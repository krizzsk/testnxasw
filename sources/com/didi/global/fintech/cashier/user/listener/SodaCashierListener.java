package com.didi.global.fintech.cashier.user.listener;

import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/listener/SodaCashierListener;", "", "onPayResult", "", "result", "Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult;", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaCashierListener.kt */
public interface SodaCashierListener {
    void onPayResult(SodaPayResult sodaPayResult);
}
