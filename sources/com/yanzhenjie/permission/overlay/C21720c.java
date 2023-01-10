package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.c */
/* compiled from: MRequest */
class C21720c extends C21718a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58989a;

    C21720c(Source source) {
        super(source);
        this.f58989a = source;
    }

    public void start() {
        if (this.f58989a.canDrawOverlays()) {
            onCallback();
        } else {
            mo178907a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58989a);
        bridgeRequest.setType(4);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178908b();
    }

    public void onCallback() {
        if (!this.f58989a.canDrawOverlays() || !m44598a(this.f58989a.getContext())) {
            mo178908b();
        } else {
            mo178906a();
        }
    }
}
