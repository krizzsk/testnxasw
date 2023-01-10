package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.splitinstall.ak */
final class C20177ak extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ C20237i f56230a;

    /* renamed from: b */
    final /* synthetic */ C20188av f56231b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20177ak(C20188av avVar, C20237i iVar, C20237i iVar2) {
        super(iVar);
        this.f56231b = avVar;
        this.f56230a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56231b.f56239a.mo164280b().mo164300a(this.f56231b.f56240d, new C20185as(this.f56231b, this.f56230a));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "getSessionStates", new Object[0]);
            this.f56230a.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
