package com.didi.dimina.container.secondparty.permission.install;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.install.c */
/* compiled from: ORequest */
class C8203c extends C8201a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19249a;

    C8203c(Source source) {
        super(source);
        this.f19249a = source;
    }

    public void start() {
        if (this.f19249a.canRequestPackageInstalls()) {
            mo60871b();
            mo60869a();
            return;
        }
        mo60870a(this);
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19249a);
        bridgeRequest.setType(3);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60872c();
    }

    public void onCallback() {
        if (this.f19249a.canRequestPackageInstalls()) {
            mo60871b();
            mo60869a();
            return;
        }
        mo60872c();
    }
}
