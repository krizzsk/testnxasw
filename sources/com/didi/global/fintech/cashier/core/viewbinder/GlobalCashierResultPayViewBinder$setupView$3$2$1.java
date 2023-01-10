package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.p118ui.viewholder.MerchantButtonData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierResultPayViewBinder.kt */
final class GlobalCashierResultPayViewBinder$setupView$3$2$1 extends Lambda implements Function1<MerchantButtonData, Unit> {
    final /* synthetic */ MerchantButtonData $button;
    final /* synthetic */ GlobalCashierResultPayViewBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierResultPayViewBinder$setupView$3$2$1(GlobalCashierResultPayViewBinder globalCashierResultPayViewBinder, MerchantButtonData merchantButtonData) {
        super(1);
        this.this$0 = globalCashierResultPayViewBinder;
        this.$button = merchantButtonData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MerchantButtonData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MerchantButtonData merchantButtonData) {
        Intrinsics.checkNotNullParameter(merchantButtonData, "it");
        ((IGlobalCashierResultPresenter) this.this$0.getPresenter()).onBottomBtnClick(this.$button);
    }
}
