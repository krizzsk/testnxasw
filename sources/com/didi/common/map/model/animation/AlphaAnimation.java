package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class AlphaAnimation extends Animation {

    /* renamed from: a */
    private float f12742a;

    /* renamed from: b */
    private float f12743b;

    public AlphaAnimation(float f, float f2) {
        this.mType = Animation.AnimationType.ALPHA;
        this.f12742a = f;
        this.f12743b = f2;
    }

    public float getFromAlpha() {
        return this.f12742a;
    }

    public float getToAlpha() {
        return this.f12743b;
    }
}
