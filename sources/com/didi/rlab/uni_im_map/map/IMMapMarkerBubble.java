package com.didi.rlab.uni_im_map.map;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class IMMapMarkerBubble extends UniModel {

    /* renamed from: a */
    private String f36967a;

    /* renamed from: b */
    private double f36968b;

    /* renamed from: c */
    private double f36969c;

    /* renamed from: d */
    private String f36970d;

    /* renamed from: e */
    private String f36971e;

    /* renamed from: f */
    private String f36972f;

    /* renamed from: g */
    private String f36973g;

    /* renamed from: h */
    private String f36974h;

    public String getIcon() {
        return this.f36967a;
    }

    public void setIcon(String str) {
        this.f36967a = str;
    }

    public double getLat() {
        return this.f36968b;
    }

    public void setLat(double d) {
        this.f36968b = d;
    }

    public double getLng() {
        return this.f36969c;
    }

    public void setLng(double d) {
        this.f36969c = d;
    }

    public String getAddress() {
        return this.f36970d;
    }

    public void setAddress(String str) {
        this.f36970d = str;
    }

    public String getDisplayname() {
        return this.f36971e;
    }

    public void setDisplayname(String str) {
        this.f36971e = str;
    }

    public String getCityName() {
        return this.f36972f;
    }

    public void setCityName(String str) {
        this.f36972f = str;
    }

    public String getCityid() {
        return this.f36973g;
    }

    public void setCityid(String str) {
        this.f36973g = str;
    }

    public String getCountry_iso_code() {
        return this.f36974h;
    }

    public void setCountry_iso_code(String str) {
        this.f36974h = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", this.f36967a);
        hashMap.put("lat", Double.valueOf(this.f36968b));
        hashMap.put("lng", Double.valueOf(this.f36969c));
        hashMap.put("address", this.f36970d);
        hashMap.put("displayname", this.f36971e);
        hashMap.put(InvitationPageActivity.CITY_NAME, this.f36972f);
        hashMap.put("cityid", this.f36973g);
        hashMap.put("country_iso_code", this.f36974h);
        return hashMap;
    }

    public static IMMapMarkerBubble fromMap(Map<String, Object> map) {
        IMMapMarkerBubble iMMapMarkerBubble = new IMMapMarkerBubble();
        String str = "";
        iMMapMarkerBubble.f36967a = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        double d = 0.0d;
        iMMapMarkerBubble.f36968b = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        if (map.containsKey("lng") && map.get("lng") != null) {
            d = ((Double) map.get("lng")).doubleValue();
        }
        iMMapMarkerBubble.f36969c = d;
        iMMapMarkerBubble.f36970d = (!map.containsKey("address") || map.get("address") == null) ? str : (String) map.get("address");
        iMMapMarkerBubble.f36971e = (!map.containsKey("displayname") || map.get("displayname") == null) ? str : (String) map.get("displayname");
        iMMapMarkerBubble.f36972f = (!map.containsKey(InvitationPageActivity.CITY_NAME) || map.get(InvitationPageActivity.CITY_NAME) == null) ? str : (String) map.get(InvitationPageActivity.CITY_NAME);
        iMMapMarkerBubble.f36973g = (!map.containsKey("cityid") || map.get("cityid") == null) ? str : (String) map.get("cityid");
        if (map.containsKey("country_iso_code") && map.get("country_iso_code") != null) {
            str = (String) map.get("country_iso_code");
        }
        iMMapMarkerBubble.f36974h = str;
        return iMMapMarkerBubble;
    }
}
