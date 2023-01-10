package com.didi.sdk.sidebar.history.manager.soda;

import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f40096a;

    /* renamed from: b */
    static long f40097b;

    /* renamed from: c */
    static long f40098c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f40099d = new long[100];

    /* renamed from: a */
    static void m30259a(long j) {
        long[] jArr = f40099d;
        int i = f40096a;
        f40096a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m30258a() {
        int min = Math.min(f40096a + 1, f40099d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f40099d[i];
        }
        return (j / ((long) min)) >> 1;
    }

    public static void updateServiceTime(long j) {
        f40097b = j + TimeUnit.MILLISECONDS.toSeconds(m30258a());
        f40098c = System.currentTimeMillis();
    }

    public static long timeAtSeconds() {
        long j = f40097b;
        if (j == 0) {
            return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        return j + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f40098c);
    }
}
