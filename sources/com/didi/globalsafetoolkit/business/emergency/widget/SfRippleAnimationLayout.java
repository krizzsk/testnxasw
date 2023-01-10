package com.didi.globalsafetoolkit.business.emergency.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class SfRippleAnimationLayout extends RelativeLayout {

    /* renamed from: a */
    private static final int f25010a = 2;

    /* renamed from: b */
    private static final int f25011b = 1500;

    /* renamed from: c */
    private static final float f25012c = 1.8f;

    /* renamed from: d */
    private static final float f25013d = 0.0f;

    /* renamed from: e */
    private static final float f25014e = 110.0f;

    /* renamed from: f */
    private int f25015f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f25016g;

    /* renamed from: h */
    private float f25017h;

    /* renamed from: i */
    private int f25018i;

    /* renamed from: j */
    private int f25019j;

    /* renamed from: k */
    private int f25020k;

    /* renamed from: l */
    private float f25021l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Paint f25022m;

    /* renamed from: n */
    private boolean f25023n;

    /* renamed from: o */
    private AnimatorSet f25024o;

    /* renamed from: p */
    private ArrayList<RippleView> f25025p;

    public SfRippleAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SfRippleAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25023n = false;
        this.f25025p = new ArrayList<>();
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SfRippleAnimationLayout);
            this.f25015f = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.sf_color_6FFF525D));
            this.f25016g = obtainStyledAttributes.getDimension(5, 0.0f);
            this.f25017h = obtainStyledAttributes.getDimension(3, f25014e);
            this.f25018i = obtainStyledAttributes.getInt(2, 1500);
            this.f25019j = obtainStyledAttributes.getInt(1, 2);
            this.f25021l = obtainStyledAttributes.getFloat(4, f25012c);
            obtainStyledAttributes.recycle();
            this.f25020k = this.f25018i / this.f25019j;
            Paint paint = new Paint(1);
            this.f25022m = paint;
            if (this.f25016g > 0.0f) {
                paint.setStyle(Paint.Style.STROKE);
            } else {
                paint.setStyle(Paint.Style.FILL);
            }
            this.f25022m.setColor(this.f25015f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25024o = animatorSet;
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            float f = this.f25017h;
            float f2 = this.f25016g;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f + f2) * 2.0f), (int) ((f + f2) * 2.0f));
            layoutParams.addRule(13, -1);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f25019j; i++) {
                RippleView rippleView = new RippleView(getContext());
                addView(rippleView, layoutParams);
                this.f25025p.add(rippleView);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", new float[]{1.0f, this.f25021l});
                ofFloat.setRepeatCount(-1);
                ofFloat.setRepeatMode(1);
                ofFloat.setStartDelay((long) (this.f25020k * i));
                ofFloat.setDuration((long) this.f25018i);
                arrayList.add(ofFloat);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", new float[]{1.0f, this.f25021l});
                ofFloat2.setRepeatCount(-1);
                ofFloat2.setRepeatMode(1);
                ofFloat2.setStartDelay((long) (this.f25020k * i));
                ofFloat2.setDuration((long) this.f25018i);
                arrayList.add(ofFloat2);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", new float[]{1.0f, 0.0f});
                ofFloat3.setRepeatCount(-1);
                ofFloat3.setRepeatMode(1);
                ofFloat3.setStartDelay((long) (this.f25020k * i));
                ofFloat3.setDuration((long) this.f25018i);
                arrayList.add(ofFloat3);
            }
            this.f25024o.playTogether(arrayList);
        }
    }

    public void startRippleAnimation() {
        if (!isRippleAnimationRunning()) {
            Iterator<RippleView> it = this.f25025p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
            this.f25024o.start();
            this.f25023n = true;
        }
    }

    public void stopRippleAnimation() {
        if (isRippleAnimationRunning()) {
            this.f25024o.end();
            this.f25023n = false;
            Iterator<RippleView> it = this.f25025p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(4);
            }
        }
    }

    public boolean isRippleAnimationRunning() {
        return this.f25023n;
    }

    private class RippleView extends View {
        public RippleView(Context context) {
            super(context);
            setVisibility(4);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, min - SfRippleAnimationLayout.this.f25016g, SfRippleAnimationLayout.this.f25022m);
        }
    }
}
