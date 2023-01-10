package com.didi.payment.creditcard.global.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.commoninterfacelib.sotre.IBusinessInfoStore;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.base.encryption.LianLianEncryptUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.request.ServerParam;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalRiskInfo {

    /* renamed from: A */
    private String f32834A = "";

    /* renamed from: a */
    private String f32835a = "";

    /* renamed from: b */
    private String f32836b = "";

    /* renamed from: c */
    private String f32837c = "";

    /* renamed from: d */
    private String f32838d = "";

    /* renamed from: e */
    private String f32839e = "";

    /* renamed from: f */
    private String f32840f = "";

    /* renamed from: g */
    private String f32841g = "";

    /* renamed from: h */
    private String f32842h = "";

    /* renamed from: i */
    private boolean f32843i = false;

    /* renamed from: j */
    private String f32844j = "";

    /* renamed from: k */
    private String f32845k = "";

    /* renamed from: l */
    private String f32846l = "";

    /* renamed from: m */
    private String f32847m = "";

    /* renamed from: n */
    private String f32848n = "";

    /* renamed from: o */
    private String f32849o = "";

    /* renamed from: p */
    private String f32850p = "";

    /* renamed from: q */
    private String f32851q = "";

    /* renamed from: r */
    private String f32852r = "";

    /* renamed from: s */
    private String f32853s = "";

    /* renamed from: t */
    private String f32854t = "";

    /* renamed from: u */
    private String f32855u = "";

    /* renamed from: v */
    private String f32856v = "";

    /* renamed from: w */
    private String f32857w = "";

    /* renamed from: x */
    private String f32858x = "";

    /* renamed from: y */
    private String f32859y = "";

    /* renamed from: z */
    private String f32860z = "";

    public void setBankCardNo(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b = m24951b(str);
            this.f32858x = b;
            this.f32835a = LianLianEncryptUtils.MD5(b);
        }
    }

    public void setOriginNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f32845k = m24951b(str);
        }
    }

    public void setCardNoPrefixSuffix(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            this.f32836b = "";
            return;
        }
        String b = m24951b(str);
        String substring = b.substring(0, 6);
        String substring2 = b.substring(b.length() - 4, b.length());
        this.f32836b = substring + substring2;
    }

    public void setBankAccountName(String str) {
        this.f32837c = str;
    }

    public void setValidDate(String str) {
        this.f32838d = str;
    }

    public void setCvv2(String str) {
        this.f32839e = str;
        this.f32859y = str;
    }

    public void setStayTime(String str) {
        this.f32840f = str;
    }

    public void setBindType(String str) {
        this.f32841g = str;
    }

    public void setSignAfterOrder(boolean z) {
        if (z) {
            this.f32852r = "1";
        } else {
            this.f32852r = "0";
        }
    }

    public void setOrderId(String str) {
        this.f32853s = str;
    }

    public void setProductLine(String str) {
        this.f32854t = str;
    }

    public void setIsOcr(boolean z) {
        this.f32843i = z;
    }

    public void setOcrContent(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            this.f32844j = "";
            return;
        }
        String b = m24951b(str);
        String substring = b.substring(0, 6);
        String substring2 = b.substring(b.length() - 4, b.length());
        this.f32844j = substring + substring2;
    }

    public void setBankCardType(String str) {
        this.f32842h = str;
    }

    public void setBaseRiskParam(Context context) {
        this.f32846l = PayBaseParamUtil.getStringParam(context, "idfa");
        this.f32847m = PayBaseParamUtil.getStringParam(context, "a3");
        this.f32848n = PayBaseParamUtil.getStringParam(context, "country");
        this.f32849o = PayBaseParamUtil.getStringParam(context, "ip");
        this.f32850p = PayBaseParamUtil.getStringParam(context, "imei");
        this.f32851q = PayBaseParamUtil.getStringParam(context, "networkType");
        this.f32852r = m24949a("sign_after_order");
        this.f32854t = m24949a("product_line");
        this.f32853s = m24949a("order_id");
    }

    public void setIsExistPaste(String str) {
        this.f32860z = str;
    }

    public void setResourceid(String str) {
        this.f32834A = str;
    }

    public String encryptWithAES(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bankcard_no", this.f32835a);
            jSONObject.put("card_no_prefix_suffix", this.f32836b);
            jSONObject.put("number", this.f32858x);
            jSONObject.put("bank_account_name", this.f32837c);
            jSONObject.put("valid_date", this.f32838d);
            jSONObject.put("cvc", this.f32859y);
            jSONObject.put("stay_time", this.f32840f);
            jSONObject.put("idfa", this.f32846l);
            jSONObject.put("a3", this.f32847m);
            jSONObject.put("country", this.f32848n);
            jSONObject.put("ip", this.f32849o);
            jSONObject.put("phone_imsi", this.f32850p);
            jSONObject.put("order_id", this.f32853s);
            jSONObject.put("product_line", this.f32854t);
            jSONObject.put("bind_type", this.f32841g);
            jSONObject.put(ServerParam.PARAM_NETWORK_TYPE, this.f32851q);
            jSONObject.put("sign_after_order", this.f32852r);
            jSONObject.put("bankcard_type", this.f32842h);
            jSONObject.put("is_ocr", this.f32843i);
            jSONObject.put("ocr_content", this.f32844j);
            jSONObject.put("bind_phone", this.f32855u);
            jSONObject.put("id_no", this.f32856v);
            jSONObject.put("id_type", this.f32857w);
            if (!TextUtils.isEmpty(this.f32845k)) {
                jSONObject.put("origin_number", this.f32845k);
            }
            if (m24950a()) {
                jSONObject.put("resource_id", this.f32834A);
                jSONObject.put("isExistPaste", this.f32860z);
            }
            return LianLianEncryptUtils.encryptWithAES(jSONObject.toString(), str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m24950a() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("wallet_screen_shot");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("paste_Android", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m24949a(String str) {
        HashMap<String, Object> infos;
        IBusinessInfoStore iBusinessInfoStore = (IBusinessInfoStore) ServiceProviderManager.getInstance().getComponent(IBusinessInfoStore.class);
        if (iBusinessInfoStore != null && (infos = iBusinessInfoStore.getInfos()) != null && !TextUtils.isEmpty(str) && infos.get(str) == null) {
        }
        return "";
    }

    /* renamed from: b */
    private String m24951b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().replaceAll(" ", "");
    }

    /* renamed from: b */
    private void m24952b() {
        SystemUtils.log(3, "RiskInfo", "--------------------------- RiskInfo Start ----------------------------", (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 368);
        String str = "RiskInfo";
        SystemUtils.log(3, str, "bankcard_no = " + this.f32835a, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 369);
        SystemUtils.log(3, str, "card_no_prefix_suffix = " + this.f32836b, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 370);
        SystemUtils.log(3, str, "bank_account_name = " + this.f32837c, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 371);
        SystemUtils.log(3, str, "valid_date = " + this.f32838d, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 372);
        SystemUtils.log(3, str, "cvv2 = " + this.f32839e, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 373);
        SystemUtils.log(3, str, "stay_time = " + this.f32840f, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 374);
        SystemUtils.log(3, str, "idfa = " + this.f32846l, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 375);
        SystemUtils.log(3, str, "a3 = " + this.f32847m, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 376);
        SystemUtils.log(3, str, "country = " + this.f32848n, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 377);
        SystemUtils.log(3, str, "ip = " + this.f32849o, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 378);
        SystemUtils.log(3, str, "phone_imsi = " + this.f32850p, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 379);
        SystemUtils.log(3, str, "order_id = " + this.f32853s, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 380);
        SystemUtils.log(3, str, "product_line = " + this.f32854t, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 381);
        SystemUtils.log(3, str, "bind_type = " + this.f32841g, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 382);
        SystemUtils.log(3, str, "network_type = " + this.f32851q, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 383);
        SystemUtils.log(3, str, "sign_after_order = " + this.f32852r, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 384);
        SystemUtils.log(3, str, "bankcard_type = " + this.f32842h, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 385);
        SystemUtils.log(3, str, "is_ocr = " + this.f32843i, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 386);
        SystemUtils.log(3, str, "ocr_content = " + this.f32844j, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 387);
        SystemUtils.log(3, str, "resource_id = " + this.f32834A, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 388);
        SystemUtils.log(3, str, "isExistPaste = " + this.f32860z, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 389);
        SystemUtils.log(3, str, "--------------------------- RiskInfo End ------------------------------", (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 391);
    }
}
