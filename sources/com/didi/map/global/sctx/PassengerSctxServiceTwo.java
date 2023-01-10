package com.didi.map.global.sctx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.didi.common.map.MapVendor;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.traffic.TrafficData;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import com.didi.map.global.sctx.event_reveal.IMockTrafficEventGetter;
import com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter;
import com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource;
import com.didi.map.global.sctx.event_reveal.TrafficEventModel;
import com.didi.map.global.sctx.event_reveal.TrafficEventsController;
import com.didi.map.global.sctx.event_reveal.TrafficEventsDataSource;
import com.didi.map.global.sctx.event_reveal.TrafficEventsRepository;
import com.didi.map.global.sctx.event_verify.TrafficEventVerifyDataSource;
import com.didi.map.global.sctx.event_verify.TrafficEventVerifyRepository;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.OrderRouteEngineResPack;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.model.SctxDataCache;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.global.sctx.widget.CompLineDelegateN;
import com.didi.map.global.sctx.widget.TrafficLineAnimatorOptions;
import com.didi.map.global.sctx.widget.TrafficOptions;
import com.didi.map.google.config.Config;
import com.didi.map.google.manager.OmegaReportManager;
import com.didi.map.google.model.MockMovementInfo;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.google.util.BizUtil;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.google.util.DUtils;
import com.didi.map.google.util.EtaEdaChangeTracker;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.google.util.GoogleSyncTripOmegaUtil;
import com.didi.map.google.widget.ISctxViewDelegate;
import com.didi.map.google.widget.SctxViewImpl;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.CarIconsPreloader;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.car.MyLocation;
import com.didi.map.sdk.nav.car.onCarAnimationCancelListener;
import com.didi.map.sdk.nav.car.onCarAnimationListener;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.InertiaEngine;
import com.didi.map.sdk.nav.inertia.OnLocationMatched;
import com.didi.map.sdk.nav.inertia.SctxInertiaSuspiciousStatus;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.map.sdk.proto.driver_gl.SecRouteInfo;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import com.didi.map.utils.MatchPointDisHandler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Utils;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class PassengerSctxServiceTwo extends AbstractSctxService {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: q */
    private static final String f29972q = "PassengerSctxServiceTwo";

    /* renamed from: r */
    private static final int f29973r = 1;

    /* renamed from: s */
    private static final int f29974s = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public IInertiaDelegate f29975A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IMyLocationDelegate f29976B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public ArrayList<LatLng> f29977C;

    /* renamed from: D */
    private List<LatLng> f29978D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public RouteGuidanceGPSPoint f29979E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public MatchPointDisHandler f29980F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public TrafficEventsController f29981G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f29982H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f29983I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f29984J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f29985K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f29986L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f29987M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f29988N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f29989O;

    /* renamed from: P */
    private List<OdPoint> f29990P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public CompLineDelegateN f29991Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f29992R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f29993S;

    /* renamed from: T */
    private int f29994T;

    /* renamed from: U */
    private OrderRouteEngineResPack f29995U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f29996V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f29997W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f29998X = new ArrayList();

    /* renamed from: Y */
    private Handler f29999Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f30000Z;

    /* renamed from: aa */
    private List<LatLng> f30001aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f30002ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f30003ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f30004ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f30005ae;

    /* renamed from: af */
    private DIDILocationListener f30006af;

    /* renamed from: ag */
    private int f30007ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f30008ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f30009ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public CompLineDelegateN f30010aj;

    /* renamed from: ak */
    private SecRouteInfo f30011ak;

    /* renamed from: al */
    private int f30012al = 0;

    /* renamed from: am */
    private OnLineClickListener f30013am;

    /* renamed from: an */
    private boolean f30014an = true;

    /* renamed from: ao */
    private boolean f30015ao = true;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public float f30016ap = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f30017aq;

    /* renamed from: ar */
    private boolean f30018ar = false;

    /* renamed from: as */
    private long f30019as = -1;

    /* renamed from: at */
    private boolean f30020at = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ISctxViewDelegate f30021t;

    /* renamed from: u */
    private long f30022u;

    /* renamed from: v */
    private EtaEdaChangeTracker f30023v;

    /* renamed from: w */
    private int f30024w;

    /* renamed from: x */
    private int f30025x;

    /* renamed from: y */
    private long f30026y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f30027z;

    /* renamed from: N */
    private boolean m23309N() {
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ int m23341b(PassengerSctxServiceTwo passengerSctxServiceTwo, int i) {
        int i2 = passengerSctxServiceTwo.f29985K + i;
        passengerSctxServiceTwo.f29985K = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ long m23342b(PassengerSctxServiceTwo passengerSctxServiceTwo, long j) {
        long j2 = passengerSctxServiceTwo.f29984J + j;
        passengerSctxServiceTwo.f29984J = j2;
        return j2;
    }

    /* renamed from: f */
    static /* synthetic */ int m23361f(PassengerSctxServiceTwo passengerSctxServiceTwo, int i) {
        int i2 = passengerSctxServiceTwo.f29987M - i;
        passengerSctxServiceTwo.f29987M = i2;
        return i2;
    }

    /* renamed from: g */
    static /* synthetic */ int m23364g(PassengerSctxServiceTwo passengerSctxServiceTwo, int i) {
        int i2 = passengerSctxServiceTwo.f29988N - i;
        passengerSctxServiceTwo.f29988N = i2;
        return i2;
    }

    /* renamed from: t */
    static /* synthetic */ int m23394t(PassengerSctxServiceTwo passengerSctxServiceTwo) {
        int i = passengerSctxServiceTwo.f30027z;
        passengerSctxServiceTwo.f30027z = i + 1;
        return i;
    }

    public PassengerSctxServiceTwo(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m23363f();
        m23380m();
        m23320a();
        m23371i();
        m23373j();
        m23376k();
        m23378l();
        m23292E();
        m23366g();
        m23288C();
        if (this.f29902e.getTripState() == 3) {
            m23344b();
            m23360e();
            m23301J();
        }
        m23326a(this.f29902e.getPickupPoint(), this.f29902e.getEndPoint());
    }

    /* renamed from: a */
    private void m23320a() {
        this.f29907j.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceTwo.this.f29997W.reportSctxErrorCode(str, 1);
            }
        });
    }

    /* renamed from: b */
    private void m23344b() {
        this.f30006af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceTwo.this.f29899b);
                if (PassengerSctxServiceTwo.this.f30004ad != locationSwitchLevel) {
                    if (PassengerSctxServiceTwo.this.f30004ad != -2) {
                        PassengerSctxServiceTwo.this.f29997W.trackPhoneLocationType(PassengerSctxServiceTwo.this.f30004ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceTwo.this.f30004ad = locationSwitchLevel;
                }
                PassengerSctxServiceTwo.this.m23357d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceTwo.this.f30005ae == null) {
                    Set unused = PassengerSctxServiceTwo.this.f30005ae = new HashSet();
                }
                if (PassengerSctxServiceTwo.this.f30005ae.size() == 0) {
                    long unused2 = PassengerSctxServiceTwo.this.f30009ai = System.currentTimeMillis();
                }
                PassengerSctxServiceTwo.this.f30005ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f29899b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f30006af);
            instance.requestLocationUpdates(this.f30006af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m23352c() {
        if (this.f29898a != null && this.f30013am == null) {
            this.f30013am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceTwo.this.f29991Q != null && PassengerSctxServiceTwo.this.f30010aj != null) {
                        List<Line> lines = PassengerSctxServiceTwo.this.f29991Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceTwo.this.f30010aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceTwo.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceTwo.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f29898a.addOnLineClickListener(this.f30013am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m23357d() {
        Set<Integer> set = this.f30005ae;
        if (set != null && !set.isEmpty()) {
            this.f29997W.trackLocationErrorInfos(this.f30009ai, this.f30005ae);
            this.f30005ae.clear();
            this.f30009ai = 0;
        }
    }

    /* renamed from: e */
    private void m23360e() {
        this.f30008ah = new BroadcastReceiver() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r6, android.content.Intent r7) {
                /*
                    r5 = this;
                    java.lang.String r6 = r7.getAction()
                    int r7 = r6.hashCode()
                    r0 = -2128145023(0xffffffff81271581, float:-3.0688484E-38)
                    r1 = 0
                    r2 = -1
                    r3 = 2
                    r4 = 1
                    if (r7 == r0) goto L_0x0030
                    r0 = -1454123155(0xffffffffa953d76d, float:-4.7038264E-14)
                    if (r7 == r0) goto L_0x0026
                    r0 = 823795052(0x311a1d6c, float:2.2426674E-9)
                    if (r7 == r0) goto L_0x001c
                    goto L_0x003a
                L_0x001c:
                    java.lang.String r7 = "android.intent.action.USER_PRESENT"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 2
                    goto L_0x003b
                L_0x0026:
                    java.lang.String r7 = "android.intent.action.SCREEN_ON"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 0
                    goto L_0x003b
                L_0x0030:
                    java.lang.String r7 = "android.intent.action.SCREEN_OFF"
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x003a
                    r6 = 1
                    goto L_0x003b
                L_0x003a:
                    r6 = -1
                L_0x003b:
                    if (r6 == 0) goto L_0x0045
                    if (r6 == r4) goto L_0x0046
                    if (r6 == r3) goto L_0x0043
                    r1 = -1
                    goto L_0x0046
                L_0x0043:
                    r1 = 2
                    goto L_0x0046
                L_0x0045:
                    r1 = 1
                L_0x0046:
                    com.didi.map.global.sctx.PassengerSctxServiceTwo r6 = com.didi.map.global.sctx.PassengerSctxServiceTwo.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f29997W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceTwo.C106234.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f29899b.registerReceiver(this.f30008ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m23363f() {
        this.f30003ac = new SctxDataCache();
        this.f29995U = new OrderRouteEngineResPack();
        this.f30023v = new EtaEdaChangeTracker(m23404y());
        this.f29977C = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f29979E = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f29990P = new ArrayList();
        this.f30021t = new SctxViewImpl(this.f29899b, this.f29898a, this.f29976B);
        if (m23406z()) {
            this.f30018ar = true;
        }
    }

    /* renamed from: g */
    private void m23366g() {
        this.f29980F = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m23369h() {
        Context activityContext;
        if (this.f29901d != null && this.f29901d.enableTrafficEvent() && (activityContext = this.f29902e.getActivityContext()) != null) {
            new MockTrafficEventsDataSource(10000, new IMockTrafficEventGetter() {
                public List<LatLng> getRoutePoints() {
                    return PassengerSctxServiceTwo.this.f29977C;
                }
            });
            this.f29981G = new TrafficEventsController(activityContext, this.f29898a, new TrafficEventsRepository(new TrafficEventsDataSource(10000)), new TrafficEventVerifyRepository(new TrafficEventVerifyDataSource()), new ITrafficEventsReqParamGetter() {
                public EventShowReq getRequestBody() {
                    long j;
                    try {
                        j = Long.parseLong(PaxEnvironment.getInstance().getUid());
                    } catch (Exception unused) {
                        j = EventShowReq.DEFAULT_USERID.longValue();
                    }
                    return new EventShowReq.Builder().timestamp(Long.valueOf(System.currentTimeMillis() / 1000)).source(1).userId(Long.valueOf(j)).didiVersion(PaxEnvironment.getInstance().getAppVersion()).token(PaxEnvironment.getInstance().getToken()).lang(Locale.getDefault().getLanguage()).orderId(PassengerSctxServiceTwo.this.f29902e.getOrderId()).curRouteId(Long.valueOf(PassengerSctxServiceTwo.this.getRouteId())).build();
                }

                public String getEventsUrl() {
                    return PassengerSctxServiceTwo.this.f29905h.getTrafficEventsRequestUrl(PassengerSctxServiceTwo.this.f29899b);
                }

                public String getVerifyUrl() {
                    return PassengerSctxServiceTwo.this.f29905h.getTrafficEventVerifyUrl(PassengerSctxServiceTwo.this.f29899b);
                }

                public CarMarker getCarMarker() {
                    return PassengerSctxServiceTwo.this.getCarMarker();
                }

                public String getOrderId() {
                    return TextUtils.isEmpty(PassengerSctxServiceTwo.this.f29902e.getOrderId()) ? "" : PassengerSctxServiceTwo.this.f29902e.getOrderId();
                }

                public long getCurRouteId() {
                    return PassengerSctxServiceTwo.this.getRouteId();
                }
            }, this.f29901d);
        }
    }

    /* renamed from: i */
    private void m23371i() {
        InertiaEngine create = InertiaEngine.create(this.f29899b);
        this.f29975A = create;
        create.setPredictionApolloParams(this.f29905h.getSctxPredictionParams());
        this.f29975A.setSimulateEvaluateCallback(this.f29997W.getSimulateCallback());
        this.f29975A.setOrderInfo(this.f29902e.getOrderId(), this.f29902e.getTripState() == 3 ? this.f29902e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f29975A.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceTwo.this.f29979E = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceTwo.this.f29979E.shapeOffSet = i2;
                    PassengerSctxServiceTwo.this.f29979E.segmentIndex = i;
                }
                PassengerSctxServiceTwo.this.f29901d.onMatched(latLng);
                DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceTwo.this.m23382n();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceTwo.this.m23384o();
                    DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceTwo.this.f29986L + " / mShowDistance:" + PassengerSctxServiceTwo.this.f29988N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceTwo.m23341b(PassengerSctxServiceTwo.this, i3);
                    PassengerSctxServiceTwo.m23342b(PassengerSctxServiceTwo.this, (long) i4);
                    DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceTwo.this.f29985K + ", mACCMockTime:" + PassengerSctxServiceTwo.this.f29984J, new Object[0]);
                    if (PassengerSctxServiceTwo.this.f29986L <= 0 && PassengerSctxServiceTwo.this.f29988N <= 0) {
                        PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                        int unused2 = passengerSctxServiceTwo.f29986L = passengerSctxServiceTwo.f29982H;
                        PassengerSctxServiceTwo passengerSctxServiceTwo2 = PassengerSctxServiceTwo.this;
                        int unused3 = passengerSctxServiceTwo2.f29987M = passengerSctxServiceTwo2.f29982H * 60;
                        PassengerSctxServiceTwo passengerSctxServiceTwo3 = PassengerSctxServiceTwo.this;
                        int unused4 = passengerSctxServiceTwo3.f29988N = passengerSctxServiceTwo3.f29983I;
                    }
                    PassengerSctxServiceTwo.m23361f(PassengerSctxServiceTwo.this, i4);
                    PassengerSctxServiceTwo passengerSctxServiceTwo4 = PassengerSctxServiceTwo.this;
                    int unused5 = passengerSctxServiceTwo4.f29986L = passengerSctxServiceTwo4.f29987M / 60;
                    PassengerSctxServiceTwo.m23364g(PassengerSctxServiceTwo.this, i3);
                    DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceTwo.this.f29986L + "mShowEtaSeconds:" + PassengerSctxServiceTwo.this.f29987M + " / mShowDistance:" + PassengerSctxServiceTwo.this.f29988N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceTwo.this.f29982H + " / mDistance:" + PassengerSctxServiceTwo.this.f29983I, new Object[0]);
                }
                if (PassengerSctxServiceTwo.this.f30021t.getCarMarker() == null) {
                    PassengerSctxServiceTwo passengerSctxServiceTwo5 = PassengerSctxServiceTwo.this;
                    passengerSctxServiceTwo5.m23325a(latLng, passengerSctxServiceTwo5.f30016ap == -1.0f ? 0.0f : PassengerSctxServiceTwo.this.f30016ap);
                }
                if (!PassengerSctxServiceTwo.this.m23339a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceTwo.m23394t(PassengerSctxServiceTwo.this);
                        if (PassengerSctxServiceTwo.this.f30027z < 3) {
                            DLog.m10773d(PassengerSctxServiceTwo.f29972q, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceTwo.this.f30027z + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused6 = PassengerSctxServiceTwo.this.f30027z = 0;
                    }
                }
                PassengerSctxServiceTwo.this.f29976B.animateTo(new AnimateNode(latLng, i, i2, true));
                if (PassengerSctxServiceTwo.this.f29981G != null) {
                    PassengerSctxServiceTwo.this.f29981G.onMatched(latLng, z);
                }
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceTwo.this.m23339a(false)) {
                    DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceTwo.this.f29997W.onReceiveSctxState(PassengerSctxServiceTwo.this.f29902e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceTwo.this.f29901d != null) {
                        PassengerSctxServiceTwo.this.f29901d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceTwo.this.f29906i.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceTwo.this.f29906i.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceTwo.this.f29906i.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: j */
    private void m23373j() {
        IMyLocationDelegate create = MyLocation.create(this.f29898a);
        this.f29976B = create;
        create.setIsPassenger(true);
        this.f29976B.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceTwo.this.f30002ab = list2;
                PassengerSctxServiceTwo.this.m23335a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                passengerSctxServiceTwo.m23335a(list, (List<LatLng>) passengerSctxServiceTwo.f30002ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceTwo.this.f29992R || latLng == null || !latLng.equals(PassengerSctxServiceTwo.this.f29993S)) {
                    if (PassengerSctxServiceTwo.this.f29991Q != null && !PassengerSctxServiceTwo.this.f29989O) {
                        PassengerSctxServiceTwo.this.f29991Q.erase(i, latLng);
                        PassengerSctxServiceTwo.this.m23322a(i, latLng);
                    }
                    int unused = PassengerSctxServiceTwo.this.f29992R = i;
                    LatLng unused2 = PassengerSctxServiceTwo.this.f29993S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23322a(int i, LatLng latLng) {
        CompLineDelegateN compLineDelegateN;
        ArrayList<LatLng> arrayList = this.f29977C;
        List<LatLng> list = this.f29978D;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f30010aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f29992R;
            DLog.m10773d(f29972q, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
            if (i >= size2 && i2 < size2) {
                int i3 = i2;
                while (i2 < size2) {
                    if (i2 < arrayList.size()) {
                        if (DDSphericalUtil.computeDistanceBetween(arrayList.get(i2), list.get(i2)) <= 5.0d) {
                            i3 = i2;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
                m23323a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m23323a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f29994T > size2 - 3 && (compLineDelegateN = this.f30010aj) != null && compLineDelegateN != null) {
                m23330a(compLineDelegateN);
                if (this.f29901d != null) {
                    this.f29901d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m23323a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m10773d(f29972q, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f30010aj.erase(i, latLng);
            this.f29994T = i;
            DLog.m10773d(f29972q, "eraseSecLine, mSecLastEraseIndex: " + this.f29994T, new Object[0]);
        } else {
            DLog.m10773d(f29972q, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23335a(List<LatLng> list, List<LatLng> list2) {
        if (this.f30003ac.enableDrawLine) {
            this.f30001aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f30001aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: k */
    private void m23376k() {
        ISctxViewDelegate iSctxViewDelegate = this.f30021t;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f29976B);
            this.f30021t.set3DCarEnabled(this.f29902e.isIs3DEnabled());
            this.f30021t.set3DCarIcons(this.f29902e.getCar3DIcons());
            this.f30021t.setCarMarkerBitmap(this.f29902e.getCarBitmapDescriptor());
            this.f30021t.setCarMarkerZIndex(this.f29902e.getzIndex());
        }
    }

    /* renamed from: l */
    private void m23378l() {
        if (this.f29902e.getVamosExpansionParam() != null) {
            this.f30003ac.vamosDriverTripDestPoint = this.f29902e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f30003ac.orderPickupPoint = this.f29902e.getPickupPoint();
        this.f30003ac.orderDestPoint = this.f29902e.getEndPoint();
        this.f30022u = checkInterval(this.f29902e.getOraRequestInterval());
        m23386p();
        if (this.f29902e.isArrivedPickupPoint()) {
            m23330a(this.f29991Q);
            this.f30003ac.enableDrawLine = false;
        }
        if (this.f29902e.getWayPoints() != null) {
            setWayPoints(this.f29902e.getWayPoints(), this.f29902e.getWayPointsTimestamp());
        }
    }

    /* renamed from: m */
    private void m23380m() {
        this.f29997W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceTwo.this.m23400w();
            }

            public String getOrderId() {
                return PassengerSctxServiceTwo.this.f29902e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceTwo.this.f29902e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceTwo.this.f29902e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceTwo.this.m23401x();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceTwo.this.m23404y();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceTwo.this.f29996V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint h = PassengerSctxServiceTwo.this.f29979E;
                int i3 = -1;
                if (h == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceTwo.this.f29980F != null ? PassengerSctxServiceTwo.this.f29980F.distanceToTail(h) : -1;
                if (PassengerSctxServiceTwo.this.f29975A != null) {
                    i2 = PassengerSctxServiceTwo.this.f29975A.distanceLeft();
                    i = PassengerSctxServiceTwo.this.f29975A.distanceLeft(h);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceTwo.this.f29980F != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceTwo.this.f29975A != null) {
                    i3 = i2;
                }
                DLog.m10773d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + h.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceTwo.this.f29976B, PassengerSctxServiceTwo.this.f29975A);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceTwo.this.f29998X);
                PassengerSctxServiceTwo.this.f29998X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceTwo.this.f29902e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceTwo.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceTwo.this.f29902e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceTwo.this.m23350b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceTwo.this.f29977C;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceTwo.this.f29905h.getMaxMockDistance(PassengerSctxServiceTwo.this.f29975A.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceTwo.this.f29905h.getMaxMockTime(PassengerSctxServiceTwo.this.f29975A.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m23382n() {
        if (m23406z()) {
            this.f29997W.doOmegaOnCarDelayed(this.f29902e.getBizType(), m23401x(), this.f29905h.getSctxPredictionEnable(), this.f30003ac.lastReceiveRouteTime, this.f29976B, this.f29975A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m23384o() {
        DLog.m10773d(f29972q, "resetEtaEda", new Object[0]);
        this.f29985K = 0;
        this.f29984J = 0;
        int i = this.f29982H;
        this.f29986L = i;
        this.f29987M = i * 60;
        this.f29988N = this.f29983I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f30021t.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f30021t.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f30022u;
        if (checkInterval != j2) {
            DLog.m10773d(f29972q, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f30022u = checkInterval;
            m23386p();
            refreshSyncInterval();
        }
    }

    /* renamed from: p */
    private void m23386p() {
        IInertiaDelegate iInertiaDelegate = this.f29975A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f30022u);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f29976B;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f30022u);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f30022u;
    }

    /* renamed from: a */
    private void m23333a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m10773d(f29972q, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        this.f30016ap = mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue();
        if (!this.f29909l) {
            m23334a(mapPassengeOrderRouteRes, latLngListFromDiffGeoPoints);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (m23406z()) {
            long j = this.f30019as;
            if (j > 0 && currentTimeMillis - j >= 60000) {
                this.f30018ar = true;
                this.f30019as = currentTimeMillis;
                DLog.m10773d(f29972q, "mNeedTraffic: true", new Object[0]);
                return;
            }
        }
        if (this.f30019as == -1) {
            this.f30019as = currentTimeMillis;
        }
        this.f30018ar = false;
    }

    /* renamed from: a */
    private void m23334a(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list) {
        if (this.f30003ac.isExtendedAnimating) {
            DLog.m10773d(f29972q, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m23388q() || !this.f30003ac.isFirstRecvRoutes) {
            m23349b(mapPassengeOrderRouteRes, list);
        } else {
            this.f30003ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m23349b(mapPassengeOrderRouteRes, list);
                return;
            }
            if (this.f29977C.isEmpty()) {
                this.f29977C.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceTwo.this.f30003ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceTwo.this.f29901d != null) {
                        PassengerSctxServiceTwo.this.f29901d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    float f;
                    PassengerSctxServiceTwo.this.f30003ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceTwo.this.f29901d != null) {
                        PassengerSctxServiceTwo.this.f29901d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceTwo.this.m23349b(mapPassengeOrderRouteRes, (List<LatLng>) list)) {
                        PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                        LatLng latLng = (LatLng) list.get(0);
                        if (list.size() > 1) {
                            f = (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1));
                        } else {
                            f = mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue();
                        }
                        passengerSctxServiceTwo.m23325a(latLng, f);
                    }
                }
            };
            m23330a(this.f29991Q);
            this.f29991Q = new CompLineDelegateN();
            m23332a(this.f29991Q, list, mapPassengeOrderRouteRes.traffic, trafficLineAnimatorOptions, false, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23325a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f30021t) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f30021t.updateCarDirection(f);
        }
    }

    /* renamed from: b */
    private void m23346b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f29995U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f29989O = !this.f29995U.lineVisible;
        SctxDataCache sctxDataCache = this.f30003ac;
        if (!this.f29995U.lineVisible || this.f29902e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: q */
    private boolean m23388q() {
        return this.f30003ac.enableDrawLine && this.f29902e.isShowExtendedAnimation() && m23406z();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m23349b(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list) {
        CompLineDelegateN compLineDelegateN;
        CompLineDelegateN compLineDelegateN2;
        final MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        final List<LatLng> list2 = list;
        this.f30003ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m10773d(f29972q, "res.logId == null", new Object[0]);
        } else if (this.f30026y > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m10773d(f29972q, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f30026y), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f30026y = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f29901d != null) {
            if (this.f29902e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f29901d.onStartDestinationUpdate(list2.get(0), list2.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f29901d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f29901d.onWayPointsStateUpdate(false, this.f29990P);
                    this.f29901d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f29982H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m10773d(f29972q, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f29983I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m10773d(f29972q, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m10773d(f29972q, "res.driverPoint is error", new Object[0]);
            this.f29907j.setErrorCode(202);
            return false;
        }
        final LatLng latLng = new LatLng((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue());
        Object[] objArr = new Object[2];
        objArr[0] = GoogleSyncTripLogUtil.getLatLngLogInfo(latLng);
        objArr[1] = Integer.valueOf(mapPassengeOrderRouteRes2.direction == null ? 0 : mapPassengeOrderRouteRes2.direction.intValue());
        DLog.m10773d(f29972q, "server返回的司机定位:%s，方向:%d", objArr);
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(mapPassengeOrderRouteRes2.driverPoint, mapPassengeOrderRouteRes2.direction == null ? 0 : mapPassengeOrderRouteRes2.direction.intValue());
        this.f29996V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f29975A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f29989O) {
            m23330a(this.f29991Q);
            if (this.f30021t.getCarMarker() == null) {
                m23325a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        List<TrafficItem> list3 = mapPassengeOrderRouteRes2.traffic;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f29910m);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m10773d(f29972q, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f29910m && list.size() == this.f29977C.size() && m23312a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f29911n) {
                DLog.m10773d(f29972q, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                if (!CollectionUtil.isEmpty((Collection<?>) list3) && (compLineDelegateN2 = this.f29991Q) != null) {
                    compLineDelegateN2.updateTraffic(list3);
                    DLog.m10773d(f29972q, "traffic not null, refresh traffic", new Object[0]);
                }
                m23390r();
            } else {
                this.f30019as = -1;
                this.f30003ac.isRouteChanged = true;
                this.f29976B.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m10773d(PassengerSctxServiceTwo.f29972q, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes2.routeId == null) {
                            PassengerSctxServiceTwo.this.f29910m = 0;
                            PassengerSctxServiceTwo.this.f29911n = 0;
                        } else {
                            if (PassengerSctxServiceTwo.this.m23406z() && PassengerSctxServiceTwo.this.f29910m > 0 && PassengerSctxServiceTwo.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceTwo.this.getCarMarker().getPosition(), (LatLng) list2.get(0));
                                if (!(PassengerSctxServiceTwo.this.f29975A == null || PassengerSctxServiceTwo.this.f29975A.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceTwo.this.f29975A.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceTwo.this.m23400w(), PassengerSctxServiceTwo.this.f29902e.getOrderId(), PassengerSctxServiceTwo.this.f29902e.getTripState(), PassengerSctxServiceTwo.this.f29902e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceTwo.this.f29989O ? 1 : 0, PassengerSctxServiceTwo.this.getCarMarker().getPosition(), j, (LatLng) list2.get(0), mapPassengeOrderRouteRes2.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceTwo.this.f29902e.getBizType(), PassengerSctxServiceTwo.this.m23401x(), PassengerSctxServiceTwo.this.m23404y());
                            }
                            PassengerSctxServiceTwo.this.f29910m = mapPassengeOrderRouteRes2.routeId.longValue();
                            PassengerSctxServiceTwo passengerSctxServiceTwo = PassengerSctxServiceTwo.this;
                            passengerSctxServiceTwo.f29911n = passengerSctxServiceTwo.m23312a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex);
                        }
                        PassengerSctxServiceTwo.this.m23347b((List<LatLng>) list2, mapPassengeOrderRouteRes2.traffic);
                        PassengerSctxServiceTwo.this.f30003ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceTwo.this.f29898a.getContext(), list2);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceTwo.this.f29979E = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceTwo.this.f29979E.segmentIndex = -1;
                        PassengerSctxServiceTwo.this.f29976B.setNavRoutePoints(list2, false);
                        if (PassengerSctxServiceTwo.this.f29975A != null) {
                            if (PassengerSctxServiceTwo.this.f29911n > 0) {
                                PassengerSctxServiceTwo.this.f29975A.setRoutePoints(list2, PassengerSctxServiceTwo.this.f29911n, PassengerSctxServiceTwo.this.m23339a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceTwo.this.f29980F.setRoutePoints(list2, PassengerSctxServiceTwo.this.f29911n);
                                }
                            } else {
                                PassengerSctxServiceTwo.this.f29975A.setRoutePoints((List<LatLng>) list2, PassengerSctxServiceTwo.this.m23339a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceTwo.this.f29980F.setRoutePoints(list2);
                                }
                            }
                        }
                        PassengerSctxServiceTwo.this.m23390r();
                        if (PassengerSctxServiceTwo.this.f30021t.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceTwo.this.f29902e.isArrivedPickupPoint()) {
                            PassengerSctxServiceTwo passengerSctxServiceTwo2 = PassengerSctxServiceTwo.this;
                            LatLng latLng = (LatLng) list2.get(0);
                            if (list2.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list2.get(0), (LatLng) list2.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes2.direction != null) {
                                    i = mapPassengeOrderRouteRes2.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceTwo2.m23325a(latLng, f);
                            return;
                        }
                        DLog.m10773d(PassengerSctxServiceTwo.f29972q, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
                        PassengerSctxServiceTwo.this.m23325a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
                    }
                });
            }
            if (!this.f29902e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m23400w(), this.f29902e.getOrderId(), this.f29910m, this.f29902e.getTripState(), this.f29902e.isArrivedPickupPoint(), this.f29902e.getCountryId(), this.f29902e.getTripId(), this.f29908k, this.f29902e.getBizType(), m23401x(), m23404y());
            }
        } else {
            if (!CollectionUtil.isEmpty((Collection<?>) list3) && (compLineDelegateN = this.f29991Q) != null) {
                compLineDelegateN.updateTraffic(list3);
                DLog.m10773d(f29972q, "routes null, refresh traffic", new Object[0]);
            }
            m23390r();
            if (this.f30021t.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m23325a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m23312a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m23390r() {
        IInertiaDelegate iInertiaDelegate = this.f29975A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m23392s());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m23339a(boolean z) {
        if (!m23406z() || !TextUtils.isEmpty(this.f29902e.getTripId()) || this.f29902e.isReadOnly()) {
            if (z) {
                DLog.m10773d(f29972q, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f29905h.getSimulateMotionEnable();
        if (z) {
            DLog.m10773d(f29972q, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m10773d(f29972q, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: s */
    private boolean m23392s() {
        boolean a = m23339a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f29905h.getMaxMockDistance(this.f29975A.getMatchPointType());
        long maxMockTime = this.f29905h.getMaxMockTime(this.f29975A.getMatchPointType());
        boolean z = this.f29985K < maxMockDistance && this.f29984J < maxMockTime;
        DLog.m10773d(f29972q, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f29985K), Long.valueOf(this.f29984J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m23350b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m23350b(boolean z) {
        int allowEDA = this.f29905h.getAllowEDA();
        int allowETA = (int) ((this.f29905h.getAllowETA() / 1000) / 60);
        if (this.f29986L > 0 || this.f29988N > 0) {
            if (z) {
                DLog.m10773d(f29972q, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f29988N), Integer.valueOf(this.f29986L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f29988N <= allowEDA || this.f29986L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m10773d(f29972q, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f29983I), Integer.valueOf(this.f29982H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f29983I <= allowEDA || this.f29982H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23347b(List<LatLng> list, List<TrafficItem> list2) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (LatLng next : list) {
                stringBuffer.append(next.longitude + "," + next.latitude + ";");
            }
            DLog.m10773d("ccc", "新路线: " + stringBuffer.toString(), new Object[0]);
        }
        this.f29977C.clear();
        this.f29977C.addAll(list);
        m23384o();
        if (!this.f30003ac.enableDrawLine) {
            return;
        }
        if (!this.f30003ac.isDestModified || DDSphericalUtil.computeDistanceBetween(list.get(list.size() - 1), this.f29902e.getEndPoint()) <= 500.0d) {
            DLog.m10773d(f29972q, "updateNewLine - rebuild TrafficLine", new Object[0]);
            if (this.f29901d != null && !this.f30015ao) {
                this.f29901d.goingOffCourse();
            }
            this.f30015ao = false;
            this.f30011ak = null;
            this.f29978D = null;
            if (m23309N()) {
                this.f29994T = 0;
                CompLineDelegateN compLineDelegateN = this.f30010aj;
                if (compLineDelegateN != null) {
                    m23330a(compLineDelegateN);
                    this.f30010aj = null;
                    if (this.f29901d != null) {
                        this.f29901d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                    }
                }
            }
            m23330a(this.f29991Q);
            CompLineDelegateN compLineDelegateN2 = new CompLineDelegateN();
            this.f29991Q = compLineDelegateN2;
            m23332a(compLineDelegateN2, list, list2, (TrafficLineAnimatorOptions) null, false, false);
            m23331a(this.f29991Q, 1);
            DLog.m10773d(f29972q, "draw line", new Object[0]);
            if (this.f29981G != null) {
                DLog.m10773d("TrafficReveal", "draw new line then request event/show", new Object[0]);
                this.f29981G.forceRestart();
            }
            if (this.f30011ak != null && this.f29978D != null) {
                m23330a(this.f30010aj);
                this.f30010aj = new CompLineDelegateN();
                m23332a(this.f30010aj, this.f29978D, this.f30011ak.route.traffic, (TrafficLineAnimatorOptions) null, this.f30011ak.route.included.intValue() == 1, true);
                m23331a(this.f30010aj, 2);
                this.f30010aj.highLight(false);
                m23352c();
                if (this.f29901d != null) {
                    this.f29901d.showSecRouteInfoCallback(new SecRouteInfoEx(this.f30011ak), true);
                }
                DLog.m10773d(f29972q, "draw sec back line", new Object[0]);
                return;
            }
            return;
        }
        DLog.m10773d(f29972q, "updateNewLine - 修改了目的地，但是修改后的目的地与后台下发的路线终点距离相差大于%dm --> 不画线", 500);
    }

    /* renamed from: a */
    private void m23332a(CompLineDelegateN compLineDelegateN, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (compLineDelegateN != null) {
            compLineDelegateN.setTrafficOptions(m23315a(list, list2, z, z2));
            compLineDelegateN.addToMap(this.f29898a, trafficLineAnimatorOptions);
            this.f30020at = true;
        }
    }

    /* renamed from: a */
    private TrafficOptions m23315a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        int i;
        float f;
        TrafficOptions trafficOptions = new TrafficOptions();
        int lineWidth = this.f29902e.getLineWidth();
        if (lineWidth == 0) {
            int i2 = 6;
            if (z) {
                i2 = 7;
            }
            if (this.f29902e.isNewVersion()) {
                f = TypedValue.applyDimension(1, (float) i2, this.f29899b.getResources().getDisplayMetrics());
            } else {
                f = TypedValue.applyDimension(1, 5.0f, this.f29899b.getResources().getDisplayMetrics());
            }
            lineWidth = (int) f;
        }
        trafficOptions.lineWidth = lineWidth;
        trafficOptions.clickable = true;
        trafficOptions.trafficDatas = new ArrayList();
        int lineColor = this.f29902e.getLineColor();
        if (list2 == null || list2.size() <= 0 || z2) {
            if (lineColor == 0) {
                if (this.f29902e.isNewVersion()) {
                    lineColor = SctxViewImpl.NEW_LINE_COLOR;
                } else {
                    lineColor = SctxViewImpl.LINE_COLOR;
                }
            }
            trafficOptions.lineColor = lineColor;
            trafficOptions.lineMinorColor = DUtils.crColorBlend(0.1f, trafficOptions.lineColor, SctxViewImpl.MASK_COLOR);
        } else {
            if (lineColor == 0) {
                if (this.f29902e.isNewVersion()) {
                    lineColor = SctxViewImpl.NEW_LINE_COLOR;
                } else {
                    lineColor = SctxViewImpl.LINE_COLOR_HAS_TRAFFIC;
                }
            }
            trafficOptions.lineColor = lineColor;
            trafficOptions.lineMinorColor = DUtils.crColorBlend(0.1f, trafficOptions.lineColor, SctxViewImpl.MASK_COLOR);
            for (TrafficItem next : list2) {
                if (!(next.startIndex == null || next.endIndex == null)) {
                    TrafficData trafficData = new TrafficData();
                    trafficData.fromIndex = next.startIndex.intValue();
                    trafficData.toIndex = next.endIndex.intValue();
                    if (next.status == null) {
                        i = trafficOptions.lineColor;
                    } else {
                        i = Color.parseColor(String.format("#%06X", new Object[]{Integer.valueOf(next.status.intValue() & 16777215)}));
                    }
                    trafficData.color = i;
                    trafficData.minorColor = DUtils.crColorBlend(0.1f, trafficData.color, SctxViewImpl.MASK_COLOR);
                    trafficOptions.trafficDatas.add(trafficData);
                }
            }
        }
        trafficOptions.points = new ArrayList();
        if (list != null) {
            trafficOptions.points.addAll(list);
        }
        if (MapVendor.DIDI.equals(this.f29898a.getMapVendor())) {
            trafficOptions.drawLineType = 2;
        } else {
            trafficOptions.drawLineType = 1;
        }
        return trafficOptions;
    }

    public List<LatLng> getRoutePoints() {
        return this.f29977C;
    }

    public List<Line> getLines() {
        CompLineDelegateN compLineDelegateN = this.f29991Q;
        if (compLineDelegateN == null) {
            return null;
        }
        return compLineDelegateN.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f30001aa;
    }

    /* renamed from: t */
    private int m23393t() {
        if (!this.f29989O) {
            int i = m23406z() ? this.f29986L : this.f29982H;
            if (Math.abs(this.f30024w - i) >= 1) {
                m23321a(i, m23406z() ? this.f29988N : this.f29983I);
                this.f30024w = i;
            }
            return i;
        } else if (this.f29995U.mEta >= 0) {
            DLog.m10773d(f29972q, "bIsHideRoute, eta:" + this.f29995U.mEta, new Object[0]);
            return this.f29995U.mEta;
        } else {
            DLog.m10773d(f29972q, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: u */
    private int m23395u() {
        if (!this.f29989O) {
            int i = m23406z() ? this.f29988N : this.f29983I;
            if (Math.abs(this.f30025x - i) >= 100) {
                m23321a(m23406z() ? this.f29986L : this.f29982H, i);
                this.f30025x = i;
            }
            return i;
        } else if (this.f29995U.mDistance >= 0) {
            DLog.m10773d(f29972q, "bIsHideRoute, eda:" + this.f29995U.mDistance, new Object[0]);
            return this.f29995U.mDistance;
        } else {
            DLog.m10773d(f29972q, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: v */
    private LatLng m23397v() {
        DoublePoint location = DUtils.getLocation(this.f29899b);
        if (location != null) {
            return new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue());
        }
        return new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m23400w() {
        return this.f29903f != null ? this.f29903f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m23401x() {
        if (!TextUtils.isEmpty(this.f30003ac.userRole)) {
            return this.f30003ac.userRole;
        }
        if (this.f29903f != null) {
            this.f30003ac.userRole = this.f29903f.getUserRole();
        }
        return this.f30003ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public String m23404y() {
        if (this.f29903f != null) {
            return this.f29903f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m23406z() {
        return this.f29902e.getTripState() == 3 && !this.f29902e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m23283A() {
        return this.f29902e.getTripState() == 3 && this.f29902e.isArrivedPickupPoint();
    }

    /* renamed from: B */
    private boolean m23286B() {
        return this.f29902e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f29902e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f29902e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f29975A;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f29975A.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f29905h.getSctxPredictionEnable() || this.f29975A.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f29975A.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f29975A.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f30021t;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m10773d(f29972q, "updateDestination...", new Object[0]);
        m23326a(this.f29902e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f30003ac.orderDestPoint = latLng;
            if (this.f29902e.getTripState() == 4) {
                DLog.m10773d(f29972q, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f30003ac.isDestModified = true;
                m23330a(this.f29991Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m23326a(latLng, this.f29902e.getEndPoint());
        if (latLng != null) {
            this.f30012al = 1;
            this.f30003ac.orderPickupPoint = latLng;
            this.f29910m = 0;
            if (this.f29902e.getTripState() == 3) {
                DLog.m10773d(f29972q, "updateDestination - 接驾段，removeLine", new Object[0]);
                m23307M();
                m23300I();
                m23294F();
                m23292E();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m10773d(f29972q, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f30003ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f29990P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f29990P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f29902e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f30003ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f30003ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f30003ac.orderPickupPoint.longitude)).build());
        }
        if (this.f30003ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f30003ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f30003ac.orderDestPoint.longitude)).build());
        }
        if (this.f30003ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f30003ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f30003ac.vamosDriverTripDestPoint.longitude)).build()).build());
        }
        String str = "google";
        if (!(this.f29898a == null || this.f29898a.getMapVendor() == null)) {
            String mapVendor = this.f29898a.getMapVendor().toString();
            if (!TextUtils.isEmpty(mapVendor) && mapVendor.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
                str = "didi";
            }
        }
        String str2 = "0";
        PassengerOrderRouteReq.Builder curRouteId = builder.orderId(this.f29902e.getOrderId()).orderStage(Integer.valueOf(this.f29902e.getTripState())).bizType(Integer.valueOf(this.f29902e.getBizType())).travelMode(this.f29902e.getTravelMode()).isNeedTraj(false).version("5").token(this.f29902e.getToken()).phoneNum(TextUtils.isEmpty(this.f29900c) ? str2 : this.f29900c).driverId(Long.valueOf(this.f29902e.getDriverId())).curRouteId(Long.valueOf(this.f29910m));
        if (!TextUtils.isEmpty(this.f29902e.getImei())) {
            str2 = this.f29902e.getImei();
        }
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f29902e.getClientVersion()).lastOrderId(this.f29902e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f29902e.getBizType())).countryId(this.f29902e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f29902e.getTripId()).recPPState(Integer.valueOf(this.f30012al)).psgPoint(DUtils.getLocation(this.f29899b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f29902e.getBizGroup())).needTraffic(Boolean.valueOf(this.f30018ar));
        if (this.f29902e.getTripState() == 4) {
            if (this.f30003ac.lastGetWayPointTime <= 0) {
                DLog.m10773d(f29972q, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f30003ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f29990P);
                builder.odPointsTimestamp(Long.valueOf(this.f30003ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f29902e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m10773d(f29972q, "onSyncStart...", new Object[0]);
        if (this.f29901d != null) {
            this.f29901d.onSyncStart();
        }
        if (!this.f29902e.isReadOnly() && (omegaReportManager = this.f29997W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: C */
    private void m23288C() {
        if (this.f29902e.getTripState() == 3) {
            this.f29997W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f29899b), m23303K());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m10773d(f29972q, "onOraResponse...", new Object[0]);
        if (!this.f29908k) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f29901d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f29901d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f29997W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m23346b(mapPassengeOrderRouteRes);
                    if (m23336a(this.f29995U.serverStage) && this.f29901d != null) {
                        this.f29901d.onAbnormalOrderStageCallback(this.f29995U.serverStage);
                        this.f29907j.setErrorCode(203);
                    }
                    if (this.f29995U.serverStage == 5) {
                        this.f29907j.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f29908k) {
                        this.f30017aq = true;
                    }
                    m23333a(mapPassengeOrderRouteRes);
                    if (this.f29901d != null) {
                        this.f29901d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f29901d.onEtaEdaUpdate(new EtaEdaInfo(m23393t(), m23395u(), SXUtils.getLastOrderEda(this.f29902e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m10773d(f29972q, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f29901d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: D */
    private double m23289D() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m23336a(int r5) {
        /*
            r4 = this;
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f29902e
            int r0 = r0.getTripState()
            r1 = 0
            if (r5 <= 0) goto L_0x0025
            if (r0 <= 0) goto L_0x0025
            r2 = 3
            r3 = 1
            if (r0 != r2) goto L_0x001f
            com.didi.map.global.sctx.model.SctxTripParam r0 = r4.f29902e
            boolean r0 = r0.isArrivedPickupPoint()
            if (r0 == 0) goto L_0x001b
            r0 = 2
            if (r5 <= r0) goto L_0x0025
            goto L_0x001d
        L_0x001b:
            if (r5 <= r3) goto L_0x0025
        L_0x001d:
            r1 = 1
            goto L_0x0025
        L_0x001f:
            r2 = 4
            if (r0 != r2) goto L_0x0025
            if (r5 <= r2) goto L_0x0025
            goto L_0x001d
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceTwo.m23336a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m10773d(f29972q, "onOraFail err:%s", str);
        if (this.f29901d != null) {
            this.f29901d.onSyncFail(new Exception(str));
        }
    }

    public void unRegisterSctxCallback(SctxService.SctxCallback sctxCallback) {
        if (sctxCallback == this.f29901d) {
            this.f29901d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPreStart() {
        if (this.f30003ac.isSctxParamUpdated) {
            this.f30003ac.isSctxParamUpdated = false;
            m23296G();
            DLog.m10773d(f29972q, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
        if (m23286B()) {
            m23369h();
            TrafficEventsController trafficEventsController = this.f29981G;
            if (trafficEventsController != null) {
                trafficEventsController.start();
            }
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m10773d(f29972q, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f29902e)) {
            DLog.m10773d(f29972q, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f30003ac.orderId = this.f29902e.getOrderId();
        this.f30003ac.orderState = this.f29902e.getTripState();
        this.f30003ac.isWaitingState = this.f29902e.isArrivedPickupPoint();
        this.f30003ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m23292E();
        if (this.f29902e.getTripState() == 3) {
            m23344b();
            m23360e();
        }
        m23326a(this.f29902e.getPickupPoint(), this.f29902e.getEndPoint());
        start();
    }

    /* renamed from: E */
    private void m23292E() {
        this.f29998X.clear();
        this.f30000Z = null;
        Handler handler = this.f29999Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f29999Y = new Handler(Looper.getMainLooper());
        }
        if (this.f29902e != null && !this.f29902e.isArrivedPickupPoint() && this.f29902e.getTripState() == 3) {
            m23324a(1000);
        }
        DLog.m10773d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: F */
    private void m23294F() {
        this.f29998X.clear();
        this.f30000Z = null;
        Handler handler = this.f29999Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f29999Y = null;
        }
        DLog.m10773d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23324a(long j) {
        this.f29999Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceTwo.this.f29976B == null || PassengerSctxServiceTwo.this.getCarMarker() == null) {
                    PassengerSctxServiceTwo.this.m23324a(1000);
                    DLog.m10773d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceTwo.this.f29912o == 0) {
                    PassengerSctxServiceTwo.this.m23324a(1000);
                    DLog.m10773d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceTwo.this.f29912o < 5000) {
                    PassengerSctxServiceTwo.this.m23324a(1000);
                    DLog.m10773d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceTwo.this.f29908k) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceTwo.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceTwo.this.f29976B, PassengerSctxServiceTwo.this.f29980F);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceTwo.this.f29976B, PassengerSctxServiceTwo.this.f29975A);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceTwo.this.f30000Z != null && PassengerSctxServiceTwo.this.f30017aq) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceTwo.this.f30000Z);
                        }
                        if (PassengerSctxServiceTwo.this.f29906i.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceTwo.this.f29906i.getCode();
                            PassengerSctxServiceTwo.this.f29906i.clearJumpOverData();
                        }
                        PassengerSctxServiceTwo.this.f29998X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceTwo.this.f30000Z = position;
                        DLog.m10773d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m10773d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceTwo$12", 1950);
                        }
                    }
                    PassengerSctxServiceTwo.this.m23324a(1000);
                }
            }
        }, j);
    }

    /* renamed from: G */
    private void m23296G() {
        m23373j();
        m23371i();
        m23376k();
        m23378l();
        m23298H();
        m23366g();
    }

    /* renamed from: H */
    private void m23298H() {
        this.f29910m = 0;
        this.f29985K = 0;
        this.f29984J = 0;
        this.f30027z = 0;
        this.f30026y = 0;
        this.f30024w = 0;
        this.f30025x = 0;
        this.f30003ac.clear();
        this.f29997W.clear();
        ArrayList<LatLng> arrayList = this.f29977C;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m23321a(int i, int i2) {
        this.f30023v.record(i, i2, m23339a(false), this.f30003ac.isRouteChanged, m23397v(), this.f29902e.isArrivedPickupPoint());
    }

    /* renamed from: I */
    private void m23300I() {
        this.f30023v.doOmega(this.f29902e.getOrderId(), this.f29902e.getTripState(), this.f29902e.isArrivedPickupPoint(), this.f29902e.getCountryId(), m23397v());
        if (!this.f29902e.isReadOnly()) {
            this.f29997W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m23326a(LatLng latLng, LatLng latLng2) {
        if (this.f29902e != null && this.f29997W != null) {
            if (TextUtils.isEmpty(this.f29902e.getOrderId())) {
                this.f29997W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f29902e.getBizType()))) {
                this.f29997W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f29997W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f29997W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: J */
    private void m23301J() {
        int K = m23303K();
        boolean z = this.f29902e.getTripState() == 3;
        int i = this.f30007ag;
        if (i != K && z) {
            this.f29997W.trackAppLocationPermission(i, K);
        }
        this.f30007ag = K;
    }

    /* renamed from: K */
    private int m23303K() {
        int locationPermissionLevel = Utils.getLocationPermissionLevel(this.f29899b);
        if (locationPermissionLevel <= 0) {
            return 2;
        }
        if (locationPermissionLevel > 3 || Build.VERSION.SDK_INT <= 28) {
            return 0;
        }
        return 1;
    }

    public void enter() {
        super.enter();
    }

    public void resume() {
        TrafficEventsController trafficEventsController;
        super.resume();
        m23292E();
        m23301J();
        this.f30017aq = true;
        if (m23286B() && (trafficEventsController = this.f29981G) != null) {
            trafficEventsController.start();
        }
    }

    public void pause() {
        TrafficEventsController trafficEventsController;
        super.pause();
        m23294F();
        m23300I();
        this.f30017aq = false;
        if (m23286B() && (trafficEventsController = this.f29981G) != null) {
            trafficEventsController.pause();
        }
    }

    public void leave() {
        super.leave();
        m23306L();
        m23300I();
        this.f30012al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f30003ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m23357d();
        }
        IInertiaDelegate iInertiaDelegate = this.f29975A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f29975A = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f29976B;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            this.f29997W.reportSctxUIError(115, this.f29902e.getOrderId(), this.f29902e.getLastOrderId());
        }
        if (!this.f30020at) {
            this.f29997W.reportSctxUIError(116, this.f29902e.getOrderId(), this.f29902e.getLastOrderId());
        }
        IMyLocationDelegate iMyLocationDelegate2 = this.f29976B;
        if (iMyLocationDelegate2 != null) {
            iMyLocationDelegate2.destroy();
            this.f29976B = null;
        }
        TrafficEventsController trafficEventsController = this.f29981G;
        if (trafficEventsController != null) {
            trafficEventsController.leave();
            this.f29981G = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f30021t;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f30021t = null;
        }
        m23307M();
        this.f29994T = 0;
        m23294F();
        if (this.f30008ah != null) {
            try {
                this.f29899b.unregisterReceiver(this.f30008ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f30008ah = null;
        }
        if (this.f30006af != null) {
            DIDILocationManager.getInstance(this.f29899b).removeLocationUpdates(this.f30006af);
            this.f30006af = null;
        }
        if (this.f29898a != null && this.f30013am != null) {
            this.f29898a.removeOnLineClickListener(this.f30013am);
            this.f30013am = null;
        }
    }

    /* renamed from: L */
    private void m23306L() {
        if (getCarMarker() == null) {
            this.f29997W.reportSctxErrorCode("5", 1);
        }
        if ((m23406z() || this.f29902e.getTripState() == 4) && !this.f29989O && !hasLine()) {
            this.f29997W.reportSctxErrorCode("6", 1);
        }
    }

    public boolean hasLine() {
        CompLineDelegateN compLineDelegateN = this.f29991Q;
        return compLineDelegateN != null && !CollectionUtil.isEmpty((Collection<?>) compLineDelegateN.getLines());
    }

    /* renamed from: a */
    private void m23330a(CompLineDelegateN compLineDelegateN) {
        if (compLineDelegateN != null) {
            compLineDelegateN.remove();
        }
        TrafficEventsController trafficEventsController = this.f29981G;
        if (trafficEventsController != null) {
            trafficEventsController.removeTrafficEventMarkers();
        }
    }

    /* renamed from: M */
    private void m23307M() {
        m23330a(this.f30010aj);
        m23330a(this.f29991Q);
        this.f30010aj = null;
        this.f29991Q = null;
        this.f29994T = 0;
    }

    public void cancelPickupPointRecommend() {
        CompLineDelegateN compLineDelegateN = this.f29991Q;
        if (compLineDelegateN != null) {
            compLineDelegateN.highLight(true);
        }
        this.f30012al = 2;
        m23330a(this.f30010aj);
        this.f30010aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m10773d(f29972q, "chooseLine: " + i, new Object[0]);
        CompLineDelegateN compLineDelegateN = this.f29991Q;
        if (compLineDelegateN != null && this.f30010aj != null) {
            if (i == 1) {
                compLineDelegateN.highLight(true);
                m23331a(this.f29991Q, 1);
                this.f30010aj.highLight(false);
                m23331a(this.f30010aj, 2);
                if (this.f29901d != null) {
                    this.f29901d.selectedPickupPoint(this.f29902e.getPickupPoint());
                }
            } else if (i == 2) {
                compLineDelegateN.highLight(false);
                m23331a(this.f29991Q, 1);
                this.f30010aj.highLight(true);
                m23331a(this.f30010aj, 2);
                SecRouteInfo secRouteInfo = this.f30011ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f30011ak.point;
                    if (this.f29901d != null) {
                        this.f29901d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m23331a(CompLineDelegateN compLineDelegateN, int i) {
        if (compLineDelegateN != null) {
            List<Line> lines = compLineDelegateN.getLines();
            if (!CollectionUtil.isEmpty((Collection<?>) lines)) {
                for (Line zIndex : lines) {
                    zIndex.setZIndex(i);
                }
            }
        }
    }

    public void showRecommendPickupPoint(boolean z) {
        this.f30014an = z;
    }

    public void handleTriggerEventDialog(TrafficEventModel trafficEventModel, int i) {
        TrafficEventsController trafficEventsController = this.f29981G;
        if (trafficEventsController != null) {
            trafficEventsController.handleTriggerVerifyDialogClick(trafficEventModel, i);
        }
    }
}
