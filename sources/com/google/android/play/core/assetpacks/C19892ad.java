package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.tasks.C20237i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ad */
final class C19892ad extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ Map f55646a;

    /* renamed from: b */
    final /* synthetic */ C20237i f55647b;

    /* renamed from: c */
    final /* synthetic */ C19906ar f55648c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19892ad(C19906ar arVar, C20237i iVar, Map map, C20237i iVar2) {
        super(iVar);
        this.f55648c = arVar;
        this.f55646a = map;
        this.f55647b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55648c.f55692e.mo164280b()).mo164360a(this.f55648c.f55690c, C19906ar.m41847b(this.f55646a), new C19901am(this.f55648c, this.f55647b));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "syncPacks", new Object[0]);
            this.f55647b.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
