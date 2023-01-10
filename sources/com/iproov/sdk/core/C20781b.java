package com.iproov.sdk.core;

import com.iproov.sdk.core.C20782break;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.core.b */
/* compiled from: SecurityResultsStore */
class C20781b {

    /* renamed from: a */
    private static final Map<C20882import, Boolean> f56929a = new HashMap();

    /* renamed from: b */
    private static final Map<C20782break.C20783do, Boolean> f56930b = new HashMap();

    /* renamed from: c */
    private static final Map<C20888super, Object> f56931c = new HashMap();

    /* renamed from: a */
    static synchronized void m43062a() {
        synchronized (C20781b.class) {
            f56929a.clear();
            f56930b.clear();
            f56931c.clear();
        }
    }

    /* renamed from: a */
    public static Boolean m43060a(C20882import importR) {
        return f56929a.get(importR);
    }

    /* renamed from: a */
    public static void m43064a(C20882import importR, Boolean bool) {
        f56929a.put(importR, bool);
    }

    /* renamed from: a */
    public static Boolean m43059a(C20782break.C20783do doVar) {
        return f56930b.get(doVar);
    }

    /* renamed from: a */
    public static void m43063a(C20782break.C20783do doVar, Boolean bool) {
        f56930b.put(doVar, bool);
    }

    /* renamed from: a */
    public static Object m43061a(C20888super superR) {
        return f56931c.get(superR);
    }

    /* renamed from: a */
    public static void m43065a(C20888super superR, Object obj) {
        f56931c.put(superR, obj);
    }
}
