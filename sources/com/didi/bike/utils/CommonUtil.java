package com.didi.bike.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class CommonUtil {

    /* renamed from: a */
    private static Boolean f12501a;

    public static boolean isDebugBuild(Context context) {
        Boolean bool = f12501a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (bool == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return false;
            }
            if ((applicationInfo.flags & 2) != 0) {
                z = true;
            }
            f12501a = Boolean.valueOf(z);
        }
        return f12501a.booleanValue();
    }
}
