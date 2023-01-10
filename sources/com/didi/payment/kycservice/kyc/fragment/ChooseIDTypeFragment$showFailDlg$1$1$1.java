package com.didi.payment.kycservice.kyc.fragment;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.response.FaceResultResp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment$showFailDlg$1$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ChooseIDTypeFragment.kt */
public final class ChooseIDTypeFragment$showFailDlg$1$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ FaceResultResp.Data $dlgInfo;
    final /* synthetic */ FaceResultResp $faceResultResp;
    final /* synthetic */ ChooseIDTypeFragment this$0;

    ChooseIDTypeFragment$showFailDlg$1$1$1(ChooseIDTypeFragment chooseIDTypeFragment, FaceResultResp faceResultResp, FaceResultResp.Data data) {
        this.this$0 = chooseIDTypeFragment;
        this.$faceResultResp = faceResultResp;
        this.$dlgInfo = data;
    }

    public void doClick(View view) {
        String replace$default;
        this.this$0.m25243c(this.$faceResultResp);
        Map linkedHashMap = new LinkedHashMap();
        String firstButtonText = this.$dlgInfo.getFirstButtonText();
        String str = "";
        if (!(firstButtonText == null || (replace$default = StringsKt.replace$default(firstButtonText, " ", "_", false, 4, (Object) null)) == null)) {
            str = replace$default;
        }
        linkedHashMap.put("button_name", str);
        if (this.this$0.f33224c == 2002) {
            KycOmega.Companion.trackEvent("fin_fullkycverification_rgbutton_ck", linkedHashMap);
        } else if (this.this$0.f33224c == 2001) {
            KycOmega.Companion.trackEvent("fin_fullkycverification_cnhhumancheck_ck", linkedHashMap);
        }
    }
}
