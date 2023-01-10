package com.didichuxing.bigdata.p174dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationUpdateOnceParam */
public class DIDILocationUpdateOnceParam {

    /* renamed from: a */
    private String f48345a;

    /* renamed from: b */
    private String f48346b;

    /* renamed from: c */
    private String f48347c;

    /* renamed from: d */
    private int f48348d = 1000;

    public String getModuleKey() {
        return this.f48345a;
    }

    public void setModuleKey(String str) {
        this.f48345a = str;
    }

    public void setCallFrom(String str) {
        this.f48346b = str;
    }

    public void setEntrance(String str) {
        this.f48347c = str;
    }

    public String getCallFrom() {
        return this.f48346b;
    }

    public String getEntrance() {
        return this.f48347c;
    }

    public int getTimeOut() {
        return this.f48348d;
    }

    public void setTimeOut(int i) {
        this.f48348d = i;
    }
}
