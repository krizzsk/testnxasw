package com.didi.rlab.uni_im_map.map;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import java.util.HashMap;
import java.util.Map;

public class IMMapConfig extends UniModel {

    /* renamed from: a */
    private String f36937a;

    /* renamed from: b */
    private long f36938b;

    /* renamed from: c */
    private long f36939c;

    /* renamed from: d */
    private long f36940d;

    /* renamed from: e */
    private boolean f36941e;

    /* renamed from: f */
    private boolean f36942f;

    /* renamed from: g */
    private String f36943g;

    /* renamed from: h */
    private String f36944h;

    /* renamed from: i */
    private String f36945i;

    /* renamed from: j */
    private String f36946j;

    /* renamed from: k */
    private String f36947k;

    /* renamed from: l */
    private String f36948l;

    /* renamed from: m */
    private double f36949m;

    /* renamed from: n */
    private double f36950n;

    /* renamed from: o */
    private String f36951o;

    /* renamed from: p */
    private String f36952p;

    /* renamed from: q */
    private String f36953q;

    /* renamed from: r */
    private long f36954r;

    /* renamed from: s */
    private String f36955s;

    /* renamed from: t */
    private String f36956t;

    /* renamed from: u */
    private String f36957u;

    /* renamed from: v */
    private Map<String, Object> f36958v;

    /* renamed from: w */
    private String f36959w;

    public String getMapKey() {
        return this.f36937a;
    }

    public void setMapKey(String str) {
        this.f36937a = str;
    }

    public long getCallFrom() {
        return this.f36938b;
    }

    public void setCallFrom(long j) {
        this.f36938b = j;
    }

    public long getPageType() {
        return this.f36939c;
    }

    public void setPageType(long j) {
        this.f36939c = j;
    }

    public long getZoomLevel() {
        return this.f36940d;
    }

    public void setZoomLevel(long j) {
        this.f36940d = j;
    }

    public boolean getDowngradeMap() {
        return this.f36941e;
    }

    public void setDowngradeMap(boolean z) {
        this.f36941e = z;
    }

    public boolean getDowngradeMapNavigation() {
        return this.f36942f;
    }

    public void setDowngradeMapNavigation(boolean z) {
        this.f36942f = z;
    }

    public String getMapStyle() {
        return this.f36943g;
    }

    public void setMapStyle(String str) {
        this.f36943g = str;
    }

    public String getTicket() {
        return this.f36944h;
    }

    public void setTicket(String str) {
        this.f36944h = str;
    }

    public String getOrderId() {
        return this.f36945i;
    }

    public void setOrderId(String str) {
        this.f36945i = str;
    }

    public String getPassengerid() {
        return this.f36946j;
    }

    public void setPassengerid(String str) {
        this.f36946j = str;
    }

    public String getAddress() {
        return this.f36947k;
    }

    public void setAddress(String str) {
        this.f36947k = str;
    }

    public String getDisplayname() {
        return this.f36948l;
    }

    public void setDisplayname(String str) {
        this.f36948l = str;
    }

    public double getLat() {
        return this.f36949m;
    }

    public void setLat(double d) {
        this.f36949m = d;
    }

    public double getLng() {
        return this.f36950n;
    }

    public void setLng(double d) {
        this.f36950n = d;
    }

    public String getCityName() {
        return this.f36951o;
    }

    public void setCityName(String str) {
        this.f36951o = str;
    }

    public String getCityid() {
        return this.f36952p;
    }

    public void setCityid(String str) {
        this.f36952p = str;
    }

    public String getCountry_iso_code() {
        return this.f36953q;
    }

    public void setCountry_iso_code(String str) {
        this.f36953q = str;
    }

    public long getTravelMode() {
        return this.f36954r;
    }

    public void setTravelMode(long j) {
        this.f36954r = j;
    }

    public String getSettingTypeKey() {
        return this.f36955s;
    }

    public void setSettingTypeKey(String str) {
        this.f36955s = str;
    }

    public String getProductID() {
        return this.f36956t;
    }

    public void setProductID(String str) {
        this.f36956t = str;
    }

    public String getToken() {
        return this.f36957u;
    }

    public void setToken(String str) {
        this.f36957u = str;
    }

    public Map<String, Object> getExtParams() {
        return this.f36958v;
    }

    public void setExtParams(Map<String, Object> map) {
        this.f36958v = map;
    }

    public String getFavor() {
        return this.f36959w;
    }

    public void setFavor(String str) {
        this.f36959w = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapKey", this.f36937a);
        hashMap.put(ImCommons.BUNDLE_CALL_FROM, Long.valueOf(this.f36938b));
        hashMap.put(ImCommons.BUNDLE_TYPE, Long.valueOf(this.f36939c));
        hashMap.put("zoomLevel", Long.valueOf(this.f36940d));
        hashMap.put(ImCommons.BUNDLE_DOWNGRADE_MAP, Boolean.valueOf(this.f36941e));
        hashMap.put("downgradeMapNavigation", Boolean.valueOf(this.f36942f));
        hashMap.put("mapStyle", this.f36943g);
        hashMap.put("ticket", this.f36944h);
        hashMap.put("orderId", this.f36945i);
        hashMap.put(ParamKeys.PARAM_PASSENGER_ID, this.f36946j);
        hashMap.put("address", this.f36947k);
        hashMap.put("displayname", this.f36948l);
        hashMap.put("lat", Double.valueOf(this.f36949m));
        hashMap.put("lng", Double.valueOf(this.f36950n));
        hashMap.put(InvitationPageActivity.CITY_NAME, this.f36951o);
        hashMap.put("cityid", this.f36952p);
        hashMap.put("country_iso_code", this.f36953q);
        hashMap.put(ImCommons.BUNDLE_NAV_TYPE, Long.valueOf(this.f36954r));
        hashMap.put("settingTypeKey", this.f36955s);
        hashMap.put(SDKConstants.PARAM_PRODUCT_ID, this.f36956t);
        hashMap.put("token", this.f36957u);
        hashMap.put(ImCommons.BUNDLE_MAP, this.f36958v);
        hashMap.put(ImCommons.BUNDLE_FAVOR, this.f36959w);
        return hashMap;
    }

    public static IMMapConfig fromMap(Map<String, Object> map) {
        IMMapConfig iMMapConfig = new IMMapConfig();
        String str = "";
        iMMapConfig.f36937a = (!map.containsKey("mapKey") || map.get("mapKey") == null) ? str : (String) map.get("mapKey");
        long j = 0;
        iMMapConfig.f36938b = (!map.containsKey(ImCommons.BUNDLE_CALL_FROM) || map.get(ImCommons.BUNDLE_CALL_FROM) == null) ? 0 : ((Number) map.get(ImCommons.BUNDLE_CALL_FROM)).longValue();
        iMMapConfig.f36939c = (!map.containsKey(ImCommons.BUNDLE_TYPE) || map.get(ImCommons.BUNDLE_TYPE) == null) ? 0 : ((Number) map.get(ImCommons.BUNDLE_TYPE)).longValue();
        iMMapConfig.f36940d = (!map.containsKey("zoomLevel") || map.get("zoomLevel") == null) ? 0 : ((Number) map.get("zoomLevel")).longValue();
        iMMapConfig.f36941e = (!map.containsKey(ImCommons.BUNDLE_DOWNGRADE_MAP) || map.get(ImCommons.BUNDLE_DOWNGRADE_MAP) == null) ? false : ((Boolean) map.get(ImCommons.BUNDLE_DOWNGRADE_MAP)).booleanValue();
        iMMapConfig.f36942f = (!map.containsKey("downgradeMapNavigation") || map.get("downgradeMapNavigation") == null) ? false : ((Boolean) map.get("downgradeMapNavigation")).booleanValue();
        iMMapConfig.f36943g = (!map.containsKey("mapStyle") || map.get("mapStyle") == null) ? str : (String) map.get("mapStyle");
        iMMapConfig.f36944h = (!map.containsKey("ticket") || map.get("ticket") == null) ? str : (String) map.get("ticket");
        iMMapConfig.f36945i = (!map.containsKey("orderId") || map.get("orderId") == null) ? str : (String) map.get("orderId");
        iMMapConfig.f36946j = (!map.containsKey(ParamKeys.PARAM_PASSENGER_ID) || map.get(ParamKeys.PARAM_PASSENGER_ID) == null) ? str : (String) map.get(ParamKeys.PARAM_PASSENGER_ID);
        iMMapConfig.f36947k = (!map.containsKey("address") || map.get("address") == null) ? str : (String) map.get("address");
        iMMapConfig.f36948l = (!map.containsKey("displayname") || map.get("displayname") == null) ? str : (String) map.get("displayname");
        iMMapConfig.f36949m = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        iMMapConfig.f36950n = (!map.containsKey("lng") || map.get("lng") == null) ? 0.0d : ((Double) map.get("lng")).doubleValue();
        iMMapConfig.f36951o = (!map.containsKey(InvitationPageActivity.CITY_NAME) || map.get(InvitationPageActivity.CITY_NAME) == null) ? str : (String) map.get(InvitationPageActivity.CITY_NAME);
        iMMapConfig.f36952p = (!map.containsKey("cityid") || map.get("cityid") == null) ? str : (String) map.get("cityid");
        iMMapConfig.f36953q = (!map.containsKey("country_iso_code") || map.get("country_iso_code") == null) ? str : (String) map.get("country_iso_code");
        if (map.containsKey(ImCommons.BUNDLE_NAV_TYPE) && map.get(ImCommons.BUNDLE_NAV_TYPE) != null) {
            j = ((Number) map.get(ImCommons.BUNDLE_NAV_TYPE)).longValue();
        }
        iMMapConfig.f36954r = j;
        iMMapConfig.f36955s = (!map.containsKey("settingTypeKey") || map.get("settingTypeKey") == null) ? str : (String) map.get("settingTypeKey");
        iMMapConfig.f36956t = (!map.containsKey(SDKConstants.PARAM_PRODUCT_ID) || map.get(SDKConstants.PARAM_PRODUCT_ID) == null) ? str : (String) map.get(SDKConstants.PARAM_PRODUCT_ID);
        iMMapConfig.f36957u = (!map.containsKey("token") || map.get("token") == null) ? str : (String) map.get("token");
        iMMapConfig.f36958v = (!map.containsKey(ImCommons.BUNDLE_MAP) || map.get(ImCommons.BUNDLE_MAP) == null) ? new HashMap<>() : (Map) map.get(ImCommons.BUNDLE_MAP);
        if (map.containsKey(ImCommons.BUNDLE_FAVOR) && map.get(ImCommons.BUNDLE_FAVOR) != null) {
            str = (String) map.get(ImCommons.BUNDLE_FAVOR);
        }
        iMMapConfig.f36959w = str;
        return iMMapConfig;
    }
}
