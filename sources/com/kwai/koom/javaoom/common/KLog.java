package com.kwai.koom.javaoom.common;

import com.didi.sdk.apm.SystemUtils;

public class KLog {

    /* renamed from: a */
    private static KLogger f58447a;

    public interface KLogger {
        /* renamed from: d */
        void mo174120d(String str, String str2);

        /* renamed from: e */
        void mo174121e(String str, String str2);

        /* renamed from: i */
        void mo174122i(String str, String str2);
    }

    public static class DefaultLogger implements KLogger {
        /* renamed from: i */
        public void mo174122i(String str, String str2) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 18);
        }

        /* renamed from: d */
        public void mo174120d(String str, String str2) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 23);
        }

        /* renamed from: e */
        public void mo174121e(String str, String str2) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.kwai.koom.javaoom.common.KLog$DefaultLogger", 28);
        }
    }

    public static void init(KLogger kLogger) {
        f58447a = kLogger;
    }

    /* renamed from: i */
    public static void m44291i(String str, String str2) {
        if (f58447a == null) {
            init(new DefaultLogger());
        }
        f58447a.mo174122i(str, str2);
    }

    /* renamed from: d */
    public static void m44289d(String str, String str2) {
        if (f58447a == null) {
            init(new DefaultLogger());
        }
        f58447a.mo174120d(str, str2);
    }

    /* renamed from: e */
    public static void m44290e(String str, String str2) {
        if (f58447a == null) {
            init(new DefaultLogger());
        }
        f58447a.mo174121e(str, str2);
    }
}
