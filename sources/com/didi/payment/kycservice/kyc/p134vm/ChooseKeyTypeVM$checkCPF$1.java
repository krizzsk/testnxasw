package com.didi.payment.kycservice.kyc.p134vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.kyc.response.CPFCheckResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/vm/ChooseKeyTypeVM$checkCPF$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp;", "onComplete", "", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseKeyTypeVM$checkCPF$1 */
/* compiled from: ChooseKeyTypeVM.kt */
public final class ChooseKeyTypeVM$checkCPF$1 extends WNetCallback<CPFCheckResp> {
    final /* synthetic */ ChooseKeyTypeVM this$0;

    ChooseKeyTypeVM$checkCPF$1(ChooseKeyTypeVM chooseKeyTypeVM) {
        this.this$0 = chooseKeyTypeVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(CPFCheckResp cPFCheckResp) {
        Intrinsics.checkNotNullParameter(cPFCheckResp, "response");
        super.onSuccess(cPFCheckResp);
        this.this$0.getCpfCheckData().setValue(cPFCheckResp);
    }
}
