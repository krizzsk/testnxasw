package com.didi.foundation.sdk.login;

import java.util.HashMap;

public class ThirdLoginClientIds {
    public static final String FACEBOOK = "facebook";
    public static final String GOOGLE = "google";

    /* renamed from: a */
    private HashMap<String, String> f23109a = new HashMap<>();

    public @interface ThirdName {
    }

    public ThirdLoginClientIds putAppId(String str, String str2) {
        this.f23109a.put(str, str2);
        return this;
    }

    public String getAppId(String str) {
        return this.f23109a.get(str);
    }
}
