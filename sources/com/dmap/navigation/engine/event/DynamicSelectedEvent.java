package com.dmap.navigation.engine.event;

public class DynamicSelectedEvent extends NaviEvent {

    /* renamed from: a */
    private int f54427a;

    /* renamed from: b */
    private int f54428b;

    public DynamicSelectedEvent(int i, int i2) {
        this.f54427a = i;
        this.f54428b = i2;
    }

    public int getAbTest() {
        return this.f54427a;
    }

    public int getType() {
        return this.f54428b;
    }
}
