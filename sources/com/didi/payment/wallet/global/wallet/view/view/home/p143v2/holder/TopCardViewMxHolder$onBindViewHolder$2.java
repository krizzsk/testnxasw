package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxHolder$onBindViewHolder$2 */
/* compiled from: TopCardViewMxHolder.kt */
final class TopCardViewMxHolder$onBindViewHolder$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TopCardViewMxHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxHolder$onBindViewHolder$2(TopCardViewMxHolder topCardViewMxHolder) {
        super(1);
        this.this$0 = topCardViewMxHolder;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.this$0.f35287e.smoothScrollToPosition(1);
    }
}
