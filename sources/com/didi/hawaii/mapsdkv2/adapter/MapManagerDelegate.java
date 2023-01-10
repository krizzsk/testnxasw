package com.didi.hawaii.mapsdkv2.adapter;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.BaseMapAllGestureListener;
import com.didi.hawaii.mapsdkv2.core.Camera;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.RouteName;
import com.didi.hawaii.mapsdkv2.core.overlay.GLRoute;
import com.didi.hawaii.mapsdkv2.widget.MapWidgets;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.CamerParameter;
import com.didi.map.alpha.maps.internal.IMapControlDelegate;
import com.didi.map.alpha.maps.internal.IProjectionDelegate;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.common.TrafficEventManager;
import com.didi.map.constant.StringConstant;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.map.core.base.OnMapStabledListener;
import com.didi.map.core.base.impl.OnMapModeListener;
import com.didi.map.core.element.MapAnnotation;
import com.didi.map.core.element.MapExtendIcon;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.CameraUpdate;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.map.Projection;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Locator;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.OutBlockInfo;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.VisibleRegion;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MapManagerDelegate extends C9761b implements IMapControlDelegate {
    public static final int DEFAULT_ANIMATION_DURATION = 500;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final GLBaseMapView f25964b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MapAllGestureListenerList f25965c;

    /* renamed from: d */
    private final MapListenerWrapper f25966d;

    /* renamed from: e */
    private final MapWidgets f25967e;

    /* renamed from: f */
    private final BaseMapAllGestureListener f25968f = new BaseMapAllGestureListener() {
        public boolean onDoubleTap(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onDoubleTap(f, f2);
        }

        public boolean onSingleTap(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onSingleTap(f, f2);
        }

        public boolean onFling(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onFling(f, f2);
        }

        public boolean onScroll(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onScroll(f, f2);
        }

        public boolean onLongPress(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onLongPress(f, f2);
        }

        public boolean onDown(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onDown(f, f2);
        }

        public boolean onUp(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onUp(f, f2);
        }

        public boolean onMove(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onMove(f, f2);
        }

        public boolean onDoubleTapDown(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onDoubleTapDown(f, f2);
        }

        public boolean onDoubleTapMove(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onDoubleTapMove(f, f2);
        }

        public boolean onDoubleTapUp(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onDoubleTapUp(f, f2);
        }

        public boolean onTwoFingerSingleTap(float f, float f2) {
            return MapManagerDelegate.this.f25965c.onTwoFingerSingleTap(f, f2);
        }

        public boolean onTwoFingerDown() {
            return MapManagerDelegate.this.f25965c.onTwoFingerDown();
        }

        public boolean onTwoFingerUp() {
            return MapManagerDelegate.this.f25965c.onTwoFingerUp();
        }

        public boolean onTwoFingerMoveVertical(float f) {
            return MapManagerDelegate.this.f25965c.onTwoFingerMoveVertical(f);
        }

        public boolean onTwoFingerMoveHorizontal(float f) {
            return MapManagerDelegate.this.f25965c.onTwoFingerMoveHorizontal(f);
        }

        public boolean onTwoFingerRotate(PointF pointF, PointF pointF2, float f) {
            return MapManagerDelegate.this.f25965c.onTwoFingerRotate(pointF, pointF2, f);
        }

        public boolean onTwoFingerMoveAgainst(PointF pointF, PointF pointF2, double d, double d2) {
            return MapManagerDelegate.this.f25965c.onTwoFingerMoveAgainst(pointF, pointF2, d, d2);
        }
    };

    /* renamed from: g */
    private boolean f25969g = true;

    /* renamed from: h */
    private boolean f25970h = true;

    /* renamed from: a */
    private float m20517a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, float f4, boolean z, boolean z2) {
    }

    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    public void animateToNaviPosition(LatLng latLng, float f, float f2, boolean z) {
    }

    public void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    public List<Rect> getElementScreenBound(List<String> list) {
        return null;
    }

    public int getMapType() {
        return 0;
    }

    public String getVersion() {
        return StringConstant.MAP_VERSION;
    }

    public void onDestroy() {
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

    public void setCompassExtraPadding(int i) {
    }

    public void setCompassExtraPadding(int i, int i2) {
    }

    public void setInfoWindowStillVisible(boolean z) {
    }

    public void setMapMode() {
    }

    public void setMapType() {
    }

    public void setNaviCenter(int i, int i2) {
    }

    public void setOnCompassClickedListener(DidiMap.OnCompassClickedListener onCompassClickedListener) {
    }

    public void setOnLableMarkerCallback(DidiMap.OnLableMarkerCallback onLableMarkerCallback) {
    }

    public void setSatelliteEnabled(boolean z) {
    }

    public void setScaleCenter(float f, float f2) {
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2, float f) {
    }

    public MapManagerDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map, MapWidgets mapWidgets) {
        super(gLViewManager, map);
        this.f25967e = mapWidgets;
        this.f25964b = gLViewManager.getBaseMap();
        this.f25965c = new MapAllGestureListenerList();
        this.f25964b.setMapGestureListener(this.f25968f);
        MapListenerWrapper mapListenerWrapper = new MapListenerWrapper();
        this.f25966d = mapListenerWrapper;
        MapAllGestureListenerList unused = mapListenerWrapper.allGestureListeners = this.f25965c;
        this.f25964b.setGLBaseCallBack(this.f25966d.mCallBack);
    }

    public CameraPosition getCameraPosition() {
        return m20522a(this.f25964b.getCamera());
    }

    public void setMaxSkew(float f) {
        this.f25964b.setMaxSkew(f);
    }

    public float getMaxSkew() {
        return this.f25964b.getMaxSkew();
    }

    public Projection getProjection() {
        return new Projection(new IProjectionDelegate() {
            public LatLng fromScreenLocation(Point point) {
                LatLng fromScreen = MapManagerDelegate.this.f25964b.getProjection().fromScreen((float) point.x, (float) point.y);
                if (fromScreen == null) {
                    return null;
                }
                return fromScreen;
            }

            public Point toScreenLocation(LatLng latLng) {
                PointF screen = MapManagerDelegate.this.f25964b.getProjection().toScreen(latLng);
                if (screen == null) {
                    return new Point();
                }
                return new Point(Math.round(screen.x), Math.round(screen.y));
            }

            public VisibleRegion getVisibleRegion() {
                return MapManagerDelegate.this.f25964b.getProjection().getVisibleRegion();
            }

            public double metersPerPixel(double d) {
                return MathsUtils.metersPerPixel((double) MapManagerDelegate.this.f25964b.getScaleLevel(), d);
            }

            public DoublePoint toScreentLocation(GeoPoint geoPoint) {
                PointF screen = MapManagerDelegate.this.f25964b.getProjection().toScreen(DataUtil.toLatLng(geoPoint));
                if (screen == null) {
                    return null;
                }
                return new DoublePoint((double) screen.x, (double) screen.y);
            }
        });
    }

    public void setLanguage(int i) {
        this.f25964b.setLanguage(i);
    }

    public int getLanguage() {
        return this.f25964b.getLanguage();
    }

    public void setTheme(int i) {
        this.f25964b.setTheme(i);
    }

    public void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2) {
        this.f25964b.setBlockInfo(i, j, list, list2);
    }

    public int getTheme() {
        return this.f25964b.getTheme();
    }

    public void setModeNavi(boolean z) {
        this.f25964b.setModeNavi(z);
    }

    public void setModeNight(boolean z) {
        this.f25964b.setModeNight(z);
    }

    public void setTrafficEnabled(boolean z) {
        this.f25964b.setTrafficEnabled(z);
    }

    public void setRouteNameVisible(boolean z) {
        this.f25964b.setRouteNameVisible(z);
    }

    public void clearRouteNameSegments() {
        this.f25964b.clearRouteNameSegments();
    }

    public void deleteRouteNameSegments(long j) {
        this.f25964b.removeRouteName(j);
    }

    public void addMultipleRouteNameSegments(List<RouteSectionWithName> list, long j, List<LatLng> list2, int i, int i2, String str, String str2, int i3, int i4) {
        List<LatLng> list3 = list2;
        if (list == null || list.size() == 0) {
        } else if (list3 == null || list2.size() == 0) {
        } else {
            RouteName[] routeNameArr = new RouteName[list.size()];
            for (int i5 = 0; i5 < list.size(); i5++) {
                RouteSectionWithName routeSectionWithName = list.get(i5);
                routeNameArr[i5] = new RouteName(routeSectionWithName.startNum, routeSectionWithName.endNum, routeSectionWithName.color, routeSectionWithName.roadName);
            }
            int size = list2.size();
            LatLng[] latLngArr = new LatLng[size];
            for (int i6 = 0; i6 < size; i6++) {
                latLngArr[i6] = new LatLng(list3.get(i6));
            }
            this.f25964b.addMultipleRouteNameSegments(j, routeNameArr, latLngArr, i, i2, str, str2, i3, i4);
        }
    }

    public void addSpecialBubble(List<RouteSectionWithName> list, List<LatLng> list2, long j, int i) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            RouteName[] routeNameArr = new RouteName[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                RouteSectionWithName routeSectionWithName = list.get(i2);
                routeNameArr[i2] = new RouteName(routeSectionWithName.startNum, routeSectionWithName.endNum, routeSectionWithName.color, routeSectionWithName.roadName);
            }
            int size = list2.size();
            LatLng[] latLngArr = new LatLng[size];
            for (int i3 = 0; i3 < size; i3++) {
                latLngArr[i3] = new LatLng(list2.get(i3));
            }
            this.f25964b.addSpecialBubble(routeNameArr, latLngArr, j, i);
        }
    }

    public void updateSpecialBubble(List<RouteSectionWithName> list, long j) {
        if (list != null && list.size() != 0) {
            RouteName[] routeNameArr = new RouteName[list.size()];
            for (int i = 0; i < list.size(); i++) {
                RouteSectionWithName routeSectionWithName = list.get(i);
                routeNameArr[i] = new RouteName(routeSectionWithName.startNum, routeSectionWithName.endNum, routeSectionWithName.color, routeSectionWithName.roadName);
            }
            this.f25964b.updateSpecialBubble(routeNameArr, j);
        }
    }

    public void removeSpecialBubble(long j) {
        this.f25964b.removeSpecialBubble(j);
    }

    public void deleteSpecialBubbleWithType(int i) {
        this.f25964b.deleteSpecialBubbleWithType(i);
    }

    public void addBubble(Bubble bubble) {
        this.f25964b.addBubble(bubble);
    }

    public void removeBubble(long j) {
        this.f25964b.removeBubble(j);
    }

    public void removeRemoteBubble(long j) {
        this.f25964b.removeRemoteBubble(j);
    }

    public void updateBubble(Bubble bubble) {
        this.f25964b.updateBubble(bubble);
    }

    public void handleBubbleCollision() {
        this.f25964b.handleBubbleCollision();
    }

    public LatLng getRouteArrowFurthestPoint() {
        LatLng calculateRoute3DArrowFurthestPoint = this.f25964b.calculateRoute3DArrowFurthestPoint();
        if (calculateRoute3DArrowFurthestPoint != null) {
            return calculateRoute3DArrowFurthestPoint;
        }
        return new LatLng(-1.0d, -1.0d);
    }

    public void setFps(int i) {
        this.viewManager.setFps(i);
    }

    public void setFpsMode(int i) {
        this.viewManager.setFpsMode(i);
    }

    public void setDisplayFishBoneGrayBubbleOnly(boolean z) {
        this.f25964b.showFishBoneGrayBubbleOnly(z);
    }

    public void showTrafficEvent(boolean z) {
        this.f25964b.showTrafficEvent(z);
    }

    public void setZhongYanEventData(byte[] bArr, long j) {
        this.f25964b.setZhongYanEventData(bArr, j);
    }

    public void setUseLowMemoryMMode(boolean z) {
        this.f25964b.setUseLowMemoryMode(z);
    }

    public void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener) {
        this.f25964b.setSurfaceChangeListener(surfaceChangeListener);
    }

    public void setClipArea(int i, int i2, int i3) {
        this.f25964b.setClipArea(i, i2, i3);
    }

    public void hibernate() {
        this.f25964b.hibernate();
    }

    public void setShowFakeTrafficEvent(boolean z) {
        this.f25970h = z;
    }

    public boolean isShowFakeTrafficEvent() {
        return this.f25970h;
    }

    public void setShowTrafficEvent(boolean z) {
        this.f25969g = z;
        if (!z) {
            this.f25964b.clearTrafficLocalIcons();
        }
    }

    public boolean isShowTrafficEvent() {
        return this.f25969g;
    }

    public void setTrafficEventData(byte[] bArr) {
        if (this.f25969g) {
            this.f25964b.setTrafficEventData(bArr);
        }
    }

    public void hideTrafficEventExcludeClosure(boolean z) {
        if (this.f25969g) {
            this.f25964b.hideTrafficEventExcludeClosure(z);
        }
    }

    public void clearTrafficEventData() {
        if (this.f25969g) {
            this.f25964b.clearTrafficEventData();
        }
    }

    public void setExtendEventData(byte[] bArr) {
        this.f25964b.setExtendEventData(bArr);
    }

    public void setExtendIconVisible(long j, boolean z) {
        this.f25964b.setExtendIconVisible(j, z);
    }

    public void setExtendIconVisible(boolean z) {
        this.f25964b.setExtendIconVisible(z);
    }

    public int getRenderExtendIconNumber() {
        return this.f25964b.getRenderExtendIconNumber();
    }

    public void setPoiHidden(int i, LatLng latLng, boolean z) {
        this.f25964b.setPoiHidden(i, latLng, z);
    }

    public void setPoiHidden(BigInteger bigInteger, boolean z) {
        this.f25964b.setPoiHidden(bigInteger, z);
    }

    public void showHiddenPoi() {
        this.f25964b.showHiddenPoi();
    }

    public void setRestrictAreaVisible(boolean z) {
        this.f25964b.setRestrictAreaVisible(z);
    }

    public void setMJOEnabled(boolean z) {
        this.f25964b.setMJOEnabled(z);
    }

    public ArrayList<LatLng> loadMJOAndGetBindRoute(long j, int i, DidiMapExt.MJOListener mJOListener, byte[] bArr, List<DidiMapExt.MJOLinkInfo> list, long j2) {
        int size = list.size();
        long[] jArr = new long[size];
        int[] iArr = new int[size];
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            DidiMapExt.MJOLinkInfo mJOLinkInfo = list.get(i2);
            jArr[i2] = mJOLinkInfo.getLinkId();
            iArr[i2] = mJOLinkInfo.getDirection();
            dArr[i2] = mJOLinkInfo.getLinkDistance();
        }
        DidiMapExt.MJOListener unused = this.f25966d.mjoListener = mJOListener;
        LatLng[] loadMJOAndGetBindRoute = this.f25964b.loadMJOAndGetBindRoute(j, i, bArr, jArr, iArr, dArr, size, j2);
        if (loadMJOAndGetBindRoute != null) {
            return new ArrayList<>(Arrays.asList(loadMJOAndGetBindRoute));
        }
        return null;
    }

    public void setBlockEventListener(DidiMapExt.BlockEventListener blockEventListener) {
        DidiMapExt.BlockEventListener unused = this.f25966d.blockEventListener = blockEventListener;
    }

    public void setVioParkingRegionData(byte[] bArr, int i) {
        this.f25964b.setVioParkingRegionData(bArr, i);
    }

    public void showMJO() {
        this.f25964b.showMJO();
    }

    public void hideMJO(boolean z) {
        this.f25964b.hideMJO(z);
    }

    public void clearMJORouteInfo() {
        this.f25964b.clearMJORouteInfo();
    }

    public void setBubbleEdgePadding(float f) {
        this.f25964b.setBubbleEdgePadding(f);
    }

    public void clearAll() {
        C9761b.m20575a(this.f26017a, this.viewManager);
    }

    public void updateLocalTrafficIcon(TrafficEventModel[] trafficEventModelArr) {
        if (trafficEventModelArr == null) {
            trafficEventModelArr = new TrafficEventModel[0];
        }
        this.f25964b.updateLocalTrafficIcon(trafficEventModelArr);
    }

    public void updateTrafficItemState(long j, int i, boolean z) {
        this.f25964b.updateTrafficItemState(BigInteger.valueOf(j), (short) i, z);
    }

    public List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo() {
        return this.f25964b.getTrafficEventRoutePointInfo();
    }

    public List<TrafficEventRoutePoint> getTrafficEventsPointInfo() {
        return this.f25964b.getTrafficEventsPointInfo();
    }

    public byte[] genVecEnlargePNGImage(byte[] bArr, long j) {
        return this.f25964b.genVecEnlargePNGImage(bArr, j);
    }

    public boolean setVecEnlargeData(String str, byte[] bArr, long j) {
        return this.f25964b.setVecEnlargeData(str, bArr, j);
    }

    public boolean setVecEnlargeIsVisible(String str, boolean z) {
        return this.f25964b.setVecEnlargeIsVisible(str, z);
    }

    public boolean destroyNewVecEnlarge(String str) {
        return this.f25964b.destroyNewVecEnlarge(str);
    }

    public void destroyAllVecEnlarge() {
        this.f25964b.destroyAllVecEnlarge();
    }

    public void setTrafficColor(int i, int i2, int i3, int i4) {
        this.f25964b.setTrafficColors(i, i3, i2, i4);
    }

    public void setCenter(LatLng latLng) {
        this.f25964b.setCenter(latLng);
    }

    public int getMapMode() {
        return this.f25964b.getMapMode();
    }

    public void setDrawPillarWith2DStyle(boolean z) {
        this.f25964b.setDrawPillarWith2DStyle(z);
    }

    public int setIsInternationalWMS(boolean z) {
        return this.f25964b.setIsInternationalWMS(z);
    }

    public void setAnnotationShowLight(boolean z) {
        this.f25964b.setAnnotationShowLight(z);
    }

    public void setAboardPointJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f25964b.setAboardPointJson(str);
        }
    }

    public void setPoiMarkerRect(Rect[] rectArr) {
        if (rectArr != null && rectArr.length != 0) {
            this.f25964b.setPoiMarkerRect(rectArr);
        }
    }

    public void setZoomInByCenter(boolean z) {
        this.f25964b.setZoomInByTapCenter(z);
    }

    public void setZoomOutByCenter(boolean z) {
        this.f25964b.setZoomOutByTapCenter(z);
    }

    public float getMaxZoomLevel() {
        return (float) this.f25964b.getMaxScaleLevel();
    }

    public float getMinZoomLevel() {
        return (float) this.f25964b.getMinScaleLevel();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        m20524a(false, cameraUpdate, 500, (Animator.AnimatorListener) null);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, DidiMap.CancelableCallback cancelableCallback) {
        m20524a(true, cameraUpdate, j, m20519a(cancelableCallback));
    }

    public void stopAnimation() {
        this.f25964b.stopAnimation();
    }

    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return calcuteZoomToSpanLevel(0, 0, 0, 0, latLng, latLng2, (LatLng) null);
    }

    public void setNaviOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        DidiMap.OnPolylineClickListener unused = this.f25966d.naviOnPolylineClickListener = onPolylineClickListener;
    }

    public void setOnPolylineClickListenner(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        DidiMap.OnPolylineClickListener unused = this.f25966d.onPolylineClickListener = onPolylineClickListener;
    }

    public void setNaviOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        DidiMap.OnMapClickListener unused = this.f25966d.naviOnMapClickListener = onMapClickListener;
    }

    public void addScaleChangedListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        if (!this.f25966d.onMapScaleChangedListenerList.contains(onMapScaleChangedListener)) {
            this.f25966d.onMapScaleChangedListenerList.add(onMapScaleChangedListener);
        }
    }

    public void removeScaleChangedListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        if (this.f25966d.onMapScaleChangedListenerList.contains(onMapScaleChangedListener)) {
            this.f25966d.onMapScaleChangedListenerList.remove(onMapScaleChangedListener);
        }
    }

    public void setOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        DidiMap.OnMapClickListener unused = this.f25966d.mapClickListener = onMapClickListener;
    }

    public void addOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        if (this.f25966d.mapClickListenerList == null) {
            List unused = this.f25966d.mapClickListenerList = new ArrayList();
        }
        this.f25966d.mapClickListenerList.add(onMapClickListener);
    }

    public void removeOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        if (this.f25966d.mapClickListenerList != null) {
            this.f25966d.mapClickListenerList.remove(onMapClickListener);
        }
    }

    public void clearOnMapClickListener() {
        if (this.f25966d.mapClickListenerList != null) {
            this.f25966d.mapClickListenerList.clear();
        }
    }

    public void setOnMapLongClickListener(DidiMap.OnMapLongClickListener onMapLongClickListener) {
        DidiMap.OnMapLongClickListener unused = this.f25966d.mapLongClickListener = onMapLongClickListener;
    }

    public void setOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        DidiMap.OnCameraChangeListener unused = this.f25966d.cameraChangeListener = onCameraChangeListener;
    }

    public void addOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.f25966d.cameraChangeListenerList == null) {
            ArrayList unused = this.f25966d.cameraChangeListenerList = new ArrayList();
        }
        this.f25966d.cameraChangeListenerList.add(onCameraChangeListener);
    }

    public void removeOnCameraChangedListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        if (this.f25966d.cameraChangeListenerList != null) {
            this.f25966d.cameraChangeListenerList.remove(onCameraChangeListener);
        }
    }

    public void addModeListener(OnMapModeListener onMapModeListener) {
        if (this.f25966d.mapModeListeners == null) {
            ArrayList unused = this.f25966d.mapModeListeners = new ArrayList();
        }
        this.f25966d.mapModeListeners.add(onMapModeListener);
    }

    public void getScreenShot(Handler handler, Bitmap.Config config) {
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(0, this.f25964b.screenShots(config)));
        }
    }

    public String getCityName(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return this.f25964b.getCityName(latLng);
    }

    public void addMapGestureListener(MapGestureListener mapGestureListener) {
        this.f25965c.addSimpleMapListener(mapGestureListener);
    }

    public void removeMapGestureListener(MapGestureListener mapGestureListener) {
        this.f25965c.removeSimpleMapListener(mapGestureListener);
    }

    public void addMapAllGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f25965c.addAllMapListener(mapAllGestureListener);
    }

    public void removeMapAllGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f25965c.removeAllMapListener(mapAllGestureListener);
    }

    public void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f) {
        this.f25964b.setVecEnlargeVisibleArea(i, i2, i3, i4, f);
    }

    public void setRotateAngle(float f) {
        this.f25964b.setRotate(f);
    }

    public void setSkewAngle(float f) {
        this.f25964b.setSkew(f);
    }

    public void setTrafficEventIconCustomSize(int i) {
        this.f25964b.setTrafficEventIconCustomSize(i);
    }

    public void resetTrafficEventIconCustomSize() {
        this.f25964b.resetTrafficEventIconCustomSize();
    }

    public void setMapCenterAndScale(float f, float f2, float f3) {
        this.f25964b.setCenterOffset(f, f2);
        this.f25964b.setScale(f3);
    }

    public void setNaviFixingProportion(float f, float f2) {
        m20517a(f);
        m20517a(f2);
    }

    public void setNaviFixingProportion2D(float f, float f2) {
        m20517a(f);
        m20517a(f2);
    }

    public void setMapPadding(int i, int i2, int i3, int i4, boolean z) {
        this.f25964b.setMapPadding(i, i2, i3, i4);
        if (z) {
            int width = this.f25964b.getWidth();
            int height = this.f25964b.getHeight();
            GLBaseMapView gLBaseMapView = this.f25964b;
            gLBaseMapView.setCenterOffset((((float) (i + (((width - i) - i3) / 2))) * 1.0f) / ((float) width), (((float) (i2 + (((height - i2) - i4) / 2))) * 1.0f) / ((float) height));
        }
    }

    public void setNavigationLineMargin(float f, float f2, float f3, float f4) {
        this.f25964b.setNavigationLineMargin(f, f2, f3, f4);
    }

    public Rect getMapPadding() {
        return this.f25964b.getMapPadding();
    }

    public float getScreenCenterX() {
        return ((float) this.f25964b.getWidth()) * this.f25964b.getCenterOffsetX();
    }

    public float getScreenCenterY() {
        return ((float) this.f25964b.getHeight()) * this.f25964b.getCenterOffsetY();
    }

    public void setMapScreenCenterProportion(float f, float f2, boolean z) {
        this.f25964b.setCenterOffset(f, f2);
    }

    public void setMapElementClickListener(OnMapElementClickListener onMapElementClickListener) {
        OnMapElementClickListener unused = this.f25966d.mapElementClickListener = onMapElementClickListener;
    }

    public OnMapElementClickListener getMapElementClickListener() {
        return this.f25966d.mapElementClickListener;
    }

    public float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z) {
        calNaviLevel2(latLngBounds.southwest, latLngBounds.northeast, f, 0.0f, i, 0, z);
        return 0.0f;
    }

    public float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z) {
        calNaviLevel3(latLng, latLng2, f, f2, i, i2, z, 0.0f);
        return 0.0f;
    }

    public float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z, float f3) {
        float f4 = !z ? 0.0f : f;
        Context androidContext = this.f25964b.getMapContext().getAndroidContext();
        return m20518a(f2, f4, DisplayUtils.px2dip(androidContext, (float) i), DisplayUtils.px2dip(androidContext, (float) i2), latLng, latLng2);
    }

    /* renamed from: a */
    private float m20518a(float f, float f2, int i, int i2, LatLng latLng, LatLng latLng2) {
        return this.f25964b.calculateNavigationZoom(f, f2, (float) i, (float) i2, latLng, latLng2);
    }

    public float calcuteZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        Rect rect = new Rect(i, i3, i2, i4);
        Camera computeZoomToSpanTarget = this.f25964b.computeZoomToSpanTarget(new RectF((float) latLng.longitude, (float) latLng2.latitude, (float) latLng2.longitude, (float) latLng.latitude), rect);
        if (computeZoomToSpanTarget == null) {
            return 0.0f;
        }
        if (latLng3 != null) {
            latLng3.longitude = computeZoomToSpanTarget.getCenter().longitude;
            latLng3.latitude = computeZoomToSpanTarget.getCenter().latitude;
        }
        return computeZoomToSpanTarget.getScaleLevel();
    }

    public CameraPosition calculateCameraPosition(List<IMapElement> list, List<LatLng> list2, List<DidiMap.ViewBounds> list3, Rect rect) {
        Camera computeZoomToSpanTarget;
        ArrayList arrayList = new ArrayList();
        RectF rectF = new RectF();
        m20523a(list, list2, rectF, (List<IMapElement>) arrayList);
        boolean z = true;
        boolean z2 = Math.abs(rectF.width() / rectF.height()) <= 1.0f;
        Rect rect2 = new Rect();
        if (z2) {
            int width = this.f25964b.getWidth();
            int i = 0;
            int i2 = 0;
            for (DidiMap.ViewBounds next : list3) {
                Rect rect3 = next.getRect();
                int position = next.getPosition();
                if (position == DidiMap.ViewBounds.P_LEFT_TOP || position == DidiMap.ViewBounds.P_LEFT_BOTTOM) {
                    i = Math.max(i, rect3.right);
                } else if (position == DidiMap.ViewBounds.P_RIGHT_TOP || position == DidiMap.ViewBounds.P_RIGHT_BOTTOM) {
                    width = Math.min(width, rect3.left);
                } else if (position == DidiMap.ViewBounds.P_CENTER_TOP) {
                    i2 = Math.max(i2, rect3.bottom);
                }
            }
            rect2.left = i;
            rect2.top = i2;
            rect2.right = width;
            rect2.bottom = this.f25964b.getHeight();
        } else {
            int height = this.f25964b.getHeight();
            int i3 = 0;
            for (DidiMap.ViewBounds next2 : list3) {
                Rect rect4 = next2.getRect();
                int position2 = next2.getPosition();
                if (position2 == DidiMap.ViewBounds.P_LEFT_TOP || position2 == DidiMap.ViewBounds.P_RIGHT_TOP || position2 == DidiMap.ViewBounds.P_CENTER_TOP) {
                    i3 = Math.max(i3, rect4.bottom);
                } else if (position2 == DidiMap.ViewBounds.P_LEFT_BOTTOM || position2 == DidiMap.ViewBounds.P_RIGHT_BOTTOM) {
                    height = Math.min(height, rect4.top);
                }
            }
            rect2.left = 0;
            rect2.top = i3;
            rect2.right = this.f25964b.getWidth();
            rect2.bottom = height;
        }
        Rect rect5 = new Rect(Math.max(rect2.left, rect.left), Math.max(rect2.top, rect.top), Math.max(this.f25964b.getWidth() - rect2.right, rect.right), Math.max(this.f25964b.getHeight() - rect2.bottom, rect.bottom));
        HWLog.m20433i("MapManagerDelegate", "geoBoundRect=" + rectF + ", screenRect=" + rect2 + ",offsetRect=" + rect5 + ", edgeRect=" + rect);
        if (rectF.left == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f && rectF.top == 0.0f) {
            z = false;
        }
        Camera computeZoomToSpanTarget2 = z ? this.f25964b.computeZoomToSpanTarget(rectF, rect5) : null;
        if (arrayList.size() > 0 && (computeZoomToSpanTarget = this.f25964b.computeZoomToSpanTarget(computeZoomToSpanTarget2, rectF, rect5, (List<IMapElement>) arrayList)) != null) {
            return m20522a(computeZoomToSpanTarget);
        }
        if (computeZoomToSpanTarget2 != null) {
            return m20522a(computeZoomToSpanTarget2);
        }
        return null;
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        Camera computeZoomToSpanTarget;
        Rect rect = new Rect(i, i3, i2, i4);
        ArrayList arrayList = new ArrayList();
        RectF rectF = new RectF();
        m20523a(list, list2, rectF, (List<IMapElement>) arrayList);
        Camera computeZoomToSpanTarget2 = (rectF.left > 0.0f ? 1 : (rectF.left == 0.0f ? 0 : -1)) != 0 || (rectF.right > 0.0f ? 1 : (rectF.right == 0.0f ? 0 : -1)) != 0 || (rectF.bottom > 0.0f ? 1 : (rectF.bottom == 0.0f ? 0 : -1)) != 0 || (rectF.top > 0.0f ? 1 : (rectF.top == 0.0f ? 0 : -1)) != 0 ? this.f25964b.computeZoomToSpanTarget(rectF, rect) : null;
        if (arrayList.size() > 0 && (computeZoomToSpanTarget = this.f25964b.computeZoomToSpanTarget(computeZoomToSpanTarget2, rectF, rect, (List<IMapElement>) arrayList)) != null) {
            return m20522a(computeZoomToSpanTarget);
        }
        if (computeZoomToSpanTarget2 != null) {
            return m20522a(computeZoomToSpanTarget2);
        }
        return null;
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4, LatLng latLng) {
        Camera computeZoomToSpanTarget;
        if (latLng == null) {
            return null;
        }
        Rect rect = new Rect(i, i3, i2, i4);
        ArrayList arrayList = new ArrayList();
        RectF rectF = new RectF((float) latLng.longitude, (float) latLng.latitude, (float) latLng.longitude, (float) latLng.latitude);
        m20523a(list, list2, rectF, (List<IMapElement>) arrayList);
        if ((rectF.left == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f && rectF.top == 0.0f && arrayList.size() == 0) || (computeZoomToSpanTarget = this.f25964b.computeZoomToSpanTarget(latLng, rectF, rect, (List<IMapElement>) arrayList)) == null) {
            return null;
        }
        return m20522a(computeZoomToSpanTarget);
    }

    /* renamed from: a */
    private void m20523a(List<IMapElement> list, List<LatLng> list2, RectF rectF, List<IMapElement> list3) {
        if (list2 != null) {
            for (LatLng next : list2) {
                if (next != null) {
                    float f = (float) next.latitude;
                    float f2 = (float) next.longitude;
                    if (rectF.left == 0.0f) {
                        rectF.left = f2;
                    }
                    if (rectF.top == 0.0f) {
                        rectF.top = f;
                    }
                    if (rectF.right == 0.0f) {
                        rectF.right = f2;
                    }
                    if (rectF.bottom == 0.0f) {
                        rectF.bottom = f;
                    }
                    if (rectF.left > f2) {
                        rectF.left = f2;
                    }
                    if (rectF.top < f) {
                        rectF.top = f;
                    }
                    if (rectF.right < f2) {
                        rectF.right = f2;
                    }
                    if (rectF.bottom > f) {
                        rectF.bottom = f;
                    }
                }
            }
        }
        if (list != null) {
            for (IMapElement next2 : list) {
                if (next2 != null) {
                    if ((next2 instanceof DMarker) || (next2 instanceof Locator)) {
                        list3.add(next2);
                    } else {
                        Rect bound = next2.getBound();
                        if (bound != null) {
                            float f3 = (float) (((double) bound.left) / 1000000.0d);
                            float f4 = (float) (((double) bound.top) / 1000000.0d);
                            float f5 = (float) (((double) bound.right) / 1000000.0d);
                            float f6 = (float) (((double) bound.bottom) / 1000000.0d);
                            if (rectF.left == 0.0f) {
                                rectF.left = f3;
                            }
                            if (rectF.top == 0.0f) {
                                rectF.top = f4;
                            }
                            if (rectF.right == 0.0f) {
                                rectF.right = f5;
                            }
                            if (rectF.bottom == 0.0f) {
                                rectF.bottom = f6;
                            }
                            if (rectF.left > f3) {
                                rectF.left = f3;
                            }
                            if (rectF.top < f4) {
                                rectF.top = f4;
                            }
                            if (rectF.right < f5) {
                                rectF.right = f5;
                            }
                            if (rectF.bottom > f6) {
                                rectF.bottom = f6;
                            }
                        }
                    }
                }
            }
        }
    }

    public void setOnMapLoadedCallback(DidiMap.OnMapLoadedCallback onMapLoadedCallback) {
        DidiMap.OnMapLoadedCallback unused = this.f25966d.mapLoadedCallback = onMapLoadedCallback;
    }

    public float getRotate() {
        return this.f25964b.getRotate();
    }

    public float getScaleLevel() {
        return this.f25964b.getScaleLevel();
    }

    public boolean isNight() {
        return this.f25964b.isNight();
    }

    /* renamed from: a */
    private void m20524a(boolean z, CameraUpdate cameraUpdate, long j, Animator.AnimatorListener animatorListener) {
        boolean z2 = z;
        long j2 = j;
        Animator.AnimatorListener animatorListener2 = animatorListener;
        if (cameraUpdate != null && cameraUpdate.getParams() != null) {
            CamerParameter params = cameraUpdate.getParams();
            if (!z2) {
                this.f25964b.stopAnimation();
            }
            switch (params.iCamerType) {
                case 0:
                    this.f25964b.zoomIn(z2, j2, animatorListener2);
                    return;
                case 1:
                    this.f25964b.zoomOut(z2, j2, animatorListener2);
                    return;
                case 2:
                    long j3 = j2;
                    Animator.AnimatorListener animatorListener3 = animatorListener2;
                    this.f25964b.scrollBy(z, params.scrollBy_xPixel, params.scrollBy_yPixel, j, animatorListener);
                    return;
                case 3:
                    long j4 = j2;
                    Animator.AnimatorListener animatorListener4 = animatorListener2;
                    this.f25964b.zoomTo(z, params.zoomTo_zoom, j, animatorListener);
                    return;
                case 4:
                    long j5 = j2;
                    Animator.AnimatorListener animatorListener5 = animatorListener2;
                    this.f25964b.zoomBy(z, params.zoomBy_amount, j, animatorListener);
                    return;
                case 5:
                    long j6 = j2;
                    Animator.AnimatorListener animatorListener6 = animatorListener2;
                    this.f25964b.zoomByPoint(z, params.zoomBy_Point_amount, params.zoomBy_Point_focus, j, animatorListener);
                    return;
                case 6:
                    long j7 = j2;
                    Animator.AnimatorListener animatorListener7 = animatorListener2;
                    if (!m20525a(params)) {
                        this.f25964b.newCameraPosition(z, m20521a(params.newCameraPosition_cameraPosition), j, animatorListener);
                        return;
                    }
                    return;
                case 7:
                    long j8 = j2;
                    Animator.AnimatorListener animatorListener8 = animatorListener2;
                    this.f25964b.newLatLng(z, params.newLatLng_latLng, j, animatorListener);
                    return;
                case 8:
                    long j9 = j2;
                    Animator.AnimatorListener animatorListener9 = animatorListener2;
                    this.f25964b.newLatLngZoom(z, params.newLatLngZoom_zoom, params.newLatLngZoom_latLng, j, animatorListener);
                    return;
                case 9:
                    long j10 = j2;
                    Animator.AnimatorListener animatorListener10 = animatorListener2;
                    this.f25964b.newLatLngBounds(z, params.newLatLngBounds_bounds, params.newLatLngBounds_padding, j, animatorListener);
                    return;
                case 11:
                    long j11 = j2;
                    Animator.AnimatorListener animatorListener11 = animatorListener2;
                    this.f25964b.newLatLngBoundsRect(z, params.newLatLngBounds_dimension_bounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padBom, j, animatorListener);
                    return;
                case 12:
                    Animator.AnimatorListener animatorListener12 = animatorListener2;
                    long j12 = j2;
                    this.f25964b.rotateTo(z, params.rotateto_rotate, params.rotateto_skew, j, animatorListener);
                    return;
                case 13:
                    Animator.AnimatorListener animatorListener13 = animatorListener2;
                    long j13 = j2;
                    CameraPosition calculateZoomToSpanLevel = calculateZoomToSpanLevel(params.elements, (List<LatLng>) null, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom);
                    if (calculateZoomToSpanLevel != null) {
                        this.f25964b.newCameraPosition(z, m20521a(calculateZoomToSpanLevel), j, animatorListener);
                        return;
                    }
                    return;
                case 14:
                    Animator.AnimatorListener animatorListener14 = animatorListener2;
                    if (!m20525a(params)) {
                        this.f25964b.navigateMap(z, m20521a(params.newCameraPosition_cameraPosition), j, animatorListener);
                        return;
                    }
                    return;
                case 15:
                    Animator.AnimatorListener animatorListener15 = animatorListener2;
                    if (!m20525a(params)) {
                        this.f25964b.fullview2overview(m20521a(params.newCameraPosition_cameraPosition), j2, animatorListener15);
                        return;
                    }
                    return;
                case 16:
                    Animator.AnimatorListener animatorListener16 = animatorListener2;
                    if (!m20525a(params)) {
                        this.f25964b.overview2fullview(m20521a(params.newCameraPosition_cameraPosition), params.centerOffsetX, params.centerOffsetY, j, animatorListener);
                        return;
                    }
                    return;
                case 17:
                    if (!m20525a(params)) {
                        Animator.AnimatorListener animatorListener17 = animatorListener2;
                        this.f25964b.newCameraPositionV2(z, m20521a(params.newCameraPosition_cameraPosition), j, animatorListener);
                        return;
                    }
                    return;
                case 18:
                    if (!m20525a(params)) {
                        this.f25964b.navigate4MapFullView(m20521a(params.newCameraPosition_cameraPosition), j2, animatorListener2);
                        return;
                    }
                    return;
                case 19:
                    LatLngBounds latLngBounds = params.newLatLngBounds_dimension_bounds;
                    if (latLngBounds != null && latLngBounds.southwest != null && latLngBounds.northeast != null) {
                        this.f25964b.newLatLngBoundsRect4MoveMapCenter(z, latLngBounds, params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padBom, j, animatorListener);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private boolean m20525a(CamerParameter camerParameter) {
        return camerParameter.newCameraPosition_cameraPosition == null || camerParameter.newCameraPosition_cameraPosition.target == null;
    }

    /* renamed from: a */
    private static Animator.AnimatorListener m20519a(final DidiMap.CancelableCallback cancelableCallback) {
        if (cancelableCallback == null) {
            return null;
        }
        return new Animator.AnimatorListener() {
            boolean isCancel = false;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                DidiMap.CancelableCallback cancelableCallback = DidiMap.CancelableCallback.this;
                if (cancelableCallback != null && !this.isCancel) {
                    cancelableCallback.onFinish();
                }
            }

            public void onAnimationCancel(Animator animator) {
                DidiMap.CancelableCallback cancelableCallback = DidiMap.CancelableCallback.this;
                if (cancelableCallback != null) {
                    cancelableCallback.onCancel();
                }
                this.isCancel = true;
            }
        };
    }

    private class MapListenerWrapper {
        /* access modifiers changed from: private */
        public MapAllGestureListenerList allGestureListeners;
        /* access modifiers changed from: private */
        public DidiMapExt.BlockEventListener blockEventListener;
        /* access modifiers changed from: private */
        public DidiMap.OnCameraChangeListener cameraChangeListener;
        /* access modifiers changed from: private */
        public ArrayList<DidiMap.OnCameraChangeListener> cameraChangeListenerList;
        /* access modifiers changed from: private */
        public float lastScale;
        /* access modifiers changed from: private */
        public int lastScaleLevel;
        /* access modifiers changed from: private */
        public GLBaseMapView.BaseMapCallback mCallBack;
        /* access modifiers changed from: private */
        public DidiMap.OnMapClickListener mapClickListener;
        /* access modifiers changed from: private */
        public List<DidiMap.OnMapClickListener> mapClickListenerList;
        /* access modifiers changed from: private */
        public OnMapElementClickListener mapElementClickListener;
        /* access modifiers changed from: private */
        public DidiMap.OnMapLoadedCallback mapLoadedCallback;
        /* access modifiers changed from: private */
        public DidiMap.OnMapLongClickListener mapLongClickListener;
        /* access modifiers changed from: private */
        public ArrayList<OnMapModeListener> mapModeListeners;
        /* access modifiers changed from: private */
        public OnMapStabledListener mapStabledListener;
        /* access modifiers changed from: private */
        public DidiMapExt.MJOListener mjoListener;
        /* access modifiers changed from: private */
        public DidiMap.OnMapClickListener naviOnMapClickListener;
        /* access modifiers changed from: private */
        public DidiMap.OnPolylineClickListener naviOnPolylineClickListener;
        /* access modifiers changed from: private */
        public ArrayList<OnMapScaleChangedListener> onMapScaleChangedListenerList;
        /* access modifiers changed from: private */
        public DidiMap.OnPolylineClickListener onPolylineClickListener;

        private MapListenerWrapper() {
            this.onMapScaleChangedListenerList = new ArrayList<>();
            this.lastScale = 0.0f;
            this.lastScaleLevel = 0;
            this.mCallBack = new GLBaseMapView.BaseMapCallback() {
                public void onMapCompassClick() {
                }

                public void onMapLocatorClick() {
                }

                public void onMapLoaded() {
                    if (MapListenerWrapper.this.mapLoadedCallback != null) {
                        MapListenerWrapper.this.mapLoadedCallback.onMapLoaded();
                    }
                }

                public void onMJOEvent(long j, int i) {
                    if (MapListenerWrapper.this.mjoListener == null) {
                        return;
                    }
                    if (i == 0) {
                        MapListenerWrapper.this.mjoListener.onMJOLoadSuccess();
                    } else {
                        MapListenerWrapper.this.mjoListener.onMJOHideSuccess();
                    }
                }

                public void onBlockEvent(long j, double d, double d2) {
                    if (MapListenerWrapper.this.blockEventListener != null) {
                        MapListenerWrapper.this.blockEventListener.onBlockEvent(j, d, d2);
                    }
                }

                public void onCameraChange(double d, double d2, float f, float f2, float f3, float f4) {
                    CameraPosition cameraPosition = new CameraPosition(new LatLng(d2, d), f2, f3, f4);
                    if (MapListenerWrapper.this.cameraChangeListener != null) {
                        MapListenerWrapper.this.cameraChangeListener.onCameraChange(cameraPosition);
                    }
                    if (MapListenerWrapper.this.cameraChangeListenerList != null) {
                        Iterator it = MapListenerWrapper.this.cameraChangeListenerList.iterator();
                        while (it.hasNext()) {
                            ((DidiMap.OnCameraChangeListener) it.next()).onCameraChange(cameraPosition);
                        }
                    }
                    if (MapListenerWrapper.this.onMapScaleChangedListenerList != null && MapListenerWrapper.this.onMapScaleChangedListenerList.size() > 0) {
                        if (MapListenerWrapper.this.lastScale == 0.0f || MapListenerWrapper.this.lastScaleLevel == 0) {
                            float unused = MapListenerWrapper.this.lastScale = f;
                            int unused2 = MapListenerWrapper.this.lastScaleLevel = (int) f2;
                            Iterator it2 = MapListenerWrapper.this.onMapScaleChangedListenerList.iterator();
                            while (it2.hasNext()) {
                                OnMapScaleChangedListener onMapScaleChangedListener = (OnMapScaleChangedListener) it2.next();
                                if (onMapScaleChangedListener != null) {
                                    onMapScaleChangedListener.onScaleChanged(OnMapScaleChangedListener.ScaleChangedType.SCALE_CHANGED);
                                    onMapScaleChangedListener.onScaleChanged(OnMapScaleChangedListener.ScaleChangedType.SCALE_LEVEL_CHANGED);
                                }
                            }
                            return;
                        }
                        if (MapListenerWrapper.this.lastScale != f) {
                            float unused3 = MapListenerWrapper.this.lastScale = f;
                            Iterator it3 = MapListenerWrapper.this.onMapScaleChangedListenerList.iterator();
                            while (it3.hasNext()) {
                                OnMapScaleChangedListener onMapScaleChangedListener2 = (OnMapScaleChangedListener) it3.next();
                                if (onMapScaleChangedListener2 != null) {
                                    onMapScaleChangedListener2.onScaleChanged(OnMapScaleChangedListener.ScaleChangedType.SCALE_CHANGED);
                                }
                            }
                        }
                        int i = (int) f2;
                        if (MapListenerWrapper.this.lastScaleLevel != i) {
                            int unused4 = MapListenerWrapper.this.lastScaleLevel = i;
                            Iterator it4 = MapListenerWrapper.this.onMapScaleChangedListenerList.iterator();
                            while (it4.hasNext()) {
                                OnMapScaleChangedListener onMapScaleChangedListener3 = (OnMapScaleChangedListener) it4.next();
                                if (onMapScaleChangedListener3 != null) {
                                    onMapScaleChangedListener3.onScaleChanged(OnMapScaleChangedListener.ScaleChangedType.SCALE_LEVEL_CHANGED);
                                }
                            }
                        }
                    }
                }

                public void onMapLongClick(LatLng latLng) {
                    if (MapListenerWrapper.this.mapLongClickListener != null) {
                        MapListenerWrapper.this.mapLongClickListener.onMapLongClick(latLng);
                    }
                }

                public void onMapClick(LatLng latLng) {
                    if (MapListenerWrapper.this.mapClickListener != null) {
                        MapListenerWrapper.this.mapClickListener.onMapClick(latLng);
                    }
                    if (MapListenerWrapper.this.mapClickListenerList != null && MapListenerWrapper.this.mapClickListenerList.size() > 0) {
                        for (DidiMap.OnMapClickListener onMapClickListener : MapListenerWrapper.this.mapClickListenerList) {
                            if (onMapClickListener != null) {
                                onMapClickListener.onMapClick(latLng);
                            }
                        }
                    }
                    if (MapListenerWrapper.this.naviOnMapClickListener != null) {
                        MapListenerWrapper.this.naviOnMapClickListener.onMapClick(latLng);
                    }
                }

                public void onMapStable() {
                    if (MapListenerWrapper.this.mapStabledListener != null) {
                        MapListenerWrapper.this.mapStabledListener.onStable();
                    }
                    if (MapListenerWrapper.this.allGestureListeners != null) {
                        MapListenerWrapper.this.allGestureListeners.onMapStable();
                    }
                }

                public void onMapModeChange(int i) {
                    if (MapListenerWrapper.this.mapModeListeners != null) {
                        Iterator it = MapListenerWrapper.this.mapModeListeners.iterator();
                        while (it.hasNext()) {
                            ((OnMapModeListener) it.next()).onModeChanged(i);
                        }
                    }
                }

                public void onGLOverlayViewClick(GLOverlayView gLOverlayView) {
                    Pair pair;
                    if (gLOverlayView != null && gLOverlayView.isVisible() && (pair = (Pair) MapManagerDelegate.this.f26017a.get(gLOverlayView.getId())) != null && (pair.first instanceof Polyline) && (pair.second instanceof GLRoute)) {
                        if (MapListenerWrapper.this.naviOnPolylineClickListener != null) {
                            MapListenerWrapper.this.naviOnPolylineClickListener.onPolylineClick((Polyline) pair.first, (LatLng) null);
                        }
                        if (MapListenerWrapper.this.onPolylineClickListener != null) {
                            MapListenerWrapper.this.onPolylineClickListener.onPolylineClick((Polyline) pair.first, (LatLng) null);
                        }
                    }
                }

                public void onMapPoiClick(GLBaseMapView.Poi poi) {
                    if (MapListenerWrapper.this.mapElementClickListener == null) {
                        return;
                    }
                    if (poi.type == 1) {
                        LatLng latLng = poi.geo;
                        GLBaseMapView.PoiEvent poiEvent = (GLBaseMapView.PoiEvent) poi;
                        MapListenerWrapper.this.mapElementClickListener.onTrafficIconClick(new MapTrafficIcon(poiEvent.identity, poiEvent.subIndex, poiEvent.itemType, TrafficEventManager.getInstance().getIconState(poiEvent.identity), latLng));
                    } else if (poi.type == 0) {
                        MapListenerWrapper.this.mapElementClickListener.onAnnoClick(new MapAnnotation(poi.f26153id, poi.name, poi.geo, poi.identity, poi.itemType));
                    } else if (poi.type == 2) {
                        MapListenerWrapper.this.mapElementClickListener.onPoiIconClick(poi.poiUrl);
                    } else if (poi.type == 3) {
                        GLBaseMapView.ExtendIcon extendIcon = (GLBaseMapView.ExtendIcon) poi;
                        MapExtendIcon.Builder builder = new MapExtendIcon.Builder();
                        builder.mo78067id(extendIcon.identity).data(extendIcon.outBype).itemType(extendIcon.itemType).latLng(extendIcon.geo);
                        MapListenerWrapper.this.mapElementClickListener.onExtendIconClick(builder.builder());
                    }
                }
            };
        }
    }

    /* renamed from: a */
    private static CameraPosition m20522a(Camera camera) {
        return new CameraPosition(camera.getCenter(), camera.getScaleLevel(), camera.getSkew(), camera.getRotate());
    }

    /* renamed from: a */
    private static Camera m20521a(CameraPosition cameraPosition) {
        return new Camera(cameraPosition.target, (float) MathsUtils.getScale((double) cameraPosition.zoom), cameraPosition.bearing, cameraPosition.tilt);
    }
}
