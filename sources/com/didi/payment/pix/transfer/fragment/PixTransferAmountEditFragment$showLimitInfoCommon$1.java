package com.didi.payment.pix.transfer.fragment;

import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$showLimitInfoCommon$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $link;
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixTransferAmountEditFragment$showLimitInfoCommon$1(String str, PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        super(0);
        this.$link = str;
        this.this$0 = pixTransferAmountEditFragment;
    }

    public final void invoke() {
        CharSequence charSequence = this.$link;
        if (!(charSequence == null || charSequence.length() == 0)) {
            DRouter.build(this.$link).start(this.this$0.getContext());
        }
        GlobalOmegaUtils.trackSkuLimitInputExceedCk(99996);
    }
}
