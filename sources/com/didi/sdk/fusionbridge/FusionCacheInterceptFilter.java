package com.didi.sdk.fusionbridge;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashSet;
import java.util.Set;

public class FusionCacheInterceptFilter {

    /* renamed from: a */
    private static final String f38709a = "global_fusion_cache_intercept_filter";

    /* renamed from: b */
    private static final String f38710b = "updateFlag";

    /* renamed from: c */
    private static final String f38711c = "blackList";
    public static FusionCacheInterceptFilter sInstance = new FusionCacheInterceptFilter();

    /* renamed from: d */
    private Set<String> f38712d = new HashSet();

    /* renamed from: e */
    private int f38713e = 0;

    public boolean shouldIntercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        IToggle toggle = Apollo.getToggle(f38709a, false);
        if (!toggle.allow()) {
            return false;
        }
        IExperiment experiment = toggle.getExperiment();
        if (m29180a(experiment)) {
            m29181b(experiment);
        }
        String[] split = str.split("\\?");
        if (split == null || split.length <= 0 || !this.f38712d.contains(split[0])) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m29180a(IExperiment iExperiment) {
        int i;
        try {
            i = Integer.parseInt((String) iExperiment.getParam(f38710b, "1"));
        } catch (Exception unused) {
            i = 1;
        }
        if (i <= this.f38713e) {
            return false;
        }
        this.f38713e = i;
        return true;
    }

    /* renamed from: b */
    private void m29181b(IExperiment iExperiment) {
        String str = (String) iExperiment.getParam(f38711c, "");
        this.f38712d.clear();
        if (!TextUtils.isEmpty(str)) {
            for (String add : str.split(",")) {
                this.f38712d.add(add);
            }
        }
    }
}
