package com.didi.entrega.customer.widget.abnormal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.support.CustomerAppCompatImageView;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.taxis99.R;

public class AbnormalView extends ConstraintLayout {

    /* renamed from: a */
    private LinearLayout f22216a;

    /* renamed from: b */
    private ImageView f22217b;

    /* renamed from: c */
    private TextView f22218c;

    /* renamed from: d */
    private TextView f22219d;

    /* renamed from: e */
    private RFGhostButton f22220e;

    public AbnormalView(Context context) {
        super(context);
        m18344a();
    }

    public AbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18344a();
    }

    public AbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18344a();
    }

    public void show(AbnormalViewModel abnormalViewModel) {
        if (abnormalViewModel.resId > 0) {
            this.f22217b.setImageResource(abnormalViewModel.resId);
            this.f22217b.setVisibility(0);
        } else {
            this.f22217b.setVisibility(8);
        }
        if (TextUtils.isEmpty(abnormalViewModel.title)) {
            this.f22218c.setVisibility(8);
        } else {
            this.f22218c.setText(abnormalViewModel.title);
            this.f22218c.setVisibility(0);
        }
        if (TextUtils.isEmpty(abnormalViewModel.subTitle)) {
            this.f22219d.setVisibility(8);
        } else {
            this.f22219d.setText(abnormalViewModel.subTitle);
            this.f22219d.setVisibility(0);
        }
        if (TextUtils.isEmpty(abnormalViewModel.retryText)) {
            this.f22220e.setVisibility(8);
            return;
        }
        this.f22220e.setText(abnormalViewModel.retryText);
        this.f22220e.setVisibility(0);
        if (abnormalViewModel.clickListener != null) {
            this.f22220e.setOnClickListener(abnormalViewModel.clickListener);
        } else {
            this.f22220e.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: a */
    private void m18344a() {
        m18345b();
    }

    /* renamed from: b */
    private void m18345b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22216a = linearLayout;
        linearLayout.setMinimumWidth(CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 32.0f));
        this.f22216a.setOrientation(1);
        this.f22217b = new CustomerAppCompatImageView(getContext());
        this.f22218c = new CustomerAppCompatTextView(getContext());
        this.f22219d = new CustomerAppCompatTextView(getContext());
        this.f22220e = new RFGhostButton(getContext());
        this.f22218c.setGravity(17);
        this.f22218c.setTextSize(1, 18.0f);
        this.f22218c.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f22218c, IToolsService.FontType.MEDIUM);
        this.f22219d.setGravity(17);
        this.f22219d.setTextSize(1, 12.5f);
        this.f22219d.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_2_40_666666));
        this.f22219d.setPadding(DisplayUtils.dip2px(getContext(), 39.0f), 0, DisplayUtils.dip2px(getContext(), 39.0f), 0);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f22219d, IToolsService.FontType.LIGHT);
        this.f22220e.setSpec(1);
        this.f22220e.setVisibility(8);
        int dip2px = DisplayUtils.dip2px(getContext(), 144.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 17;
        this.f22217b.setScaleType(ImageView.ScaleType.CENTER);
        this.f22216a.addView(this.f22217b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), -4.0f);
        this.f22216a.addView(this.f22218c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = DisplayUtils.dip2px(getContext(), 3.0f);
        this.f22216a.addView(this.f22219d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = DisplayUtils.dip2px(getContext(), 23.5f);
        layoutParams4.gravity = 17;
        this.f22216a.addView(this.f22220e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams5.verticalBias = 0.18f;
        addView(this.f22216a, layoutParams5);
    }
}
