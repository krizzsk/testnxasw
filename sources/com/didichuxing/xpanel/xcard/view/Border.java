package com.didichuxing.xpanel.xcard.view;

public class Border {

    /* renamed from: a */
    private int f52205a;

    /* renamed from: b */
    private float f52206b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f52205a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f52206b = f;
    }

    public int getBorderColor() {
        return this.f52205a;
    }

    public float getBorderWidth() {
        return this.f52206b;
    }
}
