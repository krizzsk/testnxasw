package com.didi.payment.paymethod.sign.channel.paypay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.overrider.OverrideUrlLoader;
import com.didi.payment.paymethod.omega.GlobalOmegaUtils;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignWebContract;
import com.didi.payment.paymethod.sign.channel.paypay.presenter.PayPaySignWebPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PayPaySignWebActivity extends PayBaseWebActivity implements PayPaySignWebContract.View {

    /* renamed from: a */
    private static final String f33537a = "backUrl";

    /* renamed from: b */
    private static final String f33538b = "pollingTimes";

    /* renamed from: c */
    private static final String f33539c = "pollingFrequency";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f33540d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f33541e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f33542f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayPaySignWebContract.Presenter f33543g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f33544h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, String str2, int i, int i2, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPaySignWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, str);
        intent.putExtra("backUrl", str2);
        intent.putExtra(f33538b, i);
        intent.putExtra(f33539c, i2);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mWebTitleBar.setBackBtnImg(R.drawable.paymethod_global_btn_title_back_selector);
        m25472b();
        m25469a();
    }

    /* renamed from: a */
    private void m25469a() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
        }
        this.f33540d = intent.getStringExtra("backUrl");
        this.f33541e = intent.getIntExtra(f33538b, 10);
        this.f33542f = intent.getIntExtra(f33538b, 5);
        this.f33543g = new PayPaySignWebPresenter(this);
    }

    /* renamed from: b */
    private void m25472b() {
        addOverrideUrlLoader(new OverrideUrlLoader() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(PayPaySignWebActivity.this.f33540d) || !str.contains(PayPaySignWebActivity.this.f33540d)) {
                    return false;
                }
                boolean unused = PayPaySignWebActivity.this.f33544h = true;
                PayPaySignWebActivity.this.f33543g.pollSignResult(PayPaySignWebActivity.this.f33541e, PayPaySignWebActivity.this.f33542f);
                return true;
            }
        });
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.web_title_bar, true);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void onSignSuccess(String str) {
        PayBaseToast.showSucc((Context) this, str);
        GlobalOmegaUtils.trackAddPayPaySuccess(this);
        finishWithResultCodeOK();
    }

    public void onSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        if (this.f33544h) {
            super.finishWithResultCodeOK();
        } else {
            finishWithResultCodeCanceled();
        }
    }
}
