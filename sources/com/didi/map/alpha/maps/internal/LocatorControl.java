package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.CompassDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Locator;
import java.util.List;

public final class LocatorControl {

    /* renamed from: a */
    private final ILocatorDelegate f26787a;

    public void stopNavigate() {
    }

    public LocatorControl(ILocatorDelegate iLocatorDelegate) {
        this.f26787a = iLocatorDelegate;
    }

    public void setCarVisible(boolean z) {
        this.f26787a.setCarVisible(z);
    }

    public boolean isCarVisible() {
        return this.f26787a.isCarVisible();
    }

    public boolean isCompassVisible() {
        return this.f26787a.isCompassVisible();
    }

    public void setCompassVisible(boolean z) {
        this.f26787a.setCompassVisible(z);
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        this.f26787a.setPositionAndAngle(latLng, f);
    }

    public LatLng getPosition() {
        return this.f26787a.getPosition();
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f26787a.setCarIcon(bitmapDescriptor);
    }

    public RectF getPiexBound(float f) {
        return this.f26787a.getPiexBound(f);
    }

    public void setCompassIcon(CompassDescriptor compassDescriptor) {
        this.f26787a.setCompassIcon(compassDescriptor);
    }

    public Locator getLocator() {
        return this.f26787a.getLocator(this);
    }

    public float getAngle() {
        return this.f26787a.getAngle();
    }

    public void setCarZIndex(float f) {
        this.f26787a.setCarZIndex(f);
    }

    public void setCompassZIndex(float f) {
        this.f26787a.setCompassZIndex(f);
    }

    public void setNaviMode(int i) {
        this.f26787a.setNaviMode(i);
    }

    public int getNaviMode() {
        return this.f26787a.getNaviMode();
    }

    public Rect getBound() {
        return this.f26787a.getBound();
    }

    public Rect getScreenBound() {
        return this.f26787a.getScreenBound();
    }

    public void showGuideLine(boolean z) {
        this.f26787a.showGuideLine(z);
    }

    public void setDestination(LatLng latLng) {
        this.f26787a.setDestination(latLng);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        return this.f26787a.navigateToPosition(z, latLng, f, f2, i, i2, z2, j, j2);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        this.f26787a.navigateToPosition(z, latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        this.f26787a.navigateToPosition(z, latLng, f, f2, f3, f4);
    }

    public void navigateToPosition(boolean z, float f, float f2, float f3, float f4, float f5, List<LatLng> list, int i, int i2, LatLng latLng) {
        this.f26787a.navigateToPosition(z, f, f2, f3, f4, f5, list, i, i2, latLng);
    }
}
