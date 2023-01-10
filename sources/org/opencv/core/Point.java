package org.opencv.core;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class Point {

    /* renamed from: x */
    public double f8521x;

    /* renamed from: y */
    public double f8522y;

    public Point(double d, double d2) {
        this.f8521x = d;
        this.f8522y = d2;
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f8521x = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
            this.f8522y = d;
            return;
        }
        this.f8521x = 0.0d;
        this.f8522y = 0.0d;
    }

    public Point clone() {
        return new Point(this.f8521x, this.f8522y);
    }

    public double dot(Point point) {
        return (this.f8521x * point.f8521x) + (this.f8522y * point.f8522y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f8521x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f8522y);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f8521x == point.f8521x && this.f8522y == point.f8522y) {
            return true;
        }
        return false;
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public String toString() {
        return Const.joLeft + this.f8521x + ", " + this.f8522y + "}";
    }
}
