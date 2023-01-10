package com.didi.soda.customer.foundation.log.util;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.IMessageGenerator;
import com.didi.soda.customer.foundation.log.RecordTracker;

public final class LogUtil {

    /* renamed from: a */
    private static final boolean f43538a = CustomerToolBoxUtil.DEBUG;

    private LogUtil() {
    }

    /* renamed from: d */
    public static void m32584d(String str, String str2) {
        if (f43538a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m32588i(String str, String str2) {
        m32587i(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: i */
    public static void m32587i(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f43538a) {
            Log.i(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m32590w(String str, String str2) {
        m32589w(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: w */
    public static void m32589w(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f43538a) {
            Log.w(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m32586e(String str, String str2) {
        m32585e(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: e */
    public static void m32585e(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f43538a) {
            Log.e(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
