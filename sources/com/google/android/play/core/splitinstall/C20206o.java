package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.o */
public final class C20206o {

    /* renamed from: a */
    private static final AtomicReference<C20205n> f56268a = new AtomicReference<>((Object) null);

    /* renamed from: a */
    static C20205n m42539a() {
        return f56268a.get();
    }

    /* renamed from: a */
    public static void m42540a(C20205n nVar) {
        f56268a.compareAndSet((Object) null, nVar);
    }
}
