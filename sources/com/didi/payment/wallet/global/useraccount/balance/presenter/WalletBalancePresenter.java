package com.didi.payment.wallet.global.useraccount.balance.presenter;

import android.app.Activity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.useraccount.balance.contract.WalletBalanceContract;
import com.didi.payment.wallet.global.useraccount.balance.model.BalanceModel;
import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBalancePresenter implements WalletBalanceContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f34348a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBalanceContract.View f34349b;

    /* renamed from: c */
    private BalanceModel f34350c;

    /* renamed from: d */
    private int f34351d;

    /* renamed from: e */
    private int f34352e;

    /* renamed from: f */
    private String f34353f;

    public WalletBalancePresenter(Activity activity, WalletBalanceContract.View view, int i, String str) {
        this.f34348a = activity;
        this.f34349b = view;
        this.f34352e = i;
        this.f34353f = str;
        this.f34350c = new BalanceModel(activity);
    }

    public void retryRequestData() {
        this.f34351d = 0;
        requestData();
    }

    /* renamed from: a */
    private void m26222a(long j, int i, String str, RpcService.Callback<BalanceResp> callback) {
        this.f34350c.requestBalanceList(j, i, str, callback);
    }

    public void requestData() {
        this.f34349b.showLoadingFirstTime();
        m26222a((long) this.f34351d, this.f34352e, this.f34353f, new RpcService.Callback<BalanceResp>() {
            public void onSuccess(BalanceResp balanceResp) {
                WalletBalancePresenter.this.f34349b.dismissLoadingFirstTime();
                if (balanceResp == null) {
                    WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, WalletBalancePresenter.this.f34348a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBalancePresenter.this.f34349b.onNetworkError();
                } else if (balanceResp.errno == 0) {
                    WalletBalancePresenter.this.m26223a(balanceResp);
                } else {
                    WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, balanceResp.errmsg);
                    WalletBalancePresenter.this.f34349b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBalancePresenter.this.f34349b.dismissLoadingFirstTime();
                WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, WalletBalancePresenter.this.f34348a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBalancePresenter.this.f34349b.onNetworkError();
            }
        });
    }

    public void requestMoreData() {
        m26222a((long) this.f34351d, this.f34352e, this.f34353f, new RpcService.Callback<BalanceResp>() {
            public void onSuccess(BalanceResp balanceResp) {
                if (balanceResp == null) {
                    WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, WalletBalancePresenter.this.f34348a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBalancePresenter.this.f34349b.onNetworkError();
                } else if (balanceResp.errno != 0 || balanceResp.data == null) {
                    WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, balanceResp.errmsg);
                    WalletBalancePresenter.this.f34349b.onNetworkError();
                } else {
                    WalletBalancePresenter.this.m26226b(balanceResp);
                }
            }

            public void onFailure(IOException iOException) {
                WalletToastNew.showFailedMsg(WalletBalancePresenter.this.f34348a, WalletBalancePresenter.this.f34348a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBalancePresenter.this.f34349b.onNetworkError();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26223a(BalanceResp balanceResp) {
        if (balanceResp != null) {
            BalanceResp.DataBean dataBean = balanceResp.data;
            int i = dataBean.nextIndex;
            this.f34351d = i;
            this.f34349b.onBalanceDataSuccessful(dataBean.statement, i != -1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26226b(BalanceResp balanceResp) {
        if (balanceResp != null) {
            BalanceResp.DataBean dataBean = balanceResp.data;
            int i = dataBean.nextIndex;
            this.f34351d = i;
            this.f34349b.onBalanceMoreDataSuccessful(dataBean.statement, i != -1);
        }
    }
}
