package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.HeatDataNode;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import java.util.List;

public class HeatOverlayControl {

    /* renamed from: a */
    private final IHeatOverlayDelegate f26763a;

    public HeatOverlayControl(IHeatOverlayDelegate iHeatOverlayDelegate) {
        this.f26763a = iHeatOverlayDelegate;
    }

    public HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions) {
        return this.f26763a.addHeatOverlay(heatOverlayOptions, this);
    }

    public void updateData(String str, List<HeatDataNode> list) {
        this.f26763a.updateData(str, list);
    }

    public void remove(String str) {
        this.f26763a.remove(str);
    }
}
