package com.google.p223ar.core;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.x */
/* compiled from: InstallServiceImpl */
final class C20298x implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicBoolean f56510a;

    /* renamed from: b */
    private final /* synthetic */ C20296v f56511b;

    C20298x(C20296v vVar, AtomicBoolean atomicBoolean) {
        this.f56511b = vVar;
        this.f56510a = atomicBoolean;
    }

    public final void run() {
        if (!this.f56510a.getAndSet(true)) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall timed out, launching fullscreen.", (Throwable) null, "com.google.ar.core.x", 3);
            C20291p.m42686b(this.f56511b.f56505a, this.f56511b.f56506b);
        }
    }
}
