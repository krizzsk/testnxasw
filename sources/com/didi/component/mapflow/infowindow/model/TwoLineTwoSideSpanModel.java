package com.didi.component.mapflow.infowindow.model;

public class TwoLineTwoSideSpanModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private CharSequence f16089a;

    /* renamed from: b */
    private CharSequence f16090b;

    /* renamed from: c */
    private CharSequence f16091c;

    /* renamed from: d */
    private CharSequence f16092d;

    /* renamed from: e */
    private boolean f16093e;

    public boolean isShowArrow() {
        return this.f16093e;
    }

    public void setShowArrow(boolean z) {
        this.f16093e = z;
    }

    public CharSequence getLeftTop() {
        return this.f16089a;
    }

    public void setLeftTop(CharSequence charSequence) {
        this.f16089a = charSequence;
    }

    public CharSequence getLeftBottom() {
        return this.f16090b;
    }

    public void setLeftBottom(CharSequence charSequence) {
        this.f16090b = charSequence;
    }

    public CharSequence getRightTop() {
        return this.f16091c;
    }

    public void setRightTop(CharSequence charSequence) {
        this.f16091c = charSequence;
    }

    public CharSequence getRightBottom() {
        return this.f16092d;
    }

    public void setRightBottom(CharSequence charSequence) {
        this.f16092d = charSequence;
    }
}
