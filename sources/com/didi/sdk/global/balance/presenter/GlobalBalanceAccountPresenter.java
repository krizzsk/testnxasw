package com.didi.sdk.global.balance.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.contract.GlobalBalanceAccountContract;
import com.didi.sdk.global.balance.model.BalanceModel;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.common.utils.GlobalHttpUtils;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.HashMap;

@Deprecated
public class GlobalBalanceAccountPresenter implements GlobalBalanceAccountContract.Presenter {

    /* renamed from: a */
    private static final String f38791a = "Balance";

    /* renamed from: b */
    private Context f38792b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GlobalBalanceAccountContract.View f38793c;

    public GlobalBalanceAccountPresenter(GlobalBalanceAccountContract.View view) {
        this.f38793c = view;
        this.f38792b = view.getContext();
    }

    public void loadBalanceAccounts() {
        new BalanceModel(this.f38792b).queryBalanceAccountsInfo(new RpcService.Callback<BalancePageResponse>() {
            public void onSuccess(BalancePageResponse balancePageResponse) {
                SystemUtils.log(3, "Balance", "Successfully loaded balance info", (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter$1", 46);
                GlobalBalanceAccountPresenter.this.f38793c.refreshView(balancePageResponse);
            }

            public void onFailure(IOException iOException) {
                SystemUtils.log(6, "Balance", "failed to load balance account info: " + iOException, (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter$1", 52);
                GlobalBalanceAccountPresenter.this.f38793c.refreshView((BalancePageResponse) null);
            }
        });
    }

    public void jumpToBalanceTransDetailsActivity(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "about:blank";
            SystemUtils.log(6, "Balance", "No transaction detail url provided, will use default url: " + str, (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter", 64);
        }
        WebBrowserUtil.startInternalWebActivity(this.f38793c.getActivity(), GlobalHttpUtils.appendQueryParam(str, "currency", str2), "");
    }

    public void jumpToLegalTermsActivity(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "about:blank";
            SystemUtils.log(6, "Balance", "No legal terms url provided, will use default url: " + str, (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter", 78);
        }
        WebBrowserUtil.startInternalWebActivity(this.f38793c.getActivity(), GlobalHttpUtils.appendQueryParam(str, "channelId", String.valueOf(i)), "");
    }

    public void jumpToTopUpPage(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            str = "about:blank";
            SystemUtils.log(6, "Balance", "No top up url provided, will use default url: " + str, (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter", 92);
        }
        HashMap hashMap = new HashMap();
        if (i2 > 0) {
            hashMap.put("amount", String.valueOf(i2));
        }
        hashMap.put("channelId", String.valueOf(i));
        String appendQueryParams = GlobalHttpUtils.appendQueryParams(str, hashMap);
        SystemUtils.log(3, "Balance", "start top up web view with url: " + appendQueryParams, (Throwable) null, "com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter", 105);
        WebBrowserUtil.startInternalWebActivity(this.f38793c.getActivity(), appendQueryParams, "");
    }
}
