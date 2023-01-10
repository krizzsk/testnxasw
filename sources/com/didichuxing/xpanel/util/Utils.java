package com.didichuxing.xpanel.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    /* renamed from: a */
    private static long f52157a = 0;

    /* renamed from: b */
    private static long f52158b = 400;

    /* renamed from: c */
    private static SimpleDateFormat f52159c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f52157a;
        if (0 < j && j < f52158b) {
            return true;
        }
        f52157a = currentTimeMillis;
        return false;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String formatDate(Date date) {
        return f52159c.format(date);
    }

    public static int getVisibility(String str) {
        return TextUtils.isEmpty(str) ? 8 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        return obj2 == null;
    }

    public static boolean isDebug(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null || (applicationInfo = context.getApplicationContext().getApplicationInfo()) == null || (applicationInfo.flags & 2) == 0) {
            return false;
        }
        return true;
    }
}
