package org.opencv.core;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class Rect {
    public int height;
    public int width;

    /* renamed from: x */
    public int f8526x;

    /* renamed from: y */
    public int f8527y;

    public Rect(int i, int i2, int i3, int i4) {
        this.f8526x = i;
        this.f8527y = i2;
        this.width = i3;
        this.height = i4;
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        this.f8526x = (int) (point.f8521x < point2.f8521x ? point.f8521x : point2.f8521x);
        this.f8527y = (int) (point.f8522y < point2.f8522y ? point.f8522y : point2.f8522y);
        this.width = ((int) (point.f8521x > point2.f8521x ? point.f8521x : point2.f8521x)) - this.f8526x;
        this.height = ((int) (point.f8522y > point2.f8522y ? point.f8522y : point2.f8522y)) - this.f8527y;
    }

    public Rect(Point point, Size size) {
        this((int) point.f8521x, (int) point.f8522y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        int i = 0;
        if (dArr != null) {
            this.f8526x = dArr.length > 0 ? (int) dArr[0] : 0;
            this.f8527y = dArr.length > 1 ? (int) dArr[1] : 0;
            this.width = dArr.length > 2 ? (int) dArr[2] : 0;
            if (dArr.length > 3) {
                i = (int) dArr[3];
            }
            this.height = i;
            return;
        }
        this.f8526x = 0;
        this.f8527y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rect clone() {
        return new Rect(this.f8526x, this.f8527y, this.width, this.height);
    }

    /* renamed from: tl */
    public Point mo41652tl() {
        return new Point((double) this.f8526x, (double) this.f8527y);
    }

    /* renamed from: br */
    public Point mo41644br() {
        return new Point((double) (this.f8526x + this.width), (double) (this.f8527y + this.height));
    }

    public Size size() {
        return new Size((double) this.width, (double) this.height);
    }

    public double area() {
        return (double) (this.width * this.height);
    }

    public boolean empty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean contains(Point point) {
        return ((double) this.f8526x) <= point.f8521x && point.f8521x < ((double) (this.f8526x + this.width)) && ((double) this.f8527y) <= point.f8522y && point.f8522y < ((double) (this.f8527y + this.height));
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.height);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.width);
        long doubleToLongBits3 = Double.doubleToLongBits((double) this.f8526x);
        long doubleToLongBits4 = Double.doubleToLongBits((double) this.f8527y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (this.f8526x == rect.f8526x && this.f8527y == rect.f8527y && this.width == rect.width && this.height == rect.height) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f8526x + ", " + this.f8527y + ", " + this.width + "x" + this.height + "}";
    }
}
