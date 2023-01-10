package com.didi.map.global.component.bluetooth.client;

public class RssiInfoResult {

    /* renamed from: a */
    private int f27049a;

    /* renamed from: b */
    private double f27050b;

    public int getRssi() {
        return this.f27049a;
    }

    public void setRssi(int i) {
        this.f27049a = i;
    }

    public double getDistance() {
        return this.f27050b;
    }

    public void setDistance(double d) {
        this.f27050b = d;
    }

    public String toString() {
        return "RssiInfoResult{rssi=" + this.f27049a + ", distance=" + this.f27050b + '}';
    }
}
