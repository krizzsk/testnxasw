package com.didi.map.global.flow.scene.vamos.orderwait;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.didi.map.global.flow.scene.vamos.orderwait.param.VamosOrderWaitParams;
import com.didi.map.global.flow.utils.OraDataUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class VamosOrderWaitScene extends BaseVamosPageScene<VamosOrderWaitParams> implements IVamosOrderWaitController {

    /* renamed from: a */
    private static final String f29638a = "VamosOrderWaitScene";

    /* renamed from: b */
    private static final int f29639b = 600000;

    /* renamed from: c */
    private static final int f29640c = 10000;

    /* renamed from: d */
    private static final int f29641d = 0;

    /* renamed from: e */
    private static final int f29642e = 1;

    /* renamed from: f */
    private BaseLineRoute f29643f;

    /* renamed from: g */
    private Handler f29644g = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                VamosOrderWaitScene.this.requireRouteData();
                sendEmptyMessageDelayed(0, 600000);
            } else if (i == 1) {
                VamosOrderWaitScene vamosOrderWaitScene = VamosOrderWaitScene.this;
                vamosOrderWaitScene.m22976a("postAutoBestView", vamosOrderWaitScene.mPadding);
                DLog.m10773d(VamosOrderWaitScene.f29638a, "MSG_AUTO_BEST_VIEW  not null", new Object[0]);
            }
        }
    };
    protected VamosMarkers mVamosMarkers = new VamosMarkers(getMap());
    protected VamosMultiLineManager mVamosMultiLineManager = new VamosMultiLineManager(getMap(), getContext());

    /* access modifiers changed from: protected */
    public abstract LatLng getRouteEndPoint();

    /* access modifiers changed from: protected */
    public abstract List<LatLng> getWayPoint();

    /* access modifiers changed from: protected */
    public abstract boolean isAutoPolling();

    /* access modifiers changed from: protected */
    public abstract boolean paramsCheck();

    public VamosOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams, MapViewHolder mapViewHolder) {
        super(vamosOrderWaitParams, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        Handler handler;
        super.enter(bundle);
        if (!paramsCheck()) {
            DLog.m10773d(f29638a, "[enter] Some params are null", new Object[0]);
            return;
        }
        drawMarkers();
        requireRouteData();
        if (isAutoPolling() && (handler = this.f29644g) != null) {
            handler.sendEmptyMessageDelayed(0, 600000);
        }
    }

    public void onResume() {
        super.onResume();
        m22977a(true);
    }

    public void leave() {
        super.leave();
        removeAllMarkers();
        removeLines();
        BaseLineRoute baseLineRoute = this.f29643f;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f29643f = null;
        }
        Handler handler = this.f29644g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
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

    public void drawMarkers() {
        if (this.mVamosMarkers != null && this.mParam != null && ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel() != null) {
            this.mVamosMarkers.updateAllMarkers(((VamosOrderWaitParams) this.mParam).getVamosMarkerModel());
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

    /* access modifiers changed from: protected */
    public void requireRouteData() {
        this.f29643f = LineDataFactory.createLineRoute(getContext(), LineDataFactory.LineDataType.ROUTE_PLAN);
        RouteLineRequest routeLineRequest = new RouteLineRequest(CallFrom.ORDERROUTEAPI_VAMOS, PaxEnvironment.getInstance().getProductId());
        routeLineRequest.setEnd(getRouteEndPoint());
        routeLineRequest.setStart(new LatLng(((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mDriverStartPosition.latitude, ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mDriverStartPosition.longitude));
        routeLineRequest.setWayPoint(getWayPoint());
        this.f29643f.setCacheEnable(false);
        this.f29643f.start(routeLineRequest, new IRouteSearchResultCallback() {
            public void onGetRouteResultError(String str) {
            }

            public void onGetRouteResult(LineDataResponse lineDataResponse) {
                if (lineDataResponse != null && lineDataResponse.getRoutePlanRes() != null) {
                    List<LegInfo> list = lineDataResponse.getRoutePlanRes().legsInfo;
                    VamosMultiLineModel vamosMultiLineModel = ((VamosOrderWaitParams) VamosOrderWaitScene.this.mParam).getVamosMultiLineModel();
                    if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                        if (vamosMultiLineModel != null) {
                            vamosMultiLineModel.mPickUpPoints = OraDataUtils.getLatLngListFromLegInfo(list.get(0));
                            if (list.size() > 1) {
                                vamosMultiLineModel.mPaxPoints = OraDataUtils.getLatLngListFromLegInfo(list.get(1));
                            }
                            if (list.size() > 2) {
                                vamosMultiLineModel.mHomePoints = OraDataUtils.getLatLngListFromLegInfo(list.get(2));
                            }
                        }
                        if (!(VamosOrderWaitScene.this.mParam == null || ((VamosOrderWaitParams) VamosOrderWaitScene.this.mParam).getEtaEdaCallback() == null)) {
                            if (VamosOrderWaitScene.this.isSceneValid) {
                                ((VamosOrderWaitParams) VamosOrderWaitScene.this.mParam).getEtaEdaCallback().onEtaEdaChanged(new EtaEda(lineDataResponse.getRoutePlanRes().eta.intValue(), lineDataResponse.getRoutePlanRes().distance.intValue()));
                            } else {
                                return;
                            }
                        }
                    }
                    if (VamosOrderWaitScene.this.mVamosMultiLineManager != null) {
                        VamosOrderWaitScene.this.mVamosMultiLineManager.drawLine(vamosMultiLineModel);
                    }
                    VamosOrderWaitScene.this.m22973a();
                    VamosOrderWaitScene.this.m22977a(true);
                }
            }
        });
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        m22973a();
        m22976a("Biz doBestView", padding);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22976a(String str, Padding padding) {
        if (this.isSceneValid) {
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
    public void m22977a(boolean z) {
        Handler handler;
        if (this.isSceneValid) {
            m22973a();
            if (z && (handler = this.f29644g) != null) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22973a() {
        Handler handler = this.f29644g;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }
}
