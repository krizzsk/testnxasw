package com.didi.soda.business.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessLittleStepper.kt */
final class BusinessLittleStepper$expend$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessLittleStepper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepper$expend$1$2(BusinessLittleStepper businessLittleStepper) {
        super(0);
        this.this$0 = businessLittleStepper;
    }

    public final void invoke() {
        TextView access$getNumView$p = this.this$0.f42437q;
        if (access$getNumView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numView");
            access$getNumView$p = null;
        }
        access$getNumView$p.setVisibility(0);
        this.this$0.m31922b();
    }
}
