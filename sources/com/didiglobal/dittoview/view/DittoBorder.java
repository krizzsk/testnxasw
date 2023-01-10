package com.didiglobal.dittoview.view;

public class DittoBorder {

    /* renamed from: a */
    private int f52472a;

    /* renamed from: b */
    private float f52473b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f52472a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f52473b = f;
    }

    public int getBorderColor() {
        return this.f52472a;
    }

    public float getBorderWidth() {
        return this.f52473b;
    }
}
