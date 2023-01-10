package com.didichuxing.dfbasesdk.utils;

import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.lang.reflect.Field;

public class DebugUtils {

    /* renamed from: a */
    private static Boolean f49381a;

    /* renamed from: b */
    private static String f49382b;

    public static void setAppPackage(String str) {
        f49382b = str;
    }

    public static boolean isDebug() {
        String str;
        if (f49381a == null) {
            try {
                if (TextUtils.isEmpty(f49382b)) {
                    str = WsgSecInfo.packageName(AppContextHolder.getAppContext());
                } else {
                    str = f49382b;
                }
                Field field = Class.forName(str + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                f49381a = Boolean.valueOf(field.getBoolean((Object) null));
            } catch (Throwable unused) {
                f49381a = false;
            }
        }
        return f49381a.booleanValue();
    }
}
