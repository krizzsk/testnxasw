package com.didi.map.global.component.departure.pin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.common.map.Map;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.PinStyle;
import com.taxis99.R;

public class DeparturePinView extends RelativeLayout implements IDeparturePinView {

    /* renamed from: a */
    private static final String f27510a = "DeparturePinView";

    /* renamed from: b */
    private static final String f27511b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f27512c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f27513d;

    /* renamed from: e */
    private RelativeLayout f27514e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f27515f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f27516g;

    /* renamed from: h */
    private View f27517h;

    /* renamed from: i */
    private int f27518i;

    /* renamed from: j */
    private int f27519j;

    /* renamed from: k */
    private boolean f27520k;

    /* renamed from: l */
    private AnimatorSet f27521l;

    /* renamed from: m */
    private AnimationSet f27522m;

    /* renamed from: n */
    private AnimationSet f27523n;

    /* renamed from: o */
    private Context f27524o;

    /* renamed from: p */
    private Map f27525p;

    /* renamed from: q */
    private PinStyle f27526q;

    public DeparturePinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DeparturePinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DeparturePinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27520k = false;
        m21767a(context);
    }

    /* renamed from: a */
    private void m21767a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_departure_pin_view, this);
        this.f27513d = (PinView) inflate.findViewById(R.id.pin);
        this.f27514e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f27515f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f27516g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f27515f.setAnimation(f27511b);
        this.f27515f.setRepeatCount(-1);
        this.f27516g.setAnimation(f27512c);
        this.f27516g.setRepeatCount(0);
        this.f27518i = this.f27513d.getBigCircleWidth();
        this.f27519j = this.f27513d.getBigCircleHeight();
        startDragging_Ex();
        this.f27524o = context;
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f27513d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m21774c();
            m21779f();
            this.f27514e.removeView(this.f27517h);
            this.f27517h = null;
            m21765a(this.f27513d.getDraggingWidth(), this.f27513d.getDraggingHeight(), false, j);
            this.f27513d.toDragging();
            this.f27520k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f27513d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m21771b();
            m21779f();
            this.f27514e.removeView(this.f27517h);
            this.f27517h = null;
            m21765a(this.f27513d.getLoadingWidth(), this.f27513d.getLoadingHeight(), true, 400);
            this.f27513d.toLoading();
            this.f27520k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f27513d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f27513d.getText())) {
            setPinStartEndColor(false);
            m21774c();
            m21779f();
            this.f27514e.removeView(this.f27517h);
            this.f27517h = null;
            this.f27513d.showText(str);
            m21765a(this.f27513d.getNormalWidth(), this.f27513d.getNormalHeight(), false, 400);
            this.f27520k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0) {
            setPinStartEndColor(false);
            m21774c();
            m21779f();
            this.f27514e.removeView(this.f27517h);
            this.f27517h = view;
            if (this.f27514e.indexOfChild(view) < 0) {
                this.f27514e.addView(view);
            }
            m21765a(i, i2, true, 400);
            this.f27513d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f27520k = false;
        }
    }

    public void toNoParking() {
        if (!this.f27520k) {
            setPinStartEndColor(true);
            m21774c();
            m21778e();
            this.f27514e.removeView(this.f27517h);
            this.f27517h = null;
            int draggingWidth = this.f27513d.getDraggingWidth();
            int draggingHeight = this.f27513d.getDraggingHeight();
            m21765a(draggingWidth, draggingHeight, false, 400);
            this.f27513d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f27520k = true;
        }
    }

    public Rect getWindowPosition() {
        return new Rect(getLeft(), getTop(), getRight(), getBottom() - DisplayUtils.dp2px(this.f27524o, 20.0f));
    }

    public void stopAnimation() {
        this.f27513d.stopAnimation();
        if (this.f27515f.isAnimating()) {
            this.f27515f.cancelAnimation();
        }
        if (this.f27516g.isAnimating()) {
            this.f27516g.cancelAnimation();
        }
        m21764a();
        m21777d();
        m21780g();
    }

    /* renamed from: a */
    private void m21765a(int i, int i2, boolean z, long j) {
        m21764a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27521l = animatorSet;
        animatorSet.setDuration(j);
        this.f27521l.playTogether(new Animator[]{m21761a(this.f27518i, i), m21768b(this.f27519j, i2), m21762a(z)});
        this.f27521l.start();
    }

    /* renamed from: a */
    private void m21764a() {
        AnimatorSet animatorSet = this.f27521l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f27521l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m21761a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m21776c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21776c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27518i = intValue;
        m21775c(intValue, this.f27519j);
    }

    /* renamed from: b */
    private ValueAnimator m21768b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m21772b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21772b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27519j = intValue;
        m21775c(this.f27518i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m21762a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeparturePinView.this.m21766a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21766a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f27514e.setAlpha(floatValue);
        View view = this.f27517h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f27513d;
        pinView.setPinStartEndColor(this.f27520k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f27513d.getNoParkingColor() : this.f27513d.getNormalColor());
    }

    /* renamed from: c */
    private void m21775c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f27514e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f27514e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m21771b() {
        m21777d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f27522m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                DeparturePinView.this.f27515f.setProgress(0.0f);
                DeparturePinView.this.f27515f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                DeparturePinView.this.f27515f.playAnimation();
            }
        });
        this.f27522m.addAnimation(m21773c(true));
        this.f27522m.addAnimation(m21769b(true));
        this.f27522m.setDuration(400);
        this.f27522m.setFillAfter(true);
        this.f27515f.startAnimation(this.f27522m);
    }

    /* renamed from: c */
    private void m21774c() {
        if (this.f27515f.getVisibility() == 0 || this.f27515f.isShown()) {
            m21777d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27522m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f27515f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f27515f.setVisibility(4);
                    DeparturePinView.this.f27515f.setProgress(0.0f);
                }
            });
            this.f27522m.addAnimation(m21773c(false));
            this.f27522m.addAnimation(m21769b(false));
            this.f27522m.setDuration(400);
            this.f27522m.setFillAfter(true);
            this.f27515f.startAnimation(this.f27522m);
            return;
        }
        this.f27515f.setVisibility(4);
    }

    /* renamed from: d */
    private void m21777d() {
        AnimationSet animationSet = this.f27522m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f27522m = null;
        }
    }

    /* renamed from: e */
    private void m21778e() {
        if (this.f27516g.getVisibility() != 0 || !this.f27516g.isShown()) {
            m21780g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27523n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f27516g.setProgress(0.0f);
                    DeparturePinView.this.f27516g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f27516g.playAnimation();
                }
            });
            this.f27523n.addAnimation(m21773c(true));
            this.f27523n.addAnimation(m21769b(true));
            this.f27523n.setDuration(400);
            this.f27523n.setFillAfter(true);
            this.f27516g.startAnimation(this.f27523n);
        }
    }

    /* renamed from: f */
    private void m21779f() {
        if (this.f27516g.getVisibility() == 0 || this.f27516g.isShown()) {
            m21780g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27523n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DeparturePinView.this.f27516g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DeparturePinView.this.f27516g.setVisibility(4);
                }
            });
            this.f27523n.addAnimation(m21773c(false));
            this.f27523n.addAnimation(m21769b(false));
            this.f27523n.setDuration(400);
            this.f27523n.setFillAfter(true);
            this.f27516g.startAnimation(this.f27523n);
            return;
        }
        this.f27516g.setVisibility(4);
    }

    /* renamed from: g */
    private void m21780g() {
        AnimationSet animationSet = this.f27523n;
        if (animationSet != null) {
            animationSet.setAnimationListener((Animation.AnimationListener) null);
            this.f27523n.cancel();
            this.f27523n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m21769b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m21773c(boolean z) {
        ScaleAnimation scaleAnimation;
        if (z) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        }
        scaleAnimation.setDuration(400);
        return scaleAnimation;
    }

    public void create(Context context, Map map) {
        this.f27525p = map;
        this.f27524o = context;
    }

    public void destroy() {
        stopAnimation();
        this.f27526q = null;
        Map map = this.f27525p;
        if (map != null) {
            map.removeTopView();
        }
        this.f27525p = null;
        this.f27513d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f27526q = pinStyle;
            if (this.f27513d != null) {
                this.f27513d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
            }
        }
    }

    public void onMapVisible(boolean z) {
        if (!z) {
            stopAnimation();
        }
    }

    public void add() {
        PinStyle pinStyle;
        Map map = this.f27525p;
        if (map != null && (pinStyle = this.f27526q) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f27526q.anchorY);
        }
    }

    public void remove() {
        Map map = this.f27525p;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    public boolean isVisible() {
        return isShown();
    }
}
