package org.opencv.core;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class Rect2d {
    public double height;
    public double width;

    /* renamed from: x */
    public double f8528x;

    /* renamed from: y */
    public double f8529y;

    public Rect2d(double d, double d2, double d3, double d4) {
        this.f8528x = d;
        this.f8529y = d2;
        this.width = d3;
        this.height = d4;
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        this.f8528x = point.f8521x < point2.f8521x ? point.f8521x : point2.f8521x;
        this.f8529y = point.f8522y < point2.f8522y ? point.f8522y : point2.f8522y;
        this.width = (point.f8521x > point2.f8521x ? point.f8521x : point2.f8521x) - this.f8528x;
        this.height = (point.f8522y > point2.f8522y ? point.f8522y : point2.f8522y) - this.f8529y;
    }

    public Rect2d(Point point, Size size) {
        this(point.f8521x, point.f8522y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f8528x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f8529y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            if (dArr.length > 3) {
                d = dArr[3];
            }
            this.height = d;
            return;
        }
        this.f8528x = 0.0d;
        this.f8529y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Rect2d clone() {
        return new Rect2d(this.f8528x, this.f8529y, this.width, this.height);
    }

    /* renamed from: tl */
    public Point mo41663tl() {
        return new Point(this.f8528x, this.f8529y);
    }

    /* renamed from: br */
    public Point mo41655br() {
        return new Point(this.f8528x + this.width, this.f8529y + this.height);
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public double area() {
        return this.width * this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean contains(Point point) {
        return this.f8528x <= point.f8521x && point.f8521x < this.f8528x + this.width && this.f8529y <= point.f8522y && point.f8522y < this.f8529y + this.height;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f8528x);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f8529y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        if (this.f8528x == rect2d.f8528x && this.f8529y == rect2d.f8529y && this.width == rect2d.width && this.height == rect2d.height) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f8528x + ", " + this.f8529y + ", " + this.width + "x" + this.height + "}";
    }
}
