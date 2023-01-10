package com.didichuxing.comp.telecom.biz.p177ui.view;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/didichuxing/comp/telecom/biz/ui/view/LoadingView$mAnimator$1$1"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.view.LoadingView$$special$$inlined$apply$lambda$1 */
/* compiled from: LoadingView.kt */
final class LoadingView$$special$$inlined$apply$lambda$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ LoadingView this$0;

    LoadingView$$special$$inlined$apply$lambda$1(LoadingView loadingView) {
        this.this$0 = loadingView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            this.this$0.setRotation(((Float) animatedValue).floatValue() * ((float) 360));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
