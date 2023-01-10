package com.didichuxing.comp.telecom.core;

import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.base.ICall;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* compiled from: CallManager.kt */
final class CallManager$1$onCallCreate$1 implements Runnable {
    final /* synthetic */ ICall $newCall;
    final /* synthetic */ CallManager.C160361 this$0;

    CallManager$1$onCallCreate$1(CallManager.C160361 r1, ICall iCall) {
        this.this$0 = r1;
        this.$newCall = iCall;
    }

    public final void run() {
        if (this.$newCall.getState() != CallState.IN_CALL && this.$newCall.getState() != CallState.END_CALL) {
            CallLogUtil.logI(this.this$0.this$0.f49048b, "onCallCreate - hangup income call for wait too long");
            this.$newCall.forceStop();
        }
    }
}
