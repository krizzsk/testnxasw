package com.didi.global.globalgenerickit.template.yoga.view;

public class Border {

    /* renamed from: a */
    private int f24161a;

    /* renamed from: b */
    private float f24162b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f24161a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f24162b = f;
    }

    public int getBorderColor() {
        return this.f24161a;
    }

    public float getBorderWidth() {
        return this.f24162b;
    }
}
