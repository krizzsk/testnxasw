package com.didi.addressnew.framework.widget;

import android.animation.Animator;

/* renamed from: com.didi.addressnew.framework.widget.a */
/* compiled from: AnimationRepeater */
class C3851a implements Animator.AnimatorListener {

    /* renamed from: a */
    private boolean f9265a = false;

    /* renamed from: b */
    private C3852b f9266b;

    /* renamed from: c */
    private Integer[] f9267c;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    C3851a(C3852b bVar, Integer[] numArr) {
        this.f9266b = bVar;
        this.f9267c = numArr;
    }

    public void onAnimationRepeat(Animator animator) {
        if (this.f9265a) {
            this.f9266b.f9274g.setObjectValues(new Object[]{this.f9267c[this.f9266b.f9268a], this.f9267c[(this.f9266b.f9268a + 1) % this.f9267c.length]});
            this.f9266b.f9274g.start();
            this.f9265a = false;
            return;
        }
        this.f9265a = true;
    }
}
