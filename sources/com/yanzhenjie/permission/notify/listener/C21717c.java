package com.yanzhenjie.permission.notify.listener;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.listener.c */
/* compiled from: J2Request */
class C21717c extends C21715a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58983a;

    C21717c(Source source) {
        super(source);
        this.f58983a = source;
    }

    public void start() {
        if (this.f58983a.canListenerNotification()) {
            mo178898a();
        } else {
            mo178899a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58983a);
        bridgeRequest.setType(7);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178900b();
    }

    public void onCallback() {
        if (this.f58983a.canListenerNotification()) {
            mo178898a();
        } else {
            mo178900b();
        }
    }
}
