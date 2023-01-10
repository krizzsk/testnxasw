package com.didi.unifylogin.utils;

import android.content.Context;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.response.LoginPageAbTestResponse;
import org.json.JSONObject;

public class ApolloSwitch {

    /* renamed from: a */
    private static final String f47561a = "unify_login_passport_update_sdk";

    /* renamed from: b */
    private static final String f47562b = "unify_login_passport_update_sdk_ab_result_extra";

    /* renamed from: c */
    private static ApolloSwitch f47563c;

    /* renamed from: d */
    private Context f47564d;

    public static ApolloSwitch getInstance() {
        if (f47563c == null) {
            f47563c = new ApolloSwitch();
        }
        return f47563c;
    }

    private ApolloSwitch() {
    }

    public void init(Context context) {
        this.f47564d = context;
    }

    public boolean passportSdkUpdate() {
        return ((Boolean) SPUtils.get(this.f47564d, f47561a, false)).booleanValue();
    }

    public boolean isLoginSDKUIV2(boolean z) {
        return m35693a("ab_login_style", 1) == 1;
    }

    public boolean supportWhatsAppLogin() {
        return m35693a("ab_whatsapp_login", 0) == 1;
    }

    public boolean isNewWhatsApp() {
        return m35693a("ab_whatsapp_new_login", 0) == 1;
    }

    /* renamed from: a */
    private int m35693a(String str, int i) {
        String str2 = (String) SPUtils.get(this.f47564d, f47562b, "{}");
        try {
            if (!TextUtil.isEmpty(str2)) {
                return new JSONObject(str2).optInt(str, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public void updatePassportUpdateSDK(LoginPageAbTestResponse loginPageAbTestResponse) {
        if (loginPageAbTestResponse != null && loginPageAbTestResponse.errno == 0) {
            Context context = this.f47564d;
            boolean z = true;
            if (loginPageAbTestResponse.abResult != 1) {
                z = false;
            }
            SPUtils.put(context, f47561a, Boolean.valueOf(z));
            if (loginPageAbTestResponse.abResultExtra != null) {
                Context context2 = this.f47564d;
                SPUtils.put(context2, f47562b, "" + loginPageAbTestResponse.abResultExtra);
                return;
            }
            SPUtils.remove(this.f47564d, f47562b);
        }
    }
}
