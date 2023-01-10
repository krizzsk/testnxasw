package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IDTypeFragment.kt */
final class IDTypeFragment$initListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IDTypeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IDTypeFragment$initListener$2(IDTypeFragment iDTypeFragment) {
        super(0);
        this.this$0 = iDTypeFragment;
    }

    public final void invoke() {
        WalletDialog access$getAlertDrawer$p = this.this$0.f33284l;
        if (access$getAlertDrawer$p != null) {
            SystemUtils.showDialog(access$getAlertDrawer$p);
        }
        KycOmega.Companion.trackButtonEvent("fin_table2_certificate_ck", 1);
    }
}
