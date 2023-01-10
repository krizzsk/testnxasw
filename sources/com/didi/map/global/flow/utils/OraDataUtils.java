package com.didi.map.global.flow.utils;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OraDataUtils {
    public static List<LatLng> getLatLngListFromLegInfo(LegInfo legInfo) {
        ArrayList arrayList = new ArrayList();
        if (legInfo != null) {
            for (DoublePoint next : legInfo.geos) {
                if (next != null) {
                    arrayList.add(new LatLng((double) next.lat.floatValue(), (double) next.lng.floatValue()));
                }
            }
        }
        return arrayList;
    }

    public static List<OdPoint> convertToOdPoints(List<LatLng> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (LatLng next : list) {
            arrayList.add(new OdPoint(0L, 0, new DoublePoint.Builder().lat(Float.valueOf((float) next.latitude)).lng(Float.valueOf((float) next.longitude)).build(), "", 0, Float.valueOf(0.0f), 0, (DoublePoint) null, (String) null));
        }
        return arrayList;
    }

    public static List<LatLng> convertToLatLngList(List<DoublePoint> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (DoublePoint next : list) {
            if (next != null) {
                arrayList.add(new LatLng((double) next.lat.floatValue(), (double) next.lng.floatValue()));
            }
        }
        return arrayList;
    }

    public static boolean isSameOdPoints(List<OdPoint> list, List<OdPoint> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (OdPoint hasOdPoint : list) {
            if (!hasOdPoint(list2, hasOdPoint)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasOdPoint(List<OdPoint> list, OdPoint odPoint) {
        if (!(list == null || odPoint == null)) {
            for (OdPoint next : list) {
                if (next != null && odPoint != null && next.point != null && odPoint.point != null && Objects.equals(next.point.lat, odPoint.point.lat) && Objects.equals(next.point.lng, odPoint.point.lng) && Objects.equals(next.odType, odPoint.odType) && Objects.equals(next.pointType, odPoint.pointType)) {
                    return true;
                }
            }
        }
        return false;
    }
}
