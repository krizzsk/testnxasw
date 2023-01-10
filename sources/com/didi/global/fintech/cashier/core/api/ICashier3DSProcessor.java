package com.didi.global.fintech.cashier.core.api;

import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/api/ICashier3DSProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "adyenActionHandle", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "payment3DSDetailProcess", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ICashier3DSProcessor.kt */
public interface ICashier3DSProcessor extends ICashierBaseProcessor {
    void adyenActionHandle(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel);

    void payment3DSDetailProcess(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse);
}
