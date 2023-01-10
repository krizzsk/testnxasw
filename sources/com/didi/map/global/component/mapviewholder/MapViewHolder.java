package com.didi.map.global.component.mapviewholder;

import android.content.Context;
import android.os.Build;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.MapOption;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.myLocation.IMyLocationCompContract;
import com.didi.map.global.component.myLocation.MyLocationCompParam;
import com.didi.map.global.component.myLocation.MyLocationComponent;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapViewHolder {

    /* renamed from: c */
    private static final String f28237c = "MapViewHolder";

    /* renamed from: a */
    int f28238a;

    /* renamed from: b */
    int f28239b;

    /* renamed from: d */
    private MapView f28240d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f28241e;

    /* renamed from: f */
    private Context f28242f;

    /* renamed from: g */
    private IMyLocationCompContract f28243g;

    /* renamed from: h */
    private MyLocationCompParam f28244h;

    public MapViewHolder(Context context) {
        this.f28242f = context;
        m22153a(context, (MapOption) null);
    }

    public MapViewHolder(Context context, int i, int i2) {
        this.f28242f = context;
        this.f28238a = i;
        this.f28239b = i2;
        m22153a(context, (MapOption) null);
    }

    /* renamed from: a */
    private void m22153a(Context context, MapOption mapOption) {
        this.f28240d = DDMapInit.getInstance().getMapView(context, mapOption);
        getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                Map unused = MapViewHolder.this.f28241e = map;
                MapViewHolder.this.m22154a(map);
                MapViewHolder.this.m22152a();
                SystemUtils.log(3, MapViewHolder.f28237c, "onMapReady: init location component...", (Throwable) null, "com.didi.map.global.component.mapviewholder.MapViewHolder$1", 62);
            }
        });
    }

    public MapViewHolder(Context context, MapOption mapOption) {
        this.f28242f = context;
        m22153a(context, mapOption);
    }

    public void getMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.getMapAsync(onMapReadyCallBack);
            SystemUtils.log(3, f28237c, "getMapAsync: ready callback...", (Throwable) null, "com.didi.map.global.component.mapviewholder.MapViewHolder", 81);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22152a() {
        m22158b();
        this.f28243g = new MyLocationComponent();
        MyLocationCompParam build = new MyLocationCompParam.Builder(80).arrowIcon(this.f28238a).positionIcon(this.f28239b).build();
        this.f28244h = build;
        this.f28243g.setConfigParam(build);
        this.f28243g.create(this.f28242f, this.f28241e);
    }

    /* renamed from: b */
    private void m22158b() {
        IMyLocationCompContract iMyLocationCompContract = this.f28243g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.destroy();
            this.f28243g = null;
        }
    }

    public MapView getMapView() {
        return this.f28240d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22154a(Map map) {
        if (map != null && this.f28240d != null) {
            boolean z = false;
            map.setIndoorEnabled(false);
            map.setTrafficEnabled(false);
            map.getUiSettings().setScaleViewEnabled(false);
            map.getUiSettings().setZoomControlsEnabled(false);
            map.getUiSettings().setCompassEnabled(false);
            map.getUiSettings().setTiltEnabled(false);
            map.getUiSettings().setRotateGesturesEnabled(false);
            ApolloParamsGoogleMapStyle instance = ApolloParamsGoogleMapStyle.getInstance();
            DLog.m10773d(f28237c, "initMap() ApolloStyleParams:" + instance, new Object[0]);
            if (instance != null && instance.buildingEnable) {
                z = true;
            }
            map.setBuildingsEnabled(z);
            m22155a(map, instance);
            this.f28240d.addErrorHintView(this.f28242f.getResources().getString(R.string.GRider_backup_Please_understand_cgii));
        }
    }

    /* renamed from: a */
    private void m22155a(Map map, ApolloParamsGoogleMapStyle apolloParamsGoogleMapStyle) {
        if (map != null && apolloParamsGoogleMapStyle != null) {
            try {
                String str = apolloParamsGoogleMapStyle.styleJson;
                if (this.f28240d == null || this.f28240d.getContext() == null || Build.VERSION.SDK_INT < 23) {
                    if (!map.setMapStyle(str)) {
                        DLog.m10773d(f28237c, "3, Style parsing failed.," + hashCode(), new Object[0]);
                    }
                    DLog.m10773d(f28237c, "setMapStyle end," + hashCode(), new Object[0]);
                }
                this.f28240d.getContext().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler(str, map) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ Map f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final boolean queueIdle() {
                        return MapViewHolder.this.m22157a(this.f$1, this.f$2);
                    }
                });
                DLog.m10773d(f28237c, "setMapStyle end," + hashCode(), new Object[0]);
            } catch (Exception e) {
                DLog.m10773d(f28237c, "Can't find style. Error:" + e.toString(), new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m22157a(String str, Map map) {
        if (TextUtils.isEmpty(str)) {
            if (!map.setMapStyle((int) R.raw.map_style)) {
                DLog.m10773d(f28237c, "1, Style parsing failed.," + hashCode(), new Object[0]);
            }
        } else if (!map.setMapStyle(str)) {
            DLog.m10773d(f28237c, "2, Style parsing failed.," + hashCode(), new Object[0]);
        }
        return false;
    }

    public void onResume() {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStart() {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onStop() {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        m22158b();
        MapView mapView = this.f28240d;
        if (mapView != null) {
            if (!(mapView.getMap() == null || this.f28240d.getMap().getUiSettings() == null)) {
                this.f28240d.getMap().getUiSettings().clear();
            }
            this.f28240d.onDestroy();
            this.f28240d = null;
        }
    }

    public void onLowMemory() {
        MapView mapView = this.f28240d;
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    public List<IMapElement> getMyLocationMarkers() {
        IMyLocationCompContract iMyLocationCompContract = this.f28243g;
        if (iMyLocationCompContract != null) {
            return iMyLocationCompContract.getMyLocationMarkers();
        }
        return null;
    }

    public void setLocationVisible(boolean z) {
        IMyLocationCompContract iMyLocationCompContract = this.f28243g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.setVisible(z);
        }
    }

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        IMyLocationCompContract iMyLocationCompContract = this.f28243g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.setNeedNlpLocation(nLPRegisterParam);
        }
    }
}
