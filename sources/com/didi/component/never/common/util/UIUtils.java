package com.didi.component.never.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import com.didi.sdk.apm.SystemUtils;
import java.util.Arrays;

public class UIUtils {

    /* renamed from: a */
    private static Integer f16478a;

    /* renamed from: b */
    private static Integer f16479b;

    /* renamed from: c */
    private static Float f16480c;

    /* renamed from: d */
    private static Integer f16481d;

    public static int getScreenWidth(Context context) {
        Integer num = f16478a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f16478a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f16479b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f16478a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f16479b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f16478a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f16479b = valueOf;
        return valueOf.intValue();
    }

    /* renamed from: a */
    private static float m13817a(Context context) {
        if (f16480c == null) {
            f16480c = Float.valueOf(context.getResources().getDisplayMetrics().density);
        }
        return f16480c.floatValue();
    }

    public static float dip2px(Context context, float f) {
        return f * m13817a(context);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) (((double) (f * m13817a(context))) + 0.5d);
    }

    public static int getStatusbarHeight(Context context) {
        Integer num = f16481d;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            f16481d = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            f16481d = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(dip2pxInt(context, 25.0f));
            f16481d = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            SystemUtils.log(4, str, "invoke stack trace", new Throwable(), "com.didi.component.never.common.util.UIUtils", 129);
            m13818a(str, view, new StringBuilder(), new int[2]);
        }
    }

    /* renamed from: a */
    private static void m13818a(String str, View view, StringBuilder sb, int[] iArr) {
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
        SystemUtils.log(4, str, sb.toString(), (Throwable) null, "com.didi.component.never.common.util.UIUtils", 161);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m13818a(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }

    public static void setEditTextHint(EditText editText, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }
}
