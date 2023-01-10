package com.didi.payment.kycservice.key.detail;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/payment/kycservice/key/detail/PixKeyDetailVM$pollPixKeyStatus$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixKeyDetailVM.kt */
public final class PixKeyDetailVM$pollPixKeyStatus$1 extends WNetCallback<PollStatusResp> {
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ PixKeyDetailVM this$0;

    PixKeyDetailVM$pollPixKeyStatus$1(PixKeyDetailVM pixKeyDetailVM, int i, String str) {
        this.this$0 = pixKeyDetailVM;
        this.$keyType = i;
        this.$keyVal = str;
    }

    public void onSuccess(PollStatusResp pollStatusResp) {
        Intrinsics.checkNotNullParameter(pollStatusResp, "response");
        super.onSuccess(pollStatusResp);
        if (pollStatusResp.errno == 60201) {
            if (this.this$0.f33156f <= 5) {
                this.this$0.f33155e.schedule(new Runnable(this.$keyType, this.$keyVal) {
                    public final /* synthetic */ int f$1;
                    public final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        PixKeyDetailVM$pollPixKeyStatus$1.m47002onSuccess$lambda0(PixKeyDetailVM.this, this.f$1, this.f$2);
                    }
                }, 1, TimeUnit.SECONDS);
                return;
            }
            this.this$0.isLoading().setValue(false);
            this.this$0.getUnBindApiData().errmsg = pollStatusResp.errmsg;
            this.this$0.getShowUnbindRetLD().setValue(true);
        } else if (pollStatusResp.errno == 0) {
            this.this$0.isLoading().setValue(false);
            this.this$0.getShowUnbindRetLD().setValue(true);
        } else {
            this.this$0.isLoading().setValue(false);
            this.this$0.getUnBindApiData().errmsg = pollStatusResp.errmsg;
            this.this$0.getShowUnbindRetLD().setValue(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m47002onSuccess$lambda0(PixKeyDetailVM pixKeyDetailVM, int i, String str) {
        Intrinsics.checkNotNullParameter(pixKeyDetailVM, "this$0");
        Intrinsics.checkNotNullParameter(str, "$keyVal");
        pixKeyDetailVM.pollPixKeyStatus(i, str);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isLoading().setValue(false);
    }
}
