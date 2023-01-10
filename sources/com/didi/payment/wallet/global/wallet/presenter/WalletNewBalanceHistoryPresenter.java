package com.didi.payment.wallet.global.wallet.presenter;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOptionResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceHistoryContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;

public class WalletNewBalanceHistoryPresenter implements WalletNewBalanceHistoryContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletNewBalanceHistoryContract.View f34578a;

    /* renamed from: b */
    private WalletBalanceModel f34579b;

    /* renamed from: c */
    private FragmentActivity f34580c;

    /* renamed from: d */
    private SmartRefreshLayout f34581d;

    /* renamed from: e */
    private int f34582e;

    /* renamed from: f */
    private long f34583f = -1;
    public WalletBalanceOption walletBalanceOptionsSelected;

    public void onDestroy() {
    }

    public WalletNewBalanceHistoryPresenter(FragmentActivity fragmentActivity, WalletNewBalanceHistoryContract.View view, SmartRefreshLayout smartRefreshLayout) {
        this.f34580c = fragmentActivity;
        this.f34578a = view;
        this.f34581d = smartRefreshLayout;
        this.f34579b = new WalletBalanceModel(fragmentActivity);
        requestOptions();
    }

    public void init() {
        requestData();
    }

    public void retryRequestData() {
        requestData();
    }

    public void requestNextData(long j) {
        this.f34582e = 0;
        this.f34583f = j;
        requestData();
    }

    public void onSelectedBalanceOption(WalletBalanceOption walletBalanceOption) {
        this.f34582e = 0;
        this.walletBalanceOptionsSelected = walletBalanceOption;
        requestData();
    }

    public void onSelectedBalanceTime(long j) {
        this.f34582e = 0;
        this.f34583f = j;
        requestData();
    }

    public void requestData() {
        if (this.f34582e == 0) {
            this.f34578a.showLoadingDialog();
        }
        C120121 r6 = new RpcService.Callback<WalletBalanceHistoryResp>() {
            public void onSuccess(WalletBalanceHistoryResp walletBalanceHistoryResp) {
                WalletNewBalanceHistoryPresenter.this.m26398a(walletBalanceHistoryResp);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalanceHistoryPresenter.this.m26398a((WalletBalanceHistoryResp) null);
            }
        };
        WalletBalanceOption walletBalanceOption = this.walletBalanceOptionsSelected;
        int optionType = walletBalanceOption != null ? walletBalanceOption.getOptionType() : 0;
        if (this.f34582e < 0) {
            this.f34582e = 0;
        }
        this.f34579b.getBalanceStatements(this.f34582e, this.f34583f, optionType, r6);
    }

    public void requestOptions() {
        this.f34579b.getBalanceOptions(new RpcService.Callback<WalletBalanceOptionResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(WalletBalanceOptionResp walletBalanceOptionResp) {
                List<WalletBalanceOption> options;
                if (walletBalanceOptionResp != null && walletBalanceOptionResp.getData() != null && (options = walletBalanceOptionResp.getData().getOptions()) != null && !options.isEmpty()) {
                    WalletNewBalanceHistoryPresenter.this.f34578a.onBalanceOptionSuccessful(options);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26398a(WalletBalanceHistoryResp walletBalanceHistoryResp) {
        if (this.f34582e == 0) {
            this.f34578a.dismissLoadingDialog();
        }
        this.f34581d.finishRefresh();
        this.f34581d.finishLoadMore();
        if (walletBalanceHistoryResp == null || walletBalanceHistoryResp.errno != 0) {
            if (walletBalanceHistoryResp == null || TextUtils.isEmpty(walletBalanceHistoryResp.errmsg)) {
                FragmentActivity fragmentActivity = this.f34580c;
                WalletToastNew.showFailedMsg(fragmentActivity, fragmentActivity.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
            } else {
                WalletToastNew.showFailedMsg(this.f34580c, walletBalanceHistoryResp.errmsg);
            }
            this.f34578a.onNetworkError();
            return;
        }
        m26400b(walletBalanceHistoryResp);
    }

    /* renamed from: b */
    private void m26400b(WalletBalanceHistoryResp walletBalanceHistoryResp) {
        if (walletBalanceHistoryResp != null && walletBalanceHistoryResp.data != null) {
            WalletBalanceHistoryResp.DataBean dataBean = walletBalanceHistoryResp.data;
            boolean z = dataBean.nextIndex != -1;
            List<WalletBalanceHistoryResp.StatementBean> list = dataBean.statement;
            if (this.f34582e == 0) {
                this.f34578a.onBalanceDataSuccessful(list, z, dataBean.topupBtn);
            } else {
                this.f34578a.onBalanceMoreDataSuccessful(list, z);
            }
            this.f34582e = dataBean.nextIndex;
        }
    }
}
