package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.HashMap;
import java.util.Map;

public class IMLocationResult extends UniModel {

    /* renamed from: a */
    private double f36933a;

    /* renamed from: b */
    private double f36934b;

    /* renamed from: c */
    private double f36935c;

    /* renamed from: d */
    private double f36936d;

    public double getLatitude() {
        return this.f36933a;
    }

    public void setLatitude(double d) {
        this.f36933a = d;
    }

    public double getLongtitude() {
        return this.f36934b;
    }

    public void setLongtitude(double d) {
        this.f36934b = d;
    }

    public double getHorizontalAccuracy() {
        return this.f36935c;
    }

    public void setHorizontalAccuracy(double d) {
        this.f36935c = d;
    }

    public double getVerticalAccuracy() {
        return this.f36936d;
    }

    public void setVerticalAccuracy(double d) {
        this.f36936d = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f36933a));
        hashMap.put("longtitude", Double.valueOf(this.f36934b));
        hashMap.put("horizontalAccuracy", Double.valueOf(this.f36935c));
        hashMap.put(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, Double.valueOf(this.f36936d));
        return hashMap;
    }

    public static IMLocationResult fromMap(Map<String, Object> map) {
        IMLocationResult iMLocationResult = new IMLocationResult();
        double d = 0.0d;
        iMLocationResult.f36933a = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        iMLocationResult.f36934b = (!map.containsKey("longtitude") || map.get("longtitude") == null) ? 0.0d : ((Double) map.get("longtitude")).doubleValue();
        iMLocationResult.f36935c = (!map.containsKey("horizontalAccuracy") || map.get("horizontalAccuracy") == null) ? 0.0d : ((Double) map.get("horizontalAccuracy")).doubleValue();
        if (map.containsKey(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) && map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) != null) {
            d = ((Double) map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY)).doubleValue();
        }
        iMLocationResult.f36936d = d;
        return iMLocationResult;
    }
}
