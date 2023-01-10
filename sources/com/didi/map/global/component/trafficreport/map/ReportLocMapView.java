package com.didi.map.global.component.trafficreport.map;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.map.global.component.mapviewholder.MapViewHolder;

public class ReportLocMapView {

    /* renamed from: e */
    private static ReportLocMapView f28557e;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapViewHolder f28558a;

    /* renamed from: b */
    private Context f28559b;

    /* renamed from: c */
    private ViewGroup f28560c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f28561d = true;

    public static ReportLocMapView getInstance(Context context) {
        synchronized (ReportLocMapView.class) {
            if (f28557e == null) {
                f28557e = new ReportLocMapView(context.getApplicationContext());
            }
        }
        return f28557e;
    }

    private ReportLocMapView(Context context) {
        this.f28559b = context;
        MapViewHolder mapViewHolder = new MapViewHolder(context);
        this.f28558a = mapViewHolder;
        mapViewHolder.getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                if (ReportLocMapView.this.f28558a != null) {
                    ReportLocMapView.this.f28558a.setLocationVisible(ReportLocMapView.this.f28561d);
                }
            }
        });
    }

    public MapView getMapView() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder == null) {
            return null;
        }
        return mapViewHolder.getMapView();
    }

    public void setNeedLocation(boolean z) {
        this.f28561d = z;
    }

    public void onAdd(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != this.f28560c && (mapViewHolder = this.f28558a) != null && mapViewHolder.getMapView() != null && viewGroup != null) {
            onRemove(this.f28560c);
            viewGroup.addView(this.f28558a.getMapView());
            this.f28560c = viewGroup;
            this.f28558a.setLocationVisible(this.f28561d);
        }
    }

    public void onRemove(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != null && (mapViewHolder = this.f28558a) != null && mapViewHolder.getMapView() != null && viewGroup == this.f28560c) {
            viewGroup.removeView(this.f28558a.getMapView());
            this.f28560c = null;
        }
    }

    public void onStart() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder != null) {
            mapViewHolder.onStart();
        }
    }

    public void onResume() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder != null) {
            mapViewHolder.onResume();
            this.f28558a.setLocationVisible(this.f28561d);
        }
    }

    public void onPause() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder != null) {
            mapViewHolder.onPause();
            this.f28558a.setLocationVisible(false);
        }
    }

    public void onStop() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder != null) {
            mapViewHolder.onStop();
        }
    }

    public void onDestroy() {
        onRemove(this.f28560c);
        m22292a();
    }

    /* renamed from: a */
    private void m22292a() {
        MapViewHolder mapViewHolder = this.f28558a;
        if (mapViewHolder != null) {
            mapViewHolder.onDestroy();
            this.f28558a = null;
        }
        f28557e = null;
    }
}
