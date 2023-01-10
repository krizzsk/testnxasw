package com.didichuxing.util;

import com.didi.sdk.apm.SystemUtils;

public class UpLogger {

    /* renamed from: a */
    private static boolean f51819a = false;

    public static void setCanLogger(boolean z) {
        f51819a = z;
    }

    /* renamed from: d */
    public static void m38965d(String str, String str2) {
        if (f51819a) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didichuxing.util.UpLogger", 21);
        }
    }

    /* renamed from: e */
    public static void m38966e(String str, String str2) {
        if (f51819a) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.util.UpLogger", 27);
        }
    }
}
