package com.didi.payment.pix.orderdetail.p137vm;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/payment/pix/orderdetail/vm/PixOrderDetailVM$loadDataByOid$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.orderdetail.vm.PixOrderDetailVM$loadDataByOid$1 */
/* compiled from: PixOrderDetailVM.kt */
public final class PixOrderDetailVM$loadDataByOid$1 implements RpcService.Callback<PixOrderDetailResp> {
    final /* synthetic */ PixOrderDetailVM this$0;

    PixOrderDetailVM$loadDataByOid$1(PixOrderDetailVM pixOrderDetailVM) {
        this.this$0 = pixOrderDetailVM;
    }

    public void onSuccess(PixOrderDetailResp pixOrderDetailResp) {
        this.this$0.isLoading().setValue(false);
        if (pixOrderDetailResp == null || !pixOrderDetailResp.isValid()) {
            this.this$0.getErrObj().setValue(pixOrderDetailResp);
        } else {
            this.this$0.getDetailSections().setValue(pixOrderDetailResp.data);
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.getErrObj().setValue(new WBaseResp().onRequestFail());
        this.this$0.isLoading().setValue(false);
    }
}
