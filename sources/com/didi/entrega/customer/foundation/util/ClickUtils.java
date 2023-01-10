package com.didi.entrega.customer.foundation.util;

public final class ClickUtils {

    /* renamed from: a */
    private static final long f21928a = 500;

    /* renamed from: b */
    private static long f21929b;

    private ClickUtils() {
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f21929b < 500;
        if (!z) {
            f21929b = currentTimeMillis;
        }
        return z;
    }
}
