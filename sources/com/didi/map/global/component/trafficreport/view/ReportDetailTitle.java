package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.taxis99.R;

public class ReportDetailTitle extends FrameLayout {

    /* renamed from: a */
    private TextView f28653a;

    /* renamed from: b */
    private RadioButton f28654b;

    /* renamed from: c */
    private FrameLayout f28655c;

    public ReportDetailTitle(Context context) {
        super(context);
        m22328a(context);
    }

    public ReportDetailTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22328a(context);
    }

    public ReportDetailTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22328a(context);
    }

    /* renamed from: a */
    private void m22328a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_report_detail_title, this);
        this.f28653a = (TextView) inflate.findViewById(R.id.txt_title_mid);
        this.f28654b = (RadioButton) inflate.findViewById(R.id.report_item_sel);
        this.f28655c = (FrameLayout) inflate.findViewById(R.id.img_left_small_container);
    }

    public void setTitle(int i) {
        this.f28653a.setText(i);
        this.f28653a.setVisibility(0);
    }

    public void setTitle(String str) {
        this.f28653a.setText(str);
        this.f28653a.setVisibility(0);
    }

    public FrameLayout getBackView() {
        FrameLayout frameLayout = this.f28655c;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }
}
