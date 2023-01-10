package com.didi.beatles.p101im;

import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.IMEnvironment */
public final class IMEnvironment {

    /* renamed from: a */
    private static volatile boolean f10536a = false;

    public static void setInitStatus(boolean z) {
        f10536a = z;
        IMLog.m10020d("IMEnvironment", "[setInitStatus] -> " + z);
    }

    public static boolean isInit() {
        return f10536a;
    }
}
