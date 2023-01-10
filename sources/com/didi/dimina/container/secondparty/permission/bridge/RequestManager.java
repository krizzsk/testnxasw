package com.didi.dimina.container.secondparty.permission.bridge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestManager {

    /* renamed from: a */
    private static RequestManager f19231a;

    /* renamed from: b */
    private final BlockingQueue<BridgeRequest> f19232b = new LinkedBlockingQueue();

    public static RequestManager get() {
        if (f19231a == null) {
            synchronized (RequestManager.class) {
                if (f19231a == null) {
                    f19231a = new RequestManager();
                }
            }
        }
        return f19231a;
    }

    private RequestManager() {
        new C8194a(this.f19232b).start();
    }

    public void add(BridgeRequest bridgeRequest) {
        this.f19232b.add(bridgeRequest);
    }
}
