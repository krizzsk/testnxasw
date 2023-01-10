package com.didi.map.global.component.mapviewholder;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.MapOption;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;

public class DDMapInit {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapView f28236a;

    private DDMapInit() {
    }

    public static DDMapInit getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final DDMapInit INSTANCE = new DDMapInit();

        private Holder() {
        }
    }

    public void preInitMap(final Context context) {
        final MapVendor mapVendor = C10321util.getMapVendor(context);
        if (mapVendor == MapVendor.GOOGLE) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                public void run() {
                    if (DDMapInit.this.f28236a == null) {
                        MapView unused = DDMapInit.this.f28236a = new MapView(context);
                        DDMapInit.this.f28236a.init(mapVendor);
                        DDMapInit.this.f28236a.onCreate((Bundle) null);
                    }
                }
            });
        }
    }

    public MapView getMapView(Context context, MapOption mapOption) {
        MapView mapView;
        MapView mapView2 = this.f28236a;
        if (mapView2 == null || mapView2.getParent() != null) {
            if (mapOption != null) {
                mapView = new MapView(context, mapOption);
            } else {
                mapView = new MapView(context);
            }
            mapView.init(C10321util.getMapVendor(context));
            mapView.onCreate((Bundle) null);
            return mapView;
        }
        MapView mapView3 = this.f28236a;
        this.f28236a = null;
        return mapView3;
    }
}
