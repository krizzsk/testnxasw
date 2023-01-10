package com.didi.payment.pix.transfer.fragment;

import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$showLimitInfoCommon$2 extends Lambda implements Function0<Unit> {
    public static final PixTransferAmountEditFragment$showLimitInfoCommon$2 INSTANCE = new PixTransferAmountEditFragment$showLimitInfoCommon$2();

    PixTransferAmountEditFragment$showLimitInfoCommon$2() {
        super(0);
    }

    public final void invoke() {
        GlobalOmegaUtils.trackSkuLimitInputExceedSw(99996);
    }
}
