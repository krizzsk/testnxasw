package com.didi.dqr.pdf417.encoder;

public final class Dimensions {

    /* renamed from: a */
    private final int f20842a;

    /* renamed from: b */
    private final int f20843b;

    /* renamed from: c */
    private final int f20844c;

    /* renamed from: d */
    private final int f20845d;

    public Dimensions(int i, int i2, int i3, int i4) {
        this.f20842a = i;
        this.f20843b = i2;
        this.f20844c = i3;
        this.f20845d = i4;
    }

    public int getMinCols() {
        return this.f20842a;
    }

    public int getMaxCols() {
        return this.f20843b;
    }

    public int getMinRows() {
        return this.f20844c;
    }

    public int getMaxRows() {
        return this.f20845d;
    }
}
