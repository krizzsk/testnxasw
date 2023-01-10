package com.didi.map.outer.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.hawaii.utils.BitmapUtil;

public class BubbleOptions {

    /* renamed from: a */
    private Marker f30350a;

    /* renamed from: b */
    private String f30351b;

    /* renamed from: c */
    private LatLng f30352c;

    /* renamed from: d */
    private int f30353d = 0;

    /* renamed from: e */
    private int f30354e = 0;

    /* renamed from: f */
    private float f30355f = 0.5f;

    /* renamed from: g */
    private float f30356g = 0.5f;

    /* renamed from: h */
    private int f30357h = 0;

    /* renamed from: i */
    private View f30358i;

    /* renamed from: j */
    private Drawable[] f30359j = null;

    /* renamed from: k */
    private boolean f30360k = false;

    public BubbleOptions marker(Marker marker) {
        this.f30350a = marker;
        position(marker.getPosition());
        markerAnchor(marker.getAnchorU(), marker.getAnchorV());
        return this;
    }

    public Marker getMarker() {
        return this.f30350a;
    }

    public BubbleOptions markerSize(int i, int i2) {
        this.f30353d = i;
        this.f30354e = i2;
        return this;
    }

    public int getMarkerWidth() {
        return this.f30353d;
    }

    public int getMarkerHeight() {
        return this.f30354e;
    }

    public BubbleOptions markerAnchor(float f, float f2) {
        this.f30355f = f;
        this.f30356g = f2;
        return this;
    }

    public float getMarkerAnchorU() {
        return this.f30355f;
    }

    public float getMarkerAnchorV() {
        return this.f30356g;
    }

    public BubbleOptions content(String str) {
        this.f30351b = str;
        return this;
    }

    public String getContent() {
        return this.f30351b;
    }

    public BubbleOptions position(LatLng latLng) {
        this.f30352c = latLng;
        return this;
    }

    public LatLng getPosition() {
        return this.f30352c;
    }

    public BubbleOptions displayLevel(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f30357h = i;
        return this;
    }

    public int getDisplayLevel() {
        return this.f30357h;
    }

    public BubbleOptions contentView(View view) {
        this.f30358i = view;
        return this;
    }

    public View getContentView() {
        return this.f30358i;
    }

    public BubbleOptions background(Drawable[] drawableArr) {
        this.f30359j = drawableArr;
        return this;
    }

    public BubbleOptions background(Bitmap[] bitmapArr) {
        if (bitmapArr != null) {
            this.f30359j = new Drawable[4];
            int length = bitmapArr.length;
            for (int i = 0; i < length; i++) {
                this.f30359j[i] = BitmapUtil.bitmapToDrawable(bitmapArr[i]);
            }
        }
        return this;
    }

    public Drawable[] getBackground() {
        return this.f30359j;
    }

    public BubbleOptions setOnTapHidden(boolean z) {
        this.f30360k = z;
        return this;
    }

    public boolean getOnTapHidden() {
        return this.f30360k;
    }
}
