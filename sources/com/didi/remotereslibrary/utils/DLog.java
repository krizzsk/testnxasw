package com.didi.remotereslibrary.utils;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DLog {

    /* renamed from: a */
    private static final String f35944a = "remoteresource";

    /* renamed from: b */
    private static final Logger f35945b = LoggerFactory.getLogger(f35944a);

    /* renamed from: e */
    public static void m27100e(String str, String str2, int i) {
        f35945b.error("[%s]---> %s", str, str2);
    }

    /* renamed from: d */
    public static void m27099d(String str, String str2) {
        f35945b.debug("[%s]---> %s", str, str2);
    }

    /* renamed from: w */
    public static void m27102w(String str, String str2) {
        f35945b.warn("[%s]---> %s", str, str2);
    }

    /* renamed from: i */
    public static void m27101i(String str, String str2) {
        f35945b.info("[%s]---> %s", str, str2);
    }
}
