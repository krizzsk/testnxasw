package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class LimitSpeedCameraEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54462a;

    /* renamed from: b */
    private final int f54463b;

    /* renamed from: c */
    private final int f54464c;

    /* renamed from: d */
    private final LatLng f54465d;

    /* renamed from: e */
    private final String f54466e;

    public LimitSpeedCameraEvent(int i, int i2, int i3, NaviLatLng naviLatLng, String str) {
        this.f54462a = i;
        this.f54463b = i2;
        this.f54464c = i3;
        this.f54465d = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54466e = str;
    }

    public String toString() {
        return "LimitSpeedCameraEvent{updateType=" + this.f54462a + ", type=" + this.f54463b + ", speed=" + this.f54464c + ", location=" + this.f54465d + ", describe='" + this.f54466e + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f54462a;
    }

    public int getType() {
        return this.f54463b;
    }

    public int getSpeed() {
        return this.f54464c;
    }

    public LatLng getLocation() {
        return this.f54465d;
    }

    public String getDescribe() {
        return this.f54466e;
    }
}
