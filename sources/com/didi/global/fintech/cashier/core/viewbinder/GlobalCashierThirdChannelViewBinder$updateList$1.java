package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierThirdChannelViewBinder.kt */
/* synthetic */ class GlobalCashierThirdChannelViewBinder$updateList$1 extends FunctionReferenceImpl implements Function1<ChannelItemViewHolderData, Unit> {
    GlobalCashierThirdChannelViewBinder$updateList$1(Object obj) {
        super(1, obj, GlobalCashierThirdChannelViewBinder.class, "onMethodClick", "onMethodClick(Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChannelItemViewHolderData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "p0");
        ((GlobalCashierThirdChannelViewBinder) this.receiver).onMethodClick(channelItemViewHolderData);
    }
}
