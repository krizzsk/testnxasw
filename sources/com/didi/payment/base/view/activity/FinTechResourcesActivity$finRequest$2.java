package com.didi.payment.base.view.activity;

import com.didi.payment.base.finResource.FinResourceRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/payment/base/finResource/FinResourceRequest;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FinTechResourcesActivity.kt */
final class FinTechResourcesActivity$finRequest$2 extends Lambda implements Function0<FinResourceRequest> {
    final /* synthetic */ FinTechResourcesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinTechResourcesActivity$finRequest$2(FinTechResourcesActivity finTechResourcesActivity) {
        super(0);
        this.this$0 = finTechResourcesActivity;
    }

    public final FinResourceRequest invoke() {
        return new FinResourceRequest(this.this$0);
    }
}
