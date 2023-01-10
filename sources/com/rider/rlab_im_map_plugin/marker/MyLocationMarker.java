package com.rider.rlab_im_map_plugin.marker;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.ImageUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.map.ImMapView;
import com.taxis99.R;

public class MyLocationMarker extends AbsBaseMarker {

    /* renamed from: a */
    private static final String f58682a = "map_location_im_marker";

    /* renamed from: b */
    private final Map f58683b;

    /* renamed from: c */
    private ImMapView f58684c;

    /* renamed from: d */
    private final Logger f58685d = LoggerFactory.getLogger("MyLocationMarker");

    /* renamed from: e */
    private MarkerOptions f58686e;

    /* renamed from: f */
    private LatLng f58687f;
    public Marker marker;

    public MyLocationMarker(ImMapView imMapView, Map map) {
        this.f58684c = imMapView;
        this.f58683b = map;
        Context context = imMapView.getContext();
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_d_map_location);
        if (fromResource != null) {
            Bitmap scaledBitmap = ImageUtil.getScaledBitmap(context, fromResource.getBitmap());
            MarkerOptions markerOptions = new MarkerOptions();
            this.f58686e = markerOptions;
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap));
            this.f58686e.anchor(0.5f, 0.5f);
            this.f58686e.title("location");
            this.f58686e.zIndex(10);
        }
    }

    public Map getMap() {
        return this.f58683b;
    }

    public void addMarker() {
        MarkerOptions markerOptions;
        Map map = this.f58683b;
        if (map != null && (markerOptions = this.f58686e) != null) {
            this.marker = map.addMarker(f58682a, markerOptions);
            setVisible(this.f58686e.getPosition() != null);
        }
    }

    public void removeMarker() {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            this.f58683b.remove(marker2);
            this.marker = null;
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null && latLng.longitude != 0.0d && latLng.latitude != 0.0d) {
            this.f58687f = latLng;
            ImMapView imMapView = this.f58684c;
            if (imMapView != null) {
                imMapView.updatePosition(latLng);
            }
            Marker marker2 = this.marker;
            if (marker2 == null) {
                MarkerOptions markerOptions = this.f58686e;
                if (markerOptions != null) {
                    markerOptions.position(latLng);
                    this.marker = this.f58683b.addMarker(f58682a, this.f58686e);
                    setVisible(true);
                }
            } else if (!latLng.equals(marker2.getPosition())) {
                this.marker.setPosition(latLng);
            }
        }
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getLatLng() {
        LatLng latLng = this.f58687f;
        return latLng == null ? new LatLng(0.0d, 0.0d) : latLng;
    }

    public void setZIndex(int i) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setZIndex(i);
        }
    }

    public void updateArrowRotateAngle(float f) {
        Marker marker2 = this.marker;
        if (marker2 != null && this.f58686e != null && ((double) Math.abs(f - marker2.getRotation())) > 0.8d) {
            this.f58686e.rotation(f);
            this.marker.setRotation(this.f58686e.getRotation());
        }
    }
}
