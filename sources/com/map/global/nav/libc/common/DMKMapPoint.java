package com.map.global.nav.libc.common;

public class DMKMapPoint {

    /* renamed from: x */
    public double f58546x;

    /* renamed from: y */
    public double f58547y;

    public double getX() {
        return this.f58546x;
    }

    public void setX(double d) {
        this.f58546x = d;
    }

    public double getY() {
        return this.f58547y;
    }

    public void setY(double d) {
        this.f58547y = d;
    }

    public DMKMapPoint() {
    }

    public DMKMapPoint(DMKMapPoint dMKMapPoint) {
        this(dMKMapPoint.f58546x, dMKMapPoint.f58547y);
    }

    public DMKMapPoint(double d, double d2) {
        this.f58546x = d;
        this.f58547y = d2;
    }

    public String toString() {
        return this.f58546x + "," + this.f58547y;
    }
}
