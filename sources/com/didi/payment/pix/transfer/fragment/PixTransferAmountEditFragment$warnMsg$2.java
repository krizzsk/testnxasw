package com.didi.payment.pix.transfer.fragment;

import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDiff;
import com.pay99.diff_base.base.ITransferAmountTip;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/pay99/diff_base/base/ITransferAmountTip;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$warnMsg$2 extends Lambda implements Function0<ITransferAmountTip> {
    public static final PixTransferAmountEditFragment$warnMsg$2 INSTANCE = new PixTransferAmountEditFragment$warnMsg$2();

    PixTransferAmountEditFragment$warnMsg$2() {
        super(0);
    }

    public final ITransferAmountTip invoke() {
        IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TRANSFER_AMOUNT_TIP);
        if (diffValue instanceof ITransferAmountTip) {
            return (ITransferAmountTip) diffValue;
        }
        return null;
    }
}
