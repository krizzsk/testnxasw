package com.rider.rlab_im_map_plugin.nav;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.android.libraries.navigation.Waypoint;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.tool.ImMapTrace;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ImNavigator {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f58703a = LoggerFactory.getLogger("RiderNavigator");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Navigator f58704b;

    /* renamed from: c */
    private NavigationResultListener f58705c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f58706d = new AtomicBoolean(false);

    /* renamed from: e */
    private boolean f58707e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f58708f;

    /* renamed from: g */
    private final Navigator.RemainingTimeOrDistanceChangedListener f58709g = new Navigator.RemainingTimeOrDistanceChangedListener() {
        public void onRemainingTimeOrDistanceChanged() {
            ImNavigator.this.m44394a();
        }
    };

    /* renamed from: h */
    private final Navigator.ArrivalListener f58710h = new Navigator.ArrivalListener() {
        public void onArrival(ArrivalEvent arrivalEvent) {
            ImNavigator.this.f58703a.info("️onArrival() called User has arrived at the destination!", new Object[0]);
            if (ImNavigator.this.f58704b != null) {
                ImNavigator.this.f58704b.stopGuidance();
                ImNavigator.this.f58704b.clearDestinations();
                MapIMPluginHelper.setMapNavigationFinish();
            }
        }
    };

    /* renamed from: i */
    private final Navigator.RouteChangedListener f58711i = new Navigator.RouteChangedListener() {
        public void onRouteChanged() {
            ImNavigator.this.f58703a.debug("onRouteChanged() called User , route has change", new Object[0]);
        }
    };

    public interface InitListener {
        public static final int ACTIVITY_ERROR = 1;
        public static final int INIT_ERROR = 2;

        void onFail(int i, String str);

        void onSuccess();
    }

    public interface NavigationListener {
        void onFail(String str);

        void onSuccess();
    }

    /* renamed from: a */
    private void m44395a(Activity activity, InitListener initListener) {
        if (Build.VERSION.SDK_INT < 17 || (activity != null && !activity.isDestroyed())) {
            this.f58708f = activity;
            final long currentTimeMillis = System.currentTimeMillis();
            final InitListener initListener2 = initListener;
            final Activity activity2 = activity;
            NavigationApi.getNavigator(activity, new NavigationApi.NavigatorListener() {
                public void onNavigatorReady(Navigator navigator) {
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    Logger a = ImNavigator.this.f58703a;
                    a.debug("nav init time cost : " + currentTimeMillis, new Object[0]);
                    ImNavigator.this.m44396a(navigator);
                    InitListener initListener = initListener2;
                    if (initListener != null) {
                        initListener.onSuccess();
                    }
                    ImNavigator.this.f58706d.set(true);
                }

                public void onError(int i) {
                    String navApiErrorStr = NavigatorTools.getNavApiErrorStr(activity2, i);
                    InitListener initListener = initListener2;
                    if (initListener != null) {
                        initListener.onFail(2, navApiErrorStr);
                    }
                    ImNavigator.this.f58706d.set(false);
                }
            });
        } else if (initListener != null) {
            initListener.onFail(1, "activity is null");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44396a(Navigator navigator) {
        this.f58704b = navigator;
        navigator.addArrivalListener(this.f58710h);
        this.f58704b.addRouteChangedListener(this.f58711i);
        try {
            this.f58704b.setAudioGuidance(4);
        } catch (Exception e) {
            Logger logger = this.f58703a;
            logger.error("onNavigatorReady() called with: " + e, new Object[0]);
        }
    }

    public void release() {
        m44401c();
        NavigationResultListener navigationResultListener = this.f58705c;
        if (navigationResultListener != null) {
            navigationResultListener.release();
        }
        this.f58706d.set(false);
        Navigator navigator = this.f58704b;
        if (navigator != null) {
            navigator.removeArrivalListener(this.f58710h);
            this.f58704b.removeRouteChangedListener(this.f58711i);
            if (this.f58704b.isGuidanceRunning()) {
                this.f58704b.stopGuidance();
            }
            this.f58704b.clearDestinations();
            this.f58704b.cleanup();
        }
    }

    public void navigate(Activity activity, final Waypoint waypoint, final NavigationListener navigationListener) {
        m44395a(activity, (InitListener) new InitListener() {
            public void onSuccess() {
                ImNavigator.this.navToWayPoint(waypoint, navigationListener);
            }

            public void onFail(int i, String str) {
                navigationListener.onFail(str);
            }
        });
    }

    public void navToWayPoint(Waypoint waypoint, NavigationListener navigationListener) {
        ListenableResultFuture listenableResultFuture;
        int travelMode = ImMapConfig.getInstance().getTravelMode();
        RoutingOptions routingOptions = new RoutingOptions();
        routingOptions.avoidTolls(true).avoidHighways(true).locationTimeoutMs(10000);
        Logger logger = this.f58703a;
        logger.debug("navToWayPoint() called with: sNavType = [" + travelMode + Const.jaRight, new Object[0]);
        if (travelMode == 1) {
            routingOptions.travelMode(0);
            listenableResultFuture = this.f58704b.setDestination(waypoint, routingOptions);
        } else if (travelMode == 2) {
            routingOptions.travelMode(1);
            listenableResultFuture = this.f58704b.setDestination(waypoint, routingOptions);
        } else if (travelMode != 3) {
            listenableResultFuture = this.f58704b.setDestination(waypoint);
        } else {
            routingOptions.travelMode(2);
            listenableResultFuture = this.f58704b.setDestination(waypoint, routingOptions);
        }
        NavigationResultListener navigationResultListener = new NavigationResultListener(waypoint, navigationListener);
        this.f58705c = navigationResultListener;
        listenableResultFuture.setOnResultListener(navigationResultListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44394a() {
        List timeAndDistanceList;
        Navigator navigator = this.f58704b;
        if (navigator != null && (timeAndDistanceList = navigator.getTimeAndDistanceList()) != null && timeAndDistanceList.size() > 0) {
            TimeAndDistance timeAndDistance = (TimeAndDistance) timeAndDistanceList.get(0);
            int meters = timeAndDistance.getMeters();
            int seconds = timeAndDistance.getSeconds();
            int i = seconds / 60;
            String time = NavigatorTools.getTime((long) seconds);
            String str = i + "min";
            String str2 = String.format("%.1fkm", new Object[]{Double.valueOf((double) (((float) meters) / 1000.0f))}) + " . " + time;
            MapIMPluginHelper.setNavigationInfo(str, str2);
            if (!this.f58707e) {
                this.f58703a.info("time is : " + str + " , distanceText is " + str2, new Object[0]);
                this.f58707e = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m44399b() {
        m44401c();
        Navigator navigator = this.f58704b;
        if (navigator != null) {
            navigator.addRemainingTimeOrDistanceChangedListener(10, 100, this.f58709g);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m44401c() {
        Navigator navigator = this.f58704b;
        if (navigator != null) {
            navigator.removeRemainingTimeOrDistanceChangedListener(this.f58709g);
        }
    }

    private class NavigationResultListener implements ListenableResultFuture.OnResultListener<Navigator.RouteStatus> {
        private boolean mRelease = false;
        private final NavigationListener navigationListener;
        private long routeStartTime;
        private final Waypoint waypoint;

        public NavigationResultListener(Waypoint waypoint2, NavigationListener navigationListener2) {
            this.waypoint = waypoint2;
            this.navigationListener = navigationListener2;
            this.routeStartTime = System.currentTimeMillis();
        }

        public void onResult(Navigator.RouteStatus routeStatus) {
            if (this.mRelease || ImNavigator.this.f58704b == null) {
                return;
            }
            if (routeStatus == Navigator.RouteStatus.OK) {
                try {
                    ImNavigator.this.f58704b.startGuidance();
                } catch (Exception e) {
                    ImNavigator.this.f58703a.error("startGuidance error throw exception：", (Throwable) e);
                }
                this.navigationListener.onSuccess();
                ImMapTrace.trackAppNavigationSuccess();
                ImNavigator.this.m44399b();
                Logger a = ImNavigator.this.f58703a;
                a.debug("nav success time cost : " + (System.currentTimeMillis() - this.routeStartTime), new Object[0]);
            } else if (routeStatus == Navigator.RouteStatus.QUOTA_CHECK_FAILED || routeStatus == Navigator.RouteStatus.LOCATION_DISABLED || routeStatus == Navigator.RouteStatus.LOCATION_UNKNOWN || routeStatus == Navigator.RouteStatus.WAYPOINT_ERROR || routeStatus == Navigator.RouteStatus.NO_ROUTE_FOUND || routeStatus == Navigator.RouteStatus.NETWORK_ERROR || routeStatus == Navigator.RouteStatus.ROUTE_CANCELED) {
                String routeStatusStr = NavigatorTools.getRouteStatusStr(ImNavigator.this.f58708f, routeStatus);
                Logger a2 = ImNavigator.this.f58703a;
                a2.info("Error starting guidance: " + routeStatusStr, new Object[0]);
                this.navigationListener.onFail(routeStatusStr);
                ImMapTrace.trackAppNavigationFail(routeStatus.name(), routeStatusStr);
                ImNavigator.this.m44401c();
                Logger a3 = ImNavigator.this.f58703a;
                a3.debug("nav fail time cost : " + (System.currentTimeMillis() - this.routeStartTime), new Object[0]);
            } else {
                String routeStatusStr2 = NavigatorTools.getRouteStatusStr(ImNavigator.this.f58708f, routeStatus);
                Logger a4 = ImNavigator.this.f58703a;
                a4.info("️Error starting guidance: " + routeStatusStr2, new Object[0]);
                ImNavigator.this.m44401c();
                this.navigationListener.onFail(routeStatusStr2);
                ImMapTrace.trackAppNavigationFail(DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT, routeStatusStr2);
                Logger a5 = ImNavigator.this.f58703a;
                a5.debug("nav other fail time cost : " + (System.currentTimeMillis() - this.routeStartTime), new Object[0]);
            }
        }

        public void release() {
            this.mRelease = true;
        }
    }

    public AtomicBoolean getNavigatorInit() {
        return this.f58706d;
    }

    public Navigator getNavigator() {
        return this.f58704b;
    }
}
