package com.didichuxing.drtl.auto;

import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "CoordinatorLayout.LayoutParams", value = {IDrtl.class})
@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didichuxing/drtl/auto/CoordinatorLayoutParamsDrtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;", "()V", "apply", "", "params", "getType", "Ljava/lang/Class;", "drtl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: LayoutParamsDRtl.kt */
public final class CoordinatorLayoutParamsDrtl implements IDrtl<CoordinatorLayout.LayoutParams> {
    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return IDrtl.DefaultImpls.filter(this, obj);
    }

    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public Class<CoordinatorLayout.LayoutParams> getType() {
        return CoordinatorLayout.LayoutParams.class;
    }

    public void apply(CoordinatorLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "params");
        DrtlViewExKt.rtlMargin((ViewGroup.MarginLayoutParams) layoutParams);
    }
}
