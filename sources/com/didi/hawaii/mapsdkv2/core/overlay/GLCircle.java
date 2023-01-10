package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

@GLViewDebug.ExportClass(name = "Circle")
public class GLCircle extends GLPrimaryShape {
    public static final int FILL = 1;
    public static final int RING = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f26317a;

    /* renamed from: b */
    private final boolean f26318b;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: c */
    public float f26319c;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "center")

    /* renamed from: d */
    public final LatLng f26320d;
    @GLViewDebug.ExportField(name = "radius")

    /* renamed from: e */
    private float f26321e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f26322f;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: g */
    public int f26323g;

    /* renamed from: a */
    private float m20777a(float f) {
        return f * 10.0f;
    }

    public boolean isClickable() {
        return false;
    }

    public boolean isLongClickable() {
        return false;
    }

    public GLCircle(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26317a = option.type;
        this.f26323g = option.color;
        this.f26320d = new LatLng(option.center);
        this.f26319c = option.width;
        this.f26318b = option.isMask;
        this.f26321e = m20777a(option.radius);
        this.f26322f = m20777a(option.radius);
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setCircleVisible(this.mDisplayId, z);
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setCircleColor(this.mDisplayId, MathsUtils.mixedColorWithAlpha(f, this.f26323g));
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addCircle(this.f26320d, this.f26322f, MathsUtils.mixedColorWithAlpha(this.alpha, this.f26323g), calculateTrueZIndex(this.mLayer, this.zIndex), this.visible, this.f26317a == 2, this.f26319c, this.f26318b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeCircle(i);
    }

    public int getColor() {
        return this.f26323g;
    }

    public void setColor(final int i) {
        if (this.f26323g != i) {
            this.f26323g = i;
            final float f = this.alpha;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleColor(GLCircle.this.mDisplayId, MathsUtils.mixedColorWithAlpha(f, i));
                }
            });
        }
    }

    public LatLng getCenter() {
        return this.f26320d;
    }

    public void setCenter(final LatLng latLng) {
        if (!this.f26320d.equals(latLng)) {
            this.f26320d.longitude = latLng.longitude;
            this.f26320d.latitude = latLng.latitude;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleCenter(GLCircle.this.mDisplayId, latLng);
                }
            });
        }
    }

    public float getRadius() {
        return this.f26321e;
    }

    public void setRadius(float f) {
        float a = m20777a(f);
        if (this.f26322f == 0.0f) {
            this.f26322f = a;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.updateCircle(GLCircle.this.mDisplayId, GLCircle.this.f26320d, GLCircle.this.f26322f, MathsUtils.mixedColorWithAlpha(GLCircle.this.alpha, GLCircle.this.f26323g), GLCircle.calculateTrueZIndex(GLCircle.this.mLayer, GLCircle.this.zIndex), GLCircle.this.visible, GLCircle.this.f26317a == 2, GLCircle.this.f26319c);
                }
            });
        }
        if (this.f26321e != a) {
            this.f26321e = a;
            final float f2 = a / this.f26322f;
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleScale(GLCircle.this.mDisplayId, f2);
                }
            });
        }
    }

    public float getWidth() {
        return this.f26319c;
    }

    public void setWidth(final float f) {
        if (this.f26319c != f && this.f26317a == 2) {
            set(new RenderTask() {
                public void run() {
                    GLCircle.this.mMapCanvas.setCircleRingWidth(GLCircle.this.mDisplayId, f);
                }
            });
        }
    }

    public boolean isMask() {
        return this.f26318b;
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            setColor(((Option) option).color);
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public final LatLng center = new LatLng(0.0d, 0.0d);
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public boolean isMask;
        /* access modifiers changed from: private */
        public float radius;
        /* access modifiers changed from: private */
        public int type = 1;
        /* access modifiers changed from: private */
        public float width;

        public void setCenter(LatLng latLng) {
            this.center.longitude = latLng.longitude;
            this.center.latitude = latLng.latitude;
        }

        public void setIsMask(boolean z) {
            this.isMask = z;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setWidth(float f) {
            this.width = f;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public int getColor() {
            return this.color;
        }

        public float getWidth() {
            return this.width;
        }

        public boolean isMask() {
            return this.isMask;
        }
    }
}
