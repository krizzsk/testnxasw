package com.didi.hawaii.mapsdkv2.adapter;

import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLMaskLayerOptionAdapter;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMaskLayer;
import com.didi.map.alpha.maps.internal.IMaskLayerDelegate;
import com.didi.map.alpha.maps.internal.MaskLayerControl;
import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;
import java.util.Map;

public final class MaskLayerDelegate extends C9761b implements IMaskLayerDelegate {

    /* renamed from: b */
    private static final GLMaskLayerOptionAdapter f25982b = new GLMaskLayerOptionAdapter();

    /* renamed from: c */
    private MaskLayer f25983c;

    /* renamed from: d */
    private MaskLayerOptions f25984d;

    /* renamed from: e */
    private GLMaskLayer f25985e;

    public String getId() {
        return null;
    }

    public boolean isClickable() {
        return false;
    }

    public void removeMaskLayer(long j) {
    }

    public MaskLayerDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions, MaskLayerControl maskLayerControl) {
        this.f25984d = maskLayerOptions;
        this.f25985e = new GLMaskLayer(this.viewManager, f25982b.get(maskLayerOptions, this.viewManager));
        this.f25983c = new MaskLayer(maskLayerOptions, maskLayerControl);
        this.viewManager.addView((GLOverlayView) this.f25985e);
        return this.f25983c;
    }

    public void setOptions(MaskLayerOptions maskLayerOptions) {
        if (this.f25985e != null) {
            this.f25985e.updateOption(f25982b.get(maskLayerOptions, this.viewManager));
            this.f25984d = maskLayerOptions;
        }
    }

    public MaskLayerOptions getOptions() {
        if (this.f25983c != null) {
            return this.f25984d;
        }
        return null;
    }

    public void removeMaskLayer() {
        if (this.f25985e != null) {
            this.viewManager.removeView(this.f25985e);
            this.f25985e = null;
            this.f25983c = null;
        }
    }

    public void setZIndex(int i) {
        GLMaskLayer gLMaskLayer = this.f25985e;
        if (gLMaskLayer != null) {
            gLMaskLayer.setZIndex(i);
        }
    }

    public int getZIndex() {
        GLMaskLayer gLMaskLayer = this.f25985e;
        if (gLMaskLayer != null) {
            return gLMaskLayer.getZIndex();
        }
        return 0;
    }

    public void setVisible(boolean z) {
        GLMaskLayer gLMaskLayer = this.f25985e;
        if (gLMaskLayer != null) {
            gLMaskLayer.setVisible(z);
        }
    }

    public boolean isVisible() {
        GLMaskLayer gLMaskLayer = this.f25985e;
        return gLMaskLayer != null && gLMaskLayer.isVisible();
    }
}
