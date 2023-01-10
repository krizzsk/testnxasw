package com.didi.map.global.component.trafficreport.view.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class ContributionCountItemView extends LinearLayout {

    /* renamed from: a */
    private TextView f28751a;

    /* renamed from: b */
    private TextView f28752b;

    /* renamed from: c */
    private TextView f28753c;

    public ContributionCountItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContributionCountItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContributionCountItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22385a();
    }

    public ContributionCountItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m22385a();
    }

    /* renamed from: a */
    private void m22385a() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_report_history_count_item, this);
        this.f28751a = (TextView) findViewById(R.id.tv_count);
        this.f28752b = (TextView) findViewById(R.id.tv_times);
        this.f28753c = (TextView) findViewById(R.id.tv_description);
    }

    public void setTimesVisible(boolean z) {
        TextView textView = this.f28752b;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setCountNum(String str) {
        TextView textView = this.f28751a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDescription(String str) {
        TextView textView = this.f28753c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public TextView getCountView() {
        return this.f28751a;
    }

    public TextView getTimeView() {
        return this.f28752b;
    }
}
