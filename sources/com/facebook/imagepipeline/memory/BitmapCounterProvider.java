package com.facebook.imagepipeline.memory;

import com.threatmetrix.TrustDefender.qqqqqy;

public class BitmapCounterProvider {

    /* renamed from: KB */
    private static final long f54611KB = 1024;
    public static final int MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();

    /* renamed from: MB */
    private static final long f54612MB = 1048576;
    private static final Class<?> TAG = BitmapCounterProvider.class;
    private static volatile BitmapCounter sBitmapCounter;
    private static int sMaxBitmapCount = 384;

    private static int getMaxSizeHardCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) min) > qqqqqy.be0065ee00650065) {
            return (min / 4) * 3;
        }
        return min / 2;
    }

    public static void initialize(BitmapCounterConfig bitmapCounterConfig) {
        if (sBitmapCounter == null) {
            sMaxBitmapCount = bitmapCounterConfig.getMaxBitmapCount();
            return;
        }
        throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
    }

    public static BitmapCounter get() {
        if (sBitmapCounter == null) {
            synchronized (BitmapCounterProvider.class) {
                if (sBitmapCounter == null) {
                    sBitmapCounter = new BitmapCounter(sMaxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
                }
            }
        }
        return sBitmapCounter;
    }
}
