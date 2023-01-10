package com.didi.global.fintech.cashier.soda.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsPresenter.kt */
final class SodaPaymentsPresenter$onConfirmBtnClick$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CashierAction $action;
    final /* synthetic */ SodaPaymentsPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SodaPaymentsPresenter$onConfirmBtnClick$2(SodaPaymentsPresenter sodaPaymentsPresenter, CashierAction cashierAction) {
        super(0);
        this.this$0 = sodaPaymentsPresenter;
        this.$action = cashierAction;
    }

    public final void invoke() {
        IGlobalCashierActionInterceptCallback access$getActionInterceptHandler = this.this$0.getActionInterceptHandler();
        if (access$getActionInterceptHandler != null) {
            CashierAction cashierAction = this.$action;
            access$getActionInterceptHandler.onActionInterceptJumpThirdPage(cashierAction == null ? null : cashierAction.getAction());
        }
    }
}
