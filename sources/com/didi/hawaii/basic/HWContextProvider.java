package com.didi.hawaii.basic;

import android.content.Context;

public final class HWContextProvider {

    /* renamed from: a */
    private static Context f25696a;

    private HWContextProvider() {
    }

    public static synchronized void setContextIfNecessary(Context context) {
        synchronized (HWContextProvider.class) {
            if (context != null) {
                if (f25696a == null) {
                    f25696a = context.getApplicationContext();
                }
            }
        }
    }

    public static synchronized Context getContext() {
        Context context;
        synchronized (HWContextProvider.class) {
            context = f25696a;
        }
        return context;
    }
}
