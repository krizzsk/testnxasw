package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.trafficreport.TrafficReportManager;
import com.didi.map.global.component.trafficreport.TrafficReportParam;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.ITrafficEventFeedbackViewCallback;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.widget.TrafficEventFeedbackView;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.event_reveal.TriggeredTrafficEventShowModel;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DriveOffPage extends BasePage {

    /* renamed from: a */
    private static final String f29449a = "DriveOffPage";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TrafficReportManager f29450b;

    /* renamed from: c */
    private SctxService.SctxCallback f29451c = new SctxService.SctxCallbackAdapter() {
        public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
            DriveOffPage.this.mo81272a(latLng2);
        }

        public void onWayPointsStateUpdate(boolean z, List<OdPoint> list) {
            DriveOffPage.this.addOdPointMarker(list, false);
        }

        public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
            super.onSyncSuccess(mapPassengeOrderRouteRes);
            if (DriveOffPage.this.mParam != null && DriveOffPage.this.mParam.getTrafficEventsCallback() != null) {
                CarMarker carMarker = DriveOffPage.this.mPassengerSctx.getCarMarker();
                List<IMapElement> routeElements = DriveOffPage.this.getRouteElements();
                if (DriveOffPage.this.enableTrafficEventAB() && carMarker != null && carMarker.getMarker() != null && routeElements != null) {
                    DriveOffPage.this.mParam.getTrafficEventsCallback().showTrafficReportEntry(true);
                }
            }
        }

        public void onShowTrafficEventFeedbackXpanelDialog(boolean z, final TriggeredTrafficEventShowModel triggeredTrafficEventShowModel) {
            if (DriveOffPage.this.mParam != null && DriveOffPage.this.mParam.getTrafficEventsCallback() != null) {
                boolean z2 = z && triggeredTrafficEventShowModel != null && !TextUtils.isEmpty(triggeredTrafficEventShowModel.getMessage());
                DLog.m10773d("TrafficReveal", "invoke didi-comp show feedback dialog , show: " + z2, new Object[0]);
                if (z2) {
                    DriveOffPage.this.mParam.getTrafficEventsCallback().showTrafficEventFeedbackDialog(true, DriveOffPage.this.m22804a(triggeredTrafficEventShowModel, new ITrafficEventFeedbackViewCallback() {
                        public void onVerifyCode(int i) {
                            DLog.m10773d("TrafficReveal", "trigger dialog dismiss, clicked code: " + i, new Object[0]);
                            DriveOffPage.this.mParam.getTrafficEventsCallback().showTrafficEventFeedbackDialog(false, (View) null);
                            if (DriveOffPage.this.mPassengerSctx != null && triggeredTrafficEventShowModel.isValid()) {
                                DriveOffPage.this.mPassengerSctx.handleTriggerEventDialog(triggeredTrafficEventShowModel.getEvent(), i);
                            }
                        }

                        public void countDownDismiss() {
                            DLog.m10773d("TrafficReveal", "trigger dialog dismiss, count down", new Object[0]);
                            DriveOffPage.this.mParam.getTrafficEventsCallback().showTrafficEventFeedbackDialog(false, (View) null);
                            if (DriveOffPage.this.mPassengerSctx != null && triggeredTrafficEventShowModel.isValid()) {
                                DriveOffPage.this.mPassengerSctx.handleTriggerEventDialog(triggeredTrafficEventShowModel.getEvent(), -2);
                            }
                        }

                        public void onDismiss() {
                            if (DriveOffPage.this.mPassengerSctx != null && triggeredTrafficEventShowModel.isValid()) {
                                DriveOffPage.this.mPassengerSctx.handleTriggerEventDialog(triggeredTrafficEventShowModel.getEvent(), -101);
                            }
                        }
                    }));
                } else {
                    DriveOffPage.this.mParam.getTrafficEventsCallback().showTrafficEventFeedbackDialog(false, (View) null);
                }
            }
        }
    };

    /* renamed from: d */
    private IServingController f29452d = new IServingController() {
        public /* synthetic */ void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
            IServingController.CC.$default$animateCamera(this, cameraPosition, i, cancelableCallback);
        }

        public /* synthetic */ void cancelPickupPointRecommend() {
            IServingController.CC.$default$cancelPickupPointRecommend(this);
        }

        public /* synthetic */ void destroyMarkerBubble(MapElementId mapElementId) {
            IServingController.CC.$default$destroyMarkerBubble(this, mapElementId);
        }

        public /* synthetic */ void doBestView(Padding padding) {
            ISceneController.CC.$default$doBestView(this, padding);
        }

        public /* synthetic */ LatLng getLastDriverPosition() {
            return IServingController.CC.$default$getLastDriverPosition(this);
        }

        public /* synthetic */ EtaEda getLastEtaEda() {
            return IServingController.CC.$default$getLastEtaEda(this);
        }

        public /* synthetic */ double getLeftRouteDistance() {
            return IServingController.CC.$default$getLeftRouteDistance(this);
        }

        public /* synthetic */ void hideMarkerBubble(MapElementId mapElementId) {
            IServingController.CC.$default$hideMarkerBubble(this, mapElementId);
        }

        public /* synthetic */ void onOrderStateChanged(int i, ServingParam servingParam) {
            IServingController.CC.$default$onOrderStateChanged(this, i, servingParam);
        }

        public /* synthetic */ void onPushMsgReceived(byte[] bArr) {
            IServingController.CC.$default$onPushMsgReceived(this, bArr);
        }

        public /* synthetic */ void onStartChangedForSharer(GuideStartInfo guideStartInfo) {
            IServingController.CC.$default$onStartChangedForSharer(this, guideStartInfo);
        }

        public /* synthetic */ boolean refresh3DCarIcons(boolean z, List<String> list) {
            return IServingController.CC.$default$refresh3DCarIcons(this, z, list);
        }

        public /* synthetic */ void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
            IServingController.CC.$default$refreshCarBitmapDescriptor(this, bitmapDescriptor);
        }

        public /* synthetic */ void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo) {
            IServingController.CC.$default$setCarpoolInfo(this, iFetchCarpoolInfo);
        }

        public /* synthetic */ void setCarpoolShowBubblesEnabled(boolean z) {
            IServingController.CC.$default$setCarpoolShowBubblesEnabled(this, z);
        }

        public /* synthetic */ void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
            IServingController.CC.$default$setInfoWindowClickListener(this, mapElementId, onInfoWindowClickListener);
        }

        public /* synthetic */ void setOdPoints(List<OdPoint> list, long j) {
            IServingController.CC.$default$setOdPoints(this, list, j);
        }

        public /* synthetic */ void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback) {
            IServingController.CC.$default$startModifyPickupLocation(this, address, address2, f, iLocationCallback);
        }

        public /* synthetic */ void stopModifyPickupLocation(LatLng latLng) {
            IServingController.CC.$default$stopModifyPickupLocation(this, latLng);
        }

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view);
        }

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view, position);
        }

        public /* synthetic */ void updatePickupPoint(LatLng latLng) {
            IServingController.CC.$default$updatePickupPoint(this, latLng);
        }

        public void modifyDestination(LatLng latLng) {
            DriveOffPage.this.mo81272a(DriveOffPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_END));
        }

        public void onTrafficReportClick(TrafficReportParam trafficReportParam) {
            SystemUtils.log(3, DriveOffPage.f29449a, "onTrafficReportClick: " + trafficReportParam, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.scene.sctx.DriveOffPage$2", 240);
            if (DriveOffPage.this.f29450b != null) {
                DriveOffPage.this.f29450b.showTrafficReportCenter(trafficReportParam);
            }
        }
    };
    protected long onTripSctxIntervalMillis = MapFlowApolloUtils.getOnTripSxtxIntervalMillis();

    /* access modifiers changed from: package-private */
    public int getOrderStage() {
        return 4;
    }

    public DriveOffPage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(pageScene, servingParam, mapViewHolder);
    }

    public void enter(boolean z) {
        super.enter(true);
        setServingController(this.f29452d);
        setSctxCallback(this.f29451c);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_END, false);
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
        OrderFloatWindowManager.Instance().setServingParam((ServingParam) null);
        OrderFloatWindowManager.Instance().setTripStage(getOrderStage());
        OrderFloatWindowManager.Instance().setMapSdkType(OrderFloatWindowManager.getMapSdkType(getMap()));
        if (enableTrafficEventAB()) {
            this.f29450b = TrafficReportManager.create(this.mContext);
        }
    }

    public void leave() {
        super.leave();
        this.mMarkerManager.destroy();
        removeOdMarkers();
        m22806a();
    }

    /* access modifiers changed from: package-private */
    public void doSceneBestView(Padding padding, boolean z) {
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            ArrayList arrayList = new ArrayList();
            List<IMapElement> makerMapElements = this.mMarkerManager.getMakerMapElements(MapElementId.ID_MARKER_END);
            if (!CollectionUtil.isEmpty((Collection<?>) makerMapElements)) {
                arrayList.addAll(makerMapElements);
            }
            CarMarker carMarker = this.mPassengerSctx.getCarMarker();
            if (!(carMarker == null || carMarker.getMarker() == null)) {
                arrayList.add(carMarker.getMarker());
            }
            Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_WAYPOINT);
            if (iconMarker != null) {
                arrayList.add(iconMarker);
                Marker labelMarker = this.mMarkerManager.getLabelMarker(MapElementId.ID_MARKER_WAYPOINT);
                if (labelMarker != null) {
                    arrayList.add(labelMarker);
                }
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                arrayList.addAll(routeElements);
            }
            if (!(this.mPassengerSctx == null || this.mPassengerSctx.getLines() == null)) {
                arrayList.addAll(this.mPassengerSctx.getLines());
            }
            boolean z2 = false;
            if (this.mapAutoBestViewLooper != null) {
                z2 = this.mapAutoBestViewLooper.doBestViewExecute(arrayList, padding, mapInPadding, z);
            } else {
                DLog.m10773d("InServiceSctxScene", "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                this.mScene.hideResetView();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo81272a(LatLng latLng) {
        Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_END);
        if (iconMarker == null || iconMarker.getPosition().equals(latLng)) {
            DLog.m10773d(f29449a, "refreshEndPointMarker, same LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
            return;
        }
        DLog.m10773d(f29449a, "refreshEndPointMarker, new LatLng:%s, old LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng), GoogleSyncTripLogUtil.getLatLngLogInfo(iconMarker.getPosition()));
        this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_END);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_END, latLng, false);
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        return this.onTripSctxIntervalMillis;
    }

    /* access modifiers changed from: protected */
    public boolean enableTrafficEventAB() {
        return MapFlowApolloUtils.enableTrafficEventAB() && getMap() != null && getMap().getMapVendor() == MapVendor.DIDI;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m22804a(TriggeredTrafficEventShowModel triggeredTrafficEventShowModel, ITrafficEventFeedbackViewCallback iTrafficEventFeedbackViewCallback) {
        return new TrafficEventFeedbackView(triggeredTrafficEventShowModel, iTrafficEventFeedbackViewCallback, this.mContext);
    }

    /* renamed from: a */
    private void m22806a() {
        if (this.mParam != null && enableTrafficEventAB()) {
            this.mParam.getTrafficEventsCallback().showTrafficReportEntry(false);
        }
    }
}
