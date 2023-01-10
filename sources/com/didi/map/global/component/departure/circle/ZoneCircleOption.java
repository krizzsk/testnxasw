package com.didi.map.global.component.departure.circle;

import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import java.util.Observable;

public class ZoneCircleOption extends Observable {

    /* renamed from: a */
    private boolean f27292a = false;

    /* renamed from: b */
    private LatLng f27293b;

    /* renamed from: c */
    private float f27294c;

    /* renamed from: d */
    private int f27295d = -10366036;

    /* renamed from: e */
    private int f27296e = -1999639054;

    /* renamed from: f */
    private CircleOptions f27297f;

    public ZoneCircleOption(LatLng latLng, float f) {
        CircleOptions circleOptions = new CircleOptions();
        this.f27297f = circleOptions;
        this.f27293b = latLng;
        this.f27294c = f;
        circleOptions.center(latLng).radius((double) f);
    }

    public ZoneCircleOption stroke(int i, int i2) {
        this.f27296e = i2;
        this.f27297f.strokeWidth((float) i).strokeColor(i2);
        return this;
    }

    public ZoneCircleOption fillColor(int i) {
        this.f27295d = i;
        this.f27297f.fillColor(i);
        return this;
    }

    public ZoneCircleOption allowDragToOuter(boolean z) {
        this.f27292a = z;
        return this;
    }

    public int getFillColor() {
        return this.f27295d;
    }

    public int getStrokeColor() {
        return this.f27296e;
    }

    public CircleOptions getCircleOptions() {
        return this.f27297f;
    }

    public boolean isAllowDragToOuter() {
        return this.f27292a;
    }

    public LatLng getCenter() {
        return this.f27293b;
    }

    public float getRadius() {
        return this.f27294c;
    }
}
