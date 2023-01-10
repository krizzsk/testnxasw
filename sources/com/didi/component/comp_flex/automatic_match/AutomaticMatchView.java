package com.didi.component.comp_flex.automatic_match;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IView;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AutomaticMatchView implements IView<AutomaticMatchPresenter> {

    /* renamed from: a */
    private View f13982a;

    /* renamed from: b */
    private Context f13983b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AutomaticMatchPresenter f13984c;

    /* renamed from: d */
    private TextView f13985d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SwitchCompat f13986e;

    /* renamed from: f */
    private final Logger f13987f = LoggerFactory.getLogger("AutomaticMatchView");

    /* renamed from: g */
    private CompoundButton.OnCheckedChangeListener f13988g = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AutoTrackHelper.trackViewOnClick(compoundButton, z);
            AutomaticMatchView automaticMatchView = AutomaticMatchView.this;
            automaticMatchView.m11600a("switchBtn ischecked " + z);
            AutomaticMatchView.this.f13986e.setEnabled(false);
            AutomaticMatchView.this.f13984c.onCheckedChanged(z);
            HashMap hashMap = new HashMap();
            hashMap.put("k", "click");
            hashMap.put(RavenKey.VERSION, "autopick");
            hashMap.put("style", Integer.valueOf(z ? 1 : 2));
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_autopick_ck", (Map<String, Object>) hashMap);
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11600a(String str) {
        this.f13987f.info(str, new Object[0]);
    }

    public AutomaticMatchView(Context context, ViewGroup viewGroup) {
        this.f13983b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_automatic_match_layout, viewGroup, false);
        this.f13982a = inflate;
        this.f13985d = (TextView) inflate.findViewById(R.id.title_text);
        this.f13986e = (SwitchCompat) this.f13982a.findViewById(R.id.automatic_match_switcher);
    }

    public View getView() {
        return this.f13982a;
    }

    public void setPresenter(AutomaticMatchPresenter automaticMatchPresenter) {
        this.f13984c = automaticMatchPresenter;
    }

    public void update(AutomaticMatchModel automaticMatchModel) {
        if (automaticMatchModel != null) {
            boolean z = true;
            this.f13986e.setEnabled(true);
            automaticMatchModel.title.bindTextView(this.f13985d);
            if (automaticMatchModel.toggle != 1) {
                z = false;
            }
            resetSwitchChecked(z);
            HashMap hashMap = new HashMap();
            hashMap.put("k", "show");
            hashMap.put(RavenKey.VERSION, "autopick");
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_autopick_sw", (Map<String, Object>) hashMap);
        }
    }

    public void updateSwitchBtnEnable(boolean z) {
        this.f13986e.setEnabled(z);
    }

    public void resetSwitchChecked(boolean z) {
        this.f13986e.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f13986e.isChecked() != z) {
            this.f13986e.setChecked(z);
        }
        this.f13986e.setOnCheckedChangeListener(this.f13988g);
    }
}
