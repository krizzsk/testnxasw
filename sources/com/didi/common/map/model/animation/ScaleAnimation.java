package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class ScaleAnimation extends Animation {

    /* renamed from: a */
    private float f12752a;

    /* renamed from: b */
    private float f12753b;

    /* renamed from: c */
    private float f12754c;

    /* renamed from: d */
    private float f12755d;

    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.mType = Animation.AnimationType.SCALE;
        this.f12752a = f;
        this.f12753b = f2;
        this.f12754c = f3;
        this.f12755d = f4;
    }

    public float getFromX() {
        return this.f12752a;
    }

    public float getToX() {
        return this.f12753b;
    }

    public float getFromY() {
        return this.f12754c;
    }

    public float getToY() {
        return this.f12755d;
    }
}
