package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.UUID;

public class UserInfoCollector {

    /* renamed from: a */
    private static Context f48222a = null;

    /* renamed from: b */
    private static SharedPreferences f48223b = null;

    /* renamed from: c */
    private static final String f48224c = "omega_user_info";

    /* renamed from: d */
    private static final String f48225d = "omega_id";

    public static void init(Context context) {
        f48222a = context;
    }

    public static String getOmegaId() {
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f48222a, "omega_user_info", 0);
            f48223b = sharedPreferences;
            String string = sharedPreferences.getString("omega_id", "");
            if (string.isEmpty()) {
                string = UUID.randomUUID().toString();
                f48223b.edit().putString("omega_id", string).commit();
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Long getSeq(String str) {
        Long.valueOf(0);
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f48222a, "omega_user_info", 0);
            f48223b = sharedPreferences;
            Long valueOf = Long.valueOf(sharedPreferences.getLong(str, 0) + 1);
            f48223b.edit().putLong(str, valueOf.longValue()).commit();
            return valueOf;
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
