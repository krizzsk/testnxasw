package com.dmap.navigation.engine.event;

public class MJOEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54467a;

    public MJOEvent(int i) {
        this.f54467a = i;
    }

    public int getUpdateType() {
        return this.f54467a;
    }
}
