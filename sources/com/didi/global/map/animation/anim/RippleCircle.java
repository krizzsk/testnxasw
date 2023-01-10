package com.didi.global.map.animation.anim;

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
    private static final String f24643l = RippleCircle.class.getSimpleName();

    /* renamed from: a */
    private List<Circle> f24644a;

    /* renamed from: b */
    private Circle f24645b;

    /* renamed from: c */
    private Circle f24646c;

    /* renamed from: d */
    private LatLng f24647d;

    /* renamed from: e */
    private ShowStatus f24648e;

    /* renamed from: f */
    private int f24649f = 352321535;

    /* renamed from: g */
    private int f24650g = 335597741;

    /* renamed from: h */
    private float f24651h = 20.0f;

    /* renamed from: i */
    private float f24652i = 2.0f;

    /* renamed from: j */
    private long f24653j = 1800;

    /* renamed from: k */
    private long f24654k = 1150;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo72513a(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public RippleCircle(List<Circle> list, Marker marker) {
        this.f24644a = list;
        this.f24647d = marker.getPosition();
        m19786c();
    }

    public RippleCircle(List<Circle> list, Marker marker, RippleAnimParam rippleAnimParam) {
        this.f24644a = list;
        this.f24647d = marker.getPosition();
        if (rippleAnimParam != null) {
            this.f24649f = rippleAnimParam.getFillColor();
            this.f24650g = rippleAnimParam.getStrokeColor();
            this.f24651h = (float) rippleAnimParam.getAlpha();
            this.f24654k = (long) rippleAnimParam.getRadius();
            this.f24652i = (float) rippleAnimParam.getStrokeWidth();
            String str = f24643l;
            SystemUtils.log(4, str, "RippleAnimParam = " + rippleAnimParam, (Throwable) null, "com.didi.global.map.animation.anim.RippleCircle", 53);
        }
        m19786c();
    }

    public void show() {
        this.f24648e = ShowStatus.SHOW;
        m19783a();
    }

    public void hide() {
        this.f24648e = ShowStatus.HIDE;
        m19787d();
    }

    public boolean isShowing() {
        return this.f24648e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f24648e == ShowStatus.SHOW) {
            this.f24647d = latLng;
            m19783a();
        }
    }

    /* renamed from: a */
    private void m19783a() {
        m19787d();
        m19785b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1800.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.f24653j);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleCircle.this.m19784a(valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19784a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (this.f24646c != null && this.f24645b != null) {
            if (0.0f <= f.floatValue() && f.floatValue() <= 1500.0f) {
                Float valueOf = Float.valueOf(f.floatValue() - 500.0f);
                Float valueOf2 = f.floatValue() >= 1000.0f ? Float.valueOf(1000.0f) : f;
                if (valueOf.floatValue() <= 0.0f) {
                    valueOf = Float.valueOf(0.0f);
                }
                this.f24645b.setRadius((double) (valueOf2.floatValue() * 0.001f * ((float) this.f24654k)));
                this.f24646c.setRadius((double) (valueOf.floatValue() * 0.001f * ((float) this.f24654k)));
            }
            Float.valueOf(1.0f);
            Float.valueOf(1.0f);
            if (f.floatValue() >= 700.0f && f.floatValue() <= 1300.0f) {
                Float valueOf3 = Float.valueOf(Math.abs((f.floatValue() - 1300.0f) / 600.0f));
                this.f24645b.setStrokeColor(mo72513a(this.f24650g, (int) (this.f24651h * valueOf3.floatValue())));
                this.f24645b.setFillColor(mo72513a(this.f24649f, (int) (this.f24651h * valueOf3.floatValue())));
            } else if (f.floatValue() >= 1200.0f && f.floatValue() <= 1800.0f) {
                Float valueOf4 = Float.valueOf(Math.abs((f.floatValue() - 1800.0f) / 600.0f));
                this.f24646c.setStrokeColor(mo72513a(this.f24650g, (int) (this.f24651h * valueOf4.floatValue())));
                this.f24646c.setFillColor(mo72513a(this.f24649f, (int) (this.f24651h * valueOf4.floatValue())));
            }
        }
    }

    /* renamed from: b */
    private void m19785b() {
        Circle circle = this.f24645b;
        if (circle != null) {
            circle.setVisible(true);
        }
        Circle circle2 = this.f24646c;
        if (circle2 != null) {
            circle2.setVisible(true);
        }
    }

    /* renamed from: c */
    private void m19786c() {
        List<Circle> list = this.f24644a;
        if (list != null && list.size() >= 2) {
            this.f24645b = this.f24644a.get(0);
            this.f24646c = this.f24644a.get(1);
            CircleOptions strokeWidth = new CircleOptions().center(this.f24647d).radius(0.0d).fillColor(this.f24649f).strokeColor(this.f24650g).strokeWidth(this.f24652i);
            this.f24646c.setOptions(strokeWidth);
            this.f24645b.setOptions(strokeWidth);
            this.f24645b.setVisible(false);
            this.f24646c.setVisible(false);
        }
    }

    /* renamed from: d */
    private void m19787d() {
        Circle circle = this.f24645b;
        if (circle != null) {
            circle.setRadius(0.0d);
            this.f24645b.setVisible(false);
        }
        Circle circle2 = this.f24646c;
        if (circle2 != null) {
            circle2.setRadius(0.0d);
            this.f24646c.setVisible(false);
        }
    }

    /* renamed from: e */
    private void m19788e() {
        Circle circle = this.f24645b;
        if (circle != null) {
            circle.remove();
            this.f24645b = null;
        }
        Circle circle2 = this.f24646c;
        if (circle2 != null) {
            circle2.remove();
            this.f24646c = null;
        }
    }
}
