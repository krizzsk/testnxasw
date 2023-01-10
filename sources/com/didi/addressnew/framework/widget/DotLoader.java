package com.didi.addressnew.framework.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.passenger.C11267R;
import java.lang.ref.WeakReference;

public class DotLoader extends View {

    /* renamed from: b */
    private static final int f9251b = 80;

    /* renamed from: c */
    private static final int f9252c = 500;

    /* renamed from: d */
    private static final int f9253d = 500;

    /* renamed from: a */
    Integer[] f9254a;

    /* renamed from: e */
    private C3852b[] f9255e;

    /* renamed from: f */
    private int f9256f;

    /* renamed from: g */
    private Rect f9257g;

    /* renamed from: h */
    private float f9258h;

    /* renamed from: i */
    private float f9259i;

    /* renamed from: j */
    private float f9260j;

    /* renamed from: k */
    private Interpolator f9261k = new LoadingInterpolator(0.62f, 0.28f, 0.23f, 0.99f);

    public void setNumberOfDots(int i) {
        C3852b[] bVarArr = new C3852b[i];
        initAnimation();
        C3852b[] bVarArr2 = this.f9255e;
        if (i <= bVarArr2.length) {
            System.arraycopy(bVarArr2, 0, bVarArr, 0, i);
            for (C3852b bVar : this.f9255e) {
                bVar.f9273f.start();
                bVar.f9274g.start();
            }
        } else {
            System.arraycopy(bVarArr2, 0, bVarArr, 0, bVarArr2.length);
            for (int i2 = 0; i2 < i; i2++) {
                bVarArr[i2] = new C3852b(this, this.f9256f, i2);
                int i3 = i2 - 1;
                bVarArr[i2].f9270c = bVarArr[i3 < 0 ? 0 : i3].f9270c + this.f9258h;
                bVarArr[i2].f9271d = bVarArr[i3 < 0 ? 0 : i3].f9271d / 2.0f;
                C3852b bVar2 = bVarArr[i2];
                if (i3 < 0) {
                    i3 = 0;
                }
                bVar2.mo43995a(bVarArr[i3].f9268a);
                bVarArr[i2].f9273f = m8051b(bVarArr[0].f9273f, bVarArr[i2]);
                bVarArr[i2].f9274g = m8044a(bVarArr[0].f9274g, bVarArr[i2]);
                bVarArr[i2].f9273f.start();
            }
        }
        this.f9255e = bVarArr;
    }

    /* renamed from: a */
    private ValueAnimator m8044a(ValueAnimator valueAnimator, C3852b bVar) {
        ValueAnimator clone = valueAnimator.clone();
        clone.removeAllUpdateListeners();
        clone.addUpdateListener(new DotColorUpdater(bVar, this));
        return clone;
    }

    /* renamed from: b */
    private ValueAnimator m8051b(ValueAnimator valueAnimator, C3852b bVar) {
        ValueAnimator clone = valueAnimator.clone();
        clone.removeAllUpdateListeners();
        clone.addUpdateListener(new DotYUpdater(bVar, this));
        clone.setStartDelay((long) (bVar.f9272e * 80));
        clone.removeAllListeners();
        clone.addListener(new C3851a(bVar, this.f9254a));
        return clone;
    }

    public void resetColors() {
        for (C3852b a : this.f9255e) {
            a.mo43995a(0);
        }
    }

    public DotLoader(Context context) {
        super(context);
        m8049a(context, (AttributeSet) null);
    }

    public DotLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8049a(context, attributeSet);
    }

    public DotLoader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8049a(context, attributeSet);
    }

    public DotLoader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m8049a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8049a(Context context, AttributeSet attributeSet) {
        Integer[] numArr;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.DotLoader, 0, 0);
            try {
                float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
                int integer = obtainStyledAttributes.getInteger(2, 1);
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId == 0) {
                    numArr = new Integer[integer];
                    for (int i = 0; i < integer; i++) {
                        numArr[i] = 0;
                    }
                } else {
                    int[] intArray = getResources().getIntArray(resourceId);
                    Integer[] numArr2 = new Integer[intArray.length];
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        numArr2[i2] = Integer.valueOf(intArray[i2]);
                    }
                    numArr = numArr2;
                }
                m8048a(integer, numArr, (int) dimension);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8046a() {
        for (C3852b bVar : this.f9255e) {
            bVar.f9273f.end();
            bVar.f9274g.end();
        }
    }

    /* renamed from: a */
    private void m8048a(int i, Integer[] numArr, int i2) {
        this.f9254a = numArr;
        this.f9257g = new Rect(0, 0, 0, 0);
        this.f9255e = new C3852b[i];
        this.f9256f = i2;
        for (int i3 = 0; i3 < i; i3++) {
            this.f9255e[i3] = new C3852b(this, i2, i3);
        }
    }

    public void initAnimation() {
        int length = this.f9255e.length;
        for (int i = 0; i < length; i++) {
            C3852b[] bVarArr = this.f9255e;
            bVarArr[i].f9273f = m8045a(bVarArr[i]);
            this.f9255e[i].f9273f.setStartDelay((long) (i * 80));
            C3852b[] bVarArr2 = this.f9255e;
            bVarArr2[i].f9274g = m8052b(bVarArr2[i]);
        }
    }

    /* renamed from: b */
    private void m8053b() {
        postDelayed(new Runnable() {
            public void run() {
                DotLoader.this.m8057d();
            }
        }, 10);
    }

    /* renamed from: c */
    private void m8055c() {
        post(new Runnable() {
            public void run() {
                DotLoader.this.m8046a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8057d() {
        initAnimation();
        for (C3852b bVar : this.f9255e) {
            bVar.f9273f.start();
        }
    }

    /* renamed from: a */
    private ValueAnimator m8045a(C3852b bVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f9259i, this.f9260j});
        ofFloat.setInterpolator(this.f9261k);
        ofFloat.setDuration(500);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.addUpdateListener(new DotYUpdater(bVar, this));
        ofFloat.addListener(new C3851a(bVar, this.f9254a));
        return ofFloat;
    }

    /* renamed from: b */
    private ValueAnimator m8052b(C3852b bVar) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{this.f9254a[bVar.f9268a], this.f9254a[bVar.mo43999c()]});
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.setDuration(500);
        ofObject.addUpdateListener(new DotColorUpdater(bVar, this));
        return ofObject;
    }

    private static class DotColorUpdater implements ValueAnimator.AnimatorUpdateListener {
        private C3852b mDot;
        private WeakReference<DotLoader> mDotLoaderRef;

        private DotColorUpdater(C3852b bVar, DotLoader dotLoader) {
            this.mDot = bVar;
            this.mDotLoaderRef = new WeakReference<>(dotLoader);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mDot.mo43998b(((Integer) valueAnimator.getAnimatedValue()).intValue());
            DotLoader dotLoader = (DotLoader) this.mDotLoaderRef.get();
            if (dotLoader != null) {
                dotLoader.m8058e();
            }
        }
    }

    private static class DotYUpdater implements ValueAnimator.AnimatorUpdateListener {
        private C3852b mDot;
        private WeakReference<DotLoader> mDotLoaderRef;

        private DotYUpdater(C3852b bVar, DotLoader dotLoader) {
            this.mDot = bVar;
            this.mDotLoaderRef = new WeakReference<>(dotLoader);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mDot.f9271d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DotLoader dotLoader = (DotLoader) this.mDotLoaderRef.get();
            if (dotLoader != null) {
                dotLoader.m8058e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8058e() {
        Rect rect = this.f9257g;
        if (rect == null || rect.left == 0 || this.f9257g.top == 0 || this.f9257g.right == 0 || this.f9257g.bottom == 0) {
            invalidate();
        } else {
            invalidate(this.f9257g);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f9257g);
        for (C3852b a : this.f9255e) {
            a.mo43996a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        m8047a(size);
        this.f9258h = m8059f();
        int i3 = this.f9256f * 14;
        int length = this.f9255e.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f9255e[i4].f9270c = ((float) (this.f9256f * 3)) + (((float) i4) * this.f9258h);
            this.f9255e[i4].f9271d = (float) (size / 2);
        }
        int i5 = size / 2;
        int i6 = this.f9256f;
        this.f9259i = (float) (i5 - (i6 * 1));
        this.f9260j = (float) (i5 + (i6 * 1));
        for (C3852b bVar : this.f9255e) {
            bVar.f9269b = this.f9256f;
        }
        setMeasuredDimension(i3, size);
    }

    /* renamed from: a */
    private void m8047a(int i) {
        this.f9256f = ((i - getPaddingTop()) - getPaddingBottom()) / 20;
    }

    /* renamed from: f */
    private float m8059f() {
        return (float) (this.f9256f * 4);
    }
}
