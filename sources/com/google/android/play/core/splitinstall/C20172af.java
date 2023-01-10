package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.tasks.C20237i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.af */
final class C20172af extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f56215a;

    /* renamed from: b */
    final /* synthetic */ C20237i f56216b;

    /* renamed from: c */
    final /* synthetic */ C20188av f56217c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20172af(C20188av avVar, C20237i iVar, List list, C20237i iVar2) {
        super(iVar);
        this.f56217c = avVar;
        this.f56215a = list;
        this.f56216b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            this.f56217c.f56239a.mo164280b().mo164302b(this.f56217c.f56240d, C20188av.m42497a((Collection) this.f56215a), C20188av.m42498b(), new C20183aq(this.f56217c, this.f56216b));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "deferredUninstall(%s)", this.f56215a);
            this.f56216b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
