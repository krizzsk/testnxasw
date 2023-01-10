package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.b */
/* compiled from: NRequest */
class C21713b extends C21712a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58977a;

    C21713b(Source source) {
        super(source);
        this.f58977a = source;
    }

    public void start() {
        if (this.f58977a.canNotify()) {
            mo178890a();
        } else {
            mo178891a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58977a);
        bridgeRequest.setType(1);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178892b();
    }

    public void onCallback() {
        if (this.f58977a.canNotify()) {
            mo178890a();
        } else {
            mo178892b();
        }
    }
}
