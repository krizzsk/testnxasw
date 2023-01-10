package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.c */
/* compiled from: ORequest */
class C8206c extends C8204a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19258a;

    C8206c(Source source) {
        super(source);
        this.f19258a = source;
    }

    public void start() {
        if (this.f19258a.canNotify()) {
            mo60882a();
        } else {
            mo60883a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19258a);
        bridgeRequest.setType(6);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60884b();
    }

    public void onCallback() {
        if (this.f19258a.canNotify()) {
            mo60882a();
        } else {
            mo60884b();
        }
    }
}
