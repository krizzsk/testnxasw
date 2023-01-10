package com.didichuxing.drtl.auto;

import android.view.View;
import android.widget.FrameLayout;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "FrameLayout", value = {IDrtl.class})
@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didichuxing/drtl/auto/FrameLayoutDrtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroid/widget/FrameLayout;", "()V", "apply", "", "frameLayout", "getType", "Ljava/lang/Class;", "drtl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ViewGroupDRtl.kt */
public final class FrameLayoutDrtl implements IDrtl<FrameLayout> {
    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return IDrtl.DefaultImpls.filter(this, obj);
    }

    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public void apply(FrameLayout frameLayout) {
        Intrinsics.checkParameterIsNotNull(frameLayout, "frameLayout");
        View view = frameLayout;
        DrtlViewExKt.rtlMargin(view);
        DrtlViewExKt.rtlPadding(view);
        DrtlViewExKt.rtlLayoutParams(view);
        DrtlViewExKt.rtlForegroundGravity(view);
    }

    public Class<FrameLayout> getType() {
        return FrameLayout.class;
    }
}
