package com.didi.global.fintech.cashier.model.strategy;

import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<no name provided>", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "<anonymous parameter 0>", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SyncStatusStrategy.kt */
final class SyncStatusStrategy$Companion$FastPay$1 extends Lambda implements Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> {
    public static final SyncStatusStrategy$Companion$FastPay$1 INSTANCE = new SyncStatusStrategy$Companion$FastPay$1();

    SyncStatusStrategy$Companion$FastPay$1() {
        super(2);
    }

    public final BaseStrategy.Result invoke(SyncStatusStrategy syncStatusStrategy, PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "$noName_0");
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "failed")) {
            return BaseStrategy.Result.FAILED;
        }
        if (Intrinsics.areEqual((Object) payStatusResponse.getNeedPollingResult(), (Object) true)) {
            return BaseStrategy.Result.SUCCESS;
        }
        if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "success")) {
            return BaseStrategy.Result.SUCCESS;
        }
        return BaseStrategy.Result.CONTINUE;
    }
}
