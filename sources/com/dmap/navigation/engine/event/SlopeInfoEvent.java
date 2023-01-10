package com.dmap.navigation.engine.event;

public class SlopeInfoEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54502a;

    public SlopeInfoEvent(int i) {
        this.f54502a = i;
    }

    public String toString() {
        return "SlopeInfoEvent{slopeStatus=" + this.f54502a + '}';
    }

    public int getSlopeStatus() {
        return this.f54502a;
    }
}
