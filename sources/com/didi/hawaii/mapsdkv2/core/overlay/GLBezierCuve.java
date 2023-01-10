package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Color;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

@GLViewDebug.ExportClass(name = "Polygon")
public class GLBezierCuve extends GLPrimaryShape {
    @GLViewDebug.ExportField(name = "state")

    /* renamed from: a */
    private float f26306a;
    @GLViewDebug.ExportField(name = "start_point")

    /* renamed from: b */
    private GLView.LatLngSafe f26307b;
    @GLViewDebug.ExportField(name = "end_point")

    /* renamed from: c */
    private GLView.LatLngSafe f26308c;
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: d */
    private int f26309d = Color.argb(17, 0, 163, 255);
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: e */
    private float f26310e;
    @GLViewDebug.ExportField(name = "curvature")

    /* renamed from: f */
    private float f26311f;

    /* renamed from: g */
    private double[] f26312g = new double[4];

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public GLBezierCuve(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26306a = option.state;
        this.f26310e = option.width;
        this.f26309d = option.mColor;
        this.f26311f = option.curvature;
        this.f26307b = new GLView.LatLngSafe(option.startPoint.longitude, option.startPoint.latitude);
        this.f26308c = new GLView.LatLngSafe(option.endPoint.longitude, option.endPoint.latitude);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        GLView.LatLngSafe latLngSafe = this.f26307b;
        if (latLngSafe != null && this.f26308c != null) {
            this.f26312g[0] = latLngSafe.getLongitude();
            this.f26312g[1] = this.f26307b.getLatitude();
            this.f26312g[2] = this.f26308c.getLongitude();
            this.f26312g[3] = this.f26308c.getLatitude();
            this.mDisplayId = this.mMapCanvas.drawBezierCurve(this.f26312g, m20775a(this.f26309d), this.f26310e, this.f26311f, this.f26306a);
        }
    }

    /* renamed from: a */
    private int[] m20775a(int i) {
        return new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removePolygon(i);
    }

    public void setState(final float f) {
        if (this.f26306a != f) {
            this.f26306a = f;
            set(new RenderTask() {
                public void run() {
                    GLBezierCuve.this.mMapCanvas.updateBezierCurve(GLBezierCuve.this.mDisplayId, f);
                }
            });
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public float curvature;
        /* access modifiers changed from: private */
        public LatLng endPoint;
        protected int mColor = Color.argb(17, 0, 163, 255);
        /* access modifiers changed from: private */
        public LatLng startPoint;
        /* access modifiers changed from: private */
        public float state = 0.0f;
        /* access modifiers changed from: private */
        public float width;

        public void setStartPoint(LatLng latLng) {
            this.startPoint = latLng;
        }

        public void setEndPoint(LatLng latLng) {
            this.endPoint = latLng;
        }

        public void setmColor(int i) {
            this.mColor = i;
        }

        public void setWidth(float f) {
            this.width = f;
        }

        public void setCurvature(float f) {
            this.curvature = f;
        }

        public void setState(float f) {
            this.state = f;
        }
    }
}
