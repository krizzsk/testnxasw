package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.minibus.component.MiniBusGuideEntranceComponent;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavConfirmDialog;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavErrorHintDialog;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo80431id = 3003)
public class MiniBusWaitingScene extends BaseMiniBusSctxScene {

    /* renamed from: a */
    private static final String f28932a = "MiniBusWaitingScene";

    /* renamed from: b */
    private boolean f28933b = MapFlowApolloUtils.isQuickenOraRequestIntervalNearPickup();

    /* renamed from: c */
    private int f28934c = MapFlowApolloUtils.getOraRequestDistanceNearPickup();

    /* renamed from: d */
    private long f28935d = MapFlowApolloUtils.getOraRequestIntervalNearPickup();

    /* renamed from: e */
    private JumpNavConfirmDialog f28936e;

    /* renamed from: f */
    private JumpNavErrorHintDialog f28937f;

    /* renamed from: g */
    private MiniBusGuideEntranceComponent f28938g;
    protected long pickupSctxIntervalMillis = MapFlowApolloUtils.getPickupSctxIntervalMillis();

    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public boolean showWayPoints() {
        return true;
    }

    public MiniBusWaitingScene(MiniBusSctxSceneParam miniBusSctxSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusSctxSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        enterSctxService();
        if (this.mParam != null && ((MiniBusSctxSceneParam) this.mParam).getParamInterface() != null) {
            MiniBusGuideComponentParam miniBusGuideComponentParam = new MiniBusGuideComponentParam();
            miniBusGuideComponentParam.setOrderParams(((MiniBusSctxSceneParam) this.mParam).getParamInterface().getOrderParams());
            miniBusGuideComponentParam.setStreetParam(((MiniBusSctxSceneParam) this.mParam).getParamInterface().getStreetParam());
            MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = new MiniBusGuideEntranceComponent(getMap(), ((MiniBusSctxSceneParam) this.mParam).getContext(), miniBusGuideComponentParam);
            this.f28938g = miniBusGuideEntranceComponent;
            miniBusGuideEntranceComponent.setSceneValid(true);
            DLog.m10773d(f28932a, "小巴街景已经创建，创建参数如下：", new Object[0]);
            DLog.m10773d(f28932a, ((MiniBusSctxSceneParam) this.mParam).getParamInterface().getStreetParam().toString(), new Object[0]);
        }
    }

    public void leave() {
        super.leave();
        MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = this.f28938g;
        if (miniBusGuideEntranceComponent != null) {
            miniBusGuideEntranceComponent.setSceneValid(false);
            this.f28938g.destroy();
            this.f28938g = null;
        }
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f28936e;
        if (jumpNavConfirmDialog != null) {
            if (jumpNavConfirmDialog.isShowing()) {
                this.f28936e.dismiss();
            }
            this.f28936e = null;
        }
        JumpNavErrorHintDialog jumpNavErrorHintDialog = this.f28937f;
        if (jumpNavErrorHintDialog != null) {
            if (jumpNavErrorHintDialog.isShowing()) {
                this.f28937f.dismiss();
            }
            this.f28937f = null;
        }
    }

    /* access modifiers changed from: protected */
    public List<CommonLineParam> getDashLineParams() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) this.lineParams)) {
            for (CommonLineParam commonLineParam : this.lineParams) {
                if (commonLineParam != null && MapElementId.ID_LINE_START_PICKUP == commonLineParam.getId()) {
                    LatLng a = m22554a();
                    if (a != null) {
                        commonLineParam.setStartPoint(a);
                    }
                    commonLineParam.setAnimate(true);
                    arrayList.add(commonLineParam);
                    if (!(commonLineParam.getStartPoint() == null || commonLineParam.getEndPoint() == null)) {
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(commonLineParam.getStartPoint(), commonLineParam.getEndPoint());
                        DLog.m10773d(f28932a, "乘客位置和上车点之间的距离：" + computeDistanceBetween, new Object[0]);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<CommonMarkerParam> getShowMarkerParams() {
        ArrayList arrayList = new ArrayList();
        if (this.markerParams != null && !CollectionUtil.isEmpty((Collection<?>) this.markerParams)) {
            for (CommonMarkerParam commonMarkerParam : this.markerParams) {
                if (commonMarkerParam != null && MapElementId.ID_MARKER_PICK_UP == commonMarkerParam.getId()) {
                    arrayList.add(commonMarkerParam);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        String str;
        LatLng driverPoint;
        long j = this.pickupSctxIntervalMillis;
        if (!this.f28933b || this.mPassengerSctx == null || (driverPoint = this.mPassengerSctx.getDriverPoint()) == null || DDSphericalUtil.computeDistanceBetween(driverPoint, getMarkerPointWithId(MapElementId.ID_MARKER_START)) >= ((double) this.f28934c)) {
            str = "正常轮训间隔";
        } else {
            j = this.f28935d;
            str = "临近上车点轮训间隔";
        }
        DLog.m10773d(f28932a, "接驾段当前Ora轮训间隔:%dms(%s)", Long.valueOf(j), str);
        return j;
    }

    public void onOrderStateChanged(int i, OrderParams orderParams) {
        this.orderParam = orderParams;
        if (i != 2 && i != 3 && i != 4) {
            updateScene();
        }
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        boolean z2 = false;
        DLog.m10773d(f28932a, "doSceneBestView, start", new Object[0]);
        if (this.isSceneValid && getContext() != null && getMap() != null) {
            Padding defaultPadding = getDefaultPadding();
            ArrayList arrayList = new ArrayList();
            if (this.mMapView != null) {
                List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
                if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            List<IMapElement> markerElementWithId = getMarkerElementWithId(MapElementId.ID_MARKER_PICK_UP.name());
            if (!CollectionUtil.isEmpty((Collection<?>) markerElementWithId)) {
                arrayList.addAll(markerElementWithId);
            }
            MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = this.f28938g;
            if (miniBusGuideEntranceComponent != null && !CollectionUtil.isEmpty((Collection<?>) miniBusGuideEntranceComponent.getMarker())) {
                arrayList.addAll(this.f28938g.getMarker());
            }
            if (this.dashLineComponent != null && !CollectionUtil.isEmpty((Collection<?>) this.dashLineComponent.getBestViewElements())) {
                arrayList.addAll(this.dashLineComponent.getBestViewElements());
            }
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
                DLog.m10773d(f28932a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }

    /* renamed from: a */
    private LatLng m22554a() {
        try {
            if (this.mParam == null || ((MiniBusSctxSceneParam) this.mParam).getContext() == null) {
                return null;
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(((MiniBusSctxSceneParam) this.mParam).getContext());
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            DLog.m10773d(f28932a, "getPassengerLatLng is null", new Object[0]);
            return null;
        }
    }
}
