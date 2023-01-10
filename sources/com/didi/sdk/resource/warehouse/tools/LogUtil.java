package com.didi.sdk.resource.warehouse.tools;

import com.didi.sdk.apm.SystemUtils;

public class LogUtil {

    /* renamed from: a */
    private static final String f39835a = "WareHouse_";

    /* renamed from: b */
    private static boolean f39836b = false;

    public static void setDebug(boolean z) {
        f39836b = z;
    }

    public static boolean isDebug() {
        return f39836b;
    }

    /* renamed from: v */
    public static void m29981v(String str, String str2) {
        if (f39836b) {
            SystemUtils.log(2, f39835a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 20);
        }
    }

    /* renamed from: d */
    public static void m29978d(String str, String str2) {
        if (f39836b) {
            SystemUtils.log(3, f39835a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 26);
        }
    }

    /* renamed from: i */
    public static void m29980i(String str, String str2) {
        if (f39836b) {
            SystemUtils.log(4, f39835a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 32);
        }
    }

    /* renamed from: w */
    public static void m29982w(String str, String str2) {
        if (f39836b) {
            SystemUtils.log(5, f39835a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 38);
        }
    }

    /* renamed from: e */
    public static void m29979e(String str, String str2) {
        if (f39836b) {
            SystemUtils.log(6, f39835a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 44);
        }
    }
}
