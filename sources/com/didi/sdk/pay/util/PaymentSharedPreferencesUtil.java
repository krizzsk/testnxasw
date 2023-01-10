package com.didi.sdk.pay.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

@Deprecated
public class PaymentSharedPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f39700a = null;

    /* renamed from: b */
    private static String f39701b = "payment";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f39700a == null) {
            f39700a = SystemUtils.getSharedPreferences(context, f39701b, 0);
        }
        f39700a.edit().putBoolean(str, z).commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f39700a == null) {
            f39700a = SystemUtils.getSharedPreferences(context, f39701b, 0);
        }
        return f39700a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f39700a == null) {
            f39700a = SystemUtils.getSharedPreferences(context, f39701b, 0);
        }
        f39700a.edit().putString(str, str2).commit();
    }

    public static String getString(Context context, String str, String str2) {
        if (f39700a == null) {
            f39700a = SystemUtils.getSharedPreferences(context, f39701b, 0);
        }
        return f39700a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f39700a == null) {
            f39700a = SystemUtils.getSharedPreferences(context, f39701b, 0);
        }
        f39700a.edit().remove(str).commit();
    }
}
