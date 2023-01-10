package com.didi.sdk.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.delegate.MapViewHolder;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.map.global.flow.MapFlowView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.log.Logger;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class MapFragment extends Fragment implements MapFlowView.OnMapReadyCallBack {

    /* renamed from: b */
    private static final String f39523b = "mapview";

    /* renamed from: a */
    private MapFlowView f39524a;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        long currentTimeMillis = System.currentTimeMillis();
        Logger.easylog(f39523b, "inflate mapview");
        IToggle toggle = Apollo.getToggle("global_passenger_map_init_rollback");
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("initmode", 0)).intValue() != 1 || (iCollector != null && !iCollector.isHMSupportPreInitMap())) {
            view = layoutInflater.inflate(R.layout.v_map, viewGroup);
        } else if (MapViewHolder.getInstance().getMapView() != null) {
            SystemUtils.log(3, "MapFragment", "use preinit mapview", (Throwable) null, "com.didi.sdk.map.MapFragment", 52);
            view = MapViewHolder.getInstance().getMapView();
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
                    SystemUtils.log(3, "MapFragment", "remove from parent", (Throwable) null, "com.didi.sdk.map.MapFragment", 60);
                    ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                }
                viewGroup.addView(view);
            }
        } else {
            SystemUtils.log(3, "MapFragment", "inflate mapview", (Throwable) null, "com.didi.sdk.map.MapFragment", 66);
            view = layoutInflater.inflate(R.layout.v_map, viewGroup);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Logger.easylog(f39523b, "onCreateView: inflate mapview : " + currentTimeMillis2);
        this.f39524a = (MapFlowView) view.findViewById(R.id.map);
        m29745a();
        return view;
    }

    public void startInitMap() {
        MapFlowView mapFlowView = this.f39524a;
        if (!(mapFlowView == null || mapFlowView.getMapView() == null)) {
            this.f39524a.getMapAsync(this);
        }
        if (this.f39524a != null) {
            MapViewHolder.getInstance().setMapView((View) null);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onCreate(bundle);
        }
    }

    public void onDestroy() {
        Logger.easylog(f39523b, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onDestroy();
        }
        MapViewHolder.getInstance().setMapView((View) null);
        super.onDestroy();
    }

    public void onPause() {
        Logger.easylog(f39523b, "onPause");
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        Logger.easylog(f39523b, "onResume");
        super.onResume();
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onResume();
        }
    }

    public void onStart() {
        Logger.easylog(f39523b, "onStart");
        super.onStart();
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onStart();
        }
    }

    public void onStop() {
        Logger.easylog(f39523b, "onStop");
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onStop();
        }
        super.onStop();
    }

    public boolean isReadyMap() {
        MapFlowView mapFlowView = this.f39524a;
        return mapFlowView != null && mapFlowView.isMapReady();
    }

    public MapFlowView getmMapFlowView() {
        return this.f39524a;
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.f39524a != null) {
            SystemUtils.log(3, f39523b, "Map onLowMemory", (Throwable) null, "com.didi.sdk.map.MapFragment", 167);
            this.f39524a.onLowMemory();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MapFlowView mapFlowView = this.f39524a;
        if (mapFlowView != null) {
            mapFlowView.onSaveInstanceState(bundle);
        }
    }

    /* renamed from: a */
    private void m29745a() {
        HashMap hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("source", 3);
        OmegaSDKAdapter.trackEvent("google_map_usage", (Map<String, Object>) hashMap);
    }

    public void onMapReady() {
        if (getActivity() != null && (getActivity() instanceof BaseMainActivity)) {
            ((BaseMainActivity) getActivity()).mapCallBack();
        }
    }
}
