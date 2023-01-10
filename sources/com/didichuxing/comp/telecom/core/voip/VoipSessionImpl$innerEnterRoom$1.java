package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallThreadDispatcher;
import com.didichuxing.comp.telecom.core.CallUtils;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.webrtc.SurfaceViewRenderer;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
final class VoipSessionImpl$innerEnterRoom$1 implements Runnable {
    final /* synthetic */ boolean $needSdkRecord;
    final /* synthetic */ Ref.IntRef $roomId;
    final /* synthetic */ Ref.ObjectRef $roomPin;
    final /* synthetic */ String $uid;
    final /* synthetic */ VoipSessionImpl this$0;

    VoipSessionImpl$innerEnterRoom$1(VoipSessionImpl voipSessionImpl, Ref.IntRef intRef, String str, Ref.ObjectRef objectRef, boolean z) {
        this.this$0 = voipSessionImpl;
        this.$roomId = intRef;
        this.$uid = str;
        this.$roomPin = objectRef;
        this.$needSdkRecord = z;
    }

    public final void run() {
        try {
            CallingService access$getMCallService$p = this.this$0.f49105f;
            Integer valueOf = access$getMCallService$p != null ? Integer.valueOf(access$getMCallService$p.callOut(CallManager.Companion.getInstance().getAppContext(), (SurfaceViewRenderer) null, this.$roomId.element, this.$uid, (String) this.$roomPin.element, DrtcMode.OnlyAudio, this.$needSdkRecord)) : null;
            String access$getTAG$p = this.this$0.f49100a;
            CallLogUtil.logI(access$getTAG$p, "innerEnterRoom - async callout:" + valueOf);
            if (valueOf != null) {
                if (valueOf.intValue() == -1 && this.this$0.f49102c != CallState.END_CALL) {
                    CallThreadDispatcher.Companion.getInstance().runOnUiThread(new Runnable(this) {
                        final /* synthetic */ VoipSessionImpl$innerEnterRoom$1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void run() {
                            this.this$0.this$0.m36791a(CallUtils.INSTANCE.getStringRes(Integer.valueOf(R.string.GDriver_IBT_Network_interrupt_xSfY)));
                            VoipSessionImpl.m36790a(this.this$0.this$0, (String) null, 1, (Object) null);
                        }
                    });
                }
            }
        } catch (Exception e) {
            CallLogUtil.logError(this.this$0.f49100a, "sdk callOut error", e);
        }
    }
}
