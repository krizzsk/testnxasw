package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.internal.C20111v;
import com.google.android.play.core.tasks.C20237i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ac */
final class C19891ac extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f55643a;

    /* renamed from: b */
    final /* synthetic */ C20237i f55644b;

    /* renamed from: c */
    final /* synthetic */ C19906ar f55645c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19891ac(C19906ar arVar, C20237i iVar, List list, C20237i iVar2) {
        super(iVar);
        this.f55645c = arVar;
        this.f55643a = list;
        this.f55644b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55645c.f55692e.mo164280b()).mo164364b(this.f55645c.f55690c, (List<Bundle>) C19906ar.m41841a((Collection) this.f55643a), C19906ar.m41857e(), (C20111v) new C19899ak(this.f55645c, this.f55644b, (byte[]) null));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "cancelDownloads(%s)", this.f55643a);
        }
    }
}
