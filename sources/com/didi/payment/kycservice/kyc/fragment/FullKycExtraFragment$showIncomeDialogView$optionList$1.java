package com.didi.payment.kycservice.kyc.fragment;

import androidx.exifinterface.media.ExifInterface;
import com.didi.payment.wallet_ui.wheel.OptionWheelAdapter;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$showIncomeDialogView$optionList$1", "Lcom/didi/payment/wallet_ui/wheel/OptionWheelAdapter;", "", "getItem", "index", "", "getItemsCount", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment$showIncomeDialogView$optionList$1 extends OptionWheelAdapter<String> {
    final /* synthetic */ Ref.IntRef $curPosition;
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$showIncomeDialogView$optionList$1(FullKycExtraFragment fullKycExtraFragment, Ref.IntRef intRef) {
        super(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, intRef.element);
        this.this$0 = fullKycExtraFragment;
        this.$curPosition = intRef;
    }

    public int getItemsCount() {
        LinkedList access$getIncomeList$p = this.this$0.f33259s;
        if (access$getIncomeList$p == null) {
            return 0;
        }
        return access$getIncomeList$p.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r3 = (r3 = (com.didi.payment.kycservice.kyc.response.GuidesInfoResp.Income) r0.get(r3)).getDisplay();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getItem(int r3) {
        /*
            r2 = this;
            com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment r0 = r2.this$0
            java.util.LinkedList r0 = r0.f33259s
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000b
            goto L_0x001c
        L_0x000b:
            java.lang.Object r3 = r0.get(r3)
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Income r3 = (com.didi.payment.kycservice.kyc.response.GuidesInfoResp.Income) r3
            if (r3 != 0) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.String r3 = r3.getDisplay()
            if (r3 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = r3
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment$showIncomeDialogView$optionList$1.getItem(int):java.lang.String");
    }
}
