package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$onPayInfoResponse$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IGlobalCashierNetPresenter.API $API;
    final /* synthetic */ PayInfoResponse $response;
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$onPayInfoResponse$2(GlobalCashierPayPresenter globalCashierPayPresenter, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
        this.$response = payInfoResponse;
        this.$API = api;
    }

    public final void invoke() {
        GlobalCashierPayPresenter.m19152a(this.this$0, this.$response, this.$API);
    }
}
