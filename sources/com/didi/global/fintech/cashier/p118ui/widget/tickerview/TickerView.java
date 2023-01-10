package com.didi.global.fintech.cashier.p118ui.widget.tickerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.GravityCompat;
import com.didi.passenger.C11267R;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView */
public class TickerView extends View {

    /* renamed from: a */
    private static final int f23905a = 12;

    /* renamed from: b */
    private static final int f23906b = -16777216;

    /* renamed from: c */
    private static final int f23907c = 350;

    /* renamed from: d */
    private static final Interpolator f23908d = new AccelerateDecelerateInterpolator();

    /* renamed from: e */
    private static final int f23909e = 8388611;

    /* renamed from: f */
    private final TickerDrawMetrics f23910f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final TickerColumnManager f23911g;

    /* renamed from: h */
    private final ValueAnimator f23912h = ValueAnimator.ofFloat(new float[]{1.0f});

    /* renamed from: i */
    private AnimationHolder f23913i;

    /* renamed from: j */
    private AnimationHolder f23914j;

    /* renamed from: k */
    private final Rect f23915k = new Rect();

    /* renamed from: l */
    private String f23916l;

    /* renamed from: m */
    private int f23917m;

    /* renamed from: n */
    private int f23918n;

    /* renamed from: o */
    private int f23919o;

    /* renamed from: p */
    private int f23920p;

    /* renamed from: q */
    private float f23921q;

    /* renamed from: r */
    private int f23922r;

    /* renamed from: s */
    private long f23923s;

    /* renamed from: t */
    private long f23924t;
    public final Paint textPaint;

    /* renamed from: u */
    private Interpolator f23925u;

    /* renamed from: v */
    private boolean f23926v;

    /* renamed from: w */
    private String f23927w;

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection */
    public enum ScrollingDirection {
        ANY,
        UP,
        DOWN
    }

    public TickerView(Context context) {
        super(context);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f23910f = tickerDrawMetrics;
        this.f23911g = new TickerColumnManager(tickerDrawMetrics);
        init(context, (AttributeSet) null, 0, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f23910f = tickerDrawMetrics;
        this.f23911g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, 0, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f23910f = tickerDrawMetrics;
        this.f23911g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, i, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f23910f = tickerDrawMetrics;
        this.f23911g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet, int i, int i2) {
        StyledAttributes styledAttributes = new StyledAttributes(context.getResources());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.TickerView, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C11267R.styleable.TickerView);
            styledAttributes.applyTypedArray(obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        }
        styledAttributes.applyTypedArray(obtainStyledAttributes);
        this.f23925u = f23908d;
        this.f23924t = (long) obtainStyledAttributes.getInt(11, 350);
        this.f23926v = obtainStyledAttributes.getBoolean(10, false);
        this.f23919o = styledAttributes.gravity;
        if (styledAttributes.shadowColor != 0) {
            this.textPaint.setShadowLayer(styledAttributes.shadowRadius, styledAttributes.shadowDx, styledAttributes.shadowDy, styledAttributes.shadowColor);
        }
        if (styledAttributes.textStyle != 0) {
            this.f23922r = styledAttributes.textStyle;
            setTypeface(this.textPaint.getTypeface());
        }
        setTextColor(styledAttributes.textColor);
        setTextSize(styledAttributes.textSize);
        int i3 = obtainStyledAttributes.getInt(12, 0);
        if (i3 == 1) {
            setCharacterLists(TickerUtils.provideNumberList());
        } else if (i3 == 2) {
            setCharacterLists(TickerUtils.provideAlphabeticalList());
        } else if (isInEditMode()) {
            setCharacterLists(TickerUtils.provideNumberList());
        }
        int i4 = obtainStyledAttributes.getInt(13, 0);
        if (i4 == 0) {
            this.f23910f.mo71441a(ScrollingDirection.ANY);
        } else if (i4 == 1) {
            this.f23910f.mo71441a(ScrollingDirection.UP);
        } else if (i4 == 2) {
            this.f23910f.mo71441a(ScrollingDirection.DOWN);
        } else {
            throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + i4);
        }
        if (isCharacterListsSet()) {
            setText(styledAttributes.text, false);
        } else {
            this.f23927w = styledAttributes.text;
        }
        obtainStyledAttributes.recycle();
        this.f23912h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TickerView.this.m19376a(valueAnimator);
            }
        });
        final $$Lambda$TickerView$ZBuLU_DqXzreuHaa5LHOMdprqY r5 = new Runnable() {
            public final void run() {
                TickerView.this.m19383e();
            }
        };
        this.f23912h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TickerView.this.f23911g.mo71435b();
                TickerView.this.m19375a();
                TickerView.this.invalidate();
                if (Build.VERSION.SDK_INT >= 26) {
                    r5.run();
                } else {
                    TickerView.this.post(r5);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19376a(ValueAnimator valueAnimator) {
        this.f23911g.mo71430a(valueAnimator.getAnimatedFraction());
        m19375a();
        invalidate();
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$StyledAttributes */
    private static class StyledAttributes {
        int gravity;
        int shadowColor;
        float shadowDx;
        float shadowDy;
        float shadowRadius;
        String text;
        int textColor = -16777216;
        float textSize;
        int textStyle;

        StyledAttributes(Resources resources) {
            this.textSize = TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics());
            this.gravity = 8388611;
        }

        /* access modifiers changed from: package-private */
        public void applyTypedArray(TypedArray typedArray) {
            this.gravity = typedArray.getInt(4, this.gravity);
            this.shadowColor = typedArray.getColor(6, this.shadowColor);
            this.shadowDx = typedArray.getFloat(7, this.shadowDx);
            this.shadowDy = typedArray.getFloat(8, this.shadowDy);
            this.shadowRadius = typedArray.getFloat(9, this.shadowRadius);
            this.text = typedArray.getString(5);
            this.textColor = typedArray.getColor(3, this.textColor);
            this.textSize = typedArray.getDimension(1, this.textSize);
            this.textStyle = typedArray.getInt(2, this.textStyle);
        }
    }

    public void setCharacterLists(String... strArr) {
        this.f23911g.mo71433a(strArr);
        String str = this.f23927w;
        if (str != null) {
            setText(str, false);
            this.f23927w = null;
        }
    }

    public boolean isCharacterListsSet() {
        return this.f23911g.mo71434a() != null;
    }

    public void setText(String str) {
        setText(str, !TextUtils.isEmpty(this.f23916l));
    }

    public void setText(String str, boolean z) {
        if (!TextUtils.equals(str, this.f23916l)) {
            if (!z && this.f23912h.isRunning()) {
                this.f23912h.cancel();
                this.f23914j = null;
                this.f23913i = null;
            }
            if (z) {
                this.f23914j = new AnimationHolder(str, this.f23923s, this.f23924t, this.f23925u);
                if (this.f23913i == null) {
                    m19383e();
                    return;
                }
                return;
            }
            setTextInternal(str);
            this.f23911g.mo71430a(1.0f);
            this.f23911g.mo71435b();
            m19375a();
            invalidate();
        }
    }

    public String getText() {
        return this.f23916l;
    }

    public int getTextColor() {
        return this.f23920p;
    }

    public void setTextColor(int i) {
        if (this.f23920p != i) {
            this.f23920p = i;
            this.textPaint.setColor(i);
            invalidate();
        }
    }

    public float getTextSize() {
        return this.f23921q;
    }

    public void setTextSize(float f) {
        if (this.f23921q != f) {
            this.f23921q = f;
            this.textPaint.setTextSize(f);
            m19382d();
        }
    }

    public Typeface getTypeface() {
        return this.textPaint.getTypeface();
    }

    public void setTypeface(Typeface typeface) {
        int i = this.f23922r;
        if (i == 3) {
            typeface = Typeface.create(typeface, 3);
        } else if (i == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i == 2) {
            typeface = Typeface.create(typeface, 2);
        }
        this.textPaint.setTypeface(typeface);
        m19382d();
    }

    public long getAnimationDelay() {
        return this.f23923s;
    }

    public void setAnimationDelay(long j) {
        this.f23923s = j;
    }

    public long getAnimationDuration() {
        return this.f23924t;
    }

    public void setAnimationDuration(long j) {
        this.f23924t = j;
    }

    public Interpolator getAnimationInterpolator() {
        return this.f23925u;
    }

    public void setAnimationInterpolator(Interpolator interpolator) {
        this.f23925u = interpolator;
    }

    public void setPreferredScrollingDirection(ScrollingDirection scrollingDirection) {
        this.f23910f.mo71441a(scrollingDirection);
    }

    public int getGravity() {
        return this.f23919o;
    }

    public void setGravity(int i) {
        if (this.f23919o != i) {
            this.f23919o = i;
            invalidate();
        }
    }

    public void setAnimateMeasurementChange(boolean z) {
        this.f23926v = z;
    }

    public boolean getAnimateMeasurementChange() {
        return this.f23926v;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f23912h.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f23912h.removeListener(animatorListener);
    }

    public void setPaintFlags(int i) {
        this.textPaint.setFlags(i);
        m19382d();
    }

    public void setBlurMaskFilter(BlurMaskFilter.Blur blur, float f) {
        if (blur == null || f <= 0.0f) {
            setLayerType(1, (Paint) null);
            this.textPaint.setMaskFilter((MaskFilter) null);
            return;
        }
        this.textPaint.setMaskFilter(new BlurMaskFilter(f, blur));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19375a() {
        boolean z = true;
        boolean z2 = this.f23917m != m19379b();
        if (this.f23918n == m19381c()) {
            z = false;
        }
        if (z2 || z) {
            requestLayout();
        }
    }

    /* renamed from: b */
    private int m19379b() {
        return ((int) (this.f23926v ? this.f23911g.mo71437d() : this.f23911g.mo71436c())) + getPaddingLeft() + getPaddingRight();
    }

    /* renamed from: c */
    private int m19381c() {
        return ((int) this.f23910f.mo71442b()) + getPaddingTop() + getPaddingBottom();
    }

    /* renamed from: d */
    private void m19382d() {
        this.f23910f.mo71440a();
        m19375a();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f23917m = m19379b();
        this.f23918n = m19381c();
        setMeasuredDimension(resolveSize(this.f23917m, i), resolveSize(this.f23918n, i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f23915k.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        m19377a(canvas);
        canvas.translate(0.0f, this.f23910f.mo71443c());
        this.f23911g.mo71431a(canvas, this.textPaint);
        canvas.restore();
    }

    /* renamed from: a */
    private void m19377a(Canvas canvas) {
        m19378a(canvas, this.f23919o, this.f23915k, this.f23911g.mo71437d(), this.f23910f.mo71442b());
    }

    /* renamed from: a */
    static void m19378a(Canvas canvas, int i, Rect rect, float f, float f2) {
        int width = rect.width();
        int height = rect.height();
        float f3 = (i & 16) == 16 ? ((float) rect.top) + ((((float) height) - f2) / 2.0f) : 0.0f;
        float f4 = (i & 1) == 1 ? ((float) rect.left) + ((((float) width) - f) / 2.0f) : 0.0f;
        if ((i & 48) == 48) {
            f3 = 0.0f;
        }
        if ((i & 80) == 80) {
            f3 = ((float) rect.top) + (((float) height) - f2);
        }
        if ((i & 8388611) == 8388611) {
            f4 = 0.0f;
        }
        if ((i & GravityCompat.END) == 8388613) {
            f4 = ((float) rect.left) + (((float) width) - f);
        }
        canvas.translate(f4, f3);
        canvas.clipRect(0.0f, 0.0f, f, f2);
    }

    private void setTextInternal(String str) {
        char[] cArr;
        this.f23916l = str;
        if (str == null) {
            cArr = new char[0];
        } else {
            cArr = str.toCharArray();
        }
        this.f23911g.mo71432a(cArr);
        setContentDescription(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m19383e() {
        AnimationHolder animationHolder = this.f23914j;
        this.f23913i = animationHolder;
        this.f23914j = null;
        if (animationHolder != null) {
            setTextInternal(animationHolder.text);
            this.f23912h.setStartDelay(animationHolder.animationDelayInMillis);
            this.f23912h.setDuration(animationHolder.animationDurationInMillis);
            this.f23912h.setInterpolator(animationHolder.animationInterpolator);
            this.f23912h.start();
        }
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$AnimationHolder */
    private static final class AnimationHolder {
        public final long animationDelayInMillis;
        public final long animationDurationInMillis;
        public final Interpolator animationInterpolator;
        public final String text;

        private AnimationHolder(String str, long j, long j2, Interpolator interpolator) {
            this.text = str;
            this.animationDelayInMillis = j;
            this.animationDurationInMillis = j2;
            this.animationInterpolator = interpolator;
        }
    }
}
