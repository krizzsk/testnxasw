package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletViewBoletoContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoSendEmailResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletViewBoletoModel;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletViewBoletoPresenter implements WalletViewBoletoContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34486a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletViewBoletoContract.View f34487b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34488c;

    /* renamed from: d */
    private WalletViewBoletoModel f34489d;

    public WalletViewBoletoPresenter(FragmentActivity fragmentActivity, WalletViewBoletoContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34486a = fragmentActivity;
        this.f34487b = view;
        this.f34488c = walletLoadingContract;
        this.f34489d = new WalletViewBoletoModel(fragmentActivity);
    }

    public void sendEmail(WalletBoletoResp walletBoletoResp) {
        this.f34488c.showLoadingDialog();
        this.f34489d.sendEmail(walletBoletoResp, new RpcService.Callback<WalletBoletoSendEmailResp>() {
            public void onSuccess(WalletBoletoSendEmailResp walletBoletoSendEmailResp) {
                WalletViewBoletoPresenter.this.f34488c.dismissLoadingDialog();
                if (walletBoletoSendEmailResp == null) {
                    WalletToastNew.showFailedMsg(WalletViewBoletoPresenter.this.f34486a, WalletViewBoletoPresenter.this.f34486a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                } else if (walletBoletoSendEmailResp.errno == 0) {
                    WalletViewBoletoPresenter.this.f34487b.onEmailSentSuccess();
                } else {
                    WalletToastNew.showFailedMsg(WalletViewBoletoPresenter.this.f34486a, walletBoletoSendEmailResp.errmsg);
                }
            }

            public void onFailure(IOException iOException) {
                WalletViewBoletoPresenter.this.f34488c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletViewBoletoPresenter.this.f34486a, WalletViewBoletoPresenter.this.f34486a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                WalletViewBoletoPresenter.this.f34487b.onNetworkError();
            }
        });
    }
}
