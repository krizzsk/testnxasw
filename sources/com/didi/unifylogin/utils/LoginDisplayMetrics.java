package com.didi.unifylogin.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class LoginDisplayMetrics {

    /* renamed from: a */
    private static final String f47585a = "LoginDisplayMetrics";

    /* renamed from: b */
    private static int f47586b;

    /* renamed from: c */
    private static float f47587c;

    public static int getWidth(Context context) {
        int i = f47586b;
        if (i > 0) {
            return i;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        LoginLog.write("LoginDisplayMetrics getWidthPixels:" + displayMetrics.widthPixels);
        return displayMetrics.widthPixels;
    }

    public static void setWidth(int i) {
        f47586b = i;
    }

    public static float getDensity(Context context) {
        if (f47587c <= 0.0f) {
            f47587c = context.getResources().getDisplayMetrics().density;
        }
        return f47587c;
    }
}
