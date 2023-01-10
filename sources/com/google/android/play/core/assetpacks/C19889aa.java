package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.aa */
final class C19889aa extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ String f55635a;

    /* renamed from: b */
    final /* synthetic */ C20237i f55636b;

    /* renamed from: c */
    final /* synthetic */ C19906ar f55637c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19889aa(C19906ar arVar, C20237i iVar, String str, C20237i iVar2) {
        super(iVar);
        this.f55637c = arVar;
        this.f55635a = str;
        this.f55636b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55637c.f55692e.mo164280b()).mo164368e(this.f55637c.f55690c, C19906ar.m41852c(0, this.f55635a), C19906ar.m41857e(), new C19899ak(this.f55637c, this.f55636b, (short[]) null));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "removePack(%s)", this.f55635a);
        }
    }
}
