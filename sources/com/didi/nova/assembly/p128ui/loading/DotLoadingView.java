package com.didi.nova.assembly.p128ui.loading;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.legacy.widget.Space;
import com.didi.passenger.C11267R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.nova.assembly.ui.loading.DotLoadingView */
public class DotLoadingView extends LinearLayout implements Animatable {

    /* renamed from: a */
    private static final String f31729a = "DotLoadingView";

    /* renamed from: b */
    private static final int f31730b = 1;

    /* renamed from: c */
    private static final int f31731c = 2;

    /* renamed from: d */
    private static final int f31732d = 350;

    /* renamed from: e */
    private static final int f31733e = 1400;

    /* renamed from: f */
    private static final float f31734f = 0.75f;

    /* renamed from: g */
    private static final int f31735g = 2131100431;

    /* renamed from: h */
    private static final int f31736h = 2131100433;

    /* renamed from: i */
    private static final int f31737i = 2131167088;

    /* renamed from: j */
    private static final int f31738j = 2131167090;

    /* renamed from: k */
    private static final int f31739k = 2131167089;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f31740l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f31741m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f31742n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f31743o;

    /* renamed from: p */
    private float f31744p;

    /* renamed from: q */
    private int f31745q;

    /* renamed from: r */
    private int f31746r;

    /* renamed from: s */
    private int f31747s;

    /* renamed from: t */
    private View f31748t;

    /* renamed from: u */
    private View f31749u;

    /* renamed from: v */
    private View f31750v;

    /* renamed from: w */
    private AnimatorSet f31751w;

    /* renamed from: x */
    private int f31752x = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.nova.assembly.ui.loading.DotLoadingView$LoadingMode */
    public @interface LoadingMode {
    }

    public DotLoadingView(Context context) {
        super(context);
        m24255a(context, (AttributeSet) null);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24255a(context, attributeSet);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24255a(context, attributeSet);
    }

    public void start() {
        stop();
        this.f31751w.start();
    }

    public void stop() {
        AnimatorSet animatorSet;
        if (isRunning() && (animatorSet = this.f31751w) != null) {
            animatorSet.cancel();
        }
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f31751w;
        return animatorSet != null && animatorSet.isRunning();
    }

    public void setColor(int i, int i2) {
        this.f31743o = i;
        this.f31742n = i2;
    }

    public void setMode(int i) {
        this.f31752x = i;
        m24259b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m24249a(this.f31745q, i), getDefaultSize(((int) this.f31740l) * 2, i2));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            start();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m24255a(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        setGravity(17);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.DotLoadingView, 0, 0);
            this.f31743o = obtainStyledAttributes.getColor(2, m24248a(f31736h));
            this.f31742n = obtainStyledAttributes.getColor(1, m24248a(f31735g));
            this.f31741m = obtainStyledAttributes.getDimension(8, m24256b(f31738j));
            this.f31740l = obtainStyledAttributes.getDimension(7, m24256b(f31737i));
            this.f31744p = obtainStyledAttributes.getDimension(5, m24256b(f31739k));
            this.f31752x = obtainStyledAttributes.getInt(6, 1);
            this.f31747s = 1400;
            this.f31746r = (int) (((float) (1400 / 4)) * 0.75f);
            float f = this.f31741m;
            this.f31745q = (int) ((this.f31744p * 2.0f) + (f * 2.0f * 3.0f) + ((this.f31740l - f) * 2.0f));
            obtainStyledAttributes.recycle();
        }
        this.f31748t = m24252a(context, this.f31741m, this.f31743o);
        this.f31749u = m24252a(context, this.f31741m, this.f31743o);
        this.f31750v = m24252a(context, this.f31741m, this.f31743o);
        addView(this.f31748t);
        addView(m24253a(context, (int) this.f31744p));
        addView(this.f31749u);
        addView(m24253a(context, (int) this.f31744p));
        addView(this.f31750v);
        m24254a();
    }

    /* renamed from: a */
    private void m24254a() {
        this.f31751w = new AnimatorSet();
        if (this.f31752x == 2) {
            ValueAnimator a = m24251a(this.f31748t, 0);
            ValueAnimator a2 = m24251a(this.f31749u, this.f31746r);
            ValueAnimator a3 = m24251a(this.f31750v, this.f31746r * 2);
            this.f31751w.playTogether(new Animator[]{a, a2, a3});
            return;
        }
        ValueAnimator b = m24258b(this.f31748t, 0);
        ValueAnimator b2 = m24258b(this.f31749u, this.f31746r);
        ValueAnimator b3 = m24258b(this.f31750v, this.f31746r * 2);
        this.f31751w.playTogether(new Animator[]{b, b2, b3});
    }

    /* renamed from: a */
    private ValueAnimator m24251a(View view, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration((long) this.f31747s);
        ofFloat.setStartDelay((long) i);
        return ofFloat;
    }

    /* renamed from: a */
    private int m24248a(int i) {
        if (i == 0) {
            return 0;
        }
        return ContextCompat.getColor(getContext(), i);
    }

    /* renamed from: b */
    private float m24256b(int i) {
        if (i == 0) {
            return 0.0f;
        }
        return getContext().getResources().getDimension(i);
    }

    /* renamed from: a */
    private View m24252a(Context context, float f, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(1);
        View view = new View(context);
        view.setBackground(gradientDrawable);
        int i2 = (int) (f * 2.0f);
        view.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        return view;
    }

    /* renamed from: a */
    private Space m24253a(Context context, int i) {
        Space space = new Space(context);
        space.setLayoutParams(new LinearLayout.LayoutParams(i, 1));
        return space;
    }

    /* renamed from: a */
    private int m24249a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.max(size, i);
        }
        if (mode != 1073741824) {
            return i;
        }
        return size;
    }

    /* renamed from: b */
    private ValueAnimator m24258b(final View view, int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 3.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration((long) this.f31747s);
        ofFloat.setStartDelay((long) i);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                float animatedFraction = valueAnimator.getAnimatedFraction() * 3.0f;
                if (animatedFraction > 1.0f) {
                    f = 0.0f;
                } else {
                    if (animatedFraction > 0.5f) {
                        animatedFraction = 1.0f - animatedFraction;
                    }
                    f = animatedFraction * 2.0f;
                }
                float a = (((DotLoadingView.this.f31740l - DotLoadingView.this.f31741m) * f) / DotLoadingView.this.f31741m) + 1.0f;
                view.setScaleX(a);
                view.setScaleY(a);
                DotLoadingView dotLoadingView = DotLoadingView.this;
                ((GradientDrawable) view.getBackground()).setColor(dotLoadingView.m24247a(f, dotLoadingView.f31743o, DotLoadingView.this.f31742n));
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m24247a(float f, int i, int i2) {
        int red = Color.red(i);
        int blue = Color.blue(i);
        int green = Color.green(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int blue2 = Color.blue(i2);
        int i3 = red2 - red;
        int i4 = blue2 - blue;
        int green2 = (int) (((float) green) + (((float) (Color.green(i2) - green)) * f));
        return Color.argb((int) (((float) alpha) + (f * ((float) (Color.alpha(i2) - alpha)))), (int) (((float) red) + (((float) i3) * f)), green2, (int) (((float) blue) + (((float) i4) * f)));
    }

    /* renamed from: b */
    private void m24259b() {
        m24254a();
    }
}
