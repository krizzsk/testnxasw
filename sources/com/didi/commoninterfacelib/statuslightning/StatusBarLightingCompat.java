package com.didi.commoninterfacelib.statuslightning;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.didi.commoninterfacelib.statuslightning.impl.FlyMeLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MIUILowerMLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MIUIMLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;
import com.taxis99.R;

public class StatusBarLightingCompat {

    /* renamed from: b */
    private static final ILightningCompat f12798b;

    /* renamed from: c */
    private static ILightnightLogging f12799c;

    /* renamed from: d */
    private static boolean f12800d;

    /* renamed from: e */
    private static int f12801e;

    /* renamed from: a */
    private final String f12802a = "statusLightCompat";

    /* renamed from: b */
    private static int[] m10796b(int i) {
        return new int[]{(16711680 & i) >> 16, (65280 & i) >> 8, i & 255};
    }

    public static boolean getLightStatusBar() {
        return f12800d;
    }

    public static int getStatusBarColor() {
        return f12801e;
    }

    static {
        if (C5073a.m10797a() && C5073a.m10800d()) {
            f12798b = new MIUIMLightningCompatImpl();
        } else if (C5073a.m10797a()) {
            f12798b = new MIUILowerMLightningCompatImpl();
        } else if (C5073a.m10799c()) {
            f12798b = new FlyMeLightningCompatImpl();
        } else if (C5073a.m10800d()) {
            f12798b = new MLightningCompatImpl();
        } else {
            f12798b = new NoneLightningCompatImpl();
        }
    }

    /* renamed from: a */
    private static void m10794a(String str, String str2) {
        if (getLightningLogging() != null) {
            getLightningLogging().log(str, str2);
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z) {
        if (activity != null) {
            f12798b.setLightStatusBar(activity, z);
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z, int i) {
        String name = getImpl() != null ? getImpl().getClass().getName() : null;
        m10794a("", name + ":Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT + "  Build.VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL + " activity=" + activity);
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                f12800d = z;
                f12801e = i;
                if (f12798b instanceof NoneLightningCompatImpl) {
                    activity.setTheme(R.style.GlobalActivity50);
                } else {
                    setStatusBarColor(activity, i);
                }
                f12798b.setLightStatusBar(activity, z);
                return;
            }
            setStatusBarColor(activity, i);
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
            return;
        }
        Window window2 = activity.getWindow();
        window2.clearFlags(View.STATUS_BAR_TRANSIENT);
        window2.getDecorView().setSystemUiVisibility(256);
    }

    public static void setStatusBarBgLightning(Activity activity, int i) {
        if (activity != null) {
            f12798b.setLightStatusBar(activity, m10795a(i));
        }
    }

    /* renamed from: a */
    private static boolean m10795a(int i) {
        int[] b = m10796b(i);
        if (((int) ((((double) b[0]) * 0.299d) + (((double) b[1]) * 0.587d) + (((double) b[2]) * 0.114d))) >= 192) {
            return true;
        }
        return false;
    }

    public static ILightningCompat getImpl() {
        return f12798b;
    }

    public static void setLightningLogging(ILightnightLogging iLightnightLogging) {
        f12799c = iLightnightLogging;
    }

    public static ILightnightLogging getLightningLogging() {
        return f12799c;
    }
}
