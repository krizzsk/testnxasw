package com.didi.sdk.fresco;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class CommonDelegateLoader {

    /* renamed from: a */
    private static Boolean f38707a;

    public static boolean isAllowed() {
        Boolean bool = f38707a;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("gp_anr_fresco_init_in_splash");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f38707a = valueOf;
        return valueOf.booleanValue();
    }
}
