package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Button;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$7$1$1 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$7$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Data $data;
    final /* synthetic */ Button $it;
    final /* synthetic */ Data $this_apply;
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$onBindViewHolder$1$7$1$1(TopCardViewHolder topCardViewHolder, Button button, Data data, Data data2) {
        super(0);
        this.this$0 = topCardViewHolder;
        this.$it = button;
        this.$this_apply = data;
        this.$data = data2;
    }

    public final void invoke() {
        WalletHomeContract.V2Listener lister = this.this$0.getLister();
        if (lister != null) {
            String linkUrl = this.$it.getLinkUrl();
            AccountSection accountSection = this.$this_apply.getAccountSection();
            lister.onAccountMainEnterClicked(linkUrl, accountSection == null ? null : accountSection.getKycStatus());
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(this.this$0.itemView.getContext(), this.$data, "topup");
    }
}
