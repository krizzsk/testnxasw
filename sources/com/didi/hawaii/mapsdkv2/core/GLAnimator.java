package com.didi.hawaii.mapsdkv2.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

public class GLAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: d */
    private static final int f26080d = 16;

    /* renamed from: a */
    private long f26081a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ValueAnimator.AnimatorUpdateListener f26082b;

    /* renamed from: c */
    private int f26083c = 16;

    public GLAnimator() {
        addListener(new AnimatorListener());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo75552a(int i) {
        this.f26083c = i * 16;
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        super.addUpdateListener(this);
        this.f26082b = animatorUpdateListener;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f26082b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f26081a >= ((long) this.f26083c)) {
                this.f26082b.onAnimationUpdate(valueAnimator);
                this.f26081a = currentTimeMillis;
            }
        }
    }

    private class AnimatorListener extends AnimatorListenerAdapter {
        private AnimatorListener() {
        }

        public void onAnimationEnd(Animator animator) {
            if (GLAnimator.this.f26082b != null) {
                GLAnimator.this.f26082b.onAnimationUpdate(GLAnimator.this);
            }
        }
    }
}
