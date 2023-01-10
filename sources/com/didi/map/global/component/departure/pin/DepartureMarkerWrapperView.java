package com.didi.map.global.component.departure.pin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;
import com.taxis99.R;

public class DepartureMarkerWrapperView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FrameLayout f27503a;

    /* renamed from: b */
    private DepartureMarkerView f27504b;

    /* renamed from: c */
    private Context f27505c;

    public DepartureMarkerWrapperView(Context context) {
        this(context, (AttributeSet) null, (PinStyle) null);
    }

    public DepartureMarkerWrapperView(Context context, PinStyle pinStyle) {
        this(context, (AttributeSet) null, pinStyle);
    }

    public DepartureMarkerWrapperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (PinStyle) null);
    }

    public DepartureMarkerWrapperView(Context context, AttributeSet attributeSet, PinStyle pinStyle) {
        super(context, attributeSet);
        this.f27503a = null;
        this.f27504b = null;
        this.f27505c = null;
        this.f27505c = context;
        setOrientation(1);
        setGravity(1);
        LayoutInflater.from(getContext()).inflate(R.layout.departure_pin_wrapper_view, this);
        this.f27503a = (FrameLayout) findViewById(R.id.layout_bubble);
        DepartureMarkerView departureMarkerView = (DepartureMarkerView) findViewById(R.id.departure_center);
        this.f27504b = departureMarkerView;
        departureMarkerView.setPinStyle(pinStyle);
    }

    public ViewGroup getBubbleLayout() {
        return this.f27503a;
    }

    public void removeViewFromBubbleLayout(boolean z) {
        final View departureBubbleView = getDepartureBubbleView();
        if (departureBubbleView == null) {
            return;
        }
        if (z) {
            departureBubbleView.startAnimation(m21759a((Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    DepartureMarkerWrapperView.this.f27503a.removeView(departureBubbleView);
                }
            }));
        } else {
            this.f27503a.removeView(departureBubbleView);
        }
    }

    public View getDepartureBubbleView() {
        FrameLayout frameLayout = this.f27503a;
        if (frameLayout == null || frameLayout.getChildCount() <= 0) {
            return null;
        }
        return this.f27503a.getChildAt(0);
    }

    public void setPinStyle(PinStyle pinStyle) {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.setPinStyle(pinStyle);
        }
    }

    public void setNormal() {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.setNormal();
        }
    }

    public void setNoStopZoneStatus() {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.setNoStopZoneStatus();
        }
    }

    public void setText(String str) {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.setText(str);
        }
    }

    public void startLoading() {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.startLoading();
        }
    }

    public void startJump(DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        DepartureMarkerView departureMarkerView = this.f27504b;
        if (departureMarkerView != null) {
            departureMarkerView.startJump(animationFinishListener);
        }
    }

    /* renamed from: a */
    private Animation m21759a(Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        long j = (long) 300;
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -30.0f);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setAnimationListener(animationListener);
        return animationSet;
    }

    public void animateBar(long j) {
        this.f27504b.startAnimation(m21758a(j));
    }

    /* renamed from: a */
    private Animation m21758a(long j) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(j);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        return scaleAnimation;
    }
}
