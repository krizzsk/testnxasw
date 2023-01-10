package com.didi.map.global.rpc.util;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SatelliteManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f29886a = SatelliteManager.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f29887b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private static volatile SatelliteManager f29888d;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f29889c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LocationManager f29890e;

    /* renamed from: f */
    private LocationListener f29891f;

    /* renamed from: g */
    private GpsStatus.Listener f29892g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnSatelliteStatusChangedListener f29893h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f29894i = 3000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f29895j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<GpsSatellite> f29896k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Location f29897l;

    public interface OnSatelliteStatusChangedListener {
        void onSatelliteStatusChanged(List<GpsSatellite> list, Location location);
    }

    public static SatelliteManager getInstance(Context context) {
        if (f29888d == null) {
            synchronized (SatelliteManager.class) {
                if (f29888d == null) {
                    f29888d = new SatelliteManager(context);
                }
            }
        }
        return f29888d;
    }

    private SatelliteManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f29889c = applicationContext;
        this.f29890e = (LocationManager) applicationContext.getSystemService("location");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m23142d() {
        return Apollo.getToggle("android_passenger_global_base_lib_satellite_info_toggle").allow();
    }

    public boolean isGPSEnabled() {
        LocationManager locationManager = this.f29890e;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public void setIntervalMilliseconds(long j) {
        this.f29894i = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public LocationListener m23144e() {
        if (this.f29891f == null) {
            this.f29891f = new LocationListener() {
                public void onLocationChanged(Location location) {
                    String a = SatelliteManager.f29886a;
                    SystemUtils.log(3, a, "卫星定位经度：" + location.getLongitude(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 81);
                    String a2 = SatelliteManager.f29886a;
                    SystemUtils.log(3, a2, "卫星定位纬度：" + location.getLatitude(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 82);
                    String a3 = SatelliteManager.f29886a;
                    SystemUtils.log(3, a3, "卫星定位时间：" + location.getTime(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 83);
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                    SystemUtils.log(3, SatelliteManager.f29886a, "onStatusChanged()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 89);
                }

                public void onProviderEnabled(String str) {
                    SystemUtils.log(3, SatelliteManager.f29886a, "onProviderEnabled()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 95);
                }

                public void onProviderDisabled(String str) {
                    SystemUtils.log(3, SatelliteManager.f29886a, "onProviderDisabled()", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$1", 101);
                }
            };
        }
        return this.f29891f;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public GpsStatus.Listener m23146f() {
        if (this.f29892g == null) {
            this.f29892g = new GpsStatus.Listener() {
                public void onGpsStatusChanged(int i) {
                    if (i == 1) {
                        SystemUtils.log(3, SatelliteManager.f29886a, "GPS_EVENT_STARTED", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 115);
                    } else if (i == 2) {
                        SystemUtils.log(3, SatelliteManager.f29886a, "GPS_EVENT_STOPPED", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 118);
                    } else if (i == 3) {
                        SystemUtils.log(3, SatelliteManager.f29886a, "GPS_EVENT_FIRST_FIX", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 121);
                    } else if (i == 4) {
                        SystemUtils.log(3, SatelliteManager.f29886a, "GPS_EVENT_SATELLITE_STATUS", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$2", 124);
                        SatelliteManager satelliteManager = SatelliteManager.this;
                        List unused = satelliteManager.f29896k = satelliteManager.m23147g();
                        SatelliteManager satelliteManager2 = SatelliteManager.this;
                        Location unused2 = satelliteManager2.f29897l = satelliteManager2.f29890e.getLastKnownLocation("gps");
                        if (SatelliteManager.this.f29893h != null) {
                            SatelliteManager.f29887b.post(new Runnable() {
                                public void run() {
                                    SatelliteManager.this.f29893h.onSatelliteStatusChanged(SatelliteManager.this.f29896k, SatelliteManager.this.f29897l);
                                }
                            });
                        }
                    }
                }
            };
        }
        return this.f29892g;
    }

    public boolean isRunning() {
        return this.f29895j;
    }

    public void start() {
        SystemUtils.log(5, f29886a, "start() is called", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 148);
        new Thread(new Runnable() {
            public void run() {
                if (!SatelliteManager.m23142d()) {
                    SystemUtils.log(6, SatelliteManager.f29886a, "isSatelliteInfoToggleEnabled() = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 153);
                } else if (!SatelliteManager.this.isGPSEnabled()) {
                    SystemUtils.log(6, SatelliteManager.f29886a, "isGPSEnabled() = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 158);
                } else if (!PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f29889c)) {
                    SystemUtils.log(6, SatelliteManager.f29886a, "isLocationPermissionsGranted(mContext) = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 163);
                } else if (SatelliteManager.this.f29895j) {
                    SystemUtils.log(5, SatelliteManager.f29886a, "isRunning = true", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager$3", 168);
                } else {
                    boolean unused = SatelliteManager.this.f29895j = true;
                    Looper.prepare();
                    SatelliteManager.this.f29890e.addGpsStatusListener(SatelliteManager.this.m23146f());
                    SatelliteManager.this.f29890e.requestLocationUpdates("gps", SatelliteManager.this.f29894i, 1.0f, SatelliteManager.this.m23144e());
                    Looper.loop();
                }
            }
        }).start();
    }

    public void stop() {
        SystemUtils.log(5, f29886a, "stop() is called", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 182);
        if (!this.f29895j) {
            SystemUtils.log(5, f29886a, "isRunning = false", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 184);
            return;
        }
        this.f29895j = false;
        LocationManager locationManager = this.f29890e;
        if (locationManager != null) {
            GpsStatus.Listener listener = this.f29892g;
            if (listener != null) {
                locationManager.removeGpsStatusListener(listener);
                this.f29892g = null;
            }
            LocationListener locationListener = this.f29891f;
            if (locationListener != null) {
                this.f29890e.removeUpdates(locationListener);
                this.f29891f = null;
            }
        }
        this.f29896k = null;
        this.f29897l = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public List<GpsSatellite> m23147g() {
        LocationManager locationManager = this.f29890e;
        if (locationManager == null) {
            SystemUtils.log(6, f29886a, "getGpsSatellites() mLocationManager == null", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 206);
            return null;
        }
        try {
            GpsStatus gpsStatus = locationManager.getGpsStatus((GpsStatus) null);
            int maxSatellites = gpsStatus.getMaxSatellites();
            if (maxSatellites <= 0) {
                return null;
            }
            String str = f29886a;
            SystemUtils.log(3, str, "FirstFixTime: " + gpsStatus.getTimeToFirstFix(), (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 214);
            Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
            int i = 0;
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && i <= maxSatellites) {
                GpsSatellite next = it.next();
                if (next != null) {
                    i++;
                    arrayList.add(next);
                }
            }
            String str2 = f29886a;
            SystemUtils.log(3, str2, "count: " + i, (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 226);
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GpsSatellite> getLastSatellites() {
        return this.f29896k;
    }

    public Location getLastLocation() {
        return this.f29897l;
    }

    public static class SatelliteInfo {
        public int almanac;
        public float azimuth;
        public float elevation;
        public int ephemeris;
        public int prn;
        public float snr;
        public int use;

        public SatelliteInfo(GpsSatellite gpsSatellite) {
            this.azimuth = gpsSatellite.getAzimuth();
            this.elevation = gpsSatellite.getElevation();
            this.snr = gpsSatellite.getSnr();
            this.prn = gpsSatellite.getPrn();
            this.almanac = gpsSatellite.hasAlmanac() ? 1 : 0;
            this.ephemeris = gpsSatellite.hasEphemeris() ? 1 : 0;
            this.use = gpsSatellite.usedInFix() ? 1 : 0;
        }
    }

    public String getLastSatellitesInfo() {
        String str = null;
        if (CollectionUtil.isEmpty((Collection<?>) this.f29896k)) {
            SystemUtils.log(6, f29886a, "CollectionUtil.isEmpty(mSatellites)", (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 264);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GpsSatellite next : this.f29896k) {
            if (next != null) {
                arrayList.add(new SatelliteInfo(next));
            }
        }
        try {
            str = new Gson().toJson((Object) arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null) {
            return "";
        }
        SystemUtils.log(3, f29886a, str, (Throwable) null, "com.didi.map.global.rpc.util.SatelliteManager", 286);
        return str;
    }

    public void setOnSatelliteStatusChangedListener(OnSatelliteStatusChangedListener onSatelliteStatusChangedListener) {
        this.f29893h = onSatelliteStatusChangedListener;
    }
}
