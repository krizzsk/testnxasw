package com.didi.soda.order.omega;

import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/soda/order/omega/EvaluateOmegaHelper$Companion$trackEvaluatePageTagCk$moduleShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.order.omega.EvaluateOmegaHelper$Companion$trackEvaluatePageTagCk$moduleShowTrack$1 */
/* compiled from: EvaluateOmegaHelper.kt */
public final class C14917xf4ea1bc0 extends OnceActionUtil.OnceAction {
    final /* synthetic */ int $from;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C14917xf4ea1bc0(int i, String str) {
        super(str);
        this.$from = i;
    }

    public void run() {
        EvaluateOmegaHelper.Companion.createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_PAGE_TAG_CK).addEventParam("from_channel", Integer.valueOf(this.$from)).build().track();
    }
}
