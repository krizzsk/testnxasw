package com.didi.sdk.app;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class HotPatchInitAopllo {

    /* renamed from: a */
    private static Boolean f37937a;

    public static boolean isAllowed() {
        Boolean bool = f37937a;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("psg_anr_hotpatch_delay_init");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f37937a = valueOf;
        return valueOf.booleanValue();
    }
}
