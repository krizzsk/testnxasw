package com.didi.sdk.event;

public class EventDispatcher {

    /* renamed from: a */
    private EventDispatcherImpl f38604a = new EventDispatcherImpl();

    protected EventDispatcher() {
    }

    public void register(Object obj) {
        this.f38604a.mo98007a(obj);
    }

    public void register(Object obj, int i) {
        this.f38604a.mo98008a(obj, i);
    }

    public boolean isRegistered(Object obj) {
        return this.f38604a.mo98015c(obj);
    }

    public void unregister(Object obj) {
        this.f38604a.mo98016d(obj);
    }

    public void post(Event event) {
        this.f38604a.mo98004a(event);
    }
}
