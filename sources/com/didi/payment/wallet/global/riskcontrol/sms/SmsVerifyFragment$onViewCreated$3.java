package com.didi.payment.wallet.global.riskcontrol.sms;

import com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/payment/wallet/global/riskcontrol/sms/SmsVerifyFragment$onViewCreated$3", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IClearListener;", "onClear", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SmsVerifyFragment.kt */
public final class SmsVerifyFragment$onViewCreated$3 implements SmsEditView.IClearListener {
    final /* synthetic */ SmsVerifyFragment this$0;

    SmsVerifyFragment$onViewCreated$3(SmsVerifyFragment smsVerifyFragment) {
        this.this$0 = smsVerifyFragment;
    }

    public void onClear() {
        SmsEditView access$getEditSms$p = this.this$0.f34342a;
        if (access$getEditSms$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editSms");
            access$getEditSms$p = null;
        }
        access$getEditSms$p.setText("");
    }
}
