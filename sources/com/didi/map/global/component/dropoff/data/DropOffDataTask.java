package com.didi.map.global.component.dropoff.data;

import android.content.Context;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.destpoi.DestPoiInfoParam;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class DropOffDataTask implements IDropOffDataTask {

    /* renamed from: a */
    private Context f27776a;

    /* renamed from: b */
    private int f27777b;

    /* renamed from: c */
    private DropOffDataTaskParam f27778c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IDropOffDataTask.TaskCallback f27779d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f27780e;

    public DropOffDataTask(Context context, DropOffDataTaskParam dropOffDataTaskParam) {
        this.f27776a = context;
        this.f27778c = dropOffDataTaskParam;
        if (dropOffDataTaskParam != null) {
            this.f27777b = dropOffDataTaskParam.getId();
            this.f27779d = dropOffDataTaskParam.getTaskCallback();
        }
    }

    public int getId() {
        return this.f27777b;
    }

    public void start() {
        if (this.f27776a != null && this.f27778c != null && this.f27779d != null) {
            DropOffUtils.LOGD(" data task id = " + this.f27777b);
            this.f27780e = true;
            IDropOffDataTask.TaskCallback taskCallback = this.f27779d;
            if (taskCallback != null) {
                taskCallback.onDataStart();
            }
            m21934a();
        }
    }

    public void stop() {
        this.f27780e = false;
    }

    public void destroy() {
        this.f27780e = false;
        this.f27779d = null;
        this.f27778c = null;
        this.f27776a = null;
    }

    /* renamed from: a */
    private void m21934a() {
        if (this.f27778c.getLocationInfo() != null && this.f27778c.getLocationInfo().sugPoi != null) {
            DropOffLocationInfo locationInfo = this.f27778c.getLocationInfo();
            DestPoiInfoParam destPoiInfoParam = new DestPoiInfoParam();
            destPoiInfoParam.mapType = this.f27778c.getMapType();
            destPoiInfoParam.select_lat = locationInfo.latLng.latitude;
            destPoiInfoParam.select_lng = locationInfo.latLng.longitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f27776a).getLastKnownLocation();
            if (lastKnownLocation != null) {
                destPoiInfoParam.user_loc_lat = lastKnownLocation.getLatitude();
                destPoiInfoParam.user_loc_lng = lastKnownLocation.getLongitude();
                destPoiInfoParam.accuracy = lastKnownLocation.getAccuracy();
                destPoiInfoParam.provider = lastKnownLocation.getProvider();
            }
            if (this.f27778c.getReqCallerId() != null) {
                destPoiInfoParam.callFrom = this.f27778c.getReqCallerId();
            }
            destPoiInfoParam.userOperationType = this.f27778c.getUserOperationType();
            destPoiInfoParam.chooseDestPoiInfo = m21933a(locationInfo.sugPoi);
            destPoiInfoParam.uid = PaxEnvironment.getInstance().getUid();
            destPoiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            destPoiInfoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            destPoiInfoParam.productId = PaxEnvironment.getInstance().getProductId();
            destPoiInfoParam.token = PaxEnvironment.getInstance().getToken();
            destPoiInfoParam.cityId = PaxEnvironment.getInstance().getCityId();
            destPoiInfoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            destPoiInfoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            DropOffUtils.LOGD("fetchDestPoiInfo params = " + destPoiInfoParam);
            PoiBaseApiFactory.createDidiApi(this.f27776a).fetchDestPoiInfo(destPoiInfoParam, new IHttpListener<DestPoiReverseInfo>() {
                public void onSuccess(DestPoiReverseInfo destPoiReverseInfo) {
                    if (DropOffDataTask.this.f27779d != null && DropOffDataTask.this.f27780e) {
                        if (destPoiReverseInfo != null) {
                            DropOffUtils.LOGD("result = " + destPoiReverseInfo.toString());
                            if (destPoiReverseInfo.errno == 0) {
                                DropOffDataTask.this.f27779d.onDataSuccess(destPoiReverseInfo);
                            } else {
                                DropOffDataTask.this.f27779d.onDataFailed();
                            }
                        } else {
                            DropOffDataTask.this.f27779d.onDataFailed();
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    if (DropOffDataTask.this.f27779d != null && DropOffDataTask.this.f27780e) {
                        DropOffUtils.LOGD(" request fail " + iOException.toString());
                        DropOffDataTask.this.f27779d.onDataFailed();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private String m21933a(Address address) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("poi_id", address.poiId);
            jSONObject.put("displayname", address.displayName);
            jSONObject.put("address", address.address);
            jSONObject.put(Const.H5Params.ADDRESSALL, address.fullName);
            jSONObject.put("lat", address.latitude);
            jSONObject.put("lng", address.longitude);
            jSONObject.put(DepartureConstants.SRCTAG, address.srcTag);
            jSONObject.put("coordinate_type", address.coordinate_type);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
