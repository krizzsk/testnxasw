package com.didi.payment.creditcard.global.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;

public class CardTypeViewAnimator {

    /* renamed from: a */
    private ValueAnimator f32899a;

    /* renamed from: b */
    private ValueAnimator f32900b;

    public void showCardTypeSelectView(final View view, View view2) {
        if (!view.isShown()) {
            ValueAnimator valueAnimator = this.f32899a;
            if (valueAnimator == null || !valueAnimator.isStarted()) {
                view.setVisibility(0);
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, PaymentTextUtil.dip2px(view.getContext(), 20.0f)});
                this.f32899a = ofInt;
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                });
                this.f32899a.start();
            }
        }
    }

    public void hideCardTypeSelectView(final View view, final View view2) {
        if (view.isShown()) {
            ValueAnimator valueAnimator = this.f32900b;
            if (valueAnimator == null || !valueAnimator.isStarted()) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getHeight(), 0});
                this.f32900b = ofInt;
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                });
                this.f32900b.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(8);
                        View view = view2;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                    }
                });
                this.f32900b.start();
            }
        }
    }
}
