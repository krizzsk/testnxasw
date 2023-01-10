package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/AllFreezeStrategy;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/IFreezeStrategy;", "()V", "executeStrategy", "", "status", "", "(Ljava/lang/Integer;)Z", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.AllFreezeStrategy */
/* compiled from: FreezeInterceptor.kt */
public final class AllFreezeStrategy implements IFreezeStrategy {
    public boolean executeStrategy(Integer num) {
        return (num == null || num.intValue() != 0) && num != null;
    }
}
