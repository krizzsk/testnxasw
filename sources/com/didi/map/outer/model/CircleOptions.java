package com.didi.map.outer.model;

import android.os.Parcel;

public class CircleOptions {

    /* renamed from: a */
    private LatLng f30368a;

    /* renamed from: b */
    private double f30369b;

    /* renamed from: c */
    private float f30370c;

    /* renamed from: d */
    private int f30371d;

    /* renamed from: e */
    private int f30372e;

    /* renamed from: f */
    private float f30373f;

    /* renamed from: g */
    private boolean f30374g;

    /* renamed from: h */
    private boolean f30375h;

    /* renamed from: i */
    private boolean f30376i;

    public CircleOptions() {
        this.f30376i = false;
        this.f30368a = null;
        this.f30369b = 0.0d;
        this.f30370c = 1.0f;
        this.f30371d = -16777216;
        this.f30372e = 0;
        this.f30373f = 0.0f;
        this.f30374g = true;
        this.f30375h = false;
    }

    CircleOptions(Parcel parcel) {
        boolean z = false;
        this.f30376i = false;
        this.f30368a = new LatLng(parcel.readDouble(), parcel.readDouble());
        this.f30369b = parcel.readDouble();
        this.f30370c = parcel.readFloat();
        this.f30371d = parcel.readInt();
        this.f30372e = parcel.readInt();
        this.f30373f = parcel.readFloat();
        this.f30374g = parcel.readInt() == 1 ? true : z;
    }

    public CircleOptions center(LatLng latLng) {
        this.f30368a = latLng;
        return this;
    }

    public CircleOptions isDottedLine(boolean z) {
        this.f30375h = z;
        return this;
    }

    public CircleOptions radius(double d) {
        this.f30369b = d;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f30370c = f;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f30371d = i;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f30372e = i;
        return this;
    }

    public CircleOptions zIndex(float f) {
        this.f30373f = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f30374g = z;
        return this;
    }

    public CircleOptions mask(boolean z) {
        this.f30376i = z;
        return this;
    }

    public LatLng getCenter() {
        return this.f30368a;
    }

    public double getRadius() {
        return this.f30369b;
    }

    public float getStrokeWidth() {
        return this.f30370c;
    }

    public int getStrokeColor() {
        return this.f30371d;
    }

    public int getFillColor() {
        return this.f30372e;
    }

    public float getZIndex() {
        return this.f30373f;
    }

    public boolean isVisible() {
        return this.f30374g;
    }

    public boolean isDottedLine() {
        return this.f30375h;
    }

    public boolean isMask() {
        return this.f30376i;
    }
}
