package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cm */
public final class C20090cm<T> implements C20088ck, C20092co {

    /* renamed from: a */
    private static final Object f56110a = new Object();

    /* renamed from: b */
    private volatile C20092co<T> f56111b;

    /* renamed from: c */
    private volatile Object f56112c = f56110a;

    private C20090cm(C20092co<T> coVar) {
        this.f56111b = coVar;
    }

    /* renamed from: a */
    public static <P extends C20092co<T>, T> C20092co<T> m42285a(P p) {
        C20068br.m42229a(p);
        return p instanceof C20090cm ? p : new C20090cm(p);
    }

    /* renamed from: b */
    public static <P extends C20092co<T>, T> C20088ck<T> m42286b(P p) {
        if (p instanceof C20088ck) {
            return (C20088ck) p;
        }
        C20068br.m42229a(p);
        return new C20090cm(p);
    }

    /* renamed from: a */
    public final T mo164325a() {
        T t = this.f56112c;
        if (t == f56110a) {
            synchronized (this) {
                t = this.f56112c;
                if (t == f56110a) {
                    t = this.f56111b.mo163987a();
                    T t2 = this.f56112c;
                    if (t2 != f56110a && !(t2 instanceof C20091cn)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f56112c = t;
                    this.f56111b = null;
                }
            }
        }
        return t;
    }
}
