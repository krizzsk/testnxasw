package com.didi.beatles.p101im.event;

/* renamed from: com.didi.beatles.im.event.IMInnerSchemeEvent */
public class IMInnerSchemeEvent {

    /* renamed from: a */
    private String f11051a;

    /* renamed from: b */
    private Object f11052b;

    public IMInnerSchemeEvent(String str, Object obj) {
        this.f11051a = str;
        this.f11052b = obj;
    }

    public String getAction() {
        return this.f11051a;
    }

    public Object getData() {
        return this.f11052b;
    }
}
