package com.didi.rlab.uni_foundation.location;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.util.HashMap;
import java.util.Map;

public class LocationResult extends UniModel {

    /* renamed from: a */
    private double f36818a;

    /* renamed from: b */
    private double f36819b;

    /* renamed from: c */
    private double f36820c;

    /* renamed from: d */
    private double f36821d;

    public double getLongtitude() {
        return this.f36818a;
    }

    public void setLongtitude(double d) {
        this.f36818a = d;
    }

    public double getLatitude() {
        return this.f36819b;
    }

    public void setLatitude(double d) {
        this.f36819b = d;
    }

    public double getHorizontalAccuracy() {
        return this.f36820c;
    }

    public void setHorizontalAccuracy(double d) {
        this.f36820c = d;
    }

    public double getVerticalAccuracy() {
        return this.f36821d;
    }

    public void setVerticalAccuracy(double d) {
        this.f36821d = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("longtitude", Double.valueOf(this.f36818a));
        hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(this.f36819b));
        hashMap.put("horizontalAccuracy", Double.valueOf(this.f36820c));
        hashMap.put(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, Double.valueOf(this.f36821d));
        return hashMap;
    }

    public static LocationResult fromMap(Map<String, Object> map) {
        LocationResult locationResult = new LocationResult();
        double d = 0.0d;
        locationResult.f36818a = (!map.containsKey("longtitude") || map.get("longtitude") == null) ? 0.0d : ((Double) map.get("longtitude")).doubleValue();
        locationResult.f36819b = (!map.containsKey(Const.PageParams.LATITUDE) || map.get(Const.PageParams.LATITUDE) == null) ? 0.0d : ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue();
        locationResult.f36820c = (!map.containsKey("horizontalAccuracy") || map.get("horizontalAccuracy") == null) ? 0.0d : ((Double) map.get("horizontalAccuracy")).doubleValue();
        if (map.containsKey(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) && map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY) != null) {
            d = ((Double) map.get(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY)).doubleValue();
        }
        locationResult.f36821d = d;
        return locationResult;
    }
}
