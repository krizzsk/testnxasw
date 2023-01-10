package com.didi.payment.creditcard.global.model;

import com.didi.payment.creditcard.base.encryption.LianLianEncryptUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalBankCardInfo {

    /* renamed from: a */
    private String f32828a = "";

    /* renamed from: b */
    private String f32829b = "";

    /* renamed from: c */
    private String f32830c = "";

    /* renamed from: d */
    private String f32831d = "";

    public void setNumber(String str) {
        this.f32828a = str;
    }

    public void setCvc(String str) {
        this.f32829b = str;
    }

    public void setExpiryMonth(String str) {
        this.f32830c = str;
    }

    public void setExpiryYear(String str) {
        this.f32831d = str;
    }

    public String encryptWithAES(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("number", this.f32828a);
            jSONObject.put("cvc", this.f32829b);
            jSONObject.put("expirationMonth", this.f32830c);
            jSONObject.put("expirationYear", this.f32831d);
            return LianLianEncryptUtils.encryptWithAES(jSONObject.toString(), str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
