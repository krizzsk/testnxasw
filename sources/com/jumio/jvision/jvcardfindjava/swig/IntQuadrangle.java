package com.jumio.jvision.jvcardfindjava.swig;

public class IntQuadrangle {

    /* renamed from: a */
    public transient long f57894a;
    public transient boolean swigCMemOwn;

    public IntQuadrangle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57894a = j;
    }

    public static long getCPtr(IntQuadrangle intQuadrangle) {
        if (intQuadrangle == null) {
            return 0;
        }
        return intQuadrangle.f57894a;
    }

    public synchronized void delete() {
        long j = this.f57894a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_IntQuadrangle(j);
            }
            this.f57894a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public IntPoint getBottomLeft() {
        return new IntPoint(JVCardFindJavaJNI.IntQuadrangle_getBottomLeft(this.f57894a, this), false);
    }

    public IntPoint getBottomRight() {
        return new IntPoint(JVCardFindJavaJNI.IntQuadrangle_getBottomRight(this.f57894a, this), false);
    }

    public IntPoint getTopLeft() {
        return new IntPoint(JVCardFindJavaJNI.IntQuadrangle_getTopLeft(this.f57894a, this), false);
    }

    public IntPoint getTopRight() {
        return new IntPoint(JVCardFindJavaJNI.IntQuadrangle_getTopRight(this.f57894a, this), false);
    }

    public IntQuadrangle() {
        this(JVCardFindJavaJNI.new_IntQuadrangle__SWIG_0(), true);
    }

    public IntQuadrangle(IntPoint intPoint, IntPoint intPoint2, IntPoint intPoint3, IntPoint intPoint4) {
        this(JVCardFindJavaJNI.new_IntQuadrangle__SWIG_1(IntPoint.getCPtr(intPoint), intPoint, IntPoint.getCPtr(intPoint2), intPoint2, IntPoint.getCPtr(intPoint3), intPoint3, IntPoint.getCPtr(intPoint4), intPoint4), true);
    }
}
