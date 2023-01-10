package com.didi.sdk.signkylib;

public class SignKeyUtil {

    /* renamed from: a */
    private static SignKey f40231a;

    private SignKeyUtil() {
    }

    public static SignKey getInstance() {
        if (f40231a == null) {
            f40231a = new SignKey();
        }
        return f40231a;
    }

    public String getPhoneSignKey() {
        return f40231a.getPhoneSignKey();
    }
}
