package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressListContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListCityResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoAddressListPresenter implements WalletBoletoAddressListContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f34399a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoAddressListContract.View f34400b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34401c;

    /* renamed from: d */
    private AddressPatchModel f34402d;

    public WalletBoletoAddressListPresenter(Activity activity, WalletBoletoAddressListContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34399a = activity;
        this.f34400b = view;
        this.f34401c = walletLoadingContract;
        this.f34402d = new AddressPatchModel(activity);
    }

    public void requestStates(ListFragmentExtraState listFragmentExtraState) {
        this.f34401c.showLoadingDialog();
        this.f34402d.requestState(listFragmentExtraState, new RpcService.Callback<AddressListStateResp>() {
            public void onSuccess(AddressListStateResp addressListStateResp) {
                WalletBoletoAddressListPresenter.this.f34401c.dismissLoadingDialog();
                if (addressListStateResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressListPresenter.this.f34399a, WalletBoletoAddressListPresenter.this.f34399a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
                } else if (addressListStateResp.errno == 0) {
                    WalletBoletoAddressListPresenter.this.f34400b.onStatesSuccessful(addressListStateResp.data.stateList);
                } else {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressListPresenter.this.f34399a, addressListStateResp.errmsg);
                    WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressListPresenter.this.f34401c.dismissLoadingDialog();
                WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
            }
        });
    }

    public void requestCities(ListFragmentExtraCity listFragmentExtraCity) {
        this.f34401c.showLoadingDialog();
        this.f34402d.requestCities(listFragmentExtraCity, new RpcService.Callback<AddressListCityResp>() {
            public void onSuccess(AddressListCityResp addressListCityResp) {
                WalletBoletoAddressListPresenter.this.f34401c.dismissLoadingDialog();
                if (addressListCityResp == null) {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressListPresenter.this.f34399a, WalletBoletoAddressListPresenter.this.f34399a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
                } else if (addressListCityResp.errno == 0) {
                    WalletBoletoAddressListPresenter.this.f34400b.onCitiesSuccessful(addressListCityResp.data.cityList);
                } else {
                    WalletToastNew.showFailedMsg(WalletBoletoAddressListPresenter.this.f34399a, addressListCityResp.errmsg);
                    WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressListPresenter.this.f34401c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletBoletoAddressListPresenter.this.f34399a, WalletBoletoAddressListPresenter.this.f34399a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoAddressListPresenter.this.f34400b.onNetworkError();
            }
        });
    }
}
