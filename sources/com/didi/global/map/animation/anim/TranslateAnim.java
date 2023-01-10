package com.didi.global.map.animation.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.SodaAnimEngine;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.AngleUtil;
import com.didi.global.map.animation.util.LogUtil;
import com.didi.global.map.animation.util.SphericalUtil;
import java.util.LinkedList;
import java.util.Queue;

public class TranslateAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24655a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f24656b;

    /* renamed from: c */
    private FrameAnim f24657c;

    /* renamed from: d */
    private ValueAnimator f24658d;

    /* renamed from: e */
    private long f24659e = 3000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<LatLng> f24660f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f24661g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LatLng f24662h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LatLng f24663i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f24664j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnTranslateAnimEndCallback f24665k;

    public TranslateAnim(Context context, Marker marker) {
        this.f24655a = context;
        this.f24656b = marker;
        this.f24661g = marker.getPosition();
        this.f24662h = marker.getPosition();
        this.f24660f = new LinkedList();
        m19792a();
    }

    /* renamed from: a */
    private void m19792a() {
        FrameAnim frameAnim = new FrameAnim(this.f24655a, this.f24656b);
        this.f24657c = frameAnim;
        frameAnim.setInfinite(false);
        this.f24657c.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
            public void onFrameAnimEnd() {
                AngleManager.getInstant().setFromIndex(TranslateAnim.this.f24664j);
                TranslateAnim.this.f24656b.setIcon(TranslateAnim.this.f24655a, BitmapDescriptorFactory.fromResource(TranslateAnim.this.f24655a, AngleManager.getInstant().getRunningFrame(TranslateAnim.this.f24655a)));
                TranslateAnim translateAnim = TranslateAnim.this;
                LatLng unused = translateAnim.f24662h = translateAnim.f24656b.getPosition();
                TranslateAnim.this.m19795b();
            }
        });
    }

    public void setTranslateIntervalTime(long j) {
        this.f24659e = j;
        ValueAnimator valueAnimator = this.f24658d;
        if (valueAnimator != null) {
            valueAnimator.setDuration(j);
        }
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f24665k = onTranslateAnimEndCallback;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f24658d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doTranslateAnim(LatLng latLng) {
        Marker marker = this.f24656b;
        if (marker == null || marker.getPosition() == null || latLng == null) {
            LogUtil.m19855e("doTranslateAnim() mMarker == null || mMarker.getPosition() == null || toLocation == null");
            return;
        }
        if (this.f24660f == null) {
            this.f24660f = new LinkedList();
        }
        LatLng position = this.f24656b.getPosition();
        this.f24661g = position;
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(position, latLng);
        if (computeDistanceBetween > SodaAnimEngine.DistanceThreshold) {
            LogUtil.m19857w("doTranslateAnim() distance = " + computeDistanceBetween);
            this.f24656b.setPosition(latLng);
            this.f24660f.clear();
            return;
        }
        this.f24660f.offer(latLng);
        int indexByLatLng = AngleUtil.getIndexByLatLng(this.f24661g, latLng);
        this.f24664j = indexByLatLng;
        if (indexByLatLng == AngleManager.getInstant().getToIndex()) {
            m19795b();
            return;
        }
        AngleManager.getInstant().setToIndex(this.f24664j);
        this.f24657c.setFrames(AngleManager.getInstant().getRotateFrames(this.f24655a));
        this.f24657c.doFrameAnim(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19795b() {
        LatLng poll = this.f24660f.poll();
        this.f24663i = poll;
        if (this.f24662h == null || poll == null) {
            LogUtil.m19855e("doTranslateAnimInternal() mFromLocation == null || mToLocation == null");
            return;
        }
        if (this.f24658d == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f24658d = ofFloat;
            ofFloat.setDuration(this.f24659e);
            this.f24658d.setInterpolator(new LinearInterpolator());
            this.f24658d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float f = (Float) valueAnimator.getAnimatedValue();
                    if (TranslateAnim.this.f24656b != null && f != null && f.floatValue() >= 0.0f && f.floatValue() <= 1.0f) {
                        if (((double) f.floatValue()) <= 1.0E-6d) {
                            TranslateAnim translateAnim = TranslateAnim.this;
                            LatLng unused = translateAnim.f24662h = translateAnim.f24656b.getPosition();
                        }
                        if (TranslateAnim.this.f24662h != null && TranslateAnim.this.f24663i != null) {
                            TranslateAnim translateAnim2 = TranslateAnim.this;
                            LatLng unused2 = translateAnim2.f24661g = SphericalUtil.interpolate(translateAnim2.f24662h, TranslateAnim.this.f24663i, (double) f.floatValue());
                            TranslateAnim.this.f24656b.setPosition(TranslateAnim.this.f24661g);
                        }
                    }
                }
            });
            this.f24658d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TranslateAnim translateAnim = TranslateAnim.this;
                    LatLng unused = translateAnim.f24661g = translateAnim.f24656b.getPosition();
                    TranslateAnim translateAnim2 = TranslateAnim.this;
                    LatLng unused2 = translateAnim2.f24662h = translateAnim2.f24656b.getPosition();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (TranslateAnim.this.f24660f == null || TranslateAnim.this.f24660f.size() <= 0) {
                        TranslateAnim translateAnim = TranslateAnim.this;
                        LatLng unused = translateAnim.f24661g = translateAnim.f24656b.getPosition();
                        TranslateAnim translateAnim2 = TranslateAnim.this;
                        LatLng unused2 = translateAnim2.f24662h = translateAnim2.f24656b.getPosition();
                        AngleManager.getInstant().setFromIndex(TranslateAnim.this.f24664j);
                        AngleManager.getInstant().setToIndex(TranslateAnim.this.f24664j);
                        if (TranslateAnim.this.f24665k != null) {
                            TranslateAnim.this.f24665k.onTranslateAnimEnd();
                            return;
                        }
                        return;
                    }
                    LogUtil.m19857w("onAnimationEnd mQueue.size(): " + TranslateAnim.this.f24660f.size());
                    TranslateAnim translateAnim3 = TranslateAnim.this;
                    translateAnim3.doTranslateAnim((LatLng) translateAnim3.f24660f.poll());
                }
            });
        }
        this.f24658d.start();
    }

    public void destory() {
        this.f24661g = null;
        this.f24662h = null;
        this.f24663i = null;
        this.f24665k = null;
        Queue<LatLng> queue = this.f24660f;
        if (queue != null) {
            queue.clear();
        }
        FrameAnim frameAnim = this.f24657c;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24657c = null;
        }
        ValueAnimator valueAnimator = this.f24658d;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f24658d.end();
            }
            this.f24658d.removeAllUpdateListeners();
            this.f24658d.removeAllListeners();
            this.f24658d = null;
        }
    }
}
