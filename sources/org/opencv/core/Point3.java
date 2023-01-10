package org.opencv.core;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class Point3 {

    /* renamed from: x */
    public double f8523x;

    /* renamed from: y */
    public double f8524y;

    /* renamed from: z */
    public double f8525z;

    public Point3(double d, double d2, double d3) {
        this.f8523x = d;
        this.f8524y = d2;
        this.f8525z = d3;
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f8523x = point.f8521x;
        this.f8524y = point.f8522y;
        this.f8525z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f8523x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f8524y = dArr.length > 1 ? dArr[1] : 0.0d;
            if (dArr.length > 2) {
                d = dArr[2];
            }
            this.f8525z = d;
            return;
        }
        this.f8523x = 0.0d;
        this.f8524y = 0.0d;
        this.f8525z = 0.0d;
    }

    public Point3 clone() {
        return new Point3(this.f8523x, this.f8524y, this.f8525z);
    }

    public double dot(Point3 point3) {
        return (this.f8523x * point3.f8523x) + (this.f8524y * point3.f8524y) + (this.f8525z * point3.f8525z);
    }

    public Point3 cross(Point3 point3) {
        Point3 point32 = point3;
        double d = this.f8524y;
        double d2 = point32.f8525z;
        double d3 = this.f8525z;
        double d4 = point32.f8524y;
        double d5 = point32.f8523x;
        double d6 = (d * d2) - (d3 * d4);
        double d7 = this.f8523x;
        double d8 = (d7 * d4) - (d * d5);
        return new Point3(d6, (d3 * d5) - (d2 * d7), d8);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f8523x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f8524y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f8525z);
        return ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        if (this.f8523x == point3.f8523x && this.f8524y == point3.f8524y && this.f8525z == point3.f8525z) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f8523x + ", " + this.f8524y + ", " + this.f8525z + "}";
    }
}
