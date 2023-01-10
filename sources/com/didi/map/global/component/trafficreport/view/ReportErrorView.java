package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.taxis99.R;

public class ReportErrorView extends FrameLayout {

    /* renamed from: a */
    private View f28656a;

    /* renamed from: b */
    private TextView f28657b;

    /* renamed from: c */
    private TextView f28658c;

    /* renamed from: d */
    private ListView f28659d;

    /* renamed from: e */
    private View.OnClickListener f28660e;

    public ReportErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ReportErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28656a = null;
        this.f28657b = null;
        this.f28658c = null;
        this.f28659d = null;
        this.f28660e = null;
        m22329a(context);
    }

    public ReportErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28656a = null;
        this.f28657b = null;
        this.f28658c = null;
        this.f28659d = null;
        this.f28660e = null;
        m22329a(context);
    }

    /* renamed from: a */
    private void m22329a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_report_net_error, this);
        this.f28658c = (TextView) findViewById(R.id.retry);
    }

    public void setEmptyClickListener(View.OnClickListener onClickListener) {
        this.f28660e = onClickListener;
    }
}
