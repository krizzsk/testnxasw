package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

public final class CircleOptions extends IMapElementOptions {
    public static final int DEFAULT_ACCURACY = 100;

    /* renamed from: a */
    private LatLng f12643a;

    /* renamed from: b */
    private double f12644b = 0.0d;

    /* renamed from: c */
    private float f12645c = -1.0f;

    /* renamed from: d */
    private int f12646d = -1;

    /* renamed from: e */
    private int f12647e = -1;

    /* renamed from: f */
    private int f12648f = 100;

    public CircleOptions center(LatLng latLng) {
        this.f12643a = latLng;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f12647e = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f12643a;
    }

    public int getFillColor() {
        return this.f12647e;
    }

    public double getRadius() {
        return this.f12644b;
    }

    public int getStrokeColor() {
        return this.f12646d;
    }

    public float getStrokeWidth() {
        return this.f12645c;
    }

    public CircleOptions radius(double d) {
        this.f12644b = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f12646d = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f12645c = f;
        return this;
    }

    public int getAccuracy() {
        return this.f12648f;
    }

    public CircleOptions setAccuracy(int i) {
        this.f12648f = i;
        return this;
    }
}
