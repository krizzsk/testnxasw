package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

/* renamed from: com.didi.unifiedPay.component.widget.loading.g */
/* compiled from: Utils */
class C15297g {
    private C15297g() {
    }

    /* renamed from: a */
    static void m35134a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    /* renamed from: a */
    static void m35139a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least 1 color");
        }
    }

    /* renamed from: a */
    static void m35136a(int i) {
        if (i < 0 || i > 360) {
            throw new IllegalArgumentException(String.format("Illegal angle %d: must be >=0 and <=360", new Object[]{Integer.valueOf(i)}));
        }
    }

    /* renamed from: a */
    static void m35135a(float f, String str) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format("%s %f must be positive", new Object[]{str, Float.valueOf(f)}));
        }
    }

    /* renamed from: a */
    static void m35137a(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("%s must not be null", new Object[]{str}));
        }
    }

    /* renamed from: a */
    static void m35138a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("%s must be not null", new Object[]{str}));
        }
    }

    /* renamed from: a */
    static float m35132a(ValueAnimator valueAnimator) {
        long duration = valueAnimator.getDuration();
        return valueAnimator.getInterpolator().getInterpolation(Math.min(duration > 0 ? ((float) valueAnimator.getCurrentPlayTime()) / ((float) duration) : 0.0f, 1.0f));
    }

    /* renamed from: a */
    public static boolean m35140a(PowerManager powerManager) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            return powerManager.isPowerSaveMode();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static PowerManager m35133a(Context context) {
        return (PowerManager) context.getSystemService("power");
    }
}
