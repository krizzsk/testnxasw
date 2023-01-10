package com.didi.hawaii.log;

import android.text.TextUtils;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.didi.hawaii.log.c */
/* compiled from: LoggerHelper */
final class C9701c {

    /* renamed from: a */
    private static final HWLogger2 f25742a = new HWLogger2("{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt");

    /* renamed from: b */
    private static Logger f25743b = null;

    C9701c() {
    }

    /* renamed from: a */
    static void m20450a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f25742a.setPhoneNumber(str);
        }
    }

    /* renamed from: b */
    static void m20454b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f25742a.setPath(str);
        }
    }

    /* renamed from: c */
    static void m20455c(String str) {
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m20449a();
            if (a != null) {
                a.println(Const.jaLeft + m20453b() + "] " + str);
                return;
            }
            return;
        }
        f25742a.log(str);
    }

    /* renamed from: a */
    static void m20451a(String str, String str2) {
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m20449a();
            if (a != null) {
                a.error(str + " " + str2, new Object[0]);
                return;
            }
            return;
        }
        f25742a.log(str, str2);
    }

    /* renamed from: a */
    static void m20452a(boolean z) {
        f25742a.setDebug(z);
    }

    /* renamed from: a */
    private static synchronized Logger m20449a() {
        synchronized (C9701c.class) {
            if (f25743b != null) {
                Logger logger = f25743b;
                return logger;
            }
            Logger logger2 = LoggerFactory.getLogger("", HWLog.BUFFER_ID);
            f25743b = logger2;
            return logger2;
        }
    }

    /* renamed from: b */
    private static String m20453b() {
        return Thread.currentThread().getName();
    }
}
