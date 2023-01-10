package com.didi.payment.kycservice.kyc.p134vm;

import android.app.Application;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.wallet_ui.WalletToast;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/vm/IDTypeVM$setDelayPush$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$setDelayPush$1 */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM$setDelayPush$1 extends WNetCallback<WBaseResp> {
    final /* synthetic */ IDTypeVM this$0;

    IDTypeVM$setDelayPush$1(IDTypeVM iDTypeVM) {
        this.this$0 = iDTypeVM;
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

    public void onSuccess(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "response");
        super.onSuccess(wBaseResp);
        this.this$0.getDelayPushSet().setValue(Boolean.valueOf(wBaseResp.errno == 0));
        if (wBaseResp.errno == 0) {
            WalletToast.Companion companion = WalletToast.Companion;
            Application application = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            companion.toastSuccess(application, wBaseResp.errmsg);
            return;
        }
        WalletToast.Companion companion2 = WalletToast.Companion;
        Application application2 = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        companion2.toastFail(application2, wBaseResp.errmsg);
    }
}
