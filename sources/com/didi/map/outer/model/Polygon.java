package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.PolygonControl;
import com.didi.map.outer.map.DidiMap;
import java.util.List;

public final class Polygon implements IMapElement {

    /* renamed from: a */
    private PolygonOptions f30455a = null;

    /* renamed from: b */
    private String f30456b = "";

    /* renamed from: c */
    private PolygonControl f30457c = null;

    public Polygon(PolygonOptions polygonOptions, PolygonControl polygonControl, String str) {
        this.f30456b = str;
        this.f30455a = polygonOptions;
        this.f30457c = polygonControl;
    }

    public void remove() {
        PolygonControl polygonControl = this.f30457c;
        if (polygonControl != null) {
            polygonControl.polygon_remove(this.f30456b);
        }
    }

    public String getId() {
        return this.f30456b;
    }

    public void setBellowRoute(boolean z) {
        PolygonControl polygonControl = this.f30457c;
        if (polygonControl != null) {
            polygonControl.setBellowRoute(this.f30456b, z);
            this.f30455a.bellowRoute(z);
        }
    }

    public void setPoints(List<LatLng> list) {
        PolygonControl polygonControl = this.f30457c;
        if (polygonControl != null) {
            polygonControl.polygon_setPoints(this.f30456b, list);
            this.f30455a.setPoints(list);
        }
    }

    public List<LatLng> getPoints() {
        return this.f30455a.getPoints();
    }

    public void setStrokeWidth(float f) {
        this.f30457c.polygon_setStrokeWidth(this.f30456b, f);
        this.f30455a.strokeWidth(f);
    }

    public float getStrokeWidth() {
        return this.f30455a.getStrokeWidth();
    }

    public void setStrokeColor(int i) {
        this.f30457c.polygon_setStrokeColor(this.f30456b, i);
        this.f30455a.strokeColor(i);
    }

    public int getStrokeColor() {
        return this.f30455a.getStrokeColor();
    }

    public void setFillColor(int i) {
        this.f30457c.polygon_setFillColor(this.f30456b, i);
        this.f30455a.fillColor(i);
    }

    public int getFillColor() {
        return this.f30455a.getFillColor();
    }

    public void setZIndex(float f) {
        this.f30457c.polygon_setZIndex(this.f30456b, f);
        this.f30455a.zIndex(f);
    }

    public float getZIndex() {
        return this.f30455a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f30457c.polygon_setVisible(this.f30456b, z);
        this.f30455a.visible(z);
    }

    public boolean isVisible() {
        return this.f30455a.isVisible();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo83038a(boolean z) {
        this.f30457c.polygon_setGeodesic(this.f30456b, z);
        this.f30455a.geodesic(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo83039a() {
        return this.f30455a.isGeodesic();
    }

    public void setOptions(PolygonOptions polygonOptions) {
        this.f30457c.setOptions(this.f30456b, polygonOptions);
        this.f30455a = polygonOptions;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        return this.f30456b.equals(((Polygon) obj).f30456b);
    }

    public int hashCode() {
        return this.f30456b.hashCode();
    }

    public Rect getBound() {
        PolygonControl polygonControl = this.f30457c;
        if (polygonControl == null) {
            return new Rect();
        }
        return polygonControl.getBound(this.f30456b);
    }

    public RectF getPixel20Bound(float f) {
        PolygonControl polygonControl = this.f30457c;
        if (polygonControl == null) {
            return null;
        }
        return polygonControl.getPixel20Bound(this.f30456b, f);
    }

    public void setOnPolygonClickListener(DidiMap.OnPolygonClickListener onPolygonClickListener) {
        this.f30457c.setOnPolygonClickListener(this.f30456b, onPolygonClickListener);
    }

    public boolean isClickable() {
        return this.f30455a.isClickable();
    }

    public void setClickable(boolean z) {
        this.f30457c.setClickable(this.f30456b, z);
        this.f30455a.setClickable(z);
    }
}
