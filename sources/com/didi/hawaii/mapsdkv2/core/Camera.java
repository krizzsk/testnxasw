package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.MapTransform;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.map.outer.model.LatLng;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public final class Camera {
    public static final float MAX_SCALE = 4.0f;
    public static final float MAX_SCALE_LEVEL = 22.0f;
    public static final float MIN_SCALE = 1.5258789E-5f;
    public static final int MIN_SCALE_LEVEL = 4;

    /* renamed from: a */
    private final LatLng f26057a;

    /* renamed from: b */
    private float f26058b;

    /* renamed from: c */
    private float f26059c;

    /* renamed from: d */
    private float f26060d;

    /* renamed from: e */
    private float f26061e;

    public Camera(LatLng latLng, float f, float f2, float f3) {
        this.f26057a = new LatLng(latLng);
        this.f26058b = f;
        m20592a();
        this.f26059c = f2;
        this.f26060d = f3;
    }

    public Camera(Camera camera) {
        this.f26057a = new LatLng(camera.f26057a);
        this.f26058b = camera.f26058b;
        this.f26061e = camera.f26061e;
        this.f26059c = camera.f26059c;
        this.f26060d = camera.f26060d;
    }

    public synchronized void setCamera(Camera camera) {
        this.f26057a.longitude = camera.f26057a.longitude;
        this.f26057a.latitude = camera.f26057a.latitude;
        this.f26058b = camera.f26058b;
        this.f26061e = camera.f26061e;
        this.f26059c = MapTransform.normalizeRotate(camera.f26059c);
        this.f26060d = camera.f26060d;
    }

    public synchronized void set(LatLng latLng, float f, float f2, float f3) {
        this.f26057a.longitude = latLng.longitude;
        this.f26057a.latitude = latLng.latitude;
        this.f26058b = f;
        m20592a();
        this.f26059c = MapTransform.normalizeRotate(f2);
        this.f26060d = f3;
    }

    /* renamed from: a */
    private void m20592a() {
        this.f26061e = (float) MathsUtils.getScaleLevel((double) this.f26058b);
    }

    public synchronized LatLng getCenter() {
        return this.f26057a;
    }

    public synchronized void setCenter(LatLng latLng) {
        this.f26057a.longitude = latLng.longitude;
        this.f26057a.latitude = latLng.latitude;
    }

    public synchronized float getScale() {
        return this.f26058b;
    }

    public synchronized void setScale(float f) {
        this.f26058b = f;
        m20592a();
    }

    public float getRotate() {
        return this.f26059c;
    }

    public void setRotate(float f) {
        this.f26059c = MapTransform.normalizeRotate(f);
    }

    public float getSkew() {
        return this.f26060d;
    }

    public void setSkew(float f) {
        this.f26060d = f;
    }

    public synchronized float getScaleLevel() {
        return this.f26061e;
    }

    public synchronized Camera copy() {
        return new Camera(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Camera) {
            Camera camera = (Camera) obj;
            return camera.f26058b == this.f26058b && camera.f26059c == this.f26059c && camera.f26057a.equals(this.f26057a) && camera.f26060d == this.f26060d;
        }
    }

    public String toString() {
        return "[center:" + this.f26057a + ", skew:" + this.f26060d + ", rotate:" + this.f26059c + ", scale:" + this.f26058b + ", scaleLevel:" + this.f26061e + Const.jaRight;
    }
}
