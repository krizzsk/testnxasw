package com.didi.map.global.component.departure.canoe.view;

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
import com.didi.map.global.component.departure.pin.IDeparturePinView;
import com.didi.map.global.component.departure.pin.PinView;
import com.taxis99.R;

public class CanoeDeparturePinView extends RelativeLayout implements IDeparturePinView {

    /* renamed from: a */
    private static final String f27261a = "CanoeDeparturePinView";

    /* renamed from: b */
    private static final String f27262b = "lottie_departure_loading.json";

    /* renamed from: c */
    private static final String f27263c = "lottie_no_parking.json";

    /* renamed from: d */
    private PinView f27264d;

    /* renamed from: e */
    private RelativeLayout f27265e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LottieAnimationView f27266f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LottieAnimationView f27267g;

    /* renamed from: h */
    private View f27268h;

    /* renamed from: i */
    private int f27269i;

    /* renamed from: j */
    private int f27270j;

    /* renamed from: k */
    private boolean f27271k;

    /* renamed from: l */
    private AnimatorSet f27272l;

    /* renamed from: m */
    private AnimationSet f27273m;

    /* renamed from: n */
    private AnimationSet f27274n;

    /* renamed from: o */
    private Map f27275o;

    /* renamed from: p */
    private PinStyle f27276p;

    public CanoeDeparturePinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanoeDeparturePinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanoeDeparturePinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27271k = false;
        m21560a(context);
    }

    /* renamed from: a */
    private void m21560a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_canoe_departure_pin_view, this);
        this.f27264d = (PinView) inflate.findViewById(R.id.pin);
        this.f27265e = (RelativeLayout) inflate.findViewById(R.id.container);
        this.f27266f = (LottieAnimationView) inflate.findViewById(R.id.loading_lottie);
        this.f27267g = (LottieAnimationView) inflate.findViewById(R.id.no_parking_lottie);
        this.f27266f.setAnimation(f27262b);
        this.f27266f.setRepeatCount(-1);
        this.f27267g.setAnimation(f27263c);
        this.f27267g.setRepeatCount(0);
        this.f27269i = this.f27264d.getBigCircleWidth();
        this.f27270j = this.f27264d.getBigCircleHeight();
        startDragging_Ex();
    }

    public void startDragging_Ex() {
        startShowPin(200);
    }

    public void startDragging() {
        startShowPin(400);
    }

    public void startShowPin(long j) {
        PinView pinView = this.f27264d;
        if (pinView != null && !pinView.isDragging()) {
            setPinStartEndColor(false);
            m21567c();
            m21572f();
            this.f27265e.removeView(this.f27268h);
            this.f27268h = null;
            m21558a(this.f27264d.getDraggingWidth(), this.f27264d.getDraggingHeight(), false, j);
            this.f27264d.toDragging();
            this.f27271k = false;
        }
    }

    public void startLoading(boolean z) {
        PinView pinView = this.f27264d;
        if (pinView != null && !pinView.isLoading()) {
            setPinStartEndColor(z);
            m21564b();
            m21572f();
            this.f27265e.removeView(this.f27268h);
            this.f27268h = null;
            m21558a(this.f27264d.getLoadingWidth(), this.f27264d.getLoadingHeight(), true, 400);
            this.f27264d.toLoading();
            this.f27271k = false;
        }
    }

    public void showText(String str) {
        PinView pinView;
        if (TextUtils.isEmpty(str) || (pinView = this.f27264d) == null) {
            return;
        }
        if (!pinView.isNormal() || !str.equalsIgnoreCase(this.f27264d.getText())) {
            setPinStartEndColor(false);
            m21567c();
            m21572f();
            this.f27265e.removeView(this.f27268h);
            this.f27268h = null;
            this.f27264d.showText(str);
            m21558a(this.f27264d.getNormalWidth(), this.f27264d.getNormalHeight(), false, 400);
            this.f27271k = false;
        }
    }

    public void showView(View view, int i, int i2, int i3) {
        if (view != null && i > 0 && i2 > 0 && i3 > 0 && this.f27268h != view) {
            setPinStartEndColor(false);
            m21567c();
            m21572f();
            this.f27265e.removeView(this.f27268h);
            this.f27268h = view;
            if (this.f27265e.indexOfChild(view) < 0) {
                this.f27265e.addView(view);
            }
            m21558a(i, i2, true, 400);
            this.f27264d.animSetBigCircleWidthHeightAngle(i, i2, i3);
            this.f27271k = false;
        }
    }

    public void toNoParking() {
        if (!this.f27271k) {
            setPinStartEndColor(true);
            m21567c();
            m21571e();
            this.f27265e.removeView(this.f27268h);
            this.f27268h = null;
            int draggingWidth = this.f27264d.getDraggingWidth();
            int draggingHeight = this.f27264d.getDraggingHeight();
            m21558a(draggingWidth, draggingHeight, false, 400);
            this.f27264d.animSetBigCircleWidthHeightAngle(draggingWidth, draggingHeight, PinView.DRAGGING_BIG_CIRCLE_RADIUS_PX);
            this.f27271k = true;
        }
    }

    public void stopAnimation() {
        this.f27264d.stopAnimation();
        if (this.f27266f.isAnimating()) {
            this.f27266f.cancelAnimation();
        }
        if (this.f27267g.isAnimating()) {
            this.f27267g.cancelAnimation();
        }
        m21557a();
        m21570d();
        m21573g();
    }

    /* renamed from: a */
    private void m21558a(int i, int i2, boolean z, long j) {
        m21557a();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27272l = animatorSet;
        animatorSet.setDuration(j);
        this.f27272l.playTogether(new Animator[]{m21554a(this.f27269i, i), m21561b(this.f27270j, i2), m21555a(z)});
        this.f27272l.start();
    }

    /* renamed from: a */
    private void m21557a() {
        AnimatorSet animatorSet = this.f27272l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f27272l = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m21554a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m21569c(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21569c(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27269i = intValue;
        m21568c(intValue, this.f27270j);
    }

    /* renamed from: b */
    private ValueAnimator m21561b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m21565b(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21565b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27270j = intValue;
        m21568c(this.f27269i, intValue);
    }

    /* renamed from: a */
    private ValueAnimator m21555a(boolean z) {
        ValueAnimator ofFloat = z ? ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}) : ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CanoeDeparturePinView.this.m21559a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21559a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f27265e.setAlpha(floatValue);
        View view = this.f27268h;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void setPinStartEndColor(boolean z) {
        PinView pinView = this.f27264d;
        pinView.setPinStartEndColor(this.f27271k ? pinView.getNoParkingColor() : pinView.getNormalColor(), z ? this.f27264d.getNoParkingColor() : this.f27264d.getNormalColor());
    }

    /* renamed from: c */
    private void m21568c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f27265e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f27265e.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m21564b() {
        m21570d();
        AnimationSet animationSet = new AnimationSet(false);
        this.f27273m = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                CanoeDeparturePinView.this.f27266f.setProgress(0.0f);
                CanoeDeparturePinView.this.f27266f.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                CanoeDeparturePinView.this.f27266f.playAnimation();
            }
        });
        this.f27273m.addAnimation(m21566c(true));
        this.f27273m.addAnimation(m21562b(true));
        this.f27273m.setDuration(400);
        this.f27273m.setFillAfter(true);
        this.f27266f.startAnimation(this.f27273m);
    }

    /* renamed from: c */
    private void m21567c() {
        if (this.f27266f.getVisibility() == 0 || this.f27266f.isShown()) {
            m21570d();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27273m = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f27266f.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f27266f.setVisibility(4);
                    CanoeDeparturePinView.this.f27266f.setProgress(0.0f);
                }
            });
            this.f27273m.addAnimation(m21566c(false));
            this.f27273m.addAnimation(m21562b(false));
            this.f27273m.setDuration(400);
            this.f27273m.setFillAfter(true);
            this.f27266f.startAnimation(this.f27273m);
            return;
        }
        this.f27266f.setVisibility(4);
    }

    /* renamed from: d */
    private void m21570d() {
        AnimationSet animationSet = this.f27273m;
        if (animationSet != null) {
            animationSet.cancel();
            this.f27273m = null;
        }
    }

    /* renamed from: e */
    private void m21571e() {
        if (this.f27267g.getVisibility() != 0 || !this.f27267g.isShown()) {
            m21573g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27274n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f27267g.setProgress(0.0f);
                    CanoeDeparturePinView.this.f27267g.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f27267g.playAnimation();
                }
            });
            this.f27274n.addAnimation(m21566c(true));
            this.f27274n.addAnimation(m21562b(true));
            this.f27274n.setDuration(400);
            this.f27274n.setFillAfter(true);
            this.f27267g.startAnimation(this.f27274n);
        }
    }

    /* renamed from: f */
    private void m21572f() {
        if (this.f27267g.getVisibility() == 0 || this.f27267g.isShown()) {
            m21573g();
            AnimationSet animationSet = new AnimationSet(false);
            this.f27274n = animationSet;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CanoeDeparturePinView.this.f27267g.pauseAnimation();
                }

                public void onAnimationEnd(Animation animation) {
                    CanoeDeparturePinView.this.f27267g.setVisibility(4);
                }
            });
            this.f27274n.addAnimation(m21566c(false));
            this.f27274n.addAnimation(m21562b(false));
            this.f27274n.setDuration(400);
            this.f27274n.setFillAfter(true);
            this.f27267g.startAnimation(this.f27274n);
            return;
        }
        this.f27267g.setVisibility(4);
    }

    /* renamed from: g */
    private void m21573g() {
        AnimationSet animationSet = this.f27274n;
        if (animationSet != null) {
            animationSet.cancel();
            this.f27274n = null;
        }
    }

    /* renamed from: b */
    private AlphaAnimation m21562b(boolean z) {
        AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        return alphaAnimation;
    }

    /* renamed from: c */
    private ScaleAnimation m21566c(boolean z) {
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
        this.f27275o = map;
    }

    public void destroy() {
        stopAnimation();
        this.f27276p = null;
        Map map = this.f27275o;
        if (map != null) {
            map.removeTopView();
        }
        this.f27275o = null;
        this.f27264d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f27276p = pinStyle;
            if (this.f27264d != null) {
                this.f27264d.setPinColor(pinStyle.pinNormalColor != 0 ? pinStyle.pinNormalColor : PinView.DEFAULT_COLOR, pinStyle.pintNoParkingColor != 0 ? pinStyle.pintNoParkingColor : PinView.NO_PARKING_COLOR);
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
        Map map = this.f27275o;
        if (map != null && (pinStyle = this.f27276p) != null) {
            map.setTopViewToCenter(this, pinStyle.anchorX, this.f27276p.anchorY);
        }
    }

    public void remove() {
        Map map = this.f27275o;
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

    public Rect getWindowPosition() {
        return new Rect(getLeft(), getTop(), getRight(), getBottom() - DisplayUtils.dp2px(getContext(), 20.0f));
    }
}
