package com.didi.global.map.animation.transition.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.AngleUtil;
import com.didi.global.map.animation.transition.util.LogUtil;
import com.didi.global.map.animation.transition.util.SphericalUtil;
import java.util.LinkedList;
import java.util.Queue;

public class TranslateAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24722a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f24723b;

    /* renamed from: c */
    private FrameAnim f24724c;

    /* renamed from: d */
    private ValueAnimator f24725d;

    /* renamed from: e */
    private long f24726e = 3000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<LatLng> f24727f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f24728g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LatLng f24729h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LatLng f24730i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f24731j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnTranslateAnimEndCallback f24732k;

    public TranslateAnim(Context context, Marker marker) {
        this.f24722a = context;
        this.f24723b = marker;
        this.f24728g = marker.getPosition();
        this.f24729h = marker.getPosition();
        this.f24727f = new LinkedList();
        m19834a();
    }

    /* renamed from: a */
    private void m19834a() {
        FrameAnim frameAnim = new FrameAnim(this.f24722a, this.f24723b);
        this.f24724c = frameAnim;
        frameAnim.setInfinite(false);
        this.f24724c.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
            public void onFrameAnimEnd() {
                AngleManager.getInstant().setFromIndex(TranslateAnim.this.f24731j);
                TranslateAnim.this.f24723b.setIcon(TranslateAnim.this.f24722a, BitmapDescriptorFactory.fromResource(TranslateAnim.this.f24722a, AngleManager.getInstant().getRunningFrame(TranslateAnim.this.f24722a)));
                TranslateAnim translateAnim = TranslateAnim.this;
                LatLng unused = translateAnim.f24729h = translateAnim.f24723b.getPosition();
                TranslateAnim.this.m19837b();
            }
        });
    }

    public void setTranslateIntervalTime(long j) {
        this.f24726e = j;
        ValueAnimator valueAnimator = this.f24725d;
        if (valueAnimator != null) {
            valueAnimator.setDuration(j);
        }
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f24732k = onTranslateAnimEndCallback;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f24725d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doTranslateAnim(LatLng latLng) {
        Marker marker = this.f24723b;
        if (marker == null || marker.getPosition() == null || latLng == null) {
            LogUtil.m19846e("doTranslateAnim() mMarker == null || mMarker.getPosition() == null || toLocation == null");
            OnTranslateAnimEndCallback onTranslateAnimEndCallback = this.f24732k;
            if (onTranslateAnimEndCallback != null) {
                onTranslateAnimEndCallback.onTranslateAnimEnd();
                return;
            }
            return;
        }
        if (this.f24727f == null) {
            this.f24727f = new LinkedList();
        }
        LatLng position = this.f24723b.getPosition();
        this.f24728g = position;
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(position, latLng);
        if (computeDistanceBetween > SodaAnimEngine.DistanceThreshold) {
            LogUtil.m19848w("doTranslateAnim() distance = " + computeDistanceBetween);
            this.f24723b.setPosition(latLng);
            this.f24727f.clear();
            OnTranslateAnimEndCallback onTranslateAnimEndCallback2 = this.f24732k;
            if (onTranslateAnimEndCallback2 != null) {
                onTranslateAnimEndCallback2.onTranslateAnimEnd();
                return;
            }
            return;
        }
        this.f24727f.offer(latLng);
        int indexByLatLng = AngleUtil.getIndexByLatLng(this.f24728g, latLng);
        this.f24731j = indexByLatLng;
        if (indexByLatLng == AngleManager.getInstant().getToIndex()) {
            m19837b();
            return;
        }
        AngleManager.getInstant().setToIndex(this.f24731j);
        this.f24724c.setFrames(AngleManager.getInstant().getRotateFrames(this.f24722a));
        this.f24724c.doFrameAnim(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19837b() {
        LatLng poll = this.f24727f.poll();
        this.f24730i = poll;
        if (this.f24729h == null || poll == null) {
            LogUtil.m19846e("doTranslateAnimInternal() mFromLocation == null || mToLocation == null");
            OnTranslateAnimEndCallback onTranslateAnimEndCallback = this.f24732k;
            if (onTranslateAnimEndCallback != null) {
                onTranslateAnimEndCallback.onTranslateAnimEnd();
                return;
            }
            return;
        }
        if (this.f24725d == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f24725d = ofFloat;
            ofFloat.setDuration(this.f24726e);
            this.f24725d.setInterpolator(new LinearInterpolator());
            this.f24725d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float f = (Float) valueAnimator.getAnimatedValue();
                    if (TranslateAnim.this.f24723b != null && f != null && f.floatValue() >= 0.0f && f.floatValue() <= 1.0f) {
                        if (((double) f.floatValue()) <= 1.0E-6d) {
                            TranslateAnim translateAnim = TranslateAnim.this;
                            LatLng unused = translateAnim.f24729h = translateAnim.f24723b.getPosition();
                        }
                        if (TranslateAnim.this.f24729h != null && TranslateAnim.this.f24730i != null) {
                            TranslateAnim translateAnim2 = TranslateAnim.this;
                            LatLng unused2 = translateAnim2.f24728g = SphericalUtil.interpolate(translateAnim2.f24729h, TranslateAnim.this.f24730i, (double) f.floatValue());
                            TranslateAnim.this.f24723b.setPosition(TranslateAnim.this.f24728g);
                        }
                    }
                }
            });
            this.f24725d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TranslateAnim translateAnim = TranslateAnim.this;
                    LatLng unused = translateAnim.f24728g = translateAnim.f24723b.getPosition();
                    TranslateAnim translateAnim2 = TranslateAnim.this;
                    LatLng unused2 = translateAnim2.f24729h = translateAnim2.f24723b.getPosition();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (TranslateAnim.this.f24727f == null || TranslateAnim.this.f24727f.size() <= 0) {
                        TranslateAnim translateAnim = TranslateAnim.this;
                        LatLng unused = translateAnim.f24728g = translateAnim.f24723b.getPosition();
                        TranslateAnim translateAnim2 = TranslateAnim.this;
                        LatLng unused2 = translateAnim2.f24729h = translateAnim2.f24723b.getPosition();
                        AngleManager.getInstant().setFromIndex(TranslateAnim.this.f24731j);
                        AngleManager.getInstant().setToIndex(TranslateAnim.this.f24731j);
                        if (TranslateAnim.this.f24732k != null) {
                            TranslateAnim.this.f24732k.onTranslateAnimEnd();
                            return;
                        }
                        return;
                    }
                    LogUtil.m19848w("onAnimationEnd mQueue.size(): " + TranslateAnim.this.f24727f.size());
                    TranslateAnim translateAnim3 = TranslateAnim.this;
                    translateAnim3.doTranslateAnim((LatLng) translateAnim3.f24727f.poll());
                }
            });
        }
        this.f24725d.start();
    }

    public void destory() {
        this.f24728g = null;
        this.f24729h = null;
        this.f24730i = null;
        this.f24732k = null;
        Queue<LatLng> queue = this.f24727f;
        if (queue != null) {
            queue.clear();
        }
        FrameAnim frameAnim = this.f24724c;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24724c = null;
        }
        ValueAnimator valueAnimator = this.f24725d;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f24725d.end();
            }
            this.f24725d.removeAllUpdateListeners();
            this.f24725d.removeAllListeners();
            this.f24725d = null;
        }
    }
}
