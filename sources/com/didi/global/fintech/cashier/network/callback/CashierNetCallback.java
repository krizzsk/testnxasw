package com.didi.global.fintech.cashier.network.callback;

import com.didi.global.fintech.cashier.model.CashierError;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "T", "", "onFailure", "", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccess", "response", "(Ljava/lang/Object;)V", "cashier_network_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierNetCallback.kt */
public interface CashierNetCallback<T> {
    void onFailure(CashierError cashierError);

    void onSuccess(T t);
}
