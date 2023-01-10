package com.google.p223ar.core;

import android.content.Context;

/* renamed from: com.google.ar.core.z */
/* compiled from: InstallServiceImpl */
final class C20300z extends Thread {

    /* renamed from: a */
    private final Context f56514a;

    /* renamed from: b */
    private final C20293s f56515b;

    /* renamed from: c */
    private volatile boolean f56516c;

    C20300z(Context context, C20293s sVar) {
        this.f56514a = context;
        this.f56515b = sVar;
    }

    public final void run() {
        while (!this.f56516c) {
            if (C20283h.m42667a().mo164850b(this.f56514a)) {
                this.f56515b.mo164861a(C20290o.COMPLETED);
                return;
            }
            try {
                sleep(200);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164867a() {
        this.f56516c = true;
    }
}
