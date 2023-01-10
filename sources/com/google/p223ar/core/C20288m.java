package com.google.p223ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.google.ar.core.m */
/* compiled from: InstallActivity */
final class C20288m extends AnimatorListenerAdapter {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f56481a;

    C20288m(InstallActivity installActivity) {
        this.f56481a = installActivity;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f56481a.showSpinner();
    }
}
