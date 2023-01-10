package com.didi.unifylogin.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.unifylogin.base.net.pojo.request.BaseParam;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.listener.pojo.WebViewModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class CertificationController {

    /* renamed from: a */
    private static volatile boolean f47576a = false;

    public static void checkFourElements(Activity activity, String str) {
    }

    public static boolean isAlreadyCheck() {
        if (!f47576a) {
            return false;
        }
        f47576a = false;
        return true;
    }

    public static void openCertification(Activity activity, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("phone", str4);
        hashMap.put("ticket", str2);
        m35698a(activity, str, activity.getString(R.string.login_unify_real_name_web_title), hashMap, false);
        f47576a = true;
    }

    public static void loadLawStatus(Activity activity, String str) {
        m35698a(activity, str, (String) null, (Map<String, String>) null, false);
    }

    /* renamed from: a */
    private static void m35698a(Activity activity, String str, String str2, Map<String, String> map, boolean z) {
        LoginListeners.WebViewListener webViewListener = ListenerManager.getWebViewListener();
        if (webViewListener != null && activity != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.setActivity(activity);
            webViewModel.setTitle(str2);
            if (z) {
                webViewModel.setUrl(m35696a(activity, str, map));
            } else {
                webViewModel.setUrl(m35697a(str, map));
            }
            webViewListener.callWebView(webViewModel);
        }
    }

    /* renamed from: a */
    private static String m35696a(Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Map baseMap = new BaseParam(context, -1).getBaseMap();
        if (baseMap == null) {
            baseMap = new HashMap();
        }
        if (map != null) {
            baseMap.putAll(map);
        }
        return m35697a(str, baseMap);
    }

    /* renamed from: a */
    private static String m35697a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        } else if (!str.endsWith(ParamKeys.SIGN_AND)) {
            sb.append(ParamKeys.SIGN_AND);
        }
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
                sb.append(ParamKeys.SIGN_AND);
            }
        }
        return sb.toString();
    }
}
