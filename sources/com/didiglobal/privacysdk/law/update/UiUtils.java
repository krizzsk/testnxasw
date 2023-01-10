package com.didiglobal.privacysdk.law.update;

import android.content.Context;
import android.view.WindowManager;

public class UiUtils {

    /* renamed from: a */
    private static Integer f53208a = null;

    /* renamed from: b */
    private static Integer f53209b = null;

    /* renamed from: c */
    private static Float f53210c = null;

    /* renamed from: d */
    private static Integer f53211d = null;

    /* renamed from: e */
    private static final String f53212e = "navigationBarBackground";

    public static int getScreenHeight(Context context) {
        Integer num = f53209b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f53208a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f53209b = valueOf;
        return valueOf.intValue();
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 60;
    }

    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
