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

public class ReceiverMarker extends AbsMarker {
    public static final String TAG_RECEIVER_ADDRESS_MARKER = "tag_receiver_address_marker";

    /* renamed from: a */
    private int f22055a;

    /* renamed from: b */
    private InfoWindowViewBuildConfig f22056b;

    public String getTag() {
        return TAG_RECEIVER_ADDRESS_MARKER;
    }

    public ReceiverMarker(Context context, IMapView iMapView, int i) {
        super(context, iMapView);
        m18288a(i);
    }

    /* renamed from: a */
    private void m18288a(int i) {
        if (i == 1) {
            this.f22055a = R.drawable.entrega_com_icon_dropoff_deliver_orange;
        } else {
            this.f22055a = R.drawable.entrega_com_icon_dropoff;
        }
        this.f22056b = new InfoWindowViewBuildConfig.Builder().setCategory(2).build();
    }

    public void show(LatLng latLng) {
        if (latLng != null) {
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, this.f22055a)).draggable(false).anchor(0.5f, 0.5f).zIndex(12));
        }
    }

    public void show(LatLng latLng, LatLng latLng2) {
        if (latLng2 == null) {
            show(latLng);
        } else if (latLng != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(latLng);
            arrayList.add(latLng2);
            draw((MarkerOptions) new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(this.mContext, this.f22055a)).draggable(false).anchor(0.5f, 0.5f).zIndex(11), arrayList);
        }
    }

    public void showWithInfoWindow(LatLng latLng, String str, OnInfoWindowClickListener onInfoWindowClickListener) {
        show(latLng);
        InfoWindowViewBuildConfig infoWindowViewBuildConfig = this.f22056b;
        if (infoWindowViewBuildConfig != null) {
            infoWindowViewBuildConfig.setTitle(str);
        }
        updateInfoWindow(this.f22056b, onInfoWindowClickListener);
    }
}
