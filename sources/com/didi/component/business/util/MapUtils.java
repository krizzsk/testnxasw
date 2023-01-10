package com.didi.component.business.util;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.MapFlowView;
import com.didi.sdk.address.address.entity.Address;

public class MapUtils {

    /* renamed from: a */
    private static final double f13218a = 6378137.0d;

    /* renamed from: a */
    private static double m11100a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double getDistance(Address address, Address address2) {
        if (address == null || address2 == null) {
            return 0.0d;
        }
        return getDistance(new LatLng(address.longitude, address.latitude), new LatLng(address2.longitude, address2.latitude));
    }

    public static double getDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng2.longitude;
        double d4 = latLng2.latitude;
        double a = m11100a(d2);
        double a2 = m11100a(d4);
        return (double) (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a - a2) / 2.0d), 2.0d) + ((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin((m11100a(d) - m11100a(d3)) / 2.0d), 2.0d)))) * 2.0d) * f13218a) * 10000.0d) / 10000);
    }

    public static int[] calculateMapScaleCenter(int i, int i2, int i3, int i4) {
        return new int[]{i2 / 2, ((i3 + i) - i4) / 2};
    }

    public static double max(double... dArr) {
        double d = dArr[0];
        for (double d2 : dArr) {
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double min(double... dArr) {
        double d = dArr[0];
        for (double d2 : dArr) {
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static final LatLng getSymmetry(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng2.latitude * 2.0d) - latLng.latitude, (latLng2.longitude * 2.0d) - latLng.longitude);
    }

    public static Map getMapByMapFlowView(MapFlowView mapFlowView) {
        MapView mapView;
        if (mapFlowView == null || (mapView = mapFlowView.getMapView()) == null) {
            return null;
        }
        return mapView.getMap();
    }

    public static void hookToOpenMapIndoor(Context context, MapFlowView mapFlowView) {
        Map mapByMapFlowView;
        if (Utils.isBrazilPackage(context) && (mapByMapFlowView = getMapByMapFlowView(mapFlowView)) != null) {
            mapByMapFlowView.setIndoorEnabled(true);
        }
    }
}
