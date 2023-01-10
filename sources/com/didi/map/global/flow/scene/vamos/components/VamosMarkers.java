package com.didi.map.global.flow.scene.vamos.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.vamos.model.VamosMarkerModel;
import java.util.ArrayList;
import java.util.List;

public class VamosMarkers {

    /* renamed from: a */
    private Marker f29575a;

    /* renamed from: b */
    private Marker f29576b;

    /* renamed from: c */
    private Marker f29577c;

    /* renamed from: d */
    private Marker f29578d;

    /* renamed from: e */
    private Marker f29579e;

    /* renamed from: f */
    private Map f29580f;

    /* renamed from: g */
    private Context f29581g;

    public VamosMarkers(Map map) {
        if (map != null) {
            this.f29580f = map;
            this.f29581g = map.getContext();
        }
    }

    public void updateAllMarkers(VamosMarkerModel vamosMarkerModel) {
        if (vamosMarkerModel != null) {
            if (!(vamosMarkerModel.mPaxStartPosition == null || vamosMarkerModel.mPaxStartMarkerBitmap == null)) {
                addOrUpdatePaxStartMarker(vamosMarkerModel.mPaxStartPosition, vamosMarkerModel.mPaxStartMarkerBitmap);
            }
            if (!(vamosMarkerModel.mDriverStartPosition == null || vamosMarkerModel.mDriverStartMarkerBitmap == null)) {
                addOrUpdateDriverStartMarker(vamosMarkerModel.mDriverStartPosition, vamosMarkerModel.mDriverStartMarkerBitmap);
            }
            if (!(vamosMarkerModel.mDriverEndPosition == null || vamosMarkerModel.mDriverEndMarkerBitmap == null)) {
                addOrUpdateDriverEndMarker(vamosMarkerModel.mDriverEndPosition, vamosMarkerModel.mDriverEndMarkerBitmap);
            }
            if (vamosMarkerModel.mPaxEndPosition != null && vamosMarkerModel.mPaxEndMarkerBitmap != null) {
                addOrUpdatePaxEndMarker(vamosMarkerModel.mPaxEndPosition, vamosMarkerModel.mPaxEndMarkerBitmap);
            }
        }
    }

    public void addOrUpdatePaxStartMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f29575a;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(133);
            Map map = this.f29580f;
            if (map != null) {
                this.f29575a = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f29575a.setIcon(this.f29581g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdatePaxStartMarkerBubble(View view) {
        Marker marker;
        Map map;
        if (view != null && (marker = this.f29575a) != null && (map = this.f29580f) != null) {
            InfoWindow buildInfoWindow = marker.buildInfoWindow(map, map.getContext().getApplicationContext());
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                DLog.m10773d("VamosMarkers", "Pax start bubble", new Object[0]);
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(133);
            }
        }
    }

    public void addOrUpdatePaxEndMarkerBubble(View view) {
        Marker marker;
        Map map;
        if (view != null && (marker = this.f29576b) != null && (map = this.f29580f) != null) {
            InfoWindow buildInfoWindow = marker.buildInfoWindow(map, map.getContext().getApplicationContext());
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                DLog.m10773d("VamosMarkers", "Pax end bubble", new Object[0]);
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(132);
            }
        }
    }

    public void addOrUpdatePaxEndMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f29576b;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(132);
            Map map = this.f29580f;
            if (map != null) {
                this.f29576b = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f29576b.setIcon(this.f29581g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdateDriverStartMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f29577c;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(131);
            Map map = this.f29580f;
            if (map != null) {
                this.f29577c = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f29577c.setIcon(this.f29581g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdateDriverEndMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f29578d;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(130);
            Map map = this.f29580f;
            if (map != null) {
                this.f29578d = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f29578d.setIcon(this.f29581g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public List<IMapElement> getAllMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f29575a;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.f29576b;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        Marker marker3 = this.f29577c;
        if (marker3 != null) {
            arrayList.add(marker3);
        }
        Marker marker4 = this.f29578d;
        if (marker4 != null) {
            arrayList.add(marker4);
        }
        Marker marker5 = this.f29579e;
        if (marker5 != null) {
            arrayList.add(marker5);
        }
        return arrayList;
    }

    public void removeAllMarkers() {
        Map map = this.f29580f;
        if (map != null) {
            Marker marker = this.f29575a;
            if (marker != null) {
                map.remove(marker);
                this.f29575a = null;
            }
            Marker marker2 = this.f29576b;
            if (marker2 != null) {
                this.f29580f.remove(marker2);
                this.f29576b = null;
            }
            Marker marker3 = this.f29577c;
            if (marker3 != null) {
                this.f29580f.remove(marker3);
                this.f29577c = null;
            }
            Marker marker4 = this.f29578d;
            if (marker4 != null) {
                this.f29580f.remove(marker4);
                this.f29578d = null;
            }
            Marker marker5 = this.f29579e;
            if (marker5 != null) {
                this.f29580f.remove(marker5);
                this.f29579e = null;
            }
        }
    }
}
