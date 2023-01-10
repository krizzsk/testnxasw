package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Color;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import java.util.Arrays;

@GLViewDebug.ExportClass(name = "Polyline")
public class GLPolyline extends GLPrimaryShape {
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: a */
    public int f26371a;
    @GLViewDebug.ExportField(name = "points")

    /* renamed from: b */
    private LatLng[] f26372b;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: c */
    public float f26373c;
    @GLViewDebug.ExportField(name = "forceload")

    /* renamed from: d */
    private final boolean f26374d;

    public final boolean isClickable() {
        return false;
    }

    public final boolean isLongClickable() {
        return false;
    }

    public GLPolyline(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26371a = option.color;
        this.f26372b = (LatLng[]) Arrays.copyOf(option.pts, option.pts.length);
        this.f26373c = option.width;
        this.bellowRoute = option.bellowRoute;
        this.f26374d = option.isForceLoad;
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setPolylineVisible(this.mDisplayId, z);
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setPolylineAlpha(this.mDisplayId, f);
    }

    public void setWidth(final float f) {
        if (this.f26373c != f) {
            this.f26373c = f;
            set(new RenderTask() {
                public void run() {
                    GLPolyline.this.mMapCanvas.setPolylineWidth(GLPolyline.this.mDisplayId, f);
                }
            });
        }
    }

    public float getWidth() {
        return this.f26373c;
    }

    public void setAlpha(final float f) {
        if (this.alpha != f) {
            this.alpha = f;
            this.f26371a = Color.argb((int) (255.0f * f), Color.red(this.f26371a), Color.green(this.f26371a), Color.blue(this.f26371a));
            set(new RenderTask() {
                public void run() {
                    GLPolyline.this.onSetAlpha(f);
                }
            });
        }
    }

    public void setColor(final int i) {
        if (this.f26371a != i) {
            this.f26371a = i;
            this.alpha = (float) Color.alpha(i);
            set(new RenderTask() {
                public void run() {
                    GLPolyline.this.mMapCanvas.setPolylineColor(GLPolyline.this.mDisplayId, i);
                }
            });
        }
    }

    public int getColor() {
        return this.f26371a;
    }

    public void setPts(final LatLng[] latLngArr) {
        this.f26372b = (LatLng[]) Arrays.copyOf(latLngArr, latLngArr.length);
        set(new RenderTask() {
            public void run() {
                GLPolyline.this.mMapCanvas.updatePolyline(GLPolyline.this.mDisplayId, latLngArr, GLPolyline.this.f26371a, GLPolyline.this.f26373c, GLPolyline.calculateTrueZIndex(GLPolyline.this.mLayer, GLPolyline.this.zIndex), GLPolyline.this.alpha, GLPolyline.this.visible);
            }
        });
    }

    public LatLng[] getPts() {
        LatLng[] latLngArr = this.f26372b;
        return (LatLng[]) Arrays.copyOf(latLngArr, latLngArr.length);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addPolyline(this.f26372b, this.f26371a, this.f26373c, calculateTrueZIndex(this.mLayer, this.zIndex), this.alpha, this.visible, this.f26374d);
        this.mMapCanvas.setBellowRoute(this.mDisplayId, this.bellowRoute);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removePolyline(i);
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            Option option2 = (Option) option;
            setColor(option2.color);
            setWidth(option2.width);
            setBellowRoute(option2.bellowRoute);
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public boolean bellowRoute = false;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isForceLoad = false;
        /* access modifiers changed from: private */
        public LatLng[] pts = new LatLng[0];
        /* access modifiers changed from: private */
        public float width;

        public void setForceLoad(boolean z) {
            this.isForceLoad = z;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setBellowRoute(boolean z) {
            this.bellowRoute = z;
        }

        public void setPts(LatLng[] latLngArr) {
            this.pts = latLngArr;
        }

        public void setWidth(float f) {
            this.width = f;
        }
    }
}
