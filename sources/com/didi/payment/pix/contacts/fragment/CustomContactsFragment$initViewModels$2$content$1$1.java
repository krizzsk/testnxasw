package com.didi.payment.pix.contacts.fragment;

import android.view.View;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/pix/contacts/fragment/CustomContactsFragment$initViewModels$2$content$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomContactsFragment.kt */
public final class CustomContactsFragment$initViewModels$2$content$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ WalletDialog $dialog;

    CustomContactsFragment$initViewModels$2$content$1$1(WalletDialog walletDialog) {
        this.$dialog = walletDialog;
    }

    public void doClick(View view) {
        this.$dialog.dismiss();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_to_bank_transfer_ck");
    }
}
