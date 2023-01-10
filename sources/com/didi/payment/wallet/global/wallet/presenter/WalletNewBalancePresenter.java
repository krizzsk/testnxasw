package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInfoResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceContract;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WalletNewBalancePresenter implements WalletNewBalanceContract.Presenter {

    /* renamed from: a */
    boolean f34600a;

    /* renamed from: b */
    int f34601b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletNewBalanceContract.View f34602c;

    /* renamed from: d */
    private FragmentActivity f34603d;

    /* renamed from: e */
    private AccountFreezeData f34604e = null;

    /* renamed from: f */
    private int f34605f = 0;

    /* renamed from: g */
    private WalletBalanceModel f34606g;

    public void onDestroy() {
    }

    public void requestData() {
    }

    public WalletNewBalancePresenter(FragmentActivity fragmentActivity, WalletNewBalanceContract.View view) {
        this.f34603d = fragmentActivity;
        this.f34602c = view;
        this.f34606g = new WalletBalanceModel(fragmentActivity);
    }

    public void init() {
        EventBus.getDefault().register(this);
        Bundle extras = this.f34603d.getIntent().getExtras();
        if (extras != null) {
            this.f34604e = (AccountFreezeData) extras.getSerializable(WalletExtraConstant.Key.KEY_BLOCK_DATA);
            this.f34605f = 0;
            this.f34600a = extras.getBoolean(WalletExtraConstant.Key.HAS_INTEREST);
            this.f34601b = extras.getInt(WalletExtraConstant.Key.BALANCE_TAB, 6);
        }
        this.f34602c.showLoadingDialog();
        this.f34606g.getBalanceInfo(new RpcService.Callback<WalletBalanceInfoResp>() {
            public void onSuccess(WalletBalanceInfoResp walletBalanceInfoResp) {
                if (walletBalanceInfoResp == null) {
                    onFailure((IOException) null);
                    return;
                }
                WalletNewBalancePresenter.this.f34602c.dismissLoadingDialog();
                WalletNewBalancePresenter.this.f34602c.updateContent(walletBalanceInfoResp.data, WalletNewBalancePresenter.this.f34601b);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalancePresenter.this.f34602c.dismissLoadingDialog();
                WalletNewBalancePresenter.this.f34602c.updateContent((WalletBalanceInfoResp.BalanceInfoData) null, WalletNewBalancePresenter.this.f34601b);
            }
        });
    }

    public void onServicesClicked() {
        if (WalletCommonParamsUtil.isPassengerBrazilClient() || WalletCommonParamsUtil.isSodaBrazilClient()) {
            WebBrowserUtil.startInternalWebActivity(this.f34603d, "https://help.didiglobal.com/processing-passenger-new.html?source=99pay_balance_earnings&kfPageSource=99pay&pageSource=balance_earnings_faq", "");
        } else {
            WebBrowserUtil.startInternalWebActivity(this.f34603d, "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay", "");
        }
    }

    public void onTabHistoryClicked() {
        this.f34602c.showBalanceHistory();
    }

    public void onTabInterestClicked() {
        this.f34602c.showBalanceInterest();
    }

    public void onTabCashbackClicked() {
        this.f34602c.showBalanceCallback();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSignUpSucceed(WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent) {
        int i;
        if (walletNewBalanceLoadingEvent == null || !walletNewBalanceLoadingEvent.showLoading) {
            this.f34602c.dismissLoadingDialog();
            AccountFreezeData accountFreezeData = this.f34604e;
            if (accountFreezeData != null && (i = this.f34605f) == 0) {
                this.f34605f = i + 1;
                this.f34602c.showVerifyDialog(accountFreezeData);
                return;
            }
            return;
        }
        this.f34602c.showLoadingDialog();
    }

    public void onVerifyNowClicked(String str) {
        DRouter.build(str).start((Context) null);
        FinOmegaSDK.trackEvent("ibt_didipay_interest_verify_ck");
    }

    public void onDetailsClicked(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f34603d, str, "");
        FinOmegaSDK.trackEvent("ibt_didipay_interest_verify_details_ck");
    }
}
