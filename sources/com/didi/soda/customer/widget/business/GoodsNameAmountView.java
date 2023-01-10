package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class GoodsNameAmountView extends FrameLayout {

    /* renamed from: a */
    private TextView f44259a;

    /* renamed from: b */
    private TextView f44260b;

    /* renamed from: c */
    private int f44261c;

    /* renamed from: d */
    private String f44262d;

    public GoodsNameAmountView(Context context) {
        super(context);
        m32922b();
    }

    public GoodsNameAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32922b();
    }

    public GoodsNameAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32922b();
    }

    public void setNameTextColor(int i) {
        this.f44260b.setTextColor(i);
    }

    public void updateGoodsNameWithAmount(String str, int i) {
        this.f44262d = str;
        this.f44261c = i;
        m32921a(i);
        m32920a();
    }

    /* renamed from: a */
    private void m32920a() {
        this.f44260b.setText(getSpannableName());
    }

    /* renamed from: a */
    private void m32921a(int i) {
        if (i <= 0) {
            this.f44259a.setVisibility(8);
            return;
        }
        this.f44259a.setText(String.valueOf(i));
        this.f44259a.setVisibility(0);
    }

    private CharSequence getSpannableName() {
        if (this.f44261c <= 0) {
            return this.f44262d;
        }
        SpannableString spannableString = new SpannableString(this.f44262d);
        spannableString.setSpan(new LeadingMarginSpan.Standard(getAmountWidth(), 0), 0, spannableString.length(), 17);
        return spannableString;
    }

    private int getAmountWidth() {
        int i = this.f44261c;
        if (i < 10) {
            return DisplayUtils.dip2px(getContext(), 24.0f);
        }
        if (i < 100) {
            return DisplayUtils.dip2px(getContext(), 30.0f);
        }
        return DisplayUtils.dip2px(getContext(), 36.0f);
    }

    /* renamed from: b */
    private void m32922b() {
        this.f44259a = new TextView(getContext());
        this.f44260b = new TextView(getContext());
        m32924d();
        m32923c();
        addView(this.f44259a, new FrameLayout.LayoutParams(-2, -2));
        addView(this.f44260b, new FrameLayout.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m32923c() {
        this.f44260b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f44260b.setTextSize(1, 18.0f);
        this.f44260b.setMaxLines(2);
        this.f44260b.setLineSpacing(0.0f, 1.2f);
        this.f44260b.setEllipsize(TextUtils.TruncateAt.END);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44260b, IToolsService.FontType.MEDIUM);
    }

    /* renamed from: d */
    private void m32924d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) DisplayUtils.dip2px(getContext(), 3.0f));
        gradientDrawable.setColor(SkinUtil.getBrandPrimaryColor());
        this.f44259a.setBackground(gradientDrawable);
        int dip2px = DisplayUtils.dip2px(getContext(), 1.5f);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f44259a.setPadding(dip2px2, dip2px, dip2px2, dip2px);
        this.f44259a.setTextColor(getContext().getResources().getColor(R.color.rf_color_white_100_FFFFFF));
        this.f44259a.setTextSize(1, 13.0f);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44259a, IToolsService.FontType.BOLD);
    }
}
