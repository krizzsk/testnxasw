package com.didi.component.payentrance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.unifiedPay.component.model.SignResultModel;
import com.taxis99.R;
import org.json.JSONObject;

public class DDCreditSignActivity extends WebActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f16706a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private WebTitleBar f16707b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SignResultModel f16708c;

    /* renamed from: d */
    private boolean f16709d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f16709d = true;
        this.f16707b = (WebTitleBar) findViewById(R.id.web_title_bar);
        m14074b();
    }

    /* renamed from: b */
    private void m14074b() {
        FusionBridgeModule fusionBridge = getFusionBridge();
        if (fusionBridge != null) {
            fusionBridge.addFunction("sendSignResult", new SignResult());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14076c() {
        Intent intent = new Intent();
        SignResultModel signResultModel = this.f16708c;
        if (signResultModel != null) {
            intent.putExtra("param_ddcredit_bind_result", signResultModel);
        }
        setResult(-1, intent);
        finish();
    }

    class SignResult extends FusionBridgeModule.Function {
        SignResult() {
        }

        public JSONObject execute(JSONObject jSONObject) {
            SignResultModel unused = DDCreditSignActivity.this.f16708c = new SignResultModel();
            if (jSONObject != null) {
                DDCreditSignActivity.this.f16708c.result = jSONObject.optInt("result");
                DDCreditSignActivity.this.f16708c.code = jSONObject.optInt("code");
                DDCreditSignActivity.this.f16708c.message = jSONObject.optString("message");
                Logger b = DDCreditSignActivity.this.f16706a;
                b.info("code:" + DDCreditSignActivity.this.f16708c.code + "result:" + DDCreditSignActivity.this.f16708c.result + " message:" + DDCreditSignActivity.this.f16708c.message, new Object[0]);
            }
            if (DDCreditSignActivity.this.f16708c.result == 5) {
                DDCreditSignActivity.this.m14072a(false);
                return null;
            }
            DDCreditSignActivity.this.m14072a(true);
            DDCreditSignActivity.this.m14076c();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14072a(boolean z) {
        this.f16709d = z;
        m14075b(z);
    }

    /* renamed from: b */
    private void m14075b(boolean z) {
        if (z) {
            this.f16707b.setBackBtnVisibility(0);
        } else {
            this.f16707b.setBackBtnVisibility(8);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f16709d || i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
