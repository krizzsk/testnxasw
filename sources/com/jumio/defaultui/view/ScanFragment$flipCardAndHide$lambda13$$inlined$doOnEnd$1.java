package com.jumio.defaultui.view;

import android.animation.Animator;
import android.widget.ImageView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\n"}, mo148868d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: com.jumio.defaultui.view.ScanFragment$flipCardAndHide$lambda-13$$inlined$doOnEnd$1  reason: invalid class name */
/* compiled from: Animator.kt */
public final class ScanFragment$flipCardAndHide$lambda13$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    public final /* synthetic */ ScanFragment this$0;

    public ScanFragment$flipCardAndHide$lambda13$$inlined$doOnEnd$1(ScanFragment scanFragment) {
        this.this$0 = scanFragment;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        ImageView access$getAnimationIcon$p = this.this$0.animationIcon;
        if (access$getAnimationIcon$p != null) {
            access$getAnimationIcon$p.setImageResource(R.drawable.jumio_ic_id_back);
        }
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }
}
