package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cl */
public final class C20089cl<T> implements C20092co<T> {

    /* renamed from: a */
    private C20092co<T> f56109a;

    /* renamed from: a */
    public static <T> void m42283a(C20092co<T> coVar, C20092co<T> coVar2) {
        C20068br.m42229a(coVar2);
        C20089cl clVar = (C20089cl) coVar;
        if (clVar.f56109a == null) {
            clVar.f56109a = coVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo163987a() {
        C20092co<T> coVar = this.f56109a;
        if (coVar != null) {
            return coVar.mo163987a();
        }
        throw new IllegalStateException();
    }
}
