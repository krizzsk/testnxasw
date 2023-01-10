package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.splitinstall.aj */
final class C20176aj extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f56227a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56228b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56229c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20176aj(C20188av avVar, C20237i iVar, int i, C20237i iVar2) {
        super(iVar);
        this.f56229c = avVar;
        this.f56227a = i;
        this.f56228b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56229c.f56239a.mo164280b().mo164299a(this.f56229c.f56240d, this.f56227a, new C20184ar(this.f56229c, this.f56228b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "getSessionState(%d)", Integer.valueOf(this.f56227a));
            this.f56228b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
