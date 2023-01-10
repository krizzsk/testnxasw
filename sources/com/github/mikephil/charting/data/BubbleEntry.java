package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public class BubbleEntry extends Entry {

    /* renamed from: a */
    private float f54902a = 0.0f;

    public BubbleEntry(float f, float f2, float f3) {
        super(f, f2);
        this.f54902a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Object obj) {
        super(f, f2, obj);
        this.f54902a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable) {
        super(f, f2, drawable);
        this.f54902a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
        this.f54902a = f3;
    }

    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.f54902a, getData());
    }

    public float getSize() {
        return this.f54902a;
    }

    public void setSize(float f) {
        this.f54902a = f;
    }
}
