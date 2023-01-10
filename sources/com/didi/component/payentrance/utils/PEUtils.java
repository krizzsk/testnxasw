package com.didi.component.payentrance.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import java.text.DecimalFormat;
import java.util.Arrays;

public class PEUtils {

    /* renamed from: a */
    private static Integer f16807a;

    /* renamed from: b */
    private static Integer f16808b;

    /* renamed from: c */
    private static Float f16809c;

    /* renamed from: d */
    private static Integer f16810d;

    public static int getScreenWidth(Context context) {
        Integer num = f16807a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f16807a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f16808b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f16807a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f16808b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f16807a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f16808b = valueOf;
        return valueOf.intValue();
    }

    /* renamed from: a */
    private static float m14161a(Context context) {
        if (f16809c == null) {
            f16809c = Float.valueOf(context.getResources().getDisplayMetrics().density);
        }
        return f16809c.floatValue();
    }

    public static float dip2px(Context context, float f) {
        return f * m14161a(context);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) (((double) (f * m14161a(context))) + 0.5d);
    }

    public static int getStatusbarHeight(Context context) {
        Integer num = f16810d;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            f16810d = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            f16810d = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(dip2pxInt(context, 25.0f));
            f16810d = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            SystemUtils.log(4, str, "invoke stack trace", new Throwable(), "com.didi.component.payentrance.utils.PEUtils", 135);
            m14162a(str, view, new StringBuilder(), new int[2]);
        }
    }

    /* renamed from: a */
    private static void m14162a(String str, View view, StringBuilder sb, int[] iArr) {
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
        SystemUtils.log(4, str, sb.toString(), (Throwable) null, "com.didi.component.payentrance.utils.PEUtils", 167);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m14162a(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }

    public static void setEditTextHint(EditText editText, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    public static String format(long j) {
        return format(String.valueOf(((double) j) / 100.0d));
    }

    public static String format(double d) {
        return format(String.valueOf(d));
    }

    public static String format(String str) {
        if (TextUtil.isEmpty(str)) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format((double) Float.valueOf(str).floatValue());
    }

    public static void closeInputMethod(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }
}
