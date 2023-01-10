package com.didi.one.netdetect.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class PrefUtil {
    public static final String KEY_PING_OUTPUT_TIME = "ping_output_time";
    public static final String KEY_TRACE_ROUTE_TIME = "trace_route_time";
    public static final String SHARED_PREFS_NAME = "net_detect";

    /* renamed from: a */
    private static SharedPreferences f31945a = null;

    /* renamed from: b */
    private static SharedPreferences.Editor f31946b = null;

    /* renamed from: c */
    private static boolean f31947c = false;

    /* renamed from: a */
    private static void m24370a(Context context) {
        if (!f31947c) {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), SHARED_PREFS_NAME, 0);
            f31945a = sharedPreferences;
            f31946b = sharedPreferences.edit();
            f31947c = true;
        }
    }

    public static void setTraceRouteTime(Context context, long j) {
        m24370a(context);
        f31946b.putLong(KEY_TRACE_ROUTE_TIME, j).commit();
    }

    public static long getTraceRouteTime(Context context) {
        m24370a(context);
        return f31945a.getLong(KEY_TRACE_ROUTE_TIME, 0);
    }

    public static void setPingOutputTime(Context context, long j) {
        m24370a(context);
        f31946b.putLong(KEY_PING_OUTPUT_TIME, j).commit();
    }

    public static long getPingOutputTime(Context context) {
        m24370a(context);
        return f31945a.getLong(KEY_PING_OUTPUT_TIME, 0);
    }
}
