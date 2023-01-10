package com.didi.safetoolkit.util.statuslightning;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.didi.safetoolkit.util.statuslightning.impl.FlyMeLightningCompatImpl;
import com.didi.safetoolkit.util.statuslightning.impl.KitkatLightningCompatImpl;
import com.didi.safetoolkit.util.statuslightning.impl.MIUILowerMLightningCompatImpl;
import com.didi.safetoolkit.util.statuslightning.impl.MIUIMLightningCompatImpl;
import com.didi.safetoolkit.util.statuslightning.impl.MLightningCompatImpl;
import com.didi.safetoolkit.util.statuslightning.impl.NoneLightningCompatImpl;

public class StatusBarLightingCompat {

    /* renamed from: a */
    private static final ILightningCompat f37302a;

    /* renamed from: b */
    private static int[] m28144b(int i) {
        return new int[]{(16711680 & i) >> 16, (65280 & i) >> 8, i & 255};
    }

    static {
        if (C12607a.m28145a() && C12607a.m28148d()) {
            f37302a = new MIUIMLightningCompatImpl();
        } else if (C12607a.m28145a()) {
            f37302a = new MIUILowerMLightningCompatImpl();
        } else if (C12607a.m28147c()) {
            f37302a = new FlyMeLightningCompatImpl();
        } else if (C12607a.m28148d()) {
            f37302a = new MLightningCompatImpl();
        } else if (Build.VERSION.SDK_INT == 19) {
            f37302a = new KitkatLightningCompatImpl();
        } else {
            f37302a = new NoneLightningCompatImpl();
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z) {
        if (activity != null) {
            f37302a.setLightStatusBar(activity, z);
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    public static void setStatusBarBgLightning(Activity activity, int i) {
        if (activity != null) {
            f37302a.setLightStatusBar(activity, m28143a(i));
        }
    }

    /* renamed from: a */
    private static boolean m28143a(int i) {
        int[] b = m28144b(i);
        if (((int) ((((double) b[0]) * 0.299d) + (((double) b[1]) * 0.587d) + (((double) b[2]) * 0.114d))) >= 192) {
            return true;
        }
        return false;
    }
}
