package com.didi.map.outer.model;

import android.graphics.Bitmap;

public class BitmapTileOverlayOption {

    /* renamed from: a */
    private LatLngBounds f30347a;

    /* renamed from: b */
    private Bitmap f30348b;

    public LatLngBounds getBounds() {
        return this.f30347a;
    }

    public BitmapTileOverlayOption latlngBounds(LatLngBounds latLngBounds) {
        this.f30347a = latLngBounds;
        return this;
    }

    public Bitmap getBitmap() {
        return this.f30348b;
    }

    public BitmapTileOverlayOption bitmap(Bitmap bitmap) {
        this.f30348b = bitmap;
        return this;
    }
}
