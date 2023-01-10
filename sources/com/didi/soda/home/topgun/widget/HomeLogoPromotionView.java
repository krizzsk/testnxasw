package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;

public class HomeLogoPromotionView extends LinearLayout {

    /* renamed from: a */
    private int f45644a;

    /* renamed from: b */
    private Drawable f45645b;

    /* renamed from: c */
    private Drawable f45646c;

    public HomeLogoPromotionView(Context context) {
        super(context);
        m33905a();
    }

    public HomeLogoPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33905a();
    }

    public HomeLogoPromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33905a();
    }

    public void bindData(String str, String str2) {
        removeAllViews();
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(str2);
        if (z2 || z) {
            int dip2px = DisplayUtils.dip2px(getContext(), 36.0f);
            if (z) {
                ImageView imageView = new ImageView(getContext());
                FlyImageLoader.loadImage1x1(getContext(), str).placeholder(this.f45646c).error(this.f45646c).transform(new RoundedCornersTransformation(getContext(), this.f45644a, 0, z2 ? RoundedCornersTransformation.CornerType.BOTTOM_LEFT : RoundedCornersTransformation.CornerType.BOTTOM, true)).into(imageView);
                addView(imageView, new LinearLayout.LayoutParams(dip2px, dip2px));
            }
            if (z2) {
                ImageView imageView2 = new ImageView(getContext());
                FlyImageLoader.loadImage1x1(getContext(), str2).placeholder(this.f45645b).transform(new RoundedCornersTransformation(getContext(), this.f45644a, 0, z ? RoundedCornersTransformation.CornerType.BOTTOM_RIGHT : RoundedCornersTransformation.CornerType.BOTTOM, true)).error(this.f45645b).into(imageView2);
                addView(imageView2, new LinearLayout.LayoutParams(dip2px, dip2px));
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    /* renamed from: a */
    private void m33905a() {
        setOrientation(0);
        this.f45644a = DisplayUtils.dip2px(getContext(), 2.0f);
        this.f45645b = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_img_topgun_placeholder_business_logo, this.f45644a);
        this.f45646c = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_img_topgun_placeholder_business_promotion, this.f45644a);
    }
}
