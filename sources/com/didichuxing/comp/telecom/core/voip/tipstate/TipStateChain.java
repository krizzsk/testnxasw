package com.didichuxing.comp.telecom.core.voip.tipstate;

import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateChain;", "", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "tipChain", "Ljava/util/ArrayList;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "Lkotlin/collections/ArrayList;", "getTipStr", "", "tipStateComponent", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public final class TipStateChain {

    /* renamed from: a */
    private final ArrayList<AStateTip> f49119a;

    /* renamed from: b */
    private VoipAudioCall f49120b;

    public TipStateChain(VoipAudioCall voipAudioCall) {
        this.f49120b = voipAudioCall;
        ArrayList<AStateTip> arrayList = new ArrayList<>();
        arrayList.add(new BeforeInCallTip(this.f49120b));
        arrayList.add(new PoorNetworkTip(this.f49120b));
        arrayList.add(new CallStateTip(this.f49120b));
        arrayList.add(new InCallTimeTip(this.f49120b));
        this.f49119a = arrayList;
    }

    public final String getTipStr(TipStateComponent tipStateComponent) {
        Intrinsics.checkParameterIsNotNull(tipStateComponent, "tipStateComponent");
        String str = null;
        Iterator<AStateTip> it = this.f49119a.iterator();
        while (it.hasNext()) {
            String tipStr = it.next().getTipStr(tipStateComponent);
            if (tipStr != null && (!StringsKt.isBlank(tipStr))) {
                return tipStr;
            }
        }
        return str;
    }
}
