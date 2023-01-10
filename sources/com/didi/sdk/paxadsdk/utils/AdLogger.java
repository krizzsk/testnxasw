package com.didi.sdk.paxadsdk.utils;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class AdLogger {
    public static String TAG = "AdLogger";

    /* renamed from: a */
    private static final Logger f39692a = LoggerFactory.getLogger("AdLogger");

    /* renamed from: i */
    public static void m29886i(String str) {
        f39692a.info(str, new Object[0]);
    }

    /* renamed from: d */
    public static void m29883d(String str) {
        f39692a.debug(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m29884e(String str) {
        f39692a.error(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m29885e(String str, Exception exc) {
        f39692a.error(str, (Throwable) exc);
    }
}
