package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.utils.LogUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class OrderParams extends BaseOrderParams {

    /* renamed from: A */
    private DTSdkOrderXActivityParam f46796A;

    /* renamed from: B */
    private PayEnterpriseInfo f46797B;

    /* renamed from: C */
    private String f46798C;

    /* renamed from: D */
    private String f46799D;

    /* renamed from: E */
    private String f46800E;

    /* renamed from: F */
    private DTSDKOrder412Param f46801F;

    /* renamed from: G */
    private String f46802G;

    /* renamed from: H */
    private String f46803H;

    /* renamed from: I */
    private long f46804I;

    /* renamed from: J */
    private String f46805J;

    /* renamed from: a */
    private int f46806a;

    /* renamed from: b */
    private DIDILocation f46807b;

    /* renamed from: c */
    private boolean f46808c = true;

    /* renamed from: d */
    private Address f46809d;

    /* renamed from: e */
    private Address f46810e;
    public int enterpriseFlag;

    /* renamed from: f */
    private int f46811f;

    /* renamed from: g */
    private long f46812g;

    /* renamed from: h */
    private String f46813h;

    /* renamed from: i */
    private int f46814i;

    /* renamed from: j */
    private String f46815j;

    /* renamed from: k */
    private String f46816k;

    /* renamed from: l */
    private int f46817l = -1;

    /* renamed from: m */
    private String f46818m;

    /* renamed from: n */
    private float f46819n = -1.0f;

    /* renamed from: o */
    private DTSdkOrderFlierParam f46820o;

    /* renamed from: p */
    private String f46821p;

    /* renamed from: q */
    private String f46822q;

    /* renamed from: r */
    private String f46823r;

    /* renamed from: s */
    private String f46824s;

    /* renamed from: t */
    private DTSdkOrderPassengerParam f46825t;

    /* renamed from: u */
    private DTSdkOrderGuideParam f46826u;

    /* renamed from: v */
    private DTSdkSpecialPoiParam f46827v;

    /* renamed from: w */
    private String f46828w;

    /* renamed from: x */
    private DTSdkOrderFlightParam f46829x;

    /* renamed from: y */
    private String f46830y;

    /* renamed from: z */
    private DTSdkOrderComboParam f46831z;

    public static final class DTSDKOrder412Param {
        public String cfExisted = "0";
        public String defaultFSearchId = "";
        public String defaultFSrcTag = "";
        public String defaultFUid = "";
        public String mapDraged = "0";
    }

    public static final class DTSdkOrderComboParam {
        public String comboId;
        public int comboType;
        public int mealMode;
        public String rentedInfo;
    }

    public static final class DTSdkOrderFlierParam {
        public int isCarPool = -1;
        public int isCarPoolShowed = -1;
        public int isSameWay = -1;
        public int isWillWait = -1;
        public String regionalDepartureTime;
        public int seatNumber;
        public DTSdkOrderFlierPoolStationParam stationCarPoolParam;
    }

    public static final class DTSdkOrderFlierPoolStationParam {
        public String stationAddress;
        public float stationLat;
        public float stationLng;
        public String stationName;
        public String stationPoiId;
    }

    public static final class DTSdkOrderFlightParam {
        public static final int PARAM_FLIGHT_PICKUP = 1;
        public static final int PARAM_FLIGHT_SEND = 2;
        public int flightType;
        public DTSdkOrderFlightPickupParam pickupParam;
        public DTSdkOrderSendParam sendParam;
    }

    public static final class DTSdkOrderFlightPickupParam {
        public String arrAirportId;
        public String arrCode;
        public int delayTime;
        public String depCode;
        public String depPlanTime;
        public String flightNumber;
        public int isGuide;
        public DTSdkSpecialPoiParam specialPoiParam;
    }

    public static final class DTSdkOrderGuideParam {
        public String guideApiInfo;
        public int guideScene = -1;
        public int sourceProduct = -1;
        public int sourceScene = -1;
    }

    public static final class DTSdkOrderPassengerParam {
        public String callcarName;
        public String callcarPhone;
    }

    public static final class DTSdkOrderSendParam {
        public int isCip;
        public String sendAirportId;
    }

    public static final class DTSdkOrderXActivityParam {
        public String xActivityId;
        public String xActivityType;
    }

    public static final class DTSdkSpecialPoiParam {
        public String specialPoiName;
        public int specialPoiSceneType;
        public String specialPoiid;
    }

    public Map<String, Object> convertBean2Map() {
        DTSdkOrderFlierParam dTSdkOrderFlierParam;
        HashMap hashMap = new HashMap();
        put(hashMap, "business_id", Integer.valueOf(getBusinessId()));
        put(hashMap, ParamKeys.PARAM_APP_TIME, System.currentTimeMillis() + "");
        if (!TextUtils.isEmpty(this.f46798C)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ID, this.f46798C);
        }
        if (!TextUtils.isEmpty(this.f46799D)) {
            put(hashMap, ParamKeys.PARAM_UNMATCHED_ESTIMATE_ID, this.f46799D);
        }
        put(hashMap, "flier", Integer.valueOf(this.f46806a));
        Address address = this.f46809d;
        if (address != null) {
            put(hashMap, "flat", Double.valueOf(address.getLatitude()));
            put(hashMap, "flng", Double.valueOf(this.f46809d.getLongitude()));
            put(hashMap, "area", Integer.valueOf(this.f46809d.getCityId()));
            put(hashMap, ParamKeys.PARAM_FROM_NAME, this.f46809d.getDisplayName());
            put(hashMap, "fromAddress", this.f46809d.getAddress());
            put(hashMap, ParamKeys.PARAM_STARTING_POI_ID, this.f46809d.getUid());
            put(hashMap, ParamKeys.PARAM_SPECIAL_HISTORY, Integer.valueOf(this.f46809d.getIsHistory()));
        }
        if (!TextUtils.isEmpty(this.f46805J)) {
            put(hashMap, "passenger_sheet", "{\"" + this.f46805J + "\":{\"is_confirm\":1}}");
        }
        if (this.f46809d != null) {
            LogUtil.m34913d("departure: PARAM_412_CHOOSE_F_SRCTAG =" + this.f46809d.getSrcTag());
            put(hashMap, "choose_f_srctag", this.f46809d.getSrcTag());
            put(hashMap, "choose_f_uid", this.f46809d.getUid());
            put(hashMap, "choose_f_searchid", this.f46809d.getSearchId());
        } else {
            put(hashMap, "choose_f_srctag", "");
            put(hashMap, "choose_f_uid", "");
            put(hashMap, "choose_f_searchid", "");
        }
        DTSDKOrder412Param dTSDKOrder412Param = this.f46801F;
        if (dTSDKOrder412Param != null) {
            put(hashMap, "default_f_searchid", dTSDKOrder412Param.defaultFSearchId);
            put(hashMap, "default_f_uid", this.f46801F.defaultFUid);
            put(hashMap, "default_f_srctag", this.f46801F.defaultFSrcTag);
        } else {
            put(hashMap, "default_f_searchid", "");
            put(hashMap, "default_f_uid", "");
            put(hashMap, "default_f_srctag", "");
        }
        DIDILocation dIDILocation = this.f46807b;
        if (dIDILocation != null) {
            put(hashMap, "lat", Double.valueOf(dIDILocation.getLatitude()));
            put(hashMap, "lng", Double.valueOf(this.f46807b.getLongitude()));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ParamKeys.PARAM_LOC_PROVIDER, this.f46807b.getProvider());
                jSONObject.put(ParamKeys.PARAM_LOC_ACCURACY, (double) this.f46807b.getAccuracy());
                put(hashMap, ParamKeys.PARAM_PASSTHROUGH_DATA, jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        Address address2 = this.f46810e;
        if (address2 != null) {
            put(hashMap, "toName", address2.getDisplayName());
            put(hashMap, "toAddress", this.f46810e.getAddress());
            put(hashMap, "tlat", Double.valueOf(this.f46810e.getLatitude()));
            put(hashMap, "tlng", Double.valueOf(this.f46810e.getLongitude()));
            put(hashMap, ParamKeys.PARAM_TO_AREA, Integer.valueOf(this.f46810e.getCityId()));
            put(hashMap, ParamKeys.PARAM_DEST_POI_ID, this.f46810e.getUid());
        }
        if (this.f46810e != null) {
            LogUtil.m34921i("createneworder: set srctag uid searchid params.");
            put(hashMap, "choose_t_srctag", this.f46810e.getSrcTag());
            put(hashMap, "choose_t_uid", this.f46810e.getUid());
            put(hashMap, "choose_t_searchid", this.f46810e.getSearchId());
        } else {
            put(hashMap, "choose_t_srctag", "");
            put(hashMap, "choose_t_uid", "");
            put(hashMap, "choose_t_searchid", "");
        }
        Address address3 = this.f46810e;
        if (address3 == null || !address3.isRecommendTag()) {
            put(hashMap, "default_t_searchid", "");
            put(hashMap, "default_t_uid", "");
            put(hashMap, "default_t_srctag", "");
        } else {
            put(hashMap, "default_t_searchid", this.f46810e.getSearchId());
            put(hashMap, "default_t_uid", this.f46810e.getUid());
            put(hashMap, "default_t_srctag", this.f46810e.getSrcTag());
        }
        put(hashMap, "type", Integer.valueOf(this.f46811f));
        if (this.f46811f == 1) {
            put(hashMap, "time", this.f46813h);
            put(hashMap, ParamKeys.PARAM_BOOKINGTIME, Long.valueOf(this.f46812g));
        }
        put(hashMap, "tip", Integer.valueOf(Math.max(this.f46814i, 0)));
        if (!TextUtils.isEmpty(this.f46815j)) {
            put(hashMap, "require_level", this.f46815j);
        }
        if (!TextUtils.isEmpty(this.f46800E)) {
            put(hashMap, ParamKeys.PARAM_DESIGNATED_DRIVER, this.f46800E);
        }
        if (!TextUtils.isEmpty(this.f46816k)) {
            put(hashMap, "estimate_trace_id", this.f46816k);
        }
        int i = this.f46817l;
        if (i != -1) {
            put(hashMap, "scene_type", Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(this.f46818m)) {
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f46818m);
        }
        float f = this.f46819n;
        if (f != -1.0f) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_PRICE, Float.valueOf(f));
        }
        if (260 == getBusinessId() && (dTSdkOrderFlierParam = this.f46820o) != null) {
            if (dTSdkOrderFlierParam.isCarPool != -1) {
                put(hashMap, "car_pool", Integer.valueOf(this.f46820o.isCarPool));
            }
            if (this.f46820o.isCarPoolShowed != -1) {
                put(hashMap, ParamKeys.PARAM_CARPOOL_SHOW, Integer.valueOf(this.f46820o.isCarPoolShowed));
            }
            if (!TextUtils.isEmpty(this.f46820o.regionalDepartureTime)) {
                put(hashMap, ParamKeys.PARAM_REGIONAL_DEPARTURE_TIME, this.f46820o.regionalDepartureTime);
            }
            if (this.f46820o.isCarPool == 1) {
                if (this.f46820o.isWillWait != -1) {
                    put(hashMap, "like_wait", Integer.valueOf(this.f46820o.isWillWait));
                }
                if (this.f46820o.seatNumber > 0) {
                    put(hashMap, ParamKeys.PARAM_POOL_SEAT, Integer.valueOf(this.f46820o.seatNumber));
                }
                if (this.f46820o.stationCarPoolParam != null && !TextUtils.isEmpty(this.f46820o.stationCarPoolParam.stationName)) {
                    put(hashMap, ParamKeys.PARAM_IS_POOL_STATION, 1);
                    put(hashMap, "flat", Float.valueOf(this.f46820o.stationCarPoolParam.stationLat));
                    put(hashMap, "flng", Float.valueOf(this.f46820o.stationCarPoolParam.stationLng));
                    put(hashMap, ParamKeys.PARAM_FROM_NAME, this.f46820o.stationCarPoolParam.stationName);
                    put(hashMap, "fromAddress", this.f46820o.stationCarPoolParam.stationAddress);
                    put(hashMap, ParamKeys.PARAM_STATION_ID, this.f46820o.stationCarPoolParam.stationPoiId);
                }
            } else if (this.f46820o.isSameWay != -1) {
                put(hashMap, ParamKeys.PARAM_SAME_WAY, Integer.valueOf(this.f46820o.isSameWay));
            }
        }
        put(hashMap, "openid", this.f46821p);
        DTSDKOrder412Param dTSDKOrder412Param2 = this.f46801F;
        if (dTSDKOrder412Param2 != null) {
            put(hashMap, "if_move", dTSDKOrder412Param2.mapDraged);
            put(hashMap, "if_cf", this.f46801F.cfExisted);
        } else {
            put(hashMap, "if_move", "0");
            put(hashMap, "if_cf", "0");
        }
        if (!TextUtils.isEmpty(this.f46822q)) {
            put(hashMap, ParamKeys.PARAM_USER_PAY_INFO, this.f46822q);
        }
        PayEnterpriseInfo payEnterpriseInfo = this.f46797B;
        if (payEnterpriseInfo != null) {
            put(hashMap, "business_submit", payEnterpriseInfo.toString());
        }
        if (!TextUtils.isEmpty(this.f46823r)) {
            put(hashMap, "business_submit", this.f46823r);
        }
        put(hashMap, "nettype", this.f46824s);
        put(hashMap, ParamKeys.PARAM_VERSION_ID, ParamKeys.PARAM_VERSION_VALUE);
        put(hashMap, ParamKeys.PARAM_PROTECT_STATUS, 0);
        put(hashMap, "input", 1);
        put(hashMap, ParamKeys.PARAM_DEFAULT_VOUCHER, 1);
        put(hashMap, ParamKeys.PARAM_IS_MULTICAR, 1);
        put(hashMap, "activity_id", 201503);
        DTSdkOrderPassengerParam dTSdkOrderPassengerParam = this.f46825t;
        if (dTSdkOrderPassengerParam == null || TextUtils.isEmpty(dTSdkOrderPassengerParam.callcarPhone) || this.f46825t.callcarPhone.equals(TEBridge.clientConfig().phone())) {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE, 0);
        } else {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE, 1);
            put(hashMap, ParamKeys.PARAM_CALLER_PHONE, this.f46825t.callcarPhone);
            put(hashMap, ParamKeys.PARAM_CALLER_NAME, this.f46825t.callcarName);
        }
        DTSdkOrderGuideParam dTSdkOrderGuideParam = this.f46826u;
        if (dTSdkOrderGuideParam != null) {
            put(hashMap, ParamKeys.PARAM_GUIDE_API_INFO, dTSdkOrderGuideParam.guideApiInfo);
            if (this.f46826u.guideScene != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_GUIDE_SCENE, Integer.valueOf(this.f46826u.guideScene));
            }
            if (this.f46826u.sourceProduct != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_SOURCE_PRODUCT, Integer.valueOf(this.f46826u.sourceProduct));
            }
            if (this.f46826u.sourceScene != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_SOURCE_SCENE, Integer.valueOf(this.f46826u.sourceScene));
            }
        }
        DTSdkSpecialPoiParam dTSdkSpecialPoiParam = this.f46827v;
        if (dTSdkSpecialPoiParam != null) {
            put(hashMap, ParamKeys.PARAM_SPECIAL_POIID, dTSdkSpecialPoiParam.specialPoiid);
            put(hashMap, ParamKeys.PARAM_SPECIAL_POINAME, this.f46827v.specialPoiName);
            put(hashMap, ParamKeys.PARAM_SPECIAL_POISCENE_TYPE, Integer.valueOf(this.f46827v.specialPoiSceneType));
        }
        if (!TextUtils.isEmpty(this.f46828w)) {
            put(hashMap, "extraInfo", this.f46828w);
        }
        DTSdkOrderFlightParam dTSdkOrderFlightParam = this.f46829x;
        if (dTSdkOrderFlightParam != null) {
            if (dTSdkOrderFlightParam.flightType == 1 && this.f46829x.pickupParam != null) {
                put(hashMap, ParamKeys.PARAM_OTYPE, 3);
                put(hashMap, "traffic_number", this.f46829x.pickupParam.flightNumber);
                put(hashMap, ParamKeys.PARAM_TRAFFIC_DEP_TIME, this.f46829x.pickupParam.depPlanTime);
                put(hashMap, ParamKeys.PARAM_FLIGHTDEPCODE, this.f46829x.pickupParam.depCode);
                put(hashMap, ParamKeys.PARAM_FLIGHTARRCODE, this.f46829x.pickupParam.arrCode);
                put(hashMap, "airport_id", this.f46829x.pickupParam.arrAirportId);
                put(hashMap, ParamKeys.PARAM_DEPART_DELAY_TIME, Integer.valueOf(this.f46829x.pickupParam.delayTime));
                put(hashMap, ParamKeys.PARAM_SELECTED_GUIDE, Integer.valueOf(this.f46829x.pickupParam.isGuide));
                if (this.f46829x.pickupParam.specialPoiParam != null) {
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POISCENE_TYPE, Integer.valueOf(this.f46829x.pickupParam.specialPoiParam.specialPoiSceneType));
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POIID, this.f46829x.pickupParam.specialPoiParam.specialPoiid);
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POINAME, this.f46829x.pickupParam.specialPoiParam.specialPoiName);
                }
            } else if (this.f46829x.flightType == 2 && this.f46829x.sendParam != null) {
                put(hashMap, ParamKeys.PARAM_OTYPE, 4);
                put(hashMap, "airport_id", this.f46829x.sendParam.sendAirportId);
                put(hashMap, ParamKeys.PARAM_DEPART_SELECTED_CIP, Integer.valueOf(this.f46829x.sendParam.isCip));
            }
        }
        if (!TextUtils.isEmpty(this.f46830y)) {
            put(hashMap, ParamKeys.PARAM_CUSTOM_FEATURE, this.f46830y);
        }
        DTSdkOrderComboParam dTSdkOrderComboParam = this.f46831z;
        if (dTSdkOrderComboParam != null) {
            put(hashMap, "combo_type", Integer.valueOf(dTSdkOrderComboParam.comboType));
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f46831z.comboId);
            put(hashMap, ParamKeys.PARAM_MEAL_MODE, Integer.valueOf(this.f46831z.mealMode));
            if (!TextUtils.isEmpty(this.f46831z.rentedInfo)) {
                put(hashMap, ParamKeys.RENTED_INFO, this.f46831z.rentedInfo);
            }
        }
        DTSdkOrderXActivityParam dTSdkOrderXActivityParam = this.f46796A;
        if (dTSdkOrderXActivityParam != null) {
            put(hashMap, ParamKeys.PARAM_XACTIVITY_ID, dTSdkOrderXActivityParam.xActivityId);
            put(hashMap, ParamKeys.PARAM_XACTIVITY_TYPE, this.f46796A.xActivityType);
        }
        if (!TextUtil.isEmpty(this.f46803H)) {
            put(hashMap, "traffic_number", this.f46803H);
        }
        put(hashMap, ParamKeys.PARAM_ENTERPRISE_FLAG, Integer.valueOf(this.enterpriseFlag));
        return hashMap;
    }

    public void setEnterpriseFlag(int i) {
        this.enterpriseFlag = i;
    }

    public void setEstimateId(String str) {
        this.f46798C = str;
    }

    public void setUnmatchedEstimateId(String str) {
        this.f46799D = str;
    }

    public void setIsFlier(int i) {
        this.f46806a = i;
    }

    public void setLastKnownLocation(DIDILocation dIDILocation) {
        this.f46807b = dIDILocation;
    }

    public void setStartAddress(Address address) {
        this.f46809d = address;
    }

    public void setEndAddress(Address address) {
        this.f46810e = address;
    }

    public void setBookingType(int i) {
        this.f46811f = i;
    }

    public void setDepartureTime(long j) {
        this.f46812g = j;
    }

    public void setFormatTime(String str) {
        this.f46813h = str;
    }

    public void setTipPrice(int i) {
        this.f46814i = i;
    }

    public void setCarLevelId(String str) {
        this.f46815j = str;
    }

    public void setEstimateTraceId(String str) {
        this.f46816k = str;
    }

    public void setSceneType(int i) {
        this.f46817l = i;
    }

    public void setComboId(String str) {
        this.f46818m = str;
    }

    public void setEstimatePrice(float f) {
        this.f46819n = f;
    }

    public void setFlierParam(DTSdkOrderFlierParam dTSdkOrderFlierParam) {
        this.f46820o = dTSdkOrderFlierParam;
    }

    public void setWxPayOpenId(String str) {
        this.f46821p = str;
    }

    public void setPayType(String str) {
        this.f46822q = str;
    }

    public void setPaySubmitInfo(String str) {
        this.f46823r = str;
    }

    public void setNetType(String str) {
        this.f46824s = str;
    }

    public void setOtherCallCarParam(DTSdkOrderPassengerParam dTSdkOrderPassengerParam) {
        this.f46825t = dTSdkOrderPassengerParam;
    }

    public void setGuideParam(DTSdkOrderGuideParam dTSdkOrderGuideParam) {
        this.f46826u = dTSdkOrderGuideParam;
    }

    public void setSpecialPoiParam(DTSdkSpecialPoiParam dTSdkSpecialPoiParam) {
        this.f46827v = dTSdkSpecialPoiParam;
    }

    public void setUniTaxiRemark(String str) {
        this.f46828w = str;
    }

    public void setAirportParam(DTSdkOrderFlightParam dTSdkOrderFlightParam) {
        this.f46829x = dTSdkOrderFlightParam;
    }

    public void setCustomFeatures(String str) {
        this.f46830y = str;
    }

    public void setComboParam(DTSdkOrderComboParam dTSdkOrderComboParam) {
        this.f46831z = dTSdkOrderComboParam;
    }

    public DTSdkOrderComboParam getComboParam() {
        return this.f46831z;
    }

    public void setxActivityParam(DTSdkOrderXActivityParam dTSdkOrderXActivityParam) {
        this.f46796A = dTSdkOrderXActivityParam;
    }

    public PayEnterpriseInfo getPayEnterpriseInfo() {
        return this.f46797B;
    }

    public void setPayEnterpriseInfo(PayEnterpriseInfo payEnterpriseInfo) {
        this.f46797B = payEnterpriseInfo;
    }

    public String getDesignatedDriver() {
        return this.f46800E;
    }

    public void setDesignatedDriver(String str) {
        this.f46800E = str;
    }

    public DTSDKOrder412Param getOrder412Param() {
        return this.f46801F;
    }

    public void setOrder412Param(DTSDKOrder412Param dTSDKOrder412Param) {
        this.f46801F = dTSDKOrder412Param;
    }

    public String getSubPayAccountId() {
        return this.f46802G;
    }

    public void setSubPayAccountId(String str) {
        this.f46802G = str;
    }

    public void setFlightNum(String str) {
        this.f46803H = str;
    }

    public void setFixedPriceRouteId(long j) {
        this.f46804I = j;
    }

    public String getPassengerSheetKey() {
        return this.f46805J;
    }

    public void setPassengerSheetKey(String str) {
        this.f46805J = str;
    }

    public boolean isEstimateInfoMatch() {
        return this.f46808c;
    }

    public void setEstimateInfoMatch(boolean z) {
        this.f46808c = z;
    }
}
