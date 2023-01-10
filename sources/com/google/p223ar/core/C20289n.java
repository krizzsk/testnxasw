package com.google.p223ar.core;

import android.animation.ValueAnimator;

/* renamed from: com.google.ar.core.n */
/* compiled from: InstallActivity */
final class C20289n implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private final /* synthetic */ int f56482a;

    /* renamed from: b */
    private final /* synthetic */ int f56483b;

    /* renamed from: c */
    private final /* synthetic */ int f56484c;

    /* renamed from: d */
    private final /* synthetic */ InstallActivity f56485d;

    C20289n(InstallActivity installActivity, int i, int i2, int i3) {
        this.f56485d = installActivity;
        this.f56482a = i;
        this.f56483b = i2;
        this.f56484c = i3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i = this.f56483b;
        this.f56485d.getWindow().setLayout((int) ((((float) this.f56482a) * animatedFraction) + (((float) i) * animatedFraction2)), (int) ((((float) this.f56484c) * animatedFraction) + (((float) i) * animatedFraction2)));
        this.f56485d.getWindow().getDecorView().refreshDrawableState();
    }
}
