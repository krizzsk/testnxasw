package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;

/* renamed from: com.google.android.play.core.appupdate.y */
public final class C19887y {

    /* renamed from: a */
    private C20092co<Context> f55621a;

    /* renamed from: b */
    private C20092co<C19880r> f55622b;

    /* renamed from: c */
    private C20092co<C19878p> f55623c;

    /* renamed from: d */
    private C20092co<C19863a> f55624d;

    /* renamed from: e */
    private C20092co<C19867e> f55625e;

    /* renamed from: f */
    private C20092co<AppUpdateManager> f55626f;

    /* synthetic */ C19887y(C19869g gVar) {
        C19871i iVar = new C19871i(gVar);
        this.f55621a = iVar;
        C20092co<C19880r> a = C20090cm.m42285a(new C19881s(iVar));
        this.f55622b = a;
        this.f55623c = C20090cm.m42285a(new C19879q(this.f55621a, a));
        C20092co<C19863a> a2 = C20090cm.m42285a(new C19864b(this.f55621a));
        this.f55624d = a2;
        C20092co<C19867e> a3 = C20090cm.m42285a(new C19868f(this.f55623c, a2, this.f55621a));
        this.f55625e = a3;
        this.f55626f = C20090cm.m42285a(new C19870h(a3));
    }

    /* renamed from: a */
    public final AppUpdateManager mo164026a() {
        return this.f55626f.mo163987a();
    }
}
