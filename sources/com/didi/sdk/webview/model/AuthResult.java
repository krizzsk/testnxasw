package com.didi.sdk.webview.model;

import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthResult {

    /* renamed from: a */
    private String f41202a;

    /* renamed from: b */
    private String f41203b;

    /* renamed from: c */
    private String f41204c;

    /* renamed from: d */
    private String f41205d;

    /* renamed from: e */
    private String f41206e;

    /* renamed from: f */
    private String f41207f;

    public AuthResult(Map<String, String> map, boolean z) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (TextUtils.equals(next, "resultStatus")) {
                    this.f41202a = map.get(next);
                } else if (TextUtils.equals(next, "result")) {
                    this.f41203b = map.get(next);
                } else if (TextUtils.equals(next, "memo")) {
                    this.f41204c = map.get(next);
                }
            }
            for (String str : this.f41203b.split(ParamKeys.SIGN_AND)) {
                if (str.startsWith("alipay_open_id")) {
                    this.f41207f = m30937a(m30936a("alipay_open_id=", str), z);
                } else if (str.startsWith(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE)) {
                    this.f41206e = m30937a(m30936a("auth_code=", str), z);
                } else if (str.startsWith(FontsContractCompat.Columns.RESULT_CODE)) {
                    this.f41205d = m30937a(m30936a("result_code=", str), z);
                }
            }
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultStatus", this.f41202a);
            jSONObject.put("result", this.f41203b);
            jSONObject.put("memo", this.f41204c);
            jSONObject.put(StatusResponse.RESULT_CODE, this.f41205d);
            jSONObject.put("authCode", this.f41206e);
            jSONObject.put("alipayOpenId", this.f41207f);
            return jSONObject.toString();
        } catch (Exception | JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private String m30937a(String str, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(Const.jsQuote)) {
            str = str.replaceFirst(Const.jsQuote, "");
        }
        return str.endsWith(Const.jsQuote) ? str.substring(0, str.length() - 1) : str;
    }

    public String toString() {
        return "resultStatus={" + this.f41202a + "};memo={" + this.f41204c + "};result={" + this.f41203b + "}";
    }

    /* renamed from: a */
    private String m30936a(String str, String str2) {
        return str2.substring(str.length(), str2.length());
    }

    public String getResultStatus() {
        return this.f41202a;
    }

    public String getMemo() {
        return this.f41204c;
    }

    public String getResult() {
        return this.f41203b;
    }

    public String getResultCode() {
        return this.f41205d;
    }

    public String getAuthCode() {
        return this.f41206e;
    }

    public String getAlipayOpenId() {
        return this.f41207f;
    }
}
