package com.didi.globalsafetoolkit.util.statuslightning;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.didi.globalsafetoolkit.util.statuslightning.impl.FlyMeLightningCompatImpl;
import com.didi.globalsafetoolkit.util.statuslightning.impl.KitkatLightningCompatImpl;
import com.didi.globalsafetoolkit.util.statuslightning.impl.MIUILowerMLightningCompatImpl;
import com.didi.globalsafetoolkit.util.statuslightning.impl.MIUIMLightningCompatImpl;
import com.didi.globalsafetoolkit.util.statuslightning.impl.MLightningCompatImpl;
import com.didi.globalsafetoolkit.util.statuslightning.impl.NoneLightningCompatImpl;

public class StatusBarLightingCompat {

    /* renamed from: a */
    private static final ILightningCompat f25190a;

    /* renamed from: b */
    private static int[] m20158b(int i) {
        return new int[]{(16711680 & i) >> 16, (65280 & i) >> 8, i & 255};
    }

    static {
        if (C9574a.m20159a() && C9574a.m20162d()) {
            f25190a = new MIUIMLightningCompatImpl();
        } else if (C9574a.m20159a()) {
            f25190a = new MIUILowerMLightningCompatImpl();
        } else if (C9574a.m20161c()) {
            f25190a = new FlyMeLightningCompatImpl();
        } else if (C9574a.m20162d()) {
            f25190a = new MLightningCompatImpl();
        } else if (Build.VERSION.SDK_INT == 19) {
            f25190a = new KitkatLightningCompatImpl();
        } else {
            f25190a = new NoneLightningCompatImpl();
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z) {
        if (activity != null) {
            f25190a.setLightStatusBar(activity, z);
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
            f25190a.setLightStatusBar(activity, m20157a(i));
        }
    }

    /* renamed from: a */
    private static boolean m20157a(int i) {
        int[] b = m20158b(i);
        if (((int) ((((double) b[0]) * 0.299d) + (((double) b[1]) * 0.587d) + (((double) b[2]) * 0.114d))) >= 192) {
            return true;
        }
        return false;
    }
}
