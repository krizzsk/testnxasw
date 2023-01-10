package com.didi.hawaii.mapsdkv2.adapter;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.core.GLAnimator;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMyLocation;
import com.didi.map.alpha.maps.internal.ILocationDelegate;
import com.didi.map.common.MapAssets;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.map.CameraUpdateFactory;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.BitmapDescriptorFactory;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MyLocationOption;
import com.didi.sdk.util.ImageUtil;
import com.didi.soda.customer.blocks.BlocksConst;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MyLocationDelegate extends C9761b implements ILocationDelegate, LocationSource.OnLocationChangedListener {

    /* renamed from: b */
    private static final String f25986b = "MyLocationDG";

    /* renamed from: c */
    private static final int f25987c = 5;

    /* renamed from: d */
    private static final float f25988d = 18.0f;

    /* renamed from: e */
    private static final int f25989e = 95;

    /* renamed from: f */
    private final LatLng f25990f = new LatLng(39.90881451094423d, 116.39735698699951d);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GLMyLocation f25991g;

    /* renamed from: h */
    private Location f25992h = new Location("GPS");

    /* renamed from: i */
    private boolean f25993i = true;

    /* renamed from: j */
    private LocationSource f25994j;

    /* renamed from: k */
    private MyLocationOption f25995k;

    /* renamed from: l */
    private DidiMap.OnMyLocationChangeListener f25996l;

    /* renamed from: m */
    private final DidiMap f25997m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f25998n = false;

    /* renamed from: o */
    private float f25999o = 0.0f;

    /* renamed from: p */
    private boolean f26000p = false;

    /* renamed from: q */
    private final ModeStrategy f26001q;

    /* renamed from: r */
    private final SensorFilter f26002r;

    /* renamed from: s */
    private Texture f26003s = null;

    /* renamed from: t */
    private Texture f26004t = null;

    /* renamed from: u */
    private DidiMap.CancelableCallback f26005u = new DidiMap.CancelableCallback() {
        public void onFinish() {
            boolean unused = MyLocationDelegate.this.f25998n = false;
        }

        public void onCancel() {
            boolean unused = MyLocationDelegate.this.f25998n = false;
        }
    };

    enum LocationMode {
        SENSOR,
        GPS
    }

    public MyLocationDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map, DidiMap didiMap) {
        super(gLViewManager, map);
        m20553b(IPixView.PAGE_STATUS_INIT);
        this.f25995k = new MyLocationOption.Builder().setLocationType(1).setPosition(this.f25990f).setAnchorX(0.5f).setAnchorY(0.5f).setMinRadius(15).setMaxRadius(1000).setIcon(BitmapDescriptorFactory.fromBitmap(m20538a(this.context, MapAssets.bitmap(this.context, MapAssets.HAWAII_SELF_DRIVING_LOCATOR)))).setFailedIcon(BitmapDescriptorFactory.fromBitmap(m20538a(this.context, MapAssets.bitmap(this.context, MapAssets.HAWAII_SELF_DRIVING_LOCATOR_DISABLE)))).setShowRing(true).build();
        this.f25992h.setLatitude(this.f25990f.latitude);
        this.f25992h.setLongitude(this.f25990f.longitude);
        this.f25997m = didiMap;
        this.f26001q = new ModeStrategy();
        this.f26002r = new SensorFilter();
    }

    public void release() {
        m20553b("release");
        disableMylocation();
    }

    public boolean enableMylocation() {
        return enableMylocation(18.0f, 0.0f, 0.0f);
    }

    public boolean enableMylocation(float f, float f2, float f3) {
        m20553b("enable--:" + this.f25993i);
        this.f26000p = true;
        if (!this.f25993i) {
            m20550b();
            if (this.f25991g != null && m20547a()) {
                m20541a(f, f2, f3);
            }
        } else if (m20547a()) {
            m20541a(f, f2, f3);
        }
        if (this.f25991g != null) {
            this.f26001q.cancelLocationLostTimer();
            this.f26001q.startLocationLostTimer();
        }
        LocationSource locationSource = this.f25994j;
        if (locationSource != null) {
            locationSource.activate(this);
        }
        return true;
    }

    public void disableMylocation() {
        m20553b("disable");
        this.f26000p = false;
        m20558d();
        this.f26001q.free();
        this.f26001q.free();
        if (this.f25991g != null) {
            this.viewManager.removeView(this.f25991g);
            this.f25991g = null;
        }
        LocationSource locationSource = this.f25994j;
        if (locationSource != null) {
            locationSource.deactivate();
        }
    }

    public void setLocationSource(LocationSource locationSource) {
        m20553b("setSource");
        this.f25994j = locationSource;
        if (isProviderEnable()) {
            enableMylocation();
        }
    }

    public boolean isProviderEnable() {
        return this.f25991g != null;
    }

    public Location getMyLocation() {
        return this.f25992h;
    }

    public void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        m20553b("setListener");
        this.f25996l = onMyLocationChangeListener;
    }

    public void setMyLocationOption(MyLocationOption myLocationOption) {
        setMyLocationOption(myLocationOption, 18.0f, 0.0f, 0.0f);
    }

    public void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3) {
        if (myLocationOption != null) {
            m20553b("setOp--" + myLocationOption.toString());
            if (this.f25993i && myLocationOption.getPosition() != null) {
                this.f25992h.setLatitude(myLocationOption.getPosition().latitude);
                this.f25992h.setLongitude(myLocationOption.getPosition().longitude);
                this.f25993i = false;
            }
            m20546a(myLocationOption);
            if (isProviderEnable()) {
                if (myLocationOption.getIcon() != null) {
                    m20542a(myLocationOption.getIcon().getBitmap(this.context));
                }
                if (myLocationOption.getFailedIcon() != null) {
                    m20552b(myLocationOption.getFailedIcon().getBitmap(this.context));
                }
                if (2 == myLocationOption.getLocationType().intValue()) {
                    m20541a(f, f2, f3);
                }
            }
        }
    }

    public MyLocationOption getMyLocationOption() {
        return this.f25995k;
    }

    public void onLocationChanged(Location location) {
        if (this.f26000p) {
            m20550b();
            m20543a(location);
        }
    }

    public void onAngleChanged(float f) {
        if (this.f25991g != null) {
            this.f26001q.setSensorEnable();
            this.f26002r.onSensorAngleChange(f);
            if (!this.f26001q.isGPSMode()) {
                float lastSensorAngle = this.f26002r.getLastSensorAngle();
                if (Math.abs(lastSensorAngle - this.f25999o) >= 5.0f) {
                    m20540a(360.0f - lastSensorAngle);
                    this.f25999o = lastSensorAngle;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20547a() {
        return 2 == this.f25995k.getLocationType().intValue();
    }

    /* renamed from: a */
    private void m20541a(float f, float f2, float f3) {
        if (!this.f25998n) {
            m20553b("ToCenter " + f + ", " + f2 + ", " + f3);
            this.f25998n = true;
            this.f25997m.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(m20556c(), f, f2, f3)), this.f26005u);
        }
    }

    /* renamed from: a */
    private void m20546a(MyLocationOption myLocationOption) {
        BitmapDescriptor bitmapDescriptor;
        LatLng latLng;
        Integer num;
        Integer num2;
        Integer num3;
        Boolean bool;
        BitmapDescriptor icon = myLocationOption.getIcon() != null ? myLocationOption.getIcon() : this.f25995k.getIcon();
        if (myLocationOption.getFailedIcon() != null) {
            bitmapDescriptor = myLocationOption.getFailedIcon();
        } else {
            bitmapDescriptor = this.f25995k.getFailedIcon();
        }
        if (myLocationOption.getPosition() != null) {
            latLng = myLocationOption.getPosition();
        } else {
            latLng = this.f25995k.getPosition();
        }
        if (myLocationOption.getLocationType() != null) {
            num = myLocationOption.getLocationType();
        } else {
            num = this.f25995k.getLocationType();
        }
        MyLocationOption.Builder position = new MyLocationOption.Builder().setIcon(icon).setFailedIcon(bitmapDescriptor).setAnchorX(this.f25995k.getAnchorX().floatValue()).setAnchorY(this.f25995k.getAnchorY().floatValue()).setLocationType(num.intValue()).setPosition(latLng);
        if (myLocationOption.getMinRadius() != null) {
            num2 = myLocationOption.getMinRadius();
        } else {
            num2 = this.f25995k.getMinRadius();
        }
        MyLocationOption.Builder minRadius = position.setMinRadius(num2.intValue());
        if (myLocationOption.getMaxRadius() != null) {
            num3 = myLocationOption.getMaxRadius();
        } else {
            num3 = this.f25995k.getMaxRadius();
        }
        MyLocationOption.Builder maxRadius = minRadius.setMaxRadius(num3.intValue());
        if (myLocationOption.isShowRing() != null) {
            bool = myLocationOption.isShowRing();
        } else {
            bool = this.f25995k.isShowRing();
        }
        this.f25995k = maxRadius.setShowRing(bool.booleanValue()).build();
    }

    /* renamed from: b */
    private void m20550b() {
        if (this.f25991g == null) {
            m20553b("ensureMarker-showRing:" + this.f25995k.isShowRing());
            float density = 0.5f / SystemUtil.getDensity(this.viewManager.getMapContext().getAndroidContext());
            GLMyLocation.Option option = new GLMyLocation.Option();
            option.setCenter(m20556c());
            option.setAngle(0.0f);
            option.setZIndex(95);
            option.setColor(Color.parseColor("#1A4FA7FF"));
            option.setBorderWidth(density);
            option.setBorderColor(Color.parseColor("#A0CAF4"));
            option.setRadius(0.0f);
            option.setShowRing(this.f25995k.isShowRing().booleanValue());
            Texture h = m20564h();
            if (h != null) {
                option.setTexture(h);
                this.f25991g = new GLMyLocation(this.viewManager, option);
                this.viewManager.addView((GLOverlayView) this.f25991g);
            }
        }
    }

    /* renamed from: c */
    private LatLng m20556c() {
        return new LatLng(this.f25992h.getLatitude(), this.f25992h.getLongitude());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20540a(float f) {
        GLMyLocation gLMyLocation = this.f25991g;
        if (gLMyLocation != null) {
            gLMyLocation.setAngle(f);
        }
    }

    /* renamed from: b */
    private void m20551b(float f) {
        if (this.f25991g != null) {
            this.f25991g.setRadius(m20555c(f));
        }
    }

    /* renamed from: c */
    private float m20555c(float f) {
        if (f < ((float) this.f25995k.getMinRadius().intValue())) {
            return 0.0f;
        }
        return f > ((float) this.f25995k.getMaxRadius().intValue()) ? (float) this.f25995k.getMaxRadius().intValue() : f;
    }

    /* renamed from: d */
    private void m20558d() {
        m20553b("stopAnimal");
        GLMyLocation gLMyLocation = this.f25991g;
        if (gLMyLocation != null && gLMyLocation.getCarMarker() != null) {
            this.f25991g.getCarMarker().stopAnimation();
        }
    }

    /* renamed from: a */
    private void m20543a(Location location) {
        if (location != null) {
            this.f26001q.newLocation(location);
            m20551b(location.getAccuracy());
            DidiMap.OnMyLocationChangeListener onMyLocationChangeListener = this.f25996l;
            if (onMyLocationChangeListener != null) {
                onMyLocationChangeListener.onMyLocationChange(location);
            }
            ArrayList arrayList = new ArrayList(2);
            if (this.f26001q.isGPSMode()) {
                float bearing = location.getBearing();
                if (Math.abs(this.f25999o - bearing) > 2.0f) {
                    float f = 360.0f - this.f25999o;
                    float f2 = 360.0f - bearing;
                    if (Math.abs(f2 - f) > 180.0f) {
                        f2 = f > f2 ? f2 + 360.0f : f2 - 360.0f;
                    }
                    this.f25999o = bearing;
                    arrayList.add(PropertyValuesHolder.ofFloat(BlocksConst.WIDGET_PARAMS_ANGLE, new float[]{f, f2}));
                }
            }
            if (!(this.f25992h.getLatitude() == location.getLatitude() && this.f25992h.getLongitude() == location.getLongitude())) {
                arrayList.add(PropertyValuesHolder.ofObject("position", new LatLngEvaluator(), new Object[]{new LatLng(this.f25992h.getLatitude(), this.f25992h.getLongitude()), new LatLng(location.getLatitude(), location.getLongitude())}));
            }
            if (!m20549a((Collection<?>) arrayList)) {
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setDuration(1000);
                gLAnimator.setInterpolator(new LinearInterpolator());
                gLAnimator.setValues((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("position");
                        Object animatedValue = valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE);
                        if (animatedValue != null) {
                            MyLocationDelegate.this.m20540a(((Float) animatedValue).floatValue());
                        }
                        if (latLng != null) {
                            if (MyLocationDelegate.this.f25991g != null) {
                                MyLocationDelegate.this.f25991g.setPosition(latLng);
                            }
                            if (MyLocationDelegate.this.m20547a() && !MyLocationDelegate.this.f25998n) {
                                MyLocationDelegate.this.viewManager.getBaseMap().setCenter(latLng);
                            }
                        }
                    }
                });
                GLMyLocation gLMyLocation = this.f25991g;
                if (gLMyLocation != null) {
                    gLMyLocation.getCarMarker().setAnimator(gLAnimator);
                    this.f25991g.getCarMarker().startAnimator();
                }
                this.f25993i = false;
                this.f25992h = location;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20560e() {
        m20553b("locationLost");
        if (this.f25991g != null) {
            Texture g = m20563g();
            if (g != null) {
                this.f25991g.setTexture(g);
            }
            this.f25991g.setRadius(0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m20562f() {
        Texture h;
        m20553b("locationToNormal");
        if (this.f25991g != null && (h = m20564h()) != null) {
            this.f25991g.setTexture(h);
        }
    }

    /* renamed from: g */
    private Texture m20563g() {
        Bitmap bitmap;
        Texture texture = this.f26004t;
        if (texture != null) {
            return texture;
        }
        if (this.f25995k.getFailedIcon() == null || (bitmap = this.f25995k.getFailedIcon().getBitmap(this.context)) == null) {
            return null;
        }
        Texture bitmap2 = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        this.f26004t = bitmap2;
        return bitmap2;
    }

    /* renamed from: h */
    private Texture m20564h() {
        Texture texture = this.f26003s;
        if (texture != null) {
            return texture;
        }
        Bitmap bitmap = this.f25995k.getIcon().getBitmap(this.context);
        if (bitmap == null) {
            return null;
        }
        Texture bitmap2 = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        this.f26003s = bitmap2;
        return bitmap2;
    }

    /* renamed from: a */
    private void m20542a(Bitmap bitmap) {
        this.f26003s = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        if (!this.f26001q.locationLost) {
            this.f25991g.setTexture(this.f26003s);
        }
    }

    /* renamed from: b */
    private void m20552b(Bitmap bitmap) {
        if (this.f26004t != null) {
            this.f26004t = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
            if (this.f26001q.locationLost) {
                this.f25991g.setTexture(this.f26004t);
            }
        }
    }

    /* renamed from: a */
    private boolean m20549a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    /* renamed from: a */
    private Bitmap m20538a(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            return bitmap;
        }
        float f = context.getResources().getDisplayMetrics().density / 3.0f;
        if (f == 1.0f) {
            return bitmap;
        }
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20553b(String str) {
        MapLog.m20589i(f25986b, str + " " + System.identityHashCode(this));
    }

    private static class SensorFilter {
        private float mLastSensorAngle;

        public void free() {
        }

        public float toClockAngle(float f) {
            return ((f % 360.0f) + 360.0f) % 360.0f;
        }

        private SensorFilter() {
            this.mLastSensorAngle = 0.0f;
        }

        public void onSensorAngleChange(float f) {
            this.mLastSensorAngle = toClockAngle(f);
        }

        public float getLastSensorAngle() {
            return this.mLastSensorAngle;
        }
    }

    private class ModeStrategy {
        private static final int TIME_INTERVAL_LOCATION_FAILED = 30000;
        private static final int TIME_INTERVAL_MODE_SWITCH = 5000;
        private final float SPEED_CRITICAL_VALUE = 4.0f;
        private boolean isSensorEnable = false;
        /* access modifiers changed from: private */
        public boolean locationLost = false;
        Runnable locationLostRunnable = new Runnable() {
            public void run() {
                boolean unused = ModeStrategy.this.locationLost = true;
                MyLocationDelegate.this.m20560e();
            }
        };
        private final Handler mMainHandler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public LocationMode mode = LocationMode.SENSOR;
        Runnable modeSwitchRunnable = new Runnable() {
            public void run() {
                MyLocationDelegate.this.m20553b("GPS overtime");
                LocationMode unused = ModeStrategy.this.mode = LocationMode.SENSOR;
            }
        };

        ModeStrategy() {
        }

        public void free() {
            cancelAllTimer();
        }

        public void setSensorEnable() {
            this.isSensorEnable = true;
        }

        public void newLocation(Location location) {
            LocationMode locationMode;
            if (location != null) {
                if (location.getSpeed() >= 4.0f) {
                    locationMode = LocationMode.GPS;
                } else {
                    locationMode = LocationMode.SENSOR;
                }
                this.mode = locationMode;
                if (this.locationLost) {
                    MyLocationDelegate.this.m20562f();
                    this.locationLost = false;
                }
                cancelAllTimer();
                if (!this.isSensorEnable) {
                    this.mode = LocationMode.GPS;
                } else if (isGPSMode()) {
                    startGPSCheckTimer();
                }
                startLocationLostTimer();
            }
        }

        public boolean isGPSMode() {
            return LocationMode.GPS == this.mode;
        }

        private void startGPSCheckTimer() {
            this.mMainHandler.postDelayed(this.modeSwitchRunnable, 5000);
        }

        /* access modifiers changed from: private */
        public void startLocationLostTimer() {
            this.mMainHandler.postDelayed(this.locationLostRunnable, 30000);
        }

        /* access modifiers changed from: private */
        public void cancelLocationLostTimer() {
            this.mMainHandler.removeCallbacks(this.locationLostRunnable);
        }

        private void cancelAllTimer() {
            this.mMainHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
