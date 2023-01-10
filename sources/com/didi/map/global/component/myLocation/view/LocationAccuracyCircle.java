package com.didi.map.global.component.myLocation.view;

import android.animation.ValueAnimator;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;

public class LocationAccuracyCircle {

    /* renamed from: l */
    private static final float f28331l = 2.0f;

    /* renamed from: m */
    private static final float f28332m = 30.0f;

    /* renamed from: n */
    private static final float f28333n = 500.0f;

    /* renamed from: o */
    private static final float f28334o = 20.0f;

    /* renamed from: p */
    private static final long f28335p = 200;

    /* renamed from: q */
    private static final String f28336q = "LocationAccuracyCircle";

    /* renamed from: a */
    private Map f28337a;

    /* renamed from: b */
    private Circle f28338b;

    /* renamed from: c */
    private LatLng f28339c;

    /* renamed from: d */
    private LatLng f28340d;

    /* renamed from: e */
    private ShowStatus f28341e;

    /* renamed from: f */
    private int f28342f = 456958182;

    /* renamed from: g */
    private int f28343g = -3874057;

    /* renamed from: h */
    private float f28344h;

    /* renamed from: i */
    private float f28345i;

    /* renamed from: j */
    private float f28346j;

    /* renamed from: k */
    private boolean f28347k = false;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    public LocationAccuracyCircle(Map map, LocationAccuracyCircleOptions locationAccuracyCircleOptions) {
        if (map == null || locationAccuracyCircleOptions == null) {
            DLog.m10773d(f28336q, " create fail...", new Object[0]);
            return;
        }
        this.f28337a = map;
        this.f28347k = true;
        this.f28339c = locationAccuracyCircleOptions.getPosition();
        this.f28344h = locationAccuracyCircleOptions.getAccuracy();
        this.f28345i = locationAccuracyCircleOptions.getDefMinAccuracy() > 0.0f ? locationAccuracyCircleOptions.getDefMinAccuracy() : 30.0f;
        this.f28346j = locationAccuracyCircleOptions.getDefMaxAccuracy() > 0.0f ? locationAccuracyCircleOptions.getDefMaxAccuracy() : f28333n;
    }

    public void show() {
        if (this.f28341e != ShowStatus.SHOW && this.f28347k) {
            this.f28341e = ShowStatus.SHOW;
            if (this.f28339c != null && this.f28344h > this.f28345i) {
                m22189a();
            }
        }
    }

    public void hide() {
        this.f28341e = ShowStatus.HIDE;
        m22193c();
    }

    public boolean isShowing() {
        return this.f28341e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f28347k && this.f28341e == ShowStatus.SHOW) {
            this.f28340d = this.f28339c;
            this.f28339c = latLng;
            this.f28344h = f;
            if (latLng == null || f <= this.f28345i) {
                m22193c();
            } else {
                m22189a();
            }
        }
    }

    /* renamed from: a */
    private void m22189a() {
        float f;
        m22194d();
        Circle circle = this.f28338b;
        if (circle != null) {
            f = (float) circle.getRadius();
            if (m22191a(this.f28339c, this.f28340d)) {
                this.f28338b.setCenter(this.f28339c);
            }
        } else {
            f = this.f28344h;
            m22192b();
        }
        if (this.f28338b != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, this.f28344h});
            ofFloat.setDuration(200);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LocationAccuracyCircle.this.m22190a(valueAnimator);
                }
            });
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22190a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        Circle circle = this.f28338b;
        if (circle != null) {
            circle.setRadius((double) f.floatValue());
        }
    }

    /* renamed from: b */
    private void m22192b() {
        this.f28338b = this.f28337a.addCircle(new CircleOptions().center(this.f28339c).radius((double) this.f28344h).fillColor(this.f28342f).strokeColor(this.f28343g).strokeWidth(2.0f));
    }

    /* renamed from: c */
    private void m22193c() {
        Circle circle;
        Map map = this.f28337a;
        if (map != null && (circle = this.f28338b) != null) {
            map.remove(circle);
            this.f28338b = null;
        }
    }

    /* renamed from: d */
    private void m22194d() {
        float f = this.f28344h;
        float f2 = this.f28346j;
        if (f > f2) {
            this.f28344h = f2;
        }
    }

    /* renamed from: a */
    private boolean m22191a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return false;
        }
        try {
            int i = (int) ((latLng.longitude * 1000000.0d) - (latLng2.longitude * 1000000.0d));
            if (((float) Math.abs((int) ((latLng.latitude * 1000000.0d) - (latLng2.latitude * 1000000.0d)))) >= 20.0f || ((float) Math.abs(i)) >= 20.0f) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
