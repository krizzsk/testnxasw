package com.didi.consume.channels.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.channels.model.CsTopUpChannelResp;
import com.didi.consume.channels.view.CsTopUpChannelContract;
import com.didi.consume.phone.view.activities.CsPhoneRefillActivity;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletDriverATMResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.soda.blocks.constant.Const;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsTopupChannelPresenter implements CsTopUpChannelContract.Presenter {

    /* renamed from: a */
    private static final String f18120a = "1";

    /* renamed from: b */
    private static final String f18121b = "2";

    /* renamed from: i */
    private static final String f18122i = "tab";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f18123c;
    public boolean collectAddress;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CsTopUpChannelContract.View f18124d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletLoadingContract f18125e;

    /* renamed from: f */
    private WalletPageModel f18126f;

    /* renamed from: g */
    private CsNetModel f18127g;

    /* renamed from: h */
    private int f18128h = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GGKDrawer f18129j;

    public CsTopupChannelPresenter(FragmentActivity fragmentActivity, CsTopUpChannelContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f18123c = fragmentActivity;
        this.f18124d = view;
        this.f18125e = walletLoadingContract;
        this.f18126f = new WalletPageModel(fragmentActivity);
        this.f18127g = CsNetModel.getIns(this.f18123c);
        Intent intent = fragmentActivity.getIntent();
        if ("tab".equals(intent.getStringExtra(Const.BlockParamConst.SRC))) {
            this.f18128h = 605;
        } else {
            this.f18128h = intent.getIntExtra("product_line", -1);
        }
    }

    public void requestData() {
        this.f18125e.showLoadingDialog();
        this.f18127g.requestPhoneTopUpChannel(new RpcService.Callback<CsTopUpChannelResp>() {
            public void onSuccess(CsTopUpChannelResp csTopUpChannelResp) {
                CsTopupChannelPresenter.this.f18125e.dismissLoadingDialog();
                if (csTopUpChannelResp == null) {
                    WalletToastNew.showFailedMsg(CsTopupChannelPresenter.this.f18123c, CsTopupChannelPresenter.this.f18123c.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsTopupChannelPresenter.this.f18124d.onNetworkError();
                } else if (csTopUpChannelResp.errno == 0) {
                    CsTopupChannelPresenter.this.collectAddress = csTopUpChannelResp.data.collectAddress;
                    CsTopupChannelPresenter.this.f18124d.refreshUI(csTopUpChannelResp.data);
                } else if (csTopUpChannelResp.errno == 1010) {
                    CsTopupChannelPresenter.this.f18124d.showHomelandCityErrorPage();
                } else {
                    WalletToastNew.showFailedMsg(CsTopupChannelPresenter.this.f18123c, csTopUpChannelResp.errmsg);
                    CsTopupChannelPresenter.this.f18124d.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsTopupChannelPresenter.this.f18125e.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsTopupChannelPresenter.this.f18123c, CsTopupChannelPresenter.this.f18123c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsTopupChannelPresenter.this.f18124d.onNetworkError();
            }
        });
    }

    /* renamed from: a */
    private void m15344a(int i) {
        this.f18125e.showLoadingDialog();
        this.f18126f.checkDriverATMStatus(i, new RpcService.Callback<WalletDriverATMResp>() {
            public void onSuccess(final WalletDriverATMResp walletDriverATMResp) {
                CsTopupChannelPresenter.this.f18125e.dismissLoadingDialog();
                if (walletDriverATMResp == null || walletDriverATMResp.data == null) {
                    WalletToastNew.showFailedMsg(CsTopupChannelPresenter.this.f18123c, CsTopupChannelPresenter.this.f18123c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                } else if (walletDriverATMResp.canTopup4Psgr()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("order_type", 1);
                    bundle.putString(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA, walletDriverATMResp.data.extMetaData);
                    CsPhoneRefillActivity.launch(CsTopupChannelPresenter.this.f18123c, bundle);
                } else {
                    GGKDrawerModel1 gGKDrawerModel1 = new GGKDrawerModel1(walletDriverATMResp.data.title, new GGKBtnTextAndCallback(CsTopupChannelPresenter.this.f18123c.getString(R.string.wallet_dialog_ok_ok), new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("source", 0);
                            hashMap.put("rejection_type", Integer.valueOf(walletDriverATMResp.errno));
                            FinOmegaSDK.trackEvent("ibt_mouton_pax_driver_topup_rejection_ck", hashMap);
                            if (CsTopupChannelPresenter.this.f18129j != null) {
                                CsTopupChannelPresenter.this.f18129j.dismiss();
                            }
                        }
                    }));
                    gGKDrawerModel1.setSubTitle(walletDriverATMResp.data.subTitle);
                    CsTopupChannelPresenter csTopupChannelPresenter = CsTopupChannelPresenter.this;
                    GGKDrawer unused = csTopupChannelPresenter.f18129j = GGKUICreator.showDrawerModel(csTopupChannelPresenter.f18123c, gGKDrawerModel1);
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", 0);
                    hashMap.put("rejection_type", Integer.valueOf(walletDriverATMResp.errno));
                    FinOmegaSDK.trackEvent("ibt_mouton_pax_driver_topup_rejection_sw", hashMap);
                }
            }

            public void onFailure(IOException iOException) {
                CsTopupChannelPresenter.this.f18125e.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsTopupChannelPresenter.this.f18123c, CsTopupChannelPresenter.this.f18123c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }

    public void handleConditionClick(String str) {
        WalletRouter.gotoTopupConditionPage(this.f18123c, str);
    }

    public void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            PayTracker.putGlobal("wallet_channel_id", channelBean.channelId);
            if (TextUtils.equals(channelBean.channelId, "1")) {
                FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_homepage_online_ck");
                CsPhoneRefillActivity.launch(this.f18123c, new Bundle());
            } else if (TextUtils.equals(channelBean.channelId, "2")) {
                FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_homepage_ck");
                m15344a(this.f18128h);
            }
        }
    }
}
