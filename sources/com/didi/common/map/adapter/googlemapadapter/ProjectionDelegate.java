package com.didi.common.map.adapter.googlemapadapter;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IProjectionDelegate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.SphericalUtil;

public class ProjectionDelegate implements IProjectionDelegate {

    /* renamed from: a */
    private static final String f12611a = "ProjectionDelegate";

    /* renamed from: b */
    private Context f12612b;

    /* renamed from: c */
    private GoogleMap f12613c;

    public ProjectionDelegate(GoogleMap googleMap, Context context) {
        this.f12613c = googleMap;
        this.f12612b = context;
    }

    public PointF toScreenLocation(LatLng latLng) throws MapNotExistApiException {
        GoogleMap googleMap = this.f12613c;
        if (googleMap == null || googleMap.getProjection() == null) {
            return new PointF(0.0f, 0.0f);
        }
        Point point = null;
        try {
            point = this.f12613c.getProjection().toScreenLocation(Converter.convertToGoogleLatLng(latLng));
        } catch (Exception e) {
            DLog.m10773d(f12611a, "toScreenLocation Exception=%s", e.toString());
        }
        if (point == null) {
            return new PointF(0.0f, 0.0f);
        }
        return Converter.convertToPointF(point);
    }

    public LatLng fromScreenLocation(PointF pointF) throws MapNotExistApiException {
        GoogleMap googleMap = this.f12613c;
        if (googleMap == null || googleMap.getProjection() == null) {
            return new LatLng(0.0d, 0.0d);
        }
        com.google.android.gms.maps.model.LatLng latLng = null;
        try {
            latLng = this.f12613c.getProjection().fromScreenLocation(Converter.convertToPoint(pointF));
        } catch (Exception e) {
            DLog.m10773d(f12611a, "fromScreenLocation Exception=%s", e.toString());
        }
        if (latLng == null) {
            return new LatLng(0.0d, 0.0d);
        }
        return Converter.convertFromGoogleLatLng(latLng);
    }

    public VisibleRegion getVisibleRegion() {
        return Converter.fromGoogleVisibleRegion(this.f12613c.getProjection().getVisibleRegion());
    }

    public double metersPerPixel(double d) {
        int i;
        if (this.f12613c == null) {
            return -1.0d;
        }
        Context context = this.f12612b;
        if (context == null) {
            i = 1080;
        } else {
            i = context.getResources().getDisplayMetrics().widthPixels;
        }
        try {
            com.google.android.gms.maps.model.VisibleRegion visibleRegion = this.f12613c.getProjection().getVisibleRegion();
            return SphericalUtil.computeDistanceBetween(new com.google.android.gms.maps.model.LatLng(visibleRegion.farLeft.latitude, visibleRegion.farLeft.longitude), new com.google.android.gms.maps.model.LatLng(visibleRegion.farRight.latitude, visibleRegion.farRight.longitude)) / ((double) i);
        } catch (Exception unused) {
            return -1.0d;
        }
    }
}
