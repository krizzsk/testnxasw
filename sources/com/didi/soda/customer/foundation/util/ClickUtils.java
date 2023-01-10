package com.didi.soda.customer.foundation.util;

public final class ClickUtils {

    /* renamed from: a */
    private static final long f43729a = 500;

    /* renamed from: b */
    private static long f43730b;

    private ClickUtils() {
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f43730b < 500;
        if (!z) {
            f43730b = currentTimeMillis;
        }
        return z;
    }
}
