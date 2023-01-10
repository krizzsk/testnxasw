package com.didi.soda.bill.component.cpf;

import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/soda/bill/component/cpf/CPFCheckPresenter$skip$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CPFCheckPresenter.kt */
public final class CPFCheckPresenter$skip$1 extends CustomerRpcCallback<Object> {
    public void onRpcSuccess(Object obj, long j) {
    }

    CPFCheckPresenter$skip$1() {
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        super.onRpcFailure(sFRpcException);
    }
}
