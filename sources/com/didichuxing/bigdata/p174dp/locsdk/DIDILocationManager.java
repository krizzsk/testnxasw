package com.didichuxing.bigdata.p174dp.locsdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.mapbizinterface.MapBizInterface;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Config;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.biz.BizManager;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocCenter;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocationListenerWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocationStorage;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.ThreadDispatcher;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.utils.TraceUtils;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationManager */
public class DIDILocationManager implements IDIDILocationManager {

    /* renamed from: a */
    private static volatile DIDILocationManager f48337a = null;
    protected static String appid = "test";

    /* renamed from: c */
    private static Context f48338c = null;
    public static boolean enableMockLocation = false;
    protected static volatile long startstamp;

    /* renamed from: b */
    private final Object f48339b = new Object();

    /* renamed from: d */
    private boolean f48340d = false;

    /* renamed from: e */
    private LocCenter f48341e = null;

    /* renamed from: f */
    private HashSet<DIDILocationListener> f48342f;

    /* renamed from: g */
    private DIDILocationListener f48343g;

    /* renamed from: h */
    private DIDILocationUpdateOption f48344h;

    public String getBuildBranch() {
        return BuildConfig.BUILD_BRANCH;
    }

    public String getBuildVersion() {
        return BuildConfig.BUILD_VERSION;
    }

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam, int i) {
        return -1;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, String str, int i) {
        return -1;
    }

    @Deprecated
    public void setApolloToggleName(String str) {
    }

    public void setLogPath(File file) {
    }

    @Deprecated
    public void setTimeServiceImpl(Object obj) {
    }

    public void setUseFlp(boolean z) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36211a(DIDILocation dIDILocation) {
        HashSet<DIDILocationListener> hashSet = this.f48342f;
        if (hashSet != null) {
            Iterator<DIDILocationListener> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onLocationChanged(dIDILocation);
            }
        }
    }

    private DIDILocationManager(Context context) {
        f48338c = context.getApplicationContext();
        this.f48342f = new HashSet<>();
        this.f48343g = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                DIDILocationManager.this.m36211a(dIDILocation);
                DIDILocationManager.this.m36221b();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                DIDILocationManager.this.m36210a(i, errInfo);
                DIDILocationManager.this.m36221b();
            }
        };
        DIDILocationUpdateOption defaultLocationUpdateOption = getDefaultLocationUpdateOption();
        this.f48344h = defaultLocationUpdateOption;
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        BizManager.getIntance().init(context);
        MapBizInterface.getInstance().init(context);
        SystemUtil.init(context.getApplicationContext());
        DLog.m36225d("DIDILocationManager single instance constructed!!");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36210a(int i, ErrInfo errInfo) {
        HashSet<DIDILocationListener> hashSet = this.f48342f;
        if (hashSet != null) {
            Iterator<DIDILocationListener> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onLocationError(i, errInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36221b() {
        this.f48342f.clear();
        this.f48344h.setModuleKey((String) null);
        removeLocationUpdates(this.f48343g);
    }

    public static DIDILocationManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        f48338c = context.getApplicationContext();
        if (f48337a == null) {
            synchronized (DIDILocationManager.class) {
                if (f48337a == null) {
                    f48337a = new DIDILocationManager(f48338c);
                }
            }
        }
        return f48337a;
    }

    /* renamed from: a */
    private synchronized int m36208a(LocationListenerWrapper locationListenerWrapper) {
        if (Build.VERSION.SDK_INT < 9) {
            return 1;
        }
        startstamp = System.currentTimeMillis();
        DLog.m36225d("LocManager # startLocService called, locListener hash " + locationListenerWrapper.hashCode());
        DLog.m36225d("SDK VER : 1.1.016, BUILD : 202208121644");
        if (this.f48341e == null) {
            DLog.m36225d("startLocService: new mLocCenter");
            this.f48341e = new LocCenter(f48338c);
        }
        this.f48341e.start(locationListenerWrapper, appid);
        DIDILocBusinessHelper.getInstance().init(f48338c);
        this.f48340d = true;
        DLog.m36225d("-startLocService- : success!");
        return 0;
    }

    public void setPhonenum(String str) {
        TraceUtils.setPhone(f48338c, str);
    }

    /* renamed from: a */
    static Context m36209a() {
        return f48338c;
    }

    public void setAppVersionName(String str) {
        Utils.saveAppVersion(f48338c, str);
    }

    public void setAppid(String str) {
        appid = str;
    }

    /* renamed from: c */
    private void m36223c() {
        if (Build.VERSION.SDK_INT >= 9) {
            if (this.f48340d || this.f48341e != null) {
                DLog.m36225d("LocManager # stop loc service");
                LocCenter locCenter = this.f48341e;
                if (locCenter != null) {
                    locCenter.stop();
                }
                this.f48341e = null;
                DIDILocBusinessHelper.getInstance().destroy();
                this.f48340d = false;
                return;
            }
            DLog.m36225d("LocManager # loc service is not running");
        }
    }

    public String getAppid() {
        return appid;
    }

    public DIDILocation getLastKnownLocation() {
        return LocationStorage.getInstance().getLastKnownLocation();
    }

    public boolean isRunning() {
        return this.f48340d;
    }

    public int requestLocationUpdateOnce(final DIDILocationListener dIDILocationListener, final String str) {
        if (dIDILocationListener == null) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            final ErrInfo errInfo = new ErrInfo(202);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_MODULE_PERMISSION);
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    dIDILocationListener.onLocationError(202, errInfo);
                }
            });
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m36214a(dIDILocationListener, str);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36214a(DIDILocationListener dIDILocationListener, String str) {
        this.f48342f.add(dIDILocationListener);
        String moduleKey = this.f48344h.getModuleKey();
        if (!TextUtils.isEmpty(moduleKey)) {
            str = moduleKey + "|" + str;
        }
        this.f48344h.setModuleKey(str);
        m36213a(this.f48343g, this.f48344h);
    }

    public int requestLocationUpdates(final DIDILocationListener dIDILocationListener, final DIDILocationUpdateOption dIDILocationUpdateOption) {
        if (dIDILocationListener == null || dIDILocationUpdateOption == null) {
            return -1;
        }
        if (dIDILocationUpdateOption.getInterval() == DIDILocationUpdateOption.IntervalMode.SUPER_HIGH_FREQUENCY && !Utils.isOnViechleMounted(f48338c)) {
            dIDILocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        }
        if (TextUtils.isEmpty(dIDILocationUpdateOption.getModuleKey())) {
            final ErrInfo errInfo = new ErrInfo(202);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_MODULE_PERMISSION);
            ThreadDispatcher.getMainThread().post(new Runnable() {
                public void run() {
                    dIDILocationListener.onLocationError(202, errInfo);
                }
            });
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m36213a(dIDILocationListener, dIDILocationUpdateOption);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36213a(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption dIDILocationUpdateOption) {
        LocationListenerWrapper locationListenerWrapper = new LocationListenerWrapper(dIDILocationListener, dIDILocationUpdateOption);
        if (!this.f48340d || this.f48341e == null) {
            m36208a(locationListenerWrapper);
            return;
        }
        DIDILocation lastKnownLocation = LocationStorage.getInstance().getLastKnownLocation();
        if (lastKnownLocation == null || !lastKnownLocation.isEffective()) {
            if (this.f48341e.getLastErrInfo() != null) {
                dIDILocationListener.onLocationError(this.f48341e.getLastErrInfo().getErrNo(), this.f48341e.getLastErrInfo());
            }
        } else if (this.f48341e.getLastErrInfo() == null || this.f48341e.getLastErrInfo().getLocalTime() <= lastKnownLocation.getLocalTime()) {
            dIDILocationListener.onLocationChanged(lastKnownLocation);
        } else {
            dIDILocationListener.onLocationError(this.f48341e.getLastErrInfo().getErrNo(), this.f48341e.getLastErrInfo());
        }
        this.f48341e.addLocListener(locationListenerWrapper);
    }

    public int removeLocationUpdates(final DIDILocationListener dIDILocationListener) {
        if (dIDILocationListener == null) {
            return -1;
        }
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m36212a(dIDILocationListener);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36212a(DIDILocationListener dIDILocationListener) {
        if (this.f48340d && this.f48341e != null) {
            if (dIDILocationListener != this.f48343g || this.f48342f.size() <= 0) {
                this.f48341e.removeLocListener(dIDILocationListener);
                if (this.f48341e.getLocListenersLength() == 0 && this.f48342f.size() == 0) {
                    m36223c();
                }
            }
        }
    }

    public void removeAllListeners() {
        ThreadDispatcher.getMainThread().post(new Runnable() {
            public void run() {
                DIDILocationManager.this.m36224d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36224d() {
        if (ThreadDispatcher.getMainThread().isCurrentThread() && this.f48340d && this.f48341e != null) {
            m36221b();
            this.f48341e.removeAllLocListeners();
            m36223c();
        }
    }

    public void enableMockLocation(boolean z) {
        enableMockLocation = z;
        if (z) {
            DLog.m36225d("enable mock location:\n" + Log.getStackTraceString(new Exception()));
        }
    }

    public DIDILocationUpdateOption getDefaultLocationUpdateOption() {
        return new DIDILocationUpdateOption();
    }

    public int getGpsStatus() {
        int i = 0;
        int i2 = !SensorMonitor.getInstance(f48338c).isGpsEnabled() ? 256 : 0;
        if (Utils.checkSystemPermission(f48338c, Permission.ACCESS_FINE_LOCATION) != 0) {
            i = 512;
        }
        return i2 | i;
    }

    public int getWifiStatus() {
        int i = 0;
        int i2 = !SensorMonitor.getInstance(f48338c).isWifiEnabled() ? 16 : 0;
        int i3 = !Utils.isLocationPermissionGranted(f48338c) ? 32 : 0;
        if (Utils.isLocationSwitchOff(f48338c)) {
            i = 64;
        }
        return i2 | i3 | i;
    }

    public int getCellStatus() {
        int simState = ((TelephonyManager) f48338c.getSystemService("phone")).getSimState();
        int i = 0;
        int i2 = (simState == 0 || simState == 1) ? 0 : 1;
        if (!Utils.isLocationPermissionGranted(f48338c) && Build.VERSION.SDK_INT >= 23) {
            i = 2;
        }
        return (i2 ^ 1) | i;
    }

    public void setCoordinateType(int i) {
        if (this.f48340d) {
            DLog.m36225d("set coordinate type: " + i + " failed already ruuning");
        } else if (i == 1 || i == 0) {
            Utils.setCoordinateType(i);
            DLog.m36225d("set coordinate type success " + i);
        }
    }

    public String getListenersInfo() {
        LocCenter locCenter = this.f48341e;
        return locCenter != null ? locCenter.getListenersInfo() : "";
    }

    public synchronized int startNavLocate(DIDILocationListener dIDILocationListener, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Config.mNaviLocListener = dIDILocationListener;
        DIDILocationUpdateOption defaultLocationUpdateOption = getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey(str);
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
        defaultLocationUpdateOption.setDirectNotify(true);
        return requestLocationUpdates(dIDILocationListener, defaultLocationUpdateOption);
    }

    public synchronized void stopNavLocate() {
        removeLocationUpdates(Config.mNaviLocListener);
    }

    public boolean isHighAccuracyLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m36209a()) || Utils.getLocationSwitchLevel(m36209a()) != 3) {
            return false;
        }
        return true;
    }

    public boolean isGpsLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m36209a())) {
            return false;
        }
        int locationSwitchLevel = Utils.getLocationSwitchLevel(m36209a());
        if (locationSwitchLevel == 3 || locationSwitchLevel == 1) {
            return true;
        }
        return false;
    }

    public boolean isNetLocationAvailable() {
        if (!Utils.isLocationPermissionGranted(m36209a())) {
            return false;
        }
        int locationSwitchLevel = Utils.getLocationSwitchLevel(m36209a());
        if (locationSwitchLevel == 3 || locationSwitchLevel == 2) {
            return true;
        }
        return false;
    }

    public boolean isLocationSwitchOff() {
        return Utils.isLocationSwitchOff(f48338c);
    }

    public List<DIDILocation> getRecentLocation(int i) {
        return LocationStorage.getInstance().getRecentLocations(i);
    }

    public void setOnlyOSLocationAbroad(boolean z) {
        if (!this.f48340d) {
            Utils.setOnlyOSLocationAbroad(z);
        }
    }

    public void setLocatePermissonStrategy(Config.LocatePermissonStrategy locatePermissonStrategy) {
        DLog.m36225d("setLocatePermissonStrategy strategy=" + locatePermissonStrategy + " isRunning=" + this.f48340d);
        if (!this.f48340d && locatePermissonStrategy != null) {
            Config.sPermissionStrategy = locatePermissonStrategy;
        }
    }

    public void setLocateMode(Config.LocateMode locateMode) {
        if (ApolloProxy.getInstance().isAllowLowPowerGPSMode() && Config.getConigLocateMode() != locateMode) {
            Config.setLocateMode(locateMode);
            if (locateMode == Config.LocateMode.SAVE_GPS_POWER) {
                DLog.m36225d("set save GPS mode:\n" + Log.getStackTraceString(new Exception()));
            }
        }
    }
}
