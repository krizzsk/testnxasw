package com.didichuxing.foundation.net.rpc.http;

/* renamed from: com.didichuxing.foundation.net.rpc.http.a */
/* compiled from: Constants */
interface C16376a {

    /* renamed from: a */
    public static final String f50174a = "http";

    /* renamed from: b */
    public static final String f50175b = "https";

    /* renamed from: c */
    public static final String[] f50176c = {"http", "https"};

    /* renamed from: d */
    public static final int f50177d;

    /* renamed from: e */
    public static final int f50178e;

    /* renamed from: f */
    public static final int f50179f;

    /* renamed from: g */
    public static final int f50180g;

    /* renamed from: h */
    public static final int f50181h = 1;

    /* renamed from: i */
    public static final boolean f50182i = false;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f50177d = availableProcessors;
        f50178e = (availableProcessors * 2) + 1;
        f50179f = (availableProcessors * 3) + 1;
        f50180g = (availableProcessors * 4) + 1;
    }
}
