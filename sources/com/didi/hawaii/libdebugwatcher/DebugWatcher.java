package com.didi.hawaii.libdebugwatcher;

import android.content.Context;

public final class DebugWatcher {

    /* renamed from: a */
    private static volatile DebugWatcher f25698a;

    public void install(Context context) {
    }

    public static DebugWatcher getInstance() {
        if (f25698a == null) {
            synchronized (DebugWatcher.class) {
                if (f25698a == null) {
                    f25698a = new DebugWatcher();
                }
            }
        }
        return f25698a;
    }

    private DebugWatcher() {
    }
}
