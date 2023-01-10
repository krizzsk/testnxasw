package com.didichuxing.comp.telecom.biz.p177ui.calllist;

import com.didichuxing.comp.telecom.biz.p177ui.calllist.CallListBottomPop;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.request.model.CallListModel;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.calllist.CallListBottomPop$requestCallList$cancelDelay$1 */
/* compiled from: CallListBottomPop.kt */
final class CallListBottomPop$requestCallList$cancelDelay$1 implements Runnable {
    final /* synthetic */ CallListBottomPop this$0;

    CallListBottomPop$requestCallList$cancelDelay$1(CallListBottomPop callListBottomPop) {
        this.this$0 = callListBottomPop;
    }

    public final void run() {
        CallListBottomPop.CallListRequestCallback access$getMRequestCallback$p = this.this$0.f48950f;
        if (access$getMRequestCallback$p != null) {
            access$getMRequestCallback$p.cancel();
        }
        CallListBottomPop.CallListRequestCallback access$getMRequestCallback$p2 = this.this$0.f48950f;
        if (access$getMRequestCallback$p2 != null && !access$getMRequestCallback$p2.getFinished()) {
            CallLogUtil.logI(this.this$0.f48945a, "call list request overtime , show default phone item");
            this.this$0.showLoading$voip_biz_release(false);
            this.this$0.m36729a((CallListModel) null);
        }
        this.this$0.f48950f = null;
    }
}
