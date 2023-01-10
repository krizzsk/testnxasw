package com.google.android.datatransport.runtime.logging;

import com.didi.sdk.apm.SystemUtils;

public final class Logging {
    private Logging() {
    }

    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: d */
    public static void m40762d(String str, String str2) {
        SystemUtils.log(3, getTag(str), str2, (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 27);
    }

    /* renamed from: d */
    public static void m40763d(String str, String str2, Object obj) {
        SystemUtils.log(3, getTag(str), String.format(str2, new Object[]{obj}), (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 31);
    }

    /* renamed from: d */
    public static void m40764d(String str, String str2, Object obj, Object obj2) {
        SystemUtils.log(3, getTag(str), String.format(str2, new Object[]{obj, obj2}), (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 35);
    }

    /* renamed from: d */
    public static void m40765d(String str, String str2, Object... objArr) {
        SystemUtils.log(3, getTag(str), String.format(str2, objArr), (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 39);
    }

    /* renamed from: i */
    public static void m40767i(String str, String str2) {
        SystemUtils.log(4, getTag(str), str2, (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 43);
    }

    /* renamed from: e */
    public static void m40766e(String str, String str2, Throwable th) {
        SystemUtils.log(6, getTag(str), str2, th, "com.google.android.datatransport.runtime.logging.Logging", 47);
    }

    /* renamed from: w */
    public static void m40768w(String str, String str2, Object obj) {
        SystemUtils.log(5, getTag(str), String.format(str2, new Object[]{obj}), (Throwable) null, "com.google.android.datatransport.runtime.logging.Logging", 51);
    }
}
