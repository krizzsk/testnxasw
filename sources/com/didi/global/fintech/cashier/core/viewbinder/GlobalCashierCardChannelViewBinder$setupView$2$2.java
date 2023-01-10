package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierCardChannelViewBinder.kt */
/* synthetic */ class GlobalCashierCardChannelViewBinder$setupView$2$2 extends FunctionReferenceImpl implements Function1<Payment, ChannelItemViewHolderData> {
    GlobalCashierCardChannelViewBinder$setupView$2$2(Object obj) {
        super(1, obj, ViewBinderDataParser.Companion.class, "paymentTransToCardBinderData", "paymentTransToCardBinderData(Lcom/didi/global/fintech/cashier/model/net/response/Payment;)Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", 0);
    }

    public final ChannelItemViewHolderData invoke(Payment payment) {
        Intrinsics.checkNotNullParameter(payment, "p0");
        return ((ViewBinderDataParser.Companion) this.receiver).paymentTransToCardBinderData(payment);
    }
}
