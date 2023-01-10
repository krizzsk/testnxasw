package com.didichuxing.xpanel.message;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didichuxing.xpanel.message.b */
/* compiled from: MessageAnimatorProxy */
abstract class C17375b implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    protected WeakReference<View> f52138a;

    /* renamed from: b */
    protected boolean f52139b = true;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    C17375b(View view) {
        this.f52138a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public void mo128189a(boolean z) {
        this.f52139b = z;
    }

    public void onAnimationEnd(Animator animator) {
        animator.removeAllListeners();
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).removeAllUpdateListeners();
        }
    }
}
