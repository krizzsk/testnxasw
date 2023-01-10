package com.didi.entrega.customer.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class ShimmerLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f22180a = 1600;

    /* renamed from: b */
    private static final byte f22181b = 0;

    /* renamed from: c */
    private static final byte f22182c = -45;

    /* renamed from: d */
    private static final byte f22183d = 45;

    /* renamed from: e */
    private static final byte f22184e = 0;

    /* renamed from: f */
    private static final byte f22185f = 1;

    /* renamed from: g */
    private static final byte f22186g = 0;

    /* renamed from: h */
    private static final byte f22187h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f22188i;

    /* renamed from: j */
    private Rect f22189j;

    /* renamed from: k */
    private Paint f22190k;

    /* renamed from: l */
    private ValueAnimator f22191l;

    /* renamed from: m */
    private Bitmap f22192m;

    /* renamed from: n */
    private Bitmap f22193n;

    /* renamed from: o */
    private Canvas f22194o;

    /* renamed from: p */
    private boolean f22195p;

    /* renamed from: q */
    private boolean f22196q;

    /* renamed from: r */
    private boolean f22197r;

    /* renamed from: s */
    private int f22198s;

    /* renamed from: t */
    private int f22199t;

    /* renamed from: u */
    private int f22200u;

    /* renamed from: v */
    private float f22201v;

    /* renamed from: w */
    private float f22202w;

    /* renamed from: x */
    private ViewTreeObserver.OnPreDrawListener f22203x;

    public ShimmerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaShimmerLayout, 0, 0);
        try {
            this.f22200u = obtainStyledAttributes.getInteger(0, 0);
            this.f22198s = obtainStyledAttributes.getInteger(1, 1600);
            this.f22199t = obtainStyledAttributes.getColor(3, m18328a((int) R.color.entrega_shimmer_color));
            this.f22197r = obtainStyledAttributes.getBoolean(2, false);
            this.f22201v = obtainStyledAttributes.getFloat(5, 0.8f);
            this.f22202w = obtainStyledAttributes.getFloat(4, 0.1f);
            this.f22195p = obtainStyledAttributes.getBoolean(6, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.f22201v);
            setGradientCenterColorWidth(this.f22202w);
            setShimmerAngle(this.f22200u);
            m18341g();
            if (this.f22197r && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setAnimationReversed(boolean z) {
        this.f22195p = z;
        m18332a();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("mGradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f22202w = f;
        m18332a();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("mMaskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f22201v = f;
        m18332a();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("mShimmerAngle value must be between %d and %d", new Object[]{Byte.valueOf(f22182c), Byte.valueOf(f22183d)}));
        }
        this.f22200u = i;
        m18332a();
    }

    public void setShimmerAnimationDuration(int i) {
        this.f22198s = i;
        m18332a();
    }

    public void setShimmerColor(int i) {
        this.f22199t = i;
        m18332a();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            stopShimmerAnimation();
        } else if (this.f22197r) {
            startShimmerAnimation();
        }
    }

    public void startShimmerAnimation() {
        if (!this.f22196q) {
            if (getWidth() == 0) {
                this.f22203x = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        ShimmerLayout.this.startShimmerAnimation();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.f22203x);
                return;
            }
            getShimmerAnimation().start();
            this.f22196q = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.f22203x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f22203x);
        }
        m18335b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m18335b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f22196q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m18333a(canvas);
        }
    }

    /* renamed from: a */
    private void m18332a() {
        if (this.f22196q) {
            m18335b();
            startShimmerAnimation();
        }
    }

    /* renamed from: a */
    private void m18333a(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.f22192m = maskBitmap;
        if (maskBitmap != null) {
            if (this.f22194o == null) {
                this.f22194o = new Canvas(this.f22192m);
            }
            this.f22194o.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f22194o.save();
            this.f22194o.translate((float) (-this.f22188i), 0.0f);
            super.dispatchDraw(this.f22194o);
            this.f22194o.restore();
            m18336b(canvas);
            this.f22192m = null;
        }
    }

    /* renamed from: b */
    private void m18336b(Canvas canvas) {
        m18338d();
        canvas.save();
        canvas.translate((float) this.f22188i, 0.0f);
        canvas.drawRect((float) this.f22189j.left, 0.0f, (float) this.f22189j.width(), (float) this.f22189j.height(), this.f22190k);
        canvas.restore();
    }

    /* renamed from: b */
    private void m18335b() {
        ValueAnimator valueAnimator = this.f22191l;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f22191l.removeAllUpdateListeners();
        }
        this.f22191l = null;
        this.f22190k = null;
        this.f22196q = false;
        m18337c();
    }

    /* renamed from: c */
    private void m18337c() {
        this.f22194o = null;
        Bitmap bitmap = this.f22193n;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22193n = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f22193n == null) {
            this.f22193n = m18331a(this.f22189j.width(), getHeight());
        }
        return this.f22193n;
    }

    /* renamed from: d */
    private void m18338d() {
        if (this.f22190k == null) {
            int b = m18334b(this.f22199t);
            float width = ((float) (getWidth() / 2)) * this.f22201v;
            float height = this.f22200u >= 0 ? (float) getHeight() : 0.0f;
            int i = this.f22199t;
            ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians((double) this.f22200u))) * width, height + (((float) Math.sin(Math.toRadians((double) this.f22200u))) * width), new int[]{b, i, i, b}, getGradientColorDistribution(), Shader.TileMode.CLAMP), new BitmapShader(this.f22192m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.f22190k = paint;
            paint.setAntiAlias(true);
            this.f22190k.setDither(true);
            this.f22190k.setFilterBitmap(true);
            this.f22190k.setShader(composeShader);
        }
    }

    private Animator getShimmerAnimation() {
        final int i;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f22191l;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.f22189j == null) {
            this.f22189j = m18339e();
        }
        int width = getWidth();
        if (getWidth() > this.f22189j.width()) {
            i = (-width) / 2;
        } else {
            i = (-this.f22189j.width()) / 2;
        }
        final int width2 = this.f22189j.width();
        int i2 = width - i;
        if (this.f22195p) {
            valueAnimator = ValueAnimator.ofInt(new int[]{i2, 0});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{0, i2});
        }
        this.f22191l = valueAnimator;
        valueAnimator.setDuration((long) this.f22198s);
        this.f22191l.setRepeatCount(-1);
        this.f22191l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ShimmerLayout.this.f22188i = i + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (ShimmerLayout.this.f22188i + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.f22191l;
    }

    /* renamed from: a */
    private Bitmap m18331a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    /* renamed from: a */
    private int m18328a(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i);
        }
        return getResources().getColor(i);
    }

    /* renamed from: b */
    private int m18334b(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: e */
    private Rect m18339e() {
        return new Rect(0, 0, m18340f(), getHeight());
    }

    /* renamed from: f */
    private int m18340f() {
        return (int) ((((double) (((float) (getWidth() / 2)) * this.f22201v)) / Math.cos(Math.toRadians((double) Math.abs(this.f22200u)))) + (((double) getHeight()) * Math.tan(Math.toRadians((double) Math.abs(this.f22200u)))));
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f = this.f22202w;
        fArr[1] = 0.5f - (f / 2.0f);
        fArr[2] = (f / 2.0f) + 0.5f;
        return fArr;
    }

    /* renamed from: g */
    private void m18341g() {
        if (Build.VERSION.SDK_INT <= 16) {
            setLayerType(1, (Paint) null);
        }
    }
}
