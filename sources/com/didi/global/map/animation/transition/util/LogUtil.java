package com.didi.global.map.animation.transition.util;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class LogUtil {

    /* renamed from: a */
    private static final String f24753a = "sfs";

    /* renamed from: i */
    public static void m19847i(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(3, f24753a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 15);
        }
    }

    /* renamed from: w */
    public static void m19848w(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(5, f24753a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 21);
        }
    }

    /* renamed from: e */
    public static void m19846e(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(6, f24753a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 27);
        }
    }
}
