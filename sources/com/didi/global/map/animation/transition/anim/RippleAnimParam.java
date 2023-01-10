package com.didi.global.map.animation.transition.anim;

public class RippleAnimParam {
    public static final String TAG = RippleAnimParam.class.getSimpleName();

    /* renamed from: a */
    private int f24705a;

    /* renamed from: b */
    private int f24706b;

    /* renamed from: c */
    private int f24707c;

    /* renamed from: d */
    private int f24708d;

    /* renamed from: e */
    private int f24709e;

    /* renamed from: a */
    private int m19824a(int i, int i2) {
        if (i2 >= 255) {
            i2 = 255;
        } else if (i2 <= 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public RippleAnimParam(int i, int i2, int i3, int i4, int i5) {
        this.f24706b = m19824a(i, i3);
        this.f24705a = m19824a(i2, i3);
        this.f24709e = i3;
        this.f24708d = i4;
        this.f24707c = i5;
    }

    public RippleAnimParam() {
    }

    public int getStrokeWidth() {
        return this.f24707c;
    }

    public void setStrokeWidth(int i) {
        this.f24707c = i;
    }

    public int getFillColor() {
        return this.f24706b;
    }

    public void setFillColor(int i) {
        this.f24706b = m19824a(i, this.f24709e);
    }

    public int getStrokeColor() {
        return this.f24705a;
    }

    public void setStrokeColor(int i) {
        this.f24705a = m19824a(i, this.f24709e);
    }

    public int getAlpha() {
        return this.f24709e;
    }

    public void setAlpha(int i) {
        this.f24709e = i;
    }

    public int getRadius() {
        return this.f24708d;
    }

    public void setRadius(int i) {
        this.f24708d = i;
    }

    public String toString() {
        return "RippleAnimParam{,StrokeColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f24705a)}) + ",FillColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f24706b)}) + ",Alpha = " + String.format("0x%02X", new Object[]{Integer.valueOf(this.f24709e)}) + ",Radius = " + this.f24708d + ",StrokeWidth = " + this.f24707c + "}";
    }
}
