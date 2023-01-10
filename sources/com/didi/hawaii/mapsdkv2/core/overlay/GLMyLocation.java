package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderCircle;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.map.outer.model.LatLng;

public class GLMyLocation extends GLOverlayGroup {

    /* renamed from: a */
    private GLMarker f26365a;

    /* renamed from: b */
    private GLBorderCircle f26366b;

    /* renamed from: c */
    private Option f26367c;

    public void setAnchor(float f, float f2) {
    }

    public GLMyLocation(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26367c = option;
        m20823a();
        m20825c();
    }

    public GLView getCarMarker() {
        return this.f26365a;
    }

    public void setAngle(float f) {
        this.f26367c.setAngle(f);
        this.f26365a.setAngle(f);
    }

    public void setRadius(float f) {
        this.f26367c.setRadius(f);
        m20825c();
        GLBorderCircle gLBorderCircle = this.f26366b;
        if (gLBorderCircle != null) {
            gLBorderCircle.setRadius(f);
        }
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f26367c.setCenter(latLng);
            super.beginSetTransaction();
            GLMarker gLMarker = this.f26365a;
            if (gLMarker != null) {
                gLMarker.setPosition(latLng);
            }
            GLBorderCircle gLBorderCircle = this.f26366b;
            if (gLBorderCircle != null) {
                gLBorderCircle.setCenter(latLng);
            }
            super.commitSetTransaction();
        }
    }

    public void setTexture(Texture texture) {
        this.f26367c.setTexture(texture);
        GLMarker gLMarker = this.f26365a;
        if (gLMarker != null) {
            gLMarker.updateOption(m20824b());
        }
    }

    /* renamed from: a */
    private void m20823a() {
        if (this.f26365a == null) {
            GLMarker gLMarker = new GLMarker(this.mViewManager, m20824b());
            this.f26365a = gLMarker;
            super.addView(gLMarker);
        }
    }

    /* renamed from: b */
    private GLMarker.Option m20824b() {
        GLMarker.Option option = new GLMarker.Option();
        option.setPosition(this.f26367c.center.longitude, this.f26367c.center.latitude);
        option.setTexture(this.f26367c.texture);
        option.setAngle(this.f26367c.angle);
        option.setClockwise(true);
        option.setFlat(true);
        option.setZIndex(Integer.valueOf(this.f26367c.getzIndex() + 1));
        return option;
    }

    /* renamed from: c */
    private void m20825c() {
        if (this.f26367c.showRing && this.f26366b == null && 0.0f < this.f26367c.radius) {
            GLBorderCircle.Option option = new GLBorderCircle.Option();
            option.setColor(this.f26367c.color);
            option.setRadius(this.f26367c.radius);
            option.setCenter(this.f26367c.center);
            option.setBorderWidth(this.f26367c.borderWidth);
            option.setBorderColor(this.f26367c.borderColor);
            GLBorderCircle gLBorderCircle = new GLBorderCircle(this.mViewManager, option);
            this.f26366b = gLBorderCircle;
            super.addView(gLBorderCircle);
        }
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public float angle;
        /* access modifiers changed from: private */
        public int borderColor;
        /* access modifiers changed from: private */
        public float borderWidth;
        /* access modifiers changed from: private */
        public LatLng center = new LatLng(0.0d, 0.0d);
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public float radius;
        /* access modifiers changed from: private */
        public boolean showRing;
        /* access modifiers changed from: private */
        public Texture texture;

        public void setRadius(float f) {
            this.radius = f;
        }

        public void setCenter(LatLng latLng) {
            this.center.latitude = latLng.latitude;
            this.center.longitude = latLng.longitude;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public void setBorderWidth(float f) {
            this.borderWidth = f;
        }

        public void setBorderColor(int i) {
            this.borderColor = i;
        }

        public void setAngle(float f) {
            this.angle = f;
        }

        public void setTexture(Texture texture2) {
            this.texture = texture2;
        }

        public void setShowRing(boolean z) {
            this.showRing = z;
        }
    }
}
