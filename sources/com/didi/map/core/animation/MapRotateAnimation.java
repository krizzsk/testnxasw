package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapRotateAnimation extends MapAnimation {

    /* renamed from: a */
    private float f26965a = 0.0f;

    /* renamed from: b */
    private float f26966b = 0.0f;

    /* renamed from: c */
    private float f26967c = 0.0f;

    /* renamed from: d */
    private float f26968d = 0.0f;

    /* renamed from: e */
    private float f26969e = 0.0f;

    public MapRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.f26965a = f;
        this.f26966b = f2;
        this.f26967c = f3;
        this.f26968d = f4;
        this.f26969e = f5;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        float interpolation = this.f26965a + ((this.f26966b - this.f26965a) * interpolator.getInterpolation(f));
        if (this.animationProperty != null) {
            this.animationProperty.setRotate(interpolation, this.f26967c, this.f26968d, this.f26969e);
        }
    }
}
