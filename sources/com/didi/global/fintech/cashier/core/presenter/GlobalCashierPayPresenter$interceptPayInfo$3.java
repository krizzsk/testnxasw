package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.model.net.response.Payment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "index", "", "it", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$interceptPayInfo$3 extends Lambda implements Function2<Integer, Payment, Boolean> {
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$interceptPayInfo$3(GlobalCashierPayPresenter globalCashierPayPresenter) {
        super(2);
        this.this$0 = globalCashierPayPresenter;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Payment) obj2);
    }

    public final Boolean invoke(int i, Payment payment) {
        Integer channelId;
        Intrinsics.checkNotNullParameter(payment, "it");
        payment.setPosition(i);
        Integer channelId2 = payment.getChannelId();
        if ((channelId2 != null && channelId2.intValue() == 190) || ((channelId = payment.getChannelId()) != null && channelId.intValue() == 120)) {
            List<Integer> combineChannels = payment.getCombineChannels();
            boolean z = false;
            if (combineChannels != null && (!combineChannels.isEmpty())) {
                z = true;
            }
            if (z) {
                this.this$0.setBalanceSwitcher(true);
            }
        }
        return Boolean.valueOf(payment.getSelected());
    }
}
