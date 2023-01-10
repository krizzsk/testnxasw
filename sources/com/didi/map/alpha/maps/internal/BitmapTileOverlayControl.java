package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import com.didi.map.outer.model.BitmapTileOverlay;
import com.didi.map.outer.model.BitmapTileOverlayOption;
import com.didi.map.outer.model.LatLngBounds;

public class BitmapTileOverlayControl {

    /* renamed from: a */
    private final IBitmapTileOverlayDelegate f26718a;

    public BitmapTileOverlayControl(IBitmapTileOverlayDelegate iBitmapTileOverlayDelegate) {
        this.f26718a = iBitmapTileOverlayDelegate;
    }

    public BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption) {
        return this.f26718a.addBitmapTileOverlay(bitmapTileOverlayOption, this);
    }

    public void updateData(Bitmap bitmap, LatLngBounds latLngBounds) {
        this.f26718a.updateData(bitmap, latLngBounds);
    }

    public void remove(String str) {
        this.f26718a.remove(str);
    }
}
