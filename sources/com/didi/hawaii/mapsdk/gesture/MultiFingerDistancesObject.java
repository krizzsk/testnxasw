package com.didi.hawaii.mapsdk.gesture;

public class MultiFingerDistancesObject {

    /* renamed from: a */
    private final float f25791a;

    /* renamed from: b */
    private final float f25792b;

    /* renamed from: c */
    private final float f25793c;

    /* renamed from: d */
    private final float f25794d;

    /* renamed from: e */
    private final float f25795e;

    /* renamed from: f */
    private final float f25796f;

    public MultiFingerDistancesObject(float f, float f2, float f3, float f4) {
        this.f25791a = f;
        this.f25792b = f2;
        this.f25793c = f3;
        this.f25794d = f4;
        this.f25795e = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        this.f25796f = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
    }

    public float getPrevFingersDiffX() {
        return this.f25791a;
    }

    public float getPrevFingersDiffY() {
        return this.f25792b;
    }

    public float getCurrFingersDiffX() {
        return this.f25793c;
    }

    public float getCurrFingersDiffY() {
        return this.f25794d;
    }

    public float getPrevFingersDiffXY() {
        return this.f25795e;
    }

    public float getCurrFingersDiffXY() {
        return this.f25796f;
    }
}
