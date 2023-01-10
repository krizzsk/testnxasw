package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.review.e */
final class C20144e extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ C20237i f56149a;

    /* renamed from: b */
    final /* synthetic */ C20147h f56150b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20144e(C20147h hVar, C20237i iVar, C20237i iVar2) {
        super(iVar);
        this.f56150b = hVar;
        this.f56149a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56150b.f56155a.mo164280b().mo164261a(this.f56150b.f56156c, PlayCoreVersion.m42109a(), new C20146g(this.f56150b, this.f56149a));
        } catch (RemoteException e) {
            C20147h.f56154b.mo164268a((Throwable) e, "error requesting in-app review for %s", this.f56150b.f56156c);
            this.f56149a.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
