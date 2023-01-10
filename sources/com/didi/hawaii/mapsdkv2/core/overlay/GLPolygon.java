package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import java.util.Arrays;

@GLViewDebug.ExportClass(name = "Polygon")
public class GLPolygon extends GLPrimaryShape {
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: a */
    public int f26368a;
    @GLViewDebug.ExportField(name = "points")

    /* renamed from: b */
    private final LatLng[] f26369b;
    @GLViewDebug.ExportField(name = "forceload")

    /* renamed from: c */
    private final boolean f26370c;

    public final boolean isLongClickable() {
        return false;
    }

    public GLPolygon(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26368a = option.color;
        this.f26369b = (LatLng[]) Arrays.copyOf(option.pts, option.pts.length);
        this.bellowRoute = option.bellowRoute;
        this.f26370c = option.isForceLoad;
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setPolygonVisible(this.mDisplayId, z);
    }

    public void updatePoints(final LatLng[] latLngArr) {
        set(new RenderTask() {
            public void run() {
                GLPolygon.this.mMapCanvas.updatePolygon(GLPolygon.this.mDisplayId, latLngArr, GLPolygon.this.f26368a, GLPolygon.calculateTrueZIndex(GLPolygon.this.mLayer, GLPolygon.this.zIndex), GLPolygon.this.alpha, GLPolygon.this.visible);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setPolygonAlpha(this.mDisplayId, f);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addPolygon(this.f26369b, this.f26368a, calculateTrueZIndex(this.mLayer, this.zIndex), this.alpha, this.visible, this.f26370c);
        this.mMapCanvas.setBellowRoute(this.mDisplayId, this.bellowRoute);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removePolygon(i);
    }

    public int getColor() {
        return this.f26368a;
    }

    public void setColor(final int i) {
        if (this.f26368a != i) {
            this.f26368a = i;
            set(new RenderTask() {
                public void run() {
                    GLPolygon.this.mMapCanvas.setPolygonColor(GLPolygon.this.mDisplayId, i);
                }
            });
        }
    }

    public LatLng[] getPts() {
        LatLng[] latLngArr = this.f26369b;
        return (LatLng[]) Arrays.copyOf(latLngArr, latLngArr.length);
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            Option option2 = (Option) option;
            setColor(option2.color);
            setBellowRoute(option2.bellowRoute);
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public boolean bellowRoute = false;
        private boolean clickable = false;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isForceLoad = false;
        /* access modifiers changed from: private */
        public LatLng[] pts = new LatLng[0];

        public void setForceLoad(boolean z) {
            this.isForceLoad = z;
        }

        public void setBellowRoute(boolean z) {
            this.bellowRoute = z;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setPts(LatLng[] latLngArr) {
            this.pts = latLngArr;
        }

        public void setClickable(boolean z) {
            this.clickable = z;
        }
    }
}
