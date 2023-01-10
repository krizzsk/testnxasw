package com.didi.map.sdk.sharetrack.google.inner.omega;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.google.gson.Gson;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShareTrackOmegaManager {

    /* renamed from: a */
    private final String f31327a = ShareTrackOmegaManager.class.getSimpleName();

    /* renamed from: b */
    private final int f31328b = 60000;

    /* renamed from: c */
    private ScheduledExecutorService f31329c;

    /* renamed from: d */
    private List<LightNavOmegaInfo> f31330d;

    /* renamed from: e */
    private GoogleSctxDriver f31331e;

    /* renamed from: f */
    private boolean f31332f;

    /* renamed from: g */
    private long f31333g = -1;

    /* renamed from: h */
    private LatLng f31334h;

    /* renamed from: i */
    private Runnable f31335i = new Runnable() {
        public final void run() {
            ShareTrackOmegaManager.this.m23954b();
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23954b() {
        if (this.f31333g < 0) {
            this.f31333g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f31333g >= 60000) {
            this.f31333g = currentTimeMillis;
            flushAllNavData();
        }
        m23953a();
    }

    public ShareTrackOmegaManager(GoogleSctxDriver googleSctxDriver) {
        this.f31331e = googleSctxDriver;
        this.f31330d = new ArrayList();
        this.f31329c = Executors.newSingleThreadScheduledExecutor();
    }

    public void startLoopCarInfo() {
        if (!this.f31332f) {
            this.f31332f = true;
            try {
                this.f31329c.scheduleAtFixedRate(this.f31335i, 1000, 1000, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                this.f31332f = false;
            }
        }
    }

    public void destroy() {
        flushAllNavData();
        ScheduledExecutorService scheduledExecutorService = this.f31329c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        this.f31332f = false;
        this.f31334h = null;
    }

    /* renamed from: a */
    private void m23953a() {
        double d;
        if (this.f31331e == null) {
            DLog.m23962d(this.f31327a, "driver is null, cannot continue", new Object[0]);
            return;
        }
        LightNavOmegaInfo lightNavOmegaInfo = new LightNavOmegaInfo();
        GpsLocation originGpsLocation = this.f31331e.getOriginGpsLocation();
        RouteGuidanceGPSPoint originMatchPoint = this.f31331e.getOriginMatchPoint();
        IMyLocationDelegate myLocationEngine = this.f31331e.getMyLocationEngine();
        if (originGpsLocation != null) {
            lightNavOmegaInfo.gpsTime = originGpsLocation.time;
            lightNavOmegaInfo.originLat = originGpsLocation.latitude;
            lightNavOmegaInfo.originLng = originGpsLocation.longitude;
        }
        if (originMatchPoint != null) {
            int i = -1;
            double d2 = -1.0d;
            if (originMatchPoint.point != null) {
                double latitudeE6 = ((double) originMatchPoint.point.getLatitudeE6()) / 1000000.0d;
                double longitudeE6 = ((double) originMatchPoint.point.getLongitudeE6()) / 1000000.0d;
                i = this.f31331e.getEda(new LatLng(latitudeE6, longitudeE6), originMatchPoint.segmentIndex, originMatchPoint.shapeOffSet);
                d = longitudeE6;
                d2 = latitudeE6;
            } else {
                d = -1.0d;
            }
            lightNavOmegaInfo.curEDA = i;
            lightNavOmegaInfo.matchedLat = d2;
            lightNavOmegaInfo.matchedLng = d;
        }
        lightNavOmegaInfo.sysTime = System.currentTimeMillis();
        if (TimeServiceManager.getInstance().isNTPEnabled() && TimeServiceManager.getInstance().isNTPAvailable()) {
            lightNavOmegaInfo.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
        }
        if (!(myLocationEngine == null || myLocationEngine.getCarMarker() == null || myLocationEngine.getCarMarker().getPosition() == null)) {
            LatLng position = myLocationEngine.getCarMarker().getPosition();
            lightNavOmegaInfo.carAnimLat = position.latitude;
            lightNavOmegaInfo.carAnimLng = position.longitude;
            AnimateNode currentAnimNode = myLocationEngine.getCurrentAnimNode();
            if (currentAnimNode != null) {
                lightNavOmegaInfo.carAnimEDA = ((int) DDSphericalUtil.computeDistanceBetween(position, currentAnimNode.latLng)) + this.f31331e.getEda(currentAnimNode.latLng, currentAnimNode.index, 0);
            }
            if (this.f31334h == null) {
                this.f31334h = new LatLng(position.latitude, position.longitude);
            }
            lightNavOmegaInfo.distanceBetweenLastNode = (int) DDSphericalUtil.computeDistanceBetween(position, this.f31334h);
            this.f31334h = position;
        }
        List<LightNavOmegaInfo> list = this.f31330d;
        if (list != null) {
            list.add(lightNavOmegaInfo);
        }
    }

    public void flushAllNavData() {
        List<LightNavOmegaInfo> list = this.f31330d;
        if (list != null && !list.isEmpty()) {
            try {
                String json = new Gson().toJson((Object) this.f31330d);
                HashMap hashMap = new HashMap();
                hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId()));
                String str = "";
                if (!(this.f31331e == null || this.f31331e.getOrderInfo() == null)) {
                    str = this.f31331e.getOrderInfo().getOrderId();
                }
                hashMap.put("order_id", str);
                hashMap.put("list", json);
                GlobalDriverOmega.trackEvent("map_gps_anim_location_driv", hashMap);
                String str2 = this.f31327a;
                DLog.m23962d(str2, "flushAllNavData success, size is: " + this.f31330d.size(), new Object[0]);
                this.f31330d.clear();
            } catch (Exception e) {
                DLog.m23962d(this.f31327a, e.getMessage(), new Object[0]);
            }
        }
    }
}
