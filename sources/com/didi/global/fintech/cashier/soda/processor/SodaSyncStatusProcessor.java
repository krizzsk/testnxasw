package com.didi.global.fintech.cashier.soda.processor;

import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.model.net.response.FailedInfo;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.soda.contract.ISodaSyncUICallback;
import com.didi.global.fintech.cashier.user.facade.CashierPayResult;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncStatusProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierSyncStatusProcessor;", "callback", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;", "(Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;)V", "onSyncFail", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onSyncSuccess", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaSyncStatusProcessor.kt */
public final class SodaSyncStatusProcessor implements ICashierSyncStatusProcessor {

    /* renamed from: a */
    private final ISodaSyncUICallback f23554a;

    public SodaSyncStatusProcessor(ISodaSyncUICallback iSodaSyncUICallback) {
        Intrinsics.checkNotNullParameter(iSodaSyncUICallback, "callback");
        this.f23554a = iSodaSyncUICallback;
    }

    public void onSyncSuccess(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        this.f23554a.onFinish(SodaPayResult.Companion.newSuccessResult());
    }

    public void onSyncFail(PayStatusResponse payStatusResponse) {
        SodaPayResult sodaPayResult;
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "failed")) {
            FailedInfo failedInfo = payStatusResponse.getFailedInfo();
            String str = "";
            int i = CashierPayResult.CODE_API_UNKNOWN;
            String str2 = SodaPayResult.SYSTEM_CASHIER_API;
            if (failedInfo != null) {
                String system = failedInfo.getSystem();
                if (system != null) {
                    str2 = system;
                }
                Integer code = failedInfo.getCode();
                if (code != null) {
                    i = code.intValue();
                }
                String message = failedInfo.getMessage();
                if (message != null) {
                    str = message;
                }
                sodaPayResult = new SodaPayResult(str2, i, str);
            } else {
                sodaPayResult = new SodaPayResult(str2, CashierPayResult.CODE_API_UNKNOWN, str);
            }
            this.f23554a.onFinish(sodaPayResult);
        } else if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "pending")) {
            this.f23554a.onFinish(SodaPayResult.Companion.newPaddingTimeOutResult());
        }
    }
}
