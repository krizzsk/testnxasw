package com.didi.sdk.connectivity;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.sdk.connectivity.b */
/* compiled from: IdGenerator */
class C12991b {

    /* renamed from: a */
    static AtomicInteger f38525a = new AtomicInteger(0);

    C12991b() {
    }

    /* renamed from: a */
    static int m29059a() {
        return f38525a.getAndIncrement();
    }
}
