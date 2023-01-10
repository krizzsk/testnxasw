package com.didi.hawaii.mapsdkv2.adapter;

import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLUiSetting;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.widget.MapWidgets;
import com.didi.map.alpha.maps.internal.IUiSettingDelegate;

public class UiSettingDelegate implements IUiSettingDelegate {

    /* renamed from: a */
    private final GLUiSetting f26009a;

    /* renamed from: b */
    private final GLBaseMapView f26010b;

    /* renamed from: c */
    private final MapWidgets f26011c;

    public float getLogoMarginRate(int i) {
        return 0.0f;
    }

    public void setLogoAnchor(int i) {
    }

    public void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setLogoMarginRate(int i, float f) {
    }

    public void setScaleAnchor(int i) {
    }

    public void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void showScaleWithMaskLayer(boolean z) {
    }

    public UiSettingDelegate(GLViewManager gLViewManager, MapWidgets mapWidgets) {
        GLBaseMapView baseMap = gLViewManager.getBaseMap();
        this.f26010b = baseMap;
        this.f26009a = baseMap.getUiSetting();
        this.f26011c = mapWidgets;
    }

    public void setZoomControlsEnabled(boolean z) {
        this.f26009a.setZoomControlsEnabled(z);
        this.f26010b.setZoomControlVisible(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f26009a.setCompassEnabled(z);
        this.f26010b.setCompassVisible(z);
    }

    public void setMyLocationButtonEnabled(boolean z) {
        this.f26009a.setMyLocationButtonEnabled(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f26009a.setScrollGesturesEnabled(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f26009a.setZoomGesturesEnabled(z);
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.f26009a.setTiltGesturesEnabled(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f26009a.setRotateGesturesEnabled(z);
    }

    public void setAllGesturesEnabled(boolean z) {
        this.f26009a.setAllGesturesEnabled(z);
    }

    public boolean isZoomControlsEnabled() {
        return this.f26009a.isZoomControlsEnabled();
    }

    public boolean isCompassEnabled() {
        return this.f26009a.isCompassEnabled();
    }

    public boolean isMyLocationButtonEnabled() {
        return this.f26009a.isMyLocationButtonEnabled();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f26009a.isScrollGesturesEnabled();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f26009a.isZoomGesturesEnabled();
    }

    public boolean isTiltGesturesEnabled() {
        return this.f26009a.isTiltGesturesEnabled();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f26009a.isRotateGesturesEnabled();
    }

    public void setScaleAndLogoMode(int i) {
        this.f26011c.setLogoScaleShowMode(i);
    }

    public void setScaleViewLeft(int i) {
        this.f26011c.setScaleViewLeft(i);
    }

    public void setScaleViewBottom(int i) {
        this.f26011c.setScaleViewBottom(i);
    }

    public boolean isScaleVisable() {
        return this.f26011c.isScaleViewVisible();
    }

    public void setLogoLeftMargin(int i) {
        this.f26011c.setLogoViewLeft(i);
    }

    public void setLogoBottomMargin(int i) {
        this.f26011c.setLogoViewBottom(i);
    }
}
