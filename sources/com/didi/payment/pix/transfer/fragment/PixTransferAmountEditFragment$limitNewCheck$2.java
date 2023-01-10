package com.didi.payment.pix.transfer.fragment;

import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$limitNewCheck$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map<String, Object> $param;
    final /* synthetic */ Ref.ObjectRef<String> $riskLink;
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixTransferAmountEditFragment$limitNewCheck$2(Ref.ObjectRef<String> objectRef, PixTransferAmountEditFragment pixTransferAmountEditFragment, Map<String, Object> map) {
        super(0);
        this.$riskLink = objectRef;
        this.this$0 = pixTransferAmountEditFragment;
        this.$param = map;
    }

    public final void invoke() {
        CharSequence charSequence = (CharSequence) this.$riskLink.element;
        if (!(charSequence == null || charSequence.length() == 0)) {
            DRouter.build((String) this.$riskLink.element).start(this.this$0.getContext());
        }
        FinOmegaSDK.trackEvent("fin_pix_transfer_error_ck", this.$param);
    }
}
