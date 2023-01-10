package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ai */
final class C20175ai extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f56224a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56225b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56226c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20175ai(C20188av avVar, C20237i iVar, List list, C20237i iVar2) {
        super(iVar);
        this.f56226c = avVar;
        this.f56224a = list;
        this.f56225b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56226c.f56239a.mo164280b().mo164305e(this.f56226c.f56240d, C20188av.m42499b((Collection) this.f56224a), C20188av.m42498b(), new C20182ap(this.f56226c, this.f56225b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "deferredLanguageUninstall(%s)", this.f56224a);
            this.f56225b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
