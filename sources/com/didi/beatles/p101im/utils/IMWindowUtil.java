package com.didi.beatles.p101im.utils;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.utils.IMWindowUtil */
public class IMWindowUtil {

    /* renamed from: a */
    private static final int f11635a = 24;

    /* renamed from: b */
    private static int f11636b = 0;

    /* renamed from: c */
    private static int f11637c = 0;

    /* renamed from: d */
    private static float f11638d = 1.0f;

    /* renamed from: e */
    private static int f11639e = 0;

    /* renamed from: f */
    private static boolean f11640f = false;

    /* renamed from: a */
    private static void m10039a() {
        WindowManager windowManager;
        if (!f11640f && IMContextInfoHelper.getContext() != null) {
            f11640f = true;
            if (Build.VERSION.SDK_INT < 17 || (windowManager = (WindowManager) IMContextInfoHelper.getContext().getSystemService("window")) == null) {
                DisplayMetrics displayMetrics = IMContextInfoHelper.getContext().getResources().getDisplayMetrics();
                f11636b = displayMetrics.widthPixels;
                f11637c = displayMetrics.heightPixels;
                f11638d = displayMetrics.density;
                return;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics2);
            f11636b = displayMetrics2.widthPixels;
            f11637c = displayMetrics2.heightPixels;
            f11638d = displayMetrics2.density;
        }
    }

    public static int px2dip(float f) {
        m10039a();
        return (int) ((f / f11638d) + 0.5f);
    }

    public static int dip2px(float f) {
        m10039a();
        return (int) ((f * f11638d) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / IMContextInfoHelper.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * IMContextInfoHelper.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int getScreenWidth() {
        m10039a();
        return f11636b;
    }

    public static int getScreenHeight() {
        m10039a();
        return f11637c;
    }

    public static float getScale() {
        m10039a();
        return f11638d;
    }

    public static int getStatusBarHeight() {
        int i = f11639e;
        if (i != 0) {
            return i;
        }
        Context context = IMCommonContextInfoHelper.getContext();
        boolean z = false;
        if (context == null) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            f11639e = context.getResources().getDimensionPixelSize(IMParseUtil.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            z = true;
        }
        if (z || f11639e <= 0) {
            f11639e = IMViewUtil.dp2px(context, 24.0f);
        }
        return f11639e;
    }
}
