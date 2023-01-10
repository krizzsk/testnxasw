package com.didi.map.sdk.departure.internal.data;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.departure.internal.data.store.DepartureDataStore;
import com.didi.map.sdk.departure.param.ApiType;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.google.gson.JsonObject;
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
    private static final String f30606a = "DepartureHttpTask";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureHttpTaskParam f30607b;

    /* renamed from: c */
    private Context f30608c;

    /* renamed from: d */
    private Map f30609d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f30610e = false;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f30609d = map;
        this.f30608c = context.getApplicationContext();
    }

    public void destroy() {
        this.f30607b = null;
        this.f30609d = null;
        this.f30608c = null;
    }

    public void setConfigParam(DepartureHttpTaskParam departureHttpTaskParam) {
        this.f30607b = departureHttpTaskParam;
    }

    public void start() {
        DepartureHttpTaskParam departureHttpTaskParam = this.f30607b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null && !this.f30610e) {
            DLog.m10773d(f30606a, "start()", new Object[0]);
            DepartureHttpTaskParam departureHttpTaskParam2 = this.f30607b;
            if (!(departureHttpTaskParam2 == null || departureHttpTaskParam2.listener == null)) {
                this.f30607b.listener.onPrepare(this.f30607b.locationInfo.latLng, this.f30607b.taskID);
            }
            this.f30610e = true;
            m23625a();
        }
    }

    public void stop() {
        DLog.m10773d(f30606a, "stop()", new Object[0]);
        this.f30610e = false;
    }

    /* renamed from: a */
    private void m23625a() {
        m23627a((FetchCallback<ReverseStationsInfo>) new FetchCallback<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                if (DepartureHttpTask.this.f30607b != null && DepartureHttpTask.this.f30607b.listener != null && DepartureHttpTask.this.f30610e) {
                    DepartureHttpTask.this.f30607b.listener.onSuccess(reverseStationsInfo, DepartureHttpTask.this.f30607b.taskID);
                }
            }

            public void onFail(int i) {
                if (DepartureHttpTask.this.f30607b != null && DepartureHttpTask.this.f30607b.listener != null && DepartureHttpTask.this.f30610e) {
                    DepartureHttpTask.this.f30607b.listener.onFail(i, DepartureHttpTask.this.f30607b.taskID);
                }
            }
        });
    }

    /* renamed from: a */
    private void m23627a(FetchCallback<ReverseStationsInfo> fetchCallback) {
        DepartureHttpTaskParam departureHttpTaskParam = this.f30607b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null) {
            if (this.f30607b.apiType == ApiType.DEPARTURE_POI_INFO) {
                SystemUtils.log(6, "ccc", "DepartureHttpTask: fetchPoiInfo", (Throwable) null, "com.didi.map.sdk.departure.internal.data.DepartureHttpTask", 134);
                m23631c(fetchCallback);
                return;
            }
            SystemUtils.log(6, "ccc", "DepartureHttpTask: fetchReverseGeo", (Throwable) null, "com.didi.map.sdk.departure.internal.data.DepartureHttpTask", 137);
            m23629b(fetchCallback);
        }
    }

    /* renamed from: b */
    private void m23629b(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        IPoiBaseApi createDidiApi = PoiBaseApiFactory.createDidiApi(this.f30608c);
        final ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        Map map = this.f30609d;
        reverseGeoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        reverseGeoParam.select_lng = this.f30607b.locationInfo.latLng.longitude;
        reverseGeoParam.select_lat = this.f30607b.locationInfo.latLng.latitude;
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f30608c).getLastKnownLocation();
        if (lastKnownLocation != null) {
            reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
            reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
            reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
            reverseGeoParam.provider = lastKnownLocation.getProvider();
        }
        reverseGeoParam.callFrom = this.f30607b.callFrom;
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        DLog.m10773d(f30606a, "vamos reverseGeo request params : " + reverseGeoParam, new Object[0]);
        createDidiApi.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                if (fetchCallback != null) {
                    ReverseStationsInfo a = DepartureHttpTask.this.m23623a(reverseGeoResult);
                    DepartureHttpTask.this.m23628a(a);
                    if (a != null) {
                        DLog.m10773d(DepartureHttpTask.f30606a, "reverseGeo response, index " + Integer.toHexString(reverseGeoParam.hashCode()) + "; result  : " + a.toString(), new Object[0]);
                        if (a.errno != 0) {
                            fetchCallback.onFail(a.errno);
                        } else if (!CollectionUtil.isEmpty((Collection<?>) a.getRecStartPoints()) || !CollectionUtil.isEmpty((Collection<?>) a.getList())) {
                            fetchCallback.onSuccess(a);
                        } else {
                            fetchCallback.onFail(-1);
                        }
                    } else {
                        fetchCallback.onFail(-1);
                    }
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
                DLog.m10773d(DepartureHttpTask.f30606a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: c */
    private void m23631c(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        final PoiInfoParam poiInfoParam = new PoiInfoParam();
        poiInfoParam.select_lng = this.f30607b.locationInfo.latLng.longitude;
        poiInfoParam.select_lat = this.f30607b.locationInfo.latLng.latitude;
        poiInfoParam.userOperationType = this.f30607b.operationType;
        poiInfoParam.poiInfo = m23624a(this.f30607b.locationInfo);
        poiInfoParam.callFrom = this.f30607b.callFrom;
        poiInfoParam.productId = PaxEnvironment.getInstance().getProductId();
        poiInfoParam.isFirstLaunch = DepartureDataStore.getInstance().IsFirstLaunch();
        poiInfoParam.isFence = this.f30607b.isNeedFence;
        poiInfoParam.token = PaxEnvironment.getInstance().getToken();
        poiInfoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        poiInfoParam.uid = PaxEnvironment.getInstance().getUid();
        poiInfoParam.departureTime = this.f30607b.departureTime;
        Map map = this.f30609d;
        poiInfoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        poiInfoParam.localTime = System.currentTimeMillis();
        poiInfoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        poiInfoParam.requester_type = "1";
        poiInfoParam.timeOut = this.f30607b.timeOut;
        poiInfoParam.isNeedNLP = this.f30607b.isNeedNLP;
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f30608c);
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
        poiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        poiInfoParam.entrance = PaxEnvironment.getInstance().getEntrance().toString();
        DLog.m10773d(f30606a, "vamos poiInfo request params : " + poiInfoParam, new Object[0]);
        PoiBaseApiFactory.createDidiApi(this.f30608c).fetchPoiInfo(poiInfoParam, new IHttpListener<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                DepartureHttpTask.this.m23628a(reverseStationsInfo);
                DLog.m10773d(DepartureHttpTask.f30606a, "poiInfo response, index " + Integer.toHexString(poiInfoParam.hashCode()) + "; result  : " + reverseStationsInfo, new Object[0]);
                FetchCallback fetchCallback = fetchCallback;
                if (fetchCallback == null) {
                    return;
                }
                if (reverseStationsInfo == null) {
                    fetchCallback.onFail(-1);
                } else if (reverseStationsInfo.errno == 0) {
                    if (reverseStationsInfo.result != null && !reverseStationsInfo.result.isEmpty()) {
                        RpcPoi rpcPoi = reverseStationsInfo.result.get(0);
                    }
                    fetchCallback.onSuccess(reverseStationsInfo);
                } else {
                    fetchCallback.onFail(reverseStationsInfo.errno);
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
                DLog.m10773d(DepartureHttpTask.f30606a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: a */
    private String m23624a(DepartureLocationInfo departureLocationInfo) {
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
    /* renamed from: a */
    public void m23628a(ReverseStationsInfo reverseStationsInfo) {
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
    public ReverseStationsInfo m23623a(ReverseGeoResult reverseGeoResult) {
        if (reverseGeoResult == null) {
            return null;
        }
        ReverseStationsInfo reverseStationsInfo = new ReverseStationsInfo();
        reverseStationsInfo.city = reverseGeoResult.city;
        reverseStationsInfo.cityId = reverseGeoResult.cityId;
        reverseStationsInfo.countryId = reverseGeoResult.countryId;
        reverseStationsInfo.countryCode = reverseGeoResult.countryCode;
        reverseStationsInfo.result = reverseGeoResult.result;
        return reverseStationsInfo;
    }
}
