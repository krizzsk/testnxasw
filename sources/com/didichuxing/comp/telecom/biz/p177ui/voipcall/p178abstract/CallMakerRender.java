package com.didichuxing.comp.telecom.biz.p177ui.voipcall.p178abstract;

import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/abstract/CallMakerRender;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/abstract/ACallRender;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.abstract.CallMakerRender */
/* compiled from: ACallRender.kt */
public final class CallMakerRender extends ACallRender {

    /* renamed from: a */
    private final String f48977a = "CallMakerRender";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallMakerRender(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipCall");
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f48977a;
    }
}
