package com.didi.globalsafetoolkit.business.emergency.widget;

import android.view.animation.Interpolator;

public class JumpInterpolator implements Interpolator {

    /* renamed from: a */
    private final float f25000a;

    public JumpInterpolator(float f) {
        this.f25000a = Math.abs(f);
    }

    public float getInterpolation(float f) {
        float f2 = this.f25000a;
        if (f > f2) {
            return 0.0f;
        }
        return (float) Math.sin(((double) (f / f2)) * 3.141592653589793d);
    }
}
