package com.didi.map.sdk.departure.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.internal.bubble.RecBubbleController;
import com.didi.map.sdk.departure.internal.data.DepartureDataUtils;
import com.didi.map.sdk.departure.internal.data.DepartureHttpTask;
import com.didi.map.sdk.departure.internal.data.DepartureHttpTaskParam;
import com.didi.map.sdk.departure.internal.data.IDepartureHttpTask;
import com.didi.map.sdk.departure.internal.data.OnDepartureHttpTaskListener;
import com.didi.map.sdk.departure.internal.markers.IRecMarkerController;
import com.didi.map.sdk.departure.internal.markers.RecMarkerController;
import com.didi.map.sdk.departure.internal.markers.RecMarkerControllerParam;
import com.didi.map.sdk.departure.internal.markers.RecPoint;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.internal.pin.DeparturePinDrawer;
import com.didi.map.sdk.departure.internal.pin.IPinDrawer;
import com.didi.map.sdk.departure.internal.rec.IRecMarker;
import com.didi.map.sdk.departure.internal.rec.OnRecMarkClickListener;
import com.didi.map.sdk.departure.internal.util.ApolloUtils;
import com.didi.map.sdk.departure.internal.util.FenceUtils;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.map.sdk.departure.internal.util.PinActionUtil;
import com.didi.map.sdk.departure.internal.util.ThreadManager;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.map.sdk.fencecomponent.FenceComponentParam;
import com.didi.map.sdk.fencecomponent.FenceDrawer;
import com.didi.map.sdk.fencecomponent.IFenceDrawer;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.WindowUtil;
import com.google.gson.Gson;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.GeoFence;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepartureCoreManager implements IDepartureCompContract {
    public static final int ZOOM_AUTO_SHOW_RECOMMEND_DEPARTURE = 15;

    /* renamed from: a */
    private static final String f30562a = "DepartureCoreManager";

    /* renamed from: A */
    private boolean f30563A = false;

    /* renamed from: B */
    private OnDepartureHttpTaskListener f30564B = new OnDepartureHttpTaskListener() {
        public void onPrepare(LatLng latLng, int i) {
            if (DepartureCoreManager.this.f30568d.get() == i) {
                if (!(DepartureCoreManager.this.f30565C == null || DepartureCoreManager.this.f30565C.listener == null)) {
                    DepartureCoreManager.this.f30565C.listener.onDepartureLoading(latLng);
                }
                if (DepartureCoreManager.this.f30570f != null) {
                    DepartureCoreManager.this.f30570f.startLoadingAnimation();
                }
            }
        }

        public void onSuccess(ReverseStationsInfo reverseStationsInfo, int i) {
            DLog.m10773d(DepartureCoreManager.f30562a, "OnDepartureHttpTaskListener onSuccess()", new Object[0]);
            if (DepartureCoreManager.this.f30568d.get() == i) {
                DepartureCoreManager.this.m23578a(reverseStationsInfo);
            }
            OmegaUtil.trackPinReqSuccess();
        }

        public void onFail(int i, int i2) {
            DLog.m10773d(DepartureCoreManager.f30562a, "OnDepartureHttpTaskListener onFail()", new Object[0]);
            if (DepartureCoreManager.this.f30568d.get() == i2) {
                DepartureCoreManager.this.m23578a((ReverseStationsInfo) null);
            }
            OmegaUtil.trackPinReqFail(i);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: C */
    public DepartureCompParam f30565C;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f30566b;

    /* renamed from: c */
    private Context f30567c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicInteger f30568d = new AtomicInteger(-1);

    /* renamed from: e */
    private IDepartureHttpTask f30569e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IPinDrawer f30570f;

    /* renamed from: g */
    private int f30571g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IRecMarkerController f30572h;

    /* renamed from: i */
    private boolean f30573i;

    /* renamed from: j */
    private int f30574j;

    /* renamed from: k */
    private float f30575k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RpcPoi f30576l;

    /* renamed from: m */
    private IFenceDrawer f30577m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f30578n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f30579o = false;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CameraPosition f30580p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f30581q = false;

    /* renamed from: r */
    private DepartureLocationInfo f30582r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ReverseStationsInfo f30583s;

    /* renamed from: t */
    private List<RpcPoi> f30584t = null;

    /* renamed from: u */
    private MapListener f30585u = new MapListener();

    /* renamed from: v */
    private NetworkReceiver f30586v = new NetworkReceiver();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f30587w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public LatLng f30588x;

    /* renamed from: y */
    private DepartureAddress f30589y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f30590z = -1;

    public void create(Context context, Map map) {
        this.f30566b = map;
        this.f30567c = context.getApplicationContext();
        this.f30573i = ApolloUtils.isNeedAdsorbControlEnabled();
        this.f30574j = ApolloUtils.getNeedAdsorbControlMaxDistance();
        this.f30575k = ApolloUtils.getNeedAdsorbControlPercentage();
        this.f30571g = ApolloUtils.getMoveDistanceLimit();
        OmegaUtil.isPinFirstShow = false;
        OmegaUtil.isFirst = true;
    }

    public void destroy() {
        stop();
        this.f30566b = null;
        this.f30567c = null;
        OmegaUtil.hasDragged = false;
        OmegaUtil.isPinFirstShow = false;
    }

    public void setConfigParam(DepartureCompParam departureCompParam) {
        if (departureCompParam != null) {
            this.f30565C = departureCompParam;
        } else {
            this.f30565C = null;
        }
    }

    public void onMapVisible(boolean z) {
        IDepartureHttpTask iDepartureHttpTask = this.f30569e;
        if (iDepartureHttpTask != null) {
            iDepartureHttpTask.onMapVisible(z);
        }
    }

    public void start() {
        if (!this.f30587w) {
            int i = 0;
            DLog.m10773d(f30562a, "start()", new Object[0]);
            this.f30587w = true;
            m23573a();
            m23591c();
            m23597f();
            this.f30581q = m23582a(this.f30567c);
            if (this.f30565C.locationInfo != null) {
                if (this.f30565C.locationInfo.sugPoi != null) {
                    i = this.f30565C.locationInfo.sugPoi.operationType;
                }
                m23576a(this.f30565C.locationInfo, i, -1);
            }
        }
    }

    public void stop() {
        DLog.m10773d(f30562a, "stop()", new Object[0]);
        Map map = this.f30566b;
        if (map != null) {
            map.stopAnimation();
        }
        this.f30587w = false;
        this.f30581q = false;
        m23588b();
        m23593d();
        m23596e();
        m23600g();
        m23604i();
        m23601h();
        removeDepartureBubble(false);
    }

    public boolean isStarted() {
        return this.f30587w;
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        IPinDrawer iPinDrawer = this.f30570f;
        if (iPinDrawer != null) {
            return iPinDrawer.createDepartureBubble(cls);
        }
        return null;
    }

    public void removeDepartureBubble(boolean z) {
        IPinDrawer iPinDrawer = this.f30570f;
        if (iPinDrawer != null) {
            iPinDrawer.removeDepartureBubble(z);
        }
    }

    /* renamed from: a */
    private void m23573a() {
        Map map = this.f30566b;
        if (map != null) {
            map.addOnCameraChangeListener(this.f30585u);
            this.f30566b.addOnMapGestureListener(this.f30585u);
        }
    }

    /* renamed from: b */
    private void m23588b() {
        Map map = this.f30566b;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f30585u);
            this.f30566b.removeOnMapGestureListener(this.f30585u);
        }
    }

    /* renamed from: c */
    private void m23591c() {
        try {
            m23593d();
            if (this.f30567c != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                try {
                    this.f30567c.registerReceiver(this.f30586v, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private void m23593d() {
        try {
            if (this.f30567c != null) {
                try {
                    this.f30567c.unregisterReceiver(this.f30586v);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m23576a(DepartureLocationInfo departureLocationInfo, int i, int i2) {
        if (this.f30565C != null && departureLocationInfo != null) {
            if (OmegaUtil.isFirst) {
                this.f30563A = true;
            }
            DLog.m10773d(f30562a, "startHttp：" + departureLocationInfo.toString() + ",scrollType =" + i2, new Object[0]);
            m23596e();
            DepartureHttpTask departureHttpTask = new DepartureHttpTask();
            this.f30569e = departureHttpTask;
            departureHttpTask.create(this.f30567c, this.f30566b);
            this.f30569e.setConfigParam(new DepartureHttpTaskParam.Builder().departureTime(this.f30565C.departureTime).callFrom(this.f30565C.callFrom).isNeedFence(this.f30565C.isFenceVisible).locationInfo(departureLocationInfo).operationType(i).apiType(this.f30565C.apiType).listener(this.f30564B).taskID(this.f30568d.incrementAndGet()).timeOut(this.f30565C.timeOut).isNeedNLP(this.f30565C.isNeedNLP).build());
            this.f30569e.start();
            this.f30582r = departureLocationInfo;
            this.f30590z = i2;
        }
    }

    /* renamed from: e */
    private void m23596e() {
        IDepartureHttpTask iDepartureHttpTask = this.f30569e;
        if (iDepartureHttpTask != null) {
            iDepartureHttpTask.stop();
            this.f30569e.destroy();
            this.f30569e = null;
            this.f30568d.getAndIncrement();
        }
    }

    /* renamed from: f */
    private void m23597f() {
        DepartureCompParam departureCompParam;
        if (this.f30570f == null && this.f30566b != null && (departureCompParam = this.f30565C) != null && departureCompParam.isPinVisible) {
            DeparturePinDrawer departurePinDrawer = new DeparturePinDrawer();
            this.f30570f = departurePinDrawer;
            departurePinDrawer.create(this.f30567c, this.f30566b);
            this.f30570f.setConfigParam(this.f30565C.pinStyle);
            this.f30570f.add();
            OmegaUtil.map_fist_pin_show(this.f30567c, m23605j(), this.f30565C, false);
        }
    }

    /* renamed from: g */
    private void m23600g() {
        IPinDrawer iPinDrawer = this.f30570f;
        if (iPinDrawer != null) {
            iPinDrawer.remove();
            this.f30570f.destroy();
            this.f30570f = null;
        }
    }

    /* renamed from: a */
    private void m23577a(FenceInfo fenceInfo) {
        if (this.f30566b != null && fenceInfo != null && fenceInfo.drawFence != 0 && !CollectionUtil.isEmpty((Collection<?>) fenceInfo.polygon) && this.f30565C.isFenceVisible) {
            m23601h();
            FenceDrawer fenceDrawer = new FenceDrawer();
            this.f30577m = fenceDrawer;
            fenceDrawer.create(this.f30567c, this.f30566b);
            FenceComponentParam.Builder builder = new FenceComponentParam.Builder();
            ArrayList arrayList = new ArrayList();
            arrayList.add(FenceUtils.convert2FencePolygon(fenceInfo.polygon));
            builder.fences(arrayList).fillColor(DepartureConstants.FENCE_FILL_COLOR).strokeColor(DepartureConstants.FENCE_STROKE_COLOR).strokeWidth(2.0f).limitZoom(13.0d);
            this.f30577m.setConfigParam(builder.build());
            this.f30577m.add();
            SystemUtils.log(6, "ccc", "添加围栏" + this.f30577m.hashCode(), (Throwable) null, "com.didi.map.sdk.departure.internal.DepartureCoreManager", 387);
        }
    }

    /* renamed from: a */
    private void m23579a(List<RecPoint> list) {
        if (this.f30583s != null && this.f30565C != null && this.f30566b != null && !CollectionUtil.isEmpty((Collection<?>) list) && this.f30565C.isRecPointVisible) {
            m23604i();
            RecMarkerController recMarkerController = new RecMarkerController();
            this.f30572h = recMarkerController;
            recMarkerController.create(this.f30567c, this.f30566b);
            RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
            recMarkerControllerParam.list = list;
            recMarkerControllerParam.icon = this.f30565C.recStyle.icon;
            recMarkerControllerParam.selectedIcon = this.f30565C.recStyle.selectedIcon;
            recMarkerControllerParam.isClickable = true;
            recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener() {
                public final void onClick(IRecMarker iRecMarker) {
                    DepartureCoreManager.this.m23575a(iRecMarker);
                }
            };
            this.f30572h.setConfigParam(recMarkerControllerParam);
            this.f30572h.add();
            if (DepartureDataUtils.isAllowShowCircles(this.f30583s)) {
                this.f30572h.showCircles();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23575a(IRecMarker iRecMarker) {
        if (!LatLngUtil.isSameLatLng(iRecMarker.getLocation(), m23605j())) {
            RpcPoi findTargetRecommend = DepartureDataUtils.findTargetRecommend(iRecMarker.getLocation(), this.f30584t);
            this.f30576l = findTargetRecommend;
            this.f30589y = m23571a(findTargetRecommend);
            RpcPoi rpcPoi = this.f30576l;
            if (rpcPoi != null) {
                final LatLng latLng = new LatLng(rpcPoi.base_info.lat, this.f30576l.base_info.lng);
                PinActionUtil.animateCamera(this.f30566b, latLng, true, false, this.f30565C.zoom, new CancelableCallback() {
                    public void onCancel() {
                    }

                    public void onFinish() {
                        PinActionUtil.startAdsorbRecommendAnimation(DepartureCoreManager.this.f30570f, 10, DepartureCoreManager.this.f30572h, latLng);
                        OmegaUtil.map_recommend_drag(DepartureCoreManager.this.f30576l);
                    }
                });
                DepartureCompParam departureCompParam = this.f30565C;
                if (departureCompParam != null && departureCompParam.listener != null) {
                    if (this.f30589y != null) {
                        this.f30565C.listener.onDepartureAddressChanged(this.f30589y);
                        return;
                    }
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = this.f30565C.listener;
                    DepartureLocationInfo departureLocationInfo = this.f30582r;
                    iDepartueCompCallback.onFetchAddressFailed(departureLocationInfo != null ? departureLocationInfo.latLng : null);
                }
            }
        }
    }

    /* renamed from: h */
    private void m23601h() {
        IFenceDrawer iFenceDrawer = this.f30577m;
        if (iFenceDrawer != null) {
            iFenceDrawer.destroy();
            SystemUtils.log(6, "ccc", "删除围栏" + this.f30577m.hashCode(), (Throwable) null, "com.didi.map.sdk.departure.internal.DepartureCoreManager", 452);
            this.f30577m = null;
        }
    }

    /* renamed from: i */
    private void m23604i() {
        IRecMarkerController iRecMarkerController = this.f30572h;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f30572h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public LatLng m23605j() {
        Map map = this.f30566b;
        if (map == null || map.getCameraPosition() == null) {
            return null;
        }
        return this.f30566b.getCameraPosition().target;
    }

    class MapListener implements OnCameraChangeListener, OnMapGestureListener {
        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        public boolean onUp(float f, float f2) {
            return false;
        }

        MapListener() {
        }

        public boolean onScroll(float f, float f2) {
            boolean unused = DepartureCoreManager.this.f30579o = true;
            if (!DepartureCoreManager.this.f30578n) {
                DepartureCoreManager departureCoreManager = DepartureCoreManager.this;
                LatLng unused2 = departureCoreManager.f30588x = departureCoreManager.m23605j();
                if (!(DepartureCoreManager.this.f30565C == null || DepartureCoreManager.this.f30565C.listener == null)) {
                    DepartureCoreManager.this.f30565C.listener.onStartDragging();
                }
                if (DepartureCoreManager.this.f30570f != null) {
                    DepartureCoreManager.this.f30570f.startJumpAnimation(new DepartureMarkerView.AnimationFinishListener() {
                        public void onFinish() {
                        }
                    });
                }
                OmegaUtil.map_base_slide();
            }
            boolean unused3 = DepartureCoreManager.this.f30578n = true;
            OmegaUtil.hasDragged = true;
            DepartureCoreManager.this.m23607k();
            return false;
        }

        public boolean onDown(float f, float f2) {
            if (DepartureCoreManager.this.f30566b == null) {
                return false;
            }
            DepartureCoreManager departureCoreManager = DepartureCoreManager.this;
            CameraPosition unused = departureCoreManager.f30580p = departureCoreManager.f30566b.getCameraPosition();
            return false;
        }

        public void onMapStable() {
            OmegaUtil.hasDragged = false;
            DepartureCoreManager.this.m23609l();
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (DepartureCoreManager.this.f30580p != null && DepartureCoreManager.this.f30566b != null && DepartureCoreManager.this.f30572h != null) {
                DepartureCoreManager.this.f30572h.onZoomChange(DepartureCoreManager.this.f30566b.getCameraPosition().zoom);
            }
        }
    }

    /* renamed from: a */
    private boolean m23583a(CameraPosition cameraPosition, CameraPosition cameraPosition2) {
        return (cameraPosition == null || cameraPosition2 == null || LatLngUtil.isSameLatLng(cameraPosition.target, cameraPosition2.target)) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m23607k() {
        m23596e();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m23609l() {
        DepartureCompParam departureCompParam;
        IRecMarkerController iRecMarkerController = this.f30572h;
        if (!(iRecMarkerController == null || iRecMarkerController.findMarker(m23605j()) == null)) {
            this.f30572h.hideCircles();
        }
        IRecMarkerController iRecMarkerController2 = this.f30572h;
        if (iRecMarkerController2 != null) {
            iRecMarkerController2.setNeedShowInfoWindow(m23612m());
            this.f30572h.onMapStable();
        }
        if (this.f30578n && (departureCompParam = this.f30565C) != null && departureCompParam.requireByDrag) {
            LatLng j = m23605j();
            DepartureLocationInfo departureLocationInfo = this.f30582r;
            updateDepartureLocation_inner(new DepartureLocationInfo(j, departureLocationInfo != null ? departureLocationInfo.sugPoi : null, "wgs84"), 1, 0);
            this.f30578n = false;
            this.f30588x = null;
        } else if (OmegaUtil.isFirst && !this.f30563A && this.f30565C != null) {
            OmegaUtil.trackPinMove(m23605j(), 0, this.f30590z, this.f30565C.callFrom);
        }
    }

    /* renamed from: m */
    private boolean m23612m() {
        DepartureAddress departureAddress;
        if (!(RecBubbleController.hasBubbleDesc(this.f30589y) || (departureAddress = this.f30589y) == null || departureAddress.getAddress() == null)) {
            RpcPoi address = this.f30589y.getAddress();
            if (address.base_info == null || TextUtils.isEmpty(address.base_info.srctag) || (!DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(address.base_info.srctag) && !DepartureConstants.SRCTAG_DIDIFENCE_COMMON.equals(address.base_info.srctag))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m23582a(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    class NetworkReceiver extends BroadcastReceiver {
        NetworkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION) && DepartureCoreManager.this.f30587w) {
                boolean a = DepartureCoreManager.this.m23582a(context);
                if (a && !DepartureCoreManager.this.f30581q && DepartureCoreManager.this.f30583s == null && !DepartureCoreManager.this.f30578n) {
                    boolean unused = DepartureCoreManager.this.f30578n = true;
                    DepartureCoreManager.this.m23609l();
                }
                boolean unused2 = DepartureCoreManager.this.f30581q = a;
            }
        }
    }

    public RpcPoi sensing() {
        Map map = this.f30566b;
        RpcPoi rpcPoi = null;
        if (map != null && map.getCameraPosition().zoom >= 15.0d) {
            double d = Double.MAX_VALUE;
            List<RpcPoi> list = this.f30584t;
            if (list != null && !list.isEmpty()) {
                for (RpcPoi next : this.f30584t) {
                    LatLng latLng = new LatLng(next.base_info.lat, next.base_info.lng);
                    double a = m23568a(m23605j(), latLng);
                    double distance = LatLngUtil.getDistance(m23605j(), latLng);
                    if (m23581a(a, distance) && distance < d) {
                        rpcPoi = next;
                        d = distance;
                    }
                }
            }
        }
        return rpcPoi;
    }

    /* renamed from: a */
    private double m23568a(LatLng latLng, LatLng latLng2) {
        Projection projection = this.f30566b.getProjection();
        if (projection == null) {
            return -1.0d;
        }
        PointF screenLocation = projection.toScreenLocation(latLng);
        PointF screenLocation2 = projection.toScreenLocation(latLng2);
        return Math.sqrt(Math.pow((double) Math.abs(screenLocation.x - screenLocation2.x), 2.0d) + Math.pow((double) Math.abs(screenLocation.y - screenLocation2.y), 2.0d));
    }

    /* renamed from: a */
    private boolean m23581a(double d, double d2) {
        boolean z = m23580a(d) && d < Double.MAX_VALUE;
        if (!this.f30573i || d2 <= ((double) this.f30574j)) {
            return z;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m23580a(double d) {
        if (d >= 0.0d && d / ((double) WindowUtil.getWindowWidth(this.f30567c)) <= ((double) this.f30575k)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23578a(ReverseStationsInfo reverseStationsInfo) {
        IPinDrawer iPinDrawer = this.f30570f;
        if (iPinDrawer != null) {
            iPinDrawer.stopAnimation();
        }
        LatLng latLng = null;
        if (reverseStationsInfo != null) {
            this.f30583s = reverseStationsInfo;
            m23601h();
            m23604i();
            m23577a(reverseStationsInfo.startFenceInfo);
            ArrayList<RpcPoi> recStartPoints = this.f30583s.getRecStartPoints();
            this.f30584t = recStartPoints;
            if (CollectionUtil.isEmpty((Collection<?>) recStartPoints) && reverseStationsInfo.geofenceTags != null && !reverseStationsInfo.geofenceTags.isEmpty() && reverseStationsInfo.geofenceTags.contains("airport")) {
                this.f30584t = DepartureDataUtils.getSpecialRpcPois(this.f30583s);
            }
            ArrayList arrayList = new ArrayList();
            if (!CollectionUtil.isEmpty((Collection<?>) this.f30584t)) {
                for (RpcPoi next : this.f30584t) {
                    RecPoint recPoint = new RecPoint();
                    recPoint.addrName = next.base_info.displayname;
                    recPoint.location = new LatLng(next.base_info.lat, next.base_info.lng);
                    recPoint.srctag = next.base_info.srctag;
                    arrayList.add(recPoint);
                }
            }
            RpcPoi findRecommendAdsorbPoint = DepartureDataUtils.findRecommendAdsorbPoint(this.f30584t);
            this.f30576l = findRecommendAdsorbPoint;
            this.f30589y = m23571a(findRecommendAdsorbPoint);
            m23579a((List<RecPoint>) arrayList);
            if (this.f30572h != null) {
                RpcPoi rpcPoi = this.f30576l;
                if (rpcPoi == null || rpcPoi.base_info == null) {
                    DLog.m10773d(f30562a, "HandleRecvHttpRsp：未吸附:", new Object[0]);
                } else {
                    final LatLng latLng2 = new LatLng(this.f30576l.base_info.lat, this.f30576l.base_info.lng);
                    DLog.m10773d(f30562a, "HandleRecvHttpRsp：吸附:" + latLng2.toString(), new Object[0]);
                    PinActionUtil.animateCamera(this.f30566b, latLng2, true, false, this.f30565C.zoom, new CancelableCallback() {
                        public void onCancel() {
                        }

                        public void onFinish() {
                            PinActionUtil.startAdsorbRecommendAnimation(DepartureCoreManager.this.f30570f, 10, DepartureCoreManager.this.f30572h, latLng2);
                            OmegaUtil.map_recommend_drag(DepartureCoreManager.this.f30576l);
                        }
                    });
                }
            }
            DepartureCompParam departureCompParam = this.f30565C;
            if (!(departureCompParam == null || departureCompParam.listener == null)) {
                if (this.f30589y != null) {
                    this.f30565C.listener.onDepartureAddressChanged(this.f30589y);
                } else {
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = this.f30565C.listener;
                    DepartureLocationInfo departureLocationInfo = this.f30582r;
                    if (departureLocationInfo != null) {
                        latLng = departureLocationInfo.latLng;
                    }
                    iDepartueCompCallback.onFetchAddressFailed(latLng);
                }
            }
        } else {
            DepartureCompParam departureCompParam2 = this.f30565C;
            if (!(departureCompParam2 == null || departureCompParam2.listener == null)) {
                IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback2 = this.f30565C.listener;
                DepartureLocationInfo departureLocationInfo2 = this.f30582r;
                if (departureLocationInfo2 != null) {
                    latLng = departureLocationInfo2.latLng;
                }
                iDepartueCompCallback2.onFetchAddressFailed(latLng);
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                if (DepartureCoreManager.this.f30565C == null) {
                    return;
                }
                if (DepartureCoreManager.this.f30572h == null || DepartureCoreManager.this.f30576l == null || DepartureCoreManager.this.f30576l.base_info == null) {
                    OmegaUtil.trackPinMove(DepartureCoreManager.this.m23605j(), 0, DepartureCoreManager.this.f30590z, DepartureCoreManager.this.f30565C.callFrom);
                } else {
                    OmegaUtil.trackPinMove(DepartureCoreManager.this.m23605j(), 1, DepartureCoreManager.this.f30590z, DepartureCoreManager.this.f30565C.callFrom);
                }
            }
        }, 500);
    }

    /* renamed from: a */
    private DepartureAddress m23571a(RpcPoi rpcPoi) {
        boolean z;
        RpcPoi rpcPoi2;
        if (this.f30583s == null) {
            return null;
        }
        if (rpcPoi == null || !LatLngUtil.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng)) {
            rpcPoi2 = this.f30583s.getDepartureAddress();
            if (rpcPoi2 != null && !TextUtils.isEmpty(this.f30583s.specialPoiList)) {
                rpcPoi2.specialPoiList = this.f30583s.specialPoiList;
            }
            z = false;
        } else {
            if (!TextUtils.isEmpty(this.f30583s.specialPoiList)) {
                rpcPoi.specialPoiList = this.f30583s.specialPoiList;
            }
            rpcPoi2 = rpcPoi;
            z = true;
        }
        if (rpcPoi2 == null) {
            return null;
        }
        GeoFence geoFence = this.f30583s.geoFence;
        if (geoFence != null) {
            rpcPoi2.geofence = geoFence.f58765id;
        }
        DepartureAddress departureAddress = new DepartureAddress();
        departureAddress.setAddress(rpcPoi2);
        departureAddress.setRecommendPoi(z);
        if (rpcPoi == null || !rpcPoi.isInNoStopZone) {
            departureAddress.setFenceInfo(DepartureDataUtils.getFenceInfo(this.f30583s));
            departureAddress.setZoneStatus(0);
        } else {
            try {
                departureAddress.setFenceInfo((FenceInfo) new Gson().fromJson(this.f30583s.specialPoiList, FenceInfo.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
            departureAddress.setZoneStatus(1);
        }
        departureAddress.setSpecialPoiGuidance(this.f30583s.specialPoiGuidance);
        departureAddress.setRecommendDestinations(this.f30583s.recDestination);
        if (!TextUtils.isEmpty(rpcPoi2.base_info.displayname)) {
            departureAddress.setDepartureDisplayName(rpcPoi2.base_info.displayname);
        } else {
            departureAddress.setDepartureDisplayName("");
        }
        departureAddress.setSpecialPois(DepartureDataUtils.getSpecialPois(this.f30583s));
        departureAddress.setLanguage(this.f30583s.language);
        departureAddress.setGeofenceTags(this.f30583s.geofenceTags);
        departureAddress.setPickUpPointSize(DepartureDataUtils.getRecommendPoiCount(this.f30583s));
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30583s.result)) {
            departureAddress.setRgeoResult(this.f30583s.result.get(0));
        }
        if (this.f30579o) {
            departureAddress.setOperationType(1);
        } else {
            DepartureCompParam departureCompParam = this.f30565C;
            if (departureCompParam == null || departureCompParam.locationInfo == null || this.f30565C.locationInfo.sugPoi == null) {
                departureAddress.setOperationType(0);
            } else {
                departureAddress.setOperationType(this.f30565C.locationInfo.sugPoi.operationType);
            }
        }
        return departureAddress;
    }

    /* renamed from: a */
    private boolean m23586a(DepartureLocationInfo departureLocationInfo) {
        return (departureLocationInfo == null || departureLocationInfo.latLng == null || !LatLngUtil.locateCorrect(departureLocationInfo.latLng)) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateDepartureLocation_inner(com.didi.map.sdk.departure.param.DepartureLocationInfo r12, int r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.m23586a((com.didi.map.sdk.departure.param.DepartureLocationInfo) r12)
            if (r0 == 0) goto L_0x0131
            boolean r0 = r11.f30587w
            if (r0 != 0) goto L_0x000c
            goto L_0x0131
        L_0x000c:
            com.didi.common.map.Map r0 = r11.f30566b
            if (r0 == 0) goto L_0x0016
            com.didi.common.map.model.CameraPosition r0 = r0.getCameraPosition()
            r11.f30580p = r0
        L_0x0016:
            r0 = 0
            com.didi.map.sdk.departure.param.DepartureLocationInfo r1 = r11.f30582r
            r2 = 1
            if (r1 != 0) goto L_0x001f
        L_0x001c:
            r0 = 1
            goto L_0x00f8
        L_0x001f:
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r11.f30583s
            if (r1 != 0) goto L_0x0024
            goto L_0x001c
        L_0x0024:
            com.didi.common.map.model.LatLng r1 = r12.latLng
            com.didi.map.sdk.departure.param.DepartureLocationInfo r3 = r11.f30582r
            com.didi.common.map.model.LatLng r3 = r3.latLng
            boolean r1 = com.didi.map.sdk.departure.internal.util.LatLngUtil.isSameLatLng(r1, r3)
            if (r1 == 0) goto L_0x0031
            return
        L_0x0031:
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r11.f30583s
            com.sdk.poibase.model.poi.FenceInfo r1 = r1.startFenceInfo
            boolean r3 = com.didi.map.sdk.departure.internal.util.FenceUtils.isFenceMustAbsorb(r1)
            r4 = 0
            if (r3 == 0) goto L_0x009f
            com.didi.common.map.Map r3 = r11.f30566b
            com.didi.common.map.model.LatLng r5 = r11.m23605j()
            boolean r1 = com.didi.map.sdk.departure.internal.util.FenceUtils.positionIsInFence(r3, r1, r5)
            if (r1 == 0) goto L_0x001c
            com.didi.common.map.model.LatLng r1 = r11.m23605j()
            java.util.List<com.sdk.poibase.model.RpcPoi> r2 = r11.f30584t
            com.sdk.poibase.model.RpcPoi r1 = com.didi.map.sdk.departure.internal.data.DepartureDataUtils.findTargetRecommend(r1, r2)
            r11.f30576l = r1
            if (r1 == 0) goto L_0x00f8
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r2 = r11.f30572h
            if (r2 == 0) goto L_0x00f8
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r12 = r1.base_info
            double r12 = r12.lat
            com.sdk.poibase.model.RpcPoi r14 = r11.f30576l
            com.sdk.poibase.model.RpcPoiBaseInfo r14 = r14.base_info
            double r0 = r14.lng
            r6.<init>((double) r12, (double) r0)
            com.didi.common.map.Map r5 = r11.f30566b
            r7 = 1
            r8 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            float r9 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$5 r10 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$5
            r10.<init>(r6)
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r5, r6, r7, r8, r9, r10)
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            if (r12 == 0) goto L_0x009e
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            if (r12 == 0) goto L_0x009e
            com.sdk.poibase.model.RpcPoi r12 = r11.f30576l
            com.didi.map.sdk.departure.DepartureAddress r12 = r11.m23571a((com.sdk.poibase.model.RpcPoi) r12)
            if (r12 == 0) goto L_0x0091
            com.didi.map.sdk.departure.param.DepartureCompParam r13 = r11.f30565C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r13 = r13.listener
            r13.onDepartureAddressChanged(r12)
            goto L_0x009e
        L_0x0091:
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            com.didi.map.sdk.departure.param.DepartureLocationInfo r13 = r11.f30582r
            if (r13 == 0) goto L_0x009b
            com.didi.common.map.model.LatLng r4 = r13.latLng
        L_0x009b:
            r12.onFetchAddressFailed(r4)
        L_0x009e:
            return
        L_0x009f:
            com.sdk.poibase.model.RpcPoi r1 = r11.sensing()
            r11.f30576l = r1
            if (r1 == 0) goto L_0x001c
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r3 = r11.f30572h
            if (r3 == 0) goto L_0x001c
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r1.base_info
            double r1 = r1.lat
            com.sdk.poibase.model.RpcPoi r3 = r11.f30576l
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r3.base_info
            double r7 = r3.lng
            r6.<init>((double) r1, (double) r7)
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r1 = r11.f30572h
            com.didi.map.sdk.departure.internal.rec.IRecMarker r1 = r1.findMarker(r6)
            if (r1 == 0) goto L_0x00f8
            com.didi.common.map.Map r5 = r11.f30566b
            r7 = 1
            r8 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            float r9 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$6 r10 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$6
            r10.<init>(r6)
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r5, r6, r7, r8, r9, r10)
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            if (r12 == 0) goto L_0x00f7
            com.sdk.poibase.model.RpcPoi r12 = r11.f30576l
            com.didi.map.sdk.departure.DepartureAddress r12 = r11.m23571a((com.sdk.poibase.model.RpcPoi) r12)
            if (r12 == 0) goto L_0x00ea
            com.didi.map.sdk.departure.param.DepartureCompParam r13 = r11.f30565C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r13 = r13.listener
            r13.onDepartureAddressChanged(r12)
            goto L_0x00f7
        L_0x00ea:
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            com.didi.map.sdk.departure.param.DepartureLocationInfo r13 = r11.f30582r
            if (r13 == 0) goto L_0x00f4
            com.didi.common.map.model.LatLng r4 = r13.latLng
        L_0x00f4:
            r12.onFetchAddressFailed(r4)
        L_0x00f7:
            return
        L_0x00f8:
            if (r0 == 0) goto L_0x0131
            com.didi.map.sdk.departure.param.DepartureLocationInfo r0 = r11.f30582r
            if (r0 == 0) goto L_0x012e
            int r0 = r11.f30571g
            r1 = -1
            if (r0 <= r1) goto L_0x012e
            com.didi.common.map.model.LatLng r0 = r12.latLng
            com.didi.map.sdk.departure.param.DepartureLocationInfo r1 = r11.f30582r
            com.didi.common.map.model.LatLng r1 = r1.latLng
            double r0 = com.didi.map.sdk.departure.internal.util.LatLngUtil.getDistance(r0, r1)
            int r2 = r11.f30571g
            double r2 = (double) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x012e
            com.didi.common.map.model.LatLng r12 = r11.f30588x
            if (r12 != 0) goto L_0x011c
            com.didi.map.sdk.departure.param.DepartureLocationInfo r12 = r11.f30582r
            com.didi.common.map.model.LatLng r12 = r12.latLng
        L_0x011c:
            r1 = r12
            com.didi.common.map.Map r0 = r11.f30566b
            r2 = 1
            r3 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f30565C
            float r4 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$7 r5 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$7
            r5.<init>()
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r0, r1, r2, r3, r4, r5)
            return
        L_0x012e:
            r11.m23576a(r12, r13, r14)
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.departure.internal.DepartureCoreManager.updateDepartureLocation_inner(com.didi.map.sdk.departure.param.DepartureLocationInfo, int, int):void");
    }

    public void updateDepartureLocation(DepartureLocationInfo departureLocationInfo, boolean z) {
        if (departureLocationInfo == null) {
            return;
        }
        if (z) {
            updateDepartureLocation_inner(departureLocationInfo, 1, 1);
        } else {
            updateDepartureLocation_inner(departureLocationInfo, departureLocationInfo.sugPoi == null ? 0 : departureLocationInfo.sugPoi.operationType, 1);
        }
    }
}
