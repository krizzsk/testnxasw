package com.didi.addressold.view.tips;

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
    private Paint f9815a;

    /* renamed from: b */
    private Path f9816b;

    /* renamed from: c */
    private Path f9817c;

    /* renamed from: d */
    private Point f9818d;

    /* renamed from: e */
    private Point f9819e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Point f9820f;

    /* renamed from: g */
    private float f9821g;

    /* renamed from: h */
    private int f9822h = 2;

    /* renamed from: i */
    private int f9823i;

    /* renamed from: j */
    private int f9824j;

    /* renamed from: k */
    private int f9825k;

    /* renamed from: l */
    private final int f9826l = 200;

    /* renamed from: m */
    private Animator.AnimatorListener f9827m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator.AnimatorListener f9828n;

    /* renamed from: o */
    private boolean f9829o = true;

    public TipsLineView(Context context) {
        super(context);
        m8554a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8554a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8554a(context);
    }

    /* renamed from: a */
    private void m8554a(Context context) {
        this.f9821g = context.getResources().getDisplayMetrics().density;
        this.f9815a = new Paint();
        this.f9816b = new Path();
        this.f9815a.setAntiAlias(true);
        this.f9815a.setDither(true);
        int color = context.getResources().getColor(R.color.guide_line_color);
        this.f9823i = color;
        this.f9815a.setColor(color);
        int dip2px = dip2px((float) this.f9822h);
        this.f9822h = dip2px;
        this.f9815a.setStrokeWidth((float) dip2px);
        this.f9815a.setStyle(Paint.Style.STROKE);
    }

    public void setEnterAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f9827m = animatorListener;
    }

    public void setExitAnimatorLiener(Animator.AnimatorListener animatorListener) {
        this.f9828n = animatorListener;
    }

    public void startPathAnim(long j) {
        final PathMeasure pathMeasure = new PathMeasure(this.f9817c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f9820f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f9827m;
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startEndAnim(long j) {
        Path path = new Path();
        this.f9817c = path;
        path.reset();
        this.f9817c.moveTo((float) this.f9819e.x, (float) this.f9819e.y);
        this.f9817c.lineTo((float) this.f9818d.x, (float) this.f9818d.y);
        final PathMeasure pathMeasure = new PathMeasure(this.f9817c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f9820f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                if (TipsLineView.this.f9828n != null) {
                    TipsLineView.this.f9828n.onAnimationStart(animator);
                }
            }

            public void onAnimationEnd(Animator animator) {
                TipsLineView.this.m8553a();
                if (TipsLineView.this.f9828n != null) {
                    TipsLineView.this.f9828n.onAnimationEnd(animator);
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (TipsLineView.this.f9828n != null) {
                    TipsLineView.this.f9828n.onAnimationCancel(animator);
                }
            }

            public void onAnimationRepeat(Animator animator) {
                if (TipsLineView.this.f9828n != null) {
                    TipsLineView.this.f9828n.onAnimationRepeat(animator);
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8553a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * this.f9821g) + 0.5f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f9820f == null) {
            this.f9824j = canvas.getHeight();
            this.f9825k = canvas.getWidth();
            SystemUtils.log(4, "xxxx", " cw=" + this.f9825k + " w=" + getWidth() + " " + getLeft() + " " + this.f9822h, (Throwable) null, "com.didi.addressold.view.tips.TipsLineView", 167);
            if (this.f9824j > this.f9825k) {
                this.f9818d = new Point(0, this.f9824j);
                this.f9819e = new Point(0, 0);
                this.f9815a.setStrokeWidth((float) this.f9825k);
            } else {
                this.f9818d = new Point(this.f9825k, 0);
                this.f9819e = new Point(0, 0);
                this.f9815a.setStrokeWidth((float) this.f9824j);
            }
            if (this.f9829o) {
                this.f9820f = new Point(this.f9818d.x, this.f9818d.y);
                Path path = new Path();
                this.f9817c = path;
                path.reset();
                this.f9817c.moveTo((float) this.f9818d.x, (float) this.f9818d.y);
                this.f9817c.lineTo((float) this.f9819e.x, (float) this.f9819e.y);
                startPathAnim(200);
            } else {
                this.f9820f = this.f9819e;
            }
        }
        this.f9816b.reset();
        this.f9816b.moveTo((float) this.f9818d.x, (float) this.f9818d.y);
        this.f9816b.lineTo((float) this.f9820f.x, (float) this.f9820f.y);
        float f = this.f9821g;
        this.f9815a.setPathEffect(new DashPathEffect(new float[]{f * 4.0f, f * 3.0f, 4.0f * f, f * 3.0f}, 1.0f));
        canvas.drawPath(this.f9816b, this.f9815a);
    }

    public void setUseAnimation(boolean z) {
        this.f9829o = z;
    }
}
