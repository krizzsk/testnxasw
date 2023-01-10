package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20074bx;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.splitinstall.al */
final class C20178al extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f56232a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56233b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56234c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20178al(C20188av avVar, C20237i iVar, int i, C20237i iVar2) {
        super(iVar);
        this.f56234c = avVar;
        this.f56232a = i;
        this.f56233b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56234c.f56239a.mo164280b().mo164298a(this.f56234c.f56240d, this.f56232a, C20188av.m42498b(), (C20074bx) new C20179am(this.f56234c, this.f56233b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "cancelInstall(%d)", Integer.valueOf(this.f56232a));
            this.f56233b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
