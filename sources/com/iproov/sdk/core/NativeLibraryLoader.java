package com.iproov.sdk.core;

import com.iproov.sdk.logging.IPLog;

class NativeLibraryLoader {

    /* renamed from: a */
    static boolean f56928a = true;

    static {
        try {
            System.loadLibrary("native-lib");
        } catch (UnsatisfiedLinkError unused) {
            IPLog.m43494w("NativeLib", "Not loaded");
        }
    }

    NativeLibraryLoader() {
    }

    public native int performance();

    public native int suNativeCheck(String[] strArr);
}
