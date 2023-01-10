package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.c */
/* compiled from: ORequest */
class C21714c extends C21712a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58978a;

    C21714c(Source source) {
        super(source);
        this.f58978a = source;
    }

    public void start() {
        if (this.f58978a.canNotify()) {
            mo178890a();
        } else {
            mo178891a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58978a);
        bridgeRequest.setType(6);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178892b();
    }

    public void onCallback() {
        if (this.f58978a.canNotify()) {
            mo178890a();
        } else {
            mo178892b();
        }
    }
}
