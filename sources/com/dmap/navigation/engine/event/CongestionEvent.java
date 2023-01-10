package com.dmap.navigation.engine.event;

public class CongestionEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54403a;

    /* renamed from: b */
    private final int f54404b;

    /* renamed from: c */
    private final int f54405c;

    /* renamed from: d */
    private final int f54406d;

    /* renamed from: e */
    private final int f54407e;

    /* renamed from: f */
    private final int f54408f;

    public CongestionEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f54403a = i;
        this.f54404b = i2;
        this.f54405c = i3;
        this.f54406d = i4;
        this.f54407e = i5;
        this.f54408f = i6;
    }

    public String toString() {
        return "CongestionEvent{updateType=" + this.f54403a + ", distance=" + this.f54404b + ", time=" + this.f54405c + ", startNum=" + this.f54406d + ", endNum=" + this.f54407e + ", eventId=" + this.f54408f + '}';
    }

    public int getUpdateType() {
        return this.f54403a;
    }

    public int getDistance() {
        return this.f54404b;
    }

    public int getTime() {
        return this.f54405c;
    }

    public int getStartNum() {
        return this.f54406d;
    }

    public int getEndNum() {
        return this.f54407e;
    }

    public int getEventId() {
        return this.f54408f;
    }
}
