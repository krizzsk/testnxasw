package com.didi.sdk.view.tips;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class TipsLineView extends View {

    /* renamed from: a */
    private Paint f40970a;

    /* renamed from: b */
    private Path f40971b;

    /* renamed from: c */
    private Path f40972c;

    /* renamed from: d */
    private Point f40973d;

    /* renamed from: e */
    private Point f40974e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Point f40975f;

    /* renamed from: g */
    private float f40976g;

    /* renamed from: h */
    private int f40977h = 2;

    /* renamed from: i */
    private int f40978i;

    /* renamed from: j */
    private int f40979j;

    /* renamed from: k */
    private int f40980k;

    /* renamed from: l */
    private final int f40981l = 200;

    /* renamed from: m */
    private Animator.AnimatorListener f40982m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator.AnimatorListener f40983n;

    /* renamed from: o */
    private boolean f40984o = true;

    public TipsLineView(Context context) {
        super(context);
        m30709a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30709a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30709a(context);
    }

    /* renamed from: a */
    private void m30709a(Context context) {
        this.f40976g = context.getResources().getDisplayMetrics().density;
        this.f40970a = new Paint();
        this.f40971b = new Path();
        this.f40970a.setAntiAlias(true);
        this.f40970a.setDither(true);
        int color = context.getResources().getColor(R.color.guide_line_color);
        this.f40978i = color;
        this.f40970a.setColor(color);
        int dip2px = dip2px((float) this.f40977h);
        this.f40977h = dip2px;
        this.f40970a.setStrokeWidth((float) dip2px);
        this.f40970a.setStyle(Paint.Style.STROKE);
    }

    public void setEnterAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f40982m = animatorListener;
    }

    public void setExitAnimatorLiener(Animator.AnimatorListener animatorListener) {
        this.f40983n = animatorListener;
    }

    public void startPathAnim(long j) {
        final PathMeasure pathMeasure = new PathMeasure(this.f40972c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f40975f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f40982m;
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startEndAnim(long j) {
        Path path = new Path();
        this.f40972c = path;
        path.reset();
        this.f40972c.moveTo((float) this.f40974e.x, (float) this.f40974e.y);
        this.f40972c.lineTo((float) this.f40973d.x, (float) this.f40973d.y);
        final PathMeasure pathMeasure = new PathMeasure(this.f40972c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f40975f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                if (TipsLineView.this.f40983n != null) {
                    TipsLineView.this.f40983n.onAnimationStart(animator);
                }
            }

            public void onAnimationEnd(Animator animator) {
                TipsLineView.this.m30708a();
                if (TipsLineView.this.f40983n != null) {
                    TipsLineView.this.f40983n.onAnimationEnd(animator);
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (TipsLineView.this.f40983n != null) {
                    TipsLineView.this.f40983n.onAnimationCancel(animator);
                }
            }

            public void onAnimationRepeat(Animator animator) {
                if (TipsLineView.this.f40983n != null) {
                    TipsLineView.this.f40983n.onAnimationRepeat(animator);
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30708a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * this.f40976g) + 0.5f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f40975f == null) {
            this.f40979j = canvas.getHeight();
            this.f40980k = canvas.getWidth();
            SystemUtils.log(4, "xxxx", " cw=" + this.f40980k + " w=" + getWidth() + " " + getLeft() + " " + this.f40977h, (Throwable) null, "com.didi.sdk.view.tips.TipsLineView", 178);
            if (this.f40979j > this.f40980k) {
                this.f40973d = new Point(0, this.f40979j);
                this.f40974e = new Point(0, 0);
                this.f40970a.setStrokeWidth((float) this.f40980k);
            } else {
                this.f40973d = new Point(this.f40980k, 0);
                this.f40974e = new Point(0, 0);
                this.f40970a.setStrokeWidth((float) this.f40979j);
            }
            if (this.f40984o) {
                this.f40975f = new Point(this.f40973d.x, this.f40973d.y);
                Path path = new Path();
                this.f40972c = path;
                path.reset();
                this.f40972c.moveTo((float) this.f40973d.x, (float) this.f40973d.y);
                this.f40972c.lineTo((float) this.f40974e.x, (float) this.f40974e.y);
                startPathAnim(200);
            } else {
                this.f40975f = this.f40974e;
            }
        }
        this.f40971b.reset();
        this.f40971b.moveTo((float) this.f40973d.x, (float) this.f40973d.y);
        this.f40971b.lineTo((float) this.f40975f.x, (float) this.f40975f.y);
        float f = this.f40976g;
        this.f40970a.setPathEffect(new DashPathEffect(new float[]{f * 4.0f, f * 3.0f, 4.0f * f, f * 3.0f}, 1.0f));
        canvas.drawPath(this.f40971b, this.f40970a);
    }

    public void setUseAnimation(boolean z) {
        this.f40984o = z;
    }
}
