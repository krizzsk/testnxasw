package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.OrderRouteEngineResPack;
import com.didi.map.global.sctx.model.PushInfo;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.server.IDataCallback;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.global.sctx.server.SctxDataProviderFactory;
import com.didi.map.google.util.DUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import java.lang.ref.WeakReference;

public class SctxOraService {

    /* renamed from: a */
    private static final String f29327a = "OrderFloatWindow";

    /* renamed from: b */
    private ISctxDataProvider f29328b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WeakReference<Context> f29329c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f29330d;

    /* renamed from: e */
    private ServingParam f29331e;

    /* renamed from: f */
    private int f29332f;

    /* renamed from: g */
    private String f29333g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OrderRouteEngineResPack f29334h = new OrderRouteEngineResPack();
    public LatLng mVamosDriverTripDestPoint;

    public SctxOraService(WeakReference<Context> weakReference) {
        this.f29329c = weakReference;
        ISctxDataProvider createSctxDataProvider = SctxDataProviderFactory.createSctxDataProvider(m22746a(), (RuntimeErrorCollect) null, (SctxCaseParser) null);
        this.f29328b = createSctxDataProvider;
        createSctxDataProvider.setCallback(m22752d());
        this.f29328b.setInterval(3000);
    }

    public void start() {
        if (!this.f29328b.isRunning()) {
            this.f29328b.startSync();
        }
    }

    public void resume() {
        this.f29328b.resumeSync();
    }

    public void pause() {
        this.f29328b.pauseSync();
    }

    public void stop() {
        this.f29330d = 0;
        this.f29328b.stopSync();
    }

    public boolean isRunning() {
        return this.f29328b.isRunning();
    }

    public void setServingParam(ServingParam servingParam) {
        this.f29331e = servingParam;
    }

    public void setMapSdkType(String str) {
        this.f29333g = str;
    }

    public void setTripState(int i) {
        this.f29332f = i;
    }

    /* renamed from: a */
    private ISctxDataProvider.DataSearchOptions m22746a() {
        return new ISctxDataProvider.DataSearchOptions() {
            public PushInfo getPushInfo() {
                return null;
            }

            public PassengerOrderRouteReq getRequestBody() {
                return SctxOraService.this.getOraRequestBytes();
            }

            public String getUrl() {
                return SctxOraService.getOraRequestUrl();
            }

            public Context getContext() {
                if (SctxOraService.this.f29329c == null || SctxOraService.this.f29329c.get() == null) {
                    return null;
                }
                return ((Context) SctxOraService.this.f29329c.get()).getApplicationContext();
            }
        };
    }

    public static String getOraRequestUrl() {
        try {
            IExperiment experiment = Apollo.getToggle("global_passenger_route_url_toggle").getExperiment();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((String) experiment.getParam("ora_url_host", "https://apimap.didiglobal.com"));
            stringBuffer.append((String) experiment.getParam("ora_url_path", "/navi/v1/passenger/orderroute/"));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public PassengerOrderRouteReq getOraRequestBytes() {
        try {
            if (TextUtils.isEmpty(this.f29333g)) {
                DLog.m10773d(f29327a, "map sdk type is null", new Object[0]);
                return null;
            } else if (this.f29331e == null) {
                DLog.m10773d(f29327a, "serving param is null", new Object[0]);
                return null;
            } else if (this.f29332f == 0) {
                DLog.m10773d(f29327a, "trip state error", new Object[0]);
                return null;
            } else {
                String token = PaxEnvironment.getInstance().getToken();
                if (TextUtils.isEmpty(token)) {
                    return null;
                }
                PassengerOrderRouteReq.Builder builder = new PassengerOrderRouteReq.Builder();
                LatLng b = m22749b();
                if (b != null) {
                    builder.pickupEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) b.latitude)).lng(Float.valueOf((float) b.longitude)).build());
                }
                LatLng c = m22751c();
                if (c != null) {
                    builder.orderEndPoint(new DoublePoint.Builder().lat(Float.valueOf((float) c.latitude)).lng(Float.valueOf((float) c.longitude)).build());
                }
                if (this.mVamosDriverTripDestPoint != null) {
                    builder.destPoint(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf((float) this.mVamosDriverTripDestPoint.latitude)).lng(Float.valueOf((float) this.mVamosDriverTripDestPoint.longitude)).build()).build());
                }
                boolean z = this.f29331e.getOrderParams() != null;
                String str = "";
                PassengerOrderRouteReq.Builder lang = builder.orderId(z ? this.f29331e.getOrderParams().orderId : str).orderStage(Integer.valueOf(this.f29332f)).bizType(Integer.valueOf(this.f29331e.getOrderParams().productID != null ? Integer.valueOf(this.f29331e.getOrderParams().productID).intValue() : 0)).travelMode(TravelMode.DRIVING).isNeedTraj(false).version("5").token(token).phoneNum(z ? this.f29331e.getOrderParams().phoneNumPassenger : str).driverId(Long.valueOf(z ? this.f29331e.getOrderParams().driverId : 0)).curRouteId(Long.valueOf(this.f29330d)).imei(this.f29331e.getClientParams() == null ? str : this.f29331e.getClientParams().imei).timestamp(Long.valueOf(System.currentTimeMillis())).didiVersion(this.f29331e.getClientParams() == null ? str : this.f29331e.getClientParams().clientVersion).lastOrderId(z ? this.f29331e.getOrderParams().lastOrderId : str).noNeedGeo(false).productId(String.valueOf(this.f29331e.getOrderParams().productID != null ? Integer.valueOf(this.f29331e.getOrderParams().productID).intValue() : 0)).countryId(this.f29331e.getClientParams() == null ? str : this.f29331e.getClientParams().countryId).sdkmaptype(this.f29333g).lang(LocaleCodeHolder.getInstance().getCurrentLang());
                if (z) {
                    str = this.f29331e.getOrderParams().travelId;
                }
                lang.travelId(str).recPPState(0).psgPoint(DUtils.getLocation(this.f29329c != null ? (Context) this.f29329c.get() : null)).pushBtMsg(false).bizGroup(0);
                builder.readOnly(Boolean.valueOf(this.f29331e.bReadOnly()));
                return builder.build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private LatLng m22749b() {
        CommonMarkerParam markerParam;
        ServingParam servingParam = this.f29331e;
        if (servingParam == null || (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START)) == null) {
            return null;
        }
        return markerParam.getPoint();
    }

    /* renamed from: c */
    private LatLng m22751c() {
        CommonMarkerParam markerParam;
        ServingParam servingParam = this.f29331e;
        if (servingParam == null || (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_END)) == null) {
            return null;
        }
        return markerParam.getPoint();
    }

    /* renamed from: d */
    private IDataCallback m22752d() {
        return new IDataCallback() {
            public void onError(String str) {
            }

            public void onStart() {
            }

            public void onSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (mapPassengeOrderRouteRes != null) {
                    SctxOraService.this.f29334h.parseFrom(mapPassengeOrderRouteRes);
                    if (SctxOraService.this.f29334h.serverStage == 5) {
                        SctxOraService.this.stop();
                        DLog.m10773d(SctxOraService.f29327a, "order finish hidden.", new Object[0]);
                        OrderFloatWindowManager.Instance().hidden();
                        OrderFloatWindowManager.Instance().resetState();
                    }
                    long unused = SctxOraService.this.f29330d = mapPassengeOrderRouteRes.routeId == null ? 0 : mapPassengeOrderRouteRes.routeId.longValue();
                    if (mapPassengeOrderRouteRes.eta != null && mapPassengeOrderRouteRes.eta.intValue() >= 0 && mapPassengeOrderRouteRes.distance != null && mapPassengeOrderRouteRes.distance.intValue() >= 0) {
                        OrderFloatWindowManager.Instance().updateEtaEda(mapPassengeOrderRouteRes.eta.intValue(), mapPassengeOrderRouteRes.distance.intValue());
                    }
                }
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m22748a(int r5) {
        /*
            r4 = this;
            int r0 = r4.f29332f
            r1 = 0
            if (r5 <= 0) goto L_0x001f
            if (r0 <= 0) goto L_0x001f
            r2 = 3
            r3 = 1
            if (r0 != r2) goto L_0x0019
            boolean r0 = r4.m22753e()
            if (r0 == 0) goto L_0x0015
            r0 = 2
            if (r5 <= r0) goto L_0x001f
            goto L_0x0017
        L_0x0015:
            if (r5 <= r3) goto L_0x001f
        L_0x0017:
            r1 = 1
            goto L_0x001f
        L_0x0019:
            r2 = 4
            if (r0 != r2) goto L_0x001f
            if (r5 <= r2) goto L_0x001f
            goto L_0x0017
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.SctxOraService.m22748a(int):boolean");
    }

    /* renamed from: e */
    private boolean m22753e() {
        ServingParam servingParam = this.f29331e;
        if (servingParam == null) {
            return false;
        }
        if (!(servingParam.getOrderParams() != null) || this.f29331e.getOrderParams().orderStage != 1) {
            return false;
        }
        return true;
    }
}
