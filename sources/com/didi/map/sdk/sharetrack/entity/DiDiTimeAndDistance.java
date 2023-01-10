package com.didi.map.sdk.sharetrack.entity;

public class DiDiTimeAndDistance {

    /* renamed from: a */
    private int f31088a;

    /* renamed from: b */
    private int f31089b;

    public DiDiTimeAndDistance() {
    }

    public DiDiTimeAndDistance(int i, int i2) {
        this.f31088a = i;
        this.f31089b = i2;
    }

    public int getEtaMinutes() {
        return this.f31088a;
    }

    public void setEtaMinutes(int i) {
        this.f31088a = i;
    }

    public int getEdaMeters() {
        return this.f31089b;
    }

    public void setEdaMeters(int i) {
        this.f31089b = i;
    }
}
