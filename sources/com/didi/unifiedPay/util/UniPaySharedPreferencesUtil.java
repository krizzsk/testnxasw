package com.didi.unifiedPay.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class UniPaySharedPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f47273a = null;

    /* renamed from: b */
    private static String f47274b = "unipay";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        f47273a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        return f47273a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        f47273a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        return f47273a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        f47273a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f47273a == null) {
            f47273a = SystemUtils.getSharedPreferences(context, f47274b, 0);
        }
        return f47273a.contains(str);
    }
}
