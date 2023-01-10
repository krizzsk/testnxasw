package com.didi.map.outer.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BitmapFormater;

public final class BitmapDescriptor {

    /* renamed from: a */
    private BitmapFormater f30343a = null;

    BitmapDescriptor(BitmapFormater bitmapFormater) {
        this.f30343a = bitmapFormater;
    }

    public BitmapFormater getFormater() {
        return this.f30343a;
    }

    public Bitmap getBitmap(Context context) {
        BitmapFormater bitmapFormater = this.f30343a;
        if (bitmapFormater == null) {
            return null;
        }
        return bitmapFormater.getBitmap(context);
    }
}
