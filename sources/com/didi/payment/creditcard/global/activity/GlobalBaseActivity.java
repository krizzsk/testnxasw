package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.loading.LoadingConfig;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.contract.CreditCardBaseContract;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Locale;

public abstract class GlobalBaseActivity extends FragmentActivity implements CreditCardBaseContract.IView {

    /* renamed from: a */
    private static final int f32761a = -1711276033;

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_right, R.anim.one_payment_creditcard_out_to_left);
        if (!PayBaseConfigUtil.isDebugMode()) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    public void finish() {
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
        super.finish();
    }

    public void showToast(String str) {
        if (str == null) {
            str = "";
        }
        WalletToastNew.showFailedMsg(this, str);
    }

    public void showToastCompleted(String str) {
        if (str == null) {
            str = "";
        }
        WalletToastNew.showSuccessMsg(this, str);
    }

    public void showLoadingDialog(String str) {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void showMaskLoadingDialog(String str) {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar, LoadingConfig.create().setWithMaskLayer(true).setMaskBackgroundColor(f32761a).build());
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m24875a(context));
    }

    /* renamed from: a */
    private Context m24875a(Context context) {
        Locale b = m24877b(context.getApplicationContext());
        return b != null ? m24876a(context, b) : context;
    }

    /* renamed from: b */
    private Locale m24877b(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return null;
    }

    /* renamed from: a */
    private Context m24876a(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public static void traceVendor(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str3);
        hashMap.put("vendor_type", str2);
        hashMap.put("resource_id", str);
        FinOmegaSDK.trackEvent("fin_wallet_bank_card_vendor_en", hashMap);
    }
}
