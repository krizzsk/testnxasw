package com.didichuxing.carsliding.model;

public class VectorCoordinate {

    /* renamed from: a */
    private double f48927a;

    /* renamed from: b */
    private double f48928b;

    /* renamed from: c */
    private float f48929c;

    /* renamed from: d */
    private long f48930d;

    public VectorCoordinate(double d, double d2, float f, long j) {
        this.f48927a = d;
        this.f48928b = d2;
        this.f48929c = f;
        this.f48930d = j;
    }

    public double getLat() {
        return this.f48927a;
    }

    public double getLng() {
        return this.f48928b;
    }

    public float getAngle() {
        return this.f48929c;
    }

    public long getTimeStamp() {
        return this.f48930d;
    }

    public String toString() {
        return "{lat=" + this.f48927a + ",lng=" + this.f48928b + ",angle=" + this.f48929c + ",timeStamp=" + this.f48930d + "}";
    }
}
