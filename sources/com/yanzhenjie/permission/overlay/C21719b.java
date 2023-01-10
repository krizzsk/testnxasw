package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.b */
/* compiled from: LRequest */
class C21719b extends C21718a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58988a;

    C21719b(Source source) {
        super(source);
        this.f58988a = source;
    }

    public void start() {
        if (m44598a(this.f58988a.getContext())) {
            mo178906a();
        } else {
            mo178907a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58988a);
        bridgeRequest.setType(5);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178908b();
    }

    public void onCallback() {
        if (m44598a(this.f58988a.getContext())) {
            mo178906a();
        } else {
            mo178908b();
        }
    }
}
