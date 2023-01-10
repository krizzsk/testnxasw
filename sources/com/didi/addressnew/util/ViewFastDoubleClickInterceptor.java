package com.didi.addressnew.util;

public class ViewFastDoubleClickInterceptor {

    /* renamed from: a */
    private static long f9315a = 0;

    /* renamed from: b */
    private static final long f9316b = 800;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f9315a;
        if (0 < j && j < 800) {
            return true;
        }
        f9315a = currentTimeMillis;
        return false;
    }
}
