package com.didi.soda.customer.compose.action;

import com.didi.soda.customer.foundation.storage.CustomerStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/customer/compose/action/StrategyStore;", "Lcom/didi/soda/customer/foundation/storage/CustomerStorage;", "Lcom/didi/soda/customer/compose/action/StrategyConfig;", "()V", "getData", "key", "", "setData", "", "k", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StrategyStore.kt */
public final class StrategyStore extends CustomerStorage<StrategyConfig> {
    public void setData(StrategyConfig strategyConfig) {
        Intrinsics.checkNotNullParameter(strategyConfig, "k");
        super.setData(strategyConfig.getMUniqueId(), strategyConfig);
    }

    public StrategyConfig getData(String str) {
        if (str == null) {
            return null;
        }
        return (StrategyConfig) super.getData(str);
    }
}
