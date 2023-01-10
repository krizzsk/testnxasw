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
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.taxis99.R;

public class SelectedMarker extends AbsBaseMarker {

    /* renamed from: a */
    private static final String f58688a = "map_selected_im_marker";

    /* renamed from: b */
    private final Map f58689b;

    /* renamed from: c */
    private final Logger f58690c = LoggerFactory.getLogger("SelectedMarker");

    /* renamed from: d */
    private MarkerOptions f58691d;

    /* renamed from: e */
    private LatLng f58692e;
    public Marker marker;

    public SelectedMarker(Map map) {
        BitmapDescriptor bitmapDescriptor;
        this.f58689b = map;
        Context context = map.getContext();
        if (ImMapConfig.getInstance().getFavorFrom() == ImFavorFrom.IMMAP_BRAZIL) {
            bitmapDescriptor = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_99_water_icon);
        } else {
            bitmapDescriptor = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_water_icon);
        }
        if (bitmapDescriptor != null) {
            Bitmap scaledBitmap = ImageUtil.getScaledBitmap(context, bitmapDescriptor.getBitmap());
            MarkerOptions markerOptions = new MarkerOptions();
            this.f58691d = markerOptions;
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap));
            this.f58691d.anchor(0.5f, 0.5f);
            this.f58691d.title("selected");
            this.f58691d.zIndex(30);
        }
    }

    public Map getMap() {
        return this.f58689b;
    }

    public void addMarker() {
        MarkerOptions markerOptions;
        Map map = this.f58689b;
        if (map != null && (markerOptions = this.f58691d) != null) {
            this.marker = map.addMarker(f58688a, markerOptions);
            setVisible(this.f58691d.getPosition() != null);
        }
    }

    public void removeMarker() {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            this.f58689b.remove(marker2);
            this.marker = null;
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null && latLng.longitude != 0.0d && latLng.latitude != 0.0d) {
            this.f58692e = latLng;
            Marker marker2 = this.marker;
            if (marker2 == null) {
                MarkerOptions markerOptions = this.f58691d;
                if (markerOptions != null) {
                    markerOptions.position(latLng);
                    this.marker = this.f58689b.addMarker(f58688a, this.f58691d);
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
        LatLng latLng = this.f58692e;
        return latLng == null ? new LatLng(0.0d, 0.0d) : latLng;
    }

    public void setZIndex(int i) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setZIndex(i);
        }
    }
}
