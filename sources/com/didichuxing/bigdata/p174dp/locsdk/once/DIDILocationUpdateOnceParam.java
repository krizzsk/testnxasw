package com.didichuxing.bigdata.p174dp.locsdk.once;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOnceParam */
public class DIDILocationUpdateOnceParam {

    /* renamed from: a */
    private String f48725a;

    /* renamed from: b */
    private String f48726b;

    /* renamed from: c */
    private String f48727c;

    /* renamed from: d */
    private int f48728d = 1000;

    /* renamed from: e */
    private boolean f48729e = false;

    public boolean isNeedExpress() {
        return this.f48729e;
    }

    public void setNeedExpress(boolean z) {
        this.f48729e = z;
    }

    public String getModuleKey() {
        return this.f48725a;
    }

    public void setModuleKey(String str) {
        this.f48725a = str;
    }

    public void setCallFrom(String str) {
        this.f48726b = str;
    }

    public void setEntrance(String str) {
        this.f48727c = str;
    }

    public String getCallFrom() {
        return this.f48726b;
    }

    public String getEntrance() {
        return this.f48727c;
    }

    public int getTimeOut() {
        return this.f48728d;
    }

    public void setTimeOut(int i) {
        this.f48728d = i;
    }
}
