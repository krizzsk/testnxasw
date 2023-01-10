package com.didi.dimina.starbox.extend;

public abstract class ExtendEvent {

    /* renamed from: a */
    private final String f19866a;

    /* renamed from: b */
    private final String f19867b;

    public abstract void executeEvent();

    public ExtendEvent(String str, String str2) {
        this.f19866a = str;
        this.f19867b = str2;
    }

    public String getEventName() {
        return this.f19866a;
    }

    public String getEventType() {
        return this.f19867b;
    }
}
