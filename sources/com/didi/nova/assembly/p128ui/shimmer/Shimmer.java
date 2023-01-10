package com.didi.nova.assembly.p128ui.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.didi.nova.assembly.p128ui.shimmer.ShimmerViewHelper;

/* renamed from: com.didi.nova.assembly.ui.shimmer.Shimmer */
public class Shimmer {
    public static final int ANIMATION_DIRECTION_LTR = 0;
    public static final int ANIMATION_DIRECTION_RTL = 1;

    /* renamed from: a */
    private static final int f31753a = -1;

    /* renamed from: b */
    private static final long f31754b = 1000;

    /* renamed from: c */
    private static final long f31755c = 0;

    /* renamed from: d */
    private static final int f31756d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f31757e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f31758f = 1000;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f31759g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f31760h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Animator.AnimatorListener f31761i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ObjectAnimator f31762j;

    public int getRepeatCount() {
        return this.f31757e;
    }

    public Shimmer setRepeatCount(int i) {
        this.f31757e = i;
        return this;
    }

    public long getDuration() {
        return this.f31758f;
    }

    public Shimmer setDuration(long j) {
        this.f31758f = j;
        return this;
    }

    public long getStartDelay() {
        return this.f31759g;
    }

    public Shimmer setStartDelay(long j) {
        this.f31759g = j;
        return this;
    }

    public int getDirection() {
        return this.f31760h;
    }

    public Shimmer setDirection(int i) {
        if (i == 0 || i == 1) {
            this.f31760h = i;
            return this;
        }
        throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
    }

    public Animator.AnimatorListener getAnimatorListener() {
        return this.f31761i;
    }

    public Shimmer setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f31761i = animatorListener;
        return this;
    }

    public <V extends View & ShimmerViewBase> void start(final V v) {
        if (!isAnimating()) {
            final C111001 r0 = new Runnable() {
                public void run() {
                    ((ShimmerViewBase) v).setShimmering(true);
                    float width = (float) v.getWidth();
                    float f = 0.0f;
                    if (Shimmer.this.f31760h == 1) {
                        f = (float) v.getWidth();
                        width = 0.0f;
                    }
                    ObjectAnimator unused = Shimmer.this.f31762j = ObjectAnimator.ofFloat(v, "gradientX", new float[]{f, width});
                    Shimmer.this.f31762j.setRepeatCount(Shimmer.this.f31757e);
                    Shimmer.this.f31762j.setDuration(Shimmer.this.f31758f);
                    Shimmer.this.f31762j.setStartDelay(Shimmer.this.f31759g);
                    Shimmer.this.f31762j.addListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            ((ShimmerViewBase) v).setShimmering(false);
                            v.postInvalidateOnAnimation();
                            ObjectAnimator unused = Shimmer.this.f31762j = null;
                        }
                    });
                    if (Shimmer.this.f31761i != null) {
                        Shimmer.this.f31762j.addListener(Shimmer.this.f31761i);
                    }
                    Shimmer.this.f31762j.start();
                }
            };
            ShimmerViewBase shimmerViewBase = (ShimmerViewBase) v;
            if (!shimmerViewBase.isSetUp()) {
                shimmerViewBase.setAnimationSetupCallback(new ShimmerViewHelper.AnimationSetupCallback() {
                    public void onSetupAnimation(View view) {
                        r0.run();
                    }
                });
            } else {
                r0.run();
            }
        }
    }

    public void cancel() {
        ObjectAnimator objectAnimator = this.f31762j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public boolean isAnimating() {
        ObjectAnimator objectAnimator = this.f31762j;
        return objectAnimator != null && objectAnimator.isRunning();
    }
}
