package com.didi.common.map.adapter.googlemapadapter.listener;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class GoogleMapEventListener implements GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveCanceledListener, GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    public static final int GESTURE_DEFAULT = 0;
    public static final int SINGLE_FINGER_DOUBLE_CLICK = 3;
    public static final int TOW_FINGERS_CLICK = 2;
    public static final int TOW_FINGERS_MOVE = 1;
    public static final int TOW_FINGERS_TO_SINGLE = 4;

    /* renamed from: a */
    private static final int f12619a = 1;

    /* renamed from: b */
    private static final int f12620b = 2;

    /* renamed from: c */
    private static final int f12621c = 3;

    /* renamed from: d */
    private GoogleMap f12622d;

    /* renamed from: e */
    private final CopyOnWriteArrayList<OnCameraChangeListener> f12623e;

    /* renamed from: f */
    private final CopyOnWriteArrayList<OnMapGestureListener> f12624f;

    /* renamed from: g */
    private final CopyOnWriteArrayList<OnMapClickListener> f12625g;
    public int gesture;

    /* renamed from: h */
    private final CopyOnWriteArrayList<OnMapLongClickListener> f12626h;

    /* renamed from: i */
    private int f12627i;

    public void onCameraMoveCanceled() {
    }

    public void onMapLongClick(LatLng latLng) {
    }

    public GoogleMapEventListener(GoogleMap googleMap) {
        if (googleMap != null) {
            this.f12622d = googleMap;
            this.f12623e = new CopyOnWriteArrayList<>();
            this.f12624f = new CopyOnWriteArrayList<>();
            this.f12625g = new CopyOnWriteArrayList<>();
            this.f12626h = new CopyOnWriteArrayList<>();
            googleMap.setOnCameraIdleListener(this);
            googleMap.setOnCameraMoveListener(this);
            googleMap.setOnCameraMoveCanceledListener(this);
            googleMap.setOnCameraMoveStartedListener(this);
            googleMap.setOnMapClickListener(this);
            googleMap.setOnMapLongClickListener(this);
            return;
        }
        throw new MapNotExistApiException("GoogleMapEventListener:googleMap is null!");
    }

    public void onCameraMoveStarted(int i) {
        this.f12627i = i;
    }

    public void onCameraMove() {
        onCameraChange();
    }

    public void onCameraIdle() {
        onCameraChange();
        if (this.f12627i == 1) {
            m10732a();
        }
        if (this.f12624f != null) {
            SystemUtils.log(6, "GestureFragment", "onCameraIdle", (Throwable) null, "com.didi.common.map.adapter.googlemapadapter.listener.GoogleMapEventListener", 99);
            synchronized (this.f12624f) {
                if (this.f12624f != null && this.f12624f.size() > 0) {
                    Iterator<OnMapGestureListener> it = this.f12624f.iterator();
                    while (it.hasNext()) {
                        it.next().onMapStable();
                    }
                }
            }
        }
        this.gesture = 0;
    }

    /* renamed from: a */
    private void m10732a() {
        HashMap hashMap = new HashMap();
        hashMap.put("times", 1);
        hashMap.put("map_type", "gmap");
        OmegaSDKAdapter.trackEvent("map_global_index_map_drag", (Map<String, Object>) hashMap);
    }

    public void onCameraChange() {
        synchronized (this.f12623e) {
            if (this.f12623e != null && this.f12623e.size() > 0) {
                CameraPosition convertFromGoogleCameraPosition = Converter.convertFromGoogleCameraPosition(this.f12622d.getCameraPosition());
                Iterator<OnCameraChangeListener> it = this.f12623e.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChange(convertFromGoogleCameraPosition);
                }
            }
        }
    }

    public void onMapClick(LatLng latLng) {
        synchronized (this.f12625g) {
            if (this.f12625g != null && this.f12625g.size() > 0) {
                com.didi.common.map.model.LatLng convertFromGoogleLatLng = Converter.convertFromGoogleLatLng(latLng);
                Iterator<OnMapClickListener> it = this.f12625g.iterator();
                while (it.hasNext()) {
                    it.next().onMapClick(convertFromGoogleLatLng);
                }
            }
        }
    }

    public void destroy() {
        GoogleMap googleMap = this.f12622d;
        if (googleMap != null) {
            googleMap.setOnMapClickListener((GoogleMap.OnMapClickListener) null);
            this.f12622d.setOnCameraIdleListener((GoogleMap.OnCameraIdleListener) null);
            this.f12622d.setOnCameraMoveListener((GoogleMap.OnCameraMoveListener) null);
            this.f12622d.setOnCameraMoveCanceledListener((GoogleMap.OnCameraMoveCanceledListener) null);
            this.f12622d.setOnCameraMoveStartedListener((GoogleMap.OnCameraMoveStartedListener) null);
            this.f12622d.setOnMapClickListener((GoogleMap.OnMapClickListener) null);
            this.f12622d.setOnMapLongClickListener((GoogleMap.OnMapLongClickListener) null);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener != null) {
            synchronized (this.f12623e) {
                if (!this.f12623e.contains(onCameraChangeListener)) {
                    this.f12623e.add(onCameraChangeListener);
                }
            }
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        synchronized (this.f12623e) {
            this.f12623e.remove(onCameraChangeListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener != null) {
            synchronized (this.f12625g) {
                if (!this.f12625g.contains(onMapClickListener)) {
                    this.f12625g.add(onMapClickListener);
                }
            }
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        synchronized (this.f12625g) {
            this.f12625g.remove(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener != null) {
            synchronized (this.f12626h) {
                if (!this.f12626h.contains(onMapLongClickListener)) {
                    this.f12626h.add(onMapLongClickListener);
                }
            }
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        synchronized (this.f12626h) {
            this.f12626h.remove(onMapLongClickListener);
        }
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        if (onMapGestureListener != null) {
            synchronized (this.f12624f) {
                if (!this.f12624f.contains(onMapGestureListener)) {
                    this.f12624f.add(onMapGestureListener);
                }
            }
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        synchronized (this.f12624f) {
            this.f12624f.remove(onMapGestureListener);
        }
    }

    public List<OnMapGestureListener> getOnMapGestureListeners() {
        CopyOnWriteArrayList<OnMapGestureListener> copyOnWriteArrayList;
        synchronized (this.f12624f) {
            copyOnWriteArrayList = this.f12624f;
        }
        return copyOnWriteArrayList;
    }

    public List<OnMapLongClickListener> getOnMapLongClickListeners() {
        CopyOnWriteArrayList<OnMapLongClickListener> copyOnWriteArrayList;
        synchronized (this.f12626h) {
            copyOnWriteArrayList = this.f12626h;
        }
        return copyOnWriteArrayList;
    }
}
