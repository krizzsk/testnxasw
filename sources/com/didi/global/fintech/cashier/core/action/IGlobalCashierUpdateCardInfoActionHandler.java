package com.didi.global.fintech.cashier.core.action;

import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierUpdateCardInfoActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierActionsHandler.kt */
public interface IGlobalCashierUpdateCardInfoActionHandler extends IGlobalCashierBaseActionHandler {
    boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction);
}
