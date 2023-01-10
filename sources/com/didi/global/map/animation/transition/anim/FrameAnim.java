package com.didi.global.map.animation.transition.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.util.LogUtil;
import java.util.List;

public class FrameAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24693a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f24694b;

    /* renamed from: c */
    private List<Circle> f24695c;

    /* renamed from: d */
    private ValueAnimator f24696d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int[] f24697e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f24698f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f24699g;

    /* renamed from: h */
    private boolean f24700h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnFrameAnimEndCallback f24701i;

    /* renamed from: j */
    private RippleCircle f24702j;

    /* renamed from: k */
    private RippleAnimParam f24703k;

    /* renamed from: l */
    private int f24704l = 100;

    public FrameAnim(Context context, Marker marker, List<Circle> list, RippleAnimParam rippleAnimParam) {
        this.f24693a = context;
        this.f24694b = marker;
        this.f24703k = rippleAnimParam;
        this.f24695c = list;
    }

    public FrameAnim(Context context, Marker marker) {
        this.f24693a = context;
        this.f24694b = marker;
    }

    public void setFrames(int[] iArr) {
        this.f24697e = iArr;
        this.f24698f = iArr != null ? iArr.length : 0;
    }

    public void setFrameIntervalTimeMillis(int i) {
        this.f24704l = i;
    }

    public void setInfinite(boolean z) {
        this.f24700h = z;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f24696d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doFrameAnim(boolean z) {
        if (this.f24697e == null || this.f24698f <= 0) {
            LogUtil.m19846e("FrameAnim doFrameAnim() mFrames == null || mFramesCount <= 0");
        } else if (z || this.f24696d != null) {
            if (this.f24696d == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f24698f});
                this.f24696d = ofInt;
                ofInt.setInterpolator(new LinearInterpolator());
                if (this.f24700h) {
                    this.f24696d.setRepeatMode(1);
                    this.f24696d.setRepeatCount(-1);
                }
                this.f24696d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num = (Integer) valueAnimator.getAnimatedValue();
                        if (num != null && FrameAnim.this.f24694b != null && FrameAnim.this.f24697e != null && num.intValue() != FrameAnim.this.f24699g && num.intValue() < FrameAnim.this.f24698f) {
                            int unused = FrameAnim.this.f24699g = num.intValue();
                            FrameAnim.this.f24694b.setIcon(FrameAnim.this.f24693a, BitmapDescriptorFactory.fromResource(FrameAnim.this.f24693a, FrameAnim.this.f24697e[num.intValue()]));
                        }
                    }
                });
                this.f24696d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (FrameAnim.this.f24701i != null) {
                            FrameAnim.this.f24701i.onFrameAnimEnd();
                        }
                    }
                });
            }
            if (z) {
                if (!this.f24696d.isRunning()) {
                    this.f24696d.setDuration((long) (this.f24704l * this.f24698f));
                    this.f24696d.start();
                }
            } else if (this.f24696d.isRunning()) {
                this.f24696d.end();
            }
        } else {
            LogUtil.m19846e("FrameAnim doFrameAnim() anim = false && mAnimator = null)");
            OnFrameAnimEndCallback onFrameAnimEndCallback = this.f24701i;
            if (onFrameAnimEndCallback != null) {
                onFrameAnimEndCallback.onFrameAnimEnd();
            }
        }
    }

    public void doRippleAnim(boolean z) {
        if (z) {
            if (this.f24702j == null) {
                this.f24702j = new RippleCircle(this.f24695c, this.f24694b, this.f24703k);
            }
            this.f24702j.show();
            return;
        }
        RippleCircle rippleCircle = this.f24702j;
        if (rippleCircle != null) {
            rippleCircle.hide();
        }
    }

    public void setOnFrameAnimEndCallback(OnFrameAnimEndCallback onFrameAnimEndCallback) {
        this.f24701i = onFrameAnimEndCallback;
    }

    public void destory() {
        if (this.f24696d != null) {
            doFrameAnim(false);
            doRippleAnim(false);
            this.f24696d.removeAllUpdateListeners();
            this.f24696d.removeAllListeners();
            this.f24696d = null;
        }
        this.f24701i = null;
        this.f24697e = null;
        this.f24698f = 0;
        this.f24699g = 0;
        this.f24700h = true;
    }
}
