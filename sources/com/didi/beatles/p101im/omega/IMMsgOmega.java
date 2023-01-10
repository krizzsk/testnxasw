package com.didi.beatles.p101im.omega;

import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.beatles.p101im.IMContextInfoHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.omega.IMMsgOmega */
public class IMMsgOmega {

    /* renamed from: a */
    private static IMMsgOmega f11184a;

    /* renamed from: b */
    private long f11185b;

    /* renamed from: c */
    private int f11186c;

    /* renamed from: d */
    private String f11187d;

    public static IMMsgOmega getInstance() {
        if (f11184a == null) {
            f11184a = new IMMsgOmega();
        }
        return f11184a;
    }

    private IMMsgOmega() {
        if (IMContextInfoHelper.getContext() != null) {
            this.f11187d = IMContextInfoHelper.getContext().getPackageName();
        }
    }

    public void init(long j, int i) {
        this.f11185b = j;
        this.f11186c = i;
    }

    public void trackMoreBtn(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("op", str);
        track("ddim_xq_all_more_ck", hashMap);
    }

    public void track(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("uid", Long.valueOf(this.f11185b));
        map.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(this.f11186c));
        map.put("app", this.f11187d);
        OmegaUtil.trackIMEvent(str, map);
    }

    public void destory() {
        this.f11187d = null;
        f11184a = null;
    }
}
