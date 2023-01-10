package com.didi.global.fintech.cashier.fastpay.api;

import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayOrderProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "onChangeOrderChangeSuccess", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "onPayOrderSuccess", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IFastPayOrderProcessor.kt */
public interface IFastPayOrderProcessor extends IFastPayBaseProcessor {
    void onChangeOrderChangeSuccess(ChangePayOrderResponse changePayOrderResponse);

    void onPayOrderSuccess(FastPayOrderResponse fastPayOrderResponse);
}
