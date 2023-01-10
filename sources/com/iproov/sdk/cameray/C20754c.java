package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.c */
/* compiled from: CameraFactoryProvider */
class C20754c {

    /* renamed from: a */
    private static final String f56852a = m42862b();

    /* renamed from: a */
    public static C20762else m42861a() {
        C20762else c = m42863c();
        return c != null ? c : new C20765goto();
    }

    /* renamed from: b */
    static String m42862b() {
        return new this$do().toString();
    }

    /* renamed from: c */
    private static C20762else m42863c() {
        try {
            return (C20762else) Class.forName(f56852a).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
