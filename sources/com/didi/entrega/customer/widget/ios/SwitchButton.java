package com.didi.entrega.customer.widget.ios;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a */
    private static final int f22342a = DisplayUtils.dip2px(GlobalContext.getContext(), 58.0f);

    /* renamed from: b */
    private static final int f22343b = DisplayUtils.dip2px(GlobalContext.getContext(), 36.0f);

    /* renamed from: c */
    private static final int f22344c = 0;

    /* renamed from: d */
    private static final int f22345d = 1;

    /* renamed from: e */
    private static final int f22346e = 2;

    /* renamed from: f */
    private static final int f22347f = 3;

    /* renamed from: g */
    private static final int f22348g = 4;

    /* renamed from: h */
    private static final int f22349h = 5;

    /* renamed from: A */
    private RectF f22350A = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f22351B = 0;

    /* renamed from: C */
    private ValueAnimator f22352C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f22353D;

    /* renamed from: E */
    private boolean f22354E;

    /* renamed from: F */
    private boolean f22355F = false;

    /* renamed from: G */
    private boolean f22356G = false;

    /* renamed from: H */
    private boolean f22357H = false;

    /* renamed from: I */
    private boolean f22358I = false;

    /* renamed from: J */
    private OnCheckedChangeListener f22359J;

    /* renamed from: K */
    private long f22360K;

    /* renamed from: L */
    private Runnable f22361L = new Runnable() {
        public void run() {
            if (!SwitchButton.this.m18430b()) {
                SwitchButton.this.m18437e();
            }
        }
    };

    /* renamed from: M */
    private ValueAnimator.AnimatorUpdateListener f22362M = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c = SwitchButton.this.f22351B;
            if (c == 1 || c == 3 || c == 4) {
                if (SwitchButton.this.f22351B != 1) {
                    SwitchButton.this.f22379x.buttonX = SwitchButton.this.f22380y.buttonX + ((SwitchButton.this.f22381z.buttonX - SwitchButton.this.f22380y.buttonX) * floatValue);
                }
                SwitchButton.this.f22379x.checkStateColor = ((Integer) SwitchButton.this.f22364i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.f22380y.checkStateColor), Integer.valueOf(SwitchButton.this.f22381z.checkStateColor))).intValue();
            } else if (c == 5) {
                SwitchButton.this.f22379x.buttonX = SwitchButton.this.f22380y.buttonX + ((SwitchButton.this.f22381z.buttonX - SwitchButton.this.f22380y.buttonX) * floatValue);
                float h = (SwitchButton.this.f22379x.buttonX - SwitchButton.this.f22375t) / (SwitchButton.this.f22376u - SwitchButton.this.f22375t);
                SwitchButton.this.f22379x.checkStateColor = ((Integer) SwitchButton.this.f22364i.evaluate(h, Integer.valueOf(SwitchButton.this.f22370o), Integer.valueOf(SwitchButton.this.f22371p))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };

    /* renamed from: N */
    private Animator.AnimatorListener f22363N = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int c = SwitchButton.this.f22351B;
            if (c == 1) {
                int unused = SwitchButton.this.f22351B = 2;
                SwitchButton.this.postInvalidate();
            } else if (c == 3) {
                int unused2 = SwitchButton.this.f22351B = 0;
                SwitchButton.this.postInvalidate();
            } else if (c == 4) {
                int unused3 = SwitchButton.this.f22351B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m18420a();
            } else if (c == 5) {
                SwitchButton switchButton = SwitchButton.this;
                boolean unused4 = switchButton.f22353D = true ^ switchButton.f22353D;
                int unused5 = SwitchButton.this.f22351B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m18420a();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ArgbEvaluator f22364i = new ArgbEvaluator();

    /* renamed from: j */
    private float f22365j;

    /* renamed from: k */
    private float f22366k;

    /* renamed from: l */
    private float f22367l;

    /* renamed from: m */
    private float f22368m;

    /* renamed from: n */
    private float f22369n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f22370o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f22371p;

    /* renamed from: q */
    private int f22372q;

    /* renamed from: r */
    private int f22373r;

    /* renamed from: s */
    private int f22374s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f22375t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f22376u;

    /* renamed from: v */
    private Paint f22377v;

    /* renamed from: w */
    private Paint f22378w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewState f22379x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ViewState f22380y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ViewState f22381z;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        m18421a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18421a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18421a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m18421a(context, attributeSet);
    }

    /* renamed from: a */
    private static int m18418a(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    private static int m18428b(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: c */
    private static int m18431c(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    private static boolean m18425a(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setChecked(boolean z) {
        this.f22353D = z;
        if (z) {
            setCheckedViewState(this.f22379x);
        } else {
            setUncheckViewState(this.f22379x);
        }
        postInvalidate();
    }

    public boolean isChecked() {
        return this.f22353D;
    }

    public void setIsAutoToggle(boolean z) {
        this.f22358I = z;
    }

    public void setEnableEffect(boolean z) {
        this.f22354E = z;
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        m18424a(z, true);
    }

    public boolean performClick() {
        if (this.f22358I) {
            toggle();
        }
        return super.performClick();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f22359J = onCheckedChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        if (!this.f22358I) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f22355F = true;
            this.f22360K = System.currentTimeMillis();
            removeCallbacks(this.f22361L);
            postDelayed(this.f22361L, 100);
        } else if (actionMasked == 1) {
            this.f22355F = false;
            removeCallbacks(this.f22361L);
            if (System.currentTimeMillis() - this.f22360K <= 300) {
                performClick();
            } else if (m18435d()) {
                if (Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f) {
                    z = true;
                }
                if (z == isChecked()) {
                    m18439f();
                } else {
                    this.f22353D = z;
                    m18441g();
                }
            } else if (m18433c()) {
                m18439f();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m18433c()) {
                float max = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState = this.f22379x;
                float f = this.f22375t;
                viewState.buttonX = f + ((this.f22376u - f) * max);
            } else if (m18435d()) {
                float max2 = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState2 = this.f22379x;
                float f2 = this.f22375t;
                viewState2.buttonX = f2 + ((this.f22376u - f2) * max2);
                this.f22379x.checkStateColor = ((Integer) this.f22364i.evaluate(max2, Integer.valueOf(this.f22370o), Integer.valueOf(this.f22371p))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f22355F = false;
            removeCallbacks(this.f22361L);
            if (m18433c() || m18435d()) {
                m18439f();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f22342a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f22343b, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.f22367l = f;
        float f2 = (float) i;
        this.f22368m = f2;
        float f3 = f * 0.5f;
        this.f22365j = f3;
        this.f22366k = f3 - ((float) this.f22372q);
        this.f22369n = f * 0.5f;
        this.f22375t = f3;
        this.f22376u = f2 - f3;
        if (isChecked()) {
            setCheckedViewState(this.f22379x);
        } else {
            setUncheckViewState(this.f22379x);
        }
        this.f22356G = true;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f22378w.setColor(this.f22379x.checkStateColor);
        this.f22378w.setStyle(Paint.Style.FILL);
        m18423a(canvas, 0.0f, 0.0f, this.f22368m, this.f22367l, this.f22365j, this.f22378w);
        m18422a(canvas, this.f22379x.buttonX, this.f22369n);
    }

    /* renamed from: a */
    private void m18421a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaSwitchButton) : null;
        this.f22370o = m18431c(obtainStyledAttributes, 8, ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        this.f22371p = m18431c(obtainStyledAttributes, 4, ResourceHelper.getColor(R.color.rf_color_brands_1_100));
        this.f22372q = m18428b(obtainStyledAttributes, 0, DisplayUtils.dip2px(getContext(), 2.0f));
        int c = m18431c(obtainStyledAttributes, 1, -1);
        this.f22373r = m18431c(obtainStyledAttributes, 7, c);
        this.f22374s = m18431c(obtainStyledAttributes, 3, c);
        int a = m18418a(obtainStyledAttributes, 5, 200);
        this.f22353D = m18425a(obtainStyledAttributes, 2, false);
        this.f22354E = m18425a(obtainStyledAttributes, 6, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.f22378w = new Paint(1);
        Paint paint = new Paint(1);
        this.f22377v = paint;
        paint.setColor(c);
        this.f22379x = new ViewState();
        this.f22380y = new ViewState();
        this.f22381z = new ViewState();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f22352C = ofFloat;
        ofFloat.setDuration((long) a);
        this.f22352C.setRepeatCount(0);
        this.f22352C.addUpdateListener(this.f22362M);
        this.f22352C.addListener(this.f22363N);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m18423a(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
            return;
        }
        this.f22350A.set(f, f2, f3, f4);
        canvas.drawRoundRect(this.f22350A, f5, f5, paint);
    }

    /* renamed from: a */
    private void m18422a(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f22366k, this.f22377v);
    }

    private void setUncheckViewState(ViewState viewState) {
        viewState.checkStateColor = this.f22370o;
        viewState.buttonX = this.f22375t;
        this.f22377v.setColor(this.f22373r);
    }

    private void setCheckedViewState(ViewState viewState) {
        viewState.checkStateColor = this.f22371p;
        viewState.buttonX = this.f22376u;
        this.f22377v.setColor(this.f22374s);
    }

    /* renamed from: a */
    private void m18424a(boolean z, boolean z2) {
        if (isEnabled() && isClickable()) {
            if (this.f22357H) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.f22356G) {
                this.f22353D = !this.f22353D;
                if (z2) {
                    m18420a();
                }
            } else {
                if (this.f22352C.isRunning()) {
                    this.f22352C.cancel();
                }
                if (!this.f22354E || !z) {
                    this.f22353D = !this.f22353D;
                    if (isChecked()) {
                        setCheckedViewState(this.f22379x);
                    } else {
                        setUncheckViewState(this.f22379x);
                    }
                    postInvalidate();
                    if (z2) {
                        m18420a();
                        return;
                    }
                    return;
                }
                this.f22351B = 5;
                this.f22380y.copy(this.f22379x);
                if (isChecked()) {
                    setUncheckViewState(this.f22381z);
                } else {
                    setCheckedViewState(this.f22381z);
                }
                this.f22352C.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18420a() {
        OnCheckedChangeListener onCheckedChangeListener = this.f22359J;
        if (onCheckedChangeListener != null) {
            this.f22357H = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.f22357H = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m18430b() {
        return this.f22351B != 0;
    }

    /* renamed from: c */
    private boolean m18433c() {
        int i = this.f22351B;
        return i == 1 || i == 3;
    }

    /* renamed from: d */
    private boolean m18435d() {
        return this.f22351B == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18437e() {
        if (!m18430b() && this.f22355F) {
            if (this.f22352C.isRunning()) {
                this.f22352C.cancel();
            }
            this.f22351B = 1;
            this.f22380y.copy(this.f22379x);
            this.f22381z.copy(this.f22379x);
            if (isChecked()) {
                this.f22381z.checkStateColor = this.f22371p;
                this.f22381z.buttonX = this.f22376u;
            } else {
                this.f22381z.checkStateColor = this.f22370o;
                this.f22381z.buttonX = this.f22375t;
            }
            this.f22352C.start();
        }
    }

    /* renamed from: f */
    private void m18439f() {
        if (m18435d() || m18433c()) {
            if (this.f22352C.isRunning()) {
                this.f22352C.cancel();
            }
            this.f22351B = 3;
            this.f22380y.copy(this.f22379x);
            if (isChecked()) {
                setCheckedViewState(this.f22381z);
            } else {
                setUncheckViewState(this.f22381z);
            }
            this.f22352C.start();
        }
    }

    /* renamed from: g */
    private void m18441g() {
        if (this.f22352C.isRunning()) {
            this.f22352C.cancel();
        }
        this.f22351B = 4;
        this.f22380y.copy(this.f22379x);
        if (isChecked()) {
            setCheckedViewState(this.f22381z);
        } else {
            setUncheckViewState(this.f22381z);
        }
        this.f22352C.start();
    }

    private static class ViewState {
        float buttonX;
        int checkStateColor;

        ViewState() {
        }

        /* access modifiers changed from: private */
        public void copy(ViewState viewState) {
            this.buttonX = viewState.buttonX;
            this.checkStateColor = viewState.checkStateColor;
        }
    }
}
