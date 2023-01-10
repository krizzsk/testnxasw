package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ak */
final class C20034ak extends C20031ah {

    /* renamed from: a */
    final /* synthetic */ C20040aq f56067a;

    C20034ak(C20040aq aqVar) {
        this.f56067a = aqVar;
    }

    /* renamed from: a */
    public final void mo163993a() {
        if (this.f56067a.f56083l != null) {
            this.f56067a.f56074c.mo164270c("Unbind from service.", new Object[0]);
            this.f56067a.f56073b.unbindService(this.f56067a.f56082k);
            this.f56067a.f56077f = false;
            this.f56067a.f56083l = null;
            this.f56067a.f56082k = null;
        }
    }
}
