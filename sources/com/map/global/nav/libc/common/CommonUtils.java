package com.map.global.nav.libc.common;

import android.content.Context;

public class CommonUtils {

    /* renamed from: a */
    private static Context f58545a;

    public static void setContext(Context context) {
        f58545a = context.getApplicationContext();
    }

    public static int dp2pixel(int i) {
        float f;
        Context context = f58545a;
        if (context != null) {
            f = ((float) i) * context.getResources().getDisplayMetrics().density;
        } else {
            f = (float) (i * 2);
        }
        return (int) (f + 0.5f);
    }

    public static int getScreenWidth() {
        Context context = f58545a;
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public static int getScreenHeight() {
        Context context = f58545a;
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }
}
