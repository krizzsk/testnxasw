package com.didi.beatles.p101im.access.notify;

import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.access.notify.IMFloatWindowController */
public final class IMFloatWindowController {

    /* renamed from: a */
    private static final String f10606a = IMFloatWindowController.class.getSimpleName();
    public static boolean mEnableFloatWindow = true;

    public static void setEnableFloatWindow(boolean z) {
        mEnableFloatWindow = z;
        String str = f10606a;
        IMLog.m10020d(str, "[setEnableFloatWindow] enable=" + z);
    }

    public static boolean isEnable() {
        return mEnableFloatWindow;
    }
}
