package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;

public class IntersectionEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54440a;

    /* renamed from: b */
    private final String f54441b;

    /* renamed from: c */
    private final String f54442c;

    /* renamed from: d */
    private final int f54443d;

    /* renamed from: e */
    private final int f54444e;

    /* renamed from: f */
    private final String f54445f;

    /* renamed from: g */
    private final boolean f54446g;

    /* renamed from: h */
    private final int f54447h;

    /* renamed from: i */
    private final int f54448i;

    /* renamed from: j */
    private final int f54449j;

    /* renamed from: k */
    private final LatLng f54450k;

    /* renamed from: l */
    private final int f54451l;

    public IntersectionEvent(int i, String str, String str2, int i2, int i3, int i4, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7) {
        this.f54440a = i;
        this.f54441b = str;
        this.f54442c = str2;
        this.f54443d = i2;
        this.f54444e = i3;
        this.f54449j = i4;
        this.f54447h = i5;
        this.f54448i = i6;
        this.f54445f = str3;
        this.f54446g = z;
        this.f54450k = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54451l = i7;
    }

    public String toString() {
        return "IntersectionEvent{updateType=" + this.f54440a + ", roadName='" + this.f54441b + '\'' + ", nextRoadName='" + this.f54442c + '\'' + ", leftDistance=" + this.f54443d + ", intersection=" + this.f54444e + ", highWayNumber='" + this.f54445f + '\'' + ", inHighWay=" + this.f54446g + ", actionLength=" + this.f54447h + ", connectLength=" + this.f54448i + ", index=" + this.f54449j + ", targetPos=" + this.f54450k + ", nextIntersection=" + this.f54451l + '}';
    }

    public int getUpdateType() {
        return this.f54440a;
    }

    public String getRoadName() {
        return this.f54441b;
    }

    public String getNextRoadName() {
        return this.f54442c;
    }

    public int getLeftDistance() {
        return this.f54443d;
    }

    public int getIntersection() {
        return this.f54444e;
    }

    public String getHighWayNumber() {
        return this.f54445f;
    }

    public boolean isInHighWay() {
        return this.f54446g;
    }

    public int getActionLength() {
        return this.f54447h;
    }

    public int getConnectLength() {
        return this.f54448i;
    }

    public int getIndex() {
        return this.f54449j;
    }

    public LatLng getTargetPos() {
        return this.f54450k;
    }

    public int getNextIntersection() {
        return this.f54451l;
    }
}
