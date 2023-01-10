package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "income", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "<anonymous parameter 1>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepIncomeInfoFragment.kt */
final class StepIncomeInfoFragment$initView$1 extends Lambda implements Function2<GuidesInfoResp.Income, Integer, Unit> {
    final /* synthetic */ StepIncomeInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepIncomeInfoFragment$initView$1(StepIncomeInfoFragment stepIncomeInfoFragment) {
        super(2);
        this.this$0 = stepIncomeInfoFragment;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GuidesInfoResp.Income) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GuidesInfoResp.Income income, int i) {
        Intrinsics.checkNotNullParameter(income, "income");
        if (!income.getSelected()) {
            this.this$0.f33373i = income;
            IncomeAdapter access$getAdapter$p = this.this$0.f33371g;
            IncomeAdapter incomeAdapter = null;
            if (access$getAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                access$getAdapter$p = null;
            }
            for (GuidesInfoResp.Income income2 : access$getAdapter$p.getDataLst()) {
                income2.setSelected(Intrinsics.areEqual((Object) income, (Object) income2));
            }
            IncomeAdapter access$getAdapter$p2 = this.this$0.f33371g;
            if (access$getAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                incomeAdapter = access$getAdapter$p2;
            }
            incomeAdapter.notifyDataSetChanged();
        }
        this.this$0.m25399b();
    }
}
