package com.didi.nova.assembly.components.bigimage.photoview;

import android.os.Build;
import android.view.View;

/* renamed from: com.didi.nova.assembly.components.bigimage.photoview.a */
/* compiled from: Compat */
class C11079a {

    /* renamed from: a */
    private static final int f31594a = 16;

    C11079a() {
    }

    /* renamed from: a */
    public static void m24155a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m24156b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* renamed from: b */
    private static void m24156b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
