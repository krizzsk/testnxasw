package com.didi.payment.wallet.password;

import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/payment/wallet/password/OpenCertificationManager$fullKyc$1", "Lcom/didi/payment/kycservice/utils/KycRegisterUtils$RouterListener;", "callback", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OpenCertificationManager.kt */
public final class OpenCertificationManager$fullKyc$1 implements KycRegisterUtils.RouterListener {
    final /* synthetic */ String $params;
    final /* synthetic */ CertificationResultListener $resultListener;
    final /* synthetic */ OpenCertificationManager this$0;

    OpenCertificationManager$fullKyc$1(OpenCertificationManager openCertificationManager, String str, CertificationResultListener certificationResultListener) {
        this.this$0 = openCertificationManager;
        this.$params = str;
        this.$resultListener = certificationResultListener;
    }

    public void callback() {
        this.this$0.m26867a(this.$params, this.$resultListener);
    }
}
