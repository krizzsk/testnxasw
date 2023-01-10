package com.didi.rfusion.utils.tracker;

import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import java.util.HashMap;
import java.util.Map;

public class RFEventTracker {

    /* renamed from: a */
    private static final String f36070a = "RFEventTracker";

    /* renamed from: b */
    private RFusionConfig.IRFusionLogger f36071b = RFLogger.getLogger();

    /* renamed from: c */
    private RFusionConfig.IRFusionTracker f36072c = RFusion.getTracker();

    /* renamed from: d */
    private String f36073d;

    /* renamed from: e */
    private Map<String, Object> f36074e = new HashMap();

    private RFEventTracker(String str) {
        this.f36073d = str;
    }

    public static RFEventTracker event(String str) {
        return new RFEventTracker(str);
    }

    public RFEventTracker param(String str, int i) {
        this.f36074e.put(str, Integer.valueOf(i));
        return this;
    }

    public RFEventTracker param(String str, long j) {
        this.f36074e.put(str, Long.valueOf(j));
        return this;
    }

    public RFEventTracker param(String str, String str2) {
        this.f36074e.put(str, str2);
        return this;
    }

    public RFEventTracker param(String str, boolean z) {
        this.f36074e.put(str, Boolean.valueOf(z));
        return this;
    }

    public RFEventTracker param(Map<String, String> map) {
        if (map != null) {
            this.f36074e.putAll(map);
        }
        return this;
    }

    public RFEventTracker track() {
        RFusionConfig.IRFusionLogger iRFusionLogger = this.f36071b;
        iRFusionLogger.debug(f36070a, "track eventId:" + this.f36073d + ", params:" + this.f36074e);
        this.f36072c.track(this.f36073d, this.f36074e);
        return this;
    }
}
