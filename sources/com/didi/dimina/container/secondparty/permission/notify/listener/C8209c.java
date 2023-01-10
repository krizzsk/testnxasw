package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.listener.c */
/* compiled from: J2Request */
class C8209c extends C8207a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19263a;

    C8209c(Source source) {
        super(source);
        this.f19263a = source;
    }

    public void start() {
        if (this.f19263a.canListenerNotification()) {
            mo60890a();
        } else {
            mo60891a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19263a);
        bridgeRequest.setType(7);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60892b();
    }

    public void onCallback() {
        if (this.f19263a.canListenerNotification()) {
            mo60890a();
        } else {
            mo60892b();
        }
    }
}
