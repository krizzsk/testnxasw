package com.didi.global.fintech.cashier.soda.processor;

import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.soda.contract.ISodaSyncUICallback;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncApiErrProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "callback", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;", "(Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;)V", "appUpgrade", "", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaSyncApiErrProcessor.kt */
public final class SodaSyncApiErrProcessor implements ICashierDialogProcessor {

    /* renamed from: a */
    private final ISodaSyncUICallback f23548a;

    public void appUpgrade() {
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig, "config");
        Intrinsics.checkNotNullParameter(api, "api");
    }

    public SodaSyncApiErrProcessor(ISodaSyncUICallback iSodaSyncUICallback) {
        Intrinsics.checkNotNullParameter(iSodaSyncUICallback, "callback");
        this.f23548a = iSodaSyncUICallback;
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api, "api");
        if (Intrinsics.areEqual((Object) cashierError, (Object) CashierError.Companion.getNET_ERROR())) {
            this.f23548a.onFinish(SodaPayResult.Companion.newNetErrResult());
        } else {
            this.f23548a.onFinish(new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_API, cashierError.getCode(), cashierError.getMessage()));
        }
    }
}
