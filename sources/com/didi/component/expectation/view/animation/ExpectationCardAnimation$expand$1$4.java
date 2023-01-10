package com.didi.component.expectation.view.animation;

import android.animation.ValueAnimator;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ExpectationCardAnimation.kt */
final class ExpectationCardAnimation$expand$1$4 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ IXpCompRefresh.IXpCompRefreshCb $callback;

    ExpectationCardAnimation$expand$1$4(IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        this.$callback = iXpCompRefreshCb;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb = this.$callback;
            if (iXpCompRefreshCb != null) {
                iXpCompRefreshCb.heightAnimValue(intValue);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
