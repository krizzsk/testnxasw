package com.didiglobal.dittoview.view;

public class DittoCorner {

    /* renamed from: a */
    private float f52477a;

    /* renamed from: b */
    private float f52478b;

    /* renamed from: c */
    private float f52479c;

    /* renamed from: d */
    private float f52480d;

    /* renamed from: e */
    private float f52481e;
    public boolean isEmpty = true;

    public void setCorners(float f) {
        this.isEmpty = false;
        this.f52477a = f;
        this.f52478b = f;
        this.f52479c = f;
        this.f52480d = f;
        this.f52481e = f;
    }

    public void setLeftTopCorner(float f) {
        this.isEmpty = false;
        this.f52477a = f;
    }

    public void setLeftBottomCorner(float f) {
        this.isEmpty = false;
        this.f52478b = f;
    }

    public void setRightTopCorner(float f) {
        this.isEmpty = false;
        this.f52479c = f;
    }

    public void setRightBottomCorner(float f) {
        this.isEmpty = false;
        this.f52480d = f;
    }

    public float getLeftTopCorner() {
        return this.f52477a;
    }

    public float getLeftBottomCorner() {
        return this.f52478b;
    }

    public float getRightTopCorner() {
        return this.f52479c;
    }

    public float getRightBottomCorner() {
        return this.f52480d;
    }

    public float getCornerRadius() {
        return this.f52481e;
    }
}
