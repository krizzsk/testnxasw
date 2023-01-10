package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class QRPayEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54495a;

    /* renamed from: b */
    private final BigInteger f54496b;

    public QRPayEvent(int i, BigInteger bigInteger) {
        this.f54495a = i;
        this.f54496b = bigInteger;
    }

    public String toString() {
        return "QRPayEvent{updateType=" + this.f54495a + ", linkId=" + this.f54496b + '}';
    }

    public int getUpdateType() {
        return this.f54495a;
    }

    public BigInteger getLinkId() {
        return this.f54496b;
    }
}
