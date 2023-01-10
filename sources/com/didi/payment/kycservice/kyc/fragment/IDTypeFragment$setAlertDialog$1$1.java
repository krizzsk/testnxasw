package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.payment.wallet_ui.wheel.LinkageWheelAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J*\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\t\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/IDTypeFragment$setAlertDialog$1$1", "Lcom/didi/payment/wallet_ui/wheel/LinkageWheelAdapter;", "", "getItemByRoot", "selectedRootKey", "selectedRootIndex", "", "key", "index", "getItemsCountByRoot", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IDTypeFragment.kt */
public final class IDTypeFragment$setAlertDialog$1$1 extends LinkageWheelAdapter<String> {
    final /* synthetic */ List<JumioGuideResp.TimeData> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IDTypeFragment$setAlertDialog$1$1(List<JumioGuideResp.TimeData> list) {
        super("day", (String) null, "hour", 0, 10, (DefaultConstructorMarker) null);
        this.$it = list;
    }

    public String getItemByRoot(String str, int i, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str2, "key");
        String display = this.$it.get(i2).getDisplay();
        return display == null ? "" : display;
    }

    public int getItemsCountByRoot(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str2, "key");
        return this.$it.size();
    }
}
