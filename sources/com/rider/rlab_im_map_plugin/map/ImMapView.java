package com.rider.rlab_im_map_plugin.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.marker.MyLocationMarker;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapTrace;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ImMapView extends FrameLayout implements IMapView {

    /* renamed from: a */
    private static final String f58644a = "GoogleWatermark";

    /* renamed from: c */
    private static final String f58645c = "im_water_marker_tag";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final MapView.TouchEventListener f58646A;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f58647b;

    /* renamed from: d */
    private ImageView f58648d;

    /* renamed from: e */
    private final Context f58649e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map f58650f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MapView f58651g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final MyLocationListener f58652h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MyLocationMarker f58653i;

    /* renamed from: j */
    private int f58654j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public double f58655k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public double f58656l;

    /* renamed from: m */
    private View f58657m;

    /* renamed from: n */
    private View f58658n;

    /* renamed from: o */
    private View f58659o;

    /* renamed from: p */
    private View f58660p;

    /* renamed from: q */
    private List<IMapElement> f58661q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final DefaultMapGestureListener f58662r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f58663s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f58664t;

    /* renamed from: u */
    private int f58665u;

    /* renamed from: v */
    private int f58666v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final double f58667w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final double f58668x;

    /* renamed from: y */
    private Marker f58669y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f58670z;

    public ImMapView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f58647b = LoggerFactory.getLogger("MapViewImpl");
        this.f58661q = new ArrayList();
        this.f58662r = new DefaultMapGestureListener();
        this.f58670z = false;
        this.f58646A = new MapView.TouchEventListener() {
            private float currentX = 0.0f;
            private float currentY = 0.0f;
            private int touchSlop = 0;
            private XPanelLayout xPanelLayout;

            public void onTouchEvent(MotionEvent motionEvent) {
                if (this.touchSlop == 0) {
                    this.touchSlop = ViewConfiguration.get(ImMapView.this.getContext()).getScaledTouchSlop();
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float f = x - this.currentX;
                            float f2 = y - this.currentY;
                            if (!ImMapView.this.f58670z && ImMapView.this.getMap() != null && (Math.abs(f) > ((float) this.touchSlop) || Math.abs(f2) > ((float) this.touchSlop))) {
                                ImMapView.this.f58647b.debug("onTouchEvent: setMapDragStartChange start drag", new Object[0]);
                                boolean unused = ImMapView.this.f58670z = true;
                                MapIMPluginHelper.setMapDragStartChange();
                                MapIMPluginHelper.isCheckOverlap(false);
                            }
                            XPanelLayout xPanelLayout2 = this.xPanelLayout;
                            if (xPanelLayout2 != null) {
                                xPanelLayout2.setMoveFlag(true);
                                return;
                            }
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f3 = x2 - this.currentX;
                    float f4 = y2 - this.currentY;
                    if ((Math.abs(f3) > ((float) this.touchSlop) || Math.abs(f4) > ((float) this.touchSlop)) && ImMapView.this.getMap() != null) {
                        ImMapView.this.f58647b.debug("onTouchEvent: up drag change", new Object[0]);
                        LatLng fromScreenLocation = ImMapUtils.fromScreenLocation(ImMapView.this.f58650f, (float) (ImMapView.this.f58667w / 2.0d), (float) ((((ImMapView.this.f58668x - ((double) ImMapView.this.f58664t)) - ((double) ImMapView.this.f58663s)) / 2.0d) + ((double) ImMapView.this.f58663s)));
                        if (fromScreenLocation != null) {
                            MapIMPluginHelper.setMapDragDidChange(fromScreenLocation.latitude, fromScreenLocation.longitude);
                        } else {
                            MapIMPluginHelper.setMapDragDidChange(ImMapView.this.f58655k, ImMapView.this.f58656l);
                        }
                        MapIMPluginHelper.isCheckOverlap(false);
                    }
                    boolean unused2 = ImMapView.this.f58670z = false;
                    XPanelLayout xPanelLayout3 = this.xPanelLayout;
                    if (xPanelLayout3 != null) {
                        xPanelLayout3.setMoveFlag(false);
                        return;
                    }
                    return;
                }
                this.currentX = motionEvent.getX();
                this.currentY = motionEvent.getY();
                XPanelLayout xPanelLayout4 = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
                this.xPanelLayout = xPanelLayout4;
                if (xPanelLayout4 != null) {
                    xPanelLayout4.setMoveFlag(false);
                }
            }
        };
        this.f58649e = context;
        m44363a();
        this.f58652h = new MyLocationListener(this.f58649e);
        this.f58667w = (double) DisplayUtils.getWindowWidth(this.f58649e);
        this.f58668x = (double) DisplayUtils.getWindowHeight(this.f58649e);
    }

    /* renamed from: a */
    private void m44363a() {
        if (getMapView() != null) {
            MapVendor mapVendor = MapVendor.GOOGLE;
            if (ImMapConfig.getInstance().isHmsService()) {
                mapVendor = MapVendor.HUAWEI;
            }
            this.f58651g.init(mapVendor);
            boolean isDowngradeMap = ImMapConfig.getInstance().isDowngradeMap();
            Logger logger = this.f58647b;
            logger.info("map downgrade toggle is " + isDowngradeMap, new Object[0]);
            if (isDowngradeMap) {
                this.f58647b.info("map downgrade true , no add mapView to parent", new Object[0]);
            } else {
                addView(this.f58651g);
            }
        }
    }

    public void onCreate() {
        this.f58647b.info(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.onCreate((Bundle) null);
        }
    }

    public void onStart() {
        this.f58647b.info("onStart", new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() {
        this.f58647b.info("onResume", new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        this.f58647b.info("onPause", new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() {
        this.f58647b.info("onStop", new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        this.f58647b.info(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, new Object[0]);
        MyLocationListener myLocationListener = this.f58652h;
        if (myLocationListener != null) {
            myLocationListener.stopLocation();
        }
        if (getMap() != null) {
            this.f58650f.removeOnMapGestureListener(this.f58662r);
        }
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.removeTouchEventListener(this.f58646A);
            this.f58651g.onDestroy();
        }
    }

    public MapView getMapView() {
        if (this.f58651g == null) {
            this.f58651g = new MapView(this.f58649e);
        }
        return this.f58651g;
    }

    public void getMapAsync(final IMapReadyCallBack iMapReadyCallBack) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f58647b.info("getMapAsync start", new Object[0]);
        MapView mapView = this.f58651g;
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Logger a = ImMapView.this.f58647b;
                    a.debug("getMapAsync ready : " + (currentTimeMillis - currentTimeMillis), new Object[0]);
                    Map unused = ImMapView.this.f58650f = map;
                    IMapReadyCallBack iMapReadyCallBack = iMapReadyCallBack;
                    if (iMapReadyCallBack != null) {
                        iMapReadyCallBack.onMapReady();
                    }
                    ImMapView.this.f58650f.addOnMapGestureListener(ImMapView.this.f58662r);
                    ImMapView.this.f58651g.addTouchEventListener(ImMapView.this.f58646A);
                    ImMapView.this.f58650f.getUiSettings().setZoomControlsEnabled(false);
                    String mapStyle = ImMapConfig.getInstance().getMapStyle();
                    if (!TextUtils.isEmpty(mapStyle)) {
                        ImMapView.this.f58650f.setMapStyle(mapStyle);
                    }
                    ImMapView.this.m44367b();
                    ImMapView.this.m44370c();
                    ImMapView imMapView = ImMapView.this;
                    imMapView.m44364a(imMapView.f58650f);
                    if (ImMapView.this.f58652h != null) {
                        ImMapView.this.f58652h.startLocation();
                    }
                    ImMapView.this.m44372d();
                }
            });
        }
    }

    public void setMapData(int i, double d, double d2) {
        this.f58654j = i;
        this.f58655k = d;
        this.f58656l = d2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44364a(Map map) {
        this.f58647b.info("initMapCenter", new Object[0]);
        this.f58653i = new MyLocationMarker(this, map);
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f58649e).getLastKnownLocation();
        this.f58653i.addMarker();
        this.f58652h.setMarker(this.f58653i);
        if (lastKnownLocation != null) {
            this.f58653i.updatePosition(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
        } else {
            this.f58653i.updatePosition(new LatLng(this.f58655k, this.f58656l));
        }
        this.f58661q.add(this.f58653i.getMarker());
    }

    public Map getMap() {
        return this.f58650f;
    }

    public boolean isDowngradeMap() {
        return ImMapConfig.getInstance().isDowngradeMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m44367b() {
        if (ImMapConfig.getInstance().isDebug() && this.f58657m == null) {
            View view = new View(this.f58651g.getContext());
            this.f58657m = view;
            view.setBackgroundResource(R.drawable.rider_shape_betview_bg);
            addView(this.f58657m, new FrameLayout.LayoutParams(-1, -1));
            if (ImMapConfig.getInstance().isShowMapTool() && this.f58654j == 0) {
                View view2 = new View(this.f58651g.getContext());
                this.f58658n = view2;
                view2.setBackgroundColor(-16776961);
                addView(this.f58658n, new FrameLayout.LayoutParams(-1, 1));
                View view3 = new View(this.f58651g.getContext());
                this.f58659o = view3;
                view3.setBackgroundColor(-16776961);
                addView(this.f58659o, new FrameLayout.LayoutParams(1, -1));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m44370c() {
        if (this.f58660p == null && this.f58654j == 0) {
            View view = new View(this.f58651g.getContext());
            this.f58660p = view;
            view.setBackgroundResource(R.color.white);
            addView(this.f58660p, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setHintView(int i, int i2, int i3, int i4) {
        View view;
        this.f58663s = i;
        this.f58664t = i3;
        this.f58665u = i2;
        this.f58666v = i4;
        if (ImMapConfig.getInstance().isDebug() && (view = this.f58657m) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            layoutParams.leftMargin = i2;
            layoutParams.bottomMargin = i3;
            layoutParams.rightMargin = i4;
            this.f58657m.setLayoutParams(layoutParams);
            if (ImMapConfig.getInstance().isShowMapTool() && this.f58654j == 0) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f58658n.getLayoutParams();
                layoutParams2.topMargin = ((int) ((((this.f58668x + ((double) ImMapUtils.getNavigationBarHeight(this.f58649e))) - ((double) i3)) - ((double) i)) / 2.0d)) + i;
                this.f58658n.setLayoutParams(layoutParams2);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f58659o.getLayoutParams();
                layoutParams3.leftMargin = (int) (this.f58667w / 2.0d);
                this.f58659o.setLayoutParams(layoutParams3);
            }
        }
        View view2 = this.f58660p;
        if (view2 != null && this.f58654j == 0) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view2.getLayoutParams();
            layoutParams4.topMargin = Math.max((int) ((this.f58668x - ((double) this.f58664t)) + ((double) ImMapUtils.getNavigationBarHeight(this.f58649e)) + ((double) DisplayUtils.dp2px(getContext(), 100.0f))), 0);
            layoutParams4.leftMargin = 0;
            layoutParams4.bottomMargin = 0;
            layoutParams4.rightMargin = 0;
            this.f58660p.setLayoutParams(layoutParams4);
        }
    }

    public void setMapRecenter() {
        this.f58647b.debug("setMapRecenter", new Object[0]);
        if (this.f58650f == null) {
            return;
        }
        if (this.f58654j != 1) {
            MyLocationMarker myLocationMarker = this.f58653i;
            if (myLocationMarker != null) {
                setCamera(myLocationMarker.getLatLng().latitude, this.f58653i.getLatLng().longitude);
            }
        } else if (this.f58669y != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58653i.getLatLng());
            arrayList.add(this.f58669y.getPosition());
            arrayList.add(ImMapUtils.calMirrorLatLng(this.f58653i.getLatLng(), this.f58669y.getPosition()));
            this.f58650f.setPadding(this.f58665u, this.f58663s, this.f58666v, this.f58664t);
            this.f58650f.animateCamera(ImMapUtils.calculateBestZoom(this.f58651g, arrayList, this.f58665u, this.f58663s, this.f58666v, this.f58664t, 9, 16), 300, new CancelableCallback() {
                public void onCancel() {
                }

                public void onFinish() {
                    MapIMPluginHelper.isCheckOverlap(true);
                }
            });
        } else {
            setMapCenterCoordinate();
        }
    }

    public void setMapCenterCoordinate() {
        MyLocationListener myLocationListener;
        LatLng latLng;
        this.f58647b.debug("setMapCenterCoordinate", new Object[0]);
        if (this.f58650f != null && (myLocationListener = this.f58652h) != null && (latLng = myLocationListener.getLatLng()) != null) {
            CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, (float) ImMapConfig.getInstance().getZoomLevel());
            this.f58650f.setPadding(this.f58663s, this.f58664t, this.f58665u, this.f58666v);
            this.f58650f.animateCamera(newLatLngZoom, new CancelableCallback() {
                public void onCancel() {
                }

                public void onFinish() {
                    MapIMPluginHelper.isCheckOverlap(true);
                }
            });
        }
    }

    public void setCamera(double d, double d2) {
        if (this.f58650f != null && this.f58654j == 0) {
            int zoomLevel = ImMapConfig.getInstance().getZoomLevel();
            final double d3 = d;
            final double d4 = d2;
            BestViewer.doBestView(this.f58650f, true, Float.valueOf((float) zoomLevel), new LatLng(d3, d4), new Padding(this.f58665u, this.f58663s, this.f58666v, this.f58664t), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (d3 == ImMapView.this.f58653i.getLatLng().latitude && d4 == ImMapView.this.f58653i.getLatLng().longitude) {
                        MapIMPluginHelper.isCheckOverlap(true);
                        Logger a = ImMapView.this.f58647b;
                        a.debug("setCamera overlap true" + d3 + " " + d4, new Object[0]);
                        return;
                    }
                    MapIMPluginHelper.isCheckOverlap(false);
                    Logger a2 = ImMapView.this.f58647b;
                    a2.debug("setCamera overlap false" + d3 + " " + d4, new Object[0]);
                }
            });
        }
    }

    public void setMapOverView(double d, double d2) {
        LatLng latLng;
        if (this.f58650f != null && this.f58653i != null) {
            if (d == 0.0d && d2 == 0.0d) {
                double navigationBarHeight = (this.f58668x + ((double) ImMapUtils.getNavigationBarHeight(this.f58649e))) - ((double) this.f58664t);
                int i = this.f58663s;
                latLng = ImMapUtils.fromScreenLocation(this.f58650f, (float) ((int) (this.f58667w / 2.0d)), (float) ((int) (((navigationBarHeight - ((double) i)) / 2.0d) + ((double) i))));
            } else {
                latLng = new LatLng(d, d2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58653i.getLatLng());
            arrayList.add(latLng);
            this.f58650f.setPadding(this.f58665u, this.f58663s, this.f58666v, this.f58664t);
            this.f58650f.animateCamera(ImMapUtils.calculateBestZoom(this.f58651g, arrayList, this.f58665u, this.f58663s, this.f58666v, this.f58664t, 9, 16));
        }
    }

    public void setWaterMarker(String str, double d, double d2) {
        MapView mapView;
        if (this.f58654j == 1 && (mapView = this.f58651g) != null) {
            Context context = mapView.getContext();
            ImFavorFrom favorFrom = ImMapConfig.getInstance().getFavorFrom();
            Map map = getMapView().getMap();
            Marker marker = this.f58669y;
            if (marker != null) {
                marker.setPosition(new LatLng(d, d2));
                return;
            }
            Bitmap imageFromAssetsFile = ImMapUtils.getImageFromAssetsFile(context, str);
            if (imageFromAssetsFile == null) {
                imageFromAssetsFile = ImageUtil.getScaledBitmap(context, BitmapDescriptorFactory.fromResource(context, favorFrom == ImFavorFrom.IMMAP_GLOBAL ? R.drawable.rider_im_water_icon : R.drawable.rider_im_99_water_icon).getBitmap());
            }
            if (map != null) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(imageFromAssetsFile));
                markerOptions.anchor(0.5f, 0.5f);
                markerOptions.zIndex(30);
                markerOptions.position(new LatLng(d, d2));
                Marker addMarker = map.addMarker(f58645c, markerOptions);
                this.f58669y = addMarker;
                this.f58661q.add(addMarker);
                return;
            }
            this.f58647b.info("map is null , so not add marker", new Object[0]);
        }
    }

    public void updatePosition(LatLng latLng) {
        this.f58655k = latLng.latitude;
        this.f58656l = latLng.longitude;
    }

    private class DefaultMapGestureListener implements OnMapGestureListener {
        private boolean mScrolled;
        private int mStartZoomLevel;

        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public void onMapStable() {
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        private DefaultMapGestureListener() {
        }

        public boolean onDown(float f, float f2) {
            this.mStartZoomLevel = (int) ImMapView.this.getZoomLevel();
            return false;
        }

        public boolean onScroll(float f, float f2) {
            this.mScrolled = true;
            return false;
        }

        public boolean onUp(float f, float f2) {
            int zoomLevel = (int) ImMapView.this.getZoomLevel();
            Logger a = ImMapView.this.f58647b;
            a.info("onUp map zoom level ： " + zoomLevel, new Object[0]);
            if (this.mScrolled) {
                ImMapTrace.traceMapDrag(zoomLevel);
            } else {
                int i = this.mStartZoomLevel;
                if (i != zoomLevel) {
                    ImMapTrace.traceMapZoom(zoomLevel, zoomLevel > i ? 1 : 0);
                }
            }
            this.mScrolled = false;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m44372d() {
        ImageView imageView;
        MapView mapView = this.f58651g;
        if (mapView != null && (imageView = (ImageView) mapView.findViewWithTag(f58644a)) != null && imageView.getDrawable() != null && this.f58648d == null && getMap() != null) {
            try {
                Drawable drawable = imageView.getDrawable();
                ImageView imageView2 = new ImageView(getContext());
                this.f58648d = imageView2;
                imageView2.setImageDrawable(drawable);
                int dp2px = DisplayUtils.dp2px(getContext(), 14.0f);
                int dp2px2 = DisplayUtils.dp2px(getContext(), 10.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dp2px);
                layoutParams.leftMargin = dp2px;
                layoutParams.bottomMargin = dp2px2;
                layoutParams.gravity = 80;
                addView(this.f58648d, layoutParams);
                this.f58650f.getUiSettings().setLogoVisibility(0);
            } catch (Exception e) {
                this.f58647b.error("setMapLogoPosition", (Throwable) e);
            }
        }
    }

    public void setMarkerStates(String str, boolean z) {
        Marker oneMarkerByTag = ImMapUtils.getOneMarkerByTag(this.f58651g, str);
        if (oneMarkerByTag != null) {
            oneMarkerByTag.setVisible(z);
        }
    }

    public double getZoomLevel() {
        if (getMap() == null || getMap().getCameraPosition() == null) {
            return -1.0d;
        }
        return getMap().getCameraPosition().zoom;
    }
}
