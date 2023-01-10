package com.didi.sdk.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.webview.a */
/* compiled from: H5DeeplinkSaferyInterceptor */
class C14133a {
    /* renamed from: a */
    private static String m30851a() {
        return "https://page.didiglobal.com/global/silver-bullet-online/intercept-page-warn";
    }

    C14133a() {
    }

    /* renamed from: a */
    static String m30853a(String str, String str2) {
        if (m30859c(str2)) {
            m30854a(str, 2);
            if (m30862e()) {
                return m30851a();
            }
            return "";
        } else if (m30856b(str2)) {
            m30854a(str, 0);
            return "";
        } else {
            m30854a(str, 1);
            if (m30861d()) {
                return m30852a(str2);
            }
            return "";
        }
    }

    /* renamed from: a */
    private static String m30852a(String str) {
        Uri.Builder buildUpon = Uri.parse("https://page.didiglobal.com/global/silver-bullet-online/intercept-page-info").buildUpon();
        buildUpon.appendQueryParameter("deeplink_weburl", str);
        return buildUpon.build().toString();
    }

    /* renamed from: b */
    private static boolean m30856b(String str) {
        String[] b;
        if (str == null || (b = m30857b()) == null || b.length == 0) {
            return true;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        String lowerCase = host.toLowerCase();
        if (lowerCase.endsWith(".didiglobal.com")) {
            return true;
        }
        for (String equals : b) {
            if (lowerCase.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m30859c(String str) {
        String[] c;
        if (!(str == null || (c = m30860c()) == null || c.length == 0)) {
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            String lowerCase = host.toLowerCase();
            for (String equals : c) {
                if (lowerCase.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m30855a(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        for (String equals : strArr) {
            if (host.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static String[] m30857b() {
        return m30858b("whitelist", "");
    }

    /* renamed from: c */
    private static String[] m30860c() {
        return m30858b("blacklist", "");
    }

    /* renamed from: b */
    private static String[] m30858b(String str, String str2) {
        String str3 = (String) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam(str, str2);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3.split(",");
    }

    /* renamed from: d */
    private static boolean m30861d() {
        if (((Integer) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam("show_hint_page", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m30862e() {
        if (((Integer) Apollo.getToggle("deep_link_web_white_black_list").getExperiment().getParam("show_block_page", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m30854a(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("hit_list_type", Integer.valueOf(i));
        hashMap.put("show_hint_page", Boolean.valueOf(m30861d()));
        hashMap.put("show_block_page", Boolean.valueOf(m30862e()));
        OmegaSDKAdapter.trackEvent("ibt_deeplink_web_safety_intercept_sw", (Map<String, Object>) hashMap);
    }
}
