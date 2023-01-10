package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SettingsSwitchView extends RelativeLayout {

    /* renamed from: a */
    private TextView f40208a;

    /* renamed from: b */
    private TextView f40209b;

    /* renamed from: c */
    private Switch f40210c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f40211d = false;

    public SettingsSwitchView(Context context) {
        super(context);
        m30286a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30286a(context);
    }

    public SettingsSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30286a(context);
    }

    /* renamed from: a */
    private void m30286a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.setting_switch_layout, this, true);
        this.f40208a = (TextView) findViewById(R.id.title);
        this.f40209b = (TextView) findViewById(R.id.subtitle);
        this.f40210c = (Switch) findViewById(R.id.switcher);
    }

    public void setTitle(String str) {
        if (this.f40208a != null && !TextUtils.isEmpty(str)) {
            this.f40208a.setText(str);
            this.f40208a.setVisibility(0);
        }
    }

    public void setSubTitle(String str) {
        if (this.f40209b != null && !TextUtils.isEmpty(str)) {
            this.f40209b.setText(str);
            this.f40209b.setVisibility(0);
        }
    }

    public void setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch switchR = this.f40210c;
        if (switchR != null) {
            switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (SettingsSwitchView.this.f40211d) {
                        boolean unused = SettingsSwitchView.this.f40211d = false;
                        return;
                    }
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                }
            });
        }
    }

    public void setChecked(boolean z) {
        Switch switchR = this.f40210c;
        if (switchR != null) {
            if (z != switchR.isChecked()) {
                this.f40211d = true;
            }
            this.f40210c.setChecked(z);
        }
    }
}
