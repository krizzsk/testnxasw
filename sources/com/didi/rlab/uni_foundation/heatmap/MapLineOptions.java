package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Map;

public class MapLineOptions extends UniModel {

    /* renamed from: a */
    private long f36781a;

    /* renamed from: b */
    private String f36782b;

    /* renamed from: c */
    private boolean f36783c;

    /* renamed from: d */
    private long f36784d;

    /* renamed from: e */
    private double f36785e;

    /* renamed from: f */
    private long f36786f;

    /* renamed from: g */
    private long f36787g;

    /* renamed from: h */
    private long f36788h;

    /* renamed from: i */
    private double f36789i;

    public long getZIndex() {
        return this.f36781a;
    }

    public void setZIndex(long j) {
        this.f36781a = j;
    }

    public String getColor() {
        return this.f36782b;
    }

    public void setColor(String str) {
        this.f36782b = str;
    }

    public boolean getHasDirectionArrow() {
        return this.f36783c;
    }

    public void setHasDirectionArrow(boolean z) {
        this.f36783c = z;
    }

    public long getWidth() {
        return this.f36784d;
    }

    public void setWidth(long j) {
        this.f36784d = j;
    }

    public double getSpace() {
        return this.f36785e;
    }

    public void setSpace(double d) {
        this.f36785e = d;
    }

    public long getLineEndType() {
        return this.f36786f;
    }

    public void setLineEndType(long j) {
        this.f36786f = j;
    }

    public long getLineJoinType() {
        return this.f36787g;
    }

    public void setLineJoinType(long j) {
        this.f36787g = j;
    }

    public long getType() {
        return this.f36788h;
    }

    public void setType(long j) {
        this.f36788h = j;
    }

    public double getRouteRadius() {
        return this.f36789i;
    }

    public void setRouteRadius(double d) {
        this.f36789i = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("zIndex", Long.valueOf(this.f36781a));
        hashMap.put("color", this.f36782b);
        hashMap.put("hasDirectionArrow", Boolean.valueOf(this.f36783c));
        hashMap.put("width", Long.valueOf(this.f36784d));
        hashMap.put(BlocksConst.WIDGET_PARAMS_SPACE, Double.valueOf(this.f36785e));
        hashMap.put("lineEndType", Long.valueOf(this.f36786f));
        hashMap.put("lineJoinType", Long.valueOf(this.f36787g));
        hashMap.put("type", Long.valueOf(this.f36788h));
        hashMap.put("routeRadius", Double.valueOf(this.f36789i));
        return hashMap;
    }

    public static MapLineOptions fromMap(Map<String, Object> map) {
        MapLineOptions mapLineOptions = new MapLineOptions();
        long j = 0;
        mapLineOptions.f36781a = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        mapLineOptions.f36782b = (!map.containsKey("color") || map.get("color") == null) ? "" : (String) map.get("color");
        mapLineOptions.f36783c = (!map.containsKey("hasDirectionArrow") || map.get("hasDirectionArrow") == null) ? false : ((Boolean) map.get("hasDirectionArrow")).booleanValue();
        mapLineOptions.f36784d = (!map.containsKey("width") || map.get("width") == null) ? 0 : ((Number) map.get("width")).longValue();
        double d = 0.0d;
        mapLineOptions.f36785e = (!map.containsKey(BlocksConst.WIDGET_PARAMS_SPACE) || map.get(BlocksConst.WIDGET_PARAMS_SPACE) == null) ? 0.0d : ((Double) map.get(BlocksConst.WIDGET_PARAMS_SPACE)).doubleValue();
        mapLineOptions.f36786f = (!map.containsKey("lineEndType") || map.get("lineEndType") == null) ? 0 : ((Number) map.get("lineEndType")).longValue();
        mapLineOptions.f36787g = (!map.containsKey("lineJoinType") || map.get("lineJoinType") == null) ? 0 : ((Number) map.get("lineJoinType")).longValue();
        if (map.containsKey("type") && map.get("type") != null) {
            j = ((Number) map.get("type")).longValue();
        }
        mapLineOptions.f36788h = j;
        if (map.containsKey("routeRadius") && map.get("routeRadius") != null) {
            d = ((Double) map.get("routeRadius")).doubleValue();
        }
        mapLineOptions.f36789i = d;
        return mapLineOptions;
    }
}
