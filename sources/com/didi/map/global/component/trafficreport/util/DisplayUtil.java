package com.didi.map.global.component.trafficreport.util;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class DisplayUtil {
    public static int dp2px(Context context, float f) {
        if (context != null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static void showSoftInput(Context context, View view) {
        if (context != null) {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void hideSoftInput(Context context, View view) {
        if (context != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void toastShow(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SystemUtils.showToast(m22310a(context, str, -1, 0));
        }
    }

    public static void toastShow(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SystemUtils.showToast(m22310a(context, str, i, 0));
        }
    }

    public static void toastShow(Context context, String str, int i, int i2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SystemUtils.showToast(m22310a(context, str, i, i2));
        }
    }

    /* renamed from: a */
    private static Toast m22310a(Context context, String str, int i, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_toast_view, (ViewGroup) null);
        if (i > -1) {
            ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(i);
        } else {
            inflate.findViewById(R.id.ll_icon_root).setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int height = windowManager != null ? windowManager.getDefaultDisplay().getHeight() : 0;
        textView.setText(str);
        textView.setContentDescription(str);
        Toast toast = new Toast(context);
        toast.setDuration(i2);
        toast.setView(inflate);
        toast.setGravity(80, 0, height / 8);
        return toast;
    }

    public static String convertText(int i) {
        if (i <= 0) {
            return "0";
        }
        if (i <= 999) {
            return String.valueOf(i);
        }
        if (i > 99000) {
            return "99K";
        }
        return (i / 1000) + "K";
    }

    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static ObjectAnimator getEnterTranslationX(Context context) {
        if (context == null) {
            return null;
        }
        Point point = new Point();
        getWindowManager(context).getDefaultDisplay().getSize(point);
        int i = point.x;
        int i2 = point.y;
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("translationX");
        objectAnimator.setFloatValues(new float[]{(float) i, 0.0f});
        objectAnimator.setDuration(500);
        return objectAnimator;
    }

    public static ObjectAnimator getExitTranslationX(Context context) {
        if (context == null) {
            return null;
        }
        Point point = new Point();
        getWindowManager(context).getDefaultDisplay().getSize(point);
        int i = point.x;
        int i2 = point.y;
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("translationX");
        objectAnimator.setFloatValues(new float[]{0.0f, (float) i});
        objectAnimator.setDuration(500);
        return objectAnimator;
    }
}
