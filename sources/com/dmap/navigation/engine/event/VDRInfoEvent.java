package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class VDRInfoEvent extends NaviEvent {

    /* renamed from: a */
    private final BigInteger f54517a;

    /* renamed from: b */
    private final double f54518b;

    /* renamed from: c */
    private final double f54519c;

    /* renamed from: d */
    private final float f54520d;

    /* renamed from: e */
    private final int f54521e;

    /* renamed from: f */
    private final int f54522f;

    public VDRInfoEvent(BigInteger bigInteger, double d, double d2, float f, int i, int i2) {
        this.f54517a = bigInteger;
        this.f54518b = d;
        this.f54519c = d2;
        this.f54520d = f;
        this.f54521e = i;
        this.f54522f = i2;
    }

    public String toString() {
        return "VDRInfoEvent{planLinkID=" + this.f54517a + ", planProjLon=" + this.f54518b + ", pLanProjLat=" + this.f54519c + ", planDirection=" + this.f54520d + ", planGeoCoorIndex=" + this.f54521e + ", tunnelFlag=" + this.f54522f + '}';
    }

    public BigInteger getPlanLinkID() {
        return this.f54517a;
    }

    public double getPlanProjLon() {
        return this.f54518b;
    }

    public double getpLanProjLat() {
        return this.f54519c;
    }

    public float getPlanDirection() {
        return this.f54520d;
    }

    public int getPlanGeoCoorIndex() {
        return this.f54521e;
    }

    public int getTunnelFlag() {
        return this.f54522f;
    }
}
