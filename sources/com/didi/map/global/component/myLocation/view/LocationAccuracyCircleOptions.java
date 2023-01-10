package com.didi.map.global.component.myLocation.view;

import com.didi.common.map.model.LatLng;

public class LocationAccuracyCircleOptions {

    /* renamed from: a */
    private LatLng f28348a;

    /* renamed from: b */
    private float f28349b;

    /* renamed from: c */
    private float f28350c;

    /* renamed from: d */
    private float f28351d;

    public LatLng getPosition() {
        return this.f28348a;
    }

    public void setPosition(LatLng latLng) {
        this.f28348a = latLng;
    }

    public float getAccuracy() {
        return this.f28349b;
    }

    public void setAccuracy(float f) {
        this.f28349b = f;
    }

    public float getDefMinAccuracy() {
        return this.f28350c;
    }

    public void setDefMinAccuracy(float f) {
        this.f28350c = f;
    }

    public float getDefMaxAccuracy() {
        return this.f28351d;
    }

    public void setDefMaxAccuracy(float f) {
        this.f28351d = f;
    }

    public String toString() {
        return "LocationAccuracyCircleOptions{position=" + this.f28348a + ", accuracy=" + this.f28349b + ", defMinAccuracy=" + this.f28350c + ", defMaxAccuracy=" + this.f28351d + '}';
    }
}
