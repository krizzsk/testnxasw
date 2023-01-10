package com.didi.global.globaluikit.button;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class LEGOLoadingButton extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f24265a = LEGOLoadingButton.class.getSimpleName();

    /* renamed from: b */
    private Context f24266b;

    /* renamed from: c */
    private String f24267c;

    /* renamed from: d */
    private ColorStateList f24268d;

    /* renamed from: e */
    private int f24269e;

    /* renamed from: f */
    private String f24270f;

    /* renamed from: g */
    private int f24271g;

    /* renamed from: h */
    private Drawable f24272h;

    /* renamed from: i */
    private View f24273i;

    /* renamed from: j */
    private FrameLayout f24274j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f24275k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LottieAnimationView f24276l;

    /* renamed from: m */
    private boolean f24277m;

    /* renamed from: n */
    private int f24278n;

    /* renamed from: o */
    private ValueAnimator f24279o;

    /* renamed from: p */
    private ObjectAnimator f24280p;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadingLottieAssertRes {
        public static final String _99_button_loading_main_json = "_99_button_loading_main_json.json";
        public static final String _global_button_loading_main_json = "_global_button_loading_main_json.json";
        public static final String button_loading_secondary_json = "button_loading_secondary_json.json";
    }

    public LEGOLoadingButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOLoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOLoadingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24277m = false;
        this.f24278n = 0;
        this.f24266b = context;
        setLayerType(1, (Paint) null);
        m19544a(context, attributeSet);
        m19546b();
    }

    /* renamed from: a */
    private void m19544a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.LEGOLoadingButton);
        this.f24270f = obtainStyledAttributes.getString(1);
        this.f24271g = obtainStyledAttributes.getResourceId(2, 0);
        this.f24267c = obtainStyledAttributes.getString(3);
        this.f24268d = obtainStyledAttributes.getColorStateList(4);
        this.f24269e = (int) obtainStyledAttributes.getDimension(5, 0.0f);
        this.f24272h = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m19546b() {
        View inflate = LayoutInflater.from(this.f24266b).inflate(R.layout.globaluikit_button_layout, this, false);
        this.f24273i = inflate;
        this.f24274j = (FrameLayout) inflate.findViewById(R.id.globaluikit_btn_root);
        this.f24275k = (TextView) this.f24273i.findViewById(R.id.globaluikit_btn_text);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f24273i.findViewById(R.id.globaluikit_btn_lav);
        this.f24276l = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        if (!TextUtils.isEmpty(this.f24270f)) {
            this.f24276l.setAnimation(this.f24270f);
        } else {
            int i = this.f24271g;
            if (i != 0) {
                this.f24276l.setAnimation(i);
            }
        }
        setButtonText(this.f24267c);
        setButtonTextColor(this.f24268d);
        setButtonTextSize((float) UnitUtils.px2sp(this.f24266b, (float) this.f24269e));
        setButtonBackground(this.f24272h);
        setBackground(this.f24272h);
        addView(this.f24273i);
    }

    public void setLoading(boolean z) {
        if (this.f24277m != z) {
            String str = f24265a;
            SystemUtils.log(3, str, "setLoading: isLoading " + this.f24277m + " loading " + z, (Throwable) null, "com.didi.global.globaluikit.button.LEGOLoadingButton", 306);
            if (z) {
                int textSize = (int) this.f24275k.getTextSize();
                this.f24278n = textSize;
                ValueAnimator duration = ValueAnimator.ofInt(new int[]{textSize, textSize / 2}).setDuration(500);
                this.f24279o = duration;
                duration.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
                this.f24279o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        String a = LEGOLoadingButton.f24265a;
                        SystemUtils.log(3, a, "onAnimationUpdate: size -> " + intValue, (Throwable) null, "com.didi.global.globaluikit.button.LEGOLoadingButton$1", 320);
                        LEGOLoadingButton.this.f24275k.setTextSize(0, (float) intValue);
                    }
                });
                this.f24279o.start();
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f24275k, "alpha", new float[]{1.0f, 0.0f}).setDuration(500);
                this.f24280p = duration2;
                duration2.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
                this.f24280p.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        LEGOLoadingButton.this.f24276l.setVisibility(0);
                        LEGOLoadingButton.this.f24276l.playAnimation();
                    }
                });
                this.f24280p.start();
            } else {
                ValueAnimator valueAnimator = this.f24279o;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f24279o.cancel();
                }
                ObjectAnimator objectAnimator = this.f24280p;
                if (objectAnimator != null && objectAnimator.isRunning()) {
                    this.f24280p.cancel();
                }
                if (this.f24276l.isAnimating()) {
                    this.f24276l.cancelAnimation();
                    this.f24276l.setVisibility(8);
                }
                this.f24275k.setTextSize(0, (float) this.f24278n);
                this.f24275k.setAlpha(1.0f);
            }
            this.f24277m = z;
        }
    }

    public void setLottieRes(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f24276l.setAnimation(str);
        }
    }

    public void setLottieRawRes(int i) {
        if (i != 0) {
            this.f24276l.setAnimation(i);
        }
    }

    public void setButtonText(String str) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setButtonBackground(Drawable drawable) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setBackground(drawable);
        }
        setBackground(drawable);
    }

    public void setButtonEnable(boolean z) {
        if (!this.f24277m || !z) {
            TextView textView = this.f24275k;
            if (textView != null) {
                textView.setEnabled(z);
            }
            setEnabled(z);
        }
    }

    public void setButtonClickable(boolean z) {
        if (!this.f24277m || !z) {
            TextView textView = this.f24275k;
            if (textView != null) {
                textView.setClickable(z);
            }
            setClickable(z);
        }
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setButtonTextSize(float f) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setTextSize(f);
            this.f24278n = (int) this.f24275k.getTextSize();
        }
    }

    public void setButtonTextStyle(Typeface typeface, int i) {
        TextView textView = this.f24275k;
        if (textView != null) {
            textView.setTypeface(typeface, i);
        }
    }
}
