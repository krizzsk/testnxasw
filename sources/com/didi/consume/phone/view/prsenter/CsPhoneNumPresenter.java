package com.didi.consume.phone.view.prsenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;
import com.didi.consume.phone.view.contract.CsPhoneNumContract;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsPhoneNumPresenter implements CsPhoneNumContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f18253a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsPhoneNumContract.View f18254b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f18255c;

    /* renamed from: d */
    private CsNetModel f18256d;

    /* renamed from: e */
    private String f18257e;

    /* renamed from: f */
    private int f18258f;

    public CsPhoneNumPresenter(Activity activity, CsPhoneNumContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f18253a = activity;
        this.f18254b = view;
        this.f18255c = walletLoadingContract;
        this.f18256d = CsNetModel.getIns(activity);
    }

    public void init() {
        Intent intent = this.f18253a.getIntent();
        String stringExtra = intent.getStringExtra("activity_url");
        String stringExtra2 = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            this.f18257e = stringExtra;
            this.f18254b.showActivity(stringExtra2);
        }
        this.f18258f = intent.getIntExtra("order_type", -1);
        HashMap hashMap = new HashMap();
        int i = 1;
        if (this.f18258f != 1) {
            i = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i));
        CsOmegaUtils.trackPhoneBillNumberDisplay(hashMap);
    }

    public void getDefaultPhoneNum(int i) {
        this.f18255c.showLoadingDialog();
        this.f18256d.getDefaultPhoneNumber(i, new RpcService.Callback<CsDefaultPhoneNumberResp>() {
            public void onSuccess(CsDefaultPhoneNumberResp csDefaultPhoneNumberResp) {
                CsPhoneNumPresenter.this.f18255c.dismissLoadingDialog();
                if (csDefaultPhoneNumberResp == null) {
                    WalletToastNew.showFailedMsg(CsPhoneNumPresenter.this.f18253a, CsPhoneNumPresenter.this.f18253a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneNumPresenter.this.f18254b.onNetworkError();
                } else if (csDefaultPhoneNumberResp.errno == 0) {
                    CsPhoneNumPresenter.this.f18254b.showPhoneNumber(csDefaultPhoneNumberResp.data);
                } else {
                    WalletToastNew.showFailedMsg(CsPhoneNumPresenter.this.f18253a, csDefaultPhoneNumberResp.errmsg);
                    CsPhoneNumPresenter.this.f18254b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneNumPresenter.this.f18255c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsPhoneNumPresenter.this.f18253a, CsPhoneNumPresenter.this.f18253a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneNumPresenter.this.f18254b.onNetworkError();
            }
        });
    }

    public void jumpToActivityPage() {
        WebBrowserUtil.startInternalWebActivity(this.f18253a, this.f18257e, "");
    }
}
