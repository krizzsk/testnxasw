package com.didi.hawaii.mapsdk.gesture;

public final class MoveDistancesObject {

    /* renamed from: a */
    private final float f25773a;

    /* renamed from: b */
    private final float f25774b;

    /* renamed from: c */
    private float f25775c;

    /* renamed from: d */
    private float f25776d;

    /* renamed from: e */
    private float f25777e;

    /* renamed from: f */
    private float f25778f;

    /* renamed from: g */
    private float f25779g;

    /* renamed from: h */
    private float f25780h;

    /* renamed from: i */
    private float f25781i;

    /* renamed from: j */
    private float f25782j;

    public MoveDistancesObject(float f, float f2) {
        this.f25773a = f;
        this.f25774b = f2;
    }

    public void addNewPosition(float f, float f2) {
        float f3 = this.f25777e;
        this.f25775c = f3;
        float f4 = this.f25778f;
        this.f25776d = f4;
        this.f25777e = f;
        this.f25778f = f2;
        this.f25779g = f3 - f;
        this.f25780h = f4 - f2;
        this.f25781i = this.f25773a - f;
        this.f25782j = this.f25774b - f2;
    }

    public float getInitialX() {
        return this.f25773a;
    }

    public float getInitialY() {
        return this.f25774b;
    }

    public float getPreviousX() {
        return this.f25775c;
    }

    public float getPreviousY() {
        return this.f25776d;
    }

    public float getCurrentX() {
        return this.f25777e;
    }

    public float getCurrentY() {
        return this.f25778f;
    }

    public float getDistanceXSinceLast() {
        return this.f25779g;
    }

    public float getDistanceYSinceLast() {
        return this.f25780h;
    }

    public float getDistanceXSinceStart() {
        return this.f25781i;
    }

    public float getDistanceYSinceStart() {
        return this.f25782j;
    }
}
