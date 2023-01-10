package com.dmap.navigation.engine.event;

public class ParallelYawEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54492a;

    /* renamed from: b */
    private final int f54493b;

    public ParallelYawEvent(int i, int i2) {
        this.f54492a = i;
        this.f54493b = i2;
    }

    public int getType() {
        return this.f54492a;
    }

    public int getConfidence() {
        return this.f54493b;
    }
}
