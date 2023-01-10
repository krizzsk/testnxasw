package com.didi.global.map.animation.transition.anim;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class RippleCircle {

    /* renamed from: l */
    private static final String f24710l = RippleCircle.class.getSimpleName();

    /* renamed from: a */
    private List<Circle> f24711a;

    /* renamed from: b */
    private Circle f24712b;

    /* renamed from: c */
    private Circle f24713c;

    /* renamed from: d */
    private LatLng f24714d;

    /* renamed from: e */
    private ShowStatus f24715e;

    /* renamed from: f */
    private int f24716f = 352321535;

    /* renamed from: g */
    private int f24717g = 335597741;

    /* renamed from: h */
    private float f24718h = 20.0f;

    /* renamed from: i */
    private float f24719i = 2.0f;

    /* renamed from: j */
    private long f24720j = 1800;

    /* renamed from: k */
    private long f24721k = 1150;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo72582a(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public RippleCircle(List<Circle> list, Marker marker) {
        this.f24711a = list;
        this.f24714d = marker.getPosition();
        m19828c();
    }

    public RippleCircle(List<Circle> list, Marker marker, RippleAnimParam rippleAnimParam) {
        this.f24711a = list;
        this.f24714d = marker.getPosition();
        if (rippleAnimParam != null) {
            this.f24716f = rippleAnimParam.getFillColor();
            this.f24717g = rippleAnimParam.getStrokeColor();
            this.f24718h = (float) rippleAnimParam.getAlpha();
            this.f24721k = (long) rippleAnimParam.getRadius();
            this.f24719i = (float) rippleAnimParam.getStrokeWidth();
            String str = f24710l;
            SystemUtils.log(4, str, "RippleAnimParam = " + rippleAnimParam, (Throwable) null, "com.didi.global.map.animation.transition.anim.RippleCircle", 53);
        }
        m19828c();
    }

    public void show() {
        this.f24715e = ShowStatus.SHOW;
        m19825a();
    }

    public void hide() {
        this.f24715e = ShowStatus.HIDE;
        m19829d();
    }

    public boolean isShowing() {
        return this.f24715e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f24715e == ShowStatus.SHOW) {
            this.f24714d = latLng;
            m19825a();
        }
    }

    /* renamed from: a */
    private void m19825a() {
        m19829d();
        m19827b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1800.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.f24720j);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleCircle.this.m19826a(valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19826a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (this.f24713c != null && this.f24712b != null) {
            if (0.0f <= f.floatValue() && f.floatValue() <= 1500.0f) {
                Float valueOf = Float.valueOf(f.floatValue() - 500.0f);
                Float valueOf2 = f.floatValue() >= 1000.0f ? Float.valueOf(1000.0f) : f;
                if (valueOf.floatValue() <= 0.0f) {
                    valueOf = Float.valueOf(0.0f);
                }
                this.f24712b.setRadius((double) (valueOf2.floatValue() * 0.001f * ((float) this.f24721k)));
                this.f24713c.setRadius((double) (valueOf.floatValue() * 0.001f * ((float) this.f24721k)));
            }
            Float.valueOf(1.0f);
            Float.valueOf(1.0f);
            if (f.floatValue() >= 700.0f && f.floatValue() <= 1300.0f) {
                Float valueOf3 = Float.valueOf(Math.abs((f.floatValue() - 1300.0f) / 600.0f));
                this.f24712b.setStrokeColor(mo72582a(this.f24717g, (int) (this.f24718h * valueOf3.floatValue())));
                this.f24712b.setFillColor(mo72582a(this.f24716f, (int) (this.f24718h * valueOf3.floatValue())));
            } else if (f.floatValue() >= 1200.0f && f.floatValue() <= 1800.0f) {
                Float valueOf4 = Float.valueOf(Math.abs((f.floatValue() - 1800.0f) / 600.0f));
                this.f24713c.setStrokeColor(mo72582a(this.f24717g, (int) (this.f24718h * valueOf4.floatValue())));
                this.f24713c.setFillColor(mo72582a(this.f24716f, (int) (this.f24718h * valueOf4.floatValue())));
            }
        }
    }

    /* renamed from: b */
    private void m19827b() {
        Circle circle = this.f24712b;
        if (circle != null) {
            circle.setVisible(true);
        }
        Circle circle2 = this.f24713c;
        if (circle2 != null) {
            circle2.setVisible(true);
        }
    }

    /* renamed from: c */
    private void m19828c() {
        List<Circle> list = this.f24711a;
        if (list != null && list.size() >= 2) {
            this.f24712b = this.f24711a.get(0);
            this.f24713c = this.f24711a.get(1);
            CircleOptions strokeWidth = new CircleOptions().center(this.f24714d).radius(0.0d).fillColor(this.f24716f).strokeColor(this.f24717g).strokeWidth(this.f24719i);
            this.f24713c.setOptions(strokeWidth);
            this.f24712b.setOptions(strokeWidth);
            this.f24712b.setVisible(false);
            this.f24713c.setVisible(false);
        }
    }

    /* renamed from: d */
    private void m19829d() {
        Circle circle = this.f24712b;
        if (circle != null) {
            circle.setRadius(0.0d);
            this.f24712b.setVisible(false);
        }
        Circle circle2 = this.f24713c;
        if (circle2 != null) {
            circle2.setRadius(0.0d);
            this.f24713c.setVisible(false);
        }
    }

    /* renamed from: e */
    private void m19830e() {
        Circle circle = this.f24712b;
        if (circle != null) {
            circle.remove();
            this.f24712b = null;
        }
        Circle circle2 = this.f24713c;
        if (circle2 != null) {
            circle2.remove();
            this.f24713c = null;
        }
    }
}
