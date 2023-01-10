package com.didi.map.outer.model;

import android.graphics.PointF;
import com.didi.map.alpha.maps.internal.BitmapFormater;

public class MarkerOptions extends BaseMarkerOption {

    /* renamed from: a */
    private BitmapDescriptor f30429a;

    /* renamed from: b */
    private float f30430b = 0.5f;

    /* renamed from: c */
    private float f30431c = 1.0f;

    /* renamed from: d */
    private boolean f30432d;

    /* renamed from: e */
    private boolean f30433e = false;

    /* renamed from: f */
    private int f30434f = 0;

    /* renamed from: g */
    private boolean f30435g = false;

    /* renamed from: h */
    private boolean f30436h = false;

    /* renamed from: i */
    private boolean f30437i = false;

    /* renamed from: j */
    private LatLngBounds f30438j;

    /* renamed from: k */
    private long f30439k;

    /* renamed from: l */
    private MarkerInfoWindowOption f30440l = new MarkerInfoWindowOption();

    public long getBubbleId() {
        return this.f30439k;
    }

    public MarkerOptions bubbleId(long j) {
        this.f30439k = j;
        return this;
    }

    public MarkerOptions setMarkerInfoOption(MarkerInfoWindowOption markerInfoWindowOption) {
        this.f30440l = markerInfoWindowOption;
        return this;
    }

    public MarkerInfoWindowOption getInfoWindowOption() {
        return this.f30440l;
    }

    public boolean isCollideRouteLableBubble() {
        return this.f30436h;
    }

    public MarkerOptions setCollideRouteLableBubble(boolean z) {
        this.f30436h = z;
        return this;
    }

    public boolean isNoDistanceScale() {
        return this.isNoDistanceScale;
    }

    public MarkerOptions setNoDistanceScale(boolean z) {
        this.isNoDistanceScale = z;
        return this;
    }

    public MarkerOptions(LatLng latLng) {
        super(latLng);
        this.boVisible = true;
        this.mlatlng = latLng;
    }

    public MarkerOptions() {
        this.boVisible = true;
    }

    public MarkerOptions position(LatLng latLng) {
        this.mlatlng = latLng;
        return this;
    }

    public MarkerOptions ground(boolean z) {
        this.f30437i = z;
        return this;
    }

    public MarkerOptions groundBounds(LatLngBounds latLngBounds) {
        this.f30438j = latLngBounds;
        return this;
    }

    public MarkerOptions infoWindowEnable(boolean z) {
        this.boInfoWindowEnable = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.mFlat = z;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f30429a = bitmapDescriptor;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f30430b = f;
        this.f30431c = f2;
        return this;
    }

    public MarkerOptions title(String str) {
        this.strtitle = str;
        return this;
    }

    public MarkerOptions rotateAngle(float f) {
        this.fAngle = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.strSnippet = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f30432d = z;
        return this;
    }

    public MarkerOptions scaleXY(PointF pointF) {
        this.scaleXY = pointF;
        return this;
    }

    public PointF getScaleXY() {
        return this.scaleXY;
    }

    public MarkerOptions offset(PointF pointF) {
        this.offset = pointF;
        return this;
    }

    public PointF getOffset() {
        return this.offset;
    }

    public MarkerOptions alpha(float f) {
        this.fAlpha = f;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public MarkerOptions is3D(boolean z) {
        this.boIs3D = z;
        return this;
    }

    public MarkerOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public MarkerOptions loggable(boolean z) {
        this.f30433e = z;
        return this;
    }

    public MarkerOptions clickable(boolean z) {
        this.clickable = z;
        return this;
    }

    public boolean getLogaable() {
        return this.f30433e;
    }

    public MarkerOptions avoidAnnocation(boolean z) {
        this.mAvoidAnno = z;
        return this;
    }

    public boolean isAvoidAnnocation() {
        return this.mAvoidAnno;
    }

    public LatLng getPosition() {
        return this.mlatlng;
    }

    public String getTitle() {
        return this.strtitle;
    }

    public String getSnippet() {
        return this.strSnippet;
    }

    public BitmapDescriptor getIcon() {
        if (this.f30429a == null) {
            this.f30429a = new BitmapDescriptor(new BitmapFormater(5));
        }
        return this.f30429a;
    }

    public float getAnchorU() {
        return this.f30430b;
    }

    public float getAnchorV() {
        return this.f30431c;
    }

    public boolean isDraggable() {
        return this.f30432d;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public boolean isInfoWindowEnable() {
        return this.boInfoWindowEnable;
    }

    public float getAlpha() {
        return this.fAlpha;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean is3D() {
        return this.boIs3D;
    }

    public boolean isFlat() {
        return this.mFlat;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public float getRotateAngle() {
        return this.fAngle;
    }

    public int getDisplayLevel() {
        return this.f30434f;
    }

    public MarkerOptions displayLevel(int i) {
        this.f30434f = i;
        return this;
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.f30435g;
    }

    public MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.f30435g = z;
        return this;
    }

    public MarkerOptions clockwise(boolean z) {
        this.mClockwise = z;
        return this;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public boolean is2DGround() {
        return this.f30437i;
    }

    public LatLngBounds groundBounds() {
        return this.f30438j;
    }

    public MarkerOptions infoWindowType(int i) {
        this.infoWindowType = i;
        return this;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }
}
