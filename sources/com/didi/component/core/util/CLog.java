package com.didi.component.core.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class CLog {

    /* renamed from: a */
    private static Logger f14603a = LoggerFactory.getLogger("Component");

    /* renamed from: d */
    public static void m12098d(String str) {
        f14603a.debug(str, new Object[0]);
    }

    /* renamed from: i */
    public static void m12100i(String str) {
        f14603a.info(str, new Object[0]);
    }

    /* renamed from: w */
    public static void m12101w(String str) {
        f14603a.warn(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m12099e(String str) {
        f14603a.error(str, new Object[0]);
    }
}
