package com.jumio.jvision.jvcorejava.swig;

public class Point2i {

    /* renamed from: a */
    public transient long f57910a;
    public transient boolean swigCMemOwn;

    public Point2i(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57910a = j;
    }

    public static long getCPtr(Point2i point2i) {
        if (point2i == null) {
            return 0;
        }
        return point2i.f57910a;
    }

    public synchronized void delete() {
        long j = this.f57910a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Point2i(j);
            }
            this.f57910a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getX() {
        return JVCoreJavaJNI.Point2i_getX(this.f57910a, this);
    }

    public int getY() {
        return JVCoreJavaJNI.Point2i_getY(this.f57910a, this);
    }

    public void setX(int i) {
        JVCoreJavaJNI.Point2i_setX(this.f57910a, this, i);
    }

    public void setY(int i) {
        JVCoreJavaJNI.Point2i_setY(this.f57910a, this, i);
    }

    public Point2i() {
        this(JVCoreJavaJNI.new_Point2i__SWIG_0(), true);
    }

    public Point2i(int i, int i2) {
        this(JVCoreJavaJNI.new_Point2i__SWIG_1(i, i2), true);
    }
}
