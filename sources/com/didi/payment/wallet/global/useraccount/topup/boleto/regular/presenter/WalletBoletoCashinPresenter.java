package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoCashinContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoCashinModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoCashinResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BoletoCreateErrorFragment;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoCashinPresenter implements WalletBoletoCashinContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34478a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoCashinContract.View f34479b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34480c;

    /* renamed from: d */
    private WalletBoletoCashinModel f34481d;

    public WalletBoletoCashinPresenter(FragmentActivity fragmentActivity, WalletBoletoCashinContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34478a = fragmentActivity;
        this.f34479b = view;
        this.f34480c = walletLoadingContract;
        this.f34481d = new WalletBoletoCashinModel(fragmentActivity);
    }

    public void submitBoleto(Long l) {
        this.f34480c.showLoadingDialog();
        this.f34481d.submitBoleto(l, new RpcService.Callback<WalletBoletoCashinResp>() {
            public void onSuccess(WalletBoletoCashinResp walletBoletoCashinResp) {
                WalletBoletoCashinPresenter.this.f34480c.dismissLoadingDialog();
                if (walletBoletoCashinResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoCashinPresenter.this.f34478a, WalletBoletoCashinPresenter.this.f34478a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoCashinPresenter.this.f34479b.onNetworkError();
                } else if (walletBoletoCashinResp.errno == 0) {
                    WalletBoletoCashinPresenter.this.f34479b.displayBoleto(walletBoletoCashinResp.data);
                } else {
                    processError(WalletBoletoCashinPresenter.this.f34478a, walletBoletoCashinResp);
                    WalletBoletoCashinPresenter.this.f34479b.onNetworkError();
                }
            }

            private void processError(FragmentActivity fragmentActivity, WalletBoletoCashinResp walletBoletoCashinResp) {
                if (walletBoletoCashinResp.errno == 20100 || walletBoletoCashinResp.errno == 20101) {
                    BoletoCreateErrorFragment boletoCreateErrorFragment = new BoletoCreateErrorFragment();
                    boletoCreateErrorFragment.setData(walletBoletoCashinResp.errmsg);
                    boletoCreateErrorFragment.show(fragmentActivity.getSupportFragmentManager(), "createboletoerror");
                } else if (walletBoletoCashinResp.errno == 500) {
                    WalletToastNew.showFailedMsg(WalletBoletoCashinPresenter.this.f34478a, WalletBoletoCashinPresenter.this.f34478a.getResources().getString(R.string.wallet_boleto_cashin_error_server_error));
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoCashinPresenter.this.f34480c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletBoletoCashinPresenter.this.f34478a, WalletBoletoCashinPresenter.this.f34478a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }
}
