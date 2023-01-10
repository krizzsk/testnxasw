package com.didi.map.utils;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.google.util.ConvertUtil;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/map/utils/MatchPointDisHandler;", "", "()V", "nextLength", "", "segmentInfoList", "", "Lcom/didi/map/utils/SegmentInfo;", "checkIsSamePoint", "", "p1", "Lcom/didi/common/map/model/LatLng;", "p2", "distanceToTail", "point", "Lcom/map/sdk/nav/libc/common/RouteGuidanceGPSPoint;", "pointToRouteTail", "setRoutePoints", "", "points", "", "routeWayIndex", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MatchPointDisHandler.kt */
public final class MatchPointDisHandler {

    /* renamed from: a */
    private int f31484a;

    /* renamed from: b */
    private final List<SegmentInfo> f31485b = new ArrayList();

    public final void setRoutePoints(List<LatLng> list) {
        int size;
        Intrinsics.checkNotNullParameter(list, "points");
        this.f31485b.clear();
        int i = 1;
        if (list.size() > 1 && 1 < (size = list.size())) {
            while (true) {
                int i2 = i + 1;
                int i3 = i - 1;
                LatLng latLng = list.get(i3);
                LatLng latLng2 = list.get(i);
                this.f31485b.add(new SegmentInfo(i3, latLng, latLng2, (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2)));
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        this.f31484a = 0;
    }

    public final void setRoutePoints(List<LatLng> list, int i) {
        Intrinsics.checkNotNullParameter(list, "points");
        boolean z = true;
        if (list.size() > 1) {
            if (i < 0 || i > list.size() - 1) {
                z = false;
            }
            if (z) {
                setRoutePoints(list.subList(0, i));
                this.f31484a = (int) DDSphericalUtil.computeLength(list.subList(i, list.size()));
                return;
            }
        }
        setRoutePoints(list);
    }

    public final int distanceToTail(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        if ((routeGuidanceGPSPoint == null ? null : routeGuidanceGPSPoint.point) == null) {
            return -1;
        }
        int a = m24037a(routeGuidanceGPSPoint);
        return a < 0 ? a : a + this.f31484a;
    }

    /* renamed from: a */
    private final int m24037a(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        LatLng convertFromGeoPoint;
        SegmentInfo segmentInfo;
        int i;
        int size;
        if (routeGuidanceGPSPoint.segmentIndex < 0 || routeGuidanceGPSPoint.segmentIndex + 1 >= this.f31485b.size() + 1 || (convertFromGeoPoint = ConvertUtil.convertFromGeoPoint(routeGuidanceGPSPoint.point)) == null || (segmentInfo = (SegmentInfo) CollectionsKt.getOrNull(this.f31485b, routeGuidanceGPSPoint.segmentIndex)) == null) {
            return -1;
        }
        LatLng point_e = segmentInfo.getPoint_e();
        boolean z = false;
        int computeDistanceBetween = !LatLngUtils.isSameLatLng(convertFromGeoPoint, point_e) ? ((int) DDSphericalUtil.computeDistanceBetween(convertFromGeoPoint, point_e)) + 0 : 0;
        int size2 = this.f31485b.size() - 1;
        int i2 = routeGuidanceGPSPoint.segmentIndex + 1;
        if (i2 >= 0 && i2 <= size2) {
            z = true;
        }
        if (z && (i = routeGuidanceGPSPoint.segmentIndex + 1) < (size = this.f31485b.size())) {
            while (true) {
                int i3 = i + 1;
                computeDistanceBetween += this.f31485b.get(i).getSegDis();
                if (i3 >= size) {
                    break;
                }
                i = i3;
            }
        }
        return computeDistanceBetween;
    }

    /* renamed from: a */
    private final boolean m24038a(LatLng latLng, LatLng latLng2) {
        return Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-6d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-6d;
    }
}
