package com.didi.payment.kycservice.kyc.p134vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.net.response.FaceSessionResp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/vm/SignUp99PayVM$getFaceSession$1$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/net/response/FaceSessionResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.SignUp99PayVM$getFaceSession$1$1 */
/* compiled from: SignUp99PayVM.kt */
public final class SignUp99PayVM$getFaceSession$1$1 extends WNetCallback<FaceSessionResp> {
    final /* synthetic */ SignUp99PayVM this$0;

    SignUp99PayVM$getFaceSession$1$1(SignUp99PayVM signUp99PayVM) {
        this.this$0 = signUp99PayVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
    }

    public void onSuccess(FaceSessionResp faceSessionResp) {
        Intrinsics.checkNotNullParameter(faceSessionResp, "response");
        super.onSuccess(faceSessionResp);
        if (faceSessionResp.errno == 0) {
            String sessionId = faceSessionResp.getData().getSessionId();
            if (sessionId != null) {
                this.this$0.getSessionId().setValue(sessionId);
                return;
            }
            return;
        }
        WalletToastNew.showFailedMsg(this.this$0.getApplication(), faceSessionResp.errmsg);
        this.this$0.getErrorMsg().setValue(faceSessionResp.errmsg);
    }
}
