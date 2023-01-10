package com.didi.soda.customer.biz.popdialog.natived;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/soda/customer/biz/popdialog/natived/PopDialogAnimateHelper$appearDialogWithAnimate$animatorSet$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PopDialogAnimateHelper.kt */
public final class PopDialogAnimateHelper$appearDialogWithAnimate$animatorSet$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ DialogAnimateInterface $popView;

    PopDialogAnimateHelper$appearDialogWithAnimate$animatorSet$1$1(DialogAnimateInterface dialogAnimateInterface) {
        this.$popView = dialogAnimateInterface;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        View closedView = this.$popView.getClosedView();
        if (closedView != null) {
            closedView.setVisibility(4);
        }
        View rootView = this.$popView.getRootView();
        if (rootView != null) {
            rootView.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        View closedView = this.$popView.getClosedView();
        boolean z = true;
        if (!(closedView != null && closedView.getVisibility() == 8)) {
            View closedView2 = this.$popView.getClosedView();
            if (closedView2 == null || closedView2.getVisibility() != 4) {
                z = false;
            }
            if (!z) {
                return;
            }
        }
        View closedView3 = this.$popView.getClosedView();
        if (closedView3 != null) {
            closedView3.setVisibility(0);
        }
    }
}
