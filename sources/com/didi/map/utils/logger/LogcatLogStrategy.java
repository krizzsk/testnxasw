package com.didi.map.utils.logger;

import com.didi.sdk.apm.SystemUtils;

public class LogcatLogStrategy implements LogStrategy {

    /* renamed from: a */
    static final String f31500a = "NO_TAG";

    public void log(int i, String str, String str2) {
        C11057b.m24081b(str2);
        if (str == null) {
            str = f31500a;
        }
        SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.map.utils.logger.LogcatLogStrategy", 25);
    }
}
