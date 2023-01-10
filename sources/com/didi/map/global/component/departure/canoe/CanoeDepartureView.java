package com.didi.map.global.component.departure.canoe;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
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
import com.didi.map.global.component.departure.bubble.DepartureWalkGuide;
import com.didi.map.global.component.departure.canoe.view.AbsCanoeAddressView;
import com.didi.map.global.component.departure.canoe.view.CanoeAddressFailView;
import com.didi.map.global.component.departure.canoe.view.CanoeAddressView;
import com.didi.map.global.component.departure.canoe.view.CanoeDeparturePinView;
import com.didi.map.global.component.departure.canoe.view.DestinationFlagView;
import com.didi.map.global.component.departure.carpool.CarpoolDepartureController;
import com.didi.map.global.component.departure.circle.ZoneCircleController;
import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.controller.DepartureControllerParams;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.departure.DeparturePresenter;
import com.didi.map.global.component.departure.departure.IDepartureView;
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
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CanoeDepartureView implements IDepartureView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public AtomicBoolean f27181A;

    /* renamed from: B */
    private boolean f27182B;

    /* renamed from: C */
    private int f27183C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Handler f27184D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Padding f27185E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Runnable f27186F;

    /* renamed from: G */
    private int f27187G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public DepartureInterceptController f27188H;

    /* renamed from: I */
    private boolean f27189I;

    /* renamed from: J */
    private LatLng f27190J;

    /* renamed from: K */
    private ICollideStrategy f27191K;

    /* renamed from: L */
    private boolean f27192L;

    /* renamed from: M */
    private CanoeAddressView f27193M;

    /* renamed from: N */
    private CanoeAddressFailView f27194N;

    /* renamed from: O */
    private DestinationFlagView f27195O;

    /* renamed from: P */
    private DepartureAddress f27196P;

    /* renamed from: Q */
    private DepartureWalkGuide f27197Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f27198R;

    /* renamed from: S */
    private RpcPoi f27199S;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f27200a = "CanoeDepartureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureCompParams f27201b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f27202c;

    /* renamed from: d */
    private Context f27203d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDepartureCompContract.IDepartureComponentCallback f27204e;

    /* renamed from: f */
    private boolean f27205f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDeparturePinView f27206g;

    /* renamed from: h */
    private FenceController f27207h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IRecMarkerController f27208i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GuideLine f27209j;

    /* renamed from: k */
    private DepartureCardViewController f27210k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CarpoolDepartureController f27211l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DepartureOmegaManager f27212m = new DepartureOmegaManager();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ZoneCircleController f27213n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DeparturePresenter f27214o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f27215p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f27216q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public DepartureLocationInfo f27217r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RpcPoi f27218s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public List<RpcPoi> f27219t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public LatLng f27220u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public DepartureAddress f27221v;

    /* renamed from: w */
    private MapListener f27222w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ReverseStationsInfo f27223x;

    /* renamed from: y */
    private DIDILocation f27224y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f27225z;

    public CanoeDepartureView(Map map, Context context, DepartureCompParams departureCompParams) {
        DepartureLocationInfo departureLocationInfo = null;
        this.f27219t = null;
        this.f27222w = new MapListener();
        this.f27225z = 0;
        this.f27181A = new AtomicBoolean(false);
        this.f27182B = false;
        this.f27184D = new Handler(Looper.getMainLooper());
        this.f27186F = new Runnable() {
            public void run() {
                if (CanoeDepartureView.this.f27181A.get() || CanoeDepartureView.this.f27215p) {
                    CanoeDepartureView.this.m21451a("mPaddingRunnable delay");
                    if (CanoeDepartureView.this.f27184D != null && CanoeDepartureView.this.f27185E != null) {
                        CanoeDepartureView.this.f27184D.postDelayed(CanoeDepartureView.this.f27186F, 100);
                    }
                } else if (CanoeDepartureView.this.f27202c != null && CanoeDepartureView.this.f27202c.getCameraPosition() != null && CanoeDepartureView.this.f27185E != null) {
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m21451a("mPaddingRunnable do best view：" + CanoeDepartureView.this.f27202c.getCameraPosition().target);
                    if (CanoeDepartureView.this.f27185E != null && CanoeDepartureView.this.f27185E.equals(CanoeDepartureView.this.f27202c.getPadding())) {
                        CanoeDepartureView canoeDepartureView2 = CanoeDepartureView.this;
                        canoeDepartureView2.m21451a("mPaddingRunnable same return ; " + CanoeDepartureView.this.f27185E.toString());
                    } else if (CanoeDepartureView.this.f27202c.getMapVendor() == MapVendor.DIDI) {
                        CanoeDepartureView.this.f27202c.setPadding(CanoeDepartureView.this.f27185E.left, CanoeDepartureView.this.f27185E.top, CanoeDepartureView.this.f27185E.right, CanoeDepartureView.this.f27185E.bottom);
                    } else {
                        BestViewer.doBestView(CanoeDepartureView.this.f27202c, false, Float.valueOf((float) CanoeDepartureView.this.f27202c.getCameraPosition().zoom), CanoeDepartureView.this.f27202c.getCameraPosition().target, CanoeDepartureView.this.f27185E, (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                            public void onFinished() {
                                CanoeDepartureView.this.m21451a("mPaddingRunnable do best view onFinished");
                            }
                        });
                    }
                }
            }
        };
        this.f27199S = null;
        if (departureCompParams != null) {
            DepartureOmegaUtils.isFirst = true;
            this.f27202c = map;
            this.f27203d = context;
            this.f27201b = departureCompParams;
            this.f27187G = DisplayUtils.dp2px(context, 10.0f);
            this.f27185E = m21522w();
            DepartureCompParams departureCompParams2 = this.f27201b;
            this.f27217r = m21428a(departureCompParams2 != null ? departureCompParams2.getLocationInfo() : departureLocationInfo);
            m21430a();
            DeparturePresenter departurePresenter = new DeparturePresenter(map, context, departureCompParams);
            this.f27214o = departurePresenter;
            departurePresenter.setResponseCallback(new DeparturePresenter.IResponseCallback() {
                public void onLoading(LatLng latLng) {
                    if (CanoeDepartureView.this.f27201b.isBubbleVisible() && CanoeDepartureView.this.f27206g != null) {
                        CanoeDepartureView.this.f27206g.startLoading(CanoeDepartureView.this.m21466b(latLng) || CanoeDepartureView.this.m21477c(latLng));
                    }
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.f27204e.onDepartureLoading(latLng);
                    }
                }

                public void onHandleResult(ReverseStationsInfo reverseStationsInfo) {
                    CanoeDepartureView.this.m21450a(reverseStationsInfo);
                }

                public void onLocationChange(DIDILocation dIDILocation) {
                    CanoeDepartureView.this.m21448a(dIDILocation);
                }
            });
            Address endPoint = this.f27201b.getEndPoint();
            if (endPoint != null) {
                this.f27190J = new LatLng(endPoint.getLatitude(), endPoint.getLongitude());
            }
            boolean isHasWayPoint = this.f27201b.isHasWayPoint();
            this.f27189I = isHasWayPoint;
            this.f27188H = new DepartureInterceptController(new DepartureControllerParams(this.f27203d, this.f27202c, this.f27183C, isHasWayPoint, this.f27190J, (DepartureAddress) null, this.f27207h));
        }
    }

    /* renamed from: a */
    private DepartureLocationInfo m21428a(DepartureLocationInfo departureLocationInfo) {
        DIDILocation lastKnownLocation;
        if (departureLocationInfo == null) {
            m21451a("初始化 locationInfo= null");
            departureLocationInfo = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        } else {
            m21451a("初始化 locationInfo= " + departureLocationInfo.toString());
        }
        if (departureLocationInfo.sugPoi != null) {
            this.f27225z = departureLocationInfo.sugPoi.operationType;
            m21451a("初始化mInnerOperationType= " + this.f27225z);
        }
        if (departureLocationInfo.sugPoi != null && departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = new LatLng(departureLocationInfo.sugPoi.latitude, departureLocationInfo.sugPoi.longitude);
            m21451a("从sug初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureDataStore.getInstance().getPinLocation();
            m21451a("从缓存初始化latLng");
        }
        if (departureLocationInfo.latLng == null && (lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27203d)) != null) {
            departureLocationInfo.latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            m21451a("从定位初始化latLng");
        }
        if (departureLocationInfo.latLng == null) {
            departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(this.f27202c);
            m21451a("从map初始化latLng");
        }
        if (departureLocationInfo.latLng != null) {
            m21451a("初始化latLng : " + departureLocationInfo.latLng.toString());
            return departureLocationInfo;
        }
        throw new IllegalArgumentException("departureView don't have a default location");
    }

    /* renamed from: a */
    private void m21430a() {
        LatLng latLng;
        DepartureCompParams departureCompParams = this.f27201b;
        if (departureCompParams != null) {
            DepartureFenceOptions fenceOptions = departureCompParams.getFenceOptions();
            if (fenceOptions != null) {
                this.f27207h = new FenceController(this.f27202c, fenceOptions);
            }
            if (this.f27201b.isGuideLineVisible()) {
                this.f27209j = new GuideLine();
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27203d);
                int guideLineColor = this.f27201b.getGuideLineColor();
                if (guideLineColor == 0) {
                    guideLineColor = -13386753;
                }
                if (lastKnownLocation == null) {
                    latLng = null;
                } else {
                    latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                }
                this.f27209j.setConfigParam(new GuideLineParam(guideLineColor, latLng, DepartureUtils.getMapCenterPoint(this.f27202c)));
                this.f27209j.create(this.f27203d, this.f27202c);
            }
            ZoneCircleOption circleOption = this.f27201b.getCircleOption();
            if (circleOption != null) {
                this.f27213n = new ZoneCircleController(this.f27202c, circleOption, this.f27203d);
            }
            int sceneType = this.f27201b.getSceneType();
            this.f27183C = sceneType;
            if (sceneType == 1) {
                this.f27211l = new CarpoolDepartureController(this.f27202c, sceneType);
            }
        }
    }

    /* renamed from: b */
    private void m21458b() {
        Map map = this.f27202c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f27222w);
            this.f27202c.addOnMapGestureListener(this.f27222w);
        }
    }

    /* renamed from: c */
    private void m21474c() {
        Map map = this.f27202c;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f27222w);
            this.f27202c.removeOnMapGestureListener(this.f27222w);
        }
    }

    /* renamed from: d */
    private boolean m21483d() {
        DepartureFenceOptions fenceOptions;
        if (!(!this.f27201b.isTerminalViewVisible() || (fenceOptions = this.f27201b.getFenceOptions()) == null || fenceOptions.cardWizardStart == 0)) {
            if (fenceOptions.cardWizardStart == 2) {
                return this.f27210k.isWelcomeViewValid();
            }
            if (fenceOptions.cardWizardStart == 1) {
                return this.f27210k.isWaitCheckPickupSpot();
            }
        }
        return false;
    }

    /* renamed from: e */
    private boolean m21487e() {
        DepartureCompParams departureCompParams = this.f27201b;
        return departureCompParams != null && departureCompParams.isRecPointVisible() && (this.f27210k == null || !m21483d());
    }

    /* renamed from: f */
    private void m21489f() {
        DepartureCompParams departureCompParams = this.f27201b;
        if (departureCompParams != null && this.f27202c != null && departureCompParams.isPinVisible()) {
            m21491g();
            CanoeDeparturePinView canoeDeparturePinView = new CanoeDeparturePinView(this.f27202c.getContext());
            this.f27206g = canoeDeparturePinView;
            canoeDeparturePinView.create(this.f27203d, this.f27202c);
            this.f27206g.setConfigParam(this.f27201b.getPinStyle());
            this.f27206g.add();
        }
    }

    public void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f27204e = iDepartureComponentCallback;
    }

    /* renamed from: g */
    private void m21491g() {
        IDeparturePinView iDeparturePinView = this.f27206g;
        if (iDeparturePinView != null) {
            iDeparturePinView.destroy();
            this.f27206g = null;
        }
    }

    /* renamed from: h */
    private void m21493h() {
        ZoneCircleController zoneCircleController = this.f27213n;
        if (zoneCircleController != null) {
            zoneCircleController.showCircle();
        }
    }

    /* renamed from: a */
    private void m21444a(DepartureAddress departureAddress) {
        DepartureCompParams departureCompParams;
        if (this.f27207h != null && (departureCompParams = this.f27201b) != null && departureCompParams.isFenceVisible()) {
            this.f27207h.showFence(departureAddress);
            ReverseStationsInfo reverseStationsInfo = this.f27223x;
            if (reverseStationsInfo != null) {
                this.f27207h.showAroundFenceList(reverseStationsInfo.aroundFenceList);
            }
        }
    }

    /* renamed from: a */
    private void m21452a(List<RecPoint> list, boolean z) {
        if (this.f27223x == null || CollectionUtil.isEmpty((Collection<?>) list) || this.f27201b == null || this.f27202c == null || this.f27203d == null) {
            m21451a("showRecMarkers() return");
            return;
        }
        m21498k();
        if (!m21487e()) {
            m21451a("showRecMarkers() isRecPointVisible is false,return");
            return;
        }
        RecMarkerController recMarkerController = new RecMarkerController();
        this.f27208i = recMarkerController;
        recMarkerController.create(this.f27202c.getContext(), this.f27202c);
        RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
        recMarkerControllerParam.list = list;
        RecPointStyle pinRecStyle = DepartureStyleUtils.getPinRecStyle(this.f27203d, this.f27201b);
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
                CanoeDepartureView.this.m21453a(this.f$1, this.f$2, iRecMarker);
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
                return CanoeDepartureView.this.f27202c;
            }

            public void setVisible(String str, boolean z) {
                if (CanoeDepartureView.this.f27208i != null) {
                    CanoeDepartureView.this.f27208i.setVisible(str, z);
                }
            }
        });
        this.f27191K = collideStrategyV1;
        recMarkerControllerParam.strategy = collideStrategyV1;
        this.f27208i.setConfigParam(recMarkerControllerParam);
        this.f27208i.add();
        if (DepartureUtils.isAllowShowCircles(this.f27223x)) {
            this.f27208i.showCircles();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21453a(boolean z, List list, IRecMarker iRecMarker) {
        if (!LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DepartureUtils.getMapCenterPoint(this.f27202c))) {
            DepartureCardViewController departureCardViewController = this.f27210k;
            boolean z2 = false;
            boolean z3 = departureCardViewController != null && departureCardViewController.isTerminalViewValid();
            if (!z || !z3) {
                RpcPoi findTargetRecommend = DepartureUtils.findTargetRecommend(iRecMarker.getLocation(), this.f27219t);
                this.f27218s = findTargetRecommend;
                this.f27221v = m21427a(findTargetRecommend);
                StringBuilder sb = new StringBuilder();
                sb.append("recMarker.Onclick mAdsorbPoi is null:");
                if (this.f27218s == null) {
                    z2 = true;
                }
                sb.append(z2);
                m21451a(sb.toString());
                RpcPoi rpcPoi = this.f27218s;
                if (rpcPoi != null && rpcPoi.base_info != null) {
                    LatLng latLng = new LatLng(this.f27218s.base_info.lat, this.f27218s.base_info.lng);
                    if (z3) {
                        this.f27210k.setSelectedDeparture(this.f27218s);
                        m21449a(this.f27218s, latLng, true, true);
                        this.f27212m.reportOmegaOnTerminalRecPickupChange(this.f27218s, 2);
                        return;
                    }
                    m21449a(this.f27218s, latLng, true, true);
                    m21462b(this.f27221v);
                    return;
                }
                return;
            }
            RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(iRecMarker.getLocation(), list);
            if (findTargetRecPoint != null && !TextUtils.isEmpty(findTargetRecPoint.addrName)) {
                SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m21511q(), findTargetRecPoint.addrName);
                m21446a(adsorbTerminalAreaByName);
                this.f27212m.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
                this.f27210k.setSelectedTerminalArea(adsorbTerminalAreaByName);
                m21451a("recMarker.Onclick mTerminalView.isValid() is true");
            }
        }
    }

    /* renamed from: i */
    private void m21495i() {
        FenceController fenceController = this.f27207h;
        if (fenceController != null) {
            fenceController.removeFence();
            this.f27207h.removeAroundFenceList();
        }
    }

    /* renamed from: j */
    private void m21497j() {
        ZoneCircleController zoneCircleController = this.f27213n;
        if (zoneCircleController != null) {
            zoneCircleController.hideCircle();
        }
    }

    /* renamed from: k */
    private void m21498k() {
        ICollideStrategy iCollideStrategy = this.f27191K;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f27191K = null;
        }
        IRecMarkerController iRecMarkerController = this.f27208i;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f27208i = null;
        }
    }

    public void setFenceVisible(boolean z) {
        FenceController fenceController = this.f27207h;
        if (fenceController != null) {
            fenceController.setFenceVisible(z);
        }
    }

    public void onMapVisible(boolean z) {
        this.f27205f = z;
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

        MapListener() {
        }

        public boolean onScroll(float f, float f2) {
            if (!CanoeDepartureView.this.f27216q) {
                CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                LatLng unused = canoeDepartureView.f27220u = DepartureUtils.getMapCenterPoint(canoeDepartureView.f27202c);
                CanoeDepartureView.this.m21451a("start dragging");
                if (CanoeDepartureView.this.f27208i != null) {
                    CanoeDepartureView.this.f27208i.onMapScroll();
                }
                if (!(CanoeDepartureView.this.f27213n == null || CanoeDepartureView.this.f27213n.getCircle() == null || !CanoeDepartureView.this.f27213n.getCircle().contains(CanoeDepartureView.this.f27220u))) {
                    CanoeDepartureView.this.f27212m.reportOmegaChangeStartCircle(1);
                }
                if (CanoeDepartureView.this.f27211l != null) {
                    CanoeDepartureView.this.f27211l.removeCircle(true);
                }
                if (CanoeDepartureView.this.f27214o != null) {
                    CanoeDepartureView.this.f27214o.stopRequest();
                }
                if (CanoeDepartureView.this.f27188H != null) {
                    CanoeDepartureView.this.f27188H.setHasDragged(true);
                }
            }
            DepartureOmegaUtils.OmegaParams.scrollType = 0;
            DepartureOmegaUtils.hasDragged = true;
            CanoeDepartureView.this.m21525x();
            boolean unused2 = CanoeDepartureView.this.f27216q = true;
            return false;
        }

        public boolean onDown(float f, float f2) {
            CanoeDepartureView.this.m21451a("onDown");
            boolean unused = CanoeDepartureView.this.f27215p = true;
            if (CanoeDepartureView.this.f27184D == null) {
                return false;
            }
            CanoeDepartureView.this.f27184D.removeCallbacks(CanoeDepartureView.this.f27186F);
            return false;
        }

        public boolean onUp(float f, float f2) {
            boolean unused = CanoeDepartureView.this.f27215p = false;
            if (CanoeDepartureView.this.f27204e != null) {
                CanoeDepartureView.this.f27204e.onUp();
            }
            return false;
        }

        public void onMapStable() {
            if (CanoeDepartureView.this.f27216q) {
                CanoeDepartureView.this.m21501l();
            }
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (CanoeDepartureView.this.f27202c != null) {
                if (CanoeDepartureView.this.f27213n != null) {
                    CanoeDepartureView.this.f27213n.handleMapDrag(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f27202c));
                }
                if (CanoeDepartureView.this.f27209j != null) {
                    CanoeDepartureView.this.f27209j.updateEndPosition(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f27202c));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m21501l() {
        IRecMarkerController iRecMarkerController = this.f27208i;
        if (!(iRecMarkerController == null || iRecMarkerController.findMarker(DepartureUtils.getMapCenterPoint(this.f27202c)) == null)) {
            this.f27208i.hideCircles();
        }
        IRecMarkerController iRecMarkerController2 = this.f27208i;
        if (iRecMarkerController2 != null) {
            iRecMarkerController2.setNeedShowInfoWindow(false);
            this.f27208i.onMapStable();
        }
        m21451a("handleMapStable() mDragging=" + this.f27216q + ",isRequireByDrag=" + this.f27201b.isRequireByDrag());
        if (this.f27216q && this.f27201b.isRequireByDrag()) {
            m21433a(DepartureUtils.getMapCenterPoint(this.f27202c));
            this.f27220u = null;
        }
        this.f27216q = false;
    }

    /* renamed from: b */
    private boolean m21470b(DepartureLocationInfo departureLocationInfo) {
        return departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng);
    }

    public void onConfirmClickInBroadOther() {
        this.f27198R = false;
        this.f27192L = true;
        m21450a(this.f27223x);
    }

    public void setPadding(Padding padding) {
        Map map = this.f27202c;
        if (map != null && padding != null && !map.getPadding().equals(padding)) {
            this.f27185E = padding;
            padding.left = Math.max(padding.left, this.f27187G);
            this.f27185E.right = Math.max(padding.right, this.f27187G);
            DLog.m10773d("DepartureView", "setPadding ->: " + this.f27185E.toString(), new Object[0]);
            Handler handler = this.f27184D;
            if (handler != null) {
                handler.removeCallbacks(this.f27186F);
                this.f27184D.postDelayed(this.f27186F, 100);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0198  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21433a(com.didi.common.map.model.LatLng r8) {
        /*
            r7 = this;
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r8)
            if (r0 == 0) goto L_0x019c
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f27217r
            if (r0 == 0) goto L_0x019c
            boolean r0 = r7.f27205f
            if (r0 != 0) goto L_0x0010
            goto L_0x019c
        L_0x0010:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refreshDepartureLocationOnMapDraged() =="
            r0.append(r1)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.m21451a((java.lang.String) r0)
            r0 = 0
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r7.f27223x
            r2 = 1
            if (r1 != 0) goto L_0x0036
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f27217r
            r0.latLng = r8
        L_0x0033:
            r0 = 1
            goto L_0x0161
        L_0x0036:
            boolean r1 = r7.m21466b((com.didi.common.map.model.LatLng) r8)
            r3 = 0
            if (r1 == 0) goto L_0x0059
            java.util.List<com.sdk.poibase.model.RpcPoi> r0 = r7.f27219t
            com.sdk.poibase.model.RpcPoi r0 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r8, r0)
            r7.f27218s = r0
            if (r0 == 0) goto L_0x0054
            r7.m21449a(r0, r3, r2, r2)
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m21427a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m21462b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x0054:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f27217r
            r0.latLng = r8
            goto L_0x0033
        L_0x0059:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r1 = r7.f27217r
            com.didi.common.map.model.LatLng r1 = r1.latLng
            boolean r1 = com.didi.common.map.util.LatLngUtils.isSameLatLng(r1, r8)
            if (r1 == 0) goto L_0x0067
            r7.m21485e((com.didi.common.map.model.LatLng) r8)
            return
        L_0x0067:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r1 = r7.f27217r
            r1.latLng = r8
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r7.f27223x
            com.sdk.poibase.model.poi.FenceInfo r1 = r1.startFenceInfo
            boolean r4 = com.didi.map.global.component.departure.util.FenceUtils.isFenceMustAbsorb(r1)
            if (r4 == 0) goto L_0x010c
            com.didi.common.map.Map r4 = r7.f27202c
            boolean r1 = com.didi.map.global.component.departure.util.FenceUtils.positionIsInFence(r4, r1, r8)
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7.f27198R
            if (r1 == 0) goto L_0x008c
            r7.m21485e((com.didi.common.map.model.LatLng) r8)
            com.didi.map.global.component.departure.IDepartureCompContract$IDepartureComponentCallback r8 = r7.f27204e
            if (r8 == 0) goto L_0x008b
            r8.onBroadOtherMapCallback(r2)
        L_0x008b:
            return
        L_0x008c:
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f27210k
            if (r1 == 0) goto L_0x00c2
            boolean r1 = r1.isTerminal()
            if (r1 == 0) goto L_0x00c2
            com.didi.map.global.component.departure.model.SpecialPois r0 = r7.m21511q()
            java.util.List r0 = com.didi.map.global.component.departure.util.TerminalUtils.getTerminalRecPointList(r0)
            com.didi.map.global.component.recmarker.model.RecPoint r0 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecPoint(r8, r0)
            if (r0 == 0) goto L_0x00be
            java.lang.String r1 = r0.addrName
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00be
            com.didi.map.global.component.departure.model.SpecialPois r1 = r7.m21511q()
            java.lang.String r0 = r0.addrName
            com.didi.map.global.component.departure.model.SPoi r0 = com.didi.map.global.component.departure.util.TerminalUtils.getAdsorbTerminalAreaByName(r1, r0)
            r7.m21446a((com.didi.map.global.component.departure.model.SPoi) r0)
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f27210k
            r1.setSelectedTerminalArea(r0)
        L_0x00be:
            r7.m21485e((com.didi.common.map.model.LatLng) r8)
            return
        L_0x00c2:
            java.util.List<com.sdk.poibase.model.RpcPoi> r1 = r7.f27219t
            com.sdk.poibase.model.RpcPoi r1 = com.didi.map.global.component.departure.util.DepartureUtils.findTargetRecommend(r8, r1)
            r7.f27218s = r1
            if (r1 == 0) goto L_0x0161
            com.didi.map.global.component.departure.view.DepartureCardViewController r8 = r7.f27210k
            if (r8 == 0) goto L_0x00f9
            boolean r8 = r8.isTerminalViewValid()
            if (r8 == 0) goto L_0x00f9
            com.didi.map.global.component.departure.view.DepartureCardViewController r8 = r7.f27210k
            com.sdk.poibase.model.RpcPoi r0 = r7.f27218s
            r8.setSelectedDeparture(r0)
            com.didi.map.global.component.recmarker.IRecMarkerController r8 = r7.f27208i
            if (r8 == 0) goto L_0x00e6
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            r7.m21449a(r8, r3, r2, r2)
        L_0x00e6:
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r8 = r7.f27212m
            com.didi.map.global.component.departure.view.DepartureCardViewController r0 = r7.f27210k
            com.didi.map.global.component.departure.model.SPoi r0 = r0.getSelectedTerminalArea()
            r8.setSelectedTerminalSPoi(r0)
            com.didi.map.global.component.departure.manager.DepartureOmegaManager r8 = r7.f27212m
            com.sdk.poibase.model.RpcPoi r0 = r7.f27218s
            r8.reportOmegaOnTerminalRecPickupChange(r0, r2)
            goto L_0x0102
        L_0x00f9:
            com.didi.map.global.component.recmarker.IRecMarkerController r8 = r7.f27208i
            if (r8 == 0) goto L_0x0102
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            r7.m21449a(r8, r3, r2, r2)
        L_0x0102:
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m21427a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m21462b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x010c:
            com.didi.map.global.component.departure.departure.DeparturePresenter r1 = r7.f27214o
            if (r1 == 0) goto L_0x0116
            java.util.List<com.sdk.poibase.model.RpcPoi> r3 = r7.f27219t
            com.sdk.poibase.model.RpcPoi r3 = r1.sensing(r3)
        L_0x0116:
            r7.f27218s = r3
            if (r3 == 0) goto L_0x0033
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r3.base_info
            if (r1 == 0) goto L_0x0033
            com.didi.map.global.component.recmarker.IRecMarkerController r1 = r7.f27208i
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = "refreshDepartureLocationOnMapDraged is 5% poi"
            r7.m21451a((java.lang.String) r1)
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f27210k
            if (r1 == 0) goto L_0x0139
            boolean r1 = r1.isTerminalViewValid()
            if (r1 == 0) goto L_0x0139
            com.didi.map.global.component.departure.view.DepartureCardViewController r1 = r7.f27210k
            com.sdk.poibase.model.RpcPoi r3 = r7.f27218s
            r1.setSelectedDeparture(r3)
        L_0x0139:
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoi r3 = r7.f27218s
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r3.base_info
            double r3 = r3.lat
            com.sdk.poibase.model.RpcPoi r5 = r7.f27218s
            com.sdk.poibase.model.RpcPoiBaseInfo r5 = r5.base_info
            double r5 = r5.lng
            r1.<init>((double) r3, (double) r5)
            com.didi.map.global.component.recmarker.IRecMarkerController r3 = r7.f27208i
            com.didi.map.global.component.recmarker.view.IRecMarker r3 = r3.findMarker(r1)
            if (r3 == 0) goto L_0x0161
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            r7.m21449a(r8, r1, r2, r2)
            com.sdk.poibase.model.RpcPoi r8 = r7.f27218s
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r7.m21427a((com.sdk.poibase.model.RpcPoi) r8)
            r7.m21462b((com.didi.map.global.component.departure.model.DepartureAddress) r8)
            return
        L_0x0161:
            if (r0 == 0) goto L_0x0198
            boolean r8 = r7.m21529z()
            if (r8 == 0) goto L_0x0192
            com.didi.map.global.component.departure.circle.ZoneCircleController r8 = r7.f27213n
            com.didi.common.map.model.LatLng r8 = r8.getCenter()
            com.didi.common.map.model.LatLng r0 = r7.f27220u
            if (r0 == 0) goto L_0x018b
            com.didi.map.global.component.departure.circle.ZoneCircleController r0 = r7.f27213n
            com.didi.common.map.model.Circle r0 = r0.getCircle()
            if (r0 == 0) goto L_0x018b
            com.didi.map.global.component.departure.circle.ZoneCircleController r0 = r7.f27213n
            com.didi.common.map.model.Circle r0 = r0.getCircle()
            com.didi.common.map.model.LatLng r1 = r7.f27220u
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x018b
            com.didi.common.map.model.LatLng r8 = r7.f27220u
        L_0x018b:
            r7.m21480d((com.didi.common.map.model.LatLng) r8)
            com.didi.map.global.component.departure.model.DepartureLocationInfo r0 = r7.f27217r
            r0.latLng = r8
        L_0x0192:
            com.didi.map.global.component.departure.model.DepartureLocationInfo r8 = r7.f27217r
            r7.m21445a((com.didi.map.global.component.departure.model.DepartureLocationInfo) r8, (int) r2)
            goto L_0x019b
        L_0x0198:
            r7.m21485e((com.didi.common.map.model.LatLng) r8)
        L_0x019b:
            return
        L_0x019c:
            r7.m21485e((com.didi.common.map.model.LatLng) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m21433a(com.didi.common.map.model.LatLng):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21445a(DepartureLocationInfo departureLocationInfo, int i) {
        m21451a("startPoiRequest...");
        if (this.f27201b != null) {
            this.f27182B = CallFrom.CANOE_DEPARTURE_FROMHOME == this.f27201b.getReqCallerId() && (departureLocationInfo.latLng == null || i == 0);
        }
        if (this.f27214o != null && departureLocationInfo != null) {
            this.f27217r = departureLocationInfo;
            CarpoolDepartureController carpoolDepartureController = this.f27211l;
            if (carpoolDepartureController != null) {
                carpoolDepartureController.drawCircle(departureLocationInfo.latLng);
            }
            this.f27225z = i;
            this.f27214o.startRequest(departureLocationInfo, i, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m21466b(LatLng latLng) {
        FenceController fenceController = this.f27207h;
        return fenceController != null && fenceController.isInFence(latLng) == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m21477c(LatLng latLng) {
        FenceController fenceController = this.f27207h;
        return fenceController != null && fenceController.isInFence(latLng) == 3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21450a(ReverseStationsInfo reverseStationsInfo) {
        if (this.f27205f) {
            DepartureCompParams departureCompParams = this.f27201b;
            if (departureCompParams == null || departureCompParams.getApiType() != ApiType.DEPARTURE_POI_INFO) {
                m21476c(reverseStationsInfo);
                return;
            }
            if (this.f27198R) {
                this.f27198R = false;
            }
            m21465b(reverseStationsInfo);
        }
    }

    /* renamed from: b */
    private void m21465b(ReverseStationsInfo reverseStationsInfo) {
        SPoi sPoi;
        DepartureCardViewController departureCardViewController;
        m21451a("handlePoiResult()  start");
        if (reverseStationsInfo == null) {
            m21507o();
            return;
        }
        DepartureOmegaUtils.OmegaParams.type = 1;
        this.f27223x = reverseStationsInfo;
        m21495i();
        m21498k();
        ArrayList<RpcPoi> recStartPoints = reverseStationsInfo.getRecStartPoints();
        this.f27219t = recStartPoints;
        if (CollectionUtil.isEmpty((Collection<?>) recStartPoints)) {
            this.f27219t = TerminalUtils.getSelectedSpecialRpcPoiList(this.f27223x);
        }
        this.f27218s = DepartureUtils.findRecommendAdsorbPoint(this.f27219t);
        if (this.f27192L) {
            LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f27202c);
            sPoi = TerminalUtils.getNearestSpoi(mapCenterPoint, this.f27223x);
            if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
                List<RpcPoi> list = sPoi.list;
                this.f27219t = list;
                this.f27218s = DepartureUtils.findTargetRecommend(mapCenterPoint, list);
            }
        } else {
            sPoi = null;
        }
        DepartureAddress a = m21427a(this.f27218s);
        this.f27221v = a;
        m21486e(a);
        if (this.f27192L && (departureCardViewController = this.f27210k) != null) {
            if (departureCardViewController != null) {
                departureCardViewController.performSelectedArea(sPoi, this.f27218s);
            }
            this.f27192L = false;
        }
        m21444a(this.f27221v);
        List<RecPoint> terminalRecPointListWithoutPointFirst = TerminalUtils.getTerminalRecPointListWithoutPointFirst(m21511q());
        if (!CollectionUtil.isEmpty((Collection<?>) terminalRecPointListWithoutPointFirst)) {
            m21452a(terminalRecPointListWithoutPointFirst, true);
        } else {
            m21452a(TerminalUtils.getRecPointList(this.f27219t), false);
        }
        DepartureCardViewController departureCardViewController2 = this.f27210k;
        if (departureCardViewController2 == null || !departureCardViewController2.isValidAndTerminal() || CollectionUtil.isEmpty((Collection<?>) terminalRecPointListWithoutPointFirst) || this.f27183C == 1) {
            this.f27212m.clearTerminalCache();
            if (this.f27208i == null) {
                m21451a("handlePoiResult,is normal poi, mRecMakerController is null,mLocationInfo=" + this.f27217r);
                LatLng u = m21519u();
                if (CallFrom.CANOE_DEPARTURE_FROMHOME != this.f27201b.getReqCallerId()) {
                    m21480d(u);
                }
                m21462b(this.f27221v);
                m21420A();
                return;
            }
            RpcPoi rpcPoi = this.f27218s;
            if (rpcPoi == null || rpcPoi.base_info == null) {
                m21451a("handleResult() 普通推荐点-未吸附");
            } else {
                LatLng latLng = new LatLng(this.f27218s.base_info.lat, this.f27218s.base_info.lng);
                m21451a("handleResult() 普通推荐点-吸附: " + latLng.toString());
                m21449a(this.f27218s, latLng, true, true);
                DepartureAddress departureAddress = this.f27221v;
                if (departureAddress != null && departureAddress.getZoneType() == 0) {
                    this.f27212m.setDefaultRecTerminalPickupPoi(this.f27218s);
                }
                DepartureCardViewController departureCardViewController3 = this.f27210k;
                if (departureCardViewController3 != null && departureCardViewController3.isTerminalViewValid()) {
                    this.f27212m.setSelectedTerminalSPoi(this.f27210k.getSelectedTerminalArea());
                }
            }
            if (this.f27183C == 1) {
                m21495i();
            }
            m21462b(this.f27221v);
            m21420A();
            return;
        }
        RecPoint findTargetRecPoint = DepartureUtils.findTargetRecPoint(DepartureUtils.getMapCenterPoint(this.f27202c), terminalRecPointListWithoutPointFirst);
        if (findTargetRecPoint == null || TextUtils.isEmpty(findTargetRecPoint.addrName)) {
            m21451a("handleResult() 场站内-未吸附");
            return;
        }
        m21451a("handleResult() 场站内-吸附,recPoint=" + findTargetRecPoint.location.toString());
        SPoi adsorbTerminalAreaByName = TerminalUtils.getAdsorbTerminalAreaByName(m21511q(), findTargetRecPoint.addrName);
        this.f27210k.setSelectedTerminalArea(adsorbTerminalAreaByName);
        this.f27212m.setSelectedTerminalSPoi(adsorbTerminalAreaByName);
        m21449a((RpcPoi) null, findTargetRecPoint.location, true, true);
        m21462b(this.f27221v);
        m21420A();
    }

    /* renamed from: c */
    private void m21476c(ReverseStationsInfo reverseStationsInfo) {
        m21451a("handleReverseGeoResult() start");
        DepartureOmegaUtils.OmegaParams.type = 0;
        if (reverseStationsInfo != null) {
            DepartureAddress a = m21427a((RpcPoi) null);
            this.f27221v = a;
            if (a != null) {
                m21480d(m21519u());
                this.f27223x = reverseStationsInfo;
                PinActionUtils.startAdsorbRecommendAnimation((IPinDrawer) null, 10, (DepartureMarkerView.AnimationFinishListener) null);
                m21462b(this.f27221v);
                return;
            }
        }
        m21451a("handleReverseGeoResult() is null, return.");
        m21507o();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m21449a(com.sdk.poibase.model.RpcPoi r12, com.didi.common.map.model.LatLng r13, final boolean r14, final boolean r15) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x000a
            if (r13 != 0) goto L_0x000a
            java.lang.String r12 = "animateToAdsorbPoi() is null, return."
            r11.m21451a((java.lang.String) r12)
            return
        L_0x000a:
            boolean r0 = r11.m21487e()
            if (r0 != 0) goto L_0x0016
            java.lang.String r12 = "animateToAdsorbPoi() recMarkerShowable is false, return."
            r11.m21451a((java.lang.String) r12)
            return
        L_0x0016:
            java.lang.String r0 = "animateToAdsorbPoi 吸附开始"
            r11.m21451a((java.lang.String) r0)
            com.sdk.poibase.model.RpcPoi r0 = r11.f27218s
            com.didi.map.global.component.departure.util.DepartureOmegaUtils.mapDragRecommend(r0)
            r0 = 0
            if (r12 == 0) goto L_0x0035
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r12.base_info
            if (r1 == 0) goto L_0x0035
            com.didi.common.map.model.LatLng r13 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r0 = r12.base_info
            double r0 = r0.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r12 = r12.base_info
            double r2 = r12.lng
            r13.<init>((double) r0, (double) r2)
            goto L_0x0037
        L_0x0035:
            if (r13 == 0) goto L_0x0039
        L_0x0037:
            r5 = r13
            goto L_0x003a
        L_0x0039:
            r5 = r0
        L_0x003a:
            if (r5 == 0) goto L_0x0064
            com.didi.map.global.component.departure.DepartureCompParams r12 = r11.f27201b
            if (r12 != 0) goto L_0x0041
            goto L_0x0064
        L_0x0041:
            com.didi.map.global.component.recmarker.IRecMarkerController r12 = r11.f27208i
            if (r12 == 0) goto L_0x004a
            com.didi.map.global.component.recmarker.RecMarkerController r12 = (com.didi.map.global.component.recmarker.RecMarkerController) r12
            r12.updateMarkerPinedState(r5)
        L_0x004a:
            java.util.concurrent.atomic.AtomicBoolean r12 = r11.f27181A
            r13 = 1
            r12.set(r13)
            com.didi.common.map.Map r4 = r11.f27202c
            r6 = 1
            r7 = 0
            com.didi.map.global.component.departure.DepartureCompParams r12 = r11.f27201b
            float r8 = r12.getZoom()
            com.didi.common.map.model.Padding r9 = r11.f27185E
            com.didi.map.global.component.departure.canoe.CanoeDepartureView$5 r10 = new com.didi.map.global.component.departure.canoe.CanoeDepartureView$5
            r10.<init>(r14, r15, r5)
            com.didi.map.global.component.departure.util.PinActionUtils.animateCamera(r4, r5, r6, r7, r8, r9, r10)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m21449a(com.sdk.poibase.model.RpcPoi, com.didi.common.map.model.LatLng, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21480d(LatLng latLng) {
        if (latLng != null) {
            m21451a("animateToDeparture 动画开始");
            boolean z = (this.f27213n == null && this.f27211l == null) ? this.f27225z == 0 : false;
            this.f27181A.set(true);
            PinActionUtils.animateCamera(this.f27202c, latLng, true, z, this.f27201b.getZoom(), this.f27185E, new BestViewer.IBestViewListener() {
                public void onFinished() {
                    CanoeDepartureView.this.m21451a("动画完成");
                    CanoeDepartureView.this.f27181A.set(false);
                    int u = CanoeDepartureView.this.m21526y();
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.f27204e.onDragging(u);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    private void m21485e(LatLng latLng) {
        String str;
        boolean z;
        AbsCanoeAddressView absCanoeAddressView;
        if (this.f27201b.isBubbleVisible() && this.f27206g != null) {
            DepartureCardViewController departureCardViewController = this.f27210k;
            boolean z2 = departureCardViewController != null && departureCardViewController.isTerminalViewValid() && !this.f27210k.isWelcomeViewValid() && !this.f27210k.isTerminal() && !this.f27210k.isWaitCheckPickupSpot() && this.f27183C != 1;
            AddressWalkGuide m = m21503m();
            if (m != null && z2) {
                if (this.f27197Q == null) {
                    DepartureWalkGuide departureWalkGuide = new DepartureWalkGuide(this.f27202c.getContext());
                    this.f27197Q = departureWalkGuide;
                    departureWalkGuide.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CanoeDepartureView.this.m21459b(view);
                        }
                    });
                }
                this.f27197Q.setData(m);
                IDeparturePinView iDeparturePinView = this.f27206g;
                DepartureWalkGuide departureWalkGuide2 = this.f27197Q;
                iDeparturePinView.showView(departureWalkGuide2, departureWalkGuide2.getWIDTH(), this.f27197Q.getHEIGHT(), this.f27197Q.getANGLE());
            } else if (m21466b(latLng) || m21477c(latLng)) {
                this.f27206g.toNoParking();
            } else {
                String n = m21505n();
                DepartureCardViewController departureCardViewController2 = this.f27210k;
                if (departureCardViewController2 == null || (!departureCardViewController2.isWelcomeViewValid() && !this.f27210k.isWaitCheckPickupSpot() && !this.f27210k.isTerminal())) {
                    int i = this.f27183C;
                    if (i == 3) {
                        DepartureAddress departureAddress = this.f27196P;
                        if (departureAddress != null) {
                            str = departureAddress.getDepartureDisplayName();
                            z = true;
                        } else {
                            str = this.f27202c.getContext().getString(R.string.canoe_input);
                            z = false;
                        }
                        if (z) {
                            if (this.f27193M == null) {
                                this.f27193M = new CanoeAddressView(this.f27202c.getContext());
                            }
                            absCanoeAddressView = this.f27193M;
                        } else {
                            if (this.f27194N == null) {
                                this.f27194N = new CanoeAddressFailView(this.f27202c.getContext());
                            }
                            absCanoeAddressView = this.f27194N;
                        }
                        absCanoeAddressView.setAddressName(str);
                        absCanoeAddressView.setClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                CanoeDepartureView.this.m21432a(view);
                            }
                        });
                        int[] widthHeight = absCanoeAddressView.getWidthHeight();
                        this.f27206g.showView(absCanoeAddressView, widthHeight[0], widthHeight[1], absCanoeAddressView.getAngle());
                    } else if (i == 4) {
                        if (this.f27195O == null) {
                            this.f27195O = new DestinationFlagView(this.f27202c.getContext());
                        }
                        int[] widthHeight2 = this.f27195O.getWidthHeight();
                        IDeparturePinView iDeparturePinView2 = this.f27206g;
                        DestinationFlagView destinationFlagView = this.f27195O;
                        iDeparturePinView2.showView(destinationFlagView, widthHeight2[0], widthHeight2[1], destinationFlagView.getAngle());
                    } else if (i == 5) {
                        if (TextUtils.isEmpty(n)) {
                            n = this.f27202c.getContext().getString(R.string.Canoe_Rider_Mainprocess_Get_in_YPSM);
                        }
                        this.f27206g.showText(n);
                    } else {
                        if (TextUtils.isEmpty(n)) {
                            n = this.f27202c.getContext().getString(R.string.GRider_Homepage0714_Get_on_XNNb);
                        }
                        this.f27206g.showText(n);
                    }
                } else {
                    this.f27206g.showText(this.f27202c.getContext().getString(R.string.GRider_Homepage0714_Get_in_tpiW));
                }
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                DepartureOmegaUtils.trackPinMove(DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f27202c));
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21459b(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27204e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21432a(View view) {
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27204e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onClickBubble();
        }
    }

    /* renamed from: m */
    private AddressWalkGuide m21503m() {
        DepartureAddress departureAddress = this.f27196P;
        if (departureAddress == null || departureAddress.getExtendInfo() == null || this.f27196P.getExtendInfo().getWalkGuide() == null || !this.f27196P.getExtendInfo().getWalkGuide().isValid()) {
            return null;
        }
        return this.f27196P.getExtendInfo().getWalkGuide();
    }

    /* renamed from: n */
    private String m21505n() {
        DepartureAddress departureAddress = this.f27196P;
        if (departureAddress == null || departureAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(this.f27196P.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21462b(DepartureAddress departureAddress) {
        this.f27196P = departureAddress;
        DepartureInterceptController departureInterceptController = this.f27188H;
        if (departureInterceptController != null) {
            ReverseStationsInfo reverseStationsInfo = this.f27223x;
            departureInterceptController.updateNewRequestLocation(departureAddress, reverseStationsInfo == null ? null : reverseStationsInfo.locLevel);
        }
        m21451a("onDepartureAddrSuccess callback");
        if (departureAddress != null) {
            m21475c(departureAddress);
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27204e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDepartureAddressChanged(departureAddress);
            }
            m21485e(departureAddress.getPosition());
        } else {
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback2 = this.f27204e;
            if (iDepartureComponentCallback2 != null) {
                iDepartureComponentCallback2.onFetchAddressFail(m21508p());
            }
            m21485e(m21508p());
        }
        m21434a(departureAddress == null ? m21508p() : departureAddress.getPosition(), false);
    }

    /* renamed from: o */
    private void m21507o() {
        m21485e(m21508p());
        DepartureInterceptController departureInterceptController = this.f27188H;
        if (departureInterceptController != null) {
            departureInterceptController.updateNewRequestLocation((DepartureAddress) null, (String) null);
        }
        IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27204e;
        if (iDepartureComponentCallback != null) {
            iDepartureComponentCallback.onFetchAddressFail(m21508p());
        }
        m21434a(m21508p(), true);
    }

    /* renamed from: a */
    private void m21434a(LatLng latLng, boolean z) {
        LatLng latLng2;
        String str;
        Map map = this.f27202c;
        if (map != null) {
            if (latLng == null) {
                latLng = DepartureUtils.getMapCenterPoint(map);
            }
            if (m21466b(latLng) || m21477c(latLng)) {
                FenceInfo fenceInfo = this.f27207h.getFenceInfo();
                DepartureAddress departureAddress = this.f27221v;
                String str2 = null;
                if (departureAddress == null || departureAddress.getAddress() == null) {
                    str = null;
                    latLng2 = null;
                } else {
                    str = this.f27221v.getAddress().poiId;
                    latLng2 = this.f27221v.getPosition();
                }
                if (fenceInfo != null) {
                    str2 = fenceInfo.fenceId;
                }
                if (str2 == null) {
                    str2 = this.f27207h.isInAroundFence(latLng);
                }
                if (!TextUtils.isEmpty(str2)) {
                    DepartureOmegaUtils.trackNoParkingError(latLng2, str, str2, z ? 1 : 0);
                }
            }
        }
    }

    /* renamed from: c */
    private void m21475c(DepartureAddress departureAddress) {
        m21482d(departureAddress);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21482d(DepartureAddress departureAddress) {
        DepartureOmegaManager departureOmegaManager = this.f27212m;
        if (departureOmegaManager != null) {
            departureOmegaManager.setPickupPoiDescription(DepartureUtils.getMainTitleFromDepartureAddr(departureAddress));
        }
    }

    /* renamed from: p */
    private LatLng m21508p() {
        DepartureLocationInfo departureLocationInfo = this.f27217r;
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
    public com.didi.map.global.component.departure.model.DepartureAddress m21427a(com.sdk.poibase.model.RpcPoi r8) {
        /*
            r7 = this;
            com.didi.map.global.component.departure.departure.DeparturePresenter r0 = r7.f27214o
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
            com.sdk.poibase.model.poi.ReverseStationsInfo r0 = r7.f27223x
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
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r7.f27223x
            if (r2 == 0) goto L_0x004d
            com.sdk.poibase.model.RpcPoi r1 = r2.getDepartureAddress()
        L_0x004d:
            com.didi.map.global.component.departure.departure.DeparturePresenter r2 = r7.f27214o
            com.didi.common.map.model.LatLng r3 = r7.m21508p()
            boolean r0 = r7.m21466b((com.didi.common.map.model.LatLng) r0)
            com.didi.map.global.component.departure.model.DepartureAddress r8 = r2.getDepartureAddress(r8, r1, r3, r0)
            return r8
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.canoe.CanoeDepartureView.m21427a(com.sdk.poibase.model.RpcPoi):com.didi.map.global.component.departure.model.DepartureAddress");
    }

    /* renamed from: q */
    private SpecialPois m21511q() {
        DepartureAddress departureAddress = this.f27221v;
        if (departureAddress != null) {
            return departureAddress.getSpecialPois();
        }
        return null;
    }

    /* renamed from: e */
    private void m21486e(DepartureAddress departureAddress) {
        if (this.f27201b.isTerminalViewVisible()) {
            m21451a("handleTerminalView() isTerminalViewVisible is true");
            if (departureAddress != null && departureAddress.getZoneType() == 0) {
                m21514s();
            }
            DepartureCardViewController departureCardViewController = this.f27210k;
            if (departureCardViewController != null) {
                departureCardViewController.setData(departureAddress, DepartureUtils.getFenceInfo(this.f27223x), this.f27218s);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m21512r() {
        this.f27198R = true;
        m21498k();
    }

    /* renamed from: s */
    private void m21514s() {
        if (this.f27210k == null) {
            DepartureCardViewController departureCardViewController = new DepartureCardViewController(this.f27203d, this.f27201b);
            this.f27210k = departureCardViewController;
            departureCardViewController.setTerminalViewCallback(new ITerminalView.Callback() {
                public void onTerminalAreaSelected(SPoi sPoi, int i) {
                    CanoeDepartureView.this.m21446a(sPoi);
                    CanoeDepartureView.this.f27212m.setSelectedTerminalSPoi(sPoi);
                }

                public void onDepartureSelected(RpcPoi rpcPoi, int i) {
                    CanoeDepartureView.this.m21464b(rpcPoi);
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m21451a("onDepartureSelected eventCode=" + i);
                    if (i == 2) {
                        CanoeDepartureView.this.f27212m.reportOmegaOnTerminalRecPickupChange(CanoeDepartureView.this.f27218s, 3);
                    }
                }

                public void onClickChange(SpecialPois specialPois) {
                    CanoeDepartureView.this.m21447a(specialPois);
                }

                public void onClickNext(SPoi sPoi) {
                    CanoeDepartureView.this.m21463b(sPoi);
                }

                public void onClickConfirmPickup(RpcPoi rpcPoi) {
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.m21482d(CanoeDepartureView.this.m21427a(rpcPoi));
                        CanoeDepartureView.this.f27204e.onConfirmPickup(CanoeDepartureView.this.m21427a(rpcPoi));
                    }
                    CanoeDepartureView.this.f27212m.reportOmegaOnTerminalConfirmButtonClick(rpcPoi);
                }

                public void onClickBroadOther() {
                    CanoeDepartureView.this.m21512r();
                    FenceInfo fenceInfo = CanoeDepartureView.this.f27221v.getFenceInfo();
                    if (!(fenceInfo == null || CanoeDepartureView.this.f27221v.getAddress() == null)) {
                        CanoeDepartureView.this.f27221v.getAddress().displayName = fenceInfo.fenceName;
                    }
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.f27204e.onClickBroadOtherInStationCard(CanoeDepartureView.this.f27221v);
                    }
                    CanoeDepartureView.this.f27212m.reportOmegaStationAreaBroadFromOther();
                }
            });
            this.f27210k.setWelcomeViewCallback(new ITerminalWelcomeView.Callback() {
                public void onClickSetPickupSpot() {
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.f27204e.onStartTerminalWindow(CanoeDepartureView.this.f27221v);
                    }
                    CanoeDepartureView.this.f27212m.reportOmegaOnWelcomeButtonClick();
                }

                public void onClickSelectOtherArea() {
                    if (CanoeDepartureView.this.f27204e != null) {
                        CanoeDepartureView.this.f27204e.onStartSugPage(CanoeDepartureView.this.f27221v);
                    }
                    CanoeDepartureView.this.f27212m.reportOmegaOnOtherAreaClick();
                }
            });
        }
    }

    /* renamed from: t */
    private void m21517t() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f27202c);
        if (mapCenterPoint != null) {
            this.f27217r.latLng = mapCenterPoint;
            m21445a(this.f27217r, 1);
        }
    }

    public DepartureAddress getDepartureAddress() {
        return this.f27221v;
    }

    public void startTerminalSelect() {
        DepartureCardViewController departureCardViewController = this.f27210k;
        if (departureCardViewController != null) {
            departureCardViewController.setPickupSpotChecked(true);
            m21517t();
        }
    }

    public boolean isShowTerminalViewOnSetPickupSpotAfter() {
        DepartureCardViewController departureCardViewController;
        if (this.f27201b.isTerminalViewVisible() && (departureCardViewController = this.f27210k) != null && departureCardViewController.isWaitCheckPickupSpot()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21446a(SPoi sPoi) {
        m21451a("terminalAreaSelected()");
        if (!(sPoi == null || sPoi.area == null || sPoi.area.centre_point == null)) {
            m21449a((RpcPoi) null, new LatLng(sPoi.area.centre_point.lat, sPoi.area.centre_point.lng), true, false);
        }
        this.f27199S = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21464b(RpcPoi rpcPoi) {
        m21451a("departureSelected()");
        if (rpcPoi != null && rpcPoi.base_info != null) {
            this.f27218s = rpcPoi;
            m21449a(rpcPoi, (LatLng) null, true, false);
            RpcPoi rpcPoi2 = this.f27199S;
            String str = (rpcPoi2 == null || rpcPoi2.base_info == null) ? "" : this.f27199S.base_info.poi_id;
            if (TextUtils.isEmpty(str) || !str.equals(rpcPoi.base_info.poi_id)) {
                this.f27199S = rpcPoi;
                if (this.f27204e != null) {
                    DepartureAddress a = m21427a(rpcPoi);
                    DepartureCardViewController departureCardViewController = this.f27210k;
                    if (departureCardViewController != null) {
                        departureCardViewController.refreshTerminalCardViewSubNotice(a);
                    }
                    m21482d(a);
                    this.f27196P = a;
                    if (a != null) {
                        m21475c(a);
                        this.f27204e.onDepartureAddressChanged(a);
                        m21485e(a.getPosition());
                        return;
                    }
                    this.f27204e.onFetchAddressFail(m21508p());
                    m21485e(m21508p());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21447a(SpecialPois specialPois) {
        m21451a("clickChangeToShowTerminalAreaList()");
        List<RecPoint> terminalRecPointList = TerminalUtils.getTerminalRecPointList(specialPois);
        DepartureCardViewController departureCardViewController = this.f27210k;
        if (departureCardViewController != null && departureCardViewController.hasTerminalView()) {
            m21452a(terminalRecPointList, true);
            SPoi selectedTerminalArea = this.f27210k.getSelectedTerminalArea();
            if (selectedTerminalArea == null) {
                selectedTerminalArea = TerminalUtils.getAdsorbTerminalArea(specialPois);
            }
            m21446a(selectedTerminalArea);
            m21485e((LatLng) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21463b(SPoi sPoi) {
        m21451a("clickNextToSelectTerminalArea()");
        if (sPoi != null && !CollectionUtil.isEmpty((Collection<?>) sPoi.list)) {
            this.f27219t = sPoi.list;
            m21452a(TerminalUtils.getRecPointList(sPoi.list), false);
            RpcPoi findRecommendAdsorbPoint = DepartureUtils.findRecommendAdsorbPoint(sPoi.list);
            m21464b(findRecommendAdsorbPoint);
            this.f27212m.setSelectedTerminalSPoi(sPoi);
            this.f27212m.setDefaultRecTerminalPickupPoi(findRecommendAdsorbPoint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public LatLng m21519u() {
        DepartureLocationInfo departureLocationInfo = this.f27217r;
        if (departureLocationInfo == null || departureLocationInfo.latLng == null || this.f27217r.latLng.latitude == 0.0d) {
            return DepartureUtils.getMapCenterPoint(this.f27202c);
        }
        return this.f27217r.latLng;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f27217r;
    }

    public View getDepartureCardView() {
        DepartureCardViewController departureCardViewController = this.f27210k;
        if (departureCardViewController != null) {
            return departureCardViewController.getDepartureCardView();
        }
        return null;
    }

    /* renamed from: v */
    private void m21521v() {
        DeparturePresenter departurePresenter = this.f27214o;
        if (departurePresenter != null) {
            departurePresenter.stopRequest();
        }
    }

    public void start() {
        m21458b();
        m21489f();
        m21493h();
        m21445a(this.f27217r, this.f27225z);
        this.f27181A.set(true);
        C1016510 r8 = new BestViewer.IBestViewListener() {
            public void onFinished() {
                CanoeDepartureView.this.f27181A.set(false);
            }
        };
        ZoneCircleController zoneCircleController = this.f27213n;
        if (zoneCircleController == null || CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
            DepartureLocationInfo departureLocationInfo = this.f27217r;
            if (departureLocationInfo != null && LatLngUtils.locateCorrect(departureLocationInfo.latLng)) {
                CarpoolDepartureController carpoolDepartureController = this.f27211l;
                if (carpoolDepartureController != null) {
                    BestViewer.doBestView(this.f27202c, false, (LatLng) null, carpoolDepartureController.getBestViewPoints(this.f27217r.latLng), this.f27185E, (Padding) null, r8);
                    return;
                }
                PinActionUtils.animateCamera(this.f27202c, this.f27217r.latLng, false, true, this.f27201b.getZoom(), this.f27185E, r8);
                return;
            }
            return;
        }
        BestViewer.doBestView(this.f27202c, false, (LatLng) null, this.f27213n.getBestViewPoints(), this.f27185E, (Padding) null, r8);
    }

    public void updateDepartureLocation(final DepartureLocationInfo departureLocationInfo, final boolean z) {
        if (this.f27205f && m21470b(departureLocationInfo)) {
            m21451a("updateDepartureLocation=" + departureLocationInfo);
            DepartureOmegaUtils.OmegaParams.scrollType = 1;
            C1016611 r7 = new BestViewer.IBestViewListener() {
                public void onFinished() {
                    CanoeDepartureView.this.m21451a("updateDepartureLocation onFinished");
                    CanoeDepartureView.this.f27181A.set(false);
                    if (CanoeDepartureView.this.m21529z()) {
                        LatLng center = CanoeDepartureView.this.f27213n.getCenter();
                        if (!(CanoeDepartureView.this.f27217r == null || CanoeDepartureView.this.f27217r.latLng == null || CanoeDepartureView.this.f27213n.getCircle() == null || !CanoeDepartureView.this.f27213n.getCircle().contains(CanoeDepartureView.this.f27217r.latLng))) {
                            center = CanoeDepartureView.this.f27217r.latLng;
                        }
                        CanoeDepartureView.this.m21480d(center);
                        departureLocationInfo.latLng = center;
                    } else {
                        departureLocationInfo.latLng = DepartureUtils.getMapCenterPoint(CanoeDepartureView.this.f27202c);
                    }
                    int i = 1;
                    if (CanoeDepartureView.this.f27198R && CanoeDepartureView.this.f27223x != null) {
                        LatLng latLng = departureLocationInfo.latLng;
                        FenceInfo fenceInfo = CanoeDepartureView.this.f27223x.startFenceInfo;
                        if (FenceUtils.isFenceMustAbsorb(fenceInfo)) {
                            if (!FenceUtils.positionIsInFence(CanoeDepartureView.this.f27202c, fenceInfo, latLng)) {
                                boolean unused = CanoeDepartureView.this.f27198R = false;
                            } else {
                                return;
                            }
                        }
                    } else if (CanoeDepartureView.this.m21466b(departureLocationInfo.latLng)) {
                        RpcPoi unused2 = CanoeDepartureView.this.f27218s = DepartureUtils.findTargetRecommend(departureLocationInfo.latLng, CanoeDepartureView.this.f27219t);
                        if (CanoeDepartureView.this.f27218s != null) {
                            CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                            canoeDepartureView.m21449a(canoeDepartureView.f27218s, (LatLng) null, true, true);
                            CanoeDepartureView canoeDepartureView2 = CanoeDepartureView.this;
                            CanoeDepartureView.this.m21462b(canoeDepartureView2.m21427a(canoeDepartureView2.f27218s));
                            return;
                        }
                    }
                    CanoeDepartureView canoeDepartureView3 = CanoeDepartureView.this;
                    DepartureLocationInfo departureLocationInfo = departureLocationInfo;
                    if (z) {
                        i = canoeDepartureView3.f27225z;
                    }
                    canoeDepartureView3.m21445a(departureLocationInfo, i);
                }
            };
            if (!z || !this.f27181A.get()) {
                this.f27181A.set(true);
                ZoneCircleController zoneCircleController = this.f27213n;
                if (zoneCircleController != null && !CollectionUtil.isEmpty((Collection<?>) zoneCircleController.getBestViewPoints())) {
                    m21451a("mZoneCircleCtr bestview");
                    BestViewer.doBestView(this.f27202c, true, (LatLng) null, this.f27213n.getBestViewPoints(), this.f27185E, (Padding) null, r7);
                } else if (this.f27211l != null) {
                    m21451a("mCarpoolController bestview");
                    BestViewer.doBestView(this.f27202c, true, (LatLng) null, this.f27211l.getBestViewPoints(departureLocationInfo.latLng), this.f27185E, (Padding) null, r7);
                } else {
                    float zoom = this.f27201b.getZoom();
                    m21451a("正常 BestView");
                    PinActionUtils.animateCamera(this.f27202c, departureLocationInfo.latLng, true, true, zoom, this.f27185E, r7);
                }
                DeparturePresenter departurePresenter = this.f27214o;
                if (departurePresenter != null) {
                    departurePresenter.stopRequest();
                }
            }
        }
    }

    /* renamed from: w */
    private Padding m21522w() {
        int i = this.f27187G;
        return new Padding(i, i, i, i);
    }

    /* renamed from: a */
    private boolean m21454a(LatLng latLng, LatLng latLng2) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        if (computeDistanceBetween < 30.0d) {
            return false;
        }
        m21451a("checkDistance : " + computeDistanceBetween);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m21525x() {
        if (this.f27201b.isPinVisible() && this.f27201b.isRequireByDrag()) {
            if (this.f27204e != null && !this.f27216q) {
                m21451a("onStartDragging");
                this.f27204e.onStartDragging();
            }
            int y = m21526y();
            IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback = this.f27204e;
            if (iDepartureComponentCallback != null) {
                iDepartureComponentCallback.onDragging(y);
            }
            m21431a(y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public int m21526y() {
        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f27202c);
        FenceController fenceController = this.f27207h;
        int isInFence = fenceController != null ? fenceController.isInFence(mapCenterPoint) : 2;
        ZoneCircleController zoneCircleController = this.f27213n;
        if (zoneCircleController == null || zoneCircleController.allowDragToOuter()) {
            return isInFence;
        }
        if (this.f27213n.handleMapDrag(mapCenterPoint)) {
            return 1;
        }
        return 2;
    }

    /* renamed from: a */
    private void m21431a(int i) {
        DepartureCompParams departureCompParams = this.f27201b;
        if (departureCompParams != null && this.f27206g != null) {
            if (!departureCompParams.isBubbleVisible()) {
                this.f27206g.startDragging_Ex();
            } else if (i == 1 || i == 3) {
                this.f27206g.toNoParking();
            } else {
                this.f27206g.startDragging();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m21529z() {
        ZoneCircleController zoneCircleController = this.f27213n;
        return zoneCircleController != null && !zoneCircleController.allowDragToOuter() && this.f27213n.isOutside();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21451a(String str) {
        DLog.m10773d("DepartureView", str, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21448a(DIDILocation dIDILocation) {
        if (this.f27205f && dIDILocation != null && this.f27217r != null) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                DLog.m10773d("departure", "onReceiveLocationUpdate error " + latLng.toString(), new Object[0]);
                return;
            }
            GuideLine guideLine = this.f27209j;
            if (guideLine != null) {
                guideLine.updateStartPosition(latLng);
            }
            this.f27212m.setLocationAccuracy(dIDILocation.getAccuracy());
            if (this.f27225z == 0 && this.f27213n == null && this.f27211l == null && this.f27182B) {
                DIDILocation dIDILocation2 = this.f27224y;
                if (dIDILocation2 == null) {
                    DLog.m10773d("departure", "onReceiveLocationUpdate 首次定位成功 " + latLng.toString(), new Object[0]);
                } else if (!m21454a(new LatLng(dIDILocation2.getLatitude(), this.f27224y.getLongitude()), latLng)) {
                    m21451a("onReceiveLocationUpdate : return");
                    return;
                }
                this.f27217r.latLng = latLng;
                this.f27224y = dIDILocation;
                if (CallFrom.CANOE_DEPARTURE_FROMHOME == this.f27201b.getReqCallerId()) {
                    m21445a(this.f27217r, this.f27225z);
                } else {
                    updateDepartureLocation(this.f27217r, true);
                }
            }
            DepartureInterceptController departureInterceptController = this.f27188H;
            if (departureInterceptController != null) {
                departureInterceptController.upDateCurrentLocation(dIDILocation);
            }
        }
    }

    /* renamed from: A */
    private void m21420A() {
        this.f27212m.reportOmegaOnShowTerminalWelcome(this.f27210k, DepartureUtils.getFenceInfo(this.f27223x), this.f27225z == 0);
    }

    public void stop() {
        m21474c();
        m21491g();
        m21497j();
        m21521v();
        CarpoolDepartureController carpoolDepartureController = this.f27211l;
        if (carpoolDepartureController != null) {
            carpoolDepartureController.removeCircle(false);
        }
    }

    public void destroy() {
        stop();
        m21498k();
        m21495i();
        GuideLine guideLine = this.f27209j;
        if (guideLine != null) {
            guideLine.destroy();
            this.f27209j = null;
        }
        Map map = this.f27202c;
        if (map != null) {
            map.stopAnimation();
        }
        DeparturePresenter departurePresenter = this.f27214o;
        if (departurePresenter != null) {
            departurePresenter.destroy();
            this.f27214o = null;
        }
        this.f27198R = false;
        DepartureOmegaUtils.hasDragged = false;
        DepartureOmegaUtils.OmegaParams.scrollType = -1;
        Handler handler = this.f27184D;
        if (handler != null) {
            handler.removeCallbacks(this.f27186F);
            this.f27184D.removeCallbacksAndMessages((Object) null);
            this.f27184D = null;
        }
        this.f27210k = null;
    }

    public void addOrderInterceptListener(final DepartureInterceptController.IInterceptListener iInterceptListener) {
        DepartureInterceptController departureInterceptController = this.f27188H;
        if (departureInterceptController != null) {
            departureInterceptController.addInterceptListener(new DepartureInterceptController.IInterceptListener() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z) {
                    String E = CanoeDepartureView.this.f27200a;
                    DLog.m10773d(E, "getInterceptStatus : onIntercept model=" + orderInterceptMode + ",newPoi=" + z, new Object[0]);
                    DepartureDataStore.getInstance().saveInterceptTime();
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onIntercept(orderInterceptMode, z);
                    }
                }

                public void onContinue() {
                    DLog.m10773d(CanoeDepartureView.this.f27200a, "getInterceptStatus : onContinue", new Object[0]);
                    DepartureInterceptController.IInterceptListener iInterceptListener = iInterceptListener;
                    if (iInterceptListener != null) {
                        iInterceptListener.onContinue();
                    }
                }

                public void onStart() {
                    DLog.m10773d(CanoeDepartureView.this.f27200a, "getInterceptStatus : onStart", new Object[0]);
                    CanoeDepartureView.this.f27217r.latLng = CanoeDepartureView.this.m21519u();
                    CanoeDepartureView canoeDepartureView = CanoeDepartureView.this;
                    canoeDepartureView.m21445a(canoeDepartureView.f27217r, CanoeDepartureView.this.f27225z);
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
        DepartureLocationInfo a = m21428a(departureLocationInfo);
        this.f27217r = a;
        FenceController fenceController = this.f27207h;
        if (fenceController != null && a != null && (map = this.f27202c) != null) {
            if (FenceUtils.positionIsInFence(map, fenceController.getFenceInfo(), this.f27217r.latLng)) {
                m21485e(this.f27217r.latLng);
            } else {
                m21445a(this.f27217r, this.f27225z);
            }
        }
    }
}
