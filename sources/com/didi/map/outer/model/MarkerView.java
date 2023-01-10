package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.MarkerViewControl;

public class MarkerView implements IMapElement {

    /* renamed from: a */
    private final MarkerViewControl f30441a;

    /* renamed from: b */
    private Object f30442b;

    public Rect getBound() {
        return null;
    }

    public RectF getPixel20Bound(float f) {
        return null;
    }

    public MarkerView(MarkerViewControl markerViewControl, Object obj) {
        this.f30441a = markerViewControl;
        this.f30442b = obj;
    }

    public void remove() {
        this.f30441a.remove(this, this.f30442b);
        this.f30442b = null;
    }

    public void setCenter(LatLng latLng) {
        this.f30441a.setCenter(this, this.f30442b, latLng);
    }
}
