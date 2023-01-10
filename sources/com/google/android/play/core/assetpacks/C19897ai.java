package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.assetpacks.ai */
final class C19897ai extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ int f55668a;

    /* renamed from: b */
    final /* synthetic */ String f55669b;

    /* renamed from: c */
    final /* synthetic */ String f55670c;

    /* renamed from: d */
    final /* synthetic */ int f55671d;

    /* renamed from: e */
    final /* synthetic */ C20237i f55672e;

    /* renamed from: f */
    final /* synthetic */ C19906ar f55673f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19897ai(C19906ar arVar, C20237i iVar, int i, String str, String str2, int i2, C20237i iVar2) {
        super(iVar);
        this.f55673f = arVar;
        this.f55668a = i;
        this.f55669b = str;
        this.f55670c = str2;
        this.f55671d = i2;
        this.f55672e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        try {
            ((C20109t) this.f55673f.f55692e.mo164280b()).mo164367d(this.f55673f.f55690c, C19906ar.m41853c(this.f55668a, this.f55669b, this.f55670c, this.f55671d), C19906ar.m41857e(), new C19900al(this.f55673f, this.f55672e));
        } catch (RemoteException e) {
            C19906ar.f55688a.mo164269b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f55669b, this.f55670c, Integer.valueOf(this.f55671d), Integer.valueOf(this.f55668a));
            this.f55672e.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
