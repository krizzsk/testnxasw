package com.didi.global.fintech.cashier.soda.presenter;

import com.didi.global.fintech.cashier.p118ui.kts.ContextKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsPresenter.kt */
final class SodaPaymentsPresenter$appUpgrade$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SodaPaymentsPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SodaPaymentsPresenter$appUpgrade$2(SodaPaymentsPresenter sodaPaymentsPresenter) {
        super(0);
        this.this$0 = sodaPaymentsPresenter;
    }

    public final void invoke() {
        SodaPaymentsPresenter sodaPaymentsPresenter = this.this$0;
        sodaPaymentsPresenter.omegaVersionUpdateBtnCk(ContextKtxKt.string(sodaPaymentsPresenter.getContext(), R.string.Wallet_App_V2_Upgrade_AbvG));
    }
}
