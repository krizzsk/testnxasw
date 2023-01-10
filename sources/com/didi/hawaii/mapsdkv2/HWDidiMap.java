package com.didi.hawaii.mapsdkv2;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.adapter.BezireCurveDelegate;
import com.didi.hawaii.mapsdkv2.adapter.CircleDelegate;
import com.didi.hawaii.mapsdkv2.adapter.CollisionGroupDelegate;
import com.didi.hawaii.mapsdkv2.adapter.HeatMapDelegate;
import com.didi.hawaii.mapsdkv2.adapter.LocatorDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MapManagerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MarkerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MarkerViewDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MaskLayerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MyLocationDelegate;
import com.didi.hawaii.mapsdkv2.adapter.PolygonDelegate;
import com.didi.hawaii.mapsdkv2.adapter.PolylineRouteDelegate;
import com.didi.hawaii.mapsdkv2.adapter.UiSettingDelegate;
import com.didi.hawaii.mapsdkv2.adapter.traffic.TrafficEventIconDelegate;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLInstrumentation;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.RenderProfile;
import com.didi.hawaii.mapsdkv2.widget.MapWidgets;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.alpha.maps.internal.BezierCurveControl;
import com.didi.map.alpha.maps.internal.CircleControl;
import com.didi.map.alpha.maps.internal.HeatOverlayControl;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.alpha.maps.internal.LableMarkerManager_v3;
import com.didi.map.alpha.maps.internal.LocationControl;
import com.didi.map.alpha.maps.internal.LocatorControl;
import com.didi.map.alpha.maps.internal.MarkerControl;
import com.didi.map.alpha.maps.internal.MaskLayerControl;
import com.didi.map.alpha.maps.internal.PolygonControl;
import com.didi.map.alpha.maps.internal.PolylineControl;
import com.didi.map.alpha.maps.internal.UiSettingControl;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.base.bubble.TrafficHintShowBarn;
import com.didi.map.common.TrafficEventManager;
import com.didi.map.common.TrafficEventObserver;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.core.FrameCallback;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.map.core.base.impl.OnMapGestureListener;
import com.didi.map.core.base.impl.OnMapModeListener;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.CameraUpdate;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.map.InfoWindowAnimationManager;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.map.MapAccessManager;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.map.Projection;
import com.didi.map.outer.map.UiSettings;
import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;
import com.didi.map.outer.model.BitmapTileOverlay;
import com.didi.map.outer.model.BitmapTileOverlayOption;
import com.didi.map.outer.model.BubbleGroup;
import com.didi.map.outer.model.BubbleOptions;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.Circle;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.CollisionGroup;
import com.didi.map.outer.model.CollisionGroupOption;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Locator;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerGroup;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.MarkerView;
import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;
import com.didi.map.outer.model.MyLocationOption;
import com.didi.map.outer.model.OutBlockInfo;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.navi.core.auto.OnMapAutoCameraExecutor;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HWDidiMap implements DidiMapExt {

    /* renamed from: b */
    private static final String f25904b = "HWDidiMap";

    /* renamed from: A */
    private final BubbleManager f25905A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f25906a = false;

    /* renamed from: c */
    private final Map<String, Pair<?, GLOverlayView>> f25907c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MapManagerDelegate f25908d;

    /* renamed from: e */
    private final MarkerControl f25909e;

    /* renamed from: f */
    private final BezierCurveControl f25910f;

    /* renamed from: g */
    private final LocatorControl f25911g;

    /* renamed from: h */
    private final PolylineControl f25912h;

    /* renamed from: i */
    private final PolygonControl f25913i;

    /* renamed from: j */
    private final CircleControl f25914j;

    /* renamed from: k */
    private final MaskLayerControl f25915k;

    /* renamed from: l */
    private final HeatOverlayControl f25916l;

    /* renamed from: m */
    private final CollisionGroupDelegate f25917m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final TrafficEventIconDelegate f25918n;

    /* renamed from: o */
    private final WeakReference<MapHost> f25919o;

    /* renamed from: p */
    private final LocationControl f25920p;

    /* renamed from: q */
    private final UiSettingDelegate f25921q;

    /* renamed from: r */
    private WeakReference<MapView> f25922r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final DidiMap.OnLableMarkerCallback f25923s;

    /* renamed from: t */
    private final MapAccessManager f25924t;

    /* renamed from: u */
    private final MarkerViewDelegate f25925u;

    /* renamed from: v */
    private final Handler f25926v;

    /* renamed from: w */
    private boolean f25927w = false;

    /* renamed from: x */
    private TrafficEventObserver f25928x;

    /* renamed from: y */
    private UiSettings f25929y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public DidiMapExt.BubbleLoadBitmapListener f25930z;

    public BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption) {
        return null;
    }

    public int addBubble(BubbleOptions bubbleOptions) {
        return 0;
    }

    public BubbleGroup addBubbleGroup(List<BubbleOptions> list) {
        return null;
    }

    public List<Integer> addBubbles(List<BubbleOptions> list) {
        return null;
    }

    @Deprecated
    public void addMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
    }

    @Deprecated
    public void addMapGestureListener2(OnMapGestureListener onMapGestureListener) {
    }

    public MarkerGroup addMarkerGroup() {
        return null;
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, float f4, boolean z, boolean z2) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    @Deprecated
    public void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    public void clearBubbles() {
    }

    public void clearRealTrafficIcon() {
    }

    public List<Rect> getElementScreenBound(List<String> list) {
        return null;
    }

    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    public float getLogoMarginRate(int i) {
        return 0.0f;
    }

    public float getMapSkew() {
        return 0.0f;
    }

    public Rect getMarkerBound(Marker marker) {
        return null;
    }

    public GeoPoint getMarkerGeoPoint(Marker marker) {
        return null;
    }

    public OnMapAutoCameraExecutor getNavAutoMapActionExecutor() {
        return null;
    }

    public int getSDKVersion() {
        return 2;
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean removeBubble(int i) {
        return false;
    }

    public void setCompassExtraPadding(int i) {
    }

    public void setCompassExtraPadding(int i, int i2) {
    }

    public void setFrameCallback(FrameCallback frameCallback) {
    }

    public void setInfoWindowStillVisible(boolean z) {
    }

    public void setLocationInfo(GeoPoint geoPoint, float f, float f2, boolean z) {
    }

    public void setLogoAnchor(int i) {
    }

    public void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setLogoBottomMargin(int i) {
    }

    public void setLogoLeftMargin(int i) {
    }

    public void setLogoMarginRate(int i, float f) {
    }

    public void setLogoVisible(boolean z) {
    }

    public void setMapEventApollo(boolean z) {
    }

    public void setMapGestureListener(MapGestureListener mapGestureListener) {
    }

    public void setOnMapChangeCallback(DidiMapExt.OnMapParamChangeCallback onMapParamChangeCallback) {
    }

    public void setOnTapMapViewInfoWindowHidden(boolean z) {
    }

    public void setScaleAnchor(int i) {
    }

    public void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setSuid(String str) {
    }

    @Deprecated
    public void setTrafficColor(int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public void updateScaleView() {
    }

    HWDidiMap(MapHost mapHost, MapView mapView) {
        MapUtil.getScreenType(mapHost.getContext());
        MapUtil.initBasicInfo(mapHost.getContext());
        this.f25919o = new WeakReference<>(mapHost);
        GLViewManager gLViewManage = mapHost.getGLViewManage();
        this.f25926v = gLViewManage.getMainHandler();
        this.f25922r = new WeakReference<>(mapView);
        MapWidgets mapWidgets = new MapWidgets(mapView, gLViewManage.getBaseMap());
        this.f25908d = new MapManagerDelegate(gLViewManage, this.f25907c, mapWidgets);
        this.f25925u = new MarkerViewDelegate(gLViewManage, this.f25907c, mapView, this);
        this.f25910f = new BezierCurveControl(new BezireCurveDelegate(gLViewManage, this.f25907c));
        this.f25909e = new MarkerControl(new MarkerDelegate(gLViewManage, this.f25907c, mapView, this.f25925u));
        this.f25912h = new PolylineControl(new PolylineRouteDelegate(gLViewManage, this.f25907c));
        this.f25913i = new PolygonControl(new PolygonDelegate(gLViewManage, this.f25907c));
        this.f25914j = new CircleControl(new CircleDelegate(gLViewManage, this.f25907c));
        this.f25915k = new MaskLayerControl(new MaskLayerDelegate(gLViewManage, this.f25907c));
        this.f25916l = new HeatOverlayControl(new HeatMapDelegate(gLViewManage, this.f25907c));
        this.f25917m = new CollisionGroupDelegate(new MarkerDelegate(gLViewManage, this.f25907c, mapView, this.f25925u), this.f25908d, gLViewManage, this.f25907c);
        this.f25911g = new LocatorControl(new LocatorDelegate(gLViewManage, this.f25907c));
        this.f25920p = new LocationControl(new MyLocationDelegate(gLViewManage, this.f25907c, this));
        this.f25921q = new UiSettingDelegate(gLViewManage, mapWidgets);
        BubbleManager bubbleManager = new BubbleManager(this);
        this.f25905A = bubbleManager;
        this.f25909e.setBubbleManager(bubbleManager);
        this.f25918n = new TrafficEventIconDelegate(this, this.f25908d);
        gLViewManage.getBaseMap().setBitmapLoaderListener(new GLBaseMapView.BitmapLoaderListener() {
            public Bitmap onLoadBitmap(int i, String str) {
                if (HWDidiMap.this.f25930z != null) {
                    return HWDidiMap.this.f25930z.onBitmapLoader(i, str);
                }
                return null;
            }
        });
        this.f25923s = new LableMarkerManager_v3(this);
        this.f25928x = new TrafficEventObserver() {
            public void showLocalTrafficIcon() {
                if (HWDidiMap.this.isShowFakeTrafficEvent()) {
                    TrafficEventManager.getInstance().showTrafficLocalIcon(HWDidiMap.this);
                }
            }
        };
        gLViewManage.getBaseMap().setLabelOnRouteCallback(new GLBaseMapView.LabelOnRouteCallback() {
            public void onRouteNew(List<TextLableOnRoute> list) {
                HWDidiMap.this.f25923s.onLableRouteCallback(list);
            }
        });
        m20487a();
        MapAccessibilityDelegate mapAccessibilityDelegate = new MapAccessibilityDelegate();
        this.f25924t = mapAccessibilityDelegate;
        this.f25909e.setAccessibilityDelegate(mapAccessibilityDelegate);
    }

    /* renamed from: a */
    private void m20487a() {
        TrafficEventManager.getInstance().addObserver(this.f25928x);
    }

    public void setModNav(boolean z) {
        this.f25908d.setModeNavi(z);
    }

    public void setModDark(boolean z) {
        if (this.f25906a) {
            this.f25918n.toggleDayNight(z);
        }
        this.f25908d.setModeNight(z);
        this.f25923s.setDayNight(z);
    }

    public GeoPoint getCenter() {
        return new GeoPoint((int) (this.f25908d.getCameraPosition().target.longitude * 1000000.0d), (int) (this.f25908d.getCameraPosition().target.latitude * 1000000.0d));
    }

    public void setCenter(GeoPoint geoPoint) {
        if (geoPoint != null) {
            this.f25908d.setCenter(new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d));
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.f25908d.setCenter(latLng);
        }
    }

    @Deprecated
    public void setNaviCenter(int i, int i2) {
        this.f25908d.setNaviCenter(i, i2);
    }

    public void setInfoWindowUnique(boolean z) {
        this.f25909e.setInfoWindowUnique(z);
    }

    public void setRotateAngle(float f) {
        this.f25908d.setRotateAngle(f);
    }

    public void setSkewAngle(float f) {
        this.f25908d.setSkewAngle(f);
    }

    public void showTrafficHintIcon(long j, TrafficHintShowBarn trafficHintShowBarn) {
        if (this.f25906a) {
            this.f25918n.showTrafficHintIcon(j, trafficHintShowBarn);
        }
    }

    public void removeTrafficHintIcon() {
        if (this.f25906a) {
            this.f25918n.removeTrafficHintIcon();
        }
    }

    public void setTrafficEventIconCustomSize(int i) {
        this.f25918n.setTrafficEventIconCustomSize(i, this.f25906a);
        this.f25908d.setTrafficEventIconCustomSize(i);
    }

    public void resetTrafficEventIconCustomSize() {
        this.f25908d.resetTrafficEventIconCustomSize();
    }

    public CameraPosition getCameraPosition() {
        return this.f25908d.getCameraPosition();
    }

    public void setMaxSkew(float f) {
        this.f25908d.setMaxSkew(f);
    }

    public float getMaxSkew() {
        return this.f25908d.getMaxSkew();
    }

    public float getMaxZoomLevel() {
        return this.f25908d.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        return this.f25908d.getMinZoomLevel();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.f25908d.moveCamera(cameraUpdate);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        this.f25908d.animateCamera(cameraUpdate, 500, (DidiMap.CancelableCallback) null);
    }

    public void animateCamera(CameraUpdate cameraUpdate, DidiMap.CancelableCallback cancelableCallback) {
        this.f25908d.animateCamera(cameraUpdate, 500, cancelableCallback);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, DidiMap.CancelableCallback cancelableCallback) {
        this.f25908d.animateCamera(cameraUpdate, j, cancelableCallback);
    }

    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return this.f25908d.getZoomToSpanLevel(latLng, latLng2);
    }

    public void stopAnimation() {
        this.f25908d.stopAnimation();
    }

    public HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions) {
        return this.f25916l.addHeatOverlay(heatOverlayOptions);
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.f25912h.addPolyline(polylineOptions);
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.f25913i.addPolygon(polygonOptions);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return this.f25914j.addCircle(circleOptions);
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        MarkerControl markerControl = this.f25909e;
        Marker addMarker = markerControl.addMarker(markerOptions, markerControl);
        LableMarkerManager.addOtherMarker(addMarker);
        return addMarker;
    }

    public BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption) {
        return this.f25910f.addBezierCurve(bezierCurveOption);
    }

    public Locator getLocator() {
        return this.f25911g.getLocator();
    }

    public void clear() {
        this.f25908d.clearAll();
        this.f25917m.clearGroup();
    }

    public int getMapType() {
        return this.f25908d.getMapType();
    }

    public void setSatelliteEnabled(boolean z) {
        this.f25908d.setSatelliteEnabled(z);
    }

    public boolean isMyLocationEnabled() {
        return this.f25920p.isProviderEnable();
    }

    public void setMyLocationEnabled(boolean z) {
        if (z) {
            this.f25920p.enableMylocation();
        } else {
            this.f25920p.disableMylocation();
        }
    }

    public void setMyLocationEnabled(boolean z, float f, float f2, float f3) {
        if (z) {
            this.f25920p.enableMylocation();
        } else {
            this.f25920p.disableMylocation();
        }
    }

    public void setMyLocationOption(MyLocationOption myLocationOption) {
        this.f25920p.setMyLocationOption(myLocationOption);
    }

    public void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3) {
        this.f25920p.setMyLocationOption(myLocationOption, f, f2, f3);
    }

    public MyLocationOption getMyLocationOption() {
        return this.f25920p.getMyLocationOption();
    }

    public Location getMyLocation() {
        return this.f25920p.getMyLocation();
    }

    public void setLocationSource(LocationSource locationSource) {
        this.f25920p.setLocationSource(locationSource);
    }

    public UiSettings getUiSettings() {
        if (this.f25929y == null) {
            this.f25929y = new UiSettings(new UiSettingControl(this.f25921q));
        }
        return this.f25929y;
    }

    public Projection getProjection() {
        return this.f25908d.getProjection();
    }

    public void setNaviOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f25908d.setNaviOnPolylineClickListener(onPolylineClickListener);
    }

    public void setOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f25908d.setOnPolylineClickListenner(onPolylineClickListener);
    }

    public void setNaviOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f25908d.setNaviOnMapClickListener(onMapClickListener);
    }

    public void setOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f25908d.setOnCameraChangeListener(onCameraChangeListener);
    }

    public void addModeListener(OnMapModeListener onMapModeListener) {
        this.f25908d.addModeListener(onMapModeListener);
    }

    @Deprecated
    public void setOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f25908d.setOnMapClickListener(onMapClickListener);
    }

    public void addOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f25908d.addOnMapClickListener(onMapClickListener);
    }

    public void removeOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f25908d.removeOnMapClickListener(onMapClickListener);
    }

    public void clearOnMapClickListener() {
        this.f25908d.clearOnMapClickListener();
    }

    public void setOnMapLongClickListener(DidiMap.OnMapLongClickListener onMapLongClickListener) {
        this.f25908d.setOnMapLongClickListener(onMapLongClickListener);
    }

    public void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f25920p.setOnMyLocationChangeListener(onMyLocationChangeListener);
    }

    public void setOnCompassClickedListener(DidiMap.OnCompassClickedListener onCompassClickedListener) {
        this.f25908d.setOnCompassClickedListener(onCompassClickedListener);
    }

    public void setOnMapLoadedCallback(DidiMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f25908d.setOnMapLoadedCallback(onMapLoadedCallback);
    }

    public void getScreenShot(Handler handler, Bitmap.Config config) {
        this.f25908d.getScreenShot(handler, config);
    }

    public String getCityName(LatLng latLng) {
        return this.f25908d.getCityName(latLng);
    }

    public void addMapGestureListener(MapGestureListener mapGestureListener) {
        this.f25908d.addMapGestureListener(mapGestureListener);
    }

    public void removeMapGestureListener(MapGestureListener mapGestureListener) {
        this.f25908d.removeMapGestureListener(mapGestureListener);
    }

    public void addMapAllGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f25908d.addMapAllGestureListener(mapAllGestureListener);
    }

    public void removeMapGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f25908d.removeMapAllGestureListener(mapAllGestureListener);
    }

    public void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f) {
        this.f25908d.setVecEnlargeVisibleArea(i, i2, i3, i4, f);
    }

    public float calcuteZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return this.f25908d.calcuteZoomToSpanLevel(i, i2, i3, i4, latLng, latLng2, latLng3);
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        return this.f25908d.calculateZoomToSpanLevel(list, list2, i, i2, i3, i4);
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4, LatLng latLng) {
        return this.f25908d.calculateZoomToSpanLevel(list, list2, i, i2, i3, i4, latLng);
    }

    public CameraPosition calculateCameraPosition(List<IMapElement> list, List<LatLng> list2, List<DidiMap.ViewBounds> list3, int i, int i2, int i3, int i4) {
        return this.f25908d.calculateCameraPosition(list, list2, list3, new Rect(i, i2, i3, i4));
    }

    public float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z) {
        return this.f25908d.calNaviLevel(latLngBounds, f, i, z);
    }

    public float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z) {
        return this.f25908d.calNaviLevel2(latLng, latLng2, f, f2, i, i2, z);
    }

    public float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z, float f3) {
        return this.f25908d.calNaviLevel3(latLng, latLng2, f, f2, i, i2, z, f3);
    }

    public void setNaviFixingProportion(float f, float f2) {
        this.f25908d.setNaviFixingProportion(f, f2);
    }

    public void setNaviFixingProportion2D(float f, float f2) {
        this.f25908d.setNaviFixingProportion2D(f, f2);
    }

    public void setMapScreenCenterProportion(float f, float f2) {
        this.f25908d.setMapScreenCenterProportion(f, f2, true);
    }

    public void setMapScreenCenterProportion(float f, float f2, boolean z) {
        this.f25908d.setMapScreenCenterProportion(f, f2, z);
    }

    public String getVersion() {
        return this.f25908d.getVersion();
    }

    public boolean isDestroyed() {
        return this.f25927w;
    }

    public void setDrawPillarWith2DStyle(boolean z) {
        if (z) {
            this.f25908d.setDrawPillarWith2DStyle(z);
        }
    }

    public void setPillarVisible(boolean z) {
        setDrawPillarWith2DStyle(!z);
    }

    public void setScaleCenter(float f, float f2) {
        this.f25908d.setScaleCenter(f, f2);
    }

    public void setMapCenterAndScale(float f, float f2, float f3) {
        this.f25908d.setMapCenterAndScale(f, f2, f3);
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) {
        return this.f25915k.addMaskLayer(maskLayerOptions);
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        this.f25908d.setMapPadding(i, i2, i3, i4, true);
    }

    @Deprecated
    public void setMapPadding(int i, int i2, int i3, int i4, boolean z) {
        this.f25908d.setMapPadding(i, i2, i3, i4, false);
    }

    public void setCompassMarkerHidden(boolean z) {
        this.f25921q.setCompassEnabled(!z);
    }

    public Rect getMapPadding() {
        return this.f25908d.getMapPadding();
    }

    public List<LatLng> getBounderPoints(Marker marker) {
        if (marker == null) {
            return null;
        }
        return this.f25909e.getBounderPoints(marker.getId());
    }

    public float getLocationRadius(double d, LatLng latLng) {
        if (latLng != null) {
            return (float) (d / getProjection().metersPerPixel(latLng.latitude));
        }
        return 0.0f;
    }

    public List<LatLng> getInfoWindowBoderPoints(Marker marker) {
        if (marker == null) {
            return null;
        }
        return this.f25909e.getInfoWindowBoderPoints(marker.getId());
    }

    public void setMapMode() {
        this.f25908d.setMapMode();
    }

    public int getMapMode() {
        return this.f25908d.getMapMode();
    }

    public void setTrafficEnabled(boolean z) {
        this.f25908d.setTrafficEnabled(z);
    }

    public void switchTrafficDrawer(boolean z) {
        this.f25918n.switchOnOff(this.f25906a, z);
        this.f25906a = z;
    }

    public boolean removeTrafficIcon(long j, int i, double d) {
        if (this.f25906a) {
            return this.f25918n.removeTrafficIcon(j, i, d);
        }
        return false;
    }

    public void refeshTrafficIcon(List<Long> list) {
        if (this.f25906a) {
            this.f25918n.refeshTrafficIcon(list);
        }
    }

    public void showTrafficIconRadar(long j, MapTrafficIcon mapTrafficIcon, int i) {
        if (this.f25906a) {
            this.f25918n.showTrafficIconRadar(j, mapTrafficIcon, i);
        }
    }

    public boolean isNight() {
        return this.f25908d.isNight();
    }

    public void setAllTrafficIconVisible(boolean z) {
        this.f25918n.setAllTrafficIconVisible(z, this.f25906a);
    }

    public void setLanguage(int i) {
        this.f25908d.setLanguage(i);
    }

    public int getLanguage() {
        return this.f25908d.getLanguage();
    }

    public void setTheme(int i) {
        this.f25908d.setTheme(i);
    }

    public int getTheme() {
        return this.f25908d.getTheme();
    }

    public int getWidth() {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            return mapHost.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            return mapHost.getHeight();
        }
        return 0;
    }

    public void clearActions() {
        this.f25908d.stopAnimation();
    }

    public void setZoomInTapCenterSwitch(boolean z) {
        this.f25908d.setZoomInByCenter(z);
    }

    public void setZoomOutTapCenterSwitch(boolean z) {
        this.f25908d.setZoomOutByCenter(z);
    }

    public float getScreenCenterX() {
        return this.f25908d.getScreenCenterX();
    }

    public float getScreenCenterY() {
        return this.f25908d.getScreenCenterY();
    }

    @Deprecated
    public int getCurScaleLevel() {
        return (int) this.f25908d.getScaleLevel();
    }

    public DidiMap.OnLableMarkerCallback getLableMarkerCallback() {
        return this.f25923s;
    }

    public boolean isShowTrafficEvent() {
        if (this.f25906a) {
            return this.f25918n.isShowTrafficEvent();
        }
        return this.f25908d.isShowTrafficEvent();
    }

    public boolean isShowFakeTrafficEvent() {
        if (this.f25906a) {
            return this.f25918n.isShowFakeTrafficEvent();
        }
        return this.f25908d.isShowFakeTrafficEvent();
    }

    public void setShowFakeTrafficEvent(boolean z) {
        if (this.f25906a) {
            this.f25918n.setShowFakeTrafficEvent(z);
        }
        this.f25908d.setShowFakeTrafficEvent(z);
    }

    public void setShowTrafficEvent(boolean z) {
        if (this.f25906a) {
            this.f25918n.setShowTrafficEvent(z);
        }
        this.f25908d.setShowTrafficEvent(z);
    }

    public void addScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        this.f25908d.addScaleChangedListener(onMapScaleChangedListener);
    }

    public void removeScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        this.f25908d.removeScaleChangedListener(onMapScaleChangedListener);
    }

    public List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo() {
        if (this.f25906a) {
            return this.f25918n.getTrafficEventRoutePointInfo();
        }
        return this.f25908d.getTrafficEventRoutePointInfo();
    }

    public List<TrafficEventRoutePoint> getTrafficEventsPointInfo() {
        if (this.f25906a) {
            return this.f25918n.getTrafficEventsPointInfo();
        }
        return this.f25908d.getTrafficEventsPointInfo();
    }

    public byte[] genVecEnlargePNGImage(byte[] bArr, long j) {
        if (bArr == null || j == 0) {
            return null;
        }
        return this.f25908d.genVecEnlargePNGImage(bArr, j);
    }

    public boolean setVecEnlargeData(String str, byte[] bArr, long j) {
        if (j == 0) {
            return false;
        }
        return this.f25908d.setVecEnlargeData(str, bArr, j);
    }

    public boolean setVecEnlargeIsVisible(String str, boolean z) {
        return this.f25908d.setVecEnlargeIsVisible(str, z);
    }

    public boolean destroyNewVecEnlarge(String str) {
        return this.f25908d.destroyNewVecEnlarge(str);
    }

    public void destroyAllVecEnlarge() {
        this.f25908d.destroyAllVecEnlarge();
    }

    public void setRenderPerformance(final DidiMapExt.RenderPerformance renderPerformance) {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            mapHost.setRenderProfile(new RenderProfile() {
                public int getSlowRenderInterval() {
                    return 200;
                }

                public void onSlowRender(long j, long j2, long j3) {
                }

                public void onFrame(long j, long j2, long j3) {
                    renderPerformance.onFrameFinish(j);
                }
            });
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        return getProjection().toScreenLocation(latLng);
    }

    public void setTrafficEventData(final byte[] bArr) {
        if (!SystemUtil.isUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    HWDidiMap.this.f25918n.setNewestTrafficEventData(bArr);
                    if (HWDidiMap.this.f25906a) {
                        HWDidiMap.this.f25918n.setTrafficEventData(bArr);
                    } else {
                        HWDidiMap.this.f25908d.setTrafficEventData(bArr);
                    }
                }
            });
            return;
        }
        this.f25918n.setNewestTrafficEventData(bArr);
        if (this.f25906a) {
            this.f25918n.setTrafficEventData(bArr);
        } else {
            this.f25908d.setTrafficEventData(bArr);
        }
    }

    public void clearTrafficEventData() {
        if (!SystemUtil.isUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    HWDidiMap.this.f25918n.clearTrafficEventData();
                    HWDidiMap.this.f25908d.clearTrafficEventData();
                }
            });
            return;
        }
        this.f25918n.clearTrafficEventData();
        this.f25908d.clearTrafficEventData();
    }

    public void setExtendEventData(byte[] bArr) {
        this.f25908d.setExtendEventData(bArr);
    }

    public void setExtendIconVisible(long j, boolean z) {
        this.f25908d.setExtendIconVisible(j, z);
    }

    public void setExtendIconVisible(boolean z) {
        this.f25908d.setExtendIconVisible(z);
    }

    public int getRenderExtendIconNumber() {
        return this.f25908d.getRenderExtendIconNumber();
    }

    public void setPoiHidden(int i, LatLng latLng, boolean z) {
        this.f25908d.setPoiHidden(i, latLng, z);
    }

    public void setPoiHidden(BigInteger bigInteger, boolean z) {
        this.f25908d.setPoiHidden(bigInteger, z);
    }

    public void showHiddenPoi() {
        this.f25908d.showHiddenPoi();
    }

    public CollisionGroup addCollisionGroup(CollisionGroupOption collisionGroupOption) {
        return this.f25917m.addCollisionGroup(collisionGroupOption);
    }

    public void showRestrictArea(byte[] bArr) {
        this.f25908d.setExtendEventData(bArr);
        this.f25908d.setRestrictAreaVisible(true);
    }

    public void hideRestrictArea() {
        this.f25908d.setRestrictAreaVisible(false);
    }

    /* renamed from: a */
    private void m20488a(Runnable runnable) {
        this.f25926v.post(runnable);
    }

    public void setNavigationLineMargin(float f, float f2, float f3, float f4) {
        this.f25908d.setNavigationLineMargin(f, f2, f3, f4);
    }

    public void setRouteNameVisible(boolean z) {
        this.f25908d.setRouteNameVisible(z);
    }

    public void clearRouteNameSegments() {
        this.f25908d.clearRouteNameSegments();
    }

    public void deleteRouteNameSegments(long j) {
        this.f25908d.deleteRouteNameSegments(j);
    }

    public int getmPaddingLeft() {
        return this.f25908d.getMapPadding().left;
    }

    public int getmPaddingTop() {
        return this.f25908d.getMapPadding().top;
    }

    public int getmPaddingRight() {
        return this.f25908d.getMapPadding().right;
    }

    public int getmPaddingBottom() {
        return this.f25908d.getMapPadding().bottom;
    }

    public void addRouteNameSegmentsForMultiRouteBubble(List<RouteSectionWithName> list, long j, List<LatLng> list2, int i, int i2, String str, String str2, int i3, int i4) {
        this.f25908d.addMultipleRouteNameSegments(list, j, list2, i, i2, str, str2, i3, i4);
    }

    public void addSpecialBubble(List<RouteSectionWithName> list, List<LatLng> list2, long j, int i) {
        HWLog.m20433i("hw", "addSpecialBubble " + j + " type: " + i);
        this.f25908d.addSpecialBubble(list, list2, j, i);
    }

    public void updateSpecialBubble(List<RouteSectionWithName> list, long j) {
        this.f25908d.updateSpecialBubble(list, j);
    }

    public void removeSpecialBubble(long j) {
        HWLog.m20433i("hw", "removeSpecialBubble " + j);
        this.f25908d.removeSpecialBubble(j);
    }

    public void deleteSpecialBubbleWithType(int i) {
        HWLog.m20433i("hw", "deleteSpecialBubbleWithType " + i);
        this.f25908d.deleteSpecialBubbleWithType(i);
    }

    public void addBubble(Bubble bubble) {
        this.f25908d.addBubble(bubble);
    }

    public void removeBubble(long j) {
        this.f25908d.removeBubble(j);
    }

    public void removeRemoteBubble(long j) {
        this.f25908d.removeRemoteBubble(j);
    }

    public void updateBubble(Bubble bubble) {
        this.f25908d.updateBubble(bubble);
    }

    public void handleBubbleCollision() {
        this.f25908d.handleBubbleCollision();
    }

    public void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2) {
        this.f25908d.setBlockInfo(i, j, list, list2);
    }

    public float getMapScaleLevel() {
        return this.f25908d.getScaleLevel();
    }

    public float getMapRotate() {
        return this.f25908d.getRotate();
    }

    public void updateLocalTrafficIcon(final TrafficEventModel[] trafficEventModelArr) {
        m20488a((Runnable) new Runnable() {
            public void run() {
                if (HWDidiMap.this.f25906a) {
                    HWDidiMap.this.f25918n.updateLocalTrafficIcon(trafficEventModelArr);
                } else {
                    HWDidiMap.this.f25908d.updateLocalTrafficIcon(trafficEventModelArr);
                }
            }
        });
    }

    public DoublePoint toScreentLocation(GeoPoint geoPoint) {
        Point screenLocation = getProjection().toScreenLocation(new LatLng((((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d, (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d));
        if (screenLocation == null) {
            return null;
        }
        return new DoublePoint((double) screenLocation.x, (double) screenLocation.y);
    }

    public void onDestroy() {
        this.f25918n.release();
        TrafficEventManager.getInstance().delObserver(this.f25928x);
        removeBubbleListener();
        this.f25909e.setBubbleManager((BubbleManager) null);
        this.f25907c.clear();
        this.f25923s.destroy();
        BubbleManager bubbleManager = this.f25905A;
        if (bubbleManager != null) {
            bubbleManager.onDestory();
        }
        this.f25920p.exit();
        this.f25908d.onDestroy();
        this.f25919o.clear();
        this.f25926v.removeCallbacksAndMessages((Object) null);
        this.f25927w = true;
    }

    public void setOnTop(boolean z) {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            mapHost.setZOrderMediaOverlay(true);
        }
    }

    public MapView getMapView() {
        MapView mapView;
        WeakReference<MapView> weakReference = this.f25922r;
        if (weakReference == null || (mapView = (MapView) weakReference.get()) == null) {
            return null;
        }
        return mapView;
    }

    public LatLng getRouteArrowFurthestPoint() {
        return this.f25908d.getRouteArrowFurthestPoint();
    }

    public LatLng getVehicleMarkerLocation() {
        return this.f25911g.getLocator().getPosition();
    }

    public void setMapElementClickListener(OnMapElementClickListener onMapElementClickListener) {
        this.f25908d.setMapElementClickListener(onMapElementClickListener);
    }

    public OnMapElementClickListener getMapElementClickListener() {
        return this.f25908d.getMapElementClickListener();
    }

    public void updateTrafficItemShowState(long j, int i, boolean z) {
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        m20488a((Runnable) new Runnable() {
            public void run() {
                if (HWDidiMap.this.f25906a) {
                    HWDidiMap.this.f25918n.updateTrafficItemState(j2, i2, z2);
                } else {
                    HWDidiMap.this.f25908d.updateTrafficItemState(j2, i2, z2);
                }
            }
        });
    }

    public MarkerView addMarkerView(View view, LatLng latLng) {
        return this.f25925u.add(view, latLng);
    }

    public void setFPS(int i) {
        this.f25908d.setFps(i);
    }

    public void setFpsMode(int i) {
        this.f25908d.setFpsMode(i);
    }

    public void showTrafficEvent(boolean z) {
        this.f25908d.showTrafficEvent(z);
    }

    public void setZhongYanEventData(byte[] bArr, long j) {
        this.f25908d.setZhongYanEventData(bArr, j);
    }

    public void setUseLowMemoryMode(boolean z) {
        this.f25908d.setUseLowMemoryMMode(z);
    }

    public void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener) {
        this.f25908d.setSurfaceChangeListener(surfaceChangeListener);
    }

    public void setDisplayFishBoneGrayBubbleOnly(boolean z) {
        this.f25908d.setDisplayFishBoneGrayBubbleOnly(z);
    }

    public void addOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f25908d.addOnCameraChangeListener(onCameraChangeListener);
    }

    public void removeOnCameraChangedListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f25908d.removeOnCameraChangedListener(onCameraChangeListener);
    }

    public void setMJOEnabled(boolean z) {
        this.f25908d.setMJOEnabled(z);
    }

    public ArrayList<LatLng> loadMJOAndGetBindRoute(long j, int i, DidiMapExt.MJOListener mJOListener, byte[] bArr, List<DidiMapExt.MJOLinkInfo> list, long j2) {
        return this.f25908d.loadMJOAndGetBindRoute(j, i, mJOListener, bArr, list, j2);
    }

    public void setBlockEventListener(DidiMapExt.BlockEventListener blockEventListener) {
        this.f25908d.setBlockEventListener(blockEventListener);
    }

    public void showMJO() {
        this.f25908d.showMJO();
    }

    public void hideMJO(boolean z) {
        this.f25908d.hideMJO(z);
    }

    public void clearMJORouteInfo() {
        this.f25908d.clearMJORouteInfo();
    }

    public void setClipArea(int i) {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            this.f25908d.setClipArea(i, mapHost.getWidth(), mapHost.getHeight());
        }
    }

    public void setBubbleLoadBitmapListener(DidiMapExt.BubbleLoadBitmapListener bubbleLoadBitmapListener) {
        this.f25930z = bubbleLoadBitmapListener;
    }

    public void setBubbleEdgePadding(float f) {
        HWLog.m20433i("setBubbleEdgePadding", "paddingTop = " + f);
        this.f25908d.setBubbleEdgePadding(f);
    }

    public void removeBubbleListener() {
        this.f25930z = null;
    }

    public BubbleManager getBubbleManager() {
        return this.f25905A;
    }

    public void hibernate() {
        this.f25908d.hibernate();
    }

    public GLInstrumentation getInstrumentation() {
        MapHost mapHost = (MapHost) this.f25919o.get();
        if (mapHost != null) {
            return mapHost.getGLViewManage().getGLInstrumentation();
        }
        return null;
    }

    public MapAccessManager getAccessManager() {
        return this.f25924t;
    }

    public void setIsInternationalWMS(boolean z) {
        MapView mapView;
        int isInternationalWMS = this.f25908d.setIsInternationalWMS(z);
        WeakReference<MapView> weakReference = this.f25922r;
        if (weakReference != null && (mapView = (MapView) weakReference.get()) != null) {
            mapView.showLogoForInternationalWms(isInternationalWMS);
        }
    }

    public void setAnnotationShowLight(boolean z) {
        this.f25908d.setAnnotationShowLight(z);
    }

    public void setAboardPointJson(String str) {
        this.f25908d.setAboardPointJson(str);
    }

    public void setPoiMarkerRect(Rect[] rectArr) {
        this.f25908d.setPoiMarkerRect(rectArr);
    }

    public void setVioParkingRegionData(byte[] bArr, int i) {
        this.f25908d.setVioParkingRegionData(bArr, i);
    }
}
