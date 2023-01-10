package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.internal.C20111v;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
final class C19896ah extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f55665a;

    /* renamed from: b */
    final /* synthetic */ C20237i f55666b;

    /* renamed from: c */
    final /* synthetic */ C19906ar f55667c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19896ah(C19906ar arVar, C20237i iVar, int i, C20237i iVar2) {
        super(iVar);
        this.f55667c = arVar;
        this.f55665a = i;
        this.f55666b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55667c.f55692e.mo164280b()).mo164365c(this.f55667c.f55690c, C19906ar.m41851c(this.f55665a), C19906ar.m41857e(), (C20111v) new C19899ak(this.f55667c, this.f55666b, (int[]) null));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "notifySessionFailed", new Object[0]);
        }
    }
}
