package com.didi.payment.kycservice.utils;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/utils/IPollResultCallback;", "", "onFail", "", "response", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onSuccess", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PollVM.kt */
public interface IPollResultCallback {
    void onFail(WBaseResp wBaseResp);

    void onSuccess(PollStatusResp pollStatusResp);
}
