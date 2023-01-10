package com.didi.sdk.componentconfig;

import com.didi.sdk.event.Event;

public class ComponentConfigEvent implements Event {

    /* renamed from: a */
    private String f38443a;

    public ComponentConfigEvent(String str) {
        this.f38443a = str;
    }

    public String getEvent() {
        return this.f38443a;
    }

    public void setEvent(String str) {
        this.f38443a = str;
    }
}
