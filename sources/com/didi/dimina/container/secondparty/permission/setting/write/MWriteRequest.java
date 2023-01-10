package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MWriteRequest extends C8215a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f19295a;

    public MWriteRequest(Source source) {
        super(source);
        this.f19295a = source;
    }

    public void start() {
        if (this.f19295a.canWriteSetting()) {
            mo60930a();
        } else {
            mo60931a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19295a);
        bridgeRequest.setType(8);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo60932b();
    }

    public void onCallback() {
        if (this.f19295a.canWriteSetting()) {
            mo60930a();
        } else {
            mo60932b();
        }
    }
}
