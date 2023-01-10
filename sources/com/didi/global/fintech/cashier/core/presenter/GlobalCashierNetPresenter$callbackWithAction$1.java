package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo148868d2 = {"com/didi/global/fintech/cashier/core/presenter/GlobalCashierNetPresenter$callbackWithAction$1", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "onFailure", "", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccess", "response", "(Ljava/lang/Object;)V", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierNetPresenter.kt */
public final class GlobalCashierNetPresenter$callbackWithAction$1 implements CashierNetCallback<T> {
    final /* synthetic */ IGlobalCashierNetPresenter.API $API;
    final /* synthetic */ Function2<T, IGlobalCashierNetPresenter.API, Unit> $success;
    final /* synthetic */ GlobalCashierNetPresenter this$0;

    GlobalCashierNetPresenter$callbackWithAction$1(Function2<? super T, ? super IGlobalCashierNetPresenter.API, Unit> function2, IGlobalCashierNetPresenter.API api, GlobalCashierNetPresenter globalCashierNetPresenter) {
        this.$success = function2;
        this.$API = api;
        this.this$0 = globalCashierNetPresenter;
    }

    public void onSuccess(T t) {
        this.$success.invoke(t, this.$API);
    }

    public void onFailure(CashierError cashierError) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        this.this$0.onRequestFailed(this.$API, cashierError);
    }
}
