package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoHistoryContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoHistoryModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoHistoryResp;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoHistoryPresenter implements WalletBoletoHistoryContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34482a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoHistoryContract.View f34483b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34484c;

    /* renamed from: d */
    private WalletBoletoHistoryModel f34485d;

    public WalletBoletoHistoryPresenter(FragmentActivity fragmentActivity, WalletBoletoHistoryContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34482a = fragmentActivity;
        this.f34483b = view;
        this.f34484c = walletLoadingContract;
        this.f34485d = new WalletBoletoHistoryModel(fragmentActivity);
    }

    public void requestData() {
        this.f34484c.showLoadingDialog();
        this.f34485d.requestBoletoHistory(new RpcService.Callback<WalletBoletoHistoryResp>() {
            public void onSuccess(WalletBoletoHistoryResp walletBoletoHistoryResp) {
                WalletBoletoHistoryPresenter.this.f34484c.dismissLoadingDialog();
                if (walletBoletoHistoryResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoHistoryPresenter.this.f34482a, WalletBoletoHistoryPresenter.this.f34482a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoHistoryPresenter.this.f34483b.onNetworkError();
                } else if (walletBoletoHistoryResp.errno == 0) {
                    WalletBoletoHistoryPresenter.this.f34483b.displayBoletoHistory(walletBoletoHistoryResp.data);
                } else {
                    WalletToastNew.showFailedMsg(WalletBoletoHistoryPresenter.this.f34482a, walletBoletoHistoryResp.errmsg);
                    WalletBoletoHistoryPresenter.this.f34483b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoHistoryPresenter.this.f34484c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletBoletoHistoryPresenter.this.f34482a, WalletBoletoHistoryPresenter.this.f34482a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoHistoryPresenter.this.f34483b.onNetworkError();
            }
        });
    }
}
