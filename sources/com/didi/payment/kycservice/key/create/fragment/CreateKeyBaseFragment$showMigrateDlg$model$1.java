package com.didi.payment.kycservice.key.create.fragment;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/key/create/fragment/CreateKeyBaseFragment$showMigrateDlg$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateKeyBaseFragment.kt */
public final class CreateKeyBaseFragment$showMigrateDlg$model$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ CreateKeyBaseFragment this$0;

    CreateKeyBaseFragment$showMigrateDlg$model$1(CreateKeyBaseFragment createKeyBaseFragment, int i, String str) {
        this.this$0 = createKeyBaseFragment;
        this.$keyType = i;
        this.$keyVal = str;
    }

    public void onAntiShakeClick(View view) {
        if (this.this$0.f33109a != null) {
            LEGODrawer access$getDlgMigrate$p = this.this$0.f33109a;
            Intrinsics.checkNotNull(access$getDlgMigrate$p);
            if (access$getDlgMigrate$p.isShowing()) {
                LEGODrawer access$getDlgMigrate$p2 = this.this$0.f33109a;
                Intrinsics.checkNotNull(access$getDlgMigrate$p2);
                access$getDlgMigrate$p2.dismiss();
            }
        }
        CreateKeyBaseFragment.access$getVm(this.this$0).migrateIn(this.$keyType, this.$keyVal);
        int i = this.$keyType;
    }
}
