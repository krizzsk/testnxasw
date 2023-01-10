package com.didi.sdk.messagecenter.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class MLog {

    /* renamed from: a */
    private static Logger f39596a = LoggerFactory.getLogger("MessageCenter");

    /* renamed from: d */
    public static void m29814d(String str) {
        f39596a.debug(str, new Object[0]);
    }

    /* renamed from: i */
    public static void m29816i(String str) {
        f39596a.info(str, new Object[0]);
    }

    /* renamed from: w */
    public static void m29817w(String str) {
        f39596a.warn(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m29815e(String str) {
        f39596a.error(str, new Object[0]);
    }
}
