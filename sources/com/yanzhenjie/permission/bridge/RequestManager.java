package com.yanzhenjie.permission.bridge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestManager {

    /* renamed from: a */
    private static RequestManager f58935a;

    /* renamed from: b */
    private final BlockingQueue<BridgeRequest> f58936b = new LinkedBlockingQueue();

    public static RequestManager get() {
        if (f58935a == null) {
            synchronized (RequestManager.class) {
                if (f58935a == null) {
                    f58935a = new RequestManager();
                }
            }
        }
        return f58935a;
    }

    private RequestManager() {
        new C21691a(this.f58936b).start();
    }

    public void add(BridgeRequest bridgeRequest) {
        this.f58936b.add(bridgeRequest);
    }
}
