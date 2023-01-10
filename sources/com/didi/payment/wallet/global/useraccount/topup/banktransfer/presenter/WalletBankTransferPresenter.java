package com.didi.payment.wallet.global.useraccount.topup.banktransfer.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.useraccount.topup.banktransfer.contract.WalletBankTransferContract;

public class WalletBankTransferPresenter implements WalletBankTransferContract.Presenter {

    /* renamed from: a */
    private FragmentActivity f34376a;

    /* renamed from: b */
    private WalletBankTransferContract.View f34377b;

    public void requestData() {
    }

    public WalletBankTransferPresenter(FragmentActivity fragmentActivity, WalletBankTransferContract.View view) {
        this.f34376a = fragmentActivity;
        this.f34377b = view;
    }
}
