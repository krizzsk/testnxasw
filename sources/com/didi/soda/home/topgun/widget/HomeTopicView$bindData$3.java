package com.didi.soda.home.topgun.widget;

import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicView.kt */
final class HomeTopicView$bindData$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HomeTopicView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeTopicView$bindData$3(HomeTopicView homeTopicView) {
        super(0);
        this.this$0 = homeTopicView;
    }

    public final void invoke() {
        HomeTopicBinder.Companion.Logic logic = this.this$0.getLogic();
        if (logic != null) {
            logic.onTimerFinished();
        }
    }
}
