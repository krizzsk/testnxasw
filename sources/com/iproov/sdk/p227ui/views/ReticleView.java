package com.iproov.sdk.p227ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import p095switch.C3677super;

/* renamed from: com.iproov.sdk.ui.views.ReticleView */
public class ReticleView extends View {

    /* renamed from: a */
    private static int f57287a = 5;

    /* renamed from: b */
    private static int f57288b = 20;

    /* renamed from: c */
    private final Paint f57289c = new Paint();

    /* renamed from: d */
    private float f57290d = 120.0f;

    /* renamed from: e */
    private float f57291e = 1.0f;

    /* renamed from: f */
    private C20914do f57292f = C20914do.UNLOCKED;

    /* renamed from: g */
    private final ValueAnimator f57293g = ValueAnimator.ofInt(new int[]{f57287a, f57288b});

    /* renamed from: h */
    private ValueAnimator f57294h;

    /* renamed from: i */
    private ValueAnimator f57295i;

    /* renamed from: j */
    private RectF f57296j = null;

    /* renamed from: k */
    private RectF f57297k = null;

    /* renamed from: l */
    private int f57298l = f57287a;

    /* renamed from: com.iproov.sdk.ui.views.ReticleView$do */
    enum C20914do {
        LOCKED,
        UNLOCKED
    }

    public ReticleView(Context context) {
        super(context);
        m43569a();
    }

    /* renamed from: a */
    private void m43569a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f57289c.setStyle(Paint.Style.STROKE);
        this.f57289c.setStrokeWidth(10.0f);
        this.f57289c.setStrokeCap(Paint.Cap.ROUND);
        this.f57289c.setAntiAlias(true);
        this.f57293g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m43574c(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m43572b(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: c */
    private void m43573c() {
        RectF rectF = this.f57297k;
        if (rectF == null || rectF.height() == 0.0f) {
            this.f57290d = 120.0f;
        } else {
            this.f57290d = this.f57297k.height() * 0.1f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m43574c(ValueAnimator valueAnimator) {
        setupDrawRect(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void setRect(RectF rectF) {
        this.f57296j = rectF;
        setupDrawRect(f57287a);
    }

    private void setupDrawRect(int i) {
        this.f57298l = i;
        m43571b();
    }

    /* renamed from: case  reason: not valid java name */
    public void m48156case() {
        C20914do doVar = this.f57292f;
        C20914do doVar2 = C20914do.UNLOCKED;
        if (doVar != doVar2) {
            this.f57292f = doVar2;
            this.f57293g.setDuration(100);
            this.f57293g.reverse();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f57297k;
        if (rectF != null && this.f57289c != null) {
            int width = (int) ((rectF.width() * (this.f57291e - 1.0f)) / 2.0f);
            int height = (int) ((this.f57297k.height() * (this.f57291e - 1.0f)) / 2.0f);
            RectF rectF2 = this.f57297k;
            int i = ((int) rectF2.left) - width;
            int i2 = ((int) rectF2.right) + width;
            int i3 = ((int) rectF2.top) - height;
            int i4 = ((int) rectF2.bottom) + height;
            float f = (float) i;
            float f2 = (float) i3;
            Canvas canvas2 = canvas;
            float f3 = f;
            float f4 = f2;
            canvas2.drawLine(f3, f4, f, f2 + this.f57290d, this.f57289c);
            canvas2.drawLine(f3, f4, f + this.f57290d, f2, this.f57289c);
            float f5 = (float) i4;
            float f6 = f5;
            canvas2.drawLine(f3, f6, f, f5 - this.f57290d, this.f57289c);
            canvas2.drawLine(f3, f6, f + this.f57290d, f5, this.f57289c);
            float f7 = (float) i2;
            float f8 = f7;
            float f9 = f2;
            canvas2.drawLine(f8, f9, f7, f2 + this.f57290d, this.f57289c);
            canvas2.drawLine(f8, f9, f7 - this.f57290d, f2, this.f57289c);
            Canvas canvas3 = canvas;
            float f10 = f7;
            float f11 = f5;
            canvas3.drawLine(f10, f11, f7, f5 - this.f57290d, this.f57289c);
            canvas3.drawLine(f10, f11, f7 - this.f57290d, f5, this.f57289c);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(200);
        this.f57295i = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m43572b(valueAnimator);
            }
        });
        mo171616do(true, false);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        setRect(C3677super.m7430do(getWidth(), getHeight(), this.f57291e));
    }

    public void setColor(int i) {
        this.f57289c.setColor(i);
        this.f57289c.setAlpha(255);
        m43571b();
    }

    public void setReticleVisible(boolean z) {
        setVisibility(z ? 0 : 4);
        if (z) {
            setAlpha(1.0f);
        }
    }

    public void setScale(float f) {
        this.f57291e = f;
        m43571b();
    }

    /* renamed from: try  reason: not valid java name */
    public void m48158try() {
        this.f57293g.cancel();
        ValueAnimator valueAnimator = this.f57294h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f57295i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* renamed from: b */
    private void m43571b() {
        RectF rectF = new RectF(this.f57296j);
        this.f57297k = rectF;
        float f = (float) this.f57298l;
        rectF.inset(f, f);
        m43573c();
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m48157for() {
        C20914do doVar = this.f57292f;
        C20914do doVar2 = C20914do.LOCKED;
        if (doVar != doVar2) {
            this.f57292f = doVar2;
            this.f57293g.setDuration(200);
            this.f57293g.setStartDelay(50);
            this.f57293g.start();
        }
    }

    /* renamed from: do */
    public void mo171616do(boolean z, boolean z2) {
        ValueAnimator valueAnimator = this.f57295i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            setAlpha(z ? 0.0f : 1.0f);
        } else if (z) {
            this.f57295i.start();
        } else {
            this.f57295i.reverse();
        }
    }

    public ReticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43569a();
    }

    /* renamed from: do */
    public void mo171615do(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{getAlpha(), 0.0f});
        this.f57294h = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m43570a(valueAnimator);
            }
        });
        this.f57294h.setDuration((long) i);
        this.f57294h.setStartDelay((long) i2);
        this.f57294h.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m43570a(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public ReticleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m43569a();
    }

    public ReticleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m43569a();
    }
}
