package com.didiglobal.xbanner.template.yoga.view;

public class Border {

    /* renamed from: a */
    private int f54082a;

    /* renamed from: b */
    private float f54083b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f54082a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f54083b = f;
    }

    public int getBorderColor() {
        return this.f54082a;
    }

    public float getBorderWidth() {
        return this.f54083b;
    }
}
