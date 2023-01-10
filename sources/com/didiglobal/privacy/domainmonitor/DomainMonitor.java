package com.didiglobal.privacy.domainmonitor;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.privacy.domainmonitor.model.InterceptRouter;
import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpDMInterceptor;
import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpHooker;
import com.didiglobal.privacy.domainmonitor.utils.JsonUtil;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DomainMonitor {
    public static final String TAG = "DomainMonitor";

    /* renamed from: a */
    private static List<InterceptRouter> f53029a = new ArrayList();

    /* renamed from: b */
    private static List<String> f53030b = new ArrayList();

    /* renamed from: c */
    private static Map<String, String> f53031c = new HashMap();

    /* renamed from: d */
    private static List<String> f53032d = new ArrayList();

    /* renamed from: e */
    private static volatile boolean f53033e = false;

    /* renamed from: f */
    private static volatile boolean f53034f = false;

    /* renamed from: g */
    private static boolean f53035g = false;

    /* renamed from: h */
    private static boolean f53036h = false;

    /* renamed from: i */
    private static final String f53037i = "omgup.didiglobal.com";

    /* renamed from: j */
    private static final String f53038j = "omgup-g.didiglobal.com";

    /* renamed from: k */
    private static final String f53039k = "omgup-us.didiglobal.com";

    /* renamed from: l */
    private static final String f53040l = "omgup-ru.didiglobal.com";

    /* renamed from: m */
    private static final String f53041m = "img0.didiglobal.com";

    /* renamed from: n */
    private static final String f53042n = "firebaseinstallations.googleapis.com";

    public static void initSdkWithApolloName(String str, Boolean bool) {
        initSdkWithApolloName(str, "", bool.booleanValue());
    }

    public static void initSdkWithApolloName(String str, String str2, boolean z) {
        m39736a(str, str2);
        f53036h = z;
    }

    /* renamed from: a */
    private static void m39736a(String str, String str2) {
        if (!str.isEmpty()) {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow()) {
                m39738b(toggle.getExperiment().getStringParam("alarm_list", ""));
                m39734a();
            }
        }
        if (!str2.isEmpty()) {
            IToggle toggle2 = Apollo.getToggle(str2);
            if (toggle2.allow()) {
                f53034f = true;
                m39735a(toggle2.getExperiment().getStringParam("redirect_list", ""));
            }
        }
    }

    public static void initSdkWithList(List<String> list, List<String> list2, Boolean bool) {
        if (list2 != null && !list2.isEmpty()) {
            f53030b = list2;
            f53035g = true;
            if (list != null && !list.isEmpty()) {
                for (String put : list) {
                    f53031c.put(put, "1");
                }
            }
            f53036h = bool.booleanValue();
            m39734a();
        }
    }

    /* renamed from: a */
    private static void m39734a() {
        if (!f53033e) {
            SystemUtils.log(3, TAG, "monitorInstall: 安装成功", (Throwable) null, "com.didiglobal.privacy.domainmonitor.DomainMonitor", 114);
            m39737b();
            OkHttpHooker.installNetworkInterceptors(new OkHttpDMInterceptor());
            f53033e = true;
        }
    }

    /* renamed from: a */
    private static void m39735a(String str) {
        if (!str.isEmpty()) {
            f53029a = UrlUtil.stringToList(str);
        }
    }

    /* renamed from: b */
    private static void m39738b(String str) {
        if (!str.isEmpty()) {
            f53035g = true;
            Map<String, Object> json2Map = JsonUtil.json2Map(str);
            if (json2Map.containsKey("black_list")) {
                List<String> list = (List) json2Map.get("black_list");
                f53030b = list;
                if (list.isEmpty()) {
                    f53035g = false;
                }
            }
            if (json2Map.containsKey("white_list")) {
                f53031c = (Map) json2Map.get("white_list");
                return;
            }
            return;
        }
        f53035g = false;
    }

    /* renamed from: b */
    private static void m39737b() {
        f53032d.add("omgup.didiglobal.com");
        f53032d.add(f53039k);
        f53032d.add(f53038j);
        f53032d.add(f53040l);
        f53032d.add(f53041m);
        f53032d.add(f53042n);
    }

    public static boolean isMonitor() {
        return f53033e;
    }

    public static boolean isRedirect() {
        return f53034f;
    }

    public static boolean isAlarm() {
        return f53035g;
    }

    public static List<InterceptRouter> getRedirectList() {
        return f53029a;
    }

    public static List<String> getBlackList() {
        return f53030b;
    }

    public static Map<String, String> getWhiteList() {
        return f53031c;
    }

    public static List<String> getFilterList() {
        return f53032d;
    }

    public static boolean isDebug() {
        return f53036h;
    }
}
