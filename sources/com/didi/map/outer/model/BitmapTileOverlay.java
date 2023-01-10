package com.didi.map.outer.model;

import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BitmapTileOverlayControl;

public class BitmapTileOverlay {

    /* renamed from: a */
    private String f30344a;

    /* renamed from: b */
    private final BitmapTileOverlayControl f30345b;

    /* renamed from: c */
    private BitmapTileOverlayOption f30346c;

    public BitmapTileOverlay(BitmapTileOverlayControl bitmapTileOverlayControl, String str, BitmapTileOverlayOption bitmapTileOverlayOption) {
        this.f30345b = bitmapTileOverlayControl;
        this.f30344a = str;
        this.f30346c = bitmapTileOverlayOption;
    }

    public void updateData(Bitmap bitmap, LatLngBounds latLngBounds) {
        this.f30345b.updateData(bitmap, latLngBounds);
    }

    public void remove() {
        this.f30345b.remove(this.f30344a);
    }

    public String getId() {
        return this.f30344a;
    }
}
