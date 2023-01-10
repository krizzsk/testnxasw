package com.didi.soda.customer.foundation.rpc;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f43557a;

    /* renamed from: b */
    static long f43558b;

    /* renamed from: c */
    static long f43559c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f43560d = new long[100];

    /* renamed from: e */
    private static Logger f43561e = LogService.getLogger("Clock");

    public static void updateServiceTime(long j) {
        Logger logger = f43561e;
        logger.debug("updateServiceTime: " + j, new Object[0]);
        f43558b = j + TimeUnit.MILLISECONDS.toSeconds(m32600a());
        f43559c = System.currentTimeMillis();
    }

    public static long timeOffsetSeconds() {
        return f43558b - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public static long timeAtSeconds() {
        long j;
        long j2 = f43558b;
        if (j2 == 0) {
            j = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        } else {
            j = j2 + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f43559c);
        }
        Logger logger = f43561e;
        logger.debug("currentTimeAtSeconds: " + j, new Object[0]);
        return j;
    }

    /* renamed from: a */
    static void m32601a(long j) {
        long[] jArr = f43560d;
        int i = f43557a;
        f43557a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m32600a() {
        int min = Math.min(f43557a + 1, f43560d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f43560d[i];
        }
        return (j / ((long) min)) >> 1;
    }
}
