package com.didi.map.global.flow.toolkit.sctx;

import android.content.Context;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.List;

public class DriverSctx extends AbsComponent<DriverSctxParam> {

    /* renamed from: a */
    private static final String f29738a = "DriverSctx";

    /* renamed from: b */
    private Context f29739b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f29740c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DIDILocationListener f29741d;

    /* renamed from: e */
    private DriverSctxService f29742e;

    /* renamed from: f */
    private boolean f29743f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f29744g;

    /* renamed from: h */
    private DIDILocationListener f29745h = new DIDILocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            if (!DriverSctx.this.f29744g && dIDILocation != null) {
                DLog.m10773d(DriverSctx.f29738a, "onLocationChanged %s", dIDILocation.toString());
                DIDILocation unused = DriverSctx.this.f29740c = dIDILocation;
                DriverSctx.this.onLocationChanged(dIDILocation, DIDILocBusinessHelper.getInstance().getRecentLocations(20));
                if (DriverSctx.this.f29741d != null) {
                    DriverSctx.this.f29741d.onLocationChanged(dIDILocation);
                }
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (!DriverSctx.this.f29744g && DriverSctx.this.f29741d != null) {
                DriverSctx.this.f29741d.onLocationError(i, errInfo);
            }
        }

        public void onStatusUpdate(String str, int i, String str2) {
            if (!DriverSctx.this.f29744g && DriverSctx.this.f29741d != null) {
                DriverSctx.this.f29741d.onStatusUpdate(str, i, str2);
            }
        }
    };

    public DriverSctx(DriverSctxParam driverSctxParam) {
        DLog.m10773d(f29738a, "new: %s", driverSctxParam.toString());
        this.f29739b = driverSctxParam.getApplicationContext();
        this.f29741d = driverSctxParam.locationListener;
        Context context = this.f29739b;
        if (context != null) {
            this.f29742e = new DriverSctxService(context, driverSctxParam);
        }
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f29739b);
        this.f29740c = lastKnownLocation;
        if (lastKnownLocation != null) {
            onLocationChanged(lastKnownLocation, DIDILocBusinessHelper.getInstance().getRecentLocations(20));
        }
        LocationHelper.registerListener(this.f29739b, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f29745h);
    }

    public void update(DriverSctxParam driverSctxParam) {
        super.update(driverSctxParam);
        DLog.m10773d(f29738a, "update: %s", driverSctxParam.toString());
        this.f29741d = driverSctxParam.locationListener;
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.update(driverSctxParam);
        }
        this.f29743f = false;
        this.f29744g = false;
    }

    public void setBestViewMapElements(List<IMapElement> list) {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.setBestViewMapElements(list);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.onNewMargin(i, i2, i3, i4);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.setCameraMode(cameraMode);
        }
    }

    public void followMyLocation(boolean z) {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.followMyLocation(z);
        }
    }

    public void zoomToNav() {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.zoomToNav();
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation, List<DIDILocation> list) {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService == null) {
            return;
        }
        if (!this.f29743f) {
            DLog.m10773d(f29738a, "start", new Object[0]);
            this.f29742e.start(LocationHelper.DIDILocation2GpsLocation(dIDILocation));
            this.f29743f = true;
            return;
        }
        driverSctxService.onLocationChanged(dIDILocation, list);
    }

    public Marker getCarMarker() {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            return driverSctxService.getCarMarker();
        }
        return null;
    }

    public List<IMapElement> getLine() {
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            return driverSctxService.getLine();
        }
        return new ArrayList();
    }

    public void onMapVisible(boolean z) {
        DLog.m10773d(f29738a, "onMapVisible: %d", Boolean.valueOf(z));
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.onMapVisible(z);
        }
    }

    public void stop() {
        DLog.m10773d(f29738a, "stop", new Object[0]);
        this.f29744g = true;
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.stop();
        }
    }

    public void destroy() {
        DLog.m10773d(f29738a, "destroy", new Object[0]);
        LocationHelper.unRegisterListener(this.f29739b, this.f29745h);
        this.f29741d = null;
        this.f29744g = true;
        DriverSctxService driverSctxService = this.f29742e;
        if (driverSctxService != null) {
            driverSctxService.stop();
            this.f29742e.destroy();
        }
    }
}
