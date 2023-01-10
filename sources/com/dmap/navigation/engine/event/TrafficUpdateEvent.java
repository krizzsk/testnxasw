package com.dmap.navigation.engine.event;

import java.math.BigInteger;
import java.util.ArrayList;

public class TrafficUpdateEvent extends NaviEvent {

    /* renamed from: a */
    private final BigInteger f54515a;

    /* renamed from: b */
    private final ArrayList<Integer> f54516b;

    public TrafficUpdateEvent(BigInteger bigInteger, ArrayList<Integer> arrayList) {
        this.f54515a = bigInteger;
        this.f54516b = arrayList;
    }

    public ArrayList<Integer> getTrafficIndex() {
        return this.f54516b;
    }

    public BigInteger getRouteId() {
        return this.f54515a;
    }
}
