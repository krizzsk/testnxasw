package com.didi.global.fintech.cashier.p118ui.viewholder.item;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.InstallmentVo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "item", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierCardChannelItemViewHolder$bindData$5$adapter$1 */
/* compiled from: GlobalCashierCardChannelItemViewHolder.kt */
final class GlobalCashierCardChannelItemViewHolder$bindData$5$adapter$1 extends Lambda implements Function1<InstallmentVo.PlansVo, Unit> {

    /* renamed from: $d */
    final /* synthetic */ ChannelItemViewHolderData f23774$d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCardChannelItemViewHolder$bindData$5$adapter$1(ChannelItemViewHolderData channelItemViewHolderData) {
        super(1);
        this.f23774$d = channelItemViewHolderData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InstallmentVo.PlansVo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InstallmentVo.PlansVo plansVo) {
        Function1<InstallmentVo.PlansVo, Unit> onInstallmentClick;
        Intrinsics.checkNotNullParameter(plansVo, "item");
        if (!plansVo.isSelected() && (onInstallmentClick = this.f23774$d.getOnInstallmentClick()) != null) {
            onInstallmentClick.invoke(plansVo);
        }
    }
}
