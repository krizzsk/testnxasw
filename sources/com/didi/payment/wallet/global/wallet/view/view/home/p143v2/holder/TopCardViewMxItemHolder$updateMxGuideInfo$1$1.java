package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$updateMxGuideInfo$1$1 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$updateMxGuideInfo$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HeadCardList $headCard;
    final /* synthetic */ HeadCardList.HeadCardData.GuideInfo $this_apply;
    final /* synthetic */ TopCardViewMxItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$updateMxGuideInfo$1$1(TopCardViewMxItemHolder topCardViewMxItemHolder, HeadCardList.HeadCardData.GuideInfo guideInfo, HeadCardList headCardList) {
        super(0);
        this.this$0 = topCardViewMxItemHolder;
        this.$this_apply = guideInfo;
        this.$headCard = headCardList;
    }

    public final void invoke() {
        WalletHomeContract.V2Listener lister = this.this$0.getLister();
        if (lister != null) {
            lister.onBankListClick(this.$this_apply.getLinkUrl());
        }
        TopCardViewMxItemHolder.m26820a(this.this$0, this.$headCard, "addcard", (Integer) null, 4, (Object) null);
    }
}
