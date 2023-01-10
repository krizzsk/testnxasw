package com.didi.map.global.model;

import android.content.Context;

public class URLHelper {

    /* renamed from: a */
    private static final String f29842a = "https://apimap.liggyglobal.com";

    /* renamed from: b */
    private static final String f29843b = "https://apimap.didiglobal.com";

    /* renamed from: c */
    private static final String f29844c = "com.linkee.global";

    public static boolean isCanoeApp(Context context) {
        return f29844c.equals(m23112a(context));
    }

    /* renamed from: a */
    private static String m23112a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static String getUrlHost(Context context) {
        return isCanoeApp(context) ? f29842a : "https://apimap.didiglobal.com";
    }
}
