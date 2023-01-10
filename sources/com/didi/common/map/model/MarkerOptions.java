package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

public final class MarkerOptions extends IMapElementOptions {
    public static final float DEFAULT_SIZE = 20.0f;

    /* renamed from: a */
    private int f12703a = 1;

    /* renamed from: b */
    private LatLng f12704b;

    /* renamed from: c */
    private String f12705c;

    /* renamed from: d */
    private String f12706d;

    /* renamed from: e */
    private BitmapDescriptor f12707e = BitmapDescriptorFactory.defaultMarker();

    /* renamed from: f */
    private float f12708f = 0.5f;

    /* renamed from: g */
    private float f12709g = 1.0f;

    /* renamed from: h */
    private boolean f12710h;

    /* renamed from: i */
    private boolean f12711i = true;

    /* renamed from: j */
    private float f12712j = 0.0f;

    /* renamed from: k */
    private float f12713k = 1.0f;

    /* renamed from: l */
    private boolean f12714l = false;

    /* renamed from: m */
    private boolean f12715m = false;

    /* renamed from: n */
    private float f12716n = 20.0f;

    /* renamed from: o */
    private boolean f12717o;

    public int getVersionCode() {
        return this.f12703a;
    }

    public MarkerOptions alpha(float f) {
        this.f12713k = f;
        return this;
    }

    public MarkerOptions avoidAnnocation(boolean z) {
        this.f12717o = z;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return this.f12717o;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f12708f = f;
        this.f12709g = f2;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f12710h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f12711i = z;
        return this;
    }

    public float getAlpha() {
        return this.f12713k;
    }

    public float getAnchorU() {
        return this.f12708f;
    }

    public float getAnchorV() {
        return this.f12709g;
    }

    public BitmapDescriptor getIcon() {
        return this.f12707e;
    }

    public LatLng getPosition() {
        return this.f12704b;
    }

    public float getRotation() {
        return this.f12712j;
    }

    public String getSnippet() {
        return this.f12706d;
    }

    public String getTitle() {
        return this.f12705c;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f12707e = bitmapDescriptor;
        return this;
    }

    public boolean isDraggable() {
        return this.f12710h;
    }

    public boolean isFlat() {
        return this.f12711i;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f12704b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f12712j = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f12706d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f12705c = str;
        return this;
    }

    public float getSize() {
        return this.f12716n;
    }

    public MarkerOptions size(float f) {
        this.f12716n = f;
        return this;
    }

    public MarkerOptions clockwise(boolean z) {
        this.f12714l = z;
        return this;
    }

    public boolean isClockwise() {
        return this.f12714l;
    }

    public MarkerOptions dodgeAnnotation(boolean z) {
        this.f12715m = z;
        return this;
    }

    public boolean isDodgeAnnotation() {
        return this.f12715m;
    }
}
