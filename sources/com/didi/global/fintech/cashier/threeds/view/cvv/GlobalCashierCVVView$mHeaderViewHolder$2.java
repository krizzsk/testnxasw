package com.didi.global.fintech.cashier.threeds.view.cvv;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p118ui.viewholder.GlobalCashierHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierHeaderViewHolder;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierCVVView.kt */
final class GlobalCashierCVVView$mHeaderViewHolder$2 extends Lambda implements Function0<GlobalCashierHeaderViewHolder> {
    final /* synthetic */ GlobalCashierCVVView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCVVView$mHeaderViewHolder$2(GlobalCashierCVVView globalCashierCVVView) {
        super(0);
        this.this$0 = globalCashierCVVView;
    }

    public final GlobalCashierHeaderViewHolder invoke() {
        GlobalCashierHeaderViewHolder.Companion companion = GlobalCashierHeaderViewHolder.Companion;
        Context access$getMContext$p = this.this$0.f23591a;
        ViewGroup access$getMHeaderView$p = this.this$0.f23593c;
        Intrinsics.checkNotNullExpressionValue(access$getMHeaderView$p, "mHeaderView");
        return companion.newInstance(access$getMContext$p, access$getMHeaderView$p);
    }
}
