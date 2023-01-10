package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class RotateAnimation extends Animation {

    /* renamed from: a */
    private float f12747a = 0.0f;

    /* renamed from: b */
    private float f12748b = 0.0f;

    /* renamed from: c */
    private float f12749c = 0.0f;

    /* renamed from: d */
    private float f12750d = 0.0f;

    /* renamed from: e */
    private float f12751e = 0.0f;

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mType = Animation.AnimationType.ROTATE;
        this.f12747a = f;
        this.f12748b = f2;
        this.f12749c = f3;
        this.f12750d = f4;
        this.f12751e = f5;
    }

    public float getFromDegree() {
        return this.f12747a;
    }

    public float getToDegree() {
        return this.f12748b;
    }

    public float getPivotX() {
        return this.f12749c;
    }

    public float getPivotY() {
        return this.f12750d;
    }

    public float getPivotZ() {
        return this.f12751e;
    }
}
