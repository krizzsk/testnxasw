package com.didi.common.map.adapter.didiadapter;

import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMaskLayerDelegate;
import com.didi.common.map.model.MaskLayerOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.didi.map.outer.model.MaskLayer;

public class MaskLayerDelegate implements IMaskLayerDelegate {

    /* renamed from: a */
    private MaskLayer f12560a;

    public IMapElementOptions getOptions() {
        return null;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
    }

    public MaskLayerDelegate(MaskLayer maskLayer) {
        if (maskLayer != null) {
            this.f12560a = maskLayer;
        }
    }

    public void setMaskLayerOptions(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer != null) {
            maskLayer.setOptions(Converter.convertToDidiMaskLayerOptions(maskLayerOptions));
        }
    }

    public String getId() throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer == null) {
            return null;
        }
        return maskLayer.getId();
    }

    public void remove() throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer != null) {
            maskLayer.remove();
        }
    }

    public void remove(long j) throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer != null) {
            maskLayer.remove(j);
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer != null) {
            maskLayer.setZIndex(i);
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer == null) {
            return 0;
        }
        return maskLayer.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer != null) {
            maskLayer.setVisible(z);
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer == null) {
            return false;
        }
        return maskLayer.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        MaskLayer maskLayer = this.f12560a;
        if (maskLayer == null) {
            return false;
        }
        return maskLayer.isClickable();
    }

    public void setClickable(boolean z) {
        DLog.m10773d("MaskLayer", "setClickable not support", new Object[0]);
    }

    public Object getElement() {
        return this.f12560a;
    }
}
