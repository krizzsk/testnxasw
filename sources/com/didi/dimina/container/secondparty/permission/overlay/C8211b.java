package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.b */
/* compiled from: LRequest */
class C8211b extends C8210a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19268a;

    C8211b(Source source) {
        super(source);
        this.f19268a = source;
    }

    public void start() {
        if (m16352a(this.f19268a.getContext())) {
            mo60898a();
        } else {
            mo60899a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19268a);
        bridgeRequest.setType(5);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60900b();
    }

    public void onCallback() {
        if (m16352a(this.f19268a.getContext())) {
            mo60898a();
        } else {
            mo60900b();
        }
    }
}
