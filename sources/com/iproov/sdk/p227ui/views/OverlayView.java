package com.iproov.sdk.p227ui.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import p093static.C3639do;
import p093static.C3640if;
import p095switch.C3677super;

/* renamed from: com.iproov.sdk.ui.views.OverlayView */
public class OverlayView extends ViewGroup {

    /* renamed from: a */
    private RectF f57271a;

    /* renamed from: b */
    private RectF f57272b;

    /* renamed from: c */
    private float f57273c = 1.0f;

    /* renamed from: d */
    private boolean f57274d = true;

    /* renamed from: e */
    private final Paint f57275e = new Paint();

    /* renamed from: f */
    private final Paint f57276f = new Paint();

    /* renamed from: g */
    private final Paint f57277g = new Paint();

    /* renamed from: h */
    private C3640if f57278h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ValueAnimator f57279i;

    /* renamed from: j */
    private ValueAnimator f57280j;

    /* renamed from: k */
    private ValueAnimator f57281k;

    /* renamed from: l */
    private ValueAnimator f57282l;

    /* renamed from: com.iproov.sdk.ui.views.OverlayView$do */
    class C20912do extends C3639do {

        /* renamed from: do */
        final /* synthetic */ Runnable f57283do;

        C20912do(Runnable runnable) {
            this.f57283do = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ValueAnimator unused = OverlayView.this.f57279i = null;
            this.f57283do.run();
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.OverlayView$if */
    class C20913if extends C3639do {

        /* renamed from: do */
        final /* synthetic */ Runnable f57285do;

        C20913if(OverlayView overlayView, Runnable runnable) {
            this.f57285do = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f57285do.run();
        }
    }

    public OverlayView(Context context) {
        super(context);
        m43556a();
    }

    /* renamed from: b */
    private void m43558b() {
        this.f57271a = C3677super.m7430do(getWidth(), getHeight(), this.f57273c);
        RectF rectF = new RectF(this.f57271a);
        this.f57272b = rectF;
        rectF.inset(20.0f, 20.0f);
        this.f57278h.setDrawRect(this.f57272b);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m43560c(ValueAnimator valueAnimator) {
        this.f57278h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m43561d(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f57276f);
        if (this.f57274d) {
            canvas.drawOval(this.f57272b, this.f57277g);
            canvas.drawOval(this.f57272b, this.f57275e);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C3640if ifVar = new C3640if(getContext());
        this.f57278h = ifVar;
        addView(ifVar, new ViewGroup.LayoutParams(-1, -1));
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(200);
        this.f57282l = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.m43561d(valueAnimator);
            }
        });
        setOvalVisible(false);
        mo171600do(true, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m43558b();
    }

    public void setBGColor(int i) {
        this.f57276f.setColor(i);
        if (i != ContextCompat.getColor(getContext(), 17170445)) {
            this.f57276f.setAlpha(76);
        }
        invalidate();
    }

    public void setFGColor(int i) {
        this.f57275e.setColor(i);
        this.f57275e.setAlpha(255);
        invalidate();
        this.f57278h.setColor(i);
    }

    public void setOvalVisible(boolean z) {
        this.f57274d = z;
    }

    public void setScale(float f) {
        this.f57273c = f;
        m43558b();
        invalidate();
    }

    public void setScanLineType(C20915do doVar) {
        this.f57278h.setScanlineType(doVar);
    }

    /* renamed from: a */
    private void m43556a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f57275e.setStyle(Paint.Style.STROKE);
        this.f57275e.setStrokeWidth(10.0f);
        this.f57275e.setStrokeCap(Paint.Cap.ROUND);
        this.f57275e.setAntiAlias(true);
        this.f57276f.setAlpha(0);
        this.f57277g.setStyle(Paint.Style.FILL);
        this.f57277g.setColor(0);
        this.f57277g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(1, (Paint) null);
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m48155for() {
        ValueAnimator valueAnimator = this.f57279i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f57280j;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.f57281k;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.f57282l;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        C3640if ifVar = this.f57278h;
        if (ifVar != null) {
            ifVar.m46651for();
        }
    }

    /* renamed from: if */
    public void mo171602if(boolean z, boolean z2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f57281k;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        } else if (z) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            this.f57281k = duration;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    OverlayView.this.m43560c(valueAnimator);
                }
            });
        }
        if (!z2 || (valueAnimator = this.f57281k) == null) {
            this.f57278h.setAlpha(z ? 1.0f : 0.0f);
        } else if (z) {
            valueAnimator.start();
        } else {
            valueAnimator.reverse();
        }
    }

    /* renamed from: do */
    public void mo171600do(boolean z, boolean z2) {
        ValueAnimator valueAnimator = this.f57282l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            setAlpha(z ? 0.0f : 1.0f);
        } else if (z) {
            this.f57282l.start();
        } else {
            this.f57282l.reverse();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43556a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m43559b(ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: do */
    public void mo171599do(Runnable runnable, int i, int i2) {
        if (this.f57279i == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 2.0f}).setDuration((long) i);
            this.f57279i = duration;
            duration.setStartDelay((long) i2);
            this.f57279i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    OverlayView.this.m43559b(valueAnimator);
                }
            });
            if (runnable != null) {
                this.f57279i.addListener(new C20912do(runnable));
            }
            this.f57279i.start();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m43556a();
    }

    /* renamed from: do */
    public void mo171598do(Runnable runnable) {
        if (this.f57280j != null) {
            runnable.run();
            return;
        }
        setOvalVisible(true);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{2.0f, 1.0f}).setDuration(400);
        this.f57280j = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.m43557a(valueAnimator);
            }
        });
        if (runnable != null) {
            this.f57280j.addListener(new C20913if(this, runnable));
        }
        this.f57280j.start();
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m43556a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m43557a(ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
