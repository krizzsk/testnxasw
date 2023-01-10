package com.didi.sdk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import java.lang.reflect.Field;

public class GlobalScreenFitHelper {

    /* renamed from: a */
    private static final String f40331a = "GlobalScreenFitHelper";

    /* renamed from: b */
    private static final int f40332b = 375;

    /* renamed from: c */
    private static float f40333c;

    /* renamed from: d */
    private static float f40334d;

    /* renamed from: e */
    private static boolean f40335e;

    /* renamed from: f */
    private static boolean f40336f;

    public static void startFitWholeApp(Context context) {
        if (!Apollo.getToggle("global_fit_screen", true).allow()) {
            SystemUtils.log(3, f40331a, "屏幕适配开关close ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 53);
        } else if (!m30364b(context)) {
            SystemUtils.log(3, f40331a, "not reset pad ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 57);
        } else {
            SystemUtils.log(3, f40331a, "屏幕适配开关open ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 60);
            if (!f40336f) {
                startFitSingleContext(context);
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivityPaused(Activity activity) {
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityStopped(Activity activity) {
                    }

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        SystemUtils.log(3, GlobalScreenFitHelper.f40331a, "resetActivityDensity: " + activity.getComponentName(), (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper$1", 68);
                        GlobalScreenFitHelper.m30363b(activity);
                    }

                    public void onActivityResumed(Activity activity) {
                        GlobalScreenFitHelper.m30363b(activity);
                    }
                });
                f40336f = true;
            }
        }
    }

    public static void startFitSingleContext(Context context) {
        if (context != null && m30364b(context)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (f40334d == 0.0f) {
                f40333c = displayMetrics.density;
                f40334d = m30360a(context);
            }
            SystemUtils.log(3, f40331a, "startFit: sDefaultDensity = " + displayMetrics.density + " 修改后密度 = " + f40334d, (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 117);
            displayMetrics.density = f40334d;
            displayMetrics.scaledDensity = f40334d;
            displayMetrics.densityDpi = (int) (f40334d * 160.0f);
            if (!f40335e) {
                m30361a((int) (f40334d * 160.0f));
            }
            f40335e = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m30363b(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        displayMetrics.density = f40334d;
        displayMetrics.scaledDensity = f40334d;
        displayMetrics.densityDpi = (int) (f40334d * 160.0f);
    }

    @Deprecated
    public static void endFit(Context context) {
        if (context != null && f40333c != 0.0f && m30364b(context) && f40335e) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            displayMetrics.scaledDensity = f40333c;
            displayMetrics.density = f40333c;
            displayMetrics.densityDpi = (int) (f40333c * 160.0f);
            m30361a((int) (f40333c * 160.0f));
            f40335e = false;
            SystemUtils.log(3, f40331a, "endFit: 恢复默认屏幕密度 = " + f40333c, (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 151);
        }
    }

    /* renamed from: a */
    private static void m30361a(int i) {
        try {
            Field declaredField = Class.forName("android.graphics.Bitmap").getDeclaredField("sDefaultDensity");
            declaredField.setAccessible(true);
            declaredField.set((Object) null, Integer.valueOf(i));
            declaredField.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static float m30360a(Context context) {
        return ((float) context.getResources().getDisplayMetrics().widthPixels) / 375.0f;
    }

    /* renamed from: b */
    private static boolean m30364b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels < displayMetrics.heightPixels;
    }
}
