package com.didi.soda.home.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class SubscribeButton extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GradientDrawable f45862a;

    /* renamed from: b */
    private TextView f45863b;

    /* renamed from: c */
    private TextView f45864c;

    /* renamed from: d */
    private TextView f45865d;

    /* renamed from: e */
    private LottieLoadingView f45866e;

    /* renamed from: f */
    private Drawable f45867f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f45868g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f45869h;

    /* renamed from: i */
    private int f45870i;

    /* renamed from: j */
    private float f45871j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f45872k = false;

    /* renamed from: l */
    private boolean f45873l = false;

    public SubscribeButton(Context context) {
        super(context);
        m34015a();
    }

    public SubscribeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34015a();
    }

    public SubscribeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34015a();
    }

    public boolean isSubscribed() {
        return this.f45873l;
    }

    public void playAnimation() {
        this.f45873l = true;
        post(new Runnable() {
            public final void run() {
                SubscribeButton.this.m34023c();
            }
        });
    }

    public void setSubscribeText(String str, String str2) {
        this.f45865d.setText(str);
        this.f45864c.setText(str2);
    }

    public void hideLoading() {
        this.f45866e.setVisibility(8);
        this.f45866e.stop();
        this.f45865d.setVisibility(0);
    }

    public void loading() {
        this.f45866e.setVisibility(0);
        this.f45866e.start();
        this.f45865d.setVisibility(4);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(new View.OnClickListener(onClickListener) {
            public final /* synthetic */ View.OnClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SubscribeButton.this.m34018a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34018a(View.OnClickListener onClickListener, View view) {
        if (!this.f45866e.isRunning() && onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.f45862a;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m34015a() {
        this.f45868g = ContextCompat.getColor(getContext(), R.color.rf_color_jianbian_1);
        this.f45869h = ContextCompat.getColor(getContext(), R.color.rf_color_jianbian_2);
        this.f45870i = ContextCompat.getColor(getContext(), R.color.rf_color_brands_1_100);
        this.f45871j = (float) DisplayUtils.dip2px(getContext(), 4.0f);
        setBackgroundResource(R.drawable.customer_skin_selector_bottom_btn_bg);
        this.f45867f = ContextCompat.getDrawable(getContext(), R.drawable.customer_skin_shap_circle_bg);
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_subsrcibe_btn, this);
        this.f45863b = (TextView) findViewById(R.id.customer_tv_select);
        this.f45864c = (TextView) findViewById(R.id.customer_tv_sub_middle_text);
        this.f45865d = (TextView) findViewById(R.id.customer_tv_middle_text);
        this.f45866e = (LottieLoadingView) findViewById(R.id.customer_custom_loading);
        this.f45864c.setAlpha(0.0f);
        this.f45863b.setAlpha(0.0f);
        this.f45865d.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
    }

    /* renamed from: a */
    private void m34016a(float f) {
        this.f45863b.setAlpha(f);
        this.f45864c.setAlpha(f);
        this.f45865d.setAlpha(1.0f - f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34021b() {
        this.f45863b.setBackground(this.f45867f);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34023c() {
        if (!this.f45872k) {
            Drawable background = getBackground();
            setBackground((Drawable) null);
            if (background instanceof StateListDrawable) {
                Drawable current = background.getCurrent();
                if (current instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) current;
                    this.f45862a = gradientDrawable;
                    Rect copyBounds = gradientDrawable.copyBounds();
                    Rect rect = new Rect(this.f45863b.getLeft(), this.f45863b.getTop(), this.f45863b.getRight(), this.f45863b.getBottom());
                    final AnimationValue create = AnimationValue.create(copyBounds, this.f45871j, this.f45868g, this.f45869h);
                    int i = this.f45870i;
                    AnimationValue create2 = AnimationValue.create(rect, (((float) rect.width()) * 1.0f) / 2.0f, i, i);
                    ValueAnimator ofObject = ValueAnimator.ofObject(new AnimationValueEvaluator(), new Object[]{create, create2});
                    ofObject.setInterpolator(CustomerInterpolator.newInstance());
                    ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SubscribeButton.this.m34017a(valueAnimator);
                        }
                    });
                    ofObject.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            SubscribeButton.this.f45862a.setBounds(create.mRect);
                            SubscribeButton.this.f45862a.setCornerRadius(create.mRadius);
                            SubscribeButton.this.f45862a.setColors(new int[]{SubscribeButton.this.f45868g, SubscribeButton.this.f45869h});
                            GradientDrawable unused = SubscribeButton.this.f45862a = null;
                            ViewCompat.postInvalidateOnAnimation(SubscribeButton.this);
                            SubscribeButton.this.m34021b();
                            boolean unused2 = SubscribeButton.this.f45872k = false;
                        }
                    });
                    ofObject.setDuration(300);
                    ofObject.start();
                    this.f45872k = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34017a(ValueAnimator valueAnimator) {
        m34016a(valueAnimator.getAnimatedFraction());
        AnimationValue animationValue = (AnimationValue) valueAnimator.getAnimatedValue();
        this.f45862a.setCornerRadius(animationValue.mRadius);
        this.f45862a.setBounds(animationValue.mRect);
        this.f45862a.setColors(new int[]{animationValue.mStartColor, animationValue.mEndColor});
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private static class AnimationValueEvaluator implements TypeEvaluator<AnimationValue> {
        ArgbEvaluator mArgbEvaluator;
        Rect mRect;
        AnimationValue mValue;

        private AnimationValueEvaluator() {
            this.mValue = new AnimationValue();
            this.mArgbEvaluator = new ArgbEvaluator();
        }

        public AnimationValue evaluate(float f, AnimationValue animationValue, AnimationValue animationValue2) {
            this.mValue.set(evaluateRect(f, animationValue.mRect, animationValue2.mRect), animationValue.mRadius + ((animationValue2.mRadius - animationValue.mRadius) * f), ((Integer) this.mArgbEvaluator.evaluate(f, Integer.valueOf(animationValue.mStartColor), Integer.valueOf(animationValue2.mStartColor))).intValue(), ((Integer) this.mArgbEvaluator.evaluate(f, Integer.valueOf(animationValue.mEndColor), Integer.valueOf(animationValue2.mEndColor))).intValue());
            return this.mValue;
        }

        private Rect evaluateRect(float f, Rect rect, Rect rect2) {
            int i = rect.left + ((int) (((float) (rect2.left - rect.left)) * f));
            int i2 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f));
            int i3 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f));
            int i4 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f));
            Rect rect3 = this.mRect;
            if (rect3 == null) {
                return new Rect(i, i2, i3, i4);
            }
            rect3.set(i, i2, i3, i4);
            return this.mRect;
        }
    }

    private static class AnimationValue {
        int mEndColor;
        float mRadius;
        Rect mRect;
        int mStartColor;

        private AnimationValue() {
        }

        static AnimationValue create(Rect rect, float f, int i, int i2) {
            AnimationValue animationValue = new AnimationValue();
            animationValue.mRect = rect;
            animationValue.mRadius = f;
            animationValue.mStartColor = i;
            animationValue.mEndColor = i2;
            return animationValue;
        }

        public void set(Rect rect, float f, int i, int i2) {
            this.mRect = rect;
            this.mRadius = f;
            this.mStartColor = i;
            this.mEndColor = i2;
        }
    }
}
