package com.didichuxing.xpanel.util.eventbus;

import java.util.HashMap;

public class EventBus {
    public static final int EVENT_REQUEST_NET = 20;

    /* renamed from: a */
    HashMap<Integer, IEventListener> f52164a;

    public static class Inner {
        static EventBus instance = new EventBus();
    }

    private EventBus() {
        this.f52164a = new HashMap<>();
    }

    public static EventBus getInstance() {
        return Inner.instance;
    }

    public void register(int i, IEventListener iEventListener) {
        this.f52164a.put(Integer.valueOf(i), iEventListener);
    }

    public void unregister(int i) {
        this.f52164a.remove(Integer.valueOf(i));
    }

    public void sendEvent(Event event) {
        IEventListener iEventListener = this.f52164a.get(Integer.valueOf(event.f52163a));
        if (iEventListener != null) {
            iEventListener.onEvent(event);
        }
    }
}
