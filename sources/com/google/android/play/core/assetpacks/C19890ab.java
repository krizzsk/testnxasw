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

/* renamed from: com.google.android.play.core.assetpacks.ab */
final class C19890ab extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ List f55638a;

    /* renamed from: b */
    final /* synthetic */ Map f55639b;

    /* renamed from: c */
    final /* synthetic */ C20237i f55640c;

    /* renamed from: d */
    final /* synthetic */ List f55641d;

    /* renamed from: e */
    final /* synthetic */ C19906ar f55642e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19890ab(C19906ar arVar, C20237i iVar, List list, Map map, C20237i iVar2, List list2) {
        super(iVar);
        this.f55642e = arVar;
        this.f55638a = list;
        this.f55639b = map;
        this.f55640c = iVar2;
        this.f55641d = list2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        ArrayList a = C19906ar.m41841a((Collection) this.f55638a);
        try {
            String a2 = this.f55642e.f55690c;
            Bundle b = C19906ar.m41847b(this.f55639b);
            C19906ar arVar = this.f55642e;
            ((C20109t) this.f55642e.f55692e.mo164280b()).mo164361a(a2, (List<Bundle>) a, b, (C20111v) new C19905aq(arVar, this.f55640c, arVar.f55691d, this.f55641d));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "startDownload(%s)", this.f55638a);
            this.f55640c.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
