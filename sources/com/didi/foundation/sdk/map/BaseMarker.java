package com.didi.foundation.sdk.map;

import android.content.Context;
import android.view.View;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.sdk.apm.SystemUtils;

public abstract class BaseMarker {

    /* renamed from: a */
    private IMapView f23110a;

    /* renamed from: b */
    private boolean f23111b = true;

    /* renamed from: c */
    private MarkerOptions f23112c;

    /* renamed from: d */
    private Marker f23113d;

    public void onAdd() {
    }

    public abstract void onCreate();

    public BaseMarker(IMapView iMapView) {
        this.f23110a = iMapView;
        onCreate();
    }

    public void onDestroy() {
        IMapView iMapView;
        Marker marker = this.f23113d;
        if (marker != null && (iMapView = this.f23110a) != null) {
            iMapView.remove(marker);
            this.f23113d = null;
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        IMapView iMapView = this.f23110a;
        if (iMapView == null) {
            return null;
        }
        this.f23112c = markerOptions;
        Marker marker = this.f23113d;
        if (marker != null) {
            iMapView.remove(marker);
        }
        Marker addMarker = this.f23110a.addMarker(getClass().getSimpleName(), markerOptions);
        this.f23113d = addMarker;
        if (addMarker != null) {
            SystemUtils.log(3, "MapFragment", "setVisible: " + this.f23111b, (Throwable) null, "com.didi.foundation.sdk.map.BaseMarker", 68);
            this.f23113d.setVisible(this.f23111b);
            onAdd();
        }
        return this.f23113d;
    }

    public Marker getDidiCommonMarker() {
        return this.f23113d;
    }

    public BaseMarker setPosition(LatLng latLng) {
        MarkerOptions markerOptions;
        if (latLng == null || this.f23110a == null || (markerOptions = this.f23112c) == null) {
            return null;
        }
        Marker marker = this.f23113d;
        if (marker != null) {
            marker.setVisible(this.f23111b);
            this.f23113d.setPosition(latLng);
        } else {
            markerOptions.position(latLng);
            addMarker(this.f23112c);
        }
        return this;
    }

    public BaseMarker setRotation(float f) {
        Marker marker;
        if (this.f23110a == null || (marker = this.f23113d) == null) {
            return null;
        }
        marker.setRotation(f);
        return this;
    }

    public BaseMarker setVisible(boolean z) {
        this.f23111b = z;
        Marker marker = this.f23113d;
        if (marker == null) {
            return null;
        }
        marker.setVisible(z);
        return this;
    }

    public boolean isVisible() {
        Marker marker = this.f23113d;
        if (marker == null) {
            return false;
        }
        return marker.isVisible();
    }

    public void remove() {
        IMapView iMapView;
        Marker marker = this.f23113d;
        if (marker != null && (iMapView = this.f23110a) != null) {
            iMapView.remove(marker);
            this.f23113d = null;
        }
    }

    public BaseMarker setInfoWindowAdapter(Context context, View view) {
        Marker marker = this.f23113d;
        if (marker != null) {
            marker.buildInfoWindow(this.f23110a.getDidiCommonMap(), context).showInfoWindow(view);
        }
        return this;
    }

    public BaseMarker setInfoWindowVisible(boolean z) {
        Marker marker = this.f23113d;
        if (marker != null) {
            marker.getInfoWindow().getInfoWindowMarker().setVisible(z);
        }
        return this;
    }
}
