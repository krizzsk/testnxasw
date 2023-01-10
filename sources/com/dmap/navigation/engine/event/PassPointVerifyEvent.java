package com.dmap.navigation.engine.event;

public class PassPointVerifyEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54494a;

    public PassPointVerifyEvent(int i) {
        this.f54494a = i;
    }

    public String toString() {
        return "PassPointVerifyEvent{updateType=" + this.f54494a + '}';
    }

    public int getUpdateType() {
        return this.f54494a;
    }
}
