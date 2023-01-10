package com.didi.global.map.animation.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.util.LogUtil;
import java.util.List;

public class FrameAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24626a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f24627b;

    /* renamed from: c */
    private List<Circle> f24628c;

    /* renamed from: d */
    private ValueAnimator f24629d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int[] f24630e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f24631f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f24632g;

    /* renamed from: h */
    private boolean f24633h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnFrameAnimEndCallback f24634i;

    /* renamed from: j */
    private RippleCircle f24635j;

    /* renamed from: k */
    private RippleAnimParam f24636k;

    /* renamed from: l */
    private int f24637l = 100;

    public FrameAnim(Context context, Marker marker, List<Circle> list, RippleAnimParam rippleAnimParam) {
        this.f24626a = context;
        this.f24627b = marker;
        this.f24636k = rippleAnimParam;
        this.f24628c = list;
    }

    public FrameAnim(Context context, Marker marker) {
        this.f24626a = context;
        this.f24627b = marker;
    }

    public void setFrames(int[] iArr) {
        this.f24630e = iArr;
        this.f24631f = iArr != null ? iArr.length : 0;
    }

    public void setFrameIntervalTimeMillis(int i) {
        this.f24637l = i;
    }

    public void setInfinite(boolean z) {
        this.f24633h = z;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f24629d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doFrameAnim(boolean z) {
        if (this.f24630e == null || this.f24631f <= 0) {
            LogUtil.m19855e("FrameAnim doFrameAnim() mFrames == null || mFramesCount <= 0");
        } else if (z || this.f24629d != null) {
            if (this.f24629d == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f24631f});
                this.f24629d = ofInt;
                ofInt.setInterpolator(new LinearInterpolator());
                if (this.f24633h) {
                    this.f24629d.setRepeatMode(1);
                    this.f24629d.setRepeatCount(-1);
                }
                this.f24629d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num = (Integer) valueAnimator.getAnimatedValue();
                        if (num != null && FrameAnim.this.f24627b != null && FrameAnim.this.f24630e != null && num.intValue() != FrameAnim.this.f24632g && num.intValue() < FrameAnim.this.f24631f) {
                            int unused = FrameAnim.this.f24632g = num.intValue();
                            FrameAnim.this.f24627b.setIcon(FrameAnim.this.f24626a, BitmapDescriptorFactory.fromResource(FrameAnim.this.f24626a, FrameAnim.this.f24630e[num.intValue()]));
                        }
                    }
                });
                this.f24629d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (FrameAnim.this.f24634i != null) {
                            FrameAnim.this.f24634i.onFrameAnimEnd();
                        }
                    }
                });
            }
            if (z) {
                if (!this.f24629d.isRunning()) {
                    this.f24629d.setDuration((long) (this.f24637l * this.f24631f));
                    this.f24629d.start();
                }
            } else if (this.f24629d.isRunning()) {
                this.f24629d.end();
            }
        } else {
            LogUtil.m19855e("FrameAnim doFrameAnim() anim = false && mAnimator = null)");
            OnFrameAnimEndCallback onFrameAnimEndCallback = this.f24634i;
            if (onFrameAnimEndCallback != null) {
                onFrameAnimEndCallback.onFrameAnimEnd();
            }
        }
    }

    public void doRippleAnim(boolean z) {
        if (z) {
            if (this.f24635j == null) {
                this.f24635j = new RippleCircle(this.f24628c, this.f24627b, this.f24636k);
            }
            this.f24635j.show();
            return;
        }
        RippleCircle rippleCircle = this.f24635j;
        if (rippleCircle != null) {
            rippleCircle.hide();
        }
    }

    public void setOnFrameAnimEndCallback(OnFrameAnimEndCallback onFrameAnimEndCallback) {
        this.f24634i = onFrameAnimEndCallback;
    }

    public void destory() {
        if (this.f24629d != null) {
            doFrameAnim(false);
            doRippleAnim(false);
            this.f24629d.removeAllUpdateListeners();
            this.f24629d.removeAllListeners();
            this.f24629d = null;
        }
        this.f24634i = null;
        this.f24630e = null;
        this.f24631f = 0;
        this.f24632g = 0;
        this.f24633h = true;
    }
}
