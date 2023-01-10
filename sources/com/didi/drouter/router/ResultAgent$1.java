package com.didi.drouter.router;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.drouter.utils.RouterLogger;

class ResultAgent$1 implements LifecycleObserver {
    final /* synthetic */ C8531c this$0;
    final /* synthetic */ Request val$primaryRequest;

    ResultAgent$1(C8531c cVar, Request request) {
        this.this$0 = cVar;
        this.val$primaryRequest = request;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        if (C8531c.f21080l.containsKey(this.val$primaryRequest.getNumber())) {
            RouterLogger.getCoreLogger().mo63952w("request \"%s\" lifecycleOwner \"%s\" destroy and complete", this.val$primaryRequest.getNumber(), this.val$primaryRequest.f21051b.getLifecycle().getClass().getSimpleName());
            RouterCallback unused = this.this$0.f21085p = null;
            C8531c.m17804b(this.val$primaryRequest.getNumber(), "request_cancel");
        }
    }
}
