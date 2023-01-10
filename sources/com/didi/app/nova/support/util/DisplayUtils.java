package com.didi.app.nova.support.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.WindowManager;

public class DisplayUtils {

    /* renamed from: a */
    private static Integer f10381a;

    /* renamed from: b */
    private static Integer f10382b;

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dip2pxInFloat(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dipInFloat(Context context, float f) {
        return (f / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float sp2px(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        Integer num = f10381a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f10381a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f10382b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f10381a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f10382b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f10381a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f10382b = valueOf;
        return valueOf.intValue();
    }
}
