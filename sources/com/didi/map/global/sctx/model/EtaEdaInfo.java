package com.didi.map.global.sctx.model;

public class EtaEdaInfo {

    /* renamed from: a */
    private int f30089a;

    /* renamed from: b */
    private int f30090b;

    /* renamed from: c */
    private int f30091c = -1;

    public EtaEdaInfo(int i, int i2, int i3) {
        this.f30089a = i;
        this.f30090b = i2;
        this.f30091c = i3;
    }

    public int getEta() {
        return this.f30089a;
    }

    public void setEta(int i) {
        this.f30089a = i;
    }

    public int getEda() {
        return this.f30090b;
    }

    public void setEda(int i) {
        this.f30090b = i;
    }

    public int getLastOrderEda() {
        return this.f30091c;
    }

    public void setLastOrderEda(int i) {
        this.f30091c = i;
    }

    public String toString() {
        return "EtaEdaInfo{eta=" + this.f30089a + ", eda=" + this.f30090b + ", lastOrderEda" + this.f30091c + '}';
    }
}
