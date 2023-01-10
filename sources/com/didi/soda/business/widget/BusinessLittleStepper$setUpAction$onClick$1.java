package com.didi.soda.business.widget;

import android.widget.TextView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessLittleStepper.kt */
final class BusinessLittleStepper$setUpAction$onClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessLittleStepper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepper$setUpAction$onClick$1(BusinessLittleStepper businessLittleStepper) {
        super(0);
        this.this$0 = businessLittleStepper;
    }

    public final void invoke() {
        LogUtil.m32584d(this.this$0.f42421a, "onUP click");
        if (this.this$0.getNeedExpand()) {
            this.this$0.getCountDownTimer().cancel();
            this.this$0.getCountDownTimer().start();
            this.this$0.expend();
            TextView access$getNumView$p = this.this$0.f42437q;
            TextView textView = null;
            if (access$getNumView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numView");
                access$getNumView$p = null;
            }
            access$getNumView$p.setText(String.valueOf(this.this$0.getCurrentNum()));
            TextView access$getTv_up_num$p = this.this$0.f42423c;
            if (access$getTv_up_num$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv_up_num");
            } else {
                textView = access$getTv_up_num$p;
            }
            textView.setText(String.valueOf(this.this$0.getCurrentNum()));
        }
    }
}
