package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpAmountContractOldServer;
import com.didi.payment.wallet.global.wallet.view.widget.TopUpCheckErrorDialogFragment;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletTopUpAmountPresenterOldServer implements WalletTopUpAmountContractOldServer.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34629a;

    /* renamed from: b */
    private WalletTopUpAmountContractOldServer.View f34630b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f34631c;

    /* renamed from: d */
    private WalletPageModel f34632d;

    public WalletTopUpAmountPresenterOldServer(FragmentActivity fragmentActivity, WalletTopUpAmountContractOldServer.View view, WalletLoadingContract walletLoadingContract) {
        this.f34629a = fragmentActivity;
        this.f34630b = view;
        this.f34631c = walletLoadingContract;
        this.f34632d = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f34631c.showLoadingDialog();
    }

    public void handleTopUpClick(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem) {
        if (extraDataMexicoOnlineItem != null) {
            this.f34631c.showLoadingDialog();
            this.f34632d.createOrderOldServer(extraDataMexicoOnlineItem.sku, extraDataMexicoOnlineItem.currency, extraDataMexicoOnlineItem.extend_params, new RpcService.Callback<WalletCreateOrderRespOldServer>() {
                public void onSuccess(WalletCreateOrderRespOldServer walletCreateOrderRespOldServer) {
                    WalletTopUpAmountPresenterOldServer.this.f34631c.dismissLoadingDialog();
                    if (walletCreateOrderRespOldServer == null) {
                        WalletToastNew.showFailedMsg(WalletTopUpAmountPresenterOldServer.this.f34629a, WalletTopUpAmountPresenterOldServer.this.f34629a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    } else if (walletCreateOrderRespOldServer.errno != 0 || walletCreateOrderRespOldServer.data == null) {
                        TopUpCheckErrorDialogFragment topUpCheckErrorDialogFragment = new TopUpCheckErrorDialogFragment();
                        topUpCheckErrorDialogFragment.setData(walletCreateOrderRespOldServer.errmsg);
                        topUpCheckErrorDialogFragment.show(WalletTopUpAmountPresenterOldServer.this.f34629a.getSupportFragmentManager(), "topuperror");
                    } else {
                        WalletTopUpAmountPresenterOldServer.this.onCreateOrderSuccess(walletCreateOrderRespOldServer.data);
                    }
                }

                public void onFailure(IOException iOException) {
                    WalletTopUpAmountPresenterOldServer.this.f34631c.dismissLoadingDialog();
                    WalletToastNew.showFailedMsg(WalletTopUpAmountPresenterOldServer.this.f34629a, WalletTopUpAmountPresenterOldServer.this.f34629a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                }
            });
        }
    }

    public void onCreateOrderSuccess(WalletCreateOrderRespOldServer.DataBean dataBean) {
        WalletRouter.gotoUniPayPage(this.f34629a, dataBean);
    }
}
