package com.didichuxing.sofa.animation;

/* renamed from: com.didichuxing.sofa.animation.i */
/* compiled from: BounceEaseOut */
class C17264i extends C17263h {
    C17264i(float f) {
        super(f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Float mo127636a(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        if (f5 < 0.36363637f) {
            return Float.valueOf((f3 * 7.5625f * f5 * f5) + f2);
        }
        if (f5 < 0.72727275f) {
            float f6 = f5 - 0.54545456f;
            return Float.valueOf((f3 * ((7.5625f * f6 * f6) + 0.75f)) + f2);
        } else if (((double) f5) < 0.9090909090909091d) {
            float f7 = f5 - 0.8181818f;
            return Float.valueOf((f3 * ((7.5625f * f7 * f7) + 0.9375f)) + f2);
        } else {
            float f8 = f5 - 0.95454544f;
            return Float.valueOf((f3 * ((7.5625f * f8 * f8) + 0.984375f)) + f2);
        }
    }
}
