package com.didichuxing.mas.sdk.quality.collect.lag;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.d */
/* compiled from: SingleThreadFactory */
final class C16601d implements ThreadFactory {

    /* renamed from: a */
    private final String f50703a;

    C16601d(String str) {
        this.f50703a = "BlockCanary-" + str;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f50703a);
    }
}
