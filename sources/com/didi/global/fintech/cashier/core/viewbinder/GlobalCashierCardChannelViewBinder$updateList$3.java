package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierCardChannelViewBinder.kt */
/* synthetic */ class GlobalCashierCardChannelViewBinder$updateList$3 extends FunctionReferenceImpl implements Function1<ChannelItemViewHolderData, Unit> {
    GlobalCashierCardChannelViewBinder$updateList$3(Object obj) {
        super(1, obj, GlobalCashierCardChannelViewBinder.class, "onSpreadClick", "onSpreadClick(Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChannelItemViewHolderData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChannelItemViewHolderData channelItemViewHolderData) {
        ((GlobalCashierCardChannelViewBinder) this.receiver).onSpreadClick(channelItemViewHolderData);
    }
}
