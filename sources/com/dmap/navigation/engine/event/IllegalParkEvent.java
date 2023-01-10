package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class IllegalParkEvent extends NaviEvent {
    public static final int HIDE_START = 3;

    /* renamed from: a */
    private final int f54433a;

    /* renamed from: b */
    private final int f54434b;

    /* renamed from: c */
    private final int f54435c;

    /* renamed from: d */
    private final String f54436d;

    /* renamed from: e */
    private final String f54437e;

    /* renamed from: f */
    private final LatLng f54438f;

    /* renamed from: g */
    private final LatLng f54439g;

    public IllegalParkEvent(int i, int i2, int i3, String str, String str2, NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        this.f54433a = i;
        this.f54434b = i2;
        this.f54435c = i3;
        this.f54436d = str;
        this.f54437e = str2;
        this.f54438f = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54439g = new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng());
    }

    public String toString() {
        return "IllegalParkEvent{updateType=" + this.f54433a + ", state=" + this.f54434b + ", induceState=" + this.f54435c + ", topContent='" + this.f54436d + '\'' + ", bottomContent='" + this.f54437e + '\'' + ", startPos=" + this.f54438f + ", endPos=" + this.f54439g + '}';
    }

    public int getUpdateType() {
        return this.f54433a;
    }

    public int getState() {
        return this.f54434b;
    }

    public int getInduceState() {
        return this.f54435c;
    }

    public String getTopContent() {
        return this.f54436d;
    }

    public String getBottomContent() {
        return this.f54437e;
    }

    public LatLng getStartPos() {
        return this.f54438f;
    }

    public LatLng getEndPos() {
        return this.f54439g;
    }
}
