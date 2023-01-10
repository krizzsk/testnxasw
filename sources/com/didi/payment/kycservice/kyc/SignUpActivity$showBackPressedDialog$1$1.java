package com.didi.payment.kycservice.kyc;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/SignUpActivity$showBackPressedDialog$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUpActivity.kt */
public final class SignUpActivity$showBackPressedDialog$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ SignUpActivity this$0;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SignUpActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignUpPageScene.values().length];
            iArr[SignUpPageScene.GUIDE.ordinal()] = 1;
            iArr[SignUpPageScene.SIGN_UP_99PAY.ordinal()] = 2;
            iArr[SignUpPageScene.FULL_KYC_EXTRA.ordinal()] = 3;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE.ordinal()] = 4;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE_JUMIO.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SignUpActivity$showBackPressedDialog$1$1(SignUpActivity signUpActivity) {
        this.this$0 = signUpActivity;
    }

    public void doClick(View view) {
        String firstBtn;
        String replace$default;
        Map linkedHashMap = new LinkedHashMap();
        GuidesInfoResp.ExitDetail exitDetail = SignUpActivity.access$getVm(this.this$0).getExitDetail();
        String str = "";
        if (!(exitDetail == null || (firstBtn = exitDetail.getFirstBtn()) == null || (replace$default = StringsKt.replace$default(firstBtn, " ", "_", false, 4, (Object) null)) == null)) {
            str = replace$default;
        }
        linkedHashMap.put("button_name", str);
        linkedHashMap.put("button_type", 1);
        SignUpPageScene value = SignUpActivity.access$getVm(this.this$0).getPageSceneLD().getValue();
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            KycOmega.Companion.trackEvent("fin_kycguide_popupbutton_ck", linkedHashMap);
        } else if (i != 2) {
            if (i == 3) {
                KycOmega.Companion.trackEvent("fin_fullkycinformation_popupbutton_ck", linkedHashMap);
            } else if (i == 4) {
                KycOmega.Companion.trackEvent("fin_fullkycverification_popupbutton_ck", linkedHashMap);
            } else if (i == 5) {
                KycOmega.Companion.trackButtonEvent("fin_fullkycverification_popupbutton_ck", 1);
            }
        } else if (Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_PAGE(), (Object) OmegaComParams.FACE_GUIDE)) {
            KycOmega.Companion.trackButtonEvent("fin_faceguide_popupbutton_ck", 1);
        } else {
            KycOmega.Companion.trackEvent("fin_primarykycinformation_popupbutton_ck", linkedHashMap);
        }
        WalletDialog access$getMBackDialog$p = this.this$0.f33200g;
        if (access$getMBackDialog$p != null) {
            access$getMBackDialog$p.hide();
        }
    }
}
