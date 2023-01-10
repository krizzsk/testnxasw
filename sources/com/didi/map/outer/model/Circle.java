package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.CircleControl;
import com.didi.map.common.utils.TransformUtil;

public final class Circle implements IMapElement {

    /* renamed from: a */
    private CircleOptions f30365a = null;

    /* renamed from: b */
    private String f30366b = "";

    /* renamed from: c */
    private CircleControl f30367c = null;

    public int hashCode() {
        return 0;
    }

    public Circle(CircleOptions circleOptions, CircleControl circleControl, String str) {
        this.f30366b = str;
        this.f30365a = circleOptions;
        this.f30367c = circleControl;
    }

    public boolean contains(LatLng latLng) {
        return TransformUtil.distanceBetween(getCenter().latitude, getCenter().longitude, latLng.latitude, latLng.longitude) <= getRadius();
    }

    public void setCenter(LatLng latLng) {
        CircleControl circleControl = this.f30367c;
        if (circleControl != null) {
            circleControl.circle_setCenter(this.f30366b, latLng);
            this.f30365a.center(latLng);
        }
    }

    public LatLng getCenter() {
        return new LatLng(this.f30365a.getCenter().latitude, this.f30365a.getCenter().longitude);
    }

    public LatLngBounds getLatLngBounds() {
        CircleOptions circleOptions = this.f30365a;
        if (circleOptions == null) {
            return null;
        }
        return this.f30367c.getBound(new LatLng(circleOptions.getCenter().latitude, this.f30365a.getCenter().longitude), this.f30365a.getRadius());
    }

    public void setRadius(double d) {
        CircleControl circleControl;
        if (d >= 0.0d && (circleControl = this.f30367c) != null) {
            circleControl.circle_setRadius(this.f30366b, d);
            this.f30365a.radius(d);
        }
    }

    public double getRadius() {
        return this.f30365a.getRadius();
    }

    public void setStrokeWidth(float f) {
        if (f >= 0.0f) {
            this.f30367c.circle_setStrokeWidth(this.f30366b, f);
            this.f30365a.strokeWidth(f);
        }
    }

    public float getStrokeWidth() {
        return this.f30365a.getStrokeWidth();
    }

    public void setStrokeColor(int i) {
        this.f30367c.circle_setStrokeColor(this.f30366b, i);
        this.f30365a.strokeColor(i);
    }

    public int getStrokeColor() {
        return this.f30365a.getStrokeColor();
    }

    public void setFillColor(int i) {
        this.f30367c.circle_setFillColor(this.f30366b, i);
        this.f30365a.fillColor(i);
    }

    public int getFillColor() {
        return this.f30365a.getFillColor();
    }

    public void setZIndex(float f) {
        this.f30367c.circle_setZIndex(this.f30366b, f);
        this.f30365a.zIndex(f);
    }

    public float getZIndex() {
        return this.f30365a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f30367c.circle_setVisible(this.f30366b, z);
        this.f30365a.visible(z);
    }

    public boolean isVisible() {
        return this.f30365a.isVisible();
    }

    public void setOptions(CircleOptions circleOptions) {
        this.f30367c.setOptions(this.f30366b, circleOptions);
        this.f30365a = circleOptions;
    }

    public void remove() {
        CircleControl circleControl = this.f30367c;
        if (circleControl != null) {
            circleControl.circle_remove(this.f30366b);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        return this.f30366b.equals(((Circle) obj).f30366b);
    }

    public Rect getBound() {
        CircleControl circleControl = this.f30367c;
        if (circleControl == null) {
            return new Rect();
        }
        return circleControl.getBound(this.f30366b);
    }

    public RectF getPixel20Bound(float f) {
        CircleControl circleControl = this.f30367c;
        if (circleControl == null) {
            return null;
        }
        return circleControl.getPixel20Bound(this.f30366b, f);
    }
}
