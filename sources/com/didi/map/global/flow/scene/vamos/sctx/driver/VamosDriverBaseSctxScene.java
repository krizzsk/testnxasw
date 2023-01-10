package com.didi.map.global.flow.scene.vamos.sctx.driver;

import android.location.Location;
import android.text.TextUtils;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.omega.VamosDriverSctxOmegaUtil;
import com.didi.map.global.flow.scene.vamos.sctx.driver.param.VamosDriverSctxParam;
import com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerDrawer;
import com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop;
import com.didi.map.global.flow.toolkit.sctx.DriverSctx;
import com.didi.map.global.flow.toolkit.sctx.DriverSctxParam;
import com.didi.map.global.flow.utils.VamosNavUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.passengerlocation.IPassengerLocation;
import com.didi.map.sdk.passengerlocation.PassengerInfo;
import com.didi.map.sdk.passengerlocation.PassengerLocationParam;
import com.didi.map.sdk.passengerlocation.PsgLocationDelegateImpl;
import com.didi.map.sdk.passengerlocation.onPsgLocationListener;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.util.ToastUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Utils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class VamosDriverBaseSctxScene extends BaseVamosPageScene<VamosDriverSctxParam> implements IVamosDriverSctxController {

    /* renamed from: a */
    private static final String f29648a = "VamosDriverBaseSctxScene";

    /* renamed from: b */
    private static final int f29649b = 10;

    /* renamed from: c */
    private static final int f29650c = 3;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static long f29651d = 0;

    /* renamed from: e */
    private static final long f29652e = 60000;

    /* renamed from: f */
    private static final int f29653f = 100;

    /* renamed from: g */
    private static final int f29654g = 98;

    /* renamed from: h */
    private static final int f29655h = 96;

    /* renamed from: i */
    private static final int f29656i = 94;

    /* renamed from: j */
    private static final int f29657j = 92;

    /* renamed from: k */
    private static final int f29658k = 90;

    /* renamed from: l */
    private static final int f29659l = 88;

    /* renamed from: m */
    private CameraMode f29660m = CameraMode.NORTH_UP;
    protected Marker mDriverEndMarker;
    protected DriverSctx mDriverSctx;
    protected Marker mDriverStartMarker;
    protected Marker mOrderEndMarker;
    protected Marker mOrderStartMarker;
    protected IPassengerLocation mPsgLocationDelegate;

    /* renamed from: n */
    private PassengerMarkerDrawer f29661n;

    /* renamed from: o */
    private boolean f29662o = false;

    /* renamed from: p */
    private onPsgLocationListener f29663p = new onPsgLocationListener() {
        public final void updatePassengerMarkers(List list) {
            VamosDriverBaseSctxScene.this.m22996b(list);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MapAutoBestViewLoop f29664q;

    /* renamed from: r */
    private ISearchRouteCallback f29665r = new ISearchRouteCallback() {
        public void onBeginToSearch() {
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            objArr[1] = str;
            DLog.m10773d(VamosDriverBaseSctxScene.f29648a, "searchRouteCallback onFinishToSearch: routes size:%d, msg:%s", objArr);
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase("30000")) {
                    if (System.currentTimeMillis() - VamosDriverBaseSctxScene.f29651d > 60000) {
                        ToastUtil.show(VamosDriverBaseSctxScene.this.getContext(), (CharSequence) VamosDriverBaseSctxScene.this.getContext().getResources().getString(R.string.sctx_calculate_fail));
                        long unused = VamosDriverBaseSctxScene.f29651d = System.currentTimeMillis();
                    }
                } else if (str.equalsIgnoreCase("30011")) {
                    ToastUtil.show(VamosDriverBaseSctxScene.this.getContext(), (CharSequence) VamosDriverBaseSctxScene.this.getContext().getResources().getString(R.string.sctx_cannot_nav_nearby));
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                VamosDriverSctxOmegaUtil.onSearchRouteFail();
                if (!NetUtil.isAvailable(VamosDriverBaseSctxScene.this.getContext())) {
                    VamosDriverSctxOmegaUtil.onSearchFailByNet();
                    return;
                }
                return;
            }
            VamosDriverSctxOmegaUtil.onSearchRouteSuccess();
            if (VamosDriverBaseSctxScene.this.f29664q != null) {
                VamosDriverBaseSctxScene.this.f29664q.doBestViewImmediately(false);
            }
        }
    };

    /* renamed from: s */
    private ISearchOffRouteCallback f29666s = new ISearchOffRouteCallback() {
        public void onOffRoute() {
            DLog.m10773d(VamosDriverBaseSctxScene.f29648a, "searchOffRouteCallback onOffRoute", new Object[0]);
        }

        public void onSuccess(ArrayList<NaviRoute> arrayList) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            DLog.m10773d(VamosDriverBaseSctxScene.f29648a, "searchOffRouteCallback onSuccess: routes size:%d", objArr);
            if (arrayList == null || arrayList.size() <= 0) {
                VamosDriverSctxOmegaUtil.onSearchOffRouteFail();
                if (!NetUtil.isAvailable(VamosDriverBaseSctxScene.this.getContext())) {
                    ToastUtil.show(VamosDriverBaseSctxScene.this.getContext(), (CharSequence) VamosDriverBaseSctxScene.this.getContext().getResources().getString(R.string.sctx_off_nav_failed_by_net));
                    VamosDriverSctxOmegaUtil.onSearchFailByNet();
                    return;
                }
                return;
            }
            if (VamosDriverBaseSctxScene.this.f29664q != null) {
                VamosDriverBaseSctxScene.this.f29664q.doBestViewImmediately(false);
            }
            VamosDriverSctxOmegaUtil.onSearchOffRouteSuccess();
        }

        public void onRetryFail() {
            DLog.m10773d(VamosDriverBaseSctxScene.f29648a, "searchOffRouteCallback onRetryFail", new Object[0]);
            if (!NetUtil.isAvailable(VamosDriverBaseSctxScene.this.getContext())) {
                ToastUtil.show(VamosDriverBaseSctxScene.this.getContext(), (CharSequence) VamosDriverBaseSctxScene.this.getContext().getResources().getString(R.string.sctx_off_nav_failed_by_net));
                VamosDriverSctxOmegaUtil.onSearchFailByNet();
            }
        }
    };

    /* renamed from: t */
    private INavigationCallback f29667t = new INavigationCallback() {
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

        public void onRemainingTimeOrDistanceChanged() {
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

        public void onViaPointExpired(List<LatLng> list, long j) {
        }

        public void startLightNavSctx_Google() {
        }

        public void onArriveDestination() {
            DLog.m10773d(VamosDriverBaseSctxScene.f29648a, "navigationCallback onArriveDestination", new Object[0]);
            if (VamosDriverBaseSctxScene.this.f29664q != null) {
                VamosDriverBaseSctxScene.this.f29664q.doBestViewImmediately(false);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f29668u = -1;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f29669v = -1;

    /* renamed from: w */
    private DIDILocationListener f29670w = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            int locMode = getLocMode();
            if (VamosDriverBaseSctxScene.this.f29668u != locMode) {
                int unused = VamosDriverBaseSctxScene.this.f29668u = locMode;
                VamosDriverSctxOmegaUtil.onLocateStatusChange(VamosDriverBaseSctxScene.this.f29668u);
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (errInfo != null && errInfo.getErrNo() != VamosDriverBaseSctxScene.this.f29669v) {
                int unused = VamosDriverBaseSctxScene.this.f29669v = errInfo.getErrNo();
                VamosDriverSctxOmegaUtil.onLocateFail(VamosDriverBaseSctxScene.this.f29669v);
            }
        }

        private int getLocMode() {
            return Utils.getLocationSwitchLevel(VamosDriverBaseSctxScene.this.getContext());
        }
    };

    /* access modifiers changed from: protected */
    public abstract int getInnerOrderStage();

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m22996b(List list) {
        DLog.m10773d(f29648a, "updatePsgLocationMarkers", new Object[0]);
        m22991a((List<PassengerInfo>) list);
    }

    public void setInitPsgComponent(boolean z) {
        this.f29662o = z;
    }

    public VamosDriverBaseSctxScene(VamosDriverSctxParam vamosDriverSctxParam, MapViewHolder mapViewHolder) {
        super(vamosDriverSctxParam, mapViewHolder);
        DLog.m10773d(f29648a, "new: %s", vamosDriverSctxParam.toString());
        VamosDriverSctxOmegaUtil.initCommonFields(vamosDriverSctxParam.getOrderInfo().orderInfo.getOrderId(), "", getInnerOrderStage());
    }

    /* access modifiers changed from: protected */
    public void handleTrackDragMapEvent() {
        if (this.mParam != null && ((VamosDriverSctxParam) this.mParam).getOrderInfo() != null && ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo != null) {
            ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.getOrderId();
        }
    }

    /* renamed from: a */
    private DriverSctxParam m22988a(VamosDriverSctxParam vamosDriverSctxParam) {
        return new DriverSctxParam(new DriverSctxParam.Builder().setMapView(this.mMapView.getMapView()).setOrderInfo(vamosDriverSctxParam.getOrderInfo().orderInfo).setOrderStartPoint(vamosDriverSctxParam.getOrderInfo().orderStartPoint).setOrderEndPoint(vamosDriverSctxParam.getOrderInfo().orderEndPoint).setCarBitmapRes(R.drawable.self_driving_icon).setCarZIndex(96).setLineZIndex(88).setEtaEdaCallback(new IEtaEdaCallback() {
            public final void onEtaEdaChanged(EtaEda etaEda) {
                VamosDriverBaseSctxScene.this.m22990a(etaEda);
            }
        }).setSearchRouteCallback(this.f29665r).setSearchOffRouteCallback(this.f29666s).setNavigationCallback(this.f29667t).setLocationListener(this.f29670w));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22990a(EtaEda etaEda) {
        if (((VamosDriverSctxParam) this.mParam).getEtaEdaCallback() != null) {
            ((VamosDriverSctxParam) this.mParam).getEtaEdaCallback().onEtaEdaChanged(etaEda);
        }
        if (etaEda != null) {
            startLoopFetchPsgLocation(etaEda.eda);
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        try {
            PlatInfo.getInstance().setBizType(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue());
        } catch (NumberFormatException e) {
            DLog.m10773d(f29648a, "productID exception = ", e.toString());
        }
        PlatInfo.getInstance().setDriverTicket(PaxEnvironment.getInstance().getToken());
        PlatInfo.getInstance().setDriverPhoneNumber(PaxEnvironment.getInstance().getPhoneNumber());
        PlatInfo.getInstance().setDriverId(Long.valueOf(PaxEnvironment.getInstance().getUid()).longValue());
        PlatInfo.getInstance().setOrderStage(getInnerOrderStage());
        ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.setOrderStage(getInnerOrderStage());
        if (this.mDriverSctx == null) {
            this.mDriverSctx = new DriverSctx(m22988a((VamosDriverSctxParam) this.mParam));
        }
        if (this.f29662o) {
            m22995b();
        }
        this.mOrderStartMarker = addMarker(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderStartPoint, 100);
        this.mOrderEndMarker = addMarker(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderEndPoint, 98);
        this.mDriverStartMarker = addMarker(((VamosDriverSctxParam) this.mParam).getOrderInfo().driverStartPoint, 90);
        this.mDriverEndMarker = addMarker(((VamosDriverSctxParam) this.mParam).getOrderInfo().driverEndPoint, 92);
        this.mDriverSctx.setBestViewMapElements(getBestViewMapElements());
        if (this.mPadding != null) {
            this.mDriverSctx.onNewMargin(this.mPadding.left, this.mPadding.top, this.mPadding.right, this.mPadding.bottom);
        }
        if (getMap() != null) {
            MapAutoBestViewLoop mapAutoBestViewLoop = new MapAutoBestViewLoop(getMap());
            this.f29664q = mapAutoBestViewLoop;
            mapAutoBestViewLoop.setOnBestViewCallback(new MapAutoBestViewLoop.IBestViewCallback() {
                public final void doBestView(boolean z) {
                    VamosDriverBaseSctxScene.this.m22992a(z);
                }
            });
        }
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22992a(boolean z) {
        m22989a(this.mPadding, z);
    }

    /* renamed from: b */
    private void m22995b() {
        if (getMap() != null && getContext() != null && this.mParam != null) {
            DLog.m10773d(f29648a, "initPsgLocation", new Object[0]);
            this.mPsgLocationDelegate = new PsgLocationDelegateImpl();
            PassengerInfo passengerInfo = new PassengerInfo();
            passengerInfo.setId("" + ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.getPassengerId());
            passengerInfo.setPassengerId(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.getPassengerId());
            passengerInfo.setOrderId(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.getOrderId());
            passengerInfo.setHeadUrl(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderInfo.getPassengerHeadUrl());
            this.mPsgLocationDelegate.setConfigParam(new PassengerLocationParam.Builder().startPoint(((VamosDriverSctxParam) this.mParam).getOrderInfo().orderStartPoint.latLng).listener(this.f29663p).passengerInfoList(Collections.singletonList(passengerInfo)).locationAccuracy(120).travelId(PlatInfo.getInstance().getTraverId()).build());
            this.mPsgLocationDelegate.create(getContext(), getMap());
        }
    }

    /* access modifiers changed from: protected */
    public Marker addMarker(DriverSctxParam.Point point, int i) {
        if (getMap() == null || getContext() == null || point == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(point.latLng).anchor(0.5f, 0.5f).draggable(false).flat(false).zIndex(i);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(getContext(), point.markerIconResId));
        return getMap().addMarker(markerOptions);
    }

    public void onResume() {
        super.onResume();
        DLog.m10773d(f29648a, "onResume", new Object[0]);
        DriverSctx driverSctx = this.mDriverSctx;
        if (driverSctx != null) {
            driverSctx.onMapVisible(true);
        }
        VamosDriverSctxOmegaUtil.onResume();
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        DLog.m10773d(f29648a, "onPause", new Object[0]);
        DriverSctx driverSctx = this.mDriverSctx;
        if (driverSctx != null) {
            driverSctx.onMapVisible(false);
        }
        VamosDriverSctxOmegaUtil.onPause();
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.onMapVisible(false);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        DLog.m10773d(f29648a, "setCameraMode:%s", cameraMode);
        VamosDriverSctxOmegaUtil.onCameraButtonClick(this.f29660m);
        this.f29660m = cameraMode;
        DriverSctx driverSctx = this.mDriverSctx;
        if (driverSctx != null) {
            driverSctx.setCameraMode(cameraMode);
        }
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.doBestViewImmediately(true);
        }
    }

    public void onNavButtonClick() {
        double d;
        double d2;
        DLog.m10773d(f29648a, "onNavButtonClick", new Object[0]);
        if (this instanceof VamosDriverPickupScene) {
            d2 = ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderStartPoint.latLng.latitude;
            d = ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderStartPoint.latLng.longitude;
        } else {
            d2 = ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderEndPoint.latLng.latitude;
            d = ((VamosDriverSctxParam) this.mParam).getOrderInfo().orderEndPoint.latLng.longitude;
        }
        VamosNavUtils.checkAndStartNavigation(getContext(), d2, d);
    }

    /* renamed from: a */
    private void m22991a(List<PassengerInfo> list) {
        if (getMap() != null && getContext() != null) {
            if (this.f29661n == null) {
                this.f29661n = new PassengerMarkerDrawer(getMap(), getContext());
            }
            this.f29661n.addPassengerMarkers(list, 94);
        }
    }

    /* access modifiers changed from: protected */
    public void startLoopFetchPsgLocation(int i) {
        IPassengerLocation iPassengerLocation;
        if (this.isSceneValid && i <= 500 && (iPassengerLocation = this.mPsgLocationDelegate) != null) {
            iPassengerLocation.start();
        }
    }

    /* access modifiers changed from: protected */
    public void stopLoopFetchPsgLocation() {
        IPassengerLocation iPassengerLocation = this.mPsgLocationDelegate;
        if (iPassengerLocation != null) {
            iPassengerLocation.stop();
        }
    }

    public void showResetView() {
        DriverSctx driverSctx;
        super.showResetView();
        if (this.f29660m == CameraMode.CAR_HEAD_UP && (driverSctx = this.mDriverSctx) != null) {
            driverSctx.followMyLocation(false);
        }
    }

    public void hideResetView() {
        DriverSctx driverSctx;
        super.hideResetView();
        if (this.f29660m == CameraMode.CAR_HEAD_UP && (driverSctx = this.mDriverSctx) != null) {
            driverSctx.followMyLocation(true);
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        VamosDriverSctxOmegaUtil.onResetButtonClick();
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.doBestViewImmediately(true);
        }
    }

    /* renamed from: a */
    private void m22989a(Padding padding, boolean z) {
        if (this.isSceneValid && this.mDriverSctx != null && getMap() != null && getContext() != null) {
            DriverSctx driverSctx = this.mDriverSctx;
            if (!(driverSctx == null || padding == null)) {
                driverSctx.onNewMargin(padding.left, padding.top, padding.right, padding.bottom);
            }
            if (this.f29660m != CameraMode.CAR_HEAD_UP) {
                int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
                int dp2px2 = DisplayUtils.dp2px(getContext(), 3.0f);
                Padding padding2 = new Padding(dp2px, dp2px2, dp2px, dp2px2);
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                DriverSctx driverSctx2 = this.mDriverSctx;
                if (driverSctx2 != null) {
                    if (driverSctx2.getCarMarker() != null) {
                        copyOnWriteArrayList.add(this.mDriverSctx.getCarMarker());
                    }
                    copyOnWriteArrayList.addAll(this.mDriverSctx.getLine());
                }
                copyOnWriteArrayList.addAll(getBestViewMapElements());
                MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
                boolean z2 = false;
                if (mapAutoBestViewLoop != null) {
                    z2 = mapAutoBestViewLoop.doBestViewExecute(copyOnWriteArrayList, padding, padding2, z);
                } else {
                    DLog.m10773d(f29648a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
                }
                if (z2) {
                    hideResetView();
                }
            } else if (this.mDriverSctx != null) {
                hideResetView();
                this.mDriverSctx.zoomToNav();
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<IMapElement> getBestViewMapElements() {
        return new ArrayList();
    }

    public void leave() {
        super.leave();
        if (getMap() != null) {
            getMap().remove(this.mOrderStartMarker);
            getMap().remove(this.mOrderEndMarker);
            getMap().remove(this.mDriverStartMarker);
            getMap().remove(this.mDriverEndMarker);
        }
        IPassengerLocation iPassengerLocation = this.mPsgLocationDelegate;
        if (iPassengerLocation != null) {
            iPassengerLocation.destroy();
            this.mPsgLocationDelegate = null;
        }
        PassengerMarkerDrawer passengerMarkerDrawer = this.f29661n;
        if (passengerMarkerDrawer != null) {
            passengerMarkerDrawer.removePassengerMarkers();
        }
        DriverSctx driverSctx = this.mDriverSctx;
        if (driverSctx != null) {
            driverSctx.stop();
            this.mDriverSctx.destroy();
            this.mDriverSctx = null;
        }
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f29664q;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.destroy();
            this.f29664q = null;
        }
    }
}
