package com.didi.map.global.component.line.utils;

import android.graphics.PointF;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DouglasUtil {

    /* renamed from: a */
    private int f28231a = 5;

    /* renamed from: b */
    private Projection f28232b;

    /* renamed from: c */
    private List<LatLng> f28233c;

    /* renamed from: d */
    private List<PointF> f28234d;

    public DouglasUtil(Projection projection) {
        this.f28232b = projection;
    }

    public void setThreshold(int i) {
        this.f28231a = i;
    }

    public void setRoutePoints(List<LatLng> list) {
        this.f28233c = list;
    }

    public List<PointF> getPointFsAfter() {
        return this.f28234d;
    }

    public List<PointF> getDouglasOptimiseResult() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28233c)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng screenLocation : this.f28233c) {
            PointF screenLocation2 = this.f28232b.toScreenLocation(screenLocation);
            if (screenLocation2 != null) {
                arrayList.add(screenLocation2);
            }
        }
        List<PointF> a = m22148a(arrayList);
        this.f28234d = a;
        return a;
    }

    public List<LatLng> getDouglasOptimisePoints() {
        List<PointF> douglasOptimiseResult = getDouglasOptimiseResult();
        if (CollectionUtil.isEmpty((Collection<?>) douglasOptimiseResult)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PointF fromScreenLocation : douglasOptimiseResult) {
            arrayList.add(this.f28232b.fromScreenLocation(fromScreenLocation));
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<PointF> m22148a(List<PointF> list) {
        int i;
        int size = list.size();
        int i2 = 1;
        double d = 0.0d;
        int i3 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            double a = m22146a(list.get(i2), list.get(0), list.get(i));
            if (a > d) {
                i3 = i2;
                d = a;
            }
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > ((double) this.f28231a)) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 <= i3) {
                    arrayList2.add(list.get(i4));
                    if (i4 == i3) {
                        arrayList3.add(list.get(i4));
                    }
                } else {
                    arrayList3.add(list.get(i4));
                }
            }
            List<PointF> a2 = m22148a(arrayList2);
            List<PointF> a3 = m22148a(arrayList3);
            a3.remove(0);
            a2.addAll(a3);
            return a2;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i));
        return arrayList;
    }

    public List<LatLng> getDouglasOptimiseLatLngs(List<LatLng> list) {
        int i;
        int size = list.size();
        int i2 = 1;
        double d = 0.0d;
        int i3 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            double a = m22147a(list.get(i2), list.get(0), list.get(i));
            if (a > d) {
                i3 = i2;
                d = a;
            }
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > ((double) this.f28231a)) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 <= i3) {
                    arrayList2.add(list.get(i4));
                    if (i4 == i3) {
                        arrayList3.add(list.get(i4));
                    }
                } else {
                    arrayList3.add(list.get(i4));
                }
            }
            List<LatLng> douglasOptimiseLatLngs = getDouglasOptimiseLatLngs(arrayList2);
            List<LatLng> douglasOptimiseLatLngs2 = getDouglasOptimiseLatLngs(arrayList3);
            douglasOptimiseLatLngs2.remove(0);
            douglasOptimiseLatLngs.addAll(douglasOptimiseLatLngs2);
            return douglasOptimiseLatLngs;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i));
        return arrayList;
    }

    /* renamed from: a */
    private static double m22147a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        return (m22145a(computeDistanceBetween, DDSphericalUtil.computeDistanceBetween(latLng, latLng3), DDSphericalUtil.computeDistanceBetween(latLng2, latLng3)) * 2.0d) / computeDistanceBetween;
    }

    /* renamed from: a */
    private static double m22146a(PointF pointF, PointF pointF2, PointF pointF3) {
        double distance = distance(pointF2, pointF3);
        return (m22145a(distance(pointF, pointF2), distance(pointF, pointF3), distance) * 2.0d) / distance;
    }

    public static double distance(PointF pointF, PointF pointF2) {
        double d = (double) pointF.y;
        double d2 = ((double) pointF.x) - ((double) pointF2.x);
        double d3 = d - ((double) pointF2.y);
        return Math.sqrt((d2 * d2) + (d3 * d3));
    }

    /* renamed from: a */
    private static double m22145a(double d, double d2, double d3) {
        double d4 = ((d + d2) + d3) / 2.0d;
        return Math.sqrt((d4 - d) * d4 * (d4 - d2) * (d4 - d3));
    }
}
