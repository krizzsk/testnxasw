package com.didi.map.core.point;

public class DoublePoint {

    /* renamed from: x */
    public double f27004x;

    /* renamed from: y */
    public double f27005y;

    public DoublePoint() {
    }

    public DoublePoint(double d, double d2) {
        this.f27004x = d;
        this.f27005y = d2;
    }

    public void set(double d, double d2) {
        this.f27004x = d;
        this.f27005y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (this.f27004x == doublePoint.f27004x && this.f27005y == doublePoint.f27005y) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f27004x + "," + this.f27005y;
    }

    public double distanceTo(DoublePoint doublePoint) {
        double d = this.f27004x;
        double d2 = doublePoint.f27004x;
        double d3 = (d - d2) * (d - d2);
        double d4 = this.f27005y;
        double d5 = doublePoint.f27005y;
        return Math.sqrt(d3 + ((d4 - d5) * (d4 - d5)));
    }
}
