package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import java.util.HashSet;
import java.util.Set;

public final class PerformanceOmegaHelper {

    /* renamed from: a */
    private long f43720a = -1;

    /* renamed from: b */
    private boolean f43721b;

    /* renamed from: c */
    private Set f43722c = new HashSet();

    private PerformanceOmegaHelper() {
    }

    public static PerformanceOmegaHelper getInstance() {
        return (PerformanceOmegaHelper) SingletonFactory.get(PerformanceOmegaHelper.class);
    }

    public void initStartTime() {
        this.f43721b = true;
        this.f43720a = System.currentTimeMillis();
    }

    public void reset() {
        this.f43721b = false;
        this.f43722c.clear();
    }

    public void trackAppRunDuration(String str) {
        if (!this.f43721b || this.f43722c.contains(str)) {
            return;
        }
        if (!EventConst.Performance.REQUESTFEEDDATACALLBACK.equals(str) || this.f43722c.contains(EventConst.Performance.LOCATIONMANAGER)) {
            OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam("start_time", Long.valueOf(this.f43720a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f43720a)).addEventParam(ParamConst.PARAM_PERFORMANCE_APM_ENABLED, Boolean.valueOf(FallbackController.getFallbackInfo().isOpen)).build().track();
            this.f43722c.add(str);
            if (EventConst.Performance.REQUESTFEEDDATACALLBACK.equals(str)) {
                getInstance().reset();
                return;
            }
            return;
        }
        getInstance().reset();
    }

    public void appsflyerTracker(String str, String str2) {
        if (this.f43720a <= 0) {
            this.f43720a = System.currentTimeMillis();
        }
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam(ParamConst.PARAM_PROMOCODE_VALUE, str2).addEventParam("start_time", Long.valueOf(this.f43720a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f43720a)).build().track();
    }

    public void popDialogTracker(String str) {
        if (this.f43720a <= 0) {
            this.f43720a = System.currentTimeMillis();
        }
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_APP_RUN_DURATION).addEventParam("key", str).addEventParam("start_time", Long.valueOf(this.f43720a)).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f43720a)).build().track();
    }

    public void trackImagePerformance(String str, long j, int i) {
        OmegaTracker.Builder.create(EventConst.Performance.SODA_S_IMG_AVG_LDT).addEventParam("time", Long.valueOf(j)).addEventParam("url", str).addEventParam(ParamConst.PARAM_PERFORMANCE_TOTAL_IMG_CACHE_TIME, Integer.valueOf(i)).build().track();
    }

    public void trackWebViewPerformance(String str, long j) {
        OmegaTracker.Builder.create(EventConst.Performance.TONE_P_X_FUSION_RENDER_FROM_NATIVE).addEventParam(ParamConst.PARAM_PERFORMANCE_TOTAL_TIME, Long.valueOf(j)).addEventParam("url", str).build().track();
    }
}
