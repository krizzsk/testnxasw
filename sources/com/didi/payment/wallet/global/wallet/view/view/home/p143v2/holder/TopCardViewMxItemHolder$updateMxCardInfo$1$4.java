package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.creditcard.global.model.CancelCardParam;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$updateMxCardInfo$1$4 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$updateMxCardInfo$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HeadCardList $headCard;
    final /* synthetic */ HeadCardList.HeadCardData.CardInfo $this_apply;
    final /* synthetic */ TopCardViewMxItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$updateMxCardInfo$1$4(HeadCardList.HeadCardData.CardInfo cardInfo, TopCardViewMxItemHolder topCardViewMxItemHolder, HeadCardList headCardList) {
        super(0);
        this.$this_apply = cardInfo;
        this.this$0 = topCardViewMxItemHolder;
        this.$headCard = headCardList;
    }

    public final void invoke() {
        CancelCardParam cancelCardParam = new CancelCardParam();
        cancelCardParam.cardIndex = this.$this_apply.getCardIndex();
        cancelCardParam.cardNo = this.$this_apply.getName();
        cancelCardParam.expiryDate = this.$this_apply.getExpireDate();
        cancelCardParam.expired = this.$this_apply.getExpired();
        WalletHomeContract.V2Listener lister = this.this$0.getLister();
        if (lister != null) {
            lister.toBankCardDetailActivity(cancelCardParam);
        }
        TopCardViewMxItemHolder topCardViewMxItemHolder = this.this$0;
        HeadCardList headCardList = this.$headCard;
        HeadCardList.HeadCardData.LogData logData = headCardList.getHeadCardData().getLogData();
        topCardViewMxItemHolder.m26822a(headCardList, "cardinfo", logData == null ? null : logData.getCardNum());
    }
}
