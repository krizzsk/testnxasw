package com.jumio.jvision.jvcorejava.swig;

public class Color {

    /* renamed from: a */
    public transient long f57897a;
    public transient boolean swigCMemOwn;

    public Color(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57897a = j;
    }

    public static long getCPtr(Color color) {
        if (color == null) {
            return 0;
        }
        return color.f57897a;
    }

    public synchronized void delete() {
        long j = this.f57897a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Color(j);
            }
            this.f57897a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getA() {
        return JVCoreJavaJNI.Color_getA(this.f57897a, this);
    }

    public int getB() {
        return JVCoreJavaJNI.Color_getB(this.f57897a, this);
    }

    public int getG() {
        return JVCoreJavaJNI.Color_getG(this.f57897a, this);
    }

    public int getR() {
        return JVCoreJavaJNI.Color_getR(this.f57897a, this);
    }

    public void setA(int i) {
        JVCoreJavaJNI.Color_setA(this.f57897a, this, i);
    }

    public void setB(int i) {
        JVCoreJavaJNI.Color_setB(this.f57897a, this, i);
    }

    public void setG(int i) {
        JVCoreJavaJNI.Color_setG(this.f57897a, this, i);
    }

    public void setR(int i) {
        JVCoreJavaJNI.Color_setR(this.f57897a, this, i);
    }

    public Color() {
        this(JVCoreJavaJNI.new_Color__SWIG_0(), true);
    }

    public Color(int i, int i2, int i3, int i4) {
        this(JVCoreJavaJNI.new_Color__SWIG_1(i, i2, i3, i4), true);
    }
}
