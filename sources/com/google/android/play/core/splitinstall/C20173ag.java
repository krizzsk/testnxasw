package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ag */
final class C20173ag extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f56218a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56219b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56220c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20173ag(C20188av avVar, C20237i iVar, List list, C20237i iVar2) {
        super(iVar);
        this.f56220c = avVar;
        this.f56218a = list;
        this.f56219b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56220c.f56239a.mo164280b().mo164303c(this.f56220c.f56240d, C20188av.m42497a((Collection) this.f56218a), C20188av.m42498b(), new C20180an(this.f56220c, this.f56219b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "deferredInstall(%s)", this.f56218a);
            this.f56219b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
