package com.didi.global.fintech.cashier.core.spi;

import androidx.lifecycle.LifecycleOwner;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler$handle$2$1$1", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "onFailure", "", "status", "", "desc", "onSuccess", "token", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler$handle$2$1$1 implements PayPwdResultListener {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ GlobalCashierPasswordActionHandler $this_apply;

    GlobalCashierPasswordActionHandler$handle$2$1$1(GlobalCashierPasswordActionHandler globalCashierPasswordActionHandler, LifecycleOwner lifecycleOwner) {
        this.$this_apply = globalCashierPasswordActionHandler;
        this.$lifecycleOwner = lifecycleOwner;
    }

    public void onFailure(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.$this_apply.m19158a(this.$lifecycleOwner, str, str2);
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.$this_apply.m19157a(this.$lifecycleOwner, str);
    }
}
