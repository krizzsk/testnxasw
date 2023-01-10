package com.rider.rlab_im_map_plugin.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.ImageUtil;
import com.taxis99.R;

public class TargetMarker extends AbsBaseMarker {

    /* renamed from: a */
    private static final String f58693a = "map_location_im_target_marker";

    /* renamed from: b */
    private final Map f58694b;

    /* renamed from: c */
    private FrameLayout f58695c;

    /* renamed from: d */
    private LatLng f58696d;
    public Marker marker;

    public TargetMarker(Map map) {
        this.f58694b = map;
        Context context = map.getContext();
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_water_icon);
        if (fromResource != null) {
            Bitmap scaledBitmap = ImageUtil.getScaledBitmap(context, fromResource.getBitmap());
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(scaledBitmap);
            FrameLayout frameLayout = new FrameLayout(context);
            this.f58695c = frameLayout;
            frameLayout.addView(imageView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = 134;
            layoutParams.height = 160;
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
        }
    }

    public Map getMap() {
        return this.f58694b;
    }

    public void addMarker() {
        FrameLayout frameLayout;
        Map map = this.f58694b;
        if (map != null && (frameLayout = this.f58695c) != null) {
            map.setTopViewToCenter(frameLayout, 0.5f, 0.5f);
        }
    }

    public void removeMarker() {
        Map map = this.f58694b;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null && latLng.longitude != 0.0d && latLng.latitude != 0.0d) {
            this.f58696d = latLng;
        }
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getLatLng() {
        return this.f58696d;
    }
}
