package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import java.util.HashMap;
import java.util.Map;

public class MapServiceAnnotationDataModel extends UniModel {

    /* renamed from: a */
    private String f36823a;

    /* renamed from: b */
    private double f36824b;

    /* renamed from: c */
    private double f36825c;

    /* renamed from: d */
    private String f36826d;

    /* renamed from: e */
    private long f36827e;

    /* renamed from: f */
    private boolean f36828f;

    /* renamed from: g */
    private long f36829g;

    /* renamed from: h */
    private long f36830h;

    /* renamed from: i */
    private double f36831i;

    /* renamed from: j */
    private double f36832j;

    /* renamed from: k */
    private String f36833k;

    /* renamed from: l */
    private Map<String, String> f36834l;

    public String getAddressName() {
        return this.f36823a;
    }

    public void setAddressName(String str) {
        this.f36823a = str;
    }

    public double getLat() {
        return this.f36824b;
    }

    public void setLat(double d) {
        this.f36824b = d;
    }

    public double getLng() {
        return this.f36825c;
    }

    public void setLng(double d) {
        this.f36825c = d;
    }

    public String getImagePath() {
        return this.f36826d;
    }

    public void setImagePath(String str) {
        this.f36826d = str;
    }

    public long getImagePosition() {
        return this.f36827e;
    }

    public void setImagePosition(long j) {
        this.f36827e = j;
    }

    public boolean getEnable() {
        return this.f36828f;
    }

    public void setEnable(boolean z) {
        this.f36828f = z;
    }

    public long getCalloutType() {
        return this.f36829g;
    }

    public void setCalloutType(long j) {
        this.f36829g = j;
    }

    public long getZIndex() {
        return this.f36830h;
    }

    public void setZIndex(long j) {
        this.f36830h = j;
    }

    public double getAnchorU() {
        return this.f36831i;
    }

    public void setAnchorU(double d) {
        this.f36831i = d;
    }

    public double getAnchorV() {
        return this.f36832j;
    }

    public void setAnchorV(double d) {
        this.f36832j = d;
    }

    public String getAirBgPath() {
        return this.f36833k;
    }

    public void setAirBgPath(String str) {
        this.f36833k = str;
    }

    public Map<String, String> getExtParams() {
        return this.f36834l;
    }

    public void setExtParams(Map<String, String> map) {
        this.f36834l = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("addressName", this.f36823a);
        hashMap.put("lat", Double.valueOf(this.f36824b));
        hashMap.put("lng", Double.valueOf(this.f36825c));
        hashMap.put("imagePath", this.f36826d);
        hashMap.put("imagePosition", Long.valueOf(this.f36827e));
        hashMap.put("enable", Boolean.valueOf(this.f36828f));
        hashMap.put("calloutType", Long.valueOf(this.f36829g));
        hashMap.put("zIndex", Long.valueOf(this.f36830h));
        hashMap.put("anchorU", Double.valueOf(this.f36831i));
        hashMap.put("anchorV", Double.valueOf(this.f36832j));
        hashMap.put("airBgPath", this.f36833k);
        hashMap.put(ImCommons.BUNDLE_MAP, this.f36834l);
        return hashMap;
    }

    public static MapServiceAnnotationDataModel fromMap(Map<String, Object> map) {
        MapServiceAnnotationDataModel mapServiceAnnotationDataModel = new MapServiceAnnotationDataModel();
        String str = "";
        mapServiceAnnotationDataModel.f36823a = (!map.containsKey("addressName") || map.get("addressName") == null) ? str : (String) map.get("addressName");
        double d = 0.0d;
        mapServiceAnnotationDataModel.f36824b = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        mapServiceAnnotationDataModel.f36825c = (!map.containsKey("lng") || map.get("lng") == null) ? 0.0d : ((Double) map.get("lng")).doubleValue();
        mapServiceAnnotationDataModel.f36826d = (!map.containsKey("imagePath") || map.get("imagePath") == null) ? str : (String) map.get("imagePath");
        long j = 0;
        mapServiceAnnotationDataModel.f36827e = (!map.containsKey("imagePosition") || map.get("imagePosition") == null) ? 0 : ((Number) map.get("imagePosition")).longValue();
        mapServiceAnnotationDataModel.f36828f = (!map.containsKey("enable") || map.get("enable") == null) ? false : ((Boolean) map.get("enable")).booleanValue();
        mapServiceAnnotationDataModel.f36829g = (!map.containsKey("calloutType") || map.get("calloutType") == null) ? 0 : ((Number) map.get("calloutType")).longValue();
        if (map.containsKey("zIndex") && map.get("zIndex") != null) {
            j = ((Number) map.get("zIndex")).longValue();
        }
        mapServiceAnnotationDataModel.f36830h = j;
        mapServiceAnnotationDataModel.f36831i = (!map.containsKey("anchorU") || map.get("anchorU") == null) ? 0.0d : ((Double) map.get("anchorU")).doubleValue();
        if (map.containsKey("anchorV") && map.get("anchorV") != null) {
            d = ((Double) map.get("anchorV")).doubleValue();
        }
        mapServiceAnnotationDataModel.f36832j = d;
        if (map.containsKey("airBgPath") && map.get("airBgPath") != null) {
            str = (String) map.get("airBgPath");
        }
        mapServiceAnnotationDataModel.f36833k = str;
        mapServiceAnnotationDataModel.f36834l = (!map.containsKey(ImCommons.BUNDLE_MAP) || map.get(ImCommons.BUNDLE_MAP) == null) ? new HashMap<>() : (Map) map.get(ImCommons.BUNDLE_MAP);
        return mapServiceAnnotationDataModel;
    }
}
