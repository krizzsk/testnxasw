package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.h */
/* compiled from: Subscription */
final class C13013h {

    /* renamed from: a */
    final Object f38641a;

    /* renamed from: b */
    final C13011f f38642b;

    /* renamed from: c */
    final int f38643c;

    /* renamed from: d */
    volatile boolean f38644d = true;

    C13013h(Object obj, C13011f fVar, int i) {
        this.f38641a = obj;
        this.f38642b = fVar;
        this.f38643c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C13013h)) {
            return false;
        }
        C13013h hVar = (C13013h) obj;
        if (this.f38641a != hVar.f38641a || !this.f38642b.equals(hVar.f38642b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f38641a.hashCode() + this.f38642b.f38637d.hashCode();
    }
}
