package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.drouter.api.DRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$updateMxBalance$3$2$1 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$updateMxBalance$3$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$updateMxBalance$3$2$1(String str) {
        super(0);
        this.$it = str;
    }

    public final void invoke() {
        DRouter.build(this.$it).start();
    }
}
