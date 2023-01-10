package com.didi.map.sdk.nav.inertia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.nav.inertia.SimulateInfo;
import com.didi.map.sdk.nav.jni.JniCreator;
import com.didi.map.sdk.nav.prediction.SctxPredictionDataManager;
import com.didi.map.sdk.nav.prediction.SctxPredictionOmegaData;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.map.sdk.nav.libc.common.ApolloUtil;
import com.map.sdk.nav.libc.common.CommonUtils;
import com.map.sdk.nav.libc.common.Convertor;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.DMKMatchResult;
import com.map.sdk.nav.libc.common.DMKMockConfig;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.MapMatchTracker;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import com.map.sdk.nav.libc.jni.JniWrapperInterface;
import java.util.ArrayList;
import java.util.List;

public class InertiaEngine implements IInertiaDelegate {

    /* renamed from: a */
    private static final String f30889a = "InertiaEngine";

    /* renamed from: b */
    private static final int f30890b = 1;

    /* renamed from: c */
    private static final int f30891c = 2;

    /* renamed from: d */
    private static final int f30892d = 3;

    /* renamed from: e */
    private static final int f30893e = 4;

    /* renamed from: f */
    private static final int f30894f = 5;

    /* renamed from: g */
    private static final int f30895g = 6;

    /* renamed from: h */
    private static final int f30896h = 7;

    /* renamed from: v */
    private static final int f30897v = 4;

    /* renamed from: x */
    private static final int f30898x = 6;

    /* renamed from: A */
    private ApolloCache f30899A;

    /* renamed from: B */
    private SctxStateEnum f30900B;

    /* renamed from: C */
    private SctxStateInfo f30901C;

    /* renamed from: D */
    private IInertiaDelegate.ISimulateEvaluateCallback f30902D;

    /* renamed from: E */
    private SimulateInfo f30903E;

    /* renamed from: F */
    private ApolloParamsSctxPrediction f30904F;

    /* renamed from: G */
    private long f30905G = 3000;

    /* renamed from: H */
    private String f30906H = "ddMapkit";

    /* renamed from: i */
    private Context f30907i;

    /* renamed from: j */
    private List<LatLng> f30908j;

    /* renamed from: k */
    private OnLocationMatched f30909k;

    /* renamed from: l */
    private JniWrapperInterface f30910l;

    /* renamed from: m */
    private DMKMatchResult f30911m;

    /* renamed from: n */
    private DMKEventPoint f30912n;

    /* renamed from: o */
    private MatchPointType f30913o = MatchPointType.UNKNOWN;

    /* renamed from: p */
    private RouteGuidanceGPSPoint f30914p;

    /* renamed from: q */
    private LimitQueue<RouteGuidanceGPSPoint> f30915q;

    /* renamed from: r */
    private RouteGuidanceGPSPoint f30916r;

    /* renamed from: s */
    private RouteGuidanceGPSPoint f30917s;

    /* renamed from: t */
    private RouteGuidanceGPSPoint f30918t;

    /* renamed from: u */
    private int f30919u = 0;

    /* renamed from: w */
    private int f30920w = 0;

    /* renamed from: y */
    private boolean f30921y;

    /* renamed from: z */
    private int f30922z;

    private InertiaEngine(Context context) {
        this.f30907i = context;
        CommonUtils.setContext(context);
        this.f30914p = new RouteGuidanceGPSPoint();
        this.f30899A = new ApolloCache();
        this.f30914p.segmentIndex = -1;
        this.f30912n = new DMKEventPoint();
        this.f30911m = new DMKMatchResult();
        this.f30915q = new LimitQueue<>(this.f30899A.getListSize());
        SimulateInfo simulateInfo = new SimulateInfo();
        this.f30903E = simulateInfo;
        simulateInfo.reset();
        this.f30901C = new SctxStateInfo();
    }

    public static InertiaEngine create(Context context) {
        return new InertiaEngine(context);
    }

    /* renamed from: a */
    private boolean m23737a(int i) {
        if (this.f30908j != null) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f30916r;
            double d = 0.0d;
            if (routeGuidanceGPSPoint == null || routeGuidanceGPSPoint.segmentIndex <= -1 || this.f30916r.segmentIndex >= this.f30908j.size() - 1) {
                int i2 = 0;
                while (i2 < this.f30908j.size() - 1) {
                    i2++;
                    d += DDSphericalUtil.computeDistanceBetween(this.f30908j.get(i2), this.f30908j.get(i2));
                    if (d > ((double) i)) {
                        return true;
                    }
                }
            } else {
                double d2 = 0.0d - ((double) this.f30916r.shapeOffSet);
                int i3 = this.f30916r.segmentIndex;
                while (i3 < this.f30908j.size() - 1) {
                    i3++;
                    d2 += DDSphericalUtil.computeDistanceBetween(this.f30908j.get(i3), this.f30908j.get(i3));
                    if (d2 > ((double) i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m23731a() {
        RouteGuidanceGPSPoint last;
        RouteGuidanceGPSPoint first;
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f30915q;
        if (limitQueue != null && limitQueue.size() > 0 && (first = this.f30915q.getFirst()) != null && this.f30917s.timestamp - first.timestamp > 150) {
            this.f30915q.poll();
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue2 = this.f30915q;
        if (limitQueue2 != null && this.f30914p != null) {
            if (limitQueue2.size() <= 0 || (last = this.f30915q.getLast()) == null || (!(this.f30914p.segmentIndex == last.segmentIndex && this.f30914p.shapeOffSet == last.shapeOffSet) && !this.f30914p.point.equals(last.point))) {
                this.f30915q.offer(this.f30914p.copy());
            }
        }
    }

    public void getMatchPoint(boolean z) {
        if (!m23737a(this.f30899A.getAllow_dis())) {
            DLog.m10773d(f30889a, "getMatchPoint|LastDistance less than AllowDis", new Object[0]);
            z = false;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f30917s;
        if (routeGuidanceGPSPoint == null) {
            this.f30913o = MatchPointType.UNKNOWN;
            DLog.m10773d(f30889a, "onMatchRoute gps is null", new Object[0]);
            m23733a(1, z);
            return;
        }
        if (this.f30916r == null) {
            this.f30916r = routeGuidanceGPSPoint.copy();
        }
        if (this.f30918t == null || !this.f30917s.point.equals(this.f30918t.point)) {
            this.f30918t = this.f30917s;
            if (m23740b()) {
                m23741c();
                if (this.f30909k != null && this.f30910l.isOutWay()) {
                    this.f30909k.onOffRoute();
                }
                m23733a(4, z);
                return;
            }
            m23733a(3, z);
        } else if (this.f30918t.timestamp != this.f30917s.timestamp) {
            this.f30918t = this.f30917s;
            if (!m23740b()) {
                m23733a(3, z);
            } else if (this.f30913o == MatchPointType.UNKNOWN || this.f30913o == MatchPointType.GPS) {
                m23733a(5, z);
            } else {
                m23733a(6, z);
            }
        } else {
            this.f30918t = this.f30917s;
            m23733a(2, z);
        }
    }

    /* renamed from: b */
    private boolean m23740b() {
        ApolloParamsSctxPrediction apolloParamsSctxPrediction;
        if (this.f30910l == null) {
            return false;
        }
        if (this.f30911m == null) {
            this.f30911m = new DMKMatchResult();
        }
        this.f30911m.resGpsFrequency = ((float) this.f30905G) / 1000.0f;
        RouteGuidanceGPSPoint matchResult = this.f30910l.matchResult(this.f30917s, this.f30911m);
        if (!(this.f30922z != 0 || (apolloParamsSctxPrediction = this.f30904F) == null || !apolloParamsSctxPrediction.isPredictionOmegaEnabled() || matchResult == null || distanceLeft(matchResult) >= this.f30904F.startOmgDist || matchResult.point == null || matchResult.originMatchPoint == null || matchResult.originMatchPoint.point == null)) {
            LatLng a = m23729a(matchResult.originMatchPoint.point);
            LatLng a2 = m23729a(matchResult.point);
            SctxPredictionDataManager instance = SctxPredictionDataManager.getInstance();
            SctxPredictionOmegaData sctxPredictionOmegaData = r6;
            SctxPredictionOmegaData sctxPredictionOmegaData2 = new SctxPredictionOmegaData(a.latitude, a.longitude, a2.latitude, a2.longitude, matchResult.timestamp);
            instance.insertData(sctxPredictionOmegaData);
        }
        DMKMatchResult dMKMatchResult = this.f30911m;
        if (dMKMatchResult == null) {
            return false;
        }
        RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKMatchResult.resMatchPoint);
        this.f30914p.point = convertFromDMKGPSPoint.point;
        this.f30914p.velocity = convertFromDMKGPSPoint.velocity;
        this.f30914p.timestamp = convertFromDMKGPSPoint.timestamp;
        this.f30914p.source = convertFromDMKGPSPoint.source;
        this.f30914p.shapeOffSet = convertFromDMKGPSPoint.shapeOffSet;
        this.f30914p.segmentIndex = convertFromDMKGPSPoint.segmentIndex;
        this.f30914p.matchedStatus = convertFromDMKGPSPoint.matchedStatus;
        this.f30914p.heading = convertFromDMKGPSPoint.heading;
        this.f30914p.accuracy = convertFromDMKGPSPoint.accuracy;
        if (matchResult != null) {
            this.f30914p.originMatchPoint = matchResult.originMatchPoint;
        }
        this.f30913o = MatchPointType.valueOf(this.f30911m.resPointType);
        this.f30912n = this.f30911m.resEventPoint;
        return true;
    }

    public void destroy() {
        DLog.m10773d(f30889a, "destroy", new Object[0]);
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.destroy();
            this.f30910l = null;
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f30915q;
        if (limitQueue != null) {
            limitQueue.clear();
            this.f30915q = null;
        }
        this.f30903E = null;
        this.f30914p = null;
        this.f30916r = null;
        this.f30908j = null;
        this.f30920w = 0;
        this.f30919u = 0;
        this.f30901C = null;
        this.f30899A = null;
        this.f30912n = null;
        this.f30902D = null;
    }

    public void setRoutePoints(List<LatLng> list, boolean z) {
        this.f30921y = z;
        setRoutePoints(list);
    }

    public void setRoutePoints(List<LatLng> list) {
        DLog.m10773d(f30889a, " setRoutePoints", new Object[0]);
        this.f30908j = list;
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.destroy();
            this.f30910l = null;
        }
        LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f30915q;
        if (limitQueue != null) {
            limitQueue.clear();
        }
        this.f30916r = null;
        this.f30920w = 0;
        this.f30919u = 0;
        this.f30918t = null;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        this.f30914p = routeGuidanceGPSPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        if (list != null && list.size() > 1) {
            this.f30910l = JniCreator.get();
            DMKMockConfig dMKMockConfig = new DMKMockConfig();
            ApolloParamsSctxPrediction apolloParamsSctxPrediction = this.f30904F;
            if (apolloParamsSctxPrediction != null) {
                dMKMockConfig.enableMock = apolloParamsSctxPrediction.isPredictionEnabled();
                dMKMockConfig.coefficient = this.f30904F.coefficient;
                dMKMockConfig.distDisableMock = this.f30904F.distDisableMock;
            }
            this.f30910l.setMockConfig(dMKMockConfig);
            this.f30910l.setRouteId(this.f30906H);
            this.f30910l.setRoutePoints(m23738a(list));
            this.f30910l.setNextRoutePoints((List<LatLng>) null);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i) {
        if (list == null || list.size() <= 1 || list.size() <= i) {
            setRoutePoints(list);
            return;
        }
        setRoutePoints(list.subList(0, i));
        List<LatLng> subList = list.subList(i, list.size());
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.setNextRoutePoints(subList);
        }
    }

    public void setRoutePoints(List<LatLng> list, int i, boolean z) {
        this.f30921y = z;
        setRoutePoints(list, i);
    }

    public void setRouteId(String str) {
        this.f30906H = str;
    }

    public void onRecvDriverLocation(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        this.f30917s = routeGuidanceGPSPoint;
        if (routeGuidanceGPSPoint != null) {
            DLog.m10773d(f30889a, "onRecvDriverLocation: %s ", routeGuidanceGPSPoint.toString());
            return;
        }
        DLog.m10773d(f30889a, "onRecvDriverLocation: null", new Object[0]);
    }

    public void resetRecvDriverLocation() {
        this.f30918t = null;
    }

    public void setOnLocationMatched(OnLocationMatched onLocationMatched) {
        this.f30909k = onLocationMatched;
    }

    public void setOrderInfo(String str, int i) {
        this.f30922z = i;
        ApolloParamsSctxPrediction apolloParamsSctxPrediction = this.f30904F;
        if (apolloParamsSctxPrediction != null && apolloParamsSctxPrediction.isPredictionOmegaEnabled()) {
            if (i == 0) {
                SctxPredictionDataManager.getInstance().clearData();
            } else if (i == 1) {
                SctxPredictionDataManager.getInstance().doOmega(str);
            }
        }
        MapMatchTracker.setOrderId(str);
        DLog.m10773d(f30889a, "setOrderInfo: id= " + str + ",stage=" + i, new Object[0]);
    }

    public void setPredictionApolloParams(ApolloParamsSctxPrediction apolloParamsSctxPrediction) {
        this.f30904F = apolloParamsSctxPrediction;
        if (apolloParamsSctxPrediction != null) {
            DLog.m10773d(f30889a, apolloParamsSctxPrediction.toString(), new Object[0]);
        }
    }

    public int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.distanceLeft(routeGuidanceGPSPoint);
        }
        return 0;
    }

    public int distanceLeft() {
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.distanceLeft2();
        }
        return 0;
    }

    public MatchPointType getMatchPointType() {
        DLog.m10773d(f30889a, "getMatchPointType = " + this.f30913o, new Object[0]);
        return this.f30913o;
    }

    public void setSimulateEvaluateCallback(IInertiaDelegate.ISimulateEvaluateCallback iSimulateEvaluateCallback) {
        this.f30902D = iSimulateEvaluateCallback;
    }

    public void setRequestIntervalInMills(int i) {
        this.f30905G = (long) i;
    }

    public RouteGuidanceGPSPoint getLastMatchGPSPoint() {
        return this.f30914p;
    }

    public int getEventPointSize() {
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.getEventPointSize();
        }
        return 0;
    }

    public ArrayList<DMKEventPoint> getEventPointList() {
        ArrayList<DMKEventPoint> arrayList = new ArrayList<>();
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            jniWrapperInterface.getEventPointList(arrayList);
        }
        return arrayList;
    }

    public MapMatchType getMapMatchType() {
        JniWrapperInterface jniWrapperInterface = this.f30910l;
        if (jniWrapperInterface != null) {
            return jniWrapperInterface.getMapMatchType();
        }
        return MapMatchType.UNKNOWN;
    }

    /* renamed from: a */
    private void m23733a(int i, boolean z) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        OnLocationMatched onLocationMatched;
        DLog.m10773d(f30889a, "doInertiaNavi, matchType:" + i + ",isNeedSimulate =" + z, new Object[0]);
        RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f30916r;
        if (routeGuidanceGPSPoint2 != null) {
            if (this.f30921y) {
                switch (i) {
                    case 1:
                    case 2:
                        SctxStateEnum sctxStateEnum = SctxStateEnum.NO_CAR_LOC_INERTIA;
                        int i2 = this.f30920w;
                        double d = 0.0d;
                        if (i2 > 2) {
                            LimitQueue<RouteGuidanceGPSPoint> limitQueue = this.f30915q;
                            if (limitQueue == null || limitQueue.size() <= 2) {
                                d = (double) this.f30899A.getMinSpeed();
                            } else {
                                RouteGuidanceGPSPoint first = this.f30915q.getFirst();
                                RouteGuidanceGPSPoint last = this.f30915q.getLast();
                                if (!(first == null || last == null)) {
                                    d = m23727a(first, last) / ((double) (last.timestamp - first.timestamp));
                                }
                                d = Math.min(Math.max(d * ((double) this.f30899A.getCoefficient()), (double) this.f30899A.getMinSpeed()), (double) this.f30899A.getMaxSpeed());
                            }
                        } else {
                            this.f30920w = i2 + 1;
                        }
                        m23732a((float) d, 3, sctxStateEnum, z);
                        return;
                    case 3:
                    case 5:
                        break;
                    case 4:
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f30914p;
                        if (routeGuidanceGPSPoint3 != null && routeGuidanceGPSPoint3.segmentIndex > -1) {
                            this.f30920w = 0;
                            int i3 = this.f30919u;
                            if (i3 >= 4) {
                                OnLocationMatched onLocationMatched2 = this.f30909k;
                                if (onLocationMatched2 != null) {
                                    onLocationMatched2.onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus.INERTIA_MATCH_FAIL);
                                }
                            } else if (i3 == 0 && DDSphericalUtil.computeDistanceBetween(m23729a(this.f30916r.point), m23729a(this.f30914p.point)) > 100.0d && (onLocationMatched = this.f30909k) != null) {
                                onLocationMatched.onSctxSuspiciousJumpError(SctxInertiaSuspiciousStatus.DRIVER_LOC_TOO_FAR);
                            }
                            this.f30919u = 0;
                            RouteGuidanceGPSPoint routeGuidanceGPSPoint4 = this.f30916r;
                            if (routeGuidanceGPSPoint4 == null || routeGuidanceGPSPoint4.segmentIndex <= -1 || (this.f30916r.segmentIndex <= this.f30914p.segmentIndex && (this.f30916r.segmentIndex != this.f30914p.segmentIndex || this.f30916r.shapeOffSet <= this.f30914p.shapeOffSet))) {
                                RouteGuidanceGPSPoint routeGuidanceGPSPoint5 = this.f30914p;
                                if (routeGuidanceGPSPoint5 != null && routeGuidanceGPSPoint5.point != null && this.f30909k != null) {
                                    m23734a(new LatLng(((double) this.f30914p.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30914p.point.getLongitudeE6()) / 1000000.0d), this.f30914p.segmentIndex, this.f30914p.shapeOffSet, 0, 0, false, this.f30912n);
                                    this.f30916r.shapeOffSet = this.f30914p.shapeOffSet;
                                    this.f30916r.segmentIndex = this.f30914p.segmentIndex;
                                    this.f30916r.timestamp = this.f30914p.timestamp;
                                    this.f30916r.source = this.f30914p.source;
                                    this.f30916r.point = this.f30914p.point;
                                    m23739b(SctxStateEnum.NORMAL, 0);
                                    return;
                                }
                                return;
                            }
                            m23732a(z ? (float) this.f30899A.getCatchspeed() : 0.0f, 3, SctxStateEnum.MATCH_SUCCESS_INERTIA, z);
                            return;
                        }
                        break;
                    case 6:
                        SctxStateEnum sctxStateEnum2 = SctxStateEnum.WIFI_INERTIA;
                        if (this.f30913o == MatchPointType.MOBILE_STATION) {
                            sctxStateEnum2 = SctxStateEnum.NETWORK_INERTIA;
                        }
                        m23732a((float) this.f30899A.getNetpoint_speed(), 3, sctxStateEnum2, z);
                        return;
                    case 7:
                        SctxStateEnum sctxStateEnum3 = SctxStateEnum.NOT_MOVE;
                        int i4 = this.f30919u;
                        if (i4 >= 6) {
                            m23732a((float) this.f30899A.getStandstill_speed(), 3, sctxStateEnum3, z);
                            return;
                        }
                        this.f30919u = i4 + 1;
                        DLog.m10773d(f30889a, "doInertiaNavi, mCarStandCount=" + this.f30919u, new Object[0]);
                        m23732a(0.0f, 3, sctxStateEnum3, z);
                        return;
                    default:
                        return;
                }
                SctxStateEnum sctxStateEnum4 = i != 5 ? SctxStateEnum.MATCH_FAIL_INERTIA : SctxStateEnum.NOT_MOVE;
                int i5 = this.f30919u;
                if (i5 >= 4) {
                    m23732a((float) this.f30899A.getStandstill_speed(), 3, sctxStateEnum4, z);
                    return;
                }
                this.f30919u = i5 + 1;
                m23732a(0.0f, 3, sctxStateEnum4, z);
                return;
            }
            if (i == 4) {
                RouteGuidanceGPSPoint routeGuidanceGPSPoint6 = this.f30914p;
                if (routeGuidanceGPSPoint6 != null) {
                    this.f30916r = routeGuidanceGPSPoint6.copy();
                }
            } else if (!(routeGuidanceGPSPoint2 == null || (routeGuidanceGPSPoint = this.f30917s) == null)) {
                RouteGuidanceGPSPoint copy = routeGuidanceGPSPoint.copy();
                this.f30916r = copy;
                copy.segmentIndex = -1;
            }
            RouteGuidanceGPSPoint routeGuidanceGPSPoint7 = this.f30916r;
            if (routeGuidanceGPSPoint7 != null && routeGuidanceGPSPoint7.point != null && this.f30909k != null) {
                m23734a(new LatLng(((double) this.f30916r.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30916r.point.getLongitudeE6()) / 1000000.0d), this.f30916r.segmentIndex, this.f30916r.shapeOffSet, 0, 0, false, this.f30912n);
                m23739b(SctxStateEnum.IDLE, 0);
            }
        }
    }

    /* renamed from: a */
    private double m23727a(RouteGuidanceGPSPoint routeGuidanceGPSPoint, RouteGuidanceGPSPoint routeGuidanceGPSPoint2) {
        List<LatLng> list;
        if (routeGuidanceGPSPoint == null || routeGuidanceGPSPoint2 == null || (list = this.f30908j) == null || list.size() < routeGuidanceGPSPoint2.segmentIndex + 1) {
            return -1.0d;
        }
        if (routeGuidanceGPSPoint.segmentIndex == routeGuidanceGPSPoint2.segmentIndex) {
            return DDSphericalUtil.computeDistanceBetween(m23729a(routeGuidanceGPSPoint.point), m23729a(routeGuidanceGPSPoint2.point));
        }
        if (routeGuidanceGPSPoint.segmentIndex > routeGuidanceGPSPoint2.segmentIndex) {
            return -1.0d;
        }
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(m23729a(routeGuidanceGPSPoint.point), this.f30908j.get(routeGuidanceGPSPoint.segmentIndex + 1));
        if (routeGuidanceGPSPoint.segmentIndex + 1 < routeGuidanceGPSPoint2.segmentIndex) {
            int i = routeGuidanceGPSPoint.segmentIndex + 1;
            while (i < routeGuidanceGPSPoint2.segmentIndex) {
                i++;
                computeDistanceBetween += DDSphericalUtil.computeDistanceBetween(this.f30908j.get(i), this.f30908j.get(i));
            }
        }
        return routeGuidanceGPSPoint2.shapeOffSet > 0 ? computeDistanceBetween + DDSphericalUtil.computeDistanceBetween(this.f30908j.get(routeGuidanceGPSPoint2.segmentIndex), m23729a(routeGuidanceGPSPoint2.point)) : computeDistanceBetween;
    }

    /* renamed from: c */
    private void m23741c() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.f30914p;
        if (routeGuidanceGPSPoint != null && routeGuidanceGPSPoint.segmentIndex > -1 && this.f30908j != null && this.f30914p.segmentIndex < this.f30908j.size()) {
            double computeDistanceBetween = ((double) this.f30914p.shapeOffSet) / DDSphericalUtil.computeDistanceBetween(this.f30908j.get(this.f30914p.segmentIndex), this.f30908j.get(this.f30914p.segmentIndex + 1));
            if (computeDistanceBetween > 0.0d && computeDistanceBetween < 1.0d) {
                LatLng interpolate = DDSphericalUtil.interpolate(this.f30908j.get(this.f30914p.segmentIndex), this.f30908j.get(this.f30914p.segmentIndex + 1), computeDistanceBetween);
                this.f30914p.point = new GeoPoint((int) (interpolate.latitude * 1000000.0d), (int) (interpolate.longitude * 1000000.0d));
            }
            m23731a();
        }
    }

    /* renamed from: a */
    private LatLng m23729a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }

    /* renamed from: a */
    private GeoPoint m23730a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        return geoPoint;
    }

    /* renamed from: a */
    private GeoPoint[] m23738a(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        GeoPoint[] geoPointArr = new GeoPoint[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (list.get(i).latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (list.get(i).longitude * 1000000.0d));
            geoPointArr[i] = geoPoint;
        }
        return geoPointArr;
    }

    /* renamed from: a */
    private void m23732a(float f, long j, SctxStateEnum sctxStateEnum, boolean z) {
        double d;
        double d2;
        List<LatLng> list;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        long j2 = j;
        SctxStateEnum sctxStateEnum2 = sctxStateEnum;
        if (!z) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = this.f30916r;
            if (routeGuidanceGPSPoint2 != null && (routeGuidanceGPSPoint = this.f30917s) != null) {
                routeGuidanceGPSPoint2.timestamp = routeGuidanceGPSPoint.timestamp;
                this.f30916r.source = this.f30917s.source;
                m23739b(SctxStateEnum.INERTIA_LIMIT, 0);
                return;
            }
            return;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint3 = this.f30916r;
        if (routeGuidanceGPSPoint3 == null || routeGuidanceGPSPoint3.segmentIndex <= -1) {
            List<LatLng> list2 = this.f30908j;
            if (list2 != null && list2.size() > 0) {
                if (this.f30916r == null) {
                    this.f30916r = new RouteGuidanceGPSPoint();
                }
                this.f30916r.segmentIndex = 0;
                this.f30916r.shapeOffSet = 0;
                this.f30916r.point = m23730a(this.f30908j.get(0));
                if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                    this.f30916r.timestamp = System.currentTimeMillis() / 1000;
                } else {
                    this.f30916r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                }
                RouteGuidanceGPSPoint routeGuidanceGPSPoint4 = this.f30916r;
                RouteGuidanceGPSPoint routeGuidanceGPSPoint5 = this.f30917s;
                routeGuidanceGPSPoint4.source = routeGuidanceGPSPoint5 == null ? 0 : routeGuidanceGPSPoint5.source;
                m23734a(this.f30908j.get(0), this.f30916r.segmentIndex, this.f30916r.shapeOffSet, 0, 0, true, this.f30912n);
                m23739b(sctxStateEnum2, 0);
            }
        } else if (f == 0.0f) {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint6 = this.f30917s;
            if (routeGuidanceGPSPoint6 != null) {
                this.f30916r.timestamp = routeGuidanceGPSPoint6.timestamp;
                this.f30916r.source = this.f30917s.source;
                m23739b(sctxStateEnum2, 0);
            }
        } else {
            float f2 = (this.f30917s == null || (list = this.f30908j) == null || list.size() <= 0 || DDSphericalUtil.computeDistanceBetween(new LatLng(((double) this.f30917s.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30917s.point.getLongitudeE6()) / 1000000.0d), this.f30908j.get(0)) >= 10.0d) ? f : 1.0f;
            if (f2 > ((float) this.f30899A.getMaxSpeed())) {
                f2 = (float) this.f30899A.getMaxSpeed();
            }
            double d3 = 0.0d;
            double d4 = (double) (f2 * ((float) j2));
            int i = this.f30916r.segmentIndex + 1;
            while (i < this.f30908j.size()) {
                if (i == this.f30916r.segmentIndex + 1) {
                    d = DDSphericalUtil.computeDistanceBetween(m23729a(this.f30916r.point), this.f30908j.get(i));
                    d3 += d;
                    if (d3 > d4) {
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint7 = this.f30916r;
                        routeGuidanceGPSPoint7.shapeOffSet = (int) (((double) routeGuidanceGPSPoint7.shapeOffSet) + d4);
                        double d5 = d4;
                        LatLng a = m23728a(this.f30908j.get(this.f30916r.segmentIndex), this.f30908j.get(this.f30916r.segmentIndex + 1), ((double) this.f30916r.shapeOffSet) / (d + ((double) this.f30916r.shapeOffSet)));
                        this.f30916r.point = m23730a(a);
                        if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                            this.f30916r.timestamp = System.currentTimeMillis() / 1000;
                        } else {
                            this.f30916r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                        }
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint8 = this.f30916r;
                        RouteGuidanceGPSPoint routeGuidanceGPSPoint9 = this.f30917s;
                        routeGuidanceGPSPoint8.source = routeGuidanceGPSPoint9 == null ? 0 : routeGuidanceGPSPoint9.source;
                        int i2 = (int) d5;
                        m23734a(a, this.f30916r.segmentIndex, this.f30916r.shapeOffSet, i2, (int) j2, true, this.f30912n);
                        m23739b(sctxStateEnum2, i2);
                        return;
                    }
                    d2 = d4;
                } else {
                    d2 = d4;
                    d = DDSphericalUtil.computeDistanceBetween(this.f30908j.get(i - 1), this.f30908j.get(i));
                    d3 += d;
                }
                if (d3 > d2) {
                    this.f30916r.segmentIndex = i - 1;
                    this.f30916r.shapeOffSet = (int) ((d - d3) + d2);
                    if (!ApolloUtil.isSctxSimulationTimestampNTP() || !TimeServiceManager.getInstance().isNTPAvailable()) {
                        this.f30916r.timestamp = System.currentTimeMillis() / 1000;
                    } else {
                        this.f30916r.timestamp = TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000;
                    }
                    RouteGuidanceGPSPoint routeGuidanceGPSPoint10 = this.f30916r;
                    RouteGuidanceGPSPoint routeGuidanceGPSPoint11 = this.f30917s;
                    routeGuidanceGPSPoint10.source = routeGuidanceGPSPoint11 == null ? 0 : routeGuidanceGPSPoint11.source;
                    LatLng a2 = m23728a(this.f30908j.get(this.f30916r.segmentIndex), this.f30908j.get(this.f30916r.segmentIndex + 1), ((double) this.f30916r.shapeOffSet) / d);
                    this.f30916r.point = m23730a(a2);
                    int i3 = (int) d2;
                    m23734a(a2, this.f30916r.segmentIndex, this.f30916r.shapeOffSet, i3, (int) j2, true, this.f30912n);
                    m23739b(sctxStateEnum2, i3);
                    return;
                }
                i++;
                d4 = d2;
            }
        }
    }

    /* renamed from: a */
    private void m23734a(LatLng latLng, int i, int i2, int i3, int i4, boolean z, DMKEventPoint dMKEventPoint) {
        OnLocationMatched onLocationMatched = this.f30909k;
        if (onLocationMatched != null) {
            onLocationMatched.onMatched(latLng, i, i2, i3, i4, z, dMKEventPoint);
        }
    }

    /* renamed from: a */
    private void m23736a(SctxStateEnum sctxStateEnum, int i) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint;
        if (this.f30903E != null && (routeGuidanceGPSPoint = this.f30916r) != null && routeGuidanceGPSPoint.point != null && this.f30899A.isEvaluate() && this.f30921y) {
            AnimateNode animateNode = new AnimateNode(new LatLng(((double) this.f30916r.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30916r.point.getLongitudeE6()) / 1000000.0d), this.f30916r.segmentIndex, this.f30916r.shapeOffSet, false);
            AnimateNode animateNode2 = new AnimateNode(new LatLng(((double) this.f30914p.point.getLatitudeE6()) / 1000000.0d, ((double) this.f30914p.point.getLongitudeE6()) / 1000000.0d), this.f30914p.segmentIndex, this.f30914p.shapeOffSet, false);
            if (sctxStateEnum == SctxStateEnum.NORMAL) {
                this.f30903E.setUseablePoint(animateNode2);
                this.f30903E.setUsablePointTimestamp(System.currentTimeMillis());
            } else if (sctxStateEnum == SctxStateEnum.MATCH_SUCCESS_INERTIA) {
                this.f30903E.setUseablePoint(animateNode2);
                this.f30903E.setUsablePointTimestamp(System.currentTimeMillis());
                if (i > 0) {
                    this.f30903E.setCurrentPoint(animateNode);
                    this.f30903E.setCurrentPointTimestamp(System.currentTimeMillis());
                }
            } else if (i > 0) {
                if (this.f30903E.getStartPoint() == null) {
                    DLog.m10773d(f30889a, " handleSimulate, set startpoint state=" + sctxStateEnum + ",cartStandCount=" + this.f30919u, new Object[0]);
                    this.f30903E.reset();
                    this.f30903E.setStartPoint(animateNode);
                    this.f30903E.setStartPointTimestamp(System.currentTimeMillis());
                    this.f30903E.setSctxStateEnum(sctxStateEnum);
                    this.f30903E.setRepeatPoint(this.f30919u > 4);
                }
                this.f30903E.setCurrentPoint(animateNode);
                this.f30903E.setCurrentPointTimestamp(System.currentTimeMillis());
            }
            int hashCode = this.f30908j.hashCode();
            if (this.f30903E.getRouteCode() == 0) {
                this.f30903E.setRouteCode(hashCode);
                this.f30903E.setMockType(SimulateInfo.MockType.SIMULATINT_WAIT_ARRIVE_R);
            } else if (this.f30903E.getRouteCode() != hashCode) {
                DLog.m10773d(f30889a, " handleSimulate, routeCode changed.", new Object[0]);
                this.f30903E.setRouteCode(hashCode);
                this.f30903E.setMockType(SimulateInfo.MockType.SIMULATE_STOP_ON_OFFROUTE_JUMPTO_R);
            } else if (this.f30903E.mockType != SimulateInfo.MockType.SIMULATE_STOP_ON_OFFROUTE_JUMPTO_R && sctxStateEnum == SctxStateEnum.MATCH_SUCCESS_INERTIA) {
                this.f30903E.setMockType(SimulateInfo.MockType.SIMULATINT_OVER_R_POINT_WAIT_DRIVER_POINT);
            }
            if (this.f30902D != null && this.f30903E.isReportable()) {
                DLog.m10773d(f30889a, " handleSimulate, begin Simulateinfo report. mocktype=" + this.f30903E.getMockType() + ",state=" + sctxStateEnum, new Object[0]);
                this.f30902D.onReceiveSimulateInfo(this.f30903E);
                this.f30903E.setReported(true);
            }
            if (sctxStateEnum == SctxStateEnum.NORMAL) {
                this.f30903E.reset();
            }
        }
    }

    /* renamed from: a */
    private LatLng m23728a(LatLng latLng, LatLng latLng2, double d) {
        return DDSphericalUtil.interpolate(latLng, latLng2, d);
    }

    /* renamed from: b */
    private void m23739b(SctxStateEnum sctxStateEnum, int i) {
        if (this.f30916r != null) {
            m23735a(sctxStateEnum);
            SctxStateInfo sctxStateInfo = this.f30901C;
            if (sctxStateInfo != null && sctxStateInfo.getState() != null) {
                m23742d();
                m23743e();
                m23736a(this.f30901C.getState(), i);
            }
        }
    }

    /* renamed from: d */
    private void m23742d() {
        OnLocationMatched onLocationMatched = this.f30909k;
        if (onLocationMatched != null) {
            onLocationMatched.onSctxStateUpdate(this.f30901C);
        }
    }

    /* renamed from: e */
    private void m23743e() {
        if (this.f30902D != null && this.f30922z == 0) {
            CarMoveInfo carMoveInfo = new CarMoveInfo();
            carMoveInfo.localTime = System.currentTimeMillis() / 1000;
            carMoveInfo.gpsTime = this.f30916r.timestamp;
            if (this.f30916r.point != null) {
                DLog.m10773d(f30889a, "onMatchedAfter mReturnedGps= " + this.f30916r.toString(), new Object[0]);
                carMoveInfo.lat = ((double) this.f30916r.point.getLatitudeE6()) / 1000000.0d;
                carMoveInfo.lon = ((double) this.f30916r.point.getLongitudeE6()) / 1000000.0d;
            }
            carMoveInfo.type = this.f30901C.getState().type;
            carMoveInfo.source = this.f30916r.source;
            carMoveInfo.bindResult = getMapMatchType();
            this.f30902D.onReceiveCarMoveInfo(carMoveInfo);
        }
    }

    /* renamed from: a */
    private void m23735a(SctxStateEnum sctxStateEnum) {
        boolean z = false;
        if (this.f30900B == null || sctxStateEnum != SctxStateEnum.INERTIA_LIMIT) {
            this.f30900B = sctxStateEnum;
            this.f30901C.mo83748a(sctxStateEnum);
            this.f30901C.mo83749a(false);
            return;
        }
        int i = C108251.$SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum[this.f30900B.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            DLog.m10773d(f30889a, "reset SctxState,stateEnum=" + sctxStateEnum, new Object[0]);
            this.f30901C.mo83749a(false);
            this.f30900B = SctxStateEnum.KEEP_NOW_ON_LIMIT;
        } else {
            SctxStateInfo sctxStateInfo = this.f30901C;
            if (this.f30900B == SctxStateEnum.INERTIA_LIMIT) {
                z = true;
            }
            sctxStateInfo.mo83749a(z);
            this.f30900B = sctxStateEnum;
        }
        this.f30901C.mo83748a(this.f30900B);
    }

    /* renamed from: com.didi.map.sdk.nav.inertia.InertiaEngine$1 */
    static /* synthetic */ class C108251 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.sdk.nav.inertia.SctxStateEnum[] r0 = com.didi.map.sdk.nav.inertia.SctxStateEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum = r0
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.NOT_MOVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.MATCH_FAIL_INERTIA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.MATCH_SUCCESS_INERTIA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$inertia$SctxStateEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.sdk.nav.inertia.SctxStateEnum r1 = com.didi.map.sdk.nav.inertia.SctxStateEnum.KEEP_NOW_ON_LIMIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.inertia.InertiaEngine.C108251.<clinit>():void");
        }
    }

    public static boolean isNetWorkEnable(Context context) {
        if (context == null) {
            DLog.m10773d(f30889a, "isNetWorkEnable false 0", new Object[0]);
            return false;
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        DLog.m10773d(f30889a, "isNetWorkEnable false 1", new Object[0]);
        return false;
    }
}
