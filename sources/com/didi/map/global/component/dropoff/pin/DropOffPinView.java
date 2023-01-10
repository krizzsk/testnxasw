package com.didi.map.global.component.dropoff.pin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.taxis99.R;

public class DropOffPinView extends RelativeLayout implements IDropOffPinView {

    /* renamed from: a */
    private static final String f27793a = "DeparturePinView";

    /* renamed from: b */
    private static final String f27794b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f27795c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f27796d;

    /* renamed from: e */
    private RelativeLayout f27797e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f27798f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f27799g;

    /* renamed from: h */
    private View f27800h;

    /* renamed from: i */
    private int f27801i;

    /* renamed from: j */
    private int f27802j;

    /* renamed from: k */
    private boolean f27803k;

    /* renamed from: l */
    private AnimatorSet f27804l;

    /* renamed from: m */
    private AnimationSet f27805m;

    /* renamed from: n */
    private AnimationSet f27806n;

    /* renamed from: o */
    private Map f27807o;

    /* renamed from: p */
    private PinStyle f27808p;

    public DropOffPinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DropOffPinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropOffPinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27803k = false;
        m21946a(context);
    }

    /* renamed from: a */
    private void m21946a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dropoff_pin_view, this);
        this.f27796d = (PinView) inflate.findViewById(R.id.pin);
        this.f27797e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f27798f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f27799g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f27798f.setAnimation(f27794b);
        this.f27798f.setRepeatCount(-1);
        this.f27799g.setAnimation(f27795c);
        this.f27799g.setRepeatCount(0);
        this.f27801i = this.f27796d.getBigCircleWidth();
        this.f27802j = this.f27796d.getBigCircleHeight();
        startDragging_Ex();
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f27796d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m21953c();
            m21958f();
            this.f27797e.removeView(this.f27800h);
            this.f27800h = null;
            m21944a(this.f27796d.getDraggingWidth(), this.f27796d.getDraggingHeight(), false, j);
            this.f27796d.toDragging();
            this.f27803k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f27796d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m21950b();
            m21958f();
            this.f27797e.removeView(this.f27800h);
            this.f27800h = null;
            m21944a(this.f27796d.getLoadingWidth(), this.f27796d.getLoadingHeight(), true, 400);
            this.f27796d.toLoading();
            this.f27803k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f27796d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f27796d.getText())) {
            setPinStartEndColor(false);
            m21953c();
            m21958f();
            this.f27797e.removeView(this.f27800h);
            this.f27800h = null;
            this.f27796d.showText(str);
            m21944a(this.f27796d.getNormalWidth(), this.f27796d.getNormalHeight(), false, 400);
            this.f27803k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0 && this.f27800h != view) {
            setPinStartEndColor(false);
            m21953c();
            m21958f();
            this.f27797e.removeView(this.f27800h);
            this.f27800h = view;
            if (this.f27797e.indexOfChild(view) < 0) {
                this.f27797e.addView(view);
            }
            m21944a(i, i2, true, 400);
            this.f27796d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f27803k = false;
        }
    }

    public void toNoParking() {
        if (!this.f27803k) {
            setPinStartEndColor(true);
            m21953c();
            m21957e();
            this.f27797e.removeView(this.f27800h);
            this.f27800h = null;
            int draggingWidth = this.f27796d.getDraggingWidth();
            int draggingHeight = this.f27796d.getDraggingHeight();
            m21944a(draggingWidth, draggingHeight, false, 400);
            this.f27796d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f27803k = true;
        }
    }

    public void stopAnimation() {
        this.f27796d.stopAnimation();
        if (this.f27798f.isAnimating()) {
            this.f27798f.cancelAnimation();
        }
        if (this.f27799g.isAnimating()) {
            this.f27799g.cancelAnimation();
        }
        m21943a();
        m21956d();
        m21959g();
    }

    /* renamed from: a */
    private void m21944a(int i, int i2, boolean z, long j) {
        m21943a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27804l = animatorSet;
        animatorSet.setDuration(j);
        this.f27804l.playTogether(new Animator[]{m21940a(this.f27801i, i), m21947b(this.f27802j, i2), m21941a(z)});
        this.f27804l.start();
    }

    /* renamed from: a */
    private void m21943a() {
        AnimatorSet animatorSet = this.f27804l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f27804l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m21940a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m21955c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21955c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27801i = intValue;
        m21954c(intValue, this.f27802j);
    }

    /* renamed from: b */
    private ValueAnimator m21947b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m21951b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21951b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27802j = intValue;
        m21954c(this.f27801i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m21941a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropOffPinView.this.m21945a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21945a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f27797e.setAlpha(floatValue);
        View view = this.f27800h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f27796d;
        pinView.setPinStartEndColor(this.f27803k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f27796d.getNoParkingColor() : this.f27796d.getNormalColor());
    }

    /* renamed from: c */
    private void m21954c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f27797e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f27797e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m21950b() {
        m21956d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f27805m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                DropOffPinView.this.f27798f.setProgress(0.0f);
                DropOffPinView.this.f27798f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                DropOffPinView.this.f27798f.playAnimation();
            }
        });
        this.f27805m.addAnimation(m21952c(true));
        this.f27805m.addAnimation(m21948b(true));
        this.f27805m.setDuration(400);
        this.f27805m.setFillAfter(true);
        this.f27798f.startAnimation(this.f27805m);
    }

    /* renamed from: c */
    private void m21953c() {
        if (this.f27798f.getVisibility() == 0 || this.f27798f.isShown()) {
            m21956d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27805m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f27798f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f27798f.setVisibility(4);
                    DropOffPinView.this.f27798f.setProgress(0.0f);
                }
            });
            this.f27805m.addAnimation(m21952c(false));
            this.f27805m.addAnimation(m21948b(false));
            this.f27805m.setDuration(400);
            this.f27805m.setFillAfter(true);
            this.f27798f.startAnimation(this.f27805m);
            return;
        }
        this.f27798f.setVisibility(4);
    }

    /* renamed from: d */
    private void m21956d() {
        AnimationSet animationSet = this.f27805m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f27805m = null;
        }
    }

    /* renamed from: e */
    private void m21957e() {
        if (this.f27799g.getVisibility() != 0 || !this.f27799g.isShown()) {
            m21959g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27806n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f27799g.setProgress(0.0f);
                    DropOffPinView.this.f27799g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f27799g.playAnimation();
                }
            });
            this.f27806n.addAnimation(m21952c(true));
            this.f27806n.addAnimation(m21948b(true));
            this.f27806n.setDuration(400);
            this.f27806n.setFillAfter(true);
            this.f27799g.startAnimation(this.f27806n);
        }
    }

    /* renamed from: f */
    private void m21958f() {
        if (this.f27799g.getVisibility() == 0 || this.f27799g.isShown()) {
            m21959g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27806n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    DropOffPinView.this.f27799g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    DropOffPinView.this.f27799g.setVisibility(4);
                }
            });
            this.f27806n.addAnimation(m21952c(false));
            this.f27806n.addAnimation(m21948b(false));
            this.f27806n.setDuration(400);
            this.f27806n.setFillAfter(true);
            this.f27799g.startAnimation(this.f27806n);
            return;
        }
        this.f27799g.setVisibility(4);
    }

    /* renamed from: g */
    private void m21959g() {
        AnimationSet animationSet = this.f27806n;
        if (animationSet != null) {
            animationSet.cancel();
            this.f27806n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m21948b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m21952c(boolean z) {
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
        this.f27807o = map;
    }

    public void destroy() {
        stopAnimation();
        this.f27808p = null;
        Map map = this.f27807o;
        if (map != null) {
            map.removeTopView();
        }
        this.f27807o = null;
        this.f27796d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f27808p = pinStyle;
            if (this.f27796d != null) {
                this.f27796d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
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
        Map map = this.f27807o;
        if (map != null && (pinStyle = this.f27808p) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f27808p.anchorY);
        }
    }

    public void remove() {
        Map map = this.f27807o;
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
