package com.didi.soda.customer.blocks.card;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopicHeaderWidget.kt */
final class TopicHeaderWidget$setCountDown$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TopicHeaderWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicHeaderWidget$setCountDown$1$1(TopicHeaderWidget topicHeaderWidget) {
        super(0);
        this.this$0 = topicHeaderWidget;
    }

    public final void invoke() {
        Function0 access$getCountDownCallback$p = this.this$0.f43179b;
        if (access$getCountDownCallback$p != null) {
            access$getCountDownCallback$p.invoke();
        }
    }
}
