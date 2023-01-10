package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.os.SystemClock;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.GpsManager;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManagerWrapper */
public class GpsManagerWrapper {

    /* renamed from: a */
    private Context f48503a;

    /* renamed from: b */
    private GpsManager f48504b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f48505c;

    /* renamed from: d */
    private Set<LocationUpdateInternalListener> f48506d;

    /* renamed from: e */
    private GpsManager.GPSListener f48507e;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManagerWrapper$HOLDER */
    private static class HOLDER {
        /* access modifiers changed from: private */
        public static GpsManagerWrapper instance = new GpsManagerWrapper();

        private HOLDER() {
        }
    }

    public static GpsManagerWrapper getInstance() {
        return HOLDER.instance;
    }

    private GpsManagerWrapper() {
        this.f48506d = new HashSet();
        this.f48507e = new GpsManager.GPSListener() {
            public void onLocationChanged(OSLocationWrapper oSLocationWrapper) {
                DIDILocation unused = GpsManagerWrapper.this.f48505c = DIDILocation.loadFromGps(oSLocationWrapper, false, Utils.getCoordinateType());
                GpsManagerWrapper.this.f48505c.getExtra().putLong(DIDILocation.EXTRA_KEY_RECV_GPS_TICK, SystemClock.elapsedRealtime());
                GpsManagerWrapper gpsManagerWrapper = GpsManagerWrapper.this;
                gpsManagerWrapper.m36363a(gpsManagerWrapper.f48505c);
                GpsManagerWrapper.this.m36367c();
            }
        };
    }

    public void init(Context context) {
        this.f48503a = context;
    }

    public synchronized void requestLocationUpdates(LocationUpdateInternalListener locationUpdateInternalListener) {
        if (this.f48506d.isEmpty()) {
            m36362a();
        }
        this.f48506d.add(locationUpdateInternalListener);
    }

    public synchronized void removeLocationUpdates(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48506d.remove(locationUpdateInternalListener);
        if (this.f48506d.isEmpty()) {
            m36364b();
        }
    }

    public boolean isLocationValid(DIDILocation dIDILocation) {
        return System.currentTimeMillis() - dIDILocation.getLocalTime() < 30000;
    }

    public DIDILocation getGpsLocation() {
        DIDILocation dIDILocation = this.f48505c;
        if (dIDILocation != null && isLocationValid(dIDILocation)) {
            return this.f48505c;
        }
        GpsManager gpsManager = this.f48504b;
        if (gpsManager == null) {
            return null;
        }
        gpsManager.tryInitWhenPermissionGranted();
        return null;
    }

    public DIDILocation getLastGpsLocation() {
        return this.f48505c;
    }

    public void tryRebootGPS() {
        if (this.f48504b != null) {
            GpsManager instance = GpsManager.getInstance();
            long timeBoot = Utils.getTimeBoot();
            if (timeBoot - instance.getReceiveGpsSignalTime() > 120000 && timeBoot - instance.getStartedTime() > 120000 && !Utils.airPlaneModeOn(this.f48503a) && SensorMonitor.getInstance(this.f48503a).isGpsEnabled()) {
                DLog.m36225d("restart gps");
                instance.reset();
            }
        }
    }

    /* renamed from: a */
    private void m36362a() {
        if (this.f48504b == null) {
            GpsManager instance = GpsManager.getInstance();
            this.f48504b = instance;
            instance.init(this.f48503a);
            this.f48504b.requestListenGps(this.f48507e);
        }
    }

    /* renamed from: b */
    private void m36364b() {
        GpsManager gpsManager = this.f48504b;
        if (gpsManager != null) {
            gpsManager.removeListenGps(this.f48507e);
            this.f48504b = null;
        }
        this.f48505c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36367c() {
        for (LocationUpdateInternalListener onLocationUpdate : this.f48506d) {
            onLocationUpdate.onLocationUpdate(this.f48505c, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36363a(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
            dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
        }
    }
}
