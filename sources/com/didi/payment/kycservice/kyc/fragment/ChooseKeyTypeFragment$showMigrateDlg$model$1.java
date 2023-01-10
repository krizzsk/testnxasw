package com.didi.payment.kycservice.kyc.fragment;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/ChooseKeyTypeFragment$showMigrateDlg$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ChooseKeyTypeFragment.kt */
public final class ChooseKeyTypeFragment$showMigrateDlg$model$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ MigrateTipData $dlgInfo;
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ ChooseKeyTypeFragment this$0;

    ChooseKeyTypeFragment$showMigrateDlg$model$1(ChooseKeyTypeFragment chooseKeyTypeFragment, int i, String str, MigrateTipData migrateTipData) {
        this.this$0 = chooseKeyTypeFragment;
        this.$keyType = i;
        this.$keyVal = str;
        this.$dlgInfo = migrateTipData;
    }

    public void onAntiShakeClick(View view) {
        if (this.this$0.f33226b != null) {
            LEGODrawer access$getDlgMigrate$p = this.this$0.f33226b;
            Intrinsics.checkNotNull(access$getDlgMigrate$p);
            if (access$getDlgMigrate$p.isShowing()) {
                LEGODrawer access$getDlgMigrate$p2 = this.this$0.f33226b;
                Intrinsics.checkNotNull(access$getDlgMigrate$p2);
                access$getDlgMigrate$p2.dismiss();
            }
        }
        ChooseKeyTypeFragment.access$getVm(this.this$0).migrateIn(this.$keyType, this.$keyVal);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", this.$dlgInfo.getMigrateButton());
        KycOmega.Companion.trackEvent("fin_pixkeyregistration_popupbutton_ck", linkedHashMap);
    }
}
