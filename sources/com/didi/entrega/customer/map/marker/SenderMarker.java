package com.didi.entrega.customer.map.marker;

import android.content.Context;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import com.didi.foundation.sdk.map.IMapView;
import com.taxis99.R;
import java.util.ArrayList;

public class SenderMarker extends AbsMarker {
    public static final String TAG_SENDER_ADDRESS_MARKER = "tag_sender_address_marker";

    /* renamed from: a */
    private int f22057a;

    /* renamed from: b */
    private InfoWindowViewBuildConfig f22058b;

    public String getTag() {
        return TAG_SENDER_ADDRESS_MARKER;
    }

    public SenderMarker(Context context, IMapView iMapView, int i) {
        super(context, iMapView);
        m18289a(i);
    }

    /* renamed from: a */
    private void m18289a(int i) {
        if (i == 1) {
            this.f22057a = R.drawable.entrega_com_icon_dropoff_deliver_green;
        } else {
            this.f22057a = R.drawable.entrega_com_icon_pickup;
        }
        this.f22058b = new InfoWindowViewBuildConfig.Builder().setCategory(1).build();
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, this.f22057a)).draggable(false).anchor(0.5f, 0.5f).zIndex(11));
        }
    }

    public void show(LatLng latLng, LatLng latLng2) {
        if (latLng2 == null) {
            show(latLng);
        } else if (latLng != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(latLng);
            arrayList.add(latLng2);
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, this.f22057a)).draggable(false).anchor(0.5f, 0.5f).zIndex(11), arrayList);
        }
    }

    public void showWithInfoWindow(LatLng latLng, LatLng latLng2, String str, OnInfoWindowClickListener onInfoWindowClickListener) {
        show(latLng, latLng2);
        InfoWindowViewBuildConfig infoWindowViewBuildConfig = this.f22058b;
        if (infoWindowViewBuildConfig != null) {
            infoWindowViewBuildConfig.setTitle(str);
        }
        updateInfoWindow(this.f22058b, onInfoWindowClickListener);
    }
}
