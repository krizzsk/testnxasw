package com.didi.sdk.util;

import android.content.Context;
import com.taxis99.R;

public class ExitUtil {

    /* renamed from: a */
    private static long f40302a = 0;

    /* renamed from: b */
    private static final long f40303b = 3000;

    public static void doExit() {
    }

    public static boolean isValidExit(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f40302a <= 3000) {
            return true;
        }
        if (context != null) {
            ToastUtil.show(context, (int) R.string.exit_tip);
        }
        f40302a = currentTimeMillis;
        return false;
    }
}
