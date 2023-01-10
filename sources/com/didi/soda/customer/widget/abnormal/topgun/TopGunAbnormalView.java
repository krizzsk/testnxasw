package com.didi.soda.customer.widget.abnormal.topgun;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class TopGunAbnormalView extends ConstraintLayout {

    /* renamed from: a */
    private LinearLayout f44247a;

    /* renamed from: b */
    private ImageView f44248b;

    /* renamed from: c */
    private TextView f44249c;

    /* renamed from: d */
    private TextView f44250d;

    /* renamed from: e */
    private CustomerAppCompatTextView f44251e;

    public TopGunAbnormalView(Context context) {
        super(context);
        m32911a();
    }

    public TopGunAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32911a();
    }

    public TopGunAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32911a();
    }

    public void show(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        if (topGunAbnormalViewModel.resId > 0) {
            this.f44248b.setImageResource(topGunAbnormalViewModel.resId);
            this.f44248b.setVisibility(0);
        } else {
            this.f44248b.setVisibility(8);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.title)) {
            this.f44249c.setVisibility(8);
        } else {
            this.f44249c.setText(topGunAbnormalViewModel.title);
            this.f44249c.setVisibility(0);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.subTitle)) {
            this.f44250d.setVisibility(8);
        } else {
            this.f44250d.setText(topGunAbnormalViewModel.subTitle);
            this.f44250d.setVisibility(0);
        }
        if (TextUtils.isEmpty(topGunAbnormalViewModel.retryText)) {
            this.f44251e.setVisibility(8);
            return;
        }
        this.f44251e.setText(topGunAbnormalViewModel.retryText);
        this.f44251e.setVisibility(0);
        if (topGunAbnormalViewModel.clickListener != null) {
            this.f44251e.setOnClickListener(topGunAbnormalViewModel.clickListener);
        } else {
            this.f44251e.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: a */
    private void m32911a() {
        m32912b();
    }

    /* renamed from: b */
    private void m32912b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f44247a = linearLayout;
        linearLayout.setMinimumWidth(CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 32.0f));
        this.f44247a.setOrientation(1);
        this.f44248b = new CustomerAppCompatImageView(getContext());
        this.f44249c = new CustomerAppCompatTextView(getContext());
        this.f44250d = new CustomerAppCompatTextView(getContext());
        this.f44251e = new CustomerAppCompatTextView(getContext());
        this.f44249c.setGravity(17);
        this.f44249c.setTextSize(1, 16.0f);
        this.f44249c.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44249c, IToolsService.FontType.BOLD);
        this.f44250d.setGravity(17);
        this.f44250d.setTextSize(1, 12.0f);
        this.f44250d.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f44250d.setPadding(DisplayUtils.dip2px(getContext(), 39.0f), 0, DisplayUtils.dip2px(getContext(), 39.0f), 0);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44250d, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44251e, IToolsService.FontType.BOLD);
        this.f44251e.setVisibility(8);
        this.f44251e.setBackgroundResource(R.drawable.customer_abnormal_retry_bg);
        this.f44251e.setTextSize(1, 12.0f);
        this.f44251e.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brands_1_100));
        int dip2px = DisplayUtils.dip2px(getContext(), 144.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 17;
        this.f44248b.setScaleType(ImageView.ScaleType.CENTER);
        this.f44247a.addView(this.f44248b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), -4.0f);
        this.f44247a.addView(this.f44249c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = DisplayUtils.dip2px(getContext(), 3.0f);
        this.f44247a.addView(this.f44250d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
        layoutParams4.gravity = 17;
        this.f44251e.setPadding(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_15), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_15));
        this.f44247a.addView(this.f44251e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams5.verticalBias = 0.18f;
        addView(this.f44247a, layoutParams5);
    }
}
