package com.didi.soda.business.binder.home;

import android.view.View;
import com.didi.soda.business.widget.BusinessLittleStepper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessLittleStepperBinder.kt */
final class BusinessLittleStepperBinder$initView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessLittleStepperBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepperBinder$initView$1(BusinessLittleStepperBinder businessLittleStepperBinder) {
        super(0);
        this.this$0 = businessLittleStepperBinder;
    }

    public final void invoke() {
        if (this.this$0.f42070d) {
            BusinessLittleStepper access$getStepper$p = this.this$0.f42071e;
            boolean z = true;
            if (access$getStepper$p == null || !access$getStepper$p.getNeedExpand()) {
                z = false;
            }
            if (z) {
                View access$getMask$p = this.this$0.f42072f;
                if (access$getMask$p != null) {
                    access$getMask$p.setVisibility(0);
                }
                LogUtil.m32584d(this.this$0.f42067a, "VISIBLE:");
                BusinessLittleStepperBinder businessLittleStepperBinder = this.this$0;
                businessLittleStepperBinder.m31536a(businessLittleStepperBinder.f42073g);
            }
        }
        View access$getMask$p2 = this.this$0.f42072f;
        if (access$getMask$p2 != null) {
            access$getMask$p2.setVisibility(8);
        }
        LogUtil.m32584d(this.this$0.f42067a, "GONE:");
        BusinessLittleStepperBinder businessLittleStepperBinder2 = this.this$0;
        businessLittleStepperBinder2.m31536a(businessLittleStepperBinder2.f42073g);
    }
}
