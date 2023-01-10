package com.didi.map.sdk.sharetrack.google.inner.net;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.HisTraj;
import com.didi.map.sdk.proto.driver_gl.LocationSource;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.google.inner.model.PickUpPoint;
import com.didi.map.sdk.sharetrack.google.inner.model.PointInfo;
import com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.C11013utils;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DUrl;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

public class FetcherManager {

    /* renamed from: a */
    private static final String f31285a = "FetcherManager";

    /* renamed from: b */
    private static final int f31286b = 0;

    /* renamed from: c */
    private static final int f31287c = 1;

    /* renamed from: d */
    private static final int f31288d = 2;

    /* renamed from: e */
    private static final int f31289e = 4;

    /* renamed from: f */
    private static final int f31290f = 5;

    /* renamed from: l */
    private static final int f31291l = 100000;

    /* renamed from: m */
    private static final int f31292m = 100;

    /* renamed from: A */
    private boolean f31293A = true;

    /* renamed from: B */
    private CallFrom f31294B;

    /* renamed from: C */
    private String f31295C = "";

    /* renamed from: D */
    private Handler f31296D = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (FetcherManager.this.f31300j == null || FetcherManager.this.f31300j.getStatus() == AsyncTask.Status.FINISHED) {
                    SctxRouteFetcher unused = FetcherManager.this.f31300j = new SctxRouteFetcher(FetcherManager.this.getRequireData(false, false), FetcherManager.this.f31311w);
                    FetcherManager.this.f31300j.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f31297g)});
                } else {
                    DLog.m23962d(FetcherManager.f31285a, "require eta busy", new Object[0]);
                }
                FetcherManager.this.m23939b();
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 5) {
                            if (FetcherManager.this.f31301k == null) {
                                FetcherManager.this.m23936a();
                                FetcherManager.this.f31301k.calculateRoute(FetcherManager.this.m23941c(), FetcherManager.this.f31309u);
                                return;
                            }
                            DLog.m23962d(FetcherManager.f31285a, "require offroute req busy", new Object[0]);
                        }
                    } else if (FetcherManager.this.f31301k == null) {
                        FetcherManager.this.m23936a();
                        FetcherManager.this.f31301k.calculateRoute(FetcherManager.this.m23941c(), FetcherManager.this.f31310v);
                    } else {
                        DLog.m23962d(FetcherManager.f31285a, "require offroute req busy", new Object[0]);
                    }
                } else if (FetcherManager.this.f31298h == null || FetcherManager.this.f31298h.getStatus() == AsyncTask.Status.FINISHED) {
                    SctxRouteFetcher unused2 = FetcherManager.this.f31298h = new SctxRouteFetcher(FetcherManager.this.getRequireData(false, true), FetcherManager.this.f31309u);
                    FetcherManager.this.f31298h.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f31297g)});
                } else {
                    DLog.m23962d(FetcherManager.f31285a, "require route busy", new Object[0]);
                }
            } else if (FetcherManager.this.f31299i == null || FetcherManager.this.f31299i.getStatus() == AsyncTask.Status.FINISHED) {
                SctxRouteFetcher unused3 = FetcherManager.this.f31299i = new SctxRouteFetcher(FetcherManager.this.getRequireData(true, true), FetcherManager.this.f31310v);
                FetcherManager.this.f31299i.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f31297g)});
            } else {
                DLog.m23962d(FetcherManager.f31285a, "require offroute req busy", new Object[0]);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f31297g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SctxRouteFetcher f31298h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SctxRouteFetcher f31299i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SctxRouteFetcher f31300j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public NormalRouteFetcherV2 f31301k;

    /* renamed from: n */
    private List<GpsLocation> f31302n;

    /* renamed from: o */
    private NaviRoute f31303o;

    /* renamed from: p */
    private long f31304p = 0;

    /* renamed from: q */
    private GpsLocation f31305q;

    /* renamed from: r */
    private LatLng f31306r;

    /* renamed from: s */
    private List<OrderPoint> f31307s;

    /* renamed from: t */
    private long f31308t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISearchRouteCallback f31309u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ISearchRouteCallback f31310v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public ISearchRouteCallback f31311w;

    /* renamed from: x */
    private OrderInfo f31312x;

    /* renamed from: y */
    private boolean f31313y = false;

    /* renamed from: z */
    private boolean f31314z = true;

    public FetcherManager(Context context) {
        this.f31297g = context;
    }

    public void setIsSctx(boolean z) {
        this.f31314z = z;
    }

    public void setMultiSctxGroup(String str) {
        this.f31295C = str;
    }

    public void setRecentLocList(List<GpsLocation> list) {
        this.f31302n = list;
    }

    public void setNaviRoute(NaviRoute naviRoute) {
        this.f31303o = naviRoute;
    }

    public void setRouteId(long j) {
        this.f31304p = j;
    }

    public void setStart(GpsLocation gpsLocation) {
        this.f31305q = gpsLocation;
    }

    public void setDest(LatLng latLng) {
        this.f31306r = latLng;
    }

    public void setPassPoints(List<OrderPoint> list) {
        this.f31307s = list;
    }

    public long getPassPointTimeStamp() {
        return this.f31308t;
    }

    public void setPassPointTimeStamp(long j) {
        this.f31308t = j;
    }

    public void setInnerSearchRouteCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f31309u = iSearchRouteCallback;
    }

    public void setInnerOffRouteSearchRouteCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f31310v = iSearchRouteCallback;
    }

    public void setInnerEtaCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f31311w = iSearchRouteCallback;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f31312x = orderInfo;
    }

    public void setShouldShowRoute(boolean z) {
        this.f31293A = z;
    }

    public void initRoute() {
        if (this.f31314z) {
            SctxRouteFetcher sctxRouteFetcher = new SctxRouteFetcher(getRequireData(false, true), this.f31309u);
            this.f31298h = sctxRouteFetcher;
            sctxRouteFetcher.execute(new String[]{DUrl.getOrderRouteUrl(this.f31297g)});
            DLog.m23962d(f31285a, "initRoute send require ok", new Object[0]);
            return;
        }
        m23936a();
        this.f31301k.calculateRoute(m23941c(), this.f31309u);
        DLog.m23962d(f31285a, "nav initRoute send require ok", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23936a() {
        if (this.f31301k == null) {
            this.f31301k = new NormalRouteFetcherV2(this.f31297g);
        }
        this.f31301k.setCaller(this.f31294B);
    }

    public void setCaller(CallFrom callFrom) {
        this.f31294B = callFrom;
    }

    public void additionalEtaReq() {
        SctxRouteFetcher sctxRouteFetcher = this.f31300j;
        if (sctxRouteFetcher == null || sctxRouteFetcher.getStatus() == AsyncTask.Status.FINISHED) {
            SctxRouteFetcher sctxRouteFetcher2 = new SctxRouteFetcher(getRequireData(false, false), (ISearchRouteCallback) null);
            this.f31300j = sctxRouteFetcher2;
            sctxRouteFetcher2.execute(new String[]{DUrl.getOrderRouteUrl(this.f31297g)});
            return;
        }
        DLog.m23962d(f31285a, "require eta busy", new Object[0]);
    }

    public boolean offRouteReq() {
        if (this.f31314z) {
            SctxRouteFetcher sctxRouteFetcher = this.f31299i;
            if (sctxRouteFetcher != null && sctxRouteFetcher.getStatus() != AsyncTask.Status.FINISHED) {
                return false;
            }
            SctxRouteFetcher sctxRouteFetcher2 = new SctxRouteFetcher(getRequireData(true, true), this.f31310v);
            this.f31299i = sctxRouteFetcher2;
            sctxRouteFetcher2.execute(new String[]{DUrl.getOrderRouteUrl(this.f31297g)});
            DLog.m23962d(f31285a, "onOffRoute send require ok", new Object[0]);
            return true;
        } else if (this.f31301k != null) {
            return false;
        } else {
            m23936a();
            this.f31301k.calculateRoute(m23941c(), this.f31310v);
            DLog.m23962d(f31285a, "nav onOffRoute send require ok", new Object[0]);
            return true;
        }
    }

    public void stop() {
        SctxRouteFetcher sctxRouteFetcher = this.f31299i;
        if (sctxRouteFetcher != null) {
            sctxRouteFetcher.cancel(true);
            this.f31299i = null;
        }
        SctxRouteFetcher sctxRouteFetcher2 = this.f31300j;
        if (sctxRouteFetcher2 != null) {
            sctxRouteFetcher2.cancel(true);
            this.f31300j = null;
        }
        SctxRouteFetcher sctxRouteFetcher3 = this.f31298h;
        if (sctxRouteFetcher3 != null) {
            sctxRouteFetcher3.cancel(true);
            this.f31298h = null;
        }
        if (this.f31301k != null) {
            this.f31301k = null;
        }
        Handler handler = this.f31296D;
        if (handler != null) {
            handler.removeMessages(0);
            this.f31296D.removeMessages(1);
            this.f31296D.removeMessages(2);
            this.f31296D.removeMessages(4);
            this.f31296D.removeMessages(5);
        }
    }

    public void destroy() {
        this.f31298h = null;
        this.f31300j = null;
        this.f31299i = null;
        this.f31301k = null;
        this.f31296D = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23939b() {
        if (!this.f31314z) {
            DLog.m23962d(f31285a, "updateEta， return because mIsSctx is false", new Object[0]);
            return;
        }
        OrderInfo orderInfo = this.f31312x;
        if (orderInfo == null || orderInfo.getOrderStage() != 2) {
            Handler handler = this.f31296D;
            if (handler == null || this.f31312x == null) {
                DLog.m23962d(f31285a, "updateEta error start fail", new Object[0]);
                return;
            }
            handler.removeMessages(0);
            this.f31296D.sendEmptyMessageDelayed(0, (long) ApolloUtils.getEtaInterval(this.f31312x.getOrderStage()));
            this.f31313y = true;
            return;
        }
        DLog.m23962d(f31285a, "updateEta， return because orderStage is 2", new Object[0]);
    }

    public void startEta() {
        DLog.m23962d(f31285a, "startEta enter", new Object[0]);
        if (this.f31314z && !this.f31313y) {
            m23939b();
        }
    }

    public void CancelEta() {
        if (!this.f31314z) {
            DLog.m23962d(f31285a, "CancelEta， return because mIsSctx is false", new Object[0]);
            return;
        }
        OrderInfo orderInfo = this.f31312x;
        if (orderInfo == null || orderInfo.getOrderStage() != 2) {
            this.f31313y = false;
            Handler handler = this.f31296D;
            if (handler != null) {
                handler.removeMessages(0);
                return;
            }
            return;
        }
        DLog.m23962d(f31285a, "CancelEta， return because orderStage is 2", new Object[0]);
    }

    public void updateRoute(long j) {
        Handler handler = this.f31296D;
        if (handler != null && j > 0) {
            int i = 2;
            handler.removeMessages(this.f31314z ? 2 : 5);
            Handler handler2 = this.f31296D;
            if (!this.f31314z) {
                i = 5;
            }
            handler2.sendEmptyMessageDelayed(i, j * 1000);
        }
    }

    public void offRouteTryAgain() {
        Handler handler = this.f31296D;
        if (handler != null) {
            boolean z = this.f31314z;
            handler.removeMessages(1);
            Handler handler2 = this.f31296D;
            boolean z2 = this.f31314z;
            handler2.sendEmptyMessageDelayed(1, 1000);
        }
    }

    public DriverOrderRouteReq getRequireData(boolean z, boolean z2) {
        DriverOrderRouteReq.Builder builder = new DriverOrderRouteReq.Builder();
        String driverPhoneNumber = PlatInfo.getInstance().getDriverPhoneNumber();
        if (driverPhoneNumber == null || driverPhoneNumber.isEmpty()) {
            driverPhoneNumber = "0";
        }
        builder.ticket(PlatInfo.getInstance().getDriverTicket()).phoneNum(driverPhoneNumber).driverId(Long.valueOf(PlatInfo.getInstance().getDriverId())).traverId(PlatInfo.getInstance().getTraverId());
        if (this.f31305q != null) {
            builder.startPoint(new DoublePoint.Builder().dlat(Double.valueOf(this.f31305q.latitude)).dlng(Double.valueOf(this.f31305q.longitude)).lat(Float.valueOf((float) this.f31305q.latitude)).lng(Float.valueOf((float) this.f31305q.longitude)).accuracy(Double.valueOf((double) this.f31305q.accuracy)).timestamp(Long.valueOf(this.f31305q.time / 1000)).gpsTimestamp(Long.valueOf(this.f31305q.time / 1000)).speed(Integer.valueOf((int) this.f31305q.velocity)).gpsSource(getLocationSrc(this.f31305q.provider)).build()).startPointAccuracy(0).startPointDirection(Integer.valueOf(((int) (this.f31305q.direction + 360.0f)) % 360)).startPointSpeed(0);
        }
        if (this.f31306r != null) {
            builder.endPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f31306r.latitude)).lng(Float.valueOf((float) this.f31306r.longitude)).build());
        }
        if (this.f31307s != null) {
            ArrayList arrayList = new ArrayList();
            for (OrderPoint next : this.f31307s) {
                if (!(next == null || next.point == null)) {
                    arrayList.add(new OdPoint(Long.valueOf(next.orderId), Integer.valueOf(next.orderType), new DoublePoint.Builder().lat(Float.valueOf((float) next.point.latitude)).lng(Float.valueOf((float) next.point.longitude)).build(), next.strOrderId, Integer.valueOf(next.pointType), Float.valueOf(0.0f), 0, (DoublePoint) null, ""));
                }
            }
            builder.odPoints(arrayList);
        }
        long j = this.f31308t;
        if (j > 0) {
            builder.odPointsTimestamp(Long.valueOf(j));
        }
        byte[] bytes = m23946e().getBytes();
        DriverOrderRouteReq.Builder timestamp = builder.eventType(Integer.valueOf(z ? 1 : 0)).timestamp(Long.valueOf(System.currentTimeMillis()));
        OrderInfo orderInfo = this.f31312x;
        DriverOrderRouteReq.Builder bizType = timestamp.orderId(orderInfo == null ? "" : orderInfo.getOrderId()).bizType(Integer.valueOf(PlatInfo.getInstance().getBizType()));
        OrderInfo orderInfo2 = this.f31312x;
        DriverOrderRouteReq.Builder sdkmaptype = bizType.orderStage(Integer.valueOf(orderInfo2 == null ? 0 : orderInfo2.getOrderStage())).countryId(PlatInfo.getInstance().getCountryCode()).productId(String.valueOf(PlatInfo.getInstance().getBizType())).imei(C11013utils.getImei(this.f31297g)).routeEngineReqPack(ByteString.m6997of(bytes)).version("5").sdkmaptype("google");
        NaviRoute naviRoute = this.f31303o;
        sdkmaptype.curRouteId(Long.valueOf((naviRoute == null || naviRoute.getRouteId() == null) ? this.f31304p : Long.valueOf(this.f31303o.getRouteId()).longValue())).didiVersion(PlatInfo.getInstance().getClientVersion());
        builder.noNeedGeo(Boolean.valueOf(!z2));
        builder.trajs(getHisTraj(this.f31302n));
        try {
            DriverOrderRouteReq build = builder.build();
            DLog.m23962d(f31285a, "getRequireData %s", build.toString());
            return build;
        } catch (Exception e) {
            DLog.m23962d(f31285a, "getRequireData Exception:" + e.toString(), new Object[0]);
            return null;
        }
    }

    public PickUpPoint getPickupPoint(LatLng latLng, int i) {
        if (latLng == null) {
            return null;
        }
        PickUpPoint pickUpPoint = new PickUpPoint();
        pickUpPoint.app_version = PlatInfo.getInstance().getClientVersion();
        Context context = this.f31297g;
        pickUpPoint.app_id = (context == null || context.getApplicationContext() == null) ? "" : this.f31297g.getApplicationContext().getPackageName();
        pickUpPoint.lang = C11013utils.getUsingLanguage(this.f31297g);
        OrderInfo orderInfo = this.f31312x;
        if (orderInfo != null) {
            pickUpPoint.order_id = orderInfo.getOrderId();
        }
        pickUpPoint.token = PlatInfo.getInstance().getDriverTicket();
        pickUpPoint.data = new PointInfo();
        pickUpPoint.data.driver_id = String.valueOf(PlatInfo.getInstance().getDriverId());
        pickUpPoint.data.lat = latLng.latitude;
        pickUpPoint.data.lng = latLng.longitude;
        pickUpPoint.data.accuracy = i;
        DLog.m23962d(f31285a, "getPickupPoint %s", pickUpPoint.toString());
        return pickUpPoint;
    }

    public static LocationSource getLocationSrc(String str) {
        if (TextUtils.isEmpty(str)) {
            return LocationSource.Unknown;
        }
        if (str.equalsIgnoreCase("gps")) {
            return LocationSource.GPS;
        }
        if (str.equalsIgnoreCase(DIDILocation.NLP_PROVIDER)) {
            return LocationSource.Network;
        }
        return LocationSource.Unknown;
    }

    public static HisTraj getHisTraj(List<GpsLocation> list) {
        int i;
        ArrayList arrayList;
        List<GpsLocation> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        HisTraj.Builder builder = new HisTraj.Builder();
        DiffGeoPoints.Builder builder2 = new DiffGeoPoints.Builder();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            GpsLocation gpsLocation = list2.get(i2);
            arrayList2.add(Float.valueOf((float) gpsLocation.accuracy));
            arrayList3.add(Integer.valueOf(((int) (gpsLocation.direction + 360.0f)) % 360));
            arrayList4.add(Integer.valueOf((int) gpsLocation.velocity));
            ArrayList arrayList9 = arrayList3;
            ArrayList arrayList10 = arrayList4;
            arrayList5.add(Long.valueOf(gpsLocation.time / 1000));
            arrayList6.add(getLocationSrc(gpsLocation.provider));
            if (i2 > 0) {
                GpsLocation gpsLocation2 = list2.get(i2 - 1);
                arrayList = arrayList5;
                Integer valueOf = Integer.valueOf((int) ((gpsLocation.latitude - gpsLocation2.latitude) * 100000.0d * 100.0d));
                i = size;
                Integer valueOf2 = Integer.valueOf((int) ((gpsLocation.longitude - gpsLocation2.longitude) * 100000.0d * 100.0d));
                arrayList7.add(valueOf);
                arrayList8.add(valueOf2);
            } else {
                arrayList = arrayList5;
                i = size;
            }
            i2++;
            arrayList3 = arrayList9;
            arrayList4 = arrayList10;
            arrayList5 = arrayList;
            size = i;
        }
        ArrayList arrayList11 = arrayList3;
        ArrayList arrayList12 = arrayList4;
        DoublePoint.Builder builder3 = new DoublePoint.Builder();
        GpsLocation gpsLocation3 = list2.get(0);
        double d = gpsLocation3.latitude * 100000.0d;
        double d2 = gpsLocation3.longitude * 100000.0d;
        builder3.dlat(Double.valueOf(d)).dlng(Double.valueOf(d2)).lat(Float.valueOf((float) d)).lng(Float.valueOf((float) d2)).accuracy(Double.valueOf((double) gpsLocation3.accuracy)).timestamp(Long.valueOf(gpsLocation3.time / 1000)).gpsTimestamp(Long.valueOf(gpsLocation3.time / 1000)).speed(Integer.valueOf((int) gpsLocation3.velocity)).gpsSource(getLocationSrc(gpsLocation3.provider));
        builder2.base(builder3.build()).dlats(arrayList7).dlngs(arrayList8);
        builder.hisAccuracy(arrayList2).hisDirection(arrayList11).hisSpeed(arrayList12).hisTimestamp(arrayList5).historyTraj(builder2.build()).hisLocationSource(arrayList6);
        return builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RouteSearchOptions m23941c() {
        return new RouteSearchOptions(new LatLng(this.f31305q.latitude, this.f31305q.longitude), this.f31306r);
    }

    /* renamed from: d */
    private String m23943d() {
        String str = "is_yaw_reject=" + ApolloUtils.isServerRejectYaw() + "&yaw_version=" + ApolloUtils.getYawModelType();
        DLog.m23962d(f31285a, "isArrived: " + str, new Object[0]);
        return str;
    }

    /* renamed from: e */
    private String m23946e() {
        String d = m23943d();
        if (!TextUtils.isEmpty(this.f31295C)) {
            d = d + ParamKeys.SIGN_AND + this.f31295C;
        }
        DLog.m23962d(f31285a, "RouteEngineParam = " + d, new Object[0]);
        return d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0271 A[Catch:{ Exception -> 0x02af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushEdaToServer(int r19) {
        /*
            r18 = this;
            r0 = r18
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x02af }
            r1.<init>()     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "eda"
            r3 = r19
            r1.put(r2, r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r2 = new com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder     // Catch:{ Exception -> 0x02af }
            r2.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r3 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.getDriverTicket()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r2.ticket(r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.getDriverPhoneNumber()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.phoneNum(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            long r4 = r4.getDriverId()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.driverId(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.getTraverId()     // Catch:{ Exception -> 0x02af }
            r3.traverId(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r3 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            r4 = 0
            if (r3 == 0) goto L_0x00ed
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.dlat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.dlng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            int r5 = r5.accuracy     // Catch:{ Exception -> 0x02af }
            double r5 = (double) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.accuracy(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            long r5 = r5.time     // Catch:{ Exception -> 0x02af }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.timestamp(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            long r5 = r5.time     // Catch:{ Exception -> 0x02af }
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.gpsTimestamp(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            float r5 = r5.velocity     // Catch:{ Exception -> 0x02af }
            int r5 = (int) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.speed(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.provider     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.LocationSource r5 = getLocationSrc(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.gpsSource(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r3.build()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r2.startPoint(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.startPointAccuracy(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f31305q     // Catch:{ Exception -> 0x02af }
            float r5 = r5.direction     // Catch:{ Exception -> 0x02af }
            r6 = 1135869952(0x43b40000, float:360.0)
            float r5 = r5 + r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x02af }
            int r5 = r5 % 360
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.startPointDirection(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            r3.startPointSpeed(r5)     // Catch:{ Exception -> 0x02af }
        L_0x00ed:
            com.didi.common.map.model.LatLng r3 = r0.f31306r     // Catch:{ Exception -> 0x02af }
            if (r3 == 0) goto L_0x0117
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r5 = r0.f31306r     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r5 = r0.f31306r     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r3.build()     // Catch:{ Exception -> 0x02af }
            r2.endPoint(r3)     // Catch:{ Exception -> 0x02af }
        L_0x0117:
            java.util.List<com.didi.map.sdk.sharetrack.entity.OrderPoint> r3 = r0.f31307s     // Catch:{ Exception -> 0x02af }
            if (r3 == 0) goto L_0x0189
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            java.util.List<com.didi.map.sdk.sharetrack.entity.OrderPoint> r5 = r0.f31307s     // Catch:{ Exception -> 0x02af }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x02af }
        L_0x0126:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x02af }
            if (r6 == 0) goto L_0x0186
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderPoint r6 = (com.didi.map.sdk.sharetrack.entity.OrderPoint) r6     // Catch:{ Exception -> 0x02af }
            if (r6 == 0) goto L_0x0126
            com.didi.common.map.model.LatLng r7 = r6.point     // Catch:{ Exception -> 0x02af }
            if (r7 == 0) goto L_0x0126
            com.didi.map.sdk.proto.driver_gl.OdPoint r7 = new com.didi.map.sdk.proto.driver_gl.OdPoint     // Catch:{ Exception -> 0x02af }
            long r8 = r6.orderId     // Catch:{ Exception -> 0x02af }
            java.lang.Long r9 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x02af }
            int r8 = r6.orderType     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r8.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r11 = r6.point     // Catch:{ Exception -> 0x02af }
            double r11 = r11.latitude     // Catch:{ Exception -> 0x02af }
            float r11 = (float) r11     // Catch:{ Exception -> 0x02af }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = r8.lat(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r11 = r6.point     // Catch:{ Exception -> 0x02af }
            double r11 = r11.longitude     // Catch:{ Exception -> 0x02af }
            float r11 = (float) r11     // Catch:{ Exception -> 0x02af }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = r8.lng(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r11 = r8.build()     // Catch:{ Exception -> 0x02af }
            java.lang.String r12 = r6.strOrderId     // Catch:{ Exception -> 0x02af }
            int r6 = r6.pointType     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            r6 = 0
            java.lang.Float r14 = java.lang.Float.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            r16 = 0
            java.lang.String r17 = ""
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x02af }
            r3.add(r7)     // Catch:{ Exception -> 0x02af }
            goto L_0x0126
        L_0x0186:
            r2.odPoints(r3)     // Catch:{ Exception -> 0x02af }
        L_0x0189:
            long r5 = r0.f31308t     // Catch:{ Exception -> 0x02af }
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x019a
            long r5 = r0.f31308t     // Catch:{ Exception -> 0x02af }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            r2.odPointsTimestamp(r3)     // Catch:{ Exception -> 0x02af }
        L_0x019a:
            java.lang.String r3 = r18.m23946e()     // Catch:{ Exception -> 0x02af }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r2.eventType(r5)     // Catch:{ Exception -> 0x02af }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.timestamp(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f31312x     // Catch:{ Exception -> 0x02af }
            if (r6 != 0) goto L_0x01bd
            java.lang.String r6 = ""
            goto L_0x01c3
        L_0x01bd:
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f31312x     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.getOrderId()     // Catch:{ Exception -> 0x02af }
        L_0x01c3:
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.orderId(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getBizType()     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.bizType(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f31312x     // Catch:{ Exception -> 0x02af }
            if (r6 != 0) goto L_0x01dd
            r6 = 0
            goto L_0x01e3
        L_0x01dd:
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f31312x     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getOrderStage()     // Catch:{ Exception -> 0x02af }
        L_0x01e3:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.orderStage(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.getCountryCode()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.countryId(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getBizType()     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.productId(r6)     // Catch:{ Exception -> 0x02af }
            android.content.Context r6 = r0.f31297g     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = com.didi.map.sdk.sharetrack.google.inner.utils.C11013utils.getImei(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.imei(r6)     // Catch:{ Exception -> 0x02af }
            okio.ByteString r3 = okio.ByteString.m6997of((byte[]) r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r5.routeEngineReqPack(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "5"
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.version(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "google"
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.sdkmaptype(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f31303o     // Catch:{ Exception -> 0x02af }
            if (r5 == 0) goto L_0x0241
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f31303o     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getRouteId()     // Catch:{ Exception -> 0x02af }
            if (r5 != 0) goto L_0x0232
            goto L_0x0241
        L_0x0232:
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f31303o     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getRouteId()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x02af }
            goto L_0x0243
        L_0x0241:
            long r5 = r0.f31304p     // Catch:{ Exception -> 0x02af }
        L_0x0243:
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.curRouteId(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r5 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getClientVersion()     // Catch:{ Exception -> 0x02af }
            r3.didiVersion(r5)     // Catch:{ Exception -> 0x02af }
            r3 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x02af }
            r2.noNeedGeo(r5)     // Catch:{ Exception -> 0x02af }
            java.util.List<com.didi.common.map.model.GpsLocation> r5 = r0.f31302n     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.HisTraj r5 = getHisTraj(r5)     // Catch:{ Exception -> 0x02af }
            r2.trajs(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x02af }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02af }
            if (r5 != 0) goto L_0x0280
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02af }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x02af }
            okio.ByteString r1 = okio.ByteString.m6997of((byte[]) r1)     // Catch:{ Exception -> 0x02af }
            r2.extendData(r1)     // Catch:{ Exception -> 0x02af }
        L_0x0280:
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq r1 = r2.build()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.google.inner.net.SctxRouteFetcher r2 = new com.didi.map.sdk.sharetrack.google.inner.net.SctxRouteFetcher     // Catch:{ Exception -> 0x02af }
            r5 = 0
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x02af }
            android.content.Context r5 = r0.f31297g     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = com.didi.map.sdk.sharetrack.net.DUrl.getOrderRouteUrl(r5)     // Catch:{ Exception -> 0x02af }
            r3[r4] = r5     // Catch:{ Exception -> 0x02af }
            r2.execute(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "FetcherManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "push eda to server = "
            r3.append(r5)     // Catch:{ Exception -> 0x02af }
            r3.append(r1)     // Catch:{ Exception -> 0x02af }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x02af }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.logger.DLog.m23962d(r2, r1, r3)     // Catch:{ Exception -> 0x02af }
        L_0x02af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager.pushEdaToServer(int):void");
    }
}
