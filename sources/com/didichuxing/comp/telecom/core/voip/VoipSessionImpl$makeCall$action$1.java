package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.voip.VoipSessionImpl;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
final class VoipSessionImpl$makeCall$action$1 implements Runnable {
    final /* synthetic */ VoipSessionImpl.CallMakerStateListener $callMakerStateListener;
    final /* synthetic */ VoipSessionImpl this$0;

    VoipSessionImpl$makeCall$action$1(VoipSessionImpl voipSessionImpl, VoipSessionImpl.CallMakerStateListener callMakerStateListener) {
        this.this$0 = voipSessionImpl;
        this.$callMakerStateListener = callMakerStateListener;
    }

    public final void run() {
        CallingService access$getMCallService$p = this.this$0.f49105f;
        if (access$getMCallService$p != null) {
            access$getMCallService$p.addListener(new CallingServiceListenerWrapper(this.$callMakerStateListener));
        }
        this.this$0.m36792b();
    }
}
