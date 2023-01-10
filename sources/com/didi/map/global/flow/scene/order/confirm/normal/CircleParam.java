package com.didi.map.global.flow.scene.order.confirm.normal;

public class CircleParam {

    /* renamed from: a */
    private double f29150a;

    /* renamed from: b */
    private int f29151b;

    /* renamed from: c */
    private int f29152c;

    /* renamed from: d */
    private int f29153d;

    public CircleParam(double d, int i, int i2, int i3) {
        this.f29150a = d;
        this.f29151b = i;
        this.f29152c = i2;
        this.f29153d = i3;
    }

    public double getRadiusInMeters() {
        return this.f29150a;
    }

    public int getFillColor() {
        return this.f29151b;
    }

    public int getStrokeColor() {
        return this.f29152c;
    }

    public int getStrokeWidthInPixel() {
        return this.f29153d;
    }
}
