package com.didi.rfusion.widget.searchbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/rfusion/widget/searchbar/RFSearchBar$initAnimators$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFSearchBar.kt */
public final class RFSearchBar$initAnimators$1 extends AnimatorListenerAdapter {
    final /* synthetic */ RFSearchBar this$0;

    RFSearchBar$initAnimators$1(RFSearchBar rFSearchBar) {
        this.this$0 = rFSearchBar;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        RFSearchBar.access$getIvClose$p(this.this$0).setVisibility(0);
    }
}
