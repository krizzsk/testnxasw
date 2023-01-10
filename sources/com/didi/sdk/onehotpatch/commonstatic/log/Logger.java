package com.didi.sdk.onehotpatch.commonstatic.log;

import com.didi.dynamic.manager.utils.Log;

public class Logger {
    private static final String TAG = "DM.didi_hotpatch";

    public static void log(String str, Object... objArr) {
        if (str == null) {
            return;
        }
        if (objArr == null || objArr.length == 0) {
            Log.m17923d(TAG, str);
        } else {
            Log.m17923d(TAG, String.format(str, objArr));
        }
    }

    public static void info(String str, Object... objArr) {
        if (str == null) {
            return;
        }
        if (objArr == null || objArr.length == 0) {
            Log.m17927i(TAG, str);
        } else {
            Log.m17927i(TAG, String.format(str, objArr));
        }
    }

    public static void warn(Throwable th) {
        if (th != null) {
            Log.m17933w(TAG, th);
        }
    }

    public static void dex2oatInfo(String str) {
        Log.m17931w("dex2oat", str);
    }
}
