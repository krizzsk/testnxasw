package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SettingsSwitchItemView extends ComponentView {

    /* renamed from: a */
    private View f40204a;

    /* renamed from: b */
    private TextView f40205b;

    /* renamed from: c */
    private SwitchCompat f40206c;

    /* renamed from: d */
    private TextView f40207d;

    public SettingsSwitchItemView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.settings_switch_item, (ViewGroup) null);
        this.f40204a = inflate;
        this.f40205b = (TextView) inflate.findViewById(R.id.title);
        SwitchCompat switchCompat = (SwitchCompat) this.f40204a.findViewById(R.id.switcher);
        this.f40206c = switchCompat;
        switchCompat.setClickable(false);
        this.f40206c.setVisibility(8);
        this.f40207d = (TextView) this.f40204a.findViewById(R.id.subtitle);
        return this.f40204a;
    }

    public View getView() {
        return this.f40204a;
    }

    public void setName(String str) {
        super.setName(str);
        this.f40205b.setText(str);
    }

    public void setSubtitle(String str) {
        TextView textView = this.f40207d;
        if (textView != null) {
            textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            if (!TextUtils.isEmpty(str)) {
                this.f40207d.setText(str);
            }
        }
    }

    public void setSwitchVisible(boolean z) {
        this.f40206c.setVisibility(z ? 0 : 8);
    }

    public boolean isSwitchVisible() {
        return this.f40206c.getVisibility() == 0;
    }

    public void setSwitchBtn(boolean z) {
        this.f40206c.setChecked(z);
    }

    public boolean isChecked() {
        return this.f40206c.isChecked();
    }

    public void setCheckable(boolean z) {
        this.f40206c.setClickable(z);
    }

    public void setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        SwitchCompat switchCompat = this.f40206c;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                }
            });
        }
    }
}
