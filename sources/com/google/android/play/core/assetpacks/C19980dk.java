package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dk */
public final class C19980dk implements C20092co<C19979dj> {

    /* renamed from: a */
    private final C20092co<C19917bb> f55952a;

    /* renamed from: b */
    private final C20092co<C20013w> f55953b;

    /* renamed from: c */
    private final C20092co<C19958cp> f55954c;

    /* renamed from: d */
    private final C20092co<Executor> f55955d;

    /* renamed from: e */
    private final C20092co<C19941bz> f55956e;

    public C19980dk(C20092co<C19917bb> coVar, C20092co<C20013w> coVar2, C20092co<C19958cp> coVar3, C20092co<Executor> coVar4, C20092co<C19941bz> coVar5) {
        this.f55952a = coVar;
        this.f55953b = coVar2;
        this.f55954c = coVar3;
        this.f55955d = coVar4;
        this.f55956e = coVar5;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        C19917bb a = this.f55952a.mo163987a();
        return new C19979dj(a, C20090cm.m42286b(this.f55953b), this.f55954c.mo163987a(), C20090cm.m42286b(this.f55955d), this.f55956e.mo163987a());
    }
}
