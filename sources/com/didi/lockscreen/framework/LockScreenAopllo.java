package com.didi.lockscreen.framework;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class LockScreenAopllo {

    /* renamed from: a */
    private static Boolean f26651a;

    public static boolean isAllowed() {
        Boolean bool = f26651a;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("psg_anr_lockservice_bind_type");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f26651a = valueOf;
        return valueOf.booleanValue();
    }
}
