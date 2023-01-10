package com.didi.component.mapflow.infowindow.model;

import com.didi.component.mapflow.infowindow.callback.CountDownCallback;

public class CircleCountWrapper {

    /* renamed from: a */
    private String f16048a;

    /* renamed from: b */
    private CircleCountDownModel f16049b;

    /* renamed from: c */
    private int f16050c;

    /* renamed from: d */
    private int f16051d;

    /* renamed from: e */
    private CountDownCallback f16052e;

    public CircleCountWrapper(String str, CircleCountDownModel circleCountDownModel, int i, int i2, CountDownCallback countDownCallback) {
        this.f16048a = str;
        this.f16049b = circleCountDownModel;
        this.f16050c = i;
        this.f16051d = i2;
        this.f16052e = countDownCallback;
    }

    public String getTag() {
        return this.f16048a;
    }

    public CircleCountDownModel getModel() {
        return this.f16049b;
    }

    public int getCount() {
        return this.f16050c;
    }

    public int getInitCount() {
        return this.f16051d;
    }

    public CountDownCallback getCallback() {
        return this.f16052e;
    }

    public String toString() {
        return "CircleCountWrapper{tag='" + this.f16048a + '\'' + ", model=" + this.f16049b + ", count=" + this.f16050c + ", initCount=" + this.f16051d + ", callback=" + this.f16052e + '}';
    }
}
