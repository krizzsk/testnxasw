package com.didi.global.fintech.cashier.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class GlobalCashierSPUtil {

    /* renamed from: a */
    private static SharedPreferences f23356a = null;

    /* renamed from: b */
    private static String f23357b = "cashier";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        f23356a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        return f23356a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        f23356a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        return f23356a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        f23356a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f23356a == null) {
            f23356a = SystemUtils.getSharedPreferences(context, f23357b, 0);
        }
        return f23356a.contains(str);
    }
}
