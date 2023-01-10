package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Config;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.PermRetryApollo;
import com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter.AccTimeFilterHelper;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.gnss.GNSSData;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.gnss.GpsGNSSProcessor;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeSource;
import com.didichuxing.bigdata.p174dp.locsdk.utils.MockLocationChecker;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager */
public class GpsManager extends C15954d<Location> {

    /* renamed from: c */
    private static final String f48470c = "GpsManager";

    /* renamed from: t */
    private static final long f48471t = 15000;

    /* renamed from: A */
    private GpsStatus.Listener f48472A;

    /* renamed from: B */
    private LocationListener f48473B;

    /* renamed from: C */
    private SingleGPSLocationListener f48474C;

    /* renamed from: D */
    private long f48475D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public RetrieveLastGPSLocTask f48476E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public List<GPSListener> f48477F;

    /* renamed from: G */
    private LocationListener f48478G;

    /* renamed from: a */
    OSLocationWrapper f48479a;

    /* renamed from: b */
    CopyOnWriteArraySet<GPSListener> f48480b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f48481d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LocationManager f48482e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f48483f;

    /* renamed from: g */
    private long f48484g;

    /* renamed from: h */
    private GpsStatus f48485h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f48486i;

    /* renamed from: j */
    private int f48487j;

    /* renamed from: k */
    private long f48488k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f48489l;

    /* renamed from: m */
    private boolean f48490m;

    /* renamed from: n */
    private volatile int f48491n;

    /* renamed from: o */
    private boolean f48492o;

    /* renamed from: p */
    private long f48493p;

    /* renamed from: q */
    private C15955e<Location> f48494q;

    /* renamed from: r */
    private boolean f48495r;

    /* renamed from: s */
    private long f48496s;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f48497u;

    /* renamed from: v */
    private GpsGNSSProcessor f48498v;

    /* renamed from: w */
    private GpsGNSSProcessor.OnGNSSDataListener f48499w;

    /* renamed from: x */
    private Runnable f48500x;

    /* renamed from: y */
    private Runnable f48501y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f48502z;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$GPSListener */
    public interface GPSListener {
        void onLocationChanged(OSLocationWrapper oSLocationWrapper);
    }

    /* renamed from: e */
    static /* synthetic */ int m36345e(GpsManager gpsManager) {
        int i = gpsManager.f48497u;
        gpsManager.f48497u = i + 1;
        return i;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$InstanceHolder */
    private static class InstanceHolder {
        static final GpsManager sInstance = new GpsManager();

        private InstanceHolder() {
        }
    }

    public static GpsManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private GpsManager() {
        this.f48483f = 0;
        this.f48484g = 0;
        this.f48485h = null;
        this.f48486i = -1.0f;
        this.f48487j = 0;
        this.f48489l = -1;
        this.f48490m = false;
        this.f48491n = -1;
        this.f48492o = false;
        this.f48493p = 8000;
        this.f48495r = false;
        this.f48497u = 0;
        this.f48499w = new GpsGNSSProcessor.OnGNSSDataListener() {
            public void onDataCallback(GNSSData gNSSData) {
                if (!GpsManager.this.m36346e() && gNSSData != null) {
                    long unused = GpsManager.this.f48483f = Utils.getTimeBoot();
                    int unused2 = GpsManager.this.f48489l = gNSSData.fixedSatelliteNum;
                    float unused3 = GpsManager.this.f48486i = gNSSData.signalLevel;
                    AccTimeFilterHelper.getInstance().setCurrentSatelliteNum(GpsManager.this.f48489l);
                }
            }
        };
        this.f48500x = new WaitSingleGPSTask();
        this.f48501y = new SingleGPSLocateTask();
        this.f48502z = 0;
        this.f48472A = new GpsStatus.Listener() {
            public void onGpsStatusChanged(int i) {
                long unused = GpsManager.this.f48502z = Utils.getTimeBoot();
                GpsManager.this.m36320a(i);
            }
        };
        this.f48473B = new LocationListener() {
            public void onLocationChanged(Location location) {
                if (Utils.locCorrect(location)) {
                    ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) GpsManager.this.f48476E);
                }
                GpsManager.this.m36322a(location);
                ThreadDispatcher.getWorkThread().postDelayed(GpsManager.this.f48476E, Const.DELAY_TIME4LAST_GPS_TASK);
                GpsManager.m36345e(GpsManager.this);
                if (GpsManager.this.f48497u == 10) {
                    int unused = GpsManager.this.f48497u = 0;
                    DLog.m36225d("GpsManager location arrived: gps");
                }
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
                GpsManager.this.m36330a(str, i, bundle);
            }

            public void onProviderEnabled(String str) {
                DLog.m36225d("gps provider enabled");
            }

            public void onProviderDisabled(String str) {
                DLog.m36225d("gps provider disabled");
            }
        };
        this.f48474C = new SingleGPSLocationListener();
        this.f48475D = 0;
        this.f48476E = new RetrieveLastGPSLocTask();
        this.f48480b = new CopyOnWriteArraySet<>();
        this.f48477F = new ArrayList();
        this.f48478G = new LocationListener() {
            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            public void onLocationChanged(Location location) {
                if (location != null && TextUtils.equals(location.getProvider(), "gps")) {
                    if (DIDILocationManager.enableMockLocation || !MockLocationChecker.isMockLocation(GpsManager.this.f48481d, location)) {
                        for (GPSListener onLocationChanged : GpsManager.this.f48477F) {
                            onLocationChanged.onLocationChanged(new OSLocationWrapper(location, System.currentTimeMillis()));
                        }
                    }
                }
            }
        };
    }

    public void init(Context context) {
        this.f48481d = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36319a() {
        Context context = this.f48481d;
        if (context != null && !this.f48490m) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            this.f48482e = locationManager;
            boolean hasGpsProvider = Utils.hasGpsProvider(locationManager);
            this.f48492o = hasGpsProvider;
            if (!hasGpsProvider) {
                DLog.m36225d("initGpsListeners: does not found gps provider");
                return;
            }
            try {
                boolean sendExtraCommand = this.f48482e.sendExtraCommand("gps", "force_xtra_injection", (Bundle) null);
                DLog.m36225d("using agps: " + sendExtraCommand);
            } catch (Exception unused) {
            }
            m36358k();
            Config.LocateMode finalLocateMode = Config.getFinalLocateMode();
            boolean z = false;
            if (finalLocateMode == Config.LocateMode.HIGH_ACCURATE) {
                m36341c();
            } else if (finalLocateMode == Config.LocateMode.SAVE_GPS_POWER) {
                m36332a(false);
                this.f48488k = Utils.getTimeBoot();
                this.f48476E.setContinuousRun(z);
                ThreadDispatcher.getWorkThread().postDelayed(this.f48476E, 4025);
                FilterJumpGPSStrategyInterceptor instance = FilterJumpGPSStrategyInterceptor.getInstance(this.f48481d);
                this.f48494q = instance;
                mo121180a((C15955e) instance);
                this.f48490m = true;
            }
            z = true;
            this.f48488k = Utils.getTimeBoot();
            this.f48476E.setContinuousRun(z);
            ThreadDispatcher.getWorkThread().postDelayed(this.f48476E, 4025);
            FilterJumpGPSStrategyInterceptor instance2 = FilterJumpGPSStrategyInterceptor.getInstance(this.f48481d);
            this.f48494q = instance2;
            mo121180a((C15955e) instance2);
            this.f48490m = true;
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$WaitSingleGPSTask */
    private class WaitSingleGPSTask implements Runnable {
        private WaitSingleGPSTask() {
        }

        public void run() {
            GpsManager.this.m36336b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36336b() {
        if (this.f48492o) {
            try {
                this.f48482e.removeUpdates(this.f48474C);
                this.f48474C.setIsUsing(false);
            } catch (Throwable th) {
                DLog.m36225d("remove single GPS exception, " + th.getMessage());
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$SingleGPSLocateTask */
    private class SingleGPSLocateTask implements Runnable {
        private SingleGPSLocateTask() {
        }

        public void run() {
            GpsManager.this.m36332a(true);
        }
    }

    public void delayExecuteSingleGpsLocate(long j) {
        long j2 = j - Const.DELAY_TIME4LAST_GPS_TASK;
        if (j2 <= 0) {
            j2 = 0;
        }
        ThreadDispatcher.getWorkThread().postDelayed(this.f48501y, j2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36332a(boolean z) {
        if (this.f48492o && !this.f48474C.isUsing()) {
            try {
                this.f48482e.requestSingleUpdate("gps", this.f48474C, ThreadDispatcher.getWorkThread().getLooper());
                this.f48474C.setIsUsing(true);
                ThreadDispatcher.getWorkThread().postDelayed(this.f48500x, this.f48493p);
                if (z) {
                    this.f48476E.setContinuousRun(false);
                    ThreadDispatcher.getWorkThread().postDelayed(this.f48476E, 3800);
                }
            } catch (SecurityException e) {
                m36331a((Throwable) e);
            } catch (Throwable th) {
                m36331a(th);
            }
        }
    }

    /* renamed from: c */
    private void m36341c() {
        try {
            this.f48495r = false;
            this.f48482e.requestLocationUpdates("gps", Utils.isOnViechleMounted(this.f48481d) ? 200 : 1000, 0.0f, this.f48473B, ThreadDispatcher.getWorkThread().getLooper());
        } catch (SecurityException e) {
            m36331a((Throwable) e);
        } catch (Throwable th) {
            m36331a(th);
        }
    }

    /* renamed from: a */
    private void m36331a(Throwable th) {
        int i;
        DLog.m36225d("GpsManager GPSManager exception, " + th.getMessage() + "," + th.getClass() + "," + th.getLocalizedMessage());
        if (th instanceof SecurityException) {
            i = 512;
            this.f48495r = true;
        } else {
            i = 1024;
        }
        m36329a("gps", i);
    }

    public void tryInitWhenPermissionGranted() {
        if (PermRetryApollo.getInstance().shouldRetryLoc() && this.f48490m && this.f48495r && this.f48481d != null && SystemClock.elapsedRealtime() - this.f48496s > 15000) {
            this.f48496s = SystemClock.elapsedRealtime();
            DLog.m36225d("GpsManager retry loc google gps");
            if (Utils.isLocationPermissionGranted(this.f48481d) && Config.getFinalLocateMode() == Config.LocateMode.HIGH_ACCURATE) {
                DLog.m36225d("GpsManager RESTART loc when permission granted");
                m36341c();
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$SingleGPSLocationListener */
    private class SingleGPSLocationListener implements LocationListener {
        private boolean mIsUsing;

        private SingleGPSLocationListener() {
            this.mIsUsing = false;
        }

        public boolean isUsing() {
            return this.mIsUsing;
        }

        public void setIsUsing(boolean z) {
            this.mIsUsing = z;
        }

        public void onLocationChanged(Location location) {
            if (Utils.locCorrect(location)) {
                ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) GpsManager.this.f48476E);
            }
            setIsUsing(false);
            GpsManager.this.m36344d();
            GpsManager.this.m36336b();
            GpsManager.this.m36322a(location);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            GpsManager.this.m36330a(str, i, bundle);
        }

        public void onProviderEnabled(String str) {
            DLog.m36225d("gps provider enabled");
        }

        public void onProviderDisabled(String str) {
            DLog.m36225d("gps provider disabled");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36344d() {
        ThreadDispatcher.getWorkThread().removeCallbacks(this.f48500x);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36330a(String str, int i, Bundle bundle) {
        if ("gps".equals(str)) {
            this.f48491n = i;
            if (i == 0) {
                m36329a("gps", 1024);
                DLog.m36225d("gps provider out of service");
            } else if (i == 1) {
                m36329a("gps", 1280);
                DLog.m36225d("gps provider temporarily unavailable");
            } else if (i == 2) {
                m36329a("gps", 768);
                DLog.m36225d("gps provider available");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36322a(Location location) {
        this.f48502z = Utils.getTimeBoot();
        if (Utils.locCorrect(location)) {
            boolean isMockLocation = Utils.isMockLocation(location);
            Utils.setIsGpsMocked(isMockLocation);
            if (!isMockLocation || DIDILocationManager.enableMockLocation) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f48475D > 15000) {
                    DLog.m36225d("-onLocationChanged-: type gps, location: " + location.getLongitude() + "," + location.getLatitude() + ", " + location.getSpeed() + ", " + location.getBearing() + ", " + location.getAccuracy() + ", " + location.getTime());
                    this.f48475D = currentTimeMillis;
                }
                if (mo121179a(location) != null) {
                    TimeServiceManager.getInstance().updateStandardTimeRef(TimeSource.GPS, location.getTime());
                    LocNTPHelper.adjustSystemLocationTimestamp(location);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    OSLocationWrapper oSLocationWrapper = new OSLocationWrapper(location, currentTimeMillis2);
                    this.f48479a = oSLocationWrapper;
                    m36323a(oSLocationWrapper);
                    SensorMonitor.getInstance(this.f48481d).setGpsFixedTimestamp(currentTimeMillis2);
                    return;
                }
                return;
            }
            DLog.m36225d("on gps callback, mock loc and disable mock!");
        }
    }

    public OSLocationWrapper getGPSLocation() {
        return this.f48479a;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GpsManager$RetrieveLastGPSLocTask */
    private class RetrieveLastGPSLocTask implements Runnable {
        private boolean mContinuousRun;

        private RetrieveLastGPSLocTask() {
            this.mContinuousRun = true;
        }

        public void setContinuousRun(boolean z) {
            this.mContinuousRun = z;
        }

        public void run() {
            if (GpsManager.this.f48482e != null) {
                try {
                    Location lastKnownLocation = GpsManager.this.f48482e.getLastKnownLocation("gps");
                    if (lastKnownLocation != null && ((!Utils.isMockLocation(lastKnownLocation) && !Utils.isMockSettingsON(GpsManager.this.f48481d)) || DIDILocationManager.enableMockLocation)) {
                        long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        if (Utils.locCorrect(lastKnownLocation) && nTPCurrenTimeMillis - lastKnownLocation.getTime() < 8000 && ((GpsManager.this.f48479a == null || lastKnownLocation.getTime() > GpsManager.this.f48479a.getLocation().getTime()) && GpsManager.this.mo121179a(lastKnownLocation) != null)) {
                            TimeServiceManager.getInstance().updateStandardTimeRef(TimeSource.GPS, lastKnownLocation.getTime());
                            LocNTPHelper.adjustSystemLocationTimestamp(lastKnownLocation);
                            GpsManager.this.f48479a = new OSLocationWrapper(lastKnownLocation, System.currentTimeMillis());
                            GpsManager.this.f48479a.setGpsSourceType(1);
                            GpsManager.this.m36323a(GpsManager.this.f48479a);
                            DLog.m36225d("updateFromLastKnownLocation for gps success");
                        }
                    }
                    if (this.mContinuousRun) {
                        ThreadDispatcher.getWorkThread().postDelayed(GpsManager.this.f48476E, 1000);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36323a(OSLocationWrapper oSLocationWrapper) {
        Iterator<GPSListener> it = this.f48480b.iterator();
        while (it.hasNext()) {
            it.next().onLocationChanged(oSLocationWrapper);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36320a(int i) {
        LocationManager locationManager = this.f48482e;
        if (locationManager != null) {
            try {
                if (locationManager.isProviderEnabled("gps")) {
                    if (i == 1) {
                        DLog.m36225d("gps event started");
                    } else if (i == 2) {
                        DLog.m36225d("gps event stopped");
                    } else if (i == 3) {
                        DLog.m36225d("gps event first fix");
                    } else if (i == 4 && !m36346e()) {
                        try {
                            this.f48483f = Utils.getTimeBoot();
                            this.f48486i = 0.0f;
                            GpsStatus gpsStatus = this.f48482e.getGpsStatus((GpsStatus) null);
                            this.f48485h = gpsStatus;
                            int maxSatellites = gpsStatus.getMaxSatellites();
                            Iterator<GpsSatellite> it = this.f48485h.getSatellites().iterator();
                            this.f48487j = 0;
                            this.f48489l = 0;
                            while (it.hasNext() && this.f48487j <= maxSatellites) {
                                GpsSatellite next = it.next();
                                this.f48486i += next.getSnr();
                                this.f48487j++;
                                if (next.usedInFix()) {
                                    this.f48489l++;
                                }
                            }
                            AccTimeFilterHelper.getInstance().setCurrentSatelliteNum(this.f48489l);
                            if (!m36348f()) {
                                this.f48484g = Utils.getTimeBoot();
                                DLog.m36225d("GpsManagergps satellite number:(" + this.f48489l + ")/" + this.f48487j + " level:" + this.f48486i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m36346e() {
        if (this.f48483f != 0 && Utils.getTimeBoot() - this.f48483f < 950) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private boolean m36348f() {
        if (this.f48484g != 0 && Utils.getTimeBoot() - this.f48484g < 10000) {
            return true;
        }
        return false;
    }

    public int getFixLocSatelliteNum() {
        if (Utils.getTimeBoot() - this.f48483f < 5000) {
            return this.f48489l;
        }
        return -1;
    }

    public float getGpsSignalLevel() {
        if (Utils.getTimeBoot() - this.f48483f < 5000) {
            return this.f48486i;
        }
        return -1.0f;
    }

    public int getLastGpsStatus() {
        return this.f48491n;
    }

    /* renamed from: g */
    private void m36349g() {
        if (this.f48481d != null && this.f48482e != null && this.f48490m) {
            try {
                m36354i();
                m36352h();
            } catch (Throwable th) {
                DLog.m36225d("destroy exception, " + th.getMessage());
            }
            m36359l();
            this.f48479a = null;
            this.f48482e = null;
            ThreadDispatcher.getWorkThread().removeCallbacks((Runnable) this.f48476E);
            mo121181b(this.f48494q);
            this.f48490m = false;
        }
    }

    /* renamed from: h */
    private void m36352h() {
        m36336b();
        m36355j();
        m36344d();
    }

    /* renamed from: i */
    private void m36354i() {
        this.f48482e.removeUpdates(this.f48473B);
    }

    /* renamed from: j */
    private void m36355j() {
        ThreadDispatcher.getWorkThread().removeCallbacks(this.f48501y);
    }

    public long getReceiveGpsSignalTime() {
        return this.f48502z;
    }

    public long getStartedTime() {
        return this.f48488k;
    }

    public synchronized void removeListenGps(GPSListener gPSListener) {
        this.f48480b.remove(gPSListener);
        if (this.f48480b.size() == 0) {
            m36349g();
        }
    }

    public synchronized void requestListenGps(GPSListener gPSListener) {
        if (this.f48480b.size() == 0) {
            m36319a();
        }
        this.f48480b.add(gPSListener);
    }

    public void reset() {
        if (this.f48480b.size() > 0) {
            m36349g();
            ThreadDispatcher.getWorkThread().postDelayed(new Runnable() {
                public void run() {
                    if (GpsManager.this.f48480b.size() > 0) {
                        DLog.m36225d("restart gps->start");
                        GpsManager.this.m36319a();
                    }
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36321a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                locationManager.requestLocationUpdates("passive", 1000, 0.0f, this.f48478G, ThreadDispatcher.getMainThread().getLooper());
                DLog.m36225d("GpsManager-->" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception | SecurityException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36337b(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.f48478G);
            } catch (Exception | SecurityException unused) {
            }
        }
    }

    public void requestSysPassiveListener(final Context context, final GPSListener gPSListener) {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                GpsManager.this.f48477F.add(gPSListener);
                if (GpsManager.this.f48477F.size() == 1) {
                    GpsManager.this.m36321a(context);
                }
            }
        });
    }

    public void removeSysPassiveListener(final Context context, final GPSListener gPSListener) {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                GpsManager.this.f48477F.remove(gPSListener);
                if (GpsManager.this.f48477F.size() == 0) {
                    GpsManager.this.m36337b(context);
                }
            }
        });
    }

    /* renamed from: k */
    private void m36358k() {
        try {
            if (this.f48482e != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    if (this.f48498v == null) {
                        this.f48498v = new GpsGNSSProcessor(this.f48482e);
                    }
                    this.f48498v.setOnGNSSDataListener(this.f48499w);
                    this.f48498v.start();
                    return;
                }
                this.f48482e.addGpsStatusListener(this.f48472A);
            }
        } catch (SecurityException e) {
            DLog.m36225d("GpsManagerstartGpsStatusMonitor: se: " + e.getMessage());
        } catch (Exception e2) {
            DLog.m36225d("GpsManagerstartGpsStatusMonitor: " + e2.getMessage());
        }
    }

    /* renamed from: l */
    private void m36359l() {
        try {
            if (this.f48482e != null) {
                if (Build.VERSION.SDK_INT < 24) {
                    this.f48482e.removeGpsStatusListener(this.f48472A);
                } else if (this.f48498v != null) {
                    this.f48498v.setOnGNSSDataListener((GpsGNSSProcessor.OnGNSSDataListener) null);
                    this.f48498v.stop();
                }
                this.f48491n = -1;
            }
        } catch (SecurityException e) {
            DLog.m36225d("GpsManagerstopGpsStatusMonitor: se: " + e.getMessage());
        } catch (Exception e2) {
            DLog.m36225d("GpsManagerstopGpsStatusMonitor: " + e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m36329a(String str, int i) {
        StatusBroadcastManager.getInstance().broadcastStatus(str, i);
    }
}
