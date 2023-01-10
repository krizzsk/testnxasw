package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.constants.CommonConstants;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p130ui.helper.NQRDetectedDialogHelper;
import com.didi.payment.commonsdk.p130ui.listener.OnQRCodeDetectedListener;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.event.WalletSignUpSuccessEvent;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.presenter.WalletMainListPresenter;
import com.didi.payment.wallet.global.wallet.view.view.IWalletMainListEventListener;
import com.didi.payment.wallet.global.wallet.view.view.WalletMainListView;
import com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didiglobal.pay.paysecure.tmx.ITMXHost;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WalletMainListActivity extends FragmentActivity implements ITMXHost {
    public static final int REQ_CODE_ADD_CARD = 1;
    public static final int REQ_CODE_ADD_PAYPAL = 3;
    public static final int REQ_CODE_CARD_DETAIL = 2;
    public static final int REQ_CODE_PAYPAL_DETAIL = 4;
    public static final int REQ_CODE_UPDATE_CARD = 6;
    public static final int REQ_CODE_VERIFY_BALANCE = 5;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletMainListPresenter f34682a;

    /* renamed from: b */
    private WalletMainListView f34683b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f34684c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f34685d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f34686e = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m26507d();
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_main_list);
        m26505c();
        m26499a();
        this.f34684c = this;
        EventBus.getDefault().register(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_mainlist_v2");
        } else {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_mainlist");
        }
        WalletRouter.postClipboardChecker(this, 5);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f34686e = false;
        WalletRouter.removeClipboardChecker(this, 5);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f34686e = true;
        if (this.f34682a.getBackRefreshFlag() || this.f34685d) {
            this.f34685d = false;
            this.f34682a.requestWalletPageList();
        }
        m26504b();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f34682a.requestWalletPageList();
    }

    /* renamed from: a */
    private void m26499a() {
        WalletMainListView walletMainListView = (WalletMainListView) findViewById(R.id.v_wallet_main_list);
        this.f34683b = walletMainListView;
        walletMainListView.setListener((IWalletMainListEventListener) new IWalletMainListEventListener() {
            public void onAccountMainBtnClickEvent(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
            }

            public void onAccountMoreBtnClickEvent(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
            }

            public void onBalanceItemClickEvent(WalletPageInfo.BalanceItem balanceItem) {
                if (balanceItem != null && !TextUtils.isEmpty(balanceItem.f34551id)) {
                    String str = balanceItem.f34551id;
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -934825418) {
                        if (hashCode != 110546608) {
                            if (hashCode == 273184065 && str.equals("discount")) {
                                c = 0;
                            }
                        } else if (str.equals("topup")) {
                            c = 2;
                        }
                    } else if (str.equals(WalletPageInfo.BalanceItem.MOBILEPREPAID)) {
                        c = 1;
                    }
                    if (c == 0) {
                        GlobalOmegaUtils.trackPayMethodSettingPageDiscountsCK(WalletMainListActivity.this.f34684c);
                    } else if (c == 1) {
                        GlobalOmegaUtils.trackPayMethodSettingPageBalanceMbpCK(WalletMainListActivity.this.f34684c);
                    } else if (c == 2) {
                        GlobalOmegaUtils.trackPayMethodSettingPageBalanceTopupCK(WalletMainListActivity.this.f34684c);
                        FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_didicash_topup_ck");
                    }
                }
                WalletMainListActivity.this.f34682a.handleBalanceItemClickEvent(balanceItem);
            }

            public void onBalanceDetailClickEvent(String str) {
                GlobalOmegaUtils.trackPayMethodSettingPageBalanceCK(WalletMainListActivity.this.f34684c);
                FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_didicash_amount_ck");
                WalletMainListActivity.this.f34682a.jumpToBalanceDetailPage(str);
            }

            public void onBalanceHelpEvent(String str) {
                GlobalOmegaUtils.trackPayMethodSettingPageBalanceQaCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.f34682a.jumpToBalanceHelpPage(str);
            }

            public void onBalanceBannerClickEvent(String str) {
                GlobalOmegaUtils.trackPayMethodSettingPagebalancePhotoCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.f34682a.jumpToBalanceBannerPage(str);
            }

            public void onPayMethodItemClickEvent(WalletPageInfo.PayMethodItem payMethodItem) {
                if (payMethodItem != null) {
                    int i = payMethodItem.channelId;
                    if (i == 150) {
                        GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                    } else if (i == 182) {
                        GlobalOmegaUtils.trackPayMethodSettingPagePayPayCK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                    } else if (i != 183) {
                        switch (i) {
                            case 152:
                                GlobalOmegaUtils.trackPayMethodSettingPagePaypalCK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                                break;
                            case 153:
                                GlobalOmegaUtils.trackPayMethodSettingPageCashCK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                                break;
                            case 154:
                                GlobalOmegaUtils.trackPayMethodSettingPagePosCK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                                break;
                        }
                    } else {
                        GlobalOmegaUtils.trackPayMethodSettingPagePaypal2CK(WalletMainListActivity.this.f34684c, 1, WalletMainListActivity.this.f34682a.getCardCount());
                    }
                }
                WalletMainListActivity.this.f34682a.handlePayMethodItemClickEvent(payMethodItem);
            }

            public void onPayMethodAddEvent(WalletPageInfo.AddPayMethodEntryDialogInfo addPayMethodEntryDialogInfo) {
                GlobalOmegaUtils.trackPayMethodSettingPagebalanceAddPmtCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.f34682a.showAddPayMethodDialog(addPayMethodEntryDialogInfo);
            }

            public void onPayMethodHelpEvent(String str) {
                GlobalOmegaUtils.trackPayMethodSettingPageMethodQaCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.f34682a.jumpToPayMethodHelpPage(str);
            }

            public void onPromotionItemClickEvent(WalletPageInfo.PromotionItem promotionItem) {
                GlobalOmegaUtils.trackPayMethodSettingPageDiscountsCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.f34682a.handlePromotionItemClickEvent(promotionItem);
            }

            public void onRefreshPage() {
                WalletMainListActivity.this.f34682a.requestWalletPageList();
            }

            public void onCloseEvent() {
                GlobalOmegaUtils.trackPayMethodSettingPageCloseCK(WalletMainListActivity.this.f34684c);
                WalletMainListActivity.this.finish();
            }

            public void onServiceCenterClicked() {
                FinOmegaSDK.trackEvent("gp_99pay_payment_help_ck");
                WalletMainListActivity.this.f34682a.jumpToServiceCenter();
            }

            public void onConsumeItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
                if (consumeItem.linkUrl != null && !consumeItem.linkUrl.startsWith("http")) {
                    if (consumeItem.productLine == 99999) {
                        FinOmegaSDK.trackEvent("ibt_didipay_p2p_transfer_ck");
                    } else if (consumeItem.productLine == 605) {
                        FinOmegaSDK.trackEvent("gp_99pay_payment_phonebill_ck");
                    } else if (consumeItem.productLine == 99996) {
                        FinOmegaSDK.trackEvent("ibt_didipay_mypix_ck");
                    } else if (BitcoinUtil.isBitcoin(consumeItem.productLine).booleanValue()) {
                        PayTracker.trackEvent("ibt_microinvest_sidebar_icon_ck");
                        if (!BitcoinUtil.checkBitcoinWelPage(WalletMainListActivity.this.f34684c).booleanValue()) {
                            boolean unused = WalletMainListActivity.this.f34685d = true;
                        } else {
                            return;
                        }
                    } else {
                        FinOmegaSDK.putGlobalKV("entry_timestamp", Long.valueOf(System.currentTimeMillis()));
                        FinOmegaSDK.trackEvent("gp_99pay_payment_lifebill_ck");
                    }
                    if (consumeItem.productLine == 606 && !WalletApolloUtil.isBoletoScanOptEnable()) {
                        consumeItem.linkUrl = "99pay://one/consume/scan";
                    }
                    Request build = DRouter.build(consumeItem.linkUrl);
                    build.putExtra("product_line", consumeItem.productLine);
                    build.putExtra(WalletExtraConstant.Key.PAGE_REFER, "wallet_mainlist");
                    BitcoinUtil.putBitcoinExtra(build);
                    if (consumeItem.linkUrl.contains(CommonConstants.Router.PIX_REGISTER_PATH)) {
                        build.start(WalletMainListActivity.this.f34684c, new RouterCallback.ActivityCallback() {
                            public void onResult(Result result) {
                            }

                            public void onActivityResult(int i, Intent intent) {
                                WalletMainListActivity.this.f34682a.requestWalletPageList();
                            }
                        });
                    } else {
                        build.start((Context) null);
                    }
                }
            }

            public void onSettingClicked() {
                boolean unused = WalletMainListActivity.this.f34685d = true;
                WalletMainListActivity.this.f34682a.jumpToSettingPage();
            }

            public void onTransactionClicked() {
                WalletMainListActivity.this.f34682a.jumpToTransactionPage();
            }

            public void onNewPayMethodItemClicked(int i) {
                WalletMainListActivity.this.f34682a.handleNewPayMethodItemClicked(i);
            }

            public void onNewPayMethodItemRightLabelClicked(int i) {
                WalletMainListActivity.this.f34682a.handleNewPayMethodItemRightLabelClicked(i);
            }

            public boolean onConsumeItemClickIntercept(WalletHomeResp.ConsumeItem consumeItem) {
                WalletPageInfo pageInfo = WalletMainListActivity.this.f34682a.getPageInfo();
                if (pageInfo == null || pageInfo.freezonData == null || !pageInfo.freezonData.isFrozen()) {
                    return false;
                }
                return AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(WalletMainListActivity.this, (AccountFreezeData) AccountFreezeData.Builder.from(pageInfo.freezonData).btnPos(ResourcesHelper.getString(WalletMainListActivity.this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(WalletMainListActivity.this, R.string.GRider_reminder_Confirmation_norO)).putExtra("entrance", Integer.valueOf(consumeItem.productLine)).build());
            }

            public void onFinanceItemClick(WalletPageQueryResp.FinanceItem financeItem) {
                WebBrowserUtil.startInternalWebActivity(WalletMainListActivity.this.f34684c, financeItem.linkUrl, "");
            }

            public void onPixEntryClick(Bundle bundle) {
                if (bundle.containsKey("pix_entry")) {
                    WalletHomeResp.PixEntry pixEntry = (WalletHomeResp.PixEntry) bundle.getSerializable("pix_entry");
                    if (!TextUtil.isEmpty(pixEntry.linkUrl)) {
                        Request build = DRouter.build(pixEntry.linkUrl);
                        if (!pixEntry.linkUrl.contains(CommonConstants.Router.PIX_REGISTER_PATH)) {
                            build.start(WalletMainListActivity.this);
                        } else if (ApolloSignUpUtil.getApolloExp()) {
                            KycRegisterUtils.INSTANCE.go2SignUpActivity(WalletMainListActivity.this.f34684c, "3", false, new KycRegisterUtils.RouterListener() {
                                public void callback() {
                                    WalletMainListActivity.this.f34682a.requestWalletPageList();
                                }
                            });
                        } else {
                            build.start(WalletMainListActivity.this.f34684c, new RouterCallback.ActivityCallback() {
                                public void onResult(Result result) {
                                }

                                public void onActivityResult(int i, Intent intent) {
                                    WalletMainListActivity.this.f34682a.requestWalletPageList();
                                }
                            });
                        }
                    }
                }
            }
        });
        GlobalOmegaUtils.trackPayMethodSettingPageSW(this.f34684c);
        this.f34683b.initProgressDialog(this);
        WalletMainListPresenter walletMainListPresenter = new WalletMainListPresenter(this, this.f34683b);
        this.f34682a = walletMainListPresenter;
        walletMainListPresenter.setQrCodeDetectedListener(new OnQRCodeDetectedListener() {
            public void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData) {
                if (WalletMainListActivity.this.f34686e) {
                    WalletMainListActivity walletMainListActivity = WalletMainListActivity.this;
                    walletMainListActivity.m26500a((Context) walletMainListActivity, qRCodeData);
                }
            }
        });
        this.f34682a.requestWalletPageList();
    }

    /* renamed from: b */
    private void m26504b() {
        String clipboardText = NClipBoardUtil.getClipboardText(this);
        if (TextUtil.isEmpty(clipboardText)) {
            return;
        }
        if (clipboardText.contains("BR.GOV.BCB.PIX") || clipboardText.contains("BR.GOV.BCB.PIX".toLowerCase())) {
            this.f34682a.autoVerifyQRCode(clipboardText);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26500a(Context context, PixQrCodeQueryResp.QRCodeData qRCodeData) {
        NQRDetectedDialogHelper.showDialog(context, qRCodeData);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (i2 == -1) {
                    this.f34682a.requestWalletPageList();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f34683b.dismissProgressDialog();
        this.f34683b.releaseProgressDialog();
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: c */
    private void m26505c() {
        if (!PayBaseConfigUtil.isDebugMode()) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* renamed from: d */
    private void m26507d() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.transparent));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowFlowerAnimation(WalletSignUpSuccessEvent walletSignUpSuccessEvent) {
        this.f34685d = true;
        this.f34683b.showFlowerAnimation();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWalletDataChanged(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f34685d = true;
    }
}
