package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cq */
public final class C19959cq implements C20092co<C19958cp> {

    /* renamed from: a */
    private final C20092co<C19917bb> f55881a;

    /* renamed from: b */
    private final C20092co<C20013w> f55882b;

    /* renamed from: c */
    private final C20092co<C19941bz> f55883c;

    /* renamed from: d */
    private final C20092co<Executor> f55884d;

    public C19959cq(C20092co<C19917bb> coVar, C20092co<C20013w> coVar2, C20092co<C19941bz> coVar3, C20092co<Executor> coVar4) {
        this.f55881a = coVar;
        this.f55882b = coVar2;
        this.f55883c = coVar3;
        this.f55884d = coVar4;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        C19917bb a = this.f55881a.mo163987a();
        return new C19958cp(a, C20090cm.m42286b(this.f55882b), this.f55883c.mo163987a(), C20090cm.m42286b(this.f55884d));
    }
}
