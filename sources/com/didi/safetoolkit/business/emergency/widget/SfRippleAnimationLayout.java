package com.didi.safetoolkit.business.emergency.widget;

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
    private static final int f37116a = 2;

    /* renamed from: b */
    private static final int f37117b = 1500;

    /* renamed from: c */
    private static final float f37118c = 1.8f;

    /* renamed from: d */
    private static final float f37119d = 0.0f;

    /* renamed from: e */
    private static final float f37120e = 110.0f;

    /* renamed from: f */
    private int f37121f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f37122g;

    /* renamed from: h */
    private float f37123h;

    /* renamed from: i */
    private int f37124i;

    /* renamed from: j */
    private int f37125j;

    /* renamed from: k */
    private int f37126k;

    /* renamed from: l */
    private float f37127l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Paint f37128m;

    /* renamed from: n */
    private boolean f37129n;

    /* renamed from: o */
    private AnimatorSet f37130o;

    /* renamed from: p */
    private ArrayList<RippleView> f37131p;

    public SfRippleAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SfRippleAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37129n = false;
        this.f37131p = new ArrayList<>();
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SfRippleAnimationLayout);
            this.f37121f = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.sf_color_6FFF525D));
            this.f37122g = obtainStyledAttributes.getDimension(5, 0.0f);
            this.f37123h = obtainStyledAttributes.getDimension(3, f37120e);
            this.f37124i = obtainStyledAttributes.getInt(2, 1500);
            this.f37125j = obtainStyledAttributes.getInt(1, 2);
            this.f37127l = obtainStyledAttributes.getFloat(4, f37118c);
            obtainStyledAttributes.recycle();
            this.f37126k = this.f37124i / this.f37125j;
            Paint paint = new Paint(1);
            this.f37128m = paint;
            if (this.f37122g > 0.0f) {
                paint.setStyle(Paint.Style.STROKE);
            } else {
                paint.setStyle(Paint.Style.FILL);
            }
            this.f37128m.setColor(this.f37121f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f37130o = animatorSet;
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            float f = this.f37123h;
            float f2 = this.f37122g;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f + f2) * 2.0f), (int) ((f + f2) * 2.0f));
            layoutParams.addRule(13, -1);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f37125j; i++) {
                RippleView rippleView = new RippleView(getContext());
                addView(rippleView, layoutParams);
                this.f37131p.add(rippleView);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", new float[]{1.0f, this.f37127l});
                ofFloat.setRepeatCount(-1);
                ofFloat.setRepeatMode(1);
                ofFloat.setStartDelay((long) (this.f37126k * i));
                ofFloat.setDuration((long) this.f37124i);
                arrayList.add(ofFloat);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", new float[]{1.0f, this.f37127l});
                ofFloat2.setRepeatCount(-1);
                ofFloat2.setRepeatMode(1);
                ofFloat2.setStartDelay((long) (this.f37126k * i));
                ofFloat2.setDuration((long) this.f37124i);
                arrayList.add(ofFloat2);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", new float[]{1.0f, 0.0f});
                ofFloat3.setRepeatCount(-1);
                ofFloat3.setRepeatMode(1);
                ofFloat3.setStartDelay((long) (this.f37126k * i));
                ofFloat3.setDuration((long) this.f37124i);
                arrayList.add(ofFloat3);
            }
            this.f37130o.playTogether(arrayList);
        }
    }

    public void startRippleAnimation() {
        if (!isRippleAnimationRunning()) {
            Iterator<RippleView> it = this.f37131p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
            this.f37130o.start();
            this.f37129n = true;
        }
    }

    public void stopRippleAnimation() {
        if (isRippleAnimationRunning()) {
            this.f37130o.end();
            this.f37129n = false;
            Iterator<RippleView> it = this.f37131p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(4);
            }
        }
    }

    public boolean isRippleAnimationRunning() {
        return this.f37129n;
    }

    private class RippleView extends View {
        public RippleView(Context context) {
            super(context);
            setVisibility(4);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, min - SfRippleAnimationLayout.this.f37122g, SfRippleAnimationLayout.this.f37128m);
        }
    }
}
