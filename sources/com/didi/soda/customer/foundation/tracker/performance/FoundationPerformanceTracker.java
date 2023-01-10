package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.foundation.sdk.MethodAspect;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class FoundationPerformanceTracker {

    /* renamed from: a */
    private static FoundationPerformanceTracker f43708a = new FoundationPerformanceTracker();

    /* renamed from: b */
    private boolean f43709b;

    /* renamed from: c */
    private long f43710c;

    /* renamed from: d */
    private long f43711d;

    /* renamed from: e */
    private long f43712e;

    private FoundationPerformanceTracker() {
    }

    public static FoundationPerformanceTracker getTracker() {
        return f43708a;
    }

    public void init() {
        this.f43709b = true;
    }

    public void trackSplashRender(long j) {
        this.f43711d = j;
    }

    public void trackMainRender(long j) {
        this.f43710c = j;
    }

    public void trackMapRender(long j) {
        this.f43712e = j;
    }

    public void trackOmegaAppStartDuration() {
        if (this.f43709b && this.f43710c > 0 && this.f43711d > 0 && this.f43712e > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("MainActivity", String.valueOf(this.f43710c));
            hashMap.put("SplashActivity", String.valueOf(this.f43711d));
            hashMap.put("MapRender", String.valueOf(this.f43712e));
            MethodAspect.report(Arrays.asList(new Long[]{Long.valueOf(this.f43711d), Long.valueOf(this.f43710c)}), hashMap, (Map<String, Object>) null);
        }
    }
}
