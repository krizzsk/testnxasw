package com.didi.map.outer.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.hawaii.log.HWLog;
import com.didi.map.alpha.maps.internal.PolylineControl;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.AlphaAnimation;
import com.didi.map.outer.model.animation.Animation;
import com.didi.map.outer.model.animation.EmergeAnimation;
import com.didi.util.CrashTryCatcher;
import java.util.Collection;
import java.util.List;

public final class Polyline implements IMapElement {
    public static final int DARK_BLUE = 6;
    public static final int DASHED = 33;
    public static final int DIDI_PSG_BLUE = 20;
    public static final int DIDI_PSG_SLIGHTBLUE = 0;
    public static final int GREEN = 4;
    public static final int GREY = 0;
    public static final int LIGHT_BLUE = 1;
    public static final int RED = 2;
    public static final int WHITE_BLUE = 19;
    public static final int YELLOW = 3;

    /* renamed from: b */
    private static final float f30474b = 10.0f;

    /* renamed from: a */
    long f30475a;

    /* renamed from: c */
    private PolylineOptions f30476c;

    /* renamed from: d */
    private String f30477d;

    /* renamed from: e */
    private PolylineControl f30478e;

    /* renamed from: f */
    private boolean f30479f;

    /* renamed from: g */
    private int f30480g;

    public RectF getPixel20Bound(float f) {
        return null;
    }

    public boolean isBoTrafficUpdate() {
        return this.f30479f;
    }

    public void setBoTrafficUpdate(boolean z) {
        this.f30479f = z;
        this.f30478e.setBoTrafficUpdate(this.f30477d, z);
        this.f30476c.setBoTrafficUpdate(z);
    }

    public void setTurnArrowType(int i) {
        this.f30480g = i;
    }

    public long getRouteId() {
        return this.f30475a;
    }

    public void setRouteId(long j) {
        this.f30475a = j;
        this.f30476c.setRouteId(j);
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl != null) {
            polylineControl.setRouteId(this.f30477d, j);
        }
    }

    public Polyline(PolylineOptions polylineOptions, PolylineControl polylineControl, String str) {
        this.f30476c = null;
        this.f30477d = "";
        this.f30478e = null;
        this.f30475a = -1;
        this.f30480g = 0;
        this.f30477d = str;
        this.f30476c = polylineOptions;
        this.f30478e = polylineControl;
    }

    public void setPolylineOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.f30476c.arrow(polylineOptions.isArrow());
            this.f30476c.zIndex(polylineOptions.getZIndex());
            this.f30476c.width(polylineOptions.getWidth());
            this.f30476c.color(polylineOptions.getColor());
            this.f30476c.aboveMaskLayer(polylineOptions.isAboveMaskLayer());
            this.f30476c.alpha(polylineOptions.getAlpha());
            this.f30476c.animation(polylineOptions.getAnimation());
            this.f30476c.mo83155a(polylineOptions.isGeodesic());
            this.f30476c.visible(polylineOptions.isVisible());
            this.f30478e.setPolylineOptions(this.f30477d, polylineOptions);
        }
    }

    public PolylineOptions getPolylineOptions() {
        return this.f30476c;
    }

    public void remove() {
        HWLog.m20433i("hw", "polyline remove = " + getRouteId() + " strId:" + this.f30477d);
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl != null) {
            polylineControl.polyline_remove(this.f30477d);
        }
    }

    public void removeRoadName() {
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl != null) {
            long j = this.f30475a;
            if (j > 0) {
                polylineControl.removeRoadName(j);
            }
        }
    }

    public String getId() {
        return this.f30477d;
    }

    public void setPoints(List<LatLng> list) {
        this.f30478e.polyline_setPoints(this.f30477d, list);
    }

    public void setPercent(float f) {
        this.f30478e.polyline_setPercent(this.f30477d, f);
    }

    public void setPulsePercent(float f) {
        this.f30478e.polyline_setPulsePercent(this.f30477d, f);
    }

    public void setPulseCustomColor(int i) {
        this.f30478e.polyline_setPulseCustomColor(this.f30477d, i);
    }

    public void setPulseBitmap(Bitmap bitmap) {
        this.f30478e.polyline_setPulseBitmap(this.f30477d, bitmap);
    }

    public void setPoints(List<LatLng> list, int[] iArr, int[] iArr2) {
        this.f30478e.polyline_setPoints(this.f30477d, list, iArr, iArr2);
    }

    public void setPoints(LatLng[] latLngArr, int[] iArr, int[] iArr2) {
        this.f30478e.polyline_setPoints(this.f30477d, latLngArr, iArr, iArr2);
    }

    public void setOriginPoints(List<LatLng> list) {
        this.f30478e.polyline_setOriginPoints(this.f30477d, list);
    }

    public void setOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f30478e.setOnPolylineClickListener(this.f30477d, onPolylineClickListener);
    }

    public void addAllFishBoneRoadNames(Collection<RouteSectionWithName> collection) {
        this.f30476c.addAllFishBoneRoadNames(collection);
    }

    public void addAllRoadNames(List<RouteSectionWithName> list) {
        this.f30476c.addAllRoadNames(list);
        this.f30478e.addRouteName(this.f30477d, list);
    }

    public void setRouteName(List<PolylineOptions.RouteWithName> list) {
        throw new IllegalStateException("driver no use this method");
    }

    public void addTurnArrow(int i, int i2) {
        if (i != -1) {
            i = this.f30476c.getNewIndex(i);
        }
        this.f30478e.polyline_addTurnArrow(this.f30477d, i, i2, this.f30480g);
    }

    public void addTurnArrow(int i, int i2, int i3) {
        if (i != -1) {
            i = this.f30476c.getNewIndex(i);
        }
        this.f30478e.polyline_addTurnArrow(this.f30477d, i, i2, i3, this.f30480g);
    }

    public void cleanTurnArrow() {
        HWLog.m20431d("navsdk", "cleanTurnArrow");
        this.f30478e.polyline_cleanTurnArrow(this.f30477d);
    }

    public List<LatLng> getPoints() {
        return this.f30476c.getPoints();
    }

    public void setWidth(float f) {
        this.f30478e.polyline_setWidth(this.f30477d, f);
        this.f30476c.width(f);
    }

    public float getWidth() {
        return this.f30476c.getWidth();
    }

    public void setColor(int i) {
        if (this.f30476c.getLineType() == 5) {
            this.f30478e.polyline_setCustomColor(this.f30477d, i);
        } else {
            this.f30478e.polyline_setColor(this.f30477d, i);
        }
        this.f30476c.color(i);
    }

    public void setColors(int[] iArr, int[] iArr2) {
        this.f30478e.setColors(this.f30477d, iArr, iArr2);
        this.f30476c.colors(iArr, iArr2);
    }

    public void setColor() {
        int[][] colors = this.f30476c.getColors();
        if (colors != null) {
            this.f30478e.setColors(this.f30477d, colors[0], colors[1]);
        }
    }

    public int[][] getColors() {
        return this.f30478e.getColors(this.f30477d);
    }

    public void setArrow(boolean z) {
        this.f30478e.polyline_setArrow(this.f30477d, z);
        this.f30476c.arrow(z);
    }

    public void setColorTexture(String str, String str2, int i) {
        this.f30478e.setCustomerColorTexture(this.f30477d, str, str2, i);
    }

    public int getColor() {
        return this.f30476c.getColor();
    }

    public void setZIndex(float f) {
        this.f30478e.polyline_setZIndex(this.f30477d, f);
        this.f30476c.zIndex(f);
    }

    public float getZIndex() {
        return this.f30476c.getZIndex();
    }

    public void setAlpha(float f) {
        this.f30478e.polyline_setAlpha(this.f30477d, f);
        this.f30476c.alpha(f);
    }

    public void setLineCap(boolean z) {
        this.f30478e.polyline_setLineCap(this.f30477d, z);
        this.f30476c.lineCap(z);
    }

    public boolean getLineCap() {
        return this.f30476c.getLineCap();
    }

    public void setVisible(boolean z) {
        this.f30478e.polyline_setVisible(this.f30477d, z);
        this.f30476c.visible(z);
    }

    public boolean isVisible() {
        return this.f30476c.isVisible();
    }

    public void setAboveMaskLayer(boolean z) {
        this.f30478e.polyline_setAboveMaskLayer(this.f30477d, z);
        this.f30476c.aboveMaskLayer(z);
    }

    public boolean isAboveMaskLayer() {
        return this.f30476c.isAboveMaskLayer();
    }

    public void setGeodesic(boolean z) {
        this.f30478e.polyline_setGeodesic(this.f30477d, z);
        this.f30476c.mo83155a(z);
    }

    public boolean isGeodesic() {
        return this.f30476c.isGeodesic();
    }

    public Polyline(PolylineOptions polylineOptions) {
        this(polylineOptions, (PolylineControl) null, (String) null);
    }

    public void insertPoint(int i, LatLng latLng) {
        this.f30478e.insertPoint(this.f30477d, this.f30476c.getNewIndex(i), latLng, i);
    }

    public void insertPoint(int i, LatLng latLng, int i2, int i3) {
        if (!m23556a(i, latLng)) {
            HWLog.m20433i("hw", "!isIndexVaild(index, point)");
        } else {
            this.f30478e.insertPoint(this.f30477d, this.f30476c.getNewIndex(i), latLng, i3);
        }
    }

    public GeoPoint getTrueInsertPoint() {
        return this.f30478e.polylineGetTrueInsertPoint(this.f30477d);
    }

    public void setNaviRouteLineErase(boolean z) {
        this.f30478e.setNaviRouteLineErase(this.f30477d, z);
        this.f30476c.setErase(z);
    }

    public Rect getNaviRouteLineVisibleRect() {
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl == null) {
            return null;
        }
        return polylineControl.getNaviRouteLineVisibleRect(this.f30477d);
    }

    public Rect getNaviRouteLineVisibleRect(int i) {
        return this.f30478e.getNaviRouteLineVisibleRect(this.f30477d, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        return this.f30477d.equals(((Polyline) obj).f30477d);
    }

    public int hashCode() {
        return this.f30477d.hashCode();
    }

    public void startAnimation(Animation animation) {
        if ((animation instanceof AlphaAnimation) || (animation instanceof EmergeAnimation)) {
            PolylineControl polylineControl = this.f30478e;
            if (polylineControl != null) {
                polylineControl.startAnimation(this.f30477d, animation);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
    }

    /* renamed from: a */
    private boolean m23556a(int i, LatLng latLng) {
        int i2;
        PolylineOptions polylineOptions = this.f30476c;
        if (polylineOptions == null) {
            return false;
        }
        List<LatLng> newPoints = polylineOptions.getNewPoints();
        List<LatLng> points = this.f30476c.getPoints();
        if (!(newPoints == null || newPoints.size() == 0)) {
            int size = points.size();
            if (i >= 0 && (i2 = i + 1) < size) {
                try {
                    LatLng latLng2 = newPoints.get(this.f30476c.getNewIndex(i));
                    if (this.f30476c.getNewIndex(i2) >= newPoints.size()) {
                        return false;
                    }
                    if (m23557a(latLng2, newPoints.get(this.f30476c.getNewIndex(i2)), latLng)) {
                        return true;
                    }
                    HWLog.m20433i("polyline", "index & point not inLine pos:" + latLng.toString() + ";index=" + i);
                } catch (IndexOutOfBoundsException e) {
                    CrashTryCatcher.logCrash(e);
                }
            } else if (i == size - 1) {
                return true;
            } else {
                HWLog.m20433i("hw", "index & point not inLine pos:" + latLng.toString() + ";index=" + i);
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private int m23555a(int i, LatLng latLng, int i2) {
        List<LatLng> points;
        PolylineOptions polylineOptions = this.f30476c;
        if (!(polylineOptions == null || (points = polylineOptions.getPoints()) == null || points.size() == 0)) {
            int size = points.size();
            boolean z = true;
            int i3 = i;
            while (i3 < size && i3 != size - 1) {
                int i4 = i3 + 1;
                if (m23557a(points.get(i3), points.get(i4), latLng)) {
                    return i3;
                }
                if (z) {
                    z = false;
                    for (int i5 = i3 - i2; i5 < i3; i5++) {
                        if (i5 >= 0 && m23557a(points.get(i5), points.get(i5 + 1), latLng)) {
                            return i5;
                        }
                    }
                    continue;
                }
                i3 = i4;
            }
            return i;
        }
        return i;
    }

    /* renamed from: a */
    private boolean m23557a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        LatLng latLng4 = latLng;
        LatLng latLng5 = latLng2;
        LatLng latLng6 = latLng3;
        if (latLng4 == null || latLng5 == null) {
            return false;
        }
        if (Math.abs((TransformUtil.distanceBetween(latLng4.latitude, latLng4.longitude, latLng5.latitude, latLng5.longitude) - TransformUtil.distanceBetween(latLng4.latitude, latLng4.longitude, latLng6.latitude, latLng6.longitude)) - TransformUtil.distanceBetween(latLng6.latitude, latLng6.longitude, latLng5.latitude, latLng5.longitude)) < 20.0d) {
            return true;
        }
        return false;
    }

    public Rect getBound() {
        return this.f30478e.getBound(this.f30477d);
    }

    public void addViolationParkingSection(int i, int i2, float f, int i3, float f2) {
        if (this.f30478e != null) {
            int newIndex = this.f30476c.getNewIndex(i2);
            int newIndex2 = this.f30476c.getNewIndex(i3);
            HWLog.m20433i("hw", "Polyline addViolationParkingSection2 section_uid:" + i + " startIndex:" + i2 + " endIndex:" + i3 + " lastStartIndex:" + newIndex + " lastEndIndex:" + newIndex2);
            this.f30478e.addViolationParkingSection(this.f30477d, i, newIndex, f, newIndex2, f2);
        }
    }

    public LatLng queryViolationParkingIconPosition(int i, int i2, LatLng latLng) {
        if (this.f30478e == null) {
            return null;
        }
        int newIndex = this.f30476c.getNewIndex(i2);
        HWLog.m20433i("hw", "Polyline queryViolationParkingIconPosition section_uid:" + i + " index:" + i2 + " lastIndex:" + newIndex);
        return this.f30478e.queryViolationParkingIconPosition(this.f30477d, i, newIndex, latLng);
    }

    public void flashViolationParkingSection(int i, boolean z) {
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl != null) {
            polylineControl.flashViolationParkingSection(this.f30477d, i, z);
        }
    }

    public void removeViolationParkingSection(int i) {
        PolylineControl polylineControl = this.f30478e;
        if (polylineControl != null) {
            polylineControl.removeViolationParkingSection(this.f30477d, i);
        }
    }
}
