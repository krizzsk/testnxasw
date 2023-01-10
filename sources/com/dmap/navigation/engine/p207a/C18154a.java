package com.dmap.navigation.engine.p207a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.dmap.navigation.api.core.IBaseNaviAPI;
import com.dmap.navigation.api.core.INaviPlanner;
import com.dmap.navigation.api.core.INaviPlannerBuilder;
import com.dmap.navigation.api.core.INaviPlannerInner;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.sub.BindNaviLocationNative;
import com.dmap.navigation.jni.sub.NaviInfoNative;
import com.dmap.navigation.jni.sub.NaviLocationListNative;
import com.dmap.navigation.jni.sub.NaviLocationNative;
import com.dmap.navigation.jni.sub.NaviPoiListNative;
import com.dmap.navigation.jni.sub.NaviPoiNative;
import com.dmap.navigation.jni.swig.APIRequestCallback;
import com.dmap.navigation.jni.swig.APIRequestHelper;
import com.dmap.navigation.jni.swig.BaseNaviAPI;
import com.dmap.navigation.jni.swig.DefaultRetryStrategy;
import com.dmap.navigation.jni.swig.FirstRetryStrategy;
import com.dmap.navigation.jni.swig.LongList;
import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.NaviResponse;
import com.dmap.navigation.jni.swig.ReqRouteInfo;
import com.dmap.navigation.jni.swig.RequestInfo;
import com.dmap.navigation.jni.swig.RetryStrategy;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;
import com.dmap.navigation.jni.swig.YawRetryStrategy;
import com.dmap.navigation.location.diloc.DMapDiDiLocation;
import com.dmap.navigation.simple.SimplePoi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.a */
/* compiled from: BaseNaviAPIImpl */
class C18154a<T extends BaseNaviAPI> implements IBaseNaviAPI, INaviPlanner, INaviPlannerBuilder {

    /* renamed from: a */
    final NaviInfoNative f54275a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final T f54276b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C18181n f54277c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public INaviPlanner.Callback f54278d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f54279e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private RetryStrategy f54280f;

    /* renamed from: g */
    private final APIRequestHelper f54281g = new APIRequestHelper() {
        public final void onPost(int i, final String str, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2) {
            HWLog.m20433i("nv_a", "url = " + str + " , body size = " + i2);
            if (!TextUtils.isEmpty(str)) {
                final byte[] a = C18180m.m40466a(sWIGTYPE_p_unsigned_char, i2);
                C18154a.this.f54279e.postDelayed(new Runnable() {
                    public final void run() {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Cityid", C18154a.this.f54277c.f54371aL.getCityId());
                        AsyncNetUtils.doPost(str, a, new AsyncNetUtils.Callback() {
                            public final void onSuccess(byte[] bArr) {
                                HWLog.m20433i("nv_a", "result size = " + bArr.length);
                                C18154a.this.f54276b.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
                                C18154a.m40444a(bArr, C18154a.this.f54275a.getEventType());
                            }

                            public final void onFailed(int i, Exception exc) {
                                HWLog.m20433i("nv_a", "error msg = " + exc.getMessage());
                                C18154a.this.f54276b.onResponse(new byte[0], 0, (int) (System.currentTimeMillis() / 1000));
                            }
                        }, hashMap);
                    }
                }, (long) i);
                return;
            }
            HWLog.m20433i("nv_a", "url = null");
        }

        public final RequestInfo getRequestInfo() {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setTraceId(C18180m.m40465a(C18154a.this.f54277c.f54371aL.getImei()));
            requestInfo.setCurrentTime(BigInteger.valueOf(System.currentTimeMillis()));
            requestInfo.setSessionId(C18154a.this.f54277c.getSessionId());
            requestInfo.setSeq(C18154a.this.f54277c.getSeq());
            requestInfo.setSpanId(C18180m.m40467b(C18154a.this.f54277c.f54371aL.getImei()));
            requestInfo.setLogId(C18180m.m40467b(C18154a.this.f54277c.f54371aL.getImei()) + C18180m.m40467b(C18154a.this.f54277c.f54371aL.getImei()));
            requestInfo.setTripId(C18154a.this.f54277c.getTripId());
            C18154a.this.f54275a.setRequestInfo(requestInfo);
            return requestInfo;
        }
    };

    /* renamed from: h */
    private final APIRequestCallback f54282h = new APIRequestCallback() {
        public final void onBegin() {
            HWLog.m20433i("nv_a", "onBegin, EventType = " + C18154a.this.f54275a.getEventType());
            C18154a.this.f54279e.postDelayed(C18154a.this.f54283i, 10000);
            if (C18154a.this.f54278d != null) {
                C18154a.this.f54279e.post(new Runnable() {
                    public final void run() {
                        C18154a.this.f54278d.onBegin(0);
                    }
                });
            }
        }

        public final void onRetry(final int i) {
            HWLog.m20433i("nv_a", "onRetry");
            if (C18154a.this.f54278d != null) {
                C18154a.this.f54279e.post(new Runnable() {
                    public final void run() {
                        if (C18154a.this.f54278d instanceof INaviPlannerInner.Callback) {
                            ((INaviPlannerInner.Callback) C18154a.this.f54278d).onRetry(i);
                        }
                    }
                });
            }
        }

        public final void onFinish(NaviResponse naviResponse) {
            HWLog.m20433i("nv_a", "onFinish = " + naviResponse.getErrorCode() + " ,route size = " + naviResponse.getRoutes().size());
            C18154a.this.f54279e.removeCallbacks(C18154a.this.f54283i);
            if (C18154a.this.f54278d != null) {
                final C18173f fVar = new C18173f(C18154a.this.f54276b, naviResponse);
                C18154a.this.f54279e.post(new Runnable() {
                    public final void run() {
                        C18154a.this.f54278d.onFinish(fVar.getRoutesList(), fVar.getErrorCode(), fVar.getIsMultiRoute());
                        if (C18154a.this.f54278d instanceof INaviPlannerInner.Callback) {
                            ((INaviPlannerInner.Callback) C18154a.this.f54278d).onFinish(C18154a.this.f54275a, fVar);
                        }
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Runnable f54283i = new Runnable() {
        public final void run() {
            if (C18154a.this.f54278d != null) {
                C18154a.this.f54278d.onFinish((List<IRoute>) null, NaviBusinessBridge.getERROR_REQUEST_TIME_OUT(), 0);
            }
        }
    };

    C18154a(INaviContext iNaviContext, T t) {
        AsyncNetUtils.init(iNaviContext.getAndroidContext());
        this.f54277c = (C18181n) iNaviContext;
        this.f54276b = t;
        this.f54275a = new NaviInfoNative();
        this.f54276b.setHelper(this.f54281g);
        this.f54276b.setCallback(this.f54282h);
    }

    public INaviPlannerBuilder firstRoute(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, int i) {
        if (iNaviPoi == null || iNaviPoi2 == null) {
            throw new RuntimeException("start or end point is null !");
        }
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_FIRST_ROUTE());
        this.f54275a.setStart(new NaviPoiNative(iNaviPoi));
        this.f54275a.setEnd(new NaviPoiNative(iNaviPoi2));
        this.f54275a.setPassPoints(new NaviPoiListNative(list));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(BigInteger.ZERO);
        reqRouteInfo.setPassfork(0);
        this.f54275a.setCurrentRoute(reqRouteInfo);
        this.f54275a.setNaviModel(i);
        List<INaviLocation> a = m40442a();
        if (a.size() > 0) {
            this.f54275a.setHistoryPoints(new NaviLocationListNative(a));
            this.f54275a.setLastGpsPoint(new NaviLocationNative(a.get(a.size() - 1)));
        }
        return this;
    }

    public INaviPlannerBuilder yawRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, int i3) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_YAW_ROUTE());
        IRouteEx iRouteEx = (IRouteEx) iRoute;
        this.f54275a.setStart(new NaviPoiNative(new SimplePoi((INaviLatLng) iNaviLocation.getLatLng(), "", "")));
        this.f54275a.setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        this.f54275a.setPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
        this.f54275a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        this.f54275a.setLastBindPoint(new BindNaviLocationNative(iNaviLocation2, i2));
        this.f54275a.setYawType(i3);
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(iRoute.getRouteId());
        reqRouteInfo.setPassfork(0);
        this.f54275a.setCurrentRoute(reqRouteInfo);
        List<INaviLocation> a = m40442a();
        if (a.size() > 0) {
            this.f54275a.setHistoryPoints(new NaviLocationListNative(a));
            this.f54275a.setLastGpsPoint(new NaviLocationNative(a.get(a.size() - 1)));
        }
        return this;
    }

    public INaviPlannerBuilder parallelRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_PARALLEL_ROUTE());
        m40443a((IRouteEx) iRoute, new ReqRouteInfo(), iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder elevatedRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_ELEVATED_ROUTE());
        m40443a((IRouteEx) iRoute, new ReqRouteInfo(), iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder multiRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, String str, int i3, int i4) {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_MULTI_ROUTE());
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        String str2 = str;
        reqRouteInfo.setRouteScene(str);
        int i5 = i3;
        reqRouteInfo.setRouteCount(i3);
        reqRouteInfo.setPassfork(i4);
        m40443a((IRouteEx) iRoute, reqRouteInfo, iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder arrivedDestination() {
        this.f54275a.setEventType(NaviBusinessBridge.getAPI_ARRIVED_DESTINATION());
        return this;
    }

    public INaviTrafficUpdater updateTraffic(IRoute iRoute, INaviLocation iNaviLocation, int i, List<BigInteger> list) {
        this.f54275a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(iRoute.getRouteId());
        LongList longList = new LongList();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                longList.add(list.get(i2));
            }
        }
        reqRouteInfo.setOtherRouteIds(longList);
        reqRouteInfo.setHasMjoEvent(((IRouteEx) iRoute).hasMjoEvent());
        this.f54275a.setCurrentRoute(reqRouteInfo);
        return new C18165d(this.f54277c, this.f54275a);
    }

    public void enqueue(INaviPlanner.Callback callback) {
        HWLog.m20433i("nv_a", "enqueue = ".concat(String.valueOf(this)));
        this.f54278d = callback;
        this.f54276b.execute();
    }

    public void cancel() {
        HWLog.m20433i("nv_a", "cancel = ".concat(String.valueOf(this)));
        this.f54276b.cancel();
        this.f54279e.removeCallbacksAndMessages((Object) null);
    }

    public INaviPlanner build() {
        if (!TextUtils.isEmpty(this.f54277c.f54371aL.getUserId())) {
            this.f54276b.setNaviInfo(this.f54275a);
            this.f54276b.setRetryStrategy(mo131841a(this.f54275a.getEventType()));
            return this;
        }
        throw new RuntimeException("UserId is empty !!!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RetryStrategy mo131841a(int i) {
        if (i == NaviBusinessBridge.getAPI_FIRST_ROUTE()) {
            this.f54280f = new FirstRetryStrategy();
        } else if (i == NaviBusinessBridge.getAPI_YAW_ROUTE() || i == NaviBusinessBridge.getAPI_PARALLEL_ROUTE() || i == NaviBusinessBridge.getAPI_ELEVATED_ROUTE()) {
            this.f54280f = new YawRetryStrategy();
        } else {
            this.f54280f = new DefaultRetryStrategy();
        }
        return this.f54280f;
    }

    /* renamed from: a */
    private void m40443a(IRouteEx iRouteEx, ReqRouteInfo reqRouteInfo, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f54275a.setStart(new NaviPoiNative(iRouteEx.getStart()));
        this.f54275a.setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        this.f54275a.setPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
        this.f54275a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        this.f54275a.setLastBindPoint(new BindNaviLocationNative(iNaviLocation2, i2));
        reqRouteInfo.setLastRouteId(iRouteEx.getRouteId());
        this.f54275a.setCurrentRoute(reqRouteInfo);
    }

    /* renamed from: a */
    private static List<INaviLocation> m40442a() {
        List<DIDILocation> recentLocations = DIDILocBusinessHelper.getInstance().getRecentLocations(20);
        HWLog.m20433i("nv_a", "getRecentLocations : " + recentLocations.toString());
        ArrayList arrayList = new ArrayList();
        for (DIDILocation next : recentLocations) {
            if (next != null) {
                arrayList.add(new DMapDiDiLocation(next));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m40444a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(bArr.length + 4)];
        System.arraycopy(MapSerializeUtil.intToBytes(i), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        HWLog.binary_i((byte) 1, bArr2, System.currentTimeMillis());
    }
}
