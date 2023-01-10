package com.didi.sdk.logging.util;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;

public class Debug {

    /* renamed from: a */
    private static final String f39420a = "logging";

    public static boolean isDebuggable() {
        return LoggerFactory.getConfig().isDebuggable();
    }

    /* renamed from: d */
    public static void m29707d(String str) {
        if (isDebuggable()) {
            Log.d(f39420a, str);
        }
    }

    /* renamed from: i */
    public static void m29710i(String str) {
        if (isDebuggable()) {
            Log.i(f39420a, str);
        }
    }

    /* renamed from: e */
    public static void m29708e(String str) {
        if (isDebuggable()) {
            Log.e(f39420a, str);
        }
    }

    /* renamed from: e */
    public static void m29709e(String str, Throwable th) {
        if (isDebuggable()) {
            Log.e(f39420a, str, th);
        }
    }

    public static void logOrThrow(String str, Throwable th) {
        if (!isDebuggable()) {
            Log.e(f39420a, str, th);
            return;
        }
        throw new RuntimeException(str, th);
    }
}
