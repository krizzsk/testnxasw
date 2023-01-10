package com.didi.dimina.container.util;

import android.os.Handler;
import android.os.Looper;
import com.didi.dimina.container.DMMina;

public class UIHandlerUtil {

    /* renamed from: a */
    private static final Handler f19843a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f19843a;
    }

    public static void postDelayed(Runnable runnable, long j) {
        f19843a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f19843a.post(runnable);
    }

    public static void safePost(DMMina dMMina, Runnable runnable) {
        if (dMMina != null) {
            f19843a.post(new Runnable(runnable) {
                public final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    UIHandlerUtil.m16866a(DMMina.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m16866a(DMMina dMMina, Runnable runnable) {
        if (!dMMina.isRelease()) {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f19843a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void removeCallbacks(Runnable runnable) {
        f19843a.removeCallbacks(runnable);
    }
}
