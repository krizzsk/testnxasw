package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.MaskLayerControl;

public final class MaskLayer {

    /* renamed from: a */
    private MaskLayerControl f30443a;

    public MaskLayer(MaskLayerOptions maskLayerOptions, MaskLayerControl maskLayerControl) {
        this.f30443a = maskLayerControl;
    }

    public void setOptions(MaskLayerOptions maskLayerOptions) {
        this.f30443a.setOptions(maskLayerOptions);
    }

    public MaskLayerOptions getOptions() {
        return this.f30443a.getOptions();
    }

    public String getId() {
        return this.f30443a.getId();
    }

    public void remove() {
        this.f30443a.removeMaskLayer();
    }

    public void remove(long j) {
        this.f30443a.removeMaskLayer(j);
    }

    public void setZIndex(int i) {
        this.f30443a.setZIndex(i);
    }

    public int getZIndex() {
        return this.f30443a.getZIndex();
    }

    public void setVisible(boolean z) {
        this.f30443a.setVisible(z);
    }

    public boolean isVisible() {
        return this.f30443a.isVisible();
    }

    public boolean isClickable() {
        return this.f30443a.isClickable();
    }
}
