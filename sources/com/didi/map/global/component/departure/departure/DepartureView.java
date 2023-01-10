package com.didi.map.global.component.departure.departure;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.apolllo.LocFollowToggleApollo;
import com.didi.map.global.component.departure.bubble.DepartureWalkGuide;
import com.didi.map.global.component.departure.carpool.CarpoolDepartureController;
import com.didi.map.global.component.departure.circle.ZoneCircleController;
import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.controller.DepartureControllerParams;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.departure.DeparturePresenter;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.manager.DepartureOmegaManager;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;
import com.didi.map.global.component.departure.pin.DeparturePinView;
import com.didi.map.global.component.departure.pin.IDeparturePinView;
import com.didi.map.global.component.departure.pin.IPinDrawer;
import com.didi.map.global.component.departure.util.DepartureOmegaUtils;
import com.didi.map.global.component.departure.util.DepartureStyleUtils;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.departure.util.FenceUtils;
import com.didi.map.global.component.departure.util.PinActionUtils;
import com.didi.map.global.component.departure.util.TerminalUtils;
import com.didi.map.global.component.departure.util.ThreadManager;
import com.didi.map.global.component.departure.view.DepartureCardViewController;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.didi.map.global.component.departure.view.RichTextInfo;
import com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper;
import com.didi.map.global.component.departure.walkdrop.WalkDropWrapper;
import com.didi.map.global.component.recmarker.IRecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerCallback;
import com.didi.map.global.component.recmarker.RecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerControllerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DepartureView implements IDepartureView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f27346A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public AtomicBoolean f27347B;

    /* renamed from: C */
    private boolean f27348C;

    /* renamed from: D */
    private int f27349D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Handler f27350E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Padding f27351F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public Runnable f27352G;

    /* renamed from: H */
    private int f27353H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public DepartureInterceptController f27354I;

    /* renamed from: J */
    private boolean f27355J;

    /* renamed from: K */
    private LatLng f27356K;

    /* renamed from: L */
    private ICollideStrategy f27357L;

    /* renamed from: M */
    private boolean f27358M;

    /* renamed from: N */
    private boolean f27359N;

    /* renamed from: O */
    private DepartureAddress f27360O;

    /* renamed from: P */
    private DepartureWalkGuide f27361P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f27362Q;

    /* renamed from: R */
    private RpcPoi f27363R;

    /* renamed from: S */
    private long f27364S;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f27365a = "DepartureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureCompParams f27366b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f27367c;

    /* renamed from: d */
    private Context f27368d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDepartureCompContract.IDepartureComponentCallback f27369e;

    /* renamed from: f */
    private boolean f27370f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDeparturePinView f27371g;

    /* renamed from: h */
    private FenceController f27372h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IRecMarkerController f27373i;

    /* renamed from: j */
    private DepartureCardViewController f27374j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CarpoolDepartureController f27375k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public DepartureOmegaManager f27376l = new DepartureOmegaManager();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ZoneCircleController f27377m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public DeparturePresenter f27378n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IWalkDropWrapper f27379o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f27380p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f27381q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f27382r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public DepartureLocationInfo f27383s;

    /* renamed from: t */
    private boolean f27384t = true;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public LatLng f27385u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<RpcPoi> f27386v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public DepartureAddress f27387w;

    /* renamed from: x */
    private MapListener f27388x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ReverseStationsInfo f27389y;

    /* renamed from: z */
    private DIDILocation f27390z;

    public DepartureView(Map map, Context context, DepartureCompParams departureCompParams) {
        DepartureLocationInfo departureLocationInfo = null;
        this.f27385u = null;
        this.f27386v = null;
        this.f27388x = new MapListener();
        this.f27346A = 0;
        this.f27347B = new AtomicBoolean(false);
        this.f27348C = false;
        this.f27350E = new Handler(Looper.getMainLooper());
        this.f27352G = new Runnable() {
            public void run() {
                if (DepartureView.this.f27347B.get() || DepartureView.this.f27380p) {
                    if (DepartureView.this.f27350E != null && DepartureView.this.f27351F != null) {
                        DepartureView.this.f27350E.postDelayed(DepartureView.this.f27352G, 100);
                    }
                } else if (DepartureView.this.f27367c != null && DepartureView.this.f27367c.getCameraPosition() != null && DepartureView.this.f27351F != null) {
                    if (DepartureView.this.f27351F == null || !DepartureView.this.f27351F.equals(DepartureView.this.f27367c.getPadding())) {
                        DepartureView departureView = DepartureView.this;
                        departureView.m21695g(departureView.f27367c.getCameraPosition().target);
                    }
                }
            }
        };
        this.f27363R = null;
        this.f27364S = System.currentTimeMillis();
        if (departureCompParams != null) {
            DepartureOmegaUtils.isFirst = true;
            this.f27367c = map;
            this.f27368d = context;
            this.f27366b = departureCompParams;
            this.f27353H = DisplayUtils.dp2px(context, 10.0f);
            this.f27351F = m21730y();
            DepartureCompParams departureCompParams2 = this.f27366b;
            this.f27383s = m21629a(departureCompParams2 != null ? departureCompParams2.getLocationInfo() : departureLocationInfo);
            m21631a();
            DeparturePresenter departurePresenter = new DeparturePresenter(map, context, departureCompParams);
            this.f27378n = departurePresenter;
            departurePresenter.setResponseCallback(new DeparturePresenter.IResponseCallback() {
                public void onLoading(LatLng latLng) {
                    if (DepartureView.this.f27366b.isBubbleVisible() && DepartureView.this.f27371g != null) {
                        DepartureView.this.f27371g.startLoading(DepartureView.this.m21677c(latLng) || DepartureView.this.m21684d(latLng));
                    }
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.f27369e.onDepartureLoading(latLng);
                    }
                }

                public void onHandleResult(ReverseStationsInfo reverseStationsInfo) {
                    DepartureView.this.m21654a(reverseStationsInfo);
                }

                public void onLocationChange(DIDILocation dIDILocation) {
                    DepartureView.this.m21651a(dIDILocation);
                }
            });
            Address endPoint = this.f27366b.getEndPoint();
            if (endPoint != null) {
                this.f27356K = new LatLng(endPoint.getLatitude(), endPoint.getLongitude());
            }
            boolean isHasWayPoint = this.f27366b.isHasWayPoint();
            this.f27355J = isHasWayPoint;
            this.f27354I = new DepartureInterceptController(new DepartureControllerParams(this.f27368d, this.f27367c, this.f27349D, isHasWayPoint, this.f27356K, (DepartureAddress) null, this.f27372h));
        }
    }

    /* renamed from: a */
    private DepartureLocationInfo m21629a(DepartureLocationInfo departureLocationInfo) {
        DIDILocation lastKnownLocation;
        if (departureLocationInfo == null) {
            m21655a("初始化 locationInfo= null");
            departureLocationInfo = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        } else {
            m21655a("初始化 locationInfo= " + departureLocationInfo.toString());
        }
        if (departureLocationInfo.sugPoi != null) {
            this.f27346A = departureLocationInfo.sugPoi.operationType;
            m21655a("初始化mInnerOperationType= " + this.f27346A);
        }
        if (departureLocationInfo.sugPoi != null && departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = new LatLng(departureLocationInfo.sugPoi.latitude, departureLocationInfo.sugPoi.longitude);
            m21655a("从sug初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureDataStore.getInstance().getPinLocation();
            m21655a("从缓存初始化latLng");
        }
        if (departureLocationInfo.latLng == null && (lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27368d)) != null) {
            departureLocationInfo.latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            m21655a("从定位初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(this.f27367c);
            m21655a("从map初始化latLng");
        }
        if (departureLocationInfo.latLng != null) {
            m21655a("初始化latLng : " + departureLocationInfo.latLng.toString());
            return departureLocationInfo;
        }
        throw new IllegalArgumentException("departureView don't have a default location");
    }

    /* renamed from: a */
    private void m21631a() {
        DepartureCompParams departureCompParams = this.f27366b;
        if (departureCompParams != null) {
            DepartureFenceOptions fenceOptions = departureCompParams.getFenceOptions();
            if (fenceOptions != null) {
                this.f27372h = new FenceController(this.f27367c, fenceOptions);
            }
            ZoneCircleOption circleOption = this.f27366b.getCircleOption();
            if (circleOption != null) {
                this.f27377m = new ZoneCircleController(this.f27367c, circleOption, this.f27368d);
            }
            int sceneType = this.f27366b.getSceneType();
            this.f27349D = sceneType;
            if (sceneType == 1) {
                this.f27375k = new CarpoolDepartureController(this.f27367c, sceneType);
            }
            if (this.f27366b.isWalkDropVisible() || this.f27366b.isGuideLineVisible()) {
                WalkDropWrapper walkDropWrapper = new WalkDropWrapper(this.f27368d, this.f27367c);
                this.f27379o = walkDropWrapper;
                walkDropWrapper.setSceneType(this.f27349D);
                this.f27379o.setGuideLineEnable(this.f27366b.isGuideLineVisible());
                this.f27379o.setWalkDropEnable(this.f27366b.isWalkDropVisible());
                this.f27379o.setDestPoint(this.f27366b.getEndPoint());
                this.f27379o.onCreate();
            }
        }
    }

    /* renamed from: b */
    private void m21661b() {
        Map map = this.f27367c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f27388x);
            this.f27367c.addOnMapGestureListener(this.f27388x);
        }
    }

    /* renamed from: c */
    private void m21674c() {
        Map map = this.f27367c;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f27388x);
            this.f27367c.removeOnMapGestureListener(this.f27388x);
        }
    }

    /* renamed from: d */
    private boolean m21683d() {
        DepartureFenceOptions fenceOptions;
        if (!(!this.f27366b.isTerminalViewVisible() || (fenceOptions = this.f27366b.getFenceOptions()) == null || fenceOptions.cardWizardStart == 0)) {
            if (fenceOptions.cardWizardStart == 2) {
                return this.f27374j.isWelcomeViewValid();
            }
            if (fenceOptions.cardWizardStart == 1) {
                return this.f27374j.isWaitCheckPickupSpot();
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m21689e() {
        DepartureCompParams departureCompParams = this.f27366b;
        return departureCompParams != null && departureCompParams.isRecPointVisible() && (this.f27374j == null || !m21683d());
    }

    /* renamed from: f */
    private void m21691f() {
        DepartureCompParams departureCompParams = this.f27366b;
        if (departureCompParams != null && this.f27367c != null && departureCompParams.isPinVisible()) {
            m21694g();
            DeparturePinView departurePinView = new DeparturePinView(this.f27367c.getContext());
            this.f27371g = departurePinView;
            departurePinView.create(this.f27368d, this.f27367c);
            this.f27371g.setConfigParam(this.f27366b.getPinStyle());
            this.f27371g.add();
        }
    }

    public void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f27369e = iDepartureComponentCallback;
    }

    /* renamed from: g */
    private void m21694g() {
        IDeparturePinView iDeparturePinView = this.f27371g;
        if (iDeparturePinView != null) {
            iDeparturePinView.destroy();
            this.f27371g = null;
        }
    }

    /* renamed from: h */
    private void m21697h() {
        ZoneCircleController zoneCircleController = this.f27377m;
        if (zoneCircleController != null) {
            zoneCircleController.showCircle();
        }
    }

    /* renamed from: a */
    private void m21646a(DepartureAddress departureAddress) {
        DepartureCompParams departureCompParams;
        if (this.f27372h != null && (departureCompParams = this.f27366b) != null && departureCompParams.isFenceVisible()) {
            this.f27372h.showFence(departureAddress);
            ReverseStationsInfo reverseStationsInfo = this.f27389y;
            if (reverseStationsInfo != null) {
                this.f27372h.showAroundFenceList(reverseStationsInfo.aroundFenceList);
            }
        }
    }

    /* renamed from: a */
    private void m21656a(List<RecPoint> list, boolean z) {
        if (this.f27389y == null || CollectionUtil.isEmpty((Collection<?>) list) || this.f27366b == null || this.f27367c == null || this.f27368d == null) {
            m21655a("showRecMarkers() return");
            return;
        }
        m21702k();
        if (!m21689e()) {
            m21655a("showRecMarkers() isRecPointVisible is false,return");
            return;
        }
        RecMarkerController recMarkerController = new RecMarkerController();
        this.f27373i = recMarkerController;
        recMarkerController.create(this.f27367c.getContext(), this.f27367c);
        RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
        recMarkerControllerParam.list = list;
        RecPointStyle pinRecStyle = DepartureStyleUtils.getPinRecStyle(this.f27368d, this.f27366b);
        if (pinRecStyle != null) {
            recMarkerControllerParam.icon = pinRecStyle.icon;
            recMarkerControllerParam.selectedIcon = pinRecStyle.selectedIcon;
        }
        recMarkerControllerParam.isClickable = true;
        recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener(z, list) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(IRecMarker iRecMarker) {
                DepartureView.this.m21657a(this.f$1, this.f$2, iRecMarker);
            }
        };
        recMarkerControllerParam.markerCallback = new RecMarkerCallback() {
            public void onRecMarkerShow(RecPoint recPoint, boolean z) {
                DepartureOmegaUtils.trackShowRecMarker(recPoint, z ? 1 : 0);
            }
        };
        recMarkerControllerParam.isShowLabel = false;
        ICollideStrategy collideStrategyV1 = CollideStrategyFactory.getCollideStrategyV1(new IDMarkerContractV1() {
            public /* synthetic */ int getDefaultLabelPosition() {
                return IDMarkerContractV1.CC.$default$getDefaultLabelPosition(this);
            }

            public /* synthetic */ List<Rect> getDisabledRect() {
                return IDMarkerContractV1.CC.$default$getDisabledRect(this);
            }

            public /* synthetic */ int getEnableLabelPosition() {
                return IDMarkerContractV1.CC.$default$getEnableLabelPosition(this);
            }

            public /* synthetic */ int getHot(String str) {
                return IDMarkerContractV1.CC.$default$getHot(this, str);
            }

            public /* synthetic */ boolean getIsLabelHideWhenPined() {
                return IDMarkerContractV1.CC.$default$getIsLabelHideWhenPined(this);
            }

            public boolean isCanWork() {
                return true;
            }

            public /* synthetic */ boolean isLabelDirectClockwise() {
                return IDMarkerContractV1.CC.$default$isLabelDirectClockwise(this);
            }

            public /* synthetic */ boolean isPined(String str) {
                return IDMarkerContractV1.CC.$default$isPined(this, str);
            }

            public /* synthetic */ boolean isZoomConditionOnly() {
                return IDMarkerContractV1.CC.$default$isZoomConditionOnly(this);
            }

            public /* synthetic */ void setLabelDirect(String str, int i) {
                IDMarkerContractV1.CC.$default$setLabelDirect(this, str, i);
            }

            public Map getMap() {
                return DepartureView.this.f27367c;
            }

            public void setVisible(String str, boolean z) {
                if (DepartureView.this.f27373i != null) {
                    DepartureView.this.f27373i.setVisible(str, z);
                }
            }
        });
        this.f27357L = collideStrategyV1;
        recMarkerControllerParam.strategy = collideStrategyV1;
        this.f27373i.setConfigParam(recMarkerControllerParam);
        this.f27373i.add();
        if (DepartureUtils.isAllowShowCircles(this.f27389y)) {
            this.f27373i.showCircles();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21657a(boolean z, List list, IRecMarker iRecMarker) {
        if (!LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DepartureUtils.getMapCenterPoint(this.f27367c))) {
            DepartureCardViewController departureCardViewController = this.f27374j;
            boolean z2 = false;
            boolean z3 = departureCardViewController != null && departureCardViewController.isTerminalViewValid();
            if (!z || !z3) {
                RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(iRecMarker.getLocation(), this.f27386v);
                this.f27387w = m21628a(findTargetRecommend);
                StringBuilder sb = new StringBuilder();
                sb.append("recMarker.Onclick adsorbPoi is null:");
                if (findTargetRecommend == null) {
                    z2 = true;
                }
                sb.append(z2);
                m21655a(sb.toString());
                if (findTargetRecommend != null) {
                    LatLng latLng = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                    this.f27385u = latLng;
                    if (z3) {
                        this.f27374j.setSelectedDeparture(findTargetRecommend);
                        m21652a(findTargetRecommend, this.f27385u, true, true);
                        this.f27376l.reportOmegaOnTerminalRecPickupChange(findTargetRecommend, 2);
                        return;
                    }
                    m21652a(findTargetRecommend, latLng, true, true);
                    m21664b(this.f27387w);
                    IWalkDropWrapper iWalkDropWrapper = this.f27379o;
                    if (iWalkDropWrapper != null) {
                        iWalkDropWrapper.onNormalAdsorbedOk(this.f27385u, this.f27387w);
                        return;
                    }
                    return;
                }
                return;
            }
            RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(iRecMarker.getLocation(), list);
            if (findTargetRecPoint != null && !TextUtils.isEmpty(findTargetRecPoint.addrName)) {
                SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m21716r(), findTargetRecPoint.addrName);
                m21649a(adsorbTerminalAreaByName);
                this.f27376l.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
                this.f27374j.setSelectedTerminalArea(adsorbTerminalAreaByName);
                m21655a("recMarker.Onclick mTerminalView.isValid() is true");
                IWalkDropWrapper iWalkDropWrapper2 = this.f27379o;
                if (iWalkDropWrapper2 != null) {
                    iWalkDropWrapper2.onRspAirport();
                }
            }
        }
    }

    /* renamed from: i */
    private void m21699i() {
        FenceController fenceController = this.f27372h;
        if (fenceController != null) {
            fenceController.removeFence();
            this.f27372h.removeAroundFenceList();
        }
    }

    /* renamed from: j */
    private void m21701j() {
        ZoneCircleController zoneCircleController = this.f27377m;
        if (zoneCircleController != null) {
            zoneCircleController.hideCircle();
        }
    }

    /* renamed from: k */
    private void m21702k() {
        ICollideStrategy iCollideStrategy = this.f27357L;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f27357L = null;
        }
        IRecMarkerController iRecMarkerController = this.f27373i;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f27373i = null;
        }
    }

    public void setFenceVisible(boolean z) {
        FenceController fenceController = this.f27372h;
        if (fenceController != null) {
            fenceController.setFenceVisible(z);
        }
    }

    public void onMapVisible(boolean z) {
        this.f27370f = z;
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
            LatLng mapCenterPoint;
            boolean unused = DepartureView.this.f27382r = true;
            if (!DepartureView.this.f27381q) {
                DepartureView.this.m21655a("start dragging");
                if (DepartureView.this.f27373i != null) {
                    DepartureView.this.f27373i.onMapScroll();
                }
                if (!(DepartureView.this.f27377m == null || DepartureView.this.f27377m.getCircle() == null || (mapCenterPoint = DepartureUtils.getMapCenterPoint(DepartureView.this.f27367c)) == null || !DepartureView.this.f27377m.getCircle().contains(mapCenterPoint))) {
                    DepartureView.this.f27376l.reportOmegaChangeStartCircle(1);
                }
                if (DepartureView.this.f27375k != null) {
                    DepartureView.this.f27375k.removeCircle(true);
                }
                if (DepartureView.this.f27378n != null) {
                    DepartureView.this.f27378n.stopRequest();
                }
                if (DepartureView.this.f27354I != null) {
                    DepartureView.this.f27354I.setHasDragged(true);
                }
                if (DepartureView.this.f27379o != null) {
                    DepartureView.this.f27379o.onMapDragStart();
                }
            }
            DepartureOmegaUtils.OmegaParams.scrollType = 0;
            DepartureOmegaUtils.hasDragged = true;
            DepartureView.this.m21733z();
            boolean unused2 = DepartureView.this.f27381q = true;
            return false;
        }

        public boolean onDown(float f, float f2) {
            boolean unused = DepartureView.this.f27380p = true;
            if (DepartureView.this.f27350E != null) {
                DepartureView.this.f27350E.removeCallbacks(DepartureView.this.f27352G);
            }
            int unused2 = DepartureView.this.f27346A = 1;
            return false;
        }

        public void onMapStable() {
            DepartureView.this.m21705l();
            boolean unused = DepartureView.this.f27381q = false;
            boolean unused2 = DepartureView.this.f27380p = false;
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (DepartureView.this.f27367c != null) {
                if (DepartureView.this.f27377m != null) {
                    DepartureView.this.f27377m.handleMapDrag(DepartureUtils.getMapCenterPoint(DepartureView.this.f27367c));
                }
                if (DepartureView.this.f27379o != null) {
                    DepartureView.this.f27379o.onCameraChange(DepartureUtils.getMapCenterPoint(DepartureView.this.f27367c));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m21705l() {
        DepartureLocationInfo departureLocationInfo = this.f27383s;
        if (departureLocationInfo == null || !LatLngUtils.isSameLatLng(departureLocationInfo.latLng, DepartureUtils.getMapCenterPoint(this.f27367c))) {
            LatLng latLng = this.f27385u;
            if (latLng != null && LatLngUtils.isSameLatLng(latLng, DepartureUtils.getMapCenterPoint(this.f27367c))) {
                m21655a("handleMapStable 相同吸附点");
            } else if (this.f27382r) {
                IRecMarkerController iRecMarkerController = this.f27373i;
                if (!(iRecMarkerController == null || iRecMarkerController.findMarker(DepartureUtils.getMapCenterPoint(this.f27367c)) == null)) {
                    this.f27373i.hideCircles();
                }
                IRecMarkerController iRecMarkerController2 = this.f27373i;
                if (iRecMarkerController2 != null) {
                    iRecMarkerController2.setNeedShowInfoWindow(false);
                    this.f27373i.onMapStable();
                }
                if (this.f27366b.isRequireByDrag()) {
                    m21634a(DepartureUtils.getMapCenterPoint(this.f27367c));
                }
                IWalkDropWrapper iWalkDropWrapper = this.f27379o;
                if (iWalkDropWrapper != null) {
                    iWalkDropWrapper.onMapDragEnd();
                }
            }
        } else {
            m21655a("handleMapStable 相同请求点");
        }
    }

    /* renamed from: b */
    private boolean m21672b(DepartureLocationInfo departureLocationInfo) {
        return departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng);
    }

    public void onConfirmClickInBroadOther() {
        this.f27362Q = false;
        this.f27358M = true;
        m21654a(this.f27389y);
    }

    public void setPadding(Padding padding) {
        if (this.f27367c != null && padding != null) {
            padding.left = Math.max(padding.left, this.f27353H);
            padding.right = Math.max(padding.right, this.f27353H);
            if (!this.f27367c.getPadding().equals(padding)) {
                this.f27351F = padding;
                DLog.m10773d("DepartureView", "setPadding ->: " + this.f27351F.toString(), new Object[0]);
                Handler handler = this.f27350E;
                if (handler != null) {
                    handler.removeCallbacks(this.f27352G);
                    this.f27350E.postDelayed(this.f27352G, 100);
                }
            }
        }
    }

    /* renamed from: a */
    private void m21634a(LatLng latLng) {
        DepartureLocationInfo departureLocationInfo;
        m21655a("doSomethingWhenMapStable =====" + latLng.toString());
        if (!LatLngUtils.locateCorrect(latLng) || (departureLocationInfo = this.f27383s) == null || !this.f27370f) {
            m21692f(latLng);
            m21655a("doSomethingWhenMapStable :异常情况");
        } else if (this.f27377m != null) {
            if (m21622B()) {
                LatLng center = this.f27377m.getCenter();
                if (!(this.f27383s.latLng == null || this.f27377m.getCircle() == null || !this.f27377m.getCircle().contains(this.f27383s.latLng))) {
                    center = this.f27383s.latLng;
                }
                m21688e(center);
                this.f27383s.latLng = center;
                m21655a("doSomethingWhenMapStable :修改上车点圆外");
            } else {
                this.f27383s.latLng = latLng;
                m21655a("doSomethingWhenMapStable :修改上车点圆内");
            }
            m21648a(this.f27383s, this.f27346A);
        } else if (this.f27389y == null) {
            departureLocationInfo.latLng = latLng;
            m21648a(this.f27383s, this.f27346A);
            m21655a("doSomethingWhenMapStable :首次移动地图");
        } else if (m21677c(latLng)) {
            RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(latLng, this.f27386v);
            if (findTargetRecommend != null) {
                LatLng latLng2 = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                this.f27385u = latLng2;
                m21652a(findTargetRecommend, latLng2, true, true);
                DepartureAddress a = m21628a(findTargetRecommend);
                m21664b(a);
                if (!(this.f27379o == null || findTargetRecommend.base_info == null)) {
                    this.f27379o.onNormalAdsorbedOk(new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng), a);
                }
                m21655a("doSomethingWhenMapStable :禁停吸附");
                return;
            }
            this.f27383s.latLng = latLng;
            m21648a(this.f27383s, this.f27346A);
            m21655a("doSomethingWhenMapStable :禁停未吸附");
        } else {
            FenceController fenceController = this.f27372h;
            if (fenceController == null || fenceController.getFenceType() != 0) {
                DeparturePresenter departurePresenter = this.f27378n;
                RpcPoi sensing = departurePresenter != null ? departurePresenter.sensing(this.f27386v) : null;
                if (!(sensing == null || this.f27373i == null)) {
                    m21655a("doSomethingWhenMapStable is 5% poi");
                    LatLng latLng3 = new LatLng(sensing.base_info.lat, sensing.base_info.lng);
                    this.f27385u = latLng3;
                    if (this.f27373i.findMarker(latLng3) != null) {
                        m21652a(sensing, this.f27385u, true, true);
                        DepartureAddress a2 = m21628a(sensing);
                        m21664b(a2);
                        if (!(this.f27379o == null || sensing == null || sensing.base_info == null)) {
                            this.f27379o.onNormalAdsorbedOk(this.f27385u, a2);
                        }
                        m21655a("doSomethingWhenMapStable :普通场景吸附");
                        return;
                    }
                }
                m21655a("doSomethingWhenMapStable :普通场景未吸附");
                this.f27383s.latLng = latLng;
                m21648a(this.f27383s, this.f27346A);
                return;
            }
            IWalkDropWrapper iWalkDropWrapper = this.f27379o;
            if (iWalkDropWrapper != null) {
                iWalkDropWrapper.onRspAirport();
            }
            if (m21668b(latLng)) {
                m21655a("doSomethingWhenMapStable :场站外请求");
                this.f27383s.latLng = latLng;
                m21648a(this.f27383s, this.f27346A);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.sdk.poibase.model.RpcPoi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.didi.map.global.component.recmarker.model.RecPoint} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m21668b(com.didi.common.map.model.LatLng r9) {
        /*
            r8 = this;
            r0 = 0
            r8.f27359N = r0
            com.didi.common.map.Map r1 = r8.f27367c
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r8.f27389y
            com.sdk.poibase.model.poi.FenceInfo r2 = r2.startFenceInfo
            boolean r1 = com.didi.map.global.component.departure.util.FenceUtils.positionIsInFence(r1, r2, r9)
            r2 = 1
            if (r1 == 0) goto L_0x00bc
            boolean r1 = r8.f27362Q
            if (r1 == 0) goto L_0x0024
            r8.m21692f((com.didi.common.map.model.LatLng) r9)
            com.didi.map.global.component.departure.IDepartureCompContract$IDepartureComponentCallback r9 = r8.f27369e
            if (r9 == 0) goto L_0x001e
            r9.onBroadOtherMapCallback(r0)
        L_0x001e:
            java.lang.String r9 = "doSomethingWhenMapStable :不在此区域上车"
            r8.m21655a((java.lang.String) r9)
            return r0
        L_0x0024:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f27374j
            if (r1 == 0) goto L_0x005f
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x005f
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m21716r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r1)
            com.didi.map.global.component.recmarker.model.RecPoint r1 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r9, r1)
            if (r1 == 0) goto L_0x0056
            java.lang.String r2 = r1.addrName
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0056
            com.didi.map.global.component.departure.model.SpecialPois r2 = r8.m21716r()
            java.lang.String r1 = r1.addrName
            com.didi.map.global.component.departure.model.SPoi r1 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r2, r1)
            r8.m21649a((com.didi.map.global.component.departure.model.SPoi) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r2 = r8.f27374j
            r2.setSelectedTerminalArea(r1)
        L_0x0056:
            r8.m21692f((com.didi.common.map.model.LatLng) r9)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附到功能区"
            r8.m21655a((java.lang.String) r9)
            return r0
        L_0x005f:
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r8.f27386v
            com.sdk.poibase.model.RpcPoi r9 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r9, r1)
            if (r9 == 0) goto L_0x015b
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r9.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r5 = r9.base_info
            double r5 = r5.lng
            r1.<init>((double) r3, (double) r5)
            r8.f27385u = r1
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f27374j
            if (r1 == 0) goto L_0x00a4
            boolean r1 = r1.isTerminalViewValid()
            if (r1 == 0) goto L_0x00a4
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f27374j
            r1.setSelectedDeparture(r9)
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r8.f27373i
            if (r1 == 0) goto L_0x008e
            com.didi.common.map.model.LatLng r1 = r8.f27385u
            r8.m21652a(r9, r1, r2, r2)
        L_0x008e:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r1 = r8.f27376l
            com.didi.map.global.component.departure.view.DepartureCardViewController r3 = r8.f27374j
            com.didi.map.global.component.departure.model.SPoi r3 = r3.getSelectedTerminalArea()
            r1.setSelectedTerminalSPoi(r3)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r1 = r8.f27376l
            r1.reportOmegaOnTerminalRecPickupChange(r9, r2)
            java.lang.String r1 = "doSomethingWhenMapStable :吸附站场内的推荐点1 有卡片"
            r8.m21655a((java.lang.String) r1)
            goto L_0x00b2
        L_0x00a4:
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r8.f27373i
            if (r1 == 0) goto L_0x00ad
            com.didi.common.map.model.LatLng r1 = r8.f27385u
            r8.m21652a(r9, r1, r2, r2)
        L_0x00ad:
            java.lang.String r1 = "doSomethingWhenMapStable :吸附站场内的推荐点2 无卡片"
            r8.m21655a((java.lang.String) r1)
        L_0x00b2:
            com.didi.map.global.component.departure.model.DepartureAddress r9 = r8.m21628a((com.sdk.poibase.model.RpcPoi) r9)
            r8.m21664b((com.didi.map.global.component.departure.model.DepartureAddress) r9)
            r8.f27359N = r2
            return r0
        L_0x00bc:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f27374j
            r3 = 0
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x00fc
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m21716r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r1)
            com.didi.map.global.component.departure.departure.DeparturePresenter r4 = r8.f27378n
            if (r4 == 0) goto L_0x00d7
            com.didi.map.global.component.recmarker.model.RecPoint r3 = r4.sensing_terminal(r1)
        L_0x00d7:
            if (r3 == 0) goto L_0x015b
            java.lang.String r1 = r3.addrName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x015b
            com.didi.map.global.component.departure.model.SpecialPois r1 = r8.m21716r()
            java.lang.String r2 = r3.addrName
            com.didi.map.global.component.departure.model.SPoi r1 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r1, r2)
            r8.m21649a((com.didi.map.global.component.departure.model.SPoi) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r2 = r8.f27374j
            r2.setSelectedTerminalArea(r1)
            r8.m21692f((com.didi.common.map.model.LatLng) r9)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外功能区"
            r8.m21655a((java.lang.String) r9)
            return r0
        L_0x00fc:
            com.didi.map.global.component.departure.departure.DeparturePresenter r9 = r8.f27378n
            if (r9 == 0) goto L_0x0106
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r8.f27386v
            com.sdk.poibase.model.RpcPoi r3 = r9.sensing(r1)
        L_0x0106:
            if (r3 == 0) goto L_0x015b
            com.didi.common.map.model.LatLng r9 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            double r4 = r1.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            double r6 = r1.lng
            r9.<init>((double) r4, (double) r6)
            r8.f27385u = r9
            com.didi.map.global.component.departure.view.DepartureCardViewController r9 = r8.f27374j
            if (r9 == 0) goto L_0x0145
            boolean r9 = r9.isTerminalViewValid()
            if (r9 == 0) goto L_0x0145
            com.didi.map.global.component.departure.view.DepartureCardViewController r9 = r8.f27374j
            r9.setSelectedDeparture(r3)
            com.didi.map.global.component.recmarker.IRecMarkerController r9 = r8.f27373i
            if (r9 == 0) goto L_0x012f
            com.didi.common.map.model.LatLng r9 = r8.f27385u
            r8.m21652a(r3, r9, r2, r2)
        L_0x012f:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r9 = r8.f27376l
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r8.f27374j
            com.didi.map.global.component.departure.model.SPoi r1 = r1.getSelectedTerminalArea()
            r9.setSelectedTerminalSPoi(r1)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r9 = r8.f27376l
            r9.reportOmegaOnTerminalRecPickupChange(r3, r2)
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外推荐点，有卡片"
            r8.m21655a((java.lang.String) r9)
            goto L_0x0153
        L_0x0145:
            com.didi.map.global.component.recmarker.IRecMarkerController r9 = r8.f27373i
            if (r9 == 0) goto L_0x014e
            com.didi.common.map.model.LatLng r9 = r8.f27385u
            r8.m21652a(r3, r9, r2, r2)
        L_0x014e:
            java.lang.String r9 = "doSomethingWhenMapStable :吸附围栏外推荐点，无卡片"
            r8.m21655a((java.lang.String) r9)
        L_0x0153:
            com.didi.map.global.component.departure.model.DepartureAddress r9 = r8.m21628a((com.sdk.poibase.model.RpcPoi) r3)
            r8.m21664b((com.didi.map.global.component.departure.model.DepartureAddress) r9)
            return r0
        L_0x015b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m21668b(com.didi.common.map.model.LatLng):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21648a(DepartureLocationInfo departureLocationInfo, int i) {
        boolean z = true;
        if (this.f27366b != null) {
            boolean z2 = CallFrom.PICKUP_PAGE == this.f27366b.getReqCallerId() && (departureLocationInfo.latLng == null || i == 0);
            this.f27348C = z2;
            if (z2) {
                LocFollowToggleApollo.initFollowApolloParam();
            }
        }
        if (!(this.f27378n == null || departureLocationInfo == null)) {
            this.f27383s = departureLocationInfo;
            CarpoolDepartureController carpoolDepartureController = this.f27375k;
            if (carpoolDepartureController != null) {
                carpoolDepartureController.drawCircle(departureLocationInfo.latLng);
            }
            this.f27346A = i;
            if (this.f27389y == null || i != 0) {
                z = false;
            }
            this.f27378n.startRequest(departureLocationInfo, i, z);
            m21655a("startPoiRequest..." + departureLocationInfo.latLng.toString());
        }
        IWalkDropWrapper iWalkDropWrapper = this.f27379o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onRequestStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m21677c(LatLng latLng) {
        FenceController fenceController = this.f27372h;
        return fenceController != null && fenceController.isInFence(latLng) == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m21684d(LatLng latLng) {
        FenceController fenceController = this.f27372h;
        return fenceController != null && fenceController.isInFence(latLng) == 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21654a(ReverseStationsInfo reverseStationsInfo) {
        if (this.f27370f) {
            DepartureCompParams departureCompParams = this.f27366b;
            if (departureCompParams == null || departureCompParams.getApiType() != ApiType.DEPARTURE_POI_INFO) {
                m21676c(reverseStationsInfo);
                this.f27384t = false;
                return;
            }
            if (this.f27362Q) {
                this.f27362Q = false;
            }
            m21667b(reverseStationsInfo);
            this.f27384t = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f6  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21667b(com.sdk.poibase.model.poi.ReverseStationsInfo r14) {
        /*
            r13 = this;
            java.lang.String r0 = "handlePoiResult()  start"
            r13.m21655a((java.lang.String) r0)
            if (r14 != 0) goto L_0x000b
            r13.m21713p()
            return
        L_0x000b:
            r0 = 1
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.OmegaParams.type = r0
            r13.f27389y = r14
            r13.m21699i()
            r13.m21702k()
            java.util.ArrayList r14 = r14.getRecStartPoints()
            r13.f27386v = r14
            boolean r14 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r14)
            if (r14 == 0) goto L_0x002a
            com.sdk.poibase.model.poi.ReverseStationsInfo r14 = r13.f27389y
            java.util.List r14 = com.didi.map.global.component.departure.util.TerminalUtils.getSelectedSpecialRpcPoiList(r14)
            r13.f27386v = r14
        L_0x002a:
            java.util.List<com.sdk.poibase.model.RpcPoi> r14 = r13.f27386v
            com.sdk.poibase.model.RpcPoi r14 = com.didi.map.global.component.departure.util.DepartureUtils.findRecommendAdsorbPoint(r14)
            boolean r1 = r13.f27358M
            r2 = 0
            if (r1 == 0) goto L_0x0054
            com.didi.common.map.Map r1 = r13.f27367c
            com.didi.common.map.model.LatLng r1 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r1)
            com.sdk.poibase.model.poi.ReverseStationsInfo r3 = r13.f27389y
            com.didi.map.global.component.departure.model.SPoi r3 = com.didi.map.global.component.departure.util.TerminalUtils.getNearestSpoi(r1, r3)
            if (r3 == 0) goto L_0x0055
            java.util.List<com.sdk.poibase.model.RpcPoi> r4 = r3.list
            boolean r4 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r4)
            if (r4 != 0) goto L_0x0055
            java.util.List<com.sdk.poibase.model.RpcPoi> r14 = r3.list
            r13.f27386v = r14
            com.sdk.poibase.model.RpcPoi r14 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r1, r14)
            goto L_0x0055
        L_0x0054:
            r3 = r2
        L_0x0055:
            if (r14 == 0) goto L_0x0067
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r4 = r14.base_info
            double r4 = r4.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r6 = r14.base_info
            double r6 = r6.lng
            r1.<init>((double) r4, (double) r6)
            r13.f27385u = r1
            goto L_0x0078
        L_0x0067:
            boolean r1 = r13.f27358M
            if (r1 == 0) goto L_0x0071
            java.lang.String r1 = "handleResult() 场站内未找到吸附点"
            r13.m21655a((java.lang.String) r1)
            goto L_0x0076
        L_0x0071:
            java.lang.String r1 = "handleResult() 普通场景未找到吸附点"
            r13.m21655a((java.lang.String) r1)
        L_0x0076:
            r13.f27385u = r2
        L_0x0078:
            com.didi.map.global.component.departure.model.DepartureAddress r1 = r13.m21628a((com.sdk.poibase.model.RpcPoi) r14)
            r13.f27387w = r1
            r13.m21647a((com.didi.map.global.component.departure.model.DepartureAddress) r1, (com.sdk.poibase.model.RpcPoi) r14)
            boolean r1 = r13.f27358M
            r11 = 0
            if (r1 == 0) goto L_0x0091
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r13.f27374j
            if (r1 == 0) goto L_0x0091
            if (r1 == 0) goto L_0x008f
            r1.performSelectedArea(r3, r14)
        L_0x008f:
            r13.f27358M = r11
        L_0x0091:
            com.didi.map.global.component.departure.model.DepartureAddress r1 = r13.f27387w
            r13.m21646a((com.didi.map.global.component.departure.model.DepartureAddress) r1)
            com.didi.map.global.component.departure.model.SpecialPois r1 = r13.m21716r()
            java.util.List r1 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointListWithoutPointFirst(r1)
            boolean r3 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r1)
            if (r3 != 0) goto L_0x00a6
            r3 = r1
            goto L_0x00ac
        L_0x00a6:
            java.util.List<com.sdk.poibase.model.RpcPoi> r3 = r13.f27386v
            java.util.List r3 = com.didi.map.global.component.departure.util.TerminalUtils.getRecPointList(r3)
        L_0x00ac:
            com.sdk.poibase.model.poi.ReverseStationsInfo r4 = r13.f27389y
            boolean r12 = com.didi.map.global.component.departure.util.DepartureUtils.inAirportByTag(r4)
            com.didi.map.global.component.departure.view.DepartureCardViewController r4 = r13.f27374j
            if (r4 == 0) goto L_0x011f
            boolean r4 = r4.isValidAndTerminal()
            if (r4 == 0) goto L_0x011f
            boolean r4 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r1)
            if (r4 != 0) goto L_0x011f
            int r4 = r13.f27349D
            if (r4 == r0) goto L_0x011f
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f27379o
            if (r14 == 0) goto L_0x00cd
            r14.onRspAirport()
        L_0x00cd:
            com.didi.common.map.Map r14 = r13.f27367c
            com.didi.common.map.model.LatLng r14 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r14)
            com.didi.map.global.component.recmarker.model.RecPoint r14 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r14, r1)
            if (r14 == 0) goto L_0x0119
            java.lang.String r4 = r14.addrName
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x00e2
            goto L_0x0119
        L_0x00e2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleResult() 场站内-吸附,recPoint="
            r4.append(r5)
            com.didi.common.map.model.LatLng r5 = r14.location
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r13.m21655a((java.lang.String) r4)
            com.didi.map.global.component.departure.model.SpecialPois r4 = r13.m21716r()
            java.lang.String r5 = r14.addrName
            com.didi.map.global.component.departure.model.SPoi r4 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r4, r5)
            com.didi.map.global.component.departure.view.DepartureCardViewController r5 = r13.f27374j
            r5.setSelectedTerminalArea(r4)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r5 = r13.f27376l
            r5.setSelectedTerminalSPoi(r4)
            com.didi.common.map.model.LatLng r14 = r14.location
            r13.f27385u = r14
            r13.m21652a(r2, r14, r0, r0)
            goto L_0x01f1
        L_0x0119:
            java.lang.String r14 = "handleResult() 场站内-未吸附"
            r13.m21655a((java.lang.String) r14)
            return
        L_0x011f:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f27376l
            r2.clearTerminalCache()
            if (r3 != 0) goto L_0x0169
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "handlePoiResult,is normal poi, mRecMakerController is null,mLocationInfo="
            r14.append(r0)
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r13.f27383s
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            r13.m21655a((java.lang.String) r14)
            com.didi.common.map.model.LatLng r14 = r13.m21724v()
            com.didi.map.global.component.departure.DepartureCompParams r0 = r13.f27366b
            boolean r0 = r0.isPinVisible()
            if (r0 != 0) goto L_0x0150
            com.didi.map.global.component.departure.DepartureCompParams r0 = r13.f27366b
            com.didi.map.global.component.departure.model.PinStyle r0 = r0.getPinStyle()
            if (r0 == 0) goto L_0x0153
        L_0x0150:
            r13.m21688e((com.didi.common.map.model.LatLng) r14)
        L_0x0153:
            com.didi.map.global.component.departure.model.DepartureAddress r14 = r13.f27387w
            r13.m21664b((com.didi.map.global.component.departure.model.DepartureAddress) r14)
            r13.m21624C()
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f27379o
            if (r14 == 0) goto L_0x0168
            if (r12 == 0) goto L_0x0165
            r14.onRspAirport()
            goto L_0x0168
        L_0x0165:
            r14.onNormalReverseGeo()
        L_0x0168:
            return
        L_0x0169:
            com.didi.common.map.model.LatLng r2 = r13.f27385u
            if (r2 == 0) goto L_0x01c5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "handleResult() 普通推荐点-吸附: "
            r2.append(r4)
            com.didi.common.map.model.LatLng r4 = r13.f27385u
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r13.m21655a((java.lang.String) r2)
            boolean r2 = r13.m21659a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3)
            if (r2 == 0) goto L_0x019a
            com.didi.common.map.model.LatLng r6 = r13.f27385u
            r7 = 1
            r8 = 1
            r9 = 1
            r10 = 1101004800(0x41a00000, float:20.0)
            r4 = r13
            r5 = r14
            r4.m21653a(r5, r6, r7, r8, r9, r10)
            goto L_0x019f
        L_0x019a:
            com.didi.common.map.model.LatLng r2 = r13.f27385u
            r13.m21652a(r14, r2, r0, r0)
        L_0x019f:
            com.didi.map.global.component.departure.model.DepartureAddress r2 = r13.f27387w
            if (r2 == 0) goto L_0x01ae
            int r2 = r2.getZoneType()
            if (r2 != 0) goto L_0x01ae
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f27376l
            r2.setDefaultRecTerminalPickupPoi(r14)
        L_0x01ae:
            com.didi.map.global.component.departure.view.DepartureCardViewController r14 = r13.f27374j
            if (r14 == 0) goto L_0x01c3
            boolean r14 = r14.isTerminalViewValid()
            if (r14 == 0) goto L_0x01c3
            com.didi.map.global.component.departure.view.DepartureCardViewController r14 = r13.f27374j
            com.didi.map.global.component.departure.model.SPoi r14 = r14.getSelectedTerminalArea()
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r2 = r13.f27376l
            r2.setSelectedTerminalSPoi(r14)
        L_0x01c3:
            r14 = 1
            goto L_0x01f2
        L_0x01c5:
            java.lang.String r14 = "handleResult() 普通推荐点-未吸附"
            r13.m21655a((java.lang.String) r14)
            boolean r14 = r13.m21659a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3)
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.Map r14 = r13.f27367c
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.model.CameraPosition r14 = r14.getCameraPosition()
            if (r14 == 0) goto L_0x01f1
            com.didi.common.map.Map r4 = r13.f27367c
            r5 = 1
            r14 = 1101004800(0x41a00000, float:20.0)
            java.lang.Float r6 = java.lang.Float.valueOf(r14)
            com.didi.common.map.Map r14 = r13.f27367c
            com.didi.common.map.model.CameraPosition r14 = r14.getCameraPosition()
            com.didi.common.map.model.LatLng r7 = r14.target
            com.didi.common.map.model.Padding r8 = r13.f27351F
            r9 = 0
            com.didi.common.map.BestViewer.doBestView((com.didi.common.map.Map) r4, (boolean) r5, (java.lang.Float) r6, (com.didi.common.map.model.LatLng) r7, (com.didi.common.map.model.Padding) r8, (com.didi.common.map.BestViewer.IBestViewListener) r9)
        L_0x01f1:
            r14 = 0
        L_0x01f2:
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r2 = r13.f27379o
            if (r2 == 0) goto L_0x0224
            if (r12 == 0) goto L_0x01fc
            r2.onRspAirport()
            goto L_0x0213
        L_0x01fc:
            if (r14 == 0) goto L_0x0208
            com.didi.common.map.model.LatLng r4 = r13.f27385u
            if (r4 == 0) goto L_0x0208
            com.didi.map.global.component.departure.model.DepartureAddress r5 = r13.f27387w
            r2.onNormalAdsorbedOk(r4, r5)
            goto L_0x0213
        L_0x0208:
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r2 = r13.f27379o
            com.didi.common.map.Map r4 = r13.f27367c
            com.didi.common.map.model.LatLng r4 = com.didi.map.global.component.departure.util.DepartureUtils.getMapCenterPoint(r4)
            r2.onNormalAdsorbedFail(r4)
        L_0x0213:
            if (r14 != 0) goto L_0x021d
            com.didi.map.global.component.departure.walkdrop.IWalkDropWrapper r14 = r13.f27379o
            boolean r14 = r14.isRecMarkerVisible()
            if (r14 == 0) goto L_0x022a
        L_0x021d:
            if (r1 == 0) goto L_0x0220
            r11 = 1
        L_0x0220:
            r13.m21656a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3, (boolean) r11)
            goto L_0x022a
        L_0x0224:
            if (r1 == 0) goto L_0x0227
            r11 = 1
        L_0x0227:
            r13.m21656a((java.util.List<com.didi.map.global.component.recmarker.model.RecPoint>) r3, (boolean) r11)
        L_0x022a:
            int r14 = r13.f27349D
            if (r14 != r0) goto L_0x0231
            r13.m21699i()
        L_0x0231:
            com.didi.map.global.component.departure.model.DepartureAddress r14 = r13.f27387w
            r13.m21664b((com.didi.map.global.component.departure.model.DepartureAddress) r14)
            r13.m21624C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m21667b(com.sdk.poibase.model.poi.ReverseStationsInfo):void");
    }

    /* renamed from: a */
    private boolean m21659a(List<RecPoint> list) {
        IDeparturePinView iDeparturePinView;
        if (this.f27384t && this.f27367c != null) {
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                for (RecPoint next : list) {
                    IDeparturePinView iDeparturePinView2 = this.f27371g;
                    if (iDeparturePinView2 != null && DepartureUtils.LatLngIsInRect(this.f27367c, iDeparturePinView2.getWindowPosition(), next.location)) {
                        DLog.m10773d(this.f27365a, "吸附点被遮挡", new Object[0]);
                        return true;
                    }
                }
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27368d);
            if (lastKnownLocation == null || (iDeparturePinView = this.f27371g) == null || !DepartureUtils.LatLngIsInRect(this.f27367c, iDeparturePinView.getWindowPosition(), new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()))) {
                DLog.m10773d(this.f27365a, "无遮挡", new Object[0]);
            } else {
                DLog.m10773d(this.f27365a, "定位点被遮挡", new Object[0]);
                return true;
            }
        }
        this.f27384t = false;
        return false;
    }

    /* renamed from: c */
    private void m21676c(ReverseStationsInfo reverseStationsInfo) {
        DepartureOmegaUtils.OmegaParams.type = 0;
        if (reverseStationsInfo != null) {
            DepartureAddress a = m21628a((RpcPoi) null);
            this.f27387w = a;
            if (a != null) {
                m21688e(m21724v());
                this.f27389y = reverseStationsInfo;
                PinActionUtils.startAdsorbRecommendAnimation((IPinDrawer) null, 10, (DepartureMarkerView.AnimationFinishListener) null);
                m21664b(this.f27387w);
                return;
            }
        }
        m21655a("handleReverseGeoResult() is null, return.");
        m21713p();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21652a(RpcPoi rpcPoi, LatLng latLng, boolean z, boolean z2) {
        m21653a(rpcPoi, latLng, z, z2, false, this.f27366b.getZoom());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21653a(com.sdk.poibase.model.RpcPoi r15, com.didi.common.map.model.LatLng r16, boolean r17, boolean r18, boolean r19, float r20) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            if (r1 != 0) goto L_0x000c
            if (r16 != 0) goto L_0x000c
            java.lang.String r1 = "animateToAdsorbPoi() is null, return."
            r14.m21655a((java.lang.String) r1)
            return
        L_0x000c:
            boolean r2 = r14.m21689e()
            if (r2 != 0) goto L_0x0018
            java.lang.String r1 = "animateToAdsorbPoi() recMarkerShowable is false, return."
            r14.m21655a((java.lang.String) r1)
            return
        L_0x0018:
            java.lang.String r2 = "animateToAdsorbPoi 吸附开始"
            r14.m21655a((java.lang.String) r2)
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.mapDragRecommend(r15)
            r2 = 0
            if (r1 == 0) goto L_0x0035
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r1.base_info
            if (r3 == 0) goto L_0x0035
            com.didi.common.map.model.LatLng r2 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r1.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r1.base_info
            double r5 = r1.lng
            r2.<init>((double) r3, (double) r5)
            goto L_0x003a
        L_0x0035:
            if (r16 == 0) goto L_0x003a
            r8 = r16
            goto L_0x003b
        L_0x003a:
            r8 = r2
        L_0x003b:
            if (r8 == 0) goto L_0x0066
            com.didi.map.global.component.departure.DepartureCompParams r1 = r0.f27366b
            if (r1 != 0) goto L_0x0042
            goto L_0x0066
        L_0x0042:
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r0.f27373i
            if (r1 == 0) goto L_0x004b
            com.didi.map.global.component.recmarker.RecMarkerController r1 = (com.didi.map.global.component.recmarker.RecMarkerController) r1
            r1.updateMarkerPinedState(r8)
        L_0x004b:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f27347B
            r2 = 1
            r1.set(r2)
            com.didi.common.map.Map r7 = r0.f27367c
            r9 = 1
            com.didi.common.map.model.Padding r12 = r0.f27351F
            com.didi.map.global.component.departure.departure.DepartureView$5 r13 = new com.didi.map.global.component.departure.departure.DepartureView$5
            r1 = r17
            r2 = r18
            r13.<init>(r1, r2, r8)
            r10 = r19
            r11 = r20
            com.didi.map.global.component.departure.util.PinActionUtils.animateCamera(r7, r8, r9, r10, r11, r12, r13)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m21653a(com.sdk.poibase.model.RpcPoi, com.didi.common.map.model.LatLng, boolean, boolean, boolean, float):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m21688e(LatLng latLng) {
        if (latLng != null) {
            boolean z = (this.f27377m == null && this.f27375k == null) ? this.f27346A == 0 : false;
            this.f27347B.set(true);
            PinActionUtils.animateCamera(this.f27367c, latLng, true, z, this.f27366b.getZoom(), this.f27351F, new BestViewer.IBestViewListener() {
                public void onFinished() {
                    DepartureView.this.f27347B.set(false);
                    int t = DepartureView.this.m21619A();
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.f27369e.onDragging(t);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private void m21692f(LatLng latLng) {
        if (this.f27366b.isBubbleVisible() && this.f27371g != null) {
            DepartureCardViewController departureCardViewController = this.f27374j;
            boolean z = true;
            if (departureCardViewController == null || !departureCardViewController.isTerminalViewValid() || this.f27374j.isWelcomeViewValid() || this.f27374j.isTerminal() || this.f27374j.isWaitCheckPickupSpot() || this.f27349D == 1) {
                z = false;
            }
            AddressWalkGuide n = m21709n();
            if (n == null || !z) {
                if (m21677c(latLng) || m21684d(latLng)) {
                    this.f27371g.toNoParking();
                } else if (m21707m()) {
                    this.f27371g.startDragging_Ex();
                } else {
                    String o = m21711o();
                    DepartureCardViewController departureCardViewController2 = this.f27374j;
                    if (departureCardViewController2 != null && (departureCardViewController2.isWelcomeViewValid() || this.f27374j.isWaitCheckPickupSpot() || this.f27374j.isTerminal())) {
                        o = this.f27367c.getContext().getString(R.string.GRider_Homepage0714_Get_in_tpiW);
                    } else if (TextUtils.isEmpty(o)) {
                        o = this.f27367c.getContext().getString(R.string.GRider_Homepage0714_Get_on_XNNb);
                    }
                    this.f27371g.showText(o);
                }
            } else if (this.f27359N) {
                this.f27359N = false;
                m21655a("场站上车点已经刷新过实景图!!!");
                return;
            } else {
                if (this.f27361P == null) {
                    DepartureWalkGuide departureWalkGuide = new DepartureWalkGuide(this.f27367c.getContext());
                    this.f27361P = departureWalkGuide;
                    departureWalkGuide.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            DepartureView.this.m21633a(view);
                        }
                    });
                }
                this.f27361P.setData(n);
                IDeparturePinView iDeparturePinView = this.f27371g;
                DepartureWalkGuide departureWalkGuide2 = this.f27361P;
                iDeparturePinView.showView(departureWalkGuide2, departureWalkGuide2.getWIDTH(), this.f27361P.getHEIGHT(), this.f27361P.getANGLE());
                m21655a("场站上车点刷新实景图");
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                DepartureOmegaUtils.trackPinMove(DepartureUtils.getMapCenterPoint(DepartureView.this.f27367c));
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21633a(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27369e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* renamed from: m */
    private boolean m21707m() {
        DepartureCompParams departureCompParams = this.f27366b;
        if (departureCompParams == null || departureCompParams.getReqCallerId() == null) {
            return false;
        }
        if (this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_ENDSUG_DRAG) || this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_STARTSUG_DRAG) || this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_FROMBUBBLE_ENDSUG_DRAG) || this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_FROMBUBBLE_STARTSUG_DRAG) || this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_FROMHOME_ENDSUG_DRAG) || this.f27366b.getReqCallerId().equals(CallFrom.GLOBAL_FROMHOME_STARTSUG_DRAG)) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    private AddressWalkGuide m21709n() {
        DepartureAddress departureAddress = this.f27360O;
        if (departureAddress == null || departureAddress.getExtendInfo() == null || this.f27360O.getExtendInfo().getWalkGuide() == null || !this.f27360O.getExtendInfo().getWalkGuide().isValid()) {
            return null;
        }
        return this.f27360O.getExtendInfo().getWalkGuide();
    }

    /* renamed from: o */
    private String m21711o() {
        DepartureAddress departureAddress = this.f27360O;
        if (departureAddress == null || departureAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(this.f27360O.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21664b(DepartureAddress departureAddress) {
        this.f27360O = departureAddress;
        DepartureInterceptController departureInterceptController = this.f27354I;
        if (departureInterceptController != null) {
            ReverseStationsInfo reverseStationsInfo = this.f27389y;
            departureInterceptController.updateNewRequestLocation(departureAddress, reverseStationsInfo == null ? null : reverseStationsInfo.locLevel);
        }
        m21655a("onDepartureAddrSuccess callback");
        if (departureAddress == null || departureAddress.getPosition() == null) {
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27369e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onFetchAddressFail(m21714q());
            }
            m21692f(m21714q());
            return;
        }
        m21675c(departureAddress);
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback2 = this.f27369e;
        if (iDepartureComponentCallback2 != null) {
            iDepartureComponentCallback2.onDepartureAddressChanged(departureAddress);
        }
        m21692f(departureAddress.getPosition());
        m21635a(departureAddress.getPosition(), false);
    }

    /* renamed from: p */
    private void m21713p() {
        m21692f(m21714q());
        DepartureInterceptController departureInterceptController = this.f27354I;
        if (departureInterceptController != null) {
            departureInterceptController.updateNewRequestLocation((DepartureAddress) null, (String) null);
        }
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27369e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onFetchAddressFail(m21714q());
        }
        m21635a(m21714q(), true);
        IWalkDropWrapper iWalkDropWrapper = this.f27379o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onRequestFail();
        }
    }

    /* renamed from: a */
    private void m21635a(LatLng latLng, boolean z) {
        LatLng latLng2;
        String str;
        DepartureCompParams departureCompParams = this.f27366b;
        if (departureCompParams != null && departureCompParams.getReqCallerId() != null && CallFrom.PICKUP_PAGE == this.f27366b.getReqCallerId()) {
            if (this.f27367c == null || !LatLngUtils.locateCorrect(latLng)) {
                DLog.m10773d("禁停内发单异常", "map == null || center point 异常", new Object[0]);
            } else if (m21677c(latLng) || m21684d(latLng)) {
                FenceInfo fenceInfo = this.f27372h.getFenceInfo();
                DepartureAddress departureAddress = this.f27387w;
                String str2 = null;
                if (departureAddress == null || departureAddress.getAddress() == null) {
                    str = null;
                    latLng2 = null;
                } else {
                    str = this.f27387w.getAddress().poiId;
                    latLng2 = this.f27387w.getPosition();
                }
                if (fenceInfo != null) {
                    str2 = fenceInfo.fenceId;
                }
                if (str2 == null) {
                    str2 = this.f27372h.isInAroundFence(latLng);
                }
                if (!TextUtils.isEmpty(str2)) {
                    DLog.m10773d("trackNoParkingError--->center", latLng != null ? latLng.toString() : "center is null", new Object[0]);
                    DepartureLocationInfo departureLocationInfo = this.f27383s;
                    DLog.m10773d("trackNoParkingError--->location", (departureLocationInfo == null || departureLocationInfo.latLng == null) ? "mLocation is null" : this.f27383s.latLng.toString(), new Object[0]);
                    DLog.m10773d("trackNoParkingError--->mapCenter", DepartureUtils.getMapCenterPoint(this.f27367c) != null ? DepartureUtils.getMapCenterPoint(this.f27367c).toString() : "map center is null", new Object[0]);
                    DLog.m10773d("trackNoParkingError--->position", latLng2 != null ? latLng2.toString() : "position is null", new Object[0]);
                    DepartureOmegaUtils.trackNoParkingError(latLng2, str, str2, z ? 1 : 0);
                }
            }
        }
    }

    /* renamed from: c */
    private void m21675c(DepartureAddress departureAddress) {
        m21682d(departureAddress);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21682d(DepartureAddress departureAddress) {
        DepartureOmegaManager departureOmegaManager = this.f27376l;
        if (departureOmegaManager != null) {
            departureOmegaManager.setPickupPoiDescription(DepartureUtils.getMainTitleFromDepartureAddr(departureAddress));
        }
    }

    /* renamed from: q */
    private LatLng m21714q() {
        DepartureLocationInfo departureLocationInfo = this.f27383s;
        if (departureLocationInfo != null) {
            return departureLocationInfo.latLng;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r0 = r0.getDepartureAddress();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.global.component.departure.model.DepartureAddress m21628a(com.sdk.poibase.model.RpcPoi r8) {
        /*
            r7 = this;
            com.didi.map.global.component.departure.departure.DeparturePresenter r0 = r7.f27378n
            r1 = 0
            if (r0 == 0) goto L_0x005c
            if (r8 == 0) goto L_0x0027
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            if (r0 == 0) goto L_0x0027
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            double r2 = r0.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r8.base_info
            double r4 = r0.lng
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r2, r4)
            if (r0 == 0) goto L_0x0027
            com.didi.common.map.model.LatLng r0 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r2 = r8.base_info
            double r2 = r2.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r4 = r8.base_info
            double r4 = r4.lng
            r0.<init>((double) r2, (double) r4)
            goto L_0x0045
        L_0x0027:
            com.sdk.poibase.model.poi.ReverseStationsInfo r0 = r7.f27389y
            if (r0 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoi r0 = r0.getDepartureAddress()
            if (r0 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoiBaseInfo r2 = r0.base_info
            if (r2 == 0) goto L_0x0044
            com.didi.common.map.model.LatLng r2 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r0.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r0.base_info
            double r5 = r0.lng
            r2.<init>((double) r3, (double) r5)
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r7.f27389y
            if (r2 == 0) goto L_0x004d
            com.sdk.poibase.model.RpcPoi r1 = r2.getDepartureAddress()
        L_0x004d:
            com.didi.map.global.component.departure.departure.DeparturePresenter r2 = r7.f27378n
            com.didi.common.map.model.LatLng r3 = r7.m21714q()
            boolean r0 = r7.m21677c((com.didi.common.map.model.LatLng) r0)
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r2.getDepartureAddress(r8, r1, r3, r0)
            return r8
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DepartureView.m21628a(com.sdk.poibase.model.RpcPoi):com.didi.map.global.component.departure.model.DepartureAddress");
    }

    /* renamed from: r */
    private SpecialPois m21716r() {
        DepartureAddress departureAddress = this.f27387w;
        if (departureAddress != null) {
            return departureAddress.getSpecialPois();
        }
        return null;
    }

    /* renamed from: a */
    private void m21647a(DepartureAddress departureAddress, RpcPoi rpcPoi) {
        if (this.f27366b.isTerminalViewVisible()) {
            m21655a("handleTerminalView() isTerminalViewVisible is true");
            if (departureAddress != null && departureAddress.getZoneType() == 0) {
                m21721t();
            }
            DepartureCardViewController departureCardViewController = this.f27374j;
            if (departureCardViewController != null) {
                departureCardViewController.setData(departureAddress, DepartureUtils.getFenceInfo(this.f27389y), rpcPoi);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m21718s() {
        this.f27362Q = true;
        m21702k();
    }

    /* renamed from: t */
    private void m21721t() {
        if (this.f27374j == null) {
            DepartureCardViewController departureCardViewController = new DepartureCardViewController(this.f27368d, this.f27366b);
            this.f27374j = departureCardViewController;
            departureCardViewController.setTerminalViewCallback(new ITerminalView.Callback() {
                public void onTerminalAreaSelected(SPoi sPoi, int i) {
                    DepartureView.this.m21649a(sPoi);
                    DepartureView.this.f27376l.setSelectedTerminalSPoi(sPoi);
                }

                public void onDepartureSelected(RpcPoi rpcPoi, int i) {
                    DepartureView.this.m21666b(rpcPoi);
                    DepartureView departureView = DepartureView.this;
                    departureView.m21655a("onDepartureSelected eventCode=" + i);
                    if (i == 2) {
                        DepartureView.this.f27376l.reportOmegaOnTerminalRecPickupChange(rpcPoi, 3);
                    }
                }

                public void onClickChange(SpecialPois specialPois) {
                    DepartureView.this.m21650a(specialPois);
                }

                public void onClickNext(SPoi sPoi) {
                    DepartureView.this.m21665b(sPoi);
                }

                public void onClickConfirmPickup(RpcPoi rpcPoi) {
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.m21682d(DepartureView.this.m21628a(rpcPoi));
                        DepartureView.this.f27369e.onConfirmPickup(DepartureView.this.m21628a(rpcPoi));
                    }
                    DepartureView.this.f27376l.reportOmegaOnTerminalConfirmButtonClick(rpcPoi);
                }

                public void onClickBroadOther() {
                    DepartureView.this.m21718s();
                    FenceInfo fenceInfo = DepartureView.this.f27387w.getFenceInfo();
                    if (!(fenceInfo == null || DepartureView.this.f27387w.getAddress() == null)) {
                        DepartureView.this.f27387w.getAddress().displayName = fenceInfo.fenceName;
                    }
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.f27369e.onClickBroadOtherInStationCard(DepartureView.this.f27387w);
                    }
                    DepartureView.this.f27376l.reportOmegaStationAreaBroadFromOther();
                }
            });
            this.f27374j.setWelcomeViewCallback(new ITerminalWelcomeView.Callback() {
                public void onClickSetPickupSpot() {
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.f27369e.onStartTerminalWindow(DepartureView.this.f27387w);
                    }
                    DepartureView.this.f27376l.reportOmegaOnWelcomeButtonClick();
                }

                public void onClickSelectOtherArea() {
                    if (DepartureView.this.f27369e != null) {
                        DepartureView.this.f27369e.onStartSugPage(DepartureView.this.f27387w);
                    }
                    DepartureView.this.f27376l.reportOmegaOnOtherAreaClick();
                }
            });
        }
    }

    /* renamed from: u */
    private void m21722u() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f27367c);
        if (mapCenterPoint != null) {
            this.f27383s.latLng = mapCenterPoint;
            m21648a(this.f27383s, 1);
        }
    }

    public DepartureAddress getDepartureAddress() {
        return this.f27387w;
    }

    public void startTerminalSelect() {
        DepartureCardViewController departureCardViewController = this.f27374j;
        if (departureCardViewController != null) {
            departureCardViewController.setPickupSpotChecked(true);
            m21722u();
        }
    }

    public boolean isShowTerminalViewOnSetPickupSpotAfter() {
        DepartureCardViewController departureCardViewController;
        if (this.f27366b.isTerminalViewVisible() && (departureCardViewController = this.f27374j) != null && departureCardViewController.isWaitCheckPickupSpot()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21649a(SPoi sPoi) {
        m21655a("terminalAreaSelected()");
        if (!(sPoi == null || sPoi.area == null || sPoi.area.centre_point == null)) {
            LatLng latLng = new LatLng(sPoi.area.centre_point.lat, sPoi.area.centre_point.lng);
            this.f27385u = latLng;
            m21652a((RpcPoi) null, latLng, true, false);
        }
        this.f27363R = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21666b(RpcPoi rpcPoi) {
        m21655a("departureSelected()");
        if (rpcPoi != null && rpcPoi.base_info != null) {
            LatLng latLng = new LatLng(rpcPoi.base_info.lat, rpcPoi.base_info.lng);
            this.f27385u = latLng;
            m21652a(rpcPoi, latLng, true, false);
            RpcPoi rpcPoi2 = this.f27363R;
            String str = (rpcPoi2 == null || rpcPoi2.base_info == null) ? "" : this.f27363R.base_info.poi_id;
            if (TextUtils.isEmpty(str) || !str.equals(rpcPoi.base_info.poi_id)) {
                this.f27363R = rpcPoi;
                if (this.f27369e != null) {
                    DepartureAddress a = m21628a(rpcPoi);
                    DepartureCardViewController departureCardViewController = this.f27374j;
                    if (departureCardViewController != null) {
                        departureCardViewController.refreshTerminalCardViewSubNotice(a);
                    }
                    m21682d(a);
                    this.f27360O = a;
                    if (a != null) {
                        m21675c(a);
                        this.f27369e.onDepartureAddressChanged(a);
                        m21692f(a.getPosition());
                        return;
                    }
                    this.f27369e.onFetchAddressFail(m21714q());
                    m21692f(m21714q());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21650a(SpecialPois specialPois) {
        m21655a("clickChangeToShowTerminalAreaList()");
        List<RecPoint> terminalRecPointList = TerminalUtils.getTerminalRecPointList(specialPois);
        DepartureCardViewController departureCardViewController = this.f27374j;
        if (departureCardViewController != null && departureCardViewController.hasTerminalView()) {
            m21656a(terminalRecPointList, true);
            SPoi selectedTerminalArea = this.f27374j.getSelectedTerminalArea();
            if (selectedTerminalArea == null) {
                selectedTerminalArea = TerminalUtils.getAdsorbTerminalArea(specialPois);
            }
            m21649a(selectedTerminalArea);
            m21692f((LatLng) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21665b(SPoi sPoi) {
        m21655a("clickNextToSelectTerminalArea()");
        if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
            this.f27386v = sPoi.list;
            m21656a(TerminalUtils.getRecPointList(sPoi.list), false);
            RpcPoi findRecommendAdsorbPoint = DepartureUtils.findRecommendAdsorbPoint(sPoi.list);
            m21666b(findRecommendAdsorbPoint);
            this.f27376l.setSelectedTerminalSPoi(sPoi);
            this.f27376l.setDefaultRecTerminalPickupPoi(findRecommendAdsorbPoint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public LatLng m21724v() {
        DepartureLocationInfo departureLocationInfo = this.f27383s;
        if (departureLocationInfo == null || departureLocationInfo.latLng == null || this.f27383s.latLng.latitude == 0.0d) {
            return DepartureUtils.getMapCenterPoint(this.f27367c);
        }
        return this.f27383s.latLng;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f27383s;
    }

    public View getDepartureCardView() {
        DepartureCardViewController departureCardViewController = this.f27374j;
        if (departureCardViewController != null) {
            return departureCardViewController.getDepartureCardView();
        }
        return null;
    }

    /* renamed from: w */
    private void m21726w() {
        DeparturePresenter departurePresenter = this.f27378n;
        if (departurePresenter != null) {
            departurePresenter.stopRequest();
        }
    }

    public void start() {
        m21661b();
        m21691f();
        m21697h();
        m21648a(this.f27383s, this.f27346A);
        DepartureLocationInfo departureLocationInfo = this.f27383s;
        if (departureLocationInfo != null) {
            m21695g(departureLocationInfo.latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m21695g(LatLng latLng) {
        this.f27347B.set(true);
        if (latLng == null) {
            latLng = DepartureUtils.getMapCenterPoint(this.f27367c);
        }
        ZoneCircleController zoneCircleController = this.f27377m;
        if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
            BestViewer.doBestView(this.f27367c, false, latLng, this.f27377m.getBestViewPoints(), this.f27351F, (Padding) null, (BestViewer.IBestViewListener) null);
        } else if (LatLngUtils.locateCorrect(latLng)) {
            CarpoolDepartureController carpoolDepartureController = this.f27375k;
            if (carpoolDepartureController != null) {
                BestViewer.doBestView(this.f27367c, false, latLng, carpoolDepartureController.getBestViewPoints(latLng), this.f27351F, (Padding) null, (BestViewer.IBestViewListener) null);
            } else {
                float zoom = this.f27366b.getZoom();
                if (this.f27366b.getPinStyle() != null || this.f27366b.isPinVisible()) {
                    PinActionUtils.animateCamera(this.f27367c, latLng, false, true, zoom, this.f27351F, (BestViewer.IBestViewListener) null);
                }
            }
        }
        this.f27347B.set(false);
    }

    public void updateDepartureLocation(final DepartureLocationInfo departureLocationInfo, final boolean z) {
        if (this.f27370f && m21672b(departureLocationInfo)) {
            m21655a("updateDepartureLocation=" + departureLocationInfo);
            DepartureOmegaUtils.OmegaParams.scrollType = 1;
            C1019410 r7 = new BestViewer.IBestViewListener() {
                public void onFinished() {
                    RpcPoi findTargetRecommend;
                    DepartureView.this.m21655a("updateDepartureLocation onFinished");
                    DepartureView.this.f27347B.set(false);
                    if (DepartureView.this.m21622B()) {
                        LatLng center = DepartureView.this.f27377m.getCenter();
                        if (!(DepartureView.this.f27383s == null || DepartureView.this.f27383s.latLng == null || DepartureView.this.f27377m.getCircle() == null || !DepartureView.this.f27377m.getCircle().contains(DepartureView.this.f27383s.latLng))) {
                            center = DepartureView.this.f27383s.latLng;
                        }
                        DepartureView.this.m21688e(center);
                        departureLocationInfo.latLng = center;
                    } else {
                        departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(DepartureView.this.f27367c);
                    }
                    int i = 1;
                    if (DepartureView.this.f27362Q && DepartureView.this.f27389y != null) {
                        LatLng latLng = departureLocationInfo.latLng;
                        FenceInfo fenceInfo = DepartureView.this.f27389y.startFenceInfo;
                        if (FenceUtils.isFenceMustAbsorb(fenceInfo)) {
                            if (!FenceUtils.positionIsInFence(DepartureView.this.f27367c, fenceInfo, latLng)) {
                                boolean unused = DepartureView.this.f27362Q = false;
                            } else {
                                return;
                            }
                        }
                    } else if (DepartureView.this.m21677c(departureLocationInfo.latLng) && (findTargetRecommend = DepartureUtils.findTargetRecommend(departureLocationInfo.latLng, DepartureView.this.f27386v)) != null) {
                        LatLng unused2 = DepartureView.this.f27385u = new LatLng(findTargetRecommend.base_info.lat, findTargetRecommend.base_info.lng);
                        DepartureView departureView = DepartureView.this;
                        departureView.m21652a(findTargetRecommend, departureView.f27385u, true, true);
                        DepartureView.this.m21664b(DepartureView.this.m21628a(findTargetRecommend));
                        return;
                    }
                    DepartureView departureView2 = DepartureView.this;
                    DepartureLocationInfo departureLocationInfo = departureLocationInfo;
                    if (z) {
                        i = departureView2.f27346A;
                    }
                    departureView2.m21648a(departureLocationInfo, i);
                }
            };
            if (!z || !this.f27347B.get()) {
                this.f27347B.set(true);
                LatLng latLng = departureLocationInfo != null ? departureLocationInfo.latLng : null;
                ZoneCircleController zoneCircleController = this.f27377m;
                if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
                    m21655a("mZoneCircleCtr bestview");
                    BestViewer.doBestView(this.f27367c, true, latLng, this.f27377m.getBestViewPoints(), this.f27351F, (Padding) null, r7);
                } else if (this.f27375k != null) {
                    m21655a("mCarpoolController bestview");
                    BestViewer.doBestView(this.f27367c, true, latLng, this.f27375k.getBestViewPoints(latLng), this.f27351F, (Padding) null, r7);
                } else {
                    float zoom = this.f27366b.getZoom();
                    m21655a("正常 BestView");
                    PinActionUtils.animateCamera(this.f27367c, latLng, true, true, zoom, this.f27351F, r7);
                }
                DeparturePresenter departurePresenter = this.f27378n;
                if (departurePresenter != null) {
                    departurePresenter.stopRequest();
                }
            }
        }
    }

    /* renamed from: x */
    private Padding m21728x() {
        int i = this.f27353H;
        return new Padding(i, i, i, i);
    }

    /* renamed from: y */
    private Padding m21730y() {
        Map map = this.f27367c;
        if (map == null) {
            return m21728x();
        }
        Padding padding = map.getPadding();
        if (padding == null) {
            return m21728x();
        }
        int i = padding.bottom;
        int i2 = this.f27353H;
        if (i < i2) {
            padding.bottom = i2;
        }
        int i3 = padding.left;
        int i4 = this.f27353H;
        if (i3 < i4) {
            padding.left = i4;
        }
        int i5 = padding.top;
        int i6 = this.f27353H;
        if (i5 < i6) {
            padding.top = i6;
        }
        int i7 = padding.right;
        int i8 = this.f27353H;
        if (i7 < i8) {
            padding.right = i8;
        }
        return padding;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m21733z() {
        if (this.f27366b.isPinVisible() && this.f27366b.isRequireByDrag()) {
            if (this.f27369e != null && !this.f27381q) {
                m21655a("onStartDragging");
                this.f27369e.onStartDragging();
            }
            int A = m21619A();
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27369e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDragging(A);
            }
            m21632a(A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public int m21619A() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f27367c);
        FenceController fenceController = this.f27372h;
        int isInFence = fenceController != null ? fenceController.isInFence(mapCenterPoint) : 2;
        ZoneCircleController zoneCircleController = this.f27377m;
        if (zoneCircleController == null || zoneCircleController.allowDragToOuter()) {
            return isInFence;
        }
        if (this.f27377m.handleMapDrag(mapCenterPoint)) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    private void m21632a(int i) {
        DepartureCompParams departureCompParams = this.f27366b;
        if (departureCompParams != null && this.f27371g != null) {
            if (!departureCompParams.isBubbleVisible()) {
                this.f27371g.startDragging_Ex();
            } else if (i == 1 || i == 3) {
                this.f27371g.toNoParking();
            } else {
                this.f27371g.startDragging();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m21622B() {
        ZoneCircleController zoneCircleController = this.f27377m;
        return zoneCircleController != null && !zoneCircleController.allowDragToOuter() && this.f27377m.isOutside();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21655a(String str) {
        DLog.m10773d(this.f27365a, str, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21651a(DIDILocation dIDILocation) {
        if (this.f27367c != null && this.f27368d != null && this.f27370f && dIDILocation != null && this.f27383s != null) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                DLog.m10773d("departure", "onReceiveLocationUpdate error " + latLng.toString(), new Object[0]);
                return;
            }
            if (this.f27390z == null) {
                this.f27390z = dIDILocation;
                DLog.m10773d("departure", "onReceiveLocationUpdate 首次定位成功 " + latLng.toString(), new Object[0]);
            }
            IWalkDropWrapper iWalkDropWrapper = this.f27379o;
            if (iWalkDropWrapper != null) {
                iWalkDropWrapper.onReceiveLocationUpdate(dIDILocation);
            }
            DepartureOmegaManager departureOmegaManager = this.f27376l;
            if (departureOmegaManager != null) {
                departureOmegaManager.setLocationAccuracy(dIDILocation.getAccuracy());
            }
            DepartureInterceptController departureInterceptController = this.f27354I;
            if (departureInterceptController != null) {
                departureInterceptController.upDateCurrentLocation(dIDILocation);
            }
            if (System.currentTimeMillis() - this.f27364S > ((long) (LocFollowToggleApollo.frequency * 1000))) {
                this.f27364S = System.currentTimeMillis();
                if (this.f27346A == 0 && this.f27377m == null && this.f27375k == null && this.f27348C && LocFollowToggleApollo.enable) {
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(new LatLng(this.f27390z.getLatitude(), this.f27390z.getLongitude()), latLng);
                    boolean z = computeDistanceBetween > ((double) LocFollowToggleApollo.distance);
                    boolean z2 = dIDILocation.getAccuracy() < ((float) LocFollowToggleApollo.accuracy);
                    if (z && z2) {
                        String str = this.f27365a;
                        DLog.m10773d(str, "check 30m follow distance-->" + computeDistanceBetween + "Accuracy-->" + dIDILocation.getAccuracy(), new Object[0]);
                        this.f27383s.latLng = latLng;
                        this.f27390z = dIDILocation;
                        DepartureOmegaUtils.trackOnLocFollow();
                        updateDepartureLocation(this.f27383s, true);
                    }
                }
            }
        }
    }

    /* renamed from: C */
    private void m21624C() {
        this.f27376l.reportOmegaOnShowTerminalWelcome(this.f27374j, DepartureUtils.getFenceInfo(this.f27389y), this.f27346A == 0);
    }

    public void stop() {
        m21674c();
        m21694g();
        m21701j();
        m21726w();
        CarpoolDepartureController carpoolDepartureController = this.f27375k;
        if (carpoolDepartureController != null) {
            carpoolDepartureController.removeCircle(false);
        }
    }

    public void destroy() {
        stop();
        m21702k();
        m21699i();
        IWalkDropWrapper iWalkDropWrapper = this.f27379o;
        if (iWalkDropWrapper != null) {
            iWalkDropWrapper.onDestroy();
            this.f27379o = null;
        }
        Map map = this.f27367c;
        if (map != null) {
            map.stopAnimation();
        }
        DeparturePresenter departurePresenter = this.f27378n;
        if (departurePresenter != null) {
            departurePresenter.destroy();
            this.f27378n = null;
        }
        this.f27362Q = false;
        DepartureOmegaUtils.hasDragged = false;
        DepartureOmegaUtils.OmegaParams.scrollType = -1;
        Handler handler = this.f27350E;
        if (handler != null) {
            handler.removeCallbacks(this.f27352G);
            this.f27350E.removeCallbacksAndMessages((Object) null);
            this.f27350E = null;
        }
        this.f27374j = null;
    }

    public void addOrderInterceptListener(final DepartureInterceptController.IInterceptListener iInterceptListener) {
        DepartureInterceptController departureInterceptController = this.f27354I;
        if (departureInterceptController != null) {
            departureInterceptController.addInterceptListener(new DepartureInterceptController.IInterceptListener() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z) {
                    String D = DepartureView.this.f27365a;
                    DLog.m10773d(D, "getInterceptStatus : onIntercept model=" + orderInterceptMode + ",newPoi=" + z, new Object[0]);
                    DepartureDataStore.getInstance().saveInterceptTime();
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onIntercept(orderInterceptMode, z);
                    }
                }

                public void onContinue() {
                    DLog.m10773d(DepartureView.this.f27365a, "getInterceptStatus : onContinue", new Object[0]);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onContinue();
                    }
                }

                public void onStart() {
                    DLog.m10773d(DepartureView.this.f27365a, "getInterceptStatus : onStart", new Object[0]);
                    DepartureView.this.f27383s.latLng = DepartureView.this.m21724v();
                    DepartureView departureView = DepartureView.this;
                    departureView.m21648a(departureView.f27383s, DepartureView.this.f27346A);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onStart();
                    }
                }
            });
        }
    }

    public void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo) {
        Map map;
        DepartureLocationInfo a = m21629a(departureLocationInfo);
        this.f27383s = a;
        FenceController fenceController = this.f27372h;
        if (fenceController != null && a != null && (map = this.f27367c) != null) {
            boolean positionIsInFence = FenceUtils.positionIsInFence(map, fenceController.getFenceInfo(), this.f27383s.latLng);
            Map map2 = this.f27367c;
            if (map2 != null) {
                BestViewer.doBestView_Move(map2, this.f27383s.latLng, this.f27351F);
            }
            if (positionIsInFence) {
                m21692f(this.f27383s.latLng);
                IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27369e;
                if (iDepartureComponentCallback != null) {
                    iDepartureComponentCallback.onBroadOtherMapCallback(1);
                }
                DLog.m10773d(this.f27365a, "updatePositionWhenOutStation->选择sug点在场站内", new Object[0]);
                return;
            }
            m21648a(this.f27383s, this.f27346A);
            DLog.m10773d(this.f27365a, "updatePositionWhenOutStation->选择sug点在场站外", new Object[0]);
        }
    }
}
