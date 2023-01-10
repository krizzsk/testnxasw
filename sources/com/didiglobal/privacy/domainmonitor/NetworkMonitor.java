package com.didiglobal.privacy.domainmonitor;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.privacy.domainmonitor.utils.JsonUtil;
import com.didiglobal.privacy.domainmonitor.utils.URLConnectionDebugLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkMonitor {

    /* renamed from: a */
    private static final String f53043a = "NetworkMonitor";

    /* renamed from: b */
    private static List<String> f53044b = new ArrayList();

    public static void initWithApolloName(String str) {
        IToggle toggle = Apollo.getToggle(str);
        if (toggle.allow()) {
            m39739a(toggle.getExperiment().getStringParam("white_list", ""));
        }
    }

    public static void initWithWhiteList(List<String> list) {
        m39740a(list);
    }

    public static void setIsDebug(boolean z) {
        URLConnectionDebugLogUtils.isDebug = z;
    }

    /* renamed from: a */
    private static void m39739a(String str) {
        m39740a((List<String>) Arrays.asList((String[]) JsonUtil.fromJson(str, String[].class)));
    }

    /* renamed from: a */
    private static void m39740a(List<String> list) {
        SystemUtils.log(3, f53043a, list == null ? "null" : list.toString(), (Throwable) null, "com.didiglobal.privacy.domainmonitor.NetworkMonitor", 54);
        if (list != null && !list.isEmpty()) {
            f53044b.addAll(list);
        }
    }

    public static boolean isInWhiteList(String str) {
        if (!TextUtils.isEmpty(str) && !f53044b.isEmpty()) {
            for (String contains : f53044b) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }
}
