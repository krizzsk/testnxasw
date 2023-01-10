package com.jumio.ale.swig;

public class ALEHeader {

    /* renamed from: a */
    public transient long f57341a;
    public transient boolean swigCMemOwn;

    public ALEHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57341a = j;
    }

    public static long getCPtr(ALEHeader aLEHeader) {
        if (aLEHeader == null) {
            return 0;
        }
        return aLEHeader.f57341a;
    }

    public void add(String str, String str2) {
        aleEngineJNI.ALEHeader_add__SWIG_0(this.f57341a, this, str, str2);
    }

    public void clear() {
        aleEngineJNI.ALEHeader_clear(this.f57341a, this);
    }

    public synchronized void delete() {
        long j = this.f57341a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALEHeader(j);
            }
            this.f57341a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ALEHeader() {
        this(aleEngineJNI.new_ALEHeader(), true);
    }
}
