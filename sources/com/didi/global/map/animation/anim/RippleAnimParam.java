package com.didi.global.map.animation.anim;

public class RippleAnimParam {
    public static final String TAG = RippleAnimParam.class.getSimpleName();

    /* renamed from: a */
    private int f24638a;

    /* renamed from: b */
    private int f24639b;

    /* renamed from: c */
    private int f24640c;

    /* renamed from: d */
    private int f24641d;

    /* renamed from: e */
    private int f24642e;

    /* renamed from: a */
    private int m19782a(int i, int i2) {
        if (i2 >= 255) {
            i2 = 255;
        } else if (i2 <= 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public RippleAnimParam(int i, int i2, int i3, int i4, int i5) {
        this.f24639b = m19782a(i, i3);
        this.f24638a = m19782a(i2, i3);
        this.f24642e = i3;
        this.f24641d = i4;
        this.f24640c = i5;
    }

    public RippleAnimParam() {
    }

    public int getStrokeWidth() {
        return this.f24640c;
    }

    public void setStrokeWidth(int i) {
        this.f24640c = i;
    }

    public int getFillColor() {
        return this.f24639b;
    }

    public void setFillColor(int i) {
        this.f24639b = m19782a(i, this.f24642e);
    }

    public int getStrokeColor() {
        return this.f24638a;
    }

    public void setStrokeColor(int i) {
        this.f24638a = m19782a(i, this.f24642e);
    }

    public int getAlpha() {
        return this.f24642e;
    }

    public void setAlpha(int i) {
        this.f24642e = i;
    }

    public int getRadius() {
        return this.f24641d;
    }

    public void setRadius(int i) {
        this.f24641d = i;
    }

    public String toString() {
        return "RippleAnimParam{,StrokeColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f24638a)}) + ",FillColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f24639b)}) + ",Alpha = " + String.format("0x%02X", new Object[]{Integer.valueOf(this.f24642e)}) + ",Radius = " + this.f24641d + ",StrokeWidth = " + this.f24640c + "}";
    }
}
