package com.didi.beatles.p101im.access.notify;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.beatles.p101im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.access.notify.NotiWindowManager */
public class NotiWindowManager {

    /* renamed from: a */
    private static WindowManager f10634a;

    /* renamed from: a */
    private static WindowManager m9259a() {
        if (f10634a == null) {
            f10634a = (WindowManager) IMContextInfoHelper.getContext().getSystemService("window");
        }
        return f10634a;
    }

    public static boolean addView(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m9259a().addView(view, layoutParams);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void removeView(View view) {
        try {
            m9259a().removeView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m9259a().updateViewLayout(view, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WindowManager.LayoutParams getBaseWindowLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 584;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        return layoutParams;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
