package com.didi.payment.wallet.global.wallet.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.event.home.MapEventKey;
import com.didi.payment.base.event.home.MapEventManager;
import com.didi.payment.base.event.home.WalletEvent;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.constants.CommonConstants;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.event.WalletSignUpSuccessEvent;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WalletHomePresenter implements WalletEvent, WalletHomeContract.Listener, WalletHomeContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f34555a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletHomeContract.View f34556b;

    /* renamed from: c */
    private WalletPageModel f34557c;

    /* renamed from: d */
    private WalletHomeResp.DataBean f34558d;

    /* renamed from: e */
    private boolean f34559e;

    /* renamed from: f */
    private boolean f34560f;

    public void onNewPayMethodItemRightLabelClicked(int i) {
    }

    public void onResume() {
    }

    public void onWholeCardClicked(WalletHomeResp.AccountSection accountSection) {
    }

    public WalletHomePresenter(Activity activity, WalletHomeContract.View view) {
        this.f34555a = activity;
        this.f34556b = view;
        this.f34557c = new WalletPageModel(activity);
    }

    public void init() {
        this.f34556b.setListener(this);
        this.f34556b.initLoadingDialog(this.f34555a);
        EventBus.getDefault().register(this);
        MapEventManager.INSTANCE.register(MapEventKey.WALLET_HOME_UPDATE, this);
    }

    public void autoDetectQrCode() {
        String clipboardText = NClipBoardUtil.getClipboardText(this.f34555a);
        if (TextUtil.isEmpty(clipboardText)) {
            return;
        }
        if (clipboardText.contains("BR.GOV.BCB.PIX") || clipboardText.contains("BR.GOV.BCB.PIX".toLowerCase())) {
            autoVerifyQRCode(clipboardText);
        }
    }

    public void autoVerifyQRCode(String str) {
        this.f34557c.queryPixQrCode(str, new RpcService.Callback<PixQrCodeQueryResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(PixQrCodeQueryResp pixQrCodeQueryResp) {
                if (pixQrCodeQueryResp != null && pixQrCodeQueryResp.errno == 0) {
                    WalletHomePresenter.this.f34556b.onQRCodeDetected(pixQrCodeQueryResp.data);
                }
            }
        });
    }

    public void requestData() {
        this.f34560f = false;
        this.f34556b.showLoadingDialog();
        this.f34557c.requestWalletHomeData(new RpcService.Callback<WalletHomeResp>() {
            public void onSuccess(WalletHomeResp walletHomeResp) {
                WalletHomePresenter.this.m26355a(walletHomeResp);
                if (WalletSPUtils.getCanRequestPwd(WalletHomePresenter.this.f34555a, WalletCommonParamsUtil.getToken(WalletHomePresenter.this.f34555a)).booleanValue() && WalletSPUtils.getPayPwdGuideShowCount(WalletCommonParamsUtil.getToken(WalletHomePresenter.this.f34555a), WalletHomePresenter.this.f34555a) < 3) {
                    WalletHomePresenter.this.requestPwdGuideData();
                }
            }

            public void onFailure(IOException iOException) {
                WalletHomePresenter.this.m26350a();
            }
        });
    }

    public void requestDataIfNeeded() {
        if (this.f34558d == null || this.f34560f) {
            requestData();
        }
    }

    public void checkQRCode(String str) {
        autoDetectQrCode();
    }

    public void onDestroy() {
        this.f34559e = true;
        EventBus.getDefault().unregister(this);
        this.f34556b.dismissLoadingDialog();
        this.f34556b.dismissFlowerAnimation();
        MapEventManager.INSTANCE.unRegister(MapEventKey.WALLET_HOME_UPDATE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26355a(WalletHomeResp walletHomeResp) {
        if (!this.f34559e) {
            this.f34556b.dismissLoadingDialog();
            PayTracker.trackEvent("ibt_gp_didipay_top_banner_mp_sw");
            if (walletHomeResp == null) {
                PayBaseToast.showInfo((Context) this.f34555a, (int) R.string.one_payment_global_net_toast_serverbusy);
            } else if (walletHomeResp.errno == 0 && walletHomeResp.data != null) {
                this.f34558d = walletHomeResp.data;
                this.f34556b.updateContent(walletHomeResp.data);
                m26358b(walletHomeResp.data);
                m26354a(walletHomeResp.data);
            } else if (401 == walletHomeResp.errno || 405 == walletHomeResp.errno) {
                this.f34556b.updateEmptyView(walletHomeResp.errmsg);
            } else {
                PayBaseToast.showInfo((Context) this.f34555a, walletHomeResp.errmsg);
            }
        }
    }

    /* renamed from: a */
    private void m26354a(WalletHomeResp.DataBean dataBean) {
        if (dataBean != null) {
            if (dataBean.accountSection != null) {
                PayTracker.putGlobal("wallet_account_status", Integer.valueOf(dataBean.accountSection.status));
                PayTracker.putGlobal("facial_recognition_status", dataBean.accountSection.facialRecognitionStatus);
            }
            if (dataBean.accountSection != null && !TextUtils.isEmpty(dataBean.accountSection.detailsMsg) && dataBean.accountSection.status == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(dataBean.accountSection.status));
                hashMap.put("interest_status", Integer.valueOf(dataBean.accountSection.interestStatus));
                PayTracker.trackEvent("ibt_didipay_top_navigation_interest_status_sw", hashMap);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26350a() {
        if (!this.f34559e) {
            this.f34556b.dismissLoadingDialog();
            PayBaseToast.showInfo((Context) this.f34555a, (int) R.string.one_payment_global_net_toast_connectionerror);
            this.f34556b.updateContent(null);
        }
    }

    /* renamed from: b */
    private void m26358b(WalletHomeResp.DataBean dataBean) {
        if (dataBean != null && dataBean.accountSection != null && dataBean.accountSection.status == 1 && dataBean.accountSection.channelId == 190 && WalletSPUtils.needShowTopUpGuide(this.f34555a)) {
            WalletRouter.gotoTopUpGuidePage(this.f34555a, dataBean.accountSection.accountStatus);
            WalletSPUtils.topUpGuideHasShowed(this.f34555a);
        }
    }

    public void onRefreshPage() {
        if (!PayBaseParamUtil.isLogin(this.f34555a)) {
            PayBaseParamUtil.doLogin(this.f34555a);
        } else {
            requestData();
        }
    }

    public void onAccountMainEnterClicked(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null) {
            int i = accountSection.status;
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                WalletRouter.gotoTopUpChannelPageWithLaunchFrom(this.f34555a, 3);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(accountSection.status));
            PayTracker.trackEvent("gp_99pay_payment_btn_ck", hashMap);
        }
    }

    public void onConsumeItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
        WalletHomeResp.DataBean dataBean = this.f34558d;
        if (!(dataBean == null || dataBean.freezonData == null)) {
            if (AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(this.f34555a, (AccountFreezeData) AccountFreezeData.Builder.from(this.f34558d.freezonData).btnPos(ResourcesHelper.getString(this.f34555a, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(this.f34555a, R.string.GRider_reminder_Confirmation_norO)).putExtra("entrance", Integer.valueOf(consumeItem.productLine)).build())) {
                return;
            }
        }
        if (consumeItem != null && !TextUtils.isEmpty(consumeItem.linkUrl)) {
            if (consumeItem.productLine == 99999) {
                PayTracker.trackEvent("ibt_didipay_p2p_transfer_ck");
            } else if (consumeItem.productLine == 605) {
                PayTracker.trackEvent("gp_99pay_payment_phonebill_ck");
            } else if (consumeItem.productLine == 99996) {
                PayTracker.trackEvent("ibt_didipay_mypix_ck");
            } else if (BitcoinUtil.isBitcoin(consumeItem.productLine).booleanValue()) {
                PayTracker.trackEvent("ibt_microinvest_bottomtab_icon_ck");
                if (!BitcoinUtil.checkBitcoinWelPage(this.f34555a).booleanValue()) {
                    this.f34560f = true;
                } else {
                    return;
                }
            } else {
                FinOmegaSDK.putGlobalKV("entry_timestamp", Long.valueOf(System.currentTimeMillis()));
                PayTracker.trackEvent("gp_99pay_payment_lifebill_ck");
            }
            String str = "";
            String str2 = consumeItem.promotionRule == null ? str : consumeItem.promotionRule.text;
            if (consumeItem.promotionRule != null) {
                str = consumeItem.promotionRule.url;
            }
            if (consumeItem.productLine == 606 && !WalletApolloUtil.isBoletoScanOptEnable()) {
                consumeItem.linkUrl = "99pay://one/consume/scan";
            }
            Request build = DRouter.build(consumeItem.linkUrl);
            build.putExtra(WalletExtraConstant.Key.ACTIVITY_TEXT, str2);
            build.putExtra("activity_url", str);
            build.putExtra("product_line", consumeItem.productLine);
            build.putExtra(WalletExtraConstant.Key.PAGE_REFER, "wallet_home");
            BitcoinUtil.putBitcoinExtra(build);
            if (consumeItem.linkUrl.contains(CommonConstants.Router.PIX_REGISTER)) {
                build.start(this.f34555a, new RouterCallback.ActivityCallback() {
                    public void onResult(Result result) {
                    }

                    public void onActivityResult(int i, Intent intent) {
                        WalletHomePresenter.this.requestData();
                    }
                });
            } else {
                build.start((Context) null);
            }
        }
    }

    public void onOperationItemClicked(WalletOperationItem walletOperationItem) {
        PayTracker.getTracker().trackEvent("ibt_didipay_top_navigation_referral_ck");
        if (walletOperationItem != null && !TextUtils.isEmpty(walletOperationItem.linkUrl)) {
            WebBrowserUtil.startInternalWebActivity(this.f34555a, walletOperationItem.linkUrl, "");
        }
    }

    public void onOperationItemShown(WalletOperationItem walletOperationItem) {
        PayTracker.getTracker().trackEvent("ibt_didipay_top_navigation_referral_sw");
    }

    public void onStatusMsgClicked(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null) {
            WalletRouter.gotoAccountBalancePage(this.f34555a, accountSection.balanceMsg == null ? accountSection.statusMsg : accountSection.balanceMsg, accountSection.channelId, accountSection.interestDetailMsg, accountSection.balanceAmount, accountSection.status, accountSection.accountStatus, accountSection.hasInterest, 6);
        }
    }

    public void onDetailsClicked(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null) {
            if (accountSection.status != 1) {
                HashMap hashMap = new HashMap();
                hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(accountSection.status));
                hashMap.put("interest_status", Integer.valueOf(accountSection.interestStatus));
                PayTracker.trackEvent("ibt_didipay_top_navigation_interest_signup_ck", hashMap);
            }
            if (accountSection.status == 0) {
                DRouter.build("99pay://one/register").start((Context) null);
            } else if (accountSection.status == 3) {
                WalletRouter.gotoFailedReasonPage(this.f34555a, accountSection.accountStatus);
            } else if (accountSection.status == 2) {
                WalletRouter.gotoSignUpWaitingPage(this.f34555a, accountSection.accountStatus);
            } else if (accountSection.status != 1) {
            } else {
                if (accountSection.balanceAmount == 0.0d) {
                    DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_TOPUP).start((Context) null);
                } else {
                    WalletRouter.gotoAccountBalancePage(this.f34555a, accountSection.balanceMsg == null ? accountSection.statusMsg : accountSection.balanceMsg, accountSection.channelId, accountSection.interestDetailMsg, accountSection.balanceAmount, accountSection.status, accountSection.accountStatus, accountSection.hasInterest, 7);
                }
            }
        }
    }

    public void onPromotionHeaderClicked(WalletHomeResp.AccountSection accountSection) {
        if (accountSection != null) {
            if (!TextUtils.isEmpty(accountSection.promotionLink)) {
                if (accountSection.promotionLink.contains("pay_intl_passenger/wallet_event/wallet_event.html")) {
                    WalletRouter.gotoWebActivity(this.f34555a, "", accountSection.promotionLink, "#00CD80");
                } else {
                    DRouter.build(accountSection.promotionLink).start((Context) null);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(accountSection.status));
            PayTracker.trackEvent("ibt_gp_didipay_top_banner_promo_ck", hashMap);
        }
    }

    public void onTermAndConditionsClicked() {
        WebBrowserUtil.startInternalWebActivity(this.f34555a, WalletConstant.URL.H5_99PAY_TERM_CONDITIONS, "");
    }

    public void onAccountFrozenDetailClick(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f34555a, str, "");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSignUpSucceed(WalletSignUpSuccessEvent walletSignUpSuccessEvent) {
        this.f34556b.showFlowerAnimation();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWalletDataRefreshed(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f34560f = true;
    }

    public void onNewPayMethodItemClicked(int i) {
        WalletHomeResp.PaymentMethodItem paymentMethodItem;
        WalletHomeResp.DataBean dataBean = this.f34558d;
        if (dataBean != null && dataBean.paymentSection != null && !CollectionUtil.isEmpty((Collection) this.f34558d.paymentSection.payMethodItems) && i <= this.f34558d.paymentSection.payMethodItems.size() - 1 && (paymentMethodItem = this.f34558d.paymentSection.payMethodItems.get(i)) != null) {
            int i2 = paymentMethodItem.channelId;
            if (i2 == 150) {
                if (TextUtils.isEmpty(paymentMethodItem.cardIndex)) {
                    m26353a(this.f34555a, 1);
                } else if (paymentMethodItem.cardStatus == 1) {
                    m26351a(5, paymentMethodItem.name, paymentMethodItem.cardIndex);
                } else {
                    m26352a(2, paymentMethodItem.name, paymentMethodItem.expireDate, paymentMethodItem.cardIndex, paymentMethodItem.expired);
                }
                if (TextUtils.isEmpty(paymentMethodItem.cardIndex)) {
                    GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(this.f34555a, 3, getCardCount());
                } else {
                    GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(this.f34555a, 1, getCardCount());
                }
            } else if (i2 != 190) {
                if (i2 == 999) {
                    GlobalOmegaUtils.trackPayMethodSettingPageDiscountsCK(this.f34555a);
                }
                if (!TextUtils.isEmpty(paymentMethodItem.linkUrl)) {
                    WebBrowserUtil.startInternalWebActivity(this.f34555a, paymentMethodItem.linkUrl, "");
                }
            }
        }
    }

    /* renamed from: a */
    private void m26353a(Activity activity, int i) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        addCardParam.resourceId = "2";
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                if (WalletHomePresenter.this.f34556b != null) {
                    WalletHomePresenter.this.f34556b.showLoadingDialog();
                }
            }

            public void dismissLoading() {
                if (WalletHomePresenter.this.f34556b != null) {
                    WalletHomePresenter.this.f34556b.dismissLoadingDialog();
                }
            }
        });
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity(activity, i, addCardParam);
    }

    /* renamed from: a */
    private void m26352a(int i, String str, String str2, String str3, int i2) {
        DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam = new DidiGlobalDeleteCardData.DeleteCardParam();
        deleteCardParam.expiryDate = str2;
        deleteCardParam.cardNo = str;
        deleteCardParam.cardIndex = str3;
        deleteCardParam.expired = i2;
        deleteCardParam.resourceId = "2";
        Activity activity = this.f34555a;
        if (activity != null && (activity instanceof FragmentActivity)) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startCreditCardDetailActivity((FragmentActivity) this.f34555a, i, deleteCardParam);
        }
    }

    /* renamed from: a */
    private void m26351a(int i, String str, String str2) {
        DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
        verifyCardParam.cardNo = str;
        verifyCardParam.cardIndex = str2;
        Activity activity = this.f34555a;
        if (activity != null && (activity instanceof FragmentActivity)) {
            DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((FragmentActivity) this.f34555a, i, verifyCardParam);
        }
    }

    public int getCardCount() {
        WalletHomeResp.DataBean dataBean = this.f34558d;
        int i = 0;
        if (!(dataBean == null || dataBean.paymentSection == null || this.f34558d.paymentSection.payMethodItems == null)) {
            for (WalletHomeResp.PaymentMethodItem paymentMethodItem : this.f34558d.paymentSection.payMethodItems) {
                if (paymentMethodItem.channelId == 150) {
                    i++;
                }
            }
        }
        return i;
    }

    public void onPixEntryClick(Bundle bundle) {
        WalletHomeResp.PixEntry pixEntry;
        if (bundle.containsKey("pix_entry") && (pixEntry = (WalletHomeResp.PixEntry) bundle.getSerializable("pix_entry")) != null && !TextUtil.isEmpty(pixEntry.linkUrl)) {
            Request build = DRouter.build(pixEntry.linkUrl);
            if (pixEntry.linkUrl.contains(CommonConstants.Router.PIX_REGISTER_PATH)) {
                build.start(this.f34555a, new RouterCallback.ActivityCallback() {
                    public void onResult(Result result) {
                    }

                    public void onActivityResult(int i, Intent intent) {
                        WalletHomePresenter.this.requestData();
                    }
                });
            } else {
                build.start(this.f34555a);
            }
        }
    }

    public void onAccountBlocked2UnBlock(String str) {
        DRouter.build(str).start((Context) null);
        FinOmegaSDK.trackEvent("ibt_didipay_unblock_ck");
    }

    public void onAccountBlocked2BalanceWithData(WalletHomeResp.AccountSection accountSection) {
        if (!(accountSection == null || accountSection.accountFreezeData == null)) {
            WalletRouter.gotoAccountBalancePageWithBlockData(this.f34555a, accountSection.balanceMsg == null ? accountSection.statusMsg : accountSection.balanceMsg, accountSection.channelId, accountSection.detailsMsg, accountSection.balanceAmount, accountSection.status, accountSection.accountStatus, accountSection.hasInterest, 7, accountSection.accountFreezeData);
        }
        FinOmegaSDK.trackEvent("ibt_didipay_interest_ck", "account_freeze_status", "1");
    }

    public void requestPwdGuideData() {
        this.f34557c.getPopUpWindowInfo(true, new RpcService.Callback<WalletPopUpWindowResp>() {
            public void onSuccess(WalletPopUpWindowResp walletPopUpWindowResp) {
                WalletHomePresenter.this.f34556b.showPwdGuideDialog(walletPopUpWindowResp);
                WalletSPUtils.savePayPwdGuideShowCount(WalletCommonParamsUtil.getToken(WalletHomePresenter.this.f34555a), WalletHomePresenter.this.f34555a);
                WalletSPUtils.saveCanRequestPwd(WalletHomePresenter.this.f34555a, WalletCommonParamsUtil.getToken(WalletHomePresenter.this.f34555a), false);
            }

            public void onFailure(IOException iOException) {
                WalletSPUtils.saveCanRequestPwd(WalletHomePresenter.this.f34555a, WalletCommonParamsUtil.getToken(WalletHomePresenter.this.f34555a), true);
            }
        });
    }

    public void onWalletEvent(String str) {
        requestData();
    }
}
