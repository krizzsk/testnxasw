package com.didi.component.expectation.view;

import com.didi.component.business.xpanelnew.IXpCompRefresh;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ExpectationView2.kt */
final class ExpectationView2$updateViewByIndriver$2 implements Runnable {
    final /* synthetic */ IXpCompRefresh.IXpCompRefreshCb $callback;
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $refresh;
    final /* synthetic */ boolean $small;
    final /* synthetic */ ExpectationView2 this$0;

    ExpectationView2$updateViewByIndriver$2(ExpectationView2 expectationView2, boolean z, boolean z2, long j, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        this.this$0 = expectationView2;
        this.$small = z;
        this.$refresh = z2;
        this.$duration = j;
        this.$callback = iXpCompRefreshCb;
    }

    public final void run() {
        this.this$0.m12818a(this.$small, this.$refresh, this.$duration, this.$callback);
    }
}
