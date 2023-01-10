package com.didi.beatles.p101im.picture.utils;

/* renamed from: com.didi.beatles.im.picture.utils.IMDoubleUtils */
public class IMDoubleUtils {

    /* renamed from: a */
    private static long f11288a = 0;

    /* renamed from: b */
    private static final long f11289b = 800;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f11288a < 800) {
            return true;
        }
        f11288a = currentTimeMillis;
        return false;
    }
}
