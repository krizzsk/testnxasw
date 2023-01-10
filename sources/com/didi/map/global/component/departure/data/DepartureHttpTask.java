package com.didi.map.global.component.departure.data;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.google.gson.JsonObject;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public final class DepartureHttpTask implements IDepartureHttpTask {

    /* renamed from: a */
    private static final String f27318a = "DepartureHttpTask";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureHttpTaskParam f27319b;

    /* renamed from: c */
    private Context f27320c;

    /* renamed from: d */
    private Map f27321d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f27322e = false;

    /* renamed from: f */
    private Handler f27323f = new Handler(Looper.getMainLooper());

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f27320c = context;
        this.f27321d = map;
    }

    public void destroy() {
        this.f27319b = null;
        this.f27321d = null;
        this.f27320c = null;
        Handler handler = this.f27323f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27323f = null;
        }
    }

    public void setConfigParam(DepartureHttpTaskParam departureHttpTaskParam) {
        this.f27319b = departureHttpTaskParam;
    }

    public void start() {
        ReverseStationsInfo findSameAddr;
        DepartureHttpTaskParam departureHttpTaskParam = this.f27319b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null && !this.f27322e) {
            this.f27322e = true;
            DepartureDataStore.getInstance().setPinLocation(this.f27319b.locationInfo.latLng);
            if (!this.f27319b.isNeedCache || (findSameAddr = DepartureDataStore.getInstance().findSameAddr(this.f27321d, this.f27319b.locationInfo.latLng)) == null) {
                DepartureHttpTaskParam departureHttpTaskParam2 = this.f27319b;
                if (!(departureHttpTaskParam2 == null || departureHttpTaskParam2.listener == null)) {
                    this.f27319b.listener.onPrepare(this.f27319b.locationInfo.latLng, this.f27319b.taskID);
                }
                m21592a();
                return;
            }
            DLog.m10773d(f27318a, "find address in store ,  result  : " + findSameAddr, new Object[0]);
            DepartureHttpTaskParam departureHttpTaskParam3 = this.f27319b;
            if (departureHttpTaskParam3 != null && departureHttpTaskParam3.listener != null) {
                this.f27323f.postDelayed(new Runnable(findSameAddr) {
                    public final /* synthetic */ ReverseStationsInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DepartureHttpTask.this.m21601c(this.f$1);
                    }
                }, 150);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21601c(ReverseStationsInfo reverseStationsInfo) {
        this.f27319b.listener.onSuccess(reverseStationsInfo, this.f27319b.taskID);
    }

    public void stop() {
        this.f27322e = false;
    }

    /* renamed from: a */
    private void m21592a() {
        m21594a((FetchCallback<ReverseStationsInfo>) new FetchCallback<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                DepartureHttpTask.this.m21595a(reverseStationsInfo);
                if (!(DepartureHttpTask.this.f27319b == null || DepartureHttpTask.this.f27319b.locationInfo == null)) {
                    DepartureDataStore.getInstance().setReverseResult(reverseStationsInfo, DepartureHttpTask.this.f27319b.locationInfo.latLng);
                }
                if (DepartureHttpTask.this.f27319b != null && DepartureHttpTask.this.f27319b.listener != null && DepartureHttpTask.this.f27322e) {
                    DepartureHttpTask.this.f27319b.listener.onSuccess(reverseStationsInfo, DepartureHttpTask.this.f27319b.taskID);
                }
            }

            public void onFail(int i) {
                if (DepartureHttpTask.this.f27319b != null && DepartureHttpTask.this.f27319b.listener != null && DepartureHttpTask.this.f27322e) {
                    DepartureHttpTask.this.f27319b.listener.onFail(i, DepartureHttpTask.this.f27319b.taskID);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21595a(ReverseStationsInfo reverseStationsInfo) {
        if (!CollectionUtil.isEmpty((Collection<?>) reverseStationsInfo.recStartPoints) && reverseStationsInfo.recStartPoints.get(0).base_info != null) {
            RpcPoi rpcPoi = reverseStationsInfo.recStartPoints.get(0);
            RpcPoi rpcPoi2 = new RpcPoi();
            rpcPoi2.base_info = rpcPoi.base_info.clone();
            rpcPoi2.base_info.is_recommend_absorb = 0;
            rpcPoi2.base_info.lat = rpcPoi.base_info.lat + 1.0E-6d;
            reverseStationsInfo.recStartPoints.add(rpcPoi2);
        }
    }

    /* renamed from: a */
    private void m21594a(FetchCallback<ReverseStationsInfo> fetchCallback) {
        DepartureHttpTaskParam departureHttpTaskParam = this.f27319b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null) {
            if (this.f27319b.apiType == ApiType.DEPARTURE_POI_INFO) {
                m21600c(fetchCallback);
            } else {
                m21597b(fetchCallback);
            }
        }
    }

    /* renamed from: b */
    private void m21597b(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        IPoiBaseApi createDidiApi = PoiBaseApiFactory.createDidiApi(this.f27320c);
        final ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        Map map = this.f27321d;
        reverseGeoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        reverseGeoParam.select_lng = this.f27319b.locationInfo.latLng.longitude;
        reverseGeoParam.select_lat = this.f27319b.locationInfo.latLng.latitude;
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f27320c).getLastKnownLocation();
        if (lastKnownLocation != null) {
            reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
            reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
            reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
            reverseGeoParam.provider = lastKnownLocation.getProvider();
        }
        reverseGeoParam.callFrom = this.f27319b.reqCallerId == null ? CallFrom.UNKNOWN : this.f27319b.reqCallerId;
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        DLog.m10773d(f27318a, "reverseGeo params = " + reverseGeoParam, new Object[0]);
        createDidiApi.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                ReverseStationsInfo a = DepartureHttpTask.this.m21590a(reverseGeoResult);
                DepartureHttpTask.this.m21598b(a);
                if (!(reverseGeoParam == null || a == null)) {
                    DLog.m10773d(DepartureHttpTask.f27318a, "reverseGeo response, index " + Integer.toHexString(reverseGeoParam.hashCode()) + "; result  : " + a.toString(), new Object[0]);
                }
                FetchCallback fetchCallback = fetchCallback;
                if (fetchCallback == null) {
                    return;
                }
                if (a == null) {
                    fetchCallback.onFail(-1);
                } else if (a.errno != 0) {
                    fetchCallback.onFail(a.errno);
                } else if (!CollectionUtil.isEmpty((Collection<?>) a.getRecStartPoints()) || !CollectionUtil.isEmpty((Collection<?>) a.getList())) {
                    fetchCallback.onSuccess(a);
                } else {
                    fetchCallback.onFail(-1);
                }
            }

            public void onFail(IOException iOException) {
                if (iOException == null || !"Canceled".equals(iOException.getMessage())) {
                    FetchCallback fetchCallback = fetchCallback;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                        return;
                    }
                    return;
                }
                DLog.m10773d(DepartureHttpTask.f27318a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: c */
    private void m21600c(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        final PoiInfoParam poiInfoParam = new PoiInfoParam();
        poiInfoParam.select_lng = this.f27319b.locationInfo.latLng.longitude;
        poiInfoParam.select_lat = this.f27319b.locationInfo.latLng.latitude;
        poiInfoParam.userOperationType = this.f27319b.operationType;
        poiInfoParam.poiInfo = m21591a(this.f27319b.locationInfo);
        poiInfoParam.callFrom = this.f27319b.reqCallerId == null ? CallFrom.UNKNOWN : this.f27319b.reqCallerId;
        poiInfoParam.isFirstLaunch = DepartureDataStore.getInstance().isFirstLaunch();
        poiInfoParam.isFence = this.f27319b.isNeedFence;
        poiInfoParam.isNeedNLP = this.f27319b.isNeedNLP();
        poiInfoParam.timeOut = this.f27319b.getTimeOut();
        poiInfoParam.departureTime = this.f27319b.departureTime;
        Map map = this.f27321d;
        poiInfoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        poiInfoParam.localTime = System.currentTimeMillis();
        poiInfoParam.appAutoCall = this.f27319b.IsAutoCall;
        poiInfoParam.destInfo = this.f27319b.getDestInfo();
        poiInfoParam.entrance = PaxEnvironment.getInstance().getEntrance().toString();
        poiInfoParam.uid = PaxEnvironment.getInstance().getUid();
        poiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        poiInfoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        poiInfoParam.productId = PaxEnvironment.getInstance().getProductId();
        poiInfoParam.token = PaxEnvironment.getInstance().getToken();
        poiInfoParam.cityId = PaxEnvironment.getInstance().getCityId();
        poiInfoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        poiInfoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27320c);
        if (lastKnownLocation != null) {
            poiInfoParam.user_loc_lng = lastKnownLocation.getLongitude();
            poiInfoParam.user_loc_lat = lastKnownLocation.getLatitude();
            poiInfoParam.source = lastKnownLocation.getSource();
            poiInfoParam.accuracy = lastKnownLocation.getAccuracy();
            poiInfoParam.provider = lastKnownLocation.getProvider();
            if (lastKnownLocation.getExtra() != null) {
                poiInfoParam.locStrategy = String.valueOf(lastKnownLocation.getExtra().getLong(DIDILocation.EXTRA_KEY_STRATEGY_FLAGS));
            }
        }
        PoiBaseApiFactory.createDidiApi(this.f27320c).fetchPoiInfo(poiInfoParam, new IHttpListener<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                DepartureHttpTask.this.m21598b(reverseStationsInfo);
                DLog.m10773d(DepartureHttpTask.f27318a, "poiInfo response, index " + Integer.toHexString(poiInfoParam.hashCode()) + "; result  : " + reverseStationsInfo, new Object[0]);
                FetchCallback fetchCallback = fetchCallback;
                if (fetchCallback == null) {
                    return;
                }
                if (reverseStationsInfo == null) {
                    fetchCallback.onFail(-1);
                } else if (reverseStationsInfo.errno == 0) {
                    RpcPoi rpcPoi = null;
                    if (reverseStationsInfo.result != null && !reverseStationsInfo.result.isEmpty()) {
                        rpcPoi = reverseStationsInfo.result.get(0);
                    }
                    if (!(DepartureHttpTask.this.f27319b == null || DepartureHttpTask.this.f27319b.locationInfo == null || DepartureHttpTask.this.f27319b.locationInfo.sugPoi == null || rpcPoi == null || rpcPoi.base_info == null || rpcPoi.base_info.poi_id == null || !rpcPoi.base_info.poi_id.equalsIgnoreCase(DepartureHttpTask.this.f27319b.locationInfo.sugPoi.poiId))) {
                        rpcPoi.base_info.displayname = DepartureHttpTask.this.f27319b.locationInfo.sugPoi.displayName;
                    }
                    fetchCallback.onSuccess(reverseStationsInfo);
                } else {
                    fetchCallback.onFail(reverseStationsInfo.errno);
                }
            }

            public void onFail(IOException iOException) {
                StringBuilder sb = new StringBuilder();
                sb.append("poiInfo request failed: ");
                sb.append(iOException != null ? iOException.getMessage() : "");
                DLog.m10773d(DepartureHttpTask.f27318a, sb.toString(), new Object[0]);
                if (iOException == null || !"Canceled".equals(iOException.getMessage())) {
                    FetchCallback fetchCallback = fetchCallback;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                        return;
                    }
                    return;
                }
                DLog.m10773d(DepartureHttpTask.f27318a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: a */
    private String m21591a(DepartureLocationInfo departureLocationInfo) {
        if (departureLocationInfo == null || departureLocationInfo.sugPoi == null) {
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("poi_id", departureLocationInfo.sugPoi.poiId);
        jsonObject.addProperty("displayname", departureLocationInfo.sugPoi.displayName);
        jsonObject.addProperty("address", departureLocationInfo.sugPoi.address);
        jsonObject.addProperty(Const.H5Params.ADDRESSALL, departureLocationInfo.sugPoi.fullName);
        jsonObject.addProperty("lat", (Number) Double.valueOf(departureLocationInfo.sugPoi.latitude));
        jsonObject.addProperty("lng", (Number) Double.valueOf(departureLocationInfo.sugPoi.longitude));
        jsonObject.addProperty(DepartureConstants.SRCTAG, departureLocationInfo.sugPoi.srcTag);
        jsonObject.addProperty("coordinate_type", departureLocationInfo.sugPoi.coordinate_type);
        return jsonObject.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21598b(ReverseStationsInfo reverseStationsInfo) {
        if (reverseStationsInfo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (reverseStationsInfo.getList() != null) {
                Iterator<RpcPoi> it = reverseStationsInfo.getList().iterator();
                while (it.hasNext()) {
                    it.next().curTimeMills = currentTimeMillis;
                }
            }
            if (reverseStationsInfo.getRecStartPoints() != null) {
                Iterator<RpcPoi> it2 = reverseStationsInfo.getRecStartPoints().iterator();
                while (it2.hasNext()) {
                    it2.next().curTimeMills = currentTimeMillis;
                }
            }
            if (reverseStationsInfo.recDestination != null) {
                Iterator<RpcPoi> it3 = reverseStationsInfo.recDestination.iterator();
                while (it3.hasNext()) {
                    it3.next().curTimeMills = currentTimeMillis;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ReverseStationsInfo m21590a(ReverseGeoResult reverseGeoResult) {
        if (reverseGeoResult == null) {
            return null;
        }
        ReverseStationsInfo reverseStationsInfo = new ReverseStationsInfo();
        reverseStationsInfo.city = reverseGeoResult.city;
        reverseStationsInfo.cityId = reverseGeoResult.cityId;
        reverseStationsInfo.countryId = reverseGeoResult.countryId;
        reverseStationsInfo.countryCode = reverseGeoResult.countryCode;
        reverseStationsInfo.canonicalCountryCode = reverseGeoResult.canonicalCountryCode;
        reverseStationsInfo.result = reverseGeoResult.result;
        return reverseStationsInfo;
    }
}
