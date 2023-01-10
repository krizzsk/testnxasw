package com.didiglobal.mew.framework;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.sdk.apm.SystemUtils;
import java.util.Arrays;

public class MUIUtils {

    /* renamed from: a */
    private static Integer f52766a;

    /* renamed from: b */
    private static Integer f52767b;

    /* renamed from: c */
    private static Float f52768c;

    /* renamed from: d */
    private static Integer f52769d;

    public static int getScreenWidth(Context context) {
        if (f52766a == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            f52766a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
            f52767b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        }
        return f52766a.intValue();
    }

    public static int getScreenHeight(Context context) {
        if (f52767b == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            f52766a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
            f52767b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        }
        return f52767b.intValue();
    }

    /* renamed from: a */
    private static float m39618a(Context context) {
        if (f52768c == null) {
            f52768c = Float.valueOf(context.getResources().getDisplayMetrics().density);
        }
        return f52768c.floatValue();
    }

    public static float dip2px(Context context, float f) {
        return f * m39618a(context);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) (((double) (f * m39618a(context))) + 0.5d);
    }

    public static int getStatusBarHeight(Context context) {
        Integer num = f52769d;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            f52769d = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            f52769d = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(dip2pxInt(context, 25.0f));
            f52769d = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            SystemUtils.log(4, str, "invoke stack trace", new Throwable(), "com.didiglobal.mew.framework.MUIUtils", 78);
            m39619a(str, view, new StringBuilder(), new int[2]);
        }
    }

    /* renamed from: a */
    private static void m39619a(String str, View view, StringBuilder sb, int[] iArr) {
        sb.setLength(0);
        sb.append("view: ");
        sb.append(view);
        sb.append("\n");
        view.getLocationOnScreen(iArr);
        sb.append(", location on screen");
        sb.append(Arrays.toString(iArr));
        view.getLocationInWindow(iArr);
        sb.append(", location in window ");
        sb.append(Arrays.toString(iArr));
        sb.append(", visible: ");
        sb.append(view.getVisibility() == 0);
        sb.append(", visibility");
        sb.append(view.getVisibility());
        sb.append(", alpha: ");
        sb.append(view.getAlpha());
        sb.append(", translationX");
        sb.append(view.getTranslationX());
        sb.append(", translationY");
        sb.append(view.getTranslationY());
        sb.append(", scaleX");
        sb.append(view.getScaleX());
        sb.append(", scaleY");
        sb.append(view.getScaleY());
        sb.append(", width");
        sb.append(view.getWidth());
        sb.append(", height");
        sb.append(view.getHeight());
        sb.append("\n");
        SystemUtils.log(4, str, sb.toString(), (Throwable) null, "com.didiglobal.mew.framework.MUIUtils", 103);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m39619a(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }
}
