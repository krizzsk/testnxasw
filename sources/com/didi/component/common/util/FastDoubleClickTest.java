package com.didi.component.common.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class FastDoubleClickTest {

    /* renamed from: a */
    private static final Logger f13589a = LoggerFactory.getLogger((Class<?>) FastDoubleClickTest.class);

    /* renamed from: b */
    private static long f13590b;

    /* renamed from: c */
    private static long f13591c = 400;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = f13589a;
        logger.debug("FastDoubleClickTest 开始: currentTime: " + currentTimeMillis, new Object[0]);
        long j = currentTimeMillis - f13590b;
        if (0 >= j || j >= f13591c) {
            Logger logger2 = f13589a;
            logger2.debug("FastDoubleClickTest 结束 timeD: " + j + "false ; lastClickTime: " + currentTimeMillis, new Object[0]);
            f13590b = currentTimeMillis;
            return false;
        }
        Logger logger3 = f13589a;
        logger3.debug("FastDoubleClickTest 结束 timeD: " + j + "true, time = " + currentTimeMillis, new Object[0]);
        return true;
    }
}
