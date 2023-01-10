package com.facebook.jni;

import com.facebook.soloader.SoLoader;

public class HybridData {
    private long mNativePointer = 0;

    public native void resetNative();

    static {
        SoLoader.loadLibrary("fb");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        resetNative();
        super.finalize();
    }

    public boolean isValid() {
        return this.mNativePointer != 0;
    }
}
