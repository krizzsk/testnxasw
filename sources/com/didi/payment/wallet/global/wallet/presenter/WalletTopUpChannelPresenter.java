package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContract;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class WalletTopUpChannelPresenter implements WalletTopUpChannelContract.Presenter {
    public static final String CHANNEL_ID_BRAZIL_CASH = "1004";

    /* renamed from: a */
    private static final String f34633a = "1000";

    /* renamed from: b */
    private static final String f34634b = "175";

    /* renamed from: c */
    private static final String f34635c = "212";

    /* renamed from: d */
    private static final String f34636d = "1001";

    /* renamed from: e */
    private static final String f34637e = "1002";

    /* renamed from: f */
    private static final String f34638f = "1003";
    public boolean collectAddress;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FragmentActivity f34639g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WalletTopUpChannelContract.View f34640h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletLoadingContract f34641i;

    /* renamed from: j */
    private WalletPageModel f34642j;

    public WalletTopUpChannelPresenter(FragmentActivity fragmentActivity, WalletTopUpChannelContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34639g = fragmentActivity;
        this.f34640h = view;
        this.f34641i = walletLoadingContract;
        this.f34642j = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f34641i.showLoadingDialog();
        this.f34642j.requestWalletTopUpChannel(new RpcService.Callback<WalletTopUpChannelResp>() {
            public void onSuccess(WalletTopUpChannelResp walletTopUpChannelResp) {
                WalletTopUpChannelPresenter.this.f34641i.dismissLoadingDialog();
                if (walletTopUpChannelResp == null) {
                    WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f34639g, WalletTopUpChannelPresenter.this.f34639g.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletTopUpChannelPresenter.this.f34640h.onNetworkError();
                } else if (walletTopUpChannelResp.errno == 0 && walletTopUpChannelResp.data != null) {
                    WalletTopUpChannelPresenter.this.collectAddress = walletTopUpChannelResp.data.collectAddress;
                    WalletTopUpChannelPresenter.this.f34640h.refreshUI(walletTopUpChannelResp.data);
                } else if (walletTopUpChannelResp.errno == 1010) {
                    WalletTopUpChannelPresenter.this.f34640h.showHomelandCityErrorPage();
                } else {
                    WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f34639g, walletTopUpChannelResp.errmsg);
                    WalletTopUpChannelPresenter.this.f34640h.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenter.this.f34641i.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f34639g, WalletTopUpChannelPresenter.this.f34639g.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletTopUpChannelPresenter.this.f34640h.onNetworkError();
            }
        });
    }

    public void handleConditionClick(String str) {
        WalletRouter.gotoTopupConditionPage(this.f34639g, str);
    }

    public void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            PayTracker.putGlobal("wallet_channel_id", channelBean.channelId);
            GlobalOmegaUtils.trackTopUpBtnCK(channelBean.name);
            if (TextUtils.equals(channelBean.channelId, f34634b)) {
                GlobalOmegaUtils.trackTopUpOfflineClick(this.f34639g);
                WalletRouter.gotoMexicoOfflinePage(this.f34639g, channelBean);
            } else if (TextUtils.equals(channelBean.channelId, "1000")) {
                GlobalOmegaUtils.trackTopUpOnlineClick(this.f34639g);
                Bundle bundle = new Bundle();
                bundle.putInt("key_from", this.f34639g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f34639g, bundle, 100);
                trackOnlinePayClick();
            } else if (TextUtils.equals(channelBean.channelId, f34637e)) {
                GlobalOmegaUtils.trackTopupChannelBankTransferCK();
                WalletRouter.gotoBankTransferPage(this.f34639g, channelBean);
            } else if (TextUtils.equals(channelBean.channelId, f34636d)) {
                GlobalOmegaUtils.trackTopupChannelBoletoCK();
                if (this.collectAddress) {
                    WalletRouter.gotoBoletoPatchAddressPage(this.f34639g, channelBean);
                } else {
                    WalletRouter.gotoBoletoCashinPage(this.f34639g, channelBean);
                }
            } else if (TextUtils.equals(channelBean.channelId, f34638f)) {
                GlobalOmegaUtils.trackTopupCardPaymentCK();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_from", this.f34639g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f34639g, bundle2, 100);
                trackOnlinePayClick();
            } else if (TextUtils.equals(channelBean.channelId, CHANNEL_ID_BRAZIL_CASH)) {
                m26461a(channelBean);
            } else if (TextUtils.equals(channelBean.channelId, f34635c)) {
                WalletRouter.gotoPixTopUpPage(this.f34639g, channelBean);
                m26460a();
            }
        }
    }

    /* renamed from: a */
    private void m26461a(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean.statusInfo != null) {
            if (channelBean.statusInfo.status == 1) {
                showTopUpByDriverDisabledTips(channelBean);
            } else if (!TextUtils.isEmpty(channelBean.statusInfo.extMetaData)) {
                Bundle bundle = new Bundle();
                bundle.putInt("order_type", 1);
                bundle.putString(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA, channelBean.statusInfo.extMetaData);
                bundle.putInt("key_from", this.f34639g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f34639g, bundle, 1001);
                trackOnlinePayClick();
            }
            HashMap hashMap = new HashMap();
            if (channelBean.statusInfo.status == 1) {
                hashMap.put("availability", 0);
            } else {
                hashMap.put("availability", 1);
            }
            if (WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
                hashMap.put("trip_status", 1);
            } else {
                hashMap.put("trip_status", 0);
            }
            PayTracker.trackEvent("ibt_mouton_pax_phone_topup_homepage_by_drv_ck", hashMap);
        }
    }

    /* renamed from: a */
    private void m26460a() {
        PayTracker.trackEvent("ibt_didipay_topup_pix_ck");
    }

    public void trackOnlinePayClick() {
        HashMap hashMap = new HashMap();
        hashMap.put(TransGlobalOmegaKey.KEY_WALLET_PAGEID, Integer.valueOf(this.f34639g.getIntent().getIntExtra("key_from", -1)));
        PayTracker.trackEvent("ibt_mouton_pax_phone_topup_homepage_online_ck", hashMap);
    }

    public void showTopUpByDriverDisabledTips(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean.statusInfo != null) {
            WalletToastNew.showFailedMsg(this.f34639g, channelBean.statusInfo.title);
            HashMap hashMap = new HashMap();
            hashMap.put("unavailable_reason", Integer.valueOf(channelBean.statusInfo.unableReasonCode));
            if (WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
                hashMap.put("trip_status", 1);
            } else {
                hashMap.put("trip_status", 0);
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_unavailable_reason_sw", hashMap);
        }
    }

    public void handleVerifyClick(String str) {
        OmegaComParams.Companion.setKYC_RESOURCE_ID(DiFaceLogger.EVENT_ID_APPEAL_RESULT_REAPPEAL_CLICKED);
        DRouter.build(str).start((Context) null);
        FinOmegaSDK.trackEvent("ibt_didipay_balance_cap_verify_ck");
    }
}
