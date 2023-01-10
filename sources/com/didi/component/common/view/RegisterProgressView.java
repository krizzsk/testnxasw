package com.didi.component.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.passenger.C11267R;

public class RegisterProgressView extends View {
    public static final int DEFAULT_PROGRESS_COLOR = Color.parseColor("#FE803E");

    /* renamed from: a */
    private static final int f13674a = 3;

    /* renamed from: b */
    private static final int f13675b = 6;

    /* renamed from: c */
    private static final int f13676c = Color.parseColor("#EBEBEB");

    /* renamed from: d */
    private static final int f13677d = -1;

    /* renamed from: e */
    private static final int f13678e = 3;

    /* renamed from: f */
    private static final int f13679f = 6;

    /* renamed from: g */
    private static final int f13680g = 14;

    /* renamed from: h */
    private static final int f13681h = 10;

    /* renamed from: A */
    private ValueAnimator f13682A;

    /* renamed from: B */
    private int f13683B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Rect f13684C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RectF f13685D;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Bitmap f13686i;

    /* renamed from: j */
    private Paint f13687j;

    /* renamed from: k */
    private Paint f13688k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f13689l;

    /* renamed from: m */
    private float f13690m;

    /* renamed from: n */
    private float f13691n;

    /* renamed from: o */
    private float f13692o;

    /* renamed from: p */
    private int f13693p;

    /* renamed from: q */
    private int f13694q;

    /* renamed from: r */
    private int f13695r;

    /* renamed from: s */
    private float f13696s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f13697t;

    /* renamed from: u */
    private int f13698u;

    /* renamed from: v */
    private int f13699v;

    /* renamed from: w */
    private int f13700w;

    /* renamed from: x */
    private float f13701x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f13702y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f13703z;

    public RegisterProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RegisterProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RegisterProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11412a(context, attributeSet);
    }

    /* renamed from: a */
    private void m11412a(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RegisterProgressView);
            this.f13691n = obtainStyledAttributes.getDimension(10, (float) m11409a(3.0f));
            this.f13694q = obtainStyledAttributes.getColor(9, DEFAULT_PROGRESS_COLOR);
            this.f13692o = obtainStyledAttributes.getDimension(2, (float) m11409a(6.0f));
            this.f13693p = obtainStyledAttributes.getColor(1, f13676c);
            this.f13695r = obtainStyledAttributes.getColor(6, -1);
            this.f13696s = obtainStyledAttributes.getDimension(7, (float) m11409a(3.0f));
            this.f13697t = obtainStyledAttributes.getDimension(8, (float) m11409a(6.0f));
            this.f13699v = obtainStyledAttributes.getInteger(0, 1);
            this.f13700w = obtainStyledAttributes.getInteger(11, 0);
            this.f13698u = obtainStyledAttributes.getResourceId(4, -1);
            this.f13702y = obtainStyledAttributes.getInteger(5, m11409a(14.0f));
            this.f13703z = obtainStyledAttributes.getInteger(3, m11409a(10.0f));
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f13701x = (((float) this.f13700w) * 100.0f) / ((float) this.f13699v);
        this.f13686i = BitmapFactory.decodeResource(getResources(), this.f13698u);
        Paint paint = new Paint(1);
        this.f13687j = paint;
        paint.setFilterBitmap(true);
        this.f13687j.setDither(true);
        Paint paint2 = new Paint(1);
        this.f13688k = paint2;
        paint2.setPathEffect(new CornerPathEffect(this.f13691n));
        this.f13688k.setStrokeWidth(this.f13691n);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                RegisterProgressView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                RegisterProgressView registerProgressView = RegisterProgressView.this;
                float unused = registerProgressView.f13689l = ((float) registerProgressView.getHeight()) - RegisterProgressView.this.f13697t;
                Rect unused2 = RegisterProgressView.this.f13684C = new Rect(0, 0, RegisterProgressView.this.f13686i.getWidth(), RegisterProgressView.this.f13686i.getHeight());
                RectF unused3 = RegisterProgressView.this.f13685D = new RectF((float) (RegisterProgressView.this.getWidth() - RegisterProgressView.this.f13702y), RegisterProgressView.this.f13689l - (((float) RegisterProgressView.this.f13703z) / 2.0f), (float) RegisterProgressView.this.getWidth(), RegisterProgressView.this.f13689l + (((float) RegisterProgressView.this.f13703z) / 2.0f));
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13690m = ((float) getWidth()) - (this.f13686i == null ? this.f13697t : ((float) this.f13702y) / 2.0f);
        m11423f(canvas);
        m11422e(canvas);
        m11420d(canvas);
        m11418c(canvas);
        m11413a(canvas);
    }

    /* renamed from: a */
    private void m11413a(Canvas canvas) {
        Bitmap bitmap = this.f13686i;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f13684C, this.f13685D, this.f13687j);
        }
    }

    /* renamed from: b */
    private void m11415b(Canvas canvas) {
        if (this.f13701x >= 100.0f) {
            this.f13688k.setColor(this.f13694q);
            canvas.drawCircle(this.f13690m, this.f13689l, this.f13697t, this.f13688k);
        } else {
            this.f13688k.setColor(this.f13693p);
            canvas.drawCircle(this.f13690m, this.f13689l, this.f13697t, this.f13688k);
        }
        this.f13688k.setColor(this.f13695r);
        canvas.drawCircle(this.f13690m, this.f13689l, this.f13696s, this.f13688k);
    }

    /* renamed from: c */
    private void m11418c(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = this.f13699v;
            if (i < i2 - 1) {
                i++;
                float f = ((this.f13690m - this.f13697t) * ((float) i)) / ((float) i2);
                if (i <= this.f13700w) {
                    this.f13688k.setColor(this.f13694q);
                } else {
                    this.f13688k.setColor(this.f13693p);
                }
                canvas.drawCircle(f, this.f13689l, this.f13697t, this.f13688k);
                this.f13688k.setColor(this.f13695r);
                canvas.drawCircle(f, this.f13689l, this.f13696s, this.f13688k);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private void m11420d(Canvas canvas) {
        this.f13688k.setColor(this.f13694q);
        float f = this.f13697t;
        canvas.drawCircle(f, this.f13689l, f, this.f13688k);
        this.f13688k.setColor(this.f13695r);
        canvas.drawCircle(this.f13697t, this.f13689l, this.f13696s, this.f13688k);
    }

    /* renamed from: e */
    private void m11422e(Canvas canvas) {
        float f = ((this.f13690m - this.f13697t) * this.f13701x) / 100.0f;
        this.f13688k.setColor(this.f13694q);
        this.f13688k.setStrokeWidth(this.f13691n);
        float f2 = this.f13697t;
        float f3 = this.f13689l;
        canvas.drawLine(f2, f3, f, f3, this.f13688k);
    }

    /* renamed from: f */
    private void m11423f(Canvas canvas) {
        this.f13688k.setColor(this.f13693p);
        this.f13688k.setStrokeWidth(this.f13692o);
        float f = this.f13689l;
        canvas.drawLine(this.f13697t / 2.0f, f, this.f13690m, f, this.f13688k);
    }

    public void setEndBitmap(Bitmap bitmap) {
        this.f13686i = bitmap;
        invalidate();
    }

    public void setEndBitmap(int i) {
        setEndBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setProgressColor(int i) {
        this.f13694q = i;
        invalidate();
    }

    /* renamed from: a */
    private int m11409a(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: private */
    public void setProgress(float f) {
        this.f13701x = f;
        invalidate();
    }

    public void setStep(int i) {
        this.f13700w = i;
        setProgress((((float) i) * 100.0f) / ((float) this.f13699v));
    }

    public void setStepByAnimator(final int i) {
        if (this.f13683B != i) {
            this.f13683B = i;
            ValueAnimator valueAnimator = this.f13682A;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f13682A.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f13701x, (((float) i) * 100.0f) / ((float) this.f13699v)});
            this.f13682A = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RegisterProgressView.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.f13682A.setDuration(500);
            this.f13682A.start();
            if (i < this.f13700w) {
                setStep(i);
            } else {
                postDelayed(new Runnable() {
                    public void run() {
                        RegisterProgressView.this.setStep(i);
                    }
                }, 500);
            }
        }
    }
}
