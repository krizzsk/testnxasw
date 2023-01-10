package com.didichuxing.xpanel.xcard.view;

public class Corner {

    /* renamed from: a */
    private float f52207a;

    /* renamed from: b */
    private float f52208b;

    /* renamed from: c */
    private float f52209c;

    /* renamed from: d */
    private float f52210d;

    public void setCorners(float f) {
        this.f52207a = f;
        this.f52208b = f;
        this.f52209c = f;
        this.f52210d = f;
    }

    public void setLeftTopCorner(float f) {
        this.f52207a = f;
    }

    public void setLeftBottomCorner(float f) {
        this.f52208b = f;
    }

    public void setRightTopCorner(float f) {
        this.f52209c = f;
    }

    public void setRightBottomCorner(float f) {
        this.f52210d = f;
    }

    public float getLeftTopCorner() {
        return this.f52207a;
    }

    public float getLeftBottomCorner() {
        return this.f52208b;
    }

    public float getRightTopCorner() {
        return this.f52209c;
    }

    public float getRightBottomCorner() {
        return this.f52210d;
    }
}
