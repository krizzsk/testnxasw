package com.didi.payment.kycservice.utils;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/payment/kycservice/utils/PollVM$pollPixKeyStatus$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "response", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PollVM.kt */
public final class PollVM$pollPixKeyStatus$1 extends WNetCallback<PollStatusResp> {
    final /* synthetic */ IPollResultCallback $callback;
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ int $pollType;
    final /* synthetic */ PollVM this$0;

    PollVM$pollPixKeyStatus$1(PollVM pollVM, IPollResultCallback iPollResultCallback, int i, String str, int i2) {
        this.this$0 = pollVM;
        this.$callback = iPollResultCallback;
        this.$keyType = i;
        this.$keyVal = str;
        this.$pollType = i2;
    }

    public void onSuccess(PollStatusResp pollStatusResp) {
        Intrinsics.checkNotNullParameter(pollStatusResp, "response");
        super.onSuccess(pollStatusResp);
        if (pollStatusResp.errno != 60201) {
            this.this$0.isLoading().setValue(false);
            this.$callback.onSuccess(pollStatusResp);
        } else if (this.this$0.getPollCount() <= 5) {
            this.this$0.f33477c.schedule(new Runnable(this.$keyType, this.$keyVal, this.$pollType, this.$callback) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ int f$3;
                public final /* synthetic */ IPollResultCallback f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    PollVM$pollPixKeyStatus$1.m47054onSuccess$lambda0(PollVM.this, this.f$1, this.f$2, this.f$3, this.f$4);
                }
            }, 1, TimeUnit.SECONDS);
        } else {
            this.this$0.isLoading().setValue(false);
            this.$callback.onFail(pollStatusResp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m47054onSuccess$lambda0(PollVM pollVM, int i, String str, int i2, IPollResultCallback iPollResultCallback) {
        Intrinsics.checkNotNullParameter(pollVM, "this$0");
        Intrinsics.checkNotNullParameter(str, "$keyVal");
        Intrinsics.checkNotNullParameter(iPollResultCallback, "$callback");
        pollVM.pollPixKeyStatus(i, str, i2, iPollResultCallback);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isLoading().setValue(false);
    }
}
