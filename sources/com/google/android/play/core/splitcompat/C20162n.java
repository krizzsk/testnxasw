package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.google.android.play.core.splitcompat.n */
final class C20162n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitCompat f56185a;

    C20162n(SplitCompat splitCompat) {
        this.f56185a = splitCompat;
    }

    public final void run() {
        try {
            this.f56185a.f56160b.mo164435a();
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Failed to cleanup splitcompat storage", e, "com.google.android.play.core.splitcompat.n", -1);
        }
    }
}
