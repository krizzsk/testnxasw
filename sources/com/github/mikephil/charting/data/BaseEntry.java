package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {

    /* renamed from: a */
    private float f54898a;

    /* renamed from: b */
    private Object f54899b;

    /* renamed from: c */
    private Drawable f54900c;

    public BaseEntry() {
        this.f54898a = 0.0f;
        this.f54899b = null;
        this.f54900c = null;
    }

    public BaseEntry(float f) {
        this.f54898a = 0.0f;
        this.f54899b = null;
        this.f54900c = null;
        this.f54898a = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.f54899b = obj;
    }

    public BaseEntry(float f, Drawable drawable) {
        this(f);
        this.f54900c = drawable;
    }

    public BaseEntry(float f, Drawable drawable, Object obj) {
        this(f);
        this.f54900c = drawable;
        this.f54899b = obj;
    }

    public float getY() {
        return this.f54898a;
    }

    public void setIcon(Drawable drawable) {
        this.f54900c = drawable;
    }

    public Drawable getIcon() {
        return this.f54900c;
    }

    public void setY(float f) {
        this.f54898a = f;
    }

    public Object getData() {
        return this.f54899b;
    }

    public void setData(Object obj) {
        this.f54899b = obj;
    }
}
