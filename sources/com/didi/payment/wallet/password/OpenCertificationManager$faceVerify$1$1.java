package com.didi.payment.wallet.password;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OpenCertificationManager.kt */
final class OpenCertificationManager$faceVerify$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HashMap<String, Object> $map;
    final /* synthetic */ String $params;
    final /* synthetic */ CertificationResultListener $resultListener;
    final /* synthetic */ int $source;
    final /* synthetic */ OpenCertificationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenCertificationManager$faceVerify$1$1(HashMap<String, Object> hashMap, OpenCertificationManager openCertificationManager, String str, int i, CertificationResultListener certificationResultListener) {
        super(0);
        this.$map = hashMap;
        this.this$0 = openCertificationManager;
        this.$params = str;
        this.$source = i;
        this.$resultListener = certificationResultListener;
    }

    public final void invoke() {
        FinOmegaSDK.trackEvent("ibt_password_frame_face_try_again_ck", this.$map);
        this.this$0.m26866a(this.$params, this.$source, this.$resultListener);
    }
}
