package com.didi.soda.customer.widget;

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
    private static final int f44183a = 1600;

    /* renamed from: b */
    private static final byte f44184b = 0;

    /* renamed from: c */
    private static final byte f44185c = -45;

    /* renamed from: d */
    private static final byte f44186d = 45;

    /* renamed from: e */
    private static final byte f44187e = 0;

    /* renamed from: f */
    private static final byte f44188f = 1;

    /* renamed from: g */
    private static final byte f44189g = 0;

    /* renamed from: h */
    private static final byte f44190h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f44191i;

    /* renamed from: j */
    private Rect f44192j;

    /* renamed from: k */
    private Paint f44193k;

    /* renamed from: l */
    private ValueAnimator f44194l;

    /* renamed from: m */
    private Bitmap f44195m;

    /* renamed from: n */
    private Bitmap f44196n;

    /* renamed from: o */
    private Canvas f44197o;

    /* renamed from: p */
    private boolean f44198p;

    /* renamed from: q */
    private boolean f44199q;

    /* renamed from: r */
    private boolean f44200r;

    /* renamed from: s */
    private int f44201s;

    /* renamed from: t */
    private int f44202t;

    /* renamed from: u */
    private int f44203u;

    /* renamed from: v */
    private float f44204v;

    /* renamed from: w */
    private float f44205w;

    /* renamed from: x */
    private ViewTreeObserver.OnPreDrawListener f44206x;

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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.ShimmerLayout, 0, 0);
        try {
            this.f44203u = obtainStyledAttributes.getInteger(0, 0);
            this.f44201s = obtainStyledAttributes.getInteger(1, 1600);
            this.f44202t = obtainStyledAttributes.getColor(3, m32885a((int) R.color.shimmer_color));
            this.f44200r = obtainStyledAttributes.getBoolean(2, false);
            this.f44204v = obtainStyledAttributes.getFloat(5, 0.8f);
            this.f44205w = obtainStyledAttributes.getFloat(4, 0.1f);
            this.f44198p = obtainStyledAttributes.getBoolean(6, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.f44204v);
            setGradientCenterColorWidth(this.f44205w);
            setShimmerAngle(this.f44203u);
            m32898g();
            if (this.f44200r && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setAnimationReversed(boolean z) {
        this.f44198p = z;
        m32889a();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("mGradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f44205w = f;
        m32889a();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("mMaskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f44204v = f;
        m32889a();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("mShimmerAngle value must be between %d and %d", new Object[]{Byte.valueOf(f44185c), Byte.valueOf(f44186d)}));
        }
        this.f44203u = i;
        m32889a();
    }

    public void setShimmerAnimationDuration(int i) {
        this.f44201s = i;
        m32889a();
    }

    public void setShimmerColor(int i) {
        this.f44202t = i;
        m32889a();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            stopShimmerAnimation();
        } else if (this.f44200r) {
            startShimmerAnimation();
        }
    }

    public void startShimmerAnimation() {
        if (!this.f44199q) {
            if (getWidth() == 0) {
                this.f44206x = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        ShimmerLayout.this.startShimmerAnimation();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.f44206x);
                return;
            }
            getShimmerAnimation().start();
            this.f44199q = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.f44206x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f44206x);
        }
        m32892b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m32892b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f44199q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m32890a(canvas);
        }
    }

    /* renamed from: a */
    private void m32889a() {
        if (this.f44199q) {
            m32892b();
            startShimmerAnimation();
        }
    }

    /* renamed from: a */
    private void m32890a(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.f44195m = maskBitmap;
        if (maskBitmap != null) {
            if (this.f44197o == null) {
                this.f44197o = new Canvas(this.f44195m);
            }
            this.f44197o.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f44197o.save();
            this.f44197o.translate((float) (-this.f44191i), 0.0f);
            super.dispatchDraw(this.f44197o);
            this.f44197o.restore();
            m32893b(canvas);
            this.f44195m = null;
        }
    }

    /* renamed from: b */
    private void m32893b(Canvas canvas) {
        m32895d();
        canvas.save();
        canvas.translate((float) this.f44191i, 0.0f);
        canvas.drawRect((float) this.f44192j.left, 0.0f, (float) this.f44192j.width(), (float) this.f44192j.height(), this.f44193k);
        canvas.restore();
    }

    /* renamed from: b */
    private void m32892b() {
        ValueAnimator valueAnimator = this.f44194l;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f44194l.removeAllUpdateListeners();
        }
        this.f44194l = null;
        this.f44193k = null;
        this.f44199q = false;
        m32894c();
    }

    /* renamed from: c */
    private void m32894c() {
        this.f44197o = null;
        Bitmap bitmap = this.f44196n;
        if (bitmap != null) {
            bitmap.recycle();
            this.f44196n = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f44196n == null) {
            this.f44196n = m32888a(this.f44192j.width(), getHeight());
        }
        return this.f44196n;
    }

    /* renamed from: d */
    private void m32895d() {
        if (this.f44193k == null) {
            int b = m32891b(this.f44202t);
            float width = ((float) (getWidth() / 2)) * this.f44204v;
            float height = this.f44203u >= 0 ? (float) getHeight() : 0.0f;
            int i = this.f44202t;
            ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians((double) this.f44203u))) * width, height + (((float) Math.sin(Math.toRadians((double) this.f44203u))) * width), new int[]{b, i, i, b}, getGradientColorDistribution(), Shader.TileMode.CLAMP), new BitmapShader(this.f44195m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.f44193k = paint;
            paint.setAntiAlias(true);
            this.f44193k.setDither(true);
            this.f44193k.setFilterBitmap(true);
            this.f44193k.setShader(composeShader);
        }
    }

    private Animator getShimmerAnimation() {
        final int i;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f44194l;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.f44192j == null) {
            this.f44192j = m32896e();
        }
        int width = getWidth();
        if (getWidth() > this.f44192j.width()) {
            i = (-width) / 2;
        } else {
            i = (-this.f44192j.width()) / 2;
        }
        final int width2 = this.f44192j.width();
        int i2 = width - i;
        if (this.f44198p) {
            valueAnimator = ValueAnimator.ofInt(new int[]{i2, 0});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{0, i2});
        }
        this.f44194l = valueAnimator;
        valueAnimator.setDuration((long) this.f44201s);
        this.f44194l.setRepeatCount(-1);
        this.f44194l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ShimmerLayout.this.f44191i = i + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (ShimmerLayout.this.f44191i + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.f44194l;
    }

    /* renamed from: a */
    private Bitmap m32888a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    /* renamed from: a */
    private int m32885a(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i);
        }
        return getResources().getColor(i);
    }

    /* renamed from: b */
    private int m32891b(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: e */
    private Rect m32896e() {
        return new Rect(0, 0, m32897f(), getHeight());
    }

    /* renamed from: f */
    private int m32897f() {
        return (int) ((((double) (((float) (getWidth() / 2)) * this.f44204v)) / Math.cos(Math.toRadians((double) Math.abs(this.f44203u)))) + (((double) getHeight()) * Math.tan(Math.toRadians((double) Math.abs(this.f44203u)))));
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f = this.f44205w;
        fArr[1] = 0.5f - (f / 2.0f);
        fArr[2] = (f / 2.0f) + 0.5f;
        return fArr;
    }

    /* renamed from: g */
    private void m32898g() {
        if (Build.VERSION.SDK_INT <= 16) {
            setLayerType(1, (Paint) null);
        }
    }
}
