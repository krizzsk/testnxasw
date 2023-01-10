package com.didichuxing.comp.telecom.core.voip.tipstate;

import android.os.Handler;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent$runnable$1", "Ljava/lang/Runnable;", "run", "", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: TipStateComponent.kt */
public final class TipStateComponent$runnable$1 implements Runnable {
    final /* synthetic */ TipStateComponent this$0;

    TipStateComponent$runnable$1(TipStateComponent tipStateComponent) {
        this.this$0 = tipStateComponent;
    }

    public void run() {
        this.this$0.m36796a();
        Handler access$getMHandler$p = this.this$0.f49122b;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.postDelayed(this, 1000);
        }
    }
}
