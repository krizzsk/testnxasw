package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpAmountItemsResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpAmountContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.widget.TopUpCheckErrorDialogFragment;
import com.didi.payment.wallet.open.DidiWalletFactory;
import com.didi.payment.wallet.open.param.GlobalWalletParam;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class WalletTopUpAmountPresenter implements WalletTopUpAmountContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34620a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletTopUpAmountContract.View f34621b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34622c;

    /* renamed from: d */
    private WalletPageModel f34623d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GGKDrawer f34624e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f34625f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f34626g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f34627h;

    /* renamed from: i */
    private String f34628i;

    public WalletTopUpAmountPresenter(FragmentActivity fragmentActivity, WalletTopUpAmountContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f34620a = fragmentActivity;
        this.f34621b = view;
        this.f34622c = walletLoadingContract;
        Intent intent = fragmentActivity.getIntent();
        if (intent != null) {
            this.f34626g = intent.getIntExtra("order_type", -1);
            this.f34628i = intent.getStringExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA);
        }
        this.f34623d = new WalletPageModel(this.f34620a);
    }

    public boolean isTopupByDriver() {
        return this.f34626g == 1;
    }

    public void onBack() {
        if (isTopupByDriver()) {
            this.f34623d.remindExt();
        }
    }

    public void trackOmega(int i) {
        trackOmega(i, new HashMap());
    }

    public void trackOmega(int i, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("trip_status", Integer.valueOf(WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(this.f34628i) ? 1 : 0));
        int i2 = 1;
        if (this.f34626g != 1) {
            i2 = 0;
        }
        map.put("topup_channel", Integer.valueOf(i2));
        Intent intent = this.f34620a.getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_from", -1);
            if (intExtra == 3) {
                map.put(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home");
            } else if (intExtra == 5) {
                map.put(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_mainlist");
            }
        }
        switch (i) {
            case 0:
                FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_by_drv_amount_sw", map);
                return;
            case 1:
                GlobalOmegaUtils.trackTopupCardPaymentConfirmCK(map);
                return;
            case 2:
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_topup_any_amt_ck", map);
                return;
            case 3:
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_topup_customize_amt_ck", map);
                return;
            case 4:
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_topup_customize_amt_typ", map);
                return;
            case 5:
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_topup_customize_amt_exceeded_sw", map);
                break;
            case 6:
                break;
            default:
                return;
        }
        FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_phone_topup_toast_sw", map);
    }

    public void requestData() {
        this.f34622c.showLoadingDialog();
        this.f34623d.requestWalletTopupAmountItems(this.f34628i, new RpcService.Callback<WalletTopUpAmountItemsResp>() {
            public void onSuccess(WalletTopUpAmountItemsResp walletTopUpAmountItemsResp) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
                if (walletTopUpAmountItemsResp == null || walletTopUpAmountItemsResp.errno != 0 || walletTopUpAmountItemsResp.data == null) {
                    WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, WalletTopUpAmountPresenter.this.f34620a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletTopUpAmountPresenter.this.f34621b.onNetworkError();
                    return;
                }
                int unused = WalletTopUpAmountPresenter.this.f34625f = walletTopUpAmountItemsResp.data.productLine;
                WalletTopUpAmountPresenter.this.f34621b.refreshUI(walletTopUpAmountItemsResp.data);
            }

            public void onFailure(IOException iOException) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
            }
        });
    }

    public void handleTopUpClick(WalletTopUpAmountItemsResp.TopupItem topupItem) {
        if (topupItem != null) {
            trackOmega(1);
            m26442a(topupItem);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26442a(final WalletTopUpAmountItemsResp.TopupItem topupItem) {
        String str;
        this.f34622c.showLoadingDialog();
        C120362 r6 = new RpcService.Callback<WalletCreateOrderResp>() {
            public void onSuccess(WalletCreateOrderResp walletCreateOrderResp) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
                if (walletCreateOrderResp == null) {
                    WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, WalletTopUpAmountPresenter.this.f34620a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                } else if (walletCreateOrderResp.errno != 0 || walletCreateOrderResp.data == null) {
                    if (walletCreateOrderResp.errno != 40308 || walletCreateOrderResp.data == null) {
                        TopUpCheckErrorDialogFragment topUpCheckErrorDialogFragment = new TopUpCheckErrorDialogFragment();
                        topUpCheckErrorDialogFragment.setData(walletCreateOrderResp.errmsg);
                        topUpCheckErrorDialogFragment.show(WalletTopUpAmountPresenter.this.f34620a.getSupportFragmentManager(), "topuperror");
                        return;
                    }
                    String unused = WalletTopUpAmountPresenter.this.f34627h = walletCreateOrderResp.data.orderId;
                    if (!TextUtils.isEmpty(WalletTopUpAmountPresenter.this.f34627h)) {
                        WalletTopUpAmountPresenter.this.m26447a(walletCreateOrderResp.errmsg, topupItem);
                    }
                } else if (WalletTopUpAmountPresenter.this.isTopupByDriver()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("product_line", WalletTopUpAmountPresenter.this.f34625f);
                    bundle.putString("order_id", walletCreateOrderResp.data.orderId);
                    bundle.putInt("order_type", WalletTopUpAmountPresenter.this.f34626g);
                    bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 258);
                    WalletTopUpAmountPresenter.this.f34620a.finish();
                    if (WalletTopUpAmountPresenter.this.f34620a != null) {
                        bundle.putInt("key_from", WalletTopUpAmountPresenter.this.f34620a.getIntent().getIntExtra("key_from", -1));
                    }
                    WalletTopUpPayResultActivity.launch(WalletTopUpAmountPresenter.this.f34620a, 1002, bundle);
                } else {
                    WalletTopUpAmountPresenter.this.onCreateOrderSuccess(walletCreateOrderResp.data);
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, WalletTopUpAmountPresenter.this.f34620a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        };
        if (TextUtils.isEmpty(topupItem.customer)) {
            str = topupItem.metadata;
        } else {
            String str2 = topupItem.metadata;
            str = str2.replace("{amount}", (Integer.valueOf(topupItem.price).intValue() * 100) + "");
        }
        this.f34623d.createOrder(this.f34625f, this.f34626g, str, this.f34628i, r6);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26447a(String str, final WalletTopUpAmountItemsResp.TopupItem topupItem) {
        String string = this.f34620a.getString(R.string.GRider_Riders_Confirmation_aCEH);
        String string2 = this.f34620a.getString(R.string.GRider_Riders_Return_ixVw);
        C120373 r2 = new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                WalletTopUpAmountPresenter.this.m26446a("ibt_gp_didipay_driver_topup_pending_order_popup_yes_ck");
                if (WalletTopUpAmountPresenter.this.f34624e != null) {
                    WalletTopUpAmountPresenter.this.f34624e.dismiss();
                }
                WalletTopUpAmountPresenter.this.m26449b(topupItem);
            }
        };
        C120384 r7 = new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                WalletTopUpAmountPresenter.this.m26446a("ibt_gp_didipay_driver_topup_pending_order_popup_no_ck");
                if (WalletTopUpAmountPresenter.this.f34624e != null) {
                    WalletTopUpAmountPresenter.this.f34624e.dismiss();
                }
            }
        };
        C120395 r3 = new GGKDrawerModel1(str, new GGKBtnTextAndCallback(string, r2)) {
            /* access modifiers changed from: protected */
            public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
                gGKDrawerModel.isTwoBtnHorizontal = true;
                return gGKDrawerModel;
            }
        };
        r3.addMinorBtn(new GGKBtnTextAndCallback(string2, r7));
        this.f34624e = GGKUICreatorWithThemeCheck.showDrawerModel(this.f34620a, r3);
        m26446a("ibt_gp_didipay_driver_topup_pending_order_popup_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26446a(String str) {
        HashMap hashMap = new HashMap();
        if (WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(this.f34628i)) {
            hashMap.put("trip_status", 1);
        } else {
            hashMap.put("trip_status", 0);
        }
        PayTracker.trackEvent(str, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26449b(final WalletTopUpAmountItemsResp.TopupItem topupItem) {
        m26445a((Runnable) new Runnable() {
            public void run() {
                if (WalletTopUpAmountPresenter.this.f34624e != null) {
                    WalletTopUpAmountPresenter.this.f34624e.dismiss();
                }
                WalletTopUpAmountPresenter.this.m26442a(topupItem);
            }
        });
    }

    /* renamed from: a */
    private void m26445a(final Runnable runnable) {
        this.f34622c.showLoadingDialog();
        this.f34623d.closeOrder(this.f34625f, this.f34627h, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
                if (wBaseResp != null) {
                    if (wBaseResp.errno == 0) {
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    } else if (!TextUtils.isEmpty(wBaseResp.errmsg)) {
                        WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, wBaseResp.errmsg);
                    } else {
                        WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, ResourcesHelper.getString(WalletTopUpAmountPresenter.this.f34620a, R.string.pay_base_network_error));
                    }
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpAmountPresenter.this.f34622c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletTopUpAmountPresenter.this.f34620a, ResourcesHelper.getString(WalletTopUpAmountPresenter.this.f34620a, R.string.pay_base_network_error));
            }
        });
    }

    public void onCreateOrderSuccess(WalletCreateOrderResp.DataBean dataBean) {
        Object terminalId;
        this.f34627h = dataBean.orderId;
        HashMap hashMap = new HashMap();
        hashMap.put("product_line", Integer.valueOf(this.f34625f));
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(this.f34620a)) == null)) {
            hashMap.put("wallet_terminal_id", terminalId);
        }
        WalletRouter.gotoUniPayPage(this.f34620a, dataBean, hashMap);
    }

    public void onPaySuccess(String str) {
        if (!TextUtils.isEmpty(str)) {
            WalletToastNew.showSuccessMsg(this.f34620a, str);
        }
        int i = this.f34625f;
        if (i == 300) {
            onTopupLoadingFinish();
        } else {
            WalletTopUpPayResultActivity.launch(this.f34620a, 12, i, this.f34627h, -1);
        }
    }

    public void onTopupLoadingFinish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", 1);
        intent.putExtras(bundle);
        this.f34620a.setResult(-1, intent);
        m26441a();
    }

    /* renamed from: a */
    private void m26441a() {
        int i = -1;
        if (this.f34620a.getIntent() != null) {
            i = this.f34620a.getIntent().getIntExtra("key_from", -1);
        }
        if (i != 1) {
            EventBus.getDefault().post(new WalletRefreshDataEvent());
        } else {
            DidiWalletFactory.createGlobalWalletApi().openWallet(this.f34620a, new GlobalWalletParam());
        }
        this.f34620a.finish();
    }

    public String getOrderId() {
        return this.f34627h;
    }

    public void setOrderId(String str) {
        if (TextUtils.isEmpty(this.f34627h)) {
            this.f34627h = str;
        }
    }
}
