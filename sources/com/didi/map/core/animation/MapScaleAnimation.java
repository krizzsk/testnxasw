package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapScaleAnimation extends MapAnimation {

    /* renamed from: a */
    private float f26970a = 0.0f;

    /* renamed from: b */
    private float f26971b = 0.0f;

    /* renamed from: c */
    private float f26972c = 0.0f;

    /* renamed from: d */
    private float f26973d = 0.0f;

    public MapScaleAnimation(float f, float f2, float f3, float f4) {
        this.f26970a = f;
        this.f26971b = f2;
        this.f26972c = f3;
        this.f26973d = f4;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        if (f > 0.0f) {
            float f2 = this.f26971b - this.f26970a;
            float interpolation = interpolator.getInterpolation(f);
            float f3 = this.f26970a + (f2 * interpolation);
            float f4 = this.f26972c + ((this.f26973d - this.f26972c) * interpolation);
            if (this.animationProperty != null) {
                this.animationProperty.setScale(f3, f4);
            }
        }
    }
}
