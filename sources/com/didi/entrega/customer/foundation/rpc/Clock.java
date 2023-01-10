package com.didi.entrega.customer.foundation.rpc;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f21799a;

    /* renamed from: b */
    static long f21800b;

    /* renamed from: c */
    static long f21801c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f21802d = new long[100];

    /* renamed from: e */
    private static Logger f21803e = LogService.getLogger("Clock");

    public static void updateServiceTime(long j) {
        Logger logger = f21803e;
        logger.debug("updateServiceTime: " + j, new Object[0]);
        f21800b = j + TimeUnit.MILLISECONDS.toSeconds(m18193a());
        f21801c = System.currentTimeMillis();
    }

    public static long timeOffsetSeconds() {
        return f21800b - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public static long timeAtSeconds() {
        long j;
        long j2 = f21800b;
        if (j2 == 0) {
            j = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        } else {
            j = j2 + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f21801c);
        }
        Logger logger = f21803e;
        logger.debug("currentTimeAtSeconds: " + j, new Object[0]);
        return j;
    }

    /* renamed from: a */
    static void m18194a(long j) {
        long[] jArr = f21802d;
        int i = f21799a;
        f21799a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m18193a() {
        int min = Math.min(f21799a + 1, f21802d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f21802d[i];
        }
        return (j / ((long) min)) >> 1;
    }
}
