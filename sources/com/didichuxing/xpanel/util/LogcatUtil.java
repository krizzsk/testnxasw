package com.didichuxing.xpanel.util;

import com.didi.sdk.apm.SystemUtils;

public class LogcatUtil {

    /* renamed from: a */
    private static final String f52156a = "log_xpanel_";
    public static boolean sLogEnable = true;

    /* renamed from: e */
    public static void m39238e(String str, String str2) {
        if (sLogEnable) {
            SystemUtils.log(6, getTag(str), str2, (Throwable) null, "com.didichuxing.xpanel.util.LogcatUtil", 15);
        }
    }

    /* renamed from: w */
    public static void m39240w(String str, String str2) {
        if (sLogEnable) {
            SystemUtils.log(5, getTag(str), str2, (Throwable) null, "com.didichuxing.xpanel.util.LogcatUtil", 21);
        }
    }

    /* renamed from: i */
    public static void m39239i(String str, String str2) {
        if (sLogEnable) {
            SystemUtils.log(4, getTag(str), str2, (Throwable) null, "com.didichuxing.xpanel.util.LogcatUtil", 27);
        }
    }

    /* renamed from: d */
    public static void m39237d(String str, String str2) {
        if (sLogEnable) {
            SystemUtils.log(3, getTag(str), str2, (Throwable) null, "com.didichuxing.xpanel.util.LogcatUtil", 33);
        }
    }

    public static String getTag(String str) {
        return f52156a + str;
    }
}
