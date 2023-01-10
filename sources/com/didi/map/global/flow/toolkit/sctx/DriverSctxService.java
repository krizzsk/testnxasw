package com.didi.map.global.flow.toolkit.sctx;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.external.CommonNavigator;
import com.didi.map.sdk.sharetrack.external.INavigator;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.List;

public class DriverSctxService {

    /* renamed from: a */
    private static final String f29746a = "DriverSctxService";

    /* renamed from: b */
    private Context f29747b;

    /* renamed from: c */
    private MapView f29748c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DriverSctxParam f29749d;

    /* renamed from: e */
    private LatLng f29750e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public INavigator f29751f;

    /* renamed from: g */
    private CameraMode f29752g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f29753h;

    /* renamed from: i */
    private List<IMapElement> f29754i;

    /* renamed from: j */
    private int f29755j;

    /* renamed from: k */
    private int f29756k;

    /* renamed from: l */
    private int f29757l;

    /* renamed from: m */
    private int f29758m;

    /* renamed from: n */
    private final INavigationCallback f29759n = new INavigationCallback() {
        public void onApproaching(int i) {
        }

        public void onCameraModeChanged(CameraMode cameraMode) {
        }

        public void onDriveAway() {
        }

        public void onNaviVoice(String str, int i) {
        }

        public void onNavigationCodeUpdate(int i) {
        }

        public void onOffRoute() {
        }

        public void onResetView() {
        }

        public void onRoadSnappedLocationChanged(GpsLocation gpsLocation) {
        }

        public void onSctxSetRouteToLightNav_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location) {
        }

        public void onSctxUploadAllData_Google(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, Location location, boolean z) {
        }

        public void onStartNavSuccess() {
        }

        public void startLightNavSctx_Google() {
        }

        public void onArriveDestination() {
            if (DriverSctxService.this.f29749d.navigationCallback != null) {
                DriverSctxService.this.f29749d.navigationCallback.onArriveDestination();
            }
        }

        public void onRemainingTimeOrDistanceChanged() {
            if (DriverSctxService.this.f29751f != null) {
                int remainMeters = DriverSctxService.this.f29751f.getRemainMeters(-1);
                int remainMinutes = DriverSctxService.this.f29751f.getRemainMinutes(-1);
                int i = 0;
                int i2 = 1;
                DLog.m10773d(DriverSctxService.f29746a, "navigationCallback onRemainingTimeOrDistanceChanged distance:%d, time:%d", Integer.valueOf(remainMeters), Integer.valueOf(remainMinutes));
                if (DriverSctxService.this.f29749d.etaEdaCallback != null) {
                    if (!DriverSctxService.this.f29753h) {
                        DriverSctxService.this.f29749d.etaEdaCallback.onEtaEdaChanged(new EtaEda(0, 0));
                        return;
                    }
                    if (remainMeters < 0) {
                        remainMeters = 0;
                    }
                    if (remainMinutes < 0) {
                        remainMinutes = 0;
                    }
                    if (remainMeters == 0 || remainMinutes == 0) {
                        DriverSctxService.this.f29749d.etaEdaCallback.onEtaEdaChanged(new EtaEda(1, 1));
                    } else {
                        if (remainMinutes != Integer.MAX_VALUE) {
                            i = remainMinutes;
                        }
                        if (remainMeters != Integer.MAX_VALUE) {
                            i2 = remainMeters;
                        }
                        DriverSctxService.this.f29749d.etaEdaCallback.onEtaEdaChanged(new EtaEda(i, i2));
                    }
                }
            }
            if (DriverSctxService.this.f29749d.navigationCallback != null) {
                DriverSctxService.this.f29749d.navigationCallback.onRemainingTimeOrDistanceChanged();
            }
        }

        public void onViaPointExpired(List<LatLng> list, long j) {
            if (DriverSctxService.this.f29749d.navigationCallback != null) {
                DriverSctxService.this.f29749d.navigationCallback.onViaPointExpired(list, j);
            }
        }
    };

    /* renamed from: o */
    private final ISearchOffRouteCallback f29760o = new ISearchOffRouteCallback() {
        public void onOffRoute() {
            if (DriverSctxService.this.f29749d.searchOffRouteCallback != null) {
                DriverSctxService.this.f29749d.searchOffRouteCallback.onOffRoute();
            }
        }

        public void onSuccess(ArrayList<NaviRoute> arrayList) {
            if (DriverSctxService.this.f29749d.searchOffRouteCallback != null) {
                DriverSctxService.this.f29749d.searchOffRouteCallback.onSuccess(arrayList);
            }
        }

        public void onRetryFail() {
            if (DriverSctxService.this.f29749d.searchOffRouteCallback != null) {
                DriverSctxService.this.f29749d.searchOffRouteCallback.onRetryFail();
            }
        }
    };

    /* renamed from: p */
    private final ISearchRouteCallback f29761p = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (DriverSctxService.this.f29749d.searchRouteCallback != null) {
                DriverSctxService.this.f29749d.searchRouteCallback.onBeginToSearch();
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            if (DriverSctxService.this.f29749d.searchRouteCallback != null) {
                DriverSctxService.this.f29749d.searchRouteCallback.onFinishToSearch(arrayList, str);
            }
        }
    };

    public DriverSctxService(Context context, DriverSctxParam driverSctxParam) {
        this.f29747b = context;
        m23074a(driverSctxParam);
        CommonNavigator commonNavigator = new CommonNavigator();
        this.f29751f = commonNavigator;
        commonNavigator.initWithVendor(context, MapVendor.GOOGLE, false);
    }

    /* renamed from: a */
    private void m23074a(DriverSctxParam driverSctxParam) {
        this.f29748c = driverSctxParam.mapView;
        this.f29754i = new ArrayList();
        this.f29749d = driverSctxParam;
        this.f29750e = (driverSctxParam.orderInfo.getOrderStage() == 4 ? driverSctxParam.orderEndPoint : driverSctxParam.orderStartPoint).latLng;
        this.f29752g = CameraMode.NORTH_UP;
        this.f29753h = true;
    }

    public void update(DriverSctxParam driverSctxParam) {
        m23074a(driverSctxParam);
        if (!TextUtils.equals(this.f29749d.orderInfo.getOrderId(), driverSctxParam.orderInfo.getOrderId())) {
            CommonNavigator commonNavigator = new CommonNavigator();
            this.f29751f = commonNavigator;
            commonNavigator.initWithVendor(this.f29747b, MapVendor.GOOGLE, false);
        }
    }

    public void setBestViewMapElements(List<IMapElement> list) {
        this.f29754i.clear();
        if (list != null) {
            this.f29754i.addAll(list);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        this.f29755j = i;
        this.f29756k = i2;
        this.f29757l = i3;
        this.f29758m = i4;
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.onNewMargin(i, i2, i3, i4);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        this.f29752g = cameraMode;
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.setCameraMode(cameraMode);
            followMyLocation(cameraMode == CameraMode.CAR_HEAD_UP);
        }
    }

    public void followMyLocation(boolean z) {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.followMyLocation(z);
        }
    }

    public Marker getCarMarker() {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            return iNavigator.getCarMarker();
        }
        return null;
    }

    public List<IMapElement> getLine() {
        MultiLine line;
        ArrayList arrayList = new ArrayList();
        INavigator iNavigator = this.f29751f;
        if (!(iNavigator == null || (line = iNavigator.getLine()) == null)) {
            if (line.mFirstLine != null) {
                arrayList.add(line.mFirstLine);
            }
            if (line.mFirstLine_Ex != null) {
                arrayList.add(line.mFirstLine_Ex);
            }
            if (line.mSecondLine != null) {
                arrayList.add(line.mSecondLine);
            }
        }
        return arrayList;
    }

    public void start(GpsLocation gpsLocation) {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.setCameraMode(this.f29752g);
            this.f29751f.followMyLocation(this.f29752g == CameraMode.CAR_HEAD_UP);
            this.f29751f.setDiDiMap(this.f29749d.mapView.getMap());
            this.f29751f.setOrderInfo(this.f29749d.orderInfo);
            this.f29751f.setRouteLineVisible(this.f29753h);
            this.f29751f.setCarMarkerEnabled(true);
            this.f29751f.setCarMarkerZindex((float) this.f29749d.carZIndex);
            this.f29751f.setCarMarkerBitmap(BitmapDescriptorFactory.fromBitmap(ImageUtil.Drawable2Bitmap(this.f29747b.getResources().getDrawable(this.f29749d.carBitmapRes))));
            this.f29751f.setCarMarkerEnabled(true);
            this.f29751f.setNaviCallback(this.f29759n);
            this.f29751f.setSearchOffRouteCallback(this.f29760o);
            this.f29751f.setSearchRouteCallbck(this.f29761p);
            this.f29751f.setLineOptions(m23072a(false), m23072a(true));
            this.f29751f.onLocationChanged(gpsLocation, LocationHelper.DIDILocations2GpsLocations(DIDILocBusinessHelper.getInstance().getRecentLocations(20)));
            this.f29751f.setDestination(this.f29750e);
            this.f29751f.start();
        }
    }

    public void zoomToNav() {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.zoomToNav();
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation, List<DIDILocation> list) {
        if (this.f29751f != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(LocationHelper.DIDILocation2GpsLocation(list.get(i)));
                }
            }
            this.f29751f.onLocationChanged(LocationHelper.DIDILocation2GpsLocation(dIDILocation), arrayList);
        }
    }

    public void onMapVisible(boolean z) {
        INavigator iNavigator = this.f29751f;
        if (iNavigator == null) {
            return;
        }
        if (z) {
            iNavigator.resumeAfterNavigation();
        } else {
            iNavigator.pause4Navigation();
        }
    }

    /* renamed from: a */
    private LineOptions m23072a(boolean z) {
        int i;
        int i2;
        int i3;
        LineOptions lineOptions = new LineOptions();
        Context context = this.f29747b;
        if (context != null) {
            lineOptions.width((double) DisplayUtils.dp2px(context, 5.0f));
        }
        if (z) {
            i = 162;
            i3 = 174;
            i2 = 187;
        } else {
            i = 74;
            i3 = 76;
            i2 = 91;
        }
        lineOptions.color(Color.rgb(i, i3, i2));
        lineOptions.zIndex(this.f29749d.lineZIndex);
        return lineOptions;
    }

    public void stop() {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.stop();
            this.f29751f.setCarMarkerEnabled(false);
        }
    }

    public void destroy() {
        INavigator iNavigator = this.f29751f;
        if (iNavigator != null) {
            iNavigator.destroy();
        }
    }
}
