package com.didi.payment.paymethod.sign.channel.paypal.activity;

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
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignWebContract;
import com.didi.payment.paymethod.sign.channel.paypal.presenter.PayPalSignWebPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PayPalSignWebActivity extends PayBaseWebActivity implements PayPalSignWebContract.View {

    /* renamed from: a */
    private static final String f33514a = "backUrl";

    /* renamed from: b */
    private static final String f33515b = "pollingTimes";

    /* renamed from: c */
    private static final String f33516c = "pollingFrequency";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f33517d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f33518e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f33519f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayPalSignWebContract.Presenter f33520g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f33521h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, String str2, int i, int i2, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPalSignWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, str);
        intent.putExtra("backUrl", str2);
        intent.putExtra(f33515b, i);
        intent.putExtra(f33516c, i2);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mWebTitleBar.setBackBtnImg(R.drawable.paymethod_global_btn_title_back_selector);
        m25453b();
        m25450a();
    }

    /* renamed from: a */
    private void m25450a() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
        }
        this.f33517d = intent.getStringExtra("backUrl");
        this.f33518e = intent.getIntExtra(f33515b, 10);
        this.f33519f = intent.getIntExtra(f33515b, 5);
        this.f33520g = new PayPalSignWebPresenter(this);
    }

    /* renamed from: b */
    private void m25453b() {
        addOverrideUrlLoader(new OverrideUrlLoader() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(PayPalSignWebActivity.this.f33517d) || !str.contains(PayPalSignWebActivity.this.f33517d)) {
                    return false;
                }
                boolean unused = PayPalSignWebActivity.this.f33521h = true;
                PayPalSignWebActivity.this.f33520g.pollSignResult(PayPalSignWebActivity.this.f33518e, PayPalSignWebActivity.this.f33519f);
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
        GlobalOmegaUtils.trackAddPayPalSuccess(this);
        finishWithResultCodeOK();
    }

    public void onSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
        finishWithResultCodeCanceled();
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        if (this.f33521h) {
            super.finishWithResultCodeOK();
        } else {
            finishWithResultCodeCanceled();
        }
    }
}
