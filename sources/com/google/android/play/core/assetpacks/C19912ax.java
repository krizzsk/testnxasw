package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C20018a;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ax */
public final class C19912ax implements C20092co<C19911aw> {

    /* renamed from: a */
    private final C20092co<Context> f55713a;

    /* renamed from: b */
    private final C20092co<C19958cp> f55714b;

    /* renamed from: c */
    private final C20092co<C19938bw> f55715c;

    /* renamed from: d */
    private final C20092co<C20013w> f55716d;

    /* renamed from: e */
    private final C20092co<C19941bz> f55717e;

    /* renamed from: f */
    private final C20092co<C19929bn> f55718f;

    /* renamed from: g */
    private final C20092co<C20018a> f55719g;

    /* renamed from: h */
    private final C20092co<Executor> f55720h;

    /* renamed from: i */
    private final C20092co<Executor> f55721i;

    public C19912ax(C20092co<Context> coVar, C20092co<C19958cp> coVar2, C20092co<C19938bw> coVar3, C20092co<C20013w> coVar4, C20092co<C19941bz> coVar5, C20092co<C19929bn> coVar6, C20092co<C20018a> coVar7, C20092co<Executor> coVar8, C20092co<Executor> coVar9) {
        this.f55713a = coVar;
        this.f55714b = coVar2;
        this.f55715c = coVar3;
        this.f55716d = coVar4;
        this.f55717e = coVar5;
        this.f55718f = coVar6;
        this.f55719g = coVar7;
        this.f55720h = coVar8;
        this.f55721i = coVar9;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        Context b = ((C20009s) this.f55713a).mo163987a();
        C19958cp a = this.f55714b.mo163987a();
        C19938bw a2 = this.f55715c.mo163987a();
        C20088ck<C20013w> b2 = C20090cm.m42286b(this.f55716d);
        C19941bz a3 = this.f55717e.mo163987a();
        C19929bn a4 = this.f55718f.mo163987a();
        return new C19911aw(b, a, a2, b2, a3, a4, this.f55719g.mo163987a(), C20090cm.m42286b(this.f55720h), C20090cm.m42286b(this.f55721i));
    }
}
