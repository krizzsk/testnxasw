package com.didi.beatles.p101im.views.bottombar;

/* renamed from: com.didi.beatles.im.views.bottombar.IMSkinElement */
public class IMSkinElement {

    /* renamed from: a */
    private int f11842a;

    /* renamed from: b */
    private int f11843b;

    /* renamed from: c */
    private int f11844c;

    /* renamed from: d */
    private int f11845d;

    /* renamed from: e */
    private String f11846e;

    public IMSkinElement(int i) {
        this.f11844c = i;
    }

    public IMSkinElement(String str) {
        this.f11846e = str;
    }

    public IMSkinElement(int i, int i2, int i3, String str) {
        this.f11842a = i;
        this.f11843b = i2;
        this.f11845d = i3;
        this.f11846e = str;
    }

    public int getSrcDrawable() {
        return this.f11844c;
    }

    public void setSrcDrawable(int i) {
        this.f11844c = i;
    }

    public int getBgColor() {
        return this.f11842a;
    }

    public void setBgColor(int i) {
        this.f11842a = i;
    }

    public int getBgDrawable() {
        return this.f11843b;
    }

    public void setBgDrawable(int i) {
        this.f11843b = i;
    }

    public int getTextColor() {
        return this.f11845d;
    }

    public void setTextColor(int i) {
        this.f11845d = i;
    }

    public String getText() {
        return this.f11846e;
    }

    public void setText(String str) {
        this.f11846e = str;
    }
}
