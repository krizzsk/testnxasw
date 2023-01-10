package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public class CandleEntry extends Entry {

    /* renamed from: a */
    private float f54907a = 0.0f;

    /* renamed from: b */
    private float f54908b = 0.0f;

    /* renamed from: c */
    private float f54909c = 0.0f;

    /* renamed from: d */
    private float f54910d = 0.0f;

    public CandleEntry(float f, float f2, float f3, float f4, float f5) {
        super(f, (f2 + f3) / 2.0f);
        this.f54907a = f2;
        this.f54908b = f3;
        this.f54910d = f4;
        this.f54909c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Object obj) {
        super(f, (f2 + f3) / 2.0f, obj);
        this.f54907a = f2;
        this.f54908b = f3;
        this.f54910d = f4;
        this.f54909c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable) {
        super(f, (f2 + f3) / 2.0f, drawable);
        this.f54907a = f2;
        this.f54908b = f3;
        this.f54910d = f4;
        this.f54909c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable, Object obj) {
        super(f, (f2 + f3) / 2.0f, drawable, obj);
        this.f54907a = f2;
        this.f54908b = f3;
        this.f54910d = f4;
        this.f54909c = f5;
    }

    public float getShadowRange() {
        return Math.abs(this.f54907a - this.f54908b);
    }

    public float getBodyRange() {
        return Math.abs(this.f54910d - this.f54909c);
    }

    public float getY() {
        return super.getY();
    }

    public CandleEntry copy() {
        return new CandleEntry(getX(), this.f54907a, this.f54908b, this.f54910d, this.f54909c, getData());
    }

    public float getHigh() {
        return this.f54907a;
    }

    public void setHigh(float f) {
        this.f54907a = f;
    }

    public float getLow() {
        return this.f54908b;
    }

    public void setLow(float f) {
        this.f54908b = f;
    }

    public float getClose() {
        return this.f54909c;
    }

    public void setClose(float f) {
        this.f54909c = f;
    }

    public float getOpen() {
        return this.f54910d;
    }

    public void setOpen(float f) {
        this.f54910d = f;
    }
}
