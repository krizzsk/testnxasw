package com.didi.onehybrid.log;

import com.didi.sdk.apm.SystemUtils;

public class Hlog {

    /* renamed from: a */
    private static final String f32095a = "Hybrid-Tag";

    /* renamed from: b */
    private static final boolean f32096b = true;

    public static void DebugLog(String str) {
        SystemUtils.log(3, f32095a, str, (Throwable) null, "com.didi.onehybrid.log.Hlog", 15);
    }
}
