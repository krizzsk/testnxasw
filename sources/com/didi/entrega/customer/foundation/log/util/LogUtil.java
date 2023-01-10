package com.didi.entrega.customer.foundation.log.util;

import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.log.IMessageGenerator;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.LoggerFactory;

public final class LogUtil {

    /* renamed from: a */
    private static final boolean f21795a = CustomerToolBoxUtil.DEBUG;

    private LogUtil() {
    }

    /* renamed from: d */
    public static void m18181d(String str, String str2) {
        if (f21795a) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 30);
        }
    }

    /* renamed from: i */
    public static void m18185i(String str, String str2) {
        m18184i(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: i */
    public static void m18184i(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f21795a) {
            SystemUtils.log(4, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 42);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m18187w(String str, String str2) {
        m18186w(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: w */
    public static void m18186w(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f21795a) {
            SystemUtils.log(5, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 57);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m18183e(String str, String str2) {
        m18182e(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: e */
    public static void m18182e(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f21795a) {
            SystemUtils.log(6, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 72);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
