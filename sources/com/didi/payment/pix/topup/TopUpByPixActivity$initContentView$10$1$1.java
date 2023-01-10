package com.didi.payment.pix.topup;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/pix/topup/TopUpByPixActivity$initContentView$10$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopUpByPixActivity.kt */
public final class TopUpByPixActivity$initContentView$10$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ Ref.ObjectRef<WalletDialog> $dialog;

    TopUpByPixActivity$initContentView$10$1$1(Ref.ObjectRef<WalletDialog> objectRef) {
        this.$dialog = objectRef;
    }

    public void doClick(View view) {
        WalletDialog walletDialog = (WalletDialog) this.$dialog.element;
        if (walletDialog != null) {
            walletDialog.dismiss();
        }
    }
}
