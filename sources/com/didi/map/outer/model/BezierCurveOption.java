package com.didi.map.outer.model;

import android.graphics.Color;

public class BezierCurveOption {

    /* renamed from: a */
    private LatLng f30338a;

    /* renamed from: b */
    private LatLng f30339b;

    /* renamed from: c */
    private int f30340c = Color.argb(17, 0, 163, 255);

    /* renamed from: d */
    private float f30341d;

    /* renamed from: e */
    private float f30342e;

    public BezierCurveOption startLatlng(LatLng latLng) {
        this.f30338a = latLng;
        return this;
    }

    public BezierCurveOption endLatlng(LatLng latLng) {
        this.f30339b = latLng;
        return this;
    }

    public BezierCurveOption width(float f) {
        this.f30341d = f;
        return this;
    }

    public BezierCurveOption curvature(float f) {
        this.f30342e = f;
        return this;
    }

    public BezierCurveOption color(int i) {
        this.f30340c = i;
        return this;
    }

    public LatLng getStartPoint() {
        return this.f30338a;
    }

    public LatLng getEndPoint() {
        return this.f30339b;
    }

    public int getmColor() {
        return this.f30340c;
    }

    public float getWidth() {
        return this.f30341d;
    }

    public float getCurvature() {
        return this.f30342e;
    }
}
