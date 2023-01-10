package com.didi.payment.pix.topup;

import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/pix/topup/TopUpByPixActivity$launchCashier$listener$1", "Lcom/didi/global/fintech/cashier/user/facade/CashierLaunchListener;", "onCashierLaunch", "", "result", "", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopUpByPixActivity.kt */
public final class TopUpByPixActivity$launchCashier$listener$1 implements CashierLaunchListener {
    final /* synthetic */ String $outOrderId;
    final /* synthetic */ TopUpByPixActivity this$0;

    TopUpByPixActivity$launchCashier$listener$1(TopUpByPixActivity topUpByPixActivity, String str) {
        this.this$0 = topUpByPixActivity;
        this.$outOrderId = str;
    }

    public void onCashierLaunch(boolean z) {
        if (!z) {
            this.this$0.m25636b(this.$outOrderId);
        }
    }
}
