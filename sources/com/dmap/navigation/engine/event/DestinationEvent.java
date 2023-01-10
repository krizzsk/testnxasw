package com.dmap.navigation.engine.event;

public class DestinationEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54409a;

    /* renamed from: b */
    private final int f54410b;

    /* renamed from: c */
    private final int f54411c;

    /* renamed from: d */
    private final int f54412d;

    /* renamed from: e */
    private final int f54413e;

    public DestinationEvent(int i, int i2, int i3, int i4, int i5) {
        this.f54409a = i;
        this.f54410b = i2;
        this.f54411c = i3;
        this.f54412d = i4;
        this.f54413e = i5;
    }

    public String toString() {
        return "DestinationEvent{index=" + this.f54409a + ", distance=" + this.f54410b + ", time=" + this.f54411c + ", totalDistance=" + this.f54412d + ", totalTime=" + this.f54413e + '}';
    }

    public int getIndex() {
        return this.f54409a;
    }

    public int getDistance() {
        return this.f54410b;
    }

    public int getTime() {
        return this.f54411c;
    }

    public int getTotalDistance() {
        return this.f54412d;
    }

    public int getTotalTime() {
        return this.f54413e;
    }
}
