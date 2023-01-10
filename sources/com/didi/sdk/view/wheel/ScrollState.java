package com.didi.sdk.view.wheel;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollState {

    /* renamed from: a */
    private Scroller f41028a;

    public ScrollState(Context context) {
        this.f41028a = new Scroller(context);
    }

    public ScrollState(Context context, Interpolator interpolator) {
        this.f41028a = new Scroller(context, interpolator);
    }

    public int getCurrX() {
        return -this.f41028a.getCurrX();
    }

    public int getCurrY() {
        return -this.f41028a.getCurrY();
    }

    public int getFinalX() {
        return -this.f41028a.getFinalX();
    }

    public int getFinalY() {
        return -this.f41028a.getFinalY();
    }

    public boolean shouldScroll() {
        return this.f41028a.computeScrollOffset();
    }

    public void startScroll(int i, int i2, int i3) {
        Scroller scroller = this.f41028a;
        scroller.startScroll(scroller.getCurrX(), this.f41028a.getCurrY(), -i, -i2, i3);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f41028a.startScroll(i, i2, -i3, -i4, i5);
    }

    public void setStoped() {
        this.f41028a.forceFinished(true);
    }
}
