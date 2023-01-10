package com.didi.dqr.oned.rss;

import com.didi.dqr.ResultPoint;

public final class FinderPattern {

    /* renamed from: a */
    private final int f20659a;

    /* renamed from: b */
    private final int[] f20660b;

    /* renamed from: c */
    private final ResultPoint[] f20661c;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.f20659a = i;
        this.f20660b = iArr;
        float f = (float) i4;
        this.f20661c = new ResultPoint[]{new ResultPoint((float) i2, f), new ResultPoint((float) i3, f)};
    }

    public int getValue() {
        return this.f20659a;
    }

    public int[] getStartEnd() {
        return this.f20660b;
    }

    public ResultPoint[] getResultPoints() {
        return this.f20661c;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof FinderPattern) && this.f20659a == ((FinderPattern) obj).f20659a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f20659a;
    }
}
