package com.dmap.navigation.engine.event;

public class MoreRouteEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54488a;

    /* renamed from: b */
    private final String f54489b;

    public MoreRouteEvent(int i, String str) {
        this.f54488a = i;
        this.f54489b = str;
    }

    public String toString() {
        return "MoreRouteEvent{passfork=" + this.f54488a + ", scene='" + this.f54489b + '\'' + '}';
    }

    public int getPassfork() {
        return this.f54488a;
    }

    public String getScene() {
        return this.f54489b;
    }
}
