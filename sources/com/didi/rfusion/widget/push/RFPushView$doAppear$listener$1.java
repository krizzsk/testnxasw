package com.didi.rfusion.widget.push;

import android.view.View;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.AnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/rfusion/widget/push/RFPushView$doAppear$listener$1", "Lcom/didichuxing/sofa/animation/AnimatorListener;", "onAnimationEnd", "", "animator", "Lcom/didichuxing/sofa/animation/Animator;", "view", "Landroid/view/View;", "onAnimationStart", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFPushView.kt */
public final class RFPushView$doAppear$listener$1 implements AnimatorListener {
    final /* synthetic */ RFPushView this$0;

    public void onAnimationEnd(Animator animator, View view) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    RFPushView$doAppear$listener$1(RFPushView rFPushView) {
        this.this$0 = rFPushView;
    }

    public void onAnimationStart(Animator animator, View view) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.this$0.setVisibility(0);
    }
}
