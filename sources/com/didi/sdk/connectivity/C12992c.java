package com.didi.sdk.connectivity;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Map;

/* renamed from: com.didi.sdk.connectivity.c */
/* compiled from: Logger */
class C12992c {

    /* renamed from: a */
    private static Logger f38526a = LoggerFactory.getLogger(f38527b);

    /* renamed from: b */
    private static final String f38527b = "didi-connectivity";

    C12992c() {
    }

    /* renamed from: a */
    private static void m29061a(Map<?, ?> map) {
        f38526a.infoEvent(f38527b, map);
    }

    /* renamed from: a */
    static void m29060a(String str) {
        m29062a("log", str);
    }

    /* renamed from: a */
    private static void m29062a(Object... objArr) {
        f38526a.infoEvent(f38527b, objArr);
    }
}
