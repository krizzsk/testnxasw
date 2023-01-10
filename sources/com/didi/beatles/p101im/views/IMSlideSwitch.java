package com.didi.beatles.p101im.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.MotionEventCompat;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.views.IMSlideSwitch */
public class IMSlideSwitch extends View {
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_RECT = 1;

    /* renamed from: a */
    private static final String f11776a = "IMSlideSwitch";

    /* renamed from: b */
    private static final long f11777b = 80;

    /* renamed from: c */
    private static final int f11778c = 3;

    /* renamed from: d */
    private static final int f11779d = Color.parseColor("#ffff7e33");

    /* renamed from: e */
    private int f11780e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f11781f;

    /* renamed from: g */
    private int f11782g;

    /* renamed from: h */
    private Paint f11783h;

    /* renamed from: i */
    private Rect f11784i;

    /* renamed from: j */
    private Rect f11785j;

    /* renamed from: k */
    private RectF f11786k;

    /* renamed from: l */
    private RectF f11787l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f11788m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f11789n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11790o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f11791p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f11792q;

    /* renamed from: r */
    private int f11793r;

    /* renamed from: s */
    private int f11794s;

    /* renamed from: t */
    private int f11795t;

    /* renamed from: u */
    private boolean f11796u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public SlideListener f11797v;

    /* renamed from: com.didi.beatles.im.views.IMSlideSwitch$SlideListener */
    public interface SlideListener {
        void close(boolean z);

        void open(boolean z);
    }

    public IMSlideSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11780e = Color.parseColor("#ffff7e33");
        this.f11782g = 2;
        this.f11792q = 3;
        this.f11795t = 0;
        this.f11796u = true;
        this.f11797v = null;
        Paint paint = new Paint();
        this.f11783h = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.IMSlideSwitch);
        this.f11780e = obtainStyledAttributes.getColor(2, f11779d);
        this.f11781f = obtainStyledAttributes.getBoolean(0, false);
        this.f11782g = obtainStyledAttributes.getInt(1, 2);
        obtainStyledAttributes.recycle();
    }

    public IMSlideSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMSlideSwitch(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i4 = 0;
        if (layoutParams != null) {
            i4 = layoutParams.width;
            i3 = layoutParams.height;
        } else {
            i3 = 0;
        }
        int a = m10092a(i4, i);
        int a2 = m10092a(i3, i2);
        if (a2 > a) {
            a = a2 * 2;
        }
        setMeasuredDimension(a, a2);
        initDrawingVal();
    }

    public void initDrawingVal() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f11787l = new RectF();
        this.f11786k = new RectF();
        this.f11785j = new Rect();
        this.f11784i = new Rect(0, 0, measuredWidth, measuredHeight);
        this.f11790o = 3;
        if (this.f11782g == 1) {
            this.f11789n = measuredWidth / 2;
        } else {
            this.f11789n = (measuredWidth - (measuredHeight - 6)) - 3;
        }
        if (this.f11781f) {
            this.f11791p = this.f11789n;
            this.f11788m = 255;
        } else {
            this.f11791p = 3;
            this.f11788m = 0;
        }
        this.f11792q = this.f11791p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r3 > 0) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r3 > 0) goto L_0x001b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m10092a(int r3, int r4) {
        /*
            r2 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x0017
            if (r0 == 0) goto L_0x0014
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r3) goto L_0x001c
            r4 = 0
            goto L_0x001c
        L_0x0014:
            if (r3 <= 0) goto L_0x001a
            goto L_0x001b
        L_0x0017:
            if (r3 <= 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r4
        L_0x001b:
            r4 = r3
        L_0x001c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.IMSlideSwitch.m10092a(int, int):int");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f11782g == 1) {
            this.f11783h.setColor(-7829368);
            canvas.drawRect(this.f11784i, this.f11783h);
            this.f11783h.setColor(this.f11780e);
            this.f11783h.setAlpha(this.f11788m);
            canvas.drawRect(this.f11784i, this.f11783h);
            Rect rect = this.f11785j;
            int i = this.f11791p;
            rect.set(i, 3, ((getMeasuredWidth() / 2) + i) - 3, getMeasuredHeight() - 3);
            this.f11783h.setColor(-1);
            canvas.drawRect(this.f11785j, this.f11783h);
            return;
        }
        this.f11783h.setColor(-7829368);
        this.f11787l.set(this.f11784i);
        float height = (float) (this.f11784i.height() / 2);
        canvas.drawRoundRect(this.f11787l, height, height, this.f11783h);
        this.f11783h.setColor(this.f11780e);
        this.f11783h.setAlpha(this.f11788m);
        canvas.drawRoundRect(this.f11787l, height, height, this.f11783h);
        Rect rect2 = this.f11785j;
        int i2 = this.f11791p;
        rect2.set(i2, 3, (this.f11784i.height() + i2) - 6, this.f11784i.height() - 3);
        this.f11786k.set(this.f11785j);
        this.f11783h.setColor(-1);
        canvas.drawRoundRect(this.f11786k, height, height, this.f11783h);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.f11796u) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f11793r = (int) motionEvent.getRawX();
        } else if (actionMasked == 1) {
            int rawX = (int) (motionEvent.getRawX() - ((float) this.f11793r));
            int i2 = this.f11791p;
            this.f11792q = i2;
            boolean z = i2 > this.f11789n / 2;
            if (Math.abs(rawX) < 3) {
                z = !z;
            }
            moveToDest(z);
        } else if (actionMasked == 2) {
            int rawX2 = (int) motionEvent.getRawX();
            this.f11794s = rawX2;
            int i3 = rawX2 - this.f11793r;
            this.f11795t = i3;
            int i4 = i3 + this.f11792q;
            int i5 = this.f11789n;
            if (i4 > i5) {
                i4 = i5;
            }
            int i6 = this.f11790o;
            if (i4 < i6) {
                i4 = i6;
            }
            if (i4 >= this.f11790o && i4 <= (i = this.f11789n)) {
                this.f11791p = i4;
                this.f11788m = (int) ((((float) i4) * 255.0f) / ((float) i));
                m10095a();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10095a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public void setSlideListener(SlideListener slideListener) {
        this.f11797v = slideListener;
    }

    public void moveToDest(final boolean z) {
        int[] iArr = new int[2];
        iArr[0] = this.f11791p;
        iArr[1] = z ? this.f11789n : this.f11790o;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.setDuration(f11777b);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = IMSlideSwitch.this.f11791p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                IMSlideSwitch iMSlideSwitch = IMSlideSwitch.this;
                int unused2 = iMSlideSwitch.f11788m = (int) ((((float) iMSlideSwitch.f11791p) * 255.0f) / ((float) IMSlideSwitch.this.f11789n));
                IMSlideSwitch.this.m10095a();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    boolean unused = IMSlideSwitch.this.f11781f = true;
                    if (IMSlideSwitch.this.f11797v != null) {
                        IMSlideSwitch.this.f11797v.open(true);
                    }
                    IMSlideSwitch iMSlideSwitch = IMSlideSwitch.this;
                    int unused2 = iMSlideSwitch.f11792q = iMSlideSwitch.f11789n;
                    return;
                }
                boolean unused3 = IMSlideSwitch.this.f11781f = false;
                if (IMSlideSwitch.this.f11797v != null) {
                    IMSlideSwitch.this.f11797v.close(true);
                }
                IMSlideSwitch iMSlideSwitch2 = IMSlideSwitch.this;
                int unused4 = iMSlideSwitch2.f11792q = iMSlideSwitch2.f11790o;
            }
        });
    }

    public void setState(boolean z) {
        this.f11781f = z;
        initDrawingVal();
        m10095a();
        SlideListener slideListener = this.f11797v;
        if (slideListener == null) {
            return;
        }
        if (z) {
            slideListener.open(false);
        } else {
            slideListener.close(false);
        }
    }

    public void setShapeType(int i) {
        this.f11782g = i;
    }

    public void setSlideable(boolean z) {
        this.f11796u = z;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11781f = bundle.getBoolean("isOpen");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
        SystemUtils.log(3, f11776a, "onRestoreInstanceState: ", (Throwable) null, "com.didi.beatles.im.views.IMSlideSwitch", 300);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putBoolean("isOpen", this.f11781f);
        SystemUtils.log(3, f11776a, "onRestoreInstanceState: ", (Throwable) null, "com.didi.beatles.im.views.IMSlideSwitch", 308);
        return bundle;
    }
}
