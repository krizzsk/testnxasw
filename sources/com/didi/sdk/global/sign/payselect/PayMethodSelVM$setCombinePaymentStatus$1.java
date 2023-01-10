package com.didi.sdk.global.sign.payselect;

import com.didi.sdk.global.paypal.model.bean.BaseResult;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/sdk/global/sign/payselect/PayMethodSelVM$setCombinePaymentStatus$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/sdk/global/paypal/model/bean/BaseResult;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayMethodSelVM.kt */
public final class PayMethodSelVM$setCombinePaymentStatus$1 implements RpcService.Callback<BaseResult> {
    final /* synthetic */ Function0<Unit> $onFinish;
    final /* synthetic */ PayMethodSelVM this$0;

    PayMethodSelVM$setCombinePaymentStatus$1(PayMethodSelVM payMethodSelVM, Function0<Unit> function0) {
        this.this$0 = payMethodSelVM;
        this.$onFinish = function0;
    }

    public void onSuccess(BaseResult baseResult) {
        this.this$0.isLoadingLD().setValue(false);
        Function0<Unit> function0 = this.$onFinish;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
        this.this$0.isLoadingLD().setValue(false);
        Function0<Unit> function0 = this.$onFinish;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
