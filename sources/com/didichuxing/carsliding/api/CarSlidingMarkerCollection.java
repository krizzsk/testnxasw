package com.didichuxing.carsliding.api;

import com.didi.common.map.Map;
import com.didi.common.map.model.Marker;
import java.util.ArrayList;
import java.util.List;

public class CarSlidingMarkerCollection {

    /* renamed from: a */
    private static List<Marker> f48904a = new ArrayList();

    /* renamed from: b */
    private static List<CarSlidingRender> f48905b = new ArrayList();

    public static void onSceneOut() {
    }

    public static void registerMarker(Marker marker) {
        if (marker != null && !f48904a.contains(marker)) {
            f48904a.add(marker);
        }
    }

    public static void unRegisterMarkers() {
        for (Marker next : f48904a) {
            if (next != null) {
                next.setVisible(false);
            }
        }
        f48904a.clear();
    }

    public static void unRegisterMarkersWithRemove(Map map) {
        for (Marker next : f48904a) {
            if (next != null) {
                next.setVisible(false);
                if (map != null) {
                    map.remove(next);
                }
            }
        }
        f48904a.clear();
    }

    public static void onSceneIn(Map map) {
        unRegisterMarkersWithRemove(map);
        cleanRenders();
    }

    public static void recordRenders(CarSlidingRender carSlidingRender) {
        if (carSlidingRender != null && !f48905b.contains(carSlidingRender)) {
            f48905b.add(carSlidingRender);
        }
    }

    public static void cleanRenders() {
        for (CarSlidingRender next : f48905b) {
            if (next != null) {
                next.destroy();
            }
        }
        f48905b.clear();
    }
}
