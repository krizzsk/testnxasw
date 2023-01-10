package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
final class C19898aj extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ C20237i f55674a;

    /* renamed from: b */
    final /* synthetic */ C19906ar f55675b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19898aj(C19906ar arVar, C20237i iVar, C20237i iVar2) {
        super(iVar);
        this.f55675b = arVar;
        this.f55674a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55675b.f55693f.mo164280b()).mo164363b(this.f55675b.f55690c, C19906ar.m41857e(), new C19902an(this.f55675b, this.f55674a));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "keepAlive", new Object[0]);
        }
    }
}
