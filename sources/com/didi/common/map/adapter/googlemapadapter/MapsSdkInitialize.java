package com.didi.common.map.adapter.googlemapadapter;

import android.content.Context;
import com.didi.common.map.IMapsSdkInitializeDelegate;
import com.didi.common.map.MapsSdkInitialize;
import com.didi.common.map.listener.OnMapsSdkInitializedCallback;
import com.didi.common.map.util.DLog;
import com.google.android.gms.maps.MapsInitializer;

public class MapsSdkInitialize implements IMapsSdkInitializeDelegate {

    /* renamed from: a */
    private static volatile MapsSdkInitialize f12604a;

    public static MapsSdkInitialize getInstance() {
        if (f12604a == null) {
            synchronized (MapsSdkInitialize.class) {
                if (f12604a == null) {
                    f12604a = new MapsSdkInitialize();
                }
            }
        }
        return f12604a;
    }

    public int initialize(Context context, MapsSdkInitialize.Renderer renderer, final OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        if (context == null) {
            DLog.m10773d("ccc", "MapsSdkInitialize. initialize  context = null", new Object[0]);
            return -1;
        }
        MapsInitializer.Renderer renderer2 = MapsInitializer.Renderer.LEGACY;
        if (renderer == MapsSdkInitialize.Renderer.LATEST) {
            renderer2 = MapsInitializer.Renderer.LATEST;
        }
        try {
            return MapsInitializer.initialize(context.getApplicationContext(), renderer2, new com.google.android.gms.maps.OnMapsSdkInitializedCallback() {
                public void onMapsSdkInitialized(MapsInitializer.Renderer renderer) {
                    if (onMapsSdkInitializedCallback != null) {
                        MapsSdkInitialize.Renderer renderer2 = MapsSdkInitialize.Renderer.LEGACY;
                        if (renderer == MapsInitializer.Renderer.LATEST) {
                            renderer2 = MapsSdkInitialize.Renderer.LATEST;
                        }
                        onMapsSdkInitializedCallback.onMapsSdkInitialized(renderer2);
                    }
                }
            });
        } catch (Exception e) {
            DLog.m10773d("MapsSdkInitialize", "google initialize failed : " + e, new Object[0]);
            e.printStackTrace();
            return -1;
        }
    }
}
