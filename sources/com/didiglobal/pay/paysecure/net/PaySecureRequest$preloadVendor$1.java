package com.didiglobal.pay.paysecure.net;

import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.util.PaySecureLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didiglobal/pay/paysecure/net/PaySecureRequest$preloadVendor$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "", "onFailure", "exception", "Ljava/io/IOException;", "onSuccess", "value", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureRequest.kt */
public final class PaySecureRequest$preloadVendor$1 implements RpcService.Callback<PaySecureResponse<Unit>> {
    PaySecureRequest$preloadVendor$1() {
    }

    public void onSuccess(PaySecureResponse<Unit> paySecureResponse) {
        Intrinsics.checkParameterIsNotNull(paySecureResponse, "value");
        PaySecureLog.INSTANCE.mo129704i("preloadVendor success");
    }

    public void onFailure(IOException iOException) {
        PaySecureLog.INSTANCE.mo129704i("preloadVendor fail");
    }
}
