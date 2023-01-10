package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import java.util.HashMap;
import java.util.Map;

public class MapMarkerOptions extends UniModel {

    /* renamed from: a */
    private String f36794a;

    /* renamed from: b */
    private String f36795b;

    /* renamed from: c */
    private long f36796c;

    /* renamed from: d */
    private double f36797d;

    /* renamed from: e */
    private double f36798e;

    /* renamed from: f */
    private double f36799f;

    /* renamed from: g */
    private double f36800g;

    /* renamed from: h */
    private double f36801h;

    /* renamed from: i */
    private String f36802i;

    /* renamed from: j */
    private double f36803j;

    /* renamed from: k */
    private double f36804k;

    /* renamed from: l */
    private boolean f36805l;

    public String getIcon() {
        return this.f36794a;
    }

    public void setIcon(String str) {
        this.f36794a = str;
    }

    public String getTitle() {
        return this.f36795b;
    }

    public void setTitle(String str) {
        this.f36795b = str;
    }

    public long getZIndex() {
        return this.f36796c;
    }

    public void setZIndex(long j) {
        this.f36796c = j;
    }

    public double getAlpha() {
        return this.f36797d;
    }

    public void setAlpha(double d) {
        this.f36797d = d;
    }

    public double getAnchorU() {
        return this.f36798e;
    }

    public void setAnchorU(double d) {
        this.f36798e = d;
    }

    public double getAnchorV() {
        return this.f36799f;
    }

    public void setAnchorV(double d) {
        this.f36799f = d;
    }

    public double getLatitude() {
        return this.f36800g;
    }

    public void setLatitude(double d) {
        this.f36800g = d;
    }

    public double getLongitude() {
        return this.f36801h;
    }

    public void setLongitude(double d) {
        this.f36801h = d;
    }

    public String getTag() {
        return this.f36802i;
    }

    public void setTag(String str) {
        this.f36802i = str;
    }

    public double getRotation() {
        return this.f36803j;
    }

    public void setRotation(double d) {
        this.f36803j = d;
    }

    public double getSize() {
        return this.f36804k;
    }

    public void setSize(double d) {
        this.f36804k = d;
    }

    public boolean getDodge() {
        return this.f36805l;
    }

    public void setDodge(boolean z) {
        this.f36805l = z;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", this.f36794a);
        hashMap.put("title", this.f36795b);
        hashMap.put("zIndex", Long.valueOf(this.f36796c));
        hashMap.put("alpha", Double.valueOf(this.f36797d));
        hashMap.put("anchorU", Double.valueOf(this.f36798e));
        hashMap.put("anchorV", Double.valueOf(this.f36799f));
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f36800g));
        hashMap.put(Const.PageParams.LONGITUDE, Double.valueOf(this.f36801h));
        hashMap.put("tag", this.f36802i);
        hashMap.put("rotation", Double.valueOf(this.f36803j));
        hashMap.put("size", Double.valueOf(this.f36804k));
        hashMap.put("dodge", Boolean.valueOf(this.f36805l));
        return hashMap;
    }

    public static MapMarkerOptions fromMap(Map<String, Object> map) {
        MapMarkerOptions mapMarkerOptions = new MapMarkerOptions();
        String str = "";
        mapMarkerOptions.f36794a = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        mapMarkerOptions.f36795b = (!map.containsKey("title") || map.get("title") == null) ? str : (String) map.get("title");
        mapMarkerOptions.f36796c = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        double d = 0.0d;
        mapMarkerOptions.f36797d = (!map.containsKey("alpha") || map.get("alpha") == null) ? 0.0d : ((Double) map.get("alpha")).doubleValue();
        mapMarkerOptions.f36798e = (!map.containsKey("anchorU") || map.get("anchorU") == null) ? 0.0d : ((Double) map.get("anchorU")).doubleValue();
        mapMarkerOptions.f36799f = (!map.containsKey("anchorV") || map.get("anchorV") == null) ? 0.0d : ((Double) map.get("anchorV")).doubleValue();
        mapMarkerOptions.f36800g = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        mapMarkerOptions.f36801h = (!map.containsKey(Const.PageParams.LONGITUDE) || map.get(Const.PageParams.LONGITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LONGITUDE)).doubleValue();
        if (map.containsKey("tag") && map.get("tag") != null) {
            str = (String) map.get("tag");
        }
        mapMarkerOptions.f36802i = str;
        mapMarkerOptions.f36803j = (!map.containsKey("rotation") || map.get("rotation") == null) ? 0.0d : ((Double) map.get("rotation")).doubleValue();
        if (map.containsKey("size") && map.get("size") != null) {
            d = ((Double) map.get("size")).doubleValue();
        }
        mapMarkerOptions.f36804k = d;
        mapMarkerOptions.f36805l = (!map.containsKey("dodge") || map.get("dodge") == null) ? false : ((Boolean) map.get("dodge")).booleanValue();
        return mapMarkerOptions;
    }
}
