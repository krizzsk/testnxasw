package com.dmap.navigation.engine.event;

public class ToastTextEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54510a;

    /* renamed from: b */
    private final String f54511b;

    public ToastTextEvent(int i, String str) {
        this.f54510a = i;
        this.f54511b = str;
    }

    public String toString() {
        return "ToastTextEvent{type=" + this.f54510a + ", content='" + this.f54511b + '\'' + '}';
    }

    public int getType() {
        return this.f54510a;
    }

    public String getContent() {
        return this.f54511b;
    }
}
