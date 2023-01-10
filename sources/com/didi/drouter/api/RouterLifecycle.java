package com.didi.drouter.api;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class RouterLifecycle implements LifecycleOwner {

    /* renamed from: a */
    private final LifecycleRegistry f20988a;

    public RouterLifecycle() {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f20988a = lifecycleRegistry;
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public Lifecycle getLifecycle() {
        return this.f20988a;
    }

    public void create() {
        this.f20988a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void destroy() {
        this.f20988a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
}
