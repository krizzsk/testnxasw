package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class ArriveEvent extends NaviEvent {

    /* renamed from: a */
    private final boolean f54394a;

    /* renamed from: b */
    private final LatLng f54395b;

    /* renamed from: c */
    private final LatLng f54396c;

    /* renamed from: d */
    private final LatLng f54397d;

    /* renamed from: e */
    private final int f54398e;

    /* renamed from: f */
    private final int f54399f;

    public ArriveEvent(boolean z, NaviLatLng naviLatLng, NaviLatLng naviLatLng2, NaviLatLng naviLatLng3, int i, int i2) {
        this.f54394a = z;
        this.f54395b = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54396c = new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng());
        this.f54397d = new SimpleLatlng(naviLatLng3.getLat(), naviLatLng3.getLng());
        this.f54398e = i;
        this.f54399f = i2;
    }

    public String toString() {
        return "ArriveEvent{isTerminal=" + this.f54394a + ", originalPoint=" + this.f54395b + ", matchedPoint=" + this.f54396c + ", destPoint=" + this.f54397d + ", destNo=" + this.f54398e + ", callBackType=" + this.f54399f + '}';
    }

    public boolean isTerminal() {
        return this.f54394a;
    }

    public LatLng getOriginalPoint() {
        return this.f54395b;
    }

    public LatLng getMatchedPoint() {
        return this.f54396c;
    }

    public LatLng getDestPoint() {
        return this.f54397d;
    }

    public int getDestNo() {
        return this.f54398e;
    }

    public int getCallBackType() {
        return this.f54399f;
    }
}
