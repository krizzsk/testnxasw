package com.didiglobal.privacysdk.law.lawurl;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.privacysdk.law.prepose.AppUtils;

public class LawUrlBuilder {

    /* renamed from: a */
    private static final String f53171a = "https://common.didiglobal.com";

    /* renamed from: b */
    private static final String f53172b = "https://common-g.didiglobal.com";

    /* renamed from: c */
    private static final String f53173c = "/icmc/pmc/lawUrl";

    /* renamed from: d */
    private static final String f53174d = "appID";

    /* renamed from: e */
    private static final String f53175e = "phone_country";

    /* renamed from: f */
    private static final String f53176f = "location_country";

    /* renamed from: g */
    private static final String f53177g = "lang";

    /* renamed from: h */
    private static final String f53178h = "business";

    /* renamed from: i */
    private String f53179i = "";

    /* renamed from: j */
    private String f53180j = AppUtils.getCountryCodeISO3166();

    /* renamed from: k */
    private String f53181k = "";

    /* renamed from: l */
    private String f53182l = "";

    /* renamed from: m */
    private String f53183m = "";

    public String build() {
        return m39783a(this.f53179i, this.f53180j, this.f53181k, this.f53182l, this.f53183m);
    }

    public String buildForPreposeDialog() {
        return m39785b(this.f53179i, this.f53180j, this.f53181k, this.f53182l, this.f53183m);
    }

    public LawUrlBuilder setAppId(String str) {
        this.f53179i = str;
        return this;
    }

    public LawUrlBuilder setPhoneCountry(String str) {
        this.f53180j = str;
        return this;
    }

    public LawUrlBuilder setLocationCountry(String str) {
        this.f53181k = str;
        return this;
    }

    public LawUrlBuilder setLang(String str) {
        this.f53182l = str;
        return this;
    }

    public LawUrlBuilder setBusiness(String str) {
        this.f53183m = str;
        return this;
    }

    /* renamed from: a */
    private static String m39783a(String str, String str2, String str3, String str4, String str5) {
        return m39784a("https://common.didiglobal.com/icmc/pmc/lawUrl", str, str2, str3, str4, str5);
    }

    /* renamed from: b */
    private static String m39785b(String str, String str2, String str3, String str4, String str5) {
        return m39784a("https://common-g.didiglobal.com/icmc/pmc/lawUrl", str, str2, str3, str4, str5);
    }

    /* renamed from: a */
    private static String m39784a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str2)) {
            str = m39782a(str, "appID", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str = m39782a(str, f53175e, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            str = m39782a(str, "location_country", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            str = m39782a(str, "lang", str5);
        }
        return !TextUtils.isEmpty(str6) ? m39782a(str, "business", str6) : str;
    }

    /* renamed from: a */
    private static String m39782a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str4 = str2 + "=" + str3;
        if (str.endsWith("?")) {
            return str + str4;
        } else if (!str.contains("?")) {
            return str + "?" + str4;
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            return str + str4;
        } else {
            return str + ParamKeys.SIGN_AND + str4;
        }
    }
}
