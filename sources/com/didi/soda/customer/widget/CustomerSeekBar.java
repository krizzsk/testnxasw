package com.didi.soda.customer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C11267R;

public class CustomerSeekBar extends View {

    /* renamed from: a */
    private int f44105a = 40;

    /* renamed from: b */
    private int f44106b = -1;

    /* renamed from: c */
    private int f44107c = -1;

    /* renamed from: d */
    private int f44108d = 5;

    /* renamed from: e */
    private int f44109e = 25;

    /* renamed from: f */
    private Drawable f44110f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f44111g = 1.3f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f44112h = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f44113i = 1.0f;

    /* renamed from: j */
    private int f44114j = 20;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f44115k = 100;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f44116l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTrackListener f44117m;

    /* renamed from: n */
    private SparseArray<StarData> f44118n = new SparseArray<>();

    /* renamed from: o */
    private boolean f44119o = false;

    /* renamed from: p */
    private int f44120p;

    /* renamed from: q */
    private int f44121q;

    /* renamed from: r */
    private int f44122r;

    /* renamed from: s */
    private int f44123s;

    /* renamed from: t */
    private ValueAnimator f44124t;

    /* renamed from: u */
    private BeginDragRunnable f44125u = new BeginDragRunnable();

    public interface OnTrackListener {
        void onEndTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2, boolean z);

        boolean onInterceptTouch();

        void onStartTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2);

        void onTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2);
    }

    public CustomerSeekBar(Context context) {
        super(context);
        m32856a((AttributeSet) null);
    }

    public CustomerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32856a(attributeSet);
    }

    public CustomerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32856a(attributeSet);
    }

    public int getMinStep() {
        return this.f44114j;
    }

    public void setOnTrackListener(OnTrackListener onTrackListener) {
        this.f44117m = onTrackListener;
    }

    public void setCurrentProgress(int i) {
        if (i != this.f44116l) {
            int i2 = this.f44115k;
            if (i > i2) {
                i = i2;
            }
            int i3 = this.f44114j;
            int i4 = i / i3;
            if ((((float) i) * 1.0f) / ((float) i3) == ((float) i4)) {
                this.f44116l = i;
            } else {
                this.f44116l = (i4 + 1) * i3;
            }
            invalidate();
        }
    }

    public void setMaxProgress(int i) {
        if (i <= 0) {
            i = 100;
        }
        this.f44115k = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        OnTrackListener onTrackListener = this.f44117m;
        if (onTrackListener != null && onTrackListener.onInterceptTouch()) {
            return onTouchEvent;
        }
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f44119o = false;
                m32853a();
                m32854a((int) motionEvent.getX(), (int) motionEvent.getY());
                boolean z = this.f44120p != this.f44116l;
                if (z) {
                    m32861b();
                }
                OnTrackListener onTrackListener2 = this.f44117m;
                if (onTrackListener2 != null) {
                    onTrackListener2.onEndTrackingTouch(this, this.f44116l, this.f44115k, z);
                }
            } else if (actionMasked == 2) {
                int x = (int) motionEvent.getX();
                if (!this.f44119o && Math.abs(this.f44121q - x) > this.f44122r) {
                    this.f44119o = true;
                    onTouchEvent = true;
                }
                if (this.f44119o) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    m32853a();
                    m32854a((int) motionEvent.getX(), (int) motionEvent.getY());
                    OnTrackListener onTrackListener3 = this.f44117m;
                    if (onTrackListener3 != null) {
                        onTrackListener3.onTrackingTouch(this, this.f44116l, this.f44115k);
                    }
                }
            } else if (actionMasked == 3) {
                removeCallbacks(this.f44125u);
                setCurrentProgress(this.f44120p);
                this.f44119o = false;
            }
            if (onTouchEvent || this.f44119o) {
                return true;
            }
            return false;
        }
        this.f44120p = this.f44116l;
        this.f44121q = (int) motionEvent.getX();
        this.f44119o = false;
        int unused = this.f44125u.f44126x = (int) motionEvent.getX();
        int unused2 = this.f44125u.f44127y = (int) motionEvent.getY();
        boolean unused3 = this.f44125u.isPost = false;
        postDelayed(this.f44125u, (long) this.f44123s);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f44105a;
        if (size < i3) {
            size = i3;
        }
        int i4 = this.f44107c;
        if (i4 < 0) {
            this.f44107c = (int) (((float) size) / this.f44111g);
        } else {
            size = (int) (((float) i4) * this.f44111g);
        }
        if (this.f44106b < 0) {
            this.f44106b = this.f44107c;
        }
        int i5 = this.f44106b;
        int i6 = this.f44108d;
        setMeasuredDimension((i5 * i6) + (this.f44109e * (i6 - 1)) + ((int) (((float) i5) * (this.f44111g - 1.0f))), size);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m32855a(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009c, code lost:
        if (r4 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r4 != null) goto L_0x00a1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m32855a(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.graphics.drawable.Drawable r2 = r0.f44110f
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r2 = r2 instanceof android.graphics.drawable.LayerDrawable
            if (r2 == 0) goto L_0x00e3
            r2 = 16908288(0x1020000, float:2.387723E-38)
            android.graphics.drawable.Drawable r2 = r0.m32852a((int) r2)
            r3 = 16908301(0x102000d, float:2.3877265E-38)
            android.graphics.drawable.Drawable r3 = r0.m32852a((int) r3)
            r4 = 2131430884(0x7f0b0de4, float:1.8483482E38)
            android.graphics.drawable.Drawable r4 = r0.m32852a((int) r4)
            int r5 = r0.f44106b
            int r6 = r0.f44107c
            int r7 = r0.f44109e
            int r8 = r0.f44108d
            float r9 = (float) r5
            float r10 = r0.f44111g
            r11 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 - r11
            float r9 = r9 * r10
            r10 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 / r10
            int r9 = (int) r9
            int r10 = r16.getHeight()
            int r10 = r10 - r6
            int r10 = r10 / 2
            int r6 = r6 + r10
            r13 = 0
        L_0x003e:
            if (r13 >= r8) goto L_0x006a
            int r14 = r5 + r7
            int r14 = r14 * r13
            int r14 = r14 + r9
            int r15 = r14 + r5
            r2.setBounds(r14, r10, r15, r6)
            r2.draw(r1)
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r11 = r0.f44118n
            java.lang.Object r11 = r11.get(r13)
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r11 = (com.didi.soda.customer.widget.CustomerSeekBar.StarData) r11
            if (r11 != 0) goto L_0x0062
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r11 = new com.didi.soda.customer.widget.CustomerSeekBar$StarData
            r12 = 0
            r11.<init>()
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r12 = r0.f44118n
            r12.put(r13, r11)
        L_0x0062:
            r11.set(r14, r10, r15, r6)
            int r13 = r13 + 1
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003e
        L_0x006a:
            int r2 = r0.f44116l
            int r6 = r0.f44115k
            int r7 = r0.f44114j
            int r8 = r6 - r7
            if (r2 >= r8) goto L_0x0086
            int r2 = r0.m32859b((int) r5)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r6 = r16.getHeight()
            r8 = 0
            r4.<init>(r8, r8, r2, r6)
            r1.clipRect(r4)
            goto L_0x00a2
        L_0x0086:
            r8 = 0
            if (r2 >= r6) goto L_0x009f
            int r6 = r6 - r7
            if (r2 < r6) goto L_0x009f
            int r2 = r0.m32859b((int) r5)
            android.graphics.Rect r6 = new android.graphics.Rect
            int r7 = r16.getHeight()
            r6.<init>(r8, r8, r2, r7)
            r1.clipRect(r6)
            if (r4 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x009f:
            if (r4 == 0) goto L_0x00a2
        L_0x00a1:
            r3 = r4
        L_0x00a2:
            float r2 = r0.f44112h
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r4
            float r4 = (float) r5
            float r2 = r2 * r4
            int r2 = (int) r2
            int r2 = r2 / 2
            r12 = 0
        L_0x00ae:
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r4 = r0.f44118n
            int r4 = r4.size()
            if (r12 >= r4) goto L_0x00e3
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r4 = r0.f44118n
            int r4 = r4.keyAt(r12)
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r5 = r0.f44118n
            java.lang.Object r4 = r5.get(r4)
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r4 = (com.didi.soda.customer.widget.CustomerSeekBar.StarData) r4
            int r5 = r4.left
            int r5 = r5 - r2
            int r6 = r4.top
            int r6 = r6 - r2
            int r7 = r4.right
            int r7 = r7 + r2
            int r4 = r4.bottom
            int r4 = r4 + r2
            r3.setBounds(r5, r6, r7, r4)
            float r4 = r0.f44113i
            r5 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 * r5
            int r4 = (int) r4
            r3.setAlpha(r4)
            r3.draw(r1)
            int r12 = r12 + 1
            goto L_0x00ae
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.CustomerSeekBar.m32855a(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    private void m32853a() {
        OnTrackListener onTrackListener;
        removeCallbacks(this.f44125u);
        if (!this.f44125u.isPost && (onTrackListener = this.f44117m) != null) {
            onTrackListener.onStartTrackingTouch(this, this.f44116l, this.f44115k);
        }
    }

    /* renamed from: a */
    private Drawable m32852a(int i) {
        Drawable drawable = this.f44110f;
        Drawable drawable2 = null;
        if (drawable != null) {
            this.f44110f = drawable.mutate();
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            if (drawable2 == null) {
                return drawable;
            }
        }
        return drawable2;
    }

    /* renamed from: b */
    private int m32859b(int i) {
        int i2 = (int) (((((float) this.f44116l) * 1.0f) / ((float) this.f44115k)) * ((float) (this.f44108d * i)));
        int i3 = i2 / i;
        StarData starData = this.f44118n.get(i3);
        if (starData == null) {
            return 0;
        }
        int i4 = i2 - (i3 * i);
        if (i4 == 0) {
            return Math.max(starData.left - (this.f44109e / 2), 0);
        }
        return starData.left + i4;
    }

    /* renamed from: a */
    private void m32856a(AttributeSet attributeSet) {
        this.f44122r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f44123s = ViewConfiguration.getTapTimeout();
        this.f44105a = m32862c(this.f44105a);
        this.f44109e = m32862c(this.f44109e);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerSeekBar);
            this.f44110f = obtainStyledAttributes.getDrawable(6);
            this.f44114j = obtainStyledAttributes.getInteger(4, this.f44115k / 5);
            this.f44108d = obtainStyledAttributes.getInteger(0, 5);
            this.f44109e = obtainStyledAttributes.getDimensionPixelOffset(2, this.f44109e);
            setCurrentProgress(obtainStyledAttributes.getInteger(5, 0));
            this.f44107c = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
            this.f44106b = obtainStyledAttributes.getDimensionPixelOffset(3, -1);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m32861b() {
        if (this.f44124t == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 2.0f});
            this.f44124t = ofFloat;
            ofFloat.setDuration(400);
            this.f44124t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CustomerSeekBar customerSeekBar = CustomerSeekBar.this;
                    float unused = customerSeekBar.f44112h = customerSeekBar.f44111g - ((CustomerSeekBar.this.f44111g - 1.0f) * Math.abs(1.0f - floatValue));
                    float unused2 = CustomerSeekBar.this.f44113i = Math.min(floatValue, 1.0f);
                    ViewCompat.postInvalidateOnAnimation(CustomerSeekBar.this);
                }
            });
        }
        if (this.f44124t.isRunning()) {
            this.f44124t.end();
        }
        this.f44124t.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32854a(int i, int i2) {
        int i3;
        StarData starData = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f44118n.size(); i7++) {
            int keyAt = this.f44118n.keyAt(i7);
            StarData starData2 = this.f44118n.get(keyAt);
            if (starData2.left < i && starData2.right >= i) {
                i5 = keyAt;
                starData = starData2;
            }
            i4 = Math.min(i4, starData2.left);
            i6 = Math.max(i6, starData2.right);
        }
        if (starData != null) {
            int i8 = this.f44106b;
            setCurrentProgress((int) (((((float) (((i5 * i8) + i) - starData.left)) * 1.0f) / ((float) (this.f44108d * i8))) * ((float) this.f44115k)));
        } else if (i <= i4) {
            if (this.f44116l != 0) {
                setCurrentProgress(0);
            }
        } else if (i >= i6 && this.f44116l != (i3 = this.f44115k)) {
            setCurrentProgress(i3);
        }
    }

    /* renamed from: c */
    private int m32862c(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public int getMaxProgress() {
        return this.f44115k;
    }

    private static class StarData {
        int bottom;
        int left;
        int right;
        int top;

        private StarData() {
        }

        /* access modifiers changed from: package-private */
        public void set(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }
    }

    private class BeginDragRunnable implements Runnable {
        /* access modifiers changed from: private */
        public boolean isPost;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public int f44126x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public int f44127y;

        private BeginDragRunnable() {
        }

        public void run() {
            this.isPost = true;
            CustomerSeekBar.this.m32854a(this.f44126x, this.f44127y);
            if (CustomerSeekBar.this.f44117m != null) {
                OnTrackListener b = CustomerSeekBar.this.f44117m;
                CustomerSeekBar customerSeekBar = CustomerSeekBar.this;
                b.onStartTrackingTouch(customerSeekBar, customerSeekBar.f44116l, CustomerSeekBar.this.f44115k);
            }
        }
    }
}
