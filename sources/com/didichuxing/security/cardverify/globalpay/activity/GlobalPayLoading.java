package com.didichuxing.security.cardverify.globalpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayLottieLoadingView;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayShadowLayout;
import com.taxis99.R;

public class GlobalPayLoading extends FragmentActivity {
    public static final String EXTRA_ID = "loading_id";

    /* renamed from: a */
    private static boolean f51478a = false;

    /* renamed from: b */
    private static GlobalPayLoading f51479b;

    /* renamed from: c */
    private GlobalPayShadowLayout f51480c;

    /* renamed from: d */
    private GlobalPayLottieLoadingView f51481d;

    public static void show(Context context) {
        f51478a = true;
        Intent intent = new Intent(context, GlobalPayLoading.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void hide() {
        f51478a = false;
        GlobalPayLoading globalPayLoading = f51479b;
        if (globalPayLoading != null) {
            globalPayLoading.finish();
            f51479b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (!f51478a) {
            finish();
            return;
        }
        getWindow().setFlags(1024, 1024);
        getWindow().setSoftInputMode(2);
        setContentView((int) R.layout.didi_security_card_verify_global_pay_loading_activity);
        GlobalPayLottieLoadingView globalPayLottieLoadingView = (GlobalPayLottieLoadingView) findViewById(R.id.loading_view);
        this.f51481d = globalPayLottieLoadingView;
        globalPayLottieLoadingView.show();
        GlobalPayShadowLayout globalPayShadowLayout = (GlobalPayShadowLayout) findViewById(R.id.loading_view_container);
        this.f51480c = globalPayShadowLayout;
        globalPayShadowLayout.setVisibility(0);
        f51479b = this;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        f51479b = null;
    }
}
