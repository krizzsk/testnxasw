package com.didi.sdk.connectivity;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.sdk.connectivity.e */
/* compiled from: NamedThreadFactory */
class C12994e implements ThreadFactory {

    /* renamed from: a */
    static AtomicInteger f38528a = new AtomicInteger(0);

    /* renamed from: b */
    private String f38529b;

    /* renamed from: c */
    private boolean f38530c;

    public C12994e(String str, boolean z) {
        this.f38529b = str;
        this.f38530c = z;
    }

    public Thread newThread(Runnable runnable) {
        NamedThreadFactory$1 namedThreadFactory$1 = new NamedThreadFactory$1(this, this.f38529b + f38528a.getAndIncrement(), runnable);
        namedThreadFactory$1.setDaemon(this.f38530c);
        return namedThreadFactory$1;
    }
}
