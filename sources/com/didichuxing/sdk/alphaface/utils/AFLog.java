package com.didichuxing.sdk.alphaface.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;

public class AFLog {

    /* renamed from: a */
    private static final String f51322a = "af_default";

    /* renamed from: v */
    public static void m38441v(String str) {
        m38442v(f51322a, str);
    }

    /* renamed from: v */
    public static void m38442v(String str, String str2) {
        if (AlphaFaceFacade.getInstance().getConfig() != null && AlphaFaceFacade.getInstance().getConfig().isDebug()) {
            SystemUtils.log(2, str, str2, (Throwable) null, "com.didichuxing.sdk.alphaface.utils.AFLog", 22);
        }
    }

    /* renamed from: e */
    public static void m38439e(String str) {
        m38440e(f51322a, str);
    }

    /* renamed from: e */
    public static void m38440e(String str, String str2) {
        if (AlphaFaceFacade.getInstance().getConfig() != null && AlphaFaceFacade.getInstance().getConfig().isDebug()) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.sdk.alphaface.utils.AFLog", 34);
        }
    }
}
