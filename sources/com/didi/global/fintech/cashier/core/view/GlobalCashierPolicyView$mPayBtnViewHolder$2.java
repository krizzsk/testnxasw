package com.didi.global.fintech.cashier.core.view;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p118ui.viewholder.GlobalCashierPayBtnViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPayBtnViewHolder;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPolicyView.kt */
final class GlobalCashierPolicyView$mPayBtnViewHolder$2 extends Lambda implements Function0<GlobalCashierPayBtnViewHolder> {
    final /* synthetic */ GlobalCashierPolicyView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPolicyView$mPayBtnViewHolder$2(GlobalCashierPolicyView globalCashierPolicyView) {
        super(0);
        this.this$0 = globalCashierPolicyView;
    }

    public final GlobalCashierPayBtnViewHolder invoke() {
        GlobalCashierPayBtnViewHolder.Companion companion = GlobalCashierPayBtnViewHolder.Companion;
        Context access$getMContext$p = this.this$0.f23376a;
        ViewGroup access$getMBottomView$p = this.this$0.f23380e;
        Intrinsics.checkNotNullExpressionValue(access$getMBottomView$p, "mBottomView");
        return companion.newInstance(access$getMContext$p, access$getMBottomView$p);
    }
}
