package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoZipCodeContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoZipCodePresenter implements WalletBoletoZipCodeContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f34407a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoZipCodeContract.View f34408b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34409c;

    /* renamed from: d */
    private AddressPatchModel f34410d;

    public WalletBoletoZipCodePresenter(Activity activity, WalletBoletoZipCodeContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34407a = activity;
        this.f34408b = view;
        this.f34409c = walletLoadingContract;
        this.f34410d = new AddressPatchModel(activity);
    }

    public void requestData(String str) {
        this.f34409c.showLoadingDialog();
        this.f34410d.requestBoletoAddress(str, new RpcService.Callback<AddressFromZipCodeResp>() {
            public void onSuccess(AddressFromZipCodeResp addressFromZipCodeResp) {
                WalletBoletoZipCodePresenter.this.f34409c.dismissLoadingDialog();
                if (addressFromZipCodeResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoZipCodePresenter.this.f34407a, WalletBoletoZipCodePresenter.this.f34407a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoZipCodePresenter.this.f34408b.onNetworkError();
                } else if (addressFromZipCodeResp.errno == 0) {
                    WalletBoletoZipCodePresenter.this.f34408b.sendAddress(addressFromZipCodeResp.data);
                } else {
                    WalletToastNew.showFailedMsg(WalletBoletoZipCodePresenter.this.f34407a, addressFromZipCodeResp.errmsg);
                    WalletBoletoZipCodePresenter.this.f34408b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoZipCodePresenter.this.f34409c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletBoletoZipCodePresenter.this.f34407a, WalletBoletoZipCodePresenter.this.f34407a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoZipCodePresenter.this.f34408b.onNetworkError();
            }
        });
    }
}
