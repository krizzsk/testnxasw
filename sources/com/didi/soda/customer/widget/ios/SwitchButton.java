package com.didi.soda.customer.widget.ios;

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
import com.didi.passenger.C11267R;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a */
    private static final int f44585a = DisplayUtils.dip2px(GlobalContext.getContext(), 58.0f);

    /* renamed from: b */
    private static final int f44586b = DisplayUtils.dip2px(GlobalContext.getContext(), 36.0f);

    /* renamed from: c */
    private static final int f44587c = 0;

    /* renamed from: d */
    private static final int f44588d = 1;

    /* renamed from: e */
    private static final int f44589e = 2;

    /* renamed from: f */
    private static final int f44590f = 3;

    /* renamed from: g */
    private static final int f44591g = 4;

    /* renamed from: h */
    private static final int f44592h = 5;

    /* renamed from: A */
    private RectF f44593A = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f44594B = 0;

    /* renamed from: C */
    private ValueAnimator f44595C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f44596D;

    /* renamed from: E */
    private boolean f44597E;

    /* renamed from: F */
    private boolean f44598F = false;

    /* renamed from: G */
    private boolean f44599G = false;

    /* renamed from: H */
    private boolean f44600H = false;

    /* renamed from: I */
    private boolean f44601I = false;

    /* renamed from: J */
    private OnCheckedChangeListener f44602J;

    /* renamed from: K */
    private long f44603K;

    /* renamed from: L */
    private Runnable f44604L = new Runnable() {
        public void run() {
            if (!SwitchButton.this.m33118b()) {
                SwitchButton.this.m33125e();
            }
        }
    };

    /* renamed from: M */
    private ValueAnimator.AnimatorUpdateListener f44605M = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c = SwitchButton.this.f44594B;
            if (c == 1 || c == 3 || c == 4) {
                if (SwitchButton.this.f44594B != 1) {
                    SwitchButton.this.f44622x.buttonX = SwitchButton.this.f44623y.buttonX + ((SwitchButton.this.f44624z.buttonX - SwitchButton.this.f44623y.buttonX) * floatValue);
                }
                SwitchButton.this.f44622x.checkStateColor = ((Integer) SwitchButton.this.f44607i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.f44623y.checkStateColor), Integer.valueOf(SwitchButton.this.f44624z.checkStateColor))).intValue();
            } else if (c == 5) {
                SwitchButton.this.f44622x.buttonX = SwitchButton.this.f44623y.buttonX + ((SwitchButton.this.f44624z.buttonX - SwitchButton.this.f44623y.buttonX) * floatValue);
                float h = (SwitchButton.this.f44622x.buttonX - SwitchButton.this.f44618t) / (SwitchButton.this.f44619u - SwitchButton.this.f44618t);
                SwitchButton.this.f44622x.checkStateColor = ((Integer) SwitchButton.this.f44607i.evaluate(h, Integer.valueOf(SwitchButton.this.f44613o), Integer.valueOf(SwitchButton.this.f44614p))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };

    /* renamed from: N */
    private Animator.AnimatorListener f44606N = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int c = SwitchButton.this.f44594B;
            if (c == 1) {
                int unused = SwitchButton.this.f44594B = 2;
                SwitchButton.this.postInvalidate();
            } else if (c == 3) {
                int unused2 = SwitchButton.this.f44594B = 0;
                SwitchButton.this.postInvalidate();
            } else if (c == 4) {
                int unused3 = SwitchButton.this.f44594B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m33108a();
            } else if (c == 5) {
                SwitchButton switchButton = SwitchButton.this;
                boolean unused4 = switchButton.f44596D = true ^ switchButton.f44596D;
                int unused5 = SwitchButton.this.f44594B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m33108a();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ArgbEvaluator f44607i = new ArgbEvaluator();

    /* renamed from: j */
    private float f44608j;

    /* renamed from: k */
    private float f44609k;

    /* renamed from: l */
    private float f44610l;

    /* renamed from: m */
    private float f44611m;

    /* renamed from: n */
    private float f44612n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f44613o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f44614p;

    /* renamed from: q */
    private int f44615q;

    /* renamed from: r */
    private int f44616r;

    /* renamed from: s */
    private int f44617s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f44618t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f44619u;

    /* renamed from: v */
    private Paint f44620v;

    /* renamed from: w */
    private Paint f44621w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewState f44622x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ViewState f44623y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ViewState f44624z;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        m33109a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33109a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33109a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m33109a(context, attributeSet);
    }

    /* renamed from: a */
    private static int m33106a(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    private static int m33116b(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: c */
    private static int m33119c(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    private static boolean m33113a(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setChecked(boolean z) {
        this.f44596D = z;
        if (z) {
            setCheckedViewState(this.f44622x);
        } else {
            setUncheckViewState(this.f44622x);
        }
        postInvalidate();
    }

    public boolean isChecked() {
        return this.f44596D;
    }

    public void setIsAutoToggle(boolean z) {
        this.f44601I = z;
    }

    public void setEnableEffect(boolean z) {
        this.f44597E = z;
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        m33112a(z, true);
    }

    public boolean performClick() {
        if (this.f44601I) {
            toggle();
        }
        return super.performClick();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f44602J = onCheckedChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        if (!this.f44601I) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f44598F = true;
            this.f44603K = System.currentTimeMillis();
            removeCallbacks(this.f44604L);
            postDelayed(this.f44604L, 100);
        } else if (actionMasked == 1) {
            this.f44598F = false;
            removeCallbacks(this.f44604L);
            if (System.currentTimeMillis() - this.f44603K <= 300) {
                performClick();
            } else if (m33123d()) {
                if (Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f) {
                    z = true;
                }
                if (z == isChecked()) {
                    m33127f();
                } else {
                    this.f44596D = z;
                    m33129g();
                }
            } else if (m33121c()) {
                m33127f();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m33121c()) {
                float max = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState = this.f44622x;
                float f = this.f44618t;
                viewState.buttonX = f + ((this.f44619u - f) * max);
            } else if (m33123d()) {
                float max2 = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState2 = this.f44622x;
                float f2 = this.f44618t;
                viewState2.buttonX = f2 + ((this.f44619u - f2) * max2);
                this.f44622x.checkStateColor = ((Integer) this.f44607i.evaluate(max2, Integer.valueOf(this.f44613o), Integer.valueOf(this.f44614p))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f44598F = false;
            removeCallbacks(this.f44604L);
            if (m33121c() || m33123d()) {
                m33127f();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f44585a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f44586b, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.f44610l = f;
        float f2 = (float) i;
        this.f44611m = f2;
        float f3 = f * 0.5f;
        this.f44608j = f3;
        this.f44609k = f3 - ((float) this.f44615q);
        this.f44612n = f * 0.5f;
        this.f44618t = f3;
        this.f44619u = f2 - f3;
        if (isChecked()) {
            setCheckedViewState(this.f44622x);
        } else {
            setUncheckViewState(this.f44622x);
        }
        this.f44599G = true;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f44621w.setColor(this.f44622x.checkStateColor);
        this.f44621w.setStyle(Paint.Style.FILL);
        m33111a(canvas, 0.0f, 0.0f, this.f44611m, this.f44610l, this.f44608j, this.f44621w);
        m33110a(canvas, this.f44622x.buttonX, this.f44612n);
    }

    /* renamed from: a */
    private void m33109a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, C11267R.styleable.SwitchButton) : null;
        this.f44613o = m33119c(obtainStyledAttributes, 8, ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        this.f44614p = m33119c(obtainStyledAttributes, 4, ResourceHelper.getColor(R.color.rf_color_brands_1_100));
        this.f44615q = m33116b(obtainStyledAttributes, 0, DisplayUtils.dip2px(getContext(), 2.0f));
        int c = m33119c(obtainStyledAttributes, 1, -1);
        this.f44616r = m33119c(obtainStyledAttributes, 7, c);
        this.f44617s = m33119c(obtainStyledAttributes, 3, c);
        int a = m33106a(obtainStyledAttributes, 5, 200);
        this.f44596D = m33113a(obtainStyledAttributes, 2, false);
        this.f44597E = m33113a(obtainStyledAttributes, 6, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.f44621w = new Paint(1);
        Paint paint = new Paint(1);
        this.f44620v = paint;
        paint.setColor(c);
        this.f44622x = new ViewState();
        this.f44623y = new ViewState();
        this.f44624z = new ViewState();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f44595C = ofFloat;
        ofFloat.setDuration((long) a);
        this.f44595C.setRepeatCount(0);
        this.f44595C.addUpdateListener(this.f44605M);
        this.f44595C.addListener(this.f44606N);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m33111a(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
            return;
        }
        this.f44593A.set(f, f2, f3, f4);
        canvas.drawRoundRect(this.f44593A, f5, f5, paint);
    }

    /* renamed from: a */
    private void m33110a(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f44609k, this.f44620v);
    }

    private void setUncheckViewState(ViewState viewState) {
        viewState.checkStateColor = this.f44613o;
        viewState.buttonX = this.f44618t;
        this.f44620v.setColor(this.f44616r);
    }

    private void setCheckedViewState(ViewState viewState) {
        viewState.checkStateColor = this.f44614p;
        viewState.buttonX = this.f44619u;
        this.f44620v.setColor(this.f44617s);
    }

    /* renamed from: a */
    private void m33112a(boolean z, boolean z2) {
        if (isEnabled() && isClickable()) {
            if (this.f44600H) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.f44599G) {
                this.f44596D = !this.f44596D;
                if (z2) {
                    m33108a();
                }
            } else {
                if (this.f44595C.isRunning()) {
                    this.f44595C.cancel();
                }
                if (!this.f44597E || !z) {
                    this.f44596D = !this.f44596D;
                    if (isChecked()) {
                        setCheckedViewState(this.f44622x);
                    } else {
                        setUncheckViewState(this.f44622x);
                    }
                    postInvalidate();
                    if (z2) {
                        m33108a();
                        return;
                    }
                    return;
                }
                this.f44594B = 5;
                this.f44623y.copy(this.f44622x);
                if (isChecked()) {
                    setUncheckViewState(this.f44624z);
                } else {
                    setCheckedViewState(this.f44624z);
                }
                this.f44595C.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33108a() {
        OnCheckedChangeListener onCheckedChangeListener = this.f44602J;
        if (onCheckedChangeListener != null) {
            this.f44600H = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.f44600H = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m33118b() {
        return this.f44594B != 0;
    }

    /* renamed from: c */
    private boolean m33121c() {
        int i = this.f44594B;
        return i == 1 || i == 3;
    }

    /* renamed from: d */
    private boolean m33123d() {
        return this.f44594B == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33125e() {
        if (!m33118b() && this.f44598F) {
            if (this.f44595C.isRunning()) {
                this.f44595C.cancel();
            }
            this.f44594B = 1;
            this.f44623y.copy(this.f44622x);
            this.f44624z.copy(this.f44622x);
            if (isChecked()) {
                this.f44624z.checkStateColor = this.f44614p;
                this.f44624z.buttonX = this.f44619u;
            } else {
                this.f44624z.checkStateColor = this.f44613o;
                this.f44624z.buttonX = this.f44618t;
            }
            this.f44595C.start();
        }
    }

    /* renamed from: f */
    private void m33127f() {
        if (m33123d() || m33121c()) {
            if (this.f44595C.isRunning()) {
                this.f44595C.cancel();
            }
            this.f44594B = 3;
            this.f44623y.copy(this.f44622x);
            if (isChecked()) {
                setCheckedViewState(this.f44624z);
            } else {
                setUncheckViewState(this.f44624z);
            }
            this.f44595C.start();
        }
    }

    /* renamed from: g */
    private void m33129g() {
        if (this.f44595C.isRunning()) {
            this.f44595C.cancel();
        }
        this.f44594B = 4;
        this.f44623y.copy(this.f44622x);
        if (isChecked()) {
            setCheckedViewState(this.f44624z);
        } else {
            setUncheckViewState(this.f44624z);
        }
        this.f44595C.start();
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
