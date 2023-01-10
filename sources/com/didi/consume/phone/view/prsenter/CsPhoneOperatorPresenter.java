package com.didi.consume.phone.view.prsenter;

import android.app.Activity;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.contract.CsPhoneOperatorContract;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsPhoneOperatorPresenter implements CsPhoneOperatorContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f18259a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsPhoneOperatorContract.View f18260b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f18261c;

    /* renamed from: d */
    private CsNetModel f18262d;

    /* renamed from: e */
    private int f18263e = -1;

    public CsPhoneOperatorPresenter(Activity activity, CsPhoneOperatorContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f18259a = activity;
        this.f18260b = view;
        this.f18261c = walletLoadingContract;
        this.f18262d = CsNetModel.getIns(activity);
        this.f18263e = this.f18259a.getIntent().getIntExtra("order_type", -1);
    }

    public void trackOmega(int i) {
        if (i == 0) {
            HashMap hashMap = new HashMap();
            int i2 = 1;
            if (this.f18263e != 1) {
                i2 = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i2));
            CsOmegaUtils.trackPhoneBillOperatorSelected(hashMap);
        }
    }

    public void getOperatorList(int i, String str, String str2) {
        this.f18261c.showLoadingDialog();
        this.f18262d.getOperatorList(i, str, str2, new RpcService.Callback<CsOperatorListResp>() {
            public void onSuccess(CsOperatorListResp csOperatorListResp) {
                CsPhoneOperatorPresenter.this.f18261c.dismissLoadingDialog();
                if (csOperatorListResp == null) {
                    WalletToastNew.showFailedMsg(CsPhoneOperatorPresenter.this.f18259a, CsPhoneOperatorPresenter.this.f18259a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneOperatorPresenter.this.f18260b.onNetworkError();
                } else if (csOperatorListResp.errno == 0) {
                    CsPhoneOperatorPresenter.this.f18260b.showOperators(csOperatorListResp);
                } else {
                    WalletToastNew.showFailedMsg(CsPhoneOperatorPresenter.this.f18259a, csOperatorListResp.errmsg);
                    CsPhoneOperatorPresenter.this.f18260b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneOperatorPresenter.this.f18261c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsPhoneOperatorPresenter.this.f18259a, CsPhoneOperatorPresenter.this.f18259a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneOperatorPresenter.this.f18260b.onNetworkError();
            }
        });
    }
}
