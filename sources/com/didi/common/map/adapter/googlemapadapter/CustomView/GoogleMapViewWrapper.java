package com.didi.common.map.adapter.googlemapadapter.CustomView;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.adapter.googlemapadapter.listener.GoogleMapEventListener;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

public class GoogleMapViewWrapper extends FrameLayout {
    public static final int ANIMATE_TIME = 400;
    public static boolean IS_SCALE = false;

    /* renamed from: a */
    private static final String f12579a = "GoogleMapViewWrapper";

    /* renamed from: b */
    private static final float f12580b = 1.5f;
    public static boolean isActionPointerDown = false;
    public static boolean isDoubleScale = false;

    /* renamed from: c */
    private MapView f12581c;

    /* renamed from: d */
    private View f12582d;

    /* renamed from: e */
    private GestureDetectorCompat f12583e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoogleMap f12584f;

    /* renamed from: g */
    private float f12585g;

    /* renamed from: h */
    private long f12586h;

    /* renamed from: i */
    private float f12587i;

    /* renamed from: j */
    private LatLng f12588j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GoogleMapEventListener f12589k;

    /* renamed from: l */
    private long f12590l;

    /* renamed from: m */
    private double f12591m;

    /* renamed from: n */
    private double f12592n;

    /* renamed from: o */
    private boolean f12593o;

    /* renamed from: p */
    private long f12594p;

    /* renamed from: q */
    private LatLng f12595q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f12596r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public LatLng f12597s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f12598t;

    /* renamed from: u */
    private final GestureDetector.SimpleOnGestureListener f12599u = new GestureDetector.SimpleOnGestureListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean unused = GoogleMapViewWrapper.this.f12598t = true;
            if (GoogleMapViewWrapper.this.f12589k != null) {
                for (OnMapGestureListener onDoubleTap : GoogleMapViewWrapper.this.f12589k.getOnMapGestureListeners()) {
                    onDoubleTap.onDoubleTap(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (GoogleMapViewWrapper.this.f12584f == null) {
                return false;
            }
            GoogleMapViewWrapper.this.f12584f.getUiSettings().setScrollGesturesEnabled(false);
            float f = 21.0f;
            if (GoogleMapViewWrapper.this.f12584f.getCameraPosition().zoom == 21.0f) {
                GoogleMapViewWrapper.this.f12584f.getUiSettings().setScrollGesturesEnabled(true);
                return true;
            }
            float f2 = GoogleMapViewWrapper.this.f12584f.getCameraPosition().zoom + 1.0f;
            if (f2 <= 21.0f) {
                f = f2;
            }
            long eventTime = motionEvent.getEventTime();
            if (eventTime - GoogleMapViewWrapper.this.f12596r >= 300) {
                GoogleMapViewWrapper googleMapViewWrapper = GoogleMapViewWrapper.this;
                LatLng unused2 = googleMapViewWrapper.f12597s = googleMapViewWrapper.f12584f.getCameraPosition().target;
            } else if (GoogleMapViewWrapper.this.f12597s == null) {
                GoogleMapViewWrapper googleMapViewWrapper2 = GoogleMapViewWrapper.this;
                LatLng unused3 = googleMapViewWrapper2.f12597s = googleMapViewWrapper2.f12584f.getCameraPosition().target;
            }
            long unused4 = GoogleMapViewWrapper.this.f12596r = eventTime;
            GoogleMapViewWrapper.this.f12589k.gesture = 3;
            GoogleMapViewWrapper.this.f12584f.animateCamera(CameraUpdateFactory.newLatLngZoom(GoogleMapViewWrapper.this.f12597s, f), 400, new GoogleMap.CancelableCallback() {
                public void onFinish() {
                    GoogleMapViewWrapper.this.f12584f.getUiSettings().setScrollGesturesEnabled(true);
                }

                public void onCancel() {
                    GoogleMapViewWrapper.this.f12584f.getUiSettings().setScrollGesturesEnabled(true);
                }
            });
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (GoogleMapViewWrapper.this.f12589k != null) {
                for (OnMapGestureListener onScroll : GoogleMapViewWrapper.this.f12589k.getOnMapGestureListeners()) {
                    onScroll.onScroll(f, f2);
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (GoogleMapViewWrapper.this.f12589k != null) {
                for (OnMapGestureListener onFling : GoogleMapViewWrapper.this.f12589k.getOnMapGestureListeners()) {
                    onFling.onFling(f, f2);
                }
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (GoogleMapViewWrapper.this.f12589k != null) {
                for (OnMapGestureListener onDown : GoogleMapViewWrapper.this.f12589k.getOnMapGestureListeners()) {
                    onDown.onDown(motionEvent.getX(), motionEvent.getY());
                }
            }
            return super.onDown(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (GoogleMapViewWrapper.this.f12589k != null) {
                for (OnMapGestureListener onLongPress : GoogleMapViewWrapper.this.f12589k.getOnMapGestureListeners()) {
                    onLongPress.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
            try {
                LatLng fromScreenLocation = GoogleMapViewWrapper.this.f12584f.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
                if (GoogleMapViewWrapper.this.f12589k != null) {
                    for (OnMapLongClickListener onMapLongClick : GoogleMapViewWrapper.this.f12589k.getOnMapLongClickListeners()) {
                        onMapLongClick.onMapLongClick(Converter.convertFromGoogleLatLng(fromScreenLocation));
                    }
                }
            } catch (Exception e) {
                DLog.m10773d(GoogleMapViewWrapper.f12579a, "long press exc: " + e.getMessage(), new Object[0]);
            }
            super.onLongPress(motionEvent);
        }
    };

    public void destroy() {
    }

    public GoogleMapViewWrapper(Context context) {
        super(context);
        m10718a(context);
    }

    public GoogleMapViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10718a(context);
    }

    public GoogleMapViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10718a(context);
    }

    /* renamed from: a */
    private void m10718a(Context context) {
        this.f12582d = new View(context);
        MapView mapView = new MapView(context);
        this.f12581c = mapView;
        addView(mapView);
        addView(this.f12582d);
        this.f12583e = new GestureDetectorCompat(context, this.f12599u);
        this.f12585g = 1.5f / ((float) getResources().getDisplayMetrics().widthPixels);
    }

    public MapView getGoogleMapView() {
        return this.f12581c;
    }

    public void setGoogleMap(GoogleMap googleMap) {
        this.f12584f = googleMap;
        if (this.f12589k == null) {
            this.f12589k = new GoogleMapEventListener(googleMap);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        GoogleMap googleMap = this.f12584f;
        if (googleMap == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!googleMap.getUiSettings().isZoomGesturesEnabled()) {
            return true;
        }
        if (actionMasked == 0) {
            if (!this.f12584f.getUiSettings().isScrollGesturesEnabled()) {
                this.f12584f.getUiSettings().setScrollGesturesEnabled(true);
            }
            z = this.f12583e.onTouchEvent(motionEvent);
        } else if (actionMasked == 1) {
            this.f12592n = 0.0d;
            z = this.f12583e.onTouchEvent(motionEvent);
            GoogleMapEventListener googleMapEventListener = this.f12589k;
            if (googleMapEventListener != null) {
                for (OnMapGestureListener onUp : googleMapEventListener.getOnMapGestureListeners()) {
                    onUp.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (isActionPointerDown) {
                isActionPointerDown = false;
            }
            if (IS_SCALE) {
                IS_SCALE = false;
                motionEvent.setAction(0);
                super.dispatchTouchEvent(motionEvent);
                return true;
            } else if (this.f12598t) {
                this.f12598t = false;
                return true;
            } else if (this.f12593o) {
                this.f12593o = false;
                return true;
            }
        } else if (actionMasked == 5) {
            isActionPointerDown = true;
            z = this.f12583e.onTouchEvent(motionEvent);
            this.f12586h = motionEvent.getEventTime();
            this.f12591m = getPointsLength(motionEvent);
            this.f12584f.getUiSettings().setScrollGesturesEnabled(false);
            this.f12587i = this.f12584f.getCameraPosition().zoom;
            this.f12588j = this.f12584f.getCameraPosition().target;
        } else if (actionMasked == 6) {
            this.f12592n = 0.0d;
            z = this.f12583e.onTouchEvent(motionEvent);
            GoogleMapEventListener googleMapEventListener2 = this.f12589k;
            if (googleMapEventListener2 != null) {
                for (OnMapGestureListener onUp2 : googleMapEventListener2.getOnMapGestureListeners()) {
                    onUp2.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            if (!this.f12584f.getUiSettings().isScrollGesturesEnabled()) {
                this.f12584f.getUiSettings().setScrollGesturesEnabled(true);
            }
            this.f12590l = motionEvent.getEventTime();
            if (motionEvent.getPointerCount() > 1 && this.f12590l - this.f12586h < 200 && this.f12584f.getCameraPosition().zoom != this.f12584f.getMinZoomLevel() && !IS_SCALE) {
                this.f12593o = true;
                float f = this.f12584f.getCameraPosition().zoom - 1.0f;
                if (f < this.f12584f.getMinZoomLevel()) {
                    f = this.f12584f.getMinZoomLevel();
                }
                isDoubleScale = true;
                long eventTime = motionEvent.getEventTime();
                if (eventTime - this.f12594p >= 300) {
                    this.f12595q = this.f12584f.getCameraPosition().target;
                } else if (this.f12595q == null) {
                    this.f12595q = this.f12584f.getCameraPosition().target;
                }
                this.f12594p = eventTime;
                this.f12589k.gesture = 2;
                this.f12584f.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f12595q, f), 400, (GoogleMap.CancelableCallback) null);
                return true;
            }
        } else if (actionMasked != 2) {
            z = false;
        } else if (motionEvent.getPointerCount() > 1) {
            double pointsLength = getPointsLength(motionEvent);
            double abs = Math.abs((pointsLength - this.f12591m) * ((double) this.f12585g));
            if (Math.abs(abs - this.f12592n) > 0.01d) {
                IS_SCALE = true;
                this.f12592n = abs;
                float f2 = (float) (((pointsLength - this.f12591m) * ((double) this.f12585g)) + ((double) this.f12587i));
                if (f2 > this.f12584f.getMinZoomLevel() || this.f12584f.getCameraPosition().zoom != this.f12584f.getMinZoomLevel()) {
                    if (f2 >= 21.0f && this.f12584f.getCameraPosition().zoom >= 21.0f) {
                        this.f12591m = pointsLength;
                        this.f12587i = 21.0f;
                        if (this.f12584f.getCameraPosition().zoom == 21.0f) {
                            return true;
                        }
                    }
                    if (this.f12588j == null) {
                        this.f12588j = this.f12584f.getCameraPosition().target;
                    }
                    this.f12589k.gesture = 1;
                    this.f12584f.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f12588j, f2), 1, (GoogleMap.CancelableCallback) null);
                    GoogleMapEventListener googleMapEventListener3 = this.f12589k;
                    if (googleMapEventListener3 != null) {
                        googleMapEventListener3.onCameraChange();
                    }
                } else {
                    this.f12591m = pointsLength;
                    this.f12587i = this.f12584f.getMinZoomLevel();
                    return true;
                }
            }
            return true;
        } else {
            if (!(this.f12589k.gesture == 2 || this.f12589k.gesture == 3)) {
                this.f12589k.gesture = 0;
            }
            if (motionEvent.getEventTime() - this.f12590l <= 50) {
                return false;
            }
            if (this.f12583e.onTouchEvent(motionEvent)) {
                return true;
            }
            try {
                if (super.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                DLog.m10773d(f12579a, "super.dispatchTouchEvent = " + th, new Object[0]);
                return false;
            }
        }
        if (z || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public double getPointsLength(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(motionEvent.getPointerCount() - 1));
        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(motionEvent.getPointerCount() - 1));
        return Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapGestureListener(onMapGestureListener);
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapGestureListener(onMapGestureListener);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapClickListener(onMapClickListener);
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapClickListener(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.addOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapEventListener googleMapEventListener = this.f12589k;
        if (googleMapEventListener != null) {
            googleMapEventListener.removeOnMapLongClickListener(onMapLongClickListener);
        }
    }
}
