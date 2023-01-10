package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.an */
final class C20037an extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ IBinder f56068a;

    /* renamed from: b */
    final /* synthetic */ C20039ap f56069b;

    C20037an(C20039ap apVar, IBinder iBinder) {
        this.f56069b = apVar;
        this.f56068a = iBinder;
    }

    /* renamed from: a */
    public final void mo163993a() {
        C20040aq aqVar = this.f56069b.f56071a;
        aqVar.f56083l = (IInterface) aqVar.f56079h.mo163992a(this.f56068a);
        C20040aq.m42151f(this.f56069b.f56071a);
        this.f56069b.f56071a.f56077f = false;
        for (Runnable run : this.f56069b.f56071a.f56076e) {
            run.run();
        }
        this.f56069b.f56071a.f56076e.clear();
    }
}
