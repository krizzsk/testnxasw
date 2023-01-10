package com.didi.map.setting.common.diversion;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavDiversionApollo {

    /* renamed from: a */
    private static final int f31398a = 5;

    /* renamed from: b */
    private static List<String> f31399b = new ArrayList();

    /* renamed from: c */
    private static List<String> f31400c = new ArrayList();

    /* renamed from: d */
    private static int f31401d;

    /* renamed from: e */
    private static boolean f31402e;

    static {
        f31401d = 8;
        IToggle toggle = Apollo.getToggle("map_driver_nav_diversion");
        boolean allow = toggle.allow();
        f31402e = allow;
        if (allow) {
            IExperiment experiment = toggle.getExperiment();
            String str = (String) experiment.getParam("from", "");
            if (!TextUtils.isEmpty(str)) {
                f31399b.addAll(Arrays.asList(str.split(",")));
            }
            String str2 = (String) experiment.getParam("to", "");
            if (!TextUtils.isEmpty(str2)) {
                f31400c.addAll(Arrays.asList(str2.split(",")));
            }
            f31401d = ((Integer) experiment.getParam("usage_count", 0)).intValue();
        }
    }

    public static List<String> getNavFromList() {
        return f31399b.size() > 5 ? f31399b.subList(0, 5) : f31399b;
    }

    public static List<String> getNavToList() {
        return f31400c.size() > 5 ? f31400c.subList(0, 5) : f31400c;
    }

    public static int getUsageThreshold() {
        return Math.min(10, f31401d);
    }

    public static boolean allow() {
        return f31402e;
    }
}
