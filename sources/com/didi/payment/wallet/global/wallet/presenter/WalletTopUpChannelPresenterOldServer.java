package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.constant.ProtocolType;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletUserProtocolsResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContractOldServer;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpAmountActivityOldServer;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletTopUpChannelPresenterOldServer implements WalletTopUpChannelContractOldServer.Presenter {

    /* renamed from: a */
    private static final String f34643a = "mx_online";

    /* renamed from: b */
    private static final String f34644b = "oxxo";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f34645c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletTopUpChannelContractOldServer.View f34646d;

    /* renamed from: e */
    private WalletPageModel f34647e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletTopUpChannelRespOldServer.DataBean f34648f;

    public WalletTopUpChannelPresenterOldServer(FragmentActivity fragmentActivity, WalletTopUpChannelContractOldServer.View view) {
        this.f34645c = fragmentActivity;
        this.f34646d = view;
        this.f34647e = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f34646d.showLoadingDialog();
        this.f34647e.requestWalletTopUpChannelOldServer(new RpcService.Callback<WalletTopUpChannelRespOldServer>() {
            public void onSuccess(WalletTopUpChannelRespOldServer walletTopUpChannelRespOldServer) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                if (walletTopUpChannelRespOldServer == null || walletTopUpChannelRespOldServer.data == null) {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, (int) R.string.one_payment_global_net_toast_serverbusy);
                    WalletTopUpChannelPresenterOldServer.this.f34646d.onNetworkError();
                } else if (walletTopUpChannelRespOldServer.errno == 0) {
                    WalletTopUpChannelRespOldServer.DataBean unused = WalletTopUpChannelPresenterOldServer.this.f34648f = walletTopUpChannelRespOldServer.data;
                    WalletTopUpChannelPresenterOldServer.this.f34646d.refreshUI(walletTopUpChannelRespOldServer.data);
                } else {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, walletTopUpChannelRespOldServer.errmsg);
                    WalletTopUpChannelPresenterOldServer.this.f34646d.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, (int) R.string.one_payment_global_net_toast_connectionerror);
                WalletTopUpChannelPresenterOldServer.this.f34646d.onNetworkError();
            }
        });
    }

    public void handleChannelClick(WalletTopUpChannelRespOldServer.ChannelBean channelBean) {
        if (channelBean != null) {
            if (TextUtils.equals(channelBean.f34294id, "oxxo")) {
                GlobalOmegaUtils.trackTopUpOfflineClick(this.f34645c);
                WebBrowserUtil.startInternalWebActivity(this.f34645c, channelBean.actionLink, "");
            } else if (TextUtils.equals(channelBean.f34294id, f34643a)) {
                GlobalOmegaUtils.trackTopUpOnlineClick(this.f34645c);
                boolean z = false;
                if (this.f34645c.getIntent() != null && this.f34645c.getIntent().getBooleanExtra("key_from_wallet", false)) {
                    z = true;
                }
                WalletTopUpAmountActivityOldServer.launch(this.f34645c, m26464a(), z);
            }
        }
    }

    public void requestTACProtocolInfo(String str) {
        this.f34646d.showLoadingDialog();
        this.f34647e.getUserRequiredAcceptProtocols(str, new RpcService.Callback<WalletUserProtocolsResp>() {
            public void onSuccess(WalletUserProtocolsResp walletUserProtocolsResp) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                if (walletUserProtocolsResp == null || walletUserProtocolsResp.data == null) {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, (int) R.string.one_payment_global_net_toast_serverbusy);
                } else if (walletUserProtocolsResp.errno == 0) {
                    WalletTopUpChannelPresenterOldServer.this.f34646d.showTACDialog(walletUserProtocolsResp.data);
                } else {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, walletUserProtocolsResp.errmsg);
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, (int) R.string.one_payment_global_net_toast_connectionerror);
            }
        });
    }

    public void handleTACDialogBtnClick(WalletUserProtocolsResp.UnAcceptProtocol unAcceptProtocol) {
        this.f34646d.showLoadingDialog();
        String str = unAcceptProtocol.link;
        this.f34647e.updateUserAcceptedProtocol(unAcceptProtocol.type, unAcceptProtocol.version, new RpcService.Callback<WalletUserProtocolsResp>() {
            public void onSuccess(WalletUserProtocolsResp walletUserProtocolsResp) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                if (walletUserProtocolsResp != null) {
                    if (walletUserProtocolsResp.errno == 0) {
                        WalletTopUpChannelPresenterOldServer.this.requestTACProtocolInfo(ProtocolType.TOP_UP.name());
                    } else {
                        PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, walletUserProtocolsResp.errmsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f34646d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f34645c, (int) R.string.risk_page_no_internet_toast);
            }
        });
    }

    /* renamed from: a */
    private WalletTopUpChannelResp.ExtraDataMexicoOnline m26464a() {
        WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline = new WalletTopUpChannelResp.ExtraDataMexicoOnline();
        extraDataMexicoOnline.online_top_up_items = this.f34648f.amounts;
        extraDataMexicoOnline.select_amount_page_title = this.f34648f.channelPageTitle;
        extraDataMexicoOnline.select_amount_rule_text = this.f34648f.amountRuleText;
        extraDataMexicoOnline.select_amount_text = this.f34648f.amountDesc;
        extraDataMexicoOnline.top_up_button_text = this.f34648f.buttonText;
        return extraDataMexicoOnline;
    }
}
