package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.content.Context;
import android.widget.TextView;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardViewMxItemHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$updateMxBalance$1$1$1 */
/* compiled from: TopCardViewMxItemHolder.kt */
final class TopCardViewMxItemHolder$updateMxBalance$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $amountStatus;
    final /* synthetic */ Context $context;
    final /* synthetic */ TopCardViewMxItemHolder.ItemHolder $holder;
    final /* synthetic */ TopCardViewMxItemHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewMxItemHolder$updateMxBalance$1$1$1(Ref.BooleanRef booleanRef, TopCardViewMxItemHolder.ItemHolder itemHolder, Context context, TopCardViewMxItemHolder topCardViewMxItemHolder) {
        super(0);
        this.$amountStatus = booleanRef;
        this.$holder = itemHolder;
        this.$context = context;
        this.this$0 = topCardViewMxItemHolder;
    }

    public final void invoke() {
        TextView tvTopCardMxBalanceTitle = this.$holder.getTvTopCardMxBalanceTitle();
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TopCardVH.Companion.switchAmountStatus(!this.$amountStatus.element, tvTopCardMxBalanceTitle, context);
        WalletHomeAmountStatus.Companion.saveAmountStatus(!this.$amountStatus.element);
        Ref.BooleanRef booleanRef = this.$amountStatus;
        booleanRef.element = !booleanRef.element;
        this.this$0.notifyDataSetChanged();
        WalletHomeContract.V2Listener lister = this.this$0.getLister();
        if (lister != null) {
            lister.onRefreshUI(false);
        }
    }
}
