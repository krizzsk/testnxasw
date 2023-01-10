package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardViewMxItemHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$updateBottomInfo$1$4$1 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$updateBottomInfo$1$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HeadCardList $headCard;
    final /* synthetic */ TopCardViewMxItemHolder.ItemHolder $holder;
    final /* synthetic */ String $it;
    final /* synthetic */ HeadCardList.HeadCardData.Menu $this_apply;
    final /* synthetic */ TopCardViewMxItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$updateBottomInfo$1$4$1(String str, HeadCardList.HeadCardData.Menu menu, TopCardViewMxItemHolder.ItemHolder itemHolder, TopCardViewMxItemHolder topCardViewMxItemHolder, HeadCardList headCardList) {
        super(0);
        this.$it = str;
        this.$this_apply = menu;
        this.$holder = itemHolder;
        this.this$0 = topCardViewMxItemHolder;
        this.$headCard = headCardList;
    }

    public final void invoke() {
        DRouter.build(this.$it).start();
        HeadCardList.HeadCardData.Menu menu = this.$this_apply;
        Context context = this.$holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
        menu.saveRedDot(context);
        this.this$0.notifyDataSetChanged();
        TopCardViewMxItemHolder topCardViewMxItemHolder = this.this$0;
        HeadCardList headCardList = this.$headCard;
        HeadCardList.HeadCardData.LogData logData = headCardList.getHeadCardData().getLogData();
        topCardViewMxItemHolder.m26822a(headCardList, "cardlist", logData == null ? null : logData.getCardNum());
    }
}
