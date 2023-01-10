package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.MapLog;

/* renamed from: com.didi.hawaii.mapsdkv2.core.h */
/* compiled from: ShareGLContext */
final class C9946h {

    /* renamed from: a */
    private static final String f26300a = "ShareGLContext";

    /* renamed from: b */
    private static boolean f26301b = false;

    C9946h() {
    }

    /* renamed from: a */
    static boolean m20772a() {
        return f26301b;
    }

    /* renamed from: a */
    static void m20771a(boolean z) {
        MapLog.m20586d(f26300a, "ShareContext support: " + z);
        f26301b = z;
    }
}
