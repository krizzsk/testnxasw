package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLOverlayLayer;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;

@GLViewDebug.ExportClass(name = "MaskLayer")
public class GLMaskLayer extends GLOverlayView {
    @GLViewDebug.ExportField(name = "color")

    /* renamed from: a */
    private int f26362a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f26363b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f26364c;

    public boolean isClickable() {
        return false;
    }

    public boolean isLongClickable() {
        return false;
    }

    public GLMaskLayer(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option, GLOverlayLayer.MASKLAYER, true);
        this.f26362a = option.color;
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setMaskLayerVisible(this.mDisplayId, z);
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        this.mMapCanvas.setMaskLayerAlpha(this.mDisplayId, f);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mDisplayId = this.mMapCanvas.addMaskLayer(this.f26362a, this.f26363b, this.f26364c, this.zIndex);
    }

    /* access modifiers changed from: protected */
    public void onHostSizeChanged(int i, int i2) {
        super.onHostSizeChanged(i, i2);
        if (this.f26364c != i2 || this.f26363b != i) {
            this.f26364c = i2;
            this.f26363b = i;
            this.mMapCanvas.setMaskLayerWidthHeightColor(this.mDisplayId, i, i2, this.f26362a);
        }
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            setColor(((Option) option).color);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeMaskLayer(i);
    }

    public int getColor() {
        return this.f26362a;
    }

    public void setColor(final int i) {
        if (this.f26362a != i) {
            this.f26362a = i;
            set(new RenderTask() {
                public void run() {
                    GLMaskLayer.this.mMapCanvas.setMaskLayerWidthHeightColor(GLMaskLayer.this.mDisplayId, GLMaskLayer.this.f26363b, GLMaskLayer.this.f26364c, i);
                }
            });
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public int color;

        public void setColor(int i) {
            this.color = i;
        }
    }
}
