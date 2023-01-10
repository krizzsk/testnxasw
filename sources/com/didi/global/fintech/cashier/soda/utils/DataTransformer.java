package com.didi.global.fintech.cashier.soda.utils;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/utils/DataTransformer;", "", "()V", "transform", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "srcData", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DataTransformer.kt */
public final class DataTransformer {
    public static final DataTransformer INSTANCE = new DataTransformer();

    private DataTransformer() {
    }

    public final Payment transform(GPayMethodItem gPayMethodItem) {
        Intrinsics.checkNotNullParameter(gPayMethodItem, "srcData");
        Integer num = null;
        Payment payment = new Payment((String) null, (String) null, (String) null, (String) null, (String) null, (Payment.BalanceInfo) null, false, false, false, (Payment.InstallmentVo) null, (List) null, (List) null, (Boolean) null, (CashierAction) null, 0, 32767, (DefaultConstructorMarker) null);
        payment.setChannelId(gPayMethodItem.getChannelId());
        payment.setExtraInfo(new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null));
        Payment.ExtraInfo extraInfo = payment.getExtraInfo();
        Intrinsics.checkNotNull(extraInfo);
        GPayMethodItem.ExtraInfo extraInfo2 = gPayMethodItem.getExtraInfo();
        extraInfo.setCardIndex(extraInfo2 == null ? null : extraInfo2.getCardIndex());
        Payment.ExtraInfo extraInfo3 = payment.getExtraInfo();
        Intrinsics.checkNotNull(extraInfo3);
        GPayMethodItem.ExtraInfo extraInfo4 = gPayMethodItem.getExtraInfo();
        if (extraInfo4 != null) {
            num = extraInfo4.getInstallmentNumber();
        }
        extraInfo3.setInstallmentNumber(num);
        return payment;
    }
}
