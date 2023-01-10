package com.didi.map.global.model.location;

public class NLPParam {

    /* renamed from: a */
    private String f29861a;

    /* renamed from: b */
    private int f29862b;

    /* renamed from: c */
    private boolean f29863c;

    public NLPParam(String str, int i) {
        this.f29861a = str;
        this.f29862b = i;
    }

    public NLPParam(String str, int i, boolean z) {
        this.f29861a = str;
        this.f29862b = i;
        this.f29863c = z;
    }

    public NLPParam(String str) {
        this.f29861a = str;
    }

    public String getCallFrom() {
        return this.f29861a;
    }

    public int getTimeOut() {
        return this.f29862b;
    }

    public boolean isNlpEnable() {
        return this.f29863c;
    }

    public String toString() {
        return "NLPParam{mCallFrom=" + this.f29861a + ", mTimeOut=" + this.f29862b + ", isNlpEnable=" + this.f29863c + '}';
    }
}
