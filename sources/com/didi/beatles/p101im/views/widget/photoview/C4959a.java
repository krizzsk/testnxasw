package com.didi.beatles.p101im.views.widget.photoview;

import android.os.Build;
import android.view.View;

/* renamed from: com.didi.beatles.im.views.widget.photoview.a */
/* compiled from: Compat */
class C4959a {

    /* renamed from: a */
    private static final int f12488a = 16;

    C4959a() {
    }

    /* renamed from: a */
    public static void m10650a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m10651b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* renamed from: b */
    private static void m10651b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
