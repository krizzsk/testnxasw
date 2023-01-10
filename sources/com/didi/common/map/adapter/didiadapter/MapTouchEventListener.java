package com.didi.common.map.adapter.didiadapter;

import android.content.Context;
import android.os.Handler;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLoadedCallback;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MapGestureListener;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapTouchEventListener implements DidiMap.OnCameraChangeListener, DidiMap.OnMapClickListener, DidiMap.OnMapLoadedCallback, DidiMap.OnMapLongClickListener, MapGestureListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CopyOnWriteArrayList<OnMapGestureListener> f12547a;

    /* renamed from: b */
    private CopyOnWriteArrayList<OnMapLoadedCallback> f12548b;

    /* renamed from: c */
    private CopyOnWriteArrayList<OnCameraChangeListener> f12549c;

    /* renamed from: d */
    private CopyOnWriteArrayList<OnMapClickListener> f12550d;

    /* renamed from: e */
    private CopyOnWriteArrayList<OnMapLongClickListener> f12551e;

    /* renamed from: f */
    private DidiMap f12552f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f12553g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12554h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Runnable f12555i = new Runnable() {
        public void run() {
            if (MapTouchEventListener.this.f12553g != null && MapTouchEventListener.this.f12555i != null) {
                if (MapTouchEventListener.this.f12554h) {
                    MapTouchEventListener.this.f12553g.removeCallbacks(MapTouchEventListener.this.f12555i);
                    MapTouchEventListener.this.f12553g.postDelayed(MapTouchEventListener.this.f12555i, 250);
                    return;
                }
                synchronized (MapTouchEventListener.this.f12547a) {
                    if (MapTouchEventListener.this.f12547a != null) {
                        Iterator it = MapTouchEventListener.this.f12547a.iterator();
                        while (it.hasNext()) {
                            ((OnMapGestureListener) it.next()).onMapStable();
                        }
                    }
                }
            }
        }
    };

    /* renamed from: j */
    private Runnable f12556j = new Runnable() {
        public void run() {
            if (MapTouchEventListener.this.f12553g != null) {
                MapTouchEventListener.this.m10704a();
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10704a() {
        HashMap hashMap = new HashMap();
        hashMap.put("times", 1);
        hashMap.put("map_type", RpcPoiBaseInfo.MAP_TYPE_DIDI);
        OmegaSDKAdapter.trackEvent("map_global_index_map_drag", (Map<String, Object>) hashMap);
    }

    public MapTouchEventListener(DidiMap didiMap, Context context) {
        this.f12552f = didiMap;
        this.f12547a = new CopyOnWriteArrayList<>();
        this.f12548b = new CopyOnWriteArrayList<>();
        this.f12549c = new CopyOnWriteArrayList<>();
        this.f12550d = new CopyOnWriteArrayList<>();
        this.f12551e = new CopyOnWriteArrayList<>();
        this.f12552f.addMapGestureListener(this);
        this.f12552f.setOnCameraChangeListener(this);
        this.f12552f.setOnMapClickListener(this);
        this.f12552f.setOnMapLongClickListener(this);
        this.f12552f.setOnMapLoadedCallback(this);
        this.f12554h = false;
        this.f12553g = new Handler(context.getMainLooper());
    }

    public void destroy() {
        DidiMap didiMap = this.f12552f;
        if (didiMap != null) {
            didiMap.removeMapGestureListener((MapGestureListener) this);
            this.f12552f.setOnCameraChangeListener((DidiMap.OnCameraChangeListener) null);
            this.f12552f.setOnMapClickListener((DidiMap.OnMapClickListener) null);
            this.f12552f.setOnMapLongClickListener((DidiMap.OnMapLongClickListener) null);
            this.f12552f.setOnMapLoadedCallback((DidiMap.OnMapLoadedCallback) null);
            this.f12552f = null;
        }
        Handler handler = this.f12553g;
        if (handler != null) {
            handler.removeCallbacks(this.f12555i);
            this.f12553g.removeCallbacks(this.f12556j);
            this.f12553g = null;
            this.f12555i = null;
            this.f12556j = null;
        }
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                this.f12547a.clear();
                this.f12547a = null;
            }
        }
        synchronized (this.f12548b) {
            if (this.f12548b != null) {
                this.f12548b.clear();
                this.f12548b = null;
            }
        }
        synchronized (this.f12549c) {
            if (this.f12549c != null) {
                this.f12549c.clear();
                this.f12549c = null;
            }
        }
        synchronized (this.f12550d) {
            if (this.f12550d != null) {
                this.f12550d.clear();
                this.f12550d = null;
            }
        }
        synchronized (this.f12551e) {
            if (this.f12551e != null) {
                this.f12551e.clear();
                this.f12551e = null;
            }
        }
        this.f12554h = false;
    }

    public boolean onDoubleTap(float f, float f2) {
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onDoubleTap(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onSingleTap(float f, float f2) {
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onSingleTap(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onFling(float f, float f2) {
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onFling(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onScroll(float f, float f2) {
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onScroll(f, f2);
                }
            }
        }
        Handler handler = this.f12553g;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(this.f12556j);
        this.f12553g.postDelayed(this.f12556j, 500);
        return false;
    }

    public boolean onLongPress(float f, float f2) {
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onLongPress(f, f2);
                }
            }
        }
        return false;
    }

    public boolean onDown(float f, float f2) {
        this.f12554h = true;
        CopyOnWriteArrayList<OnMapGestureListener> copyOnWriteArrayList = this.f12547a;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<OnMapGestureListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onDown(f, f2);
        }
        return false;
    }

    public boolean onUp(float f, float f2) {
        this.f12554h = false;
        synchronized (this.f12547a) {
            if (this.f12547a != null) {
                Iterator<OnMapGestureListener> it = this.f12547a.iterator();
                while (it.hasNext()) {
                    it.next().onUp(f, f2);
                }
            }
        }
        return false;
    }

    public void onMapStable() {
        Runnable runnable;
        Handler handler = this.f12553g;
        if (handler != null && (runnable = this.f12555i) != null) {
            handler.removeCallbacks(runnable);
            this.f12553g.postDelayed(this.f12555i, 250);
        }
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        synchronized (this.f12549c) {
            if (this.f12549c != null) {
                Iterator<OnCameraChangeListener> it = this.f12549c.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChange(Converter.convertFromDidiCameraPosition(cameraPosition));
                }
            }
        }
    }

    public void onMapClick(LatLng latLng) {
        synchronized (this.f12550d) {
            if (this.f12550d != null) {
                Iterator<OnMapClickListener> it = this.f12550d.iterator();
                while (it.hasNext()) {
                    it.next().onMapClick(Converter.convertFromDidiLatLng(latLng));
                }
            }
        }
    }

    public void onMapLongClick(LatLng latLng) {
        synchronized (this.f12551e) {
            if (this.f12551e != null) {
                Iterator<OnMapLongClickListener> it = this.f12551e.iterator();
                while (it.hasNext()) {
                    it.next().onMapLongClick(Converter.convertFromDidiLatLng(latLng));
                }
            }
        }
    }

    public void onMapLoaded() {
        synchronized (this.f12548b) {
            if (this.f12548b != null) {
                Iterator<OnMapLoadedCallback> it = this.f12548b.iterator();
                while (it.hasNext()) {
                    it.next().onMapLoaded();
                }
            }
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        if (onCameraChangeListener != null) {
            synchronized (this.f12549c) {
                if (this.f12549c != null && !this.f12549c.contains(onCameraChangeListener)) {
                    this.f12549c.add(onCameraChangeListener);
                }
            }
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        this.f12549c.remove(onCameraChangeListener);
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        if (onMapGestureListener != null) {
            synchronized (this.f12547a) {
                if (!this.f12547a.contains(onMapGestureListener)) {
                    this.f12547a.add(onMapGestureListener);
                }
            }
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        synchronized (this.f12547a) {
            this.f12547a.remove(onMapGestureListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        if (onMapClickListener != null) {
            synchronized (this.f12550d) {
                if (!this.f12550d.contains(onMapClickListener)) {
                    this.f12550d.add(onMapClickListener);
                }
            }
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        synchronized (this.f12550d) {
            this.f12550d.remove(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        if (onMapLongClickListener != null) {
            synchronized (this.f12551e) {
                if (!this.f12551e.contains(onMapLongClickListener)) {
                    this.f12551e.add(onMapLongClickListener);
                }
            }
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        synchronized (this.f12551e) {
            this.f12551e.remove(onMapLongClickListener);
        }
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        synchronized (this.f12548b) {
            if (!this.f12548b.contains(onMapLoadedCallback)) {
                this.f12548b.add(onMapLoadedCallback);
            }
        }
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        synchronized (this.f12548b) {
            this.f12548b.remove(onMapLoadedCallback);
        }
    }
}
