package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchResp;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoAddressPresenter implements WalletBoletoAddressContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f34403a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoAddressContract.View f34404b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34405c;

    /* renamed from: d */
    private AddressPatchModel f34406d;

    public WalletBoletoAddressPresenter(Activity activity, WalletBoletoAddressContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34403a = activity;
        this.f34404b = view;
        this.f34405c = walletLoadingContract;
        this.f34406d = new AddressPatchModel(activity);
    }

    public void requestData(AddressFromZipCodeResp.DataBean dataBean) {
        this.f34405c.showLoadingDialog();
        this.f34406d.submitBoletoAddressPatch(dataBean, new RpcService.Callback<AddressPatchResp>() {
            public void onSuccess(AddressPatchResp addressPatchResp) {
                WalletBoletoAddressPresenter.this.f34405c.dismissLoadingDialog();
                if (addressPatchResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressPresenter.this.f34403a, WalletBoletoAddressPresenter.this.f34403a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressPresenter.this.f34404b.onNetworkError();
                } else if (addressPatchResp.errno == 0) {
                    WalletBoletoAddressPresenter.this.f34404b.onAddressPatchSuccessful();
                } else {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressPresenter.this.f34403a, addressPatchResp.errmsg);
                    WalletBoletoAddressPresenter.this.f34404b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressPresenter.this.f34405c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletBoletoAddressPresenter.this.f34403a, WalletBoletoAddressPresenter.this.f34403a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoAddressPresenter.this.f34404b.onNetworkError();
            }
        });
    }
}
