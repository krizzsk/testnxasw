package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepIncomeInfoFragment.kt */
final class IncomeAdapter$onBindViewHolder$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GuidesInfoResp.Income $item;
    final /* synthetic */ int $position;
    final /* synthetic */ IncomeAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IncomeAdapter$onBindViewHolder$1(IncomeAdapter incomeAdapter, GuidesInfoResp.Income income, int i) {
        super(0);
        this.this$0 = incomeAdapter;
        this.$item = income;
        this.$position = i;
    }

    public final void invoke() {
        Function2<GuidesInfoResp.Income, Integer, Unit> onItemClick = this.this$0.getOnItemClick();
        if (onItemClick != null) {
            onItemClick.invoke(this.$item, Integer.valueOf(this.$position));
        }
    }
}
