package com.didi.soda.compose.log;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.compose.ComposeEngine;
import com.didi.soda.compose.log.ComposeRecordTracker;

public final class ComposeLogUtil {

    /* renamed from: a */
    private static final boolean f42699a = ComposeEngine.DEBUG;

    private ComposeLogUtil() {
    }

    /* renamed from: d */
    public static void m32026d(String str, String str2) {
        if (f42699a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m32030i(String str, String str2) {
        m32029i(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: i */
    public static void m32029i(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f42699a) {
            Log.i(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m32032w(String str, String str2) {
        m32031w(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: w */
    public static void m32031w(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f42699a) {
            Log.w(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m32028e(String str, String str2) {
        m32027e(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: e */
    public static void m32027e(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f42699a) {
            Log.e(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
