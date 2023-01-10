package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.util.DDMathUtil;
import com.didi.common.map.util.DDSphericalUtil;

public class GroundOverlayOptions extends IMapElementOptions {

    /* renamed from: a */
    private float f12654a = 0.5f;

    /* renamed from: b */
    private float f12655b = 0.5f;

    /* renamed from: c */
    private LatLng f12656c;

    /* renamed from: d */
    private float f12657d;

    /* renamed from: e */
    private float f12658e;

    /* renamed from: f */
    private float f12659f;

    /* renamed from: g */
    private BitmapDescriptor f12660g;

    /* renamed from: h */
    private float f12661h;

    /* renamed from: i */
    private LatLngBounds f12662i;

    public float getAlpha() {
        return this.f12661h;
    }

    public GroundOverlayOptions transparency(float f) {
        this.f12661h = f;
        return this;
    }

    public float getAnchorU() {
        return this.f12654a;
    }

    public GroundOverlayOptions anchorU(float f) {
        this.f12654a = f;
        return this;
    }

    public float getAnchorV() {
        return this.f12655b;
    }

    public GroundOverlayOptions anchorV(float f) {
        this.f12655b = f;
        return this;
    }

    public LatLng getPosition() {
        return this.f12656c;
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        this.f12656c = latLng;
        this.f12657d = f;
        this.f12658e = f2;
        this.f12662i = m10735a(latLng, f, f2);
        return this;
    }

    public GroundOverlayOptions position(LatLngBounds latLngBounds) {
        this.f12662i = latLngBounds;
        return this;
    }

    public LatLngBounds getBounds() {
        return this.f12662i;
    }

    public float getWidth() {
        return this.f12657d;
    }

    public float getHeight() {
        return this.f12658e;
    }

    public float getBearing() {
        return this.f12659f;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f12659f = f;
        return this;
    }

    public BitmapDescriptor getImage() {
        return this.f12660g;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f12660g = bitmapDescriptor;
        return this;
    }

    /* renamed from: a */
    private LatLngBounds m10735a(LatLng latLng, float f, float f2) {
        double computeAngle = DDMathUtil.computeAngle(f, f2);
        double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2))) / 2.0d;
        return new LatLngBounds(DDSphericalUtil.computeOffsetOrigin(latLng, sqrt, computeAngle), DDSphericalUtil.computeOffsetOrigin(latLng, sqrt, DDMathUtil.computeAngle(f, f2) + 180.0d));
    }
}
