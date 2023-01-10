package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.c */
/* compiled from: MRequest */
class C8212c extends C8210a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19269a;

    C8212c(Source source) {
        super(source);
        this.f19269a = source;
    }

    public void start() {
        if (this.f19269a.canDrawOverlays()) {
            onCallback();
        } else {
            mo60899a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19269a);
        bridgeRequest.setType(4);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60900b();
    }

    public void onCallback() {
        if (!this.f19269a.canDrawOverlays() || !m16352a(this.f19269a.getContext())) {
            mo60900b();
        } else {
            mo60898a();
        }
    }
}
