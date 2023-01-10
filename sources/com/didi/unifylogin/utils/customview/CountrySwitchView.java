package com.didi.unifylogin.utils.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryListActivity;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class CountrySwitchView extends RelativeLayout {

    /* renamed from: a */
    private TextView f47642a;

    /* renamed from: b */
    private TextView f47643b;

    /* renamed from: c */
    private ImageView f47644c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f47645d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f47646e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Activity f47647f;

    public CountrySwitchView(Context context) {
        super(context);
        m35731a(context);
    }

    public CountrySwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35731a(context);
    }

    public CountrySwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35731a(context);
    }

    /* renamed from: a */
    private void m35731a(final Context context) {
        if (context instanceof Activity) {
            this.f47647f = (Activity) context;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.login_unify_view_country_switch, this);
        this.f47642a = (TextView) inflate.findViewById(R.id.tv_switch_country_code);
        DIDIFontUtils.Companion.setTypeface(getContext(), this.f47642a);
        this.f47643b = (TextView) inflate.findViewById(R.id.tv_code);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_country_flag);
        this.f47644c = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.login_unify_color_country_placeholder));
        CountryManager.getIns().setContext(context.getApplicationContext());
        setCountry(CountryManager.getIns().getDefCountry());
        this.f47642a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.COUNTRY_CK).send();
                Intent intent = new Intent(context, CountryListActivity.class);
                if (CountrySwitchView.this.f47647f == null || !CountrySwitchView.this.f47645d) {
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                intent.putExtra(CountryListActivity.SEND_RESULT_2_CALLER, true);
                CountrySwitchView.this.f47647f.startActivityForResult(intent, CountrySwitchView.this.f47646e);
            }
        });
        if (LoginPreferredConfig.isCanSwitchCountry()) {
            this.f47642a.setVisibility(0);
        } else {
            this.f47643b.setVisibility(0);
        }
    }

    public void setCountry(CountryListResponse.CountryRule countryRule) {
        Glide.with(getContext()).load(countryRule.getNationalFlagUrl()).into(this.f47644c);
        this.f47643b.setText(countryRule.calling_code);
        this.f47642a.setText(countryRule.calling_code);
    }

    public void forbidSwitch() {
        this.f47643b.setVisibility(0);
        this.f47642a.setVisibility(4);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!this.f47645d) {
            this.f47642a.setText(CountryManager.getIns().getDefCountry().calling_code);
            this.f47643b.setText(CountryManager.getIns().getDefCountry().calling_code);
            Glide.with(getContext()).load(CountryManager.getIns().getDefCountry().getNationalFlagUrl()).into(this.f47644c);
        }
    }

    public void setSendResult2Caller(boolean z, int i) {
        this.f47645d = z;
        this.f47646e = i;
    }
}
