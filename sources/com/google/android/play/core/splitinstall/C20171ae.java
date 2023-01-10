package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20074bx;
import com.google.android.play.core.tasks.C20237i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ae */
final class C20171ae extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ Collection f56211a;

    /* renamed from: b */
    final /* synthetic */ Collection f56212b;

    /* renamed from: c */
    final /* synthetic */ C20237i f56213c;

    /* renamed from: d */
    final /* synthetic */ C20188av f56214d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20171ae(C20188av avVar, C20237i iVar, Collection collection, Collection collection2, C20237i iVar2) {
        super(iVar);
        this.f56214d = avVar;
        this.f56211a = collection;
        this.f56212b = collection2;
        this.f56213c = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163993a() {
        ArrayList a = C20188av.m42497a(this.f56211a);
        a.addAll(C20188av.m42499b(this.f56212b));
        try {
            this.f56214d.f56239a.mo164280b().mo164301a(this.f56214d.f56240d, (List<Bundle>) a, C20188av.m42498b(), (C20074bx) new C20186at(this.f56214d, this.f56213c));
        } catch (RemoteException e) {
            C20188av.f56237b.mo164268a((Throwable) e, "startInstall(%s,%s)", this.f56211a, this.f56212b);
            this.f56213c.mo164556b((Exception) new RuntimeException(e));
        }
    }
}
