package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapOption;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.hawaii.p120ar.utils.DisplayUtils;
import com.didi.hawaii.p120ar.utils.LocationUtil;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalMapManager */
public class ZGGlobalMapManager {
    public static final int DEFAULT_MAP_PADDING_DP = 20;

    /* renamed from: a */
    MapView f25400a;

    /* renamed from: b */
    private Context f25401b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f25402c = null;

    /* renamed from: d */
    private LatLng f25403d = null;

    /* renamed from: e */
    private LatLng f25404e = null;

    /* renamed from: f */
    private Marker f25405f = null;

    /* renamed from: g */
    private boolean f25406g = false;

    /* renamed from: h */
    private float f25407h = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MapViewHolder f25408i;

    /* renamed from: j */
    private String f25409j = "ZGGlobalMapManager";

    /* renamed from: k */
    private float f25410k = 5.0f;

    /* renamed from: l */
    private GuideLine f25411l;

    /* renamed from: m */
    private Marker f25412m;

    public void onRestart() {
    }

    public void setDestLocation(LatLng latLng) {
        this.f25404e = latLng;
        m20286b();
        m20290d();
    }

    public ZGGlobalMapManager(Context context, ViewGroup viewGroup, boolean z) {
        DLog.m10773d("ZGGlobalMapManager", " map ZGGlobalMapManager", new Object[0]);
        this.f25401b = context;
        m20285a(viewGroup, z);
    }

    /* renamed from: a */
    private void m20285a(ViewGroup viewGroup, boolean z) {
        MapOption mapOption = new MapOption();
        mapOption.setUseTextureMap(z);
        MapViewHolder mapViewHolder = new MapViewHolder(this.f25401b, mapOption);
        this.f25408i = mapViewHolder;
        mapViewHolder.getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                ZGGlobalMapManager.this.f25408i.setLocationVisible(true);
                Map unused = ZGGlobalMapManager.this.f25402c = map;
                ZGGlobalMapManager.this.m20283a();
            }
        });
        MapView mapView = this.f25408i.getMapView();
        if (mapView != null) {
            viewGroup.addView(mapView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20283a() {
        Map map = this.f25402c;
        if (map != null && !this.f25406g) {
            if (map.getUiSettings() != null) {
                this.f25402c.getUiSettings().setAllGesturesEnabled(false);
            }
            m20286b();
            m20289c();
            m20290d();
            this.f25406g = true;
        }
    }

    /* renamed from: b */
    private void m20286b() {
        if (this.f25401b != null && this.f25402c != null && LatLngUtils.locateCorrect(this.f25404e) && this.f25405f == null) {
            DLog.m10773d("AR-ZG", "addDestMarker:" + this.f25404e.longitude + "," + this.f25404e.latitude, new Object[0]);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.position(this.f25404e);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(this.f25401b, ZGThemeManager.getInstance().fromResource(R.drawable.direction_start_global)));
            this.f25405f = this.f25402c.addMarker(markerOptions);
        }
    }

    /* renamed from: c */
    private void m20289c() {
        if (this.f25401b != null && this.f25402c != null && LatLngUtils.locateCorrect(this.f25403d) && LatLngUtils.locateCorrect(this.f25404e)) {
            GuideLine guideLine = this.f25411l;
            if (guideLine != null) {
                guideLine.destroy();
                this.f25411l = null;
            }
            this.f25411l = new GuideLine();
            this.f25411l.setConfigParam(new GuideLineParam(Color.parseColor("#5DBAF9"), this.f25403d, this.f25404e));
            this.f25411l.create(this.f25401b, this.f25402c);
            this.f25411l.setVisible(true);
        }
    }

    /* renamed from: d */
    private void m20290d() {
        if (this.f25402c != null && this.f25401b != null) {
            ArrayList arrayList = new ArrayList();
            LatLng latLng = this.f25404e;
            if (latLng != null) {
                arrayList.add(latLng);
            }
            LatLng latLng2 = this.f25403d;
            if (latLng2 != null) {
                arrayList.add(latLng2);
            }
            Marker marker = this.f25412m;
            if (marker != null) {
                arrayList.add(marker.getPosition());
            }
            BestViewer.doBestView(this.f25402c, false, this.f25403d, (List<LatLng>) arrayList, (Padding) null, m20291e());
        }
    }

    /* renamed from: a */
    private void m20284a(float f) {
        float f2 = this.f25407h;
        if (f2 == 0.0f || Math.abs(f - f2) >= this.f25410k) {
            this.f25407h = f;
            Map map = this.f25402c;
            if (map != null) {
                if (map.getMapVendor() == MapVendor.GOOGLE) {
                    this.f25402c.setRotateAngle(f);
                } else {
                    this.f25402c.setRotateAngle(-f);
                }
            }
            m20287b(f);
            m20290d();
        }
    }

    /* renamed from: e */
    private Padding m20291e() {
        int i;
        int dip2px = DisplayUtils.dip2px(this.f25401b, 20.0f);
        if (this.f25402c.getMapVendor() == MapVendor.DIDI || this.f25402c.getMapVendor() == MapVendor.G_DIDI) {
            i = DisplayUtils.dip2px(this.f25401b, 20.0f);
        } else {
            i = (this.f25401b.getResources().getDisplayMetrics().heightPixels / 3) * 2;
        }
        return new Padding(dip2px, i, dip2px, DisplayUtils.dip2px(this.f25401b, 20.0f));
    }

    public void onStart() {
        MapViewHolder mapViewHolder = this.f25408i;
        if (mapViewHolder != null) {
            mapViewHolder.onStart();
        }
        MapView mapView = this.f25400a;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() {
        MapViewHolder mapViewHolder = this.f25408i;
        if (mapViewHolder != null) {
            mapViewHolder.onResume();
        }
        MapView mapView = this.f25400a;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        MapViewHolder mapViewHolder = this.f25408i;
        if (mapViewHolder != null) {
            mapViewHolder.onPause();
        }
        MapView mapView = this.f25400a;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() {
        MapViewHolder mapViewHolder = this.f25408i;
        if (mapViewHolder != null) {
            mapViewHolder.onStop();
        }
        MapView mapView = this.f25400a;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        MapViewHolder mapViewHolder = this.f25408i;
        if (mapViewHolder != null) {
            mapViewHolder.onDestroy();
        }
        MapView mapView = this.f25400a;
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    public void onOrientationChanged(float f) {
        if (this.f25406g) {
            float f2 = (f + 360.0f) % 360.0f;
            float f3 = this.f25407h;
            if (f3 < 0.0f || (Math.abs(f2 - f3) + 360.0f) % 360.0f >= 2.0f) {
                m20284a(f2);
            }
        }
    }

    public void onLocationChanged(LocationUtil.GpscurLocation gpscurLocation) {
        if (this.f25402c != null && gpscurLocation != null && this.f25406g && LatLngUtils.locateCorrect(this.f25404e)) {
            LatLng latLng = new LatLng(gpscurLocation.latitude, gpscurLocation.longitude);
            if (!LatLngUtils.isSameLatLng(this.f25403d, latLng)) {
                this.f25403d = latLng;
                GuideLine guideLine = this.f25411l;
                if (guideLine == null) {
                    m20289c();
                } else {
                    guideLine.updateStartPosition(latLng);
                }
                m20286b();
                m20290d();
            }
        }
    }

    /* renamed from: b */
    private void m20287b(float f) {
        if (this.f25402c != null && LatLngUtils.locateCorrect(this.f25403d) && LatLngUtils.locateCorrect(this.f25404e) && this.f25402c.getProjection() != null) {
            double radians = Math.toRadians((double) f);
            PointF screenLocation = this.f25402c.getProjection().toScreenLocation(this.f25403d);
            PointF screenLocation2 = this.f25402c.getProjection().toScreenLocation(this.f25404e);
            double d = (double) (screenLocation2.x - screenLocation.x);
            double d2 = (double) (screenLocation2.y - screenLocation.y);
            PointF pointF = new PointF();
            double d3 = -radians;
            pointF.x = (float) (((Math.cos(d3) * d) - (Math.sin(d3) * d2)) + ((double) screenLocation.x));
            pointF.y = (float) ((d * Math.sin(d3)) + (d2 * Math.cos(d3)) + ((double) screenLocation.y));
            LatLng fromScreenLocation = this.f25402c.getProjection().fromScreenLocation(pointF);
            Marker marker = this.f25412m;
            if (marker != null) {
                marker.setPosition(fromScreenLocation);
                return;
            }
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.position(fromScreenLocation);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(this.f25401b, R.drawable.direction_start));
            markerOptions.visible(false);
            this.f25412m = this.f25402c.addMarker(markerOptions);
        }
    }
}
