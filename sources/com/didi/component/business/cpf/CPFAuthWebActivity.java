package com.didi.component.business.cpf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.safety.god.IClientAppInfo;
import com.didi.safety.god.manager.SafetyGod;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class CPFAuthWebActivity extends WebActivity {
    public static final String SOURCE_KEY = "CPF_AUTH_SOURCE_KEY";
    public static final String SOURCE_KEY_RG = "RG_AUTH_SOURCE_KEY";

    /* renamed from: a */
    private int f13036a = 0;

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SafetyGod.init(getApplicationContext(), new IClientAppInfo() {
            public String getA3() {
                return null;
            }

            public double getLat() {
                return 0.0d;
            }

            public double getLng() {
                return 0.0d;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
        this.f13036a = m11001b();
    }

    /* renamed from: b */
    private int m11001b() {
        return getIntent() != null ? getIntent().getIntExtra("CPF_AUTH_SOURCE_KEY", this.f13036a) : this.f13036a;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f13036a = m11001b();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && i2 == -1) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, 1);
            Intent intent2 = new Intent();
            intent2.putExtra(BaseEventKeys.Confirm.INTENT_KEY_SIGN_CREDIT_CARD, true);
            setResult(-1, intent2);
            finish();
        }
    }

    public boolean goBack(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(this.f13036a));
        if (this.f13036a > 0) {
            OmegaSDKAdapter.trackEvent("Brazil_CPF_fillin_back_ck", (Map<String, Object>) hashMap);
            GLog.m11354d("CPFAuthWebActivity", "source=" + this.f13036a);
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_safetycurp_back_ck", (Map<String, Object>) hashMap);
        setResult(0);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, 3);
        return super.goBack(z);
    }
}
