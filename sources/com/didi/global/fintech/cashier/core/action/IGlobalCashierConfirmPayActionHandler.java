package com.didi.global.fintech.cashier.core.action;

import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierConfirmPayActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierActionsHandler.kt */
public interface IGlobalCashierConfirmPayActionHandler extends IGlobalCashierBaseActionHandler {
    boolean handle(LifecycleOwner lifecycleOwner, CashierAction cashierAction, CashierParam cashierParam, String str);
}
