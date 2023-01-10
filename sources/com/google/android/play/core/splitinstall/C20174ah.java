package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ah */
final class C20174ah extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f56221a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56222b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56223c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20174ah(C20188av avVar, C20237i iVar, List list, C20237i iVar2) {
        super(iVar);
        this.f56223c = avVar;
        this.f56221a = list;
        this.f56222b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56223c.f56239a.mo164280b().mo164304d(this.f56223c.f56240d, C20188av.m42499b((Collection) this.f56221a), C20188av.m42498b(), new C20181ao(this.f56223c, this.f56222b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "deferredLanguageInstall(%s)", this.f56221a);
            this.f56222b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
