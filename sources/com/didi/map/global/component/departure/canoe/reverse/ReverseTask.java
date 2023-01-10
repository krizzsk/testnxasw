package com.didi.map.global.component.departure.canoe.reverse;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class ReverseTask {

    /* renamed from: a */
    private Context f27247a;

    /* renamed from: b */
    private int f27248b;

    /* renamed from: c */
    private ReverseTaskParam f27249c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ReverseTaskCallback f27250d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f27251e;

    public ReverseTask(Context context, ReverseTaskParam reverseTaskParam) {
        this.f27247a = context;
        this.f27249c = reverseTaskParam;
        if (reverseTaskParam != null) {
            this.f27248b = reverseTaskParam.getId();
            this.f27250d = reverseTaskParam.getTaskCallback();
        }
    }

    public int getId() {
        return this.f27248b;
    }

    public void start() {
        ReverseTaskCallback reverseTaskCallback;
        if (this.f27247a != null && this.f27249c != null && (reverseTaskCallback = this.f27250d) != null) {
            this.f27251e = true;
            if (reverseTaskCallback != null) {
                reverseTaskCallback.onDataStart();
            }
            m21546a();
        }
    }

    public void stop() {
        this.f27251e = false;
    }

    public void destroy() {
        this.f27251e = false;
        this.f27250d = null;
        this.f27249c = null;
        this.f27247a = null;
    }

    /* renamed from: a */
    private void m21546a() {
        if (this.f27249c.getLocationInfo() != null) {
            DepartureLocationInfo locationInfo = this.f27249c.getLocationInfo();
            ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
            reverseGeoParam.mapType = this.f27249c.getMapType();
            reverseGeoParam.select_lng = locationInfo.latLng.longitude;
            reverseGeoParam.select_lat = locationInfo.latLng.latitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f27247a).getLastKnownLocation();
            if (lastKnownLocation != null) {
                reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
                reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
                reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
                reverseGeoParam.provider = lastKnownLocation.getProvider();
            }
            reverseGeoParam.callFrom = this.f27249c.getReqCallerId() == null ? CallFrom.UNKNOWN : this.f27249c.getReqCallerId();
            reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
            reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
            reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
            reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
            reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            DLog.m10773d("canoe", "reverseGeo params = " + reverseGeoParam, new Object[0]);
            PoiBaseApiFactory.createDidiApi(this.f27247a).reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    if (ReverseTask.this.f27250d != null && ReverseTask.this.f27251e) {
                        ReverseStationsInfo a = ReverseTask.this.m21545a(reverseGeoResult);
                        ReverseTask.this.m21548a(a);
                        if (a != null) {
                            DLog.m10773d("canoe", "reverseGeo  onSuccess info = " + a.toString(), new Object[0]);
                            if (a.errno != 0) {
                                ReverseTask.this.f27250d.onDataFailed(a.errno);
                            } else if (!CollectionUtil.isEmpty((Collection<?>) a.getRecStartPoints()) || !CollectionUtil.isEmpty((Collection<?>) a.getList())) {
                                ReverseTask.this.f27250d.onDataSuccess(a);
                            } else {
                                ReverseTask.this.f27250d.onDataFailed(-1);
                            }
                        } else {
                            ReverseTask.this.f27250d.onDataFailed(-1);
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    if (ReverseTask.this.f27250d != null && ReverseTask.this.f27251e) {
                        DLog.m10773d("canoe", " reverseGeo onFail " + iOException.toString(), new Object[0]);
                        ReverseTask.this.f27250d.onDataFailed(-1);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21548a(ReverseStationsInfo reverseStationsInfo) {
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
    public ReverseStationsInfo m21545a(ReverseGeoResult reverseGeoResult) {
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
