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
import com.didi.map.global.sctx.widget.TrafficLineDelegate;
import com.didi.map.global.sctx.work.core.WorkManager;
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
import com.didi.map.sdk.nav.traffic.TrafficData;
import com.didi.map.sdk.nav.traffic.TrafficOptions;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
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

public class PassengerSctxServiceImp extends AbstractSctxService {
    public static final int RecPPState_Cancel = 2;
    public static final int RecPPState_Use = 1;

    /* renamed from: q */
    private static final String f29917q = "PassengerSctxService";

    /* renamed from: r */
    private static final int f29918r = 1;

    /* renamed from: s */
    private static final int f29919s = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public IInertiaDelegate f29920A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IMyLocationDelegate f29921B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public ArrayList<LatLng> f29922C;

    /* renamed from: D */
    private List<LatLng> f29923D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public RouteGuidanceGPSPoint f29924E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public MatchPointDisHandler f29925F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public TrafficEventsController f29926G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f29927H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f29928I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f29929J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public int f29930K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f29931L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f29932M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f29933N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public boolean f29934O;

    /* renamed from: P */
    private List<OdPoint> f29935P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public TrafficLineDelegate f29936Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public int f29937R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public LatLng f29938S;

    /* renamed from: T */
    private int f29939T;

    /* renamed from: U */
    private OrderRouteEngineResPack f29940U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public RouteGuidanceGPSPoint f29941V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public OmegaReportManager f29942W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public List<MockMovementInfo.SctxAnimData> f29943X = new ArrayList();

    /* renamed from: Y */
    private Handler f29944Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public LatLng f29945Z;

    /* renamed from: aa */
    private List<LatLng> f29946aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public List<LatLng> f29947ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public SctxDataCache f29948ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f29949ad = -2;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public Set<Integer> f29950ae;

    /* renamed from: af */
    private DIDILocationListener f29951af;

    /* renamed from: ag */
    private int f29952ag = -1;

    /* renamed from: ah */
    private BroadcastReceiver f29953ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public long f29954ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public TrafficLineDelegate f29955aj;

    /* renamed from: ak */
    private SecRouteInfo f29956ak;

    /* renamed from: al */
    private int f29957al = 0;

    /* renamed from: am */
    private OnLineClickListener f29958am;

    /* renamed from: an */
    private boolean f29959an = true;

    /* renamed from: ao */
    private boolean f29960ao = true;

    /* renamed from: ap */
    private WorkManager f29961ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public float f29962aq = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f29963ar;

    /* renamed from: as */
    private boolean f29964as = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ISctxViewDelegate f29965t;

    /* renamed from: u */
    private long f29966u;

    /* renamed from: v */
    private EtaEdaChangeTracker f29967v;

    /* renamed from: w */
    private int f29968w;

    /* renamed from: x */
    private int f29969x;

    /* renamed from: y */
    private long f29970y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f29971z;

    /* renamed from: N */
    private boolean m23183N() {
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ int m23216b(PassengerSctxServiceImp passengerSctxServiceImp, int i) {
        int i2 = passengerSctxServiceImp.f29930K + i;
        passengerSctxServiceImp.f29930K = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ long m23217b(PassengerSctxServiceImp passengerSctxServiceImp, long j) {
        long j2 = passengerSctxServiceImp.f29929J + j;
        passengerSctxServiceImp.f29929J = j2;
        return j2;
    }

    /* renamed from: f */
    static /* synthetic */ int m23237f(PassengerSctxServiceImp passengerSctxServiceImp, int i) {
        int i2 = passengerSctxServiceImp.f29932M - i;
        passengerSctxServiceImp.f29932M = i2;
        return i2;
    }

    /* renamed from: g */
    static /* synthetic */ int m23240g(PassengerSctxServiceImp passengerSctxServiceImp, int i) {
        int i2 = passengerSctxServiceImp.f29933N - i;
        passengerSctxServiceImp.f29933N = i2;
        return i2;
    }

    /* renamed from: t */
    static /* synthetic */ int m23270t(PassengerSctxServiceImp passengerSctxServiceImp) {
        int i = passengerSctxServiceImp.f29971z;
        passengerSctxServiceImp.f29971z = i + 1;
        return i;
    }

    public PassengerSctxServiceImp(SctxTripParam sctxTripParam) {
        super(sctxTripParam);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        m23239f();
        m23256m();
        m23195a();
        m23247i();
        m23249j();
        m23252k();
        m23254l();
        m23166E();
        m23242g();
        m23162C();
        if (this.f29902e.getTripState() == 3) {
            m23220b();
            m23236e();
            m23175J();
        }
        m23201a(this.f29902e.getPickupPoint(), this.f29902e.getEndPoint());
    }

    /* renamed from: a */
    private void m23195a() {
        this.f29907j.setReportCallback(new RuntimeErrorCollect.ReportCallback() {
            public void reportError(String str) {
                PassengerSctxServiceImp.this.f29942W.reportSctxErrorCode(str, 0);
            }
        });
    }

    /* renamed from: b */
    private void m23220b() {
        this.f29951af = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locationSwitchLevel = Utils.getLocationSwitchLevel(PassengerSctxServiceImp.this.f29899b);
                if (PassengerSctxServiceImp.this.f29949ad != locationSwitchLevel) {
                    if (PassengerSctxServiceImp.this.f29949ad != -2) {
                        PassengerSctxServiceImp.this.f29942W.trackPhoneLocationType(PassengerSctxServiceImp.this.f29949ad, locationSwitchLevel);
                    }
                    int unused = PassengerSctxServiceImp.this.f29949ad = locationSwitchLevel;
                }
                PassengerSctxServiceImp.this.m23232d();
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (PassengerSctxServiceImp.this.f29950ae == null) {
                    Set unused = PassengerSctxServiceImp.this.f29950ae = new HashSet();
                }
                if (PassengerSctxServiceImp.this.f29950ae.size() == 0) {
                    long unused2 = PassengerSctxServiceImp.this.f29954ai = System.currentTimeMillis();
                }
                PassengerSctxServiceImp.this.f29950ae.add(Integer.valueOf(errInfo.getErrNo()));
            }
        };
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f29899b);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("PassengerSctx");
            defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this.f29951af);
            instance.requestLocationUpdates(this.f29951af, defaultLocationUpdateOption);
        }
    }

    /* renamed from: c */
    private void m23226c() {
        if (this.f29898a != null && this.f29958am == null) {
            this.f29958am = new OnLineClickListener() {
                public void onLineClick(Line line) {
                    if (PassengerSctxServiceImp.this.f29936Q != null && PassengerSctxServiceImp.this.f29955aj != null) {
                        List<Line> lines = PassengerSctxServiceImp.this.f29936Q.getLines();
                        List<Line> lines2 = PassengerSctxServiceImp.this.f29955aj.getLines();
                        if (!CollectionUtil.isEmpty((Collection<?>) lines) && !CollectionUtil.isEmpty((Collection<?>) lines2)) {
                            if (lines.contains(line)) {
                                PassengerSctxServiceImp.this.chooseLine(1);
                            } else if (lines2.contains(line)) {
                                PassengerSctxServiceImp.this.chooseLine(2);
                            }
                        }
                    }
                }
            };
            this.f29898a.addOnLineClickListener(this.f29958am);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m23232d() {
        Set<Integer> set = this.f29950ae;
        if (set != null && !set.isEmpty()) {
            this.f29942W.trackLocationErrorInfos(this.f29954ai, this.f29950ae);
            this.f29950ae.clear();
            this.f29954ai = 0;
        }
    }

    /* renamed from: e */
    private void m23236e() {
        this.f29953ah = new BroadcastReceiver() {
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
                    com.didi.map.global.sctx.PassengerSctxServiceImp r6 = com.didi.map.global.sctx.PassengerSctxServiceImp.this
                    com.didi.map.google.manager.OmegaReportManager r6 = r6.f29942W
                    r6.trackScreenState(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.C106114.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            this.f29899b.registerReceiver(this.f29953ah, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m23239f() {
        this.f29948ac = new SctxDataCache();
        this.f29940U = new OrderRouteEngineResPack();
        this.f29967v = new EtaEdaChangeTracker(m23280y());
        this.f29922C = new ArrayList<>();
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f29924E = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        this.f29935P = new ArrayList();
        this.f29965t = new SctxViewImpl(this.f29899b, this.f29898a, this.f29921B);
    }

    /* renamed from: g */
    private void m23242g() {
        this.f29925F = new MatchPointDisHandler();
    }

    /* renamed from: h */
    private void m23245h() {
        Context activityContext;
        if (this.f29901d != null && this.f29901d.enableTrafficEvent() && (activityContext = this.f29902e.getActivityContext()) != null) {
            new MockTrafficEventsDataSource(10000, new IMockTrafficEventGetter() {
                public List<LatLng> getRoutePoints() {
                    return PassengerSctxServiceImp.this.f29922C;
                }
            });
            this.f29926G = new TrafficEventsController(activityContext, this.f29898a, new TrafficEventsRepository(new TrafficEventsDataSource(10000)), new TrafficEventVerifyRepository(new TrafficEventVerifyDataSource()), new ITrafficEventsReqParamGetter() {
                public EventShowReq getRequestBody() {
                    long j;
                    try {
                        j = Long.parseLong(PaxEnvironment.getInstance().getUid());
                    } catch (Exception unused) {
                        j = EventShowReq.DEFAULT_USERID.longValue();
                    }
                    return new EventShowReq.Builder().timestamp(Long.valueOf(System.currentTimeMillis() / 1000)).source(1).userId(Long.valueOf(j)).didiVersion(PaxEnvironment.getInstance().getAppVersion()).token(PaxEnvironment.getInstance().getToken()).lang(Locale.getDefault().getLanguage()).orderId(PassengerSctxServiceImp.this.f29902e.getOrderId()).curRouteId(Long.valueOf(PassengerSctxServiceImp.this.getRouteId())).build();
                }

                public String getEventsUrl() {
                    return PassengerSctxServiceImp.this.f29905h.getTrafficEventsRequestUrl(PassengerSctxServiceImp.this.f29899b);
                }

                public String getVerifyUrl() {
                    return PassengerSctxServiceImp.this.f29905h.getTrafficEventVerifyUrl(PassengerSctxServiceImp.this.f29899b);
                }

                public CarMarker getCarMarker() {
                    return PassengerSctxServiceImp.this.getCarMarker();
                }

                public String getOrderId() {
                    return TextUtils.isEmpty(PassengerSctxServiceImp.this.f29902e.getOrderId()) ? "" : PassengerSctxServiceImp.this.f29902e.getOrderId();
                }

                public long getCurRouteId() {
                    return PassengerSctxServiceImp.this.getRouteId();
                }
            }, this.f29901d);
        }
    }

    /* renamed from: i */
    private void m23247i() {
        InertiaEngine create = InertiaEngine.create(this.f29899b);
        this.f29920A = create;
        create.setPredictionApolloParams(this.f29905h.getSctxPredictionParams());
        this.f29920A.setSimulateEvaluateCallback(this.f29942W.getSimulateCallback());
        this.f29920A.setOrderInfo(this.f29902e.getOrderId(), this.f29902e.getTripState() == 3 ? this.f29902e.isArrivedPickupPoint() ? 1 : 0 : 2);
        this.f29920A.setOnLocationMatched(new OnLocationMatched() {
            public void onOffRoute() {
            }

            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
                if (i >= 0 && !z) {
                    RouteGuidanceGPSPoint unused = PassengerSctxServiceImp.this.f29924E = ConvertUtil.tran2RouteGuidanceGPSPointWithLatLng(latLng, 0);
                    PassengerSctxServiceImp.this.f29924E.shapeOffSet = i2;
                    PassengerSctxServiceImp.this.f29924E.segmentIndex = i;
                }
                PassengerSctxServiceImp.this.f29901d.onMatched(latLng);
                DLog.m10773d(PassengerSctxServiceImp.f29917q, "onMatched - point:" + latLng.toString() + ", segmentIndex:" + i + ", shapeOffset:" + i2 + ", distanceOffset:" + i3 + ", timeoffsett:" + i4 + ", isSimulate:" + z, new Object[0]);
                PassengerSctxServiceImp.this.m23258n();
                CarIconsPreloader.getInstance().preloadCarIcons(i);
                if (!z) {
                    PassengerSctxServiceImp.this.m23260o();
                    DLog.m10773d(PassengerSctxServiceImp.f29917q, "onMatched - 非惯导, mShowEta:" + PassengerSctxServiceImp.this.f29931L + " / mShowDistance:" + PassengerSctxServiceImp.this.f29933N + "显示的均为后台下发值", new Object[0]);
                } else {
                    PassengerSctxServiceImp.m23216b(PassengerSctxServiceImp.this, i3);
                    PassengerSctxServiceImp.m23217b(PassengerSctxServiceImp.this, (long) i4);
                    DLog.m10773d(PassengerSctxServiceImp.f29917q, "onMatched - 惯导累积, mACCMockDistance:" + PassengerSctxServiceImp.this.f29930K + ", mACCMockTime:" + PassengerSctxServiceImp.this.f29929J, new Object[0]);
                    if (PassengerSctxServiceImp.this.f29931L <= 0 && PassengerSctxServiceImp.this.f29933N <= 0) {
                        PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                        int unused2 = passengerSctxServiceImp.f29931L = passengerSctxServiceImp.f29927H;
                        PassengerSctxServiceImp passengerSctxServiceImp2 = PassengerSctxServiceImp.this;
                        int unused3 = passengerSctxServiceImp2.f29932M = passengerSctxServiceImp2.f29927H * 60;
                        PassengerSctxServiceImp passengerSctxServiceImp3 = PassengerSctxServiceImp.this;
                        int unused4 = passengerSctxServiceImp3.f29933N = passengerSctxServiceImp3.f29928I;
                    }
                    PassengerSctxServiceImp.m23237f(PassengerSctxServiceImp.this, i4);
                    PassengerSctxServiceImp passengerSctxServiceImp4 = PassengerSctxServiceImp.this;
                    int unused5 = passengerSctxServiceImp4.f29931L = passengerSctxServiceImp4.f29932M / 60;
                    PassengerSctxServiceImp.m23240g(PassengerSctxServiceImp.this, i3);
                    DLog.m10773d(PassengerSctxServiceImp.f29917q, "onMatched - 惯导, mShowEta:" + PassengerSctxServiceImp.this.f29931L + "mShowEtaSeconds:" + PassengerSctxServiceImp.this.f29932M + " / mShowDistance:" + PassengerSctxServiceImp.this.f29933N + "显示的与后台下发值不一定一样: mEta:" + PassengerSctxServiceImp.this.f29927H + " / mDistance:" + PassengerSctxServiceImp.this.f29928I, new Object[0]);
                }
                if (PassengerSctxServiceImp.this.f29965t.getCarMarker() == null) {
                    PassengerSctxServiceImp passengerSctxServiceImp5 = PassengerSctxServiceImp.this;
                    passengerSctxServiceImp5.m23200a(latLng, passengerSctxServiceImp5.f29962aq == -1.0f ? 0.0f : PassengerSctxServiceImp.this.f29962aq);
                }
                if (!PassengerSctxServiceImp.this.m23214a(false)) {
                    if (i < 0) {
                        PassengerSctxServiceImp.m23270t(PassengerSctxServiceImp.this);
                        if (PassengerSctxServiceImp.this.f29971z < 3) {
                            DLog.m10773d(PassengerSctxServiceImp.f29917q, "[不满足惯导条件(sctx2.0效果)] 当前连续绑线失败次数:" + PassengerSctxServiceImp.this.f29971z + ",不足" + 3 + "次，不做动画", new Object[0]);
                            return;
                        }
                    } else {
                        int unused6 = PassengerSctxServiceImp.this.f29971z = 0;
                    }
                }
                PassengerSctxServiceImp.this.f29921B.animateTo(new AnimateNode(latLng, i, i2, true));
                if (PassengerSctxServiceImp.this.f29926G != null) {
                    PassengerSctxServiceImp.this.f29926G.onMatched(latLng, z);
                }
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (sctxStateInfo != null && sctxStateInfo.getState() != null && PassengerSctxServiceImp.this.m23214a(false)) {
                    DLog.m10773d(PassengerSctxServiceImp.f29917q, "onUpdateSctxState:" + sctxStateInfo.getState().type, new Object[0]);
                    PassengerSctxServiceImp.this.f29942W.onReceiveSctxState(PassengerSctxServiceImp.this.f29902e.getOrderId(), sctxStateInfo);
                    if (PassengerSctxServiceImp.this.f29901d != null) {
                        PassengerSctxServiceImp.this.f29901d.onSctxStateUpdate(sctxStateInfo);
                    }
                }
            }

            public void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
                if (!PassengerSctxServiceImp.this.f29906i.isEnable()) {
                    return;
                }
                if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR) {
                    PassengerSctxServiceImp.this.f29906i.recordJumpCode(SctxCaseCode.INERTIA_DRIVER_TOO_FAR);
                } else if (sctxInertiaSuspiciousStatus == SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL) {
                    PassengerSctxServiceImp.this.f29906i.recordJumpCode(SctxCaseCode.INERTIA_MATCH_FAIL);
                }
            }
        });
    }

    /* renamed from: j */
    private void m23249j() {
        IMyLocationDelegate create = MyLocation.create(this.f29898a);
        this.f29921B = create;
        create.setIsPassenger(true);
        this.f29921B.setCarAnimationListener(new onCarAnimationListener() {
            public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                List unused = PassengerSctxServiceImp.this.f29947ab = list2;
                PassengerSctxServiceImp.this.m23210a(list, list2);
            }

            public void onErase(List<LatLng> list) {
                PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                passengerSctxServiceImp.m23210a(list, (List<LatLng>) passengerSctxServiceImp.f29947ab);
            }

            public void onErase(int i, int i2, LatLng latLng) {
                if (i != PassengerSctxServiceImp.this.f29937R || latLng == null || !latLng.equals(PassengerSctxServiceImp.this.f29938S)) {
                    if (PassengerSctxServiceImp.this.f29936Q != null && !PassengerSctxServiceImp.this.f29934O) {
                        PassengerSctxServiceImp.this.f29936Q.erase(i, latLng);
                        PassengerSctxServiceImp.this.m23197a(i, latLng);
                    }
                    int unused = PassengerSctxServiceImp.this.f29937R = i;
                    LatLng unused2 = PassengerSctxServiceImp.this.f29938S = latLng;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23197a(int i, LatLng latLng) {
        TrafficLineDelegate trafficLineDelegate;
        ArrayList<LatLng> arrayList = this.f29922C;
        List<LatLng> list = this.f29923D;
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !CollectionUtil.isEmpty((Collection<?>) list) && this.f29955aj != null) {
            int size = arrayList.size();
            int size2 = list.size();
            int i2 = this.f29937R;
            DLog.m10773d(f29917q, "sec points size :" + size2 + "cur points size: " + size + "lastEraseIndex: " + i2 + "segmentIndex: " + i, new Object[0]);
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
                m23198a(i3, list.get(i3), (List<LatLng>) arrayList, list);
            } else if (arrayList.size() > i && size2 > i) {
                int i4 = size2 - 1;
                if (i == i4) {
                    latLng = list.get(i4);
                }
                m23198a(i, latLng, (List<LatLng>) arrayList, list);
            }
            if (this.f29939T > size2 - 3 && (trafficLineDelegate = this.f29955aj) != null && trafficLineDelegate != null) {
                trafficLineDelegate.remove();
                this.f29955aj = null;
                if (this.f29901d != null) {
                    this.f29901d.showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m23198a(int i, LatLng latLng, List<LatLng> list, List<LatLng> list2) {
        if (DDSphericalUtil.computeDistanceBetween(list.get(i), list2.get(i)) > 5.0d) {
            DLog.m10773d(f29917q, "not eraseSecLine, distance > 5m", new Object[0]);
        } else if (list2.size() > i) {
            this.f29955aj.erase(i, latLng);
            this.f29939T = i;
            DLog.m10773d(f29917q, "eraseSecLine, mSecLastEraseIndex: " + this.f29939T, new Object[0]);
        } else {
            DLog.m10773d(f29917q, "not eraseSecLine, distance < 5m...", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23210a(List<LatLng> list, List<LatLng> list2) {
        if (this.f29948ac.enableDrawLine) {
            this.f29946aa = new ArrayList(list);
            if (list2 != null && list2.size() > 1) {
                this.f29946aa.addAll(list2.subList(1, list2.size()));
            }
        }
    }

    /* renamed from: k */
    private void m23252k() {
        ISctxViewDelegate iSctxViewDelegate = this.f29965t;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.setLocationDelegate(this.f29921B);
            this.f29965t.set3DCarEnabled(this.f29902e.isIs3DEnabled());
            this.f29965t.set3DCarIcons(this.f29902e.getCar3DIcons());
            this.f29965t.setCarMarkerBitmap(this.f29902e.getCarBitmapDescriptor());
            this.f29965t.setCarMarkerZIndex(this.f29902e.getzIndex());
        }
    }

    /* renamed from: l */
    private void m23254l() {
        if (this.f29902e.getVamosExpansionParam() != null) {
            this.f29948ac.vamosDriverTripDestPoint = this.f29902e.getVamosExpansionParam().driverTripDestPoint;
        }
        this.f29948ac.orderPickupPoint = this.f29902e.getPickupPoint();
        this.f29948ac.orderDestPoint = this.f29902e.getEndPoint();
        this.f29966u = checkInterval(this.f29902e.getOraRequestInterval());
        m23262p();
        if (this.f29902e.isArrivedPickupPoint()) {
            m23205a(this.f29936Q);
            this.f29948ac.enableDrawLine = false;
        }
        if (this.f29902e.getWayPoints() != null) {
            setWayPoints(this.f29902e.getWayPoints(), this.f29902e.getWayPointsTimestamp());
        }
    }

    /* renamed from: m */
    private void m23256m() {
        this.f29942W = new OmegaReportManager(new OmegaReportManager.SctxReportGetter() {
            public String getUid() {
                return PassengerSctxServiceImp.this.m23276w();
            }

            public String getOrderId() {
                return PassengerSctxServiceImp.this.f29902e.getOrderId();
            }

            public int getOrderState() {
                return PassengerSctxServiceImp.this.f29902e.getTripState();
            }

            public int getProductId() {
                return PassengerSctxServiceImp.this.f29902e.getBizType();
            }

            public String getRole() {
                return PassengerSctxServiceImp.this.m23277x();
            }

            public String getPageReferrer() {
                return PassengerSctxServiceImp.this.m23280y();
            }

            public RouteGuidanceGPSPoint getOriginDriverPoint() {
                return PassengerSctxServiceImp.this.f29941V;
            }

            public int getDriverMatchEda() {
                int i;
                int i2;
                RouteGuidanceGPSPoint h = PassengerSctxServiceImp.this.f29924E;
                int i3 = -1;
                if (h == null) {
                    return -1;
                }
                int distanceToTail = PassengerSctxServiceImp.this.f29925F != null ? PassengerSctxServiceImp.this.f29925F.distanceToTail(h) : -1;
                if (PassengerSctxServiceImp.this.f29920A != null) {
                    i2 = PassengerSctxServiceImp.this.f29920A.distanceLeft();
                    i = PassengerSctxServiceImp.this.f29920A.distanceLeft(h);
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (ApolloUtils.newEdaCalculator() && PassengerSctxServiceImp.this.f29925F != null) {
                    i3 = distanceToTail;
                } else if (PassengerSctxServiceImp.this.f29920A != null) {
                    i3 = i2;
                }
                DLog.m10773d("eda_log", "DriverMatchEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|CurDriverEda:" + i3 + "|OldEda:" + i2 + "|oldEdaParam:" + i + "|NewEda:" + distanceToTail + "|segmentIndex:" + h.segmentIndex, new Object[0]);
                return i3;
            }

            public int getCarAnimEda() {
                return BizUtil.animDistanceLeft(PassengerSctxServiceImp.this.f29921B, PassengerSctxServiceImp.this.f29920A);
            }

            public List<MockMovementInfo.SctxAnimData> getSctxAnimDataList() {
                ArrayList arrayList = new ArrayList(PassengerSctxServiceImp.this.f29943X);
                PassengerSctxServiceImp.this.f29943X.clear();
                return arrayList;
            }

            public boolean isSplitAccounts() {
                return PassengerSctxServiceImp.this.f29902e.isReadOnly();
            }

            public CarMarker getDriverMarker() {
                return PassengerSctxServiceImp.this.getCarMarker();
            }

            public boolean isArrived() {
                return PassengerSctxServiceImp.this.f29902e.isArrivedPickupPoint();
            }

            public boolean isSimulateEtaEdaLimit(boolean z) {
                return PassengerSctxServiceImp.this.m23224b(z);
            }

            public List<LatLng> getSctxRoutePoints() {
                return PassengerSctxServiceImp.this.f29922C;
            }

            public double getMaxMockDistance() {
                return (double) PassengerSctxServiceImp.this.f29905h.getMaxMockDistance(PassengerSctxServiceImp.this.f29920A.getMatchPointType());
            }

            public long getMaxMockTime() {
                return PassengerSctxServiceImp.this.f29905h.getMaxMockTime(PassengerSctxServiceImp.this.f29920A.getMatchPointType());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m23258n() {
        if (m23282z()) {
            this.f29942W.doOmegaOnCarDelayed(this.f29902e.getBizType(), m23277x(), this.f29905h.getSctxPredictionEnable(), this.f29948ac.lastReceiveRouteTime, this.f29921B, this.f29920A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m23260o() {
        DLog.m10773d(f29917q, "resetEtaEda", new Object[0]);
        this.f29930K = 0;
        this.f29929J = 0;
        int i = this.f29927H;
        this.f29931L = i;
        this.f29932M = i * 60;
        this.f29933N = this.f29928I;
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f29965t.setCarMarkerBitmap(bitmapDescriptor);
    }

    public boolean set3DCarIcons(boolean z, List<String> list) {
        return this.f29965t.refresh3DCarIcons(z, list);
    }

    public void setOraRequestInterval(long j) {
        long checkInterval = checkInterval(j);
        long j2 = this.f29966u;
        if (checkInterval != j2) {
            DLog.m10773d(f29917q, "setOraRequestInterval :%s -> %s", Long.valueOf(j2), Long.valueOf(checkInterval));
            this.f29966u = checkInterval;
            m23262p();
            refreshSyncInterval();
        }
    }

    /* renamed from: p */
    private void m23262p() {
        IInertiaDelegate iInertiaDelegate = this.f29920A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.setRequestIntervalInMills((int) this.f29966u);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f29921B;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setAnimationInterval((int) this.f29966u);
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return this.f29966u;
    }

    /* renamed from: a */
    private void m23209a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        DLog.m10773d(f29917q, "setOrderRouteResponse...", new Object[0]);
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
        if (!CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints) || CollectionUtil.isEmpty((Collection<?>) list)) {
            list = latLngListFromDiffGeoPoints;
        }
        float f = 0.0f;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f29962aq = f;
        } else {
            if (list.size() > 1) {
                f = (float) DDSphericalUtil.computeHeading(list.get(0), list.get(1));
            } else if (mapPassengeOrderRouteRes.direction != null) {
                f = (float) mapPassengeOrderRouteRes.direction.intValue();
            }
            this.f29962aq = f;
        }
        if (!this.f29909l) {
            m23222b(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* renamed from: b */
    private void m23222b(final MapPassengeOrderRouteRes mapPassengeOrderRouteRes, final List<LatLng> list, final List<TrafficItem> list2) {
        if (this.f29948ac.isExtendedAnimating) {
            DLog.m10773d(f29917q, "bIsExtendedAnimating, return", new Object[0]);
        } else if (!m23264q() || !this.f29948ac.isFirstRecvRoutes) {
            m23229c(mapPassengeOrderRouteRes, list, list2);
        } else if (mapPassengeOrderRouteRes == null || mapPassengeOrderRouteRes.secRouteInfo == null) {
            this.f29948ac.isFirstRecvRoutes = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                m23229c(mapPassengeOrderRouteRes, list, list2);
                return;
            }
            if (this.f29922C.isEmpty()) {
                this.f29922C.addAll(list);
            }
            TrafficLineAnimatorOptions trafficLineAnimatorOptions = new TrafficLineAnimatorOptions();
            trafficLineAnimatorOptions.duration = getRouteExtensionAnimationDuration();
            trafficLineAnimatorOptions.animatorListener = new TrafficLineAnimatorOptions.TrafficLineAnimatorListener() {
                public void onStart() {
                    PassengerSctxServiceImp.this.f29948ac.isExtendedAnimating = true;
                    if (PassengerSctxServiceImp.this.f29901d != null) {
                        PassengerSctxServiceImp.this.f29901d.onRouteAnimationStart();
                    }
                }

                public void onEnd() {
                    float f;
                    PassengerSctxServiceImp.this.f29948ac.isExtendedAnimating = false;
                    if (PassengerSctxServiceImp.this.f29901d != null) {
                        PassengerSctxServiceImp.this.f29901d.onRouteAnimationEnd();
                    }
                    if (!PassengerSctxServiceImp.this.m23229c(mapPassengeOrderRouteRes, list, list2)) {
                        PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                        LatLng latLng = (LatLng) list.get(0);
                        if (list.size() > 1) {
                            f = (float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1));
                        } else {
                            f = mapPassengeOrderRouteRes.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes.direction.intValue();
                        }
                        passengerSctxServiceImp.m23200a(latLng, f);
                    }
                }
            };
            m23205a(this.f29936Q);
            this.f29936Q = new TrafficLineDelegate();
            List<TrafficItem> list3 = mapPassengeOrderRouteRes.traffic;
            m23207a(this.f29936Q, list, (!CollectionUtil.isEmpty((Collection<?>) list3) || CollectionUtil.isEmpty((Collection<?>) list2)) ? list3 : list2, trafficLineAnimatorOptions, false, false);
        } else {
            m23229c(mapPassengeOrderRouteRes, list, list2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23200a(LatLng latLng, float f) {
        ISctxViewDelegate iSctxViewDelegate;
        if (latLng != null && (iSctxViewDelegate = this.f29965t) != null) {
            iSctxViewDelegate.updateCarMarker(latLng);
            this.f29965t.updateCarDirection(f);
        }
    }

    /* renamed from: a */
    private void m23208a(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        this.f29940U.parseFrom(mapPassengeOrderRouteRes);
        boolean z = true;
        this.f29934O = !this.f29940U.lineVisible;
        SctxDataCache sctxDataCache = this.f29948ac;
        if (!this.f29940U.lineVisible || this.f29902e.isArrivedPickupPoint()) {
            z = false;
        }
        sctxDataCache.enableDrawLine = z;
    }

    /* renamed from: q */
    private boolean m23264q() {
        return this.f29948ac.enableDrawLine && this.f29902e.isShowExtendedAnimation() && m23282z();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m23229c(MapPassengeOrderRouteRes mapPassengeOrderRouteRes, List<LatLng> list, List<TrafficItem> list2) {
        MapPassengeOrderRouteRes mapPassengeOrderRouteRes2 = mapPassengeOrderRouteRes;
        List<LatLng> list3 = list;
        this.f29948ac.isRouteChanged = false;
        if (mapPassengeOrderRouteRes2.logId == null) {
            DLog.m10773d(f29917q, "res.logId == null", new Object[0]);
        } else if (this.f29970y > mapPassengeOrderRouteRes2.logId.longValue()) {
            DLog.m10773d(f29917q, "mResLogId:%d > res.logId:%d, return", Long.valueOf(this.f29970y), mapPassengeOrderRouteRes2.logId);
            return false;
        } else {
            this.f29970y = mapPassengeOrderRouteRes2.logId.longValue();
        }
        if (this.f29901d != null) {
            if (this.f29902e.isReadOnly() && !CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f29901d.onStartDestinationUpdate(list3.get(0), list3.get(list.size() - 1));
            }
            if (mapPassengeOrderRouteRes2.ret != null) {
                if (mapPassengeOrderRouteRes2.ret.intValue() == 33333) {
                    this.f29901d.onWayPointsStateUpdate(true, (List<OdPoint>) null);
                } else if (mapPassengeOrderRouteRes2.ret.intValue() == 0) {
                    this.f29901d.onWayPointsStateUpdate(false, this.f29935P);
                    this.f29901d.onWayPointsStateUpdateForMiniBus(CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes2.odPoints) ? new ArrayList() : mapPassengeOrderRouteRes2.odPoints);
                }
            }
        }
        if (mapPassengeOrderRouteRes2.eta != null && mapPassengeOrderRouteRes2.eta.intValue() >= 0) {
            this.f29927H = mapPassengeOrderRouteRes2.eta.intValue();
            DLog.m10773d(f29917q, "res.eta:" + mapPassengeOrderRouteRes2.eta, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.distance != null && mapPassengeOrderRouteRes2.distance.intValue() >= 0) {
            this.f29928I = mapPassengeOrderRouteRes2.distance.intValue();
            DLog.m10773d(f29917q, "res.distance:" + mapPassengeOrderRouteRes2.distance, new Object[0]);
        }
        if (mapPassengeOrderRouteRes2.driverPoint == null || !LatLngUtils.locateCorrect((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue())) {
            DLog.m10773d(f29917q, "res.driverPoint is error", new Object[0]);
            this.f29907j.setErrorCode(202);
            return false;
        }
        LatLng latLng = new LatLng((double) mapPassengeOrderRouteRes2.driverPoint.lat.floatValue(), (double) mapPassengeOrderRouteRes2.driverPoint.lng.floatValue());
        Object[] objArr = new Object[2];
        objArr[0] = GoogleSyncTripLogUtil.getLatLngLogInfo(latLng);
        objArr[1] = Integer.valueOf(mapPassengeOrderRouteRes2.direction == null ? 0 : mapPassengeOrderRouteRes2.direction.intValue());
        DLog.m10773d(f29917q, "server返回的司机定位:%s，方向:%d", objArr);
        RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint = ConvertUtil.tran2RouteGuidanceGPSPoint(mapPassengeOrderRouteRes2.driverPoint, mapPassengeOrderRouteRes2.direction == null ? 0 : mapPassengeOrderRouteRes2.direction.intValue());
        this.f29941V = tran2RouteGuidanceGPSPoint;
        IInertiaDelegate iInertiaDelegate = this.f29920A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.onRecvDriverLocation(tran2RouteGuidanceGPSPoint);
        }
        float f = 0.0f;
        if (this.f29934O) {
            m23205a(this.f29936Q);
            if (this.f29965t.getCarMarker() == null) {
                m23200a(latLng, mapPassengeOrderRouteRes2.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes2.direction.intValue());
            }
        }
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(list.size());
            objArr2[1] = Long.valueOf(this.f29910m);
            objArr2[2] = Long.valueOf(mapPassengeOrderRouteRes2.routeId == null ? 0 : mapPassengeOrderRouteRes2.routeId.longValue());
            DLog.m10773d(f29917q, "server返回了路线，路线点集个数:%d，重新画线，routeId:[%d -> %d]", objArr2);
            if (hasLine() && mapPassengeOrderRouteRes2.routeId != null && mapPassengeOrderRouteRes2.routeId.longValue() == this.f29910m && list.size() == this.f29922C.size() && m23186a(mapPassengeOrderRouteRes2.curDstRouteGeoIndex) == this.f29911n) {
                DLog.m10773d(f29917q, "后台返回了跟上次一样的routeId，但也返回了路线(按理不该返回)，这里就不再刷新路线", new Object[0]);
                m23266r();
            } else {
                this.f29948ac.isRouteChanged = true;
                this.f29948ac.routePoints = list3;
                this.f29948ac.trafficItems = mapPassengeOrderRouteRes2.traffic;
                final MapPassengeOrderRouteRes mapPassengeOrderRouteRes3 = mapPassengeOrderRouteRes;
                final List<LatLng> list4 = list;
                final List<TrafficItem> list5 = list2;
                final LatLng latLng2 = latLng;
                this.f29921B.animateCancel(new onCarAnimationCancelListener() {
                    public void onCancel() {
                        float f;
                        int i = 0;
                        DLog.m10773d(PassengerSctxServiceImp.f29917q, "onCarAnimationCancelListener onCancel() callback", new Object[0]);
                        long j = 0;
                        if (mapPassengeOrderRouteRes3.routeId == null) {
                            PassengerSctxServiceImp.this.f29910m = 0;
                            PassengerSctxServiceImp.this.f29911n = 0;
                        } else {
                            if (PassengerSctxServiceImp.this.m23282z() && PassengerSctxServiceImp.this.f29910m > 0 && PassengerSctxServiceImp.this.getCarMarker() != null) {
                                float computeHeading = (float) DDSphericalUtil.computeHeading(PassengerSctxServiceImp.this.getCarMarker().getPosition(), (LatLng) list4.get(0));
                                if (!(PassengerSctxServiceImp.this.f29920A == null || PassengerSctxServiceImp.this.f29920A.getLastMatchGPSPoint() == null)) {
                                    j = PassengerSctxServiceImp.this.f29920A.getLastMatchGPSPoint().timestamp;
                                }
                                GoogleSyncTripOmegaUtil.map_pax_car_jump(PassengerSctxServiceImp.this.m23276w(), PassengerSctxServiceImp.this.f29902e.getOrderId(), PassengerSctxServiceImp.this.f29902e.getTripState(), PassengerSctxServiceImp.this.f29902e.isArrivedPickupPoint(), computeHeading, !PassengerSctxServiceImp.this.f29934O ? 1 : 0, PassengerSctxServiceImp.this.getCarMarker().getPosition(), j, (LatLng) list4.get(0), mapPassengeOrderRouteRes3.driverPoint.gpsTimestamp.longValue(), PassengerSctxServiceImp.this.f29902e.getBizType(), PassengerSctxServiceImp.this.m23277x(), PassengerSctxServiceImp.this.m23280y());
                            }
                            PassengerSctxServiceImp.this.f29910m = mapPassengeOrderRouteRes3.routeId.longValue();
                            PassengerSctxServiceImp passengerSctxServiceImp = PassengerSctxServiceImp.this;
                            passengerSctxServiceImp.f29911n = passengerSctxServiceImp.m23186a(mapPassengeOrderRouteRes3.curDstRouteGeoIndex);
                        }
                        if (!CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes3.traffic) || CollectionUtil.isEmpty((Collection<?>) list5)) {
                            PassengerSctxServiceImp passengerSctxServiceImp2 = PassengerSctxServiceImp.this;
                            MapPassengeOrderRouteRes mapPassengeOrderRouteRes = mapPassengeOrderRouteRes3;
                            passengerSctxServiceImp2.m23233d(mapPassengeOrderRouteRes, list4, mapPassengeOrderRouteRes.traffic);
                        } else {
                            PassengerSctxServiceImp.this.m23233d(mapPassengeOrderRouteRes3, list4, list5);
                        }
                        PassengerSctxServiceImp.this.f29948ac.lastReceiveRouteTime = System.currentTimeMillis();
                        CarIconsPreloader.getInstance().setRoutePoints(PassengerSctxServiceImp.this.f29898a.getContext(), list4);
                        RouteGuidanceGPSPoint unused = PassengerSctxServiceImp.this.f29924E = new RouteGuidanceGPSPoint();
                        PassengerSctxServiceImp.this.f29924E.segmentIndex = -1;
                        PassengerSctxServiceImp.this.f29921B.setNavRoutePoints(list4, false);
                        if (PassengerSctxServiceImp.this.f29920A != null) {
                            if (PassengerSctxServiceImp.this.f29911n > 0) {
                                PassengerSctxServiceImp.this.f29920A.setRoutePoints(list4, PassengerSctxServiceImp.this.f29911n, PassengerSctxServiceImp.this.m23214a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceImp.this.f29925F.setRoutePoints(list4, PassengerSctxServiceImp.this.f29911n);
                                }
                            } else {
                                PassengerSctxServiceImp.this.f29920A.setRoutePoints((List<LatLng>) list4, PassengerSctxServiceImp.this.m23214a(false));
                                if (ApolloUtils.newEdaCalculator()) {
                                    PassengerSctxServiceImp.this.f29925F.setRoutePoints(list4);
                                }
                            }
                        }
                        PassengerSctxServiceImp.this.m23266r();
                        if (PassengerSctxServiceImp.this.f29965t.getCarMarker() != null) {
                            return;
                        }
                        if (!PassengerSctxServiceImp.this.f29902e.isArrivedPickupPoint()) {
                            PassengerSctxServiceImp passengerSctxServiceImp3 = PassengerSctxServiceImp.this;
                            LatLng latLng = (LatLng) list4.get(0);
                            if (list4.size() > 1) {
                                f = (float) DDSphericalUtil.computeHeading((LatLng) list4.get(0), (LatLng) list4.get(1));
                            } else {
                                if (mapPassengeOrderRouteRes3.direction != null) {
                                    i = mapPassengeOrderRouteRes3.direction.intValue();
                                }
                                f = (float) i;
                            }
                            passengerSctxServiceImp3.m23200a(latLng, f);
                            return;
                        }
                        DLog.m10773d(PassengerSctxServiceImp.f29917q, "司机已到达态下发新路线时，初始让小车显示在真实司机位置%s，非路线第一个点", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng2));
                        PassengerSctxServiceImp.this.m23200a(latLng2, mapPassengeOrderRouteRes3.direction == null ? 0.0f : (float) mapPassengeOrderRouteRes3.direction.intValue());
                    }
                });
            }
            if (!this.f29902e.isReadOnly()) {
                GoogleSyncTripOmegaUtil.com_map_PassengerGetRoute_sw_global(m23276w(), this.f29902e.getOrderId(), this.f29910m, this.f29902e.getTripState(), this.f29902e.isArrivedPickupPoint(), this.f29902e.getCountryId(), this.f29902e.getTripId(), this.f29908k, this.f29902e.getBizType(), m23277x(), m23280y());
            }
        } else {
            m23266r();
            if (this.f29965t.getCarMarker() == null) {
                if (mapPassengeOrderRouteRes2.direction != null) {
                    f = (float) mapPassengeOrderRouteRes2.direction.intValue();
                }
                m23200a(latLng, f);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m23186a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m23266r() {
        IInertiaDelegate iInertiaDelegate = this.f29920A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.getMatchPoint(m23268s());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m23214a(boolean z) {
        if (!m23282z() || !TextUtils.isEmpty(this.f29902e.getTripId()) || this.f29902e.isReadOnly()) {
            if (z) {
                DLog.m10773d(f29917q, "[getMatchPoint result] 非接驾段 | 拼车 | 分账人 -> 不开启惯导", new Object[0]);
            }
            return false;
        }
        boolean simulateMotionEnable = this.f29905h.getSimulateMotionEnable();
        if (z) {
            DLog.m10773d(f29917q, "[getMatchPoint] 看是否满足惯导条件：", new Object[0]);
            DLog.m10773d(f29917q, "1.总Apollo开关是否打开：%s", Boolean.valueOf(simulateMotionEnable));
        }
        return simulateMotionEnable;
    }

    /* renamed from: s */
    private boolean m23268s() {
        boolean a = m23214a(true);
        if (!a) {
            return a;
        }
        int maxMockDistance = this.f29905h.getMaxMockDistance(this.f29920A.getMatchPointType());
        long maxMockTime = this.f29905h.getMaxMockTime(this.f29920A.getMatchPointType());
        boolean z = this.f29930K < maxMockDistance && this.f29929J < maxMockTime;
        DLog.m10773d(f29917q, "2.累积惯导距离：%d, 累积惯导时间：%d [距离上限：%d, 时间上限:%d]", Integer.valueOf(this.f29930K), Long.valueOf(this.f29929J), Integer.valueOf(maxMockDistance), Long.valueOf(maxMockTime));
        return z ? !m23224b(true) : z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m23224b(boolean z) {
        int allowEDA = this.f29905h.getAllowEDA();
        int allowETA = (int) ((this.f29905h.getAllowETA() / 1000) / 60);
        if (this.f29931L > 0 || this.f29933N > 0) {
            if (z) {
                DLog.m10773d(f29917q, "3.mShowDistance：%d, mShowEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f29933N), Integer.valueOf(this.f29931L), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
            }
            if (this.f29933N <= allowEDA || this.f29931L <= allowETA) {
                return true;
            }
            return false;
        }
        if (z) {
            DLog.m10773d(f29917q, "3.mDistance：%d, mEta：%d [惯导eda上限：%d, 惯导eta上限:%d]", Integer.valueOf(this.f29928I), Integer.valueOf(this.f29927H), Integer.valueOf(allowEDA), Integer.valueOf(allowETA));
        }
        if (this.f29928I <= allowEDA || this.f29927H <= allowETA) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m23233d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes r12, java.util.List<com.didi.common.map.model.LatLng> r13, java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r14) {
        /*
            r11 = this;
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r13)
            r1 = 0
            if (r0 != 0) goto L_0x0059
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.util.Iterator r2 = r13.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r2.next()
            com.didi.common.map.model.LatLng r3 = (com.didi.common.map.model.LatLng) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            double r5 = r3.longitude
            r4.append(r5)
            java.lang.String r5 = ","
            r4.append(r5)
            double r5 = r3.latitude
            r4.append(r5)
            java.lang.String r3 = ";"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.append(r3)
            goto L_0x0010
        L_0x003d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "新路线: "
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "ccc"
            com.didi.common.map.util.DLog.m10773d(r3, r0, r2)
        L_0x0059:
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f29922C
            r0.clear()
            java.util.ArrayList<com.didi.common.map.model.LatLng> r0 = r11.f29922C
            r0.addAll(r13)
            r11.m23260o()
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f29948ac
            boolean r0 = r0.enableDrawLine
            if (r0 == 0) goto L_0x0182
            com.didi.map.global.sctx.model.SctxDataCache r0 = r11.f29948ac
            boolean r0 = r0.isDestModified
            java.lang.String r2 = "PassengerSctxService"
            r3 = 1
            if (r0 == 0) goto L_0x00a4
            int r0 = r13.size()
            int r0 = r0 - r3
            java.lang.Object r0 = r13.get(r0)
            com.didi.common.map.model.LatLng r0 = (com.didi.common.map.model.LatLng) r0
            com.didi.map.global.sctx.model.SctxTripParam r4 = r11.f29902e
            com.didi.common.map.model.LatLng r4 = r4.getEndPoint()
            double r4 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r0, r4)
            r6 = 4647503709213818880(0x407f400000000000, double:500.0)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a4
            java.lang.Object[] r12 = new java.lang.Object[r3]
            r13 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12[r1] = r13
            java.lang.String r13 = "updateNewLine - 修改了目的地，但是修改后的目的地与后台下发的路线终点距离相差大于%dm --> 不画线"
            com.didi.common.map.util.DLog.m10773d(r2, r13, r12)
            goto L_0x0182
        L_0x00a4:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r4 = "updateNewLine - rebuild TrafficLine"
            com.didi.common.map.util.DLog.m10773d(r2, r4, r0)
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f29901d
            if (r0 == 0) goto L_0x00b8
            boolean r0 = r11.f29960ao
            if (r0 != 0) goto L_0x00b8
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r11.f29901d
            r0.goingOffCourse()
        L_0x00b8:
            r11.f29960ao = r1
            r0 = 0
            r11.f29956ak = r0
            r11.f29923D = r0
            boolean r4 = r11.m23183N()
            if (r4 == 0) goto L_0x00f7
            r11.f29939T = r1
            com.didi.map.global.sctx.widget.TrafficLineDelegate r4 = r11.f29955aj
            if (r4 == 0) goto L_0x00d9
            r11.m23205a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r4)
            r11.f29955aj = r0
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f29901d
            if (r4 == 0) goto L_0x00d9
            com.didi.map.global.sctx.SctxService$SctxCallback r4 = r11.f29901d
            r4.showSecRouteInfoCallback(r0, r1)
        L_0x00d9:
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r12.secRouteInfo
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.proto.driver_gl.Route r0 = r12.route
            if (r0 == 0) goto L_0x00f7
            boolean r0 = com.didi.map.google.util.DUtils.checkSecRouteInfoValid(r12)
            if (r0 == 0) goto L_0x00f7
            r11.f29956ak = r12
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            com.didi.map.sdk.proto.driver_gl.DiffGeoPoints r12 = r12.routePoints
            java.util.List r12 = com.didi.map.google.util.ConvertUtil.getLatLngListFromDiffGeoPoints(r12)
            r11.f29923D = r12
            r10 = 1
            goto L_0x00f8
        L_0x00f7:
            r10 = 0
        L_0x00f8:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f29936Q
            r11.m23205a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r5.<init>()
            r11.f29936Q = r5
            r8 = 0
            r9 = 0
            r4 = r11
            r6 = r13
            r7 = r14
            r4.m23207a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f29936Q
            r11.m23206a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r3)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw line"
            com.didi.common.map.util.DLog.m10773d(r2, r13, r12)
            com.didi.map.global.sctx.event_reveal.TrafficEventsController r12 = r11.f29926G
            if (r12 == 0) goto L_0x012a
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "TrafficReveal"
            java.lang.String r14 = "draw new line then request event/show"
            com.didi.common.map.util.DLog.m10773d(r13, r14, r12)
            com.didi.map.global.sctx.event_reveal.TrafficEventsController r12 = r11.f29926G
            r12.forceRestart()
        L_0x012a:
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f29956ak
            if (r12 == 0) goto L_0x0182
            java.util.List<com.didi.common.map.model.LatLng> r12 = r11.f29923D
            if (r12 == 0) goto L_0x0182
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f29955aj
            r11.m23205a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = new com.didi.map.global.sctx.widget.TrafficLineDelegate
            r12.<init>()
            r11.f29955aj = r12
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f29956ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.lang.Integer r12 = r12.included
            int r12 = r12.intValue()
            if (r12 != r3) goto L_0x014c
            r9 = 1
            goto L_0x014d
        L_0x014c:
            r9 = 0
        L_0x014d:
            com.didi.map.global.sctx.widget.TrafficLineDelegate r5 = r11.f29955aj
            java.util.List<com.didi.common.map.model.LatLng> r6 = r11.f29923D
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r12 = r11.f29956ak
            com.didi.map.sdk.proto.driver_gl.Route r12 = r12.route
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r7 = r12.traffic
            r8 = 0
            r10 = 1
            r4 = r11
            r4.m23207a(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f29955aj
            r13 = 2
            r11.m23206a((com.didi.map.global.sctx.widget.TrafficLineDelegate) r12, (int) r13)
            com.didi.map.global.sctx.widget.TrafficLineDelegate r12 = r11.f29955aj
            r12.highLight(r1)
            r11.m23226c()
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f29901d
            if (r12 == 0) goto L_0x017b
            com.didi.map.global.sctx.SctxService$SctxCallback r12 = r11.f29901d
            com.didi.map.global.sctx.model.SecRouteInfoEx r13 = new com.didi.map.global.sctx.model.SecRouteInfoEx
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r14 = r11.f29956ak
            r13.<init>(r14)
            r12.showSecRouteInfoCallback(r13, r3)
        L_0x017b:
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "draw sec back line"
            com.didi.common.map.util.DLog.m10773d(r2, r13, r12)
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.m23233d(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes, java.util.List, java.util.List):void");
    }

    /* renamed from: a */
    private void m23207a(TrafficLineDelegate trafficLineDelegate, List<LatLng> list, List<TrafficItem> list2, TrafficLineAnimatorOptions trafficLineAnimatorOptions, boolean z, boolean z2) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.setTrafficOptions(m23190a(list, list2, z, z2));
            trafficLineDelegate.addToMap(this.f29898a, trafficLineAnimatorOptions);
            this.f29964as = true;
        }
    }

    /* renamed from: a */
    private TrafficOptions m23190a(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
        if (!MapVendor.DIDI.equals(this.f29898a.getMapVendor()) || !z2 || (ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture())) {
            return m23219b(list, list2, z, z2);
        }
        return m23191a(list, z);
    }

    /* renamed from: a */
    private TrafficOptions m23191a(List<LatLng> list, boolean z) {
        TrafficOptions trafficOptions = new TrafficOptions();
        trafficOptions.lineWidth = (int) TypedValue.applyDimension(1, (float) (z ? 7 : 6), this.f29899b.getResources().getDisplayMetrics());
        trafficOptions.drawLineType = 2;
        trafficOptions.clickable = true;
        trafficOptions.lineTextureIndex = 1;
        trafficOptions.lineMinorTextureIndex = 2;
        trafficOptions.points = new ArrayList();
        if (list != null) {
            trafficOptions.points.addAll(list);
        }
        return trafficOptions;
    }

    /* renamed from: b */
    private TrafficOptions m23219b(List<LatLng> list, List<TrafficItem> list2, boolean z, boolean z2) {
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
        boolean z3 = false;
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
        if (MapVendor.DIDI.equals(this.f29898a.getMapVendor()) && ApolloUtils.useCompLineForSctx() && ApolloUtils.useCompLineTexture()) {
            z3 = true;
        }
        if (z3) {
            trafficOptions.useNewCompLine = true;
            trafficOptions.drawLineType = 2;
        } else {
            trafficOptions.useNewCompLine = ApolloUtils.useCompLineForSctx();
            trafficOptions.drawLineType = 1;
        }
        return trafficOptions;
    }

    public List<LatLng> getRoutePoints() {
        return this.f29922C;
    }

    public List<Line> getLines() {
        TrafficLineDelegate trafficLineDelegate = this.f29936Q;
        if (trafficLineDelegate == null) {
            return null;
        }
        return trafficLineDelegate.getLines();
    }

    public List<LatLng> getRemainingRoutePoints() {
        return this.f29946aa;
    }

    /* renamed from: t */
    private int m23269t() {
        if (!this.f29934O) {
            int i = m23282z() ? this.f29931L : this.f29927H;
            if (Math.abs(this.f29968w - i) >= 1) {
                m23196a(i, m23282z() ? this.f29933N : this.f29928I);
                this.f29968w = i;
            }
            return i;
        } else if (this.f29940U.mEta >= 0) {
            DLog.m10773d(f29917q, "bIsHideRoute, eta:" + this.f29940U.mEta, new Object[0]);
            return this.f29940U.mEta;
        } else {
            DLog.m10773d(f29917q, "bIsHideRoute, eta return %d", 1);
            return 1;
        }
    }

    /* renamed from: u */
    private int m23271u() {
        if (!this.f29934O) {
            int i = m23282z() ? this.f29933N : this.f29928I;
            if (Math.abs(this.f29969x - i) >= 100) {
                m23196a(m23282z() ? this.f29931L : this.f29927H, i);
                this.f29969x = i;
            }
            return i;
        } else if (this.f29940U.mDistance >= 0) {
            DLog.m10773d(f29917q, "bIsHideRoute, eda:" + this.f29940U.mDistance, new Object[0]);
            return this.f29940U.mDistance;
        } else {
            DLog.m10773d(f29917q, "bIsHideRoute, eda return %d", 100);
            return 100;
        }
    }

    /* renamed from: v */
    private LatLng m23273v() {
        DoublePoint location = DUtils.getLocation(this.f29899b);
        if (location != null) {
            return new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue());
        }
        return new LatLng(0.0d, 0.0d);
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public String m23276w() {
        return this.f29903f != null ? this.f29903f.getUserId() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public String m23277x() {
        if (!TextUtils.isEmpty(this.f29948ac.userRole)) {
            return this.f29948ac.userRole;
        }
        if (this.f29903f != null) {
            this.f29948ac.userRole = this.f29903f.getUserRole();
        }
        return this.f29948ac.userRole;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public String m23280y() {
        if (this.f29903f != null) {
            return this.f29903f.getPageReferrer();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m23282z() {
        return this.f29902e.getTripState() == 3 && !this.f29902e.isArrivedPickupPoint();
    }

    /* renamed from: A */
    private boolean m23157A() {
        return this.f29902e.getTripState() == 3 && this.f29902e.isArrivedPickupPoint();
    }

    /* renamed from: B */
    private boolean m23160B() {
        return this.f29902e.getTripState() == 4;
    }

    public double getRemainingRouteDistance() {
        if (!this.f29902e.isArrivedPickupPoint() || getCarMarker() == null) {
            return 0.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(getCarMarker().getPosition(), this.f29902e.getPickupPoint());
    }

    public LatLng getDriverPoint() {
        IInertiaDelegate iInertiaDelegate = this.f29920A;
        if (iInertiaDelegate == null || iInertiaDelegate.getLastMatchGPSPoint() == null || this.f29920A.getLastMatchGPSPoint().segmentIndex == -1) {
            if (getCarMarker() != null) {
                return getCarMarker().getPosition();
            }
            return null;
        } else if (!this.f29905h.getSctxPredictionEnable() || this.f29920A.getLastMatchGPSPoint().originMatchPoint == null) {
            return ConvertUtil.convertFromGeoPoint(this.f29920A.getLastMatchGPSPoint().point);
        } else {
            return ConvertUtil.convertFromGeoPoint(this.f29920A.getLastMatchGPSPoint().originMatchPoint.point);
        }
    }

    public CarMarker getCarMarker() {
        ISctxViewDelegate iSctxViewDelegate = this.f29965t;
        if (iSctxViewDelegate == null) {
            return null;
        }
        return iSctxViewDelegate.getCarMarker();
    }

    public void updateDestination(LatLng latLng) {
        DLog.m10773d(f29917q, "updateDestination...", new Object[0]);
        m23201a(this.f29902e.getPickupPoint(), latLng);
        if (latLng != null) {
            this.f29948ac.orderDestPoint = latLng;
            if (this.f29902e.getTripState() == 4) {
                DLog.m10773d(f29917q, "updateDestination - 送驾段，removeLine", new Object[0]);
                this.f29948ac.isDestModified = true;
                m23205a(this.f29936Q);
            }
        }
    }

    public void updatePickupPoint(LatLng latLng) {
        m23201a(latLng, this.f29902e.getEndPoint());
        if (latLng != null) {
            this.f29957al = 1;
            this.f29948ac.orderPickupPoint = latLng;
            this.f29910m = 0;
            if (this.f29902e.getTripState() == 3) {
                DLog.m10773d(f29917q, "updateDestination - 接驾段，removeLine", new Object[0]);
                m23181M();
                m23174I();
                m23168F();
                m23166E();
                runImmediately();
            }
        }
    }

    public void setWayPoints(List<OdPoint> list, long j) {
        DLog.m10773d(f29917q, "[途经点信息] setOdPoints:%s, odPointsTimestamp:%d", GoogleSyncTripLogUtil.getOdPointsLogInfo(list), Long.valueOf(j));
        this.f29948ac.lastGetWayPointTime = j;
        List<OdPoint> list2 = this.f29935P;
        if (list2 != null) {
            list2.clear();
            if (list != null) {
                this.f29935P.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        if (TextUtils.isEmpty(this.f29902e.getToken())) {
            return null;
        }
        PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
        if (this.f29948ac.orderPickupPoint != null) {
            builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f29948ac.orderPickupPoint.latitude)).lng(Float.valueOf((float) this.f29948ac.orderPickupPoint.longitude)).build());
        }
        if (this.f29948ac.orderDestPoint != null) {
            builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f29948ac.orderDestPoint.latitude)).lng(Float.valueOf((float) this.f29948ac.orderDestPoint.longitude)).build());
        }
        if (this.f29948ac.vamosDriverTripDestPoint != null) {
            builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.f29948ac.vamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.f29948ac.vamosDriverTripDestPoint.longitude)).build()).build());
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
        curRouteId.imei(str2).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f29902e.getClientVersion()).lastOrderId(this.f29902e.getLastOrderId()).noNeedGeo(false).productId(String.valueOf(this.f29902e.getBizType())).countryId(this.f29902e.getCountryId()).sdkmaptype(str).lang(LocaleCodeHolder.getInstance().getCurrentLang()).travelId(this.f29902e.getTripId()).recPPState(Integer.valueOf(this.f29957al)).psgPoint(DUtils.getLocation(this.f29899b)).pushBtMsg(false).bizGroup(Integer.valueOf(this.f29902e.getBizGroup()));
        if (this.f29902e.getTripState() == 4) {
            if (this.f29948ac.lastGetWayPointTime <= 0) {
                DLog.m10773d(f29917q, "mWayPointTimeStamp(%d) <= 0，不传给后台途经点", Long.valueOf(this.f29948ac.lastGetWayPointTime));
            } else {
                builder.odPoints(this.f29935P);
                builder.odPointsTimestamp(Long.valueOf(this.f29948ac.lastGetWayPointTime));
            }
        }
        builder.readOnly(Boolean.valueOf(this.f29902e.isReadOnly()));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
        OmegaReportManager omegaReportManager;
        DLog.m10773d(f29917q, "onSyncStart...", new Object[0]);
        if (this.f29901d != null) {
            this.f29901d.onSyncStart();
        }
        if (!this.f29902e.isReadOnly() && (omegaReportManager = this.f29942W) != null) {
            omegaReportManager.doOmegaReportByTimeInterval();
        }
    }

    /* renamed from: C */
    private void m23162C() {
        if (this.f29902e.getTripState() == 3) {
            this.f29942W.trackOrderLocationPermission(Utils.getLocationSwitchLevel(this.f29899b), m23177K());
        }
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        DLog.m10773d(f29917q, "onOraResponse...", new Object[0]);
        if (!this.f29908k) {
            if (Config.DEBUG && mapPassengeOrderRouteRes.ret != null && mapPassengeOrderRouteRes.ret.intValue() == 10000) {
                this.f29901d.orderChanged();
            } else if (mapPassengeOrderRouteRes != null) {
                if (mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() != 30076 || this.f29901d == null) {
                    if (!(mapPassengeOrderRouteRes.ret == null || mapPassengeOrderRouteRes.ret.intValue() == 0 || mapPassengeOrderRouteRes.logId == null)) {
                        this.f29942W.trackOrderRouteResultError(mapPassengeOrderRouteRes.ret.intValue(), mapPassengeOrderRouteRes.logId.longValue());
                    }
                    m23208a(mapPassengeOrderRouteRes);
                    if (m23211a(this.f29940U.serverStage) && this.f29901d != null) {
                        this.f29901d.onAbnormalOrderStageCallback(this.f29940U.serverStage);
                        this.f29907j.setErrorCode(203);
                    }
                    if (this.f29940U.serverStage == 5) {
                        this.f29907j.setErrorCode(203);
                        stop();
                        return;
                    }
                    if (!this.f29908k) {
                        this.f29963ar = true;
                    }
                    m23209a(mapPassengeOrderRouteRes, this.f29948ac.routePoints, this.f29948ac.trafficItems);
                    if (this.f29901d != null) {
                        this.f29901d.onSyncSuccess(mapPassengeOrderRouteRes);
                        this.f29901d.onEtaEdaUpdate(new EtaEdaInfo(m23269t(), m23271u(), SXUtils.getLastOrderEda(this.f29902e.getLastOrderId(), mapPassengeOrderRouteRes)));
                        return;
                    }
                    return;
                }
                DLog.m10773d(f29917q, "error code:" + mapPassengeOrderRouteRes.ret, new Object[0]);
                this.f29901d.onAbnormalOrderStageCallback(4);
            }
        }
    }

    /* renamed from: D */
    private double m23163D() {
        LatLng driverPoint = getDriverPoint();
        List<LatLng> routePoints = getRoutePoints();
        return DDSphericalUtil.computeDistanceBetween(driverPoint, routePoints.get(routePoints.size() - 1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m23211a(int r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.PassengerSctxServiceImp.m23211a(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
        DLog.m10773d(f29917q, "onOraFail err:%s", str);
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
        if (this.f29948ac.isSctxParamUpdated) {
            this.f29948ac.isSctxParamUpdated = false;
            m23170G();
            DLog.m10773d(f29917q, "onPreStart, isSctxParamUpdated is true", new Object[0]);
        }
        if (m23160B()) {
            m23245h();
            TrafficEventsController trafficEventsController = this.f29926G;
            if (trafficEventsController != null) {
                trafficEventsController.start();
            }
        }
    }

    public void update(SctxTripParam sctxTripParam) {
        DLog.m10773d(f29917q, "update...", new Object[0]);
        if (sctxTripParam == null || sctxTripParam.equals(this.f29902e)) {
            DLog.m10773d(f29917q, "update,mSctxTripParam is equals.", new Object[0]);
            return;
        }
        stop();
        this.f29948ac.orderId = this.f29902e.getOrderId();
        this.f29948ac.orderState = this.f29902e.getTripState();
        this.f29948ac.isWaitingState = this.f29902e.isArrivedPickupPoint();
        this.f29948ac.isSctxParamUpdated = true;
        initBaseParam(sctxTripParam);
        m23166E();
        if (this.f29902e.getTripState() == 3) {
            m23220b();
            m23236e();
        }
        m23201a(this.f29902e.getPickupPoint(), this.f29902e.getEndPoint());
        start();
    }

    /* renamed from: E */
    private void m23166E() {
        this.f29943X.clear();
        this.f29945Z = null;
        Handler handler = this.f29944Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        } else {
            this.f29944Y = new Handler(Looper.getMainLooper());
        }
        if (this.f29902e != null && !this.f29902e.isArrivedPickupPoint() && this.f29902e.getTripState() == 3) {
            m23199a(1000);
        }
        DLog.m10773d("ccc", "开始记录缓存数据", new Object[0]);
    }

    /* renamed from: F */
    private void m23168F() {
        this.f29943X.clear();
        this.f29945Z = null;
        Handler handler = this.f29944Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f29944Y = null;
        }
        DLog.m10773d("ccc", "清除缓存数据", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23199a(long j) {
        this.f29944Y.postDelayed(new Runnable() {
            public void run() {
                if (PassengerSctxServiceImp.this.f29921B == null || PassengerSctxServiceImp.this.getCarMarker() == null) {
                    PassengerSctxServiceImp.this.m23199a(1000);
                    DLog.m10773d("ccc", "未初始化，不缓存轨迹点", new Object[0]);
                } else if (PassengerSctxServiceImp.this.f29912o == 0) {
                    PassengerSctxServiceImp.this.m23199a(1000);
                    DLog.m10773d("ccc", "未可用，不缓存轨迹点", new Object[0]);
                } else if (System.currentTimeMillis() - PassengerSctxServiceImp.this.f29912o < 5000) {
                    PassengerSctxServiceImp.this.m23199a(1000);
                    DLog.m10773d("ccc", "5s内不缓存轨迹数据", new Object[0]);
                } else {
                    if (!PassengerSctxServiceImp.this.f29908k) {
                        MockMovementInfo.SctxAnimData sctxAnimData = new MockMovementInfo.SctxAnimData();
                        if (TimeServiceManager.getInstance().isNTPAvailable()) {
                            sctxAnimData.ntpTimestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
                        } else {
                            sctxAnimData.ntpTimestamp = -1;
                        }
                        sctxAnimData.localTime = System.currentTimeMillis();
                        LatLng position = PassengerSctxServiceImp.this.getCarMarker().getPosition();
                        sctxAnimData.animLat = position.latitude;
                        sctxAnimData.animLng = position.longitude;
                        int animDistanceLeftCustomed = BizUtil.animDistanceLeftCustomed(PassengerSctxServiceImp.this.f29921B, PassengerSctxServiceImp.this.f29925F);
                        int animDistanceLeft = BizUtil.animDistanceLeft(PassengerSctxServiceImp.this.f29921B, PassengerSctxServiceImp.this.f29920A);
                        if (ApolloUtils.newEdaCalculator()) {
                            sctxAnimData.carAnimEda = animDistanceLeftCustomed;
                        } else {
                            sctxAnimData.carAnimEda = animDistanceLeft;
                        }
                        if (PassengerSctxServiceImp.this.f29945Z != null && PassengerSctxServiceImp.this.f29963ar) {
                            sctxAnimData.animDistance = DDSphericalUtil.computeDistanceBetween(position, PassengerSctxServiceImp.this.f29945Z);
                        }
                        if (PassengerSctxServiceImp.this.f29906i.isEnable()) {
                            sctxAnimData.jumpOverException = PassengerSctxServiceImp.this.f29906i.getCode();
                            PassengerSctxServiceImp.this.f29906i.clearJumpOverData();
                        }
                        PassengerSctxServiceImp.this.f29943X.add(sctxAnimData);
                        LatLng unused = PassengerSctxServiceImp.this.f29945Z = position;
                        DLog.m10773d("eda_log", "CarAnimEda|EdaApollo:" + ApolloUtils.newEdaCalculator() + "|carAnimEda:" + sctxAnimData.carAnimEda + "|oldCarAnimEda:" + animDistanceLeft + "|newCarAnimEda:" + animDistanceLeftCustomed, new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("新增缓存数据 data.carAnimEda = ");
                        sb.append(sctxAnimData.carAnimEda);
                        sb.append(", data.animDistance=");
                        sb.append(sctxAnimData.animDistance);
                        DLog.m10773d("ccc", sb.toString(), new Object[0]);
                        if (Config.DEBUG && sctxAnimData.animDistance > 100.0d) {
                            String str = Config.DEBUG_TAG;
                            SystemUtils.log(3, str, "------ data.animDistance=" + sctxAnimData.animDistance, (Throwable) null, "com.didi.map.global.sctx.PassengerSctxServiceImp$12", 1982);
                        }
                    }
                    PassengerSctxServiceImp.this.m23199a(1000);
                }
            }
        }, j);
    }

    /* renamed from: G */
    private void m23170G() {
        m23249j();
        m23247i();
        m23252k();
        m23254l();
        m23172H();
        m23242g();
    }

    /* renamed from: H */
    private void m23172H() {
        this.f29910m = 0;
        this.f29930K = 0;
        this.f29929J = 0;
        this.f29971z = 0;
        this.f29970y = 0;
        this.f29968w = 0;
        this.f29969x = 0;
        this.f29948ac.clear();
        this.f29942W.clear();
        ArrayList<LatLng> arrayList = this.f29922C;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private void m23196a(int i, int i2) {
        this.f29967v.record(i, i2, m23214a(false), this.f29948ac.isRouteChanged, m23273v(), this.f29902e.isArrivedPickupPoint());
    }

    /* renamed from: I */
    private void m23174I() {
        this.f29967v.doOmega(this.f29902e.getOrderId(), this.f29902e.getTripState(), this.f29902e.isArrivedPickupPoint(), this.f29902e.getCountryId(), m23273v());
        if (!this.f29902e.isReadOnly()) {
            this.f29942W.doOmegaReportCarMoveInfo();
        }
    }

    /* renamed from: a */
    private void m23201a(LatLng latLng, LatLng latLng2) {
        if (this.f29902e != null && this.f29942W != null) {
            if (TextUtils.isEmpty(this.f29902e.getOrderId())) {
                this.f29942W.trackOrderRouteParamError(1);
            } else if (TextUtils.isEmpty(String.valueOf(this.f29902e.getBizType()))) {
                this.f29942W.trackOrderRouteParamError(4);
            } else if (!LatLngUtils.locateCorrect(latLng)) {
                this.f29942W.trackOrderRouteParamError(2);
            } else if (!LatLngUtils.locateCorrect(latLng2)) {
                this.f29942W.trackOrderRouteParamError(3);
            }
        }
    }

    /* renamed from: J */
    private void m23175J() {
        int K = m23177K();
        boolean z = this.f29902e.getTripState() == 3;
        int i = this.f29952ag;
        if (i != K && z) {
            this.f29942W.trackAppLocationPermission(i, K);
        }
        this.f29952ag = K;
    }

    /* renamed from: K */
    private int m23177K() {
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
        m23166E();
        m23175J();
        this.f29963ar = true;
        if (m23160B() && (trafficEventsController = this.f29926G) != null) {
            trafficEventsController.start();
        }
    }

    public void pause() {
        TrafficEventsController trafficEventsController;
        super.pause();
        m23168F();
        m23174I();
        this.f29963ar = false;
        if (m23160B() && (trafficEventsController = this.f29926G) != null) {
            trafficEventsController.pause();
        }
    }

    public void leave() {
        super.leave();
        m23180L();
        m23174I();
        this.f29957al = 2;
        runImmediately();
        SctxDataCache sctxDataCache = this.f29948ac;
        if (sctxDataCache != null && sctxDataCache.orderState == 3) {
            m23232d();
        }
        IInertiaDelegate iInertiaDelegate = this.f29920A;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f29920A = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f29921B;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            this.f29942W.reportSctxUIError(115, this.f29902e.getOrderId(), this.f29902e.getLastOrderId());
        }
        if (!this.f29964as) {
            this.f29942W.reportSctxUIError(116, this.f29902e.getOrderId(), this.f29902e.getLastOrderId());
        }
        IMyLocationDelegate iMyLocationDelegate2 = this.f29921B;
        if (iMyLocationDelegate2 != null) {
            iMyLocationDelegate2.destroy();
            this.f29921B = null;
        }
        TrafficEventsController trafficEventsController = this.f29926G;
        if (trafficEventsController != null) {
            trafficEventsController.leave();
            this.f29926G = null;
        }
        ISctxViewDelegate iSctxViewDelegate = this.f29965t;
        if (iSctxViewDelegate != null) {
            iSctxViewDelegate.destroy();
            this.f29965t = null;
        }
        m23181M();
        this.f29939T = 0;
        m23168F();
        if (this.f29953ah != null) {
            try {
                this.f29899b.unregisterReceiver(this.f29953ah);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f29953ah = null;
        }
        if (this.f29951af != null) {
            DIDILocationManager.getInstance(this.f29899b).removeLocationUpdates(this.f29951af);
            this.f29951af = null;
        }
        if (this.f29898a != null && this.f29958am != null) {
            this.f29898a.removeOnLineClickListener(this.f29958am);
            this.f29958am = null;
        }
    }

    /* renamed from: L */
    private void m23180L() {
        if (getCarMarker() == null) {
            this.f29942W.reportSctxErrorCode("5", 1);
        }
        if ((m23282z() || this.f29902e.getTripState() == 4) && !hasLine()) {
            this.f29942W.reportSctxErrorCode("6", 1);
        }
    }

    public boolean hasLine() {
        TrafficLineDelegate trafficLineDelegate = this.f29936Q;
        return trafficLineDelegate != null && !CollectionUtil.isEmpty((Collection<?>) trafficLineDelegate.getLines());
    }

    /* renamed from: a */
    private void m23205a(TrafficLineDelegate trafficLineDelegate) {
        if (trafficLineDelegate != null) {
            trafficLineDelegate.remove();
        }
        TrafficEventsController trafficEventsController = this.f29926G;
        if (trafficEventsController != null) {
            trafficEventsController.removeTrafficEventMarkers();
        }
    }

    /* renamed from: M */
    private void m23181M() {
        m23205a(this.f29955aj);
        m23205a(this.f29936Q);
        this.f29955aj = null;
        this.f29936Q = null;
        this.f29939T = 0;
    }

    public void cancelPickupPointRecommend() {
        TrafficLineDelegate trafficLineDelegate = this.f29936Q;
        if (trafficLineDelegate != null) {
            trafficLineDelegate.highLight(true);
        }
        this.f29957al = 2;
        m23205a(this.f29955aj);
        this.f29955aj = null;
        runImmediately();
    }

    public void chooseLine(int i) {
        DLog.m10773d(f29917q, "chooseLine: " + i, new Object[0]);
        TrafficLineDelegate trafficLineDelegate = this.f29936Q;
        if (trafficLineDelegate != null && this.f29955aj != null) {
            if (i == 1) {
                trafficLineDelegate.highLight(true);
                m23206a(this.f29936Q, 1);
                this.f29955aj.highLight(false);
                m23206a(this.f29955aj, 2);
                if (this.f29901d != null) {
                    this.f29901d.selectedPickupPoint(this.f29902e.getPickupPoint());
                }
            } else if (i == 2) {
                trafficLineDelegate.highLight(false);
                m23206a(this.f29936Q, 1);
                this.f29955aj.highLight(true);
                m23206a(this.f29955aj, 2);
                SecRouteInfo secRouteInfo = this.f29956ak;
                if (secRouteInfo != null && secRouteInfo.point != null) {
                    PickupPoint pickupPoint = this.f29956ak.point;
                    if (this.f29901d != null) {
                        this.f29901d.selectedPickupPoint(new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m23206a(TrafficLineDelegate trafficLineDelegate, int i) {
        if (trafficLineDelegate != null) {
            List<Line> lines = trafficLineDelegate.getLines();
            if (!CollectionUtil.isEmpty((Collection<?>) lines)) {
                for (Line zIndex : lines) {
                    zIndex.setZIndex(i);
                }
            }
        }
    }

    public void showRecommendPickupPoint(boolean z) {
        this.f29959an = z;
    }

    public void handleTriggerEventDialog(TrafficEventModel trafficEventModel, int i) {
        TrafficEventsController trafficEventsController = this.f29926G;
        if (trafficEventsController != null) {
            trafficEventsController.handleTriggerVerifyDialogClick(trafficEventModel, i);
        }
    }
}
