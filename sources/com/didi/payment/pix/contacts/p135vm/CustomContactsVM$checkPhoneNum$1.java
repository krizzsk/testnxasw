package com.didi.payment.pix.contacts.p135vm;

import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/payment/pix/contacts/vm/CustomContactsVM$checkPhoneNum$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.contacts.vm.CustomContactsVM$checkPhoneNum$1 */
/* compiled from: CustomContactsVM.kt */
public final class CustomContactsVM$checkPhoneNum$1 implements RpcService.Callback<PixKeyVerifyResp> {
    final /* synthetic */ CustomContactsVM this$0;

    CustomContactsVM$checkPhoneNum$1(CustomContactsVM customContactsVM) {
        this.this$0 = customContactsVM;
    }

    public void onSuccess(PixKeyVerifyResp pixKeyVerifyResp) {
        Intrinsics.checkNotNullParameter(pixKeyVerifyResp, "value");
        this.this$0.isLoading().setValue(false);
        if (!NWHttpUtil.Companion.isRespValid(pixKeyVerifyResp)) {
            this.this$0.isNetError().setValue(true);
        } else {
            this.this$0.getPhoneNumPixLD().setValue(pixKeyVerifyResp.data);
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.isLoading().setValue(false);
        this.this$0.isNetError().setValue(true);
    }
}
