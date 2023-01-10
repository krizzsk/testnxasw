package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.FLPDiffInfoGetter;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocConfessor;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter.AccTimeFilter;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter.AccTimeFilterHelper;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator.GoogleFusionFilter;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator.IFLPLocator;
import com.didichuxing.bigdata.p174dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.utils.LocExceptionTracker;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.b */
/* compiled from: GlobalLocationStrategy */
class C15952b implements C15953c {

    /* renamed from: a */
    private static final String f48583a = "GlobalLocationStrategy";

    /* renamed from: b */
    private final Context f48584b;

    /* renamed from: c */
    private OSNLPManager f48585c;

    /* renamed from: d */
    private IFLPLocator f48586d;

    /* renamed from: e */
    private WifiManagerWrapper f48587e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LocationUpdateInternalListener f48588f;

    /* renamed from: g */
    private volatile boolean f48589g = false;

    /* renamed from: h */
    private GpsManagerWrapper f48590h;

    /* renamed from: i */
    private GoogleFusionFilter f48591i;

    /* renamed from: j */
    private AccTimeFilter f48592j;

    /* renamed from: a */
    public void mo121173a(long j) {
    }

    /* renamed from: a */
    public void mo121177a(StringBuilder sb) {
    }

    /* renamed from: b */
    public void mo121178b(long j) {
    }

    public C15952b(Context context) {
        this.f48584b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo121176a(String str) {
        m36455d();
        OSNLPManager instance = OSNLPManager.getInstance();
        this.f48585c = instance;
        instance.mo121133a(this.f48584b);
        this.f48585c.mo121132a();
        m36453b();
        GpsManager.getInstance().init(this.f48584b);
        if (ApolloProxy.getInstance().isAlwaysScanWifiAllowed()) {
            WifiManagerWrapper instance2 = WifiManagerWrapper.getInstance();
            this.f48587e = instance2;
            instance2.init(this.f48584b);
        }
        CellManager.getInstance().init(this.f48584b);
        CellManager.getInstance().getCellLocation();
        this.f48589g = true;
    }

    /* renamed from: a */
    public void mo121172a() {
        IFLPLocator iFLPLocator = this.f48586d;
        if (iFLPLocator != null) {
            iFLPLocator.destroy();
        }
        OSNLPManager oSNLPManager = this.f48585c;
        if (oSNLPManager != null) {
            oSNLPManager.mo121134b();
            this.f48585c = null;
        }
        WifiManagerWrapper wifiManagerWrapper = this.f48587e;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.destroy();
            this.f48587e = null;
        }
        CellManager.getInstance().destroy();
        GoogleFusionFilter googleFusionFilter = this.f48591i;
        if (googleFusionFilter != null) {
            googleFusionFilter.destroy();
            this.f48591i = null;
        }
        AccTimeFilter accTimeFilter = this.f48592j;
        if (accTimeFilter != null) {
            accTimeFilter.destroy();
            this.f48592j = null;
        }
        m36454c();
        this.f48588f = null;
        this.f48589g = false;
    }

    /* renamed from: b */
    private void m36453b() {
        GpsManagerWrapper instance = GpsManagerWrapper.getInstance();
        this.f48590h = instance;
        instance.init(this.f48584b);
        this.f48590h.requestLocationUpdates(this.f48588f);
    }

    /* renamed from: c */
    private void m36454c() {
        GpsManagerWrapper gpsManagerWrapper = this.f48590h;
        if (gpsManagerWrapper != null) {
            gpsManagerWrapper.removeLocationUpdates(this.f48588f);
            this.f48590h = null;
        }
    }

    /* renamed from: a */
    public void mo121174a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback) {
        m36451a(retrieveLocationCallback, 0);
    }

    /* renamed from: a */
    private void m36451a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, long j) {
        IFLPLocator iFLPLocator = this.f48586d;
        DIDILocation dIDILocation = null;
        DIDILocation fLPLocation = iFLPLocator != null ? iFLPLocator.getFLPLocation() : null;
        OSNLPManager oSNLPManager = this.f48585c;
        OSLocationWrapper originNLPLocation = oSNLPManager != null ? oSNLPManager.getOriginNLPLocation() : null;
        GpsManagerWrapper gpsManagerWrapper = this.f48590h;
        DIDILocation gpsLocation = gpsManagerWrapper != null ? gpsManagerWrapper.getGpsLocation() : null;
        GpsManagerWrapper gpsManagerWrapper2 = this.f48590h;
        DIDILocation lastGpsLocation = gpsManagerWrapper2 != null ? gpsManagerWrapper2.getLastGpsLocation() : null;
        if (AccTimeFilterHelper.getInstance().shouldUseThisFilter()) {
            if (this.f48592j == null) {
                this.f48592j = new AccTimeFilter(this.f48584b);
            }
            dIDILocation = this.f48592j.getTargetLocation(fLPLocation, originNLPLocation, gpsLocation, lastGpsLocation);
        } else if (ETraceSource.googleflp == FLPDiffInfoGetter.getInstance().getInfoSource()) {
            if (this.f48591i == null) {
                this.f48591i = new GoogleFusionFilter();
            }
            dIDILocation = this.f48591i.getTargetLocation(fLPLocation, originNLPLocation, gpsLocation, lastGpsLocation);
        } else if (fLPLocation != null) {
            dIDILocation = fLPLocation;
        } else if (originNLPLocation != null) {
            dIDILocation = DIDILocation.loadFromSystemLoc(originNLPLocation, ETraceSource.nlp, Utils.getCoordinateType());
        } else if (gpsLocation != null) {
            dIDILocation = gpsLocation;
        } else if (lastGpsLocation != null) {
            dIDILocation = lastGpsLocation;
        }
        if (dIDILocation != null) {
            m36449a(dIDILocation, j);
            m36452a(retrieveLocationCallback, dIDILocation);
            return;
        }
        ErrInfo e = m36456e();
        m36450a(retrieveLocationCallback, e.getErrNo(), e);
    }

    /* renamed from: a */
    public void mo121175a(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48588f = locationUpdateInternalListener;
    }

    /* renamed from: d */
    private void m36455d() {
        try {
            IFLPLocator iFLPLocator = (IFLPLocator) ServiceLoader.load(IFLPLocator.class).get();
            this.f48586d = iFLPLocator;
            if (iFLPLocator == null) {
                DLog.m36225d("GlobalLocationStrategyflp locator init NULL!");
                return;
            }
            iFLPLocator.setLocationListener(new GlobalLocationStrategy$1(this));
            this.f48586d.init(this.f48584b, 1000);
        } catch (Throwable th) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker instance = LocExceptionTracker.getInstance();
                instance.trackInnerException(7, "Other_" + th.getClass().getCanonicalName());
            }
            DLog.m36225d("GlobalLocationStrategyinit flp exception: " + th.getMessage() + ", " + th.getClass() + th.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private void m36452a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, DIDILocation dIDILocation) {
        if (this.f48589g) {
            LocNTPHelper.adjustLocTimestampWhenDispatch(dIDILocation);
            retrieveLocationCallback.onLocationChanged(dIDILocation);
        }
    }

    /* renamed from: a */
    private void m36450a(LocConfessor.RetrieveLocationCallback retrieveLocationCallback, int i, ErrInfo errInfo) {
        if (this.f48589g) {
            retrieveLocationCallback.onLocationError(i, errInfo);
        }
    }

    /* renamed from: e */
    private ErrInfo m36456e() {
        ErrInfo errInfo = new ErrInfo();
        if (!Utils.isLocationPermissionGranted(this.f48584b) || !SensorMonitor.getInstance(this.f48584b).isGpsEnabled()) {
            errInfo.setErrNo(101);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_LOCATION_PERMISSION);
        } else if (!NetUtils.isNetWorkConnected(this.f48584b)) {
            errInfo.setErrNo(301);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NETWORK_CONNECTION);
        } else {
            errInfo.setErrNo(1000);
            errInfo.setErrMessage("其他原因引起的定位失败。");
        }
        return errInfo;
    }

    /* renamed from: a */
    private static void m36449a(DIDILocation dIDILocation, long j) {
        if (dIDILocation != null && dIDILocation.getExtra() != null) {
            dIDILocation.getExtra().putLong(DIDILocation.EXTRA_KEY_STRATEGY_FLAGS, j);
        }
    }
}
