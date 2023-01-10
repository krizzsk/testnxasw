package com.didi.map.global.flow.scene.vamos.orderpreview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.data.param.RouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.flow.scene.vamos.components.VamosMarkers;
import com.didi.map.global.flow.scene.vamos.components.VamosMultiLineManager;
import com.didi.map.global.flow.scene.vamos.model.VamosMultiLineModel;
import com.didi.map.global.flow.scene.vamos.orderpreview.param.VamosOrderPreviewParams;
import com.didi.map.global.flow.utils.OraDataUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class VamosOrderPreviewScene extends BaseVamosPageScene<VamosOrderPreviewParams> implements IVamosOrderPreviewController {

    /* renamed from: a */
    private static final String f29627a = "VamosOrderPreviewScene";

    /* renamed from: b */
    private static final int f29628b = 1;

    /* renamed from: c */
    private BaseLineRoute f29629c;

    /* renamed from: d */
    private Handler f29630d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                VamosOrderPreviewScene vamosOrderPreviewScene = VamosOrderPreviewScene.this;
                vamosOrderPreviewScene.m22962a("postAutoBestView", vamosOrderPreviewScene.mPadding);
                DLog.m10773d(VamosOrderPreviewScene.f29627a, "MSG_AUTO_BEST_VIEW  not null", new Object[0]);
            }
        }
    };
    protected VamosMarkers mVamosMarkers = new VamosMarkers(getMap());
    protected VamosMultiLineManager mVamosMultiLineManager = new VamosMultiLineManager(getMap(), getContext());

    public VamosOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams, MapViewHolder mapViewHolder) {
        super(vamosOrderPreviewParams, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mParam == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel() == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverStartPosition == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverEndPosition == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxEndPosition == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxStartPosition == null) {
            DLog.m10773d(f29627a, "[enter] Some params are null", new Object[0]);
            return;
        }
        initConfig();
        drawMarkers();
        requireRouteData();
    }

    public void onResume() {
        super.onResume();
        m22963a(true);
    }

    public void leave() {
        super.leave();
        removeAllMarkers();
        removeLines();
        BaseLineRoute baseLineRoute = this.f29629c;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f29629c = null;
        }
        if (!(getMap() == null || this.mParam == null)) {
            getMap().setMaxZoomLevel((float) getMap().getMaxZoomLevel());
        }
        Handler handler = this.f29630d;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        m22959a();
        m22962a("Biz doBestView", padding);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22962a(String str, Padding padding) {
        if (this.isSceneValid && getMap() != null && getContext() != null) {
            ArrayList arrayList = new ArrayList();
            VamosMarkers vamosMarkers = this.mVamosMarkers;
            if (vamosMarkers != null) {
                arrayList.addAll(vamosMarkers.getAllMarkers());
            }
            VamosMultiLineManager vamosMultiLineManager = this.mVamosMultiLineManager;
            if (vamosMultiLineManager != null && !CollectionUtil.isEmpty((Collection<?>) vamosMultiLineManager.getAllLine())) {
                arrayList.addAll(this.mVamosMultiLineManager.getAllLine());
            }
            int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
            int dp2px2 = DisplayUtils.dp2px(getContext(), 3.0f);
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, new Padding(dp2px, dp2px2, dp2px, dp2px2), (BestViewer.IBestViewListener) null);
            hideResetView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22963a(boolean z) {
        Handler handler;
        if (this.isSceneValid) {
            m22959a();
            if (z && (handler = this.f29630d) != null) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22959a() {
        Handler handler = this.f29630d;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void initConfig() {
        if (getMap() != null && this.mParam != null) {
            getMap().setMaxZoomLevel(((VamosOrderPreviewParams) this.mParam).getMaxMapZoomLevel());
        }
    }

    public void requireRouteData() {
        this.f29629c = LineDataFactory.createLineRoute(getContext(), LineDataFactory.LineDataType.ROUTE_PLAN);
        RouteLineRequest routeLineRequest = new RouteLineRequest(CallFrom.ORDERROUTEAPI_VAMOS, PaxEnvironment.getInstance().getProductId());
        routeLineRequest.setEnd(new LatLng(((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverEndPosition.latitude, ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverEndPosition.longitude));
        routeLineRequest.setStart(new LatLng(((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverStartPosition.latitude, ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mDriverStartPosition.longitude));
        routeLineRequest.setWayPoint(m22965b());
        if (((VamosOrderPreviewParams) this.mParam).getOrderInfo() != null && !TextUtils.isEmpty(((VamosOrderPreviewParams) this.mParam).getOrderInfo().getOrderId())) {
            routeLineRequest.setOrderId(((VamosOrderPreviewParams) this.mParam).getOrderInfo().getOrderId());
        }
        this.f29629c.setCacheEnable(false);
        this.f29629c.start(routeLineRequest, new IRouteSearchResultCallback() {
            public void onGetRouteResultError(String str) {
            }

            public void onGetRouteResult(LineDataResponse lineDataResponse) {
                if (lineDataResponse != null && lineDataResponse.getRoutePlanRes() != null) {
                    List<LegInfo> list = lineDataResponse.getRoutePlanRes().legsInfo;
                    VamosMultiLineModel vamosMultiLineModel = ((VamosOrderPreviewParams) VamosOrderPreviewScene.this.mParam).getVamosMultiLineModel();
                    if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                        List<LatLng> latLngListFromLegInfo = OraDataUtils.getLatLngListFromLegInfo(list.get(0));
                        if (vamosMultiLineModel != null) {
                            vamosMultiLineModel.mPickUpPoints = latLngListFromLegInfo;
                            if (list.size() > 1) {
                                vamosMultiLineModel.mPaxPoints = OraDataUtils.getLatLngListFromLegInfo(list.get(1));
                            }
                            if (list.size() > 2) {
                                vamosMultiLineModel.mHomePoints = OraDataUtils.getLatLngListFromLegInfo(list.get(2));
                            }
                        }
                        if (!(VamosOrderPreviewScene.this.mParam == null || ((VamosOrderPreviewParams) VamosOrderPreviewScene.this.mParam).getEtaEdaCallback() == null)) {
                            if (VamosOrderPreviewScene.this.isSceneValid) {
                                ((VamosOrderPreviewParams) VamosOrderPreviewScene.this.mParam).getEtaEdaCallback().onEtaEdaChanged(new EtaEda(lineDataResponse.getRoutePlanRes().eta.intValue(), lineDataResponse.getRoutePlanRes().distance.intValue()));
                            } else {
                                return;
                            }
                        }
                    }
                    if (VamosOrderPreviewScene.this.mVamosMultiLineManager != null) {
                        VamosOrderPreviewScene.this.mVamosMultiLineManager.drawLine(((VamosOrderPreviewParams) VamosOrderPreviewScene.this.mParam).getVamosMultiLineModel());
                    }
                    VamosOrderPreviewScene.this.m22959a();
                    VamosOrderPreviewScene.this.m22963a(true);
                }
            }
        });
    }

    public void drawMarkers() {
        if (this.mVamosMarkers != null && this.mParam != null && ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel() != null) {
            this.mVamosMarkers.updateAllMarkers(((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel());
        }
    }

    public void removeAllMarkers() {
        VamosMarkers vamosMarkers = this.mVamosMarkers;
        if (vamosMarkers != null) {
            vamosMarkers.removeAllMarkers();
            this.mVamosMarkers = null;
        }
    }

    public void removeLines() {
        VamosMultiLineManager vamosMultiLineManager = this.mVamosMultiLineManager;
        if (vamosMultiLineManager != null) {
            vamosMultiLineManager.removeAllLine();
            this.mVamosMultiLineManager = null;
        }
    }

    public float getMaxZoomLevel() {
        if (this.mParam != null) {
            return ((VamosOrderPreviewParams) this.mParam).getMaxMapZoomLevel();
        }
        return 19.0f;
    }

    /* renamed from: b */
    private List<LatLng> m22965b() {
        ArrayList arrayList = new ArrayList();
        if (!(this.mParam == null || ((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel() == null)) {
            if (((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxStartPosition != null) {
                arrayList.add(((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxStartPosition);
            }
            if (((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxEndPosition != null) {
                arrayList.add(((VamosOrderPreviewParams) this.mParam).getVamosMarkerModel().mPaxEndPosition);
            }
        }
        return arrayList;
    }

    public void updateStartMarkerBubble(View view) {
        VamosMarkers vamosMarkers;
        if (view != null && (vamosMarkers = this.mVamosMarkers) != null) {
            vamosMarkers.addOrUpdatePaxStartMarkerBubble(view);
        }
    }

    public void updateEndMarkerBubble(View view) {
        VamosMarkers vamosMarkers;
        if (view != null && (vamosMarkers = this.mVamosMarkers) != null) {
            vamosMarkers.addOrUpdatePaxEndMarkerBubble(view);
        }
    }
}
