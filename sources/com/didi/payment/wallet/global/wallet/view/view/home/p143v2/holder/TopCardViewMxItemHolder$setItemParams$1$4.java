package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$setItemParams$1$4 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$setItemParams$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ TopCardViewMxItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$setItemParams$1$4(TopCardViewMxItemHolder topCardViewMxItemHolder, int i) {
        super(0);
        this.this$0 = topCardViewMxItemHolder;
        this.$position = i;
    }

    public final void invoke() {
        Function1<Boolean, Unit> unit = this.this$0.getUnit();
        if (unit != null) {
            unit.invoke(Boolean.valueOf(this.$position == 0));
        }
    }
}
