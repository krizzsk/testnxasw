package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Button;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$7$1$2 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$7$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Button $it;
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$onBindViewHolder$1$7$1$2(TopCardViewHolder topCardViewHolder, Button button) {
        super(0);
        this.this$0 = topCardViewHolder;
        this.$it = button;
    }

    public final void invoke() {
        WalletHomeContract.V2Listener lister = this.this$0.getLister();
        if (lister != null) {
            lister.onAccountBlocked2UnBlock(this.$it.getLinkUrl());
        }
        EventBus.getDefault().post(new WalletRefreshDataEvent());
    }
}
