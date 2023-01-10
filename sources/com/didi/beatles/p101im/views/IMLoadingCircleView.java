package com.didi.beatles.p101im.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.views.IMLoadingCircleView */
public class IMLoadingCircleView extends View {

    /* renamed from: a */
    private static String f11730a = IMLoadingCircleView.class.getSimpleName();

    /* renamed from: m */
    private static final float f11731m = 10.0f;

    /* renamed from: b */
    private Paint f11732b;

    /* renamed from: c */
    private float f11733c;

    /* renamed from: d */
    private float f11734d;

    /* renamed from: e */
    private float f11735e;

    /* renamed from: f */
    private float f11736f;

    /* renamed from: g */
    private final RectF f11737g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f11738h;

    /* renamed from: i */
    private int f11739i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Float f11740j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Float f11741k;

    /* renamed from: l */
    private AnimatorSet f11742l;

    /* renamed from: n */
    private ValueAnimator f11743n;

    /* renamed from: o */
    private ValueAnimator f11744o;

    /* renamed from: p */
    private ValueAnimator f11745p;

    /* renamed from: q */
    private boolean f11746q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnDoneCircleAnimListner f11747r;

    /* renamed from: com.didi.beatles.im.views.IMLoadingCircleView$OnDoneCircleAnimListner */
    public interface OnDoneCircleAnimListner {
        void onCircleDone();
    }

    public IMLoadingCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMLoadingCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMLoadingCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11733c = 3.0f;
        this.f11737g = new RectF();
        this.f11739i = -65536;
        Float valueOf = Float.valueOf(0.0f);
        this.f11740j = valueOf;
        this.f11741k = valueOf;
        this.f11742l = new AnimatorSet();
        Paint paint = new Paint();
        this.f11732b = paint;
        paint.setAntiAlias(true);
        this.f11732b.setStrokeJoin(Paint.Join.ROUND);
        this.f11732b.setStrokeWidth(this.f11733c);
        this.f11732b.setColor(this.f11739i);
        this.f11732b.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11737g.left = this.f11734d - this.f11736f;
        this.f11737g.top = this.f11735e - this.f11736f;
        this.f11737g.right = this.f11734d + this.f11736f;
        this.f11737g.bottom = this.f11735e + this.f11736f;
        canvas.drawArc(this.f11737g, 0.0f, (float) this.f11738h, false, this.f11732b);
        float f = this.f11734d;
        float f2 = this.f11736f;
        canvas.drawLine(f - (f2 / 2.0f), this.f11735e, (f - (f2 / 2.0f)) + this.f11740j.floatValue(), this.f11735e + this.f11740j.floatValue(), this.f11732b);
        float f3 = this.f11734d;
        canvas.drawLine(f3, this.f11735e + (this.f11736f / 2.0f), f3 + this.f11741k.floatValue(), (this.f11735e + (this.f11736f / 2.0f)) - (this.f11741k.floatValue() * 1.5f), this.f11732b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m10079a();
    }

    /* renamed from: a */
    private void m10079a() {
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(height, width);
        this.f11734d = (float) (width / 2);
        this.f11735e = (float) (height / 2);
        this.f11736f = (((float) min) - 20.0f) / 2.0f;
    }

    public void loadCircle() {
        AnimatorSet animatorSet = this.f11742l;
        if (animatorSet == null || !animatorSet.isRunning()) {
            initDegreeAndOffset();
            m10079a();
            this.f11743n = ValueAnimator.ofInt(new int[]{0, 360});
            this.f11744o = ValueAnimator.ofFloat(new float[]{0.0f, this.f11736f / 2.0f});
            this.f11745p = ValueAnimator.ofFloat(new float[]{0.0f, this.f11736f / 2.0f});
            String str = f11730a;
            IMLog.m10024i(str, "mRadius" + this.f11736f);
            this.f11743n.setDuration(700);
            this.f11744o.setDuration(350);
            this.f11745p.setDuration(350);
            this.f11743n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = IMLoadingCircleView.this.f11738h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f11744o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = IMLoadingCircleView.this.f11740j = (Float) valueAnimator.getAnimatedValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f11745p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = IMLoadingCircleView.this.f11741k = (Float) valueAnimator.getAnimatedValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f11742l.play(this.f11743n).before(this.f11744o);
            this.f11742l.play(this.f11745p).after(this.f11744o);
            this.f11742l.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    IMLoadingCircleView.this.stop();
                    IMLoadingCircleView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (IMLoadingCircleView.this.f11747r != null) {
                                IMLoadingCircleView.this.f11747r.onCircleDone();
                            }
                        }
                    }, 800);
                }
            });
            this.f11742l.start();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.f11743n;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        ValueAnimator valueAnimator2 = this.f11744o;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
        }
        ValueAnimator valueAnimator3 = this.f11745p;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
        }
        clearAnimation();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f11742l;
        if (animatorSet != null) {
            return animatorSet.isStarted();
        }
        return false;
    }

    public void initDegreeAndOffset() {
        this.f11738h = 0;
        Float valueOf = Float.valueOf(0.0f);
        this.f11740j = valueOf;
        this.f11741k = valueOf;
    }

    public boolean IsCanHide() {
        return this.f11746q;
    }

    public void setCanHide(boolean z) {
        this.f11746q = z;
    }

    public void addCircleAnimatorEndListner(OnDoneCircleAnimListner onDoneCircleAnimListner) {
        if (this.f11747r == null) {
            this.f11747r = onDoneCircleAnimListner;
        }
    }

    public void removeCircleAnimatorEndListner() {
        this.f11747r = null;
    }
}
