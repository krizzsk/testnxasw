package com.didi.nova.kyc.jumio;

import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.didi.nova.kyc.jumio.view.JumioConfirmCustomView;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/nova/kyc/jumio/DDCustomActivity$goConfirm$1$2", "Lcom/didi/nova/kyc/jumio/view/JumioConfirmCustomView$JumioBtnClick;", "onClick", "", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DDCustomActivity.kt */
public final class DDCustomActivity$goConfirm$1$2 implements JumioConfirmCustomView.JumioBtnClick {
    final /* synthetic */ DDCustomActivity this$0;

    DDCustomActivity$goConfirm$1$2(DDCustomActivity dDCustomActivity) {
        this.this$0 = dDCustomActivity;
    }

    public void onClick() {
        if (this.this$0.f31784j != null) {
            JumioOmegaUtil.Companion.fin_jumioconfirm_button_ck(1);
        }
    }
}
