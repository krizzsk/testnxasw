package com.didi.global.fintech.cashier.network;

import com.didi.global.fintech.cashier.network.api.CashierApiRpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/api/CashierApiRpcService;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierNetwork.kt */
final class CashierNetwork$cashierApiRpcService$2 extends Lambda implements Function0<CashierApiRpcService> {
    final /* synthetic */ CashierNetwork this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CashierNetwork$cashierApiRpcService$2(CashierNetwork cashierNetwork) {
        super(0);
        this.this$0 = cashierNetwork;
    }

    public final CashierApiRpcService invoke() {
        return (CashierApiRpcService) new RpcServiceFactory(this.this$0.f23496a).newRpcService(CashierApiRpcService.class, Url.CASHIER_BASE_URL);
    }
}
