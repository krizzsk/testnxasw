package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class EstimateParams extends BaseEstimateParams {
    public static final int NEW_UI_HORIZONTAL = 0;
    public static final int NEW_UI_VERTICAL = 1;

    /* renamed from: A */
    private long f46751A;

    /* renamed from: B */
    private String f46752B;

    /* renamed from: C */
    private String f46753C;

    /* renamed from: D */
    private int f46754D = 1;

    /* renamed from: E */
    private int f46755E = 0;

    /* renamed from: F */
    private int f46756F;

    /* renamed from: G */
    private int f46757G;

    /* renamed from: H */
    private long f46758H = 0;

    /* renamed from: I */
    private long f46759I = 0;

    /* renamed from: J */
    private String f46760J;

    /* renamed from: K */
    private Map<String, Object> f46761K;

    /* renamed from: L */
    private List<JSONObject> f46762L;

    /* renamed from: M */
    private int f46763M;

    /* renamed from: N */
    private int f46764N = 0;

    /* renamed from: O */
    private int f46765O = 0;

    /* renamed from: P */
    private int f46766P = 0;

    /* renamed from: Q */
    private boolean f46767Q = false;

    /* renamed from: R */
    private String f46768R;

    /* renamed from: S */
    private String f46769S;

    /* renamed from: a */
    private Address f46770a;

    /* renamed from: b */
    private Address f46771b;

    /* renamed from: c */
    private long f46772c;
    public String curCompanyId;

    /* renamed from: d */
    private int f46773d;

    /* renamed from: e */
    private int f46774e;
    public int enterpriseFlag;
    public String estimateSceneType;
    public String estimateSort;

    /* renamed from: f */
    private String f46775f;
    public boolean fixedPrice;

    /* renamed from: g */
    private String f46776g;

    /* renamed from: h */
    private String f46777h;

    /* renamed from: i */
    private boolean f46778i;

    /* renamed from: j */
    private boolean f46779j;

    /* renamed from: k */
    private String f46780k;

    /* renamed from: l */
    private String f46781l;

    /* renamed from: m */
    private int f46782m = 1;

    /* renamed from: n */
    private String f46783n;

    /* renamed from: o */
    private String f46784o;

    /* renamed from: p */
    private String f46785p;

    /* renamed from: q */
    private String f46786q;

    /* renamed from: r */
    private String f46787r;
    public String regionalDepartureTime;
    public String routeList;

    /* renamed from: s */
    private String f46788s;

    /* renamed from: t */
    private String f46789t;

    /* renamed from: u */
    private String f46790u;

    /* renamed from: v */
    private String f46791v;

    /* renamed from: w */
    private String f46792w;

    /* renamed from: x */
    private String f46793x;

    /* renamed from: y */
    private String f46794y;

    /* renamed from: z */
    private String f46795z;

    public String getGroupType() {
        return this.f46760J;
    }

    public void setGroupType(String str) {
        this.f46760J = str;
    }

    public int getRequestSource() {
        return this.f46755E;
    }

    public void setRequestSource(int i) {
        this.f46755E = i;
    }

    public int getProductId() {
        return this.f46764N;
    }

    public void setProductId(int i) {
        this.f46764N = i;
    }

    public int getRequireLevel() {
        return this.f46765O;
    }

    public void setRequireLevel(int i) {
        this.f46765O = i;
    }

    public int getComboType() {
        return this.f46766P;
    }

    public void setComboType(int i) {
        this.f46766P = i;
    }

    public boolean isFormOpenRide() {
        return this.f46767Q;
    }

    public void setFormOpenRide(boolean z) {
        this.f46767Q = z;
    }

    public String getUser_input_price() {
        return this.f46769S;
    }

    public void setUser_input_price(String str) {
        this.f46769S = str;
    }

    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", TEBridge.clientConfig().token());
        Address address = this.f46770a;
        if (address != null) {
            put(hashMap, "from_lng", Double.valueOf(address.getLongitude()));
            put(hashMap, "from_lat", Double.valueOf(this.f46770a.getLatitude()));
            put(hashMap, "from_name", this.f46770a.getDisplayName());
            put(hashMap, "from_address", this.f46770a.getAddress());
            put(hashMap, ParamKeys.PARAM_FROM_AREA, Integer.valueOf(this.f46770a.getCityId()));
            put(hashMap, "from_poi_id", this.f46770a.getUid());
            put(hashMap, ParamKeys.PARAM_START_TYPE_V2, this.f46770a.getSrcTag());
        }
        Address address2 = this.f46771b;
        if (address2 != null) {
            put(hashMap, "to_lng", Double.valueOf(address2.getLongitude()));
            put(hashMap, "to_lat", Double.valueOf(this.f46771b.getLatitude()));
            put(hashMap, "to_name", this.f46771b.getDisplayName());
            put(hashMap, "to_address", this.f46771b.getAddress());
            put(hashMap, ParamKeys.PARAM_TO_POI_UID, this.f46771b.getUid());
            put(hashMap, ParamKeys.PARAM_TO_POI_TYPE, this.f46771b.getSrcTag());
            put(hashMap, ParamKeys.PARAM_TO_AREA, Integer.valueOf(this.f46771b.getCityId()));
        }
        int i = this.f46772c > 0 ? 1 : 0;
        put(hashMap, "order_type", Integer.valueOf(i));
        if (!TextUtils.isEmpty(this.f46753C)) {
            put(hashMap, ParamKeys.PARAM_WAY_POINTS, this.f46753C);
        }
        put(hashMap, ParamKeys.PARAM_CAR_WILL_WAIT, Integer.valueOf(this.f46778i ? 1 : 0));
        LogUtil.m34913d("CarReqest getEstimatePriceCoupon select seat  seatNum" + this.f46782m);
        put(hashMap, ParamKeys.PARAM_POOL_SEAT_V2, Integer.valueOf(this.f46782m));
        if (i == 1) {
            put(hashMap, "departure_time", Long.valueOf(this.f46772c / 1000));
        }
        put(hashMap, "user_type", Integer.valueOf(this.f46773d));
        put(hashMap, "scene_type", Integer.valueOf(this.f46774e));
        if (!TextUtils.isEmpty(this.f46776g)) {
            put(hashMap, ParamKeys.PARAM_PAYMENTS_TYPE, this.f46776g);
        }
        if (!TextUtils.isEmpty(this.f46777h)) {
            put(hashMap, "card_index", this.f46777h);
        }
        put(hashMap, "require_level", this.f46775f);
        if (!TextUtil.isEmpty(this.f46791v)) {
            put(hashMap, ParamKeys.PARAM_DESIGNATED_DRIVER, this.f46791v);
        }
        if (TextUtils.isEmpty(this.f46781l) || this.f46781l.equals(TEBridge.clientConfig().phone())) {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE_V2, 0);
        } else {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE_V2, 1);
            put(hashMap, ParamKeys.PARAM_CALLER_PHONE_V2, this.f46781l);
        }
        if (!TextUtil.isEmpty(this.f46780k)) {
            put(hashMap, ParamKeys.PARAM_GUIDE_TYPE, this.f46780k);
        }
        if (!TextUtils.isEmpty(this.f46789t)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_TRANSPARENT_DATA, this.f46789t);
        }
        if (this.f46779j) {
            put(hashMap, ParamKeys.PARAM_POOL_STATION, 1);
        }
        if (!TextUtils.isEmpty(this.f46783n)) {
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f46783n);
        }
        if (!TextUtils.isEmpty(this.f46784o)) {
            put(hashMap, "activity_id", this.f46784o);
        }
        if (!TextUtils.isEmpty(this.f46787r)) {
            put(hashMap, ParamKeys.PARAM_GUIDE_API_INFO, this.f46787r);
        }
        if (!TextUtil.isEmpty(this.f46785p)) {
            put(hashMap, ParamKeys.PARAM_CURRENT_STATION_ID, this.f46785p);
            put(hashMap, ParamKeys.PARAM_CARPOOL_REQUIRE_TRACE_ID, this.f46786q);
        }
        if (!TextUtils.isEmpty(this.f46788s)) {
            put(hashMap, ParamKeys.PARAM_CUSTOM_FEATURE, this.f46788s);
        }
        if (!TextUtils.isEmpty(this.f46790u)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ATHENA_PARAMS, this.f46790u);
        }
        if (!TextUtils.isEmpty(this.regionalDepartureTime)) {
            put(hashMap, ParamKeys.PARAM_REGIONAL_DEPARTURE_TIME, this.regionalDepartureTime);
        }
        if (!TextUtils.isEmpty(this.f46792w)) {
            put(hashMap, ParamKeys.PARAM_ONE_CONF, this.f46792w);
        }
        if (!TextUtil.isEmpty(this.f46793x)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_DEP_CODE, this.f46793x);
        }
        if (!TextUtil.isEmpty(this.f46794y)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_DEP_TERMINAL, this.f46794y);
        }
        if (!TextUtil.isEmpty(this.f46795z)) {
            put(hashMap, "airport_id", this.f46795z);
        }
        if (!TextUtil.isEmpty(this.f46752B)) {
            put(hashMap, ParamKeys.PARAM_MENU_ID, this.f46752B);
        }
        put(hashMap, ParamKeys.PARAM_ESTIMATE_FIXEDPRICE, Integer.valueOf(this.fixedPrice ? 1 : 0));
        if (!TextUtil.isEmpty(this.curCompanyId)) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.curCompanyId);
            put(hashMap, ParamKeys.PARAM_ESTIMATE_COMPANY_ID, jSONArray.toString());
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.routeList);
        }
        if (!TextUtil.isEmpty(this.estimateSceneType)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_SCENE_TYPE, this.estimateSceneType);
        }
        put(hashMap, ParamKeys.PARAM_ESTIMATE_SHIFT_TIME, Long.valueOf(this.f46751A));
        put(hashMap, ParamKeys.PARAM_ENTERPRISE_FLAG, Integer.valueOf(this.enterpriseFlag));
        if (!TextUtil.isEmpty(this.estimateSort)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_SORT, this.estimateSort);
        }
        put(hashMap, ParamKeys.PARAM_NEW_UI_TYPE, Integer.valueOf(this.f46754D));
        if (this.f46767Q || this.f46755E == 1) {
            put(hashMap, "product_id", Integer.valueOf(this.f46764N));
            put(hashMap, "combo_type", Integer.valueOf(this.f46766P));
            put(hashMap, "require_level", Integer.valueOf(this.f46765O));
        }
        put(hashMap, ParamKeys.PARAM_NEW_UI_REQUEST_SOURCE, Integer.valueOf(this.f46755E));
        if (!TextUtils.isEmpty(this.f46768R)) {
            put(hashMap, "req_id", this.f46768R);
        }
        put(hashMap, "group_type", this.f46760J);
        Map<String, Object> map = this.f46761K;
        if (map != null) {
            hashMap.put(ParamKeys.POST_BACK_PARAMS, map);
        }
        if (!TextUtils.isEmpty(this.f46769S)) {
            hashMap.put("user_input_price", this.f46769S);
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f46762L)) {
            hashMap.put(ParamKeys.PARAM_ANYCAR_PRODUCTS_SELECTED, this.f46762L);
        }
        hashMap.put(ParamKeys.PARAM_ANYCAR_PREFERENCE, Integer.valueOf(this.f46763M));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("select", Long.valueOf(this.f46758H));
        hashMap2.put("default", Long.valueOf(this.f46759I));
        hashMap.put(ParamKeys.PARAM_MULTI_ROUTE_ID_MAP, hashMap2);
        if (this.f46756F > 0) {
            ArrayList arrayList = new ArrayList();
            if (this.f46757G > 0) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("product_id", Integer.valueOf(this.f46757G));
                hashMap3.put("combo_type", Integer.valueOf(this.f46766P));
                hashMap3.put(ParamKeys.PARAM_PASS_BUY_CHOOSE, Integer.valueOf(this.f46756F));
                arrayList.add(hashMap3);
            }
            addParam(ParamKeys.PARAM_PRODUCT_INFO, arrayList);
        }
        return hashMap;
    }

    public String getReqId() {
        return this.f46768R;
    }

    public void setReqId(String str) {
        this.f46768R = str;
    }

    public int getUserType() {
        return this.f46773d;
    }

    public void setUserType(int i) {
        this.f46773d = i;
    }

    public long getDepartureTime() {
        return this.f46772c;
    }

    public void setDepartureTime(long j) {
        this.f46772c = j;
    }

    public Address getStartAddress() {
        return this.f46770a;
    }

    public void setStartAddress(Address address) {
        this.f46770a = address;
    }

    public Address getEndAddress() {
        return this.f46771b;
    }

    public void setEndAddress(Address address) {
        this.f46771b = address;
    }

    public String getCarLevelId() {
        return this.f46775f;
    }

    public void setCarLevelId(String str) {
        this.f46775f = str;
    }

    public String getPaymentsType() {
        return this.f46776g;
    }

    public void setPaymentsType(String str) {
        this.f46776g = str;
    }

    public String getCardIndex() {
        return this.f46777h;
    }

    public void setCardIndex(String str) {
        this.f46777h = str;
    }

    public String getPassengerPhone() {
        return this.f46781l;
    }

    public void setPassengerPhone(String str) {
        this.f46781l = str;
    }

    public int getSceneType() {
        return this.f46774e;
    }

    public void setSceneType(int i) {
        this.f46774e = i;
    }

    public String getGuideType() {
        return this.f46780k;
    }

    public void setGuideType(String str) {
        this.f46780k = str;
    }

    public boolean isWillWait() {
        return this.f46778i;
    }

    public void setWillWait(boolean z) {
        this.f46778i = z;
    }

    public int getSeatNumber() {
        return this.f46782m;
    }

    public void setSeatNumber(int i) {
        this.f46782m = i;
    }

    public boolean isOpenStation() {
        return this.f46779j;
    }

    public void setOpenStation(boolean z) {
        this.f46779j = z;
    }

    public String getTransparentData() {
        return this.f46789t;
    }

    public void setTransparentData(String str) {
        this.f46789t = str;
    }

    public String getComboId() {
        return this.f46783n;
    }

    public void setComboId(String str) {
        this.f46783n = str;
    }

    public String getActivityId() {
        return this.f46784o;
    }

    public void setActivityId(String str) {
        this.f46784o = str;
    }

    public String getGuideApiInfo() {
        return this.f46787r;
    }

    public void setGuideApiInfo(String str) {
        this.f46787r = str;
    }

    public String getCustomFeature() {
        return this.f46788s;
    }

    public void setCustomFeature(String str) {
        this.f46788s = str;
    }

    public String getStationId() {
        return this.f46785p;
    }

    public void setStationId(String str) {
        this.f46785p = str;
    }

    public String getStationTraceId() {
        return this.f46786q;
    }

    public void setStationTraceId(String str) {
        this.f46786q = str;
    }

    public String getAthenaParams() {
        return this.f46790u;
    }

    public void setAthenaParams(String str) {
        this.f46790u = str;
    }

    public void setRegionalDepartureTime(String str) {
        this.regionalDepartureTime = str;
    }

    public String getRegionalDepartureTime() {
        return this.regionalDepartureTime;
    }

    public String getDesignatedDriver() {
        return this.f46791v;
    }

    public void setDesignatedDriver(String str) {
        this.f46791v = str;
    }

    public String getBccInfo() {
        return this.f46792w;
    }

    public void setBccInfo(String str) {
        this.f46792w = str;
    }

    public String getDepatureCode() {
        return this.f46793x;
    }

    public void setDepatureCode(String str) {
        this.f46793x = str;
    }

    public String getDepatureTerminal() {
        return this.f46794y;
    }

    public void setDepatureTerminal(String str) {
        this.f46794y = str;
    }

    public String getAirportId() {
        return this.f46795z;
    }

    public void setAirportId(String str) {
        this.f46795z = str;
    }

    public long getFlightTime() {
        return this.f46751A;
    }

    public void setFlightTime(long j) {
        this.f46751A = j;
    }

    public String getMenuId() {
        return this.f46752B;
    }

    public void setMenuId(String str) {
        this.f46752B = str;
    }

    public String getWayPointAddressList() {
        return this.f46753C;
    }

    public void setWayPointAddressList(String str) {
        this.f46753C = str;
    }

    public void setEnterpriseFlag(int i) {
        this.enterpriseFlag = i;
    }

    public void setNewUIType(int i) {
        this.f46754D = i;
    }

    public void setPassBuyChoose(int i) {
        this.f46756F = i;
    }

    public int getPassBuyChoose() {
        return this.f46756F;
    }

    public void setPassProductId(int i) {
        this.f46757G = i;
    }

    public int getPassProductId() {
        return this.f46757G;
    }

    public long getMultiRouteId() {
        return this.f46758H;
    }

    public void setMultiRouteId(long j) {
        this.f46758H = j;
    }

    public long getDefaultRouteId() {
        return this.f46759I;
    }

    public void setDefaultRouteId(long j) {
        this.f46759I = j;
    }

    public void addPostBackParam(String str, Object obj) {
        if (this.f46761K == null) {
            this.f46761K = new HashMap();
        }
        this.f46761K.put(str, obj);
    }

    public void setSelectProducts(List<JSONObject> list) {
        this.f46762L = list;
    }

    public void setAnyCarPreference(int i) {
        this.f46763M = i;
    }
}
