package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.OSNLPManager */
public class OSNLPManager {

    /* renamed from: a */
    private static final String f48552a = "OSNLPManager";

    /* renamed from: h */
    private static final long f48553h = 15000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f48554b;

    /* renamed from: c */
    private LocationManager f48555c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile OSLocationWrapper f48556d;

    /* renamed from: e */
    private volatile boolean f48557e;

    /* renamed from: f */
    private boolean f48558f;

    /* renamed from: g */
    private long f48559g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f48560i;

    /* renamed from: j */
    private LocationListener f48561j;

    /* renamed from: a */
    static /* synthetic */ int m36422a(OSNLPManager oSNLPManager) {
        int i = oSNLPManager.f48560i;
        oSNLPManager.f48560i = i + 1;
        return i;
    }

    private OSNLPManager() {
        this.f48556d = null;
        this.f48557e = false;
        this.f48558f = false;
        this.f48560i = 0;
        this.f48561j = new LocationListener() {
            public void onLocationChanged(Location location) {
                OSNLPManager.m36422a(OSNLPManager.this);
                if (OSNLPManager.this.f48560i == 10) {
                    int unused = OSNLPManager.this.f48560i = 0;
                    DLog.m36225d("OSNLPManager location arrived: os nlp");
                }
                if (Utils.locCorrect(location)) {
                    if (ApolloProxy.getInstance().getIsCheckMockViaSystem()) {
                        boolean isMockLocation = Utils.isMockLocation(location);
                        Utils.setIsGpsMocked(isMockLocation);
                        if (isMockLocation && !DIDILocationManager.enableMockLocation) {
                            DLog.m36225d("on osnlp callback, mock loc and disable mock!");
                        }
                    }
                    if (!DIDILocationManager.enableMockLocation) {
                        boolean z = true;
                        if (!Utils.isMockSettingsON(OSNLPManager.this.f48554b) && !Utils.isGpsMocked()) {
                            z = Utils.isMockLocation(location);
                        }
                        if (z) {
                            return;
                        }
                    }
                    if (!(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() > 0.0f) {
                        LocNTPHelper.adjustSystemLocationTimestamp(location);
                        OSLocationWrapper unused2 = OSNLPManager.this.f48556d = new OSLocationWrapper(location, System.currentTimeMillis());
                        return;
                    }
                    DLog.m36225d("zero nlp location: " + String.valueOf(location));
                }
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
                DLog.m36225d(" status = " + i);
            }

            public void onProviderEnabled(String str) {
                DLog.m36225d(" osNLP onProviderEnabled: " + str);
            }

            public void onProviderDisabled(String str) {
                DLog.m36225d("osNLP onProviderDisabled: " + str);
            }
        };
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.OSNLPManager$SigletonHolder */
    private static class SigletonHolder {
        static OSNLPManager sInstance = new OSNLPManager();

        private SigletonHolder() {
        }
    }

    public static OSNLPManager getInstance() {
        return SigletonHolder.sInstance;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121133a(Context context) {
        this.f48554b = context;
        this.f48555c = (LocationManager) context.getSystemService("location");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo121132a() {
        m36425a(false);
    }

    /* renamed from: a */
    private synchronized void m36425a(boolean z) {
        if (!this.f48557e || z) {
            this.f48557e = true;
            try {
                this.f48555c.requestLocationUpdates("network", 1000, 0.0f, this.f48561j, ThreadDispatcher.getWorkThread().getLooper());
                this.f48558f = false;
            } catch (SecurityException e) {
                this.f48558f = true;
                DLog.m36225d("OSNLPManager#start: exception:" + e.getMessage());
            } catch (Exception e2) {
                this.f48558f = false;
                DLog.m36225d("OSNLPManager#start: exception:" + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo121134b() {
        if (this.f48557e) {
            try {
                this.f48555c.removeUpdates(this.f48561j);
            } catch (SecurityException e) {
                DLog.m36225d("OSNLPManager#stop: exception:" + e.getMessage());
            } catch (Exception e2) {
                DLog.m36225d("OSNLPManager#stop: exception:" + e2.getMessage());
            }
            this.f48557e = false;
        }
    }

    /* renamed from: c */
    private synchronized void m36428c() {
        if (this.f48557e && this.f48558f && this.f48555c != null && this.f48554b != null && SystemClock.elapsedRealtime() - this.f48559g > 15000) {
            this.f48559g = SystemClock.elapsedRealtime();
            if (Utils.isLocationPermissionGranted(this.f48554b)) {
                m36425a(true);
            }
        }
    }

    public DIDILocation getNLPLocation(int i) {
        DIDILocation dIDILocation = null;
        if (this.f48556d != null && Utils.locCorrect(this.f48556d.getLocation())) {
            if (System.currentTimeMillis() - this.f48556d.getLocalTime() > 20000) {
                this.f48556d = null;
            } else {
                dIDILocation = DIDILocation.loadFromGps(this.f48556d, true, i);
            }
        }
        if (this.f48556d == null) {
            m36428c();
        }
        return dIDILocation;
    }

    public OSLocationWrapper getOriginNLPLocation() {
        OSLocationWrapper oSLocationWrapper = null;
        if (this.f48556d != null && Utils.locCorrect(this.f48556d.getLocation())) {
            if (System.currentTimeMillis() - this.f48556d.getLocalTime() > 20000) {
                this.f48556d = null;
            } else {
                oSLocationWrapper = this.f48556d;
            }
        }
        if (this.f48556d == null) {
            m36428c();
        }
        return oSLocationWrapper;
    }
}
