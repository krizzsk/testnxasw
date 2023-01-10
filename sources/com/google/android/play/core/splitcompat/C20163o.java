package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.o */
final class C20163o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Set f56186a;

    /* renamed from: b */
    final /* synthetic */ SplitCompat f56187b;

    C20163o(SplitCompat splitCompat, Set set) {
        this.f56187b = splitCompat;
        this.f56186a = set;
    }

    public final void run() {
        try {
            for (String f : this.f56186a) {
                this.f56187b.f56160b.mo164445f(f);
            }
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e, "com.google.android.play.core.splitcompat.o", -1);
        }
    }
}
