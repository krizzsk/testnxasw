package com.didi.map.global.flow.scene.minibus.scene.service;

import android.text.TextUtils;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.scene.BaseMiniBusScene;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop;
import com.didi.map.global.flow.toolkit.sctx.PassengerSctx;
import com.didi.map.global.flow.utils.RoleExtractUtil;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMiniBusSctxScene extends BaseMiniBusScene<MiniBusSctxSceneParam> implements IMiniBusSctxSceneController {

    /* renamed from: a */
    private static final String f28904a = "MiniBusSctxScene";

    /* renamed from: b */
    private static final long f28905b = 3000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EtaEda f28906c;
    protected ClientParams clientParam;

    /* renamed from: d */
    private ICarBitmapDescriptor f28907d;
    protected MiniBusLineGroupComponent dashLineComponent;

    /* renamed from: e */
    private MarkersComponent f28908e;

    /* renamed from: f */
    private MarkersComponent f28909f;

    /* renamed from: g */
    private List<MarkerModel> f28910g = new ArrayList();
    protected List<CommonLineParam> lineParams;
    protected PassengerSctx mPassengerSctx;
    protected MapAutoBestViewLoop mapAutoBestViewLoop;
    protected List<CommonMarkerParam> markerParams;
    protected OrderParams orderParam;

    /* access modifiers changed from: protected */
    public abstract List<CommonLineParam> getDashLineParams();

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public abstract int getOrderStage();

    /* access modifiers changed from: protected */
    public abstract List<CommonMarkerParam> getShowMarkerParams();

    /* access modifiers changed from: protected */
    public abstract boolean showWayPoints();

    public BaseMiniBusSctxScene(MiniBusSctxSceneParam miniBusSctxSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusSctxSceneParam, mapViewHolder);
        if (miniBusSctxSceneParam != null && miniBusSctxSceneParam.getParamInterface() != null) {
            miniBusSctxSceneParam.systemOutLog();
            this.markerParams = miniBusSctxSceneParam.getParamInterface().getMarkerParams();
            this.lineParams = miniBusSctxSceneParam.getParamInterface().getLineParams();
            this.orderParam = miniBusSctxSceneParam.getParamInterface().getOrderParams();
            this.clientParam = miniBusSctxSceneParam.getParamInterface().getClientParam();
            this.f28907d = miniBusSctxSceneParam.getParamInterface().getCarMarkerBitmap();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        initMarkerComponent(getShowMarkerParams());
        m22524c();
        if (this.mapAutoBestViewLoop == null && getMap() != null) {
            MapAutoBestViewLoop mapAutoBestViewLoop2 = new MapAutoBestViewLoop(getMap());
            this.mapAutoBestViewLoop = mapAutoBestViewLoop2;
            mapAutoBestViewLoop2.setOnBestViewCallback(new MapAutoBestViewLoop.IBestViewCallback() {
                public final void doBestView(boolean z) {
                    BaseMiniBusSctxScene.this.m22519a(z);
                }
            });
        }
        OrderParams orderParams = this.orderParam;
        if (orderParams != null && !TextUtils.equals(DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT, orderParams.srcTag)) {
            DLog.m10773d(f28904a, "srcTag非场站围栏", new Object[0]);
            m22532g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22519a(boolean z) {
        doSceneBestView(this.mPadding, z);
    }

    public void leave() {
        super.leave();
        MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
        if (mapAutoBestViewLoop2 != null) {
            mapAutoBestViewLoop2.destroy();
            this.mapAutoBestViewLoop = null;
        }
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.leave();
        }
        MarkersComponent markersComponent = this.f28908e;
        if (markersComponent != null) {
            markersComponent.destroy();
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.dashLineComponent;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
        }
        m22530f();
    }

    public void onResume() {
        super.onResume();
        if (this.isSceneValid) {
            PassengerSctx passengerSctx = this.mPassengerSctx;
            if (passengerSctx != null) {
                passengerSctx.resume();
            }
            MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
            if (mapAutoBestViewLoop2 != null) {
                mapAutoBestViewLoop2.onMapVisible(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.isSceneValid) {
            PassengerSctx passengerSctx = this.mPassengerSctx;
            if (passengerSctx != null) {
                passengerSctx.pause();
            }
            MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
            if (mapAutoBestViewLoop2 != null) {
                mapAutoBestViewLoop2.onMapVisible(false);
            }
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
        if (mapAutoBestViewLoop2 != null) {
            mapAutoBestViewLoop2.doBestViewImmediately(true);
        }
    }

    public void refreshCarBitmap(BitmapDescriptor bitmapDescriptor) {
        PassengerSctx passengerSctx;
        if (bitmapDescriptor != null && (passengerSctx = this.mPassengerSctx) != null) {
            passengerSctx.setCarIcon(bitmapDescriptor);
        }
    }

    /* access modifiers changed from: protected */
    public void updateScene() {
        m22530f();
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.leave();
            this.mPassengerSctx.destroy();
            this.mPassengerSctx = null;
        }
        m22524c();
        enterSctxService();
    }

    /* access modifiers changed from: protected */
    public List<Marker> getWayPointElements() {
        MarkersComponent markersComponent = this.f28909f;
        if (markersComponent != null) {
            return markersComponent.getMarkers();
        }
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m22515a() {
        return RoleExtractUtil.getId(PaxEnvironment.getInstance().getRoleType());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m22520b() {
        Page page = PaxEnvironment.getInstance().getPage();
        return page != null ? page.toString() : "";
    }

    public void initMarkerComponent(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f28908e = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam paramConvertToMarkerModel : list) {
                MarkerModel paramConvertToMarkerModel2 = paramConvertToMarkerModel(paramConvertToMarkerModel);
                if (paramConvertToMarkerModel2 != null) {
                    arrayList.add(paramConvertToMarkerModel2);
                }
            }
            this.f28908e.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f28908e.create(getContext(), getMap());
        }
    }

    /* renamed from: c */
    private void m22524c() {
        if (this.orderParam != null && getMap() != null && getContext() != null) {
            String str = this.orderParam.productID;
            SctxTripParam.Builder passengerPhone = new SctxTripParam.Builder().map(getMap()).context(getContext()).passengerPhone(this.orderParam.phoneNumPassenger);
            ICarBitmapDescriptor iCarBitmapDescriptor = this.f28907d;
            SctxTripParam.Builder isShowExtendedAnimation = passengerPhone.carBitmapDescriptor(iCarBitmapDescriptor != null ? iCarBitmapDescriptor.getBitmapDescriptor() : null).car3DEnabled(ApolloToggleUtils.is3DCarEnabled()).zIndex(200).isArrivedPickupPoint(this.orderParam.orderStage == 1).orderId(this.orderParam.orderId).bizType(TextUtils.isEmpty(str) ? 21081 : Integer.valueOf(str).intValue()).tripState(getOrderStage()).pickupPoint(getMarkerPointWithId(MapElementId.ID_MARKER_PICK_UP)).endPoint(getMarkerPointWithId(MapElementId.ID_MARKER_DROP_OFF)).token(PaxEnvironment.getInstance().getToken()).driverId(this.orderParam.driverId).tripId(this.orderParam.travelId).isShowExtendedAnimation(this.orderParam.isShowExtendedAnimation);
            ClientParams clientParams = this.clientParam;
            String str2 = "";
            SctxTripParam.Builder clientVersion = isShowExtendedAnimation.clientVersion(clientParams == null ? str2 : clientParams.clientVersion);
            ClientParams clientParams2 = this.clientParam;
            SctxTripParam.Builder newVersion = clientVersion.countryId(clientParams2 == null ? str2 : clientParams2.countryId).newVersion(true);
            ClientParams clientParams3 = this.clientParam;
            if (clientParams3 != null) {
                str2 = clientParams3.imei;
            }
            SctxTripParam build = newVersion.imei(str2).oraRequestInterval(getOraRequestIntervalMillis()).routeExtensionAnimationDuration((long) this.orderParam.pickupExtendedAnimDurationInMs).sctxSearchGetter(m22526d()).build();
            PassengerSctx passengerSctx = new PassengerSctx();
            this.mPassengerSctx = passengerSctx;
            passengerSctx.update(build);
            this.mPassengerSctx.registerSctxCallback(m22528e());
        }
    }

    /* access modifiers changed from: protected */
    public LatLng getMarkerPointWithId(MapElementId mapElementId) {
        if (CollectionUtil.isEmpty((Collection<?>) this.markerParams)) {
            return null;
        }
        for (CommonMarkerParam next : this.markerParams) {
            if (next != null && next.getId() != null && mapElementId != null && mapElementId == next.getId()) {
                return next.getPoint();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public CommonMarkerParam getMarkerParamWithId(MapElementId mapElementId) {
        if (CollectionUtil.isEmpty((Collection<?>) this.markerParams)) {
            return null;
        }
        for (CommonMarkerParam next : this.markerParams) {
            if (next != null && next.getId() != null && mapElementId != null && mapElementId == next.getId()) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public List<IMapElement> getMarkerElementWithId(String str) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f28908e;
        if (markersComponent != null) {
            List<Marker> markers = markersComponent.getMarkers(str);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private SctxService.SctxSearchGetter m22526d() {
        return new SctxService.SctxSearchGetter() {
            public String getUserId() {
                return PaxEnvironment.getInstance().getUid();
            }

            public String getUserRole() {
                return BaseMiniBusSctxScene.this.m22515a();
            }

            public String getPageReferrer() {
                return BaseMiniBusSctxScene.this.m22520b();
            }
        };
    }

    /* renamed from: e */
    private SctxService.SctxCallback m22528e() {
        return new SctxService.SctxCallbackAdapter() {
            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (BaseMiniBusSctxScene.this.mParam != null && ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getSctxStateCallback() != null) {
                    ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getSctxStateCallback().onSctxStateUpdate(sctxStateInfo);
                }
            }

            public void onEtaEdaUpdate(EtaEdaInfo etaEdaInfo) {
                if (etaEdaInfo != null && etaEdaInfo.getEta() >= 0 && etaEdaInfo.getEda() >= 0) {
                    if (BaseMiniBusSctxScene.this.f28906c != null) {
                        BaseMiniBusSctxScene.this.f28906c.eta = etaEdaInfo.getEta();
                        BaseMiniBusSctxScene.this.f28906c.eda = etaEdaInfo.getEda();
                    } else {
                        EtaEda unused = BaseMiniBusSctxScene.this.f28906c = new EtaEda(etaEdaInfo.getEta(), etaEdaInfo.getEda());
                    }
                    if (!(BaseMiniBusSctxScene.this.mParam == null || ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getEtaEdaCallback() == null)) {
                        ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getEtaEdaCallback().onEtaEdaChanged(BaseMiniBusSctxScene.this.f28906c);
                    }
                    if (BaseMiniBusSctxScene.this.mapAutoBestViewLoop != null) {
                        BaseMiniBusSctxScene.this.mapAutoBestViewLoop.doBestViewImmediately(false);
                    }
                }
            }

            public void onWayPointsStateUpdateForMiniBus(List<OdPoint> list) {
                if (BaseMiniBusSctxScene.this.showWayPoints()) {
                    BaseMiniBusSctxScene.this.m22518a(list);
                }
            }

            public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (BaseMiniBusSctxScene.this.isSceneValid && BaseMiniBusSctxScene.this.mPassengerSctx != null) {
                    BaseMiniBusSctxScene.this.mPassengerSctx.setOraRequestInterval(BaseMiniBusSctxScene.this.getOraRequestIntervalMillis());
                }
            }

            public void onAbnormalOrderStageCallback(int i) {
                if (BaseMiniBusSctxScene.this.mParam != null && ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getOraSyncOrderStageCallback() != null) {
                    ((MiniBusSctxSceneParam) BaseMiniBusSctxScene.this.mParam).getOraSyncOrderStageCallback().onAbnormal(i);
                }
            }
        };
    }

    public void enterSctxService() {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.enter();
        }
    }

    /* renamed from: f */
    private void m22530f() {
        MarkersComponent markersComponent = this.f28909f;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f28909f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22518a(List<OdPoint> list) {
        if (list != null && this.mParam != null) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                OdPoint odPoint = (OdPoint) it.next();
                if (!(odPoint == null || odPoint.pointType == null || odPoint.point == null || odPoint.pointType.intValue() != 2)) {
                    LatLng latLng = new LatLng((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue());
                    MarkerModel markerModel = new MarkerModel();
                    if (((MiniBusSctxSceneParam) this.mParam).getParamInterface() != null) {
                        markerModel.setMarkerIcon(((MiniBusSctxSceneParam) this.mParam).getParamInterface().getWayPointIcon());
                    }
                    markerModel.setPoint(latLng);
                    markerModel.setAnchorV(0.5f);
                    markerModel.setAnchorU(0.5f);
                    markerModel.setZOrder(190);
                    markerModel.setId(MapElementId.ID_MARKER_WAYPOINT.name());
                    arrayList2.add(markerModel);
                }
            }
            if (m22522b((List<MarkerModel>) arrayList2)) {
                m22530f();
                if (!CollectionUtil.isEmpty((Collection<?>) arrayList2)) {
                    this.f28909f = new MarkersComponent();
                    this.f28909f.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList2).build());
                    this.f28909f.create(getContext(), getMap());
                }
            }
            this.f28910g = arrayList2;
        }
    }

    /* renamed from: b */
    private boolean m22522b(List<MarkerModel> list) {
        List<MarkerModel> list2 = this.f28910g;
        return (list2 == null || list == null || list2.size() == list.size()) ? false : true;
    }

    /* renamed from: g */
    private void m22532g() {
        List<CommonLineParam> dashLineParams = getDashLineParams();
        MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
        this.dashLineComponent = miniBusLineGroupComponent;
        miniBusLineGroupComponent.setConfigParam(dashLineParams, 2);
        this.dashLineComponent.setDidiVersion(PaxEnvironment.getInstance().getAppVersion());
        this.dashLineComponent.setProductId(PaxEnvironment.getInstance().getProductId());
        this.dashLineComponent.setOrderStage(getOrderStage());
        OrderParams orderParams = this.orderParam;
        if (orderParams != null && !TextUtils.isEmpty(orderParams.orderId)) {
            this.dashLineComponent.setOrderId(this.orderParam.orderId);
        }
        this.dashLineComponent.create(getContext(), getMap());
        this.dashLineComponent.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
            public void onLineDateRequestSuccess() {
                BaseMiniBusSctxScene baseMiniBusSctxScene = BaseMiniBusSctxScene.this;
                baseMiniBusSctxScene.doBestView(baseMiniBusSctxScene.mPadding);
            }
        });
        this.dashLineComponent.start();
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        if (this.isSceneValid && getContext() != null && getMap() != null) {
            Padding defaultPadding = getDefaultPadding();
            ArrayList arrayList = new ArrayList();
            if (getOrderStage() == 3 && this.mMapView != null) {
                List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
                if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            MarkersComponent markersComponent = this.f28908e;
            if (markersComponent != null && !CollectionUtil.isEmpty((Collection<?>) markersComponent.getMarkers())) {
                arrayList.addAll(this.f28908e.getMarkers());
            }
            MiniBusLineGroupComponent miniBusLineGroupComponent = this.dashLineComponent;
            if (miniBusLineGroupComponent != null && !CollectionUtil.isEmpty((Collection<?>) miniBusLineGroupComponent.getBestViewElements())) {
                arrayList.addAll(this.dashLineComponent.getBestViewElements());
            }
            PassengerSctx passengerSctx = this.mPassengerSctx;
            if (passengerSctx != null) {
                CarMarker carMarker = passengerSctx.getCarMarker();
                if (!(carMarker == null || carMarker.getMarker() == null)) {
                    arrayList.add(carMarker.getMarker());
                }
                if (!CollectionUtil.isEmpty((Collection<?>) this.mPassengerSctx.getLines())) {
                    arrayList.addAll(this.mPassengerSctx.getLines());
                }
            }
            if (!CollectionUtil.isEmpty((Collection<?>) getWayPointElements())) {
                arrayList.addAll(getWayPointElements());
            }
            boolean z2 = false;
            if (this.mapAutoBestViewLoop != null) {
                if (padding != null) {
                    if (padding.right <= 0) {
                        padding.right = getDefaultPadding().right;
                    }
                    if (padding.left <= 0) {
                        padding.left = getDefaultPadding().left;
                    }
                }
                z2 = this.mapAutoBestViewLoop.doBestViewExecute(arrayList, padding, defaultPadding, z);
            } else {
                DLog.m10773d(f28904a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }
}
