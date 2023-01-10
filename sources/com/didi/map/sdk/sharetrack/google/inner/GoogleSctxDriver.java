package com.didi.map.sdk.sharetrack.google.inner;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.car.MyLocation;
import com.didi.map.sdk.nav.car.onCarAnimationCancelListener;
import com.didi.map.sdk.nav.car.onCarAnimationListener;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.InertiaEngine;
import com.didi.map.sdk.nav.inertia.OnLocationMatched;
import com.didi.map.sdk.nav.inertia.SctxInertiaSuspiciousStatus;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.line.MultiLine;
import com.didi.map.sdk.sharetrack.callback.IBusinessEventCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.GuideRouteLine;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.RouteEvent;
import com.didi.map.sdk.sharetrack.entity.StreetViewInfo;
import com.didi.map.sdk.sharetrack.entity.WayPoint;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.google.inner.handler.PushEdaHandler;
import com.didi.map.sdk.sharetrack.google.inner.model.RouteUnreachableHandler;
import com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager;
import com.didi.map.sdk.sharetrack.google.inner.state.DriverStateChecker;
import com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.C11013utils;
import com.didi.map.sdk.sharetrack.google.inner.utils.LocateUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.OraErrorCodeUtil;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.routesearchsdk.CallFrom;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GoogleSctxDriver {

    /* renamed from: T */
    private static final int f31198T = 1;

    /* renamed from: a */
    private static final String f31199a = "GoogleSctxDriver";

    /* renamed from: b */
    private static final String f31200b = "33333";

    /* renamed from: c */
    private static final String f31201c = "0";

    /* renamed from: d */
    private static final int f31202d = 1000;

    /* renamed from: e */
    private static final double f31203e = 500.0d;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public FetcherManager f31204A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IInertiaDelegate f31205B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IMyLocationDelegate f31206C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ISearchRouteCallback f31207D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ISearchOffRouteCallback f31208E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public INavigationInnerCallback f31209F;

    /* renamed from: G */
    private IBusinessEventCallback f31210G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f31211H = 0;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AnimateNode f31212I;

    /* renamed from: J */
    private LatLng f31213J;

    /* renamed from: K */
    private LineOptions f31214K;

    /* renamed from: L */
    private LineOptions f31215L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public DMKEventPoint f31216M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public DMKEventPoint f31217N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public List<DMKEventPoint> f31218O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f31219P;

    /* renamed from: Q */
    private int f31220Q = 0;

    /* renamed from: R */
    private int f31221R = 0;

    /* renamed from: S */
    private long f31222S = 0;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public String f31223U = "";
    /* access modifiers changed from: private */

    /* renamed from: V */
    public int f31224V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public DriverStateChecker f31225W;

    /* renamed from: X */
    private double f31226X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public RouteGuidanceGPSPoint f31227Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public RouteGuidanceGPSPoint f31228Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public StreetViewInfo f31229aa;

    /* renamed from: ab */
    private RouteUnreachableHandler f31230ab;

    /* renamed from: ac */
    private RouteEvent f31231ac;

    /* renamed from: ad */
    private GuideRouteLine f31232ad;

    /* renamed from: ae */
    private List<OrderPoint> f31233ae;

    /* renamed from: af */
    private PushEdaHandler f31234af;

    /* renamed from: ag */
    private CallFrom f31235ag;

    /* renamed from: ah */
    private LatLng f31236ah;

    /* renamed from: ai */
    private int f31237ai = 0;

    /* renamed from: aj */
    private onCarAnimationListener f31238aj = new onCarAnimationListener() {
        public void onErase(int i, int i2, LatLng latLng) {
        }

        public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
            if (GoogleSctxDriver.this.f31257q != null) {
                GoogleSctxDriver.this.f31257q.updateFirstLineAll(list, list2);
            }
        }

        public void onErase(List<LatLng> list) {
            if (GoogleSctxDriver.this.f31257q != null && list != null && list.size() > 1) {
                GoogleSctxDriver.this.f31257q.updateFirstLineEX(list);
            }
        }
    };

    /* renamed from: ak */
    private OnLocationMatched f31239ak = new OnLocationMatched() {
        public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
        }

        public /* synthetic */ void onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus sctxInertiaSuspiciousStatus) {
            OnLocationMatched.CC.$default$onSctxSuspiciousJumpError(this, sctxInertiaSuspiciousStatus);
        }

        public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
            boolean z2;
            if (latLng == null || GoogleSctxDriver.this.f31206C == null || !GoogleSctxDriver.this.f31259s || GoogleSctxDriver.this.m23911i() || i >= GoogleSctxDriver.this.f31256p.size()) {
                DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute return at the beginning", new Object[0]);
            } else if (GoogleSctxDriver.this.f31218O == null) {
                DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute return because mEventPointList is null", new Object[0]);
            } else {
                if (!GoogleSctxDriver.this.f31218O.contains(dMKEventPoint)) {
                    GoogleSctxDriver.this.f31218O.add(dMKEventPoint);
                }
                DMKEventPoint unused = GoogleSctxDriver.this.f31216M = dMKEventPoint;
                if (GoogleSctxDriver.this.f31216M != null) {
                    DLog.m23962d(GoogleSctxDriver.f31199a, "onMatched mEventPoint geoIndex = " + GoogleSctxDriver.this.f31216M.geoIndex, new Object[0]);
                }
                if (!(GoogleSctxDriver.this.f31217N == null || GoogleSctxDriver.this.f31229aa == null || GoogleSctxDriver.this.f31205B == null)) {
                    int eventPointSize = GoogleSctxDriver.this.f31205B.getEventPointSize();
                    GoogleSctxDriver.this.f31229aa.isInTheLastEvent = i >= GoogleSctxDriver.this.f31217N.geoIndex;
                    DLog.m23962d(GoogleSctxDriver.f31199a, "StreetView event size is: " + eventPointSize + " segmentIndex: " + i + "last event geo index:" + GoogleSctxDriver.this.f31217N.geoIndex + " point:" + latLng.toString(), new Object[0]);
                }
                if (GoogleSctxDriver.this.f31225W != null) {
                    GoogleSctxDriver.this.f31225W.onMatched(latLng, i);
                }
                if (i == -1) {
                    GoogleSctxDriver.m23916l(GoogleSctxDriver.this);
                    DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute fail count = %d", Integer.valueOf(GoogleSctxDriver.this.f31211H));
                    if (GoogleSctxDriver.this.f31211H > 1) {
                        z2 = false;
                    } else {
                        return;
                    }
                } else {
                    DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute success. segmentIndex = " + i, new Object[0]);
                    if (GoogleSctxDriver.this.f31212I != null && GoogleSctxDriver.this.f31212I.index >= 0) {
                        if (i < GoogleSctxDriver.this.f31212I.index) {
                            DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute success return segmentIndex < last", new Object[0]);
                            return;
                        } else if (i == GoogleSctxDriver.this.f31212I.index && i2 <= GoogleSctxDriver.this.f31212I.offSet) {
                            DLog.m23962d(GoogleSctxDriver.f31199a, "onMatchRoute success return segmentIndex == last & shapeOffSet< last", new Object[0]);
                            return;
                        }
                    }
                    if (GoogleSctxDriver.this.f31204A != null && GoogleSctxDriver.this.f31219P) {
                        GoogleSctxDriver.this.f31204A.startEta();
                    }
                    GoogleSctxDriver googleSctxDriver = GoogleSctxDriver.this;
                    int unused2 = googleSctxDriver.f31265y = googleSctxDriver.getEda(latLng, i, i2);
                    if (GoogleSctxDriver.this.f31229aa != null) {
                        GoogleSctxDriver.this.f31229aa.realEDA = GoogleSctxDriver.this.f31265y;
                    }
                    GoogleSctxDriver.this.m23896c();
                    if (!(GoogleSctxDriver.this.f31205B == null || GoogleSctxDriver.this.f31205B.getLastMatchGPSPoint() == null)) {
                        GoogleSctxDriver googleSctxDriver2 = GoogleSctxDriver.this;
                        RouteGuidanceGPSPoint unused3 = googleSctxDriver2.f31227Y = googleSctxDriver2.f31205B.getLastMatchGPSPoint().originMatchPoint;
                        GoogleSctxDriver googleSctxDriver3 = GoogleSctxDriver.this;
                        RouteGuidanceGPSPoint unused4 = googleSctxDriver3.f31228Z = googleSctxDriver3.f31205B.getLastMatchGPSPoint();
                        if (GoogleSctxDriver.this.f31209F != null) {
                            GoogleSctxDriver.this.f31209F.onRoadSnappedLocationChanged(LocateUtils.convertToGpsLocation(GoogleSctxDriver.this.f31205B.getLastMatchGPSPoint()));
                        }
                    }
                    z2 = GoogleSctxDriver.this.f31211H <= 1 && i >= 0;
                    int unused5 = GoogleSctxDriver.this.f31211H = 0;
                }
                if (!(GoogleSctxDriver.this.f31212I == null || GoogleSctxDriver.this.f31218O.size() <= 1 || GoogleSctxDriver.this.f31218O.get(0) == null)) {
                    int i5 = ((DMKEventPoint) GoogleSctxDriver.this.f31218O.get(0)).geoIndex;
                    if (GoogleSctxDriver.this.f31212I.index >= i5) {
                        GoogleSctxDriver.this.f31218O.remove(0);
                    } else if (i > i5 && GoogleSctxDriver.this.f31216M.geoIndex > i5) {
                        GoogleSctxDriver googleSctxDriver4 = GoogleSctxDriver.this;
                        DMKEventPoint unused6 = googleSctxDriver4.f31216M = (DMKEventPoint) googleSctxDriver4.f31218O.get(0);
                    }
                }
                AnimateNode animateNode = new AnimateNode(latLng, i, i2, z2);
                if (i > 0) {
                    AnimateNode unused7 = GoogleSctxDriver.this.f31212I = animateNode;
                }
                if (GoogleSctxDriver.this.f31206C != null && GoogleSctxDriver.this.f31248h != null) {
                    GoogleSctxDriver.this.f31206C.animateTo(animateNode, GoogleSctxDriver.this.f31216M);
                }
            }
        }

        public void onOffRoute() {
            GoogleSctxDriver.this.m23893b();
        }
    };

    /* renamed from: al */
    private ISearchRouteCallback f31240al = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerEtaCallback onBeginToSearch()", new Object[0]);
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            NaviRoute naviRoute;
            DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerEtaCallback onFinishToSearch()", new Object[0]);
            if (GoogleSctxDriver.this.f31246f) {
                if (str.compareTo(GoogleSctxDriver.f31200b) == 0 && GoogleSctxDriver.this.f31209F != null) {
                    GoogleSctxDriver.this.f31209F.onViaPointExpired((List<LatLng>) null, 0);
                }
                if (arrayList != null && arrayList.size() > 0 && (naviRoute = arrayList.get(0)) != null) {
                    DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerEtaCallback newRoute eta" + naviRoute.getDistanceInfo() + "," + naviRoute.getTime(), new Object[0]);
                    int unused = GoogleSctxDriver.this.f31266z = naviRoute.getTime();
                    if (GoogleSctxDriver.this.f31209F != null) {
                        GoogleSctxDriver.this.f31209F.onReceiveETA(GoogleSctxDriver.this.f31266z);
                    }
                    GoogleSctxDriver googleSctxDriver = GoogleSctxDriver.this;
                    int unused2 = googleSctxDriver.f31224V = googleSctxDriver.f31266z;
                    String unused3 = GoogleSctxDriver.this.f31223U = naviRoute.getRouteId();
                    GoogleSctxDriver.this.m23896c();
                }
            }
        }
    };

    /* renamed from: am */
    private ISearchRouteCallback f31241am = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (GoogleSctxDriver.this.f31246f) {
                DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onBeginToSearch()  vr ", new Object[0]);
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            if (!GoogleSctxDriver.this.f31246f) {
                DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() ok  vr, return at the entry", new Object[0]);
                return;
            }
            if (str.compareTo(GoogleSctxDriver.f31200b) == 0 && GoogleSctxDriver.this.f31209F != null) {
                GoogleSctxDriver.this.f31209F.onViaPointExpired((List<LatLng>) null, 0);
            }
            DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() ok  entry", new Object[0]);
            if (!GoogleSctxDriver.this.m23889a(arrayList, true)) {
                DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onFinishToSearch() fail  vr ", new Object[0]);
                if ((!TextUtils.isEmpty(str) && (str == null || str.equals("0") || str.compareTo(GoogleSctxDriver.f31200b) == 0)) || !GoogleSctxDriver.this.m23888a(str)) {
                    return;
                }
                if (GoogleSctxDriver.this.f31251k < GoogleSctxDriver.this.f31250j) {
                    DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onFinishToSearch()  retry ", new Object[0]);
                    GoogleSctxDriver.m23930z(GoogleSctxDriver.this);
                    if (GoogleSctxDriver.this.f31204A != null) {
                        GoogleSctxDriver.this.f31204A.offRouteTryAgain();
                        return;
                    }
                    return;
                }
                int unused = GoogleSctxDriver.this.f31251k = 0;
                if (GoogleSctxDriver.this.f31208E != null) {
                    GoogleSctxDriver.this.f31208E.onRetryFail();
                }
                DLog.m23962d(GoogleSctxDriver.f31199a, "mInnerOffRouteSearchRouteCallback onFinishToSearch()  retry abort ", new Object[0]);
                return;
            }
            GoogleSctxDriver.this.m23905f();
            if (GoogleSctxDriver.this.f31208E != null) {
                GoogleSctxDriver.this.f31208E.onSuccess(arrayList);
            }
        }
    };

    /* renamed from: an */
    private ISearchRouteCallback f31242an = new ISearchRouteCallback() {
        public void onBeginToSearch() {
            if (GoogleSctxDriver.this.f31207D != null) {
                GoogleSctxDriver.this.f31207D.onBeginToSearch();
                DLog.m23962d(GoogleSctxDriver.f31199a, "ISearchRouteCallback onBeginToSearch() ", new Object[0]);
            }
        }

        public void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str) {
            DLog.m23962d(GoogleSctxDriver.f31199a, "ISearchRouteCallback onFinishToSearch success", new Object[0]);
            if (GoogleSctxDriver.this.f31246f) {
                if (str.compareTo(GoogleSctxDriver.f31200b) == 0 && GoogleSctxDriver.this.f31209F != null) {
                    GoogleSctxDriver.this.f31209F.onViaPointExpired((List<LatLng>) null, 0);
                }
                if (GoogleSctxDriver.this.m23889a(arrayList, false)) {
                    DLog.m23962d(GoogleSctxDriver.f31199a, "ISearchRouteCallback route OK,  pickup point mPreOrderStage= " + PlatInfo.getInstance().getOrderStage(), new Object[0]);
                    if (GoogleSctxDriver.this.f31207D != null) {
                        GoogleSctxDriver.this.f31207D.onFinishToSearch(arrayList, str);
                        DLog.m23962d(GoogleSctxDriver.f31199a, "ISearchRouteCallback onFinishToSearch() ok  ", new Object[0]);
                        return;
                    }
                    return;
                }
                if (GoogleSctxDriver.this.f31207D != null) {
                    GoogleSctxDriver.this.f31207D.onFinishToSearch((ArrayList<NaviRoute>) null, str);
                    DLog.m23962d(GoogleSctxDriver.f31199a, "ISearchRouteCallback onFinishToSearch() fail ", new Object[0]);
                }
                if (!GoogleSctxDriver.this.m23888a(str)) {
                    return;
                }
                if (GoogleSctxDriver.this.f31251k < GoogleSctxDriver.this.f31250j) {
                    GoogleSctxDriver.m23930z(GoogleSctxDriver.this);
                    if (GoogleSctxDriver.this.f31204A != null) {
                        GoogleSctxDriver.this.f31204A.updateRoute(3);
                        return;
                    }
                    return;
                }
                int unused = GoogleSctxDriver.this.f31251k = 0;
                if (GoogleSctxDriver.this.f31204A != null) {
                    GoogleSctxDriver.this.f31204A.updateRoute(60);
                }
            }
        }
    };

    /* renamed from: ao */
    private int f31243ao = 0;

    /* renamed from: ap */
    private List<GpsLocation> f31244ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public CameraMode f31245aq = CameraMode.NORTH_UP;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f31246f = false;

    /* renamed from: g */
    private Context f31247g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map f31248h;

    /* renamed from: i */
    private OrderInfo f31249i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f31250j = 3;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f31251k = 0;

    /* renamed from: l */
    private GpsLocation f31252l;

    /* renamed from: m */
    private GpsLocation f31253m;

    /* renamed from: n */
    private LatLng f31254n;

    /* renamed from: o */
    private NaviRoute f31255o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List<LatLng> f31256p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MultiLine f31257q;

    /* renamed from: r */
    private boolean f31258r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f31259s;

    /* renamed from: t */
    private BitmapDescriptor f31260t;

    /* renamed from: u */
    private float f31261u;

    /* renamed from: v */
    private boolean f31262v = false;

    /* renamed from: w */
    private boolean f31263w = false;

    /* renamed from: x */
    private boolean f31264x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f31265y = 0;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f31266z = 0;

    /* renamed from: a */
    private int m23873a(int i) {
        if (1 != i) {
            if (2 == i) {
                return 1;
            }
            if (4 == i) {
                return 2;
            }
        }
        return 0;
    }

    public int getRemainStraightDistance() {
        return 0;
    }

    /* renamed from: l */
    static /* synthetic */ int m23916l(GoogleSctxDriver googleSctxDriver) {
        int i = googleSctxDriver.f31211H;
        googleSctxDriver.f31211H = i + 1;
        return i;
    }

    /* renamed from: z */
    static /* synthetic */ int m23930z(GoogleSctxDriver googleSctxDriver) {
        int i = googleSctxDriver.f31251k;
        googleSctxDriver.f31251k = i + 1;
        return i;
    }

    /* renamed from: a */
    private Marker m23875a(int i, LatLng latLng, float f, float f2, float f3, int i2) {
        Context context;
        BitmapDescriptor fromResource;
        if (this.f31248h == null || (context = this.f31247g) == null || (fromResource = BitmapDescriptorFactory.fromResource(context, i)) == null) {
            return null;
        }
        MarkerOptions rotation = new MarkerOptions().anchor(f2, f3).icon(fromResource).position(new LatLng(latLng.latitude, latLng.longitude)).rotation(f);
        rotation.flat(true);
        rotation.zIndex(i2);
        try {
            return this.f31248h.addMarker(rotation);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m23886a() {
        OrderInfo orderInfo = this.f31249i;
        if (orderInfo == null) {
            return false;
        }
        if (orderInfo.getOrderStage() == 1 || this.f31249i.getOrderStage() == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23893b() {
        DLog.m23962d(f31199a, "onOffRouteInCommon", new Object[0]);
        if (!this.f31219P) {
            DLog.m23962d(f31199a, "onOffRouteInCommon return because mRequestOra = false", new Object[0]);
            return;
        }
        m23885a(false);
        this.f31218O.clear();
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager == null || !fetcherManager.offRouteReq()) {
            DLog.m23962d(f31199a, "onOffRoute require busy", new Object[0]);
        } else {
            DLog.m23962d(f31199a, "onOffRoute send require ok", new Object[0]);
            AnimateNode animateNode = this.f31212I;
            if (animateNode != null) {
                this.f31213J = animateNode.latLng;
            }
            if (this.f31252l != null) {
                GpsLocation gpsLocation = new GpsLocation();
                this.f31253m = gpsLocation;
                gpsLocation.latitude = this.f31252l.latitude;
                this.f31253m.longitude = this.f31252l.longitude;
                this.f31253m.altitude = this.f31252l.altitude;
                this.f31253m.accuracy = this.f31252l.accuracy;
                this.f31253m.direction = this.f31252l.direction;
                this.f31253m.velocity = this.f31252l.velocity;
                this.f31253m.time = this.f31252l.time;
                this.f31253m.provider = this.f31252l.provider;
                this.f31253m.isCache = this.f31252l.isCache;
                this.f31253m.localTime = this.f31252l.localTime;
                this.f31253m.source = this.f31252l.source;
                m23915k();
            }
        }
        ISearchOffRouteCallback iSearchOffRouteCallback = this.f31208E;
        if (iSearchOffRouteCallback != null) {
            iSearchOffRouteCallback.onOffRoute();
        }
        INavigationInnerCallback iNavigationInnerCallback = this.f31209F;
        if (iNavigationInnerCallback != null) {
            iNavigationInnerCallback.onOffRoute();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        r3 = r10.getWayPoints();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m23889a(java.util.ArrayList<com.didi.map.sdk.sharetrack.entity.NaviRoute> r10, final boolean r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x016c
            int r1 = r10.size()
            if (r1 != 0) goto L_0x000b
            goto L_0x016c
        L_0x000b:
            java.util.List<com.map.sdk.nav.libc.common.DMKEventPoint> r1 = r9.f31218O
            r1.clear()
            java.lang.Object r10 = r10.get(r0)
            com.didi.map.sdk.sharetrack.entity.NaviRoute r10 = (com.didi.map.sdk.sharetrack.entity.NaviRoute) r10
            if (r10 == 0) goto L_0x016c
            java.util.List r1 = r10.getRoutePoints()
            if (r1 == 0) goto L_0x016c
            java.util.List r1 = r10.getRoutePoints()
            int r1 = r1.size()
            r2 = 1
            if (r1 <= r2) goto L_0x016c
            r9.f31255o = r10
            if (r11 != 0) goto L_0x0036
            com.didi.map.sdk.sharetrack.external.GoogleRouteOptManager r1 = com.didi.map.sdk.sharetrack.external.GoogleRouteOptManager.getInstance()
            com.didi.map.sdk.sharetrack.entity.NaviRoute r3 = r9.f31255o
            r1.updateRouteOpt(r3)
        L_0x0036:
            com.didi.map.sdk.sharetrack.entity.RouteEvent r1 = r9.f31231ac
            com.didi.map.sdk.sharetrack.entity.NaviRoute r3 = r9.f31255o
            r1.updateRoute(r3)
            java.util.List r1 = r10.getRoutePoints()
            r9.f31256p = r1
            if (r1 == 0) goto L_0x005a
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x005a
            java.util.List<com.didi.common.map.model.LatLng> r1 = r9.f31256p
            int r3 = r1.size()
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1
            r9.f31236ah = r1
        L_0x005a:
            r1 = 0
            r9.f31212I = r1
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r3 = r9.f31204A
            if (r3 == 0) goto L_0x0075
            r3.setNaviRoute(r10)
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r3 = r9.f31204A
            java.lang.String r4 = r10.getRouteId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            long r4 = r4.longValue()
            r3.setRouteId(r4)
        L_0x0075:
            com.didi.map.sdk.nav.line.MultiLine r3 = r9.f31257q
            r4 = -1
            if (r3 == 0) goto L_0x008b
            java.util.List r3 = r10.getWayPoints()
            if (r3 == 0) goto L_0x008b
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x008b
            int r3 = r10.getDstRouteGeoIndex()
            goto L_0x008c
        L_0x008b:
            r3 = -1
        L_0x008c:
            com.didi.common.map.Map r5 = r9.f31248h
            java.lang.String r6 = "GoogleSctxDriver"
            if (r5 == 0) goto L_0x00ca
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f31257q
            if (r5 == 0) goto L_0x00ca
            com.didi.common.map.model.LineOptions r7 = r9.f31214K
            com.didi.common.map.model.LineOptions r8 = r9.f31215L
            r5.setOptions(r7, r8)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f31257q
            java.util.List r7 = r10.getRoutePoints()
            r5.setPoints(r7)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f31257q
            boolean r7 = r9.f31258r
            r5.setVisible(r7)
            com.didi.map.sdk.nav.line.MultiLine r5 = r9.f31257q
            r5.init(r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "onRecvNewRoute mLineVisible= "
            r5.append(r7)
            boolean r7 = r9.f31258r
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            com.didi.map.sdk.sharetrack.logger.DLog.m23962d(r6, r5, r7)
        L_0x00ca:
            r9.m23883a((com.didi.map.sdk.sharetrack.entity.NaviRoute) r10)
            r9.m23909h()
            r9.f31211H = r0
            com.didi.common.map.Map r5 = r9.f31248h
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.IMyLocationDelegate r5 = r9.f31206C
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.CarMarker r5 = r5.getCarMarker()
            if (r5 == 0) goto L_0x00eb
            com.didi.map.sdk.nav.car.IMyLocationDelegate r1 = r9.f31206C
            com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver$6 r4 = new com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver$6
            r4.<init>(r11, r10, r3)
            r1.animateCancel(r4)
            goto L_0x010c
        L_0x00eb:
            java.util.List r5 = r10.getRoutePoints()
            if (r3 <= r4) goto L_0x0100
            com.didi.map.sdk.nav.inertia.IInertiaDelegate r4 = r9.f31205B
            if (r4 == 0) goto L_0x0109
            int r3 = r3 + r2
            java.util.List r3 = r5.subList(r0, r3)
            r4.setRoutePoints(r3)
            r9.f31228Z = r1
            goto L_0x0109
        L_0x0100:
            com.didi.map.sdk.nav.inertia.IInertiaDelegate r3 = r9.f31205B
            if (r3 == 0) goto L_0x0109
            r3.setRoutePoints(r5)
            r9.f31228Z = r1
        L_0x0109:
            r9.m23913j()
        L_0x010c:
            java.lang.String r1 = r10.getDistanceInfo()     // Catch:{ Exception -> 0x011b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x011b }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x011b }
            r9.f31265y = r1     // Catch:{ Exception -> 0x011b }
            goto L_0x011f
        L_0x011b:
            r1 = 100
            r9.f31265y = r1
        L_0x011f:
            int r10 = r10.getTime()
            r9.f31266z = r10
            com.didi.map.sdk.sharetrack.entity.StreetViewInfo r10 = r9.f31229aa
            if (r10 == 0) goto L_0x013e
            int r1 = r9.f31265y
            r10.realEDA = r1
            com.didi.map.sdk.sharetrack.entity.StreetViewInfo r10 = r9.f31229aa
            java.util.List<com.didi.common.map.model.LatLng> r1 = r9.f31256p
            int r3 = r1.size()
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1
            r10.mLastRoutePoint = r1
        L_0x013e:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            int r1 = r9.f31266z
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10[r0] = r1
            int r0 = r9.f31265y
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "onRecvNewRoute init: eta= %d, eda = %d"
            com.didi.map.sdk.sharetrack.logger.DLog.m23962d(r6, r0, r10)
            r9.m23896c()
            com.didi.map.sdk.sharetrack.callback.INavigationInnerCallback r10 = r9.f31209F
            if (r10 == 0) goto L_0x0164
            com.didi.map.sdk.sharetrack.entity.NaviRoute r0 = r9.f31255o
            if (r0 == 0) goto L_0x0164
            r10.onRouteUpdate(r0, r11)
        L_0x0164:
            com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager r10 = r9.f31204A
            if (r10 == 0) goto L_0x016b
            r10.startEta()
        L_0x016b:
            return r2
        L_0x016c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.GoogleSctxDriver.m23889a(java.util.ArrayList, boolean):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m23896c() {
        INavigationInnerCallback iNavigationInnerCallback = this.f31209F;
        if (iNavigationInnerCallback != null) {
            iNavigationInnerCallback.onRemainingTimeOrDistanceChanged();
        }
        m23899d();
        m23903e();
    }

    /* renamed from: d */
    private void m23899d() {
        RouteEvent routeEvent;
        if (this.f31230ab != null && (routeEvent = this.f31231ac) != null) {
            routeEvent.updateEdaEta(this.f31265y, this.f31266z);
            if (this.f31230ab.dispatchEvent(this.f31231ac) && this.f31210G != null) {
                this.f31210G.onRouteUnreachableTts(this.f31265y, this.f31230ab.getCurUnreachableDis());
            }
        }
    }

    /* renamed from: e */
    private void m23903e() {
        PushEdaHandler pushEdaHandler;
        OrderInfo orderInfo = this.f31249i;
        if (orderInfo != null && orderInfo.getOrderStage() == 1 && (pushEdaHandler = this.f31234af) != null && pushEdaHandler.dispatchEvent(this.f31265y)) {
            this.f31204A.pushEdaToServer(this.f31265y);
        }
    }

    public int getEda(LatLng latLng, int i, int i2) {
        int i3;
        int i4;
        if (latLng == null || this.f31252l == null) {
            return 0;
        }
        if (this.f31205B != null) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.point = geoPoint;
            routeGuidanceGPSPoint.accuracy = this.f31252l.accuracy;
            routeGuidanceGPSPoint.segmentIndex = i;
            routeGuidanceGPSPoint.heading = this.f31252l.direction;
            routeGuidanceGPSPoint.velocity = this.f31252l.velocity;
            routeGuidanceGPSPoint.timestamp = this.f31252l.time;
            routeGuidanceGPSPoint.source = this.f31252l.source;
            routeGuidanceGPSPoint.shapeOffSet = i2;
            i3 = this.f31205B.distanceLeft(routeGuidanceGPSPoint);
            DLog.m23962d(f31199a, "eda from NavBaseLib = " + i3, new Object[0]);
        } else {
            i3 = 0;
        }
        NaviRoute naviRoute = this.f31255o;
        if (naviRoute != null) {
            i4 = Integer.parseInt(naviRoute.getDistanceInfo());
            DLog.m23962d(f31199a, "eda from Ora = " + i4, new Object[0]);
            if (i3 <= i4) {
                return i3;
            }
        } else if (this.f31256p == null) {
            return i3;
        } else {
            DLog.m23962d(f31199a, "eda from outside = " + this.f31220Q, new Object[0]);
            i4 = this.f31220Q;
            if (i3 <= i4) {
                return i3;
            }
        }
        return i4;
    }

    public void mockOffRoute() {
        OnLocationMatched onLocationMatched = this.f31239ak;
        if (onLocationMatched != null) {
            onLocationMatched.onOffRoute();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23905f() {
        double d;
        String str;
        String str2;
        GpsLocation gpsLocation = this.f31253m;
        if (gpsLocation == null) {
            DLog.m23962d(f31199a, "doOffRouteDistanceTrace  mOffRouteGps is null ", new Object[0]);
            return;
        }
        if (this.f31213J != null) {
            d = DDSphericalUtil.computeDistanceBetween(new LatLng(gpsLocation.latitude, this.f31253m.longitude), this.f31213J);
        } else {
            d = -999.0d;
            DLog.m23962d(f31199a, "doOffRouteDistanceTrace matched point is null, set distance -999", new Object[0]);
        }
        NaviRoute naviRoute = this.f31255o;
        if (naviRoute != null) {
            str = naviRoute.getRouteId();
        } else {
            str = this.f31256p != null ? String.valueOf(this.f31222S) : "unknown";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, str);
        hashMap.put("distance", Double.valueOf(d));
        hashMap.put("lat", Double.valueOf(this.f31253m.latitude));
        hashMap.put("lng", Double.valueOf(this.f31253m.longitude));
        hashMap.put(ServerParam.PARAM_ACCURACY, Integer.valueOf(this.f31253m.accuracy));
        hashMap.put("head", Float.valueOf(this.f31253m.direction));
        hashMap.put("speed", Float.valueOf(this.f31253m.velocity));
        hashMap.put("source", Integer.valueOf(this.f31253m.source));
        hashMap.put("driver_phone", PlatInfo.getInstance().getDriverPhoneNumber());
        hashMap.put("travelid", PlatInfo.getInstance().getTraverId());
        OrderInfo orderInfo = this.f31249i;
        if (orderInfo != null) {
            hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(m23873a(orderInfo.getOrderStage())));
            hashMap.put("order_id", this.f31249i.getOrderId());
        }
        String str3 = ",  accuracy = " + this.f31253m.accuracy + ", head=" + this.f31253m.direction + "speed = " + this.f31253m.velocity + this.f31253m.source;
        LatLng latLng = this.f31213J;
        if (latLng == null) {
            str2 = "mOffRouteMatchPoint is null";
        } else {
            str2 = latLng.toString();
        }
        DLog.m23962d(f31199a, " doOffRouteDistanceTrace: route_id=" + str + ", distance=" + d + ", matchPoint=" + str2 + ", [mOffRouteGps] lat=" + this.f31253m.latitude + ", lng=" + this.f31253m.longitude + str3, new Object[0]);
        GlobalDriverOmega.trackEvent("gd_raw_distance_res", hashMap);
        this.f31213J = null;
        this.f31253m = null;
    }

    public GoogleSctxDriver(Context context) {
        this.f31247g = context;
        FetcherManager fetcherManager = new FetcherManager(context);
        this.f31204A = fetcherManager;
        fetcherManager.setInnerEtaCallback(this.f31240al);
        this.f31204A.setInnerOffRouteSearchRouteCallback(this.f31241am);
        this.f31204A.setInnerSearchRouteCallback(this.f31242an);
        NetUtils.init(context);
        this.f31219P = true;
        this.f31218O = new ArrayList();
        this.f31226X = -1.0d;
        this.f31229aa = new StreetViewInfo();
        this.f31230ab = new RouteUnreachableHandler();
        this.f31231ac = new RouteEvent();
        this.f31234af = new PushEdaHandler();
    }

    public void setDiDiMap(Map map) {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
        }
        this.f31248h = map;
        if (map == null) {
            MultiLine multiLine = this.f31257q;
            if (multiLine != null) {
                multiLine.remove();
                this.f31257q = null;
            }
        } else if (this.f31257q == null) {
            this.f31257q = new MultiLine(map);
        }
        IMyLocationDelegate create = MyLocation.create(this.f31248h);
        this.f31206C = create;
        create.setAnimationInterval(1000);
        this.f31206C.setIsBackground(false);
        this.f31206C.setCarAnimationListener(this.f31238aj);
        double d = this.f31226X;
        if (d > 0.0d) {
            this.f31206C.setCarHeadMaxMapLevel(d);
        }
        GuideRouteLine guideRouteLine = this.f31232ad;
        if (guideRouteLine != null) {
            guideRouteLine.remove();
            this.f31232ad = null;
        }
        Map map2 = this.f31248h;
        if (map2 != null) {
            this.f31232ad = new GuideRouteLine(map2);
        }
    }

    /* renamed from: g */
    private void m23907g() {
        IMyLocationDelegate iMyLocationDelegate;
        if (this.f31248h != null && (iMyLocationDelegate = this.f31206C) != null && iMyLocationDelegate.getCarMarker() == null && this.f31260t != null && this.f31252l != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.visible(this.f31259s);
            markerOptions.icon(this.f31260t);
            markerOptions.draggable(false);
            markerOptions.zIndex((int) this.f31261u);
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.flat(true);
            markerOptions.position(new LatLng(this.f31252l.latitude, this.f31252l.longitude));
            markerOptions.rotation(this.f31252l.direction);
            this.f31206C.setCarMarkerOptions("sharetrack", markerOptions);
        }
    }

    /* renamed from: h */
    private void m23909h() {
        if (this.f31205B == null) {
            InertiaEngine create = InertiaEngine.create(this.f31247g);
            this.f31205B = create;
            create.setOnLocationMatched(this.f31239ak);
            this.f31205B.setRequestIntervalInMills(1000);
            this.f31205B.setPredictionApolloParams(ApolloUtils.getSctxPredictionApolloParams());
            OrderInfo orderInfo = this.f31249i;
            if (orderInfo != null) {
                this.f31205B.setOrderInfo(orderInfo.getOrderId(), m23873a(this.f31249i.getOrderStage()));
            }
            DLog.m23962d(f31199a, "mGoogleNav: init", new Object[0]);
        }
    }

    public void setIsSctx(boolean z) {
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setIsSctx(z);
        }
    }

    /* renamed from: a */
    private void m23885a(boolean z) {
        DLog.m23962d(f31199a, "stopReqEta", new Object[0]);
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.CancelEta();
        }
        if (z) {
            IInertiaDelegate iInertiaDelegate = this.f31205B;
            if (iInertiaDelegate != null) {
                iInertiaDelegate.setRoutePoints((List<LatLng>) null);
                this.f31228Z = null;
            }
            IMyLocationDelegate iMyLocationDelegate = this.f31206C;
            if (iMyLocationDelegate != null) {
                iMyLocationDelegate.setNavRoutePoints((List<LatLng>) null, false);
            }
        }
    }

    public void setDestination(LatLng latLng) {
        this.f31254n = latLng;
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setDest(latLng);
        }
        RouteEvent routeEvent = this.f31231ac;
        if (routeEvent != null) {
            routeEvent.setPickUpPoint(latLng);
        }
    }

    public boolean isSctxStarted() {
        return this.f31246f;
    }

    public void start() {
        if (!this.f31246f) {
            this.f31246f = true;
            Map map = this.f31248h;
            if (map != null) {
                MultiLine multiLine = new MultiLine(map);
                this.f31257q = multiLine;
                multiLine.setOptions(this.f31214K, this.f31215L);
            }
            FetcherManager fetcherManager = this.f31204A;
            if (fetcherManager != null) {
                fetcherManager.initRoute();
            }
        }
    }

    public void stopNav() {
        this.f31246f = false;
        this.f31223U = "";
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setShouldShowRoute(true);
            this.f31204A.setNaviRoute((NaviRoute) null);
            this.f31204A.setRouteId(0);
        }
        MultiLine multiLine = this.f31257q;
        if (multiLine != null) {
            multiLine.remove();
            this.f31257q = null;
        }
        FetcherManager fetcherManager2 = this.f31204A;
        if (fetcherManager2 != null) {
            fetcherManager2.stop();
        }
        GuideRouteLine guideRouteLine = this.f31232ad;
        if (guideRouteLine != null) {
            guideRouteLine.remove();
            this.f31232ad = null;
        }
    }

    public void stop() {
        stopNav();
    }

    public void destroy() {
        stop();
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.destroy();
            this.f31204A = null;
        }
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
            this.f31206C = null;
        }
        IInertiaDelegate iInertiaDelegate = this.f31205B;
        if (iInertiaDelegate != null) {
            iInertiaDelegate.destroy();
            this.f31205B = null;
        }
        this.f31218O = null;
        DriverStateChecker driverStateChecker = this.f31225W;
        if (driverStateChecker != null) {
            driverStateChecker.destroy();
            this.f31225W = null;
        }
    }

    public void pause4Navigation() {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setIsBackground(true);
        }
    }

    public void resumeAfterNavigation() {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setIsBackground(false);
        }
        onLocationChanged(this.f31252l, this.f31244ap);
    }

    public void setSearchRouteCallbck(ISearchRouteCallback iSearchRouteCallback) {
        this.f31207D = iSearchRouteCallback;
    }

    public void setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback) {
        this.f31208E = iSearchOffRouteCallback;
    }

    public void setNaviCallback(INavigationInnerCallback iNavigationInnerCallback) {
        this.f31209F = iNavigationInnerCallback;
    }

    public void setBusinessEventCallback(IBusinessEventCallback iBusinessEventCallback) {
        this.f31210G = iBusinessEventCallback;
    }

    public void setRetryCount(int i) {
        this.f31250j = i;
    }

    public void zoomToLeftRoute(List<IMapElement> list, int i, int i2, int i3, int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        MultiLine multiLine = this.f31257q;
        if (multiLine == null || !multiLine.isVisible() || i5 < 0) {
            MultiLine multiLine2 = this.f31257q;
            if (multiLine2 != null && multiLine2.isVisible() && i5 == -1) {
                if (!(this.f31257q.mFirstLine == null || this.f31257q.mFirstLine.getBounderPoints() == null || this.f31257q.mFirstLine.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f31257q.mFirstLine);
                }
                if (!(this.f31257q.mFirstLine_Ex == null || this.f31257q.mFirstLine_Ex.getBounderPoints() == null || this.f31257q.mFirstLine_Ex.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f31257q.mFirstLine_Ex);
                }
                if (!(this.f31257q.mSecondLine == null || this.f31257q.mSecondLine.getBounderPoints() == null || this.f31257q.mSecondLine.getBounderPoints().size() <= 1)) {
                    arrayList.add(this.f31257q.mSecondLine);
                }
            }
        } else {
            if (!(this.f31257q.mFirstLine == null || this.f31257q.mFirstLine.getBounderPoints() == null || this.f31257q.mFirstLine.getBounderPoints().size() <= 1)) {
                arrayList.add(this.f31257q.mFirstLine);
            }
            if (!(this.f31257q.mFirstLine_Ex == null || this.f31257q.mFirstLine_Ex.getBounderPoints() == null || this.f31257q.mFirstLine_Ex.getBounderPoints().size() <= 1)) {
                arrayList.add(this.f31257q.mFirstLine_Ex);
            }
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        if (arrayList.size() == 0) {
            IMyLocationDelegate iMyLocationDelegate = this.f31206C;
            if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
                m23882a(this.f31206C.getCarMarker().getPosition(), i, i2, i3, i4);
                return;
            }
            return;
        }
        IMyLocationDelegate iMyLocationDelegate2 = this.f31206C;
        if (!(iMyLocationDelegate2 == null || iMyLocationDelegate2.getCarMarker() == null)) {
            arrayList.add(this.f31206C.getCarMarker());
        }
        Map map = this.f31248h;
        if (map != null) {
            BestViewer.doBestView(map, true, (List<IMapElement>) arrayList, map.getPadding(), new Padding(i, i3, i2, i4), (BestViewer.IBestViewListener) null);
        }
    }

    /* renamed from: a */
    private void m23882a(LatLng latLng, int i, int i2, int i3, int i4) {
        if (latLng != null && this.f31248h != null) {
            double m2L = C11013utils.m2L(f31203e, latLng.longitude);
            double m2L2 = C11013utils.m2L(f31203e, latLng.latitude);
            LatLng latLng2 = new LatLng(latLng.latitude - m2L2, latLng.longitude - m2L);
            this.f31248h.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(new LatLngBounds.Builder().include(latLng2).include(new LatLng(latLng.latitude + m2L2, latLng.longitude + m2L)).build(), i, i2, i3, i4));
        }
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f31260t = bitmapDescriptor;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            m23907g();
        } else {
            this.f31206C.getCarMarker().setIcon(this.f31247g, this.f31260t);
        }
    }

    public void setCarMarkerZindex(float f) {
        this.f31261u = f;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f31206C.getCarMarker().setZIndex((int) this.f31261u);
        }
    }

    public void setRouteLineVisible(boolean z) {
        this.f31258r = z;
        MultiLine multiLine = this.f31257q;
        if (multiLine != null) {
            multiLine.setVisible(z);
        }
        GuideRouteLine guideRouteLine = this.f31232ad;
        if (guideRouteLine != null) {
            guideRouteLine.setVisible(z);
        }
        DLog.m23962d(f31199a, "setRouteLineVisible：" + z, new Object[0]);
    }

    public void setCarMarkerEnabled(boolean z) {
        this.f31259s = z;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f31206C.getCarMarker().setVisible(this.f31259s);
        }
    }

    public void onLocationChanged(GpsLocation gpsLocation, List<GpsLocation> list) {
        IInertiaDelegate iInertiaDelegate;
        if (gpsLocation != null) {
            this.f31252l = gpsLocation;
            this.f31244ap = list;
            m23907g();
            if (list != null && this.f31243ao == 5) {
                DLog.m23962d(f31199a, "onLocationChanged  point=%f,%f|accuracy= %d|direction=%f|provider=%s|velocity=%f|time=%d,recentLocList= %d", Double.valueOf(gpsLocation.longitude), Double.valueOf(gpsLocation.latitude), Integer.valueOf(gpsLocation.accuracy), Float.valueOf(gpsLocation.direction), gpsLocation.provider, Float.valueOf(gpsLocation.velocity), Long.valueOf(gpsLocation.time), Integer.valueOf(list.size()));
                this.f31243ao++;
            }
            if (this.f31243ao >= 5) {
                this.f31243ao = 0;
            }
            FetcherManager fetcherManager = this.f31204A;
            if (fetcherManager != null) {
                fetcherManager.setStart(gpsLocation);
                this.f31204A.setRecentLocList(list);
            }
            if (!this.f31246f || (iInertiaDelegate = this.f31205B) == null) {
                IMyLocationDelegate iMyLocationDelegate = this.f31206C;
                if (iMyLocationDelegate != null && this.f31248h != null) {
                    iMyLocationDelegate.animateTo(new AnimateNode(new LatLng(gpsLocation.latitude, gpsLocation.longitude), -1, 0, false), this.f31216M);
                    return;
                }
                return;
            }
            iInertiaDelegate.onRecvDriverLocation(GGConverter.convertFromDiDiLocation(gpsLocation));
            this.f31205B.getMatchPoint(false);
            DLog.m23962d(f31199a, "getMatchPoint", new Object[0]);
        }
    }

    public void setLineOptions(LineOptions lineOptions, LineOptions lineOptions2) {
        this.f31214K = lineOptions;
        this.f31215L = lineOptions2;
        MultiLine multiLine = this.f31257q;
        if (multiLine != null) {
            multiLine.setOptions(lineOptions, lineOptions2);
        }
    }

    public void setGuideRouteLineOpt(LineOptions lineOptions) {
        Map map = this.f31248h;
        if (map != null) {
            GuideRouteLine guideRouteLine = this.f31232ad;
            if (guideRouteLine == null) {
                this.f31232ad = new GuideRouteLine(map, lineOptions);
            } else {
                guideRouteLine.setLineOpt(lineOptions);
            }
        }
    }

    public int getRemainTime(int i) {
        if (this.f31237ai == 2) {
            return 1;
        }
        return this.f31266z;
    }

    public int getRemainDistance(int i) {
        if (this.f31237ai == 2) {
            return 100;
        }
        return this.f31265y;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f31249i = orderInfo;
        if (orderInfo != null && PlatInfo.getInstance().getOrderStage() == -1) {
            DLog.m23962d(f31199a, "setOrderInfo" + orderInfo.toString(), new Object[0]);
            DLog.m23962d(f31199a, "PlatInfo.setOrderStage", new Object[0]);
            PlatInfo.getInstance().setOrderStage(orderInfo.getOrderStage());
        }
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setOrderInfo(this.f31249i);
        }
        if (this.f31247g != null && orderInfo != null && orderInfo.getOrderStage() == 1 && this.f31225W == null) {
            DriverStateChecker driverStateChecker = new DriverStateChecker(this.f31247g);
            this.f31225W = driverStateChecker;
            driverStateChecker.create();
        }
    }

    public MultiLine getLine() {
        return this.f31257q;
    }

    public void setOrderPoints(List<OrderPoint> list) {
        this.f31233ae = list;
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setPassPoints(list);
        }
        RouteEvent routeEvent = this.f31231ac;
        if (routeEvent != null) {
            routeEvent.setWayList(list);
        }
    }

    public void setMultiSctxGroup(String str) {
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setMultiSctxGroup(str);
        }
    }

    public void setOrderPointsTimeStamp(long j) {
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setPassPointTimeStamp(j);
        }
    }

    public List<OrderPoint> getPassPoints() {
        NaviRoute naviRoute = this.f31255o;
        ArrayList arrayList = null;
        if (naviRoute == null) {
            return null;
        }
        List<WayPoint> wayPoints = naviRoute.getWayPoints();
        if (wayPoints != null && wayPoints.size() > 0) {
            arrayList = new ArrayList();
            for (WayPoint wayPoint : wayPoints) {
                OrderPoint orderPoint = new OrderPoint();
                orderPoint.point = wayPoint.point;
                arrayList.add(orderPoint);
            }
        }
        return arrayList;
    }

    public void setIsPassNavi(boolean z) {
        DLog.m23962d(f31199a, "setIsPassNavi:" + z, new Object[0]);
    }

    public Marker getCarMarker() {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null) {
            return null;
        }
        return this.f31206C.getCarMarker().getMarker();
    }

    public void setCameraMode(CameraMode cameraMode) {
        this.f31245aq = cameraMode;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setCameraMode(cameraMode);
        }
    }

    public void followMyLocation(boolean z) {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.followMyLocation(z);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.onNewMargin(i, i2, i3, i4);
        }
    }

    public void zoomToNav() {
        this.f31245aq = CameraMode.CAR_HEAD_UP;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.zoomToNav();
        }
    }

    public void pauseRequestOra() {
        DLog.m23962d(f31199a, "pauseRequestOra called", new Object[0]);
        this.f31219P = false;
        m23885a(false);
    }

    public void resumeRequestOra() {
        DLog.m23962d(f31199a, "resumeRequestOra called", new Object[0]);
        this.f31219P = true;
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.startEta();
        }
    }

    public boolean isLightNavSctxPaused() {
        return !this.f31219P;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m23911i() {
        List<LatLng> list = this.f31256p;
        return list == null || list.size() == 0;
    }

    public void setOutSideRoute(final List<LatLng> list, int i, int i2, long j, GpsLocation gpsLocation) {
        if (gpsLocation != null) {
            this.f31252l = gpsLocation;
        }
        if (list == null || list.size() <= 1) {
            this.f31220Q = i2;
            this.f31221R = i;
            this.f31265y = i2;
            this.f31266z = i;
            StreetViewInfo streetViewInfo = this.f31229aa;
            if (streetViewInfo != null) {
                streetViewInfo.realEDA = i2;
            }
            DLog.m23962d(f31199a, "setOutSideRoute else: eta= %d, eda = %d", Integer.valueOf(this.f31266z), Integer.valueOf(this.f31265y));
            m23896c();
            return;
        }
        this.f31220Q = i2;
        this.f31221R = i;
        this.f31222S = j;
        if (this.f31248h != null) {
            this.f31255o = null;
            this.f31231ac.updateRoute((NaviRoute) null);
            this.f31256p = list;
            this.f31236ah = list.get(list.size() - 1);
            this.f31212I = null;
            FetcherManager fetcherManager = this.f31204A;
            if (fetcherManager != null) {
                fetcherManager.setNaviRoute((NaviRoute) null);
                this.f31204A.setRouteId(j);
            }
            MultiLine multiLine = this.f31257q;
            if (multiLine != null) {
                multiLine.setOptions(this.f31214K, this.f31215L);
                this.f31257q.setPoints(list);
                this.f31257q.setVisible(this.f31258r);
                this.f31257q.init(-1);
                DLog.m23962d(f31199a, "setOutSideRoute=" + this.f31258r, new Object[0]);
            }
            m23883a(this.f31255o);
            m23909h();
            this.f31211H = 0;
            IMyLocationDelegate iMyLocationDelegate = this.f31206C;
            if (!(iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null)) {
                this.f31206C.animateCancel(new onCarAnimationCancelListener(-1) {
                    public void onCancel() {
                        if (GoogleSctxDriver.this.f31206C != null && GoogleSctxDriver.this.f31206C.getCarMarker() != null) {
                            GoogleSctxDriver.this.f31206C.getCarMarker().setPosition((LatLng) list.get(0));
                            DLog.m23962d(GoogleSctxDriver.f31199a, "setOutSideRoute: the first point of the googleNav route : " + ((LatLng) list.get(0)).toString(), new Object[0]);
                            GoogleSctxDriver.this.f31206C.getCarMarker().setRotation((float) DDSphericalUtil.computeHeading((LatLng) list.get(0), (LatLng) list.get(1)));
                            if (-1 > -1) {
                                GoogleSctxDriver.this.f31206C.setNavRoutePoints(list.subList(0, -1 + 1), true);
                                if (GoogleSctxDriver.this.f31205B != null) {
                                    GoogleSctxDriver.this.f31205B.setRoutePoints((List<LatLng>) list.subList(0, -1 + 1), true);
                                    RouteGuidanceGPSPoint unused = GoogleSctxDriver.this.f31228Z = null;
                                }
                            } else {
                                GoogleSctxDriver.this.f31206C.setNavRoutePoints(list, true);
                                if (GoogleSctxDriver.this.f31205B != null) {
                                    GoogleSctxDriver.this.f31205B.setRoutePoints(list);
                                    RouteGuidanceGPSPoint unused2 = GoogleSctxDriver.this.f31228Z = null;
                                }
                            }
                            GoogleSctxDriver.this.m23913j();
                        }
                    }
                });
            }
            this.f31265y = i2;
            this.f31266z = i;
            StreetViewInfo streetViewInfo2 = this.f31229aa;
            if (streetViewInfo2 != null) {
                streetViewInfo2.realEDA = i2;
            }
            DLog.m23962d(f31199a, "setOutSideRoute : eta= %d, eda = %d", Integer.valueOf(this.f31266z), Integer.valueOf(this.f31265y));
            m23896c();
            FetcherManager fetcherManager2 = this.f31204A;
            if (fetcherManager2 != null) {
                fetcherManager2.startEta();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m23913j() {
        ArrayList<DMKEventPoint> eventPointList;
        IInertiaDelegate iInertiaDelegate = this.f31205B;
        if (iInertiaDelegate != null && (eventPointList = iInertiaDelegate.getEventPointList()) != null) {
            StreetViewInfo streetViewInfo = this.f31229aa;
            if (streetViewInfo != null) {
                streetViewInfo.eventListSize = eventPointList.size();
            }
            if (this.f31256p != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<DMKEventPoint> it = eventPointList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().geoIndex);
                    sb.append(";");
                }
                DLog.m23962d("StreetView event points: ", sb.toString(), new Object[0]);
            }
            if (this.f31229aa != null && eventPointList.size() <= 1) {
                this.f31229aa.lastTwoEventPoint = this.f31256p;
                this.f31229aa.isInTheLastEvent = true;
                this.f31217N = null;
                if (eventPointList.size() == 1) {
                    DMKEventPoint dMKEventPoint = eventPointList.get(0);
                    List<LatLng> list = this.f31256p;
                    if (list != null && list.size() > dMKEventPoint.geoIndex) {
                        this.f31229aa.lastEventPoint = this.f31256p.get(dMKEventPoint.geoIndex);
                    }
                }
                DLog.m23962d(f31199a, "StreetView: only one event point!!!", new Object[0]);
            } else if (this.f31229aa != null) {
                this.f31217N = eventPointList.get(eventPointList.size() - 2);
                this.f31229aa.lastTwoEventPoint = new ArrayList();
                int i = eventPointList.get(eventPointList.size() - 2).geoIndex;
                List<LatLng> list2 = this.f31256p;
                if (list2 != null && i >= 0 && i < list2.size()) {
                    StreetViewInfo streetViewInfo2 = this.f31229aa;
                    List<LatLng> list3 = this.f31256p;
                    streetViewInfo2.lastTwoEventPoint = list3.subList(i, list3.size());
                }
                DMKEventPoint dMKEventPoint2 = eventPointList.get(eventPointList.size() - 2);
                if (dMKEventPoint2 != null) {
                    int i2 = dMKEventPoint2.geoIndex;
                    List<LatLng> list4 = this.f31256p;
                    if (list4 != null && i2 >= 0 && i2 < list4.size()) {
                        StreetViewInfo streetViewInfo3 = this.f31229aa;
                        List<LatLng> list5 = this.f31256p;
                        streetViewInfo3.lastDistance = (int) DDSphericalUtil.computeDistanceBetween(list5.get(list5.size() - 1), this.f31256p.get(i2));
                        this.f31229aa.lastEventPoint = this.f31256p.get(i2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m23888a(String str) {
        return ApolloUtils.isRetryRoute() && OraErrorCodeUtil.canBeRetry(str);
    }

    public void setCarHeadMaxMapLevel(double d) {
        this.f31226X = d;
        IMyLocationDelegate iMyLocationDelegate = this.f31206C;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.setCarHeadMaxMapLevel(d);
        }
    }

    public OrderInfo getOrderInfo() {
        return this.f31249i;
    }

    public GpsLocation getOriginGpsLocation() {
        return this.f31252l;
    }

    public RouteGuidanceGPSPoint getOriginMatchPoint() {
        return this.f31227Y;
    }

    public IMyLocationDelegate getMyLocationEngine() {
        return this.f31206C;
    }

    public RouteGuidanceGPSPoint getMatchedPoint() {
        return this.f31228Z;
    }

    public StreetViewInfo getStreetViewInfo() {
        StreetViewInfo streetViewInfo = this.f31229aa;
        if (streetViewInfo != null) {
            GpsLocation gpsLocation = this.f31252l;
            if (gpsLocation != null) {
                streetViewInfo.mOriginPoint = new LatLng(gpsLocation.latitude, this.f31252l.longitude);
            }
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f31228Z;
            if (!(routeGuidanceGPSPoint == null || routeGuidanceGPSPoint.point == null)) {
                this.f31229aa.mMatchedPoint = new LatLng(((double) this.f31228Z.point.getLatitudeE6()) / 1000000.0d, ((double) this.f31228Z.point.getLongitudeE6()) / 1000000.0d);
            }
        }
        return this.f31229aa;
    }

    /* renamed from: a */
    private void m23883a(NaviRoute naviRoute) {
        OrderInfo orderInfo;
        LatLng latLng;
        LatLng latLng2;
        List<OrderPoint> list;
        if (this.f31232ad != null && naviRoute != null && (orderInfo = this.f31249i) != null) {
            int orderStage = orderInfo.getOrderStage();
            if (orderStage != 1 && orderStage != 2) {
                this.f31232ad.remove();
            } else if (naviRoute.isShowPickUpGuideLine()) {
                if (!ApolloUtils.getBERGuideLineEnable()) {
                    this.f31232ad.remove();
                    return;
                }
                int dstRouteGeoIndex = naviRoute.getDstRouteGeoIndex();
                List<LatLng> routePoints = naviRoute.getRoutePoints();
                if (dstRouteGeoIndex < 0 || dstRouteGeoIndex >= routePoints.size() || (list = this.f31233ae) == null || list.size() <= 0) {
                    latLng = routePoints.get(routePoints.size() - 1);
                    latLng2 = this.f31254n;
                } else {
                    latLng = routePoints.get(dstRouteGeoIndex);
                    latLng2 = this.f31233ae.get(0).point;
                }
                double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
                if (computeDistanceBetween > ((double) ApolloUtils.getBERGuideLineDistance())) {
                    this.f31232ad.add(Arrays.asList(new LatLng[]{latLng2, latLng}));
                    m23881a(computeDistanceBetween);
                    return;
                }
                this.f31232ad.remove();
            }
        }
    }

    /* renamed from: a */
    private void m23881a(double d) {
        HashMap hashMap = new HashMap();
        OrderInfo orderInfo = this.f31249i;
        hashMap.put("order_id", orderInfo != null ? orderInfo.getOrderId() : "");
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId()));
        hashMap.put("distance", Double.valueOf(d));
        GlobalDriverOmega.trackEvent("map_route_guidance_sw", hashMap);
    }

    /* renamed from: k */
    private void m23915k() {
        HashMap hashMap = new HashMap();
        OrderInfo orderInfo = this.f31249i;
        hashMap.put("order_id", orderInfo != null ? orderInfo.getOrderId() : "");
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        GpsLocation gpsLocation = this.f31253m;
        Object obj = "-999";
        hashMap.put("deviate_lat", gpsLocation != null ? Double.valueOf(gpsLocation.latitude) : obj);
        GpsLocation gpsLocation2 = this.f31253m;
        if (gpsLocation2 != null) {
            obj = Double.valueOf(gpsLocation2.longitude);
        }
        hashMap.put("deviate_lng", obj);
        m23884a("map_deviate_driv_sw", (HashMap<String, Object>) hashMap, "trackOffRoutePoint");
    }

    /* renamed from: a */
    private void m23884a(String str, HashMap<String, Object> hashMap, String str2) {
        GlobalDriverOmega.trackEvent(str, hashMap);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> next : hashMap.entrySet()) {
            sb.append(" " + next.toString() + " ");
        }
        DLog.m23962d(str2, sb.toString(), new Object[0]);
    }

    public LatLng getRouteEndPoint() {
        return this.f31236ah;
    }

    public void setArriveStatus(int i) {
        DLog.m23962d(BaseRoundStrategy.TAG, "update arrive status: " + i, new Object[0]);
        this.f31237ai = i;
        m23896c();
    }

    public void setCaller(CallFrom callFrom) {
        this.f31235ag = callFrom;
        FetcherManager fetcherManager = this.f31204A;
        if (fetcherManager != null) {
            fetcherManager.setCaller(callFrom);
        }
    }
}
