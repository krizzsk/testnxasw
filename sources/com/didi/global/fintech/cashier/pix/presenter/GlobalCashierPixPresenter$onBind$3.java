package com.didi.global.fintech.cashier.pix.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPixPresenter.kt */
final class GlobalCashierPixPresenter$onBind$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierPixPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPixPresenter$onBind$3(GlobalCashierPixPresenter globalCashierPixPresenter) {
        super(0);
        this.this$0 = globalCashierPixPresenter;
    }

    public final void invoke() {
        this.this$0.onPaidClick();
    }
}
