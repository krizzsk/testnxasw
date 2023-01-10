package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.internal.C20111v;
import com.google.android.play.core.tasks.C20237i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ae */
final class C19893ae extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f55649a;

    /* renamed from: b */
    final /* synthetic */ Map f55650b;

    /* renamed from: c */
    final /* synthetic */ C20237i f55651c;

    /* renamed from: d */
    final /* synthetic */ C19914az f55652d;

    /* renamed from: e */
    final /* synthetic */ C19906ar f55653e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19893ae(C19906ar arVar, C20237i iVar, List list, Map map, C20237i iVar2, C19914az azVar) {
        super(iVar);
        this.f55653e = arVar;
        this.f55649a = list;
        this.f55650b = map;
        this.f55651c = iVar2;
        this.f55652d = azVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        ArrayList a = C19906ar.m41841a((Collection) this.f55649a);
        try {
            String a2 = this.f55653e.f55690c;
            Bundle b = C19906ar.m41847b(this.f55650b);
            C19906ar arVar = this.f55653e;
            ((C20109t) this.f55653e.f55692e.mo164280b()).mo164366c(a2, (List<Bundle>) a, b, (C20111v) new C19904ap(arVar, this.f55651c, arVar.f55691d, this.f55652d));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "getPackStates(%s)", this.f55649a);
            this.f55651c.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
