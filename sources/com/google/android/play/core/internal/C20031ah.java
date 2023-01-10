package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.internal.ah */
public abstract class C20031ah implements Runnable {

    /* renamed from: a */
    private final C20237i<?> f56063a;

    C20031ah() {
        this.f56063a = null;
    }

    public C20031ah(C20237i<?> iVar) {
        this.f56063a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo163993a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C20237i<?> mo164272b() {
        return this.f56063a;
    }

    public final void run() {
        try {
            mo163993a();
        } catch (Exception e) {
            C20237i<?> iVar = this.f56063a;
            if (iVar != null) {
                iVar.mo164556b(e);
            }
        }
    }
}
