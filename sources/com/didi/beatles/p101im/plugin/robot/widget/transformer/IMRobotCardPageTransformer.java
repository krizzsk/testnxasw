package com.didi.beatles.p101im.plugin.robot.widget.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.didi.beatles.im.plugin.robot.widget.transformer.IMRobotCardPageTransformer */
public class IMRobotCardPageTransformer implements ViewPager.PageTransformer {

    /* renamed from: a */
    private static final float f11375a = 1.0f;

    /* renamed from: b */
    private static final float f11376b = 0.3f;

    /* renamed from: c */
    private static final float f11377c = 1.0f;

    /* renamed from: d */
    private static final float f11378d = 0.8f;

    /* renamed from: e */
    private ViewPager f11379e;

    public IMRobotCardPageTransformer(ViewPager viewPager) {
        this.f11379e = viewPager;
    }

    /* renamed from: a */
    private float m9871a(ViewPager viewPager, View view) {
        return ((float) ((view.getLeft() - viewPager.getScrollX()) - viewPager.getPaddingLeft())) / ((float) ((viewPager.getMeasuredWidth() - viewPager.getPaddingLeft()) - viewPager.getPaddingRight()));
    }

    public void transformPage(View view, float f) {
        float f2;
        float f3;
        float a = m9871a(this.f11379e, view);
        if (Math.abs(a) <= 1.0f) {
            if (a >= 0.0f) {
                f3 = 1.0f - (0.7f * a);
                f2 = 1.0f - (a * 0.19999999f);
            } else {
                f3 = (0.7f * a) + 1.0f;
                f2 = 1.0f + (a * 0.19999999f);
            }
            view.setAlpha(f3);
            view.setScaleX(f2);
            view.setScaleY(f2);
            return;
        }
        view.setAlpha(0.3f);
        view.setScaleX(0.8f);
        view.setScaleY(0.8f);
    }
}
