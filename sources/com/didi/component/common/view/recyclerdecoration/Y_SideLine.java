package com.didi.component.common.view.recyclerdecoration;

public class Y_SideLine {

    /* renamed from: a */
    private boolean f13754a = false;

    /* renamed from: b */
    private int f13755b;

    /* renamed from: c */
    private int f13756c;

    /* renamed from: d */
    private int f13757d;

    /* renamed from: e */
    private int f13758e;

    public Y_SideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f13754a = z;
        this.f13755b = i;
        this.f13756c = i2;
        this.f13757d = i3;
        this.f13758e = i4;
    }

    public boolean isHave() {
        return this.f13754a;
    }

    public void setHave(boolean z) {
        this.f13754a = z;
    }

    public int getColor() {
        return this.f13755b;
    }

    public void setColor(int i) {
        this.f13755b = i;
    }

    public int getWidthPx() {
        return this.f13756c;
    }

    public void setWidthPx(int i) {
        this.f13756c = i;
    }

    public int getStartPaddingPx() {
        return this.f13757d;
    }

    public void setStartPaddingPx(int i) {
        this.f13757d = i;
    }

    public int getEndPaddingPx() {
        return this.f13758e;
    }

    public void setEndPaddingPx(int i) {
        this.f13758e = i;
    }
}
