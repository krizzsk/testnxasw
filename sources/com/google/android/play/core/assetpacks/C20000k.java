package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import com.google.android.play.core.splitinstall.C20207p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.k */
public final class C20000k implements C20092co<C19999j> {

    /* renamed from: a */
    private final C20092co<C19917bb> f56021a;

    /* renamed from: b */
    private final C20092co<C20013w> f56022b;

    /* renamed from: c */
    private final C20092co<C19911aw> f56023c;

    /* renamed from: d */
    private final C20092co<C20207p> f56024d;

    /* renamed from: e */
    private final C20092co<C19958cp> f56025e;

    /* renamed from: f */
    private final C20092co<C19941bz> f56026f;

    /* renamed from: g */
    private final C20092co<C19929bn> f56027g;

    /* renamed from: h */
    private final C20092co<Executor> f56028h;

    public C20000k(C20092co<C19917bb> coVar, C20092co<C20013w> coVar2, C20092co<C19911aw> coVar3, C20092co<C20207p> coVar4, C20092co<C19958cp> coVar5, C20092co<C19941bz> coVar6, C20092co<C19929bn> coVar7, C20092co<Executor> coVar8) {
        this.f56021a = coVar;
        this.f56022b = coVar2;
        this.f56023c = coVar3;
        this.f56024d = coVar4;
        this.f56025e = coVar5;
        this.f56026f = coVar6;
        this.f56027g = coVar7;
        this.f56028h = coVar8;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        C19917bb a = this.f56021a.mo163987a();
        C20088ck<C20013w> b = C20090cm.m42286b(this.f56022b);
        C19911aw a2 = this.f56023c.mo163987a();
        return new C19999j(a, b, a2, this.f56024d.mo163987a(), this.f56025e.mo163987a(), this.f56026f.mo163987a(), this.f56027g.mo163987a(), C20090cm.m42286b(this.f56028h));
    }
}
