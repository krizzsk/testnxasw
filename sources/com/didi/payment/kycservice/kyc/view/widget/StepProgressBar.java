package com.didi.payment.kycservice.kyc.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.taxis99.R;
import java.util.ArrayList;

public class StepProgressBar extends LinearLayout {

    /* renamed from: a */
    private View f33378a;

    /* renamed from: b */
    private LinearLayout f33379b;

    /* renamed from: c */
    private TextView f33380c;

    /* renamed from: d */
    private Context f33381d;

    public StepProgressBar(Context context) {
        super(context);
        m25401a(context);
    }

    public StepProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25401a(context);
    }

    public StepProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25401a(context);
    }

    /* renamed from: a */
    private void m25401a(Context context) {
        inflate(context, R.layout.kyc_step_layout, this);
        this.f33378a = findViewById(R.id.step_layout);
        this.f33379b = (LinearLayout) findViewById(R.id.step_view_container);
        this.f33380c = (TextView) findViewById(R.id.steep_count_view1);
        this.f33381d = context;
    }

    public void updateView(ArrayList<GuidesInfoResp.StepInfo> arrayList) {
        this.f33379b.removeAllViews();
        if (arrayList == null || arrayList.size() <= 1) {
            this.f33378a.setVisibility(8);
            return;
        }
        this.f33378a.setVisibility(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                this.f33380c.setBackgroundResource(arrayList.get(0).getStatus() == 2 ? R.drawable.kyc_step_point_success : R.drawable.kyc_step_point_bg);
                this.f33380c.setText(arrayList.get(0).getStatus() == 2 ? "" : "1");
            } else {
                m25400a(i, arrayList.get(i));
            }
        }
    }

    /* renamed from: a */
    private void m25400a(int i, GuidesInfoResp.StepInfo stepInfo) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f33381d).inflate(R.layout.kyc_step_view, this.f33379b, false);
        View findViewById = linearLayout.findViewById(R.id.steep_line);
        TextView textView = (TextView) linearLayout.findViewById(R.id.steep_count_view);
        textView.setText(stepInfo.getStatus() == 2 ? "" : String.valueOf(i + 1));
        int status = stepInfo.getStatus();
        int i2 = R.drawable.kyc_step_point_gray_bg;
        if (status != 0) {
            if (status == 1) {
                i2 = R.drawable.kyc_step_point_bg;
            } else if (status == 2) {
                i2 = R.drawable.kyc_step_point_success;
            }
        }
        textView.setBackgroundResource(i2);
        findViewById.setBackgroundResource(stepInfo.getStatus() > 0 ? R.drawable.kyc_step_line_bg : R.drawable.kyc_step_line_gray_bg);
        this.f33379b.addView(linearLayout);
    }
}
