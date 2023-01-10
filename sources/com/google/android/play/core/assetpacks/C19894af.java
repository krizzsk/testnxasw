package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.internal.C20111v;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.af */
final class C19894af extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f55654a;

    /* renamed from: b */
    final /* synthetic */ String f55655b;

    /* renamed from: c */
    final /* synthetic */ String f55656c;

    /* renamed from: d */
    final /* synthetic */ int f55657d;

    /* renamed from: e */
    final /* synthetic */ C20237i f55658e;

    /* renamed from: f */
    final /* synthetic */ C19906ar f55659f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19894af(C19906ar arVar, C20237i iVar, int i, String str, String str2, int i2, C20237i iVar2) {
        super(iVar);
        this.f55659f = arVar;
        this.f55654a = i;
        this.f55655b = str;
        this.f55656c = str2;
        this.f55657d = i2;
        this.f55658e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55659f.f55692e.mo164280b()).mo164359a(this.f55659f.f55690c, C19906ar.m41853c(this.f55654a, this.f55655b, this.f55656c, this.f55657d), C19906ar.m41857e(), (C20111v) new C19899ak(this.f55659f, this.f55658e, (char[]) null));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164268a((Throwable) e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
