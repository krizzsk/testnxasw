package com.didi.sdk.debug;

import android.content.pm.ApplicationInfo;

public class AppDebugger {

    /* renamed from: a */
    private static boolean f38552a = false;

    public static boolean isDebuggable() {
        return f38552a;
    }

    public static void setIsDebuggable(ApplicationInfo applicationInfo) {
        f38552a = (applicationInfo.flags & 2) != 0;
    }
}
