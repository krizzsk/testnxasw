package com.didi.foundation.sdk.location;

import android.content.Context;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.ApplicationService;
import com.didi.sdk.logging.Logger;
import com.didi.soda.andy.tools.LogUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Config;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;

@ServiceProvider({LocationServiceProvider.class})
public class LocationPerformerImpl implements LocationServiceProvider {

    /* renamed from: a */
    private static final String f23067a = "LocationPerformerImpl";

    /* renamed from: b */
    private static boolean f23068b = false;

    /* renamed from: c */
    private Logger f23069c = LogService.getLogger((Class<?>) LocationPerformerImpl.class);

    /* renamed from: d */
    private DIDILocationManager f23070d;

    /* renamed from: e */
    private DIDILocationUpdateOption f23071e;

    /* renamed from: f */
    private MonitorLocationListener f23072f = new MonitorLocationListener();

    /* renamed from: g */
    private String f23073g;

    /* renamed from: h */
    private Config.LocateMode f23074h;

    /* renamed from: i */
    private DIDILocationUpdateOption.IntervalMode f23075i;

    /* renamed from: j */
    private int f23076j = 0;

    public DIDILocation getLastKnownLocation() {
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager == null) {
            return null;
        }
        return dIDILocationManager.getLastKnownLocation();
    }

    public double getLatitude() {
        if (getLastKnownLocation() != null) {
            return getLastKnownLocation().getLatitude();
        }
        return 0.0d;
    }

    public double getLongitude() {
        if (getLastKnownLocation() != null) {
            return getLastKnownLocation().getLongitude();
        }
        return 0.0d;
    }

    public LocationServiceProvider registerLocationListener(BaseLocationListener baseLocationListener) {
        this.f23072f.add(baseLocationListener);
        return this;
    }

    public void requestOnceLocation(DIDILocationListener dIDILocationListener) {
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager != null) {
            dIDILocationManager.requestLocationUpdateOnce(dIDILocationListener, this.f23073g);
        }
    }

    public LocationServiceProvider setInterval(DIDILocationUpdateOption.IntervalMode intervalMode) {
        if (intervalMode == null) {
            return this;
        }
        this.f23075i = intervalMode;
        return this;
    }

    public LocationServiceProvider setLocateMode(Config.LocateMode locateMode) {
        if (locateMode == null) {
            return this;
        }
        this.f23074h = locateMode;
        return this;
    }

    public LocationServiceProvider setCoordinateType(int i) {
        this.f23076j = i;
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager != null) {
            if (dIDILocationManager.isRunning()) {
                Logger logger = this.f23069c;
                logger.error(LogUtils.getLineText("⚠️setCoordinateType() called with: type = [" + i + "] fail LocationManager isRunning"), new Object[0]);
            } else {
                this.f23070d.setCoordinateType(this.f23076j);
            }
        }
        return this;
    }

    public LocationServiceProvider setLogPath(File file) {
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager != null) {
            dIDILocationManager.setLogPath(file);
        }
        return this;
    }

    public LocationServiceProvider startLocation(Context context) {
        LogUtils.m31181t(f23067a, "⚠️startLocation() called with: context = [" + context + Const.jaRight);
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager != null && dIDILocationManager.isRunning()) {
            return this;
        }
        if (this.f23070d == null) {
            this.f23069c.error(LogUtils.getLineText("⚠️ startLocation() called with: mLocationManager == null"), new Object[0]);
            initLocationManager(context);
        }
        int requestLocationUpdates = this.f23070d.requestLocationUpdates(this.f23072f, this.f23071e);
        Logger logger = this.f23069c;
        logger.debug("code: " + requestLocationUpdates, new Object[0]);
        return this;
    }

    public LocationServiceProvider stopLocation() {
        LogUtils.m31173d(f23067a, "⚠️stopLocation() called");
        DIDILocationManager dIDILocationManager = this.f23070d;
        if (dIDILocationManager != null) {
            dIDILocationManager.removeLocationUpdates(this.f23072f);
        }
        return this;
    }

    public LocationServiceProvider enableMock(boolean z) {
        f23068b = z;
        DIDILocationManager.getInstance(FoundationApplicationListener.getApplication()).enableMockLocation(z);
        return this;
    }

    public boolean isMockEnabled() {
        return f23068b;
    }

    public LocationServiceProvider unRegisterLocationListener(BaseLocationListener baseLocationListener) {
        this.f23072f.remove(baseLocationListener);
        return this;
    }

    public void initLocationManager(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        this.f23070d = instance;
        this.f23071e = instance.getDefaultLocationUpdateOption();
        this.f23073g = context.getPackageName();
        DIDILocationUpdateOption.IntervalMode intervalMode = this.f23075i;
        if (intervalMode != null) {
            this.f23071e.setInterval(intervalMode);
        } else {
            this.f23071e.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
        }
        Config.LocateMode locateMode = this.f23074h;
        if (locateMode != null) {
            this.f23070d.setLocateMode(locateMode);
        }
        this.f23071e.setModuleKey(ApplicationService.getInstance().getVersionName());
        this.f23071e.setModuleKey(this.f23073g);
        this.f23070d.setAppVersionName(ApplicationService.getInstance().getVersionName());
        try {
            this.f23070d.setPhonenum(AccountService.getInstance().getPhone());
        } catch (Exception e) {
            Logger logger = this.f23069c;
            logger.info(LogUtils.getLineText("⚠️initLocationManager() called with: context = [" + context + Const.jaRight), (Throwable) e);
        }
        this.f23070d.setAppid(this.f23073g);
        this.f23070d.setCoordinateType(this.f23076j);
    }
}
