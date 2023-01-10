package com.jumio.core.data.document;

public enum DocumentFormat {
    NONE(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d),
    ID1(0.136d, 0.136d, 0.0675d, 0.0675d, 1.585185185185185d, 0.24000000000000002d, 0.09546296296296297d),
    ID2(0.0936d, 0.0936d, 0.0675d, 0.0675d, 1.4189189189189189d, 0.17162162162162162d, 0.08412162162162162d),
    ID3(0.022d, 0.022d, 0.022d, 0.022d, 1.4119318181818181d, 0.2353181818181818d, 0.0d);
    

    /* renamed from: a */
    public final double f57517a;

    /* renamed from: b */
    public final double f57518b;

    /* renamed from: c */
    public final double f57519c;

    /* renamed from: d */
    public final double f57520d;

    /* renamed from: e */
    public final double f57521e;

    /* renamed from: f */
    public final double f57522f;

    /* renamed from: g */
    public final double f57523g;

    /* access modifiers changed from: public */
    DocumentFormat(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        this.f57517a = d;
        this.f57518b = d2;
        this.f57519c = d3;
        this.f57520d = d4;
        this.f57521e = d5;
        this.f57522f = d6;
        this.f57523g = d7;
    }

    public double getMarginBottom() {
        return this.f57523g;
    }

    public double getOverlayBottom() {
        return this.f57518b;
    }

    public int getOverlayBottomInPx(int i) {
        return (int) (((double) i) * this.f57518b);
    }

    public double getOverlayLeft() {
        return this.f57519c;
    }

    public int getOverlayLeftInPx(int i) {
        return (int) (((double) i) * this.f57519c);
    }

    public double getOverlayRatio() {
        return this.f57521e;
    }

    public double getOverlayRight() {
        return this.f57520d;
    }

    public int getOverlayRightInPx(int i) {
        return (int) (((double) i) * this.f57520d);
    }

    public double getOverlayTop() {
        return this.f57517a;
    }

    public int getOverlayTopInPx(int i) {
        return (int) (((double) i) * this.f57517a);
    }

    public double getRoiHeight() {
        return this.f57522f;
    }

    public int getRoiHeightInPx(int i) {
        return (int) (((double) (i - (getOverlayTopInPx(i) * 2))) * this.f57522f);
    }

    public int getRoiMarginBottomPx(int i) {
        return (int) (((double) (i - (getOverlayTopInPx(i) * 2))) * this.f57523g);
    }
}
