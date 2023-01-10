package com.didiglobal.p205sa.biz.delegate;

import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.app.business.ICurrentBusiness;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider({ICurrentBusiness.class})
@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/delegate/SaCurrentBusinessDelegate;", "Lcom/didi/sdk/app/business/ICurrentBusiness;", "()V", "getCurrentBusiness", "", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaCurrentBusinessDelegate */
/* compiled from: SaCurrentBusinessDelegate.kt */
public final class SaCurrentBusinessDelegate implements ICurrentBusiness {
    public String getCurrentBusiness() {
        return SuperAppBusinessManager.INSTANCE.getCurrentBusiness();
    }
}
