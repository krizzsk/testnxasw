package com.didi.map.outer.map;

import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;

public class MapOptions {

    /* renamed from: a */
    private static final double f30308a = 116.306178d;

    /* renamed from: b */
    private static final double f30309b = 40.053036d;

    /* renamed from: c */
    private boolean f30310c = false;

    /* renamed from: d */
    private boolean f30311d;

    /* renamed from: e */
    private boolean f30312e;

    /* renamed from: f */
    private boolean f30313f;

    /* renamed from: g */
    private boolean f30314g = false;

    /* renamed from: h */
    private boolean f30315h = false;

    /* renamed from: i */
    private boolean f30316i = false;

    /* renamed from: j */
    private int f30317j;

    /* renamed from: k */
    private int f30318k = 0;

    /* renamed from: l */
    private float f30319l = 35.0f;

    /* renamed from: m */
    private CameraPosition f30320m = new CameraPosition(new LatLng((double) f30309b, (double) f30308a), 17.0f, 0.0f, 0.0f);

    public boolean isMediaOverlay() {
        return this.f30315h;
    }

    public void setMediaOverlay(boolean z) {
        this.f30315h = z;
    }

    public MapOptions isNight(boolean z) {
        this.f30311d = z;
        return this;
    }

    public MapOptions isNavi(boolean z) {
        this.f30312e = z;
        return this;
    }

    public MapOptions isTraffic(boolean z) {
        this.f30313f = z;
        return this;
    }

    public MapOptions maxSkewAngle(float f) {
        this.f30319l = f;
        return this;
    }

    public MapOptions isDynamicLayerEnable(boolean z) {
        this.f30316i = z;
        return this;
    }

    public MapOptions useBetterDisplay(boolean z) {
        this.f30314g = z;
        return this;
    }

    public MapOptions useTextureMapView(boolean z) {
        this.f30310c = z;
        return this;
    }

    public int getMapTheme() {
        return this.f30317j;
    }

    public void setMapTheme(int i) {
        this.f30317j = i;
    }

    public MapOptions cameraPosition(CameraPosition cameraPosition) {
        this.f30320m = cameraPosition;
        return this;
    }

    public MapOptions setLanguage(int i) {
        this.f30318k = i;
        return this;
    }

    public static MapOptions createDefaultOptions() {
        return new MapOptions().isNight(false).isNavi(false).isTraffic(false).cameraPosition(new CameraPosition(new LatLng((double) f30309b, (double) f30308a), 17.0f, 0.0f, 0.0f));
    }

    public boolean isNight() {
        return this.f30311d;
    }

    public boolean isNavi() {
        return this.f30312e;
    }

    public boolean isTraffic() {
        return this.f30313f;
    }

    public boolean isBetterDisplay() {
        return this.f30314g;
    }

    public CameraPosition getCameraPosition() {
        return this.f30320m;
    }

    public boolean isUseTextureMapView() {
        return this.f30310c;
    }

    public int getLanguage() {
        return this.f30318k;
    }

    public float getMaxSkewAngle() {
        return this.f30319l;
    }

    public boolean isDynamicLayerEnable() {
        return this.f30316i;
    }
}
