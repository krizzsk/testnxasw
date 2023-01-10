package com.didi.safety.god.util;

import com.didi.sdk.apm.SystemUtils;

public class LogUtils {

    /* renamed from: a */
    private static final String f37607a = "SafetyGod";

    private LogUtils() {
    }

    /* renamed from: d */
    public static void m28308d(String str, String str2) {
        com.didichuxing.dfbasesdk.utils.LogUtils.m37052d(str, str2);
    }

    /* renamed from: d */
    public static void m28307d(String str) {
        m28308d("SafetyGod", str);
    }

    /* renamed from: i */
    public static void m28314i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.safety.god.util.LogUtils", 20);
    }

    /* renamed from: i */
    public static void m28313i(String str) {
        m28314i("SafetyGod", str);
    }

    /* renamed from: e */
    public static void m28310e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.safety.god.util.LogUtils", 28);
    }

    /* renamed from: e */
    public static void m28311e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "com.didi.safety.god.util.LogUtils", 32);
    }

    /* renamed from: e */
    public static void m28309e(String str) {
        m28310e("SafetyGod", str);
    }

    /* renamed from: e */
    public static void m28312e(String str, Throwable th) {
        m28311e("SafetyGod", str, th);
    }

    public static void logStackTrace(Throwable th) {
        com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(th);
    }
}
