package com.didi.entrega.customer.foundation.rpc.entity;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo148868d2 = {"isPayChannelInvalid", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillInfoExtra.kt */
public final class BillInfoExtraKt {
    public static final boolean isPayChannelInvalid(PayChannel payChannel) {
        Intrinsics.checkNotNullParameter(payChannel, "<this>");
        if (payChannel.getChannelId() == 0) {
            return true;
        }
        if (payChannel.getChannelId() != 150 || (!TextUtils.isEmpty(payChannel.getCardIndex()) && !TextUtils.isEmpty(payChannel.getCardSuffix()))) {
            return false;
        }
        return true;
    }
}
