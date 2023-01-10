package com.didi.soda.business.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessLittleStepper.kt */
final class BusinessLittleStepper$recovery$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessLittleStepper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepper$recovery$1(BusinessLittleStepper businessLittleStepper) {
        super(0);
        this.this$0 = businessLittleStepper;
    }

    public final void invoke() {
        TextView access$getDownView$p = this.this$0.f42424d;
        if (access$getDownView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downView");
            access$getDownView$p = null;
        }
        access$getDownView$p.setVisibility(8);
    }
}
