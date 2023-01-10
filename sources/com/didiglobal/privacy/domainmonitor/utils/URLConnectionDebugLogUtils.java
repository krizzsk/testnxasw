package com.didiglobal.privacy.domainmonitor.utils;

import com.didi.sdk.apm.SystemUtils;
import java.net.HttpURLConnection;

public class URLConnectionDebugLogUtils {

    /* renamed from: a */
    private static final String f53084a = "MonitorHttpURLConnect";
    public static boolean isDebug = false;

    /* renamed from: d */
    public static void m39753d(String str, String str2) {
        if (isDebug) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didiglobal.privacy.domainmonitor.utils.URLConnectionDebugLogUtils", 15);
        }
    }

    /* renamed from: a */
    static void m39752a(HttpURLConnection httpURLConnection, String str) {
        if (isDebug) {
            String absoluteUrl = UrlUtil.getAbsoluteUrl(httpURLConnection);
            SystemUtils.log(3, f53084a, "absoluteUrl = " + absoluteUrl + "  " + str, (Throwable) null, "com.didiglobal.privacy.domainmonitor.utils.URLConnectionDebugLogUtils", 22);
        }
    }
}
