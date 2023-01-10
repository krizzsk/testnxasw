package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.k */
final class C19873k extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ String f55566a;

    /* renamed from: b */
    final /* synthetic */ C20237i f55567b;

    /* renamed from: c */
    final /* synthetic */ C19878p f55568c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19873k(C19878p pVar, C20237i iVar, String str, C20237i iVar2) {
        super(iVar);
        this.f55568c = pVar;
        this.f55566a = str;
        this.f55567b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f55568c.f55579a.mo164280b().mo164357a(this.f55568c.f55580d, C19878p.m41769a(this.f55568c, this.f55566a), new C19877o(this.f55568c, this.f55567b, this.f55566a));
        } catch (RemoteException e) {
            C19878p.f55577b.mo164268a((Throwable) e, "requestUpdateInfo(%s)", this.f55566a);
            this.f55567b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
