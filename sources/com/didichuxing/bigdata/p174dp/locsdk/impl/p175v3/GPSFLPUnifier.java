package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.os.SystemClock;
import com.didichuxing.bigdata.p174dp.locsdk.Config;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.GpsManager;
import com.didichuxing.bigdata.p174dp.locsdk.utils.OmegaUtils;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GPSFLPUnifier */
public class GPSFLPUnifier {

    /* renamed from: a */
    GpsManager.GPSListener f48461a;

    /* renamed from: b */
    private Context f48462b;

    /* renamed from: c */
    private CopyOnWriteArraySet<LocationUpdateInternalListener> f48463c;

    /* renamed from: d */
    private CopyOnWriteArraySet<LocationUpdateInternalListener> f48464d;

    /* renamed from: e */
    private GpsManager f48465e;

    /* renamed from: f */
    private int f48466f;

    /* renamed from: g */
    private Config.LocateMode f48467g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DIDILocation f48468h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DIDILocation f48469i;

    public void tryRebootGPS() {
        if (this.f48465e != null) {
            GpsManager instance = GpsManager.getInstance();
            long timeBoot = Utils.getTimeBoot();
            if (timeBoot - instance.getReceiveGpsSignalTime() > 120000 && timeBoot - instance.getStartedTime() > 120000 && !Utils.airPlaneModeOn(this.f48462b) && SensorMonitor.getInstance(this.f48462b).isGpsEnabled()) {
                DLog.m36225d("restart gps");
                instance.reset();
            }
        }
    }

    public void applyLocateMode(Config.LocateMode locateMode, long j) {
        GpsManager gpsManager;
        if (this.f48467g != locateMode) {
            GpsManager gpsManager2 = this.f48465e;
            if (gpsManager2 != null) {
                gpsManager2.reset();
            }
            this.f48467g = locateMode;
        }
        if (this.f48467g == Config.LocateMode.SAVE_GPS_POWER && (gpsManager = this.f48465e) != null) {
            gpsManager.delayExecuteSingleGpsLocate(j);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GPSFLPUnifier$InstanceHolder */
    private static class InstanceHolder {
        static final GPSFLPUnifier sInstance = new GPSFLPUnifier();

        private InstanceHolder() {
        }
    }

    public static GPSFLPUnifier getInstance() {
        return InstanceHolder.sInstance;
    }

    private GPSFLPUnifier() {
        this.f48463c = new CopyOnWriteArraySet<>();
        this.f48464d = new CopyOnWriteArraySet<>();
        this.f48466f = 0;
        this.f48467g = Config.getFinalLocateMode();
        this.f48461a = new GpsManager.GPSListener() {
            public void onLocationChanged(OSLocationWrapper oSLocationWrapper) {
                DIDILocation unused = GPSFLPUnifier.this.f48468h = DIDILocation.loadFromGps(oSLocationWrapper);
                GPSFLPUnifier.this.f48468h.getExtra().putLong(DIDILocation.EXTRA_KEY_RECV_GPS_TICK, SystemClock.elapsedRealtime());
                GPSFLPUnifier gPSFLPUnifier = GPSFLPUnifier.this;
                gPSFLPUnifier.m36308a(gPSFLPUnifier.f48468h);
                DIDILocation unused2 = GPSFLPUnifier.this.f48469i = DIDILocation.loadFromGps(oSLocationWrapper, false, 0);
                GPSFLPUnifier gPSFLPUnifier2 = GPSFLPUnifier.this;
                gPSFLPUnifier2.m36310b(gPSFLPUnifier2.f48468h);
                GPSFLPUnifier gPSFLPUnifier3 = GPSFLPUnifier.this;
                gPSFLPUnifier3.m36313c(gPSFLPUnifier3.f48468h);
            }
        };
    }

    public void init(Context context) {
        this.f48462b = context;
    }

    public synchronized void removeListenLoc(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48463c.remove(locationUpdateInternalListener);
        if (this.f48463c.size() == 0) {
            m36309b();
        }
    }

    public synchronized void requestListenLoc(LocationUpdateInternalListener locationUpdateInternalListener) {
        if (this.f48463c.size() == 0) {
            m36307a();
        }
        this.f48463c.add(locationUpdateInternalListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36308a(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
            dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
        }
    }

    /* renamed from: a */
    private void m36307a() {
        this.f48467g = Config.getFinalLocateMode();
        GpsManager instance = GpsManager.getInstance();
        this.f48465e = instance;
        instance.init(this.f48462b);
        this.f48465e.requestListenGps(this.f48461a);
    }

    /* renamed from: b */
    private void m36309b() {
        GpsManager gpsManager = this.f48465e;
        if (gpsManager != null) {
            gpsManager.removeListenGps(this.f48461a);
            this.f48465e = null;
        }
        this.f48466f = 0;
        this.f48468h = null;
        this.f48469i = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36310b(DIDILocation dIDILocation) {
        Iterator<LocationUpdateInternalListener> it = this.f48463c.iterator();
        while (it.hasNext()) {
            it.next().onLocationUpdate(dIDILocation, 0);
        }
        if (DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource())) {
            OmegaUtils.trackVDRInertial(dIDILocation);
        }
    }

    public boolean isLocationValid(DIDILocation dIDILocation) {
        OSLocationWrapper gPSLocation = GpsManager.getInstance().getGPSLocation();
        if (dIDILocation == null) {
            if (gPSLocation != null) {
                long localTime = gPSLocation.getLocalTime();
                if (System.currentTimeMillis() - localTime < 3000) {
                    int i = this.f48466f + 1;
                    this.f48466f = i;
                    if (i == 3) {
                        OmegaUtils.trackSystemGpsButSdkNoGpsOrFlp(localTime, -1);
                        this.f48466f = 0;
                    }
                }
            }
            return false;
        }
        if (gPSLocation != null) {
            long localTime2 = gPSLocation.getLocalTime();
            long localTime3 = dIDILocation.getLocalTime();
            if (localTime2 - localTime3 > 3000) {
                OmegaUtils.trackSystemGpsButSdkNoGpsOrFlp(localTime2, localTime3);
            }
        }
        if (System.currentTimeMillis() - dIDILocation.getLocalTime() < 30000) {
            return true;
        }
        return false;
    }

    public void addPassiveListener(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48464d.add(locationUpdateInternalListener);
    }

    public void removePassiveListener(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48464d.remove(locationUpdateInternalListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36313c(DIDILocation dIDILocation) {
        Iterator<LocationUpdateInternalListener> it = this.f48464d.iterator();
        while (it.hasNext()) {
            it.next().onLocationUpdate(dIDILocation, 0);
        }
    }

    public DIDILocation getValidGPSFLPLocation() {
        if (isLocationValid(this.f48468h)) {
            return this.f48468h;
        }
        return null;
    }

    public DIDILocation getGPSFLPLocationWGS84() {
        return this.f48469i;
    }
}
