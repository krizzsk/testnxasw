package com.didi.soda.bill.component.bill;

import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
final class CustomerBillPresenterV2$startAlertTask$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenterV2$startAlertTask$2$1(CustomerBillPresenterV2 customerBillPresenterV2) {
        super(0);
        this.this$0 = customerBillPresenterV2;
    }

    public final Unit invoke() {
        CPFCheckVisibleListener access$getCpfVisibleListener$p = this.this$0.f41585m;
        if (access$getCpfVisibleListener$p == null) {
            return null;
        }
        access$getCpfVisibleListener$p.showCPFCheckView();
        return Unit.INSTANCE;
    }
}
