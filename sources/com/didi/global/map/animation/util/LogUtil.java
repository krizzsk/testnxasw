package com.didi.global.map.animation.util;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class LogUtil {

    /* renamed from: a */
    private static final String f24774a = "sfs";

    /* renamed from: i */
    public static void m19856i(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(3, f24774a, str, (Throwable) null, "com.didi.global.map.animation.util.LogUtil", 15);
        }
    }

    /* renamed from: w */
    public static void m19857w(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(5, f24774a, str, (Throwable) null, "com.didi.global.map.animation.util.LogUtil", 21);
        }
    }

    /* renamed from: e */
    public static void m19855e(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(6, f24774a, str, (Throwable) null, "com.didi.global.map.animation.util.LogUtil", 27);
        }
    }
}
