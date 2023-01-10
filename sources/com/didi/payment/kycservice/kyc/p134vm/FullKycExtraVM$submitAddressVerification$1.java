package com.didi.payment.kycservice.kyc.p134vm;

import android.content.Context;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/vm/FullKycExtraVM$submitAddressVerification$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.FullKycExtraVM$submitAddressVerification$1 */
/* compiled from: FullKycExtraVM.kt */
public final class FullKycExtraVM$submitAddressVerification$1 extends WNetCallback<WBaseResp> {
    final /* synthetic */ FullKycExtraVM this$0;

    FullKycExtraVM$submitAddressVerification$1(FullKycExtraVM fullKycExtraVM) {
        this.this$0 = fullKycExtraVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "response");
        super.onSuccess(wBaseResp);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        if (wBaseResp.errno != 0) {
            Context application = this.this$0.getApplication();
            String str = wBaseResp.errmsg;
            if (str == null) {
                str = "";
            }
            WalletToastNew.showFailedMsg(application, str);
            return;
        }
        WalletToastNew.showSuccessMsg(this.this$0.getApplication(), this.this$0.getApplication().getResources().getString(R.string.GRider_payment_Success_YHHI));
        this.this$0.getBFinishCreateAccount().setValue(true);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.getBFinishCreateAccount().setValue(false);
    }
}
