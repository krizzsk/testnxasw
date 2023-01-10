package com.didi.component.common.util;

import android.text.TextUtils;

public class GlobalParseUtils {
    /* renamed from: b */
    private static void m11368b(String str) {
    }

    public static double parseDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            m11367a("parseDouble err while text is null!");
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            m11367a(e.toString());
            m11368b(e.toString());
            return 0.0d;
        }
    }

    /* renamed from: a */
    private static void m11367a(String str) {
        GLog.m11356e(str);
    }
}
