package com.map.sdk.nav.libc.common;

public class DMKMapPoint {

    /* renamed from: x */
    public double f58568x;

    /* renamed from: y */
    public double f58569y;

    public double getX() {
        return this.f58568x;
    }

    public void setX(double d) {
        this.f58568x = d;
    }

    public double getY() {
        return this.f58569y;
    }

    public void setY(double d) {
        this.f58569y = d;
    }

    public DMKMapPoint() {
    }

    public DMKMapPoint(DMKMapPoint dMKMapPoint) {
        this(dMKMapPoint.f58568x, dMKMapPoint.f58569y);
    }

    public DMKMapPoint(double d, double d2) {
        this.f58568x = d;
        this.f58569y = d2;
    }

    public String toString() {
        return this.f58568x + "," + this.f58569y;
    }
}
