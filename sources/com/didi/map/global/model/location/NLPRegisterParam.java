package com.didi.map.global.model.location;

public class NLPRegisterParam {

    /* renamed from: a */
    private String f29864a;

    /* renamed from: b */
    private int f29865b;

    /* renamed from: c */
    private int f29866c;

    public NLPRegisterParam(String str, int i, int i2) {
        this.f29864a = str;
        this.f29865b = i;
        this.f29866c = i2;
    }

    public String getmCallFrom() {
        return this.f29864a;
    }

    public void setmCallFrom(String str) {
        this.f29864a = str;
    }

    public int getmConnectTimeOut() {
        return this.f29865b;
    }

    public void setmConnectTimeOut(int i) {
        this.f29865b = i;
    }

    public int getFrequency() {
        return this.f29866c;
    }

    public void setFrequency(int i) {
        this.f29866c = i;
    }

    public String toString() {
        return "NLPRegisterParam{mCallFrom='" + this.f29864a + '\'' + ", mConnectTimeOut=" + this.f29865b + ", frequency=" + this.f29866c + '}';
    }
}
