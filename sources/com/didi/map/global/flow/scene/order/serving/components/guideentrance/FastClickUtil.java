package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

public class FastClickUtil {

    /* renamed from: a */
    private static long f29362a = 0;

    /* renamed from: b */
    private static final long f29363b = 1000;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f29362a;
        if (0 < j && j < 1000) {
            return true;
        }
        f29362a = currentTimeMillis;
        return false;
    }
}
