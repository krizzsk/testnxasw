package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.trafficreport.map.ReportLocOpCallback;
import com.didi.map.global.component.trafficreport.model.ReportLocParam;
import com.didi.map.global.component.trafficreport.util.LocUtils;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;

public class ReportLocComponent implements IBaseComponent<ReportLocParam> {

    /* renamed from: a */
    private final String f28661a = "ReportLocComponent";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f28662b;

    /* renamed from: c */
    private Map f28663c;

    /* renamed from: d */
    private ReportLocParam f28664d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ReportLocOpCallback f28665e;

    /* renamed from: f */
    private LatLng f28666f;

    /* renamed from: g */
    private IPoiBaseApi f28667g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        if (context != null) {
            this.f28662b = context;
            this.f28663c = map;
        }
    }

    public void destroy() {
        this.f28663c = null;
        this.f28662b = null;
        this.f28667g = null;
    }

    public void setConfigParam(ReportLocParam reportLocParam) {
        this.f28664d = reportLocParam;
        if (reportLocParam != null) {
            this.f28666f = reportLocParam.getmLoc();
            this.f28665e = reportLocParam.getCallback();
        }
        if (this.f28666f == null) {
            this.f28666f = LocUtils.getCurrentLocation(this.f28662b);
        }
        SystemUtils.log(3, "ReportLocComponent", "setConfigParam: " + this.f28666f, (Throwable) null, "com.didi.map.global.component.trafficreport.view.ReportLocComponent", 72);
    }

    public void startRevertGeo() {
        if (this.f28666f == null) {
            this.f28666f = LocUtils.getCurrentLocation(this.f28662b);
        }
        startRevertGeo(this.f28666f);
    }

    public void startRevertGeo(final LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng) && this.f28662b != null) {
            ReportLocOpCallback reportLocOpCallback = this.f28665e;
            if (reportLocOpCallback != null) {
                reportLocOpCallback.onDateLoading();
            }
            ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
            Map map = this.f28663c;
            reverseGeoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
            reverseGeoParam.callFrom = CallFrom.PAX_USER_REPORT;
            reverseGeoParam.select_lng = latLng.longitude;
            reverseGeoParam.select_lat = latLng.latitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f28662b).getLastKnownLocation();
            if (lastKnownLocation != null) {
                reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
                reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
                reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
                reverseGeoParam.provider = lastKnownLocation.getProvider();
            }
            reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
            reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
            reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
            reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
            reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            DLog.m10773d("ReportLocComponent", "startRevertGeo params : " + reverseGeoParam.toString(), new Object[0]);
            if (this.f28667g == null) {
                this.f28667g = PoiBaseApiFactory.createDidiApi(this.f28662b);
            }
            this.f28667g.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    if (ReportLocComponent.this.f28662b != null) {
                        DLog.m10773d("ReportLocComponent", "reverse geo success", new Object[0]);
                        if (reverseGeoResult != null && reverseGeoResult.result != null && !reverseGeoResult.result.isEmpty() && ReportLocComponent.this.f28665e != null) {
                            RpcPoi rpcPoi = reverseGeoResult.result.get(0);
                            if (!(rpcPoi == null || rpcPoi.base_info == null || latLng == null)) {
                                rpcPoi.base_info.lat = latLng.latitude;
                                rpcPoi.base_info.lng = latLng.longitude;
                            }
                            ReportLocComponent.this.f28665e.onRevertAddress(rpcPoi);
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    DLog.m10773d("ReportLocComponent", "reverse geo fail", new Object[0]);
                    if (ReportLocComponent.this.f28662b != null) {
                        RpcPoi rpcPoi = new RpcPoi();
                        rpcPoi.base_info = new RpcPoiBaseInfo();
                        rpcPoi.base_info.displayname = ReportLocComponent.this.f28662b.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                        if (latLng != null) {
                            rpcPoi.base_info.lat = latLng.latitude;
                            rpcPoi.base_info.lng = latLng.longitude;
                        }
                        rpcPoi.base_info.poi_id = "android_reverse_geo_error_default_id";
                        if (ReportLocComponent.this.f28665e != null) {
                            ReportLocComponent.this.f28665e.onRevertAddress(rpcPoi);
                        }
                    }
                }
            });
        }
    }
}
