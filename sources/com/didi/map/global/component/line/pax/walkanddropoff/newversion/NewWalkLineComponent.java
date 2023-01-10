package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didi.map.intl.commonwalkengine.IWalkEngine;
import com.didi.map.intl.commonwalkengine.WalkEngineType;
import com.didi.map.intl.commonwalkengine.WalkEngineWrapper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.OrderWalkingRes;
import com.didi.map.sdk.proto.driver_gl.VisitorInfo;
import com.didi.map.sdk.proto.driver_gl.WalkScene;
import com.didi.map.sdk.proto.driver_gl.WalkState;
import com.didi.map.sdk.proto.driver_gl.enumOSType;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.walk.IWalkNavRouteSearchApi;
import com.didichuxing.routesearchsdk.walk.WalkNavRouteSearchCallback;
import com.didichuxing.routesearchsdk.walk.WalkNavRouteSearchParam;
import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NewWalkLineComponent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f28202a = "NewWalkLineComponent";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICompLineContract f28203b;

    /* renamed from: c */
    private Map f28204c;

    /* renamed from: d */
    private Context f28205d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IWalkEngine f28206e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f28207f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f28208g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public NewWalkParam f28209h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f28210i;

    /* renamed from: j */
    private DIDILocationListener f28211j;

    /* renamed from: k */
    private PsgLocationMarker f28212k;

    /* renamed from: l */
    private IWalkNavRouteSearchApi f28213l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IWalkNavRouteSearchApi f28214m;

    /* renamed from: n */
    private Handler f28215n = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LatLng f28216o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List<LatLng> f28217p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f28218q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f28219r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f28220s = false;

    public void create(Context context, Map map, NewWalkParam newWalkParam) {
        this.f28204c = map;
        this.f28205d = context;
        this.f28209h = newWalkParam;
        m22121a(false);
        this.f28212k = new PsgLocationMarker(this.f28205d, this.f28204c);
        C103041 r3 = new DIDILocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation != null) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (!LatLngUtils.locateCorrect(latLng)) {
                        return;
                    }
                    if (NewWalkLineComponent.this.f28219r) {
                        if (NewWalkLineComponent.this.f28220s) {
                            String c = NewWalkLineComponent.this.f28202a;
                            DLog.m10773d(c, "------>定位绑路点" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                        }
                        if (NewWalkLineComponent.this.f28206e != null) {
                            NewWalkLineComponent.this.f28206e.getMatchPoint(NewWalkLineComponent.this.m22112a(dIDILocation));
                        }
                    } else if (NewWalkLineComponent.this.f28203b != null && NewWalkLineComponent.this.f28209h != null) {
                        List allLinePoints = NewWalkLineComponent.this.f28203b.getAllLinePoints();
                        if (allLinePoints == null) {
                            allLinePoints = new ArrayList();
                        } else {
                            allLinePoints.clear();
                        }
                        allLinePoints.add(latLng);
                        allLinePoints.add(NewWalkLineComponent.this.f28209h.getEndPoint());
                        NewWalkLineComponent.this.m22126b((List<LatLng>) allLinePoints);
                        NewWalkLineComponent.this.m22114a(latLng);
                    }
                }
            }
        };
        this.f28211j = r3;
        LocationHelper2.registerListener(this.f28205d, r3, new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP));
        m22113a();
    }

    public void updateStartPoint(LatLng latLng) {
        NewWalkParam newWalkParam;
        if (!LatLngUtils.locateCorrect(latLng) || (newWalkParam = this.f28209h) == null) {
            return;
        }
        if (!LatLngUtils.isSameLatLng(latLng, newWalkParam.getEndPoint())) {
            DLog.m10773d(this.f28202a, "updateStartPoint-> 终点更新", new Object[0]);
            this.f28209h.setEndPoint(latLng);
            m22121a(false);
            return;
        }
        DLog.m10773d(this.f28202a, "updateStartPoint-> 终点相同", new Object[0]);
    }

    public void destroy() {
        DLog.m10773d(this.f28202a, "destroy", new Object[0]);
        this.f28208g = true;
        ICompLineContract iCompLineContract = this.f28203b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f28203b = null;
        }
        PsgLocationMarker psgLocationMarker = this.f28212k;
        if (psgLocationMarker != null) {
            psgLocationMarker.destroy();
            this.f28212k = null;
        }
        DIDILocationListener dIDILocationListener = this.f28211j;
        if (dIDILocationListener != null) {
            LocationHelper2.unRegisterListener(this.f28205d, dIDILocationListener);
            this.f28211j = null;
        }
        IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f28213l;
        if (iWalkNavRouteSearchApi != null) {
            iWalkNavRouteSearchApi.cancelRequest();
            this.f28213l = null;
        }
        IWalkNavRouteSearchApi iWalkNavRouteSearchApi2 = this.f28214m;
        if (iWalkNavRouteSearchApi2 != null) {
            iWalkNavRouteSearchApi2.cancelRequest();
            this.f28214m = null;
        }
        Handler handler = this.f28215n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f28215n = null;
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        ICompLineContract iCompLineContract = this.f28203b;
        if (iCompLineContract != null && !CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
            arrayList.addAll(this.f28203b.getBestViewElements());
        }
        PsgLocationMarker psgLocationMarker = this.f28212k;
        if (psgLocationMarker != null && !CollectionUtil.isEmpty((Collection<?>) psgLocationMarker.getBestViewElements())) {
            arrayList.addAll(this.f28212k.getBestViewElements());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22120a(List<LatLng> list) {
        IWalkEngine iWalkEngine = this.f28206e;
        if (iWalkEngine != null) {
            iWalkEngine.destroy();
            this.f28206e = null;
        }
        this.f28206e = new WalkEngineWrapper(WalkEngineType.NAV_BASE);
        this.f28206e.setWalkEngineEventCallback(new IWalkEngine.IWalkEngineEventCallback() {
            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, DMKEventPoint dMKEventPoint) {
                if (LatLngUtils.locateCorrect(latLng)) {
                    if (NewWalkLineComponent.this.f28207f) {
                        LatLng unused = NewWalkLineComponent.this.f28216o = latLng;
                        NewWalkLineComponent.this.m22114a(latLng);
                    } else if (i >= 0) {
                        if (NewWalkLineComponent.this.f28220s) {
                            DLog.m10773d(NewWalkLineComponent.this.f28202a, "matchResult-> ->success", new Object[0]);
                            String c = NewWalkLineComponent.this.f28202a;
                            DLog.m10773d(c, "------>绑路点" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                        }
                        LatLng unused2 = NewWalkLineComponent.this.f28216o = latLng;
                        NewWalkLineComponent.this.m22114a(latLng);
                        NewWalkLineComponent.this.m22115a(latLng, i);
                    } else if (NewWalkLineComponent.this.f28220s) {
                        DLog.m10773d(NewWalkLineComponent.this.f28202a, "matchResult-> ->fails", new Object[0]);
                    }
                }
            }

            public void onOffRoute() {
                if (!NewWalkLineComponent.this.f28207f) {
                    DLog.m10773d(NewWalkLineComponent.this.f28202a, "matchResult->->onOffRoute", new Object[0]);
                    NewWalkLineComponent.this.m22121a(true);
                    boolean unused = NewWalkLineComponent.this.f28207f = true;
                }
            }
        });
        this.f28206e.setRoutePoints(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22121a(final boolean z) {
        final LatLng latLng;
        NewWalkParam newWalkParam = this.f28209h;
        if (newWalkParam != null && LatLngUtils.locateCorrect(newWalkParam.getEndPoint())) {
            DIDILocation lastKnownLocation = LocationHelper2.getLastKnownLocation(this.f28205d, LocationRegisterParam.LocType.FLP);
            if (lastKnownLocation != null) {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                if (!LatLngUtils.locateCorrect(latLng)) {
                    return;
                }
            } else {
                latLng = null;
            }
            WalkNavRouteSearchParam.Builder c = m22129c();
            if (c != null) {
                WalkNavRouteSearchParam build = c.psgPoint(LineDataConverter.latConvertToDoublePoint(latLng)).startPoint(LineDataConverter.latConvertToDoublePoint(latLng)).endPoint(LineDataConverter.latConvertToDoublePoint(this.f28209h.getEndPoint())).curRouteId(z ? this.f28210i : 0).eventType(z ? 1 : 0).build();
                IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f28213l;
                if (iWalkNavRouteSearchApi != null) {
                    iWalkNavRouteSearchApi.cancelRequest();
                    this.f28213l = null;
                }
                IWalkNavRouteSearchApi createWalkNavSearch = RouteSearchApiFactory.createWalkNavSearch(this.f28205d);
                this.f28213l = createWalkNavSearch;
                if (createWalkNavSearch != null) {
                    final LatLng endPoint = this.f28209h.getEndPoint();
                    this.f28213l.calculateRoute(build, new WalkNavRouteSearchCallback() {
                        public void onBeginToSearch() {
                        }

                        public void onFinishToSearch(OrderWalkingRes orderWalkingRes, String str) {
                            if (!NewWalkLineComponent.this.f28208g) {
                                int unused = NewWalkLineComponent.this.f28218q = -1;
                                if (orderWalkingRes == null || orderWalkingRes.ret == null) {
                                    DLog.m10773d(NewWalkLineComponent.this.f28202a, "getWalkLineData->lineDataResponse==null", new Object[0]);
                                } else {
                                    int intValue = orderWalkingRes.ret.intValue();
                                    if (intValue == -2) {
                                        boolean unused2 = NewWalkLineComponent.this.f28219r = false;
                                        DLog.m10773d(NewWalkLineComponent.this.f28202a, "getWalkLineData  ret=-2", new Object[0]);
                                        if (NewWalkLineComponent.this.f28217p != null) {
                                            NewWalkLineComponent.this.f28217p.clear();
                                        } else {
                                            List unused3 = NewWalkLineComponent.this.f28217p = new ArrayList();
                                        }
                                        NewWalkLineComponent.this.f28217p.add(latLng);
                                        NewWalkLineComponent.this.f28217p.add(endPoint);
                                        NewWalkLineComponent newWalkLineComponent = NewWalkLineComponent.this;
                                        newWalkLineComponent.m22126b((List<LatLng>) newWalkLineComponent.f28217p);
                                    } else if (intValue != 0) {
                                        String c = NewWalkLineComponent.this.f28202a;
                                        DLog.m10773d(c, "getWalkLineData  ret=" + orderWalkingRes.ret, new Object[0]);
                                    } else {
                                        boolean unused4 = NewWalkLineComponent.this.f28219r = true;
                                        if (orderWalkingRes.routeId == null || NewWalkLineComponent.this.f28210i != orderWalkingRes.routeId.longValue() || !z) {
                                            long unused5 = NewWalkLineComponent.this.f28210i = orderWalkingRes.routeId == null ? 0 : orderWalkingRes.routeId.longValue();
                                            String c2 = NewWalkLineComponent.this.f28202a;
                                            DLog.m10773d(c2, "logid" + orderWalkingRes.logid + "", new Object[0]);
                                            List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(orderWalkingRes.geos);
                                            if (CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints)) {
                                                DLog.m10773d(NewWalkLineComponent.this.f28202a, "getWalkLineData ->allLinePoints  is null", new Object[0]);
                                                return;
                                            }
                                            if (NewWalkLineComponent.this.f28217p != null) {
                                                NewWalkLineComponent.this.f28217p.clear();
                                            } else {
                                                List unused6 = NewWalkLineComponent.this.f28217p = new ArrayList();
                                            }
                                            NewWalkLineComponent.this.f28217p.addAll(latLngListFromDiffGeoPoints);
                                            NewWalkLineComponent newWalkLineComponent2 = NewWalkLineComponent.this;
                                            newWalkLineComponent2.m22126b((List<LatLng>) newWalkLineComponent2.f28217p);
                                            NewWalkLineComponent newWalkLineComponent3 = NewWalkLineComponent.this;
                                            newWalkLineComponent3.m22120a((List<LatLng>) newWalkLineComponent3.f28217p);
                                        } else {
                                            DLog.m10773d(NewWalkLineComponent.this.f28202a, "偏航后 routeId 相同，无需更新路线", new Object[0]);
                                            return;
                                        }
                                    }
                                }
                                boolean unused7 = NewWalkLineComponent.this.f28207f = false;
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    private void m22113a() {
        NewWalkParam newWalkParam = this.f28209h;
        if (newWalkParam != null) {
            long pushInterval = newWalkParam.getPushInterval();
            if (pushInterval > 0) {
                if (this.f28215n == null) {
                    this.f28215n = new Handler();
                }
                this.f28215n.postDelayed(new Runnable() {
                    public final void run() {
                        NewWalkLineComponent.this.m22136e();
                    }
                }, pushInterval);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m22136e() {
        m22125b();
        m22113a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22126b(List<LatLng> list) {
        if (this.f28204c != null && this.f28205d != null) {
            ICompLineContract iCompLineContract = this.f28203b;
            if (iCompLineContract != null) {
                iCompLineContract.updateLinePoints(list);
                return;
            }
            LineParams lineParams = new LineParams(list, Color.parseColor("#33BBFF"), 5);
            lineParams.setDotSpace(20.0f);
            lineParams.setZIndex(10);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f28204c, this.f28205d, lineParams);
            this.f28203b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22114a(LatLng latLng) {
        PsgLocationMarker psgLocationMarker = this.f28212k;
        if (psgLocationMarker != null) {
            psgLocationMarker.updatePosition(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22115a(LatLng latLng, int i) {
        if (this.f28203b != null && !CollectionUtil.isEmpty((Collection<?>) this.f28217p)) {
            List<LatLng> arrayList = new ArrayList<>();
            if (this.f28218q != i) {
                if (this.f28220s) {
                    DLog.m10773d(this.f28202a, "eraseLine->重新刷新路线数据segmentIndex 不同", new Object[0]);
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f28217p);
                if (i < arrayList2.size()) {
                    arrayList = arrayList2.subList(i + 1, arrayList2.size());
                } else {
                    return;
                }
            } else if (this.f28203b != null) {
                if (this.f28220s) {
                    DLog.m10773d(this.f28202a, "eraseLine->重新刷新路线数据segmentIndex 相同", new Object[0]);
                }
                List<LatLng> allLinePoints = this.f28203b.getAllLinePoints();
                if (!CollectionUtil.isEmpty((Collection<?>) allLinePoints)) {
                    arrayList = allLinePoints.subList(1, allLinePoints.size());
                }
            }
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                arrayList.add(0, latLng);
                m22126b(arrayList);
                this.f28218q = i;
            }
        }
    }

    /* renamed from: b */
    private void m22125b() {
        WalkNavRouteSearchParam.Builder c;
        if (LatLngUtils.locateCorrect(this.f28216o) && this.f28205d != null && (c = m22129c()) != null) {
            WalkNavRouteSearchParam build = c.psgPoint(LineDataConverter.latConvertToDoublePoint(this.f28216o)).eventType(11).curRouteId(0).state(WalkState.STATE_WALKING).build();
            IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f28214m;
            if (iWalkNavRouteSearchApi != null) {
                iWalkNavRouteSearchApi.cancelRequest();
                this.f28214m = null;
            }
            IWalkNavRouteSearchApi createWalkNavSearch = RouteSearchApiFactory.createWalkNavSearch(this.f28205d);
            this.f28214m = createWalkNavSearch;
            createWalkNavSearch.calculateRoute(build, new WalkNavRouteSearchCallback() {
                public void onBeginToSearch() {
                }

                public void onFinishToSearch(OrderWalkingRes orderWalkingRes, String str) {
                    if (!NewWalkLineComponent.this.f28208g && NewWalkLineComponent.this.f28214m != null && orderWalkingRes != null && orderWalkingRes.ret != null && orderWalkingRes.ret.intValue() == 0 && NewWalkLineComponent.this.f28220s) {
                        String c = NewWalkLineComponent.this.f28202a;
                        DLog.m10773d(c, "ora push success" + orderWalkingRes.logid, new Object[0]);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private WalkNavRouteSearchParam.Builder m22129c() {
        try {
            if (this.f28209h != null) {
                if (this.f28204c != null) {
                    String str = "";
                    if (this.f28204c.getMapVendor() != null) {
                        int i = C103085.$SwitchMap$com$didi$common$map$MapVendor[this.f28204c.getMapVendor().ordinal()];
                        if (i == 1 || i == 2) {
                            str = "didi";
                        } else if (i == 3) {
                            str = "google";
                        } else if (i == 4) {
                            str = Payload.SOURCE_HUAWEI;
                        }
                    }
                    WalkNavRouteSearchParam.Builder builder = new WalkNavRouteSearchParam.Builder();
                    builder.scene(WalkScene.START).orderId(this.f28209h.getOrderId()).visitorInfo(m22134d()).bizType(TextUtils.isEmpty(this.f28209h.getProductId()) ? -1 : Integer.valueOf(this.f28209h.getProductId()).intValue()).role(2).type(0).sdkMapType(str).passengerId(TextUtils.isEmpty(PaxEnvironment.getInstance().getUid()) ? -1 : Long.valueOf(PaxEnvironment.getInstance().getUid()).longValue()).didiVersion(PaxEnvironment.getInstance().getAppVersion()).caller(CallFrom.ORDERROUTEAPI_WALK).driverId(this.f28209h.getDriverId()).build();
                    return builder;
                }
            }
            return null;
        } catch (Exception e) {
            String str2 = this.f28202a;
            DLog.m10773d(str2, "基础参数拼接发生异常" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* renamed from: com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent$5 */
    static /* synthetic */ class C103085 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.G_DIDI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.HUAWEI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent.C103085.<clinit>():void");
        }
    }

    /* renamed from: d */
    private VisitorInfo m22134d() {
        return new VisitorInfo.Builder().token(PaxEnvironment.getInstance().getToken()).timeStampSec(Long.valueOf(System.currentTimeMillis() / 1000)).phoneNum(PaxEnvironment.getInstance().getPhoneNumber()).didiVersion(PaxEnvironment.getInstance().getAppVersion()).mo84797OS(enumOSType.Android).imei(SystemUtil.getIMEI()).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RouteGuidanceGPSPoint m22112a(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        try {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.accuracy = (int) dIDILocation.getAccuracy();
            routeGuidanceGPSPoint.matchedStatus = 1;
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (dIDILocation.getLatitude() * 1000000.0d));
            geoPoint.setLongitudeE6((int) (dIDILocation.getLongitude() * 1000000.0d));
            routeGuidanceGPSPoint.point = geoPoint;
            routeGuidanceGPSPoint.segmentIndex = -1;
            routeGuidanceGPSPoint.shapeOffSet = 0;
            routeGuidanceGPSPoint.timestamp = dIDILocation.getTime() / 1000;
            routeGuidanceGPSPoint.velocity = dIDILocation.getSpeed();
            routeGuidanceGPSPoint.heading = dIDILocation.getBearing();
            routeGuidanceGPSPoint.source = dIDILocation.getCoordinateType();
            return routeGuidanceGPSPoint;
        } catch (Exception unused) {
            DLog.m10773d("convertFromDiDiLocation2", "error", new Object[0]);
            return null;
        }
    }
}
