package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.payment.wallet_ui.wheel.LinkageWheelAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J*\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\t\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/IDTypeFragment$setAlertDialog$1$2", "Lcom/didi/payment/wallet_ui/wheel/LinkageWheelAdapter;", "", "getItemByRoot", "selectedRootKey", "selectedRootIndex", "", "key", "index", "getItemsCountByRoot", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IDTypeFragment.kt */
public final class IDTypeFragment$setAlertDialog$1$2 extends LinkageWheelAdapter<String> {
    final /* synthetic */ List<JumioGuideResp.TimeData> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IDTypeFragment$setAlertDialog$1$2(List<JumioGuideResp.TimeData> list) {
        super("hour", "day", (String) null, 0, 12, (DefaultConstructorMarker) null);
        this.$it = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r1 = (r1 = r1.get(r4)).getDisplay();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getItemByRoot(java.lang.String r1, int r2, java.lang.String r3, int r4) {
        /*
            r0 = this;
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.util.List<com.didi.payment.kycservice.net.response.JumioGuideResp$TimeData> r1 = r0.$it
            java.lang.Object r1 = r1.get(r2)
            com.didi.payment.kycservice.net.response.JumioGuideResp$TimeData r1 = (com.didi.payment.kycservice.net.response.JumioGuideResp.TimeData) r1
            java.util.List r1 = r1.getHour()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0016
            goto L_0x0027
        L_0x0016:
            java.lang.Object r1 = r1.get(r4)
            com.didi.payment.kycservice.net.response.JumioGuideResp$HourData r1 = (com.didi.payment.kycservice.net.response.JumioGuideResp.HourData) r1
            if (r1 != 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.String r1 = r1.getDisplay()
            if (r1 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.IDTypeFragment$setAlertDialog$1$2.getItemByRoot(java.lang.String, int, java.lang.String, int):java.lang.String");
    }

    public int getItemsCountByRoot(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str2, "key");
        List<JumioGuideResp.HourData> hour = this.$it.get(i).getHour();
        if (hour == null) {
            return 0;
        }
        return hour.size();
    }
}
