package com.sdk.poibase.util;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sdk.poibase.util.BaseGpsStatusHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SatelliteManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f58775a = SatelliteManager.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f58776b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private static volatile SatelliteManager f58777d;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f58778c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BaseGpsStatusHelper f58779e;

    /* renamed from: f */
    private BaseGpsStatusHelper.IGpsStatusChanged f58780f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LocationManager f58781g;

    /* renamed from: h */
    private LocationListener f58782h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnSatelliteStatusChangedListener f58783i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f58784j = 3000;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f58785k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<GpsSatellite> f58786l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Location f58787m;

    public interface OnSatelliteStatusChangedListener {
        void onSatelliteStatusChanged(List<GpsSatellite> list, Location location);
    }

    public static SatelliteManager getInstance(Context context) {
        if (f58777d == null) {
            synchronized (SatelliteManager.class) {
                if (f58777d == null) {
                    f58777d = new SatelliteManager(context);
                }
            }
        }
        return f58777d;
    }

    private SatelliteManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f58778c = applicationContext;
        this.f58781g = (LocationManager) applicationContext.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.f58779e = new GpsStatusHelperN(this.f58781g);
        } else {
            this.f58779e = new GpsStatusHelperOlder(this.f58781g);
        }
    }

    public boolean isGPSEnabled() {
        LocationManager locationManager = this.f58781g;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps");
        }
        return false;
    }

    public void setIntervalMilliseconds(long j) {
        this.f58784j = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LocationListener m44456c() {
        if (this.f58782h == null) {
            this.f58782h = new LocationListener() {
                public void onLocationChanged(Location location) {
                }

                public void onProviderDisabled(String str) {
                }

                public void onProviderEnabled(String str) {
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                }
            };
        }
        return this.f58782h;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public BaseGpsStatusHelper.IGpsStatusChanged m44458d() {
        if (this.f58780f == null) {
            this.f58780f = new BaseGpsStatusHelper.IGpsStatusChanged() {
                public void onFirstFix() {
                }

                public void onStarted() {
                    SystemUtils.log(3, SatelliteManager.f58775a, "GPS_EVENT_STARTED", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$2", 109);
                }

                public void onStopped() {
                    SystemUtils.log(3, SatelliteManager.f58775a, "GPS_EVENT_STOPPED", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$2", 114);
                }

                public void onSatelliteStatusChanged() {
                    SatelliteManager satelliteManager = SatelliteManager.this;
                    List unused = satelliteManager.f58786l = satelliteManager.m44461e();
                    SatelliteManager satelliteManager2 = SatelliteManager.this;
                    Location unused2 = satelliteManager2.f58787m = satelliteManager2.f58781g.getLastKnownLocation("gps");
                    if (SatelliteManager.this.f58783i != null) {
                        SatelliteManager.f58776b.post(new Runnable() {
                            public void run() {
                                SatelliteManager.this.f58783i.onSatelliteStatusChanged(SatelliteManager.this.f58786l, SatelliteManager.this.f58787m);
                            }
                        });
                    }
                }
            };
        }
        return this.f58780f;
    }

    public boolean isRunning() {
        return this.f58785k;
    }

    public void start() {
        SystemUtils.log(5, f58775a, "start() is called", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 145);
        new Thread(new Runnable() {
            public void run() {
                if (!SatelliteManager.this.isGPSEnabled()) {
                    SystemUtils.log(6, SatelliteManager.f58775a, "isGPSEnabled() = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 150);
                } else if (!PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f58778c)) {
                    SystemUtils.log(6, SatelliteManager.f58775a, "isLocationPermissionsGranted(mContext) = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 155);
                } else if (SatelliteManager.this.f58785k) {
                    SystemUtils.log(5, SatelliteManager.f58775a, "isRunning = true", (Throwable) null, "com.sdk.poibase.util.SatelliteManager$3", 160);
                } else if (PermissionUtil.isLocationPermissionsGranted(SatelliteManager.this.f58778c)) {
                    boolean unused = SatelliteManager.this.f58785k = true;
                    Looper.prepare();
                    SatelliteManager.this.f58779e.registerGpsStatusListener(SatelliteManager.this.m44458d());
                    SatelliteManager.this.f58781g.requestLocationUpdates("gps", SatelliteManager.this.f58784j, 1.0f, SatelliteManager.this.m44456c());
                    Looper.loop();
                }
            }
        }).start();
    }

    public void stop() {
        SystemUtils.log(5, f58775a, "stop() is called", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 176);
        if (!this.f58785k) {
            SystemUtils.log(5, f58775a, "isRunning = false", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 178);
            return;
        }
        this.f58785k = false;
        if (this.f58781g != null) {
            BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged = this.f58780f;
            if (iGpsStatusChanged != null) {
                this.f58779e.unRegisterGpsStatusListener(iGpsStatusChanged);
                this.f58780f = null;
            }
            LocationListener locationListener = this.f58782h;
            if (locationListener != null) {
                this.f58781g.removeUpdates(locationListener);
                this.f58782h = null;
            }
        }
        this.f58786l = null;
        this.f58787m = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<GpsSatellite> m44461e() {
        LocationManager locationManager = this.f58781g;
        if (locationManager == null) {
            SystemUtils.log(6, f58775a, "getGpsSatellites() mLocationManager == null", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 200);
            return null;
        }
        try {
            GpsStatus gpsStatus = locationManager.getGpsStatus((GpsStatus) null);
            int maxSatellites = gpsStatus.getMaxSatellites();
            if (maxSatellites <= 0) {
                return null;
            }
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
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GpsSatellite> getLastSatellites() {
        return this.f58786l;
    }

    public Location getLastLocation() {
        return this.f58787m;
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
        try {
            if (CollectionUtil.isEmpty((Collection<?>) this.f58786l)) {
                SystemUtils.log(6, f58775a, "CollectionUtil.isEmpty(mSatellites)", (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 257);
                return null;
            }
            JsonArray jsonArray = new JsonArray();
            for (GpsSatellite next : this.f58786l) {
                if (next != null) {
                    jsonArray.add((JsonElement) m44449a(next));
                }
            }
            String jsonArray2 = jsonArray.toString();
            SystemUtils.log(3, f58775a, jsonArray2, (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 269);
            return jsonArray2;
        } catch (Exception e) {
            SystemUtils.log(3, f58775a, e.getMessage(), (Throwable) null, "com.sdk.poibase.util.SatelliteManager", 273);
            return "";
        }
    }

    /* renamed from: a */
    private static JsonObject m44449a(GpsSatellite gpsSatellite) {
        JsonObject jsonObject = new JsonObject();
        if (gpsSatellite != null) {
            jsonObject.addProperty("ephemeris", (Number) Integer.valueOf(gpsSatellite.hasEphemeris() ? 1 : 0));
            jsonObject.addProperty("almanac", (Number) Integer.valueOf(gpsSatellite.hasAlmanac() ? 1 : 0));
            jsonObject.addProperty("prn", (Number) Integer.valueOf(gpsSatellite.getPrn()));
            jsonObject.addProperty("snr", (Number) Float.valueOf(gpsSatellite.getSnr()));
            jsonObject.addProperty("elevation", (Number) Float.valueOf(gpsSatellite.getElevation()));
            jsonObject.addProperty("azimuth", (Number) Float.valueOf(gpsSatellite.getAzimuth()));
            jsonObject.addProperty("use", (Number) Integer.valueOf(gpsSatellite.usedInFix() ? 1 : 0));
        }
        return jsonObject;
    }

    public void setOnSatelliteStatusChangedListener(OnSatelliteStatusChangedListener onSatelliteStatusChangedListener) {
        this.f58783i = onSatelliteStatusChangedListener;
    }
}
