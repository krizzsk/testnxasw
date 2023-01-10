package com.didi.component.expectation.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ExpectationView2.kt */
final class ExpectationView2$performUpdateViewByIndriverWithAnimated$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ExpectationView2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpectationView2$performUpdateViewByIndriverWithAnimated$1(ExpectationView2 expectationView2) {
        super(0);
        this.this$0 = expectationView2;
    }

    public final void invoke() {
        this.this$0.f15535e = false;
        Function0 access$getPendingUpdateAction$p = this.this$0.f15541k;
        if (access$getPendingUpdateAction$p != null) {
            access$getPendingUpdateAction$p.invoke();
        }
    }
}
