package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapPolygonOptions extends UniModel {

    /* renamed from: a */
    private String f36806a;

    /* renamed from: b */
    private long f36807b;

    /* renamed from: c */
    private double f36808c;

    /* renamed from: d */
    private String f36809d;

    /* renamed from: e */
    private double f36810e;

    /* renamed from: f */
    private double f36811f;

    public String getFillColor() {
        return this.f36806a;
    }

    public void setFillColor(String str) {
        this.f36806a = str;
    }

    public long getZIndex() {
        return this.f36807b;
    }

    public void setZIndex(long j) {
        this.f36807b = j;
    }

    public double getStrokeWidth() {
        return this.f36808c;
    }

    public void setStrokeWidth(double d) {
        this.f36808c = d;
    }

    public String getStrokeColor() {
        return this.f36809d;
    }

    public void setStrokeColor(String str) {
        this.f36809d = str;
    }

    public double getCenterLng() {
        return this.f36810e;
    }

    public void setCenterLng(double d) {
        this.f36810e = d;
    }

    public double getCenterLat() {
        return this.f36811f;
    }

    public void setCenterLat(double d) {
        this.f36811f = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("fillColor", this.f36806a);
        hashMap.put("zIndex", Long.valueOf(this.f36807b));
        hashMap.put("strokeWidth", Double.valueOf(this.f36808c));
        hashMap.put("strokeColor", this.f36809d);
        hashMap.put("centerLng", Double.valueOf(this.f36810e));
        hashMap.put("centerLat", Double.valueOf(this.f36811f));
        return hashMap;
    }

    public static MapPolygonOptions fromMap(Map<String, Object> map) {
        MapPolygonOptions mapPolygonOptions = new MapPolygonOptions();
        String str = "";
        mapPolygonOptions.f36806a = (!map.containsKey("fillColor") || map.get("fillColor") == null) ? str : (String) map.get("fillColor");
        mapPolygonOptions.f36807b = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        double d = 0.0d;
        mapPolygonOptions.f36808c = (!map.containsKey("strokeWidth") || map.get("strokeWidth") == null) ? 0.0d : ((Double) map.get("strokeWidth")).doubleValue();
        if (map.containsKey("strokeColor") && map.get("strokeColor") != null) {
            str = (String) map.get("strokeColor");
        }
        mapPolygonOptions.f36809d = str;
        mapPolygonOptions.f36810e = (!map.containsKey("centerLng") || map.get("centerLng") == null) ? 0.0d : ((Double) map.get("centerLng")).doubleValue();
        if (map.containsKey("centerLat") && map.get("centerLat") != null) {
            d = ((Double) map.get("centerLat")).doubleValue();
        }
        mapPolygonOptions.f36811f = d;
        return mapPolygonOptions;
    }
}
