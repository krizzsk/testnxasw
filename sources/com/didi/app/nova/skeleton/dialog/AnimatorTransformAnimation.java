package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;

public abstract class AnimatorTransformAnimation extends TransformAnimation {
    public static final int DEFAULT_ANIMATION_DURATION = -1;

    /* renamed from: b */
    private int f10252b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f10253c = false;

    /* renamed from: d */
    private boolean f10254d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10255e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Animator f10256f;

    /* renamed from: g */
    private OnAnimationReadyOrAbortedListener f10257g;

    public abstract Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z);

    public abstract void resetFromView(View view);

    public AnimatorTransformAnimation() {
        super(true);
    }

    public AnimatorTransformAnimation(int i, boolean z) {
        super(z);
        this.f10252b = i;
    }

    public void onAbortPush() {
        this.f10253c = true;
        Animator animator = this.f10256f;
        if (animator != null) {
            animator.cancel();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f10257g;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public void completeAnimationImmediately() {
        this.f10255e = true;
        Animator animator = this.f10256f;
        if (animator != null) {
            animator.end();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f10257g;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public int getAnimationDuration() {
        return this.f10252b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performChange(android.view.ViewGroup r11, android.view.View r12, android.view.View r13, boolean r14, com.didi.app.nova.skeleton.dialog.TransformAnimation.TransformAnimationListener r15) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r13 == 0) goto L_0x000c
            android.view.ViewParent r2 = r13.getParent()
            if (r2 != 0) goto L_0x000c
            r2 = 1
            goto L_0x000d
        L_0x000c:
            r2 = 0
        L_0x000d:
            if (r2 == 0) goto L_0x0049
            if (r14 != 0) goto L_0x0022
            if (r12 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            android.view.ViewParent r2 = r13.getParent()
            if (r2 != 0) goto L_0x0025
            int r2 = r11.indexOfChild(r12)
            r11.addView(r13, r2)
            goto L_0x0025
        L_0x0022:
            r11.addView(r13)
        L_0x0025:
            int r2 = r13.getWidth()
            if (r2 > 0) goto L_0x0049
            int r2 = r13.getHeight()
            if (r2 > 0) goto L_0x0049
            com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener r1 = new com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener
            r3 = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            r3.<init>(r5, r6, r7, r8, r9)
            r10.f10257g = r1
            android.view.ViewTreeObserver r1 = r13.getViewTreeObserver()
            com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener r2 = r10.f10257g
            r1.addOnPreDrawListener(r2)
            goto L_0x004a
        L_0x0049:
            r0 = 1
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r10.m8998a(r11, r12, r13, r14, r15)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation.performChange(android.view.ViewGroup, android.view.View, android.view.View, boolean, com.didi.app.nova.skeleton.dialog.TransformAnimation$TransformAnimationListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9001a(TransformAnimation.TransformAnimationListener transformAnimationListener, Animator.AnimatorListener animatorListener) {
        if (!this.f10254d) {
            this.f10254d = true;
            transformAnimationListener.onAnimationCompleted();
        }
        Animator animator = this.f10256f;
        if (animator != null) {
            if (animatorListener != null) {
                animator.removeListener(animatorListener);
            }
            this.f10256f.cancel();
            this.f10256f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8998a(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimation.TransformAnimationListener transformAnimationListener) {
        if (this.f10253c) {
            m9001a(transformAnimationListener, (Animator.AnimatorListener) null);
        } else if (this.f10255e) {
            if (view != null && (!z || removeFromViewOnEnter())) {
                viewGroup.removeView(view);
            }
            m9001a(transformAnimationListener, (Animator.AnimatorListener) null);
            if (z && view != null) {
                resetFromView(view);
            }
        } else {
            Animator animator = getAnimator(viewGroup, view, view2, z);
            this.f10256f = animator;
            int i = this.f10252b;
            if (i > 0) {
                animator.setDuration((long) i);
            }
            final View view3 = view;
            final boolean z2 = z;
            final ViewGroup viewGroup2 = viewGroup;
            final TransformAnimation.TransformAnimationListener transformAnimationListener2 = transformAnimationListener;
            this.f10256f.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (view3 != null && ((!z2 || AnimatorTransformAnimation.this.removeFromViewOnEnter()) && AnimatorTransformAnimation.this.f10255e)) {
                        viewGroup2.removeView(view3);
                    }
                    AnimatorTransformAnimation.this.m9001a(transformAnimationListener2, this);
                }

                public void onAnimationEnd(Animator animator) {
                    View view;
                    if (!AnimatorTransformAnimation.this.f10253c && AnimatorTransformAnimation.this.f10256f != null) {
                        if (view3 != null && (!z2 || AnimatorTransformAnimation.this.removeFromViewOnEnter())) {
                            viewGroup2.removeView(view3);
                        }
                        AnimatorTransformAnimation.this.m9001a(transformAnimationListener2, this);
                        if (z2 && (view = view3) != null) {
                            AnimatorTransformAnimation.this.resetFromView(view);
                        }
                    }
                }
            });
            this.f10256f.start();
        }
    }

    private class OnAnimationReadyOrAbortedListener implements ViewTreeObserver.OnPreDrawListener {
        final TransformAnimation.TransformAnimationListener changeListener;
        final ViewGroup container;
        final View from;
        private boolean hasRun;
        final boolean isPush;

        /* renamed from: to */
        final View f10258to;

        OnAnimationReadyOrAbortedListener(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimation.TransformAnimationListener transformAnimationListener) {
            this.container = viewGroup;
            this.from = view;
            this.f10258to = view2;
            this.isPush = z;
            this.changeListener = transformAnimationListener;
        }

        public boolean onPreDraw() {
            onReadyOrAborted();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void onReadyOrAborted() {
            if (!this.hasRun) {
                this.hasRun = true;
                View view = this.f10258to;
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                }
                AnimatorTransformAnimation.this.m8998a(this.container, this.from, this.f10258to, this.isPush, this.changeListener);
            }
        }
    }
}
