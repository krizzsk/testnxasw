package com.didi.map.global.flow;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnMapLoadedCallback;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.NetUtils;
import com.didi.hawaii.p120ar.utils.MapVenderUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.MapFlowView;
import com.didi.map.global.flow.presenter.IMapFlowPresenter;
import com.didi.map.global.flow.presenter.MapFlowPresenter;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.model.omega.AppFluentOmega;
import java.util.HashMap;

public class MapFlowView extends RelativeLayout implements IMapFlowView {

    /* renamed from: a */
    private static final String f28781a = "BaseMapFlowView";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f28782h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static boolean f28783i;

    /* renamed from: b */
    private MapFlowPresenter f28784b;

    /* renamed from: c */
    private MapViewHolder f28785c;

    /* renamed from: d */
    private boolean f28786d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f28787e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f28788f;

    /* renamed from: g */
    private Handler f28789g;

    /* renamed from: j */
    private final Runnable f28790j;

    /* renamed from: k */
    private OnMapLoadedCallback f28791k;

    public interface OnMapReadyCallBack {
        void onMapReady();
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public MapFlowView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public MapFlowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28786d = false;
        this.f28789g = new Handler(Looper.getMainLooper());
        this.f28790j = new Runnable() {
            public void run() {
                DLog.m10773d(MapFlowView.f28781a, "MapLoad Failed", new Object[0]);
                boolean unused = MapFlowView.f28783i = true;
                MapFlowOmegaUtil.trackMapLoadFailed(MapFlowView.this.f28787e != null ? MapFlowView.this.f28787e.getMapVendor().toString() : null);
            }
        };
        this.f28791k = new OnMapLoadedCallback() {
            public void onMapLoaded() {
                DLog.m10773d(MapFlowView.f28781a, "MapLoad Success", new Object[0]);
                AppFluentOmega.getInstance().stopCalculateTime(MapFlowView.this.f28788f, MapFlowView.this.f28787e, 2, (HashMap<String, Object>) null);
                MapFlowView.this.m22395a();
                boolean unused = MapFlowView.f28782h = true;
            }
        };
        this.f28788f = context;
        m22399b();
    }

    public IMapFlowPresenter getPresenter() {
        return this.f28784b;
    }

    public MapView getMapView() {
        MapViewHolder mapViewHolder = this.f28785c;
        if (mapViewHolder != null && mapViewHolder.getMapView() != null) {
            return this.f28785c.getMapView();
        }
        MapFlowOmegaUtil.onMapViewIsNull(isMapReady());
        return null;
    }

    public void getMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        DLog.m10773d("MapFlowView", "getMapAsync", new Object[0]);
        if (!this.f28786d) {
            MapViewHolder mapViewHolder = this.f28785c;
            if (mapViewHolder != null) {
                mapViewHolder.getMapAsync(m22394a(onMapReadyCallBack));
            }
        } else if (onMapReadyCallBack != null) {
            onMapReadyCallBack.onMapReady();
        }
    }

    public boolean isMapReady() {
        return this.f28786d;
    }

    public void onCreate(Bundle bundle) {
        NetUtils.init(getContext());
    }

    public void onStart() {
        this.f28785c.onStart();
        MapFlowApolloUtils.updateMapLoadMonitorParam(MapVenderUtil.getCurrentMapType(this.f28788f));
        if (!f28782h && !f28783i && MapFlowApolloUtils.enableMapLoadMonitor) {
            m22395a();
            if (this.f28789g != null) {
                DLog.m10773d(f28781a, "MapLoad Countdown", new Object[0]);
                this.f28789g.postDelayed(this.f28790j, (long) MapFlowApolloUtils.mapLoadTimeoutMillis);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22395a() {
        if (this.f28789g != null) {
            DLog.m10773d(f28781a, "MapLoad Countdown Cancel", new Object[0]);
            this.f28789g.removeCallbacks(this.f28790j);
        }
    }

    public void onResume() {
        this.f28785c.onResume();
        this.f28784b.onResume();
    }

    public void onPause() {
        this.f28785c.onPause();
        this.f28784b.onPause();
    }

    public void onStop() {
        this.f28785c.onStop();
        m22395a();
    }

    public void onDestroy() {
        DLog.m10773d(f28781a, "Map destroy", new Object[0]);
        this.f28786d = false;
        this.f28784b.onDestroy();
        this.f28785c.onDestroy();
        Map map = this.f28787e;
        if (map != null) {
            map.removeOnMapLoadedCallback(this.f28791k);
        }
        AppFluentOmega.getInstance().removeOmega(2);
        m22395a();
        this.f28789g = null;
    }

    public void onLowMemory() {
        MapViewHolder mapViewHolder = this.f28785c;
        if (mapViewHolder != null) {
            mapViewHolder.onLowMemory();
        }
    }

    /* renamed from: b */
    private void m22399b() {
        MapViewHolder mapViewHolder = new MapViewHolder(getContext());
        this.f28785c = mapViewHolder;
        addView(mapViewHolder.getMapView(), -1, -1);
        this.f28784b = new MapFlowPresenter(this.f28785c);
        AppFluentOmega.getInstance().removeOmega(2);
        DLog.m10773d(f28781a, "initMap", new Object[0]);
    }

    /* renamed from: a */
    private com.didi.common.map.OnMapReadyCallBack m22394a(OnMapReadyCallBack onMapReadyCallBack) {
        return new com.didi.common.map.OnMapReadyCallBack(onMapReadyCallBack) {
            public final /* synthetic */ MapFlowView.OnMapReadyCallBack f$1;

            {
                this.f$1 = r2;
            }

            public final void onMapReady(Map map) {
                MapFlowView.this.m22396a(this.f$1, map);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22396a(OnMapReadyCallBack onMapReadyCallBack, Map map) {
        this.f28786d = true;
        this.f28787e = map;
        DLog.m10773d(f28781a, "onMapReady , map.getMapStatus() = " + map.getMapStatus(), new Object[0]);
        if (onMapReadyCallBack != null) {
            onMapReadyCallBack.onMapReady();
        }
        Map map2 = this.f28787e;
        if (map2 != null) {
            map2.addOnMapLoadedCallback(this.f28791k);
        }
    }

    public void setGoogleLogoVisible(int i) {
        Map map = this.f28787e;
        if (map != null && map.getUiSettings() != null) {
            this.f28787e.getUiSettings().setLogoVisibility(i);
        }
    }
}
