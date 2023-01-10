package com.didi.rfusion.widget.calendar;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
final class RFCalendar$postSmoothRecyclerViewScroll$1 implements Runnable {
    final /* synthetic */ int $position;
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$postSmoothRecyclerViewScroll$1(RFCalendar rFCalendar, int i) {
        this.this$0 = rFCalendar;
        this.$position = i;
    }

    public final void run() {
        RFCalendar.access$getRvMonths$p(this.this$0).smoothScrollToPosition(this.$position);
    }
}
