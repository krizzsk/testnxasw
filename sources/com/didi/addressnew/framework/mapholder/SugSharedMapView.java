package com.didi.addressnew.framework.mapholder;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class SugSharedMapView {

    /* renamed from: f */
    private static SugSharedMapView f9227f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapViewHolder f9228a;

    /* renamed from: b */
    private Context f9229b;

    /* renamed from: c */
    private ViewGroup f9230c;

    /* renamed from: d */
    private HighEndMobile f9231d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f9232e = true;

    public static SugSharedMapView getInstance(Context context) {
        synchronized (SugSharedMapView.class) {
            if (f9227f == null) {
                f9227f = new SugSharedMapView(context.getApplicationContext());
            }
        }
        return f9227f;
    }

    private SugSharedMapView(Context context) {
        this.f9229b = context;
        MapViewHolder mapViewHolder = new MapViewHolder(context);
        this.f9228a = mapViewHolder;
        mapViewHolder.getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                if (SugSharedMapView.this.f9228a != null) {
                    SugSharedMapView.this.f9228a.setLocationVisible(SugSharedMapView.this.f9232e);
                }
            }
        });
        this.f9231d = new HighEndMobile();
    }

    public List<IMapElement> getMyLocationMarkers() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            return mapViewHolder.getMyLocationMarkers();
        }
        return null;
    }

    public MapView getMapView() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder == null) {
            return null;
        }
        return mapViewHolder.getMapView();
    }

    public void setNeedLocation(boolean z) {
        this.f9232e = z;
    }

    public void onAdd(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != this.f9230c && (mapViewHolder = this.f9228a) != null && mapViewHolder.getMapView() != null && viewGroup != null) {
            onRemove(this.f9230c);
            viewGroup.addView(this.f9228a.getMapView());
            this.f9230c = viewGroup;
            this.f9228a.setLocationVisible(this.f9232e);
            SystemUtils.log(3, "LocXXX", "onAdd: ", (Throwable) null, "com.didi.addressnew.framework.mapholder.SugSharedMapView", 81);
        }
    }

    public void onRemove(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != null && (mapViewHolder = this.f9228a) != null && mapViewHolder.getMapView() != null && viewGroup == this.f9230c) {
            viewGroup.removeView(this.f9228a.getMapView());
            this.f9230c = null;
        }
    }

    public void onStart() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            mapViewHolder.onStart();
        }
    }

    public void onResume() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            mapViewHolder.onResume();
            this.f9228a.setLocationVisible(this.f9232e);
        }
    }

    public void onPause() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            mapViewHolder.onPause();
            this.f9228a.setLocationVisible(false);
        }
    }

    public void onStop() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            mapViewHolder.onStop();
        }
    }

    public void onDestroy() {
        onRemove(this.f9230c);
        m8021a();
    }

    /* renamed from: a */
    private void m8021a() {
        if (!this.f9231d.isHighEndMobile(this.f9229b)) {
            MapViewHolder mapViewHolder = this.f9228a;
            if (mapViewHolder != null) {
                mapViewHolder.onDestroy();
                this.f9228a = null;
            }
            this.f9231d = null;
            f9227f = null;
        }
    }

    public void onLowMemory() {
        MapViewHolder mapViewHolder = this.f9228a;
        if (mapViewHolder != null) {
            mapViewHolder.onLowMemory();
        }
    }
}
