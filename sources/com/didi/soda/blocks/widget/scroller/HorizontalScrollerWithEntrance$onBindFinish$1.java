package com.didi.soda.blocks.widget.scroller;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
final class HorizontalScrollerWithEntrance$onBindFinish$1 implements Runnable {
    final /* synthetic */ HorizontalScrollerWithEntrance this$0;

    HorizontalScrollerWithEntrance$onBindFinish$1(HorizontalScrollerWithEntrance horizontalScrollerWithEntrance) {
        this.this$0 = horizontalScrollerWithEntrance;
    }

    public final void run() {
        this.this$0.checkInVisible();
        this.this$0.scrollToLastPosition();
    }
}
