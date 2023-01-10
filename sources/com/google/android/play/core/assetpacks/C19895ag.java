package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.internal.C20111v;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.ag */
final class C19895ag extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f55660a;

    /* renamed from: b */
    final /* synthetic */ String f55661b;

    /* renamed from: c */
    final /* synthetic */ C20237i f55662c;

    /* renamed from: d */
    final /* synthetic */ int f55663d;

    /* renamed from: e */
    final /* synthetic */ C19906ar f55664e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19895ag(C19906ar arVar, C20237i iVar, int i, String str, C20237i iVar2, int i2) {
        super(iVar);
        this.f55664e = arVar;
        this.f55660a = i;
        this.f55661b = str;
        this.f55662c = iVar2;
        this.f55663d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55664e.f55692e.mo164280b()).mo164362b(this.f55664e.f55690c, C19906ar.m41852c(this.f55660a, this.f55661b), C19906ar.m41857e(), (C20111v) new C19903ao(this.f55664e, this.f55662c, this.f55660a, this.f55661b, this.f55663d));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
