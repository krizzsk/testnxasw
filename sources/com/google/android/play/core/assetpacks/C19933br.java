package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C20018a;
import com.google.android.play.core.common.C20020c;
import com.google.android.play.core.internal.C20089cl;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import com.google.android.play.core.splitinstall.C20207p;
import com.google.android.play.core.splitinstall.C20208q;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.br */
public final class C19933br implements C19888a {

    /* renamed from: a */
    private final C20004n f55767a;

    /* renamed from: b */
    private C20092co<Context> f55768b;

    /* renamed from: c */
    private C20092co<C19981dl> f55769c;

    /* renamed from: d */
    private C20092co<C19917bb> f55770d;

    /* renamed from: e */
    private C20092co<C19941bz> f55771e;

    /* renamed from: f */
    private C20092co<C19906ar> f55772f;

    /* renamed from: g */
    private C20092co<String> f55773g = C20090cm.m42285a(new C20010t(this.f55768b));

    /* renamed from: h */
    private C20092co<C20013w> f55774h = new C20089cl();

    /* renamed from: i */
    private C20092co<Executor> f55775i;

    /* renamed from: j */
    private C20092co<C19958cp> f55776j;

    /* renamed from: k */
    private C20092co<C19911aw> f55777k;

    /* renamed from: l */
    private C20092co<C19935bt> f55778l;

    /* renamed from: m */
    private C20092co<C19991dv> f55779m;

    /* renamed from: n */
    private C20092co<C19975df> f55780n;

    /* renamed from: o */
    private C20092co<C19979dj> f55781o;

    /* renamed from: p */
    private C20092co<C20018a> f55782p;

    /* renamed from: q */
    private C20092co<C19984do> f55783q;

    /* renamed from: r */
    private C20092co<C19926bk> f55784r;

    /* renamed from: s */
    private C20092co<C19961cs> f55785s;

    /* renamed from: t */
    private C20092co<C19938bw> f55786t;

    /* renamed from: u */
    private C20092co<C19929bn> f55787u;

    /* renamed from: v */
    private C20092co<Executor> f55788v;

    /* renamed from: w */
    private C20092co<C19968cz> f55789w;

    /* renamed from: x */
    private C20092co<C20207p> f55790x;

    /* renamed from: y */
    private C20092co<C19999j> f55791y;

    /* renamed from: z */
    private C20092co<AssetPackManager> f55792z;

    /* synthetic */ C19933br(C20004n nVar) {
        this.f55767a = nVar;
        C20009s sVar = new C20009s(nVar);
        this.f55768b = sVar;
        C20092co<C19981dl> a = C20090cm.m42285a(new C19982dm(sVar));
        this.f55769c = a;
        this.f55770d = C20090cm.m42285a(new C19918bc(this.f55768b, a));
        C20092co<C19941bz> a2 = C20090cm.m42285a(C19943ca.f55840a);
        this.f55771e = a2;
        this.f55772f = C20090cm.m42285a(new C19907as(this.f55768b, a2));
        C20092co<Executor> a3 = C20090cm.m42285a(C20005o.f56034a);
        this.f55775i = a3;
        this.f55776j = C20090cm.m42285a(new C19959cq(this.f55770d, this.f55774h, this.f55771e, a3));
        C20089cl clVar = new C20089cl();
        this.f55777k = clVar;
        this.f55778l = C20090cm.m42285a(new C19936bu(this.f55770d, this.f55774h, clVar, this.f55771e));
        this.f55779m = C20090cm.m42285a(new C19992dw(this.f55770d));
        this.f55780n = C20090cm.m42285a(new C19976dg(this.f55770d));
        this.f55781o = C20090cm.m42285a(new C19980dk(this.f55770d, this.f55774h, this.f55776j, this.f55775i, this.f55771e));
        C20092co<C20018a> a4 = C20090cm.m42285a(C20020c.m42114b());
        this.f55782p = a4;
        this.f55783q = C20090cm.m42285a(new C19985dp(this.f55770d, this.f55774h, a4));
        C20092co<C19926bk> a5 = C20090cm.m42285a(new C19927bl(this.f55774h));
        this.f55784r = a5;
        C20092co<C19961cs> a6 = C20090cm.m42285a(new C19962ct(this.f55776j, this.f55770d, a5));
        this.f55785s = a6;
        this.f55786t = C20090cm.m42285a(new C19939bx(this.f55776j, this.f55774h, this.f55778l, this.f55779m, this.f55780n, this.f55781o, this.f55783q, a6));
        this.f55787u = C20090cm.m42285a(C19930bo.f55765a);
        C20092co<Executor> a7 = C20090cm.m42285a(C20011u.f56042a);
        this.f55788v = a7;
        C20089cl.m42283a(this.f55777k, C20090cm.m42285a(new C19912ax(this.f55768b, this.f55776j, this.f55786t, this.f55774h, this.f55771e, this.f55787u, this.f55782p, this.f55775i, a7)));
        C20092co<C19968cz> a8 = C20090cm.m42285a(new C19970da(this.f55773g, this.f55777k, this.f55771e, this.f55768b, this.f55769c, this.f55775i));
        this.f55789w = a8;
        C20089cl.m42283a(this.f55774h, C20090cm.m42285a(new C20008r(this.f55768b, this.f55772f, a8)));
        C20092co<C20207p> a9 = C20090cm.m42285a(C20208q.m42548a(this.f55768b));
        this.f55790x = a9;
        C20092co<C19999j> a10 = C20090cm.m42285a(new C20000k(this.f55770d, this.f55774h, this.f55777k, a9, this.f55776j, this.f55771e, this.f55787u, this.f55775i));
        this.f55791y = a10;
        this.f55792z = C20090cm.m42285a(new C20007q(a10, this.f55768b));
    }

    /* renamed from: a */
    public final AssetPackManager mo164059a() {
        return this.f55792z.mo163987a();
    }

    /* renamed from: a */
    public final void mo164060a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f55628a = C20009s.m42089a(this.f55767a);
        assetPackExtractionService.f55629b = this.f55791y.mo163987a();
        assetPackExtractionService.f55630c = this.f55770d.mo163987a();
    }
}
