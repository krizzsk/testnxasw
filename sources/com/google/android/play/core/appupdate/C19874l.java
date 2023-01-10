package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.l */
final class C19874l extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ C20237i f55569a;

    /* renamed from: b */
    final /* synthetic */ String f55570b;

    /* renamed from: c */
    final /* synthetic */ C19878p f55571c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19874l(C19878p pVar, C20237i iVar, C20237i iVar2, String str) {
        super(iVar);
        this.f55571c = pVar;
        this.f55569a = iVar2;
        this.f55570b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f55571c.f55579a.mo164280b().mo164358b(this.f55571c.f55580d, C19878p.m41775d(), new C19876n(this.f55571c, this.f55569a));
        } catch (RemoteException e) {
            C19878p.f55577b.mo164268a((Throwable) e, "completeUpdate(%s)", this.f55570b);
            this.f55569a.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
