package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.p118ui.kts.ContextKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierMainPresenter.kt */
final class GlobalCashierMainPresenter$onBackPressed$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierMainPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierMainPresenter$onBackPressed$3(GlobalCashierMainPresenter globalCashierMainPresenter) {
        super(0);
        this.this$0 = globalCashierMainPresenter;
    }

    public final void invoke() {
        GlobalCashierMainPresenter globalCashierMainPresenter = this.this$0;
        globalCashierMainPresenter.omegaCheckoutReturnPopupCk(ContextKtxKt.string(globalCashierMainPresenter.getContext(), R.string.Wallet_App_V2_Cancel_xPEq));
        this.this$0.m19139a(2);
    }
}
