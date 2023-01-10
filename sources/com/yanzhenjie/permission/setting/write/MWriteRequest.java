package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

public class MWriteRequest extends C21723a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f59016a;

    public MWriteRequest(Source source) {
        super(source);
        this.f59016a = source;
    }

    public void start() {
        if (this.f59016a.canWriteSetting()) {
            mo178938a();
        } else {
            mo178939a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f59016a);
        bridgeRequest.setType(8);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo178940b();
    }

    public void onCallback() {
        if (this.f59016a.canWriteSetting()) {
            mo178938a();
        } else {
            mo178940b();
        }
    }
}
