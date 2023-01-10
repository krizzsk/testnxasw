package com.didi.map.sdk.sharetrack.external;

import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.logger.DLog;

public class GoogleRouteOptManager {

    /* renamed from: a */
    private static final String f31130a = "GoogleRouteOpt";

    /* renamed from: b */
    private boolean f31131b;

    /* renamed from: c */
    private boolean f31132c;

    private GoogleRouteOptManager() {
        this.f31131b = false;
        this.f31132c = false;
    }

    private static class Holder {
        public static GoogleRouteOptManager opt = new GoogleRouteOptManager();

        private Holder() {
        }
    }

    public static GoogleRouteOptManager getInstance() {
        return Holder.opt;
    }

    public void updateRouteOpt(NaviRoute naviRoute) {
        log("updateRouteOpt = " + naviRoute);
        if (naviRoute != null) {
            this.f31131b = naviRoute.avoidTolls();
            this.f31132c = naviRoute.routeShorter();
            return;
        }
        reset();
    }

    public void reset() {
        log("reset");
        this.f31131b = false;
        this.f31132c = false;
    }

    public boolean avoidTolls() {
        log("avoidTolls = " + this.f31131b);
        return this.f31131b;
    }

    public boolean routeShorter() {
        log("routeShorter = " + this.f31132c);
        return this.f31132c;
    }

    public void log(String str) {
        DLog.m23962d(f31130a, str, new Object[0]);
    }
}
