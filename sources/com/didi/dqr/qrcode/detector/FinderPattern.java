package com.didi.dqr.qrcode.detector;

import com.didi.dqr.ResultPoint;

public final class FinderPattern extends ResultPoint {

    /* renamed from: a */
    private final float f20921a;

    /* renamed from: b */
    private final int f20922b;

    public FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f20921a = f3;
        this.f20922b = i;
    }

    public float getEstimatedModuleSize() {
        return this.f20921a;
    }

    public int getCount() {
        return this.f20922b;
    }

    public boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f20921a);
        if (abs <= 1.0f || abs <= this.f20921a) {
            return true;
        }
        return false;
    }

    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.f20922b;
        int i2 = i + 1;
        float x = (((float) i) * getX()) + f2;
        float f4 = (float) i2;
        return new FinderPattern(x / f4, ((((float) this.f20922b) * getY()) + f) / f4, ((((float) this.f20922b) * this.f20921a) + f3) / f4, i2);
    }
}
