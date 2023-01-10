package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletChangeLimitResultContract;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class WalletChangeLimitResultPresenter implements WalletChangeLimitResultContract.IPresenter {

    /* renamed from: a */
    private FragmentActivity f34552a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletChangeLimitResultContract.IView f34553b;

    /* renamed from: c */
    private final NightlyLimitSettingModel f34554c;

    public WalletChangeLimitResultPresenter(FragmentActivity fragmentActivity, WalletChangeLimitResultContract.IView iView) {
        this.f34552a = fragmentActivity;
        this.f34553b = iView;
        this.f34554c = new NightlyLimitSettingModel(fragmentActivity);
    }

    public void requestData() {
        this.f34553b.showLoadingDialog();
        this.f34554c.getNightlyLimitSetting(new RpcService.Callback<QueryNightlyLimitSettingResp>() {
            public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                if (WalletChangeLimitResultPresenter.this.f34553b != null) {
                    QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                    if (queryNightlyLimitSettingResp.errno != 0 || queryNightlyLimitSettingVo == null) {
                        WalletChangeLimitResultPresenter.this.f34553b.showNetworkError();
                    } else {
                        WalletChangeLimitResultPresenter.this.f34553b.showResult(queryNightlyLimitSettingVo);
                    }
                    WalletChangeLimitResultPresenter.this.f34553b.dismissLoadingDialog();
                }
            }

            public void onFailure(IOException iOException) {
                if (WalletChangeLimitResultPresenter.this.f34553b != null) {
                    WalletChangeLimitResultPresenter.this.f34553b.dismissLoadingDialog();
                    WalletChangeLimitResultPresenter.this.f34553b.showNetworkError();
                }
            }
        });
    }

    public void destroy() {
        WalletChangeLimitResultContract.IView iView = this.f34553b;
        if (iView != null) {
            iView.dismissLoadingDialog();
        }
        this.f34552a = null;
        this.f34553b = null;
    }
}
