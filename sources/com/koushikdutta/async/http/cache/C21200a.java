package com.koushikdutta.async.http.cache;

/* renamed from: com.koushikdutta.async.http.cache.a */
/* compiled from: Objects */
final class C21200a {
    private C21200a() {
    }

    /* renamed from: a */
    public static boolean m44077a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m44076a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
