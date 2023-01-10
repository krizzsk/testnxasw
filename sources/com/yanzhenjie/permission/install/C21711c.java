package com.yanzhenjie.permission.install;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.install.c */
/* compiled from: ORequest */
class C21711c extends C21709a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f58969a;

    C21711c(Source source) {
        super(source);
        this.f58969a = source;
    }

    public void start() {
        if (this.f58969a.canRequestPackageInstalls()) {
            mo178879b();
            mo178877a();
            return;
        }
        mo178878a(this);
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f58969a);
        bridgeRequest.setType(3);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178880c();
    }

    public void onCallback() {
        if (this.f58969a.canRequestPackageInstalls()) {
            mo178879b();
            mo178877a();
            return;
        }
        mo178880c();
    }
}
