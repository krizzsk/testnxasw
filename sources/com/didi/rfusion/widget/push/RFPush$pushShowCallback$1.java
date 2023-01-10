package com.didi.rfusion.widget.push;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFPush.kt */
final class RFPush$pushShowCallback$1 implements Runnable {
    final /* synthetic */ RFPush this$0;

    RFPush$pushShowCallback$1(RFPush rFPush) {
        this.this$0 = rFPush;
    }

    public final void run() {
        if (this.this$0.f36425c != null || this.this$0.f36426d != null) {
            RFPush.access$getPushView$p(this.this$0).show();
        }
    }
}
