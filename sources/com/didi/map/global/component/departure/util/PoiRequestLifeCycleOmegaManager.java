package com.didi.map.global.component.departure.util;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.HashMap;

public class PoiRequestLifeCycleOmegaManager {

    /* renamed from: a */
    private static PoiRequestLifeCycleOmegaManager f27568a;

    /* renamed from: b */
    private long f27569b;

    /* renamed from: c */
    private boolean f27570c;

    /* renamed from: d */
    private long f27571d = 0;

    /* renamed from: e */
    private boolean f27572e;

    /* renamed from: f */
    private boolean f27573f;

    private PoiRequestLifeCycleOmegaManager() {
    }

    public static PoiRequestLifeCycleOmegaManager getInstance() {
        if (f27568a == null) {
            synchronized (PoiRequestLifeCycleOmegaManager.class) {
                if (f27568a == null) {
                    PoiRequestLifeCycleOmegaManager poiRequestLifeCycleOmegaManager = new PoiRequestLifeCycleOmegaManager();
                    f27568a = poiRequestLifeCycleOmegaManager;
                    poiRequestLifeCycleOmegaManager.m21807a();
                }
            }
        }
        return f27568a;
    }

    public void onDestroy() {
        if (f27568a != null) {
            this.f27569b = 0;
            this.f27571d = 0;
            this.f27570c = true;
            this.f27572e = false;
            this.f27573f = false;
            f27568a = null;
        }
    }

    public void setBuryPoint(boolean z) {
        this.f27572e = z;
    }

    /* renamed from: a */
    private void m21807a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f27571d = currentTimeMillis;
        this.f27569b = currentTimeMillis;
        this.f27570c = true;
        this.f27573f = false;
    }

    public void timeStampOnStartRequest() {
        if (this.f27572e && !this.f27573f && this.f27570c) {
            this.f27573f = true;
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f27569b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f27569b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_init_to_req_time", hashMap);
        }
    }

    public void timeStampOnGetResponse() {
        if (this.f27572e && this.f27570c) {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f27569b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f27569b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_poiinfo_time", hashMap);
        }
    }

    public void timeStampOnResponseResolveDone() {
        if (this.f27572e && this.f27570c) {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            this.f27569b = currentTimeMillis;
            hashMap.put("time", Long.valueOf(currentTimeMillis - this.f27569b));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_show_card_time", hashMap);
        }
    }

    public void timeStampPoiRequestAllLife() {
        if (this.f27572e && this.f27570c) {
            this.f27570c = false;
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f27571d));
            GlobalOmegaTracker.trackEvent("tech_global_piconf_first_result_time", hashMap);
        }
    }

    public void onPoiRequestError() {
        this.f27570c = false;
        this.f27573f = false;
    }
}
