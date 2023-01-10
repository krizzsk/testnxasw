package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNightlyLimitContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletNightlyLimitPresenter implements WalletNightlyLimitContract.IPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletNightlyLimitContract.IView f34607a;

    /* renamed from: b */
    private FragmentActivity f34608b;

    /* renamed from: c */
    private NightlyLimitSettingModel f34609c;

    public WalletNightlyLimitPresenter(WalletNightlyLimitContract.IView iView, FragmentActivity fragmentActivity) {
        this.f34607a = iView;
        this.f34608b = fragmentActivity;
        this.f34609c = new NightlyLimitSettingModel(fragmentActivity);
    }

    public void requestData() {
        this.f34607a.showLoadingDialog();
        this.f34609c.getNightlyLimitSetting(new RpcService.Callback<QueryNightlyLimitSettingResp>() {
            public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                if (WalletNightlyLimitPresenter.this.f34607a != null) {
                    WalletNightlyLimitPresenter.this.f34607a.dismissLoadingDialog();
                    QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                    if (queryNightlyLimitSettingResp.errno != 0 || queryNightlyLimitSettingVo == null) {
                        WalletNightlyLimitPresenter.this.f34607a.onNetworkError();
                    } else {
                        WalletNightlyLimitPresenter.this.f34607a.showSettingLimit(queryNightlyLimitSettingVo);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                if (WalletNightlyLimitPresenter.this.f34607a != null) {
                    WalletNightlyLimitPresenter.this.f34607a.dismissLoadingDialog();
                    WalletNightlyLimitPresenter.this.f34607a.onNetworkError();
                }
            }
        });
    }

    public void submit(long j, long j2) {
        WalletNightlyLimitContract.IView iView = this.f34607a;
        if (iView != null) {
            iView.showLoadingDialog();
            this.f34609c.setNightlyLimit(j, j2, new RpcService.Callback<QueryNightlyLimitSettingResp>() {
                public void onSuccess(QueryNightlyLimitSettingResp queryNightlyLimitSettingResp) {
                    if (WalletNightlyLimitPresenter.this.f34607a != null) {
                        WalletNightlyLimitPresenter.this.f34607a.dismissLoadingDialog();
                        QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = queryNightlyLimitSettingResp.data;
                        if (queryNightlyLimitSettingResp.errno == 0 && queryNightlyLimitSettingVo != null) {
                            WalletNightlyLimitPresenter.this.f34607a.onChangeSuccess(queryNightlyLimitSettingVo);
                        } else if (queryNightlyLimitSettingResp.errno == 40101) {
                            WalletNightlyLimitPresenter.this.f34607a.onChangeFailed(queryNightlyLimitSettingResp.errmsg);
                        } else {
                            WalletNightlyLimitPresenter.this.f34607a.onChangeFailed(WalletNightlyLimitPresenter.this.f34607a.getContext().getString(R.string.pay_base_network_error));
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    if (WalletNightlyLimitPresenter.this.f34607a != null) {
                        WalletNightlyLimitPresenter.this.f34607a.dismissLoadingDialog();
                        WalletNightlyLimitPresenter.this.f34607a.onChangeFailed(WalletNightlyLimitPresenter.this.f34607a.getContext().getString(R.string.pay_base_network_error));
                    }
                }
            });
        }
    }

    public void destroy() {
        WalletNightlyLimitContract.IView iView = this.f34607a;
        if (iView != null) {
            iView.dismissLoadingDialog();
        }
        this.f34607a = null;
        this.f34608b = null;
    }
}
