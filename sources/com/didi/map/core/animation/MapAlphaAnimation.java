package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapAlphaAnimation extends MapAnimation {

    /* renamed from: a */
    private float f26958a = 0.0f;

    /* renamed from: b */
    private float f26959b = 0.0f;

    public MapAlphaAnimation(float f, float f2) {
        this.f26958a = f;
        this.f26959b = f2;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        float interpolation = this.f26958a + ((this.f26959b - this.f26958a) * interpolator.getInterpolation(f));
        if (this.animationProperty != null) {
            this.animationProperty.setAlpha(interpolation);
        }
    }
}
