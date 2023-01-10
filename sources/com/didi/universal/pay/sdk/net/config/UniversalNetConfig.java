package com.didi.universal.pay.sdk.net.config;

public class UniversalNetConfig {
    public static final String URL_ONLINE_HEAD_GLOBAL = "https://cashier.didiglobal.com";
    public static final String URL_ONLINE_HEAD_MAIN = "";

    /* renamed from: a */
    private static String f47779a = "";

    /* renamed from: b */
    private static final String f47780b = "";

    /* renamed from: c */
    private static final String f47781c = "/gulfstream/pay/v1/client/";

    /* renamed from: d */
    private static final String f47782d = "/gulfstream/pay/v1/didipay/";

    /* renamed from: e */
    private static String f47783e = (f47779a + f47781c);

    /* renamed from: f */
    private static String f47784f = f47781c;

    /* renamed from: g */
    private static String f47785g = (f47779a + f47782d);

    /* renamed from: h */
    private static String f47786h = f47782d;

    /* renamed from: i */
    private boolean f47787i = true;

    /* renamed from: j */
    private boolean f47788j;

    public UniversalNetConfig(boolean z, boolean z2) {
        this.f47788j = z;
        this.f47787i = z2;
    }

    public boolean isOnline() {
        return this.f47787i;
    }

    public void resetDomain(int i) {
        if (i == 1) {
            f47779a = "";
        } else if (i == 2) {
            f47779a = "https://cashier.didiglobal.com";
        }
        f47783e = f47779a + f47781c;
        f47785g = f47779a + f47782d;
    }

    public String getBaseUrl() {
        return this.f47788j ? this.f47787i ? f47783e : f47784f : this.f47787i ? f47785g : f47786h;
    }

    public void setTripSdkOfflineEnv(String str) {
        f47784f = str + f47781c;
    }

    public void setNonTripSdkOfflineEnv(String str) {
        f47786h = str + f47782d;
    }
}
