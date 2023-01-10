package com.didi.map.outer.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.alpha.maps.internal.MarkerControl;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.core.base.OnMapTransformer;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.animation.Animation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import rui.config.RConfigConstants;

public final class Marker extends DMarker<DidiMap.MultiPositionInfoWindowAdapter, DidiMap.OnMarkerClickListener, DidiMap.OnInfoWindowClickListener> implements IMapElement {
    public static final int BOTTOM = 3;
    public static final int INFO_WINDOW_TYPE_ANDROID_VIEW = 2;
    public static final int INFO_WINDOW_TYPE_MARKER = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 1;

    /* renamed from: a */
    private static Handler f30401a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private boolean f30402b = false;

    /* renamed from: c */
    private String f30403c;

    /* renamed from: d */
    private int f30404d = -1;

    /* renamed from: e */
    private boolean f30405e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MarkerOptions f30406f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f30407g = "";

    /* renamed from: h */
    private boolean f30408h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MarkerControl f30409i = null;

    /* renamed from: j */
    private boolean f30410j = false;

    /* renamed from: k */
    private int f30411k = 0;

    /* renamed from: l */
    private boolean f30412l = false;

    /* renamed from: m */
    private String f30413m = "";

    /* renamed from: n */
    private DidiMap.MultiPositionInfoWindowAdapter f30414n;

    /* renamed from: o */
    private int f30415o = 1;

    /* renamed from: p */
    private DidiMap.OnMarkerDragListener f30416p;

    /* renamed from: q */
    private DidiMap.OnInfoWindowClickListener f30417q;

    /* renamed from: r */
    private DidiMap.OnInfoWindowVisibleChangeListener f30418r;

    /* renamed from: s */
    private DoublePoint f30419s;

    /* renamed from: t */
    private int f30420t;

    /* renamed from: u */
    private int f30421u;

    /* renamed from: v */
    private int f30422v;

    /* renamed from: w */
    private LatLng f30423w;

    /* renamed from: x */
    private String f30424x;

    /* renamed from: y */
    private String f30425y = "";

    /* renamed from: z */
    private boolean f30426z = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gravity {
    }

    public DoublePoint getDoublePoint() {
        return this.f30419s;
    }

    public void setDoublePoint(DoublePoint doublePoint) {
        this.f30419s = doublePoint;
    }

    public Marker(MarkerOptions markerOptions, MarkerControl markerControl, String str) {
        super(markerOptions, markerControl, str);
        this.f30407g = str;
        this.f30406f = markerOptions;
        this.f30409i = markerControl;
        this.f30412l = markerOptions.isInfoWindowAutoOverturn();
        this.f30411k = markerOptions.getDisplayLevel();
        this.f30415o = markerOptions.getInfoWindowType();
    }

    public String getTouchableContent() {
        return this.f30425y;
    }

    public void setTouchableContent(String str) {
        this.f30425y = str;
        if (!TextUtils.isEmpty(str)) {
            this.f30409i.onSetTouchableContent(this);
        }
    }

    public void setMarkerInfoOption(MarkerInfoWindowOption markerInfoWindowOption) {
        this.f30409i.setMarkerInfoOption(this.f30407g, markerInfoWindowOption);
        this.f30406f.setMarkerInfoOption(markerInfoWindowOption);
    }

    public String getStrChargeInfo() {
        return this.f30424x;
    }

    public void setStrChargeInfo(String str) {
        this.f30424x = str;
    }

    public LatLng getCachePosition() {
        return this.f30423w;
    }

    public void setCachePosition(LatLng latLng) {
        this.f30423w = latLng;
    }

    public int getLableType() {
        return this.f30422v;
    }

    public void setLableType(int i) {
        this.f30422v = i;
    }

    public int getChangeNum() {
        return this.f30421u;
    }

    public void setChangeNum(int i) {
        this.f30421u = i;
    }

    public void calculateChangeNum() {
        this.f30421u++;
    }

    public int getDirection() {
        return this.f30420t;
    }

    public void setDirection(int i) {
        this.f30420t = i;
    }

    public String getStrFileName() {
        return this.f30413m;
    }

    public void setStrFileName(String str) {
        this.f30413m = str;
    }

    public void setBubbleInfoWindow(boolean z) {
        if (this.f30409i != null) {
            this.f30402b = z;
        }
    }

    public void setBubbleContent(String str) {
        if (this.f30409i != null) {
            this.f30403c = str;
            this.f30402b = true;
        }
    }

    public String getBubbleContent() {
        return this.f30403c;
    }

    public boolean isBubbleInfoWindow() {
        return this.f30402b;
    }

    public void setBubbleId(int i) {
        if (this.f30409i != null) {
            this.f30404d = i;
        }
    }

    public int getBubbleId() {
        return this.f30404d;
    }

    public void setOnTapMapViewBubbleHidden(boolean z) {
        if (this.f30409i != null) {
            this.f30405e = z;
        }
    }

    public boolean onTapMapViewBubbleHidden() {
        return this.f30405e;
    }

    public void remove() {
        C107291 r0 = new Runnable() {
            public void run() {
                if (Marker.this.f30409i != null) {
                    Marker.this.f30409i.removeMarker(Marker.this.f30407g);
                    LableMarkerManager.removeOtherMarker(Marker.this);
                }
            }
        };
        if (SystemUtil.isUIThread()) {
            r0.run();
        } else {
            f30401a.post(r0);
        }
    }

    public String getId() {
        return this.f30407g;
    }

    public void setPosition(LatLng latLng) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && latLng != null && this.f30406f != null) {
            markerControl.setPosition(this.f30407g, latLng);
            this.f30406f.position(latLng);
        }
    }

    public void setInfoWindowEnable(boolean z) {
        MarkerOptions markerOptions;
        if (this.f30409i != null && (markerOptions = this.f30406f) != null) {
            markerOptions.infoWindowEnable(z);
        }
    }

    public boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return false;
        }
        return markerOptions.isInfoWindowEnable();
    }

    public void setPositionNotUpdate(LatLng latLng) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setPosition(this.f30407g, latLng);
            this.f30406f.position(latLng);
        }
    }

    public void setNaviState(boolean z, boolean z2) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null) {
            markerControl.setNaviState(this.f30407g, z, z2);
            this.f30408h = z;
        }
    }

    public boolean isNaviState() {
        return this.f30408h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r2.f30406f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.outer.model.LatLng getPosition() {
        /*
            r2 = this;
            com.didi.map.alpha.maps.internal.MarkerControl r0 = r2.f30409i
            java.lang.String r1 = r2.f30407g
            com.didi.map.outer.model.LatLng r0 = r0.getPosition(r1)
            if (r0 != 0) goto L_0x0012
            com.didi.map.outer.model.MarkerOptions r1 = r2.f30406f
            if (r1 == 0) goto L_0x0012
            com.didi.map.outer.model.LatLng r0 = r1.getPosition()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.outer.model.Marker.getPosition():com.didi.map.outer.model.LatLng");
    }

    public void setTitle(String str) {
        MarkerOptions markerOptions;
        if (this.f30409i != null && (markerOptions = this.f30406f) != null) {
            markerOptions.title(str);
            this.f30409i.setTitle(this.f30407g, str);
        }
    }

    public String getTitle() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return "";
        }
        return markerOptions.getTitle();
    }

    public void setSnippet(String str) {
        MarkerOptions markerOptions;
        if (this.f30409i != null && (markerOptions = this.f30406f) != null) {
            markerOptions.snippet(str);
            this.f30409i.setSnippet(this.f30407g, str);
        }
    }

    public String getSnippet() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return "";
        }
        return markerOptions.getSnippet();
    }

    public float getAlpha() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAlpha();
    }

    public void setDraggable(boolean z) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setDraggable(this.f30407g, z);
            this.f30406f.draggable(z);
        }
    }

    public boolean isDraggable() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return false;
        }
        return markerOptions.isDraggable();
    }

    public void showInfoWindow() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && markerControl.showInfoWindow(this.f30407g) && !this.f30410j) {
            this.f30410j = true;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f30418r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(true);
            }
        }
    }

    public void showInfoWindowWithGravity(int i) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && markerControl.showInfoWindowWithGravity(this.f30407g, i) && !this.f30410j) {
            this.f30410j = true;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f30418r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(true);
            }
        }
    }

    public void hideInfoWindow() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && markerControl.hideInfoWindow(this.f30407g) && this.f30410j) {
            this.f30410j = false;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f30418r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(false);
            }
        }
    }

    public boolean isInfoWindowShown() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.isInfoWindowShown(this.f30407g);
    }

    public void setAnchor(float f, float f2) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setAnchor(this.f30407g, f, f2);
            this.f30406f.anchor(f, f2);
        }
    }

    public void setVisible(final boolean z) {
        C107302 r0 = new Runnable() {
            public void run() {
                if (Marker.this.f30409i != null && Marker.this.f30406f != null) {
                    Marker.this.f30409i.setVisible(Marker.this.f30407g, z);
                    Marker.this.f30406f.visible(z);
                }
            }
        };
        if (Looper.myLooper() == f30401a.getLooper()) {
            r0.run();
        } else {
            f30401a.post(r0);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setIcon(this.f30407g, bitmapDescriptor);
            this.f30406f.icon(bitmapDescriptor);
        }
    }

    public void setRotateAngle(float f) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setMarkerRotateAngle(this.f30407g, f);
            this.f30406f.rotateAngle(f);
        }
    }

    public float getRotateAngle() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return 0.0f;
        }
        return markerControl.getRotateAngle(this.f30407g);
    }

    public void setRotateAngleNotUpdate(float f) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setRotateAngleNotUpdate(this.f30407g, f);
            this.f30406f.rotateAngle(f);
        }
    }

    public boolean isVisible() {
        MarkerOptions markerOptions;
        if (this.f30409i == null || (markerOptions = this.f30406f) == null) {
            return false;
        }
        return markerOptions.isVisible();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        return this.f30407g.equals(((Marker) obj).f30407g);
    }

    public void setAnimation(Animation animation) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && animation != null) {
            markerControl.setAnimation(this.f30407g, animation);
            if (!this.f30426z) {
                this.f30409i.setAnimationListener(this.f30407g, animation.getListener());
            }
        }
    }

    public boolean startAnimation() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.startAnimation(this.f30407g);
    }

    @Deprecated
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null) {
            markerControl.setAnimationListener(this.f30407g, animationListener);
            this.f30426z = true;
        }
    }

    public void setScale(PointF pointF) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setScale(this.f30407g, pointF);
            this.f30406f.scaleXY(pointF);
        }
    }

    public void setOffset(PointF pointF) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setOffset(this.f30407g, pointF);
            this.f30406f.offset(pointF);
        }
    }

    public void setGroundIcon(LatLngBounds latLngBounds, BitmapDescriptor bitmapDescriptor) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null && latLngBounds != null && bitmapDescriptor != null) {
            markerControl.setGroundIcon(this.f30407g, latLngBounds, bitmapDescriptor);
            this.f30406f.ground(true);
            this.f30406f.groundBounds(latLngBounds);
            this.f30406f.icon(bitmapDescriptor);
        }
    }

    public PointF getOffset() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return null;
        }
        return markerOptions.getOffset();
    }

    public void setAlpha(float f) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setAlpha(this.f30407g, f);
            this.f30406f.alpha(f);
        }
    }

    public void setClickable(boolean z) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null) {
            markerControl.setClickable(this.f30407g, z);
        }
    }

    public boolean isClickable() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.isClickable(this.f30407g);
    }

    public void setFixingPointEnable(boolean z) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null) {
            markerControl.setFixingPointEnable(this.f30407g, z);
        }
    }

    public boolean isFixingPointEnabled() {
        return this.f30409i.isFixingPointEnabled(this.f30407g);
    }

    public void setFixingPoint(int i, int i2) {
        this.f30409i.setFixingPoint(this.f30407g, i, i2);
    }

    public Point getFixingPoint() {
        return this.f30409i.getFixingPoint(this.f30407g);
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null && this.f30406f != null) {
            this.f30409i.setMarkerOptions(this.f30407g, markerOptions);
            this.f30406f.position(markerOptions.getPosition());
            this.f30406f.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
            this.f30406f.title(markerOptions.getTitle());
            this.f30406f.snippet(markerOptions.getSnippet());
            this.f30406f.draggable(markerOptions.isDraggable());
            this.f30406f.visible(markerOptions.isVisible());
            this.f30406f.rotateAngle(markerOptions.getRotateAngle());
            this.f30406f.icon(markerOptions.getIcon());
            this.f30406f.alpha(markerOptions.getAlpha());
            this.f30406f.zIndex(markerOptions.getZIndex());
            this.f30406f.ground(markerOptions.is2DGround());
            this.f30406f.clickable(markerOptions.isClickable());
            this.f30406f.groundBounds(markerOptions.groundBounds());
        }
    }

    public MarkerOptions getOptions() {
        return this.f30406f;
    }

    public void setZIndex(float f) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl != null && this.f30406f != null) {
            markerControl.setZIndex(this.f30407g, f);
            this.f30406f.zIndex(f);
        }
    }

    public int getWidth(Context context) {
        BitmapDescriptor icon;
        Bitmap bitmap;
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null || (icon = markerOptions.getIcon()) == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public int getHeight(Context context) {
        BitmapDescriptor icon;
        Bitmap bitmap;
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null || (icon = markerOptions.getIcon()) == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public float getAnchorU() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAnchorU();
    }

    public float getAnchorV() {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAnchorV();
    }

    public int getDisplayLevel() {
        return this.f30411k;
    }

    public void setDisplayLevel(int i) {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions != null) {
            this.f30411k = i;
            markerOptions.displayLevel(i);
        }
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.f30412l;
    }

    public void setAutoOverturnInfoWindow(boolean z) {
        MarkerOptions markerOptions = this.f30406f;
        if (markerOptions != null) {
            this.f30412l = z;
            markerOptions.autoOverturnInfoWindow(z);
        }
    }

    public void setInfoWindowAdapter(DidiMap.MultiPositionInfoWindowAdapter multiPositionInfoWindowAdapter) {
        this.f30414n = multiPositionInfoWindowAdapter;
    }

    public int getInfoWindowType() {
        return this.f30415o;
    }

    public DidiMap.MultiPositionInfoWindowAdapter getInfoWindowAdapter() {
        return this.f30414n;
    }

    public void setOnClickListener(DidiMap.OnMarkerClickListener onMarkerClickListener) {
        this.f30409i.setOnClickListener(this.f30407g, onMarkerClickListener);
    }

    public DidiMap.OnMarkerClickListener getOnClickListener() {
        return this.f30409i.getOnClickListener(this.f30407g);
    }

    public void setOnDragListener(DidiMap.OnMarkerDragListener onMarkerDragListener) {
        this.f30416p = onMarkerDragListener;
    }

    public DidiMap.OnMarkerDragListener getOnDragListener() {
        return this.f30416p;
    }

    public void setOnInfoWindowClickListener(DidiMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f30417q = onInfoWindowClickListener;
    }

    public void setOnInfoWindowVisibleChangeListener(DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener) {
        this.f30418r = onInfoWindowVisibleChangeListener;
    }

    public DidiMap.OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.f30417q;
    }

    public void setOnMarkerVisibleChangeListener(DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener) {
        this.f30409i.setOnVisibleChangeListener(this.f30407g, onMarkerVisibleChangeListener);
    }

    public Rect getBound(OnMapTransformer onMapTransformer, Context context) {
        Bitmap bitmap;
        MarkerOptions options = getOptions();
        if (options == null || getPosition() == null || (bitmap = options.getIcon().getFormater().getBitmap(context)) == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width / 2;
        int i2 = height / 2;
        DoublePoint screentLocation = onMapTransformer.toScreentLocation(m23548a(getPosition()));
        float anchorU = options.getAnchorU();
        float anchorV = options.getAnchorV();
        if (anchorU >= 0.0f && anchorU <= 1.0f) {
            screentLocation.f27004x -= (((double) anchorU) - 0.5d) * ((double) width);
        }
        if (anchorV >= 0.0f && anchorV <= 1.0f) {
            screentLocation.f27005y -= (((double) anchorV) - 0.5d) * ((double) height);
        }
        DoublePoint doublePoint = new DoublePoint();
        DoublePoint doublePoint2 = new DoublePoint();
        double d = (double) i;
        doublePoint.f27004x = screentLocation.f27004x - d;
        doublePoint2.f27004x = screentLocation.f27004x + d;
        double d2 = (double) i2;
        doublePoint.f27005y = screentLocation.f27005y - d2;
        doublePoint2.f27005y = screentLocation.f27005y + d2;
        return new Rect((int) doublePoint.f27004x, (int) doublePoint.f27005y, (int) doublePoint2.f27004x, (int) doublePoint2.f27005y);
    }

    public int hashCode() {
        return this.f30407g.hashCode();
    }

    /* renamed from: a */
    private GeoPoint m23548a(LatLng latLng) {
        if (latLng != null) {
            return new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        }
        HWLog.m20432e(1, "Marker", "point is null,return default geo");
        return new GeoPoint();
    }

    public Rect getScreenRect() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getScreenRect(this.f30407g);
    }

    public RectF getInfoWindowScreenRect() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getInfoWindowScreenRect(this.f30407g);
    }

    public Rect getBound() {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return new Rect();
        }
        return markerControl.getBound(this.f30407g);
    }

    public RectF getPixel20Bound(float f) {
        MarkerControl markerControl = this.f30409i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getPixel20Bound(this.f30407g, f);
    }

    public String toString() {
        return super.toString() + RConfigConstants.KEYWORD_COLOR_SIGN + this.f30407g;
    }
}
