package com.didi.global.globaluikit.datepicker;

import android.graphics.Color;

public class LEGOLinearGradient {

    /* renamed from: a */
    private int f24297a;

    /* renamed from: b */
    private int f24298b;

    /* renamed from: c */
    private int f24299c;

    /* renamed from: d */
    private int f24300d;

    /* renamed from: e */
    private int f24301e;

    /* renamed from: f */
    private int f24302f;

    /* renamed from: g */
    private int f24303g;

    /* renamed from: h */
    private int f24304h;

    public LEGOLinearGradient(int i, int i2) {
        this.f24297a = i;
        this.f24298b = i2;
        m19558a();
    }

    public void setStartColor(int i) {
        this.f24297a = i;
        m19558a();
    }

    public void setEndColor(int i) {
        this.f24298b = i;
        m19558a();
    }

    /* renamed from: a */
    private void m19558a() {
        this.f24299c = Color.red(this.f24297a);
        this.f24300d = Color.blue(this.f24297a);
        this.f24301e = Color.green(this.f24297a);
        this.f24302f = Color.red(this.f24298b);
        this.f24303g = Color.blue(this.f24298b);
        this.f24304h = Color.green(this.f24298b);
    }

    public int getColor(float f) {
        int i = this.f24299c;
        int i2 = (int) (((double) i) + ((double) (((float) (this.f24302f - i)) * f)) + 0.5d);
        int i3 = this.f24301e;
        int i4 = (int) (((double) i3) + ((double) (((float) (this.f24304h - i3)) * f)) + 0.5d);
        int i5 = this.f24300d;
        return Color.rgb(i2, i4, (int) (((double) i5) + ((double) (((float) (this.f24303g - i5)) * f)) + 0.5d));
    }
}
